package com.vmware.vim25.mo;

import com.utility.LoadVcenterProps;
import com.vmware.vim25.ws.CustomSSLTrustContextCreator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.X509TrustManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class ServiceInstanceIntTest {

    @Before
    public void setUp() throws Exception {
        if (null == LoadVcenterProps.url || null == LoadVcenterProps.userName
                || null == LoadVcenterProps.password
                || null == LoadVcenterProps.secondUrl
                || null == LoadVcenterProps.badUrl
                || "".equals(LoadVcenterProps.url.trim())
                || "".equals(LoadVcenterProps.secondUrl.trim())
                || "".equals(LoadVcenterProps.badUrl.trim())
                || "".equals(LoadVcenterProps.userName.trim())
                || "".equals(LoadVcenterProps.password.trim())) {
            throw new Exception("Vcenter credentials not loaded");
        }

        // ensure that the ssl context is re-initialized for every test, so behavior for different trust managers can be verified
        CustomSSLTrustContextCreator.setContextAlreadyCreated(false);
    }

    @Test
    public void testCreateServiceInstanceForUsernameAndPasswordAndIgnoreCertsNoTimeouts() {
        try {
            ServiceInstance si = new ServiceInstance(new URL(LoadVcenterProps.url),
                    LoadVcenterProps.userName, LoadVcenterProps.password, true);
            Assert.assertNotNull("Expected non-null service instance", si.currentTime());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForUsernameAndPasswordAndIgnoreCertsWithTimeouts() {
        try {
            ServiceInstance si = new ServiceInstance(new URL(LoadVcenterProps.url),
                    LoadVcenterProps.userName, LoadVcenterProps.password, true, 5000, 5000);
            Assert.assertNotNull("Expected non-null service instance", si.currentTime());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForUsernameAndPasswordAndIgnoreCertsAndNamespaceNoTimeouts() {
        try {
            ServiceInstance si = new ServiceInstance(new URL(LoadVcenterProps.url),
                    LoadVcenterProps.userName, LoadVcenterProps.password, true, ServiceInstance.VIM25_NAMESPACE);
            Assert.assertNotNull("Expected non-null service instance", si.currentTime());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForUsernameAndPasswordAndIgnoreCertsAndNamespaceWithTimeouts() {
        try {
            ServiceInstance si = new ServiceInstance(new URL(LoadVcenterProps.url),
                    LoadVcenterProps.userName, LoadVcenterProps.password, true, ServiceInstance.VIM25_NAMESPACE, 5000, 5000);
            Assert.assertNotNull("Expected non-null service instance", si.currentTime());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForSessionStringAndIgnoreCertsAndNamespaceNoTimeouts() {
        try {
            ServiceInstance si = new ServiceInstance(new URL(LoadVcenterProps.url),
                    LoadVcenterProps.userName, LoadVcenterProps.password, true);
            Assert.assertNotNull("Expected non-null service instance", si.currentTime());

            ServiceInstance siFromSessionString = new ServiceInstance(new URL(LoadVcenterProps.url), si.getServerConnection().getSessionStr(), true);
            Assert.assertNotNull("Expected non-null service instance when creating with session string", siFromSessionString.currentTime());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    /**
     * Tests case when a trust all manager is passed to the service instance. Verifies no exceptions are thrown and that the connection is accepted.
     */
    @Test
    public void testCreateServiceInstanceForUsernameAndPasswordWithTrustAllManager() {
        try {
            ServiceInstance si = new ServiceInstance(new URL(LoadVcenterProps.url),
                    LoadVcenterProps.userName, LoadVcenterProps.password, new TrustAllManager(), ServiceInstance.VIM25_NAMESPACE, 1000, 1000);
             Assert.assertNotNull("Expected a non-null time from service instance", si.currentTime());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    /**
     * Tests case when no trust manager is provided and certs should not be ignored. Verifies an SSLHandshakeException occurs and the connection is not accepted.
     * This must be run against a vCenter running on ssl and you should not have its cert in your keystore. This is because the default trust manager performs
     * normal certificate verification against the JDK's default CA certs.
     */
    @Test
    public void testCreateServiceInstanceWithNullTrustManager() {
        try {
            new ServiceInstance(new URL(LoadVcenterProps.url),
                    LoadVcenterProps.userName, LoadVcenterProps.password, null, ServiceInstance.VIM25_NAMESPACE, 1000, 1000);
            Assert.fail("Expected an SSLHandshakeException to have been thrown when no trust manager is provided and certs are not ignored.");
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.assertTrue("Expected an SSLHandshakeException to have been thrown when no trust manager is provided and certs are not ignored.", e.getCause() instanceof SSLHandshakeException);
        }
    }

    /**
     * Tests case when a trust manager is provided but the server is not trusted. Verifies an SSLHandshakeException occurs and the connection is not accepted.
     */
    @Test
    public void testCreateServiceInstanceWithProvidedTrustManagerServerNotTrusted() {
        try {
            X509TrustManager testUntrustedServerTrustManager = new UntrustedServerTrustManager();

            new ServiceInstance(new URL(LoadVcenterProps.url),
                    LoadVcenterProps.userName, LoadVcenterProps.password, testUntrustedServerTrustManager, ServiceInstance.VIM25_NAMESPACE, 1000, 1000);
            Assert.fail("Expected an SSLHandshakeException to have been thrown when the trust manager provided simulates an untrusted server.");
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            e.printStackTrace();
            Assert.assertTrue("Expected an SSLHandshakeException to have been thrown when the trust manager provided simulates an untrusted server.", e.getCause() instanceof SSLHandshakeException);
        }
    }

    /**
     * Tests case when a trust all manager is passed to the service instance. Then the same trust manager is passed to a new service instance for a session string.
     * Verifies no exceptions are thrown and that the connection is accepted for both service instances.
     */
    @Test
    public void testCreateServiceInstanceForSessionStringWithTrustAllManager() {
        try {
            TrustAllManager trustAllManager = new TrustAllManager();
            ServiceInstance si = new ServiceInstance(new URL(LoadVcenterProps.url),
                    LoadVcenterProps.userName, LoadVcenterProps.password, trustAllManager);
            Assert.assertNotNull("Expected non-null service instance", si.currentTime());

            ServiceInstance siFromSessionString = new ServiceInstance(new URL(LoadVcenterProps.url), si.getServerConnection().getSessionStr(), trustAllManager);
            Assert.assertNotNull("Expected non-null service instance when creating with session string", siFromSessionString.currentTime());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    /**
     * Tests case when a trust all manager is passed to the service instance. Then a null trust manager is passed to a new service instance for a session string.
     * Verifies an SSLHandshakeException is thrown for the session string service instance.
     */
    @Test
    public void testCreateServiceInstanceForSessionStringWithNullTrustManager() {
        try {
            ServiceInstance si = new ServiceInstance(new URL(LoadVcenterProps.url),
                    LoadVcenterProps.userName, LoadVcenterProps.password, new TrustAllManager(), ServiceInstance.VIM25_NAMESPACE, 1000, 1000);
            Assert.assertNotNull("Expected non-null service instance", si.currentTime());

            X509TrustManager nullTrustManager = null;
            new ServiceInstance(new URL(LoadVcenterProps.url), si.getServerConnection().getSessionStr(), nullTrustManager);
            Assert.fail("Expected an SSLHandshakeException to have been thrown when no trust manager is provided.");
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.assertTrue("Expected an SSLHandshakeException to have been thrown when no trust manager is provided.", e.getCause() instanceof SSLHandshakeException);
        }
    }

    @Test
    public void testServiceInstanceUsingSession() {
        try {
            ServiceInstance si = new ServiceInstance(new URL(LoadVcenterProps.url),
                LoadVcenterProps.userName, LoadVcenterProps.password, true, 5000, 5000);
            Assert.assertNotNull("Expected non-null service instance", si.currentTime());
            ServiceInstance si2 = new ServiceInstance(new URL(LoadVcenterProps.url),
                si.getServerConnection().getSessionStr(), true);
            Assert.assertNotNull("Expected non-null service instance", si2.currentTime());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    private static class TrustAllManager implements X509TrustManager {
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        @Override
        public void checkServerTrusted(X509Certificate[] certs, String authType) {
        }

        @Override
        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }
    }

    private static class UntrustedServerTrustManager implements X509TrustManager {
        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        @Override
        public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
            throw new CertificateException("Intentional CertificateException to simulate an untrusted server.");
        }

        @Override
        public void checkClientTrusted(X509Certificate[] certs, String authType) {
        }
    }
}
