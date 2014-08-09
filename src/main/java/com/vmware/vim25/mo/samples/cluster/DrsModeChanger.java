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

import java.net.URL;

import com.vmware.vim25.ClusterConfigSpec;
import com.vmware.vim25.ClusterDrsConfigInfo;
import com.vmware.vim25.DrsBehavior;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.ClusterComputeResource;
import com.vmware.vim25.mo.util.*;

/**
 * @author Steve Jin
 * http://vijava.sf.net
 * This sample code illustrates how to use VI SDK API to change DRS configurations.
 * It's NOT intended for production use.
 */

public class DrsModeChanger 
{
	public static void main(String[] args) throws Exception 
	{
		if(args.length!=4)
		{
			System.out.println("Usage: DrsModeChanger url username password mode");
			System.exit(-1);
		}

		URL url = new URL(args[0]);
		String username = args[1];
		String password = args[2];
		String mode = args[3];
		String drs_obj_id = "domain-c5";
		
		ServiceInstance si = new ServiceInstance(url, username, password, true);
		
		ManagedObjectReference mref_drs = new ManagedObjectReference();
		mref_drs.set_value(drs_obj_id);
		mref_drs.setType("ClusterComputeResource");
		
		ClusterComputeResource ccr = (ClusterComputeResource )MorUtil.createExactManagedEntity(si.getServerConnection(), mref_drs);
		
		ClusterConfigSpec ccs = new ClusterConfigSpec();
		ClusterDrsConfigInfo cdci = new ClusterDrsConfigInfo();
		if("manual".equals(mode))
			cdci.setDefaultVmBehavior(DrsBehavior.manual);
		else 
			cdci.setDefaultVmBehavior(DrsBehavior.fullyAutomated);
		cdci.setVmotionRate(new Integer(5));
		ccs.setDrsConfig(cdci);
		
		ccr.reconfigureCluster_Task(ccs, true);
		
		si.getServerConnection().logout();
		System.out.println("End of changing DRS config to " + args[3]);
	}
}
