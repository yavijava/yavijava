package com.vmware.vim25.mo;

import com.vmware.vim25.ManagedObjectReference;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Verifies that Guest*Manager convenience overloads are reachable — i.e., that GuestOperationsManager
 * injects the VirtualMachine reference into the returned managers (issue: vm field was always null).
 */
public class GuestManagersTest {

    private static ManagedObjectReference mor(String type, String val) {
        ManagedObjectReference m = new ManagedObjectReference();
        m.setType(type);
        m.setVal(val);
        return m;
    }

    @Test
    public void guestFileManager_setVM_storesVmForConvenienceOverloads() {
        GuestFileManager fm = new GuestFileManager(null, mor("GuestFileManager", "fm-1"));
        VirtualMachine vm = new VirtualMachine(null, mor("VirtualMachine", "vm-1"));

        assertNull("vm should be null before setVM", fm.getVM());
        fm.setVM(vm);
        assertSame("getVM() must return the vm passed to setVM", vm, fm.getVM());
    }

    @Test
    public void guestProcessManager_setVM_storesVmForConvenienceOverloads() {
        GuestProcessManager pm = new GuestProcessManager(null, mor("GuestProcessManager", "pm-1"));
        VirtualMachine vm = new VirtualMachine(null, mor("VirtualMachine", "vm-1"));

        assertNull("vm should be null before setVM", pm.getVM());
        pm.setVM(vm);
        assertSame("getVM() must return the vm passed to setVM", vm, pm.getVM());
    }

    @Test
    public void guestAuthManager_setVM_storesVmForConvenienceOverloads() {
        GuestAuthManager am = new GuestAuthManager(null, mor("GuestAuthManager", "am-1"));
        VirtualMachine vm = new VirtualMachine(null, mor("VirtualMachine", "vm-1"));

        assertNull("vm should be null before setVM", am.getVM());
        am.setVM(vm);
        assertSame("getVM() must return the vm passed to setVM", vm, am.getVM());
    }
}
