package com.vmware.vim.cf;

import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectUpdate;
import com.vmware.vim25.PropertyChange;
import com.vmware.vim25.PropertyFilterUpdate;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;

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
