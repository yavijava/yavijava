/*================================================================================
Copyright (c) 2013 Steve Jin. All Rights Reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, 
this list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice, 
this list of conditions and the following disclaimer in the documentation 
and/or other materials provided with the distribution.

* Neither the name of VMware, Inc. nor the names of its contributors may be used
to endorse or promote products derived from this software without specific prior 
written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL VMWARE, INC. OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.
================================================================================*/

package com.vmware.vim25.mo;

import com.vmware.vim25.*;

import java.rmi.RemoteException;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 *
 * @author Steve JIN (http://www.doublecloud.org)
 * @since SDK5.5
 */

public class HostVsanSystem extends ManagedObject {
    public HostVsanSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public VsanHostConfigInfo getConfig() {
        return (VsanHostConfigInfo) getCurrentProperty("config");
    }

    public Task addDisks_Task(HostScsiDisk[] disk) throws RuntimeFault, RemoteException {
        ManagedObjectReference mor = getVimService().addDisks_Task(this.getMOR(), disk);
        return new Task(getServerConnection(), mor);
    }

    public Task initializeDisks_Task(VsanHostDiskMapping[] mapping) throws RuntimeFault, RemoteException {
        ManagedObjectReference mor = getVimService().initializeDisks_Task(this.getMOR(), mapping);
        return new Task(getServerConnection(), mor);
    }

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

    /**
     * Remove the set of given disks from use by the VSAN service on this host. Users may use this API to manually
     * remove a DiskMapping#nonSsd from a DiskMapping. This operation is only permitted if the VSAN service on this host
     * is not configured to automatically claim storage.
     *
     * @param disk            list of disks to be removed from use by the VSAN service.
     * @param maintenanceSpec -
     *                        Any additional actions to move data out of the disk before removing it.
     * @param timeout         Time to wait for the task to complete in seconds. If the value is less than or equal to zero,
     *                        there is no timeout. The operation fails with a Timedout exception if it timed out.
     * @return This method returns a Task object with which to monitor the operation.
     * @throws RuntimeFault
     * @throws RemoteException
     * @see com.vmware.vim25.HostMaintenanceSpec
     * If unspecified, there is no action taken to move data from the
     * disk.
     */
    public Task removeDisk_Task(HostScsiDisk[] disk, HostMaintenanceSpec maintenanceSpec, int timeout) throws RuntimeFault, RemoteException {
        ManagedObjectReference mor = getVimService().removeDisk_Task(this.getMOR(), disk, maintenanceSpec, timeout);
        return new Task(getServerConnection(), mor);
    }

    public Task removeDiskMapping_Task(VsanHostDiskMapping[] mapping) throws RuntimeFault, RemoteException {
        return removeDiskMapping_Task(mapping, null, 0);
    }

    public Task removeDiskMapping_Task(VsanHostDiskMapping[] mapping, HostMaintenanceSpec maintenanceSpec, int timeout) throws RuntimeFault, RemoteException {
        ManagedObjectReference mor = getVimService().removeDiskMapping_Task(this.getMOR(), mapping, maintenanceSpec, timeout);
        return new Task(getServerConnection(), mor);
    }

    public Task updateVsan_Task(VsanHostConfigInfo config) throws RuntimeFault, RemoteException {
        ManagedObjectReference mor = getVimService().updateVsan_Task(this.getMOR(), config);
        return new Task(getServerConnection(), mor);
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
}