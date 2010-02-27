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

import com.vmware.vim25.*;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 * @author Steve JIN (sjin@vmware.com)
 */

public class HostNetworkSystem extends ExtensibleManagedObject 
{

	public HostNetworkSystem(ServerConnection serverConnection, ManagedObjectReference mor) 
	{
		super(serverConnection, mor);
	}

	public HostNetCapabilities getCapabilities()
	{
		return (HostNetCapabilities) getCurrentProperty("capabilities");
	}
	
	public HostIpRouteConfig getConsoleIpRouteConfig()
	{
		return (HostIpRouteConfig) getCurrentProperty("consoleIpRouteConfig");
	}
	
	public HostDnsConfig getDnsConfig()
	{
		return (HostDnsConfig) getCurrentProperty("dnsConfig");
	}
	
	public HostIpRouteConfig getIpRouteConfig()
	{
		return (HostIpRouteConfig) getCurrentProperty("ipRouteConfig");
	}
	
	public HostNetworkConfig getNetworkConfig()
	{
		return (HostNetworkConfig) getCurrentProperty("networkConfig");
	}
	
	public HostNetworkInfo getNetworkInfo()
	{
		return (HostNetworkInfo) getCurrentProperty("networkInfo");
	}

	public HostNetOffloadCapabilities getOffloadCapabilities()
	{
		return (HostNetOffloadCapabilities) getCurrentProperty("offloadCapabilities");
	}
	
	public void addPortGroup(HostPortGroupSpec portgrp) throws HostConfigFault, AlreadyExists, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().addPortGroup(getMOR(), portgrp);
	}
	
	public String addServiceConsoleVirtualNic(String portgroup, HostVirtualNicSpec spec) throws HostConfigFault, RuntimeFault, RemoteException 
	{
		return getVimService().addServiceConsoleVirtualNic(getMOR(), portgroup, spec);
	}
	
	public String addVirtualNic(String portgroup, HostVirtualNicSpec nicSpec) throws HostConfigFault, AlreadyExists, RuntimeFault, RemoteException 
	{
		return getVimService().addVirtualNic(getMOR(), portgroup, nicSpec);
	}
	
	public void addVirtualSwitch(String vswitchName, HostVirtualSwitchSpec spec) throws HostConfigFault, ResourceInUse, AlreadyExists, RuntimeFault, RemoteException 
	{
		getVimService().addVirtualSwitch(getMOR(), vswitchName, spec);
	}
	
	public PhysicalNicHintInfo[] queryNetworkHint(String[] devices) throws HostConfigFault, NotFound, RuntimeFault, RemoteException 
	{
		return getVimService().queryNetworkHint(getMOR(), devices);
	}
	
	public void refreshNetworkSystem() throws RuntimeFault, RemoteException 
	{
		getVimService().refreshNetworkSystem(getMOR());
	}
	
	public void removePortGroup(String pgName) throws HostConfigFault, ResourceInUse, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().removePortGroup(getMOR(), pgName);
	}
	
	public void removeServiceConsoleVirtualNic(String device) throws HostConfigFault, ResourceInUse, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().removeServiceConsoleVirtualNic(getMOR(), device);
	}
	
	public void removeVirtualNic(String device) throws HostConfigFault, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().removeVirtualNic(getMOR(), device);
	}
	
	public void removeVirtualSwitch(String vswitchName) throws HostConfigFault, ResourceInUse, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().removeVirtualSwitch(getMOR(), vswitchName);
	}
	
	public void restartServiceConsoleVirtualNic(String device) throws HostConfigFault, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().restartServiceConsoleVirtualNic(getMOR(), device);
	}
	
	public void updateConsoleIpRouteConfig(HostIpRouteConfig config) throws HostConfigFault, RuntimeFault, RemoteException 
	{
		getVimService().updateConsoleIpRouteConfig(getMOR(), config);
	}
	
	public void updateDnsConfig(HostDnsConfig config) throws HostConfigFault, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().updateDnsConfig(getMOR(), config);
	}
	
	public void updateIpRouteConfig(HostIpRouteConfig config) throws HostConfigFault, RuntimeFault, RemoteException 
	{
		getVimService().updateIpRouteConfig(getMOR(), config);
	}
	
  public void updateIpRouteTableConfig(HostIpRouteTableConfig config) throws HostConfigFault, RuntimeFault, RemoteException 
  {
    getVimService().updateIpRouteTableConfig(getMOR(), config);
  }
	
	public void updateNetworkConfig(HostNetworkConfig config, String changeMode) throws HostConfigFault, AlreadyExists, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().updateNetworkConfig(getMOR(), config, changeMode);
	}
	
	public void updatePhysicalNicLinkSpeed(String device, PhysicalNicLinkInfo linkSpeed) throws HostConfigFault, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().updatePhysicalNicLinkSpeed(getMOR(), device, linkSpeed);
	}
	
	public void updatePortGroup(String pgName, HostPortGroupSpec portgrp) throws HostConfigFault, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().updatePortGroup(getMOR(), pgName, portgrp);
	}
	
	public void updateServiceConsoleVirtualNic(String device, HostVirtualNicSpec nic) throws HostConfigFault, ResourceInUse, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().updateServiceConsoleVirtualNic(getMOR(), device, nic);
	}
	
	public void updateVirtualNic(String device, HostVirtualNicSpec nic) throws HostConfigFault, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().updateVirtualNic(getMOR(), device, nic);
	}
	
	public void updateVirtualSwitch(String vswitchName, HostVirtualSwitchSpec spec) throws HostConfigFault, ResourceInUse, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().updateVirtualSwitch(getMOR(), vswitchName, spec);
	}
	
}
