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

import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;

/**
*<pre>This sample Performs virtual machine snapshot operations
*
*To run this samples following parameters are used:
*
*<b>Parameters</b>
*vmname         [required]:Name of the virtual machine
*operation      [required]:Type of the operation
*snapshotname   [optional]:Name of the snapshot
*description    [optional]:description of the sanpshot
*removechild    [optional]:if children needs to be removed and 0 if children
*               needn't be removed
*
*<b>Command Line:To list the name of the snapshot</b>
*run.bat com.vmware.samples.vm.VMSnapshot --url [webserviceurl]
*--username [username] --password  [password] --vmname [vmname]
*--operation [list]
*
*<b>Command Line: To create a snapshot of the virtual machine</b>
*run.bat com.vmware.samples.vm.VMSnapshot --url [webserviceurl]
*--username [username] --password  [password] --vmname [vmname]
*--operation [create]
*--description [Description of the snapshot]
*
*<b>Command Line: To revert a snapshot of the virtual machine</b>
*run.bat com.vmware.samples.vm.VMSnapshot --url [webserviceurl]
*--username [username] --password  [password] --vmname [vmname]
*--operation [revert]
*--description [Description of the snapshot]
*
*<b>Command Line: To remove a snapshot of the virtual machine</b>
*run.bat com.vmware.samples.vm.VMSnapshot --url [webserviceurl]
*--username [username] --password  [password] --vmname [vmname]
*--operation [remove]  --removechild [0]
*
* @author sjin
* This is a sample converted from the equivalent in VI SDK
*/


public class VMSnapshot 
{

	private static void listSnapshots(VirtualMachine vm)
	{
		VirtualMachineSnapshotInfo snapInfo = vm.getSnapshot();
		VirtualMachineSnapshotTree[] snapTree = snapInfo.getRootSnapshotList();
		printSnapshots(snapTree);
	}

	private static void printSnapshots(VirtualMachineSnapshotTree[] snapTree)
	{
		for (int i = 0; snapTree!=null && i < snapTree.length; i++) 
		{
	          VirtualMachineSnapshotTree node = snapTree[i];
	          System.out.println("Snapshot Name : " + node.getName());            
	          VirtualMachineSnapshotTree[] childTree = node.getChildSnapshotList();
	          if(childTree!=null)
	          {
	        	  printSnapshots(childTree);
	          }
		}
	}
	
	private static VirtualMachineSnapshot findSnapshotInTree( VirtualMachine vm, String snapName)
	{
		if (vm == null || snapName == null) 
		{
			return null;
		}
		
		VirtualMachineSnapshotTree[] snapTree = vm.getSnapshot().getRootSnapshotList();
		
		ManagedObjectReference mor = findSnapshotInTree(snapTree, snapName);
		if(mor!=null)
		{
			return new VirtualMachineSnapshot(vm.getServerConnection(), mor);
		}
		return null;
	}
	
	private static ManagedObjectReference findSnapshotInTree( VirtualMachineSnapshotTree[] snapTree, String snapName)
	{
		if(snapTree==null || snapName==null)
		{
			return null;
		}
		
		for (int i = 0; i < snapTree.length; i++) 
		{
			VirtualMachineSnapshotTree node = snapTree[i];
			if (snapName.equals(node.getName()))
			{
				return node.getSnapshot();
			} 
			else 
			{
				VirtualMachineSnapshotTree[] childTree = node.getChildSnapshotList();
				if(childTree!=null)
				{
					ManagedObjectReference mor = findSnapshotInTree(childTree, snapName);
					if(mor!=null)
					{
						return mor;
					}
				}
			}
		}
		return null;
	}

   private static OptionSpec[] constructOptions() 
   {
      return new OptionSpec[] {
    	  new OptionSpec("vmname","String",1,"Name of the virtual machine", null),
    	  new OptionSpec("operation","String",1, "Type of the operation [list|create|remove|removeall|revert]", null),
    	  new OptionSpec("snapshotname","String",0, "Name of Snapshot", null),
    	  new OptionSpec("description","String",0, "Description of snapshot", null),
    	  new OptionSpec("removechild","Integer",0,"1 if children needs to be removed and 0 if children needn't be removed", null)
      };
   }
   
   public static void main(String[] args) throws Exception 
   {
	   	CommandLineParser clp = new CommandLineParser(constructOptions(), args);
	   	String urlStr = clp.get_option("url");
  	    String username = clp.get_option("username");
	    String password = clp.get_option("password");
	    String vmname = clp.get_option("vmname");
	    String snapshotname = clp.get_option("snapshotname");
	    String desc = clp.get_option("description");
	    String op = clp.get_option("operation");
	    boolean removechild = "1".equalsIgnoreCase(clp.get_option("removechild"));
	    
		ServiceInstance si = new ServiceInstance(new URL(urlStr), username, password, true);
		Folder rootFolder = si.getRootFolder();
		VirtualMachine vm = (VirtualMachine) new InventoryNavigator(rootFolder).searchManagedEntity("VirtualMachine", vmname);
	   
		if(vm==null)
		{
			System.out.println("No VM " + vmname + " found");
			return;
		}
		
		boolean res = false;
		if("create".equalsIgnoreCase(op))
		{
			Task task = vm.createSnapshot_Task(snapshotname, desc, false, false);
			if(task.waitForMe()==Task.SUCCESS)
			{
				res = true;
			}
		}
		else if("list".equalsIgnoreCase(op))
		{
			listSnapshots(vm);
		}
        else if(op.equalsIgnoreCase("revert")) 
        {
        	VirtualMachineSnapshot vmsnap = findSnapshotInTree(vm, snapshotname);
        	if(vmsnap!=null)
        	{
        		Task task = vmsnap.revertToSnapshot_Task(null);
        		if(task.waitForMe()==Task.SUCCESS)
        		{
        			res = true;
        		}
        	}
        }
        else if(op.equalsIgnoreCase("removeall")) 
        {
        	Task task = vm.removeAllSnapshots_Task();      
            if(task.waitForMe()== Task.SUCCESS) 
            {
            	res = true;
            }
        }
        else if(op.equalsIgnoreCase("remove")) 
        {
        	VirtualMachineSnapshot vmsnap = findSnapshotInTree(vm, snapshotname);
        	if(vmsnap!=null)
        	{
        		Task task = vmsnap.removeSnapshot_Task(removechild);
        		if(task.waitForMe()==Task.SUCCESS)
        		{
        			res = true;
        		}
        	}
        }
        else 
        {
        	System.out.println("Invalid operation [create|list|revert|remoeveall|remove]");
        	return;
        }
		
		if(res)
		{
               System.out.println("Operation " + op + " completed sucessfully");
        }
		si.getServerConnection().logout();
   }
}
