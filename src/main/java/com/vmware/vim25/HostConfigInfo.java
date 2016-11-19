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

public class HostConfigInfo extends DynamicData {
    @Getter @Setter public ManagedObjectReference host;
    @Getter @Setter public AboutInfo product;
    @Getter @Setter public HostDeploymentInfo deploymentInfo;
    @Getter @Setter public HostHyperThreadScheduleInfo hyperThread;
    @Getter @Setter public ServiceConsoleReservationInfo consoleReservation;
    @Getter @Setter public VirtualMachineMemoryReservationInfo virtualMachineReservation;
    @Getter @Setter public HostStorageDeviceInfo storageDevice;
    @Getter @Setter public HostMultipathStateInfo multipathState;
    @Getter @Setter public HostFileSystemVolumeInfo fileSystemVolume;
    @Getter @Setter public String[] systemFile;
    @Getter @Setter public HostNetworkInfo network;
    @Getter @Setter public HostVMotionInfo vmotion;
    @Getter @Setter public HostVirtualNicManagerInfo virtualNicManagerInfo;
    @Getter @Setter public HostNetCapabilities capabilities;
    @Getter @Setter public HostDatastoreSystemCapabilities datastoreCapabilities;
    @Getter @Setter public HostNetOffloadCapabilities offloadCapabilities;
    @Getter @Setter public HostServiceInfo service;
    @Getter @Setter public HostFirewallInfo firewall;
    @Getter @Setter public HostAutoStartManagerConfig autoStart;
    @Getter @Setter public HostDiagnosticPartition activeDiagnosticPartition;
    @Getter @Setter public OptionValue[] option;
    @Getter @Setter public OptionDef[] optionDef;
    @Getter @Setter public String datastorePrincipal;
    @Getter @Setter public ManagedObjectReference localSwapDatastore;
    @Getter @Setter public HostSystemSwapConfiguration systemSwapConfiguration;
    @Getter @Setter public HostSystemResourceInfo systemResources;
    @Getter @Setter public HostDateTimeInfo dateTimeInfo;
    @Getter @Setter public HostFlagInfo flags;
    @Getter @Setter public Boolean adminDisabled;
    @Getter @Setter public HostLockdownMode lockdownMode;
    @Getter @Setter public HostIpmiInfo ipmi;
    @Getter @Setter public HostSslThumbprintInfo sslThumbprintInfo;
    @Getter @Setter public HostSslThumbprintInfo[] sslThumbprintData;
    @Getter @Setter public byte[] certificate;
    @Getter @Setter public HostPciPassthruInfo[] pciPassthruInfo;
    @Getter @Setter public HostAuthenticationManagerInfo authenticationManagerInfo;
    @Getter @Setter public HostFeatureVersionInfo[] featureVersion;
    @Getter @Setter public PowerSystemCapability powerSystemCapability;
    @Getter @Setter public PowerSystemInfo powerSystemInfo;
    @Getter @Setter public HostCacheConfigurationInfo[] cacheConfigurationInfo;
    @Getter @Setter public Boolean wakeOnLanCapable;
    @Getter @Setter public HostFeatureCapability[] featureCapability;
    @Getter @Setter public HostFeatureCapability[] maskedFeatureCapability;
    @Getter @Setter public HostVFlashManagerVFlashConfigInfo vFlashConfigInfo;
    @Getter @Setter public VsanHostConfigInfo vsanHostConfig;
    @Getter @Setter public String[] domainList;
    @Getter @Setter public byte[] scriptCheckSum;
    @Getter @Setter public byte[] hostConfigCheckSum;
    @Getter @Setter public HostGraphicsInfo[] graphicsInfo;
    @Getter @Setter public String[] sharedPassthruGpuTypes;
    @Getter @Setter public HostGraphicsConfig graphicsConfig;
    @Getter @Setter public HostIoFilterInfo[] ioFilterInfo;
    @Getter @Setter public HostSriovDevicePoolInfo[] sriovDevicePool;
}
