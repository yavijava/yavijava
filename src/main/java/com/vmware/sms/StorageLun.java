package com.vmware.sms;

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
public class StorageLun extends DynamicData {

    public String[] alternateIdentifier;
    public long capacityInMB;
    public boolean drsManagementPermitted;
    public boolean lunThinProvisioned;
    public String thinProvisioningStatus;
    public long usedSpaceInMB;
    public String uuid;
    public String vendorDisplayName;
    public String vSphereLunIdentifier;

    public String[] getAlternateIdentifier() {
        return alternateIdentifier;
    }

    public void setAlternateIdentifier(String[] alternateIdentifier) {
        this.alternateIdentifier = alternateIdentifier;
    }

    public long getCapacityInMB() {
        return capacityInMB;
    }

    public void setCapacityInMB(long capacityInMB) {
        this.capacityInMB = capacityInMB;
    }

    public boolean isDrsManagementPermitted() {
        return drsManagementPermitted;
    }

    public void setDrsManagementPermitted(boolean drsManagementPermitted) {
        this.drsManagementPermitted = drsManagementPermitted;
    }

    public boolean isLunThinProvisioned() {
        return lunThinProvisioned;
    }

    public void setLunThinProvisioned(boolean lunThinProvisioned) {
        this.lunThinProvisioned = lunThinProvisioned;
    }

    public String getThinProvisioningStatus() {
        return thinProvisioningStatus;
    }

    public void setThinProvisioningStatus(String thinProvisioningStatus) {
        this.thinProvisioningStatus = thinProvisioningStatus;
    }

    public long getUsedSpaceInMB() {
        return usedSpaceInMB;
    }

    public void setUsedSpaceInMB(long usedSpaceInMB) {
        this.usedSpaceInMB = usedSpaceInMB;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getVendorDisplayName() {
        return vendorDisplayName;
    }

    public void setVendorDisplayName(String vendorDisplayName) {
        this.vendorDisplayName = vendorDisplayName;
    }

    public String getvSphereLunIdentifier() {
        return vSphereLunIdentifier;
    }

    public void setvSphereLunIdentifier(String vSphereLunIdentifier) {
        this.vSphereLunIdentifier = vSphereLunIdentifier;
    }
}
