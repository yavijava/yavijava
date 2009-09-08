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

import com.vmware.vim25.ArrayUpdateOperation;
import com.vmware.vim25.ClusterAffinityRuleSpec;
import com.vmware.vim25.ClusterConfigSpec;
import com.vmware.vim25.ClusterRuleSpec;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.mo.ClusterComputeResource;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.util.MorUtil;

/**
 * @author Steve Jin
 * http://vijava.sf.net
 * This sample code illustrates how to set up an affinity rule for the DRS cluster.
 * Please note that this sample is not intended to be complete or for production use.
 * Some of the information are hardcoded to simplify the code.
 */

public class DrsAffRule 
{
	public static void main(String[] args) throws Exception
	{
		if(args.length!=3)
		{
			System.out.println("Usage: DrsAffRule url username password");
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
		String drs_obj_id = "domain-c5"; // The reference ID for cluster
		String vm1_oid = "vm-26"; // The reference ID for VM 1
		String vm2_oid = "vm-28"; // The reference ID for VM 2
		
		// initialize the system, set up web services
		ServiceInstance si = new ServiceInstance(url, username, password, true);
		
		//create the MOR object for DRS cluster
		ManagedObjectReference mref_drs = createMOR("ClusterComputeResource", drs_obj_id);
		ClusterComputeResource ccr = (ClusterComputeResource )
		  MorUtil.createExactManagedEntity(si.getServerConnection(), mref_drs);
		
		// create a new ClusterConfigSpec and populate it with related data for affinity rule
		ClusterConfigSpec ccs = new ClusterConfigSpec();

		ClusterAffinityRuleSpec cars = new ClusterAffinityRuleSpec();
		cars.setName("App and DB Appliance Bundle");
		cars.setEnabled(Boolean.TRUE);
		ManagedObjectReference vm1 = createMOR("VirtualMachine", vm1_oid);
		ManagedObjectReference vm2 = createMOR("VirtualMachine", vm2_oid);
		cars.setVm(new ManagedObjectReference[] {vm1, vm2});
		
		ClusterRuleSpec crs = new ClusterRuleSpec();
		//*NOTE*: the following setOperation has to be called since operation must be set.
		crs.setOperation(ArrayUpdateOperation.add);
		crs.setInfo(cars);

		ccs.setRulesSpec(new ClusterRuleSpec[] {crs});

		// make a call to set the configuration.
		ccr.reconfigureCluster_Task(ccs, true);

		si.getServerConnection().logout();
		
		System.out.println("Done with setting affinity rule for DRS cluster.");
	}
	
	public static ManagedObjectReference createMOR(String type, String id)
	{
		ManagedObjectReference mor = new ManagedObjectReference();
		mor.setType(type);
		mor.set_value(id);
		return mor; 
	}
}