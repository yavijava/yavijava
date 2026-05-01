package com.vmware.vim25.ws;

import org.junit.After;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class TrustAllSSLTest {

    @After
    public void resetStaticState() throws Exception {
        Field created = TrustAllSSL.class.getDeclaredField("alreadyCreated");
        created.setAccessible(true);
        created.setBoolean(null, false);

        Field ctx = TrustAllSSL.class.getDeclaredField("sslContext");
        ctx.setAccessible(true);
        ctx.set(null, null);
    }

    @Test
    public void getTrustContext_returnsNonNullSSLContext() throws Exception {
        SSLContext context = TrustAllSSL.getTrustContext();
        assertNotNull(context);
    }

    @Test
    public void getTrustContext_returnsTLSContext() throws Exception {
        SSLContext context = TrustAllSSL.getTrustContext();
        assertEquals("TLS", context.getProtocol());
    }

    @Test
    public void getTrustContext_calledTwice_returnsSameInstance() throws Exception {
        SSLContext first = TrustAllSSL.getTrustContext();
        SSLContext second = TrustAllSSL.getTrustContext();
        assertSame(first, second);
    }

    @Test
    public void trustAllHttpsCertificates_doesNotThrow() throws Exception {
        TrustAllSSL.trustAllHttpsCertificates();
    }

    @Test
    public void getTrustAllHostnameVerifier_returnsVerifierThatAcceptsAnyHostname() {
        javax.net.ssl.HostnameVerifier verifier = TrustAllSSL.getTrustAllHostnameVerifier();
        assertNotNull(verifier);
        assertTrue(verifier.verify("any-host", null));
        assertTrue(verifier.verify("192.0.2.1", null));
    }

    @Test
    public void getTrustAllHostnameVerifier_returnsSameInstanceAcrossCalls() {
        // Reused instance keeps WSClient.applyHttpsConfig allocation-free per request.
        assertSame(TrustAllSSL.getTrustAllHostnameVerifier(), TrustAllSSL.getTrustAllHostnameVerifier());
    }
}
