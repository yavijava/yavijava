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

import com.vmware.vim25.HostService;
import com.vmware.vim25.HostServiceInfo;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostServiceSystem;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class FlipNetworkService
{
  public static void main(String[] args) throws Exception 
  {
    if(args.length != 3)
    {
      System.out.println("Usage: java FlipNetworkService " +
      		"<url> <username> <password>");
      return;
    }

    ServiceInstance si = new ServiceInstance(
        new URL(args[0]), args[1], args[2], true);

    String hostname = "sjin-dev1.eng.vmware.com";
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
    
    HostServiceSystem hss = host.getHostServiceSystem();
    
    HostServiceInfo hsi = hss.getServiceInfo();
    HostService[] ss = hsi.getService();
    for(int i=0; ss!=null && i<ss.length; i++)
    {
      printService(ss[i]);
      if(ss[i].isRunning())
      {
        hss.stopService(ss[i].getKey());
        System.out.println("Service stopped.");
      }
      else
      {
        hss.startService(ss[i].getKey());
        System.out.println("Service started.");
      }
    }
    si.getServerConnection().logout();
  }
  
  static void printService(HostService si)
  {
    System.out.println("\nKey:" + si.getKey());
    System.out.println("Label:" + si.getLabel());
    System.out.println("Policy:" + si.getPolicy());
    System.out.println("Required:" + si.isRequired());
    System.out.print("RuleSet:");
    String[] rules = si.getRuleset();
    for(int j=0; rules!=null && j<rules.length; j++)
    {
      System.out.print(rules[j] + " ");
    }
    System.out.println("\nRunning:" + si.isRunning());
    System.out.println("Uninstallable:" + si.isUninstallable());
  }
}
