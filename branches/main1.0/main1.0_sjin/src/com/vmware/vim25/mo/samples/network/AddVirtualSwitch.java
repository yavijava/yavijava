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

import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;


/**
*<pre>
*This sample is used to add a virtual switch  
*
*<b>To run this samples following parameters are used:</b>
*
*vsiwtchid   [required]: Name of the switch to be added
*host        [optional]: Name of the host
*datacenter  [optional]: Name of the datacenter
*
*<b>Command Line: to add a Virtual Switch on a virtual center as: -
*run.bat com.vmware.samples.host.AddVirtualSwitch --url [webserviceurl] --username [username] --password  [password] 
*--vsiwtchid [mySwitch] --datacenter [mydatacenter]
*</pre>
*
*/

public class AddVirtualSwitch  
{
   String datacenter = null;
   String host = null;
   String vswitchId = null;
   
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

		addVirtualSwitch(host, vswitchId);
   }

	public static void addVirtualSwitch(HostSystem host, String vswitchId) throws RemoteException
	{
		
		HostNetworkSystem hns = host.getHostNetworkSystem();
		
		HostVirtualSwitchSpec spec = new HostVirtualSwitchSpec();
		spec.setNumPorts(8);
		
		try
		{
			hns.addVirtualSwitch(vswitchId, spec);
			System.out.println("Successful creating : " + vswitchId);
		}
		catch (InvalidArgument e) 
		{
			System.out.println("vswitchName exceeds the maximum allowed length, or the number of ports "
                          + "specified falls out of valid range, or the network policy is invalid, or beacon configuration is invalid. ");
		}
		catch (AlreadyExists e) 
		{
			System.out.println("Failed : Switch already exists ");
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
			System.out.println("Failed adding switch: "+ vswitchId);
			System.out.println(e);
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

