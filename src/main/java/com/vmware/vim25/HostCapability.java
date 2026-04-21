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
 * Created by Michael Rice on Fri Nov 18 12:45:26 CST 2016
 * This code is auto generated using yavijava_generator
 * https://github.com/yavijava/yavijava_generator
 *
 * Copyright 2015 Michael Rice
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @since 6.0
 */

public class HostCapability extends DynamicData {
    @Getter @Setter public boolean recursiveResourcePoolsSupported;
    @Getter @Setter public boolean cpuMemoryResourceConfigurationSupported;
    @Getter @Setter public boolean rebootSupported;
    @Getter @Setter public boolean shutdownSupported;
    @Getter @Setter public boolean vmotionSupported;
    @Getter @Setter public boolean standbySupported;
    @Getter @Setter public Boolean ipmiSupported;
    @Getter @Setter public Integer maxSupportedVMs;
    @Getter @Setter public Integer maxRunningVMs;
    @Getter @Setter public Integer maxSupportedVcpus;
    @Getter @Setter public Integer maxRegisteredVMs;
    @Getter @Setter public boolean datastorePrincipalSupported;
    @Getter @Setter public boolean sanSupported;
    @Getter @Setter public boolean nfsSupported;
    @Getter @Setter public boolean iscsiSupported;
    @Getter @Setter public boolean vlanTaggingSupported;
    @Getter @Setter public boolean nicTeamingSupported;
    @Getter @Setter public boolean highGuestMemSupported;
    @Getter @Setter public boolean maintenanceModeSupported;
    @Getter @Setter public boolean suspendedRelocateSupported;
    @Getter @Setter public boolean restrictedSnapshotRelocateSupported;
    @Getter @Setter public boolean perVmSwapFiles;
    @Getter @Setter public boolean localSwapDatastoreSupported;
    @Getter @Setter public boolean unsharedSwapVMotionSupported;
    @Getter @Setter public boolean backgroundSnapshotsSupported;
    @Getter @Setter public boolean preAssignedPCIUnitNumbersSupported;
    @Getter @Setter public boolean screenshotSupported;
    @Getter @Setter public boolean scaledScreenshotSupported;
    @Getter @Setter public Boolean storageVMotionSupported;
    @Getter @Setter public Boolean vmotionWithStorageVMotionSupported;
    @Getter @Setter public Boolean vmotionAcrossNetworkSupported;
    @Getter @Setter public Integer maxNumDisksSVMotion;
    @Getter @Setter public Boolean hbrNicSelectionSupported;
    @Getter @Setter public Boolean vrNfcNicSelectionSupported;
    @Getter @Setter public Boolean recordReplaySupported;
    @Getter @Setter public Boolean ftSupported;
    @Getter @Setter public String replayUnsupportedReason;
    @Getter @Setter public String[] replayCompatibilityIssues;
    @Getter @Setter public Boolean smpFtSupported;
    @Getter @Setter public String[] ftCompatibilityIssues;
    @Getter @Setter public String[] smpFtCompatibilityIssues;
    @Getter @Setter public Integer maxVcpusPerFtVm;
    @Getter @Setter public Boolean loginBySSLThumbprintSupported;
    @Getter @Setter public Boolean cloneFromSnapshotSupported;
    @Getter @Setter public Boolean deltaDiskBackingsSupported;
    @Getter @Setter public Boolean perVMNetworkTrafficShapingSupported;
    @Getter @Setter public Boolean tpmSupported;
    @Getter @Setter public HostCpuIdInfo[] supportedCpuFeature;
    @Getter @Setter public Boolean virtualExecUsageSupported;
    @Getter @Setter public Boolean storageIORMSupported;
    @Getter @Setter public Boolean vmDirectPathGen2Supported;
    @Getter @Setter public String[] vmDirectPathGen2UnsupportedReason;
    @Getter @Setter public String vmDirectPathGen2UnsupportedReasonExtended;
    @Getter @Setter public int[] supportedVmfsMajorVersion;
    @Getter @Setter public Boolean vStorageCapable;
    @Getter @Setter public Boolean snapshotRelayoutSupported;
    @Getter @Setter public Boolean firewallIpRulesSupported;
    @Getter @Setter public Boolean servicePackageInfoSupported;
    @Getter @Setter public Integer maxHostRunningVms;
    @Getter @Setter public Integer maxHostSupportedVcpus;
    @Getter @Setter public Boolean vmfsDatastoreMountCapable;
    @Getter @Setter public Boolean eightPlusHostVmfsSharedAccessSupported;
    @Getter @Setter public Boolean nestedHVSupported;
    @Getter @Setter public Boolean vPMCSupported;
    @Getter @Setter public Boolean interVMCommunicationThroughVMCISupported;
    @Getter @Setter public Boolean scheduledHardwareUpgradeSupported;
    @Getter @Setter public Boolean featureCapabilitiesSupported;
    @Getter @Setter public Boolean latencySensitivitySupported;
    @Getter @Setter public Boolean storagePolicySupported;
    @Getter @Setter public Boolean accel3dSupported;
    @Getter @Setter public Boolean reliableMemoryAware;
    @Getter @Setter public Boolean multipleNetworkStackInstanceSupported;
    @Getter @Setter public Boolean messageBusProxySupported;
    @Getter @Setter public Boolean vsanSupported;
    @Getter @Setter public Boolean vFlashSupported;
    @Getter @Setter public Boolean hostAccessManagerSupported;
    @Getter @Setter public Boolean provisioningNicSelectionSupported;
    @Getter @Setter public Boolean nfs41Supported;
    @Getter @Setter public Boolean nfs41Krb5iSupported;
    @Getter @Setter public Boolean turnDiskLocatorLedSupported;
    @Getter @Setter public Boolean virtualVolumeDatastoreSupported;
    @Getter @Setter public Boolean markAsSsdSupported;
    @Getter @Setter public Boolean markAsLocalSupported;
    @Getter @Setter public Boolean smartCardAuthenticationSupported;
    @Getter @Setter public Boolean cryptoSupported;
    @Getter @Setter public Boolean oneKVolumeAPIsSupported;
    @Getter @Setter public Boolean gatewayOnNicSupported;
    @Getter @Setter public Boolean upitSupported;
    @Getter @Setter public Boolean cpuHwMmuSupported;
    @Getter @Setter public Boolean encryptedVMotionSupported;
    @Getter @Setter public Boolean encryptionChangeOnAddRemoveSupported;
    @Getter @Setter public Boolean encryptionHotOperationSupported;
    @Getter @Setter public Boolean encryptionWithSnapshotsSupported;
    @Getter @Setter public Boolean encryptionFaultToleranceSupported;
    @Getter @Setter public Boolean encryptionMemorySaveSupported;
    @Getter @Setter public Boolean encryptionRDMSupported;
    @Getter @Setter public Boolean encryptionVFlashSupported;
    @Getter @Setter public Boolean encryptionCBRCSupported;
    @Getter @Setter public Boolean encryptionHBRSupported;
}
