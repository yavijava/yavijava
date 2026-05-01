// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostSpecificationManager extends ManagedObject {

    public HostSpecificationManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void deleteHostSpecification(HostSystem host) throws HostSpecificationOperationFailed, RuntimeFault, RemoteException {
        getVimService().deleteHostSpecification(getMOR(), host == null ? null : host.getMOR());
    }

    public void deleteHostSubSpecification(HostSystem host, String subSpecName) throws HostSpecificationOperationFailed, RuntimeFault, RemoteException {
        getVimService().deleteHostSubSpecification(getMOR(), host == null ? null : host.getMOR(), subSpecName);
    }

    public HostSystem[] getUpdatedHosts(String startChangeID, String endChangeID) throws RuntimeFault, RemoteException {
        ManagedObjectReference[] mors = getVimService().hostSpecGetUpdatedHosts(getMOR(), startChangeID, endChangeID);
        if (mors == null) return new HostSystem[0];
        HostSystem[] hosts = new HostSystem[mors.length];
        for (int i = 0; i < mors.length; i++) {
            hosts[i] = new HostSystem(getServerConnection(), mors[i]);
        }
        return hosts;
    }

    public HostSpecification retrieveHostSpecification(HostSystem host, boolean fromHost) throws HostSpecificationOperationFailed, RuntimeFault, RemoteException {
        return getVimService().retrieveHostSpecification(getMOR(), host == null ? null : host.getMOR(), fromHost);
    }

    public void updateHostSpecification(HostSystem host, HostSpecification hostSpec) throws HostSpecificationOperationFailed, RuntimeFault, RemoteException {
        getVimService().updateHostSpecification(getMOR(), host == null ? null : host.getMOR(), hostSpec);
    }

    public void updateHostSubSpecification(HostSystem host, HostSubSpecification hostSubSpec) throws HostSpecificationOperationFailed, RuntimeFault, RemoteException {
        getVimService().updateHostSubSpecification(getMOR(), host == null ? null : host.getMOR(), hostSubSpec);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
