package org.doublecloud.ws.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class XmlUtilTest {

    @Test
    public void testEscapeForXML() throws Exception {
        String toBeEscaped = "&, <, >, \", '";
        String expected = "&amp;, &lt;, &gt;, &quot;, &apos;";
        String actual = XmlUtil.escapeForXML(toBeEscaped);
        assertEquals(expected, actual);
    }
}