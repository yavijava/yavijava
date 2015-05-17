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
public class PlacementSpec extends DynamicData {

    public String cloneName;
    public VirtualMachineCloneSpec cloneSpec;
    public VirtualMachineConfigSpec configSpec;
    public ManagedObjectReference[] datastores;
    public Boolean disallowPrerequisiteMoves;
    public ManagedObjectReference[] hosts;
    public String key;
    public String placementType;
    public VirtualMachineMovePriority priority;
    public VirtualMachineRelocateSpec relocateSpec;
    public ClusterRuleInfo[] rules;
    public ManagedObjectReference[] storagePods;
    public ManagedObjectReference vm;

    public String getCloneName() {
        return cloneName;
    }

    public void setCloneName(String cloneName) {
        this.cloneName = cloneName;
    }

    public VirtualMachineCloneSpec getCloneSpec() {
        return cloneSpec;
    }

    public void setCloneSpec(VirtualMachineCloneSpec cloneSpec) {
        this.cloneSpec = cloneSpec;
    }

    public VirtualMachineConfigSpec getConfigSpec() {
        return configSpec;
    }

    public void setConfigSpec(VirtualMachineConfigSpec configSpec) {
        this.configSpec = configSpec;
    }

    public ManagedObjectReference[] getDatastores() {
        return datastores;
    }

    public void setDatastores(ManagedObjectReference[] datastores) {
        this.datastores = datastores;
    }

    public Boolean getDisallowPrerequisiteMoves() {
        return disallowPrerequisiteMoves;
    }

    public void setDisallowPrerequisiteMoves(Boolean disallowPrerequisiteMoves) {
        this.disallowPrerequisiteMoves = disallowPrerequisiteMoves;
    }

    public ManagedObjectReference[] getHosts() {
        return hosts;
    }

    public void setHosts(ManagedObjectReference[] hosts) {
        this.hosts = hosts;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getPlacementType() {
        return placementType;
    }

    public void setPlacementType(String placementType) {
        this.placementType = placementType;
    }

    public VirtualMachineMovePriority getPriority() {
        return priority;
    }

    public void setPriority(VirtualMachineMovePriority priority) {
        this.priority = priority;
    }

    public VirtualMachineRelocateSpec getRelocateSpec() {
        return relocateSpec;
    }

    public void setRelocateSpec(VirtualMachineRelocateSpec relocateSpec) {
        this.relocateSpec = relocateSpec;
    }

    public ClusterRuleInfo[] getRules() {
        return rules;
    }

    public void setRules(ClusterRuleInfo[] rules) {
        this.rules = rules;
    }

    public ManagedObjectReference[] getStoragePods() {
        return storagePods;
    }

    public void setStoragePods(ManagedObjectReference[] storagePods) {
        this.storagePods = storagePods;
    }

    public ManagedObjectReference getVm() {
        return vm;
    }

    public void setVm(ManagedObjectReference vm) {
        this.vm = vm;
    }
}
