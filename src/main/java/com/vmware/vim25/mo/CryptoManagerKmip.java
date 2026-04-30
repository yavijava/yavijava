// auto generated using yavijava_generator
package com.vmware.vim25.mo;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */


import com.vmware.vim25.*;
import java.rmi.RemoteException;
import java.util.Calendar;

public class CryptoManagerKmip extends CryptoManager {

    public CryptoManagerKmip(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    public void registerKmipServer(KmipServerSpec server) throws RuntimeFault, RemoteException, InvalidArgument {
        getVimService().registerKmipServer(getMOR(), server);
    }

    public void removeKmipServer(KeyProviderId clusterId, String serverName) throws RuntimeFault, RemoteException, InvalidArgument {
        getVimService().removeKmipServer(getMOR(), clusterId, serverName);
    }

    public void updateKmipServer(KmipServerSpec server) throws RuntimeFault, RemoteException, InvalidArgument {
        getVimService().updateKmipServer(getMOR(), server);
    }

    public void updateKmsSignedCsrClientCert(KeyProviderId cluster, String certificate) throws RuntimeFault, RemoteException, InvalidArgument {
        getVimService().updateKmsSignedCsrClientCert(getMOR(), cluster, certificate);
    }

    public void updateSelfSignedClientCert(KeyProviderId cluster, String certificate) throws RuntimeFault, RemoteException, InvalidArgument {
        getVimService().updateSelfSignedClientCert(getMOR(), cluster, certificate);
    }

    public void uploadClientCert(KeyProviderId cluster, String certificate, String privateKey) throws RuntimeFault, RemoteException {
        getVimService().uploadClientCert(getMOR(), cluster, certificate, privateKey);
    }

    public void uploadKmipServerCert(KeyProviderId cluster, String certificate) throws RuntimeFault, RemoteException, InvalidArgument {
        getVimService().uploadKmipServerCert(getMOR(), cluster, certificate);
    }

    public void markDefault(KeyProviderId clusterId) throws RuntimeFault, RemoteException, InvalidArgument {
        getVimService().markDefault(getMOR(), clusterId);
    }
    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public KmipClusterInfo[] getKmipClusterInfo() {
    KmipClusterInfo[] kmipServers = (KmipClusterInfo[]) this.getCurrentProperty("kmipServers");
    return kmipServers;
}
    /**
 * Generate a certificate signing request with its private .
 */
public String generateClientCsr(KeyProviderId cluster) throws RuntimeFault, RemoteException {
    return getVimService().generateClientCsr(getMOR(), cluster, null);
}
    public CryptoKeyResult generateKey(KeyProviderId keyProvider) throws RuntimeFault, RemoteException {
    return getVimService().generateKey(getMOR(), keyProvider, null, null);
}
    public String generateSelfSignedClientCert(KeyProviderId cluster) throws RuntimeFault, RemoteException {
    return getVimService().generateSelfSignedClientCert(getMOR(), cluster, null);
}
    public KmipClusterInfo[] listKmipServers(int limit) throws RuntimeFault, RemoteException {
    return getVimService().listKmipServers(getMOR(), limit);
}
    public String retrieveClientCert(KeyProviderId cluster) throws RuntimeFault, RemoteException {
    return getVimService().retrieveClientCert(getMOR(), cluster);
}
    public String retrieveClientCsr(KeyProviderId cluster) throws RuntimeFault, RemoteException {
    return getVimService().retrieveClientCsr(getMOR(), cluster);
}
    public CryptoManagerKmipServerCertInfo retrieveKmipServerCert(KeyProviderId keyProvider, KmipServerInfo server) throws RuntimeFault, RemoteException, InvalidArgument {
    return getVimService().retrieveKmipServerCert(getMOR(), keyProvider, server);
}
    public ManagedObjectReference retrieveKmipServersStatus_Task(KmipClusterInfo[] clusters) throws RuntimeFault, RemoteException {
    return getVimService().retrieveKmipServersStatus_Task(getMOR(), clusters);
}
    public String retrieveSelfSignedClientCert(KeyProviderId cluster) throws RuntimeFault, RemoteException {
    return getVimService().retrieveSelfSignedClientCert(getMOR(), cluster);
}
    /* ===== END custom ===== */
}
