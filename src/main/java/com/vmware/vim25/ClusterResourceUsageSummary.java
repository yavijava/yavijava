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
public class ClusterResourceUsageSummary extends DynamicData {

    public int cpuCapacityMHz;
    public int cpuUsedMHz;
    public int memCapacityMB;
    public int memUsedMB;
    public long storageCapacityMB;
    public long storageUsedMB;

    public int getCpuCapacityMHz() {
        return cpuCapacityMHz;
    }

    public void setCpuCapacityMHz(int cpuCapacityMHz) {
        this.cpuCapacityMHz = cpuCapacityMHz;
    }

    public int getCpuUsedMHz() {
        return cpuUsedMHz;
    }

    public void setCpuUsedMHz(int cpuUsedMHz) {
        this.cpuUsedMHz = cpuUsedMHz;
    }

    public int getMemCapacityMB() {
        return memCapacityMB;
    }

    public void setMemCapacityMB(int memCapacityMB) {
        this.memCapacityMB = memCapacityMB;
    }

    public int getMemUsedMB() {
        return memUsedMB;
    }

    public void setMemUsedMB(int memUsedMB) {
        this.memUsedMB = memUsedMB;
    }

    public long getStorageCapacityMB() {
        return storageCapacityMB;
    }

    public void setStorageCapacityMB(long storageCapacityMB) {
        this.storageCapacityMB = storageCapacityMB;
    }

    public long getStorageUsedMB() {
        return storageUsedMB;
    }

    public void setStorageUsedMB(long storageUsedMB) {
        this.storageUsedMB = storageUsedMB;
    }
}
