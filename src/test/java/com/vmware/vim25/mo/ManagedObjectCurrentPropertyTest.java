package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagedObjectCurrentPropertyTest {

    // Subclass that bypasses the server call so we can inject any ObjectContent
    static class TestManagedObject extends ManagedObject {
        private final ObjectContent content;

        TestManagedObject(ObjectContent content) {
            this.content = content;
        }

        @Override
        protected ObjectContent retrieveObjectProperties(String[] properties) {
            return content;
        }

        public Object testGetCurrentProperty(String name) {
            return getCurrentProperty(name);
        }
    }

    @Test
    public void getCurrentProperty_returnsNullWhenObjectContentIsNull() {
        TestManagedObject mo = new TestManagedObject(null);
        assertNull(mo.testGetCurrentProperty("name"));
    }

    @Test
    public void getCurrentProperty_returnsNullWhenPropSetIsNull() {
        TestManagedObject mo = new TestManagedObject(new ObjectContent());
        assertNull(mo.testGetCurrentProperty("name"));
    }

    // Reproduces github.com/yavijava/yavijava/issues/360 — PropertyCollector returns a
    // DynamicProperty whose val is null (e.g. when XmlGenDom can't resolve an ArrayOf*
    // xsi:type and leaves the field unset). getCurrentProperty should return null for
    // a present-but-null property, matching the long-standing contract that optional
    // managed-object properties yield null when unset.
    @Test
    public void getCurrentProperty_returnsNullWhenDynamicPropertyValIsNull() {
        DynamicProperty dp = new DynamicProperty();
        dp.setName("customValue");
        dp.setVal(null);

        ObjectContent objContent = new ObjectContent();
        objContent.setPropSet(new DynamicProperty[]{dp});

        TestManagedObject mo = new TestManagedObject(objContent);

        assertNull(mo.testGetCurrentProperty("customValue"));
    }

    @Test
    public void getCurrentProperty_throwsWhenMissingSetContainsFault() {
        MissingProperty missing = new MissingProperty();
        missing.setPath("host");
        LocalizedMethodFault lmf = new LocalizedMethodFault();
        lmf.setFault(new NotAuthenticated());
        missing.setFault(lmf);

        ObjectContent objContent = new ObjectContent();
        objContent.setMissingSet(new MissingProperty[]{missing});

        TestManagedObject mo = new TestManagedObject(objContent);

        try {
            mo.testGetCurrentProperty("host");
            fail("Expected RuntimeException wrapping the server fault");
        } catch (RuntimeException e) {
            assertTrue("cause should be the MethodFault from missingSet",
                e.getCause() instanceof NotAuthenticated);
        }
    }

    @Test
    public void getCurrentProperty_throwsWithFaultMessageWhenMissingSetHasLocalizedMessage() {
        MissingProperty missing = new MissingProperty();
        missing.setPath("config");
        LocalizedMethodFault lmf = new LocalizedMethodFault();
        lmf.setFault(new NotAuthenticated());
        lmf.setLocalizedMessage("Not authenticated");
        missing.setFault(lmf);

        ObjectContent objContent = new ObjectContent();
        objContent.setMissingSet(new MissingProperty[]{missing});

        TestManagedObject mo = new TestManagedObject(objContent);

        try {
            mo.testGetCurrentProperty("config");
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertNotNull(e.getCause());
        }
    }

    // Subclass that fails loudly if retrieveObjectProperties is called — proves the cache short-circuits the server call.
    static class CacheOnlyManagedObject extends ManagedObject {
        @Override
        protected ObjectContent retrieveObjectProperties(String[] properties) {
            throw new AssertionError("retrieveObjectProperties called for "
                + (properties != null && properties.length > 0 ? properties[0] : "?")
                + " — cache should have served this read");
        }
        public Object testGetCurrentProperty(String name) {
            return getCurrentProperty(name);
        }
    }

    @Test
    public void getCurrentProperty_returnsCachedValue_withoutServerCall() {
        CacheOnlyManagedObject mo = new CacheOnlyManagedObject();
        mo.setCachedProperty("name", "test-vm");
        mo.setCachedProperty("overallStatus", "green");

        assertEquals("test-vm", mo.testGetCurrentProperty("name"));
        assertEquals("green", mo.testGetCurrentProperty("overallStatus"));
    }

    @Test
    public void getCurrentProperty_cachedNullValue_returnsNullWithoutServerCall() {
        CacheOnlyManagedObject mo = new CacheOnlyManagedObject();
        mo.setCachedProperty("network", null);  // server may legitimately return null for a property

        assertNull(mo.testGetCurrentProperty("network"));
    }

    @Test
    public void getCurrentProperty_runtimeExceptionMessageIsLocalizedMessageFromFault() {
        MissingProperty missing = new MissingProperty();
        missing.setPath("config");
        LocalizedMethodFault lmf = new LocalizedMethodFault();
        lmf.setFault(new com.vmware.vim25.NoPermission());
        lmf.setLocalizedMessage("Permission to perform this operation was denied.");
        missing.setFault(lmf);

        ObjectContent objContent = new ObjectContent();
        objContent.setMissingSet(new MissingProperty[]{missing});

        TestManagedObject mo = new TestManagedObject(objContent);

        try {
            mo.testGetCurrentProperty("config");
            fail("Expected RuntimeException");
        } catch (RuntimeException e) {
            assertEquals(
                "Exception message should be the localized message from the server fault",
                "Permission to perform this operation was denied.",
                e.getMessage());
            assertTrue(
                "Cause should be the MethodFault so callers can inspect type",
                e.getCause() instanceof com.vmware.vim25.NoPermission);
        }
    }
}
