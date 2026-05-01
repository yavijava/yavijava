package com.vmware.vim.cf;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.PropertyCollector;
import com.vmware.vim25.mo.ServerConnection;
import com.vmware.vim25.mo.ServiceInstance;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

public class CacheInstanceTest {

    private ManagedObjectCache cache;
    private CacheInstance cacheInstance;

    @Before
    public void setUp() {
        cache = new ManagedObjectCache(null);
        cacheInstance = new CacheInstance(cache);
    }

    @Test
    public void getCopyByMor_returnsValueFromCache() {
        ManagedObjectReference mor = mor("VirtualMachine", "vm-1");
        cache.onUpdate(updates(objectUpdate(mor, propertyChange("name", "my-vm"))));

        Object result = cacheInstance.getCopy(mor, "name");

        assertEquals("my-vm", result);
    }

    @Test
    public void getCopyByMor_returnsDifferentInstance() {
        ManagedObjectReference mor = mor("VirtualMachine", "vm-1");
        Calendar original = Calendar.getInstance();
        original.setTimeInMillis(1_000_000_000L);
        cache.onUpdate(updates(objectUpdate(mor, propertyChange("startTime", original))));

        Object result = cacheInstance.getCopy(mor, "startTime");

        assertNotSame(original, result);
        assertEquals(original.getTimeInMillis(), ((Calendar) result).getTimeInMillis());
    }

    @Test
    public void getCopyByMor_missingKey_returnsNull() {
        ManagedObjectReference mor = mor("VirtualMachine", "vm-1");
        cache.onUpdate(updates(objectUpdate(mor, propertyChange("name", "my-vm"))));

        assertNull(cacheInstance.getCopy(mor, "nonexistent"));
    }

    @Test
    public void getCopyByMor_unknownMor_returnsNull() {
        ManagedObjectReference mor = mor("VirtualMachine", "vm-missing");

        assertNull(cacheInstance.getCopy(mor, "name"));
    }

    @Test
    public void getByMor_returnsValueFromCache() {
        ManagedObjectReference mor = mor("VirtualMachine", "vm-1");
        cache.onUpdate(updates(objectUpdate(mor, propertyChange("powerState", "poweredOn"))));

        assertEquals("poweredOn", cacheInstance.get(mor, "powerState"));
    }

    @Test
    public void getByMor_unknownMor_returnsNull() {
        assertNull(cacheInstance.get(mor("VirtualMachine", "vm-missing"), "name"));
    }

    @Test(timeout = 5000)
    public void awaitReady_returnsTrueWhenCacheBecomesReady() throws InterruptedException {
        // Mirrors the start()/get() race window: caller awaits readiness rather than spin-checking isReady().
        Thread updater = new Thread(() -> {
            try { Thread.sleep(50); } catch (InterruptedException ignored) {}
            cache.onUpdate(updates(objectUpdate(mor("VirtualMachine", "vm-1"),
                propertyChange("name", "ready"))));
        });
        updater.start();

        boolean ready = cacheInstance.awaitReady(2000);

        assertTrue("awaitReady should return true once onUpdate fires", ready);
        updater.join();
    }

    @Test(timeout = 5000)
    public void awaitReady_returnsFalseOnTimeout() throws InterruptedException {
        boolean ready = cacheInstance.awaitReady(100);

        assertFalse("awaitReady should return false when no update arrives in time", ready);
    }

    @Test(timeout = 5000)
    public void awaitReady_returnsImmediatelyIfAlreadyReady() throws InterruptedException {
        cache.onUpdate(updates(objectUpdate(mor("VirtualMachine", "vm-1"),
            propertyChange("name", "already-here"))));

        long start = System.nanoTime();
        boolean ready = cacheInstance.awaitReady(60_000);
        long elapsedMs = (System.nanoTime() - start) / 1_000_000L;

        assertTrue(ready);
        assertTrue("awaitReady should return without blocking when cache is already ready (took " + elapsedMs + "ms)",
            elapsedMs < 500);
    }

