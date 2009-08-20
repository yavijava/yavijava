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

public class HostPatchManager extends ManagedObject 
{

	public HostPatchManager(ServerConnection serverConnection, ManagedObjectReference mor) 
	{
		super(serverConnection, mor);
	}

	/** 
	 * @since 4.0
	 */
	public Task checkHostPatch_Task(String[] metaUrls, String[] bundleUrls, HostPatchManagerPatchManagerOperationSpec spec) throws PlatformConfigFault, RequestCanceled, InvalidState, TaskInProgress, RuntimeFault, RemoteException
	{
		ManagedObjectReference taskMor = getVimService().checkHostPatch_Task(getMOR(), metaUrls, bundleUrls, spec);
		return new Task(getServerConnection(), taskMor);
	}

	/** 
	 * @since 4.0
	 */
	public Task installHostPatchV2_Task(String[] metaUrls, String[] bundleUrls, String[] vibUrls, HostPatchManagerPatchManagerOperationSpec spec) throws PlatformConfigFault, RequestCanceled, InvalidState, TaskInProgress, RuntimeFault, RemoteException
	{
		ManagedObjectReference taskMor = getVimService().installHostPatchV2_Task(getMOR(), metaUrls, bundleUrls, vibUrls, spec);
		return new Task(getServerConnection(), taskMor);
	}
	
	public Task installHostPatch_Task(HostPatchManagerLocator repository, String updateID, Boolean force) throws PatchInstallFailed, NoDiskSpace, TaskInProgress, RebootRequired, PatchBinariesNotFound, InvalidState, PatchNotApplicable, PatchMetadataInvalid, RuntimeFault, RemoteException
	{
		return new Task(getServerConnection(),
		getVimService().installHostPatch_Task(getMOR(), repository, updateID, force));
	}
	
	/** 
	 * @since 4.0
	 */
	public Task queryHostPatch_Task(HostPatchManagerPatchManagerOperationSpec spec) throws PlatformConfigFault, RequestCanceled, InvalidState, TaskInProgress, RuntimeFault, RemoteException
	{
		ManagedObjectReference taskMor = getVimService().queryHostPatch_Task(getMOR(), spec);
		return new Task(getServerConnection(), taskMor);
	}
	
	public Task scanHostPatch_Task(HostPatchManagerLocator repository, String[] updateID) throws PlatformConfigFault, RequestCanceled, PatchMetadataInvalid, RuntimeFault, RemoteException 
	{
		return new Task(getServerConnection(),
			getVimService().scanHostPatch_Task(getMOR(), repository, updateID));
	}
	
	/**
	 * @since 4.0
	 */
	public Task scanHostPatchV2_Task(String[] metaUrls, String[] bundleUrls, HostPatchManagerPatchManagerOperationSpec spec) throws PlatformConfigFault, RequestCanceled, InvalidState, TaskInProgress, RuntimeFault, RemoteException
	{
		ManagedObjectReference taskMor = getVimService().scanHostPatchV2_Task(getMOR(), metaUrls, bundleUrls, spec);
		return new Task(getServerConnection(), taskMor);
	}
	
	/**
	 * @since 4.0
	 */
	public Task stageHostPatch_Task(String[] metaUrls, String[] bundleUrls, String[] vibUrls, HostPatchManagerPatchManagerOperationSpec spec) throws PlatformConfigFault, RequestCanceled, InvalidState, TaskInProgress, RuntimeFault, RemoteException
	{
		ManagedObjectReference taskMor = getVimService().stageHostPatch_Task(getMOR(), metaUrls, bundleUrls, vibUrls, spec);
		return new Task(getServerConnection(), taskMor);
	}
	
	/**
	 * @since 4.0
	 */
	public Task uninstallHostPatch_Task(String[] bulletinIds, HostPatchManagerPatchManagerOperationSpec spec) throws PlatformConfigFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException
	{
    ManagedObjectReference taskMor = getVimService().uninstallHostPatch_Task(getMOR(), bulletinIds, spec);
    return new Task(getServerConnection(), taskMor);
	}
}
