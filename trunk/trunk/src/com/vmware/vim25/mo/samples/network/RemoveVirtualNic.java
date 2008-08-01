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
*This sample is used to remove a Virtual Nic  
*
*To run this samples following parameters are used:
*
*portgroupname  [required]: Name of the port group from which the nic is to be removed
*host           [optional]: Name of the host
*datacenter     [optional]: Name of the datacenter
*
*<b>Parameters:</b>
*<b>Command Line:to remove a Host VirtualNic from a PortGroup</b>
*run.bat com.vmware.samples.host.RemoveVirtualNic --url [webserviceurl] --username [username] --password  [password] 
*--datacenter [mydatacenter] --portgroupname [myportgroup]>  --host [hostname]
*
*<b>Command Line:to remove a Host VirtualNic from a PortGroup without specifying the host</b>
*run.bat com.vmware.samples.host.RemoveVirtualNic --url [webserviceurl] --username [username] --password  [password] 
*--datacenter [mydatacenter] --portgroupname [myportgroup]
*
*<b>Command Line:to remove a Host VirtualNic from a PortGroup without specifying the datacenter</b>
*run.bat com.vmware.samples.host.RemoveVirtualNic --url [webserviceurl] --username [username] --password  [password] 
*--portgroupname [myportgroup] --host [name of the host]
*</pre>
*
* @author sjin 
* THis is a sample converted from VI SDK samples
*/



public class RemoveVirtualNic 
{
	public static void main(String[] args) throws Exception 
	{
	    CommandLineParser clp = new CommandLineParser(constructOptions(), args);
	   	String urlStr = clp.get_option("url");
 	    String username = clp.get_option("username");
	    String password = clp.get_option("password");
		String dcname = clp.get_option("datacenter");;
		String hostname = clp.get_option("host");
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

		removeVirtualNic(host, portGroupName);
	}

   private static void removeVirtualNic(HostSystem host, String portGroupName) 
	{
		try
		{
			HostNetworkSystem hns = host.getHostNetworkSystem();
			HostVirtualNic[] hvns = hns.getNetworkInfo().getVnic();
			if(hvns==null)
			{
				return;
			}
			
			boolean found = false;
			// TODO ***** problem here!!!
			for (int i=0; i<hvns.length; i++)
			{
				HostVirtualNic nic = hvns[i];
	            String portGroup = nic.getPortgroup();
	            if (portGroup!=null && portGroup.equals(portGroupName)) 
	            {
	            	found = true;
	            	hns.removeVirtualNic(nic.getDevice());
	    			System.out.println("Successful removing : " + portGroupName );
	            }
			}
			if (!found)
			{
				System.out.println("PortGroupName not found failed removing : " + portGroupName );
			}
		}
		catch (NotFound e) 
      {
         System.out.println("Failed : virtual network adapter cannot be found. ");
      }
      catch (HostConfigFault e) 
      {
         System.out.println("Failed : Configuration falilures. ");
      }
      catch (Exception e) 
      {
         System.out.println("Failed removing nic: " + portGroupName);
      }
   }
   
   private static OptionSpec[] constructOptions() 
   {
	   return new OptionSpec[] 
       {
	       	new OptionSpec("host","String",0, "Name of the host", null),
	      	new OptionSpec("portgroupname","String", 1 ,"Name of the portgroup", null),
	       	new OptionSpec("datacenter","String",0, "Name of the datacenter", null)
	   };
   }
}

