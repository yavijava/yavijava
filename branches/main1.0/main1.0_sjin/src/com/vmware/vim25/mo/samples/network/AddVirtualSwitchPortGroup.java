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
*<pre>
*This sample is used to add a Virtual Switch PortGroup
*
*<b>To run this samples following parameters are used:></b>
*
*vsiwtchid      [required]: Name of the switch in which portgroup is to be added
*portgroupname  [required]: Name of the port group
*host           [optional]: Name of the host
*datacenter     [optional]: Name of the datacenter
*
*<b>Command Line:to add a Virtual switch Port Group as: -</b>
*run.bat com.vmware.samples.host.AddVirtualSwitchPortGroup --url [webserviceurl] --username [username] --password  [password] 
*--vsiwtchid [mySwitch] --datacenter [mydatacenter] --portgroupname [myportgroup] --host[hostname]
*
*<b>Command Line:to add a Virtual switch Port Group without specifying the host: </b>
*run.bat com.vmware.samples.host.AddVirtualSwitchPortGroup --url [webserviceurl] --username [username] --password  [password] 
*--vsiwtchid [mySwitch] --datacenter [mydatacenter] --portgroupname [myportgroup]
*
*
*<b>Command Line:to add a Virtual switch Port Group without specifying the datacenter -</b>
*run.bat com.vmware.samples.host.AddVirtualSwitchPortGroup --url [webserviceurl] --username [username] --password  [password] 
*--vsiwtchid [mySwitch]  --portgroupname [myportgroup]
*</pre>
*
* @author sjin 
* THis is a sample converted from VI SDK samples
*/


public class AddVirtualSwitchPortGroup 
{
   public static void main(String[] args) throws Exception 
   {
	    CommandLineParser clp = new CommandLineParser(constructOptions(), args);
	   	String urlStr = clp.get_option("url");
 	    String username = clp.get_option("username");
	    String password = clp.get_option("password");
		String dcname = clp.get_option("datacenter");;
		String hostname = clp.get_option("host");
		String vswitchId = clp.get_option("vswitchid");
		String portGroupName = clp.get_option("portgroupname");

		ServiceInstance si = new ServiceInstance(new URL(urlStr), username, password, true);
		Folder rootFolder = si.getRootFolder();
		HostSystem host = null;
		
		String apiType = si.getAboutInfo().getApiType();
		if("HostAgent".equalsIgnoreCase(apiType) && dcname ==null)
		{
			dcname = "ha-datacenter";
		}
		else if("VirtualCenter".equalsIgnoreCase(apiType) && ((dcname == null) || (hostname ==null)))
		{
			System.out.println("datacenter and host should be specified");
			return;
		}
		
		Datacenter dc = (Datacenter) new InventoryNavigator(rootFolder).searchManagedEntity("Datacenter", dcname);
		host = (HostSystem) new InventoryNavigator(dc).searchManagedEntity("HostSystem", hostname);

		addVirtualSwitchPortGroup(host, vswitchId, portGroupName);
   }


   private static void addVirtualSwitchPortGroup(HostSystem host, String vswitchId, String portGroupName) throws Exception 
   {
		HostNetworkSystem hns = host.getHostNetworkSystem();
			
		HostPortGroupSpec portgrp = new HostPortGroupSpec();
        portgrp.setName(portGroupName);
        portgrp.setVswitchName(vswitchId);
        portgrp.setPolicy(new HostNetworkPolicy());

        try
        {
        	hns.addPortGroup(portgrp);
        	System.out.println("Successful creating : " + vswitchId +"/" + portGroupName);
        }
	      catch (AlreadyExists e) 
	      {
	         System.out.println("Failed to create : " + vswitchId + "/" + portGroupName);
	         System.out.println("Portgroup name already exists");
	      }
	      catch (InvalidArgument e) 
	      {
	         System.out.println("Failed creating : " + vswitchId +"/"+ portGroupName);
	         System.out.println("PortGroup vlanId or network policy may be invalid.");
	      }   
	      catch (NotFound e) 
	      {
	         System.out.println("Failed creating : " + vswitchId +"/"+ portGroupName);
	         System.out.println("Switch Not found.");
	      }
	      catch (NullPointerException e) 
	      {
	         System.out.println("Failed creating : " + vswitchId +"/"+ portGroupName);
	         System.out.println("Datacenter or Host may be invalid");
	         throw e;
	      }   
	      catch (Exception e) {
	         System.out.println("Failed creating : " + vswitchId +"/"+ portGroupName);
	         throw e;
	      }
   }
   private static OptionSpec[] constructOptions() 
   {
      return new OptionSpec[]
	  {
    	new OptionSpec("vswitchid","String",1 ,"Name of the switch on which portgroup is to be added",null),
      	new OptionSpec("host","String",0, "Name of the host", null),
      	new OptionSpec("portgroupname","String",1, "Name of the portgroup",null),
      	new OptionSpec("datacenter","String",0, "Name of the datacenter", null)
	  };
   }
}

