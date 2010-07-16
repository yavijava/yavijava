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

public class HostConfigSummary extends DynamicData
{
  public String name;
  public int port;
  public String sslThumbprint;
  public AboutInfo product;
  public boolean vmotionEnabled;
  public Boolean faultToleranceEnabled;
  public HostFeatureVersionInfo[] featureVersion;

  public String getName()
  {
    return this.name;
  }

  public int getPort()
  {
    return this.port;
  }

  public String getSslThumbprint()
  {
    return this.sslThumbprint;
  }

  public AboutInfo getProduct()
  {
    return this.product;
  }

  public boolean isVmotionEnabled()
  {
    return this.vmotionEnabled;
  }

  public Boolean getFaultToleranceEnabled()
  {
    return this.faultToleranceEnabled;
  }

  public HostFeatureVersionInfo[] getFeatureVersion()
  {
    return this.featureVersion;
  }

  public void setName(String name)
  {
    this.name=name;
  }

  public void setPort(int port)
  {
    this.port=port;
  }

  public void setSslThumbprint(String sslThumbprint)
  {
    this.sslThumbprint=sslThumbprint;
  }

  public void setProduct(AboutInfo product)
  {
    this.product=product;
  }

  public void setVmotionEnabled(boolean vmotionEnabled)
  {
    this.vmotionEnabled=vmotionEnabled;
  }

  public void setFaultToleranceEnabled(Boolean faultToleranceEnabled)
  {
    this.faultToleranceEnabled=faultToleranceEnabled;
  }

  public void setFeatureVersion(HostFeatureVersionInfo[] featureVersion)
  {
    this.featureVersion=featureVersion;
  }
}