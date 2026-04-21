package com.vmware.vim25.ws;

import org.junit.Test;

import javax.net.ssl.X509TrustManager;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import static org.junit.Assert.*;

public class ApacheHttpClientTest {

    private static final X509TrustManager NOOP_TRUST_MANAGER = new X509TrustManager() {
        public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
        public void checkClientTrusted(X509Certificate[] c, String a) throws CertificateException {}
        public void checkServerTrusted(X509Certificate[] c, String a) throws CertificateException {}
    };

    @Test
    public void constructor_stripsTrailingSlash() throws Exception {
        ApacheHttpClient client = new ApacheHttpClient("http://vcenter.example.com/", true);
        assertEquals("http://vcenter.example.com", client.getBaseUrl().toString());
    }

    @Test
    public void constructor_noTrailingSlash_urlUnchanged() throws Exception {
        ApacheHttpClient client = new ApacheHttpClient("http://vcenter.example.com", true);
        assertEquals("http://vcenter.example.com", client.getBaseUrl().toString());
    }

    @Test
    public void constructor_ignoreCertTrue_setsTrustAllSSL() throws Exception {
        ApacheHttpClient client = new ApacheHttpClient("http://vcenter.example.com", true);
        Field f = ApacheHttpClient.class.getDeclaredField("trustAllSSL");
        f.setAccessible(true);
        assertTrue(f.getBoolean(client));
    }

    @Test
    public void constructor_ignoreCertFalse_clearsTrustAllSSL() throws Exception {
        ApacheHttpClient client = new ApacheHttpClient("http://vcenter.example.com", false);
        Field f = ApacheHttpClient.class.getDeclaredField("trustAllSSL");
        f.setAccessible(true);
        assertFalse(f.getBoolean(client));
    }

    @Test
    public void oneArgConstructor_defaultsIgnoreCertToTrue() throws Exception {
        ApacheHttpClient client = new ApacheHttpClient("http://vcenter.example.com");
        Field f = ApacheHttpClient.class.getDeclaredField("trustAllSSL");
        f.setAccessible(true);
        assertTrue(f.getBoolean(client));
    }

    @Test
    public void constructor_withTrustManager_storesTrustManager() throws Exception {
        ApacheHttpClient client = new ApacheHttpClient("http://vcenter.example.com", false, NOOP_TRUST_MANAGER);
        assertSame(NOOP_TRUST_MANAGER, client.getTrustManager());
    }

    @Test(expected = MalformedURLException.class)
    public void constructor_malformedUrl_throwsMalformedURLException() throws Exception {
        new ApacheHttpClient("not-a-url", true);
    }
}
