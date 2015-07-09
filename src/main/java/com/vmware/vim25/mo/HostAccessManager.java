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
public class HostAccessManager extends ManagedObject {

    /**
     * Constructor
     *
     * @param sc  ServerConnection
     * @param mor ManagedObjectReference
     */
    public HostAccessManager(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    /**
     * Current lockdown state of the host.
     *
     * @return {@link com.vmware.vim25.HostLockdownMode HostLockdownMode}
     */
    public HostLockdownMode getLockdownMode() {
        return (HostLockdownMode) getCurrentProperty("lockdownMode");
    }

    /**
     * Update the access mode for a user or group.
     * If the host is in lockdown mode, this operation is allowed only on users in the exceptions list - see
     * {@link com.vmware.vim25.mo.HostAccessManager#queryLockdownExceptions QueryLockdownExceptions}, and trying to
     * change the access mode of other users or groups will fail with SecurityError.
     *
     * @param principal  The affected user or group.
     * @param isGroup    True if principal refers to a group account, false otherwise.
     * @param accessMode AccessMode to be granted. AccessMode#accessOther is meaningless and will result in InvalidArgument exception.
     * @throws AuthMinimumAdminPermission
     * @throws InvalidArgument
     * @throws RuntimeFault
     * @throws SecurityError
     * @throws UserNotFound
     * @throws RemoteException
     */
    public void changeAccessMode(String principal, boolean isGroup, HostAccessMode accessMode) throws AuthMinimumAdminPermission, InvalidArgument, RuntimeFault, SecurityError, UserNotFound, RemoteException {
        getVimService().changeAccessMode(getMOR(), principal, isGroup, accessMode);
    }

    /**
     * Changes the lockdown state of the ESXi host.
     * <p>
     * This operation will do nothing if the host is already in the desired lockdown state.
     * When the host is in lockdown mode it can be managed only through vCenter and through DCUI
     * (Direct Console User Interface) if the DCUI service is running. This is achieved by removing all permissions on
     * the host, except those of the exception users defined with UpdateLockdownExceptions.
     * In addition, the permissions for users 'dcui', 'vpxuser' and 'vslauser' are always preserved. When lockdown mode
     * is disabled, the system will try to restore all permissions that have been removed when lockdown mode was
     * enabled. It is possible that not all permissions may be restored and this is not an error, e.g. if in the
     * meantime some user or managed object was deleted.
     * <p>
     * It may be possible that after exiting lockdown mode the only permissions on the host will be those of users
     * 'dcui' and 'vpxuser'. This will render the host unmanageable if it is not already managed by vCenter, or if the
     * connection to vCenter is lost. To prevent this, the users in the "DCUI.Access" list will be assigned Admin roles.
     * While the host is in lockdown mode, some operations will fail with SecurityError. This ensures that the
     * conditions for lockdown mode cannot be changed. For example it is allowed to change the access mode only for
     * users in the exceptions list.
     * <p>
     * When the host is in lockdown mode, changing the running state of service DCUI through HostServiceSystem will also
     * fail with SecurityError accompanied with an appropriate localizeable message.
     * <p>
     * If mode is the same as the current lockdown mode state, the operation will silently succeed and nothing will be changed.
     * If mode is LockdownMode#lockdownDisabled then lockdown mode will be disabled and the system will start service DCUI if it is not running.
     * If mode is LockdownMode#lockdownNormal then lockdown mode will be enabled and the system will start service DCUI if it is not running.
     * If mode is LockdownMode#lockdownStrict then lockdown mode will be enabled and the system will stop service DCUI if it is running.
     *
     * @param mode The new desired lockdown mode.
     * @throws AuthMinimumAdminPermission
     * @throws NoPermission
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public void changeLockdownMode(HostLockdownMode mode) throws AuthMinimumAdminPermission, NoPermission, RuntimeFault, RemoteException {
        getVimService().changeHostLockdownMode(getMOR(), mode);
    }

    /**
     * Get the list of users which are exceptions for lockdown mode.
     *
     * @return The list of users which will not lose their permissions when the host enters lockdown mode.
     * @throws RuntimeFault
     * @throws RemoteException
     * @see #updateLockdownExceptions UpdateLockdownExceptions.
     */
    public String[] queryLockdownExceptions() throws RuntimeFault, RemoteException {
        return getVimService().queryLockdownExceptions(getMOR());
    }

    /**
     * Get the list of local system users.
     * <p>
     * These are special users like 'vpxuser', 'vslauser' and 'dcui', which may be used for authenticating different
     * sub-components of the vSphere system and may be essential for its correct functioning.
     * Usually these users may not be used by human operators to connect directly to the host and the UI may choose to
     * show them only in some "advanced" UI view.
     *
     * @return The list of local system users.
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public String[] querySystemUsers() throws RuntimeFault, RemoteException {
        return getVimService().querySystemUsers(getMOR());
    }

    /**
     * Retrieve access entries. Returns a list of AccessEntry objects for each VIM user or group which have explicitly
     * assigned permissions on the host. This means that AccessMode#accessNone will not be present in the result.
     *
     * @return A list of AccessEntry objects.
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public HostAccessControlEntry[] retrieveHostAccessControlEntries() throws RuntimeFault, RemoteException {
        return getVimService().retrieveHostAccessControlEntries(getMOR());
    }

    /**
     * Update the list of users which are exceptions for lockdown mode.
     * <p>
     * Usually these are user accounts used by third party solutions and external applications which need to continue to
     * function in lockdown mode. It is not advised to add user accounts used by human operators, because this will
     * compromise the purpose of lockdown mode.
     * <p>
     * Both local and domain users are supported. The format for domain accounts is "DOMAIN\login".
     * <p>
     * When this API is called when the host is in lockdown mode, the behaviour is as follows:
     * if a user is removed from the exceptions list, then the permissions of that user are removed.
     * if a user is added to the exceptions list, then the permissions of that user are restored.
     *
     * @param users The new list of lockdown mode exceptions.
     * @throws AuthMinimumAdminPermission
     * @throws RuntimeFault
     * @throws UserNotFound
     * @throws RemoteException
     */
    public void updateLockdownExceptions(String[] users) throws AuthMinimumAdminPermission, RuntimeFault, UserNotFound, RemoteException {
        getVimService().updateLockdownExceptions(getMOR(), users);
    }

    public void updateLockdownExceptions() throws AuthMinimumAdminPermission, RuntimeFault, UserNotFound, RemoteException {
        updateLockdownExceptions(null);
    }

    /**
     * Update the list of local system users. The special users 'dcui', 'vpxuser' and 'vslauser' need not be specified.
     * They are always reported in the list of system users.
     *
     * @param users The new list of local system users.
     * @throws InvalidArgument
     * @throws RuntimeFault
     * @throws UserNotFound
     * @throws RemoteException
     */
    public void updateSystemUsers(String[] users) throws InvalidArgument, RuntimeFault, UserNotFound, RemoteException {
        getVimService().updateSystemUsers(getMOR(), users);
    }

    public void updateSystemUsers() throws InvalidArgument, RuntimeFault, UserNotFound, RemoteException {
        updateSystemUsers(null);
    }
}
