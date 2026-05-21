package com.vmware.vim25.ws;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import com.vmware.vim25.ArrayOfHostRdmaDevice;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.List;
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

    @Test
    public void toXML_serializingArrayOfWithSerialVersionUID_doesNotLogIllegalAccess() {
        // Attach a ListAppender to the XmlGen logger to capture log events during serialization.
        Logger xmlGenLogger = (Logger) LoggerFactory.getLogger("com.vmware.vim25.ws.XmlGen");
        ListAppender<ILoggingEvent> appender = new ListAppender<>();
        appender.start();
        xmlGenLogger.addAppender(appender);
        try {
            ArrayOfHostRdmaDevice payload = new ArrayOfHostRdmaDevice();
            Argument[] args = new Argument[]{new Argument("devices", "ArrayOfHostRdmaDevice", payload)};
            XmlGen.toXML("testMethod", args, " xmlns=\"urn:vim25\"");

            List<ILoggingEvent> events = appender.list;
            for (ILoggingEvent event : events) {
                if (event.getLevel() == Level.ERROR) {
                    Throwable t = event.getThrowableProxy() != null
                            ? (event.getThrowableProxy() instanceof ch.qos.logback.classic.spi.ThrowableProxy
                                ? ((ch.qos.logback.classic.spi.ThrowableProxy) event.getThrowableProxy()).getThrowable()
                                : null)
                            : null;
                    boolean mentionsIllegalAccess = event.getFormattedMessage().contains("IllegalAccessException")
                            || (t instanceof IllegalAccessException);
                    assertFalse(
                            "XmlGen must not log ERROR for IllegalAccessException on serialVersionUID, but got: "
                                    + event.getFormattedMessage(),
                            mentionsIllegalAccess);
                }
            }
        } finally {
            xmlGenLogger.detachAppender(appender);
            appender.stop();
        }
    }

    @Test
    public void toXML_serializedXml_doesNotContainStaticSerialVersionUID() {
        ArrayOfHostRdmaDevice payload = new ArrayOfHostRdmaDevice();
        Argument[] args = new Argument[]{new Argument("devices", "ArrayOfHostRdmaDevice", payload)};
        String xml = XmlGen.toXML("testMethod", args, " xmlns=\"urn:vim25\"");

        assertFalse("Serialized XML must not contain serialVersionUID — static fields must be skipped",
                xml.contains("serialVersionUID"));
    }
}
