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

import java.rmi.RemoteException;

import com.vmware.vim25.InvalidCollectorVersion;
import com.vmware.vim25.InvalidProperty;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectContent;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.RetrieveOptions;
import com.vmware.vim25.RetrieveResult;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.WaitOptions;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 * @author Steve JIN (sjin@vmware.com)
 */

public class PropertyCollector extends ManagedObject 
{

	public PropertyCollector(ServerConnection serverConnection, ManagedObjectReference mor) 
	{
		super(serverConnection, mor);
	}

	public PropertyFilter[] getFilters()
	{
		return getFilter("filter");
	}
	
	/** @since SDK4.1 */
	public void cancelRetrievePropertiesEx(String token) throws InvalidProperty, RuntimeFault, RemoteException
	{
    getVimService().cancelRetrievePropertiesEx(getMOR(), token); 
	}
	
	public void cancelWaitForUpdates() throws RuntimeFault, RemoteException
	{
		getVimService().cancelWaitForUpdates(getMOR());
	}
	
  /** @since SDK4.1 */
	public RetrieveResult continueRetrievePropertiesEx(String token) throws InvalidProperty, RuntimeFault, RemoteException
	{
	  return getVimService().continueRetrievePropertiesEx(getMOR(), token);
	}
	
	public UpdateSet checkForUpdates(String version) throws InvalidCollectorVersion, RuntimeFault, RemoteException
	{
		return getVimService().checkForUpdates(getMOR(), version);
	}
	
	public PropertyFilter createFilter(PropertyFilterSpec spec, boolean partialUpdates) throws InvalidProperty, RuntimeFault, RemoteException
	{
		ManagedObjectReference mor = getVimService().createFilter(getMOR(), spec, partialUpdates);
		return new PropertyFilter(getServerConnection(), mor);
	}
	
	/** @since SDK4.1 */
	public PropertyCollector createPropertyCollector() throws RuntimeFault, RemoteException
	{
	  ManagedObjectReference mor = getVimService().createPropertyCollector(getMOR());
    return new PropertyCollector(getServerConnection(), mor);
	}
	
	 /** @since SDK4.1 */
	public void destroyPropertyCollector() throws RuntimeFault, RemoteException
	{
	  getVimService().destroyPropertyCollector(getMOR());
	}
	
	/** @deprecated as of SDK4.1 */
	public ObjectContent[] retrieveProperties(PropertyFilterSpec[] specSet) throws InvalidProperty, RuntimeFault, RemoteException
	{
		return getVimService().retrieveProperties(getMOR(), specSet);
	}
	
	/** @since SDK4.1 */
  public RetrieveResult retrievePropertiesEx(PropertyFilterSpec[] specSet, RetrieveOptions options) throws InvalidProperty, RuntimeFault, RemoteException
  {
    return getVimService().retrievePropertiesEx(getMOR(), specSet, options);
  }
	
  /** @deprecated as of SDK4.1 */
	public UpdateSet waitForUpdates(String version) throws InvalidCollectorVersion, RuntimeFault, RemoteException
	{
		return getVimService().waitForUpdates(getMOR(), version);
	}
	
	/** @since SDK4.1 */
  public UpdateSet waitForUpdatesEx(String version, WaitOptions options) throws InvalidCollectorVersion, RuntimeFault, RemoteException
  {
	  return getVimService().waitForUpdatesEx(getMOR(), version, options);
  }

}