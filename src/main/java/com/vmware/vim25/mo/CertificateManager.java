// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.SystemError;
/* ===== END custom imports ===== */

public class CertificateManager extends ManagedObject {

    public CertificateManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public Task refreshCACertificatesAndCRLs(HostSystem[] host) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().certMgrRefreshCACertificatesAndCRLs_Task(getMOR(), host == null ? null : MorUtil.createMORs(host));
        return new Task(getServerConnection(), resultMor);
    }

    public Task refreshCertificates(HostSystem[] host) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().certMgrRefreshCertificates_Task(getMOR(), host == null ? null : MorUtil.createMORs(host));
        return new Task(getServerConnection(), resultMor);
    }

    public Task revokeCertificates(HostSystem[] host) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().certMgrRevokeCertificates_Task(getMOR(), host == null ? null : MorUtil.createMORs(host));
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
