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

import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.VirtualMachineSnapshotInfo;
import com.vmware.vim25.VirtualMachineSnapshotTree;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;
import com.vmware.vim25.mo.VirtualMachine;
import com.vmware.vim25.mo.VirtualMachineSnapshot;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class VMSnapshot 
{
  public static void main(String[] args) throws Exception 
  {
    if(args.length!=5)
    {
      System.out.println("Usage: java VMSnapshot <url> " +
      		"<username> <password> <vmname> <op>");
      System.out.println("op - list, create, remove, " +
      		"removeall, revert");
      System.exit(0);
    }

    String vmname = args[3];
    String op = args[4];
    //please change the following three depending your op
    String snapshotname = "test";
    String desc = "A description for sample snapshot";
    boolean removechild = true;
    
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

    if("create".equalsIgnoreCase(op))
    {
      Task task = vm.createSnapshot_Task(
          snapshotname, desc, false, false);
      if(task.waitForMe()==Task.SUCCESS)
      {
        System.out.println("Snapshot was created.");
      }
    }
    else if("list".equalsIgnoreCase(op))
    {
      listSnapshots(vm);
    }
    else if(op.equalsIgnoreCase("revert")) 
    {
      VirtualMachineSnapshot vmsnap = getSnapshotInTree(
          vm, snapshotname);
      if(vmsnap!=null)
      {
        Task task = vmsnap.revertToSnapshot_Task(null);
        if(task.waitForMe()==Task.SUCCESS)
        {
          System.out.println("Reverted to snapshot:" 
              + snapshotname);
        }
      }
    }
    else if(op.equalsIgnoreCase("removeall")) 
    {
      Task task = vm.removeAllSnapshots_Task();      
      if(task.waitForMe()== Task.SUCCESS) 
      {
        System.out.println("Removed all snapshots");
      }
    }
    else if(op.equalsIgnoreCase("remove")) 
    {
      VirtualMachineSnapshot vmsnap = getSnapshotInTree(
          vm, snapshotname);
      if(vmsnap!=null)
      {
        Task task = vmsnap.removeSnapshot_Task(removechild);
        if(task.waitForMe()==Task.SUCCESS)
        {
          System.out.println("Removed snapshot:" + snapshotname);
        }
      }
    }
    else 
    {
      System.out.println("Invalid operation");
      return;
    }
    si.getServerConnection().logout();
  }
  
  static VirtualMachineSnapshot getSnapshotInTree(
      VirtualMachine vm, String snapName)
  {
    if (vm == null || snapName == null) 
    {
      return null;
    }

    VirtualMachineSnapshotTree[] snapTree = 
        vm.getSnapshot().getRootSnapshotList();
    if(snapTree!=null)
    {
      ManagedObjectReference mor = findSnapshotInTree(
          snapTree, snapName);
      if(mor!=null)
      {
        return new VirtualMachineSnapshot(
            vm.getServerConnection(), mor);
      }
    }
    return null;
  }

  static ManagedObjectReference findSnapshotInTree(
      VirtualMachineSnapshotTree[] snapTree, String snapName)
  {
    for(int i=0; i <snapTree.length; i++) 
    {
      VirtualMachineSnapshotTree node = snapTree[i];
      if(snapName.equals(node.getName()))
      {
        return node.getSnapshot();
      } 
      else 
      {
        VirtualMachineSnapshotTree[] childTree = 
            node.getChildSnapshotList();
        if(childTree!=null)
        {
          ManagedObjectReference mor = findSnapshotInTree(
              childTree, snapName);
          if(mor!=null)
          {
            return mor;
          }
        }
      }
    }
    return null;
  }

  static void listSnapshots(VirtualMachine vm)
  {
    if(vm==null)
    {
      return;
    }
    VirtualMachineSnapshotInfo snapInfo = vm.getSnapshot();
    VirtualMachineSnapshotTree[] snapTree = 
      snapInfo.getRootSnapshotList();
    printSnapshots(snapTree);
  }

  static void printSnapshots(
      VirtualMachineSnapshotTree[] snapTree)
  {
    for (int i = 0; snapTree!=null && i < snapTree.length; i++) 
    {
      VirtualMachineSnapshotTree node = snapTree[i];
      System.out.println("Snapshot Name : " + node.getName());           
      VirtualMachineSnapshotTree[] childTree = 
        node.getChildSnapshotList();
      if(childTree!=null)
      {
        printSnapshots(childTree);
      }
    }
  }
}