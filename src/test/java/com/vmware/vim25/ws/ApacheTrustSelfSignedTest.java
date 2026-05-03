package com.vmware.vim25.ws;

import org.apache.hc.client5.http.ssl.TlsSocketStrategy;
import org.junit.Test;

import static org.junit.Assert.*;

public class ApacheTrustSelfSignedTest {

    @Test
    public void trust_returnsNonNullStrategy() {
        TlsSocketStrategy strategy = ApacheTrustSelfSigned.trust();
        assertNotNull(strategy);
    }

    @Test
    public void trust_calledTwice_returnsNewInstanceEachTime() {
        TlsSocketStrategy first = ApacheTrustSelfSigned.trust();
        TlsSocketStrategy second = ApacheTrustSelfSigned.trust();
        assertNotNull(first);
        assertNotNull(second);
        assertNotSame(first, second);
    }
}
