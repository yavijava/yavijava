// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class GuestWindowsRegistryManager extends ManagedObject {

    public GuestWindowsRegistryManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void createRegistryKeyInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean isVolatile, String classType) throws GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().createRegistryKeyInGuest(getMOR(), vm == null ? null : vm.getMOR(), auth, keyName, isVolatile, classType);
    }

    public void deleteRegistryKeyInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean recursive) throws GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().deleteRegistryKeyInGuest(getMOR(), vm == null ? null : vm.getMOR(), auth, keyName, recursive);
    }

    public void deleteRegistryValueInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegValueNameSpec valueName) throws GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().deleteRegistryValueInGuest(getMOR(), vm == null ? null : vm.getMOR(), auth, valueName);
    }

    public void setRegistryValueInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegValueSpec value) throws GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().setRegistryValueInGuest(getMOR(), vm == null ? null : vm.getMOR(), auth, value);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public void createRegistryKeyInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean isVolatile) throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable, GuestPermissionDenied, GuestRegistryKeyAlreadyExists, GuestRegistryKeyInvalid, GuestRegistryKeyParentVolatile, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
    createRegistryKeyInGuest(vm, auth, keyName, isVolatile, null);
}
    /**
 * List all registry subkeys for a given registry key.
 *
 * @param vm           Virtual machine to perform the operation on.
 * @param auth         The guest authentication data.
 * @param keyName      The path to the registry key for which all subkeys are to be listed.
 * @param recursive    If true, all subkeys are listed recursively.
 * @param matchPattern A filter for the key names returned, specified using perl-compatible regular expressions. If matchPattern is unset, then the pattern '.*' is used, which returns all key names found, otherwise only those key names that match the input pattern shall be returned.
 * @return GuestRegKeyRecordSpec[] The list of subkeys is returned in an array of GuestRegKeySpec structures.
 * @throws GuestComponentsOutOfDate
 * @throws GuestOperationsFault
 * @throws GuestOperationsUnavailable
 * @throws GuestPermissionDenied
 * @throws GuestRegistryKeyInvalid
 * @throws InvalidGuestLogin
 * @throws InvalidPowerState
 * @throws InvalidState
 * @throws OperationDisabledByGuest
 * @throws OperationNotSupportedByGuest
 * @throws RuntimeFault
 * @throws TaskInProgress
 * @throws RemoteException
 */
public GuestRegKeyRecordSpec[] listRegistryKeysInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean recursive, String matchPattern) throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable, GuestPermissionDenied, GuestRegistryKeyInvalid, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
    return getVimService().listRegistryKeysInGuest(getMOR(), vm.getMOR(), auth, keyName, recursive, matchPattern);
}
    public GuestRegKeyRecordSpec[] listRegistryKeysInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean recursive) throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable, GuestPermissionDenied, GuestRegistryKeyInvalid, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
    return listRegistryKeysInGuest(vm, auth, keyName, recursive, null);
}
    /**
 * List all registry values for a given registry key.
 *
 * @param vm            Virtual machine to perform the operation on.
 * @param auth          The guest authentication data.
 * @param keyName       The path to the registry key for which all subkeys are to be listed.
 * @param expandStrings If true, all values that have expandable data such as environment variable names, shall get expanded in the result.
 * @param matchPattern  A filter for the value names returned, specified using perl-compatible regular expressions. If matchPattern is unset, then the pattern '.*' is used, which returns all value names found, otherwise only those value names that match the input pattern shall be returned.
 * @return The list of values is returned in an array of {@link com.vmware.vim25.GuestRegValueNameSpec GuestRegValueSpec} structures.
 * @throws GuestComponentsOutOfDate
 * @throws GuestOperationsFault
 * @throws GuestOperationsUnavailable
 * @throws GuestPermissionDenied
 * @throws GuestRegistryKeyInvalid
 * @throws InvalidGuestLogin
 * @throws InvalidPowerState
 * @throws InvalidState
 * @throws OperationDisabledByGuest
 * @throws OperationNotSupportedByGuest
 * @throws RuntimeFault
 * @throws TaskInProgress
 * @throws RemoteException
 */
public GuestRegValueSpec[] listRegistryValuesInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean expandStrings, String matchPattern) throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable, GuestPermissionDenied, GuestRegistryKeyInvalid, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
    return getVimService().listRegistryValuesInGuest(getMOR(), vm.getMOR(), auth, keyName, expandStrings, matchPattern);
}
    public GuestRegValueSpec[] listRegistryValuesInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean expandStrings) throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable, GuestPermissionDenied, GuestRegistryKeyInvalid, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
    return listRegistryValuesInGuest(vm, auth, keyName, expandStrings, null);
}
    /* ===== END custom ===== */
}
