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

import com.vmware.vim25.Event;
import com.vmware.vim25.EventFilterSpec;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;
import com.vmware.vim25.ws.*;

import java.net.URL;


/**
 *<pre>
 *This is a simple standalone client whose purpose is to demonstrate the
 *process for Logging into the Webservice, Creating EventHistoryCollector
 *and monitoring Events using the latestPage attribute of the 
 *EventHistoryCollector
 *
 *<b>Command Line: </b>
 *run.bat com.vmware.samples.vm.EventHistoryCollectorMonitor --url 
 *[webserviceurl] --username [username] --password [password]
 *</pre>
 * http://vijava.sf.net
 * @author Steve Jin
 */
 

public class EventHistoryCollectorMonitor 
{  
  public static void main(String[] args) throws Exception
  {
    CommandLineParser clp = new CommandLineParser(
        new OptionSpec[]{}, args);
    String urlStr = clp.get_option("url");
    String username = clp.get_option("username");
    String password = clp.get_option("password");

    ServiceInstance si = new ServiceInstance(new URL(urlStr), 
        username, password, true);

    EventManager evtMgr = si.getEventManager();

    if(evtMgr!=null)
    {
      EventFilterSpec eventFilter = new EventFilterSpec();
      EventHistoryCollector ehc = 
        evtMgr.createCollectorForEvents(eventFilter);
      Event[] events = ehc.getLatestPage();

      for (int i = 0; i < events.length; i++)
      {
        Event anEvent = events[i];
        System.out.println("Event: " + 
            anEvent.getClass().getName());
      }
    }
    si.getServerConnection().logout();
  }
}

