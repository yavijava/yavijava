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
import lombok.Getter;
import lombok.Setter;

/**
 * @author Steve Jin (http://www.doublecloud.org)
 * @version 5.1
 */

public class VirtualMachineCapability extends DynamicData {
    @Getter @Setter public boolean snapshotOperationsSupported;
    @Getter @Setter public boolean multipleSnapshotsSupported;
    @Getter @Setter public boolean snapshotConfigSupported;
    @Getter @Setter public boolean poweredOffSnapshotsSupported;
    @Getter @Setter public boolean memorySnapshotsSupported;
    @Getter @Setter public boolean revertToSnapshotSupported;
    @Getter @Setter public boolean quiescedSnapshotsSupported;
    @Getter @Setter public boolean disableSnapshotsSupported;
    @Getter @Setter public boolean lockSnapshotsSupported;
    @Getter @Setter public boolean consolePreferencesSupported;
    @Getter @Setter public boolean cpuFeatureMaskSupported;
    @Getter @Setter public boolean s1AcpiManagementSupported;
    @Getter @Setter public boolean settingScreenResolutionSupported;
    @Getter @Setter public boolean toolsAutoUpdateSupported;
    @Getter @Setter public boolean vmNpivWwnSupported;
    @Getter @Setter public boolean npivWwnOnNonRdmVmSupported;
    @Getter @Setter public Boolean vmNpivWwnDisableSupported;
    @Getter @Setter public Boolean vmNpivWwnUpdateSupported;
    @Getter @Setter public boolean swapPlacementSupported;
    @Getter @Setter public boolean toolsSyncTimeSupported;
    @Getter @Setter public boolean virtualMmuUsageSupported;
    @Getter @Setter public boolean diskSharesSupported;
    @Getter @Setter public boolean bootOptionsSupported;
    @Getter @Setter public Boolean bootRetryOptionsSupported;
    @Getter @Setter public boolean settingVideoRamSizeSupported;
    @Getter @Setter public Boolean settingDisplayTopologySupported;
    @Getter @Setter public Boolean recordReplaySupported;
    @Getter @Setter public Boolean changeTrackingSupported;
    @Getter @Setter public Boolean multipleCoresPerSocketSupported;
    @Getter @Setter public Boolean hostBasedReplicationSupported;
    @Getter @Setter public Boolean guestAutoLockSupported;
    @Getter @Setter public Boolean memoryReservationLockSupported;
    @Getter @Setter public Boolean featureRequirementSupported;
    @Getter @Setter public Boolean poweredOnMonitorTypeChangeSupported;
    @Getter @Setter public Boolean seSparseDiskSupported;
    @Getter @Setter public Boolean nestedHVSupported;
    @Getter @Setter public Boolean vPMCSupported;
    @Getter @Setter public Boolean secureBootSupported;
}
