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

}
