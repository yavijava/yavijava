package com.vmware.vim25;

/**
 * Created by Michael Rice on Thu May 21 01:07:55 CDT 2015
 * <p>
 * Copyright 2015 Michael Rice
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @since 6.0
 */

public class InsufficientNetworkResourcePoolCapacity extends InsufficientResourcesFault {
    public String dvsName;

    public String dvsUuid;

    public String resourcePoolKey;

    public long available;

    public long requested;

    public String[] device;

    public String getDvsName() {
        return dvsName;
    }

    public void setDvsName(String dvsName) {
        this.dvsName = dvsName;
    }

    public String getDvsUuid() {
        return dvsUuid;
    }

    public void setDvsUuid(String dvsUuid) {
        this.dvsUuid = dvsUuid;
    }

    public String getResourcePoolKey() {
        return resourcePoolKey;
    }

    public void setResourcePoolKey(String resourcePoolKey) {
        this.resourcePoolKey = resourcePoolKey;
    }

    public long getAvailable() {
        return available;
    }

    public void setAvailable(long available) {
        this.available = available;
    }

    public long getRequested() {
        return requested;
    }

    public void setRequested(long requested) {
        this.requested = requested;
    }

    public String[] getDevice() {
        return device;
    }

    public void setDevice(String[] device) {
        this.device = device;
    }

}
