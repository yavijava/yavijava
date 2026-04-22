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
}
