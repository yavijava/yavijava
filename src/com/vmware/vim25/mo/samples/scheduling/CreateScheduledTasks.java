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
import java.util.Calendar;

import com.vmware.vim25.MethodAction;
import com.vmware.vim25.MethodActionArgument;
import com.vmware.vim25.OnceTaskScheduler;
import com.vmware.vim25.ScheduledTaskSpec;
import com.vmware.vim25.WeeklyTaskScheduler;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ScheduledTask;
import com.vmware.vim25.mo.ScheduledTaskManager;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.VirtualMachine;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class CreateScheduledTasks 
{
  public static void main(String [] args) throws Exception
  {
    if(args.length != 4)
    {
      System.out.println("Usage: java CreateScheduledTasks " 
	    + "<url> <username> <password> <vmname>");
	  return;
    }
    
    ServiceInstance si = new ServiceInstance(
	              new URL(args[0]), args[1], args[2], true);
    Folder rootFolder = si.getRootFolder();
    
    InventoryNavigator inv = new InventoryNavigator(rootFolder);
    String vmname = args[3];
    VirtualMachine vm = (VirtualMachine)inv.searchManagedEntity(
            "VirtualMachine", vmname);
	if(vm==null)
	{
	  System.out.println("Cannot find the VM " + vmname 
	    + "\nExisting...");
	  si.getServerConnection().logout();
	  return;
	}

    ScheduledTaskManager stm = si.getScheduledTaskManager();
    if(stm!=null)
    {
      //to save space, we just check one name here
      if(taskNameExists(stm, "ViMaster_OneTime"))
      {
        si.getServerConnection().logout();
        return;
      }
      
      // Note: the time should be fetched from server,
      // just to make sure it's synchronized.
      ScheduledTaskSpec oneSpec = createOneTimeSchedulerSpec(
          "ViMaster_OneTime", si.currentTime());
      
      ScheduledTaskSpec weekSpec = createWeeklySchedulerSpec(
          "ViMaster_Weekly");

      ScheduledTask st = stm.createScheduledTask(vm, oneSpec);
      ScheduledTask st1 = stm.createScheduledTask(vm, weekSpec);
	  // sleep two minutes before deleting 
	  // the one time scheduled task.
      // An one time scheduled task has not to be deleted after
      // it's run. It can be run any time again by calling the 
      // runScheduledTask() method.
      Thread.sleep(2*60*1000);
      st.removeScheduledTask();
    }
    else
    {
      System.out.println("SchduledTaskManager is not "
        + "available on this target.");
    }
    
	si.getServerConnection().logout();
   }
  
  static ScheduledTaskSpec createOneTimeSchedulerSpec(
      String taskName, Calendar runTime)
  {
    // specify the action
    MethodAction action = new MethodAction();
    action.setName("PowerOffVM_Task");
    action.setArgument(new MethodActionArgument[] { });

    // specify the schedule
    runTime.add(Calendar.MINUTE, 01);
    OnceTaskScheduler scheduler = new OnceTaskScheduler();
    scheduler.setRunAt(runTime);
    
    // create a spec for the scheduled task
    ScheduledTaskSpec scheduleSpec = new ScheduledTaskSpec();
    scheduleSpec.setName(taskName);
    scheduleSpec.setDescription("PowerOff VM in 1 minutes");
    scheduleSpec.setEnabled(true);
    scheduleSpec.setAction(action);
    scheduleSpec.setScheduler(scheduler);

    return scheduleSpec;
  }
  
  static ScheduledTaskSpec createWeeklySchedulerSpec(
    String taskName)
  {
    // create an action to take snapshot
    MethodAction action = new MethodAction();
    action.setName("CreateSnapshot_Task");
    MethodActionArgument nameArg = new MethodActionArgument();
    nameArg.setValue("My Snapshot");
    MethodActionArgument descArg = new MethodActionArgument();
    descArg.setValue("My Description");
    MethodActionArgument memArg = new MethodActionArgument();
    memArg.setValue(true);
    MethodActionArgument quieArg = new MethodActionArgument();
    quieArg.setValue(true);
    action.setArgument(new MethodActionArgument[] 
      {nameArg, descArg, memArg, quieArg });
    
    // run the task only once every week at Saturday midnight
    WeeklyTaskScheduler scheduler = new WeeklyTaskScheduler();
    scheduler.setSaturday(true);
    scheduler.setHour(23);
    scheduler.setMinute(59);
    scheduler.setInterval(1); 
    
    ScheduledTaskSpec scheduleSpec = new ScheduledTaskSpec();
    scheduleSpec.setName(taskName);
    scheduleSpec.setDescription(
      "Run a command at 23:59PM every other Saturday.");
    scheduleSpec.setEnabled(true);
    scheduleSpec.setAction(action);
    scheduleSpec.setScheduler(scheduler);
    
    return scheduleSpec;
  }

  static boolean taskNameExists(ScheduledTaskManager stm, 
      String vmname)
  {
    ScheduledTask[] tasks = stm.getScheduledTasks();
    boolean found = false;
    for(int i=0; tasks!=null && i<tasks.length; i++)
    {
      if(vmname.equals(tasks[i].getInfo().getName()))
      {
        found = true;
        System.out.println("The task name " + vmname 
            + " exists. \nPlease pick a new one.");
        break;
       }
    }
    return found;
  }
}