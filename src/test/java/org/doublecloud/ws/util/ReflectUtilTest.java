package org.doublecloud.ws.util;

import com.vmware.vim25.AboutInfo;
import org.doublecloud.ws.util.testUtils.*;
import org.junit.Test;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class ReflectUtilTest {

    @Test
    public void test_GetAllFields_Returns_All_Fields_From_Single_Class() throws Exception {
        Field[] fields = ReflectUtil.getAllFields(ReflectUtilSingleObjWith2Fields1Method.class);
        assertEquals(2, fields.length);
    }

    @Test
    public void test_GetAllFields_Returns_All_Fields_With_Superclass() throws Exception {
        Field[] fields = ReflectUtil.getAllFields(ReflectUtilExtendsSuper4Fields.class);
        assertEquals(4, fields.length);
    }

    @Test
    public void test_GetAllFields_Returns_All_Fields_With_AbstractClass() throws Exception {
        Field[] fields = ReflectUtil.getAllFields(ReflectUtilExtendsAbs1With2Fields.class);
        assertEquals(2, fields.length);
    }

    @Test
    public void test_GetAllFields_Returns_All_Fields_With_Interface() throws Exception {
        Field[] fields = ReflectUtil.getAllFields(ReflectUtilImplementsSimpleWith4Fields.class);
        assertEquals(4, fields.length);
    }

    @Test
    public void testSetObjectArrayField() throws Exception {

    }

    @Test
    public void testParseToObject() throws Exception {

    }
}