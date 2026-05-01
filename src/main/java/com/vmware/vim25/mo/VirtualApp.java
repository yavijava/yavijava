// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class VirtualApp extends ResourcePool {

    public VirtualApp(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public VirtualAppLinkInfo[] getChildLink() {
        return (VirtualAppLinkInfo[]) getCurrentProperty("childLink");
    }

    public Datastore[] getDatastore() {
        return getDatastores("datastore");
    }

    public Network[] getNetwork() {
        return getNetworks("network");
    }

    public VAppConfigInfo getVAppConfig() {
        return (VAppConfigInfo) getCurrentProperty("vAppConfig");
    }

    public Task cloneVApp_Task(String name, ResourcePool target, VAppCloneSpec spec) throws FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidState, MigrationFault, TaskInProgress, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().cloneVApp_Task(getMOR(), name, target == null ? null : target.getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public HttpNfcLease exportVApp() throws FileFault, InvalidPowerState, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().exportVApp(getMOR());
        return new HttpNfcLease(getServerConnection(), resultMor);
    }

    public Task powerOffVApp_Task(boolean force) throws InvalidState, TaskInProgress, VAppConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().powerOffVApp_Task(getMOR(), force);
        return new Task(getServerConnection(), resultMor);
    }

    public Task powerOnVApp_Task() throws FileFault, InsufficientResourcesFault, InvalidState, TaskInProgress, VAppConfigFault, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().powerOnVApp_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task suspendVApp_Task() throws InvalidState, TaskInProgress, VAppConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().suspendVApp_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task unregisterVApp_Task() throws ConcurrentAccess, InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().unregisterVApp_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public void updateLinkedChildren(VirtualAppLinkInfo[] addChangeSet, ManagedEntity[] removeSet) throws ConcurrentAccess, RuntimeFault, RemoteException {
        getVimService().updateLinkedChildren(getMOR(), addChangeSet, removeSet == null ? null : MorUtil.createMORs(removeSet));
    }

    public void updateVAppConfig(VAppConfigSpec spec) throws ConcurrentAccess, DuplicateName, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidName, InvalidState, TaskInProgress, VmConfigFault, RuntimeFault, RemoteException {
        getVimService().updateVAppConfig(getMOR(), spec);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public Folder getParentFolder() {
    ManagedObjectReference mor = (ManagedObjectReference) getCurrentProperty("parentFolder");
    return new Folder(getServerConnection(), mor);
}
    /**
 * @since SDK4.1
 */
public ManagedEntity getParentVApp() {
    ManagedObjectReference mor = (ManagedObjectReference) getCurrentProperty("parentVApp");
    return new ManagedEntity(getServerConnection(), mor);
}
    /* ===== END custom ===== */
}
