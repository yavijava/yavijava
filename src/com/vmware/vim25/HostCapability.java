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

public class HostCapability extends DynamicData
{
  public boolean recursiveResourcePoolsSupported;
  public boolean cpuMemoryResourceConfigurationSupported;
  public boolean rebootSupported;
  public boolean shutdownSupported;
  public boolean vmotionSupported;
  public boolean standbySupported;
  public Integer maxSupportedVMs;
  public Integer maxRunningVMs;
  public Integer maxSupportedVcpus;
  public boolean datastorePrincipalSupported;
  public boolean sanSupported;
  public boolean nfsSupported;
  public boolean iscsiSupported;
  public boolean vlanTaggingSupported;
  public boolean nicTeamingSupported;
  public boolean highGuestMemSupported;
  public boolean maintenanceModeSupported;
  public boolean suspendedRelocateSupported;
  public boolean restrictedSnapshotRelocateSupported;
  public boolean perVmSwapFiles;
  public boolean localSwapDatastoreSupported;
  public boolean unsharedSwapVMotionSupported;
  public boolean backgroundSnapshotsSupported;
  public boolean preAssignedPCIUnitNumbersSupported;
  public boolean screenshotSupported;
  public boolean scaledScreenshotSupported;

  public boolean isRecursiveResourcePoolsSupported()
  {
    return this.recursiveResourcePoolsSupported;
  }

  public boolean isCpuMemoryResourceConfigurationSupported()
  {
    return this.cpuMemoryResourceConfigurationSupported;
  }

  public boolean isRebootSupported()
  {
    return this.rebootSupported;
  }

  public boolean isShutdownSupported()
  {
    return this.shutdownSupported;
  }

  public boolean isVmotionSupported()
  {
    return this.vmotionSupported;
  }

  public boolean isStandbySupported()
  {
    return this.standbySupported;
  }

  public Integer getMaxSupportedVMs()
  {
    return this.maxSupportedVMs;
  }

  public Integer getMaxRunningVMs()
  {
    return this.maxRunningVMs;
  }

  public Integer getMaxSupportedVcpus()
  {
    return this.maxSupportedVcpus;
  }

  public boolean isDatastorePrincipalSupported()
  {
    return this.datastorePrincipalSupported;
  }

  public boolean isSanSupported()
  {
    return this.sanSupported;
  }

  public boolean isNfsSupported()
  {
    return this.nfsSupported;
  }

  public boolean isIscsiSupported()
  {
    return this.iscsiSupported;
  }

  public boolean isVlanTaggingSupported()
  {
    return this.vlanTaggingSupported;
  }

  public boolean isNicTeamingSupported()
  {
    return this.nicTeamingSupported;
  }

  public boolean isHighGuestMemSupported()
  {
    return this.highGuestMemSupported;
  }

  public boolean isMaintenanceModeSupported()
  {
    return this.maintenanceModeSupported;
  }

  public boolean isSuspendedRelocateSupported()
  {
    return this.suspendedRelocateSupported;
  }

  public boolean isRestrictedSnapshotRelocateSupported()
  {
    return this.restrictedSnapshotRelocateSupported;
  }

  public boolean isPerVmSwapFiles()
  {
    return this.perVmSwapFiles;
  }

  public boolean isLocalSwapDatastoreSupported()
  {
    return this.localSwapDatastoreSupported;
  }

  public boolean isUnsharedSwapVMotionSupported()
  {
    return this.unsharedSwapVMotionSupported;
  }

  public boolean isBackgroundSnapshotsSupported()
  {
    return this.backgroundSnapshotsSupported;
  }

  public boolean isPreAssignedPCIUnitNumbersSupported()
  {
    return this.preAssignedPCIUnitNumbersSupported;
  }

  public boolean isScreenshotSupported()
  {
    return this.screenshotSupported;
  }

  public boolean isScaledScreenshotSupported()
  {
    return this.scaledScreenshotSupported;
  }

