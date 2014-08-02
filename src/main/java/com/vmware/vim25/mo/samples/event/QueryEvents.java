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

package com.vmware.vim25.mo.samples.event;

import java.net.URL;
import java.util.Calendar;

import com.vmware.vim25.Event;
import com.vmware.vim25.EventFilterSpec;
import com.vmware.vim25.EventFilterSpecByEntity;
import com.vmware.vim25.EventFilterSpecByTime;
import com.vmware.vim25.EventFilterSpecByUsername;
import com.vmware.vim25.EventFilterSpecRecursionOption;
import com.vmware.vim25.mo.EventManager;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class QueryEvents 
{
  public static void main(String[] args) throws Exception
  {
    if(args.length != 3)
    {
      System.out.println("Usage: java QueryEvents " 
          + "<url> <username> <password>");
      return;
    }

    ServiceInstance si = new ServiceInstance(
        new URL(args[0]), args[1], args[2], true);

    // get the latest event and print it out
    EventManager evtMgr = si.getEventManager();
    Event latestEvent = evtMgr.getLatestEvent();
    printEvent(latestEvent);

    // create a filter spec for querying events
    EventFilterSpec efs = new EventFilterSpec();
    // limit to only error and warning
    efs.setType(new String[] {"VmFailedToPowerOnEvent", 
        "HostConnectionLostEvent"});
    // limit to error and warning only
    efs.setCategory(new String[] {"error", "warning"});
    
    // limit to the children of root folder
    EventFilterSpecByEntity eFilter = 
      new EventFilterSpecByEntity();
    eFilter.setEntity(si.getRootFolder().getMOR());
    eFilter.setRecursion(
        EventFilterSpecRecursionOption.children);
    
    // limit to the events happened since a month ago
    EventFilterSpecByTime tFilter = new EventFilterSpecByTime();
    Calendar startTime = si.currentTime();
    startTime.roll(Calendar.MONTH, false);
    tFilter.setBeginTime(startTime);
    efs.setTime(tFilter);
    // limit to the user of "administrator"
    EventFilterSpecByUsername uFilter = 
        new EventFilterSpecByUsername();
    uFilter.setSystemUser(false);
    uFilter.setUserList(new String[] {"administrator"});

    Event[] events = evtMgr.queryEvents(efs);
    
    // print each of the events
    for(int i=0; events!=null && i<events.length; i++) 
    {
      System.out.println("\nEvent #" + i);
      printEvent(events[i]);
    }
    
    si.getServerConnection().logout();
  }

  /**
   * Only print an event as Event type.
   * More info can be printed if casted to a sub type. 
   */
  static void printEvent(Event evt)
  {
    String typeName = evt.getClass().getName();
    int lastDot = typeName.lastIndexOf('.');
    if(lastDot != -1) 
    {
      typeName = typeName.substring(lastDot+1);
    }
    System.out.println("Type:" + typeName);
    System.out.println("Key:" + evt.getKey());
    System.out.println("ChainId:" + evt.getChainId());
    System.out.println("User:" + evt.getUserName());
    System.out.println("Time:" + evt.getCreatedTime().getTime());
    System.out.println("FormattedMessage:" 
        + evt.getFullFormattedMessage());
    if(evt.getDatacenter()!= null)
    {
      System.out.println("Datacenter:" 
          + evt.getDatacenter().getDatacenter());
    }
    if(evt.getComputeResource()!=null)
    {
      System.out.println("ComputeResource:" 
          + evt.getComputeResource().getComputeResource());
    }
    if(evt.getHost()!=null)
    {
      System.out.println("Host:" + evt.getHost().getHost());
    }
    if(evt.getVm()!=null)
    {
      System.out.println("VM:" + evt.getVm().getVm());
    }
  }
}
