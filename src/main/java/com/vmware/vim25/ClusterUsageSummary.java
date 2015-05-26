package com.vmware.vim25;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Michael Rice on Sun May 24 16:15:34 CDT 2015
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

public class ClusterUsageSummary extends DynamicData {
    @Getter @Setter public int totalCpuCapacityMhz;
    @Getter @Setter public int totalMemCapacityMB;
    @Getter @Setter public int cpuReservationMhz;
    @Getter @Setter public int memReservationMB;
    @Getter @Setter public Integer poweredOffCpuReservationMhz;
    @Getter @Setter public Integer poweredOffMemReservationMB;
    @Getter @Setter public int cpuDemandMhz;
    @Getter @Setter public int memDemandMB;
    @Getter @Setter public long statsGenNumber;
    @Getter @Setter public int cpuEntitledMhz;
    @Getter @Setter public int memEntitledMB;
    @Getter @Setter public int poweredOffVmCount;
    @Getter @Setter public int totalVmCount;
}
