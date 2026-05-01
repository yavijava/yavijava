// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class Folder extends ManagedEntity {

    public Folder(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public String[] getChildType() {
        return (String[]) getCurrentProperty("childType");
    }

    public FolderExternallyManagedFolderInfo getExternallyManagedFolderInfo() {
        return (FolderExternallyManagedFolderInfo) getCurrentProperty("externallyManagedFolderInfo");
    }

    public String getNamespace() {
        return (String) getCurrentProperty("namespace");
    }

    public Task addStandaloneHost(HostConnectSpec spec, ComputeResourceConfigSpec compResSpec, boolean addConnected, String license) throws DuplicateName, HostConnectFault, InvalidLogin, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().addStandaloneHost_Task(getMOR(), spec, compResSpec, addConnected, license);
        return new Task(getServerConnection(), resultMor);
    }

    public Task batchAddHostsToCluster(ClusterComputeResource cluster, FolderNewHostSpec[] newHosts, HostSystem[] existingHosts, ComputeResourceConfigSpec compResSpec, String desiredState) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().batchAddHostsToCluster_Task(getMOR(), cluster == null ? null : cluster.getMOR(), newHosts, existingHosts == null ? null : MorUtil.createMORs(existingHosts), compResSpec, desiredState);
        return new Task(getServerConnection(), resultMor);
    }

    public Task batchAddStandaloneHosts(FolderNewHostSpec[] newHosts, ComputeResourceConfigSpec compResSpec, boolean addConnected) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().batchAddStandaloneHosts_Task(getMOR(), newHosts, compResSpec, addConnected);
        return new Task(getServerConnection(), resultMor);
    }

    public Task createDistributedVirtualSwitch(DVSCreateSpec spec) throws DuplicateName, DvsFault, DvsNotAuthorized, InvalidName, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createDVS_Task(getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public StoragePod createStoragePod(String name) throws DuplicateName, InvalidName, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createStoragePod(getMOR(), name);
        return new StoragePod(getServerConnection(), resultMor);
    }

    public Task createVm(VirtualMachineConfigSpec config, ResourcePool pool, HostSystem host) throws AlreadyExists, DuplicateName, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidName, InvalidState, OutOfBounds, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createVM_Task(getMOR(), config, pool == null ? null : pool.getMOR(), host == null ? null : host.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task moveInto(ManagedEntity[] list) throws DuplicateName, InvalidFolder, InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().moveIntoFolder_Task(getMOR(), list == null ? null : MorUtil.createMORs(list));
        return new Task(getServerConnection(), resultMor);
    }

    public Task registerVm(String path, String name, boolean asTemplate, ResourcePool pool, HostSystem host) throws AlreadyExists, DuplicateName, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidName, InvalidState, NotFound, OutOfBounds, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().registerVM_Task(getMOR(), path, name, asTemplate, pool == null ? null : pool.getMOR(), host == null ? null : host.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task unregisterAndDestroy() throws ConcurrentAccess, InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().unregisterAndDestroy_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    // the array could have different real types, therefore cannot use getManagedObjects()
public ManagedEntity[] getChildEntity() throws InvalidProperty, RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = (ManagedObjectReference[]) getCurrentProperty("childEntity");
    ;
    if (mors == null) {
        return new ManagedEntity[] {};
    }
    ManagedEntity[] mes = new ManagedEntity[mors.length];
    for (int i = 0; i < mors.length; i++) {
        mes[i] = MorUtil.createExactManagedEntity(getServerConnection(), mors[i]);
    }
    return mes;
}
    // SDK2.5 signature for back compatibility
public Task addStandaloneHost_Task(HostConnectSpec spec, ComputeResourceConfigSpec compResSpec, boolean addConnected) throws InvalidLogin, HostConnectFault, RuntimeFault, RemoteException {
    return addStandaloneHost_Task(spec, compResSpec, addConnected, null);
}
    // new 4.0 signature
public Task addStandaloneHost_Task(HostConnectSpec spec, ComputeResourceConfigSpec compResSpec, boolean addConnected, String license) throws InvalidLogin, HostConnectFault, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().addStandaloneHost_Task(getMOR(), spec, compResSpec, addConnected, license));
}
    public ClusterComputeResource createCluster(String name, ClusterConfigSpec spec) throws InvalidName, DuplicateName, RuntimeFault, RemoteException {
    return new ClusterComputeResource(getServerConnection(), getVimService().createCluster(getMOR(), name, spec));
}
    public ClusterComputeResource createClusterEx(String name, ClusterConfigSpecEx spec) throws InvalidName, DuplicateName, RuntimeFault, RemoteException {
    return new ClusterComputeResource(getServerConnection(), getVimService().createClusterEx(getMOR(), name, spec));
}
    public Datacenter createDatacenter(String name) throws InvalidName, DuplicateName, RuntimeFault, RemoteException {
    return new Datacenter(getServerConnection(), getVimService().createDatacenter(getMOR(), name));
}
    public Folder createFolder(String name) throws InvalidName, DuplicateName, RuntimeFault, RemoteException {
    return new Folder(getServerConnection(), getVimService().createFolder(getMOR(), name));
}
    public Task createVM_Task(VirtualMachineConfigSpec config, ResourcePool pool, HostSystem host) throws InvalidName, VmConfigFault, DuplicateName, FileFault, OutOfBounds, InsufficientResourcesFault, InvalidDatastore, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().createVM_Task(getMOR(), config, pool.getMOR(), host == null ? null : host.getMOR()));
}
    public Task moveIntoFolder_Task(ManagedEntity[] entities) throws DuplicateName, InvalidState, InvalidFolder, RuntimeFault, RemoteException {
    if (entities == null) {
        throw new IllegalArgumentException("entities must not be null");
    }
    return new Task(getServerConnection(), getVimService().moveIntoFolder_Task(getMOR(), MorUtil.createMORs(entities)));
}
    public Task registerVM_Task(String path, String name, boolean asTemplate, ResourcePool pool, HostSystem host) throws VmConfigFault, InvalidName, DuplicateName, FileFault, OutOfBounds, InsufficientResourcesFault, InvalidDatastore, AlreadyExists, NotFound, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().registerVM_Task(getMOR(), path, name, asTemplate, pool == null ? null : pool.getMOR(), host == null ? null : host.getMOR()));
}
    public Task unregisterAndDestroy_Task() throws InvalidState, ConcurrentAccess, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().unregisterAndDestroy_Task(getMOR()));
}
    /** Backward-compat alias for {@link #createDistributedVirtualSwitch(DVSCreateSpec)}. */
    public Task createDVS_Task(DVSCreateSpec spec) throws DvsNotAuthorized, DvsFault, DuplicateName, InvalidName, NotFound, RuntimeFault, RemoteException {
        return createDistributedVirtualSwitch(spec);
    }
    /* ===== END custom ===== */
}
