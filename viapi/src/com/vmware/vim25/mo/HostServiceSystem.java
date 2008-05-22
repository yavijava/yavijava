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

public class HostServiceSystem extends ExtensibleManagedObject 
{

	public HostServiceSystem(ServerConnection serverConnection, ManagedObjectReference mor) 
	{
		super(serverConnection, mor);
	}

	public HostServiceInfo getServiceInfo()
	{
		return (HostServiceInfo) getCurrentProperty("serviceInfo");
	}
	
	public void refreshServices() throws RuntimeFault, RemoteException 
	{
		getVimService().refreshServices(getMOR());
	}
	
	public void restartService(String id) throws HostConfigFault, InvalidState, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().restartService(getMOR(), id);
	}
	
	public void startService(String id) throws HostConfigFault, InvalidState, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().startService(getMOR(), id);
	}
	
	public void stopService(String id) throws HostConfigFault, InvalidState, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().stopService(getMOR(), id);
	}
	
	public void uninstallService(String id) throws HostConfigFault, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().uninstallService(getMOR(), id);
	}
	
	public void updateServicePolicy(String id, String policy) throws HostConfigFault, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().updateServicePolicy(getMOR(), id, policy);
	}

}
