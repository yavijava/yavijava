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

public class PhysicalNicCdpInfo extends DynamicData
{
  public Integer cdpVersion;
  public Integer timeout;
  public Integer ttl;
  public Integer samples;
  public String devId;
  public String address;
  public String portId;
  public PhysicalNicCdpDeviceCapability deviceCapability;
  public String softwareVersion;
  public String hardwarePlatform;
  public String ipPrefix;
  public Integer ipPrefixLen;
  public Integer vlan;
  public Boolean fullDuplex;
  public Integer mtu;
  public String systemName;
  public String systemOID;
  public String mgmtAddr;
  public String location;

  public Integer getCdpVersion()
  {
    return this.cdpVersion;
  }

  public Integer getTimeout()
  {
    return this.timeout;
  }

  public Integer getTtl()
  {
    return this.ttl;
  }

  public Integer getSamples()
  {
    return this.samples;
  }

  public String getDevId()
  {
    return this.devId;
  }

  public String getAddress()
  {
    return this.address;
  }

  public String getPortId()
  {
    return this.portId;
  }

  public PhysicalNicCdpDeviceCapability getDeviceCapability()
  {
    return this.deviceCapability;
  }

  public String getSoftwareVersion()
  {
    return this.softwareVersion;
  }

  public String getHardwarePlatform()
  {
    return this.hardwarePlatform;
  }

  public String getIpPrefix()
  {
    return this.ipPrefix;
  }

  public Integer getIpPrefixLen()
  {
    return this.ipPrefixLen;
  }

  public Integer getVlan()
  {
    return this.vlan;
  }

  public Boolean getFullDuplex()
  {
    return this.fullDuplex;
  }

  public Integer getMtu()
  {
    return this.mtu;
  }

  public String getSystemName()
  {
    return this.systemName;
  }

  public String getSystemOID()
  {
    return this.systemOID;
  }

  public String getMgmtAddr()
  {
    return this.mgmtAddr;
  }

  public String getLocation()
  {
    return this.location;
  }

  public void setCdpVersion(Integer cdpVersion)
  {
    this.cdpVersion=cdpVersion;
  }

  public void setTimeout(Integer timeout)
  {
    this.timeout=timeout;
  }

  public void setTtl(Integer ttl)
  {
    this.ttl=ttl;
  }

  public void setSamples(Integer samples)
  {
    this.samples=samples;
  }

  public void setDevId(String devId)
  {
    this.devId=devId;
  }

  public void setAddress(String address)
  {
    this.address=address;
  }

  public void setPortId(String portId)
  {
    this.portId=portId;
  }

  public void setDeviceCapability(PhysicalNicCdpDeviceCapability deviceCapability)
  {
    this.deviceCapability=deviceCapability;
  }

  public void setSoftwareVersion(String softwareVersion)
  {
    this.softwareVersion=softwareVersion;
  }

  public void setHardwarePlatform(String hardwarePlatform)
  {
    this.hardwarePlatform=hardwarePlatform;
  }

  public void setIpPrefix(String ipPrefix)
  {
    this.ipPrefix=ipPrefix;
  }

  public void setIpPrefixLen(Integer ipPrefixLen)
  {
    this.ipPrefixLen=ipPrefixLen;
  }

  public void setVlan(Integer vlan)
  {
    this.vlan=vlan;
  }

  public void setFullDuplex(Boolean fullDuplex)
  {
    this.fullDuplex=fullDuplex;
  }

  public void setMtu(Integer mtu)
  {
    this.mtu=mtu;
  }

  public void setSystemName(String systemName)
  {
    this.systemName=systemName;
  }

  public void setSystemOID(String systemOID)
  {
    this.systemOID=systemOID;
  }

  public void setMgmtAddr(String mgmtAddr)
  {
    this.mgmtAddr=mgmtAddr;
  }

  public void setLocation(String location)
  {
    this.location=location;
  }
}