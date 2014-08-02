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
import com.vmware.vim25.HostIpConfig;
import com.vmware.vim25.HostNetworkPolicy;
import com.vmware.vim25.HostPortGroupSpec;
import com.vmware.vim25.HostVirtualNicSpec;
import com.vmware.vim25.HostVirtualSwitchSpec;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostNetworkSystem;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class AddNIC  
{
  public static void main(String[] args) throws Exception 
  {
    if(args.length != 3)
    {
      System.out.println("Usage: java AddNIC <url> " 
          + "<username> <password>");
      return;
    }

    ServiceInstance si = new ServiceInstance(
        new URL(args[0]), args[1], args[2], true);

    String hostname = "dev.acme.com";
    String portGroupName = "ViMaster PortGroup"; 
    String switchName = "ViMaster Switch";

    Folder rootFolder = si.getRootFolder();
    HostSystem host = null;
    host = (HostSystem) new InventoryNavigator(
        rootFolder).searchManagedEntity("HostSystem", hostname);

    HostNetworkSystem hns = host.getHostNetworkSystem();

    // add a virtual switch
    HostVirtualSwitchSpec spec = new HostVirtualSwitchSpec();
    spec.setNumPorts(8);
    hns.addVirtualSwitch(switchName, spec);
    
    // add a port group
    HostPortGroupSpec hpgs = new HostPortGroupSpec();
    hpgs.setName(portGroupName);
    hpgs.setVlanId(0); // not associated with a VLAN
    hpgs.setVswitchName(switchName);
    hpgs.setPolicy(new HostNetworkPolicy());
    hns.addPortGroup(hpgs);
    
    // add a virtual NIC to VMKernel
    HostVirtualNicSpec hvns = new HostVirtualNicSpec();
    hvns.setMac("00:50:56:7d:5e:0b");
    HostIpConfig hic = new HostIpConfig();
    hic.setDhcp(false);
    hic.setIpAddress("10.20.143.204");
    hic.setSubnetMask("255.255.252.0");
    hvns.setIp(hic);
    String result = hns.addVirtualNic("VMKernel", hvns);
    System.out.println(result);
    
    si.getServerConnection().logout();
  }
}
