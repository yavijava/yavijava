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
import com.vmware.vim25.mo.util.*;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 * @author Steve JIN (sjin@vmware.com)
 */

public class Datacenter extends ManagedEntity 
{

	public Datacenter(ServerConnection sc, ManagedObjectReference mor) 
	{
		super(sc, mor);
	}
	
	public Folder getVmFolder() throws InvalidProperty, RuntimeFault, RemoteException  
	{
		return (Folder) this.getManagedObject("vmFolder");
	}
	
	public Folder getHostFolder() throws InvalidProperty, RuntimeFault, RemoteException  
	{
		return (Folder) this.getManagedObject("hostFolder");
	}

	public Datastore[] getDatastores()
	{
		return getDatastores("datastore");
	}
	
	/**
	 * @since 4.0
	 */
	public Folder getDatastoreFolder()
	{
		return (Folder) getManagedObject("datastoreFolder");
	}
	
	/**
	 * @since 4.0
	 */
	public Folder getNetworkFolder()
	{
		return (Folder) getManagedObject("networkFolder");
	}
	
	public Network[] getNetworks() throws InvalidProperty, RuntimeFault, RemoteException  
	{
		return getNetworks("network");
	}
	
	/** old signature for back compatibility with 2.5 and 4.0 */
  public Task powerOnMultiVM_Task(VirtualMachine[] vms) throws RuntimeFault, RemoteException  
  {
    return powerOnMultiVM_Task(vms, null);
  }
	
  /** @since SDK4.1 */
	public Task powerOnMultiVM_Task(VirtualMachine[] vms, OptionValue[] option) throws RuntimeFault, RemoteException  
	{
		if(vms==null)
		{
			throw new IllegalArgumentException("vms must not be null.");
		}
		ManagedObjectReference[] mors = MorUtil.createMORs(vms);
		ManagedObjectReference tmor = getVimService().powerOnMultiVM_Task(getMOR(), mors, option);
		return new Task(getServerConnection(), tmor);
	}
	
	public HostConnectInfo queryConnectionInfo(String hostname, int port, String username, String password,
			String sslThumbprint) throws InvalidLogin, HostConnectFault, RuntimeFault, RemoteException  
	{
		return getVimService().queryConnectionInfo(getMOR(), hostname, port, username, password, sslThumbprint);
	}
	
}
