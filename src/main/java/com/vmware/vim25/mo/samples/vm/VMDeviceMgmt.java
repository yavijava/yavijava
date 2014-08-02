/*================================================================================
Copyright (c) 2011 VMware, Inc. All Rights Reserved.

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

import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.VirtualMachine;
import com.vmware.vim25.mox.VirtualMachineDeviceManager;
import com.vmware.vim25.mox.VirtualMachineDeviceManager.VirtualNetworkAdapterType;

public class VMDeviceMgmt
{
  public static void main(String[] args) throws Exception 
  {
    String vmName = "Rawc1.2_Win7x32bit_Target";

    ServiceInstance si = new ServiceInstance(new URL("https://8.8.8.8/sdk"), "administrator", "vmware", true);
    VirtualMachine vm = (VirtualMachine) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("VirtualMachine", vmName);

    VirtualMachineDeviceManager vmdm = new VirtualMachineDeviceManager(vm);

    vmdm.createNetworkAdapter(VirtualNetworkAdapterType.VirtualE1000, "dvPortGroup", "00:50:56:00:12:14", true, true);
    
//  vmdm.createNetworkAdapter(VirtualNetworkAdapterType.VirtualVmxnet3, null, "VM Network", true, false);
//  vmdm.createNewHardDisk(2048, VirtualDiskType.thin, VirtualDiskMode.persistent);
//  vmdm.addHardDisk("[psorl-iscsi01] tobin-win7-a/Rawc1.2_Win7x32bit_Target.vmdk", VirtualDiskMode.persistent);
    
//  vmdm.createNewHardDrive(1000, VirtualDiskType.flatMonolithic, VirtualDiskMode.persistent, false, false, null);
//  vmdm.createNewHardDrive(1000, VirtualDiskType.flatMonolithic, VirtualDiskMode.persistent, false, false, null);
    
//  List<VirtualDevice> devs = new ArrayList<VirtualDevice>();
//  devs.add( vmdm.findHardDisk("Hard disk 2"));
//  devs.add( vmdm.findHardDisk("Hard disk 3"));
//  devs.add( vmdm.findHardDisk("Hard disk 4"));
//  devs.add( vmdm.findHardDisk("Hard disk 5"));
//    
//  // CAUTION: the second parameter is true, and remove disk files in datastore.
//    vmdm.removeDevices(devs, true);

    si.getServerConnection().logout();
  }  
}