package com.vmware.vim25.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.utility.LoadVcenterProps;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.SelectionSpec;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.util.PropertyCollectorUtil;

public class ApacheHttpClientTest {
    SoapClient apacheHttpClient = null;

    @Before
    public void setUp() throws Exception {
        if (null == LoadVcenterProps.url || null == LoadVcenterProps.userName
                || null == LoadVcenterProps.password
                || "".equals(LoadVcenterProps.url.trim())
                || "".equals(LoadVcenterProps.userName.trim())
                || "".equals(LoadVcenterProps.password.trim())) {
            throw new Exception("Vcenter credentials not loaded");
        }

        ServiceInstance si = null;
        try {
            si = new ServiceInstance(new URL(LoadVcenterProps.url),
                    LoadVcenterProps.userName, LoadVcenterProps.password, true);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        apacheHttpClient = new ApacheHttpClient(LoadVcenterProps.url, true);

        apacheHttpClient.setVimNameSpace(ServiceInstance.VIM25_NAMESPACE);
        apacheHttpClient.setSoapActionOnApiVersion("5.5");
        apacheHttpClient.setCookie(si.getSessionManager().getServerConnection()
                .getVimService().getWsc().getCookie());
    }

    /**
     * This test method will bring all the host systems under particular
     * vCenter.
     */
    @Test
    public void testGetHosts() {

        ObjectContent[] hostSystems = null;
        try {
            hostSystems = (ObjectContent[]) apacheHttpClient.invoke(
                    "RetrieveProperties", buildGetHostsArgs(),
                    "ObjectContent[]");
            if (hostSystems == null) {
                hostSystems = (ObjectContent[]) apacheHttpClient.invoke(
                        "RetrieveProperties", buildGetHostsArgs(),
                        "ObjectContent[]");
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }

        Assert.assertNotNull(hostSystems);
        Assert.assertNotEquals(0, hostSystems.length);
    }

    /**
     * This method will build the request payload.
     * 
     * @return Argument[]
     */
    private Argument[] buildGetHostsArgs() {
        Argument[] paras = new Argument[2];
        SelectionSpec[] selectionSpecs = null;

        ManagedObjectReference mor = new ManagedObjectReference();
        mor.setType("PropertyCollector");
        mor.setVal("propertyCollector");

        selectionSpecs = PropertyCollectorUtil.buildFullTraversalV4();

        // Need to set the vcenter specific details here.
        ManagedObjectReference vcenterMor = new ManagedObjectReference();
        vcenterMor.setType("Folder");
        vcenterMor.setVal("group-d1");

        ObjectSpec os = new ObjectSpec();
        os.setObj(vcenterMor);
        os.setSkip(Boolean.FALSE);
        os.setSelectSet(selectionSpecs);

        String[][] typeinfo = new String[][] { new String[] { "HostSystem",
                "name", }, };
        PropertySpec[] propspecary = PropertyCollectorUtil
                .buildPropertySpecArray(typeinfo);

        PropertyFilterSpec spec = new PropertyFilterSpec();
        spec.setObjectSet(new ObjectSpec[] { os });
        spec.setPropSet(propspecary);

        paras[0] = new Argument("_this", "ManagedObjectReference", mor);
        paras[1] = new Argument("specSet", "PropertyFilterSpec[]",
                new PropertyFilterSpec[] { spec });

        return paras;
    }
}
