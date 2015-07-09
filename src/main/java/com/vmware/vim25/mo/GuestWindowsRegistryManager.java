package com.vmware.vim25.mo;

import com.vmware.vim25.*;

import java.rmi.RemoteException;

/**
 * Copyright 2015 Michael Rice &lt;michael@michaelrice.org&gt;
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @since 6.0
 */
public class GuestWindowsRegistryManager extends ManagedObject {

    /**
     * Constructor
     *
     * @param sc  {@link com.vmware.vim25.mo.ServerConnection ServerConnection}
     * @param mor {@link com.vmware.vim25.ManagedObjectReference ManagedObjectReference} to a GuestWindowsRegistryManager
     */
    public GuestWindowsRegistryManager(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    /**
     * Create a registry key.
     *
     * @param vm         Virtual machine to perform the operation on.
     * @param auth       The guest authentication data.
     * @param keyName    The path to the registry key to be created.
     * @param isVolatile If true, the key is created in memory and is not preserved across system reboot. Otherwise, it shall persist in the file system.
     * @param classType  User defined class type for this key. May be omitted.
     * @throws GuestComponentsOutOfDate       Thrown if the guest agent is too old to support the operation.
     * @throws GuestOperationsFault           Thrown if there is an error processing a guest operation.
     * @throws GuestOperationsUnavailable     Thrown if the VM agent for guest operations is not running.
     * @throws GuestPermissionDenied          Thrown if the program path cannot be run because the guest authentication will not allow the operation.
     * @throws GuestRegistryKeyAlreadyExists  Thrown if the registry key already exists.
     * @throws GuestRegistryKeyInvalid        Thrown if the registry key is not valid. Check the HKEY Root specified.
     * @throws GuestRegistryKeyParentVolatile Thrown if trying to create a non-volatile registry subkey under a volatile registry parent key.
     * @throws InvalidGuestLogin              Thrown if the the guest authentication information was not accepted.
     * @throws InvalidPowerState              Thrown if the VM is not powered on.
     * @throws InvalidState                   Thrown if the operation cannot be performed because of the virtual machine's current state.
     * @throws OperationDisabledByGuest       Thrown if the operation is not enabled due to guest agent configuration.
     * @throws OperationNotSupportedByGuest   Thrown if the operation is not supported by the guest OS.
     * @throws RuntimeFault                   Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
     * @throws TaskInProgress                 Thrown if the virtual machine is busy.
     * @throws RemoteException
     */
    public void createRegistryKeyInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean isVolatile, String classType) throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable,
        GuestPermissionDenied, GuestRegistryKeyAlreadyExists, GuestRegistryKeyInvalid, GuestRegistryKeyParentVolatile, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
        getVimService().createRegistryKeyInGuest(getMOR(), vm.getMOR(), auth, keyName, isVolatile, classType);
    }

    public void createRegistryKeyInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean isVolatile) throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable,
        GuestPermissionDenied, GuestRegistryKeyAlreadyExists, GuestRegistryKeyInvalid, GuestRegistryKeyParentVolatile, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
        createRegistryKeyInGuest(vm, auth, keyName, isVolatile, null);
    }

    /**
     * Delete a registry key.
     *
     * @param vm        Virtual machine to perform the operation on.
     * @param auth      The guest authentication data.
     * @param keyName   The path to the registry key to be deleted.
     * @param recursive If true, the key is deleted along with any subkeys (if present). Otherwise, it shall only delete the key if it has no subkeys.
     * @throws GuestComponentsOutOfDate
     * @throws GuestOperationsFault
     * @throws GuestOperationsUnavailable
     * @throws GuestPermissionDenied
     * @throws GuestRegistryKeyHasSubkeys
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
    public void deleteRegistryKeyInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean recursive) throws GuestComponentsOutOfDate, GuestOperationsFault,
        GuestOperationsUnavailable, GuestPermissionDenied, GuestRegistryKeyHasSubkeys, GuestRegistryKeyInvalid, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest,
        OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
        getVimService().deleteRegistryKeyInGuest(getMOR(), vm.getMOR(), auth, keyName, recursive);
    }

    /**
     * Delete a registry value.
     *
     * @param vm        Virtual machine to perform the operation on.
     * @param auth      The guest authentication data.
     * @param valueName The registry value name to be deleted. The Value "name" (specified in {@link com.vmware.vim25.GuestRegValueNameSpec GuestRegValueNameSpec}) can be empty. If "name" is empty, it deletes the value for the unnamed or default value of the given key.
     * @throws GuestComponentsOutOfDate
     * @throws GuestOperationsFault
     * @throws GuestOperationsUnavailable
     * @throws GuestPermissionDenied
     * @throws GuestRegistryKeyInvalid
     * @throws GuestRegistryValueNotFound
     * @throws InvalidGuestLogin
     * @throws InvalidPowerState
     * @throws InvalidState
     * @throws OperationDisabledByGuest
     * @throws OperationNotSupportedByGuest
     * @throws RuntimeFault
     * @throws TaskInProgress
     * @throws RemoteException
     */
    public void deleteRegistryValueInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegValueNameSpec valueName) throws GuestComponentsOutOfDate, GuestOperationsFault,
        GuestOperationsUnavailable, GuestPermissionDenied, GuestRegistryKeyInvalid, GuestRegistryValueNotFound, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest,
        RuntimeFault, TaskInProgress, RemoteException {
        getVimService().deleteRegistryValueInGuest(getMOR(), vm.getMOR(), auth, valueName);
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
    public GuestRegKeyRecordSpec[] listRegistryKeysInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean recursive, String matchPattern)
        throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable, GuestPermissionDenied, GuestRegistryKeyInvalid, InvalidGuestLogin, InvalidPowerState,
        InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
        return getVimService().listRegistryKeysInGuest(getMOR(), vm.getMOR(), auth, keyName, recursive, matchPattern);
    }

    public GuestRegKeyRecordSpec[] listRegistryKeysInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean recursive)
        throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable, GuestPermissionDenied, GuestRegistryKeyInvalid, InvalidGuestLogin, InvalidPowerState,
        InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
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
    public GuestRegValueSpec[] listRegistryValuesInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean expandStrings, String matchPattern) throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable, GuestPermissionDenied, GuestRegistryKeyInvalid, InvalidGuestLogin, InvalidPowerState,
        InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
        return getVimService().listRegistryValuesInGuest(getMOR(), vm.getMOR(), auth, keyName, expandStrings, matchPattern);
    }

    public GuestRegValueSpec[] listRegistryValuesInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean expandStrings) throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable, GuestPermissionDenied, GuestRegistryKeyInvalid, InvalidGuestLogin, InvalidPowerState,
        InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
        return listRegistryValuesInGuest(vm, auth, keyName, expandStrings, null);
    }

    /**
     * Set/Create a registry value.
     *
     * @param vm    Virtual machine to perform the operation on.
     * @param auth  The guest authentication data.
     * @param value The information for the registry value to be set/created. The Value "name" (specified in {@link com.vmware.vim25.GuestRegValueNameSpec GuestRegValueNameSpec}) and the Value "data" (specified in {@link com.vmware.vim25.GuestRegValueSpec GuestRegValueSpec}) can both be empty. If "name" is empty, it sets the value for the unnamed or default value of the given key.
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
    public void setRegistryValueInGuest(VirtualMachine vm, GuestAuthentication auth, GuestRegValueSpec value) throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable, GuestPermissionDenied, GuestRegistryKeyInvalid, InvalidGuestLogin,
        InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
        getVimService().setRegistryValueInGuest(getMOR(), vm.getMOR(), auth, value);
    }
}
