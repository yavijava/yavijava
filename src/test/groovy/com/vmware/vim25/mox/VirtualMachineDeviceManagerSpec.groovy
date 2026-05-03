package com.vmware.vim25.mox

import com.vmware.vim25.VirtualDevice
import com.vmware.vim25.VirtualDisk
import com.vmware.vim25.VirtualDiskMode
import com.vmware.vim25.VirtualDiskType
import com.vmware.vim25.VirtualMachineConfigSpec
import com.vmware.vim25.VirtualSCSIController
import com.vmware.vim25.mo.Task
import com.vmware.vim25.mo.VirtualMachine
import spock.lang.Specification

class VirtualMachineDeviceManagerSpec extends Specification {

    def "createHardDisk sets capacityInKB correctly for large disk over 2 TB"() {
        setup:
        VirtualSCSIController scsiController = new VirtualSCSIController()
        scsiController.key = 1000
        scsiController.scsiCtlrUnitNumber = 7
        // device == null so getFirstFreeUnitNumberForController returns 0 immediately

        VirtualMachine vm = Mock(VirtualMachine)
        vm.getPropertyByPath("config.hardware.device") >> ([scsiController] as VirtualDevice[])

        VirtualMachineConfigSpec[] captured = [null]
        Task mockTask = Mock(Task)
        vm.reconfigVM_Task(_) >> { args -> captured[0] = args[0]; mockTask }
        mockTask.waitForTask(_, _) >> "success"

        VirtualMachineDeviceManager manager = new VirtualMachineDeviceManager(vm)
        int diskSizeMB = 2_500_000  // ~2.4 TB — overflows with int * int arithmetic

        when:
        manager.createHardDisk(diskSizeMB, VirtualDiskType.thin, VirtualDiskMode.persistent)

        then:
        VirtualDisk disk = captured[0].deviceChange[0].device as VirtualDisk
        disk.capacityInKB == (long) diskSizeMB * 1024L
    }
}
