package com.vmware.vim25.mo.util

import com.vmware.vim25.ManagedObjectReference
import com.vmware.vim25.mo.ManagedObject
import com.vmware.vim25.mo.ServerConnection
import com.vmware.vim25.mo.VirtualMachine
import spock.lang.Specification

public class MorUtilTestSpec extends Specification {

    public void 'test CreateExactManagedObject using VirtualMachine'() throws Exception {

        setup:
        ServerConnection serverConnection = Mock(ServerConnection)
        ManagedObjectReference mor = Mock(ManagedObjectReference)
        mor.type = "VirtualMachine"
        mor.val = "vm-12345"

        when:
        VirtualMachine vm = (VirtualMachine) MorUtil.createExactManagedObject(serverConnection, mor)

        then:
        vm == mor.val
    }

    public void 'test createMORs throws IllegalArgumentException when mos is null'() {
        setup:
        ManagedObject[] mos = null;

        when:
        MorUtil.createMORs(mos)

        then:
        thrown(IllegalArgumentException)
    }

    public void 'test createMORs returns array of ManagedObjectReference'() {

        setup:
        ServerConnection serverConnection = Mock(ServerConnection)
        ManagedObjectReference mor1 = new ManagedObjectReference()
        mor1.type = "VirtualMachine"
        mor1.val = "vm-12310"
        VirtualMachine vm1 = (VirtualMachine) MorUtil.createExactManagedObject(serverConnection, mor1)

        ManagedObjectReference mor2 = new ManagedObjectReference()
        mor2.type = "VirtualMachine"
        mor2.val = "vm-12311"
        VirtualMachine vm2 = (VirtualMachine) MorUtil.createExactManagedObject(serverConnection, mor2)
        ManagedObject[] mos = [vm1,vm2]

        when:
        // Here we pass in an array of managed objects and get back an array
        // of managed object references
        ManagedObjectReference[] mORs = MorUtil.createMORs(mos)

        then:
        mORs[0].val == mor1.val
    }
}