/*================================================================================
Copyright (c) 2009 VMware, Inc. All Rights Reserved.

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

package com.vmware.vim25;

/**
@author Steve Jin (sjin@vmware.com)
*/

public class HostNetworkConfig extends DynamicData
{
  public HostVirtualSwitchConfig[] vswitch;
  public HostProxySwitchConfig[] proxySwitch;
  public HostPortGroupConfig[] portgroup;
  public PhysicalNicConfig[] pnic;
  public HostVirtualNicConfig[] vnic;
  public HostVirtualNicConfig[] consoleVnic;
  public HostDnsConfig dnsConfig;
  public HostIpRouteConfig ipRouteConfig;
  public HostIpRouteConfig consoleIpRouteConfig;
  public HostIpRouteTableConfig routeTableConfig;
  public HostDhcpServiceConfig[] dhcp;
  public HostNatServiceConfig[] nat;
  public Boolean ipV6Enabled;

  public HostVirtualSwitchConfig[] getVswitch()
  {
    return this.vswitch;
  }

  public HostProxySwitchConfig[] getProxySwitch()
  {
    return this.proxySwitch;
  }

  public HostPortGroupConfig[] getPortgroup()
  {
    return this.portgroup;
  }

  public PhysicalNicConfig[] getPnic()
  {
    return this.pnic;
  }

  public HostVirtualNicConfig[] getVnic()
  {
    return this.vnic;
  }

  public HostVirtualNicConfig[] getConsoleVnic()
  {
    return this.consoleVnic;
  }

  public HostDnsConfig getDnsConfig()
  {
    return this.dnsConfig;
  }

  public HostIpRouteConfig getIpRouteConfig()
  {
    return this.ipRouteConfig;
  }

  public HostIpRouteConfig getConsoleIpRouteConfig()
  {
    return this.consoleIpRouteConfig;
  }

  public HostIpRouteTableConfig getRouteTableConfig()
  {
    return this.routeTableConfig;
  }

  public HostDhcpServiceConfig[] getDhcp()
  {
    return this.dhcp;
  }

  public HostNatServiceConfig[] getNat()
  {
    return this.nat;
  }

  public Boolean getIpV6Enabled()
  {
    return this.ipV6Enabled;
  }

  public void setVswitch(HostVirtualSwitchConfig[] vswitch)
  {
    this.vswitch=vswitch;
  }

  public void setProxySwitch(HostProxySwitchConfig[] proxySwitch)
  {
    this.proxySwitch=proxySwitch;
  }

  public void setPortgroup(HostPortGroupConfig[] portgroup)
  {
    this.portgroup=portgroup;
  }

  public void setPnic(PhysicalNicConfig[] pnic)
  {
    this.pnic=pnic;
  }

  public void setVnic(HostVirtualNicConfig[] vnic)
  {
    this.vnic=vnic;
  }

  public void setConsoleVnic(HostVirtualNicConfig[] consoleVnic)
  {
    this.consoleVnic=consoleVnic;
  }

  public void setDnsConfig(HostDnsConfig dnsConfig)
  {
    this.dnsConfig=dnsConfig;
  }

  public void setIpRouteConfig(HostIpRouteConfig ipRouteConfig)
  {
    this.ipRouteConfig=ipRouteConfig;
  }

  public void setConsoleIpRouteConfig(HostIpRouteConfig consoleIpRouteConfig)
  {
    this.consoleIpRouteConfig=consoleIpRouteConfig;
  }

  public void setRouteTableConfig(HostIpRouteTableConfig routeTableConfig)
  {
    this.routeTableConfig=routeTableConfig;
  }

  public void setDhcp(HostDhcpServiceConfig[] dhcp)
  {
    this.dhcp=dhcp;
  }

  public void setNat(HostNatServiceConfig[] nat)
  {
    this.nat=nat;
  }

  public void setIpV6Enabled(Boolean ipV6Enabled)
  {
    this.ipV6Enabled=ipV6Enabled;
  }
}