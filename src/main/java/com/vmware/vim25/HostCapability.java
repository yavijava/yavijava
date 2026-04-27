package com.vmware.vim25;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Michael Rice on Fri Apr 24 22:47:25 CDT 2026
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
    @Getter @Setter public Integer maxVirtualDiskDescVersionSupported;
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
    @Getter @Setter public String tpmVersion;
    @Getter @Setter public Boolean txtEnabled;
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
    @Getter @Setter public Boolean pMemSupported;
    @Getter @Setter public Boolean pMemSnapshotSupported;
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
    @Getter @Setter public Boolean ftEfiSupported;
    @Getter @Setter public String unmapMethodSupported;
    @Getter @Setter public Integer maxMemMBPerFtVm;
    @Getter @Setter public Boolean virtualMmuUsageIgnored;
    @Getter @Setter public Boolean virtualExecUsageIgnored;
    @Getter @Setter public Boolean vmCreateDateSupported;
    @Getter @Setter public Boolean vmfs3EOLSupported;
    @Getter @Setter public Boolean ftVmcpSupported;
    @Getter @Setter public Boolean quickBootSupported;
    @Getter @Setter public Boolean encryptedFtSupported;
    @Getter @Setter public Boolean assignableHardwareSupported;
    @Getter @Setter public Boolean suspendToMemorySupported;
    @Getter @Setter public Boolean useFeatureReqsForOldHWv;
    @Getter @Setter public Boolean markPerenniallyReservedSupported;
    @Getter @Setter public Boolean hppPspSupported;
    @Getter @Setter public Boolean deviceRebindWithoutRebootSupported;
    @Getter @Setter public Boolean storagePolicyChangeSupported;
    @Getter @Setter public Boolean precisionTimeProtocolSupported;
    @Getter @Setter public Boolean remoteDeviceVMotionSupported;
    @Getter @Setter public Integer maxSupportedVmMemory;
    @Getter @Setter public Boolean ahDeviceHintsSupported;
    @Getter @Setter public Boolean nvmeOverTcpSupported;
    @Getter @Setter public Boolean nvmeStorageFabricServicesSupported;
    @Getter @Setter public Boolean assignHwPciConfigSupported;
    @Getter @Setter public Boolean timeConfigSupported;
    @Getter @Setter public Boolean nvmeBatchOperationsSupported;
    @Getter @Setter public Boolean pMemFailoverSupported;
    @Getter @Setter public Boolean hostConfigEncryptionSupported;
    @Getter @Setter public Integer maxSupportedSimultaneousThreads;
    @Getter @Setter public Boolean ptpConfigSupported;
    @Getter @Setter public Integer maxSupportedPtpPorts;
    @Getter @Setter public Boolean sgxRegistrationSupported;
    @Getter @Setter public Boolean pMemIndependentSnapshotSupported;
    @Getter @Setter public Boolean iommuSLDirtyCapable;
    @Getter @Setter public Boolean vmknicBindingSupported;
    @Getter @Setter public Boolean ultralowFixedUnmapSupported;
    @Getter @Setter public Boolean nvmeVvolSupported;
    @Getter @Setter public Boolean fptHotplugSupported;
    @Getter @Setter public Boolean mconnectSupported;
    @Getter @Setter public Boolean vsanNicMgmtSupported;
    @Getter @Setter public Boolean vvolNQNSupported;
    @Getter @Setter public Boolean stretchedSCSupported;
    @Getter @Setter public Boolean vmknicBindingOnNFSv41;
    @Getter @Setter public Boolean vpStatusCheckSupported;
    @Getter @Setter public Boolean e2e4knSupported;
    @Getter @Setter public Boolean vsanDedicatedVmkNicSupported;
    @Getter @Setter public Boolean nConnectSupported;
    @Getter @Setter public Boolean userKeySupported;
    @Getter @Setter public Boolean ndcmSupported;
    @Getter @Setter public Boolean uefiSecureBoot;
    @Getter @Setter public Boolean vpxdVmxGenerationSupported;
    @Getter @Setter public Boolean nfs41Krb5pSupported;
    @Getter @Setter public Boolean cimSupported;
    @Getter @Setter public Boolean npivSupported;
    @Getter @Setter public Boolean entitlementSupported;
}
