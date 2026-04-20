package com.vmware.vim.cf;

import com.vmware.vim25.PropertyFilterUpdate;
import org.junit.Test;

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
}
