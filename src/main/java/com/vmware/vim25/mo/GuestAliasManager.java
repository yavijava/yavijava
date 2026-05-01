// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class GuestAliasManager extends ManagedObject {

    public GuestAliasManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void addGuestAlias(VirtualMachine vm, GuestAuthentication auth, String username, boolean mapCert, String base64Cert, GuestAuthAliasInfo aliasInfo) throws GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().addGuestAlias(getMOR(), vm == null ? null : vm.getMOR(), auth, username, mapCert, base64Cert, aliasInfo);
    }

    public void removeGuestAlias(VirtualMachine vm, GuestAuthentication auth, String username, String base64Cert, GuestAuthSubject subject) throws GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().removeGuestAlias(getMOR(), vm == null ? null : vm.getMOR(), auth, username, base64Cert, subject);
    }

    public void removeGuestAliasByCert(VirtualMachine vm, GuestAuthentication auth, String username, String base64Cert) throws GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().removeGuestAliasByCert(getMOR(), vm == null ? null : vm.getMOR(), auth, username, base64Cert);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /**
 * Lists the {@link com.vmware.vim25.GuestAliases GuestAliases} for a specified user in the guest that can be used for authentication of guest operations.
 *
 * @param vm       Virtual machine to perform the operation on.
 * @param auth     The guest authentication data for this operation. See {@link com.vmware.vim25.GuestAuthentication GuestAuthentication}. These credentials must satisfy authentication requirements for a guest account on the specified virtual machine.
 * @param userName The guest user whose Alias store is being queried.
 * @return GuestAliases[]
 * @throws GuestComponentsOutOfDate     Thrown if the guest agent is too old to support the operation.
 * @throws GuestOperationsFault         Thrown if there is an error processing a guest operation.
 * @throws GuestOperationsUnavailable   Thrown if the agent for guest operations is not running.
 * @throws GuestPermissionDenied        Thrown if there are insufficient permissions in the guest OS.
 * @throws InvalidGuestLogin            Thrown if the the guest authentication information was not accepted.
 * @throws InvalidPowerState            Thrown if the VM is not powered on.
 * @throws InvalidState                 Thrown if the operation cannot be performed because of the virtual machine's current state.
 * @throws OperationDisabledByGuest     Thrown if the operation is not enabled due to guest agent configuration.
 * @throws OperationNotSupportedByGuest Thrown if the operation is not supported by the guest OS.
 * @throws RuntimeFault                 Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
 * @throws TaskInProgress               Thrown if the virtual machine is busy.
 * @throws RemoteException
 */
public GuestAliases[] listGuestAliases(VirtualMachine vm, GuestAuthentication auth, String userName) throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable, GuestPermissionDenied, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
    return getVimService().listGuestAliases(getMOR(), vm.getMOR(), auth, userName);
}
    /**
 * Lists the GuestMappedAliases in the guest that can be used for authentication of guest operations.
 *
 * @param vm   {@link com.vmware.vim25.mo.VirtualMachine VirtualMachine} to perform the operation on.
 * @param auth {@link com.vmware.vim25.GuestAuthentication GuestAuthentication} The guest authentication data for this operation. These credentials must satisfy authentication requirements for a guest account on the specified virtual machine.
 * @return GuestMappedAliases[]
 * @throws GuestComponentsOutOfDate     Thrown if the guest agent is too old to support the operation.
 * @throws GuestOperationsFault         Thrown if there is an error processing a guest operation.
 * @throws GuestOperationsUnavailable   Thrown if the VM agent for guest operations is not running.
 * @throws GuestPermissionDenied        Thrown if there are insufficient permissions in the guest OS.
 * @throws InvalidGuestLogin            Thrown if the the guest authentication information was not accepted.
 * @throws InvalidPowerState            Thrown if the VM is not powered on.
 * @throws InvalidState                 Thrown if the operation cannot be performed because of the virtual machine's current state.
 * @throws OperationDisabledByGuest     Thrown if the operation is not enabled due to guest agent configuration.
 * @throws OperationNotSupportedByGuest Thrown if the operation is not supported by the guest OS.
 * @throws RuntimeFault                 Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
 * @throws TaskInProgress               Thrown if the virtual machine is busy.
 * @throws RemoteException
 */
public GuestMappedAliases[] listGuestMappedAliases(VirtualMachine vm, GuestAuthentication auth) throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable, GuestPermissionDenied, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
    return getVimService().listGuestMappedAliases(getMOR(), vm.getMOR(), auth);
}
    /* ===== END custom ===== */
}
