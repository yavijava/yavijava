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
import java.rmi.RemoteException;

import com.vmware.vim25.HostConfigFault;
import com.vmware.vim25.NotFound;
import com.vmware.vim25.ResourceInUse;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;

/**
*<pre>
*This sample is used to remove a virtual switch  
*
*To run this samples following parameters are used:
*
*vsiwtchid   [required]: Name of the switch to be removed
*host        [optional]: Name of the host
*datacenter  [optional]: Name of the datacenter
*
*<b>Command Line: to remove the Virtual Switch from a virtual center</b>
*run.bat com.vmware.samples.host.RemoveVirtualSwitch --url [webserviceurl] --username [username] --password  *[password]  --vsiwtchid [mySwitch] --datacenter [mydatacenter]  --host[hostname]
*
*<b>Command Line:to remove a Virtual Switch from a virtual center without specifying the host</b>
*run.bat com.vmware.samples.host.RemoveVirtualSwitch --url [webserviceurl] --username [username] --password  *[password]  --vsiwtchid [mySwitch] --datacenter [mydatacenter] 
*
*<b> Command Line:to remove a Virtual Switch from a virtual center without specifying the datacenter</b>
*run.bat com.vmware.samples.host.RemoveVirtualSwitch --url [webserviceurl] --username [username] --password  [password]  --vsiwtchid [mySwitch] --host [host]
*
*</pre>
/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class RemoveVirtualSwitch  
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

			removeVirtualSwitch(host, vswitchId);
	   }   

	public static void removeVirtualSwitch(HostSystem host, String vswitchId) throws RemoteException
	{
		try
		{
			HostNetworkSystem hns = host.getHostNetworkSystem();
			hns.removeVirtualSwitch(vswitchId);
			System.out.println("Successful removed: " + vswitchId);
		}
	    catch (NotFound e) 
	    {
	    	System.out.println("Failed : virtual switch cannot be found. ");
	    }
	    catch (HostConfigFault e) 
	    {
	    	System.out.println("Failed : Configuration falilures. ");
	    }
	    catch (ResourceInUse e) 
	    {
	    	System.out.println("Failed removing switch "+ vswitchId);
	    	System.out.println("There are virtual network adapters " + "associated with the virtual switch.");
	    }
	    catch (Exception e) 
	    {
	    	System.out.println("Failed removing switch: "+ vswitchId +"\n" + e);
	    }
	}

   private static OptionSpec[] constructOptions() 
   {
      return new OptionSpec[] 
      {
    		  new OptionSpec("vswitchid","String",1,"Name of the switch", null),
    		  new OptionSpec("host","String",0, "Name of the host", null),
    		  new OptionSpec("datacenter","String",0, "Name of the datacenter", null)
      };
   } 

}

