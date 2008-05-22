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

package com.vmware.vim25.mo;

import java.rmi.RemoteException;

import com.vmware.vim25.InvalidDatastore;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.mo.util.MorUtil;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 * @author Steve JIN (sjin@vmware.com)
 */

public class SearchIndex extends ManagedObject 
{
	
	public SearchIndex(ServerConnection serverConnection, ManagedObjectReference mor) 
	{
		super(serverConnection, mor);
	}

	/**
	 * find a managed object in the inventory tree. 
	 * @param inventoryPath The inventory path to the managed object searched.
	 * @return ManagedEntity object.
	 * @throws RemoteException 
	 * @throws RuntimeFault 
	 */
	public ManagedEntity findByInventoryPath(String inventoryPath) throws RuntimeFault, RemoteException
	{
		ManagedObjectReference mor = getVimService().findByInventoryPath(getMOR(), inventoryPath);
		return MorUtil.createExactManagedEntity(getServerConnection(), mor);
	}
	
	/**
	 * Find a Virtual Machine or Host System by its IP address.
	 * @param datacenter The datacenter within which it searches. If null is passed, all inventory is searched.
	 * @param ip The IP address of the VM or Host.
	 * @param vmOnly When set true only searches for VM; otherwise only for Host.
	 * @return A ManagedEntity to either HostSystem or VirtualMachine having the IP address.
	 * @throws RuntimeFault 
	 * @throws RemoteException
	 */
	public ManagedEntity findByIp(Datacenter datacenter, String ip, boolean vmOnly) throws RuntimeFault, RemoteException
	{
		ManagedObjectReference mor = getVimService().findByIp(getMOR(), datacenter==null? null : datacenter.getMOR(), ip, vmOnly);
		return MorUtil.createExactManagedEntity(getServerConnection(), mor);
	}
	
	/**
	 * Find a VM or Host by its DNS name
	 * @param datacenter The datacenter within which it searches. If null is passed, all inventory is searched.
	 * @param dnsName DNS name like "dev.eng.vmware.com"
	 * @param vmOnly When set true only searches for VM; otherwise only for Host.
	 * @return A ManagedEntity to either HostSystem or VirtualMachine having the DNS name.
	 * @throws RemoteException 
	 * @throws RuntimeFault 
	 */
	
	public ManagedEntity findByDnsName(Datacenter datacenter, String dnsName, boolean vmOnly) throws RuntimeFault, RemoteException
	{
		ManagedObjectReference mor = getVimService().findByDnsName(getMOR(), datacenter==null? null : datacenter.getMOR(), dnsName, vmOnly);
		return MorUtil.createExactManagedEntity(getServerConnection(), mor);
	}
	
	/**
	 * Find a VM by its location on a datastore
	 * @param datacenter The datacenter within which it searches.
	 * @param dPath The datastore path, for example, "[storage1] WinXP/WinXP.vmx".
	 * @return A VirtualMachine that pointed by the dPath
	 * @throws RemoteException 
	 * @throws RuntimeFault 
	 * @throws InvalidDatastore 
	 */
	public VirtualMachine findByDatastorePath(Datacenter datacenter, String dPath) throws InvalidDatastore, RuntimeFault, RemoteException
	{
		if(datacenter==null)
		{
			throw new IllegalArgumentException("datacenter must not be null.");
		}
		
		ManagedObjectReference mor = getVimService().findByDatastorePath(getMOR(), datacenter.getMOR(), dPath);
		return new VirtualMachine(getServerConnection(), mor);
	}
	
	/**
	 * Find a VM or Host by its UUID
	 * @param datacenter The datacenter within which it searches. If null is passed, all inventory is searched.
	 * @param uuid The UUID of the VM or Host
	 * @param vmOnly When set true only searches for VM; otherwise only for Host
	 * @return A VM or Host.
	 * @throws RemoteException 
	 * @throws RuntimeFault 
	 */
	public ManagedEntity findByUuid(Datacenter datacenter, String uuid, boolean vmOnly) throws RuntimeFault, RemoteException
	{
		ManagedObjectReference mor = getVimService().findByUuid(getMOR(), datacenter==null? null : datacenter.getMOR(), uuid, vmOnly);
		return MorUtil.createExactManagedEntity(getServerConnection(), mor);
	}

	/**
	 * Find a child entity under a ManagedObjectReference in the inventory.
	 * @param parent The parent managed entity.
	 * @param name The name of the child to search.
	 * @return A child entity.
	 * @throws RemoteException 
	 * @throws RuntimeFault 
	 */
	public ManagedEntity findChild(ManagedEntity parent, String name) throws RuntimeFault, RemoteException
	{
		if(parent == null)
		{
			throw new IllegalArgumentException("parent entity must not be null.");
		}
		ManagedObjectReference mor = getVimService().findChild(getMOR(), parent.getMOR(), name);
		return MorUtil.createExactManagedEntity(getServerConnection(), mor);
	}
	
}
