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

package com.vmware.vim25.mo.samples.network;

import java.net.URL;

import com.vmware.vim25.HostSnmpConfigSpec;
import com.vmware.vim25.HostSnmpDestination;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostSnmpSystem;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class ConfigureSnmpSystem
{
  public static void main(String[] args) throws Exception 
  {
    if(args.length != 4)
    {
      System.out.println("Usage: java ConfigureSnmpSystem " +
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
    HostSnmpSystem hss = host.getHostSnmpSystem();
    
    HostSnmpConfigSpec spec = new HostSnmpConfigSpec();
    spec.setEnabled(true);
    spec.setReadOnlyCommunities(new String[] {"visdk"});
    HostSnmpDestination dest = new HostSnmpDestination();
    dest.setCommunity("visdk");
    dest.setHostName("192.168.8.8");
    dest.setPort(162);
    spec.setTrapTargets(new HostSnmpDestination[] {dest});
    
    hss.reconfigureSnmpAgent(spec);
    
    si.getServerConnection().logout();
  }
}
