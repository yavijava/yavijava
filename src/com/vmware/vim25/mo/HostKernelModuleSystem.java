package com.vmware.vim25.mo;

import java.rmi.RemoteException;

import com.vmware.vim25.KernelModuleInfo;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.NotFound;
import com.vmware.vim25.RuntimeFault;

public class HostKernelModuleSystem extends ManagedObject 
{
	public HostKernelModuleSystem(ServerConnection sc, ManagedObjectReference mor) 
	{
		super(sc, mor);
	}
	
	public String queryConfiguredModuleOptionString(String name) throws NotFound, RuntimeFault, RemoteException  
	{
		return getVimService().queryConfiguredModuleOptionString(getMOR(), name);
	}
	
	public KernelModuleInfo[] queryModules() throws RemoteException, RuntimeFault
	{
		return getVimService().queryModules(getMOR());
	}
	
	public void updateModuleOptionString(String name, String options) throws NotFound, RuntimeFault, RemoteException
	{
		getVimService().updateModuleOptionString(getMOR(), name, options);
	}

}
