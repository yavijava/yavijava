package com.vmware.vim25.ws;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArgumentTest {

    @Test
    public void constructor_setsAllFields() {
        Argument arg = new Argument("_this", "ManagedObjectReference", "domain-c7");
        assertEquals("_this", arg.getName());
        assertEquals("ManagedObjectReference", arg.getType());
        assertEquals("domain-c7", arg.getValue());
    }

    @Test
    public void constructor_allowsNullValue() {
        Argument arg = new Argument("spec", "TaskFilterSpec", null);
        assertNull(arg.getValue());
    }

    @Test
    public void setName_updatesName() {
        Argument arg = new Argument("old", "String", "v");
        arg.setName("new");
        assertEquals("new", arg.getName());
    }

    @Test
    public void setType_updatesType() {
        Argument arg = new Argument("n", "OldType", "v");
        arg.setType("NewType");
        assertEquals("NewType", arg.getType());
    }

    @Test
    public void setValue_updatesValue() {
        Argument arg = new Argument("n", "t", "original");
        arg.setValue("updated");
        assertEquals("updated", arg.getValue());
    }

    @Test
    public void setValue_acceptsArbitraryObjectType() {
        Object obj = new Object();
        Argument arg = new Argument("n", "t", null);
        arg.setValue(obj);
        assertSame(obj, arg.getValue());
    }
}
