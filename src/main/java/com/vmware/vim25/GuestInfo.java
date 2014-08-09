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
public class GuestInfo extends DynamicData {
  public VirtualMachineToolsStatus toolsStatus;
  public String toolsVersionStatus;
  public String toolsVersionStatus2;
  public String toolsRunningStatus;
  public String toolsVersion;
  public String guestId;
  public String guestFamily;
  public String guestFullName;
  public String hostName;
  public String ipAddress;
  public GuestNicInfo[] net;
  public GuestStackInfo[] ipStack;
  public GuestDiskInfo[] disk;
  public GuestScreenInfo screen;
  public String guestState;
  public String appHeartbeatStatus;
  public String appState;
  public Boolean guestOperationsReady;
  public Boolean interactiveGuestOperationsReady;
  public GuestInfoNamespaceGenerationInfo[] generationInfo;

  public VirtualMachineToolsStatus getToolsStatus() {
    return this.toolsStatus;
  }

  public String getToolsVersionStatus() {
    return this.toolsVersionStatus;
  }

  public String getToolsVersionStatus2() {
    return this.toolsVersionStatus2;
  }

  public String getToolsRunningStatus() {
    return this.toolsRunningStatus;
  }

  public String getToolsVersion() {
    return this.toolsVersion;
  }

  public String getGuestId() {
    return this.guestId;
  }

  public String getGuestFamily() {
    return this.guestFamily;
  }

  public String getGuestFullName() {
    return this.guestFullName;
  }

  public String getHostName() {
    return this.hostName;
  }

  public String getIpAddress() {
    return this.ipAddress;
  }

  public GuestNicInfo[] getNet() {
    return this.net;
  }

  public GuestStackInfo[] getIpStack() {
    return this.ipStack;
  }

  public GuestDiskInfo[] getDisk() {
    return this.disk;
  }

  public GuestScreenInfo getScreen() {
    return this.screen;
  }

  public String getGuestState() {
    return this.guestState;
  }

  public String getAppHeartbeatStatus() {
    return this.appHeartbeatStatus;
  }

  public String getAppState() {
    return this.appState;
  }

  public Boolean getGuestOperationsReady() {
    return this.guestOperationsReady;
  }

  public Boolean getInteractiveGuestOperationsReady() {
    return this.interactiveGuestOperationsReady;
  }

  public GuestInfoNamespaceGenerationInfo[] getGenerationInfo() {
    return this.generationInfo;
  }

  public void setToolsStatus(VirtualMachineToolsStatus toolsStatus) {
    this.toolsStatus=toolsStatus;
  }

  public void setToolsVersionStatus(String toolsVersionStatus) {
    this.toolsVersionStatus=toolsVersionStatus;
  }

  public void setToolsVersionStatus2(String toolsVersionStatus2) {
    this.toolsVersionStatus2=toolsVersionStatus2;
  }

  public void setToolsRunningStatus(String toolsRunningStatus) {
    this.toolsRunningStatus=toolsRunningStatus;
  }

  public void setToolsVersion(String toolsVersion) {
    this.toolsVersion=toolsVersion;
  }

  public void setGuestId(String guestId) {
    this.guestId=guestId;
  }

  public void setGuestFamily(String guestFamily) {
    this.guestFamily=guestFamily;
  }

  public void setGuestFullName(String guestFullName) {
    this.guestFullName=guestFullName;
  }

  public void setHostName(String hostName) {
    this.hostName=hostName;
  }

  public void setIpAddress(String ipAddress) {
    this.ipAddress=ipAddress;
  }

  public void setNet(GuestNicInfo[] net) {
    this.net=net;
  }

  public void setIpStack(GuestStackInfo[] ipStack) {
    this.ipStack=ipStack;
  }

  public void setDisk(GuestDiskInfo[] disk) {
    this.disk=disk;
  }

  public void setScreen(GuestScreenInfo screen) {
    this.screen=screen;
  }

  public void setGuestState(String guestState) {
    this.guestState=guestState;
  }

  public void setAppHeartbeatStatus(String appHeartbeatStatus) {
    this.appHeartbeatStatus=appHeartbeatStatus;
  }

  public void setAppState(String appState) {
    this.appState=appState;
  }

  public void setGuestOperationsReady(Boolean guestOperationsReady) {
    this.guestOperationsReady=guestOperationsReady;
  }

  public void setInteractiveGuestOperationsReady(Boolean interactiveGuestOperationsReady) {
    this.interactiveGuestOperationsReady=interactiveGuestOperationsReady;
  }

  public void setGenerationInfo(GuestInfoNamespaceGenerationInfo[] generationInfo) {
    this.generationInfo=generationInfo;
  }
}