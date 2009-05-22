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

public class CustomizationIPSettings extends DynamicData
{
  public CustomizationIpGenerator ip;
  public String subnetMask;
  public String[] gateway;
  public CustomizationIPSettingsIpV6AddressSpec ipV6Spec;
  public String[] dnsServerList;
  public String dnsDomain;
  public String primaryWINS;
  public String secondaryWINS;
  public CustomizationNetBIOSMode netBIOS;

  public CustomizationIpGenerator getIp()
  {
    return this.ip;
  }

  public String getSubnetMask()
  {
    return this.subnetMask;
  }

  public String[] getGateway()
  {
    return this.gateway;
  }

  public CustomizationIPSettingsIpV6AddressSpec getIpV6Spec()
  {
    return this.ipV6Spec;
  }

  public String[] getDnsServerList()
  {
    return this.dnsServerList;
  }

  public String getDnsDomain()
  {
    return this.dnsDomain;
  }

  public String getPrimaryWINS()
  {
    return this.primaryWINS;
  }

  public String getSecondaryWINS()
  {
    return this.secondaryWINS;
  }

  public CustomizationNetBIOSMode getNetBIOS()
  {
    return this.netBIOS;
  }

  public void setIp(CustomizationIpGenerator ip)
  {
    this.ip=ip;
  }

  public void setSubnetMask(String subnetMask)
  {
    this.subnetMask=subnetMask;
  }

  public void setGateway(String[] gateway)
  {
    this.gateway=gateway;
  }

  public void setIpV6Spec(CustomizationIPSettingsIpV6AddressSpec ipV6Spec)
  {
    this.ipV6Spec=ipV6Spec;
  }

  public void setDnsServerList(String[] dnsServerList)
  {
    this.dnsServerList=dnsServerList;
  }

  public void setDnsDomain(String dnsDomain)
  {
    this.dnsDomain=dnsDomain;
  }

  public void setPrimaryWINS(String primaryWINS)
  {
    this.primaryWINS=primaryWINS;
  }

  public void setSecondaryWINS(String secondaryWINS)
  {
    this.secondaryWINS=secondaryWINS;
  }

  public void setNetBIOS(CustomizationNetBIOSMode netBIOS)
  {
    this.netBIOS=netBIOS;
  }
}