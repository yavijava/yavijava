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

import com.vmware.vim25.AlreadyExists;
import com.vmware.vim25.ConcurrentAccess;
import com.vmware.vim25.DVPortConfigSpec;
import com.vmware.vim25.DVPortgroupConfigSpec;
import com.vmware.vim25.DVSCapability;
import com.vmware.vim25.DVSConfigInfo;
import com.vmware.vim25.DVSConfigSpec;
import com.vmware.vim25.DVSSummary;
import com.vmware.vim25.DistributedVirtualPort;
import com.vmware.vim25.DistributedVirtualSwitchPortCriteria;
import com.vmware.vim25.DistributedVirtualSwitchProductSpec;
import com.vmware.vim25.DuplicateName;
import com.vmware.vim25.DvsFault;
import com.vmware.vim25.DvsNotAuthorized;
import com.vmware.vim25.InvalidHostState;
import com.vmware.vim25.InvalidName;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.LimitExceeded;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.NotFound;
import com.vmware.vim25.ResourceInUse;
import com.vmware.vim25.ResourceNotAvailable;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.TaskInProgress;
import com.vmware.vim25.mo.util.MorUtil;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 * @author Steve JIN (sjin@vmware.com)
 * @since 4.0
 */

public class DistributedVirtualSwitch extends ManagedEntity
{

	public DistributedVirtualSwitch(ServerConnection sc, ManagedObjectReference mor) 
	{
		super(sc, mor);
	}
	
	public DVSCapability getCapability()
	{
		return (DVSCapability) getCurrentProperty("capability");
	}
	
	public DVSConfigInfo getConfig()
	{
		return (DVSConfigInfo) getCurrentProperty("config");
	}
	
	public DistributedVirtualPortgroup[] getPortgroup()
	{
		ManagedObjectReference[] pgMors = (ManagedObjectReference[]) getCurrentProperty("portgroup");
		if(pgMors==null)
		{
			return new DistributedVirtualPortgroup[]{};
		}
		
		DistributedVirtualPortgroup[] dvpgs = new DistributedVirtualPortgroup[pgMors.length];
		for(int i=0; i< pgMors.length; i++)
		{
			dvpgs[i] = new DistributedVirtualPortgroup(getServerConnection(), pgMors[i]);
		}
		return dvpgs;
	}
	
	public DVSSummary getSummary()
	{
		return (DVSSummary) getCurrentProperty("portgroup");
	}
	
	public String getUuid()
	{
		return (String) getCurrentProperty("uuid");
	}
	
	public void addDVPortgroup_Task(DVPortgroupConfigSpec[] spec) throws DvsFault, DuplicateName, InvalidName, RuntimeFault, RemoteException
	{
		getVimService().addDVPortgroup_Task(getMOR(), spec);
	}
	
	public String[] fetchDVPortKeys(DistributedVirtualSwitchPortCriteria criteria) throws RuntimeFault, RemoteException
	{
		return getVimService().fetchDVPortKeys(getMOR(), criteria);
	}
	
	public DistributedVirtualPort[] fetchDVPorts(DistributedVirtualSwitchPortCriteria criteria) throws RuntimeFault, RemoteException
	{
		return getVimService().fetchDVPorts(getMOR(), criteria);
	}
	
	public Task mergeDvs_Task(DistributedVirtualSwitch dvs) throws InvalidHostState, DvsFault, NotFound, ResourceInUse, RuntimeFault, RemoteException
	{
		ManagedObjectReference taskMor = getVimService().mergeDvs_Task(getMOR(), dvs.getMOR());
		return new Task(getServerConnection(), taskMor);
	}
	
	public void moveDVPort_Task(String[] portKey, String destinationPortgroupKey) throws DvsFault, NotFound, ConcurrentAccess, RuntimeFault, RemoteException
	{
		getVimService().moveDVPort_Task(getMOR(), portKey, destinationPortgroupKey);
	}
	
	public Task performDvsProductSpecOperation_Task(String operation, DistributedVirtualSwitchProductSpec productSpec) throws TaskInProgress, InvalidState, DvsFault, RuntimeFault, RemoteException
	{
		ManagedObjectReference taskMor = getVimService().performDvsProductSpecOperation_Task(getMOR(), operation, productSpec);
		return new Task(getServerConnection(), taskMor);
	}

	public int[] queryUsedVlanIdInDvs() throws RuntimeFault, RemoteException
	{
		return getVimService().queryUsedVlanIdInDvs(getMOR());
	}
	
	public Task reconfigureDvs_Task(DVSConfigSpec spec) throws DvsNotAuthorized, DvsFault, ConcurrentAccess, DuplicateName, InvalidState, InvalidName, NotFound, AlreadyExists, LimitExceeded, ResourceInUse, ResourceNotAvailable, RuntimeFault, RemoteException
	{
		ManagedObjectReference taskMor = getVimService().reconfigureDvs_Task(getMOR(), spec);
		return new Task(getServerConnection(), taskMor);
	}
	
	public Task rectifyDvsHost_Task(HostSystem[] hosts) throws DvsFault, NotFound, RuntimeFault, RemoteException
	{
		ManagedObjectReference[] mors = MorUtil.createMORs(hosts);
		ManagedObjectReference mor = getVimService().rectifyDvsHost_Task(getMOR(), mors);
		return new Task(getServerConnection(), mor);
	}
	
	public void refreshDVPortState(String[] portKeys) throws DvsFault, NotFound, RuntimeFault, RemoteException
	{
		getVimService().refreshDVPortState(getMOR(), portKeys);
	}
	
	public void updateDvsCapability(DVSCapability capability) throws RuntimeFault, RemoteException
	{
		getVimService().updateDvsCapability(getMOR(), capability);
	}
	
	public Task reconfigureDVPort_Task(DVPortConfigSpec[] port) throws DvsFault, NotFound, ResourceInUse, ConcurrentAccess, RuntimeFault, RemoteException
	{
		ManagedObjectReference mor = getVimService().reconfigureDVPort_Task(getMOR(), port);
		return new Task(getServerConnection(), mor);
	}
	
}
