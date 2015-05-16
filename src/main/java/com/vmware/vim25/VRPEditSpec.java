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
public class VRPEditSpec extends DynamicData {

    public ManagedObjectReference[] addedHubs;
    public long changeVersion;
    public VrpResourceAllocationInfo cpuAllocation;
    public String description;
    public VrpResourceAllocationInfo memoryAllocation;
    public ManagedObjectReference[] removedHubs;
    public String vrpId;

    public ManagedObjectReference[] getAddedHubs() {
        return addedHubs;
    }

    public void setAddedHubs(ManagedObjectReference[] addedHubs) {
        this.addedHubs = addedHubs;
    }

    public long getChangeVersion() {
        return changeVersion;
    }

    public void setChangeVersion(long changeVersion) {
        this.changeVersion = changeVersion;
    }

    public VrpResourceAllocationInfo getCpuAllocation() {
        return cpuAllocation;
    }

    public void setCpuAllocation(VrpResourceAllocationInfo cpuAllocation) {
        this.cpuAllocation = cpuAllocation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public VrpResourceAllocationInfo getMemoryAllocation() {
        return memoryAllocation;
    }

    public void setMemoryAllocation(VrpResourceAllocationInfo memoryAllocation) {
        this.memoryAllocation = memoryAllocation;
    }

    public ManagedObjectReference[] getRemovedHubs() {
        return removedHubs;
    }

    public void setRemovedHubs(ManagedObjectReference[] removedHubs) {
        this.removedHubs = removedHubs;
    }

    public String getVrpId() {
        return vrpId;
    }

    public void setVrpId(String vrpId) {
        this.vrpId = vrpId;
    }
}
