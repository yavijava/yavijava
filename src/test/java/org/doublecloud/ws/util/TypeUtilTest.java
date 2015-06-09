package org.doublecloud.ws.util;

/**
 * Created by Michael Rice on 2/12/15.
 * <p/>
 * Copyright 2015 Michael Rice
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.vmware.vim25.mo.VirtualMachine;
import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.*;

public class TypeUtilTest {

	public final static String PACKAGE_NAME = "com.vmware.vim25";

    @Test
    public void testIsPrimitiveType_boolean_is_Primitave() throws Exception {
        assertTrue(TypeUtil.isPrimitiveType("boolean"));
    }

    @Test
    public void testIsPrimitiveType_Boolean_is_not_Primitave() throws Exception {
        assertFalse(TypeUtil.isPrimitiveType("Boolean"));
    }

    @Test
    public void testIsPrimitiveType_null_is_not_Primitave_and_doesnt_throw_exception() {
        assertFalse(TypeUtil.isPrimitiveType(null));
    }

    @Test
    public void testIsPrimitiveType_int_is_Primitave() throws Exception {
        assertTrue(TypeUtil.isPrimitiveType("int"));
    }

    @Test
    public void testIsPrimitiveType_short_is_Primitave() throws Exception {
        assertTrue(TypeUtil.isPrimitiveType("short"));
    }

    @Test
    public void testIsPrimitiveType_float_is_Primitave() throws Exception {
        assertTrue(TypeUtil.isPrimitiveType("float"));
    }

    @Test
    public void testIsPrimitiveType_byte_is_Primitave() throws Exception {
        assertTrue(TypeUtil.isPrimitiveType("byte"));
    }

    @Test
    public void testIsPrimitiveType_long_is_Primitave() throws Exception {
        assertTrue(TypeUtil.isPrimitiveType("long"));
    }

    @Test
    public void testIsPrimitiveType_double_is_Primitave() throws Exception {
        assertTrue(TypeUtil.isPrimitiveType("double"));
    }

    @Test
    public void testIsPrimitiveType_empty_string_is_not_Primitave_and_doesnt_throw_exception() throws Exception {
        assertFalse(TypeUtil.isPrimitiveType(""));
    }

    @Test
    public void testIsBasicType_String_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType("String"));
    }

    @Test
    public void testIsBasicType_String_class_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType(String.class));
    }

    @Test
    public void testIsBasicType_int_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType("int"));
    }

    @Test
    public void testIsBasicType_int_class_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType(int.class));
    }

    @Test
    public void testIsBasicType_short_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType("short"));
    }

    @Test
    public void testIsBasicType_short_class_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType(short.class));
    }

    @Test
    public void testIsBasicType_long_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType("long"));
    }

    @Test
    public void testIsBasicType_long_class_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType(long.class));
    }

    @Test
    public void testIsBasicType_float_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType("float"));
    }

    @Test
    public void testIsBasicType_float_class_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType(float.class));
    }

    @Test
    public void testIsBasicType_Float_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType("Float"));
    }

    @Test
    public void testIsBasicType_byte_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType("byte"));
    }

    @Test
    public void testIsBasicType_byte__class_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType(byte.class));
    }

    @Test
    public void testIsBasicType_boolean_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType("boolean"));
    }

    @Test
    public void testIsBasicType_boolean_class_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType(boolean.class));
    }

    @Test
    public void testIsBasicType_Boolean_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType("Boolean"));
    }

    @Test
    public void testIsBasicType_Boolean_class_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType(Boolean.class));
    }

    @Test
    public void testIsBasicType_Calendar_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType("Calendar"));
    }

    @Test
    public void testIsBasicType_Calendar_class_is_basic() throws Exception {
        assertTrue(TypeUtil.isBasicType(Calendar.class));
    }

    @Test
    public void testGetVimClass_VirtualMachine_is_VirtualMachine() throws Exception {
        Class<?> vm = TypeUtil.getVimClass(PACKAGE_NAME, "mo.VirtualMachine");
        assertEquals(VirtualMachine.class.getName(), vm.getName());
    }

    @Test
    public void testGetVimClass_VirtualMachine_wrong_package_is_null() throws Exception {
        Class<?> vm = TypeUtil.getVimClass(PACKAGE_NAME, "VirtualMachine");
        assertEquals(null, vm);
    }

    @Test
    public void testGetVimClass_VirtualMachine_array_returns_Array() throws Exception {
        Class<?> vm = TypeUtil.getVimClass(PACKAGE_NAME, "mo.VirtualMachine[]");
        assertTrue(vm.isArray());
    }

    @Test
    public void testGetXSIType_Integer_gives_xsd_int() throws Exception {
        String actual = TypeUtil.getXSIType(1);
        assertEquals("xsd:int", actual);
    }

    @Test
    public void testGetXSIType_String_gives_xsd_string() throws Exception {
        String actual = TypeUtil.getXSIType("string");
        assertEquals("xsd:string", actual);
    }

    @Test
    public void testGetXSIType_long_gives_xsd_long() throws Exception {
        String actual = TypeUtil.getXSIType(10l);
        assertEquals("xsd:long", actual);
    }

    @Test
    public void testGetXSIType_float_gives_xsd_float() throws Exception {
        String actual = TypeUtil.getXSIType(1.2f);
        assertEquals("xsd:float", actual);
    }

    @Test
    public void testGetXSIType_double_gives_xsd_double() throws Exception {
        String actual = TypeUtil.getXSIType(1.0);
        assertEquals("xsd:double", actual);
    }

    @Test
    public void testGetXSIType_boolean_gives_xsd_boolean() throws Exception {
        String actual = TypeUtil.getXSIType(true);
        assertEquals("xsd:boolean", actual);
    }

    @Test
    public void testGetXSIType_short_gives_xsd_short() throws Exception {
        Short s = 10;
        String actual = TypeUtil.getXSIType(s);
        assertEquals("xsd:short", actual);
    }

    @Test
    public void testGetXSIType_byte_gives_xsd_byte() throws Exception {
        byte b = Byte.parseByte("1");
        String actual = TypeUtil.getXSIType(b);
        assertEquals("xsd:byte", actual);
    }

    @Test(expected = RuntimeException.class)
    public void testGetXSIType_Custom_Object_gives_RuntimeException() throws Exception {
        class foo {}
        String actual = TypeUtil.getXSIType(foo.class);
    }

    @Test(expected = NullPointerException.class)
    public void testGetXSIType_null_gives_NPE() throws Exception {
        String actual = TypeUtil.getXSIType(null);
    }
}