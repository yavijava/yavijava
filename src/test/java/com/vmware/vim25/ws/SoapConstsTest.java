package com.vmware.vim25.ws;

import org.junit.Test;

import static org.junit.Assert.*;

public class SoapConstsTest {

    @Test
    public void xsiNamespaceUri_isW3cXmlSchemaInstance() {
        assertEquals("http://www.w3.org/2001/XMLSchema-instance", SoapConsts.XSI_NAMESPACE_URI);
    }

    @Test
    public void xsiNamespace_hasXsiPrefixAndCorrectUri() {
        assertEquals("xsi", SoapConsts.XSI.getPrefix());
        assertEquals("http://www.w3.org/2001/XMLSchema-instance", SoapConsts.XSI.getURI());
    }

    @Test
    public void xsiType_localNameIsType() {
        assertEquals("type", SoapConsts.XSI_TYPE.getName());
    }

    @Test
    public void xsiType_namespaceMatchesXsiNamespace() {
        assertEquals(SoapConsts.XSI, SoapConsts.XSI_TYPE.getNamespace());
    }

    @Test
    public void soapHeader_startsWithXmlDeclaration() {
        assertTrue(SoapConsts.SOAP_HEADER.startsWith("<?xml version=\"1.0\" encoding=\"UTF-8\"?>"));
    }

    @Test
    public void soapHeader_containsSoapEnvelopeElement() {
        assertTrue(SoapConsts.SOAP_HEADER.contains("<soapenv:Envelope"));
        assertTrue(SoapConsts.SOAP_HEADER.contains("xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\""));
    }

    @Test
    public void soapHeader_opensBodyElement() {
        assertTrue(SoapConsts.SOAP_HEADER.endsWith("<soapenv:Body>"));
    }

    @Test
    public void soapEnd_closesBodyAndEnvelope() {
        assertEquals("</soapenv:Body></soapenv:Envelope>", SoapConsts.SOAP_END);
    }

    @Test
    public void headerAndEnd_formBalancedEnvelope() {
        String envelope = SoapConsts.SOAP_HEADER + SoapConsts.SOAP_END;
        assertTrue(envelope.contains("<soapenv:Body>"));
        assertTrue(envelope.contains("</soapenv:Body>"));
        assertTrue(envelope.contains("<soapenv:Envelope"));
        assertTrue(envelope.contains("</soapenv:Envelope>"));
    }
}
