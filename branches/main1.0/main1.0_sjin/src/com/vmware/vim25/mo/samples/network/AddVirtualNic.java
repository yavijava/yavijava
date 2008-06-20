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
import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;

/**
*<pre>This sample is used to add a Virtual Nic  
*
*<b>To run this samples following parameters are used:</b>
*
*vsiwtchid      [required]: Name of the switch 
*portgroupname  [required]: Name of the port group
*ipaddress      [required]: ipaddress for the nic
*host           [optional]: Name of the host
*datacenter     [optional]: Name of the datacenter
*
*<b>Command Line:To add a Host VirtualNic to a PortGroup on a Virtual Switch as: -</b>
*run.bat com.vmware.samples.host.AddVirtualNic --url [webserviceurl] --username [username] --password  [password] 
*--vsiwtchid [mySwitch] --host [hostname]  --datacenter [mydatacenter] --portgroupname [myportgroup] --ipaddress[AAA.AAA.AAA.AAA]
*
*<b>Command Line:To add a Host VirtualNic to a PortGroup on a Virtual Switch as 
*without specifying the host name</b>
*<br>run.bat com.vmware.samples.host.AddVirtualNic --url [webserviceurl] --username [username] --password  [password] 
*--vsiwtchid [mySwitch] --datacenter [mydatacenter] --portgroupname [myportgroup] --ipaddress[AAA.AAA.AAA.AAA]

*<b>Command Line:To add a Host VirtualNic to a PortGroup on a Virtual Switch as </b>
*without specifying the datacenter name
*<br>run.bat com.vmware.samples.host.AddVirtualNic --url [webserviceurl] --username [username] --password  [password] 
*--vsiwtchid [mySwitch] --portgroupname[myportgroup] --ipaddress[AAA.AAA.AAA.AAA]

</pre>

*/

public class AddVirtualNic 
{
   public static void main(String[] args) throws Exception 
   {
	    CommandLineParser clp = new CommandLineParser(constructOptions(), args);
	   	String urlStr = clp.get_option("url");
 	    String username = clp.get_option("username");
	    String password = clp.get_option("password");
		String dcName = clp.get_option("datacenter");;
		String hostname = clp.get_option("host");
		//TODO *** vswitchid is NEVER used. need to find out why and how.
//		String vswitchId = clp.get_option("vswitchid");
		String portGroup = clp.get_option("portgroupname");
		String ipAddr = clp.get_option("ipaddress");

		ServiceInstance si = new ServiceInstance(new URL(urlStr), username, password, true);
		Folder rootFolder = si.getRootFolder();
		HostSystem host = null;
		
		if(hostname==null)
		{
			System.out.println("Hostname cannot be empty!");
			return;
		}
		if(dcName!=null)
		{
			Datacenter dc = (Datacenter) new InventoryNavigator(rootFolder).searchManagedEntity("Datacenter", dcName);
			host = (HostSystem) new InventoryNavigator(dc).searchManagedEntity("HostSystem", hostname);
		}
		else
		{
			host = (HostSystem) new InventoryNavigator(rootFolder).searchManagedEntity("HostSystem", hostname);
		}

		if(host==null)
		{
	           System.out.println("Host not found");
	           return;
		}
       HostNetworkSystem hns = host.getHostNetworkSystem();
       
       HostPortGroupSpec portgrp = new HostPortGroupSpec();
       portgrp.setName(portGroup);
       HostVirtualNicSpec vNicSpec = createVNicSpecification(ipAddr);
       try
       {
    	   hns.addVirtualNic(portGroup, vNicSpec);
       }
       catch (InvalidArgument e) 
       {
    	    System.out.println("Failed : IP address or subnet mask in the IP configuration are invalid ");
       }
       catch (AlreadyExists e) 
       {
    	   System.out.println("Failed : The specific key,name or identifier already exists ");
       }
       catch (HostConfigFault e) 
       {
    	   System.out.println("Failed : Configuration failures. ");
       }
       catch (NotFound e) 
       {
    	   System.out.println("Failed : switch not found ");
       } 
       catch (Exception e) 
       {
    	   System.out.println("Failed creating nic: "+ portGroup);
    	   throw e;
       }
       
       System.out.println("Successful creating nic : " + portGroup);
     }
   
   private static HostVirtualNicSpec createVNicSpecification(String ipAddr) 
   {
	   HostVirtualNicSpec vNicSpec = new HostVirtualNicSpec();
	   HostIpConfig ipConfig = new HostIpConfig();
	   ipConfig.setDhcp(false);
	   ipConfig.setIpAddress(ipAddr);
	   ipConfig.setSubnetMask("255.255.255.0");      
	   vNicSpec.setIp(ipConfig);
	   return vNicSpec;
   }

   private static OptionSpec[] constructOptions() 
   {
      return new OptionSpec[] {
    	new OptionSpec("vswitchid","String",1, "Name of the switch", null),
      	new OptionSpec("host","String",0, "Name of the host", null),
    	new OptionSpec("portgroupname","String", 1 ,"Name of the portgroup", null),
    	new OptionSpec("ipaddress","String", 1 , "Ipaddress of the nic", null),
    	new OptionSpec("datacenter","String",0, "Name of the datacenter", null)
      };
   }
}

