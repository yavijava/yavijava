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

public class HostNetCapabilities extends DynamicData
{
  public boolean canSetPhysicalNicLinkSpeed;
  public boolean supportsNicTeaming;
  public String[] nicTeamingPolicy;
  public boolean supportsVlan;
  public boolean usesServiceConsoleNic;
  public boolean supportsNetworkHints;
  public Integer maxPortGroupsPerVswitch;
  public boolean vswitchConfigSupported;
  public boolean vnicConfigSupported;
  public boolean ipRouteConfigSupported;
  public boolean dnsConfigSupported;
  public boolean dhcpOnVnicSupported;

  public boolean isCanSetPhysicalNicLinkSpeed()
  {
    return this.canSetPhysicalNicLinkSpeed;
  }

  public boolean isSupportsNicTeaming()
  {
    return this.supportsNicTeaming;
  }

  public String[] getNicTeamingPolicy()
  {
    return this.nicTeamingPolicy;
  }

  public boolean isSupportsVlan()
  {
    return this.supportsVlan;
  }

  public boolean isUsesServiceConsoleNic()
  {
    return this.usesServiceConsoleNic;
  }

  public boolean isSupportsNetworkHints()
  {
    return this.supportsNetworkHints;
  }

  public Integer getMaxPortGroupsPerVswitch()
  {
    return this.maxPortGroupsPerVswitch;
  }

  public boolean isVswitchConfigSupported()
  {
    return this.vswitchConfigSupported;
  }

  public boolean isVnicConfigSupported()
  {
    return this.vnicConfigSupported;
  }

  public boolean isIpRouteConfigSupported()
  {
    return this.ipRouteConfigSupported;
  }

  public boolean isDnsConfigSupported()
  {
    return this.dnsConfigSupported;
  }

  public boolean isDhcpOnVnicSupported()
  {
    return this.dhcpOnVnicSupported;
  }

  public void setCanSetPhysicalNicLinkSpeed(boolean canSetPhysicalNicLinkSpeed)
  {
    this.canSetPhysicalNicLinkSpeed=canSetPhysicalNicLinkSpeed;
  }

  public void setSupportsNicTeaming(boolean supportsNicTeaming)
  {
    this.supportsNicTeaming=supportsNicTeaming;
  }

  public void setNicTeamingPolicy(String[] nicTeamingPolicy)
  {
    this.nicTeamingPolicy=nicTeamingPolicy;
  }

  public void setSupportsVlan(boolean supportsVlan)
  {
    this.supportsVlan=supportsVlan;
  }

  public void setUsesServiceConsoleNic(boolean usesServiceConsoleNic)
  {
    this.usesServiceConsoleNic=usesServiceConsoleNic;
  }

  public void setSupportsNetworkHints(boolean supportsNetworkHints)
  {
    this.supportsNetworkHints=supportsNetworkHints;
  }

  public void setMaxPortGroupsPerVswitch(Integer maxPortGroupsPerVswitch)
  {
    this.maxPortGroupsPerVswitch=maxPortGroupsPerVswitch;
  }

  public void setVswitchConfigSupported(boolean vswitchConfigSupported)
  {
    this.vswitchConfigSupported=vswitchConfigSupported;
  }

  public void setVnicConfigSupported(boolean vnicConfigSupported)
  {
    this.vnicConfigSupported=vnicConfigSupported;
  }

  public void setIpRouteConfigSupported(boolean ipRouteConfigSupported)
  {
    this.ipRouteConfigSupported=ipRouteConfigSupported;
  }

  public void setDnsConfigSupported(boolean dnsConfigSupported)
  {
    this.dnsConfigSupported=dnsConfigSupported;
  }

  public void setDhcpOnVnicSupported(boolean dhcpOnVnicSupported)
  {
    this.dhcpOnVnicSupported=dhcpOnVnicSupported;
  }
}