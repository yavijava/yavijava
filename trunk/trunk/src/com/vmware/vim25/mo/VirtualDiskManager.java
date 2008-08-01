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

import com.vmware.vim25.*;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 * @author Steve JIN (sjin@vmware.com)
 */

public class VirtualDiskManager extends ManagedObject 
{

	public VirtualDiskManager(ServerConnection sc, ManagedObjectReference mor) 
	{
		super(sc, mor);
	}
	
	public Task copyVirtualDisk_Task(String sourceName, Datacenter sourceDatacenter, String destName, 
			Datacenter destDatacenter, VirtualDiskSpec destSpec, Boolean force) throws FileFault, RuntimeFault, RemoteException 
	{
		ManagedObjectReference taskMor = getVimService().copyVirtualDisk_Task(getMOR(), 
				sourceName, sourceDatacenter==null? null : sourceDatacenter.getMOR(), 
				destName, destDatacenter==null? null : destDatacenter.getMOR(), destSpec, force);
		return new Task(getServerConnection(), taskMor);
	}

	public Task createVirtualDisk_Task(String name, Datacenter datacenter, VirtualDiskSpec spec) throws FileFault, RuntimeFault, RemoteException 
	{
		return new Task(getServerConnection(),
				getVimService().createVirtualDisk_Task(getMOR(), name, datacenter==null? null : datacenter.getMOR(), spec));
	}
	
	public Task defragmentVirtualDisk_Task(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException 
	{
		return new Task(getServerConnection(),
				getVimService().defragmentVirtualDisk_Task(getMOR(), name, datacenter==null? null : datacenter.getMOR()));
	}
	
	public Task deleteVirtualDisk_Task(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException 
	{
		return new Task(getServerConnection(),
				getVimService().deleteVirtualDisk_Task(getMOR(), name, datacenter==null? null : datacenter.getMOR()));
	}
	
	public Task extendVirtualDisk_Task(String name, Datacenter datacenter, long newCapacityKb) throws FileFault, RuntimeFault, RemoteException 
	{
		return new Task(getServerConnection(),
				getVimService().extendVirtualDisk_Task(getMOR(), name, datacenter==null? null : datacenter.getMOR(), newCapacityKb));
	}
	
	public Task inflateVirtualDisk_Task(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException 
	{
		return new Task(getServerConnection(),
				getVimService().inflateVirtualDisk_Task(getMOR(), name, datacenter==null? null : datacenter.getMOR()));
	}
	
	public Task moveVirtualDisk_Task(String sourceName, Datacenter sourceDatacenter, String destName, Datacenter destDatacenter, Boolean force) throws FileFault, RuntimeFault, RemoteException 
	{
		ManagedObjectReference taskMor = getVimService().moveVirtualDisk_Task(getMOR(), 
				sourceName, sourceDatacenter==null? null : sourceDatacenter.getMOR(), 
				destName, destDatacenter==null? null : destDatacenter.getMOR(), force);
		
		return new Task(getServerConnection(), taskMor);
	}
	
	public int queryVirtualDiskFragmentation(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException 
	{
		return getVimService().queryVirtualDiskFragmentation(getMOR(), name, datacenter==null? null : datacenter.getMOR());
	}
	
	public HostDiskDimensionsChs queryVirtualDiskGeometry(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException 
	{
		return getVimService().queryVirtualDiskGeometry(getMOR(), name, datacenter==null? null : datacenter.getMOR());
	}
	
	public String queryVirtualDiskUuid(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException 
	{
		return getVimService().queryVirtualDiskUuid(getMOR(), name, datacenter==null? null : datacenter.getMOR());
	}
	
	public void setVirtualDiskUuid(String name, Datacenter datacenter, String uuid) throws FileFault, RuntimeFault, RemoteException 
	{
		getVimService().setVirtualDiskUuid(getMOR(), name, datacenter==null? null : datacenter.getMOR(), uuid);
	}
	
	public Task shrinkVirtualDisk_Task(String name, Datacenter datacenter, boolean copy) throws FileFault, RuntimeFault, RemoteException 
	{
		return new Task(getServerConnection(),
				getVimService().shrinkVirtualDisk_Task(getMOR(), name, datacenter==null? null : datacenter.getMOR(), copy));
	}
	
	public Task zeroFillVirtualDisk_Task(String name, Datacenter datacenter) throws FileFault, RuntimeFault, RemoteException 
	{	
		return new Task(getServerConnection(),
				getVimService().zeroFillVirtualDisk_Task(getMOR(), name, datacenter==null? null : datacenter.getMOR()));
	}
	
}
