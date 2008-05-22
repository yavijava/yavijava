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
import java.util.*;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;

/**
*<pre>
*This sample Determines the amount of memory overhead necessary to
*power on a virtual machine with the specified characteristics.
*
*<b>Parameters:</b>
*hostname        [required]:Name of the host
*memorysize      [required]:Size of the memory in MB
*cpucount        [required]:Number of the CPU count
*
*</pre>
*@author sjin
*/

public class QueryMemoryOverhead 
{
	public static void main(String[] args) throws Exception 
	{
		CommandLineParser clp = new CommandLineParser(constructOptions(), args);
		String urlStr = clp.get_option("url");
		String username = clp.get_option("username");
		String password = clp.get_option("password");
		String hostname = clp.get_option("hostname");
		String memorysize = clp.get_option("memorysize");
		String cpucount = clp.get_option("cpucount");
			
		ServiceInstance si = new ServiceInstance(new URL(urlStr), username, password, true);

		HostSystem host = (HostSystem) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("HostSystem",hostname);

		VirtualMachineConfigInfo vmConfigInfo = new VirtualMachineConfigInfo();
            
		vmConfigInfo.setChangeVersion("1");
		Calendar cal = si.currentTime(); 
		vmConfigInfo.setModified(cal);
           
		VirtualMachineDefaultPowerOpInfo defaultInfo = new VirtualMachineDefaultPowerOpInfo();
		vmConfigInfo.setDefaultPowerOps(defaultInfo);
           
		VirtualMachineFileInfo fileInfo = new VirtualMachineFileInfo();
		vmConfigInfo.setFiles(fileInfo);
            
		VirtualMachineFlagInfo flagInfo = new VirtualMachineFlagInfo();
		vmConfigInfo.setFlags(flagInfo);
            
		vmConfigInfo.setGuestFullName("Full Name");
		vmConfigInfo.setGuestId("Id");
            
		VirtualHardware vhardware = new VirtualHardware();
		vhardware.setMemoryMB(Integer.parseInt(memorysize));
		vhardware.setNumCPU(Integer.parseInt(cpucount));
		vmConfigInfo.setHardware(vhardware);
            
		// TODO*** Not Required For Computing The Overhead
		vmConfigInfo.setName("OnlyFoeInfo");
		vmConfigInfo.setUuid("12345678-abcd-1234-cdef-123456789abc");
		vmConfigInfo.setVersion("First");
		vmConfigInfo.setTemplate(false);
		vmConfigInfo.setAlternateGuestName("Alternate");
            
       Long overhead = host.queryMemoryOverheadEx(vmConfigInfo);      
       System.out.println("Using queryMemoryOverheadEx API using vmReconfigInfo");
       System.out.println("Memory overhead necessary to power on a virtual machine with memory " 
                          + memorysize + " MB and cpu count " + cpucount + " -: " + overhead + " bytes");
    }
    
    public static OptionSpec[] constructOptions() 
    {
        return new OptionSpec [] {
        		new OptionSpec("hostname", "String", 1 ,"Name of the host", null),
        		new OptionSpec("memorysize", "Integer", 1, "Size of the memory", null),
        		new OptionSpec("cpucount", "Integer", 1, "Number of the CPU count", null)
        };
     }  
}
