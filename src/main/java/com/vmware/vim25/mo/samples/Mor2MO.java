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
 * This sample shows how to create managed object from managed object reference.
 * One of the real use cases is to use the URL passed from a VI client plugin to log back to the VC server.
 * @author sjin
 *
 */


public class Mor2MO 
{
	public final static String MOREF = "moref";
	public final static String SESSION_ID = "sessionId";
	public final static String SERVICE_URL = "serviceUrl";
	public final static String LOCALE = "locale";
	
	public static void main(String[] args) throws Exception
	{
		String urlStr ="http://dev:8000/vmAction.cgi?cmd=powerOn&moref=VirtualMachine:16&sessionId=9241E7B8-A37B-4264-A8D1-945628F9E0D6&locale=en&serviceUrl=https://localhost/sdk";
		
		Map<String, String> kvPairs = parseURL(urlStr);
		
		String morStr = kvPairs.get(MOREF);
		String type = morStr.substring(0, morStr.indexOf(":"));
		String value = morStr.substring(morStr.indexOf(":")+1);
		ManagedObjectReference mor = new ManagedObjectReference();
		mor.setType(type);
		mor.set_value(value);

		String sesssionStr = "vmware_soap_session=\"" + kvPairs.get(SESSION_ID) + "\"";
		ServiceInstance si = new ServiceInstance(new URL(kvPairs.get(SERVICE_URL)),sesssionStr, true);

		ManagedEntity me = MorUtil.createExactManagedEntity(si.getServerConnection(), mor);
		
		String name = me.getName();
		System.out.println("name:" + name);
		if(me instanceof VirtualMachine)
		{
			Task task = ((VirtualMachine)me).powerOffVM_Task();
			task.waitForMe();
		}
		// si.getServerConnection().logout(); if you get access via sessionID, pls don't log out...
	}

	private static Map<String, String> parseURL(String urlStr)
	{
		Map<String, String> kvPairs = new Hashtable<String, String>();
		
		int start = 0;
		int end = 0;
		
		while (true)
		{
			start = urlStr.indexOf("&", end);
			if(start==-1)
			{
				break;
			}
			end = urlStr.indexOf("&", start+1);
			if(end==-1)
			{
				end = urlStr.length();
			}
			
			String data = urlStr.substring(start+1, end);
			int loc = data.indexOf("=");
			String key = data.substring(0, loc);
			String value = data.substring(loc+1);
			kvPairs.put(key, value);
	    }
		
		return kvPairs;
	}
	
}
