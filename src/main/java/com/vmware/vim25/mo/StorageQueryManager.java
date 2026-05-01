// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class StorageQueryManager extends ManagedObject {

    public StorageQueryManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostSystem[] queryHostsWithAttachedLun(String lunUuid) throws RuntimeFault, RemoteException {
        ManagedObjectReference[] mors = getVimService().queryHostsWithAttachedLun(getMOR(), lunUuid);
        if (mors == null) return new HostSystem[0];
        HostSystem[] hosts = new HostSystem[mors.length];
        for (int i = 0; i < mors.length; i++) {
            hosts[i] = new HostSystem(getServerConnection(), mors[i]);
        }
        return hosts;
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
