// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class DistributedVirtualSwitch extends ManagedEntity {

    public DistributedVirtualSwitch(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public DVSCapability getCapability() {
        return (DVSCapability) getCurrentProperty("capability");
    }

    public DVSConfigInfo getConfig() {
        return (DVSConfigInfo) getCurrentProperty("config");
    }

    public DVSNetworkResourcePool[] getNetworkResourcePool() {
        return (DVSNetworkResourcePool[]) getCurrentProperty("networkResourcePool");
    }

    public DVSRuntimeInfo getRuntime() {
        return (DVSRuntimeInfo) getCurrentProperty("runtime");
    }

    public DVSSummary getSummary() {
        return (DVSSummary) getCurrentProperty("summary");
    }

    public String getUuid() {
        return (String) getCurrentProperty("uuid");
    }

    public void addNetworkResourcePool(DVSNetworkResourcePoolConfigSpec[] configSpec) throws DvsFault, InvalidName, RuntimeFault, RemoteException {
        getVimService().addNetworkResourcePool(getMOR(), configSpec);
    }

    public Task addDVPortgroup_Task(DVPortgroupConfigSpec spec) throws DuplicateName, DvsFault, InvalidName, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().addDVPortgroup_Task(getMOR(), new DVPortgroupConfigSpec[]{spec});
        return new Task(getServerConnection(), resultMor);
    }

    public Task addDVPortgroups_Task(DVPortgroupConfigSpec[] spec) throws DuplicateName, DvsFault, InvalidName, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().addDVPortgroup_Task(getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public void enableNetworkResourceManagement(boolean enable) throws DvsFault, RuntimeFault, RemoteException {
        getVimService().enableNetworkResourceManagement(getMOR(), enable);
    }

    public DistributedVirtualPortgroup lookupDvPortGroup(String portgroupKey) throws NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().lookupDvPortGroup(getMOR(), portgroupKey);
        return new DistributedVirtualPortgroup(getServerConnection(), resultMor);
    }

    public Task mergeDvs_Task(DistributedVirtualSwitch dvs) throws DvsFault, InvalidHostState, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().mergeDvs_Task(getMOR(), dvs == null ? null : dvs.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task moveDVPort_Task(String[] portKey, String destinationPortgroupKey) throws ConcurrentAccess, DvsFault, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().moveDVPort_Task(getMOR(), portKey, destinationPortgroupKey);
        return new Task(getServerConnection(), resultMor);
    }

    public Task performDvsProductSpecOperation_Task(String operation, DistributedVirtualSwitchProductSpec productSpec) throws DvsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().performDvsProductSpecOperation_Task(getMOR(), operation, productSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task reconfigureDvs_Task(DVSConfigSpec spec) throws AlreadyExists, ConcurrentAccess, DuplicateName, DvsFault, DvsNotAuthorized, InvalidName, InvalidState, LimitExceeded, NotFound, ResourceInUse, ResourceNotAvailable, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().reconfigureDvs_Task(getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task reconfigureDVPort_Task(DVPortConfigSpec[] port) throws ConcurrentAccess, DvsFault, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().reconfigureDVPort_Task(getMOR(), port);
        return new Task(getServerConnection(), resultMor);
    }

    public Task dvsReconfigureVmVnicNetworkResourcePool_Task(DvsVmVnicResourcePoolConfigSpec[] configSpec) throws ConcurrentAccess, ConflictingConfiguration, DvsFault, InvalidName, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().dvsReconfigureVmVnicNetworkResourcePool_Task(getMOR(), configSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public void refreshDVPortState(String[] portKeys) throws DvsFault, NotFound, RuntimeFault, RemoteException {
        getVimService().refreshDVPortState(getMOR(), portKeys);
    }

    public void removeNetworkResourcePool(String[] key) throws DvsFault, InvalidName, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().removeNetworkResourcePool(getMOR(), key);
    }

    public Task dVSRollback_Task(EntityBackupConfig entityBackup) throws DvsFault, RollbackFailure, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().dVSRollback_Task(getMOR(), entityBackup);
        return new Task(getServerConnection(), resultMor);
    }

    public void updateDvsCapability(DVSCapability capability) throws DvsFault, RuntimeFault, RemoteException {
        getVimService().updateDvsCapability(getMOR(), capability);
    }

    public Task updateDVSHealthCheckConfig_Task(DVSHealthCheckConfig[] healthCheckConfig) throws DvsFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().updateDVSHealthCheckConfig_Task(getMOR(), healthCheckConfig);
        return new Task(getServerConnection(), resultMor);
    }

    public void updateNetworkResourcePool(DVSNetworkResourcePoolConfigSpec[] configSpec) throws ConcurrentAccess, DvsFault, InvalidName, NotFound, RuntimeFault, RemoteException {
        getVimService().updateNetworkResourcePool(getMOR(), configSpec);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public DistributedVirtualPortgroup[] getPortgroup() {
    ManagedObjectReference[] pgMors = (ManagedObjectReference[]) getCurrentProperty("portgroup");
    if (pgMors == null) {
        return new DistributedVirtualPortgroup[] {};
    }
    DistributedVirtualPortgroup[] dvpgs = new DistributedVirtualPortgroup[pgMors.length];
    for (int i = 0; i < pgMors.length; i++) {
        dvpgs[i] = new DistributedVirtualPortgroup(getServerConnection(), pgMors[i]);
    }
    return dvpgs;
}
    public String[] fetchDVPortKeys(DistributedVirtualSwitchPortCriteria criteria) throws RuntimeFault, RemoteException {
    return getVimService().fetchDVPortKeys(getMOR(), criteria);
}
    public DistributedVirtualPort[] fetchDVPorts(DistributedVirtualSwitchPortCriteria criteria) throws RuntimeFault, RemoteException {
    return getVimService().fetchDVPorts(getMOR(), criteria);
}
    public int[] queryUsedVlanIdInDvs() throws RuntimeFault, RemoteException {
    return getVimService().queryUsedVlanIdInDvs(getMOR());
}
    public Task rectifyDvsHost_Task(HostSystem[] hosts) throws DvsFault, NotFound, RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = MorUtil.createMORs(hosts);
    ManagedObjectReference mor = getVimService().rectifyDvsHost_Task(getMOR(), mors);
    return new Task(getServerConnection(), mor);
}
    /* ===== END custom ===== */
}
