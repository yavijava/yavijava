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

public class OvfParseDescriptorResult extends DynamicData
{
  public String[] eula;
  public OvfNetworkInfo[] network;
  public String[] ipAllocationScheme;
  public String[] ipProtocols;
  public VAppPropertyInfo[] property;
  public VAppProductInfo productInfo;
  public String annotation;
  public Long approximateDownloadSize;
  public Long approximateFlatDeploymentSize;
  public Long approximateSparseDeploymentSize;
  public String defaultEntityName;
  public boolean virtualApp;
  public OvfDeploymentOption[] deploymentOption;
  public String defaultDeploymentOption;
  public LocalizedMethodFault[] error;
  public LocalizedMethodFault[] warning;

  public String[] getEula()
  {
    return this.eula;
  }

  public OvfNetworkInfo[] getNetwork()
  {
    return this.network;
  }

  public String[] getIpAllocationScheme()
  {
    return this.ipAllocationScheme;
  }

  public String[] getIpProtocols()
  {
    return this.ipProtocols;
  }

  public VAppPropertyInfo[] getProperty()
  {
    return this.property;
  }

  public VAppProductInfo getProductInfo()
  {
    return this.productInfo;
  }

  public String getAnnotation()
  {
    return this.annotation;
  }

  public Long getApproximateDownloadSize()
  {
    return this.approximateDownloadSize;
  }

  public Long getApproximateFlatDeploymentSize()
  {
    return this.approximateFlatDeploymentSize;
  }

  public Long getApproximateSparseDeploymentSize()
  {
    return this.approximateSparseDeploymentSize;
  }

  public String getDefaultEntityName()
  {
    return this.defaultEntityName;
  }

  public boolean isVirtualApp()
  {
    return this.virtualApp;
  }

  public OvfDeploymentOption[] getDeploymentOption()
  {
    return this.deploymentOption;
  }

  public String getDefaultDeploymentOption()
  {
    return this.defaultDeploymentOption;
  }

  public LocalizedMethodFault[] getError()
  {
    return this.error;
  }

  public LocalizedMethodFault[] getWarning()
  {
    return this.warning;
  }

  public void setEula(String[] eula)
  {
    this.eula=eula;
  }

  public void setNetwork(OvfNetworkInfo[] network)
  {
    this.network=network;
  }

  public void setIpAllocationScheme(String[] ipAllocationScheme)
  {
    this.ipAllocationScheme=ipAllocationScheme;
  }

  public void setIpProtocols(String[] ipProtocols)
  {
    this.ipProtocols=ipProtocols;
  }

  public void setProperty(VAppPropertyInfo[] property)
  {
    this.property=property;
  }

  public void setProductInfo(VAppProductInfo productInfo)
  {
    this.productInfo=productInfo;
  }

  public void setAnnotation(String annotation)
  {
    this.annotation=annotation;
  }

  public void setApproximateDownloadSize(Long approximateDownloadSize)
  {
    this.approximateDownloadSize=approximateDownloadSize;
  }

  public void setApproximateFlatDeploymentSize(Long approximateFlatDeploymentSize)
  {
    this.approximateFlatDeploymentSize=approximateFlatDeploymentSize;
  }

  public void setApproximateSparseDeploymentSize(Long approximateSparseDeploymentSize)
  {
    this.approximateSparseDeploymentSize=approximateSparseDeploymentSize;
  }

  public void setDefaultEntityName(String defaultEntityName)
  {
    this.defaultEntityName=defaultEntityName;
  }

  public void setVirtualApp(boolean virtualApp)
  {
    this.virtualApp=virtualApp;
  }

  public void setDeploymentOption(OvfDeploymentOption[] deploymentOption)
  {
    this.deploymentOption=deploymentOption;
  }

  public void setDefaultDeploymentOption(String defaultDeploymentOption)
  {
    this.defaultDeploymentOption=defaultDeploymentOption;
  }

  public void setError(LocalizedMethodFault[] error)
  {
    this.error=error;
  }

  public void setWarning(LocalizedMethodFault[] warning)
  {
    this.warning=warning;
  }
}