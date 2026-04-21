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
}
