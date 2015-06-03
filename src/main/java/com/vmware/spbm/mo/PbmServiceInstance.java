package com.vmware.spbm.mo;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import com.vmware.vim25.ManagedObjectReference;
import com.vmware.spbm.PbmPortType;
import com.vmware.spbm.PbmServiceInstanceContent;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.ws.SoapClient;

/**
 * @author Atoka Sema
 */

public class PbmServiceInstance extends PbmManagedObject {
    private PbmServiceInstanceContent pbmServiceContent = null;
    final static ManagedObjectReference SERVICE_INSTANCE_MOR;
    public final static String PBM_NAMESPACE = " xmlns=\"urn:pbm\">";

    static {
        SERVICE_INSTANCE_MOR = new ManagedObjectReference();
        SERVICE_INSTANCE_MOR.val = "ServiceInstance";
        SERVICE_INSTANCE_MOR.type = "PbmServiceInstance";
    }

    public PbmServiceInstance(URL url, String sessionStr, boolean ignoreCert) throws RemoteException,
                    MalformedURLException {
        this(url, sessionStr, ignoreCert, PBM_NAMESPACE);
    }

    public PbmServiceInstance(URL url, String sessionStr, boolean ignoreCert, String namespace) throws RemoteException,
                    MalformedURLException {
        if (url == null || sessionStr == null) {
            throw new NullPointerException("None of url, session string can be null.");
        }

        setMOR(SERVICE_INSTANCE_MOR);

        PbmPortType pbmService = new PbmPortType(url.toString(), ignoreCert);
        SoapClient wsc = (SoapClient) pbmService.getWsc();
        wsc.setCookie(sessionStr);
        wsc.setVimNameSpace(namespace);
        wsc.soapAction = "urn:pbm/2.0";
        pbmServiceContent = pbmService.retrievePbmServiceInstanceContent(SERVICE_INSTANCE_MOR);
        setPbmServerConnection(new PbmServerConnection(url, pbmService, this));
    }

    public PbmServiceInstance(PbmServerConnection sc) {
        super(sc, SERVICE_INSTANCE_MOR);
    }

    private PbmServiceInstanceContent retrievePbmServiceInstanceContent() throws RuntimeFault, RemoteException {
        return getPbmService().retrievePbmServiceInstanceContent(getMOR());
    }

    public PbmServiceInstanceContent getPbmServiceInstanceContent() {
        if (pbmServiceContent == null) {
            try {
                pbmServiceContent = retrievePbmServiceInstanceContent();
            } catch (Exception e) {
                System.out.println("Exceptoin: " + e);
            }
        }
        return pbmServiceContent;
    }

    public PbmProfileProfileManager getProfileManager() {
        return (PbmProfileProfileManager) createMO(getPbmServiceInstanceContent().profileManager);
    }

    private PbmManagedObject createMO(ManagedObjectReference mor) {
        return PbmMorUtil.createExactManagedObject(getPbmServerConnection(), mor);
    }
}
