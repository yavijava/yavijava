package com.vmware.vim25.ws;

import org.junit.Test;

import java.util.Calendar;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class XmlGenTest {

    @Test
    public void toXML_serializes_Calendar_as_xsd_dateTime() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal.set(2015, Calendar.JUNE, 19, 15, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Argument[] args = new Argument[]{new Argument("timestamp", "dateTime", cal)};
        String xml = XmlGen.toXML("testMethod", args, " xmlns=\"urn:vim25\"");

        assertTrue("XML should contain xsd:dateTime type", xml.contains("xsi:type=\"xsd:dateTime\""));
        assertTrue("XML should contain timestamp tag", xml.contains("<timestamp"));
        assertTrue("XML should contain closing timestamp tag", xml.contains("</timestamp>"));
    }

    @Test
    public void toXML_serializes_Calendar_value_in_ISO8601_format() {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal.set(2015, Calendar.JUNE, 19, 15, 0, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Argument[] args = new Argument[]{new Argument("timestamp", "dateTime", cal)};
        String xml = XmlGen.toXML("testMethod", args, " xmlns=\"urn:vim25\"");

        // The serialized value must contain the date — format varies by impl but year/month/day must be present
        assertTrue("XML should contain the date 2015-06-19", xml.contains("2015-06-19"));
    }
}
