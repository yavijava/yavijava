package com.vmware.vim.cf;

import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectUpdate;
import com.vmware.vim25.PropertyChange;
import com.vmware.vim25.PropertyFilterUpdate;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagedObjectCacheTest {

    @Test
    public void isNotReadyBeforeAnyUpdate() {
        ManagedObjectCache cache = new ManagedObjectCache(null);
        assertFalse(cache.isReady());
    }

    @Test
    public void isReadyAfterEmptyUpdate() {
        ManagedObjectCache cache = new ManagedObjectCache(null);
        cache.onUpdate(new PropertyFilterUpdate[0]);
        assertTrue(cache.isReady());
    }

    @Test
    public void onUpdate_storesNewPropertyInCache() {
        ManagedObjectCache cache = new ManagedObjectCache(null);

        ManagedObjectReference mor = mor("VirtualMachine", "vm-123");
        PropertyChange pc = propertyChange("name", "my-vm");
        cache.onUpdate(updates(objectUpdate(mor, pc)));

        assertEquals("my-vm", cache.getCachedItems().get(mor).get("name"));
    }

    @Test
    public void onUpdate_updatesExistingPropertyInCache() {
        ManagedObjectCache cache = new ManagedObjectCache(null);

        ManagedObjectReference mor = mor("VirtualMachine", "vm-123");
        cache.onUpdate(updates(objectUpdate(mor, propertyChange("name", "original"))));
        cache.onUpdate(updates(objectUpdate(mor, propertyChange("name", "updated"))));

        assertEquals("updated", cache.getCachedItems().get(mor).get("name"));
    }

    @Test
    public void onUpdate_storesNullValueAsNullObject() {
        ManagedObjectCache cache = new ManagedObjectCache(null);

        ManagedObjectReference mor = mor("VirtualMachine", "vm-123");
        cache.onUpdate(updates(objectUpdate(mor, propertyChange("name", null))));

        assertSame(NullObject.NULL, cache.getCachedItems().get(mor).get("name"));
    }

    @Test
    public void onUpdate_handlesNullChangeset_doesNotThrow() {
        ManagedObjectCache cache = new ManagedObjectCache(null);

        ManagedObjectReference mor = mor("VirtualMachine", "vm-123");
        ObjectUpdate ou = new ObjectUpdate();
        ou.setObj(mor);
        ou.setChangeSet(null);

        PropertyFilterUpdate pfu = new PropertyFilterUpdate();
        pfu.setObjectSet(new ObjectUpdate[]{ou});

        cache.onUpdate(new PropertyFilterUpdate[]{pfu});
        assertTrue(cache.isReady());
    }

    @Test
    public void onUpdate_handlesNullObjectSet_doesNotThrow() {
        ManagedObjectCache cache = new ManagedObjectCache(null);
        PropertyFilterUpdate pfu = new PropertyFilterUpdate();
        pfu.setObjectSet(null);
        cache.onUpdate(new PropertyFilterUpdate[]{pfu});
        assertTrue(cache.isReady());
    }

    @Test
    public void onUpdate_storesMultiplePropertiesForSameMor() {
        ManagedObjectCache cache = new ManagedObjectCache(null);

        ManagedObjectReference mor = mor("VirtualMachine", "vm-123");
        cache.onUpdate(updates(objectUpdate(mor,
                propertyChange("name", "my-vm"),
                propertyChange("powerState", "poweredOn"))));

        assertEquals("my-vm", cache.getCachedItems().get(mor).get("name"));
        assertEquals("poweredOn", cache.getCachedItems().get(mor).get("powerState"));
    }

    // --- helpers ---

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
