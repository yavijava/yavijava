// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class VcenterVStorageObjectManager extends VStorageObjectManagerBase {

    public VcenterVStorageObjectManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void attachTagToVStorageObject(ID id, String category, String tag) throws NotFound, RuntimeFault, RemoteException {
        getVimService().attachTagToVStorageObject(getMOR(), id, category, tag);
    }

    public void clearVStorageObjectControlFlags(ID id, Datastore datastore, String[] controlFlags) throws InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        getVimService().clearVStorageObjectControlFlags(getMOR(), id, datastore == null ? null : datastore.getMOR(), controlFlags);
    }

    public Task cloneVStorageObject(ID id, Datastore datastore, VslmCloneSpec spec) throws FileFault, InvalidDatastore, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().cloneVStorageObject_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task createDisk(VslmCreateSpec spec) throws FileFault, InvalidDatastore, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createDisk_Task(getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task createDiskFromSnapshot(ID id, Datastore datastore, ID snapshotId, String name, VirtualMachineProfileSpec[] profile, CryptoSpec crypto, String path) throws FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createDiskFromSnapshot_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), snapshotId, name, profile, crypto, path);
        return new Task(getServerConnection(), resultMor);
    }

    public Task createSnapshot(ID id, Datastore datastore, String description) throws FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().vStorageObjectCreateSnapshot_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), description);
        return new Task(getServerConnection(), resultMor);
    }

    public Task deleteSnapshot(ID id, Datastore datastore, ID snapshotId) throws FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().deleteSnapshot_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), snapshotId);
        return new Task(getServerConnection(), resultMor);
    }

    public Task deleteVStorageObject(ID id, Datastore datastore) throws FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().deleteVStorageObject_Task(getMOR(), id, datastore == null ? null : datastore.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task deleteVStorageObjectEx(ID id, Datastore datastore) throws FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().deleteVStorageObjectEx_Task(getMOR(), id, datastore == null ? null : datastore.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public void detachTagFromVStorageObject(ID id, String category, String tag) throws NotFound, RuntimeFault, RemoteException {
        getVimService().detachTagFromVStorageObject(getMOR(), id, category, tag);
    }

    public Task extendDisk(ID id, Datastore datastore, long newCapacityInMB) throws FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().extendDisk_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), newCapacityInMB);
        return new Task(getServerConnection(), resultMor);
    }

    public Task inflateDisk(ID id, Datastore datastore) throws FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().inflateDisk_Task(getMOR(), id, datastore == null ? null : datastore.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public VslmTagEntry[] listTagsAttachedToVStorageObject(ID id) throws NotFound, RuntimeFault, RemoteException {
        return getVimService().listTagsAttachedToVStorageObject(getMOR(), id);
    }

    public ID[] listVStorageObject(Datastore datastore) throws InvalidDatastore, RuntimeFault, RemoteException {
        return getVimService().listVStorageObject(getMOR(), datastore == null ? null : datastore.getMOR());
    }

    public ID[] listVStorageObjectsAttachedToTag(String category, String tag) throws NotFound, RuntimeFault, RemoteException {
        return getVimService().listVStorageObjectsAttachedToTag(getMOR(), category, tag);
    }

    public DiskChangeInfo queryChangedDiskAreas(ID id, Datastore datastore, ID snapshotId, long startOffset, String changeId) throws FileFault, InvalidArgument, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        return getVimService().vstorageObjectVCenterQueryChangedDiskAreas(getMOR(), id, datastore == null ? null : datastore.getMOR(), snapshotId, startOffset, changeId);
    }

    public String queryVirtualDiskUuidEx(String name, Datacenter datacenter) throws FileFault, InvalidDatastore, RuntimeFault, RemoteException {
        return getVimService().queryVirtualDiskUuidEx(getMOR(), name, datacenter == null ? null : datacenter.getMOR());
    }

    public Task reconcileDatastoreInventory(Datastore datastore, boolean deepCleansing) throws InvalidDatastore, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().reconcileDatastoreInventory_Task(getMOR(), datastore == null ? null : datastore.getMOR(), deepCleansing);
        return new Task(getServerConnection(), resultMor);
    }

    public Task reconcileDatastoreInventoryEx(VStorageObjectReconcileSpec spec) throws FileFault, InvalidArgument, InvalidDatastore, InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().reconcileDatastoreInventoryEx_Task(getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public VStorageObject registerDisk(String path, String name) throws AlreadyExists, FileFault, InvalidDatastore, RuntimeFault, RemoteException {
        return getVimService().registerDisk(getMOR(), path, name);
    }

    public Task relocateVStorageObject(ID id, Datastore datastore, VslmRelocateSpec spec) throws FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().relocateVStorageObject_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public void renameVStorageObject(ID id, Datastore datastore, String name) throws FileFault, InvalidDatastore, NotFound, RuntimeFault, RemoteException {
        getVimService().renameVStorageObject(getMOR(), id, datastore == null ? null : datastore.getMOR(), name);
    }

    public VStorageObjectSnapshotDetails retrieveSnapshotDetails(ID id, Datastore datastore, ID snapshotId) throws FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        return getVimService().retrieveSnapshotDetails(getMOR(), id, datastore == null ? null : datastore.getMOR(), snapshotId);
    }

    public VStorageObjectSnapshotInfo retrieveSnapshotInfo(ID id, Datastore datastore) throws FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        return getVimService().retrieveSnapshotInfo(getMOR(), id, datastore == null ? null : datastore.getMOR());
    }

    public vslmInfrastructureObjectPolicy[] retrieveVStorageInfrastructureObjectPolicy(Datastore datastore) throws InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        return getVimService().retrieveVStorageInfrastructureObjectPolicy(getMOR(), datastore == null ? null : datastore.getMOR());
    }

    public VStorageObject retrieveVStorageObject(ID id, Datastore datastore, String[] diskInfoFlags) throws FileFault, InvalidDatastore, NotFound, RuntimeFault, RemoteException {
        return getVimService().retrieveVStorageObject(getMOR(), id, datastore == null ? null : datastore.getMOR(), diskInfoFlags);
    }

    public VStorageObjectAssociations[] retrieveVStorageObjectAssociations(RetrieveVStorageObjSpec[] ids) throws RuntimeFault, RemoteException {
        return getVimService().retrieveVStorageObjectAssociations(getMOR(), ids);
    }

    public VStorageObjectStateInfo retrieveVStorageObjectState(ID id, Datastore datastore) throws FileFault, InvalidDatastore, NotFound, RuntimeFault, RemoteException {
        return getVimService().retrieveVStorageObjectState(getMOR(), id, datastore == null ? null : datastore.getMOR());
    }

    public Task revertVStorageObject(ID id, Datastore datastore, ID snapshotId) throws FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().revertVStorageObject_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), snapshotId);
        return new Task(getServerConnection(), resultMor);
    }

    public void scheduleReconcileDatastoreInventory(Datastore datastore, boolean deepCleansing) throws InvalidDatastore, NotFound, RuntimeFault, RemoteException {
        getVimService().scheduleReconcileDatastoreInventory(getMOR(), datastore == null ? null : datastore.getMOR(), deepCleansing);
    }

    public void setVStorageObjectControlFlags(ID id, Datastore datastore, String[] controlFlags) throws InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        getVimService().setVStorageObjectControlFlags(getMOR(), id, datastore == null ? null : datastore.getMOR(), controlFlags);
    }

    public Task setVirtualDiskUuidEx(String name, Datacenter datacenter, String uuid) throws FileFault, InvalidDatastore, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().setVirtualDiskUuidEx_Task(getMOR(), name, datacenter == null ? null : datacenter.getMOR(), uuid);
        return new Task(getServerConnection(), resultMor);
    }

    public Task updateVStorageInfrastructureObjectPolicy(vslmInfrastructureObjectPolicySpec spec) throws InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().updateVStorageInfrastructureObjectPolicy_Task(getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task updateVStorageObjectCrypto(ID id, Datastore datastore, VirtualMachineProfileSpec[] profile, DiskCryptoSpec disksCrypto) throws FileFault, InvalidDatastore, NotFound, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().updateVStorageObjectCrypto_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), profile, disksCrypto);
        return new Task(getServerConnection(), resultMor);
    }

    public Task updateVStorageObjectMetadataEx(ID id, Datastore datastore, KeyValue[] metadata, String[] deleteKeys) throws InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().vCenterUpdateVStorageObjectMetadataEx_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), metadata, deleteKeys);
        return new Task(getServerConnection(), resultMor);
    }

    public Task updateVStorageObjectPolicy(ID id, Datastore datastore, VirtualMachineProfileSpec[] profile) throws FileFault, InvalidDatastore, NotFound, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().updateVStorageObjectPolicy_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), profile);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
