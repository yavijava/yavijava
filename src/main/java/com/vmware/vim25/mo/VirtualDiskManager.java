// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class VirtualDiskManager extends ManagedObject {

    public VirtualDiskManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public Task copyVirtualDisk_Task(String sourceName, Datacenter sourceDatacenter, String destName, Datacenter destDatacenter, VirtualDiskSpec destSpec, boolean force) throws FileFault, InvalidDatastore, InvalidDiskFormat, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().copyVirtualDisk_Task(getMOR(), sourceName, sourceDatacenter == null ? null : sourceDatacenter.getMOR(), destName, destDatacenter == null ? null : destDatacenter.getMOR(), destSpec, force);
        return new Task(getServerConnection(), resultMor);
    }

    public void importUnmanagedSnapshot(String vdisk, Datacenter datacenter, String vvolId) throws InvalidDatastore, NotFound, RuntimeFault, RemoteException {
        getVimService().importUnmanagedSnapshot(getMOR(), vdisk, datacenter == null ? null : datacenter.getMOR(), vvolId);
    }

    public Task moveVirtualDisk_Task(String sourceName, Datacenter sourceDatacenter, String destName, Datacenter destDatacenter, boolean force, VirtualMachineProfileSpec[] profile) throws FileFault, InvalidDatastore, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().moveVirtualDisk_Task(getMOR(), sourceName, sourceDatacenter == null ? null : sourceDatacenter.getMOR(), destName, destDatacenter == null ? null : destDatacenter.getMOR(), force, profile);
        return new Task(getServerConnection(), resultMor);
    }

    public void releaseManagedSnapshot(String vdisk, Datacenter datacenter) throws FileNotFound, InvalidDatastore, RuntimeFault, RemoteException {
        getVimService().releaseManagedSnapshot(getMOR(), vdisk, datacenter == null ? null : datacenter.getMOR());
    }

    public void setVirtualDiskUuid(String name, Datacenter datacenter, String uuid) throws FileFault, InvalidDatastore, RuntimeFault, RemoteException {
        getVimService().setVirtualDiskUuid(getMOR(), name, datacenter == null ? null : datacenter.getMOR(), uuid);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public Task createVirtualDisk_Task(String name, Datacenter datacenter, VirtualDiskSpec spec) throws FileFault, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().createVirtualDisk_Task(getMOR(), name, datacenter == null ? null : datacenter.getMOR(), spec));
}
    public Task defragmentVirtualDisk_Task(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().defragmentVirtualDisk_Task(getMOR(), name, datacenter == null ? null : datacenter.getMOR()));
}
    public Task deleteVirtualDisk_Task(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().deleteVirtualDisk_Task(getMOR(), name, datacenter == null ? null : datacenter.getMOR()));
}
    //SDK2.5 signature for back compatibility
public Task extendVirtualDisk_Task(String name, Datacenter datacenter, long newCapacityKb) throws FileFault, RuntimeFault, RemoteException {
    return extendVirtualDisk_Task(name, datacenter, newCapacityKb, null);
}
    //SDK4.0 signature
public Task extendVirtualDisk_Task(String name, Datacenter datacenter, long newCapacityKb, Boolean eagerZero) throws FileFault, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().extendVirtualDisk_Task(getMOR(), name, datacenter == null ? null : datacenter.getMOR(), newCapacityKb, eagerZero));
}
    /**
 * @since SDK4.0
 */
public Task eagerZeroVirtualDisk_Task(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().eagerZeroVirtualDisk_Task(getMOR(), name, datacenter == null ? null : datacenter.getMOR()));
}
    public Task inflateVirtualDisk_Task(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().inflateVirtualDisk_Task(getMOR(), name, datacenter == null ? null : datacenter.getMOR()));
}
    /**
 * keep the old signature for compability
 */
public Task moveVirtualDisk_Task(String sourceName, Datacenter sourceDatacenter, String destName, Datacenter destDatacenter, Boolean force) throws FileFault, RuntimeFault, RemoteException {
    return moveVirtualDisk_Task(sourceName, sourceDatacenter, destName, destDatacenter, force, null);
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
    public Task shrinkVirtualDisk_Task(String name, Datacenter datacenter, boolean copy) throws FileFault, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().shrinkVirtualDisk_Task(getMOR(), name, datacenter == null ? null : datacenter.getMOR(), copy));
}
    public Task zeroFillVirtualDisk_Task(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().zeroFillVirtualDisk_Task(getMOR(), name, datacenter == null ? null : datacenter.getMOR()));
}
    public void importUnmanagedSnapshot(String vdisk, String vvolId) throws InvalidDatastore, NotFound, RuntimeFault, RemoteException {
    importUnmanagedSnapshot(vdisk, null, vvolId);
}
    /* ===== END custom ===== */
}
