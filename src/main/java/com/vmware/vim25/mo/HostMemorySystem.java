// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostMemorySystem extends ExtensibleManagedObject {

    public HostMemorySystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public ServiceConsoleReservationInfo getConsoleReservationInfo() {
        return (ServiceConsoleReservationInfo) getCurrentProperty("consoleReservationInfo");
    }

    public VirtualMachineMemoryReservationInfo getVirtualMachineReservationInfo() {
        return (VirtualMachineMemoryReservationInfo) getCurrentProperty("virtualMachineReservationInfo");
    }

    public void reconfigureServiceConsoleReservation(long cfgBytes) throws RuntimeFault, RemoteException {
        getVimService().reconfigureServiceConsoleReservation(getMOR(), cfgBytes);
    }

    public void reconfigureVirtualMachineReservation(VirtualMachineMemoryReservationSpec spec) throws RuntimeFault, RemoteException {
        getVimService().reconfigureVirtualMachineReservation(getMOR(), spec);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
