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
import java.util.Calendar;

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

public class VirtualMachineConfigInfo extends DynamicData {
    @Getter @Setter public String changeVersion;
    @Getter @Setter public Calendar modified;
    @Getter @Setter public String name;
    @Getter @Setter public String guestFullName;
    @Getter @Setter public String version;
    @Getter @Setter public String uuid;
    @Getter @Setter public String instanceUuid;
    @Getter @Setter public long[] npivNodeWorldWideName;
    @Getter @Setter public long[] npivPortWorldWideName;
    @Getter @Setter public String npivWorldWideNameType;
    @Getter @Setter public short npivDesiredNodeWwns;
    @Getter @Setter public short npivDesiredPortWwns;
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
    @Getter @Setter public VirtualHardware hardware;
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
}
