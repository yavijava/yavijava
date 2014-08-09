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

import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;
import com.vmware.vim25.mo.VirtualMachine;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class VMpowerOps 
{
  public static void main(String[] args) throws Exception 
  {
    if(args.length!=5)
    {
      System.out.println("Usage: java VMpowerOps <url> " +
            "<username> <password> <vmname> <op>");
      System.out.println("op - reboot|poweron|poweroff" +
      		"|reset|standby|suspend|shutdown");
      System.exit(0);
    }

    String vmname = args[3];
    String op = args[4];
    
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

    if("reboot".equalsIgnoreCase(op))
    {
      vm.rebootGuest();
      System.out.println(vmname + " guest OS rebooted");
    }
    else if("poweron".equalsIgnoreCase(op))
    {
      Task task = vm.powerOnVM_Task(null);
      if(task.waitForMe()==Task.SUCCESS)
      {
        System.out.println(vmname + " powered on");
      }
    }
    else if("poweroff".equalsIgnoreCase(op))
    {
      Task task = vm.powerOffVM_Task();
      if(task.waitForMe()==Task.SUCCESS)
      {
        System.out.println(vmname + " powered off");
      }
    }
    else if("reset".equalsIgnoreCase(op))
    {
      Task task = vm.resetVM_Task();
      if(task.waitForMe()==Task.SUCCESS)
      {
        System.out.println(vmname + " reset");
      }
    }
    else if("standby".equalsIgnoreCase(op))
    {
      vm.standbyGuest();
      System.out.println(vmname + " guest OS stoodby");
    }
    else if("suspend".equalsIgnoreCase(op))
    {
      Task task = vm.suspendVM_Task();
      if(task.waitForMe()==Task.SUCCESS)
      {
        System.out.println(vmname + " suspended");
      }
    }
    else if("shutdown".equalsIgnoreCase(op))
    {
      Task task = vm.suspendVM_Task();
      if(task.waitForMe()==Task.SUCCESS)
      {
        System.out.println(vmname + " suspended");
      }
    }
    else
    {
      System.out.println("Invalid operation. Exiting...");
    }
    si.getServerConnection().logout();
  }
}
