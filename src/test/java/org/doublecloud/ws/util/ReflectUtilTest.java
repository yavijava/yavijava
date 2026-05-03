package org.doublecloud.ws.util;

import com.vmware.vim25.PropertyChange;
import com.vmware.vim25.StoragePerformanceSummary;
import org.doublecloud.ws.util.testUtils.*;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
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
    public void testToByteArray_decodesBase64EncodedCharList() throws Exception {
        String base64 = "ox991LwhCGLf2gntXqKkSPdqC+A=";
        List<String> values = new ArrayList<>();
        for (char c : base64.toCharArray()) {
            values.add(Character.toString(c));
        }
        byte[] actual = ReflectUtil.toByteArray(values);
        byte[] expected = Base64.getDecoder().decode(base64);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testToByteArray_decodesBase64SplitIntoMultiCharChunks() throws Exception {
        // Realistic scenario: base64 payload arrives as multi-character chunks across
        // several XML text nodes rather than one character per element.
        String base64 = "ox991LwhCGLf2gntXqKkSPdqC+A=";
        List<String> values = Arrays.asList(
            base64.substring(0, 8),
            base64.substring(8, 16),
            base64.substring(16)
        );
        byte[] actual = ReflectUtil.toByteArray(values);
        byte[] expected = Base64.getDecoder().decode(base64);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testReflectUtil_ParseToObject_Returns_String_Array() throws Exception {
        List<String> strings = Arrays.asList("string1", "string2", "string3");
        String[] stringArray = (String[]) ReflectUtil.parseToObject("String[]", strings);
        assertTrue(stringArray.getClass().isArray());
    }

    @Test
    public void testReflectUtil_SetObjectField_Supports_Base64Binary_To_ByteArray() throws Exception {
        Object obj = new PropertyChange();
        Field field = PropertyChange.class.getField("val");
        ReflectUtil.setObjectField(obj, field, "base64Binary", "EtUGWJdr2BYg3Dom7G6oPAlHHcc=");
        assertTrue(((PropertyChange) obj).getVal() instanceof byte[]);
    }

    @Test
    public void testReflectUtil_SetObjectField_Supports_DateTime_To_Calendar() throws Exception {
        Object obj = new PropertyChange();
        Field field = PropertyChange.class.getField("val");
        ReflectUtil.setObjectField(obj, field, "dateTime", "2015-06-19T10:00:00.000-05:00");
        assertTrue(((PropertyChange) obj).getVal() instanceof Calendar);
    }

    @Test
    public void testReflectUtil_SetObjectField_DateTime_Preserves_TimeInMillis() throws Exception {
        Object obj = new PropertyChange();
        Field field = PropertyChange.class.getField("val");
        ReflectUtil.setObjectField(obj, field, "dateTime", "2015-06-19T10:00:00.000-05:00");
        Calendar cal = (Calendar) ((PropertyChange) obj).getVal();
        // 2015-06-19T10:00:00-05:00 == 2015-06-19T15:00:00Z
        Calendar expected = Calendar.getInstance(java.util.TimeZone.getTimeZone("UTC"));
        expected.set(2015, Calendar.JUNE, 19, 15, 0, 0);
        expected.set(Calendar.MILLISECOND, 0);
        assertEquals(expected.getTimeInMillis(), cal.getTimeInMillis());
    }

    @Test
    public void testReflectUtil_ParseToObject_Returns_Calendar_For_Calendar_Type() throws Exception {
        Object result = ReflectUtil.parseToObject("Calendar", Arrays.asList("2015-06-19T10:00:00.000-05:00"));
        assertTrue(result instanceof Calendar);
    }

    @Test
    public void testReflectUtil_ParseToObject_Returns_Calendar_For_dateTime_Alias() throws Exception {
        Object result = ReflectUtil.parseToObject("dateTime", Arrays.asList("2015-06-19T10:00:00.000-05:00"));
        assertTrue(result instanceof Calendar);
    }

    @Test
    public void testReflectUtil_SetObjectArrayField_Supports_Double_Array() throws Exception {
        // StoragePerformanceSummary has double[] fields (e.g. datastoreReadLatency).
        // Prior to the fix, setObjectArrayField threw RuntimeException for double[].
        StoragePerformanceSummary summary = new StoragePerformanceSummary();
        Field field = StoragePerformanceSummary.class.getField("datastoreReadLatency");
        List<String> values = Arrays.asList("0.5", "1.0", "1.5");
        ReflectUtil.setObjectArrayField(summary, field, "double[]", values);
        assertNotNull(summary.getDatastoreReadLatency());
        assertEquals(3, summary.getDatastoreReadLatency().length);
        assertEquals(0.5, summary.getDatastoreReadLatency()[0], 0.0001);
    }
}
