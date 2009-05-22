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

public class VAppProductInfo extends DynamicData
{
  public int key;
  public String classId;
  public String instanceId;
  public String name;
  public String vendor;
  public String version;
  public String fullVersion;
  public String vendorUrl;
  public String productUrl;
  public String appUrl;

  public int getKey()
  {
    return this.key;
  }

  public String getClassId()
  {
    return this.classId;
  }

  public String getInstanceId()
  {
    return this.instanceId;
  }

  public String getName()
  {
    return this.name;
  }

  public String getVendor()
  {
    return this.vendor;
  }

  public String getVersion()
  {
    return this.version;
  }

  public String getFullVersion()
  {
    return this.fullVersion;
  }

  public String getVendorUrl()
  {
    return this.vendorUrl;
  }

  public String getProductUrl()
  {
    return this.productUrl;
  }

  public String getAppUrl()
  {
    return this.appUrl;
  }

  public void setKey(int key)
  {
    this.key=key;
  }

  public void setClassId(String classId)
  {
    this.classId=classId;
  }

  public void setInstanceId(String instanceId)
  {
    this.instanceId=instanceId;
  }

  public void setName(String name)
  {
    this.name=name;
  }

  public void setVendor(String vendor)
  {
    this.vendor=vendor;
  }

  public void setVersion(String version)
  {
    this.version=version;
  }

  public void setFullVersion(String fullVersion)
  {
    this.fullVersion=fullVersion;
  }

  public void setVendorUrl(String vendorUrl)
  {
    this.vendorUrl=vendorUrl;
  }

  public void setProductUrl(String productUrl)
  {
    this.productUrl=productUrl;
  }

  public void setAppUrl(String appUrl)
  {
    this.appUrl=appUrl;
  }
}