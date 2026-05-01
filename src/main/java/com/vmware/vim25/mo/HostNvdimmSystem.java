// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostNvdimmSystem extends ManagedObject {

    public HostNvdimmSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public NvdimmSystemInfo getNvdimmSystemInfo() {
        return (NvdimmSystemInfo) getCurrentProperty("nvdimmSystemInfo");
    }

    public Task createNamespace(NvdimmNamespaceCreateSpec createSpec) throws AlreadyExists, HostConfigFault, InvalidHostState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createNvdimmNamespace_Task(getMOR(), createSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task createPMemNamespace(NvdimmPMemNamespaceCreateSpec createSpec) throws AlreadyExists, HostConfigFault, InvalidHostState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createNvdimmPMemNamespace_Task(getMOR(), createSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task deleteBlockNamespaces() throws HostConfigFault, InvalidHostState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().deleteNvdimmBlockNamespaces_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task deleteNamespace(NvdimmNamespaceDeleteSpec deleteSpec) throws HostConfigFault, InvalidHostState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().deleteNvdimmNamespace_Task(getMOR(), deleteSpec);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
