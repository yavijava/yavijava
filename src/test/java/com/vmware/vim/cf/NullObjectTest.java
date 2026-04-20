package com.vmware.vim.cf;

import org.junit.Test;

import static org.junit.Assert.*;

public class NullObjectTest {

    @Test
    public void NULL_isNotJavaNull() {
        assertNotNull(NullObject.NULL);
    }

    @Test
    public void NULL_isInstanceOfNullObject() {
        assertTrue(NullObject.NULL instanceof NullObject);
    }

    @Test
    public void NULL_isSingleton() {
        assertSame(NullObject.NULL, NullObject.NULL);
    }

    @Test
    public void toString_returnsLiteralNullString() {
        assertEquals("null", NullObject.NULL.toString());
    }
}
