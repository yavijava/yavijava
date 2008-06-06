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

package com.vmware.vim25.mo.util;

import static org.junit.Assert.*;
import java.util.HashMap;
import com.vmware.vim25.mo.*;
import org.apache.commons.cli.ParseException;
import org.junit.Before;
import org.junit.Test;
import com.vmware.vim25.ManagedObjectReference;

public class ServiceInstanceHelperTest
{
	/**
	 * Connects to a VI server and attempts to find a VM to prove that it is
	 * connected. Environment variables that must be set are:
	 * 
	 *  - VI_SERVER - the VI server to connect to
	 *  - VI_USERNAME - the username to authenticate as
	 *  - VI_PASSWORD - the password to use to authenticate
	 *  - VI_VIM - the FQDN of the VM to search for
	 *  - VI_IGNORESSLERRORS - to ignore the server cert
	 * @throws Exception
	 */
	@Test
	public void connectTest() throws Exception
	{
		String[] args = new String[] {
			"--server", System.getenv( "VI_SERVER" ),
			"--username", System.getenv( "VI_USERNAME" ),
			"--password", System.getenv( "VI_PASSWORD" ) 
		};
		
		ServiceInstanceHelper sih = new ServiceInstanceHelper( args );
		
		try
		{
			// Validate the options.
			sih.validateOptions();
		}
		catch ( ParseException e )
		{
			fail( "could not parse args" );
		}
		
		// Connect to the server.
		sih.connect();
		
		// Find the given VM and assert that we found it.
		VirtualMachine vm = ( VirtualMachine) 
			sih.getServiceInstance().getSearchIndex().findByDnsName( 
				null, System.getenv( "VI_VM" ), true );
		assertEquals( System.getenv( "VI_VM" ), vm.getConfig().getName() );
		
		// Disconnect
		sih.disconnect();
	}
}
