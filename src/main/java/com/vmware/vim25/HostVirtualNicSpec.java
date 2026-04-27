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

public class HostVirtualNicSpec extends DynamicData {
    @Getter @Setter public HostIpConfig ip;
    @Getter @Setter public String mac;
    @Getter @Setter public DistributedVirtualSwitchPortConnection distributedVirtualPort;
    @Getter @Setter public String portgroup;
    @Getter @Setter public Integer mtu;
    @Getter @Setter public Boolean tsoEnabled;
    @Getter @Setter public String netStackInstanceKey;
    @Getter @Setter public HostVirtualNicOpaqueNetworkSpec opaqueNetwork;
    @Getter @Setter public String externalId;
    @Getter @Setter public String pinnedPnic;
    @Getter @Setter public HostVirtualNicIpRouteSpec ipRouteSpec;
    @Getter @Setter public Boolean systemOwned;
    @Getter @Setter public String dpuId;
}
