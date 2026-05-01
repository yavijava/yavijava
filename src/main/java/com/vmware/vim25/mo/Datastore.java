// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class Datastore extends ManagedEntity {

    public Datastore(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostDatastoreBrowser getBrowser() {
        return (HostDatastoreBrowser) this.getManagedObject("browser");
    }

    public DatastoreCapability getCapability() {
        return (DatastoreCapability) getCurrentProperty("capability");
    }

    public DatastoreHostMount[] getHost() {
        return (DatastoreHostMount[]) getCurrentProperty("host");
    }

    public DatastoreInfo getInfo() {
        return (DatastoreInfo) getCurrentProperty("info");
    }

    public StorageIORMInfo getIormConfiguration() {
        return (StorageIORMInfo) getCurrentProperty("iormConfiguration");
    }

    public DatastoreSummary getSummary() {
        return (DatastoreSummary) getCurrentProperty("summary");
    }

    public VirtualMachine[] getVm() {
        return getVms("vm");
    }

    public void destroyDatastore() throws ResourceInUse, RuntimeFault, RemoteException {
        getVimService().destroyDatastore(getMOR());
    }

    public Task datastoreExitMaintenanceMode_Task() throws InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().datastoreExitMaintenanceMode_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public boolean isClusteredVmdkEnabled() throws InvalidDatastore, RuntimeFault, RemoteException {
        return getVimService().isClusteredVmdkEnabled(getMOR());
    }

    public void refresh() throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().refresh(getMOR());
    }

    public void refreshStorageInfo() throws RuntimeFault, RemoteException {
        getVimService().refreshStorageInfo(getMOR());
    }

    public void renameDatastore(String newName) throws DuplicateName, InvalidName, RuntimeFault, RemoteException {
        getVimService().renameDatastore(getMOR(), newName);
    }

    public Task updateVVolVirtualMachineFiles_Task(DatastoreVVolContainerFailoverPair[] failoverPair) throws InvalidDatastore, NotSupported, PlatformConfigFault, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().updateVVolVirtualMachineFiles_Task(getMOR(), failoverPair);
        return new Task(getServerConnection(), resultMor);
    }

    public Task updateVirtualMachineFiles_Task(DatastoreMountPathDatastorePair[] mountPathDatastoreMapping) throws InvalidDatastore, PlatformConfigFault, ResourceInUse, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().updateVirtualMachineFiles_Task(getMOR(), mountPathDatastoreMapping);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public void refreshDatastore() throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().refreshDatastore(getMOR());
    }
    /** @since SDK4.0 */
    public void refreshDatastoreStorageInfo() throws RuntimeFault, RemoteException {
        getVimService().refreshDatastoreStorageInfo(getMOR());
    }
    /**
 * @since SDK5.0
 */
public StoragePlacementResult datastoreEnterMaintenanceMode() throws InvalidState, RuntimeFault, RemoteException {
    return getVimService().datastoreEnterMaintenanceMode(getMOR());
}
    /* ===== END custom ===== */
}
