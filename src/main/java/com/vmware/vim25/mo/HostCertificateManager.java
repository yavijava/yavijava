package com.vmware.vim25.mo;

import com.vmware.vim25.HostCertificateManagerCertificateInfo;
import com.vmware.vim25.HostConfigFault;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;

import java.rmi.RemoteException;

/**
 * Copyright 2015 Michael Rice &lt;michael@michaelrice.org&gt;
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @since 6.0
 */
public class HostCertificateManager extends ManagedObject {

    public HostCertificateManager(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    public HostCertificateManagerCertificateInfo getCertificateInfo() {
        return (HostCertificateManagerCertificateInfo) getCurrentProperty("certificateInfo");
    }

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
        return getVimService().generateCertificateSigningRequest(getMOR(), useIpAddressAsCommonName);
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
        return getVimService().generateCertificateSigningRequestByDn(getMOR(), distinguishedName);
    }

    /**
     * Installs a given SSL certificate on the server.
     *
     * @param cert SSL certificate in PEM format
     * @throws HostConfigFault
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public void installServerCertificate(String cert) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().installServerCertificate(getMOR(), cert);
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
     * @param caCrl  List of SSL CRLs, in PEM format, issued by trusted CAs from the above list
     * @throws HostConfigFault
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public void replaceCACertificatesAndCRLs(String[] caCert, String[] caCrl) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().replaceCACertificatesAndCRLs(getMOR(), caCert, caCrl);
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
}
