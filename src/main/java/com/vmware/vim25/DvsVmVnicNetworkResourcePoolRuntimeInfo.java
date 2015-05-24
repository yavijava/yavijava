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

public class DvsVmVnicNetworkResourcePoolRuntimeInfo extends DynamicData {
    public String key;

    public String name;

    public int capacity;

    public int usage;

    public int available;

    public String status;

    public DvsVnicAllocatedResource[] allocatedResource;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getUsage() {
        return usage;
    }

    public void setUsage(int usage) {
        this.usage = usage;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DvsVnicAllocatedResource[] getAllocatedResource() {
        return allocatedResource;
    }

    public void setAllocatedResource(DvsVnicAllocatedResource[] allocatedResource) {
        this.allocatedResource = allocatedResource;
    }

}
