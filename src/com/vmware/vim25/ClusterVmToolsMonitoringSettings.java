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

public class ClusterVmToolsMonitoringSettings extends DynamicData
{
  public Boolean enabled;
  public Boolean clusterSettings;
  public Integer failureInterval;
  public Integer minUpTime;
  public Integer maxFailures;
  public Integer maxFailureWindow;

  public Boolean getEnabled()
  {
    return this.enabled;
  }

  public Boolean getClusterSettings()
  {
    return this.clusterSettings;
  }

  public Integer getFailureInterval()
  {
    return this.failureInterval;
  }

  public Integer getMinUpTime()
  {
    return this.minUpTime;
  }

  public Integer getMaxFailures()
  {
    return this.maxFailures;
  }

  public Integer getMaxFailureWindow()
  {
    return this.maxFailureWindow;
  }

  public void setEnabled(Boolean enabled)
  {
    this.enabled=enabled;
  }

  public void setClusterSettings(Boolean clusterSettings)
  {
    this.clusterSettings=clusterSettings;
  }

  public void setFailureInterval(Integer failureInterval)
  {
    this.failureInterval=failureInterval;
  }

  public void setMinUpTime(Integer minUpTime)
  {
    this.minUpTime=minUpTime;
  }

  public void setMaxFailures(Integer maxFailures)
  {
    this.maxFailures=maxFailures;
  }

  public void setMaxFailureWindow(Integer maxFailureWindow)
  {
    this.maxFailureWindow=maxFailureWindow;
  }
}