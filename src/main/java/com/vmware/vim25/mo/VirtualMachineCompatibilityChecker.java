// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.NoActiveHostInCluster;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class VirtualMachineCompatibilityChecker extends ManagedObject {

    public VirtualMachineCompatibilityChecker(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public Task checkCompatibility_Task(VirtualMachine vm, HostSystem host, ResourcePool pool, String[] testType) throws DatacenterMismatch, InvalidArgument, InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().checkCompatibility_Task(getMOR(), vm == null ? null : vm.getMOR(), host == null ? null : host.getMOR(), pool == null ? null : pool.getMOR(), testType);
        return new Task(getServerConnection(), resultMor);
    }

    public Task checkPowerOn_Task(VirtualMachine vm, HostSystem host, ResourcePool pool, String[] testType) throws DatacenterMismatch, InvalidArgument, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().checkPowerOn_Task(getMOR(), vm == null ? null : vm.getMOR(), host == null ? null : host.getMOR(), pool == null ? null : pool.getMOR(), testType);
        return new Task(getServerConnection(), resultMor);
    }

    public Task checkVmConfig_Task(VirtualMachineConfigSpec spec, VirtualMachine vm, HostSystem host, ResourcePool pool, String[] testType) throws DatacenterMismatch, InvalidArgument, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().checkVmConfig_Task(getMOR(), spec, vm == null ? null : vm.getMOR(), host == null ? null : host.getMOR(), pool == null ? null : pool.getMOR(), testType);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
