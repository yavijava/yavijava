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

package com.vmware.vim25.mo.samples.task;

import java.net.URL;
import java.util.Calendar;
import java.util.Date;

import com.vmware.vim25.TaskFilterSpec;
import com.vmware.vim25.TaskFilterSpecByEntity;
import com.vmware.vim25.TaskFilterSpecByTime;
import com.vmware.vim25.TaskFilterSpecByUsername;
import com.vmware.vim25.TaskFilterSpecRecursionOption;
import com.vmware.vim25.TaskFilterSpecTimeOption;
import com.vmware.vim25.TaskInfo;
import com.vmware.vim25.TaskInfoState;
import com.vmware.vim25.TaskReason;
import com.vmware.vim25.TaskReasonAlarm;
import com.vmware.vim25.TaskReasonSchedule;
import com.vmware.vim25.TaskReasonSystem;
import com.vmware.vim25.TaskReasonUser;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.TaskHistoryCollector;
import com.vmware.vim25.mo.TaskManager;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class TaskHistoryMonitor 
{
  public static void main(String[] args) throws Exception
  {
    if(args.length != 3)
    {
      System.out.println("Usage: java TaskHistoryMonitor " 
        + "<url> <username> <password>");
      return;
    }
     
    ServiceInstance si = new ServiceInstance(
      new URL(args[0]), args[1], args[2], true);
     
    TaskManager taskMgr = si.getTaskManager();

    if(taskMgr!=null)
    {
      Folder root = si.getRootFolder();
      TaskFilterSpec tfs = createTaskFilterSpec(root); 
      TaskHistoryCollector thc = 
          taskMgr.createCollectorForTasks(tfs);
      
      // Note: 10 <= pagesize <= 62
      thc.setCollectorPageSize(15);

      System.out.println("Tasks in latestPage:");
      TaskInfo[] tis = thc.getLatestPage();
      printTaskInfos(tis);

      System.out.println("\nAll tasks:");
      int total = 0; 
      
      while(true)
      {
        tis= thc.readNextTasks(50);
        if(tis==null)
        {
          break;
        }
        total += tis.length;
        printTaskInfos(tis);
      }
      System.out.println("\nTotal number " +
      		"of tasks retrieved:" + total);
      thc.destroyCollector();
    }
    si.getServerConnection().logout();
  }

  static void printTaskInfos(TaskInfo[] tis)
  {
    for (int i = 0; tis!=null && i < tis.length; i++)
    {
      printTaskInfo(tis[i]);
    }
  }
  
  static void printTaskInfo(TaskInfo ti)
  {
    System.out.println("\nName:" + ti.getName());
    System.out.println("Key:" + ti.getKey());
    System.out.println("Entity:" + ti.getEntityName());
    System.out.println("Reason:" + taskReason(ti.getReason()));
    System.out.println("QueueTime:" 
        + ti.getQueueTime().getTime());
    Calendar calStart = ti.getStartTime();
    Date dateStart = calStart==null? null : calStart.getTime();
    System.out.println("StartTime:" + dateStart);
    Calendar calStop = ti.getCompleteTime();
    Date dateStop = calStop==null? null : calStop.getTime();
    System.out.println("CompleteTime:" + dateStop);
    System.out.println("Cancelable:" + ti.isCancelable());
    System.out.println("Cancelled:" + ti.isCancelled());
  }
  
  static String taskReason(TaskReason tr)
  {
    if(tr instanceof TaskReasonAlarm)
    {
      return " <-- Alarm";
    }
    else if(tr instanceof TaskReasonSchedule)
    {
      return " <-- ScheduledTask";
    }
    else if(tr instanceof TaskReasonSystem)
    {
      return " <-- System";
    }
    else if(tr instanceof TaskReasonUser)
    {
      return " <-- User : " + ((TaskReasonUser)tr).getUserName();
    }
    return "Unknown";
  }
  
  static TaskFilterSpec createTaskFilterSpec(ManagedEntity ent)
  {
    TaskFilterSpec tfs = new TaskFilterSpec();
    
    // only the root initiated tasks
    TaskFilterSpecByUsername nameFilter 
      = new TaskFilterSpecByUsername();
    nameFilter.setUserList(new String[] {"Administrator"});
    // include tasks initiated by non-users, 
    // for example, by ScheduledTaskManager.
    nameFilter.setSystemUser(true);
    tfs.setUserName(nameFilter);
    
    // only the tasks with one entity itself
    TaskFilterSpecByEntity entFilter = 
      new TaskFilterSpecByEntity();
    entFilter.setEntity(ent.getMOR());
    entFilter.setRecursion(TaskFilterSpecRecursionOption.all);
    tfs.setEntity(entFilter);
    
    // only successfully finished tasks
    tfs.setState(new TaskInfoState[]{TaskInfoState.success });
    
    // only tasks started within last one month
    // strictly speaking, time should be retrieved from server
    TaskFilterSpecByTime tFilter =new TaskFilterSpecByTime();
    Calendar cal = Calendar.getInstance();
    cal.roll(Calendar.MONTH, -1);
    tFilter.setBeginTime(cal); 
    //we ignore the end time here so it gets the latest.
    tFilter.setTimeType(TaskFilterSpecTimeOption.startedTime);
    tfs.setTime(tFilter);
    
    // Optionally, you limits tasks initiated by scheduled task
    // with the setScheduledTask() method. 
    return tfs;
  }
}