package com.vmware.vim25;

/**
 * Created by Michael Rice on Wed May 20 23:39:35 CDT 2015
 * <p/>
 * Copyright 2015 Michael Rice
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
 *
 * @since 6.0
 */

public class ClusterUsageSummary extends DynamicData {
    public int totalCpuCapacityMhz;

    public int totalMemCapacityMB;

    public int cpuReservationMhz;

    public int memReservationMB;

    public int poweredOffCpuReservationMhz;

    public int poweredOffMemReservationMB;

    public int cpuDemandMhz;

    public int memDemandMB;

    public long statsGenNumber;

    public int cpuEntitledMhz;

    public int memEntitledMB;

    public int poweredOffVmCount;

    public int totalVmCount;

    public int getTotalCpuCapacityMhz() {
        return totalCpuCapacityMhz;
    }

    public void setTotalCpuCapacityMhz(int totalCpuCapacityMhz) {
        this.totalCpuCapacityMhz = totalCpuCapacityMhz;
    }

    public int getTotalMemCapacityMB() {
        return totalMemCapacityMB;
    }

    public void setTotalMemCapacityMB(int totalMemCapacityMB) {
        this.totalMemCapacityMB = totalMemCapacityMB;
    }

    public int getCpuReservationMhz() {
        return cpuReservationMhz;
    }

    public void setCpuReservationMhz(int cpuReservationMhz) {
        this.cpuReservationMhz = cpuReservationMhz;
    }

    public int getMemReservationMB() {
        return memReservationMB;
    }

    public void setMemReservationMB(int memReservationMB) {
        this.memReservationMB = memReservationMB;
    }

    public int getPoweredOffCpuReservationMhz() {
        return poweredOffCpuReservationMhz;
    }

    public void setPoweredOffCpuReservationMhz(int poweredOffCpuReservationMhz) {
        this.poweredOffCpuReservationMhz = poweredOffCpuReservationMhz;
    }

    public int getPoweredOffMemReservationMB() {
        return poweredOffMemReservationMB;
    }

    public void setPoweredOffMemReservationMB(int poweredOffMemReservationMB) {
        this.poweredOffMemReservationMB = poweredOffMemReservationMB;
    }

    public int getCpuDemandMhz() {
        return cpuDemandMhz;
    }

    public void setCpuDemandMhz(int cpuDemandMhz) {
        this.cpuDemandMhz = cpuDemandMhz;
    }

    public int getMemDemandMB() {
        return memDemandMB;
    }

    public void setMemDemandMB(int memDemandMB) {
        this.memDemandMB = memDemandMB;
    }

    public long getStatsGenNumber() {
        return statsGenNumber;
    }

    public void setStatsGenNumber(long statsGenNumber) {
        this.statsGenNumber = statsGenNumber;
    }

    public int getCpuEntitledMhz() {
        return cpuEntitledMhz;
    }

    public void setCpuEntitledMhz(int cpuEntitledMhz) {
        this.cpuEntitledMhz = cpuEntitledMhz;
    }

    public int getMemEntitledMB() {
        return memEntitledMB;
    }

    public void setMemEntitledMB(int memEntitledMB) {
        this.memEntitledMB = memEntitledMB;
    }

    public int getPoweredOffVmCount() {
        return poweredOffVmCount;
    }

    public void setPoweredOffVmCount(int poweredOffVmCount) {
        this.poweredOffVmCount = poweredOffVmCount;
    }

    public int getTotalVmCount() {
        return totalVmCount;
    }

    public void setTotalVmCount(int totalVmCount) {
        this.totalVmCount = totalVmCount;
    }

}
