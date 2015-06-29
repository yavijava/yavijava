package com.vmware.vim25.mo;

import com.vmware.vim25.*;

import java.rmi.RemoteException;

/**
 * @since SDK4.1
 */
public class HostActiveDirectoryAuthentication extends HostDirectoryStore {
    public HostActiveDirectoryAuthentication(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    /**
     * @since SDK5.0
     */
    public Task importCertificateForCAM_Task(String certPath, String camServer) throws FileNotFound, ActiveDirectoryFault, RuntimeFault, RemoteException {
        ManagedObjectReference mor = getVimService().importCertificateForCAM_Task(getMOR(), certPath, camServer);
        return new Task(getServerConnection(), mor);
    }

    public Task joinDomain_Task(String domainName, String userName, String password) throws InvalidState, HostConfigFault, InvalidLogin, ActiveDirectoryFault, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference mor = getVimService().joinDomain_Task(getMOR(), domainName, userName, password);
        return new Task(getServerConnection(), mor);
    }

    /**
     * @since SDK5.0
     */
    public Task joinDomainWithCAM_Task(String domainName, String camServer) throws InvalidState, HostConfigFault, ActiveDirectoryFault, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference mor = getVimService().joinDomainWithCAM_Task(getMOR(), domainName, camServer);
        return new Task(getServerConnection(), mor);
    }

    public Task leaveCurrentDomain_Task(boolean force) throws InvalidState, AuthMinimumAdminPermission, ActiveDirectoryFault, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference mor = getVimService().leaveCurrentDomain_Task(getMOR(), force);
        return new Task(getServerConnection(), mor);
    }

    /**
     * Disables console authentication using a local smart card and reader.
     *
     * @throws ActiveDirectoryFault
     * @throws HostConfigFault
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public void disableSmartCardAuthentication() throws ActiveDirectoryFault, HostConfigFault, RuntimeFault, RemoteException {
        getVimService().disableSmartCardAuthentication(getMOR());
    }

    /**
     * Enables console authentication using a local smart card and reader. To take effect this feature requires an
     * active domain membership to a domain with users configured to authenticate using smart cards.
     *
     * @throws ActiveDirectoryFault
     * @throws HostConfigFault
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public void enableSmartCardAuthentication() throws ActiveDirectoryFault, HostConfigFault, RuntimeFault, RemoteException {
        getVimService().disableSmartCardAuthentication(getMOR());
    }

    /**
     * Install a trust anchor certificate for smart card authentication.
     *
     * @param cert SSL certificate in PEM format
     * @throws HostConfigFault
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public void installSmartCardTrustAnchor(String cert) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().installSmartCardTrustAnchor(getMOR(), cert);
    }

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
     * Remove a smart card trust anchor certificate from the system.
     *
     * @param issuer Certificate issuer
     * @param serial Certificate serial number (decimal integer)
     * @throws HostConfigFault
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     * @deprecated Please remove by fingerprint/digest instead.
     */
    public void removeSmartCardTrustAnchor(String issuer, String serial) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().removeSmartCardTrustAnchor(getMOR(), issuer, serial);
    }

    /**
     * Remove a smart card trust anchor certificate from the system by fingerprint.
     *
     * @param fingerprint Certificate fingerprint
     * @param digest      Digest function used to compute fingerprint. One of {@link com.vmware.vim25.HostActiveDirectoryAuthenticationCertificateDigest}.
     * @throws HostConfigFault
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public void removeSmartCardTrustAnchorByFingerprint(String fingerprint, String digest) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().removeSmartCardTrustAnchorByFingerprint(getMOR(), fingerprint, digest);
    }

    /**
     * Replace the trust anchor certificates for smart card authentication.
     *
     * @param certs List of trusted CA certificates in PEM format.
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public void replaceSmartCardTrustAnchors(String[] certs) throws RuntimeFault, RemoteException {
        getVimService().replaceSmartCardTrustAnchors(getMOR(), certs);
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
}
