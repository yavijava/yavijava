// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostDatastoreBrowser extends ManagedObject {

    public HostDatastoreBrowser(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public Datastore[] getDatastore() {
        return getDatastores("datastore");
    }

    public FileQuery[] getSupportedType() {
        return (FileQuery[]) getCurrentProperty("supportedType");
    }

    public void deleteFile(String datastorePath) throws FileFault, InvalidDatastore, RuntimeFault, RemoteException {
        getVimService().deleteFile(getMOR(), datastorePath);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /** Backward-compat alias for {@link #getDatastore()}. */
    public Datastore[] getDatastores() {
        return getDatastore();
    }
    public Task searchDatastore_Task(String datastorePath, HostDatastoreBrowserSearchSpec searchSpec) throws FileFault, InvalidDatastore, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().searchDatastore_Task(getMOR(), datastorePath, searchSpec));
}
    public Task searchDatastoreSubFolders_Task(String datastorePath, HostDatastoreBrowserSearchSpec searchSpec) throws FileFault, InvalidDatastore, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().searchDatastoreSubFolders_Task(getMOR(), datastorePath, searchSpec));
}
    /* ===== END custom ===== */
}
