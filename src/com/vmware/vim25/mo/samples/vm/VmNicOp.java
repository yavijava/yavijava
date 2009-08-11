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

import com.vmware.vim25.ConfigTarget;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.NetworkSummary;
import com.vmware.vim25.VirtualDevice;
import com.vmware.vim25.VirtualDeviceConfigSpec;
import com.vmware.vim25.VirtualDeviceConfigSpecOperation;
import com.vmware.vim25.VirtualEthernetCard;
import com.vmware.vim25.VirtualEthernetCardNetworkBackingInfo;
import com.vmware.vim25.VirtualMachineConfigInfo;
import com.vmware.vim25.VirtualMachineConfigSpec;
import com.vmware.vim25.VirtualMachineNetworkInfo;
import com.vmware.vim25.VirtualMachineRuntimeInfo;
import com.vmware.vim25.VirtualPCNet32;
import com.vmware.vim25.mo.EnvironmentBrowser;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;
import com.vmware.vim25.mo.VirtualMachine;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class VmNicOp 
{    
  public static void main(String[] args) throws Exception 
  {     
    if(args.length!=6)
    {
      System.out.println("Usage: java VmNicOp <url> " +
            "<username> <password> <vmname> <op> <name>");
      System.out.println("op - add|remove");
      System.out.println("name - NIC name when remove; " +
      		"Network name when add");
      System.exit(0);
    }
    String vmname = args[3];
    String op = args[4];
    String name = args[5];
 
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
    
    VirtualMachineConfigSpec vmConfigSpec = 
      new VirtualMachineConfigSpec();
    
    
    VirtualDeviceConfigSpec nicSpec = 
      getNICDeviceConfigSpec(vm, op, name);
    
    String result = null;
    if(nicSpec!=null)
    {
      vmConfigSpec.setDeviceChange(
          new VirtualDeviceConfigSpec []{nicSpec});
      Task task = vm.reconfigVM_Task(vmConfigSpec);
      result = task.waitForMe();
    }

    if(result==Task.SUCCESS)
    {
      System.out.println("Done with NIC for VM:" + vmname);
    }
    else
    {
      System.out.println("Failed with NIC for VM:" + vmname);
    }
    
    si.getServerConnection().logout();
  }

  static VirtualDeviceConfigSpec getNICDeviceConfigSpec(
      VirtualMachine vm, String op, String name) 
        throws Exception
  {
    VirtualDeviceConfigSpec nicSpec = 
      new VirtualDeviceConfigSpec();
    VirtualMachineConfigInfo vmConfigInfo = vm.getConfig();

    if("add".equalsIgnoreCase(op) 
        && doesNetworkNameExist(vm, name)) 
    {
      nicSpec.setOperation(VirtualDeviceConfigSpecOperation.add);
      VirtualEthernetCard nic =  new VirtualPCNet32();
      VirtualEthernetCardNetworkBackingInfo nicBacking = 
        new VirtualEthernetCardNetworkBackingInfo();
      nicBacking.setDeviceName(name);
      nic.setAddressType("generated");
      nic.setBacking(nicBacking);
      nic.setKey(4);
      nicSpec.setDevice(nic);
      return nicSpec;
    }
    else if("remove".equalsIgnoreCase(op))
    {
      VirtualDevice [] vds = 
        vmConfigInfo.getHardware().getDevice();
      nicSpec.setOperation(
          VirtualDeviceConfigSpecOperation.remove);
      for(int i=0;i<vds.length;i++)
      {
        if((vds[i] instanceof VirtualEthernetCard) &&
          (vds[i].getDeviceInfo().getLabel().equalsIgnoreCase(
              name)))
        {                             
          nicSpec.setDevice(vds[i]);
          return nicSpec;
        }
      }
    }
    return null;
  }

  static boolean doesNetworkNameExist(VirtualMachine vm, 
      String netName) throws Exception 
  {
    VirtualMachineRuntimeInfo vmRuntimeInfo = vm.getRuntime();
    EnvironmentBrowser envBrowser = vm.getEnvironmentBrowser();
    ManagedObjectReference hmor = vmRuntimeInfo.getHost();

    HostSystem host = new HostSystem(
        vm.getServerConnection(), hmor);
    ConfigTarget cfg = envBrowser.queryConfigTarget(host);
    VirtualMachineNetworkInfo[] nets = cfg.getNetwork();
    for (int i = 0; nets!=null && i < nets.length; i++) 
    {
      NetworkSummary netSummary = nets[i].getNetwork();
      if (netSummary.isAccessible() && 
          netSummary.getName().equalsIgnoreCase(netName)) 
      {
        return true;
      }
    }
    return false;
  }
}