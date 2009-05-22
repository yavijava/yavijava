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

public class ClusterDasConfigInfo extends DynamicData
{
  public Boolean enabled;
  public String vmMonitoring;
  public String hostMonitoring;
  public Integer failoverLevel;
  public ClusterDasAdmissionControlPolicy admissionControlPolicy;
  public Boolean admissionControlEnabled;
  public ClusterDasVmSettings defaultVmSettings;
  public OptionValue[] option;

  public Boolean getEnabled()
  {
    return this.enabled;
  }

  public String getVmMonitoring()
  {
    return this.vmMonitoring;
  }

  public String getHostMonitoring()
  {
    return this.hostMonitoring;
  }

  public Integer getFailoverLevel()
  {
    return this.failoverLevel;
  }

  public ClusterDasAdmissionControlPolicy getAdmissionControlPolicy()
  {
    return this.admissionControlPolicy;
  }

  public Boolean getAdmissionControlEnabled()
  {
    return this.admissionControlEnabled;
  }

  public ClusterDasVmSettings getDefaultVmSettings()
  {
    return this.defaultVmSettings;
  }

  public OptionValue[] getOption()
  {
    return this.option;
  }

  public void setEnabled(Boolean enabled)
  {
    this.enabled=enabled;
  }

  public void setVmMonitoring(String vmMonitoring)
  {
    this.vmMonitoring=vmMonitoring;
  }

  public void setHostMonitoring(String hostMonitoring)
  {
    this.hostMonitoring=hostMonitoring;
  }

  public void setFailoverLevel(Integer failoverLevel)
  {
    this.failoverLevel=failoverLevel;
  }

  public void setAdmissionControlPolicy(ClusterDasAdmissionControlPolicy admissionControlPolicy)
  {
    this.admissionControlPolicy=admissionControlPolicy;
  }

  public void setAdmissionControlEnabled(Boolean admissionControlEnabled)
  {
    this.admissionControlEnabled=admissionControlEnabled;
  }

  public void setDefaultVmSettings(ClusterDasVmSettings defaultVmSettings)
  {
    this.defaultVmSettings=defaultVmSettings;
  }

  public void setOption(OptionValue[] option)
  {
    this.option=option;
  }
}