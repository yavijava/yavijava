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

import com.vmware.vim25.ElementDescription;
import com.vmware.vim25.TaskDescription;
import com.vmware.vim25.TaskInfo;
import com.vmware.vim25.TypeDescription;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;
import com.vmware.vim25.mo.TaskManager;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class PrintTaskManager
{
  public static void main(String[] args) throws Exception
  {
    if(args.length != 3)
    {
      System.out.println("Usage: java PrintTaskManager " 
        + "<url> <username> <password>");
      return;
    }

    ServiceInstance si = new ServiceInstance(
      new URL(args[0]), args[1], args[2], true);
     
    TaskManager taskMgr = si.getTaskManager();

    int maxCollector = taskMgr.getMaxCollector();
    System.out.println("Maximum number of collectors to " +
    		"retrive historical tasks: " + maxCollector);
    
    System.out.println("\nTask description:");
    TaskDescription td = taskMgr.getDescriptioin();
    printTaskDescription(td);
    
    System.out.println("\nRecent tasks:");
    Task[] recentTasks = taskMgr.getRecentTasks();
    for(int i=0; recentTasks!=null && i<recentTasks.length; i++)
    {
      TaskInfo ti = recentTasks[i].getTaskInfo();
      System.out.println("\nName:" + ti.getName());
      System.out.println("Key:" + ti.getKey());
      System.out.println("State:" + ti.getState());
    }
    si.getServerConnection().logout();
  }
  
  static void printTaskDescription(TaskDescription td)
  {
    ElementDescription[] methodInfos = td.getMethodInfo();
    System.out.println("\n***Method descriptions:" + methodInfos.length);
    printElementDescriptions(methodInfos);

    System.out.println("\n***Reason descriptions:");
    TypeDescription[] reasons = td.getReason();
    for(int i=0; reasons!=null && i<reasons.length; i++)
    {
      System.out.println("\nKey:" + reasons[i].getKey());
      System.out.println("Label:" + reasons[i].getLabel());
      System.out.println("Summary:" + reasons[i].getSummary());
    }
    
    System.out.println("\n***Task state enum descriptions:");
    ElementDescription[] states = td.getState();
    printElementDescriptions(states);
  }
  
  static void printElementDescriptions(ElementDescription[] eds)
  {
    for(int i=0; eds!=null && i<eds.length; i++)
    {
      printElementDescription(eds[i]);
    }
  }
  
  static void printElementDescription(ElementDescription ed)
  {
    System.out.println("\nKey:" + ed.getKey());
    System.out.println("Label:" + ed.getLabel());
    System.out.println("Summary:" + ed.getSummary());
  }
}
