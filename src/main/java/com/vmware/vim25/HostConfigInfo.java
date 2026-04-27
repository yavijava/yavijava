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

public class HostConfigInfo extends DynamicData {
    @Getter @Setter public ManagedObjectReference host;
    @Getter @Setter public AboutInfo product;
    @Getter @Setter public HostDeploymentInfo deploymentInfo;
    @Getter @Setter public HostHyperThreadScheduleInfo hyperThread;
    @Getter @Setter public HostCpuSchedulerInfo cpuScheduler;
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
    @Getter @Setter public HostAuthenticationInfo[] authenticationData;
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
    @Getter @Setter public byte[] descriptionTreeCheckSum;
    @Getter @Setter public HostGraphicsInfo[] graphicsInfo;
    @Getter @Setter public String[] sharedPassthruGpuTypes;
    @Getter @Setter public HostGraphicsConfig graphicsConfig;
    @Getter @Setter public HostSharedGpuCapabilities[] sharedGpuCapabilities;
    @Getter @Setter public HostIoFilterInfo[] ioFilterInfo;
    @Getter @Setter public HostSriovDevicePoolInfo[] sriovDevicePool;
    @Getter @Setter public HostAssignableHardwareBinding[] assignableHardwareBinding;
    @Getter @Setter public HostAssignableHardwareConfig assignableHardwareConfig;
}
