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

public class HostInternetScsiHba extends HostHostBusAdapter
{
  public boolean isSoftwareBased;
  public HostInternetScsiHbaDiscoveryCapabilities discoveryCapabilities;
  public HostInternetScsiHbaDiscoveryProperties discoveryProperties;
  public HostInternetScsiHbaAuthenticationCapabilities authenticationCapabilities;
  public HostInternetScsiHbaAuthenticationProperties authenticationProperties;
  public HostInternetScsiHbaIPCapabilities ipCapabilities;
  public HostInternetScsiHbaIPProperties ipProperties;
  public String iScsiName;
  public String iScsiAlias;
  public HostInternetScsiHbaSendTarget[] configuredSendTarget;
  public HostInternetScsiHbaStaticTarget[] configuredStaticTarget;
  public Integer maxSpeedMb;
  public Integer currentSpeedMb;

  public boolean isIsSoftwareBased()
  {
    return this.isSoftwareBased;
  }

  public HostInternetScsiHbaDiscoveryCapabilities getDiscoveryCapabilities()
  {
    return this.discoveryCapabilities;
  }

  public HostInternetScsiHbaDiscoveryProperties getDiscoveryProperties()
  {
    return this.discoveryProperties;
  }

  public HostInternetScsiHbaAuthenticationCapabilities getAuthenticationCapabilities()
  {
    return this.authenticationCapabilities;
  }

  public HostInternetScsiHbaAuthenticationProperties getAuthenticationProperties()
  {
    return this.authenticationProperties;
  }

  public HostInternetScsiHbaIPCapabilities getIpCapabilities()
  {
    return this.ipCapabilities;
  }

  public HostInternetScsiHbaIPProperties getIpProperties()
  {
    return this.ipProperties;
  }

  public String getIScsiName()
  {
    return this.iScsiName;
  }

  public String getIScsiAlias()
  {
    return this.iScsiAlias;
  }

  public HostInternetScsiHbaSendTarget[] getConfiguredSendTarget()
  {
    return this.configuredSendTarget;
  }

  public HostInternetScsiHbaStaticTarget[] getConfiguredStaticTarget()
  {
    return this.configuredStaticTarget;
  }

  public Integer getMaxSpeedMb()
  {
    return this.maxSpeedMb;
  }

  public Integer getCurrentSpeedMb()
  {
    return this.currentSpeedMb;
  }

  public void setIsSoftwareBased(boolean isSoftwareBased)
  {
    this.isSoftwareBased=isSoftwareBased;
  }

  public void setDiscoveryCapabilities(HostInternetScsiHbaDiscoveryCapabilities discoveryCapabilities)
  {
    this.discoveryCapabilities=discoveryCapabilities;
  }

  public void setDiscoveryProperties(HostInternetScsiHbaDiscoveryProperties discoveryProperties)
  {
    this.discoveryProperties=discoveryProperties;
  }

  public void setAuthenticationCapabilities(HostInternetScsiHbaAuthenticationCapabilities authenticationCapabilities)
  {
    this.authenticationCapabilities=authenticationCapabilities;
  }

  public void setAuthenticationProperties(HostInternetScsiHbaAuthenticationProperties authenticationProperties)
  {
    this.authenticationProperties=authenticationProperties;
  }

  public void setIpCapabilities(HostInternetScsiHbaIPCapabilities ipCapabilities)
  {
    this.ipCapabilities=ipCapabilities;
  }

  public void setIpProperties(HostInternetScsiHbaIPProperties ipProperties)
  {
    this.ipProperties=ipProperties;
  }

  public void setIScsiName(String iScsiName)
  {
    this.iScsiName=iScsiName;
  }

  public void setIScsiAlias(String iScsiAlias)
  {
    this.iScsiAlias=iScsiAlias;
  }

  public void setConfiguredSendTarget(HostInternetScsiHbaSendTarget[] configuredSendTarget)
  {
    this.configuredSendTarget=configuredSendTarget;
  }

  public void setConfiguredStaticTarget(HostInternetScsiHbaStaticTarget[] configuredStaticTarget)
  {
    this.configuredStaticTarget=configuredStaticTarget;
  }

  public void setMaxSpeedMb(Integer maxSpeedMb)
  {
    this.maxSpeedMb=maxSpeedMb;
  }

  public void setCurrentSpeedMb(Integer currentSpeedMb)
  {
    this.currentSpeedMb=currentSpeedMb;
  }
}