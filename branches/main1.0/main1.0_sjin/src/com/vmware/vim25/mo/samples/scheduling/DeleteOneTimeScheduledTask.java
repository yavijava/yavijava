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
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;

/**
*<pre>
*This is a simple standalone client whose purpose is to 
*demonstrate the process  deleting a ScheduledTask.
*The OneTime Scheduled Task will be deleted.
*
*<b>To run this samples following parameters are used :</b>
*
*taskname   [required]   : name of the task to be deleted
*
*<b>Command Line:</b>
*Delete a task named Task1
*run.bat com.vmware.samples.vm.DeleteOneTimeScheduledTask --url [webserviceurl]
*--username [username] --password [password] --taskname [Task1]
*</pre>
* @author sjin 
* THis is a sample converted from VI SDK samples
*/


public class DeleteOneTimeScheduledTask 
{

   private static OptionSpec[] constructOptions() 
   {
      OptionSpec [] useroptions = new OptionSpec[1];
      useroptions[0] = new OptionSpec("taskname","String",1
                                      ,"Name of the task to be scheduled"
                                      ,null);
      return useroptions;
   }
   
   public static void main(String [] args) throws Exception
   {
	    CommandLineParser clp = new CommandLineParser(constructOptions(), args);
	   	String urlStr = clp.get_option("url");
  	    String username = clp.get_option("username");
	    String password = clp.get_option("password");
	    String taskname = clp.get_option("taskname");

		ServiceInstance si = new ServiceInstance(new URL(urlStr), username, password, true);
		ScheduledTaskManager stm = si.getScheduledTaskManager();

		if(stm!=null)
		{
			ScheduledTask[] tasks = stm.getScheduledTasks();
			boolean found = false;
			for(int i=0; i<tasks.length; i++)
			{
				if(taskname.equals(tasks[i].getInfo().getName()))
				{
					tasks[i].removeScheduledTask();
					found = true;
					System.out.println(taskname + " has been removed.");
					break;
				}
			}
			if(found==false)
			{
				System.out.println("There is no task found named as " + taskname);
			}
		}
		else
		{
			System.out.println("SchduledTaskManager is not available on this target.");
		}
   }
}
