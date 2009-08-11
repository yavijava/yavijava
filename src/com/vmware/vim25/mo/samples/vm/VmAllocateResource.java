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

import com.vmware.vim25.ResourceAllocationInfo;
import com.vmware.vim25.SharesInfo;
import com.vmware.vim25.SharesLevel;
import com.vmware.vim25.VirtualMachineConfigSpec;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;
import com.vmware.vim25.mo.VirtualMachine;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class VmAllocateResource
{
  public static void main(String[] args) throws Exception 
  {     
    if(args.length!=6)
    {
      System.out.println("Usage: java VmAllocateResource <url> " +
            "<username> <password> <vmname> <device> <value>");
      System.out.println("device - cpu|memory");
      System.out.println("value: high|low|normal|numeric value");
      System.exit(0);
    }

    String vmname = args[3];
    String deviceType = args[4];
    String value = args[5];
    
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
    
    if("memory".equalsIgnoreCase(deviceType)) 
    {
      System.out.println("Reconfig memory for VM: " + vmname);
      vmConfigSpec.setMemoryAllocation(getShares(value));          
    }
    else if("cpu".equalsIgnoreCase(deviceType)) 
    {
      System.out.println("Reconfig CPU for VM:  " + vmname);       
      vmConfigSpec.setCpuAllocation(getShares(value));
    }
    else
    {
      System.out.println("Incorrect option for " + vmname);
    }

    Task task = vm.reconfigVM_Task(vmConfigSpec);
    task.waitForMe();
  }

  static ResourceAllocationInfo getShares(String val) throws Exception 
  {
    ResourceAllocationInfo raInfo = new ResourceAllocationInfo();
    SharesInfo sharesInfo = new SharesInfo();

    if("high".equalsIgnoreCase(val)) 
    {
      sharesInfo.setLevel(SharesLevel.high);          
    }
    else if("normal".equalsIgnoreCase(val)) 
    {
      sharesInfo.setLevel(SharesLevel.normal);
    }
    else if("low".equalsIgnoreCase(val)) 
    {
      sharesInfo.setLevel(SharesLevel.low);
    }
    else 
    {
      sharesInfo.setLevel(SharesLevel.custom);          
      sharesInfo.setShares(Integer.parseInt(val));          
    }    
    raInfo.setShares(sharesInfo);
    return raInfo;
  }
}