package com.vmware.vim25.ws;

import org.junit.Test;

import static org.junit.Assert.*;

public class SoapActionTest {

    @Test
    public void soapActionHeader_toStringIsHeaderName() {
        assertEquals("SOAPAction", SoapAction.SOAP_ACTION_HEADER.toString());
    }

    @Test
    public void apiVersionValues_matchExpectedUrns() {
        assertEquals("urn:vim25/4.0", SoapAction.SOAP_ACTION_V40.toString());
        assertEquals("urn:vim25/4.1", SoapAction.SOAP_ACTION_V41.toString());
        assertEquals("urn:vim25/5.0", SoapAction.SOAP_ACTION_V50.toString());
        assertEquals("urn:vim25/5.1", SoapAction.SOAP_ACTION_V51.toString());
        assertEquals("urn:vim25/5.5", SoapAction.SOAP_ACTION_V55.toString());
        assertEquals("urn:vim25/6.0", SoapAction.SOAP_ACTION_V60.toString());
        assertEquals("urn:vim25/6.5", SoapAction.SOAP_ACTION_V65.toString());
    }

    @Test
    public void equalsName_returnsTrue_whenValueMatches() {
        assertTrue(SoapAction.SOAP_ACTION_V60.equalsName("urn:vim25/6.0"));
    }

    @Test
    public void equalsName_returnsFalse_whenValueDiffers() {
        assertFalse(SoapAction.SOAP_ACTION_V60.equalsName("urn:vim25/5.5"));
    }

    @Test
    public void equalsName_returnsFalse_whenNull() {
        assertFalse(SoapAction.SOAP_ACTION_V60.equalsName(null));
    }

    @Test
    public void allEnumConstants_arePresent() {
        assertEquals(8, SoapAction.values().length);
    }
}
