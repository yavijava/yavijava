// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.HostCertificateManagerCertificateInfo;
import com.vmware.vim25.HostConfigFault;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class HostCertificateManager extends ManagedObject {

    public HostCertificateManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostCertificateManagerCertificateInfo getCertificateInfo() {
        return (HostCertificateManagerCertificateInfo) getCurrentProperty("certificateInfo");
    }

    public String generateCertificateSigningRequest(boolean useIpAddressAsCommonName, HostCertificateManagerCertificateSpec spec) throws HostConfigFault, RuntimeFault, RemoteException {
        return getVimService().generateCertificateSigningRequest(getMOR(), useIpAddressAsCommonName, spec);
    }

    public String generateCertificateSigningRequestByDn(String distinguishedName, HostCertificateManagerCertificateSpec spec) throws HostConfigFault, RuntimeFault, RemoteException {
        return getVimService().generateCertificateSigningRequestByDn(getMOR(), distinguishedName, spec);
    }

    public void installServerCertificate(String cert) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().installServerCertificate(getMOR(), cert);
    }

    public void notifyAffectedServices(String[] services) throws RuntimeFault, RemoteException {
        getVimService().notifyAffectedServices(getMOR(), services);
    }

    public void provisionServerPrivateKey(String key) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().provisionServerPrivateKey(getMOR(), key);
    }

    public void replaceCACertificatesAndCRLs(String[] caCert, String[] caCrl) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().replaceCACertificatesAndCRLs(getMOR(), caCert, caCrl);
    }

    public HostCertificateManagerCertificateInfo[] retrieveCertificateInfoList() throws RuntimeFault, RemoteException {
        return getVimService().retrieveCertificateInfoList(getMOR());
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /**
 * Requests the server to generate a certificate-signing request (CSR) for itself. The CSR is then typically
 * provided to a Certificate Authority to sign and issue the SSL certificate for the server. Use
 * InstallServerCertificate to install this certificate.
 *
 * @param useIpAddressAsCommonName if true, use host's management IP address as CN in the CSR; otherwise use host's FQDN
 * @return CSR in PEM format
 * @throws HostConfigFault
 * @throws RuntimeFault
 * @throws RemoteException
 */
public String generateCertificateSigningRequest(boolean useIpAddressAsCommonName) throws HostConfigFault, RuntimeFault, RemoteException {
    return getVimService().generateCertificateSigningRequest(getMOR(), useIpAddressAsCommonName, null);
}
    /**
 * Requests the server to generate a certificate-signing request (CSR) for itself. Alternative version similar to
 * GenerateCertificateSigningRequest but takes a Distinguished Name (DN) as a parameter.
 *
 * @param distinguishedName DN to be used as subject in CSR.
 * @return CSR in PEM format
 * @throws HostConfigFault
 * @throws RuntimeFault
 * @throws RemoteException
 */
public String generateCertificateSigningRequestByDn(String distinguishedName) throws HostConfigFault, RuntimeFault, RemoteException {
    return getVimService().generateCertificateSigningRequestByDn(getMOR(), distinguishedName, null);
}
    /**
 * Fetches the SSL CRLs of Certificate Authorities that are trusted.
 *
 * @return SSL CRLs of trusted CAs in PEM format
 * @throws HostConfigFault
 * @throws RuntimeFault
 * @throws RemoteException
 */
public String[] listCACertificateRevocationLists() throws HostConfigFault, RuntimeFault, RemoteException {
    return getVimService().listCACertificateRevocationLists(getMOR());
}
    /**
 * Fetches the SSL certificates of Certificate Authorities that are trusted.
 *
 * @return SSL certificates of trusted CAs in PEM format
 * @throws HostConfigFault
 * @throws RuntimeFault
 * @throws RemoteException
 */
public String[] listCACertificates() throws HostConfigFault, RuntimeFault, RemoteException {
    return getVimService().listCACertificates(getMOR());
}
    /**
 * Replaces the trusted Certificate Authority (CA) certificates and Certification Revocation List (CRL) used by the
 * server with the provided values. These determine whether the server can verify the identity of an external entity.
 *
 * @param caCert List of SSL certificates, in PEM format, of all CAs that should be trusted
 * @throws HostConfigFault
 * @throws RuntimeFault
 * @throws RemoteException
 */
public void replaceCACertificatesAndCRLs(String[] caCert) throws HostConfigFault, RuntimeFault, RemoteException {
    replaceCACertificatesAndCRLs(caCert, null);
}
    /* ===== END custom ===== */
}
