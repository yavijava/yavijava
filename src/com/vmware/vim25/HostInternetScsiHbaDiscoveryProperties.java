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

public class HostInternetScsiHbaDiscoveryProperties extends DynamicData
{
  public boolean iSnsDiscoveryEnabled;
  public String iSnsDiscoveryMethod;
  public String iSnsHost;
  public boolean slpDiscoveryEnabled;
  public String slpDiscoveryMethod;
  public String slpHost;
  public boolean staticTargetDiscoveryEnabled;
  public boolean sendTargetsDiscoveryEnabled;

  public boolean isISnsDiscoveryEnabled()
  {
    return this.iSnsDiscoveryEnabled;
  }

  public String getISnsDiscoveryMethod()
  {
    return this.iSnsDiscoveryMethod;
  }

  public String getISnsHost()
  {
    return this.iSnsHost;
  }

  public boolean isSlpDiscoveryEnabled()
  {
    return this.slpDiscoveryEnabled;
  }

  public String getSlpDiscoveryMethod()
  {
    return this.slpDiscoveryMethod;
  }

  public String getSlpHost()
  {
    return this.slpHost;
  }

  public boolean isStaticTargetDiscoveryEnabled()
  {
    return this.staticTargetDiscoveryEnabled;
  }

  public boolean isSendTargetsDiscoveryEnabled()
  {
    return this.sendTargetsDiscoveryEnabled;
  }

  public void setISnsDiscoveryEnabled(boolean iSnsDiscoveryEnabled)
  {
    this.iSnsDiscoveryEnabled=iSnsDiscoveryEnabled;
  }

  public void setISnsDiscoveryMethod(String iSnsDiscoveryMethod)
  {
    this.iSnsDiscoveryMethod=iSnsDiscoveryMethod;
  }

  public void setISnsHost(String iSnsHost)
  {
    this.iSnsHost=iSnsHost;
  }

  public void setSlpDiscoveryEnabled(boolean slpDiscoveryEnabled)
  {
    this.slpDiscoveryEnabled=slpDiscoveryEnabled;
  }

  public void setSlpDiscoveryMethod(String slpDiscoveryMethod)
  {
    this.slpDiscoveryMethod=slpDiscoveryMethod;
  }

  public void setSlpHost(String slpHost)
  {
    this.slpHost=slpHost;
  }

  public void setStaticTargetDiscoveryEnabled(boolean staticTargetDiscoveryEnabled)
  {
    this.staticTargetDiscoveryEnabled=staticTargetDiscoveryEnabled;
  }

  public void setSendTargetsDiscoveryEnabled(boolean sendTargetsDiscoveryEnabled)
  {
    this.sendTargetsDiscoveryEnabled=sendTargetsDiscoveryEnabled;
  }
}