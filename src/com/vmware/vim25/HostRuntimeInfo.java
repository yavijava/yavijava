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
import java.util.Calendar;

/**
* @author Steve Jin (http://www.doublecloud.org)
* @version 5.1
*/

@SuppressWarnings("all")
public class HostRuntimeInfo extends DynamicData {
  public HostSystemConnectionState connectionState;
  public HostSystemPowerState powerState;
  public String standbyMode;
  public boolean inMaintenanceMode;
  public Calendar bootTime;
  public HealthSystemRuntime healthSystemRuntime;
  public ClusterDasFdmHostState dasHostState;
  public HostTpmDigestInfo[] tpmPcrValues;
  public VsanHostRuntimeInfo vsanRuntimeInfo;
  public HostRuntimeInfoNetworkRuntimeInfo networkRuntimeInfo;
  public HostVFlashManagerVFlashResourceRunTimeInfo vFlashResourceRuntimeInfo;
  public Long hostMaxVirtualDiskCapacity;

  public HostSystemConnectionState getConnectionState() {
    return this.connectionState;
  }

  public HostSystemPowerState getPowerState() {
    return this.powerState;
  }

  public String getStandbyMode() {
    return this.standbyMode;
  }

  public boolean isInMaintenanceMode() {
    return this.inMaintenanceMode;
  }

  public Calendar getBootTime() {
    return this.bootTime;
  }

  public HealthSystemRuntime getHealthSystemRuntime() {
    return this.healthSystemRuntime;
  }

  public ClusterDasFdmHostState getDasHostState() {
    return this.dasHostState;
  }

  public HostTpmDigestInfo[] getTpmPcrValues() {
    return this.tpmPcrValues;
  }

  public VsanHostRuntimeInfo getVsanRuntimeInfo() {
    return this.vsanRuntimeInfo;
  }

  public HostRuntimeInfoNetworkRuntimeInfo getNetworkRuntimeInfo() {
    return this.networkRuntimeInfo;
  }

  public HostVFlashManagerVFlashResourceRunTimeInfo getVFlashResourceRuntimeInfo() {
    return this.vFlashResourceRuntimeInfo;
  }

  public Long getHostMaxVirtualDiskCapacity() {
    return this.hostMaxVirtualDiskCapacity;
  }

  public void setConnectionState(HostSystemConnectionState connectionState) {
    this.connectionState=connectionState;
  }

  public void setPowerState(HostSystemPowerState powerState) {
    this.powerState=powerState;
  }

  public void setStandbyMode(String standbyMode) {
    this.standbyMode=standbyMode;
  }

  public void setInMaintenanceMode(boolean inMaintenanceMode) {
    this.inMaintenanceMode=inMaintenanceMode;
  }

  public void setBootTime(Calendar bootTime) {
    this.bootTime=bootTime;
  }

  public void setHealthSystemRuntime(HealthSystemRuntime healthSystemRuntime) {
    this.healthSystemRuntime=healthSystemRuntime;
  }

  public void setDasHostState(ClusterDasFdmHostState dasHostState) {
    this.dasHostState=dasHostState;
  }

  public void setTpmPcrValues(HostTpmDigestInfo[] tpmPcrValues) {
    this.tpmPcrValues=tpmPcrValues;
  }

  public void setVsanRuntimeInfo(VsanHostRuntimeInfo vsanRuntimeInfo) {
    this.vsanRuntimeInfo=vsanRuntimeInfo;
  }

  public void setNetworkRuntimeInfo(HostRuntimeInfoNetworkRuntimeInfo networkRuntimeInfo) {
    this.networkRuntimeInfo=networkRuntimeInfo;
  }

  public void setVFlashResourceRuntimeInfo(HostVFlashManagerVFlashResourceRunTimeInfo vFlashResourceRuntimeInfo) {
    this.vFlashResourceRuntimeInfo=vFlashResourceRuntimeInfo;
  }

  public void setHostMaxVirtualDiskCapacity(Long hostMaxVirtualDiskCapacity) {
    this.hostMaxVirtualDiskCapacity=hostMaxVirtualDiskCapacity;
  }
}