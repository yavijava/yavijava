package com.vmware.vim25;

/**
 * Copyright 2015 Michael Rice <michael@michaelrice.org>
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class VirtualResourcePoolUsage extends DynamicData {

    public long cpuReservationMhz;
    public long cpuReservationUsedMhz;
    public long memReservationMB;
    public long memReservationUsedMB;
    public String vrpId;

    public long getCpuReservationMhz() {
        return cpuReservationMhz;
    }

    public void setCpuReservationMhz(long cpuReservationMhz) {
        this.cpuReservationMhz = cpuReservationMhz;
    }

    public long getCpuReservationUsedMhz() {
        return cpuReservationUsedMhz;
    }

    public void setCpuReservationUsedMhz(long cpuReservationUsedMhz) {
        this.cpuReservationUsedMhz = cpuReservationUsedMhz;
    }

    public long getMemReservationMB() {
        return memReservationMB;
    }

    public void setMemReservationMB(long memReservationMB) {
        this.memReservationMB = memReservationMB;
    }

    public long getMemReservationUsedMB() {
        return memReservationUsedMB;
    }

    public void setMemReservationUsedMB(long memReservationUsedMB) {
        this.memReservationUsedMB = memReservationUsedMB;
    }

    public String getVrpId() {
        return vrpId;
    }

    public void setVrpId(String vrpId) {
        this.vrpId = vrpId;
    }
}
