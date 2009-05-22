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

import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.NoActiveHostInCluster;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.VirtualMachinePowerState;
import com.vmware.vim25.VirtualMachineRelocateSpec;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 * @author Steve JIN (sjin@vmware.com)
 * @since 4.0
 */
public class VirtualMachineProvisioningChecker extends ManagedObject 
{
	public VirtualMachineProvisioningChecker(ServerConnection sc, ManagedObjectReference mor) 
	{
		super(sc, mor);
	}
	
	public Task checkMigrate_Task(VirtualMachine vm, HostSystem host, ResourcePool pool, VirtualMachinePowerState state, String[] testType) throws NoActiveHostInCluster, InvalidState, RuntimeFault, RemoteException
	{
		ManagedObjectReference taskMor = getVimService().checkMigrate_Task(getMOR(), 
				vm.getMOR(), 
				host==null?null : host.getMOR(), 
				pool==null?null : pool.getMOR(), state, testType);
		return new Task(getServerConnection(), taskMor);
	}
	
	public Task checkRelocate_Task(VirtualMachine vm, VirtualMachineRelocateSpec spec, String[] testType) throws InvalidState, RuntimeFault, RemoteException
	{
		ManagedObjectReference taskMor = getVimService().checkRelocate_Task(getMOR(), 
				vm.getMOR(), spec, testType);
		return new Task(getServerConnection(), taskMor);
	}
	
	public Task queryVMotionCompatibilityEx_Task(VirtualMachine[] vm, HostSystem[] host) throws RuntimeFault, RemoteException
	{
		ManagedObjectReference taskMor = getVimService().queryVMotionCompatibilityEx_Task(getMOR(), 
				convertMors(vm), convertMors(host));
		return new Task(getServerConnection(), taskMor);
	}
}