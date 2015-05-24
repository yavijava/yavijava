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

public class ClusterVmComponentProtectionSettings extends DynamicData {
    public String vmStorageProtectionForAPD;

    public Boolean enableAPDTimeoutForHosts;

    public int vmTerminateDelayForAPDSec;

    public String vmReactionOnAPDCleared;

    public String vmStorageProtectionForPDL;

    public String getVmStorageProtectionForAPD() {
        return vmStorageProtectionForAPD;
    }

    public void setVmStorageProtectionForAPD(String vmStorageProtectionForAPD) {
        this.vmStorageProtectionForAPD = vmStorageProtectionForAPD;
    }

    public Boolean getEnableAPDTimeoutForHosts() {
        return enableAPDTimeoutForHosts;
    }

    public void setEnableAPDTimeoutForHosts(Boolean enableAPDTimeoutForHosts) {
        this.enableAPDTimeoutForHosts = enableAPDTimeoutForHosts;
    }

    public int getVmTerminateDelayForAPDSec() {
        return vmTerminateDelayForAPDSec;
    }

    public void setVmTerminateDelayForAPDSec(int vmTerminateDelayForAPDSec) {
        this.vmTerminateDelayForAPDSec = vmTerminateDelayForAPDSec;
    }

    public String getVmReactionOnAPDCleared() {
        return vmReactionOnAPDCleared;
    }

    public void setVmReactionOnAPDCleared(String vmReactionOnAPDCleared) {
        this.vmReactionOnAPDCleared = vmReactionOnAPDCleared;
    }

    public String getVmStorageProtectionForPDL() {
        return vmStorageProtectionForPDL;
    }

    public void setVmStorageProtectionForPDL(String vmStorageProtectionForPDL) {
        this.vmStorageProtectionForPDL = vmStorageProtectionForPDL;
    }

}
