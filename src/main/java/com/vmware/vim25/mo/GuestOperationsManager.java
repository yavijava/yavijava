// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.ManagedObjectReference;
/* ===== END custom imports ===== */

public class GuestOperationsManager extends ManagedObject {

    public GuestOperationsManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public GuestAuthManager getAuthManager() {
        return (GuestAuthManager) this.getManagedObject("authManager");
    }

    public GuestFileManager getFileManager() {
        return (GuestFileManager) this.getManagedObject("fileManager");
    }

    public GuestProcessManager getProcessManager() {
        return (GuestProcessManager) this.getManagedObject("processManager");
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public GuestAuthManager getAuthManager(VirtualMachine vm) {
    ManagedObjectReference mor = (ManagedObjectReference) getCurrentProperty("authManager");
    return new GuestAuthManager(getServerConnection(), mor);
}
    public GuestFileManager getFileManager(VirtualMachine vm) {
    ManagedObjectReference mor = (ManagedObjectReference) getCurrentProperty("fileManager");
    return new GuestFileManager(getServerConnection(), mor);
}
    public GuestProcessManager getProcessManager(VirtualMachine vm) {
    ManagedObjectReference mor = (ManagedObjectReference) getCurrentProperty("processManager");
    return new GuestProcessManager(getServerConnection(), mor);
}
    /**
 * A managed object that provides methods to support single sign-on in the guest operating system.
 *
 * @return {@link com.vmware.vim25.mo.GuestAliasManager GuestAliasManager}
 * @since 6.0
 */
public GuestAliasManager getAliasManager() {
    ManagedObjectReference mor = (ManagedObjectReference) getCurrentProperty("aliasManager");
    return new GuestAliasManager(getServerConnection(), mor);
}
    /**
 * A singleton managed object that provides methods for guest windows registry operations.
 *
 * @return GuestWindowsRegistryManager
 */
public GuestWindowsRegistryManager getGuestWindowsRegistryManager() {
    ManagedObjectReference mor = (ManagedObjectReference) getCurrentProperty("guestWindowsRegistryManager");
    return new GuestWindowsRegistryManager(getServerConnection(), mor);
}
    /* ===== END custom ===== */
}
