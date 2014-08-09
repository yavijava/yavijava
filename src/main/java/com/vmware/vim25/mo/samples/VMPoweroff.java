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

package com.vmware.vim25.mo.samples;

import java.net.URL;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;

/**
 * Sample code to show how to use the Managed Object APIs to power off VM.
 * @author Steve JIN (sjin@vmware.com)
 */


public class VMPoweroff 
{
	public static void main(String[] args) throws Exception
	{
		ServiceInstance si = new ServiceInstance(new URL("https://10.17.218.174/sdk"), "root", "password", true);
		Folder rootFolder = si.getRootFolder();
		
		ManagedEntity[] mes = rootFolder.getChildEntity();
		
		for(int i=0; i<mes.length; i++)
		{
			if(mes[i] instanceof Datacenter)
			{
				Datacenter dc = (Datacenter) mes[i];
				Folder vmFolder = dc.getVmFolder();
				ManagedEntity[] vms = vmFolder.getChildEntity();
				
				for(int j=0; j<vms.length; j++)
				{
					if(vms[j] instanceof VirtualMachine)
					{
						VirtualMachine vm = (VirtualMachine) vms[j];
						System.out.println((vm.getName()));
						VirtualMachineSummary summary = (VirtualMachineSummary) (vm.getSummary());
						System.out.println(summary.toString());
						VirtualMachineRuntimeInfo vmri = (VirtualMachineRuntimeInfo) vm.getRuntime();
						if(vmri.getPowerState() == VirtualMachinePowerState.poweredOn
							&& "Ubuntu704Srv".equals(vm.getName()))
						{
							Task task = vm.powerOffVM_Task();
							task.waitForMe();
							System.out.println("vm:" + vm.getName() + " powered off.");
						}
					}
				}
			}
		}
		si.getServerConnection().logout();
	}
}
