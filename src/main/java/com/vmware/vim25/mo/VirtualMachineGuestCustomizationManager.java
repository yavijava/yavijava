// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class VirtualMachineGuestCustomizationManager extends ManagedObject {

    public VirtualMachineGuestCustomizationManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public Task abortCustomization(VirtualMachine vm, GuestAuthentication auth) throws CustomizationFault, GuestPermissionDenied, InvalidGuestLogin, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().abortCustomization_Task(getMOR(), vm == null ? null : vm.getMOR(), auth);
        return new Task(getServerConnection(), resultMor);
    }

    public Task customize(VirtualMachine vm, GuestAuthentication auth, CustomizationSpec spec, OptionValue[] configParams) throws CustomizationFault, GuestPermissionDenied, InvalidGuestLogin, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().customizeGuest_Task(getMOR(), vm == null ? null : vm.getMOR(), auth, spec, configParams);
        return new Task(getServerConnection(), resultMor);
    }

    public Task startNetwork(VirtualMachine vm, GuestAuthentication auth) throws CustomizationFault, GuestPermissionDenied, InvalidGuestLogin, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().startGuestNetwork_Task(getMOR(), vm == null ? null : vm.getMOR(), auth);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
