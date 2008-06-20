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

package com.vmware.vim25.mo.samples.scheduling;

import java.net.URL;
import java.util.*;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;

/**
*<pre>
*This is a simple standalone client whose purpose is to 
*demonstrate the creation of a ScheduledTask using the 
*ScheduledTaskManager
*
*<b>To run this samples following parameters are used :</b>
*
*taskname   [required]   : name of the task to be scheduled
*vmname     [required]   : name of the virtual machine
*
*<b>Command Line:</b>
*run.bat com.vmware.samples.vm.OneTimeScheduledTask --url 
*[webserviceurl] --username [username] --password [password] 
*--taskname [myTask]
*<pre>
*/

public class OneTimeScheduledTask 
{
   private static OptionSpec[] constructOptions() 
   {
      OptionSpec [] useroptions = new OptionSpec[2];
      useroptions[0] = new OptionSpec("vmname","String",1
                                      ,"Name of Virtual Machine"
                                      ,null);
      useroptions[1] = new OptionSpec("taskname","String",1,
                                      "Name of the task to be scheduled",
                                      null);
      return useroptions;
   }
   
	public static ScheduledTaskSpec createSchedulerSpec(String taskName, Calendar runTime)
	{
		MethodAction action = new MethodAction();
		action.setName("PowerOffVM_Task");
		action.setArgument(new MethodActionArgument[] { });
		
		runTime.add(Calendar.MINUTE, 01);
		OnceTaskScheduler scheduler = new OnceTaskScheduler();
		scheduler.setRunAt(runTime);
		
		ScheduledTaskSpec scheduleSpec = new ScheduledTaskSpec();
		scheduleSpec.setName(taskName);
		scheduleSpec.setDescription("PowerOff VM in 1 minutes");
		scheduleSpec.setEnabled(true);
		scheduleSpec.setAction(action);
		scheduleSpec.setScheduler(scheduler);
		
		return scheduleSpec;
	}
   
   public static void main(String [] args) throws Exception
   {
	    CommandLineParser clp = new CommandLineParser(constructOptions(), args);
	   	String urlStr = clp.get_option("url");
  	    String username = clp.get_option("username");
	    String password = clp.get_option("password");
	    String vmname = clp.get_option("vmname");
	    String taskname = clp.get_option("taskname");

		ServiceInstance si = new ServiceInstance(new URL(urlStr), username, password, true);
        
		Folder rootFolder = si.getRootFolder();
		VirtualMachine vm = (VirtualMachine) new InventoryNavigator(rootFolder).searchManagedEntity("VirtualMachine", vmname);
		
		//this runtime has to be fetched from server...
		ScheduledTaskSpec spec = createSchedulerSpec(taskname, si.currentTime());  
		
		ScheduledTaskManager stm = si.getScheduledTaskManager();
		if(stm!=null)
		{
			stm.createScheduledTask(vm, spec);
			System.out.println("Task: " + taskname + " has been successfully added.");
		}
		else
		{
			System.out.println("SchduledTaskManager is not available on this target.");
		}
		
		si.getServerConnection().logout();
   }
}
