package com.vmware.vim25;

/**
 * Created by Michael Rice on Wed May 20 23:39:36 CDT 2015
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

public class PlacementRankResult extends DynamicData {
    public String key;

    public ManagedObjectReference candidate;

    public long reservedSpaceMB;

    public long usedSpaceMB;

    public long totalSpaceMB;

    public double utilization;

    public LocalizedMethodFault[] faults;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ManagedObjectReference getCandidate() {
        return candidate;
    }

    public void setCandidate(ManagedObjectReference candidate) {
        this.candidate = candidate;
    }

    public long getReservedSpaceMB() {
        return reservedSpaceMB;
    }

    public void setReservedSpaceMB(long reservedSpaceMB) {
        this.reservedSpaceMB = reservedSpaceMB;
    }

    public long getUsedSpaceMB() {
        return usedSpaceMB;
    }

    public void setUsedSpaceMB(long usedSpaceMB) {
        this.usedSpaceMB = usedSpaceMB;
    }

    public long getTotalSpaceMB() {
        return totalSpaceMB;
    }

    public void setTotalSpaceMB(long totalSpaceMB) {
        this.totalSpaceMB = totalSpaceMB;
    }

    public double getUtilization() {
        return utilization;
    }

    public void setUtilization(double utilization) {
        this.utilization = utilization;
    }

    public LocalizedMethodFault[] getFaults() {
        return faults;
    }

    public void setFaults(LocalizedMethodFault[] faults) {
        this.faults = faults;
    }

}
