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

public class GuestOsDescriptor extends DynamicData {
    @Getter @Setter public String id;
    @Getter @Setter public String family;
    @Getter @Setter public String fullName;
    @Getter @Setter public int supportedMaxCPUs;
    @Getter @Setter public Integer numSupportedPhysicalSockets;
    @Getter @Setter public Integer numSupportedCoresPerSocket;
    @Getter @Setter public int supportedMinMemMB;
    @Getter @Setter public int supportedMaxMemMB;
    @Getter @Setter public int recommendedMemMB;
    @Getter @Setter public int recommendedColorDepth;
    @Getter @Setter public String[] supportedDiskControllerList;
    @Getter @Setter public String recommendedSCSIController;
    @Getter @Setter public String recommendedDiskController;
    @Getter @Setter public int supportedNumDisks;
    @Getter @Setter public int recommendedDiskSizeMB;
    @Getter @Setter public String recommendedCdromController;
    @Getter @Setter public String[] supportedEthernetCard;
    @Getter @Setter public String recommendedEthernetCard;
    @Getter @Setter public Boolean supportsSlaveDisk;
    @Getter @Setter public HostCpuIdInfo[] cpuFeatureMask;
    @Getter @Setter public Boolean smcRequired;
    @Getter @Setter public boolean supportsWakeOnLan;
    @Getter @Setter public Boolean supportsVMI;
    @Getter @Setter public Boolean supportsMemoryHotAdd;
    @Getter @Setter public Boolean supportsCpuHotAdd;
    @Getter @Setter public Boolean supportsCpuHotRemove;
    @Getter @Setter public String[] supportedFirmware;
    @Getter @Setter public String recommendedFirmware;
    @Getter @Setter public String[] supportedUSBControllerList;
    @Getter @Setter public String recommendedUSBController;
    @Getter @Setter public Boolean supports3D;
    @Getter @Setter public Boolean recommended3D;
    @Getter @Setter public Boolean smcRecommended;
    @Getter @Setter public Boolean ich7mRecommended;
    @Getter @Setter public Boolean usbRecommended;
    @Getter @Setter public String supportLevel;
    @Getter @Setter public Boolean supportedForCreate;
    @Getter @Setter public IntOption vRAMSizeInKB;
    @Getter @Setter public Integer numSupportedFloppyDevices;
    @Getter @Setter public String[] wakeOnLanEthernetCard;
    @Getter @Setter public Boolean supportsPvscsiControllerForBoot;
    @Getter @Setter public Boolean diskUuidEnabled;
    @Getter @Setter public Boolean supportsHotPlugPCI;
    @Getter @Setter public Boolean supportsSecureBoot;
    @Getter @Setter public Boolean defaultSecureBoot;
}
