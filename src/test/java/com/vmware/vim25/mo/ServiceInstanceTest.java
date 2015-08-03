package com.vmware.vim25.mo;

import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ServiceContent;
import com.vmware.vim25.UserSession;
import com.vmware.vim25.VimPortType;
import org.junit.Assert;
import org.junit.Test;

import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.security.cert.X509Certificate;

public class ServiceInstanceTest {

    @Test
    public void testCreateServiceInstanceForUsernameAndPasswordNoTimeouts() {
        try {
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "username", "password");

            Assert.assertEquals(0, si.getConnectTimeout());
            Assert.assertEquals(0, si.getReadTimeout());
            Assert.assertNull(si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForUsernameAndPasswordWithTimeouts() {
        try {
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "username", "password", 2000, 5000);

            Assert.assertEquals(2000, si.getConnectTimeout());
            Assert.assertEquals(5000, si.getReadTimeout());
            Assert.assertNull(si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForUsernameAndPasswordAndIgnoreCertsNoTimeouts() {
        try {
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "username", "password", true);

            Assert.assertEquals(0, si.getConnectTimeout());
            Assert.assertEquals(0, si.getReadTimeout());
            Assert.assertNull(si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForUsernameAndPasswordAndTrustManagerNoTimeouts() {
        try {
            TestTrustManager testTrustManager = new TestTrustManager();
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "username", "password", testTrustManager);

            Assert.assertEquals(0, si.getConnectTimeout());
            Assert.assertEquals(0, si.getReadTimeout());
            Assert.assertEquals(testTrustManager, si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForUsernameAndPasswordAndIgnoreCertsWithTimeouts() {
        try {
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "username", "password", true, 2000, 5000);

            Assert.assertEquals(2000, si.getConnectTimeout());
            Assert.assertEquals(5000, si.getReadTimeout());
            Assert.assertNull(si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForUsernameAndPasswordAndTrustManagerWithTimeouts() {
        try {
            TestTrustManager testTrustManager = new TestTrustManager();
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "username", "password", testTrustManager, 2000, 5000);

            Assert.assertEquals(2000, si.getConnectTimeout());
            Assert.assertEquals(5000, si.getReadTimeout());
            Assert.assertEquals(testTrustManager, si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForUsernameAndPasswordAndIgnoreCertsAndNamespaceNoTimeouts() {
        try {
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "username", "password", true, ServiceInstance.VIM25_NAMESPACE);

            Assert.assertEquals(0, si.getConnectTimeout());
            Assert.assertEquals(0, si.getReadTimeout());
            Assert.assertNull(si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForUsernameAndPasswordAndTrustManagerAndNamespaceNoTimeouts() {
        try {
            TestTrustManager testTrustManager = new TestTrustManager();
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "username", "password", testTrustManager, ServiceInstance.VIM25_NAMESPACE);

            Assert.assertEquals(0, si.getConnectTimeout());
            Assert.assertEquals(0, si.getReadTimeout());
            Assert.assertEquals(testTrustManager, si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForUsernameAndPasswordAndIgnoreCertsAndNamespaceWithTimeouts() {
        try {
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "username", "password", true, ServiceInstance.VIM25_NAMESPACE, 2000, 5000);

            Assert.assertEquals(2000, si.getConnectTimeout());
            Assert.assertEquals(5000, si.getReadTimeout());
            Assert.assertNull(si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForUsernameAndPasswordAndTrustManagerAndNamespaceWithTimeouts() {
        try {
            TestTrustManager testTrustManager = new TestTrustManager();
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "username", "password", testTrustManager, ServiceInstance.VIM25_NAMESPACE, 2000, 5000);

            Assert.assertEquals(2000, si.getConnectTimeout());
            Assert.assertEquals(5000, si.getReadTimeout());
            Assert.assertEquals(testTrustManager, si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForSessionStringAndIgnoreCertsNoTimeouts() {
        try {
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "\"vmware_soap_session=\\\"B3240D15-34DF-4BB8-B902-A844FDF42E85\\\"\"", true);

            Assert.assertEquals(0, si.getConnectTimeout());
            Assert.assertEquals(0, si.getReadTimeout());
            Assert.assertNull(si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForSessionStringAndTrustManagerNoTimeouts() {
        try {
            TestTrustManager testTrustManager = new TestTrustManager();
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "\"vmware_soap_session=\\\"B3240D15-34DF-4BB8-B902-A844FDF42E85\\\"\"", testTrustManager);

            Assert.assertEquals(0, si.getConnectTimeout());
            Assert.assertEquals(0, si.getReadTimeout());
            Assert.assertEquals(testTrustManager, si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForSessionStringAndIgnoreCertsWithTimeouts() {
        try {
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "\"vmware_soap_session=\\\"B3240D15-34DF-4BB8-B902-A844FDF42E85\\\"\"", true, 2000, 5000);

            Assert.assertEquals(2000, si.getConnectTimeout());
            Assert.assertEquals(5000, si.getReadTimeout());
            Assert.assertNull(si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForSessionStringAndTrustManagerWithTimeouts() {
        try {
            TestTrustManager testTrustManager = new TestTrustManager();
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "\"vmware_soap_session=\\\"B3240D15-34DF-4BB8-B902-A844FDF42E85\\\"\"", testTrustManager, 2000, 5000);

            Assert.assertEquals(2000, si.getConnectTimeout());
            Assert.assertEquals(5000, si.getReadTimeout());
            Assert.assertEquals(testTrustManager, si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForSessionStringAndIgnoreCertsAndNamespaceNoTimeouts() {
        try {
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "\"vmware_soap_session=\\\"B3240D15-34DF-4BB8-B902-A844FDF42E85\\\"\"", true, ServiceInstance.VIM25_NAMESPACE);

            Assert.assertEquals(0, si.getConnectTimeout());
            Assert.assertEquals(0, si.getReadTimeout());
            Assert.assertNull(si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForSessionStringAndTrustManagerAndNamespaceNoTimeouts() {
        try {
            TestTrustManager testTrustManager = new TestTrustManager();
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "\"vmware_soap_session=\\\"B3240D15-34DF-4BB8-B902-A844FDF42E85\\\"\"", testTrustManager, ServiceInstance.VIM25_NAMESPACE);

            Assert.assertEquals(0, si.getConnectTimeout());
            Assert.assertEquals(0, si.getReadTimeout());
            Assert.assertEquals(testTrustManager, si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForSessionStringAndIgnoreCertsAndNamespaceWithTimeouts() {
        try {
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "\"vmware_soap_session=\\\"B3240D15-34DF-4BB8-B902-A844FDF42E85\\\"\"", true, ServiceInstance.VIM25_NAMESPACE, 2000, 5000);

            Assert.assertEquals(2000, si.getConnectTimeout());
            Assert.assertEquals(5000, si.getReadTimeout());
            Assert.assertNull(si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    @Test
    public void testCreateServiceInstanceForSessionStringAndTrustManagerAndNamespaceWithTimeouts() {
        try {
            TestTrustManager testTrustManager = new TestTrustManager();
            TestServiceInstance si = new TestServiceInstance(new URL("https://some-vcenter-address/sdk"), "\"vmware_soap_session=\\\"B3240D15-34DF-4BB8-B902-A844FDF42E85\\\"\"", testTrustManager, ServiceInstance.VIM25_NAMESPACE, 2000, 5000);

            Assert.assertEquals(2000, si.getConnectTimeout());
            Assert.assertEquals(5000, si.getReadTimeout());
            Assert.assertEquals(testTrustManager, si.getTrustManager());
        } catch(MalformedURLException e) {
            Assert.fail("An error occurred creating a service instance due its url being malformed. " + e.getMessage());
        } catch(RemoteException e) {
            Assert.fail("An error occurred creating and reading from service instance. " + e.getMessage());
        }
    }

    private class TestServiceInstance extends ServiceInstance {

        private TestServiceInstance(URL url, String username, String password)
                throws RemoteException, MalformedURLException {
            super(url, username, password);
        }

        private TestServiceInstance(URL url, String username, String password, boolean ignoreCert)
                throws RemoteException, MalformedURLException {
            super(url, username, password, ignoreCert);
        }

        private TestServiceInstance(URL url, String username, String password, TrustManager trustManager)
                throws RemoteException, MalformedURLException {
            super(url, username, password, trustManager);
        }

        private TestServiceInstance(URL url, String username, String password, boolean ignoreCert, String namespace)
                throws RemoteException, MalformedURLException {
            super(url, username, password, ignoreCert, namespace);
        }

        private TestServiceInstance(URL url, String username, String password, int connectTimeout, int readTimeout)
                throws RemoteException, MalformedURLException {
            super(url, username, password, connectTimeout, readTimeout);
        }

        private TestServiceInstance(URL url, String username, String password, boolean ignoreCert, int connectTimeout, int readTimeout)
                throws RemoteException, MalformedURLException {
            super(url, username, password, ignoreCert, connectTimeout, readTimeout);
        }

        private TestServiceInstance(URL url, String username, String password, TrustManager trustManager, int connectTimeout, int readTimeout)
                throws RemoteException, MalformedURLException {
            super(url, username, password, trustManager, connectTimeout, readTimeout);
        }

        private TestServiceInstance(URL url, String username, String password, boolean ignoreCert, String namespace, int connectTimeout, int readTimeout)
                throws RemoteException, MalformedURLException {
            super(url, username, password, ignoreCert, namespace, connectTimeout, readTimeout);
        }

        private TestServiceInstance(URL url, String username, String password, TrustManager trustManager, String namespace, int connectTimeout, int readTimeout)
                throws RemoteException, MalformedURLException {
            super(url, username, password, trustManager, namespace, connectTimeout, readTimeout);
        }

        private TestServiceInstance(URL url, String username, String password, TrustManager trustManager, String namespace)
                throws RemoteException, MalformedURLException {
            super(url, username, password, trustManager, namespace);
        }

        private TestServiceInstance(URL url, String sessionStr, boolean ignoreCert)
                throws RemoteException, MalformedURLException {
            super(url, sessionStr, ignoreCert);
        }

        private TestServiceInstance(URL url, String sessionStr, TrustManager trustManager)
                throws RemoteException, MalformedURLException {
            super(url, sessionStr, trustManager);
        }

        private TestServiceInstance(URL url, String sessionStr, boolean ignoreCert, int connectTimeout, int readTimeout)
                throws RemoteException, MalformedURLException {
            super(url, sessionStr, ignoreCert, connectTimeout, readTimeout);
        }

        private TestServiceInstance(URL url, String sessionStr, TrustManager trustManager, int connectTimeout, int readTimeout)
                throws RemoteException, MalformedURLException {
            super(url, sessionStr, trustManager, connectTimeout, readTimeout);
        }

        private TestServiceInstance(URL url, String sessionStr, boolean ignoreCert, String namespace)
                throws RemoteException, MalformedURLException {
            super(url, sessionStr, ignoreCert, namespace);
        }

        private TestServiceInstance(URL url, String sessionStr, TrustManager trustManager, String namespace)
                throws RemoteException, MalformedURLException {
            super(url, sessionStr, trustManager, namespace);
        }

        private TestServiceInstance(URL url, String sessionStr, boolean ignoreCert, String namespace, int connectTimeout, int readTimeout)
                throws RemoteException, MalformedURLException {
            super(url, sessionStr, ignoreCert, namespace, connectTimeout, readTimeout);
        }

        private TestServiceInstance(URL url, String sessionStr, TrustManager trustManager, String namespace, int connectTimeout, int readTimeout)
                throws RemoteException, MalformedURLException {
            super(url, sessionStr, trustManager, namespace, connectTimeout, readTimeout);
        }

        @Override
        protected UserSession login(SessionManager sessionManager, String userName, String password, String locale) {
            return new UserSession();
        }

        @Override
        protected UserSession getCurrentUserSession() {
            return new UserSession();
        }

        @Override
        protected ServiceContent retrieveServiceContent(VimPortType vimService, ManagedObjectReference mor) throws RemoteException {
            return new ServiceContent();
        }

        @Override
        protected String getApiVersion(ServiceContent serviceContent) {
            return "2.5";
        }
    }

    private static class TestTrustManager implements X509TrustManager {
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
}
