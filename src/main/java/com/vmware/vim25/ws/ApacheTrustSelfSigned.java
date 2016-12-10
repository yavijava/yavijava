package com.vmware.vim25.ws;

import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
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

    public static SSLConnectionSocketFactory trust() {
        SSLContextBuilder builder = new SSLContextBuilder();
        log.trace("Set SSL Context Builder to trust self signed certs.");
        try {
            builder.loadTrustMaterial(null, new TrustSelfSignedStrategy());
            log.trace("Added Self Signed Strategy to builder.");
        }
        catch (NoSuchAlgorithmException e) {
            log.error("NoSuchAlgorithm caught trying to add SelfSignedStrategy.", e);
            return null;
        }
        catch (KeyStoreException e) {
            log.error("KeyStoreException caught trying to add TrustSelfSignedStrategy.", e);
            return null;
        }
        SSLConnectionSocketFactory sslConnectionSocketFactory;
        try {
            sslConnectionSocketFactory = new SSLConnectionSocketFactory(builder.build(), new AllowAllHostnameVerifier());
            log.trace("Added SSLConnectionSocketFactory to builder.");
        }
        catch (NoSuchAlgorithmException e) {
            log.error("Error trying to trust self signed certs.", e);
            return null;
        }
        catch (KeyManagementException e) {
            log.error("Error trying to trust self signed certs.", e);
            return null;
        }
        log.trace("Created self signed trust.");
        return sslConnectionSocketFactory;
    }
}
