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

public class AboutInfo extends DynamicData
{
  public String name;
  public String fullName;
  public String vendor;
  public String version;
  public String build;
  public String localeVersion;
  public String localeBuild;
  public String osType;
  public String productLineId;
  public String apiType;
  public String apiVersion;

  public String getName()
  {
    return this.name;
  }

  public String getFullName()
  {
    return this.fullName;
  }

  public String getVendor()
  {
    return this.vendor;
  }

  public String getVersion()
  {
    return this.version;
  }

  public String getBuild()
  {
    return this.build;
  }

  public String getLocaleVersion()
  {
    return this.localeVersion;
  }

  public String getLocaleBuild()
  {
    return this.localeBuild;
  }

  public String getOsType()
  {
    return this.osType;
  }

  public String getProductLineId()
  {
    return this.productLineId;
  }

  public String getApiType()
  {
    return this.apiType;
  }

  public String getApiVersion()
  {
    return this.apiVersion;
  }

  public void setName(String name)
  {
    this.name=name;
  }

  public void setFullName(String fullName)
  {
    this.fullName=fullName;
  }

  public void setVendor(String vendor)
  {
    this.vendor=vendor;
  }

  public void setVersion(String version)
  {
    this.version=version;
  }

  public void setBuild(String build)
  {
    this.build=build;
  }

  public void setLocaleVersion(String localeVersion)
  {
    this.localeVersion=localeVersion;
  }

  public void setLocaleBuild(String localeBuild)
  {
    this.localeBuild=localeBuild;
  }

  public void setOsType(String osType)
  {
    this.osType=osType;
  }

  public void setProductLineId(String productLineId)
  {
    this.productLineId=productLineId;
  }

  public void setApiType(String apiType)
  {
    this.apiType=apiType;
  }

  public void setApiVersion(String apiVersion)
  {
    this.apiVersion=apiVersion;
  }
}