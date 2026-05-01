// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class OverheadMemoryManager extends ManagedObject {

    public OverheadMemoryManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /**
 * Return static VM overhead memory value in bytes for a (vm, host) pair from the overhead memory module (OMM)
 * in Virtual Center.
 *
 * @param vm   The Virtual Machine
 * @param host The Host
 * @return Overhead memory value, if found in the OMM.
 * @throws InvalidArgument
 * @throws InvalidType
 * @throws ManagedObjectNotFound
 * @throws NotFound
 * @throws RuntimeFault
 * @throws RemoteException
 */
public long lookupVmOverheadMemory(VirtualMachine vm, HostSystem host) throws InvalidArgument, InvalidType, ManagedObjectNotFound, NotFound, RuntimeFault, RemoteException {
    return getVimService().lookupVmOverheadMemory(getMOR(), vm.getMOR(), host.getMOR());
}
    /* ===== END custom ===== */
}
