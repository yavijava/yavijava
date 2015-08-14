package com.vmware.vim25;

import org.junit.Assert;
import org.junit.Test;

public class ManagedObjectReferenceTest {

    @Test
    public void testManagedObjectReferencesAreEqual() {
        ManagedObjectReference mor1 = new ManagedObjectReference();
        mor1.setType("HostSystem");
        mor1.setVal("host-234");

        ManagedObjectReference mor2 = new ManagedObjectReference();
        mor2.setType("HostSystem");
        mor2.setVal("host-234");
        Assert.assertEquals(mor1, mor2);
    }

    @Test
    public void testManagedObjectReferenceToString() {
        ManagedObjectReference mor1 = new ManagedObjectReference();
        mor1.setType("HostSystem");
        mor1.setVal("host-234");
        Assert.assertEquals("HostSystem:host-234", mor1.toString());
    }

    @Test
    public void testManagedObjectNotFoundToString(){
        ManagedObjectReference mor1 = new ManagedObjectReference();
        mor1.setType("HostSystem");
        mor1.setVal("host-234");
        ManagedObjectNotFound managedObjectNotFound = new ManagedObjectNotFound();
        managedObjectNotFound.setObj(mor1);
        Assert.assertEquals("com.vmware.vim25.ManagedObjectNotFound: HostSystem:host-234", managedObjectNotFound.toString());
        managedObjectNotFound.setObj(null);
        Assert.assertEquals("com.vmware.vim25.ManagedObjectNotFound: <null ManagedObjectReference>", managedObjectNotFound.toString());
    }
}
