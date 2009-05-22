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

public class NetworkProfile extends ApplyProfile
{
  public VirtualSwitchProfile[] vswitch;
  public VmPortGroupProfile[] vmPortGroup;
  public HostPortGroupProfile[] hostPortGroup;
  public ServiceConsolePortGroupProfile[] serviceConsolePortGroup;
  public NetworkProfileDnsConfigProfile dnsConfig;
  public IpRouteProfile ipRouteConfig;
  public IpRouteProfile consoleIpRouteConfig;
  public PhysicalNicProfile[] pnic;
  public DvsProfile[] dvswitch;
  public DvsServiceConsoleVNicProfile[] dvsServiceConsoleNic;
  public DvsHostVNicProfile[] dvsHostNic;

  public VirtualSwitchProfile[] getVswitch()
  {
    return this.vswitch;
  }

  public VmPortGroupProfile[] getVmPortGroup()
  {
    return this.vmPortGroup;
  }

  public HostPortGroupProfile[] getHostPortGroup()
  {
    return this.hostPortGroup;
  }

  public ServiceConsolePortGroupProfile[] getServiceConsolePortGroup()
  {
    return this.serviceConsolePortGroup;
  }

  public NetworkProfileDnsConfigProfile getDnsConfig()
  {
    return this.dnsConfig;
  }

  public IpRouteProfile getIpRouteConfig()
  {
    return this.ipRouteConfig;
  }

  public IpRouteProfile getConsoleIpRouteConfig()
  {
    return this.consoleIpRouteConfig;
  }

  public PhysicalNicProfile[] getPnic()
  {
    return this.pnic;
  }

  public DvsProfile[] getDvswitch()
  {
    return this.dvswitch;
  }

  public DvsServiceConsoleVNicProfile[] getDvsServiceConsoleNic()
  {
    return this.dvsServiceConsoleNic;
  }

  public DvsHostVNicProfile[] getDvsHostNic()
  {
    return this.dvsHostNic;
  }

  public void setVswitch(VirtualSwitchProfile[] vswitch)
  {
    this.vswitch=vswitch;
  }

  public void setVmPortGroup(VmPortGroupProfile[] vmPortGroup)
  {
    this.vmPortGroup=vmPortGroup;
  }

  public void setHostPortGroup(HostPortGroupProfile[] hostPortGroup)
  {
    this.hostPortGroup=hostPortGroup;
  }

  public void setServiceConsolePortGroup(ServiceConsolePortGroupProfile[] serviceConsolePortGroup)
  {
    this.serviceConsolePortGroup=serviceConsolePortGroup;
  }

  public void setDnsConfig(NetworkProfileDnsConfigProfile dnsConfig)
  {
    this.dnsConfig=dnsConfig;
  }

  public void setIpRouteConfig(IpRouteProfile ipRouteConfig)
  {
    this.ipRouteConfig=ipRouteConfig;
  }

  public void setConsoleIpRouteConfig(IpRouteProfile consoleIpRouteConfig)
  {
    this.consoleIpRouteConfig=consoleIpRouteConfig;
  }

  public void setPnic(PhysicalNicProfile[] pnic)
  {
    this.pnic=pnic;
  }

  public void setDvswitch(DvsProfile[] dvswitch)
  {
    this.dvswitch=dvswitch;
  }

  public void setDvsServiceConsoleNic(DvsServiceConsoleVNicProfile[] dvsServiceConsoleNic)
  {
    this.dvsServiceConsoleNic=dvsServiceConsoleNic;
  }

  public void setDvsHostNic(DvsHostVNicProfile[] dvsHostNic)
  {
    this.dvsHostNic=dvsHostNic;
  }
}