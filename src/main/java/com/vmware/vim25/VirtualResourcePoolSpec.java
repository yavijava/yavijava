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
public class VirtualResourcePoolSpec extends DynamicData {

    public long changeVersion;
    public VrpResourceAllocationInfo cpuAllocation;
    public String description;
    public ManagedObjectReference[] hubList;
    public VrpResourceAllocationInfo memoryAllocation;
    public Boolean rootVRP;
    public ManagedObjectReference[] rpList;
    public Boolean staticVRP;
    public String vrpId;
    public String vrpName;

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

    public ManagedObjectReference[] getHubList() {
        return hubList;
    }

    public void setHubList(ManagedObjectReference[] hubList) {
        this.hubList = hubList;
    }

    public VrpResourceAllocationInfo getMemoryAllocation() {
        return memoryAllocation;
    }

    public void setMemoryAllocation(VrpResourceAllocationInfo memoryAllocation) {
        this.memoryAllocation = memoryAllocation;
    }

    public Boolean getRootVRP() {
        return rootVRP;
    }

    public void setRootVRP(Boolean rootVRP) {
        this.rootVRP = rootVRP;
    }

    public ManagedObjectReference[] getRpList() {
        return rpList;
    }

    public void setRpList(ManagedObjectReference[] rpList) {
        this.rpList = rpList;
    }

    public Boolean getStaticVRP() {
        return staticVRP;
    }

    public void setStaticVRP(Boolean staticVRP) {
        this.staticVRP = staticVRP;
    }

    public String getVrpId() {
        return vrpId;
    }

    public void setVrpId(String vrpId) {
        this.vrpId = vrpId;
    }

    public String getVrpName() {
        return vrpName;
    }

    public void setVrpName(String vrpName) {
        this.vrpName = vrpName;
    }
}
