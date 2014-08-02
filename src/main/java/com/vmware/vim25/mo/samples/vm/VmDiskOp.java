/*================================================================================
Copyright (c) 2008 VMware, Inc. All Rights Reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

 * Redistributions of source code must retain the above copyright notice, 
this list of conditions and the following disclaimer.

 * Redistributions in binary form must reproduce the above copyright notice, 
this list of conditions and the following disclaimer in the documentation 
and/or other materials provided with the distribution.

 * Neither the name of VMware, Inc. nor the names of its contributors may be used
to endorse or promote products derived from this software without specific prior 
written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL VMWARE, INC. OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.
================================================================================*/

package com.vmware.vim25.mo.samples.vm;

import java.net.URL;

import com.vmware.vim25.DatastoreSummary;
import com.vmware.vim25.VirtualDevice;
import com.vmware.vim25.VirtualDeviceConfigSpec;
import com.vmware.vim25.VirtualDeviceConfigSpecFileOperation;
import com.vmware.vim25.VirtualDeviceConfigSpecOperation;
import com.vmware.vim25.VirtualDisk;
import com.vmware.vim25.VirtualDiskFlatVer2BackingInfo;
import com.vmware.vim25.VirtualMachineConfigInfo;
import com.vmware.vim25.VirtualMachineConfigSpec;
import com.vmware.vim25.mo.Datastore;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;
import com.vmware.vim25.mo.VirtualMachine;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class VmDiskOp 
{    
  public static void main(String[] args) throws Exception 
  {     
    if(args.length!=5)
    {
      System.out.println("Usage: java VmDiskOp <url> " +
            "<username> <password> <vmname> <device> <op>");
      System.out.println("device - disk|cd");
      System.out.println("op - add|remove");
      System.exit(0);
    }
    String vmname = args[3];
    String op = args[5];
 
    ServiceInstance si = new ServiceInstance(
        new URL(args[0]), args[1], args[2], true);

    Folder rootFolder = si.getRootFolder();
    VirtualMachine vm = (VirtualMachine) new InventoryNavigator(
      rootFolder).searchManagedEntity("VirtualMachine", vmname);

    if(vm==null)
    {
      System.out.println("No VM " + vmname + " found");
      si.getServerConnection().logout();
      return;
    }
    
    VirtualMachineConfigSpec vmConfigSpec = new VirtualMachineConfigSpec();
    
    if("add".equalsIgnoreCase(op)) 
    {
      int diskSize = 1;
      // mode: persistent|independent_persistent,independent_nonpersistent
      String diskMode = "persistent"; 
      String diskName = "vijava_disk";
      VirtualDeviceConfigSpec vdiskSpec = createAddDiskConfigSpec(vm, diskSize, diskMode, diskName);
      VirtualDeviceConfigSpec [] vdiskSpecArray = {vdiskSpec};         
      vmConfigSpec.setDeviceChange(vdiskSpecArray);
    }
    else if("remove".equalsIgnoreCase(op)) 
    {
      // mode: persistent|independent_persistent,independent_nonpersistent
      String diskName = "vijava_disk";
      VirtualDeviceConfigSpec vdiskSpec = createRemoveDiskConfigSpec(vm, diskName);
      VirtualDeviceConfigSpec [] vdiskSpecArray = {vdiskSpec};         
      vmConfigSpec.setDeviceChange(vdiskSpecArray);
    }
    else 
    {
      System.out.println("Invlaid device type [disk|cd]");
      return;
    }
    
    Task task = vm.reconfigVM_Task(vmConfigSpec);
    task.waitForMe();
  }

  private static VirtualDevice findVirtualDevice(
      VirtualMachineConfigInfo vmConfig, String name)
  {
    VirtualDevice [] devices = vmConfig.getHardware().getDevice();
    for(int i=0;i<devices.length;i++)
    {
      if(devices[i].getDeviceInfo().getLabel().equals(name))
      {                             
        return devices[i];
      }
    }
    return null;
  }

  static VirtualDeviceConfigSpec createAddDiskConfigSpec(
      VirtualMachine vm, int diskSize, String diskMode, String diskName) throws Exception
  {
    VirtualDeviceConfigSpec diskSpec = new VirtualDeviceConfigSpec();      
    VirtualMachineConfigInfo vmConfig = (VirtualMachineConfigInfo)vm.getConfig();
    VirtualDevice[] vds = vmConfig.getHardware().getDevice();
    
    VirtualDisk disk =  new VirtualDisk();
    VirtualDiskFlatVer2BackingInfo diskfileBacking = new VirtualDiskFlatVer2BackingInfo();
    
    int key = 0;
    int unitNumber = 0;
    for(int k=0;k<vds.length;k++)
    {
      if(vds[k].getDeviceInfo().getLabel().equalsIgnoreCase("SCSI Controller 0"))
      {
        key = vds[k].getKey();
      }
    }

    unitNumber = vds.length + 1; //***********************seems NOT correct!!!
    String dsName = getFreeDatastoreName(vm, diskSize);
    if(dsName==null)
    {
      return null;
    }
    String fileName = "["+ dsName +"] "+ vm.getName() + "/" + diskName + ".vmdk";

    diskfileBacking.setFileName(fileName);
    diskfileBacking.setDiskMode(diskMode);

    disk.setControllerKey(key);
    disk.setUnitNumber(unitNumber);
    disk.setBacking(diskfileBacking);
    disk.setCapacityInKB(1024 * diskSize);
    disk.setKey(-1);

    diskSpec.setOperation(VirtualDeviceConfigSpecOperation.add);           
    diskSpec.setFileOperation(VirtualDeviceConfigSpecFileOperation.create);           
    diskSpec.setDevice(disk);                 
    return diskSpec;
  }

  static VirtualDeviceConfigSpec createRemoveDiskConfigSpec(
      VirtualMachine vm, String diskName) throws Exception
  {
    VirtualDeviceConfigSpec diskSpec = new VirtualDeviceConfigSpec();      
    VirtualDisk disk = (VirtualDisk) findVirtualDevice(vm.getConfig(), diskName);
      
    if(disk != null)
    {
      diskSpec.setOperation(VirtualDeviceConfigSpecOperation.remove);           
      diskSpec.setFileOperation(VirtualDeviceConfigSpecFileOperation.destroy);           
      diskSpec.setDevice(disk);
      return diskSpec;
    }
    else 
    {
      System.out.println("No device found: " + diskName);
      return null;
    }
  }
  
  static String getFreeDatastoreName(VirtualMachine vm, 
      int size) throws Exception
  {
    String dsName = null;
    Datastore[] datastores = vm.getDatastores();
    for(int i=0; i<datastores.length; i++) 
    {
      DatastoreSummary ds = datastores[i].getSummary(); 
      if(ds.getFreeSpace() > size) 
      {
        dsName = ds.getName();
        break;           
      }
    }
    return dsName;
  }
}
