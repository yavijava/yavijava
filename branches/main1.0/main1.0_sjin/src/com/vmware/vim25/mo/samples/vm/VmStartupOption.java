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

package com.vmware.vim25.mo.samples.vm;

import java.net.URL;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;

public class VmStartupOption 
{
	public static void main(String[] args) throws Exception
	{
		CommandLineParser clp = new CommandLineParser(constructOptions(), args);
		String urlStr = clp.get_option("url");
		String username = clp.get_option("username");
		String password = clp.get_option("password");
        String hostname = clp.get_option("hostname");

		ServiceInstance si = new ServiceInstance(new URL(urlStr), username, password, true);
		HostSystem host = (HostSystem) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("HostSystem", hostname);

		if(host==null)
		{
			System.out.println("Host cannot be found");
			return;
		}
		
		HostAutoStartManager hasm = host.getHostAutoStartManager();
		if(hasm==null)
		{
			System.out.println("HostAutoStartManager is not available.");
			return;
		}

		AutoStartDefaults asd = new AutoStartDefaults();
		asd.setStartDelay(new Integer(100));
		asd.setEnabled(Boolean.TRUE);
		asd.setStopDelay(new Integer(60));
		HostAutoStartManagerConfig spec = new HostAutoStartManagerConfig();
		spec.setDefaults(asd);
		hasm.reconfigureAutostart(spec);

		System.out.println("Done with reconfiguring the autostart options.");
	}
	
   private static OptionSpec[] constructOptions() 
   {
      return new OptionSpec[] 
      {
    		  new OptionSpec("hostname","String",1 ,"Name of the host", null)
      };
   }
}
