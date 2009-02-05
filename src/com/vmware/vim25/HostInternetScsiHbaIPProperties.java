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

public class HostInternetScsiHbaIPProperties extends DynamicData
{
  public String mac;
  public String address;
  public boolean dhcpConfigurationEnabled;
  public String subnetMask;
  public String defaultGateway;
  public String primaryDnsServerAddress;
  public String alternateDnsServerAddress;

  public String getMac()
  {
    return this.mac;
  }

  public String getAddress()
  {
    return this.address;
  }

  public boolean isDhcpConfigurationEnabled()
  {
    return this.dhcpConfigurationEnabled;
  }

  public String getSubnetMask()
  {
    return this.subnetMask;
  }

  public String getDefaultGateway()
  {
    return this.defaultGateway;
  }

  public String getPrimaryDnsServerAddress()
  {
    return this.primaryDnsServerAddress;
  }

  public String getAlternateDnsServerAddress()
  {
    return this.alternateDnsServerAddress;
  }

  public void setMac(String mac)
  {
    this.mac=mac;
  }

  public void setAddress(String address)
  {
    this.address=address;
  }

  public void setDhcpConfigurationEnabled(boolean dhcpConfigurationEnabled)
  {
    this.dhcpConfigurationEnabled=dhcpConfigurationEnabled;
  }

  public void setSubnetMask(String subnetMask)
  {
    this.subnetMask=subnetMask;
  }

  public void setDefaultGateway(String defaultGateway)
  {
    this.defaultGateway=defaultGateway;
  }

  public void setPrimaryDnsServerAddress(String primaryDnsServerAddress)
  {
    this.primaryDnsServerAddress=primaryDnsServerAddress;
  }

  public void setAlternateDnsServerAddress(String alternateDnsServerAddress)
  {
    this.alternateDnsServerAddress=alternateDnsServerAddress;
  }
}