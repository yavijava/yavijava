package com.vmware.vim25.mo.samples;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Hashtable;

import javax.xml.rpc.ServiceException;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;

public class MultiProperties 
{
	public static void main(String[] args) throws RemoteException, MalformedURLException, ServiceException 
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
