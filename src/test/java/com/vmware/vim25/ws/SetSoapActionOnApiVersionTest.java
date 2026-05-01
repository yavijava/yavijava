package com.vmware.vim25.ws;

import org.junit.Test;

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import static org.junit.Assert.assertEquals;

/**
 * Regression tests for {@link SoapClient#setSoapActionOnApiVersion(String)}.
 *
 * Originally found by smoke-testing yavijava against a live vCenter 9.0:
 * the server's RetrieveServiceContent response was returning a 6.5-era
 * subset of manager MORs because yavijava was sending
 * {@code SOAPAction: urn:vim25/6.5} for any API version &gt; 6.5
 * (the if/else chain fell through to a 6.5 default).
 *
 * vSphere 7.0+ also reports apiVersion as four-part ("9.0.0.0") rather
 * than the two-part form ("6.5") used by older versions, so the matcher
 * has to normalize.
 */
public class SetSoapActionOnApiVersionTest {

    private SoapClient newClient() throws MalformedURLException, RemoteException {
        // WSClient is the simplest concrete subclass of SoapClient.
        return new WSClient("https://example.invalid/sdk", true);
    }

    @Test
    public void apiVersion4_0_picksV40Header() throws Exception {
        SoapClient c = newClient();
        c.setSoapActionOnApiVersion("4.0");
        assertEquals("urn:vim25/4.0", c.soapAction);
    }

    @Test
    public void apiVersion5_5_picksV55Header() throws Exception {
        SoapClient c = newClient();
        c.setSoapActionOnApiVersion("5.5");
        assertEquals("urn:vim25/5.5", c.soapAction);
    }

    @Test
    public void apiVersion6_5_picksV65Header() throws Exception {
        SoapClient c = newClient();
        c.setSoapActionOnApiVersion("6.5");
        assertEquals("urn:vim25/6.5", c.soapAction);
    }

    @Test
    public void apiVersion6_7_picksV67Header() throws Exception {
        SoapClient c = newClient();
        c.setSoapActionOnApiVersion("6.7");
        assertEquals("urn:vim25/6.7", c.soapAction);
    }

    @Test
    public void apiVersion7_0_picksV70Header() throws Exception {
        SoapClient c = newClient();
        c.setSoapActionOnApiVersion("7.0");
        assertEquals("urn:vim25/7.0", c.soapAction);
    }

    @Test
    public void apiVersion8_0_picksV80Header() throws Exception {
        SoapClient c = newClient();
        c.setSoapActionOnApiVersion("8.0");
        assertEquals("urn:vim25/8.0", c.soapAction);
    }

    /**
     * Regression: prior to fix, this fell through to the V65 default and the
     * vCenter 9.0 server responded with a 6.5-era ServiceContent that was
     * missing tenantManager / siteInfoManager / storageQueryManager /
     * directPathProfileManager / guestCustomizationManager / virtualizationManager.
     */
    @Test
    public void apiVersion9_0_picksV90Header_notV65() throws Exception {
        SoapClient c = newClient();
        c.setSoapActionOnApiVersion("9.0");
        assertEquals("urn:vim25/9.0", c.soapAction);
    }

    /**
     * vSphere 7.0+ reports apiVersion in four-part form. The matcher must
     * normalize to major.minor before comparing. Previously this fell
     * through to the V65 default and triggered the same regression as
     * apiVersion9_0_picksV90Header_notV65.
     */
    @Test
    public void apiVersion9_0_0_0_isNormalizedTo9_0() throws Exception {
        SoapClient c = newClient();
        c.setSoapActionOnApiVersion("9.0.0.0");
        assertEquals("urn:vim25/9.0", c.soapAction);
    }

    @Test
    public void apiVersion8_0_3_0_isNormalizedTo8_0() throws Exception {
        SoapClient c = newClient();
        c.setSoapActionOnApiVersion("8.0.3.0");
        assertEquals("urn:vim25/8.0", c.soapAction);
    }

    @Test
    public void apiVersion7_0_3_0_isNormalizedTo7_0() throws Exception {
        SoapClient c = newClient();
        c.setSoapActionOnApiVersion("7.0.3.0");
        assertEquals("urn:vim25/7.0", c.soapAction);
    }

    /**
     * Unknown future versions should default to the latest known version
     * (currently 9.0), not 6.5. This is the contract change documented in
     * UPDATES.md.
     */
    @Test
    public void unknownFutureVersion_defaultsToLatestKnown_notV65() throws Exception {
        SoapClient c = newClient();
        c.setSoapActionOnApiVersion("99.0.0.0");
        assertEquals("urn:vim25/9.0", c.soapAction);
    }
}