    // --- destroy() lifecycle ---

    static class StubPropertyCollector extends PropertyCollector {
        final CountDownLatch waitEntered = new CountDownLatch(1);
        final AtomicInteger cancelCalls = new AtomicInteger();
        volatile boolean cancelled = false;

        StubPropertyCollector() { super(null, null); }

        @Override
        public UpdateSet waitForUpdatesEx(String version, WaitOptions options) throws RuntimeFault {
            waitEntered.countDown();
            // Block until cancelWaitForUpdates flips us. Mirrors a long-poll vCenter call.
            while (!cancelled) {
                try { Thread.sleep(20); } catch (InterruptedException ie) { Thread.currentThread().interrupt(); break; }
            }
            // After cancellation, signal end of session so the watcher loop exits cleanly.
            throw new NotAuthenticated();
        }

        @Override
        public void cancelWaitForUpdates() {
            cancelCalls.incrementAndGet();
            cancelled = true;
        }
    }

    static class StubServiceInstance extends ServiceInstance {
        private final PropertyCollector pc;
        StubServiceInstance(PropertyCollector pc) {
            super(new ServerConnection(null, null, null));
            this.pc = pc;
        }
        @Override public PropertyCollector getPropertyCollector() { return pc; }
    }

    @Test(timeout = 5000)
    public void destroy_isIdempotent_secondCallIsNoOp() {
        CacheInstance ci = new CacheInstance(new StubServiceInstance(new StubPropertyCollector()));
        ci.start();
        ci.destroy();
        ci.destroy(); // must not throw NPE on the now-nulled fields
    }

    @Test(timeout = 5000)
    public void destroy_neverStarted_doesNotNPE() {
        // User created cache + watch()'d, but never called start(). destroy() should still tear down cleanly.
        CacheInstance ci = new CacheInstance(new StubServiceInstance(new StubPropertyCollector()));
        ci.destroy(); // no start() means mThread == null; must be handled
    }

    @Test(timeout = 5000)
    public void destroy_cancelsInFlightWaitForUpdates_andJoinsThread() throws InterruptedException {
        // Issue #110 follow-up: destroy() must break the watcher's blocking waitForUpdatesEx so the
        // thread exits promptly instead of hanging until vCenter times the long-poll out (or until the
        // user belatedly calls serviceInstance.disconnect() — yashu2203's NotAuthenticated workaround).
        StubPropertyCollector pc = new StubPropertyCollector();
        CacheInstance ci = new CacheInstance(new StubServiceInstance(pc));
        ci.start();

        // Wait for the watcher to actually be parked inside waitForUpdatesEx.
        assertTrue("watcher should be inside waitForUpdatesEx", pc.waitEntered.await(2, TimeUnit.SECONDS));

        ci.destroy();

        assertEquals("destroy() must call cancelWaitForUpdates exactly once", 1, pc.cancelCalls.get());
    }

    // --- helpers (mirrors ManagedObjectCacheTest) ---

    private static ManagedObjectReference mor(String type, String val) {
        ManagedObjectReference mor = new ManagedObjectReference();
        mor.setType(type);
        mor.setVal(val);
        return mor;
    }

    private static PropertyChange propertyChange(String name, Object val) {
        PropertyChange pc = new PropertyChange();
        pc.setName(name);
        pc.setVal(val);
        return pc;
    }

    private static ObjectUpdate objectUpdate(ManagedObjectReference mor, PropertyChange... changes) {
        ObjectUpdate ou = new ObjectUpdate();
        ou.setObj(mor);
        ou.setChangeSet(changes);
        return ou;
    }

    private static PropertyFilterUpdate[] updates(ObjectUpdate... objectUpdates) {
        PropertyFilterUpdate pfu = new PropertyFilterUpdate();
        pfu.setObjectSet(objectUpdates);
        return new PropertyFilterUpdate[]{pfu};
    }
}
