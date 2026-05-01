// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostVsanSystem extends ManagedObject {

    public HostVsanSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public VsanHostConfigInfo getConfig() {
        return (VsanHostConfigInfo) getCurrentProperty("config");
    }

    public Task addDisks(HostScsiDisk[] disk) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().addDisks_Task(getMOR(), disk);
        return new Task(getServerConnection(), resultMor);
    }

    public Task initializeDisks(VsanHostDiskMapping[] mapping) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().initializeDisks_Task(getMOR(), mapping);
        return new Task(getServerConnection(), resultMor);
    }

    public Task removeDisk_Task(HostScsiDisk[] disk, HostMaintenanceSpec maintenanceSpec, int timeout) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().removeDisk_Task(getMOR(), disk, maintenanceSpec, timeout);
        return new Task(getServerConnection(), resultMor);
    }

    public Task removeDiskMapping_Task(VsanHostDiskMapping[] mapping, HostMaintenanceSpec maintenanceSpec, int timeout) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().removeDiskMapping_Task(getMOR(), mapping, maintenanceSpec, timeout);
        return new Task(getServerConnection(), resultMor);
    }

    public Task update(VsanHostConfigInfo config) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().updateVsan_Task(getMOR(), config);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public VsanHostDiskResult[] queryDisksForVsan(String[] canonicalName) throws RuntimeFault, RemoteException {
    return getVimService().queryDisksForVsan(this.getMOR(), canonicalName);
}
    public VsanHostClusterStatus queryHostStatus() throws RuntimeFault, RemoteException {
    return getVimService().queryHostStatus(this.getMOR());
}
    /**
 * Remove the set of given disks from use by the VSAN service on this host. Users may use this API to manually
 * remove a DiskMapping#nonSsd from a DiskMapping. This operation is only permitted if the VSAN service on this host
 * is not configured to automatically claim storage.
 *
 * @param disk list of disks to be removed from use by the VSAN service.
 * @return This method returns a Task object with which to monitor the operation.
 * @throws RuntimeFault
 * @throws RemoteException
 */
public Task removeDisk_Task(HostScsiDisk[] disk) throws RuntimeFault, RemoteException {
    return removeDisk_Task(disk, null, 0);
}
    public Task removeDiskMapping_Task(VsanHostDiskMapping[] mapping) throws RuntimeFault, RemoteException {
    return removeDiskMapping_Task(mapping, null, 0);
}

    /**
 * Evacuate this host from VSAN cluster.
 * The task is cancellable.
 *
 * @param maintenanceSpec -
 *                        Specifies the data evacuation mode. See {@link com.vmware.vim25.HostMaintenanceSpec HostMaintenanceSpec}.
 *                        If unspecified, the default mode chosen will be ensureObjectAccessibility.
 * @param timeout         -
 *                        Time to wait for the task to complete in seconds. If the value is less than or equal to zero,
 *                        there is no timeout. The operation fails with a Timedout exception if it timed out.
 * @return This method returns a Task object with which to monitor the operation.
 * @throws InvalidState
 * @throws RequestCanceled
 * @throws RuntimeFault
 * @throws Timedout
 * @throws VsanFault
 * @throws RemoteException
 * @since 6.0
 */
public Task evacuateVsanNode_Task(HostMaintenanceSpec maintenanceSpec, int timeout) throws InvalidState, RequestCanceled, RuntimeFault, Timedout, VsanFault, RemoteException {
    return new Task(getServerConnection(), getVimService().evacuateVsanNode_Task(getMOR(), maintenanceSpec, timeout));
}
    /**
 * Recommission this host to VSAN cluster.
 * Users may use this API to recommission a node that has been evacuated in VsanHostDecommissionMode.
 *
 * @return This method returns a Task object with which to monitor the operation.
 * @throws InvalidState
 * @throws RuntimeFault
 * @throws VsanFault
 * @throws RemoteException
 * @see com.vmware.vim25.mo.HostVsanSystem#evacuateVsanNode_Task
 * @see VsanHostDecommissionMode
 * @since 6.0
 */
public Task recommissionVsanNode_Task() throws InvalidState, RuntimeFault, VsanFault, RemoteException {
    return new Task(getServerConnection(), getVimService().recommissionVsanNode_Task(getMOR()));
}
    /**
 * Unmount the mounted DiskMapping. An unmounted volume cannot be used for any VSAN operations. In contrast to
 * RemoveDiskMapping_Task, this operation does not destroy or alter VSAN data on the disks. AddDisks_Task and
 * InitializeDisks_Task can be used to re-mount the diskMapping.
 *
 * @param mapping Mapping
 * @return This method returns a Task object with which to monitor the operation.
 * @throws InvalidState
 * @throws RuntimeFault
 * @throws VsanFault
 * @throws RemoteException
 */
public Task unmountDiskMapping_Task(VsanHostDiskMapping[] mapping) throws InvalidState, RuntimeFault, VsanFault, RemoteException {
    return new Task(getServerConnection(), getVimService().unmountDiskMapping_Task(getMOR(), mapping));
}
    /* ===== END custom ===== */
}
