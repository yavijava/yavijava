/*================================================================================
Copyright (c) 2013 Steve Jin. All Rights Reserved.

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
* @author Steve Jin (http://www.doublecloud.org)
* @version 5.1
*/

@SuppressWarnings("all")
public class IpPool extends DynamicData {
  public Integer id;
  public String name;
  public IpPoolIpPoolConfigInfo ipv4Config;
  public IpPoolIpPoolConfigInfo ipv6Config;
  public String dnsDomain;
  public String dnsSearchPath;
  public String hostPrefix;
  public String httpProxy;
  public IpPoolAssociation[] networkAssociation;
  public Integer availableIpv4Addresses;
  public Integer availableIpv6Addresses;
  public Integer allocatedIpv4Addresses;
  public Integer allocatedIpv6Addresses;

  public Integer getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public IpPoolIpPoolConfigInfo getIpv4Config() {
    return this.ipv4Config;
  }

  public IpPoolIpPoolConfigInfo getIpv6Config() {
    return this.ipv6Config;
  }

  public String getDnsDomain() {
    return this.dnsDomain;
  }

  public String getDnsSearchPath() {
    return this.dnsSearchPath;
  }

  public String getHostPrefix() {
    return this.hostPrefix;
  }

  public String getHttpProxy() {
    return this.httpProxy;
  }

  public IpPoolAssociation[] getNetworkAssociation() {
    return this.networkAssociation;
  }

  public Integer getAvailableIpv4Addresses() {
    return this.availableIpv4Addresses;
  }

  public Integer getAvailableIpv6Addresses() {
    return this.availableIpv6Addresses;
  }

  public Integer getAllocatedIpv4Addresses() {
    return this.allocatedIpv4Addresses;
  }

  public Integer getAllocatedIpv6Addresses() {
    return this.allocatedIpv6Addresses;
  }

  public void setId(Integer id) {
    this.id=id;
  }

  public void setName(String name) {
    this.name=name;
  }

  public void setIpv4Config(IpPoolIpPoolConfigInfo ipv4Config) {
    this.ipv4Config=ipv4Config;
  }

  public void setIpv6Config(IpPoolIpPoolConfigInfo ipv6Config) {
    this.ipv6Config=ipv6Config;
  }

  public void setDnsDomain(String dnsDomain) {
    this.dnsDomain=dnsDomain;
  }

  public void setDnsSearchPath(String dnsSearchPath) {
    this.dnsSearchPath=dnsSearchPath;
  }

  public void setHostPrefix(String hostPrefix) {
    this.hostPrefix=hostPrefix;
  }

  public void setHttpProxy(String httpProxy) {
    this.httpProxy=httpProxy;
  }

  public void setNetworkAssociation(IpPoolAssociation[] networkAssociation) {
    this.networkAssociation=networkAssociation;
  }

  public void setAvailableIpv4Addresses(Integer availableIpv4Addresses) {
    this.availableIpv4Addresses=availableIpv4Addresses;
  }

  public void setAvailableIpv6Addresses(Integer availableIpv6Addresses) {
    this.availableIpv6Addresses=availableIpv6Addresses;
  }

  public void setAllocatedIpv4Addresses(Integer allocatedIpv4Addresses) {
    this.allocatedIpv4Addresses=allocatedIpv4Addresses;
  }

  public void setAllocatedIpv6Addresses(Integer allocatedIpv6Addresses) {
    this.allocatedIpv6Addresses=allocatedIpv6Addresses;
  }
}