  public void setRecursiveResourcePoolsSupported(boolean recursiveResourcePoolsSupported)
  {
    this.recursiveResourcePoolsSupported=recursiveResourcePoolsSupported;
  }

  public void setCpuMemoryResourceConfigurationSupported(boolean cpuMemoryResourceConfigurationSupported)
  {
    this.cpuMemoryResourceConfigurationSupported=cpuMemoryResourceConfigurationSupported;
  }

  public void setRebootSupported(boolean rebootSupported)
  {
    this.rebootSupported=rebootSupported;
  }

  public void setShutdownSupported(boolean shutdownSupported)
  {
    this.shutdownSupported=shutdownSupported;
  }

  public void setVmotionSupported(boolean vmotionSupported)
  {
    this.vmotionSupported=vmotionSupported;
  }

  public void setStandbySupported(boolean standbySupported)
  {
    this.standbySupported=standbySupported;
  }

  public void setMaxSupportedVMs(Integer maxSupportedVMs)
  {
    this.maxSupportedVMs=maxSupportedVMs;
  }

  public void setMaxRunningVMs(Integer maxRunningVMs)
  {
    this.maxRunningVMs=maxRunningVMs;
  }

  public void setMaxSupportedVcpus(Integer maxSupportedVcpus)
  {
    this.maxSupportedVcpus=maxSupportedVcpus;
  }

  public void setDatastorePrincipalSupported(boolean datastorePrincipalSupported)
  {
    this.datastorePrincipalSupported=datastorePrincipalSupported;
  }

  public void setSanSupported(boolean sanSupported)
  {
    this.sanSupported=sanSupported;
  }

  public void setNfsSupported(boolean nfsSupported)
  {
    this.nfsSupported=nfsSupported;
  }

  public void setIscsiSupported(boolean iscsiSupported)
  {
    this.iscsiSupported=iscsiSupported;
  }

  public void setVlanTaggingSupported(boolean vlanTaggingSupported)
  {
    this.vlanTaggingSupported=vlanTaggingSupported;
  }

  public void setNicTeamingSupported(boolean nicTeamingSupported)
  {
    this.nicTeamingSupported=nicTeamingSupported;
  }

  public void setHighGuestMemSupported(boolean highGuestMemSupported)
  {
    this.highGuestMemSupported=highGuestMemSupported;
  }

  public void setMaintenanceModeSupported(boolean maintenanceModeSupported)
  {
    this.maintenanceModeSupported=maintenanceModeSupported;
  }

  public void setSuspendedRelocateSupported(boolean suspendedRelocateSupported)
  {
    this.suspendedRelocateSupported=suspendedRelocateSupported;
  }

  public void setRestrictedSnapshotRelocateSupported(boolean restrictedSnapshotRelocateSupported)
  {
    this.restrictedSnapshotRelocateSupported=restrictedSnapshotRelocateSupported;
  }

  public void setPerVmSwapFiles(boolean perVmSwapFiles)
  {
    this.perVmSwapFiles=perVmSwapFiles;
  }

  public void setLocalSwapDatastoreSupported(boolean localSwapDatastoreSupported)
  {
    this.localSwapDatastoreSupported=localSwapDatastoreSupported;
  }

  public void setUnsharedSwapVMotionSupported(boolean unsharedSwapVMotionSupported)
  {
    this.unsharedSwapVMotionSupported=unsharedSwapVMotionSupported;
  }

  public void setBackgroundSnapshotsSupported(boolean backgroundSnapshotsSupported)
  {
    this.backgroundSnapshotsSupported=backgroundSnapshotsSupported;
  }

  public void setPreAssignedPCIUnitNumbersSupported(boolean preAssignedPCIUnitNumbersSupported)
  {
    this.preAssignedPCIUnitNumbersSupported=preAssignedPCIUnitNumbersSupported;
  }

  public void setScreenshotSupported(boolean screenshotSupported)
  {
    this.screenshotSupported=screenshotSupported;
  }

  public void setScaledScreenshotSupported(boolean scaledScreenshotSupported)
  {
    this.scaledScreenshotSupported=scaledScreenshotSupported;
  }
}