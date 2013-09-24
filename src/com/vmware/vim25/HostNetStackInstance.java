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
public class HostNetStackInstance extends DynamicData {
  public String key;
  public String name;
  public HostDnsConfig dnsConfig;
  public HostIpRouteConfig ipRouteConfig;
  public Integer requestedMaxNumberOfConnections;
  public String congestionControlAlgorithm;
  public Boolean ipV6Enabled;
  public HostIpRouteTableConfig routeTableConfig;

  public String getKey() {
    return this.key;
  }

  public String getName() {
    return this.name;
  }

  public HostDnsConfig getDnsConfig() {
    return this.dnsConfig;
  }

  public HostIpRouteConfig getIpRouteConfig() {
    return this.ipRouteConfig;
  }

  public Integer getRequestedMaxNumberOfConnections() {
    return this.requestedMaxNumberOfConnections;
  }

  public String getCongestionControlAlgorithm() {
    return this.congestionControlAlgorithm;
  }

  public Boolean getIpV6Enabled() {
    return this.ipV6Enabled;
  }

  public HostIpRouteTableConfig getRouteTableConfig() {
    return this.routeTableConfig;
  }

  public void setKey(String key) {
    this.key=key;
  }

  public void setName(String name) {
    this.name=name;
  }

  public void setDnsConfig(HostDnsConfig dnsConfig) {
    this.dnsConfig=dnsConfig;
  }

  public void setIpRouteConfig(HostIpRouteConfig ipRouteConfig) {
    this.ipRouteConfig=ipRouteConfig;
  }

  public void setRequestedMaxNumberOfConnections(Integer requestedMaxNumberOfConnections) {
    this.requestedMaxNumberOfConnections=requestedMaxNumberOfConnections;
  }

  public void setCongestionControlAlgorithm(String congestionControlAlgorithm) {
    this.congestionControlAlgorithm=congestionControlAlgorithm;
  }

  public void setIpV6Enabled(Boolean ipV6Enabled) {
    this.ipV6Enabled=ipV6Enabled;
  }

  public void setRouteTableConfig(HostIpRouteTableConfig routeTableConfig) {
    this.routeTableConfig=routeTableConfig;
  }
}