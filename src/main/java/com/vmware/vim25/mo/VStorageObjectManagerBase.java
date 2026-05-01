// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class VStorageObjectManagerBase extends ManagedObject {

    public VStorageObjectManagerBase(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public Task createSnapshotEx(ID id, Datastore datastore, String description) throws FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().vStorageObjectCreateSnapshotEx_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), description);
        return new Task(getServerConnection(), resultMor);
    }

    public Task deleteSnapshotEx(ID id, Datastore datastore, ID snapshotId) throws FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().vStorageObjectDeleteSnapshotEx_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), snapshotId);
        return new Task(getServerConnection(), resultMor);
    }

    public Task deleteSnapshotEx2(ID id, Datastore datastore, ID snapshotId) throws FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().vStorageObjectDeleteSnapshotEx2_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), snapshotId);
        return new Task(getServerConnection(), resultMor);
    }

    public Task extendDiskEx(ID id, Datastore datastore, long newCapacityInMB) throws FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().vStorageObjectExtendDiskEx_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), newCapacityInMB);
        return new Task(getServerConnection(), resultMor);
    }

    public vslmVClockInfo renameVStorageObjectEx(ID id, Datastore datastore, String name) throws FileFault, InvalidDatastore, NotFound, RuntimeFault, RemoteException {
        return getVimService().renameVStorageObjectEx(getMOR(), id, datastore == null ? null : datastore.getMOR(), name);
    }

    public Task revertVStorageObjectEx(ID id, Datastore datastore, ID snapshotId) throws FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().revertVStorageObjectEx_Task(getMOR(), id, datastore == null ? null : datastore.getMOR(), snapshotId);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
