package com.vmware.vim25.mo;

import com.vmware.vim25.*;

import java.rmi.RemoteException;

public class CryptoManagerKmip extends CryptoManager {

    public CryptoManagerKmip(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    public KmipClusterInfo[] getKmipClusterInfo() {
        KmipClusterInfo[] kmipServers = (KmipClusterInfo[]) this.getCurrentProperty("kmipServers");
        return kmipServers;
    }

    /**
     * Generate a certificate signing request with its private .
     */
    public String generateClientCsr(KeyProviderId cluster) throws RuntimeFault, RemoteException {
        return getVimService().generateClientCsr(getMOR(), cluster);
    }

    public CryptoKeyResult generateKey(ManagedObjectReference _this, KeyProviderId keyProvider) throws RuntimeFault, RemoteException {
        return getVimService().generateKey(getMOR(), keyProvider);
    }

    public String generateSelfSignedClientCert(ManagedObjectReference _this, KeyProviderId cluster) throws RuntimeFault, RemoteException {
        return getVimService().generateSelfSignedClientCert(getMOR(), cluster);
    }

    public KmipClusterInfo[] listKmipServers(ManagedObjectReference _this, int limit) throws RuntimeFault, RemoteException {
        return getVimService().listKmipServers(getMOR(), limit);
    }

    public void registerKmipServer(ManagedObjectReference _this, KmipServerSpec server) throws RuntimeFault, RemoteException, InvalidArgument {
        getVimService().registerKmipServer(getMOR(), server);
    }

    public void removeKmipServer(ManagedObjectReference _this, KeyProviderId clusterId, String serverName) throws RuntimeFault, RemoteException, InvalidArgument {
        getVimService().removeKmipServer(getMOR(), clusterId, serverName);
    }

    public String retrieveClientCert(ManagedObjectReference _this, KeyProviderId cluster) throws RuntimeFault, RemoteException {
        return getVimService().retrieveClientCert(getMOR(), cluster);
    }

    public String retrieveClientCsr(ManagedObjectReference _this, KeyProviderId cluster) throws RuntimeFault, RemoteException {
        return getVimService().retrieveClientCsr(getMOR(), cluster);
    }

    public CryptoManagerKmipServerCertInfo retrieveKmipServerCert(ManagedObjectReference _this, KeyProviderId keyProvider, KmipServerInfo server) throws RuntimeFault, RemoteException, InvalidArgument {
        return getVimService().retrieveKmipServerCert(getMOR(), keyProvider, server);
    }

    public ManagedObjectReference retrieveKmipServersStatus_Task(ManagedObjectReference _this, KmipClusterInfo[] clusters) throws RuntimeFault, RemoteException {
        return getVimService().retrieveKmipServersStatus_Task(getMOR(), clusters);
    }

    public String retrieveSelfSignedClientCert(ManagedObjectReference _this, KeyProviderId cluster) throws RuntimeFault, RemoteException {
        return getVimService().retrieveSelfSignedClientCert(getMOR(), cluster);
    }

    public String updateKmipServer(ManagedObjectReference _this, KmipServerSpec server) throws RuntimeFault, RemoteException, InvalidArgument {
        return getVimService().updateKmipServer(getMOR(), server);
    }

    public void updateKmsSignedCsrClientCert(ManagedObjectReference _this, KeyProviderId cluster, String certificate) throws RuntimeFault, RemoteException, InvalidArgument {
        getVimService().updateKmsSignedCsrClientCert(getMOR(), cluster, certificate);
    }

    public void updateSelfSignedClientCert(ManagedObjectReference _this, KeyProviderId cluster, String certificate) throws RuntimeFault, RemoteException, InvalidArgument {
        getVimService().updateSelfSignedClientCert(getMOR(), cluster, certificate);
    }

    public void uploadClientCert(ManagedObjectReference _this, KeyProviderId cluster, String certificate, String privateKey) throws RuntimeFault, RemoteException {
        getVimService().uploadClientCert(getMOR(), cluster, certificate, privateKey);
    }

    public void uploadKmipServerCert(ManagedObjectReference _this, KeyProviderId cluster, String certificate) throws RuntimeFault, RemoteException, InvalidArgument {
        getVimService().uploadKmipServerCert(getMOR(), cluster, certificate);
    }
}
