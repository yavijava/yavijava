package com.vmware.vim25;
import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

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

public class VirtualMachineConfigInfo extends DynamicData {
    @Getter @Setter public String changeVersion;
    @Getter @Setter public Calendar modified;
    @Getter @Setter public String name;
    @Getter @Setter public String guestFullName;
    @Getter @Setter public String version;
    @Getter @Setter public String uuid;
    @Getter @Setter public Calendar createDate;
    @Getter @Setter public String instanceUuid;
    @Getter @Setter public long[] npivNodeWorldWideName;
    @Getter @Setter public long[] npivPortWorldWideName;
    @Getter @Setter public String npivWorldWideNameType;
    @Getter @Setter public Short npivDesiredNodeWwns;
    @Getter @Setter public Short npivDesiredPortWwns;
    @Getter @Setter public Boolean npivTemporaryDisabled;
    @Getter @Setter public Boolean npivOnNonRdmDisks;
    @Getter @Setter public String locationId;
    @Getter @Setter public boolean template;
    @Getter @Setter public String guestId;
    @Getter @Setter public String alternateGuestName;
    @Getter @Setter public String annotation;
    @Getter @Setter public VirtualMachineFileInfo files;
    @Getter @Setter public ToolsConfigInfo tools;
    @Getter @Setter public VirtualMachineFlagInfo flags;
    @Getter @Setter public VirtualMachineConsolePreferences consolePreferences;
    @Getter @Setter public VirtualMachineDefaultPowerOpInfo defaultPowerOps;
    @Getter @Setter public Boolean rebootPowerOff;
    @Getter @Setter public VirtualHardware hardware;
    @Getter @Setter public VirtualMachineVcpuConfig[] vcpuConfig;
    @Getter @Setter public ResourceAllocationInfo cpuAllocation;
    @Getter @Setter public ResourceAllocationInfo memoryAllocation;
    @Getter @Setter public LatencySensitivity latencySensitivity;
    @Getter @Setter public Boolean memoryHotAddEnabled;
    @Getter @Setter public Boolean cpuHotAddEnabled;
    @Getter @Setter public Boolean cpuHotRemoveEnabled;
    @Getter @Setter public Long hotPlugMemoryLimit;
    @Getter @Setter public Long hotPlugMemoryIncrementSize;
    @Getter @Setter public VirtualMachineAffinityInfo cpuAffinity;
    @Getter @Setter public VirtualMachineAffinityInfo memoryAffinity;
    @Getter @Setter public VirtualMachineNetworkShaperInfo networkShaper;
    @Getter @Setter public OptionValue[] extraConfig;
    @Getter @Setter public HostCpuIdInfo[] cpuFeatureMask;
    @Getter @Setter public VirtualMachineConfigInfoDatastoreUrlPair[] datastoreUrl;
    @Getter @Setter public String swapPlacement;
    @Getter @Setter public VirtualMachineBootOptions bootOptions;
    @Getter @Setter public FaultToleranceConfigInfo ftInfo;
    @Getter @Setter public ReplicationConfigSpec repConfig;
    @Getter @Setter public VmConfigInfo vAppConfig;
    @Getter @Setter public Boolean vAssertsEnabled;
    @Getter @Setter public Boolean changeTrackingEnabled;
    @Getter @Setter public String firmware;
    @Getter @Setter public Integer maxMksConnections;
    @Getter @Setter public Boolean guestAutoLockEnabled;
    @Getter @Setter public ManagedByInfo managedBy;
    @Getter @Setter public Boolean memoryReservationLockedToMax;
    @Getter @Setter public VirtualMachineConfigInfoOverheadInfo initialOverhead;
    @Getter @Setter public Boolean nestedHVEnabled;
    @Getter @Setter public Boolean vPMCEnabled;
    @Getter @Setter public ScheduledHardwareUpgradeInfo scheduledHardwareUpgradeInfo;
    @Getter @Setter public VirtualMachineForkConfigInfo forkConfigInfo;
    @Getter @Setter public Long vFlashCacheReservation;
    @Getter @Setter public byte[] vmxConfigChecksum;
    @Getter @Setter public Boolean messageBusTunnelEnabled;
    @Getter @Setter public String vmStorageObjectId;
    @Getter @Setter public String swapStorageObjectId;
    @Getter @Setter public CryptoKeyId keyId;
    @Getter @Setter public VirtualMachineGuestIntegrityInfo guestIntegrityInfo;
    @Getter @Setter public String migrateEncryption;
    @Getter @Setter public VirtualMachineSgxInfo sgxInfo;
    @Getter @Setter public VirtualMachineContentLibraryItemInfo contentLibItemInfo;
    @Getter @Setter public String ftEncryptionMode;
    @Getter @Setter public VirtualMachineGuestMonitoringModeInfo guestMonitoringModeInfo;
    @Getter @Setter public Boolean sevEnabled;
    @Getter @Setter public VirtualMachineVirtualNumaInfo numaInfo;
    @Getter @Setter public Boolean pmemFailoverEnabled;
    @Getter @Setter public Boolean vmxStatsCollectionEnabled;
    @Getter @Setter public Boolean vmOpNotificationToAppEnabled;
    @Getter @Setter public Long vmOpNotificationTimeout;
    @Getter @Setter public VirtualMachineVirtualDeviceSwap deviceSwap;
    @Getter @Setter public VirtualMachineVirtualPMem pmem;
    @Getter @Setter public VirtualMachineVirtualDeviceGroups deviceGroups;
    @Getter @Setter public Boolean fixedPassthruHotPlugEnabled;
    @Getter @Setter public Boolean metroFtEnabled;
    @Getter @Setter public OptionValue[] vmxRuntimeConfig;
    @Getter @Setter public String metroFtHostGroup;
    @Getter @Setter public Boolean tdxEnabled;
    @Getter @Setter public Boolean sevSnpEnabled;
}
