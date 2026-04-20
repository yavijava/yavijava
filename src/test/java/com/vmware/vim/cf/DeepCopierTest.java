package com.vmware.vim.cf;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class DeepCopierTest {

    // Test fixture: mutable class with public fields and no-arg constructor
    public static class SimpleBean {
        public String name;
        public SimpleBean() {}
    }

    public static class BeanWithArray {
        public SimpleBean[] items;
        public BeanWithArray() {}
    }

    @Test
    public void deepCopy_finalClass_returnsSameReference() throws Exception {
        String original = "immutable";
        assertSame(original, DeepCopier.deepCopy(original));
    }

    @Test
    public void deepCopy_integer_returnsSameReference() throws Exception {
        Integer original = 42;
        assertSame(original, DeepCopier.deepCopy(original));
    }

    @Test
    public void deepCopy_calendar_producesNewInstanceWithSameTimeMillis() throws Exception {
        Calendar original = Calendar.getInstance();
        original.setTimeInMillis(1_000_000_000L);

        Calendar copy = (Calendar) DeepCopier.deepCopy(original);

        assertNotSame(original, copy);
        assertEquals(original.getTimeInMillis(), copy.getTimeInMillis());
    }

    @Test
    public void deepCopy_mutableBean_producesNewInstance() throws Exception {
        SimpleBean original = new SimpleBean();
        original.name = "test";

        SimpleBean copy = (SimpleBean) DeepCopier.deepCopy(original);

        assertNotSame(original, copy);
        assertEquals("test", copy.name);
    }

    @Test
    public void deepCopy_mutableBean_withNullField_doesNotThrow() throws Exception {
        SimpleBean original = new SimpleBean();
        original.name = null;

        SimpleBean copy = (SimpleBean) DeepCopier.deepCopy(original);

        assertNotSame(original, copy);
        assertNull(copy.name);
    }

    @Test
    public void deepCopy_beanWithArray_copiesArrayItems() throws Exception {
        SimpleBean item = new SimpleBean();
        item.name = "item1";
        BeanWithArray original = new BeanWithArray();
        original.items = new SimpleBean[]{item};

        BeanWithArray copy = (BeanWithArray) DeepCopier.deepCopy(original);

        assertNotSame(original, copy);
        assertNotSame(original.items, copy.items);
        assertEquals(1, copy.items.length);
        assertEquals("item1", copy.items[0].name);
    }
}
