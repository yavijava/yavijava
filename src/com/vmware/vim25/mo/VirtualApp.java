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

import com.vmware.vim25.ConcurrentAccess;
import com.vmware.vim25.DuplicateName;
import com.vmware.vim25.FileFault;
import com.vmware.vim25.InsufficientResourcesFault;
import com.vmware.vim25.InvalidDatastore;
import com.vmware.vim25.InvalidName;
import com.vmware.vim25.InvalidPowerState;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.MigrationFault;
import com.vmware.vim25.ResourceConfigSpec;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.TaskInProgress;
import com.vmware.vim25.VAppCloneSpec;
import com.vmware.vim25.VAppConfigFault;
import com.vmware.vim25.VAppConfigInfo;
import com.vmware.vim25.VAppConfigSpec;
import com.vmware.vim25.VirtualAppLinkInfo;
import com.vmware.vim25.VmConfigFault;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 * @author Steve JIN (sjin@vmware.com)
 */
public class VirtualApp extends ResourcePool
{
	public VirtualApp(ServerConnection sc, ManagedObjectReference mor) 
	{
		super(sc, mor);
	}

	/** @since SDK4.1 */
	public VirtualAppLinkInfo[] getChildLink()
	{
	  return (VirtualAppLinkInfo[]) getCurrentProperty("childLink");
	}
	
	public Datastore[] getDatastore()
	{
		return getDatastores("datastore");
	}
	
	public Network[] getNetwork()
	{
		return getNetworks("network");
	}
	
	public Folder getParentFolder()
	{
		ManagedObjectReference mor = (ManagedObjectReference) getCurrentProperty("parentFolder");
		return new Folder(getServerConnection(), mor);
	}
	
	/** @since SDK4.1 */
	public ManagedEntity getParentVApp()
	{
	  ManagedObjectReference mor = (ManagedObjectReference) getCurrentProperty("parentVApp");
    return new ManagedEntity(getServerConnection(), mor);
	}
	
	public VAppConfigInfo getVAppConfig()
	{
		return (VAppConfigInfo) getCurrentProperty("vAppConfig");
	}
	
	public Task cloneVApp_Task(String name, ManagedObjectReference target, VAppCloneSpec spec) throws InvalidState, InvalidDatastore, TaskInProgress, VmConfigFault, FileFault, MigrationFault, InsufficientResourcesFault, RuntimeFault, RemoteException
	{
		ManagedObjectReference taskMor = getVimService().cloneVApp_Task(getMOR(), name, target, spec);
		return new Task(getServerConnection(), taskMor);
	}
	
	public HttpNfcLease exportVApp() throws InvalidPowerState, TaskInProgress, InvalidState, FileFault, RuntimeFault, RemoteException
	{
		ManagedObjectReference mor = getVimService().exportVApp(getMOR());
		return new HttpNfcLease(getServerConnection(), mor);
	}
	
	public Task powerOffVApp_Task(boolean force) throws TaskInProgress, InvalidState, VAppConfigFault, RuntimeFault, RemoteException
	{
		ManagedObjectReference taskMor = getVimService().powerOffVApp_Task(getMOR(), force);
		return new Task(getServerConnection(), taskMor);
	}
	
	/** @since SDK4.1 */
	public Task suspendVApp_Task() throws TaskInProgress, InvalidState, VAppConfigFault, RuntimeFault, RemoteException
	{
	  ManagedObjectReference taskMor = getVimService().suspendVApp_Task(getMOR());
	  return new Task(getServerConnection(), taskMor);
	}
	
	public Task powerOnVApp_Task() throws TaskInProgress, InvalidState, InsufficientResourcesFault, VmConfigFault, VAppConfigFault, FileFault, RuntimeFault, RemoteException
	{
		ManagedObjectReference taskMor = getVimService().powerOnVApp_Task(getMOR());
		return new Task(getServerConnection(), taskMor);
	}
	
	public Task unregisterVApp_Task() throws ConcurrentAccess, InvalidState, RuntimeFault, RemoteException
	{
		ManagedObjectReference taskMor = getVimService().unregisterVApp_Task(getMOR());
		return new Task(getServerConnection(), taskMor);
	}
	
	/** @since SDK4.1 */
	public void updateLinkedChildren(VirtualAppLinkInfo[] addChangeSet, ManagedObjectReference[] removeSet) throws ConcurrentAccess, RuntimeFault, RemoteException
	{
	  getVimService().updateLinkedChildren(getMOR(), addChangeSet, removeSet);
	}
	
	public void updateVAppConfig(VAppConfigSpec spec) throws TaskInProgress, VmConfigFault, ConcurrentAccess, FileFault, InvalidName, DuplicateName, InvalidState, InsufficientResourcesFault, InvalidDatastore, RuntimeFault, RemoteException
	{
		getVimService().updateVAppConfig(getMOR(), spec);
	}
}
