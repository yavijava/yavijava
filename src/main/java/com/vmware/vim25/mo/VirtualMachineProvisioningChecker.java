// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class VirtualMachineProvisioningChecker extends ManagedObject {

    public VirtualMachineProvisioningChecker(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public Task checkClone_Task(VirtualMachine vm, Folder folder, String name, VirtualMachineCloneSpec spec, String[] testType) throws InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().checkClone_Task(getMOR(), vm == null ? null : vm.getMOR(), folder == null ? null : folder.getMOR(), name, spec, testType);
        return new Task(getServerConnection(), resultMor);
    }

    public Task checkInstantClone_Task(VirtualMachine vm, VirtualMachineInstantCloneSpec spec, String[] testType) throws InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().checkInstantClone_Task(getMOR(), vm == null ? null : vm.getMOR(), spec, testType);
        return new Task(getServerConnection(), resultMor);
    }

    public Task checkMigrate_Task(VirtualMachine vm, HostSystem host, ResourcePool pool, VirtualMachinePowerState state, String[] testType) throws InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().checkMigrate_Task(getMOR(), vm == null ? null : vm.getMOR(), host == null ? null : host.getMOR(), pool == null ? null : pool.getMOR(), state, testType);
        return new Task(getServerConnection(), resultMor);
    }

    public Task checkRelocate_Task(VirtualMachine vm, VirtualMachineRelocateSpec spec, String[] testType) throws InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().checkRelocate_Task(getMOR(), vm == null ? null : vm.getMOR(), spec, testType);
        return new Task(getServerConnection(), resultMor);
    }

    public Task queryVMotionCompatibilityEx_Task(VirtualMachine[] vm, HostSystem[] host) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().queryVMotionCompatibilityEx_Task(getMOR(), vm == null ? null : MorUtil.createMORs(vm), host == null ? null : MorUtil.createMORs(host));
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
