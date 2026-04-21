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

public class ServiceContent extends DynamicData {
    @Getter @Setter public ManagedObjectReference rootFolder;
    @Getter @Setter public ManagedObjectReference propertyCollector;
    @Getter @Setter public ManagedObjectReference viewManager;
    @Getter @Setter public AboutInfo about;
    @Getter @Setter public ManagedObjectReference setting;
    @Getter @Setter public ManagedObjectReference userDirectory;
    @Getter @Setter public ManagedObjectReference sessionManager;
    @Getter @Setter public ManagedObjectReference authorizationManager;
    @Getter @Setter public ManagedObjectReference serviceManager;
    @Getter @Setter public ManagedObjectReference perfManager;
    @Getter @Setter public ManagedObjectReference scheduledTaskManager;
    @Getter @Setter public ManagedObjectReference alarmManager;
    @Getter @Setter public ManagedObjectReference eventManager;
    @Getter @Setter public ManagedObjectReference taskManager;
    @Getter @Setter public ManagedObjectReference extensionManager;
    @Getter @Setter public ManagedObjectReference customizationSpecManager;
    @Getter @Setter public ManagedObjectReference customFieldsManager;
    @Getter @Setter public ManagedObjectReference accountManager;
    @Getter @Setter public ManagedObjectReference diagnosticManager;
    @Getter @Setter public ManagedObjectReference licenseManager;
    @Getter @Setter public ManagedObjectReference searchIndex;
    @Getter @Setter public ManagedObjectReference fileManager;
    @Getter @Setter public ManagedObjectReference datastoreNamespaceManager;
    @Getter @Setter public ManagedObjectReference virtualDiskManager;
    @Getter @Setter public ManagedObjectReference virtualizationManager;
    @Getter @Setter public ManagedObjectReference snmpSystem;
    @Getter @Setter public ManagedObjectReference vmProvisioningChecker;
    @Getter @Setter public ManagedObjectReference vmCompatibilityChecker;
    @Getter @Setter public ManagedObjectReference ovfManager;
    @Getter @Setter public ManagedObjectReference ipPoolManager;
    @Getter @Setter public ManagedObjectReference dvSwitchManager;
    @Getter @Setter public ManagedObjectReference hostProfileManager;
    @Getter @Setter public ManagedObjectReference clusterProfileManager;
    @Getter @Setter public ManagedObjectReference complianceManager;
    @Getter @Setter public ManagedObjectReference localizationManager;
    @Getter @Setter public ManagedObjectReference storageResourceManager;
    @Getter @Setter public ManagedObjectReference guestOperationsManager;
    @Getter @Setter public ManagedObjectReference overheadMemoryManager;
    @Getter @Setter public ManagedObjectReference certificateManager;
    @Getter @Setter public ManagedObjectReference ioFilterManager;
    @Getter @Setter public ManagedObjectReference vStorageObjectManager;
    @Getter @Setter public ManagedObjectReference hostSpecManager;
    @Getter @Setter public ManagedObjectReference cryptoManager;
    @Getter @Setter public ManagedObjectReference healthUpdateManager;
    @Getter @Setter public ManagedObjectReference failoverClusterConfigurator;
    @Getter @Setter public ManagedObjectReference failoverClusterManager;
}
