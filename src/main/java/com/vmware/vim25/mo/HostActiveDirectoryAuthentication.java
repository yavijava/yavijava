// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostActiveDirectoryAuthentication extends HostDirectoryStore {

    public HostActiveDirectoryAuthentication(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void disableSmartCardAuthentication() throws ActiveDirectoryFault, HostConfigFault, RuntimeFault, RemoteException {
        getVimService().disableSmartCardAuthentication(getMOR());
    }

    public void enableSmartCardAuthentication() throws ActiveDirectoryFault, HostConfigFault, RuntimeFault, RemoteException {
        getVimService().enableSmartCardAuthentication(getMOR());
    }

    public Task importCertificateForCAM(String certPath, String camServer) throws ActiveDirectoryFault, FileNotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().importCertificateForCAM_Task(getMOR(), certPath, camServer);
        return new Task(getServerConnection(), resultMor);
    }

    public void installSmartCardTrustAnchor(String cert) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().installSmartCardTrustAnchor(getMOR(), cert);
    }

    public Task joinDomain(String domainName, String userName, String password) throws ActiveDirectoryFault, HostConfigFault, InvalidLogin, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().joinDomain_Task(getMOR(), domainName, userName, password);
        return new Task(getServerConnection(), resultMor);
    }

    public Task joinDomainWithCAM(String domainName, String camServer) throws ActiveDirectoryFault, HostConfigFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().joinDomainWithCAM_Task(getMOR(), domainName, camServer);
        return new Task(getServerConnection(), resultMor);
    }

    public Task leaveCurrentDomain(boolean force) throws ActiveDirectoryFault, AuthMinimumAdminPermission, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().leaveCurrentDomain_Task(getMOR(), force);
        return new Task(getServerConnection(), resultMor);
    }

    public void removeSmartCardTrustAnchor(String issuer, String serial) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().removeSmartCardTrustAnchor(getMOR(), issuer, serial);
    }

    public void removeSmartCardTrustAnchorByFingerprint(String fingerprint, String digest) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().removeSmartCardTrustAnchorByFingerprint(getMOR(), fingerprint, digest);
    }

    public void removeSmartCardTrustAnchorCertificate(String certificate) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().removeSmartCardTrustAnchorCertificate(getMOR(), certificate);
    }

    public void replaceSmartCardTrustAnchors(String[] certs) throws RuntimeFault, RemoteException {
        getVimService().replaceSmartCardTrustAnchors(getMOR(), certs);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /**
 * Lists installed trust anchor certificates for smart card authentication.
 *
 * @return SSL certificates of trusted CAs in PEM format.
 * @throws HostConfigFault
 * @throws RuntimeFault
 * @throws RemoteException
 * @since 6.0
 */
public String[] listSmartCardTrustAnchors() throws HostConfigFault, RuntimeFault, RemoteException {
    return getVimService().listSmartCardTrustAnchors(getMOR());
}
    /**
 * Replace the trust anchor certificates for smart card authentication, all existing trust anchors are removed.
 *
 * @throws RuntimeFault
 * @throws RemoteException
 */
public void replaceSmartCardTrustAnchors() throws RuntimeFault, RemoteException {
    replaceSmartCardTrustAnchors(null);
}
    /* ===== END custom ===== */
}
