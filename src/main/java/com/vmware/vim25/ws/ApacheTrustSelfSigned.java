package com.vmware.vim25.ws;

import org.apache.hc.client5.http.ssl.DefaultClientTlsStrategy;
import org.apache.hc.client5.http.ssl.NoopHostnameVerifier;
import org.apache.hc.client5.http.ssl.TlsSocketStrategy;
import org.apache.hc.client5.http.ssl.TrustAllStrategy;
import org.apache.hc.core5.ssl.SSLContextBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Michael Rice on 8/15/14.
 * <p>
 * Copyright 2014 Michael Rice
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class ApacheTrustSelfSigned {

    private static Logger log = LoggerFactory.getLogger(ApacheTrustSelfSigned.class);

    /**
     * Returns a TLS socket strategy that accepts all certificates without validation
     * and skips hostname verification.
     *
     * @apiNote <strong>WARNING:</strong> This intentionally disables SSL certificate
     *     validation and hostname checking. Use only in closed, trusted environments
     *     (e.g., local vSphere labs with self-signed certs). Never use against
     *     untrusted or public endpoints.
     * @return a trust-all {@link TlsSocketStrategy}, or {@code null} if the TLS context
     *     cannot be initialised
     */
    public static TlsSocketStrategy trust() {
        try {
            return new DefaultClientTlsStrategy(
                SSLContextBuilder.create()
                    .loadTrustMaterial(TrustAllStrategy.INSTANCE)
                    .build(),
                NoopHostnameVerifier.INSTANCE);
        } catch (NoSuchAlgorithmException | KeyStoreException | KeyManagementException e) {
            log.error("Error creating trust-all TLS strategy.", e);
            return null;
        }
    }
}
