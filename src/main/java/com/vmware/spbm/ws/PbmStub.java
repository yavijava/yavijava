package com.vmware.spbm.ws;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;

import com.vmware.vim25.ManagedObjectReference;
import com.vmware.spbm.PbmCapabilityVendorNamespaceInfo;
import com.vmware.spbm.PbmProfileResourceType;
import com.vmware.spbm.PbmServiceInstanceContent;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.ws.Argument;
import com.vmware.vim25.ws.Client;
import com.vmware.vim25.ws.ClientCreator;

/**
 * @author Atoka Sema
 */

public class PbmStub {

    private Client wsc = null;
    /**
     * Setup logger
     */
    private static Logger log = Logger.getLogger(PbmStub.class);

    public PbmStub(String url, boolean ignoreCert) throws java.net.MalformedURLException {
        try {
            this.wsc = ClientCreator.getClient(url, ignoreCert);
        } catch (NoSuchMethodException e) {
            log.error("Error detected for url: " + url + " ignoreSSL: " + ignoreCert, e);
        } catch (IllegalAccessException e) {
            log.error("Error detected for url: " + url + " ignoreSSL: " + ignoreCert, e);
        } catch (InvocationTargetException e) {
            log.error("Error detected for url: " + url + " ignoreSSL: " + ignoreCert, e);
        } catch (InstantiationException e) {
            log.error("Error detected for url: " + url + " ignoreSSL: " + ignoreCert, e);
        }
    }

    public PbmStub(Client wsc) {
        this.wsc = wsc;
    }

    public Client getWsc() {
        return wsc;
    }

    public PbmServiceInstanceContent retrievePbmServiceInstanceContent(ManagedObjectReference _this)
                    throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (PbmServiceInstanceContent) getWsc().invoke("PbmRetrieveServiceContent", paras,
                        "PbmServiceInstanceContent");
    }

    public PbmCapabilityVendorNamespaceInfo[] pbmFetchVendorInfo(ManagedObjectReference _this,
                    PbmProfileResourceType resourceType) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("resourceType", "PbmProfileResourceType", resourceType);
        return (PbmCapabilityVendorNamespaceInfo[]) getWsc().invoke("PbmFetchVendorInfo", paras,
                        "PbmCapabilityVendorNamespaceInfo[]");
    }

    public PbmProfileResourceType[] pbmFetchResourceType(ManagedObjectReference _this) throws java.rmi.RemoteException,
                    RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (PbmProfileResourceType[]) getWsc().invoke("PbmFetchResourceType", paras, "PbmProfileResourceType[]");
    }

}
