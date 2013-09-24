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
public class DVSFeatureCapability extends DynamicData {
  public boolean networkResourceManagementSupported;
  public boolean vmDirectPathGen2Supported;
  public String[] nicTeamingPolicy;
  public Integer networkResourcePoolHighShareValue;
  public DVSNetworkResourceManagementCapability networkResourceManagementCapability;
  public DVSHealthCheckCapability healthCheckCapability;
  public DVSRollbackCapability rollbackCapability;
  public DVSBackupRestoreCapability backupRestoreCapability;
  public Boolean networkFilterSupported;

  public boolean isNetworkResourceManagementSupported() {
    return this.networkResourceManagementSupported;
  }

  public boolean isVmDirectPathGen2Supported() {
    return this.vmDirectPathGen2Supported;
  }

  public String[] getNicTeamingPolicy() {
    return this.nicTeamingPolicy;
  }

  public Integer getNetworkResourcePoolHighShareValue() {
    return this.networkResourcePoolHighShareValue;
  }

  public DVSNetworkResourceManagementCapability getNetworkResourceManagementCapability() {
    return this.networkResourceManagementCapability;
  }

  public DVSHealthCheckCapability getHealthCheckCapability() {
    return this.healthCheckCapability;
  }

  public DVSRollbackCapability getRollbackCapability() {
    return this.rollbackCapability;
  }

  public DVSBackupRestoreCapability getBackupRestoreCapability() {
    return this.backupRestoreCapability;
  }

  public Boolean getNetworkFilterSupported() {
    return this.networkFilterSupported;
  }

  public void setNetworkResourceManagementSupported(boolean networkResourceManagementSupported) {
    this.networkResourceManagementSupported=networkResourceManagementSupported;
  }

  public void setVmDirectPathGen2Supported(boolean vmDirectPathGen2Supported) {
    this.vmDirectPathGen2Supported=vmDirectPathGen2Supported;
  }

  public void setNicTeamingPolicy(String[] nicTeamingPolicy) {
    this.nicTeamingPolicy=nicTeamingPolicy;
  }

  public void setNetworkResourcePoolHighShareValue(Integer networkResourcePoolHighShareValue) {
    this.networkResourcePoolHighShareValue=networkResourcePoolHighShareValue;
  }

  public void setNetworkResourceManagementCapability(DVSNetworkResourceManagementCapability networkResourceManagementCapability) {
    this.networkResourceManagementCapability=networkResourceManagementCapability;
  }

  public void setHealthCheckCapability(DVSHealthCheckCapability healthCheckCapability) {
    this.healthCheckCapability=healthCheckCapability;
  }

  public void setRollbackCapability(DVSRollbackCapability rollbackCapability) {
    this.rollbackCapability=rollbackCapability;
  }

  public void setBackupRestoreCapability(DVSBackupRestoreCapability backupRestoreCapability) {
    this.backupRestoreCapability=backupRestoreCapability;
  }

  public void setNetworkFilterSupported(Boolean networkFilterSupported) {
    this.networkFilterSupported=networkFilterSupported;
  }
}