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

package com.vmware.vim25.mo.samples.cluster;

import java.net.MalformedURLException;
import java.net.URL;

import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ResourceAllocationInfo;
import com.vmware.vim25.SharesInfo;
import com.vmware.vim25.SharesLevel;
import com.vmware.vim25.VirtualMachineConfigSpec;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.VirtualMachine;
import com.vmware.vim25.mo.util.*;

/**
 * @author Steve Jin
 * http://vijava.sf.net
 * This sample code illustrates how to set up VM shares.
 * Please note that this sample is not intended to be complete or for production use.
 * Some of the information are hard-coded to simplify the code.
 */

public class DrsVmShares
{
	public static void main(String[] args) throws Exception
	{
		if(args.length!=3)
		{
			System.out.println("Usage: DrsVmShares url username password");
			System.exit(-1);
		}
		
		URL url = null;
		try 
		{ 
			url = new URL(args[0]); 
		} catch ( MalformedURLException urlE)
		{
			System.out.println("The URL provided is NOT valid. Please check it.");
			System.exit(-1);
		}
		String username = args[1];
		String password = args[2];
		String vm1_oid = "vm-26"; // The reference ID for VM 1
		String vm2_oid = "vm-28"; // The reference ID for VM 2
		
		// initialize the system, set up web services
    ServiceInstance si = new ServiceInstance(url, username, password, true);
    
		// create a new VirtualMachineConfigSpec for VM1
		VirtualMachineConfigSpec vmcs1 = new VirtualMachineConfigSpec();
		ResourceAllocationInfo rai1 = new ResourceAllocationInfo();
		SharesInfo si1 = new SharesInfo();
		si1.setLevel(SharesLevel.custom);
		si1.setShares(1333);
		rai1.setShares(si1);
		vmcs1.setCpuAllocation(rai1);

		// do the same for VM2
		VirtualMachineConfigSpec vmcs2 = new VirtualMachineConfigSpec();
		ResourceAllocationInfo rai2 = new ResourceAllocationInfo();
		SharesInfo si2 = new SharesInfo();
		si2.setLevel(SharesLevel.high);
		rai2.setShares(si2);
		vmcs2.setCpuAllocation(rai2);
		
		ManagedObjectReference vm1_mor = createMOR("VirtualMachine", vm1_oid);
		ManagedObjectReference vm2_mor = createMOR("VirtualMachine", vm2_oid);
		VirtualMachine vm1 = (VirtualMachine) MorUtil.createExactManagedEntity(si.getServerConnection(), vm1_mor);
		VirtualMachine vm2 = (VirtualMachine) MorUtil.createExactManagedEntity(si.getServerConnection(), vm2_mor);
		
		// make a web service call to set the configuration.
		vm1.reconfigVM_Task(vmcs1);
		vm2.reconfigVM_Task(vmcs2);			

		// log out from web service
		si.getServerConnection().logout();
		System.out.println("Done with setting VM CPU shares.");
	}
	
	public static ManagedObjectReference createMOR(String type, String id)
	{
		ManagedObjectReference mor = new ManagedObjectReference();
		mor.setType(type);
		mor.set_value(id);
		return mor; 
	}
}