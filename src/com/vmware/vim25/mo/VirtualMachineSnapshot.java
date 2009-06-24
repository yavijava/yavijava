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

public class VirtualMachineSnapshot extends ManagedObject 
{

	public VirtualMachineSnapshot(ServerConnection sc, ManagedObjectReference mor) 
	{
		super(sc, mor);
	}
	
	public VirtualMachineConfigInfo getConfig()
	{
		return (VirtualMachineConfigInfo) getCurrentProperty("config");
	}
	
	public Task removeSnapshot_Task(boolean removeChildren) throws TaskInProgress, RuntimeFault, RemoteException 
	{	return new Task( getServerConnection(),
			getVimService().removeSnapshot_Task(getMOR(), removeChildren));
	}
	
	public void renameSnapshot(String name, String description) throws InvalidName, RuntimeFault, RemoteException 
	{
		getVimService().renameSnapshot(getMOR(), name, description);
	}
	
	//SDK2.5 signature for back compatibility
	public Task revertToSnapshot_Task(HostSystem host) throws VmConfigFault, TaskInProgress, FileFault, InvalidState, InsufficientResourcesFault, RuntimeFault, RemoteException 
	{
		return revertToSnapshot_Task(host, null);
	}
	
	//SDK4.0 signature
	public Task revertToSnapshot_Task(HostSystem host, Boolean suppressPowerOn) throws VmConfigFault, TaskInProgress, FileFault, InvalidState, InsufficientResourcesFault, RuntimeFault, RemoteException 
	{
		return new Task(getServerConnection(),
				getVimService().revertToSnapshot_Task(getMOR(), host==null? null: host.getMOR(), suppressPowerOn));
	}

}
