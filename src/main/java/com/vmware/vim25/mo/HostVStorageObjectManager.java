// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostVStorageObjectManager extends VStorageObjectManagerBase {

    public HostVStorageObjectManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void clearVStorageObjectControlFlags(ID id, Datastore datastore, String[] controlFlags) throws InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        getVimService().hostClearVStorageObjectControlFlags(getMOR(), id, datastore == null ? null : datastore.getMOR(), controlFlags);
    }

    public Task cloneVStorageObject(ID id, Datastore datastore, VslmCloneSpec spec) throws FileFault, InvalidDatastore, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().hostCloneVStorageObject_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task createDisk(VslmCreateSpec spec) throws FileFault, InvalidDatastore, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().hostCreateDisk_Task(getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task createDiskFromSnapshot(ID id, Datastore datastore, ID snapshotId, String name, VirtualMachineProfileSpec[] profile, CryptoSpec crypto, String path, String provisioningType) throws FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().hostVStorageObjectCreateDiskFromSnapshot_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), snapshotId, name, profile, crypto, path, provisioningType);
        return new Task(getServerConnection(), resultMor);
    }

    public Task createSnapshot(ID id, Datastore datastore, String description) throws FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().hostVStorageObjectCreateSnapshot_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), description);
        return new Task(getServerConnection(), resultMor);
    }

    public Task deleteSnapshot(ID id, Datastore datastore, ID snapshotId) throws FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().hostVStorageObjectDeleteSnapshot_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), snapshotId);
        return new Task(getServerConnection(), resultMor);
    }

    public Task deleteVStorageObject(ID id, Datastore datastore) throws FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().hostDeleteVStorageObject_Task(getMOR(), id, datastore == null ? null : datastore.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task deleteVStorageObjectEx(ID id, Datastore datastore) throws FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().hostDeleteVStorageObjectEx_Task(getMOR(), id, datastore == null ? null : datastore.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task extendDisk(ID id, Datastore datastore, long newCapacityInMB) throws FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().hostExtendDisk_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), newCapacityInMB);
        return new Task(getServerConnection(), resultMor);
    }

    public Task inflateDisk(ID id, Datastore datastore) throws FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().hostInflateDisk_Task(getMOR(), id, datastore == null ? null : datastore.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public ID[] listVStorageObject(Datastore datastore) throws InvalidDatastore, RuntimeFault, RemoteException {
        return getVimService().hostListVStorageObject(getMOR(), datastore == null ? null : datastore.getMOR());
    }

    public String queryVirtualDiskUuidEx(String name) throws FileFault, InvalidDatastore, RuntimeFault, RemoteException {
        return getVimService().hostQueryVirtualDiskUuid(getMOR(), name);
    }

    public Task reconcileDatastoreInventory(Datastore datastore, boolean deepCleansing) throws InvalidDatastore, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().hostReconcileDatastoreInventory_Task(getMOR(), datastore == null ? null : datastore.getMOR(), deepCleansing);
        return new Task(getServerConnection(), resultMor);
    }

    public VStorageObject registerDisk(String path, String name, boolean modifyControlFlags) throws AlreadyExists, FileFault, InvalidDatastore, RuntimeFault, RemoteException {
        return getVimService().hostRegisterDisk(getMOR(), path, name, modifyControlFlags);
    }

    public Task relocateVStorageObject(ID id, Datastore datastore, VslmRelocateSpec spec) throws FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().hostRelocateVStorageObject_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public void renameVStorageObject(ID id, Datastore datastore, String name) throws FileFault, InvalidDatastore, NotFound, RuntimeFault, RemoteException {
        getVimService().hostRenameVStorageObject(getMOR(), id, datastore == null ? null : datastore.getMOR(), name);
    }

    public VStorageObjectSnapshotInfo retrieveSnapshotInfo(ID id, Datastore datastore) throws FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        return getVimService().hostVStorageObjectRetrieveSnapshotInfo(getMOR(), id, datastore == null ? null : datastore.getMOR());
    }

    public vslmInfrastructureObjectPolicy[] retrieveVStorageInfrastructureObjectPolicy(Datastore datastore) throws InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        return getVimService().hostRetrieveVStorageInfrastructureObjectPolicy(getMOR(), datastore == null ? null : datastore.getMOR());
    }

    public VStorageObject retrieveVStorageObject(ID id, Datastore datastore, String[] diskInfoFlags) throws FileFault, InvalidDatastore, NotFound, RuntimeFault, RemoteException {
        return getVimService().hostRetrieveVStorageObject(getMOR(), id, datastore == null ? null : datastore.getMOR(), diskInfoFlags);
    }

    public KeyValue[] retrieveVStorageObjectMetadata(ID id, Datastore datastore, ID snapshotId, String prefix) throws InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        return getVimService().hostRetrieveVStorageObjectMetadata(getMOR(), id, datastore == null ? null : datastore.getMOR(), snapshotId, prefix);
    }

    public String retrieveVStorageObjectMetadataValue(ID id, Datastore datastore, ID snapshotId, String key) throws InvalidDatastore, InvalidState, KeyNotFound, NotFound, RuntimeFault, RemoteException {
        return getVimService().hostRetrieveVStorageObjectMetadataValue(getMOR(), id, datastore == null ? null : datastore.getMOR(), snapshotId, key);
    }

    public VStorageObjectStateInfo retrieveVStorageObjectState(ID id, Datastore datastore) throws FileFault, InvalidDatastore, NotFound, RuntimeFault, RemoteException {
        return getVimService().hostRetrieveVStorageObjectState(getMOR(), id, datastore == null ? null : datastore.getMOR());
    }

    public Task revertVStorageObject(ID id, Datastore datastore, ID snapshotId) throws FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().hostVStorageObjectRevert_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), snapshotId);
        return new Task(getServerConnection(), resultMor);
    }

    public void scheduleReconcileDatastoreInventory(Datastore datastore, boolean deepCleansing) throws InvalidDatastore, NotFound, RuntimeFault, RemoteException {
        getVimService().hostScheduleReconcileDatastoreInventory(getMOR(), datastore == null ? null : datastore.getMOR(), deepCleansing);
    }

    public void setVStorageObjectControlFlags(ID id, Datastore datastore, String[] controlFlags) throws InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        getVimService().hostSetVStorageObjectControlFlags(getMOR(), id, datastore == null ? null : datastore.getMOR(), controlFlags);
    }

    public Task setVirtualDiskUuidEx(String name, String uuid) throws FileFault, InvalidDatastore, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().hostSetVirtualDiskUuid_Task(getMOR(), name, uuid);
        return new Task(getServerConnection(), resultMor);
    }

    public Task updateVStorageObjectMetadata(ID id, Datastore datastore, KeyValue[] metadata, String[] deleteKeys) throws InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().hostUpdateVStorageObjectMetadata_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), metadata, deleteKeys);
        return new Task(getServerConnection(), resultMor);
    }

    public Task updateVStorageObjectMetadataEx(ID id, Datastore datastore, KeyValue[] metadata, String[] deleteKeys) throws InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().hostUpdateVStorageObjectMetadataEx_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), metadata, deleteKeys);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
