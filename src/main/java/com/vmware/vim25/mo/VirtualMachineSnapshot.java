// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class VirtualMachineSnapshot extends ExtensibleManagedObject {

    public VirtualMachineSnapshot(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public VirtualMachineConfigInfo getConfig() {
        return (VirtualMachineConfigInfo) getCurrentProperty("config");
    }

    public HttpNfcLease exportSnapshot() throws FileFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().exportSnapshot(getMOR());
        return new HttpNfcLease(getServerConnection(), resultMor);
    }

    public void rename(String name, String description) throws InvalidName, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().renameSnapshot(getMOR(), name, description);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /**
 * @since SDK4.1
 */
public VirtualMachineSnapshot[] getChildSnapshot() {
    ManagedObjectReference[] mors = (ManagedObjectReference[]) getCurrentProperty("childSnapshot");
    VirtualMachineSnapshot[] vmns = new VirtualMachineSnapshot[mors.length];
    for (int i = 0; i < mors.length; i++) {
        vmns[i] = new VirtualMachineSnapshot(getServerConnection(), mors[i]);
    }
    return vmns;
}
    //SDK4.1 signature for back compatibility
public Task removeSnapshot_Task(boolean removeChildren) throws TaskInProgress, RuntimeFault, RemoteException {
    return removeSnapshot_Task(removeChildren, null);
}
    //SDK5.0 signature
public Task removeSnapshot_Task(boolean removeChildren, Boolean consolidate) throws TaskInProgress, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().removeSnapshot_Task(getMOR(), removeChildren, consolidate));
}
    //SDK2.5 signature for back compatibility
public Task revertToSnapshot_Task(HostSystem host) throws VmConfigFault, TaskInProgress, FileFault, InvalidState, InsufficientResourcesFault, RuntimeFault, RemoteException {
    return revertToSnapshot_Task(host, null);
}
    //SDK4.0 signature
public Task revertToSnapshot_Task(HostSystem host, Boolean suppressPowerOn) throws VmConfigFault, TaskInProgress, FileFault, InvalidState, InsufficientResourcesFault, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().revertToSnapshot_Task(getMOR(), host == null ? null : host.getMOR(), suppressPowerOn));
}
    /**
 * Get the virtual machine for which the snapshot was taken.
 *
 * @return {@link com.vmware.vim25.mo.VirtualMachine VirtualMachine}
 * @since 6.0
 */
public VirtualMachine getVm() {
    ManagedObjectReference mor = (ManagedObjectReference) getCurrentProperty("vm");
    return new VirtualMachine(getServerConnection(), mor);
}
    /* ===== END custom ===== */
}
