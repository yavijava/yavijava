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

public class ToolsConfigInfo extends DynamicData
{
  public Integer toolsVersion;
  public Boolean afterPowerOn;
  public Boolean afterResume;
  public Boolean beforeGuestStandby;
  public Boolean beforeGuestShutdown;
  public Boolean beforeGuestReboot;
  public String toolsUpgradePolicy;
  public String pendingCustomization;
  public Boolean syncTimeWithHost;

  public Integer getToolsVersion()
  {
    return this.toolsVersion;
  }

  public Boolean getAfterPowerOn()
  {
    return this.afterPowerOn;
  }

  public Boolean getAfterResume()
  {
    return this.afterResume;
  }

  public Boolean getBeforeGuestStandby()
  {
    return this.beforeGuestStandby;
  }

  public Boolean getBeforeGuestShutdown()
  {
    return this.beforeGuestShutdown;
  }

  public Boolean getBeforeGuestReboot()
  {
    return this.beforeGuestReboot;
  }

  public String getToolsUpgradePolicy()
  {
    return this.toolsUpgradePolicy;
  }

  public String getPendingCustomization()
  {
    return this.pendingCustomization;
  }

  public Boolean getSyncTimeWithHost()
  {
    return this.syncTimeWithHost;
  }

  public void setToolsVersion(Integer toolsVersion)
  {
    this.toolsVersion=toolsVersion;
  }

  public void setAfterPowerOn(Boolean afterPowerOn)
  {
    this.afterPowerOn=afterPowerOn;
  }

  public void setAfterResume(Boolean afterResume)
  {
    this.afterResume=afterResume;
  }

  public void setBeforeGuestStandby(Boolean beforeGuestStandby)
  {
    this.beforeGuestStandby=beforeGuestStandby;
  }

  public void setBeforeGuestShutdown(Boolean beforeGuestShutdown)
  {
    this.beforeGuestShutdown=beforeGuestShutdown;
  }

  public void setBeforeGuestReboot(Boolean beforeGuestReboot)
  {
    this.beforeGuestReboot=beforeGuestReboot;
  }

  public void setToolsUpgradePolicy(String toolsUpgradePolicy)
  {
    this.toolsUpgradePolicy=toolsUpgradePolicy;
  }

  public void setPendingCustomization(String pendingCustomization)
  {
    this.pendingCustomization=pendingCustomization;
  }

  public void setSyncTimeWithHost(Boolean syncTimeWithHost)
  {
    this.syncTimeWithHost=syncTimeWithHost;
  }
}