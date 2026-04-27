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

public class GuestInfo extends DynamicData {
    @Getter @Setter public VirtualMachineToolsStatus toolsStatus;
    @Getter @Setter public String toolsVersionStatus;
    @Getter @Setter public String toolsVersionStatus2;
    @Getter @Setter public String toolsRunningStatus;
    @Getter @Setter public String toolsVersion;
    @Getter @Setter public String toolsInstallType;
    @Getter @Setter public String guestId;
    @Getter @Setter public String guestFamily;
    @Getter @Setter public String guestFullName;
    @Getter @Setter public String guestDetailedData;
    @Getter @Setter public String hostName;
    @Getter @Setter public String ipAddress;
    @Getter @Setter public GuestNicInfo[] net;
    @Getter @Setter public GuestStackInfo[] ipStack;
    @Getter @Setter public GuestDiskInfo[] disk;
    @Getter @Setter public GuestScreenInfo screen;
    @Getter @Setter public String guestState;
    @Getter @Setter public String appHeartbeatStatus;
    @Getter @Setter public Boolean guestKernelCrashed;
    @Getter @Setter public String appState;
    @Getter @Setter public Boolean guestOperationsReady;
    @Getter @Setter public Boolean interactiveGuestOperationsReady;
    @Getter @Setter public Boolean guestStateChangeSupported;
    @Getter @Setter public GuestInfoNamespaceGenerationInfo[] generationInfo;
    @Getter @Setter public String hwVersion;
    @Getter @Setter public GuestInfoCustomizationInfo customizationInfo;
}
