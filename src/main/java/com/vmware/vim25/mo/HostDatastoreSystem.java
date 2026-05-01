// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostDatastoreSystem extends ManagedObject {

    public HostDatastoreSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostDatastoreSystemCapabilities getCapabilities() {
        return (HostDatastoreSystemCapabilities) getCurrentProperty("capabilities");
    }

    public Datastore[] getDatastore() {
        return getDatastores("datastore");
    }

    public void configureDatastorePrincipal(String userName, String password) throws HostConfigFault, InvalidState, RuntimeFault, RemoteException {
        getVimService().configureDatastorePrincipal(getMOR(), userName, password);
    }

    public Datastore createLocalDatastore(String name, String path) throws DuplicateName, FileNotFound, HostConfigFault, InvalidName, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createLocalDatastore(getMOR(), name, path);
        return new Datastore(getServerConnection(), resultMor);
    }

    public Datastore createNasDatastore(HostNasVolumeSpec spec) throws AlreadyExists, DuplicateName, HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createNasDatastore(getMOR(), spec);
        return new Datastore(getServerConnection(), resultMor);
    }

    public Datastore createVmfsDatastore(VmfsDatastoreCreateSpec spec) throws DuplicateName, HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createVmfsDatastore(getMOR(), spec);
        return new Datastore(getServerConnection(), resultMor);
    }

    public Datastore createVvolDatastore(HostDatastoreSystemVvolDatastoreSpec spec) throws DuplicateName, HostConfigFault, InvalidName, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createVvolDatastore(getMOR(), spec);
        return new Datastore(getServerConnection(), resultMor);
    }

    public void disableClusteredVmdkSupport(Datastore datastore) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().disableClusteredVmdkSupport(getMOR(), datastore == null ? null : datastore.getMOR());
    }

    public void enableClusteredVmdkSupport(Datastore datastore) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().enableClusteredVmdkSupport(getMOR(), datastore == null ? null : datastore.getMOR());
    }

    public Datastore expandVmfsDatastore(Datastore datastore, VmfsDatastoreExpandSpec spec) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().expandVmfsDatastore(getMOR(), datastore == null ? null : datastore.getMOR(), spec);
        return new Datastore(getServerConnection(), resultMor);
    }

    public long queryMaxQueueDepth(Datastore datastore) throws NotFound, RuntimeFault, RemoteException {
        return getVimService().queryMaxQueueDepth(getMOR(), datastore == null ? null : datastore.getMOR());
    }

    public VmfsDatastoreOption[] queryVmfsDatastoreExtendOptions(Datastore datastore, String devicePath, boolean suppressExpandCandidates) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        return getVimService().queryVmfsDatastoreExtendOptions(getMOR(), datastore == null ? null : datastore.getMOR(), devicePath, suppressExpandCandidates);
    }

    public Task removeDatastoreEx_Task(Datastore[] datastore) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().removeDatastoreEx_Task(getMOR(), datastore == null ? null : MorUtil.createMORs(datastore));
        return new Task(getServerConnection(), resultMor);
    }

    public Task resignatureUnresolvedVmfsVolume_Task(HostUnresolvedVmfsResignatureSpec resolutionSpec) throws HostConfigFault, VmfsAmbiguousMount, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().resignatureUnresolvedVmfsVolume_Task(getMOR(), resolutionSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public void setMaxQueueDepth(Datastore datastore, long maxQdepth) throws NotFound, RuntimeFault, RemoteException {
        getVimService().setMaxQueueDepth(getMOR(), datastore == null ? null : datastore.getMOR(), maxQdepth);
    }

    public void updateLocalSwapDatastore(Datastore datastore) throws DatastoreNotWritableOnHost, InaccessibleDatastore, RuntimeFault, RemoteException {
        getVimService().updateLocalSwapDatastore(getMOR(), datastore == null ? null : datastore.getMOR());
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public Datastore extendVmfsDatastore(Datastore datastore, VmfsDatastoreExtendSpec spec) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
    if (datastore == null) {
        throw new IllegalArgumentException("datastore must not be null.");
    }
    ManagedObjectReference mor = getVimService().extendVmfsDatastore(getMOR(), datastore.getMOR(), spec);
    return new Datastore(getServerConnection(), mor);
}
    public HostScsiDisk[] queryAvailableDisksForVmfs(Datastore datastore) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
    return getVimService().queryAvailableDisksForVmfs(getMOR(), datastore == null ? null : datastore.getMOR());
}
    //SDK5.0 signature
public VmfsDatastoreOption[] queryVmfsDatastoreCreateOptions(String devicePath, int vmfsMajorVersion) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
    return getVimService().queryVmfsDatastoreCreateOptions(getMOR(), devicePath, vmfsMajorVersion);
}
    //SDK2.5 signature for back compatibility
public VmfsDatastoreOption[] queryVmfsDatastoreExtendOptions(Datastore datastore, String devicePath) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
    return queryVmfsDatastoreExtendOptions(datastore, devicePath, null);
}
    //SDK4.0 signature
public VmfsDatastoreOption[] queryVmfsDatastoreExtendOptions(Datastore datastore, String devicePath, Boolean suppressExpandCandidates) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
    if (datastore == null) {
        throw new IllegalArgumentException("datastore must not be null.");
    }
    return getVimService().queryVmfsDatastoreExtendOptions(getMOR(), datastore.getMOR(), devicePath, suppressExpandCandidates);
}
    /**
 * @since 4.0
 */
public VmfsDatastoreOption[] queryVmfsDatastoreExpandOptions(Datastore datastore) throws NotFound, HostConfigFault, RuntimeFault, RemoteException {
    return getVimService().queryVmfsDatastoreExpandOptions(getMOR(), datastore.getMOR());
}
    /**
 * @since 4.0
 */
public HostUnresolvedVmfsVolume[] queryUnresolvedVmfsVolumes() throws RuntimeFault, RemoteException {
    return getVimService().queryUnresolvedVmfsVolumes(getMOR());
}
    public void removeDatastore(Datastore datastore) throws HostConfigFault, ResourceInUse, NotFound, RuntimeFault, RemoteException {
    if (datastore == null) {
        throw new IllegalArgumentException("datastore must not be null.");
    }
    getVimService().removeDatastore(getMOR(), datastore.getMOR());
}
    /* ===== END custom ===== */
}
