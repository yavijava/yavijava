// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class DistributedVirtualSwitchManager extends ManagedObject {

    public DistributedVirtualSwitchManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public DVSManagerPhysicalNicsList[] queryCompatibleVmnicsFromHosts(HostSystem[] hosts, DistributedVirtualSwitch dvs) throws RuntimeFault, RemoteException {
        return getVimService().queryCompatibleVmnicsFromHosts(getMOR(), hosts == null ? null : MorUtil.createMORs(hosts), dvs == null ? null : dvs.getMOR());
    }

    public DistributedVirtualSwitchNetworkOffloadSpec[] querySupportedNetworkOffloadSpec(DistributedVirtualSwitchProductSpec switchProductSpec) throws RuntimeFault, RemoteException {
        return getVimService().querySupportedNetworkOffloadSpec(getMOR(), switchProductSpec);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /** @since SDK5.1 */
    public Task dVSManagerExportEntity_Task(SelectionSet[] selectionSet) throws BackupBlobWriteFailure, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().dVSManagerExportEntity_Task(getMOR(), selectionSet);
        return new Task(getServerConnection(), taskMor);
    }
    /** @since SDK5.1 */
    public Task dVSManagerImportEntity_Task(EntityBackupConfig[] entityBackup, String importType) throws DvsFault, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().dVSManagerImportEntity_Task(getMOR(), entityBackup, importType);
        return new Task(getServerConnection(), taskMor);
    }
    public DistributedVirtualSwitchProductSpec[] queryAvailableDvsSpec() throws RuntimeFault, RemoteException {
    return queryAvailableDvsSpec(null);
}
    /**
 * This operation returns a list of switch product specifications that are supported by the vCenter Server.
 *
 * @param recommended If set to true, return only the recommened versions. If set to false, return only the not recommended versions. If unset, return all supported versions.
 * @return DistributedVirtualSwitchProductSpec[]
 * @throws RuntimeFault
 * @throws RemoteException
 * @since 6.0
 */
public DistributedVirtualSwitchProductSpec[] queryAvailableDvsSpec(Boolean recommended) throws RuntimeFault, RemoteException {
    return getVimService().queryAvailableDvsSpec(getMOR(), recommended);
}
    public HostSystem[] queryCompatibleHostForExistingDvs(ManagedEntity container, boolean recursive, DistributedVirtualSwitch dvs) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = getVimService().queryCompatibleHostForExistingDvs(getMOR(), container.getMOR(), recursive, dvs.getMOR());
    HostSystem[] hosts = new HostSystem[mors.length];
    for (int i = 0; i < hosts.length; i++) {
        hosts[i] = new HostSystem(getServerConnection(), mors[i]);
    }
    return hosts;
}
    public HostSystem[] queryCompatibleHostForNewDvs(ManagedEntity container, boolean recursive, DistributedVirtualSwitchProductSpec switchProductSpec) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = getVimService().queryCompatibleHostForNewDvs(getMOR(), container.getMOR(), recursive, switchProductSpec);
    HostSystem[] hosts = new HostSystem[mors.length];
    for (int i = 0; i < hosts.length; i++) {
        hosts[i] = new HostSystem(getServerConnection(), mors[i]);
    }
    return hosts;
}
    public DistributedVirtualSwitchHostProductSpec[] queryDvsCompatibleHostSpec(DistributedVirtualSwitchProductSpec switchProductSpec) throws RuntimeFault, RemoteException {
    return getVimService().queryDvsCompatibleHostSpec(getMOR(), switchProductSpec);
}
    /**
 * @since SDK4.1
 */
public DistributedVirtualSwitchManagerCompatibilityResult[] queryDvsCheckCompatibility(DistributedVirtualSwitchManagerHostContainer hostContainer, DistributedVirtualSwitchManagerDvsProductSpec dvsProductSpec, DistributedVirtualSwitchManagerHostDvsFilterSpec[] hostFilterSpec) throws RuntimeFault, RemoteException {
    return getVimService().queryDvsCheckCompatibility(getMOR(), hostContainer, dvsProductSpec, hostFilterSpec);
}
    public DVSManagerDvsConfigTarget queryDvsConfigTarget(HostSystem host, DistributedVirtualSwitch dvs) throws RuntimeFault, RemoteException {
    return getVimService().queryDvsConfigTarget(getMOR(), host == null ? null : host.getMOR(), dvs == null ? null : dvs.getMOR());
}
    /**
 * @since SDK4.1
 */
public DVSFeatureCapability queryDvsFeatureCapability(DistributedVirtualSwitchProductSpec switchProductSpec) throws RuntimeFault, RemoteException {
    return getVimService().queryDvsFeatureCapability(getMOR(), switchProductSpec);
}
    /**
 * @since SDK5.0
 */
public Task rectifyDvsOnHost_Task(HostSystem[] hosts) throws DvsFault, RuntimeFault, RemoteException {
    ManagedObjectReference[] hostMors = MorUtil.createMORs(hosts);
    ManagedObjectReference taskMor = getVimService().rectifyDvsOnHost_Task(getMOR(), hostMors);
    return new Task(getServerConnection(), taskMor);
}
    public DistributedVirtualPortgroup lookupDvPortGroup(String portgroupKey) throws NotFound, RuntimeFault, RemoteException {
    ManagedObjectReference resultMor = getVimService().lookupDvPortGroup(getMOR(), portgroupKey);
    return new DistributedVirtualPortgroup(getServerConnection(), resultMor);
}
    public DistributedVirtualSwitch queryDvsByUuid(String uuid) throws NotFound, RuntimeFault, RemoteException {
    ManagedObjectReference resultMor = getVimService().queryDvsByUuid(getMOR(), uuid);
    return new DistributedVirtualSwitch(getServerConnection(), resultMor);
}
    /**
     * Look up a DVPortgroup by switch UUID + portgroup key. This is a distinct
     * SOAP operation from {@link #lookupDvPortGroup(String)} (which looks up by
     * portgroup key only within the current scope).
     */
    public DistributedVirtualPortgroup dVSManagerLookupDvPortGroup(String switchUuid, String portgroupKey) throws NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference mor = getVimService().dVSManagerLookupDvPortGroup(getMOR(), switchUuid, portgroupKey);
        return new DistributedVirtualPortgroup(getServerConnection(), mor);
    }
    /* ===== END custom ===== */
}
