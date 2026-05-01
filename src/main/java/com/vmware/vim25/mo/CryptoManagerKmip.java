// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class CryptoManagerKmip extends CryptoManager {

    public CryptoManagerKmip(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public KmipClusterInfo[] getKmipServers() {
        return (KmipClusterInfo[]) getCurrentProperty("kmipServers");
    }

    public String generateClientCsr(KeyProviderId cluster, CryptoManagerKmipCertSignRequest request) throws RuntimeFault, RemoteException {
        return getVimService().generateClientCsr(getMOR(), cluster, request);
    }

    public CryptoKeyResult generateKey(KeyProviderId keyProvider, CryptoManagerKmipCustomAttributeSpec spec, CryptoManagerKmipGenerateKeySpec keySpec) throws RuntimeFault, RemoteException {
        return getVimService().generateKey(getMOR(), keyProvider, spec, keySpec);
    }

    public String generateSelfSignedClientCert(KeyProviderId cluster, CryptoManagerKmipCertSignRequest request) throws RuntimeFault, RemoteException {
        return getVimService().generateSelfSignedClientCert(getMOR(), cluster, request);
    }

    public KeyProviderId getDefaultKmsCluster(ManagedEntity entity, boolean defaultsToParent) throws RuntimeFault, RemoteException {
        return getVimService().getDefaultKmsCluster(getMOR(), entity == null ? null : entity.getMOR(), defaultsToParent);
    }

    public boolean isKmsClusterActive(KeyProviderId cluster) throws InvalidArgument, RuntimeFault, RemoteException {
        return getVimService().isKmsClusterActive(getMOR(), cluster);
    }

    public KmipClusterInfo[] listKmsClusters(boolean includeKmsServers, int managementTypeFilter, int statusFilter) throws RuntimeFault, RemoteException {
        return getVimService().listKmsClusters(getMOR(), includeKmsServers, managementTypeFilter, statusFilter);
    }

    public void markDefault(KeyProviderId clusterId) throws RuntimeFault, RemoteException {
        getVimService().markDefault(getMOR(), clusterId);
    }

    public CryptoManagerKmipCryptoKeyStatus[] queryCryptoKeyStatus(CryptoKeyId[] keyIds, int checkKeyBitMap) throws RuntimeFault, RemoteException {
        return getVimService().queryCryptoKeyStatus(getMOR(), keyIds, checkKeyBitMap);
    }

    public void registerKmipServer(KmipServerSpec server) throws RuntimeFault, RemoteException {
        getVimService().registerKmipServer(getMOR(), server);
    }

    public void registerKmsCluster(KeyProviderId clusterId, String managementType) throws RuntimeFault, RemoteException {
        getVimService().registerKmsCluster(getMOR(), clusterId, managementType);
    }

    public void removeKmipServer(KeyProviderId clusterId, String serverName) throws RuntimeFault, RemoteException {
        getVimService().removeKmipServer(getMOR(), clusterId, serverName);
    }

    public void setDefaultKmsCluster(ManagedEntity entity, KeyProviderId clusterId) throws RuntimeFault, RemoteException {
        getVimService().setDefaultKmsCluster(getMOR(), entity == null ? null : entity.getMOR(), clusterId);
    }

    public CryptoKeyResult setKeyCustomAttributes(CryptoKeyId keyId, CryptoManagerKmipCustomAttributeSpec spec) throws RuntimeFault, RemoteException {
        return getVimService().setKeyCustomAttributes(getMOR(), keyId, spec);
    }

    public void unregisterKmsCluster(KeyProviderId clusterId) throws RuntimeFault, RemoteException {
        getVimService().unregisterKmsCluster(getMOR(), clusterId);
    }

    public void updateKmipServer(KmipServerSpec server) throws RuntimeFault, RemoteException {
        getVimService().updateKmipServer(getMOR(), server);
    }

    public void updateKmsSignedCsrClientCert(KeyProviderId cluster, String certificate) throws RuntimeFault, RemoteException {
        getVimService().updateKmsSignedCsrClientCert(getMOR(), cluster, certificate);
    }

    public void updateSelfSignedClientCert(KeyProviderId cluster, String certificate) throws RuntimeFault, RemoteException {
        getVimService().updateSelfSignedClientCert(getMOR(), cluster, certificate);
    }

    public void uploadClientCert(KeyProviderId cluster, String certificate, String privateKey) throws RuntimeFault, RemoteException {
        getVimService().uploadClientCert(getMOR(), cluster, certificate, privateKey);
    }

    public void uploadKmipServerCert(KeyProviderId cluster, String certificate) throws RuntimeFault, RemoteException {
        getVimService().uploadKmipServerCert(getMOR(), cluster, certificate);
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
