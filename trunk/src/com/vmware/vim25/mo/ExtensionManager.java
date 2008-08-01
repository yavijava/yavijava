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

/* **********************************************************
 * Copyright 2007 VMware, Inc.  All rights reserved. 
 * -- VMware Confidential
 * **********************************************************/
package com.vmware.vim25.mo;

import java.rmi.RemoteException;

import com.vmware.vim25.*;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 * @author Steve JIN (sjin@vmware.com)
 */

public class ExtensionManager extends ManagedObject
{
	
	public ExtensionManager(ServerConnection serverConnection, ManagedObjectReference mor) 
	{
		super(serverConnection, mor);
	}
	
	/**
	 * Retrieve all the registered plugins objects 
	 * @return An array of extension objects. If no extension found, an empty array is returned.
	 */
	
	public Extension[] getExtensionList() 
	{
		return (Extension[])getCurrentProperty("extensionList");
	}


	/**
	 * Un-register an existing plugin
	 * If <code>keyStr</code> is null then a <code>NullPointerException</code>
     * is thrown.
	 * @param keyStr The unique key of the plugin
	 * @throws RemoteException 
	 * @throws RuntimeFault 
	 * @throws NotFound 
	 * either because of the web service itself, or because of the service
	 * provider unable to handle the request. 
	 */
	public void unregisterExtension(String keyStr) throws NotFound, RuntimeFault, RemoteException
	{
		if (keyStr == null) {
		    throw new NullPointerException();
		}
		getVimService().unregisterExtension(getMOR(), keyStr);
	}

	/**
	 * Update an existing plugin with modified information
	 * If <code>extension</code> is null then a <code>NullPointerException</code> is thrown.
	 * @param extension The extension object with updated information
	 * @throws RemoteException 
	 * @throws RuntimeFault 
	 * @throws NotFound 
	 * either because of the web service itself, or because of the service
	 * provider unable to handle the request. 
	 */
	public void updateExtension(Extension extension) throws NotFound, RuntimeFault, RemoteException
	{
		if (extension == null) {
		    throw new NullPointerException();
		}
		getVimService().updateExtension(getMOR(), extension);
	}

	/**
	 * Register a new plugin
	 * If <code>extension</code> is null then a <code>NullPointerException</code> is thrown.
	 * @param extension The extension object to be registered
	 * @throws RemoteException 
	 * @throws RuntimeFault 
	 * either because of the web service itself, or because of the service
	 * provider unable to handle the request. 
	 */
	public void registerExtension(Extension extension) throws RuntimeFault, RemoteException
	{
		if (extension == null) {
		    throw new NullPointerException();
		}
		getVimService().registerExtension(getMOR(), extension);
	}
	
	/**
	 * Find the extension based on the unique key of the plugin
 	 * If <code>keyStr</code> is null then a <code>NullPointerException</code>
	 * @param keyStr The unique key for the plugin
	 * @return The extension object found with the unique key
	 * @throws RemoteException 
	 * @throws RuntimeFault 
	 * @throws RemoteException if something is wrong with web service call, 
	 * either because of the web service itself, or because of the service
	 * provider unable to handle the request. 
	 */
	public Extension findExtension(String keyStr) throws RuntimeFault, RemoteException
	{
		if (keyStr == null) {
		    throw new NullPointerException();
		}
		return getVimService().findExtension(getMOR(), keyStr);
	}

	/**
	 * Print out information of all the plugins to stdout
	 * @throws RemoteException if something is wrong with web service call, 
	 * either because of the web service itself, or because of the service
	 * provider unable to handle the request. 
	 */
	public void printAllExtensions() 
	{
		Extension[] exts = getExtensionList();

		System.out.println("There are totally " + exts.length + " plugin(s) registered.");
		
		for(int i=0; exts!=null && i<exts.length; i++)
		{
			System.out.println("\n ---- Plugin # " + (i+1) + " ---- ");
			System.out.println("Key: " + exts[i].getKey());
			System.out.println("Version: " + exts[i].getVersion());
			System.out.println("Registration Time: " + exts[i].getLastHeartbeatTime().getTime());
			System.out.println("Configuration URL: " + exts[i].getServer()[0].getUrl());
		}
	}
	
}
