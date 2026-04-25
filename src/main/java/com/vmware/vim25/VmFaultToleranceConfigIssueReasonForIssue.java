package com.vmware.vim25;

/**
 * Created by Michael Rice on Fri Apr 24 22:47:38 CDT 2026
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

public enum VmFaultToleranceConfigIssueReasonForIssue {

    haNotEnabled("haNotEnabled"),
    moreThanOneSecondary("moreThanOneSecondary"),
    recordReplayNotSupported("recordReplayNotSupported"),
    replayNotSupported("replayNotSupported"),
    templateVm("templateVm"),
    multipleVCPU("multipleVCPU"),
    hostInactive("hostInactive"),
    ftUnsupportedHardware("ftUnsupportedHardware"),
    ftUnsupportedProduct("ftUnsupportedProduct"),
    missingVMotionNic("missingVMotionNic"),
    missingFTLoggingNic("missingFTLoggingNic"),
    thinDisk("thinDisk"),
    verifySSLCertificateFlagNotSet("verifySSLCertificateFlagNotSet"),
    hasSnapshots("hasSnapshots"),
    noConfig("noConfig"),
    ftSecondaryVm("ftSecondaryVm"),
    hasLocalDisk("hasLocalDisk"),
    esxAgentVm("esxAgentVm"),
    video3dEnabled("video3dEnabled"),
    hasUnsupportedDisk("hasUnsupportedDisk"),
    insufficientBandwidth("insufficientBandwidth"),
    hasNestedHVConfiguration("hasNestedHVConfiguration"),
    hasVFlashConfiguration("hasVFlashConfiguration"),
    unsupportedProduct("unsupportedProduct"),
    cpuHvUnsupported("cpuHvUnsupported"),
    cpuHwmmuUnsupported("cpuHwmmuUnsupported"),
    cpuHvDisabled("cpuHvDisabled"),
    hasEFIFirmware("hasEFIFirmware"),
    tooManyVCPUs("tooManyVCPUs"),
    tooMuchMemory("tooMuchMemory"),
    vMotionNotLicensed("vMotionNotLicensed"),
    ftNotLicensed("ftNotLicensed"),
    haAgentIssue("haAgentIssue"),
    unsupportedSPBM("unsupportedSPBM"),
    hasLinkedCloneDisk("hasLinkedCloneDisk"),
    unsupportedPMemHAFailOver("unsupportedPMemHAFailOver"),
    unsupportedEncryptedDisk("unsupportedEncryptedDisk"),
    ftMetroClusterNotEditable("ftMetroClusterNotEditable"),
    noHostGroupConfigured("noHostGroupConfigured");

    private String val;

    VmFaultToleranceConfigIssueReasonForIssue(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return this.val;
    }
}
