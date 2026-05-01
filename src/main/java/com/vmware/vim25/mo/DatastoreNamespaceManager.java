// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class DatastoreNamespaceManager extends ManagedObject {

    public DatastoreNamespaceManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public String convertNamespacePathToUuidPath(Datacenter datacenter, String namespaceUrl) throws InvalidDatastore, InvalidDatastorePath, RuntimeFault, RemoteException {
        return getVimService().convertNamespacePathToUuidPath(getMOR(), datacenter == null ? null : datacenter.getMOR(), namespaceUrl);
    }

    public void deleteDirectory(Datacenter datacenter, String datastorePath) throws FileFault, FileNotFound, InvalidDatastore, InvalidDatastorePath, RuntimeFault, RemoteException {
        getVimService().deleteDirectory(getMOR(), datacenter == null ? null : datacenter.getMOR(), datastorePath);
    }

    public void increaseDirectorySize(Datacenter datacenter, String stableName, long size) throws FileFault, FileNotFound, InvalidArgument, InvalidDatastore, NotSupported, RuntimeFault, RemoteException {
        getVimService().increaseDirectorySize(getMOR(), datacenter == null ? null : datacenter.getMOR(), stableName, size);
    }

    public DatastoreNamespaceManagerDirectoryInfo queryDirectoryInfo(Datacenter datacenter, String stableName) throws FileFault, FileNotFound, InvalidDatastore, NotSupported, RuntimeFault, RemoteException {
        return getVimService().queryDirectoryInfo(getMOR(), datacenter == null ? null : datacenter.getMOR(), stableName);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public String createDirectory(Datastore datastore, String displayName, String policy) throws CannotCreateFile, FileAlreadyExists, InvalidDatastore, RuntimeFault, RemoteException {
    return createDirectory(datastore, displayName, policy, 0L);
}
    public String createDirectory(Datastore datastore, String displayName, String policy, long size) throws CannotCreateFile, FileAlreadyExists, InvalidDatastore, RuntimeFault, RemoteException {
    return getVimService().createDirectory(this.getMOR(), datastore.getMOR(), displayName, policy, size);
}
    /* ===== END custom ===== */
}
