package com.vmware.vim.cf;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.PropertyCollector;
import org.junit.Test;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ManagedObjectWatcherTest {

    @Test
    public void addListener_registeredListenerIsNotifiedOnUpdate() {
        // PropertyCollector is null — we won't call run(), just test listener wiring
        ManagedObjectWatcher watcher = new ManagedObjectWatcher(null);

        PropertyFilterUpdate[] sentUpdates = new PropertyFilterUpdate[]{new PropertyFilterUpdate()};
        PropertyFilterUpdate[][] received = {null};

        watcher.addListener(updates -> received[0] = updates);
        watcher.notifyListeners(sentUpdates);

        assertSame(sentUpdates, received[0]);
    }

    @Test
    public void addListener_multipleListenersAllReceiveUpdates() {
        ManagedObjectWatcher watcher = new ManagedObjectWatcher(null);

        PropertyFilterUpdate[] sentUpdates = new PropertyFilterUpdate[0];
        int[] callCount = {0};

        watcher.addListener(updates -> callCount[0]++);
        watcher.addListener(updates -> callCount[0]++);
        watcher.notifyListeners(sentUpdates);

        assertEquals(2, callCount[0]);
    }

    @Test
    public void removeListener_removedListenerDoesNotReceiveUpdates() {
        ManagedObjectWatcher watcher = new ManagedObjectWatcher(null);

        int[] callCount = {0};
        PropertyFilterUpdateListener listener = updates -> callCount[0]++;

        watcher.addListener(listener);
        watcher.removeListener(listener);
        watcher.notifyListeners(new PropertyFilterUpdate[0]);

        assertEquals(0, callCount[0]);
    }

    @Test
    public void notifyListeners_withNoListeners_doesNotThrow() {
        ManagedObjectWatcher watcher = new ManagedObjectWatcher(null);
        watcher.notifyListeners(new PropertyFilterUpdate[0]); // should not throw
    }

    // Recorded calls into a stub PropertyCollector.
    static class StubPropertyCollector extends PropertyCollector {
        int waitForUpdatesCalls = 0;
        int waitForUpdatesExCalls = 0;
        final List<String> waitForUpdatesExVersions = new ArrayList<>();
        final List<UpdateSet> updateSetSequence = new ArrayList<>();
        Throwable throwAfterSequence = null;

        StubPropertyCollector() {
            super(null, null);
        }

        @Override
        public UpdateSet waitForUpdates(String version) {
            waitForUpdatesCalls++;
            return null;
        }

        @Override
        public UpdateSet waitForUpdatesEx(String version, WaitOptions options) throws RuntimeFault, RemoteException {
            int idx = waitForUpdatesExCalls;
            waitForUpdatesExCalls++;
            waitForUpdatesExVersions.add(version);
            if (idx < updateSetSequence.size()) {
                return updateSetSequence.get(idx);
            }
            if (throwAfterSequence != null) {
                if (throwAfterSequence instanceof RuntimeException) throw (RuntimeException) throwAfterSequence;
                if (throwAfterSequence instanceof RemoteException) throw (RemoteException) throwAfterSequence;
                throw new RuntimeException(throwAfterSequence);
            }
            // Default: signal end of test by throwing NotAuthenticated which the loop treats as exit.
            throw new NotAuthenticated();
        }
    }

    private UpdateSet updateSetWithVersion(String version, PropertyFilterUpdate... filterSet) {
        UpdateSet us = new UpdateSet();
        us.setVersion(version);
        us.setFilterSet(filterSet);
        return us;
    }

    @Test(timeout = 5000)
    public void run_usesWaitForUpdatesEx_notDeprecatedWaitForUpdates() {
        // Issue #110: deprecated waitForUpdates returns null on vCenter 6+, then update.getFilterSet() NPEs.
        // Watcher must call the supported waitForUpdatesEx instead.
        StubPropertyCollector pc = new StubPropertyCollector();
        // First call returns one UpdateSet, second call throws NotAuthenticated to break the loop.
        pc.updateSetSequence.add(updateSetWithVersion("v1", new PropertyFilterUpdate()));

        ManagedObjectWatcher watcher = new ManagedObjectWatcher(pc);
        watcher.run();

        assertEquals("waitForUpdates (deprecated) must not be called", 0, pc.waitForUpdatesCalls);
        assertTrue("waitForUpdatesEx must be called at least once", pc.waitForUpdatesExCalls >= 1);
    }

    @Test(timeout = 5000)
    public void run_nullUpdateSet_doesNotNPE_advancesPastEmptyResponse() {
        // waitForUpdatesEx legitimately returns null when the wait window expires with no updates.
        // The loop must skip the iteration without dereferencing.
        StubPropertyCollector pc = new StubPropertyCollector();
        pc.updateSetSequence.add(null);
        pc.updateSetSequence.add(updateSetWithVersion("v1", new PropertyFilterUpdate()));

        ManagedObjectWatcher watcher = new ManagedObjectWatcher(pc);
        int[] notifications = {0};
        watcher.addListener(updates -> notifications[0]++);

        watcher.run();

        // First call returned null and was skipped. Second returned a real UpdateSet and notified once.
        // Third call throws NotAuthenticated to exit.
        assertEquals(1, notifications[0]);
        assertEquals(3, pc.waitForUpdatesExCalls);
    }

    @Test(timeout = 5000)
    public void run_validUpdateSet_notifiesListenersAndAdvancesVersion() {
        StubPropertyCollector pc = new StubPropertyCollector();
        PropertyFilterUpdate u1 = new PropertyFilterUpdate();
        PropertyFilterUpdate u2 = new PropertyFilterUpdate();
        pc.updateSetSequence.add(updateSetWithVersion("v1", u1));
        pc.updateSetSequence.add(updateSetWithVersion("v2", u2));

        ManagedObjectWatcher watcher = new ManagedObjectWatcher(pc);
        List<PropertyFilterUpdate[]> received = new ArrayList<>();
        watcher.addListener(received::add);

        watcher.run();

        assertEquals(2, received.size());
        assertSame(u1, received.get(0)[0]);
        assertSame(u2, received.get(1)[0]);
        // Version advances: first call sees "", second sees "v1", third sees "v2".
        assertEquals("", pc.waitForUpdatesExVersions.get(0));
        assertEquals("v1", pc.waitForUpdatesExVersions.get(1));
        assertEquals("v2", pc.waitForUpdatesExVersions.get(2));
    }
}
