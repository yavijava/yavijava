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

/**
 * @since 6.0
 */
public class ClusterEVCManagerEVCState extends DynamicData {

    public String currentEVCModeKey;
    public HostFeatureCapability[] featureCapability;
    public HostFeatureMask[] featureMask;
    public VirtualMachineFeatureRequirement[] featureRequirement;
    public HostCpuIdInfo[] guaranteedCPUFeatures;
    public EVCMode[] supportedEVCMode;

    public String getCurrentEVCModeKey() {
        return currentEVCModeKey;
    }

    public void setCurrentEVCModeKey(String currentEVCModeKey) {
        this.currentEVCModeKey = currentEVCModeKey;
    }

    public HostFeatureCapability[] getFeatureCapability() {
        return featureCapability;
    }

    public void setFeatureCapability(HostFeatureCapability[] featureCapability) {
        this.featureCapability = featureCapability;
    }

    public HostFeatureMask[] getFeatureMask() {
        return featureMask;
    }

    public void setFeatureMask(HostFeatureMask[] featureMask) {
        this.featureMask = featureMask;
    }

    public VirtualMachineFeatureRequirement[] getFeatureRequirement() {
        return featureRequirement;
    }

    public void setFeatureRequirement(VirtualMachineFeatureRequirement[] featureRequirement) {
        this.featureRequirement = featureRequirement;
    }

    public HostCpuIdInfo[] getGuaranteedCPUFeatures() {
        return guaranteedCPUFeatures;
    }

    public void setGuaranteedCPUFeatures(HostCpuIdInfo[] guaranteedCPUFeatures) {
        this.guaranteedCPUFeatures = guaranteedCPUFeatures;
    }

    public EVCMode[] getSupportedEVCMode() {
        return supportedEVCMode;
    }

    public void setSupportedEVCMode(EVCMode[] supportedEVCMode) {
        this.supportedEVCMode = supportedEVCMode;
    }
}
