package com.vmware.vim25.ws;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApacheTrustSelfSignedTest {

    @Test
    public void trust_returnsNonNullSocketFactory() {
        SSLConnectionSocketFactory factory = ApacheTrustSelfSigned.trust();
        assertNotNull(factory);
    }

    @Test
    public void trust_calledTwice_returnsNewInstanceEachTime() {
        SSLConnectionSocketFactory first = ApacheTrustSelfSigned.trust();
        SSLConnectionSocketFactory second = ApacheTrustSelfSigned.trust();
        assertNotNull(first);
        assertNotNull(second);
        assertNotSame(first, second);
    }
}
