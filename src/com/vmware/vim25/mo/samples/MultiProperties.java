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

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Hashtable;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;

/**
 * This sample code shows how to get different API to:
 * . get a single property by path from a single managed object
 * . get multiple properties from a single managed object
 * . get multiple properties from multiple managed objects
 * @author Steve JIN (sjin@vmware.com)
 */

public class MultiProperties 
{
	public static void main(String[] args) throws RemoteException, MalformedURLException 
	{
	    CommandLineParser clp = new CommandLineParser(new OptionSpec[]{}, args);
	   	String urlStr = clp.get_option("url");
  	    String username = clp.get_option("username");
	    String password = clp.get_option("password");

		ServiceInstance si = new ServiceInstance(new URL(urlStr), username, password, true);
		Folder rootFolder = si.getRootFolder();
		
		ManagedEntity[] vms = new InventoryNavigator(rootFolder).searchManagedEntities("VirtualMachine");
		
		if(vms==null || vms.length ==0)
		{
			return;
		}
		VirtualMachine vm = (VirtualMachine) vms[0];
		
		System.out.println("retrieve a property from a single managed object.");
		VirtualMachineToolsStatus status = (VirtualMachineToolsStatus) vm.getPropertyByPath("guest.toolsStatus");
		System.out.println("toolStatus:" + status);
		
		System.out.println("\nretrieve multiple properties from a single managed object.");
		Hashtable props = vm.getPropertiesByPaths(new String[] {"name", 
				"config.cpuFeatureMask",
				"guest.toolsStatus",
				"guest.guestId"});
		System.out.println(vm);
		System.out.println(props);
		
		System.out.println("\nretrieve multiple properties from multiple managed objects.");
		Hashtable[] pTables = PropertyCollectorUtil.retrieveProperties(vms, "VirtualMachine",
				new String[] {"name", 
				"config.cpuFeatureMask",
				"guest.toolsStatus",
				"guest.guestId"
				});
		for(int i=0; i<pTables.length; i++)
		{
			System.out.println(vms[i]);
			System.out.println(pTables[i].toString());
		}

		si.getServerConnection().logout();
	}
}
