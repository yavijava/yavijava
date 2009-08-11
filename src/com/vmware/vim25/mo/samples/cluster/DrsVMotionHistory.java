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
import java.net.*;

import com.vmware.vim25.ClusterDrsMigration;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;
import com.vmware.vim25.ws.*;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class DrsVMotionHistory
{
	public static void main(String[] args) throws Exception
	{
		ServiceInstance si = new ServiceInstance(new URL("https://10.20.143.209/sdk"), "Administrator", "password", true);
		ClusterComputeResource drsCluster = (ClusterComputeResource) new InventoryNavigator(
				si.getRootFolder()).searchManagedEntity("ClusterComputeResource", "myDrs");
		if(drsCluster==null)
		{
			System.out.println("There is no cluster called myDrs. Exiting...");
		}
		
		ClusterDrsMigration[] histories = drsCluster.getMigrationHistory();
		if(histories==null)
		{
			System.out.println("There is no migration history set. Please check whether it's running in automatic mode!\nExiting...");
		}
		
		System.out.println("There were totally " + histories.length + " migration(s).");
		
		for(int i=0; i < histories.length; i++)
		{   ServerConnection sc = si.getServerConnection();
			VirtualMachine vm = (VirtualMachine) MorUtil.createExactManagedEntity(sc, histories[i].getVm());
			HostSystem srcHost = (HostSystem) MorUtil.createExactManagedEntity(sc, histories[i].getSource());
			HostSystem dstHost = (HostSystem) MorUtil.createExactManagedEntity(sc, histories[i].getDestination());
			System.out.println("VM: " + vm.getName() + " migrated from " + srcHost.getName() + " to " + dstHost.getName());			
		}
		si.getServerConnection().logout();
	}
}