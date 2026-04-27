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

public class HostConfigManager extends DynamicData {
    @Getter @Setter public ManagedObjectReference cpuScheduler;
    @Getter @Setter public ManagedObjectReference datastoreSystem;
    @Getter @Setter public ManagedObjectReference memoryManager;
    @Getter @Setter public ManagedObjectReference storageSystem;
    @Getter @Setter public ManagedObjectReference networkSystem;
    @Getter @Setter public ManagedObjectReference vmotionSystem;
    @Getter @Setter public ManagedObjectReference virtualNicManager;
    @Getter @Setter public ManagedObjectReference serviceSystem;
    @Getter @Setter public ManagedObjectReference firewallSystem;
    @Getter @Setter public ManagedObjectReference advancedOption;
    @Getter @Setter public ManagedObjectReference diagnosticSystem;
    @Getter @Setter public ManagedObjectReference autoStartManager;
    @Getter @Setter public ManagedObjectReference snmpSystem;
    @Getter @Setter public ManagedObjectReference dateTimeSystem;
    @Getter @Setter public ManagedObjectReference patchManager;
    @Getter @Setter public ManagedObjectReference imageConfigManager;
    @Getter @Setter public ManagedObjectReference bootDeviceSystem;
    @Getter @Setter public ManagedObjectReference firmwareSystem;
    @Getter @Setter public ManagedObjectReference healthStatusSystem;
    @Getter @Setter public ManagedObjectReference pciPassthruSystem;
    @Getter @Setter public ManagedObjectReference licenseManager;
    @Getter @Setter public ManagedObjectReference kernelModuleSystem;
    @Getter @Setter public ManagedObjectReference authenticationManager;
    @Getter @Setter public ManagedObjectReference powerSystem;
    @Getter @Setter public ManagedObjectReference cacheConfigurationManager;
    @Getter @Setter public ManagedObjectReference esxAgentHostManager;
    @Getter @Setter public ManagedObjectReference iscsiManager;
    @Getter @Setter public ManagedObjectReference vFlashManager;
    @Getter @Setter public ManagedObjectReference vsanSystem;
    @Getter @Setter public ManagedObjectReference messageBusProxy;
    @Getter @Setter public ManagedObjectReference userDirectory;
    @Getter @Setter public ManagedObjectReference accountManager;
    @Getter @Setter public ManagedObjectReference hostAccessManager;
    @Getter @Setter public ManagedObjectReference graphicsManager;
    @Getter @Setter public ManagedObjectReference vsanInternalSystem;
    @Getter @Setter public ManagedObjectReference certificateManager;
    @Getter @Setter public ManagedObjectReference cryptoManager;
    @Getter @Setter public ManagedObjectReference nvdimmSystem;
    @Getter @Setter public ManagedObjectReference assignableHardwareManager;
}
