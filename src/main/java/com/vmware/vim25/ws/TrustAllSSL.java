package com.vmware.vim25.ws;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Copyright 2014-2015 Michael Rice
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class TrustAllSSL {

    private static boolean alreadyCreated = false;

    public static void trustAllHttpsCertificates() throws NoSuchAlgorithmException, KeyManagementException {
        if (getAlreadyCreated()) {
            return;
        }
        setAlreadyCreated();
        TrustManager[] trustAllCerts = new TrustManager[1];
        trustAllCerts[0] = new TrustAllManager();
        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, null);
        HttpsURLConnection.setDefaultSSLSocketFactory(
            sc.getSocketFactory());
    }

    private static class TrustAllManager implements X509TrustManager {
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        public void checkServerTrusted(X509Certificate[] certs,
                                       String authType)
            throws CertificateException {
        }

        public void checkClientTrusted(X509Certificate[] certs,
                                       String authType)
            throws CertificateException {
        }
    }

    private static boolean getAlreadyCreated() {
        return alreadyCreated;
    }

    private static void setAlreadyCreated() {
        alreadyCreated = true;
    }
}
