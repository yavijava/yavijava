package org.doublecloud.ws.util;

import com.vmware.vim25.AboutInfo;
import org.doublecloud.ws.util.testUtils.*;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public void testToByteArray() throws Exception {
        List<String> values = new ArrayList<String>();
        char[] chars = "ox991LwhCGLf2gntXqKkSPdqC+A=".toCharArray();
        for (char c: chars) {
            values.add(Character.toString(c));
        }
        byte[] actual = ReflectUtil.toByteArray(values);
        byte[] expected = javax.xml.bind.DatatypeConverter.parseBase64Binary("ox991LwhCGLf2gntXqKkSPdqC+A=");
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testReflectUtil_ParseToObject_Returns_String_Array() throws Exception {
        String type = "String[]";
        List<String> strings = new ArrayList<String>();
        strings.add("string1");
        strings.add("string2");
        strings.add("string3");
        String[] stringArray = (String[]) ReflectUtil.parseToObject(type, strings);
        assert stringArray.getClass().isArray();
    }
}
