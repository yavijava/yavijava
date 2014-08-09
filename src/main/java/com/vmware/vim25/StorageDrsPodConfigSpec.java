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
public class StorageDrsPodConfigSpec extends DynamicData {
  public Boolean enabled;
  public Boolean ioLoadBalanceEnabled;
  public String defaultVmBehavior;
  public Integer loadBalanceInterval;
  public Boolean defaultIntraVmAffinity;
  public StorageDrsSpaceLoadBalanceConfig spaceLoadBalanceConfig;
  public StorageDrsIoLoadBalanceConfig ioLoadBalanceConfig;
  public ClusterRuleSpec[] rule;
  public StorageDrsOptionSpec[] option;

  public Boolean getEnabled() {
    return this.enabled;
  }

  public Boolean getIoLoadBalanceEnabled() {
    return this.ioLoadBalanceEnabled;
  }

  public String getDefaultVmBehavior() {
    return this.defaultVmBehavior;
  }

  public Integer getLoadBalanceInterval() {
    return this.loadBalanceInterval;
  }

  public Boolean getDefaultIntraVmAffinity() {
    return this.defaultIntraVmAffinity;
  }

  public StorageDrsSpaceLoadBalanceConfig getSpaceLoadBalanceConfig() {
    return this.spaceLoadBalanceConfig;
  }

  public StorageDrsIoLoadBalanceConfig getIoLoadBalanceConfig() {
    return this.ioLoadBalanceConfig;
  }

  public ClusterRuleSpec[] getRule() {
    return this.rule;
  }

  public StorageDrsOptionSpec[] getOption() {
    return this.option;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled=enabled;
  }

  public void setIoLoadBalanceEnabled(Boolean ioLoadBalanceEnabled) {
    this.ioLoadBalanceEnabled=ioLoadBalanceEnabled;
  }

  public void setDefaultVmBehavior(String defaultVmBehavior) {
    this.defaultVmBehavior=defaultVmBehavior;
  }

  public void setLoadBalanceInterval(Integer loadBalanceInterval) {
    this.loadBalanceInterval=loadBalanceInterval;
  }

  public void setDefaultIntraVmAffinity(Boolean defaultIntraVmAffinity) {
    this.defaultIntraVmAffinity=defaultIntraVmAffinity;
  }

  public void setSpaceLoadBalanceConfig(StorageDrsSpaceLoadBalanceConfig spaceLoadBalanceConfig) {
    this.spaceLoadBalanceConfig=spaceLoadBalanceConfig;
  }

  public void setIoLoadBalanceConfig(StorageDrsIoLoadBalanceConfig ioLoadBalanceConfig) {
    this.ioLoadBalanceConfig=ioLoadBalanceConfig;
  }

  public void setRule(ClusterRuleSpec[] rule) {
    this.rule=rule;
  }

  public void setOption(StorageDrsOptionSpec[] option) {
    this.option=option;
  }
}