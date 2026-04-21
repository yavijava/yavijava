package com.vmware.vim25.ws;

import org.junit.After;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.lang.reflect.Field;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import static org.junit.Assert.*;

public class CustomSSLTrustContextCreatorTest {

    private static final TrustManager NOOP_TRUST_MANAGER = new X509TrustManager() {
        public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
        public void checkClientTrusted(X509Certificate[] c, String a) throws CertificateException {}
        public void checkServerTrusted(X509Certificate[] c, String a) throws CertificateException {}
    };

    @After
    public void resetState() throws Exception {
        CustomSSLTrustContextCreator.setContextAlreadyCreated(false);
        Field ctx = CustomSSLTrustContextCreator.class.getDeclaredField("sslContext");
        ctx.setAccessible(true);
        ctx.set(null, null);
    }

    @Test
    public void getTrustContext_returnsNonNullSSLContext() throws Exception {
        SSLContext context = CustomSSLTrustContextCreator.getTrustContext(NOOP_TRUST_MANAGER);
        assertNotNull(context);
    }

    @Test
    public void getTrustContext_returnsTLSContext() throws Exception {
        SSLContext context = CustomSSLTrustContextCreator.getTrustContext(NOOP_TRUST_MANAGER);
        assertEquals("TLS", context.getProtocol());
    }

    @Test
    public void getTrustContext_calledTwice_returnsSameInstance() throws Exception {
        SSLContext first = CustomSSLTrustContextCreator.getTrustContext(NOOP_TRUST_MANAGER);
        SSLContext second = CustomSSLTrustContextCreator.getTrustContext(NOOP_TRUST_MANAGER);
        assertSame(first, second);
    }

    @Test
    public void setContextAlreadyCreated_false_allowsNewContext() throws Exception {
        SSLContext first = CustomSSLTrustContextCreator.getTrustContext(NOOP_TRUST_MANAGER);
        CustomSSLTrustContextCreator.setContextAlreadyCreated(false);

        Field ctx = CustomSSLTrustContextCreator.class.getDeclaredField("sslContext");
        ctx.setAccessible(true);
        ctx.set(null, null);

        SSLContext second = CustomSSLTrustContextCreator.getTrustContext(NOOP_TRUST_MANAGER);
        assertNotSame(first, second);
    }
}
