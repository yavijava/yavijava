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

public class HostNetworkInfo extends DynamicData
{
  public HostVirtualSwitch[] vswitch;
  public HostProxySwitch[] proxySwitch;
  public HostPortGroup[] portgroup;
  public PhysicalNic[] pnic;
  public HostVirtualNic[] vnic;
  public HostVirtualNic[] consoleVnic;
  public HostDnsConfig dnsConfig;
  public HostIpRouteConfig ipRouteConfig;
  public HostIpRouteConfig consoleIpRouteConfig;
  public HostIpRouteTableInfo routeTableInfo;
  public HostDhcpService[] dhcp;
  public HostNatService[] nat;
  public Boolean ipV6Enabled;

  public HostVirtualSwitch[] getVswitch()
  {
    return this.vswitch;
  }

  public HostProxySwitch[] getProxySwitch()
  {
    return this.proxySwitch;
  }

  public HostPortGroup[] getPortgroup()
  {
    return this.portgroup;
  }

  public PhysicalNic[] getPnic()
  {
    return this.pnic;
  }

  public HostVirtualNic[] getVnic()
  {
    return this.vnic;
  }

  public HostVirtualNic[] getConsoleVnic()
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

  public HostIpRouteTableInfo getRouteTableInfo()
  {
    return this.routeTableInfo;
  }

  public HostDhcpService[] getDhcp()
  {
    return this.dhcp;
  }

  public HostNatService[] getNat()
  {
    return this.nat;
  }

  public Boolean getIpV6Enabled()
  {
    return this.ipV6Enabled;
  }

  public void setVswitch(HostVirtualSwitch[] vswitch)
  {
    this.vswitch=vswitch;
  }

  public void setProxySwitch(HostProxySwitch[] proxySwitch)
  {
    this.proxySwitch=proxySwitch;
  }

  public void setPortgroup(HostPortGroup[] portgroup)
  {
    this.portgroup=portgroup;
  }

  public void setPnic(PhysicalNic[] pnic)
  {
    this.pnic=pnic;
  }

  public void setVnic(HostVirtualNic[] vnic)
  {
    this.vnic=vnic;
  }

  public void setConsoleVnic(HostVirtualNic[] consoleVnic)
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

  public void setRouteTableInfo(HostIpRouteTableInfo routeTableInfo)
  {
    this.routeTableInfo=routeTableInfo;
  }

  public void setDhcp(HostDhcpService[] dhcp)
  {
    this.dhcp=dhcp;
  }

  public void setNat(HostNatService[] nat)
  {
    this.nat=nat;
  }

  public void setIpV6Enabled(Boolean ipV6Enabled)
  {
    this.ipV6Enabled=ipV6Enabled;
  }
}