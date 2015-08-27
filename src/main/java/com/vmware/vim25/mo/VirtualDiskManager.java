/*================================================================================
Copyright (c) 2008 VMware, Inc. All Rights Reserved.

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
 */

public class VirtualDiskManager extends ManagedObject {

    public VirtualDiskManager(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    public Task copyVirtualDisk_Task(String sourceName, Datacenter sourceDatacenter, String destName,
                                     Datacenter destDatacenter, VirtualDiskSpec destSpec, Boolean force) throws FileFault, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().copyVirtualDisk_Task(getMOR(),
            sourceName, sourceDatacenter == null ? null : sourceDatacenter.getMOR(),
            destName, destDatacenter == null ? null : destDatacenter.getMOR(), destSpec, force);
        return new Task(getServerConnection(), taskMor);
    }

    public Task createVirtualDisk_Task(String name, Datacenter datacenter, VirtualDiskSpec spec) throws FileFault, RuntimeFault, RemoteException {
        return new Task(getServerConnection(),
            getVimService().createVirtualDisk_Task(getMOR(), name, datacenter == null ? null : datacenter.getMOR(), spec));
    }

    public Task defragmentVirtualDisk_Task(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException {
        return new Task(getServerConnection(),
            getVimService().defragmentVirtualDisk_Task(getMOR(), name, datacenter == null ? null : datacenter.getMOR()));
    }

    public Task deleteVirtualDisk_Task(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException {
        return new Task(getServerConnection(),
            getVimService().deleteVirtualDisk_Task(getMOR(), name, datacenter == null ? null : datacenter.getMOR()));
    }

    //SDK2.5 signature for back compatibility
    public Task extendVirtualDisk_Task(String name, Datacenter datacenter, long newCapacityKb) throws FileFault, RuntimeFault, RemoteException {
        return extendVirtualDisk_Task(name, datacenter, newCapacityKb, null);
    }

    //SDK4.0 signature
    public Task extendVirtualDisk_Task(String name, Datacenter datacenter, long newCapacityKb, Boolean eagerZero) throws FileFault, RuntimeFault, RemoteException {
        return new Task(getServerConnection(),
            getVimService().extendVirtualDisk_Task(getMOR(), name, datacenter == null ? null : datacenter.getMOR(), newCapacityKb, eagerZero));
    }

    /**
     * @since SDK4.0
     */
    public Task eagerZeroVirtualDisk_Task(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException {
        return new Task(getServerConnection(),
            getVimService().eagerZeroVirtualDisk_Task(getMOR(), name,
                datacenter == null ? null : datacenter.getMOR()));
    }

    public Task inflateVirtualDisk_Task(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException {
        return new Task(getServerConnection(),
            getVimService().inflateVirtualDisk_Task(getMOR(), name, datacenter == null ? null : datacenter.getMOR()));
    }

    /**
     * keep the old signature for compability
     */
    public Task moveVirtualDisk_Task(String sourceName, Datacenter sourceDatacenter, String destName, Datacenter destDatacenter, Boolean force) throws FileFault, RuntimeFault, RemoteException {
        return moveVirtualDisk_Task(sourceName, sourceDatacenter, destName, destDatacenter, force, null);
    }

    /**
     * @since SDK5.5
     */
    public Task moveVirtualDisk_Task(String sourceName, Datacenter sourceDatacenter, String destName, Datacenter destDatacenter, Boolean force, VirtualMachineProfileSpec[] profile) throws FileFault, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().moveVirtualDisk_Task(getMOR(),
            sourceName, sourceDatacenter == null ? null : sourceDatacenter.getMOR(),
            destName, destDatacenter == null ? null : destDatacenter.getMOR(), force, profile);

        return new Task(getServerConnection(), taskMor);
    }

    public int queryVirtualDiskFragmentation(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException {
        return getVimService().queryVirtualDiskFragmentation(getMOR(), name, datacenter == null ? null : datacenter.getMOR());
    }

    public HostDiskDimensionsChs queryVirtualDiskGeometry(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException {
        return getVimService().queryVirtualDiskGeometry(getMOR(), name, datacenter == null ? null : datacenter.getMOR());
    }

    public String queryVirtualDiskUuid(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException {
        return getVimService().queryVirtualDiskUuid(getMOR(), name, datacenter == null ? null : datacenter.getMOR());
    }

    public void setVirtualDiskUuid(String name, Datacenter datacenter, String uuid) throws FileFault, RuntimeFault, RemoteException {
        getVimService().setVirtualDiskUuid(getMOR(), name, datacenter == null ? null : datacenter.getMOR(), uuid);
    }

    public Task shrinkVirtualDisk_Task(String name, Datacenter datacenter, boolean copy) throws FileFault, RuntimeFault, RemoteException {
        return new Task(getServerConnection(),
            getVimService().shrinkVirtualDisk_Task(getMOR(), name, datacenter == null ? null : datacenter.getMOR(), copy));
    }

    public Task zeroFillVirtualDisk_Task(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException {
        return new Task(getServerConnection(),
            getVimService().zeroFillVirtualDisk_Task(getMOR(), name, datacenter == null ? null : datacenter.getMOR()));
    }

    /**
     * Import an unmanaged-snapshot from Virtual-Volume(VVol) enabled Storage Array.
     * <p>
     * Storage Array may support users to take snapshots indepedent of VMware stack. Such copies or snapshots are known
     * as 'Unmanaged-Snapshots'. We are providing an ability to end-users to import such unmanaged-snapshots as Virtual
     * Disks.
     * <p>
     * End-user needs to know the VVol-Identifier to import unmanaged snapshot as VirtualDisk.
     * <p>
     * Once VirtualDisk is created, user can use 'Datastore Browser' to use with rest of Virtual Machine provisioning
     * APIs.
     *
     * @param vdisk      -
     *                   The name of the disk to import, either a datastore path or a URL referring to the virtual disk from
     *                   which to get geometry information.
     * @param datacenter -
     *                   If vdisk is a datastore path, the datacenter for that datastore path. Not needed when invoked
     *                   directly on ESX. If not specified on a call to VirtualCenter, vdisk must be a URL.
     * @param vvolId     Unmanaged snapshot identifier
     * @throws InvalidDatastore
     * @throws NotFound
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public void importUnmanagedSnapshot(String vdisk, Datacenter datacenter, String vvolId) throws InvalidDatastore, NotFound, RuntimeFault, RemoteException {
        getVimService().importUnmanagedSnapshot(getMOR(), vdisk, datacenter == null ? null : datacenter.getMOR(), vvolId);
    }

    public void importUnmanagedSnapshot(String vdisk, String vvolId) throws InvalidDatastore, NotFound, RuntimeFault, RemoteException {
        importUnmanagedSnapshot(vdisk, null, vvolId);
    }
}
