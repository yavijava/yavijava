// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostAccessManager extends ManagedObject {

    public HostAccessManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostLockdownMode getLockdownMode() {
        return (HostLockdownMode) getCurrentProperty("lockdownMode");
    }

    public void changeAccessMode(String principal, boolean isGroup, HostAccessMode accessMode) throws AuthMinimumAdminPermission, UserNotFound, RuntimeFault, RemoteException {
        getVimService().changeAccessMode(getMOR(), principal, isGroup, accessMode);
    }

    public void changeLockdownMode(HostLockdownMode mode) throws AuthMinimumAdminPermission, RuntimeFault, RemoteException {
        getVimService().changeLockdownMode(getMOR(), mode);
    }

    public void updateLockdownExceptions(String[] users) throws AuthMinimumAdminPermission, UserNotFound, RuntimeFault, RemoteException {
        getVimService().updateLockdownExceptions(getMOR(), users);
    }

    public void updateSystemUsers(String[] users) throws UserNotFound, RuntimeFault, RemoteException {
        getVimService().updateSystemUsers(getMOR(), users);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
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
    public void updateLockdownExceptions() throws AuthMinimumAdminPermission, RuntimeFault, UserNotFound, RemoteException {
    updateLockdownExceptions(null);
}
    public void updateSystemUsers() throws InvalidArgument, RuntimeFault, UserNotFound, RemoteException {
    updateSystemUsers(null);
}
    /* ===== END custom ===== */
}
