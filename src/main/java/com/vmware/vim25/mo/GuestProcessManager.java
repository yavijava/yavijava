// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class GuestProcessManager extends ManagedObject {

    public GuestProcessManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public GuestProcessInfo[] listProcessesInGuest(VirtualMachine vm, GuestAuthentication auth, long[] pids) throws GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        return getVimService().listProcessesInGuest(getMOR(), vm == null ? null : vm.getMOR(), auth, pids);
    }

    public String[] readEnvironmentVariableInGuest(VirtualMachine vm, GuestAuthentication auth, String[] names) throws GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        return getVimService().readEnvironmentVariableInGuest(getMOR(), vm == null ? null : vm.getMOR(), auth, names);
    }

    public long startProgramInGuest(VirtualMachine vm, GuestAuthentication auth, GuestProgramSpec spec) throws FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        return getVimService().startProgramInGuest(getMOR(), vm == null ? null : vm.getMOR(), auth, spec);
    }

    public void terminateProcessInGuest(VirtualMachine vm, GuestAuthentication auth, long pid) throws GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().terminateProcessInGuest(getMOR(), vm == null ? null : vm.getMOR(), auth, pid);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    private VirtualMachine vm = null;
    public VirtualMachine getVM() {
    return vm;
}
    public GuestProcessInfo[] listProcessesInGuest(GuestAuthentication auth, long[] pids) throws GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
    return getVimService().listProcessesInGuest(getMOR(), vm.getMOR(), auth, pids);
}
    public String[] readEnvironmentVariableInGuest(GuestAuthentication auth, String[] names) throws GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
    return getVimService().readEnvironmentVariableInGuest(getMOR(), vm.getMOR(), auth, names);
}
    public long startProgramInGuest(GuestAuthentication auth, GuestProgramSpec spec) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException {
    return getVimService().startProgramInGuest(getMOR(), vm.getMOR(), auth, spec);
}
    /* ===== END custom ===== */
}
