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
import java.util.Calendar;

import com.vmware.vim25.HostDateTimeInfo;
import com.vmware.vim25.HostDateTimeSystemTimeZone;
import com.vmware.vim25.HostNtpConfig;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostDateTimeSystem;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class SetHostTime
{
  public static void main(String[] args) throws Exception 
  {
    if(args.length != 4)
    {
      System.out.println("Usage: java SetHostTime " +
            "<url> <username> <password> <hostname>");
      return;
    }

    ServiceInstance si = new ServiceInstance(
        new URL(args[0]), args[1], args[2], true);

    String hostname = args[3];
    Folder rootFolder = si.getRootFolder();
    HostSystem host = null;
    host = (HostSystem) new InventoryNavigator(
        rootFolder).searchManagedEntity("HostSystem", hostname);

    if(host==null)
    {
      System.out.println("Cannot find the host:" + hostname);
      si.getServerConnection().logout();
      return;
    }
    HostDateTimeSystem hdts = host.getHostDateTimeSystem();
    
    HostDateTimeInfo info = hdts.getDateTimeInfo();

    System.out.println("The NTP Servers:");
    HostNtpConfig cfg = info.getNtpConfig();
    String[] svrs = cfg.getServer();
    for(int i=0; svrs!=null && i<svrs.length; i++)
    {
      System.out.println("Server["+i+"]:" + svrs[i]);
    }
    
    System.out.println("\nCurrent Time Zone:");
    HostDateTimeSystemTimeZone tz = info.getTimeZone();
    System.out.println("Key:" + tz.getKey());
    System.out.println("Name:" + tz.getName());
    // the GMT offset is in seconds. 
    // for example, America/Los_Angeles, -28800 
    System.out.println("GmtOffset:" + tz.getGmtOffset());
    System.out.println("Description:" + tz.getDescription());
    
    Calendar curTime = si.currentTime();
    System.out.println("\nCurrent time:" + curTime.getTime());
    //roll back one hour
    curTime.roll(Calendar.HOUR, false); 
    hdts.updateDateTime(curTime);
    
    curTime = si.currentTime();
    System.out.println("Current time (after):"
        + curTime.getTime());

    // reset the time
    curTime.roll(Calendar.HOUR, true);
    hdts.updateDateTime(curTime);
    
    si.getServerConnection().logout();
  }
}
