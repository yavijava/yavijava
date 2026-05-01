// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class FileManager extends ManagedObject {

    public FileManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void changeOwner(String name, Datacenter datacenter, String owner) throws FileFault, InvalidDatastore, UserNotFound, RuntimeFault, RemoteException {
        getVimService().changeOwner(getMOR(), name, datacenter == null ? null : datacenter.getMOR(), owner);
    }

    public Task copyFile(String sourceName, Datacenter sourceDatacenter, String destinationName, Datacenter destinationDatacenter, boolean force) throws FileFault, InvalidDatastore, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().copyDatastoreFile_Task(getMOR(), sourceName, sourceDatacenter == null ? null : sourceDatacenter.getMOR(), destinationName, destinationDatacenter == null ? null : destinationDatacenter.getMOR(), force);
        return new Task(getServerConnection(), resultMor);
    }

    public Task deleteFile(String name, Datacenter datacenter) throws FileFault, InvalidDatastore, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().deleteDatastoreFile_Task(getMOR(), name, datacenter == null ? null : datacenter.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public void makeDirectory(String name, Datacenter datacenter, boolean createParentDirectories) throws FileFault, InvalidDatastore, RuntimeFault, RemoteException {
        getVimService().makeDirectory(getMOR(), name, datacenter == null ? null : datacenter.getMOR(), createParentDirectories);
    }

    public Task moveFile(String sourceName, Datacenter sourceDatacenter, String destinationName, Datacenter destinationDatacenter, boolean force) throws FileFault, InvalidDatastore, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().moveDatastoreFile_Task(getMOR(), sourceName, sourceDatacenter == null ? null : sourceDatacenter.getMOR(), destinationName, destinationDatacenter == null ? null : destinationDatacenter.getMOR(), force);
        return new Task(getServerConnection(), resultMor);
    }

    public FileLockInfoResult queryFileLockInfo(String path, HostSystem host) throws FileFault, InvalidDatastore, RuntimeFault, RemoteException {
        return getVimService().queryFileLockInfo(getMOR(), path, host == null ? null : host.getMOR());
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
