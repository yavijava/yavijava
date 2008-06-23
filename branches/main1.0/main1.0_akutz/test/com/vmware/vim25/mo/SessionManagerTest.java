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

import static org.junit.Assert.*;
import java.util.Arrays;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import com.jinvoke.JInvoke;
import com.jinvoke.Util;
import com.vmware.vim25.*;
import com.vmware.vim25.mo.ServiceInstance;

public class SessionManagerTest
{
	@Test
	public void testLoginBySSPI() throws Exception
	{
		// This unit test is only valid on Windows platforms.
		if ( System.getProperty( "os.name" )
			.toUpperCase().indexOf( "WINDOWS" ) == -1 )
		{
			return;
		}	
			
		// Attempt to login by SSPI
		ServiceInstance si = new ServiceInstance(
			ServiceInstance.getVIUrl( System.getenv( "VI_SERVER" ), true ),
			true );
		
		UserSession us = si.getSessionManager().getCurrentSession();
		Assert.assertNotNull( us );
		
		// Logout
		si.getServerConnection().logout();
	}
	
}