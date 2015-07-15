package com.vmware.vim25.mo;

import com.utility.LoadVcenterProps;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

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

}
