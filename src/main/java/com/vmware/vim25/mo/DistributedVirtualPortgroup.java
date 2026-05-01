// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class DistributedVirtualPortgroup extends Network {

    public DistributedVirtualPortgroup(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public DVPortgroupConfigInfo getConfig() {
        return (DVPortgroupConfigInfo) getCurrentProperty("config");
    }

    public String getKey() {
        return (String) getCurrentProperty("key");
    }

    public String[] getPortKeys() {
        return (String[]) getCurrentProperty("portKeys");
    }

    public Task reconfigureDVPortgroup_Task(DVPortgroupConfigSpec spec) throws ConcurrentAccess, DuplicateName, DvsFault, InvalidName, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().reconfigureDVPortgroup_Task(getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task dVPortgroupRollback_Task(EntityBackupConfig entityBackup) throws DvsFault, RollbackFailure, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().dVPortgroupRollback_Task(getMOR(), entityBackup);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
