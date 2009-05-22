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

public class HostInternetScsiHbaStaticTarget extends DynamicData
{
  public String address;
  public Integer port;
  public String iScsiName;
  public HostInternetScsiHbaAuthenticationProperties authenticationProperties;
  public HostInternetScsiHbaDigestProperties digestProperties;
  public OptionDef[] supportedAdvancedOptions;
  public HostInternetScsiHbaParamValue[] advancedOptions;
  public String parent;

  public String getAddress()
  {
    return this.address;
  }

  public Integer getPort()
  {
    return this.port;
  }

  public String getIScsiName()
  {
    return this.iScsiName;
  }

  public HostInternetScsiHbaAuthenticationProperties getAuthenticationProperties()
  {
    return this.authenticationProperties;
  }

  public HostInternetScsiHbaDigestProperties getDigestProperties()
  {
    return this.digestProperties;
  }

  public OptionDef[] getSupportedAdvancedOptions()
  {
    return this.supportedAdvancedOptions;
  }

  public HostInternetScsiHbaParamValue[] getAdvancedOptions()
  {
    return this.advancedOptions;
  }

  public String getParent()
  {
    return this.parent;
  }

  public void setAddress(String address)
  {
    this.address=address;
  }

  public void setPort(Integer port)
  {
    this.port=port;
  }

  public void setIScsiName(String iScsiName)
  {
    this.iScsiName=iScsiName;
  }

  public void setAuthenticationProperties(HostInternetScsiHbaAuthenticationProperties authenticationProperties)
  {
    this.authenticationProperties=authenticationProperties;
  }

  public void setDigestProperties(HostInternetScsiHbaDigestProperties digestProperties)
  {
    this.digestProperties=digestProperties;
  }

  public void setSupportedAdvancedOptions(OptionDef[] supportedAdvancedOptions)
  {
    this.supportedAdvancedOptions=supportedAdvancedOptions;
  }

  public void setAdvancedOptions(HostInternetScsiHbaParamValue[] advancedOptions)
  {
    this.advancedOptions=advancedOptions;
  }

  public void setParent(String parent)
  {
    this.parent=parent;
  }
}