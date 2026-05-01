// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class GuestAuthManager extends ManagedObject {

    public GuestAuthManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void releaseCredentialsInGuest(VirtualMachine vm, GuestAuthentication auth) throws GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().releaseCredentialsInGuest(getMOR(), vm == null ? null : vm.getMOR(), auth);
    }

    public void validateCredentialsInGuest(VirtualMachine vm, GuestAuthentication auth) throws GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().validateCredentialsInGuest(getMOR(), vm == null ? null : vm.getMOR(), auth);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    private VirtualMachine vm = null;
    public VirtualMachine getVM() {
    return vm;
}
    public GuestAuthentication acquireCredentialsInGuest(GuestAuthentication requestedAuth, long sessionID) throws GuestOperationsFault, TaskInProgress, InvalidState, RuntimeFault, RemoteException {
    return getVimService().acquireCredentialsInGuest(this.getMOR(), vm.getMOR(), requestedAuth, sessionID);
}
    /* ===== END custom ===== */
}
