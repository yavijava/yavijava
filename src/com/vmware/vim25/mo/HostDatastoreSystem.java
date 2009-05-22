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

public class HostDatastoreSystem extends ManagedObject 
{

	public HostDatastoreSystem(ServerConnection serverConnection, ManagedObjectReference mor) 
	{
		super(serverConnection, mor);
	}

	public HostDatastoreSystemCapabilities getCapabilities()
	{
		return (HostDatastoreSystemCapabilities) getCurrentProperty("capabilities");
	}
	
	public Datastore[] getDatastores()
	{
		return getDatastores("datastore");
	}
	
	public void configureDatastorePrincipal(String userName, String password) throws HostConfigFault, InvalidState, RuntimeFault, RemoteException 
	{
		getVimService().configureDatastorePrincipal(getMOR(), userName, password);
	}
	
	public Datastore createLocalDatastore(String name, String  path) throws HostConfigFault, DuplicateName, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().createLocalDatastore(getMOR(), name, path);
		return new Datastore(getServerConnection(), mor);
	}

	public Datastore createNasDatastore(HostNasVolumeSpec spec) throws HostConfigFault, DuplicateName, AlreadyExists, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().createNasDatastore(getMOR(), spec);
		return new Datastore(getServerConnection(), mor);
	}
	
	public Datastore createVmfsDatastore(VmfsDatastoreCreateSpec spec) throws HostConfigFault, DuplicateName, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().createVmfsDatastore(getMOR(), spec);
		return new Datastore(getServerConnection(), mor);
	}

	/**
	 * @since 4.0
	 */
	public Datastore expandVmfsDatastore(Datastore datastore, VmfsDatastoreExpandSpec spec) throws NotFound, HostConfigFault, RuntimeFault, RemoteException
	{
		ManagedObjectReference mor = getVimService().expandVmfsDatastore(getMOR(), datastore.getMOR(), spec);
		return new Datastore(getServerConnection(), mor);
	}
	
	public Datastore extendVmfsDatastore(Datastore datastore, VmfsDatastoreExtendSpec spec) throws HostConfigFault, NotFound, RuntimeFault, RemoteException 
	{
		if(datastore==null)
		{
			throw new IllegalArgumentException("datastore must not be null.");
		}
		ManagedObjectReference mor = getVimService().extendVmfsDatastore(getMOR(), datastore.getMOR(), spec);
		return new Datastore(getServerConnection(), mor);
	}

	public HostScsiDisk[] queryAvailableDisksForVmfs(Datastore datastore) throws HostConfigFault, NotFound, RuntimeFault, RemoteException 
	{
		return getVimService().queryAvailableDisksForVmfs(getMOR(), datastore==null? null : datastore.getMOR());
	}
	
	public VmfsDatastoreOption[] queryVmfsDatastoreCreateOptions(String devicePath) throws HostConfigFault, NotFound, RuntimeFault, RemoteException 
	{
		return getVimService().queryVmfsDatastoreCreateOptions(getMOR(), devicePath);
	}
	
	//SDK2.5 signature for back compatibility
	public VmfsDatastoreOption[] queryVmfsDatastoreExtendOptions(Datastore datastore, String devicePath) throws HostConfigFault, NotFound, RuntimeFault, RemoteException 
	{
		if(datastore==null)
		{
			throw new IllegalArgumentException("datastore must not be null.");
		}
		return getVimService().queryVmfsDatastoreExtendOptions(getMOR(), datastore.getMOR(), devicePath, false);
	}
	
	//SDK4.0 signature
	public VmfsDatastoreOption[] queryVmfsDatastoreExtendOptions(Datastore datastore, String devicePath, boolean suppressExpandCandidates) throws HostConfigFault, NotFound, RuntimeFault, RemoteException 
	{
		if(datastore==null)
		{
			throw new IllegalArgumentException("datastore must not be null.");
		}
		return getVimService().queryVmfsDatastoreExtendOptions(getMOR(), datastore.getMOR(), devicePath, suppressExpandCandidates);
	}

	/** 
	 * @since 4.0
	 */
	public VmfsDatastoreOption[] queryVmfsDatastoreExpandOptions(Datastore datastore) throws NotFound, HostConfigFault, RuntimeFault, RemoteException
	{
		return getVimService().queryVmfsDatastoreExpandOptions(getMOR(), datastore.getMOR());
	}
	
	/**
	 * @since 4.0
	 */
	public HostUnresolvedVmfsVolume[] queryUnresolvedVmfsVolumes() throws RuntimeFault, RemoteException
	{
		return getVimService().queryUnresolvedVmfsVolumes(getMOR());
	}
	
	public void removeDatastore(Datastore datastore) throws HostConfigFault, ResourceInUse, NotFound, RuntimeFault, RemoteException 
	{
		if(datastore==null)
		{
			throw new IllegalArgumentException("datastore must not be null.");
		}
		getVimService().removeDatastore(getMOR(), datastore.getMOR());
	}
	
	/**
	 * @since 4.0
	 */
	public Task resignatureUnresolvedVmfsVolume_Task(HostUnresolvedVmfsResignatureSpec resolutionSpec) throws VmfsAmbiguousMount, HostConfigFault, RuntimeFault, RemoteException
	{
		ManagedObjectReference taskMor = getVimService().resignatureUnresolvedVmfsVolume_Task(getMOR(), resolutionSpec);
		return new Task(getServerConnection(), taskMor);
	}
	
	public void updateLocalSwapDatastore(Datastore datastore) throws InaccessibleDatastore, DatastoreNotWritableOnHost, RuntimeFault, RemoteException 
	{
		getVimService().updateLocalSwapDatastore(getMOR(), datastore==null? null : datastore.getMOR());
	}

}
