package com.vmware.vim25.ws;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;

import static org.junit.Assert.*;

public class SoapClientTest {

    private StubSoapClient client;

    private static class StubSoapClient extends SoapClient {
        public Object invoke(String m, Argument[] p, String r) throws RemoteException { return null; }
        public StringBuffer invokeAsString(String m, Argument[] p) throws RemoteException { return null; }
    }

    @Before
    public void setUp() {
        client = new StubSoapClient();
    }

    // --- setSoapActionOnApiVersion ---

    @Test
    public void setSoapAction_version40_setsV40Action() {
        client.setSoapActionOnApiVersion("4.0");
        assertEquals("urn:vim25/4.0", client.soapAction);
    }

    @Test
    public void setSoapAction_version41_setsV41Action() {
        client.setSoapActionOnApiVersion("4.1");
        assertEquals("urn:vim25/4.1", client.soapAction);
    }

    @Test
    public void setSoapAction_version50_setsV50Action() {
        client.setSoapActionOnApiVersion("5.0");
        assertEquals("urn:vim25/5.0", client.soapAction);
    }

    @Test
    public void setSoapAction_version51_setsV51Action() {
        client.setSoapActionOnApiVersion("5.1");
        assertEquals("urn:vim25/5.1", client.soapAction);
    }

    @Test
    public void setSoapAction_version55_setsV55Action() {
        client.setSoapActionOnApiVersion("5.5");
        assertEquals("urn:vim25/5.5", client.soapAction);
    }

    @Test
    public void setSoapAction_version60_setsV60Action() {
        client.setSoapActionOnApiVersion("6.0");
        assertEquals("urn:vim25/6.0", client.soapAction);
    }

    @Test
    public void setSoapAction_version65_setsV65Action() {
        client.setSoapActionOnApiVersion("6.5");
        assertEquals("urn:vim25/6.5", client.soapAction);
    }

    @Test
    public void setSoapAction_unknownVersion_defaultsToLatestKnown() {
        // Was previously V65 — bug: caused 7.x/8.x/9.x clients to receive
        // 6.5-era ServiceContent missing newer manager MORs. Default is now
        // the latest supported version (9.0).
        client.setSoapActionOnApiVersion("99.9");
        assertEquals("urn:vim25/9.0", client.soapAction);
    }

    // --- hexify ---

    @Test
    public void hexify_emptyArray_returnsEmptyString() {
        assertEquals("", SoapClient.hexify(new byte[]{}));
    }

    @Test
    public void hexify_singleZeroByte_returnsTwoZeros() {
        assertEquals("00", SoapClient.hexify(new byte[]{0x00}));
    }

    @Test
    public void hexify_singleMaxByte_returnsFF() {
        assertEquals("FF", SoapClient.hexify(new byte[]{(byte) 0xFF}));
    }

    @Test
    public void hexify_multipleBytes_separatedByColon() {
        assertEquals("0A:0B:0C", SoapClient.hexify(new byte[]{0x0A, 0x0B, 0x0C}));
    }

    // --- readStream ---

    @Test
    public void readStream_emptyStream_returnsEmptyBuffer() throws Exception {
        InputStream is = new ByteArrayInputStream(new byte[0]);
        assertEquals("", client.readStream(is).toString());
    }

    @Test
    public void readStream_multiLineInput_joinsLines() throws Exception {
        String input = "line1\nline2\nline3";
        InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        assertEquals("line1line2line3", client.readStream(is).toString());
    }

    @Test
    public void readStream_utf8NonAsciiContent_preservesCharacters() throws Exception {
        // SOAP responses from vSphere are UTF-8. VM names / descriptions can contain
        // non-ASCII characters (e.g. German umlauts, accented chars). Without an explicit
        // charset the JDK uses the platform default, which corrupts these characters on
        // non-UTF-8 systems.
        String input = "München-VM Résumé Ñoño";
        InputStream is = new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8));
        assertEquals(input, client.readStream(is).toString());
    }

    // --- marshall ---

    @Test
    public void marshall_returnsNonNullString() {
        client.setVimNameSpace("urn:vim25/6.0");
        String result = client.marshall("TestMethod", new Argument[0]);
        assertNotNull(result);
    }

    @Test
    public void marshall_containsMethodName() {
        client.setVimNameSpace("urn:vim25/6.0");
        String result = client.marshall("RetrieveServiceContent", new Argument[0]);
        assertTrue(result.contains("RetrieveServiceContent"));
    }

    // --- getters/setters ---

    @Test
    public void cookie_roundTrip() {
        client.setCookie("session=abc123");
        assertEquals("session=abc123", client.getCookie());
    }

    @Test
    public void vimNameSpace_roundTrip() {
        client.setVimNameSpace("urn:vim25/6.0");
        assertEquals("urn:vim25/6.0", client.getVimNameSpace());
    }

    @Test
    public void connectTimeout_roundTrip() {
        client.setConnectTimeout(5000);
        assertEquals(5000, client.getConnectTimeout());
    }

    @Test
    public void readTimeout_roundTrip() {
        client.setReadTimeout(3000);
        assertEquals(3000, client.getReadTimeout());
    }

    @Test
    public void serverThumbprint_roundTrip() {
        client.setServerThumbprint("AA:BB:CC");
        assertEquals("AA:BB:CC", client.getServerThumbprint());
    }
}
