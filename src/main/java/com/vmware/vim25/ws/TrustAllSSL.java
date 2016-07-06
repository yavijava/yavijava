package com.vmware.vim25.ws;

import javax.net.ssl.*;
import java.rmi.RemoteException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Copyright 2014-2015 Michael Rice
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
public class TrustAllSSL {

    private static boolean alreadyCreated = false;
    private static SSLContext sslContext;

    public static synchronized SSLContext getTrustContext() throws RemoteException {
        try {
            if (getAlreadyCreated()) {
                return sslContext;
            }
            setAlreadyCreated();
            TrustManager[] trustAllCerts = new TrustManager[1];
            trustAllCerts[0] = new TrustAllManager();
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultHostnameVerifier(
                new HostnameVerifier() {
                    public boolean verify(String urlHostName, SSLSession session) {
                        return true;
                    }
                }
            );
        } catch (NoSuchAlgorithmException e) {
            throw new RemoteException("Unable to find suitable algorithm while attempting to communicate with remote server.", e);
        } catch (KeyManagementException e) {
            throw new RemoteException("Key Management exception while attempting to communicate with remote server.", e);
        }

        return sslContext;
    }

    /**
     * This is an unsafe method and should not be used. It will be removed
     * at the next MAJOR release of vSphere
     *
     * @throws NoSuchAlgorithmException
     * @throws KeyManagementException
     * @deprecated
     */
    @Deprecated
    public static void trustAllHttpsCertificates() throws NoSuchAlgorithmException, KeyManagementException {
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
