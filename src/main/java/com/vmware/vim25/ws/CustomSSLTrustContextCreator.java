package com.vmware.vim25.ws;

import javax.net.ssl.*;
import java.rmi.RemoteException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.atomic.AtomicBoolean;

public class CustomSSLTrustContextCreator {

    private static AtomicBoolean contextAlreadyCreated = new AtomicBoolean(false);
    private static SSLContext sslContext;

    public static SSLContext getTrustContext(TrustManager trustManager) throws RemoteException {
        try {
            if (contextAlreadyCreated.getAndSet(true)) {
                return sslContext;
            }

            TrustManager[] trustManagers = new TrustManager[] { trustManager };
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagers, null);
        }catch(NoSuchAlgorithmException e) {
            throw new RemoteException("Unable to find suitable algorithm while attempting to communicate with remote server.", e);
        } catch(KeyManagementException e) {
            throw new RemoteException("An error occurred initializing SSL context due to a problem with key management.", e);
        }

        return sslContext;
    }

    /**
     * Sets the contextAlreadyCreated boolean used to determine whether a new ssl context should be initialized or not.
     * Exposed as public for unit testability.
     *
     * @param alreadyCreated
     */
    public static void setContextAlreadyCreated(boolean alreadyCreated) {
        contextAlreadyCreated.set(alreadyCreated);
    }
}
