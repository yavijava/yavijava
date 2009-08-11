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

import com.vmware.vim25.Event;
import com.vmware.vim25.EventFilterSpec;
import com.vmware.vim25.mo.EventHistoryCollector;
import com.vmware.vim25.mo.EventManager;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class QueryHistoricalEvents 
{  
  public static void main(String[] args) throws Exception
  {
    if(args.length != 3)
    {
      System.out.println("Usage: java QueryHistoricalEvents " 
        + "<url> <username> <password>");
      return;
    }

    ServiceInstance si = new ServiceInstance(
      new URL(args[0]), args[1], args[2], true);

    EventManager evtMgr = si.getEventManager();

    if(evtMgr!=null)
    {
      EventFilterSpec eventFilter = new EventFilterSpec();
      EventHistoryCollector ehc = 
        evtMgr.createCollectorForEvents(eventFilter);
      
      int total = 0;
      
      Event[] latestEvts = ehc.getLatestPage();
      printEvents(latestEvts, 0);
      total += latestEvts==null? 0 : latestEvts.length;
      
      System.out.println("\nBefore Latest Page:");
      ehc.resetCollector();
      while(true)
      {
        Event[] events = ehc.readPreviousEvents(50);
        if(events==null)
        {
          break;
        }
        printEvents(events, total);
        total += events.length;
      }
    }
    si.getServerConnection().logout();
  }
  
  static void printEvents(Event[] events, int total)
  {
    for(int i=0; i<events.length; i++)
    {
      System.out.println("Event[" + (total+i) + "]=" + events[i].getClass().getName());
      System.out.println("Event: " + events[i].getCreatedTime().getTime());
    }
  }
}
