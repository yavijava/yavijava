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

package com.vmware.vim25.mo.samples;

import java.net.URL;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;
import com.vmware.vim25.mo.util.OptionSpec;

/**
 *<pre>
 *This sample dipslays a list of tasks performed on some managed 
 *object. The sample display the tasks in the following format:
 * 
 *Operation:
 *Name:
 *Type:
 *State:
 *Error:
 *
 *If there is no task running when this sample is used, then it
 *displays a messsage.
 *
 *</pre>
 *
 * @author sjin
 */


public class TaskList_New 
{
	private static void displayTasks(Task[] tasks) throws Exception
	{
		if(tasks.length == 0) 
		{
			System.out.println("Currently no task running");
			return;
		}
		
		for(int i=0; i<tasks.length; i++) 
		{
			System.out.println("Task");
			
			TaskInfo ti = tasks[i].getTaskInfo();
			
			ManagedObjectReference mor = (ManagedObjectReference)ti.getEntity();
			String type = mor.getType();
			String name = ti.getEntityName();
			String op = ti.getName();
			String state = "";
			String error = "";
			
			TaskInfoState tis = ti.getState();
			if(TaskInfoState.error.equals(tis)) {  state = "-Error"; }
            else if(TaskInfoState.queued.equals(tis))  { state = "-Queued";  } 
            else if(TaskInfoState.running.equals(tis)) { state = "-Running"; } 
            else if(TaskInfoState.success.equals(tis)) { state = "-Success"; }
            else if (ti.isCancelled()) 
            {
                     state += "-Cancelled";
            } 
            
			LocalizedMethodFault lmf = ti.getError();
			if (lmf!=null)
            {
            	error = lmf.getLocalizedMessage();
            }
			
            System.out.println("Operation " + op);
            System.out.println("Name " + name);
            System.out.println("Type " + type);
            System.out.println("State " + state);
            System.out.println("Error " + error);
            System.out.println("======================");
         }
      }

   public static void main(String [] args) throws Exception
   {
	    CommandLineParser clp = new CommandLineParser(new OptionSpec[]{}, args);
	   	String urlStr = clp.get_option("url");
  	    String username = clp.get_option("username");
	    String password = clp.get_option("password");

		ServiceInstance si = new ServiceInstance(new URL(urlStr), username, password, true);
		TaskManager tm = si.getTaskManager();
		Task[] tasks = tm.getRecentTasks();
		displayTasks(tasks);
   }     
}
