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

public class VirtualMachineCapability extends DynamicData
{
  public boolean snapshotOperationsSupported;
  public boolean multipleSnapshotsSupported;
  public boolean snapshotConfigSupported;
  public boolean poweredOffSnapshotsSupported;
  public boolean memorySnapshotsSupported;
  public boolean revertToSnapshotSupported;
  public boolean quiescedSnapshotsSupported;
  public boolean disableSnapshotsSupported;
  public boolean lockSnapshotsSupported;
  public boolean consolePreferencesSupported;
  public boolean cpuFeatureMaskSupported;
  public boolean s1AcpiManagementSupported;
  public boolean settingScreenResolutionSupported;
  public boolean toolsAutoUpdateSupported;
  public boolean vmNpivWwnSupported;
  public boolean npivWwnOnNonRdmVmSupported;
  public boolean swapPlacementSupported;
  public boolean toolsSyncTimeSupported;
  public boolean virtualMmuUsageSupported;
  public boolean diskSharesSupported;
  public boolean bootOptionsSupported;
  public boolean settingVideoRamSizeSupported;

  public boolean isSnapshotOperationsSupported()
  {
    return this.snapshotOperationsSupported;
  }

  public boolean isMultipleSnapshotsSupported()
  {
    return this.multipleSnapshotsSupported;
  }

  public boolean isSnapshotConfigSupported()
  {
    return this.snapshotConfigSupported;
  }

  public boolean isPoweredOffSnapshotsSupported()
  {
    return this.poweredOffSnapshotsSupported;
  }

  public boolean isMemorySnapshotsSupported()
  {
    return this.memorySnapshotsSupported;
  }

  public boolean isRevertToSnapshotSupported()
  {
    return this.revertToSnapshotSupported;
  }

  public boolean isQuiescedSnapshotsSupported()
  {
    return this.quiescedSnapshotsSupported;
  }

  public boolean isDisableSnapshotsSupported()
  {
    return this.disableSnapshotsSupported;
  }

  public boolean isLockSnapshotsSupported()
  {
    return this.lockSnapshotsSupported;
  }

  public boolean isConsolePreferencesSupported()
  {
    return this.consolePreferencesSupported;
  }

  public boolean isCpuFeatureMaskSupported()
  {
    return this.cpuFeatureMaskSupported;
  }

  public boolean isS1AcpiManagementSupported()
  {
    return this.s1AcpiManagementSupported;
  }

  public boolean isSettingScreenResolutionSupported()
  {
    return this.settingScreenResolutionSupported;
  }

  public boolean isToolsAutoUpdateSupported()
  {
    return this.toolsAutoUpdateSupported;
  }

  public boolean isVmNpivWwnSupported()
  {
    return this.vmNpivWwnSupported;
  }

  public boolean isNpivWwnOnNonRdmVmSupported()
  {
    return this.npivWwnOnNonRdmVmSupported;
  }

  public boolean isSwapPlacementSupported()
  {
    return this.swapPlacementSupported;
  }

  public boolean isToolsSyncTimeSupported()
  {
    return this.toolsSyncTimeSupported;
  }

  public boolean isVirtualMmuUsageSupported()
  {
    return this.virtualMmuUsageSupported;
  }

  public boolean isDiskSharesSupported()
  {
    return this.diskSharesSupported;
  }

  public boolean isBootOptionsSupported()
  {
    return this.bootOptionsSupported;
  }

  public boolean isSettingVideoRamSizeSupported()
  {
    return this.settingVideoRamSizeSupported;
  }

  public void setSnapshotOperationsSupported(boolean snapshotOperationsSupported)
  {
    this.snapshotOperationsSupported=snapshotOperationsSupported;
  }

  public void setMultipleSnapshotsSupported(boolean multipleSnapshotsSupported)
  {
    this.multipleSnapshotsSupported=multipleSnapshotsSupported;
  }

  public void setSnapshotConfigSupported(boolean snapshotConfigSupported)
  {
    this.snapshotConfigSupported=snapshotConfigSupported;
  }

  public void setPoweredOffSnapshotsSupported(boolean poweredOffSnapshotsSupported)
  {
    this.poweredOffSnapshotsSupported=poweredOffSnapshotsSupported;
  }

  public void setMemorySnapshotsSupported(boolean memorySnapshotsSupported)
  {
    this.memorySnapshotsSupported=memorySnapshotsSupported;
  }

  public void setRevertToSnapshotSupported(boolean revertToSnapshotSupported)
  {
    this.revertToSnapshotSupported=revertToSnapshotSupported;
  }

  public void setQuiescedSnapshotsSupported(boolean quiescedSnapshotsSupported)
  {
    this.quiescedSnapshotsSupported=quiescedSnapshotsSupported;
  }

  public void setDisableSnapshotsSupported(boolean disableSnapshotsSupported)
  {
    this.disableSnapshotsSupported=disableSnapshotsSupported;
  }

  public void setLockSnapshotsSupported(boolean lockSnapshotsSupported)
  {
    this.lockSnapshotsSupported=lockSnapshotsSupported;
  }

  public void setConsolePreferencesSupported(boolean consolePreferencesSupported)
  {
    this.consolePreferencesSupported=consolePreferencesSupported;
  }

  public void setCpuFeatureMaskSupported(boolean cpuFeatureMaskSupported)
  {
    this.cpuFeatureMaskSupported=cpuFeatureMaskSupported;
  }

  public void setS1AcpiManagementSupported(boolean s1AcpiManagementSupported)
  {
    this.s1AcpiManagementSupported=s1AcpiManagementSupported;
  }

  public void setSettingScreenResolutionSupported(boolean settingScreenResolutionSupported)
  {
    this.settingScreenResolutionSupported=settingScreenResolutionSupported;
  }

  public void setToolsAutoUpdateSupported(boolean toolsAutoUpdateSupported)
  {
    this.toolsAutoUpdateSupported=toolsAutoUpdateSupported;
  }

  public void setVmNpivWwnSupported(boolean vmNpivWwnSupported)
  {
    this.vmNpivWwnSupported=vmNpivWwnSupported;
  }

  public void setNpivWwnOnNonRdmVmSupported(boolean npivWwnOnNonRdmVmSupported)
  {
    this.npivWwnOnNonRdmVmSupported=npivWwnOnNonRdmVmSupported;
  }

  public void setSwapPlacementSupported(boolean swapPlacementSupported)
  {
    this.swapPlacementSupported=swapPlacementSupported;
  }

  public void setToolsSyncTimeSupported(boolean toolsSyncTimeSupported)
  {
    this.toolsSyncTimeSupported=toolsSyncTimeSupported;
  }

  public void setVirtualMmuUsageSupported(boolean virtualMmuUsageSupported)
  {
    this.virtualMmuUsageSupported=virtualMmuUsageSupported;
  }

  public void setDiskSharesSupported(boolean diskSharesSupported)
  {
    this.diskSharesSupported=diskSharesSupported;
  }

  public void setBootOptionsSupported(boolean bootOptionsSupported)
  {
    this.bootOptionsSupported=bootOptionsSupported;
  }

  public void setSettingVideoRamSizeSupported(boolean settingVideoRamSizeSupported)
  {
    this.settingVideoRamSizeSupported=settingVideoRamSizeSupported;
  }
}