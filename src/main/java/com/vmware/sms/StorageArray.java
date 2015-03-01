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
public class StorageArray extends DynamicData {

    public String[] alternateName;
    public String firmware;
    public String modelId;
    public String name;
    public int priority;
    public String[] supportedBlockInterface;
    public String[] supportedFileSystemInterface;
    public String uuid;
    public String vendorId;

    public String[] getAlternateName() {
        return alternateName;
    }

    public void setAlternateName(String[] alternateName) {
        this.alternateName = alternateName;
    }

    public String getFirmware() {
        return firmware;
    }

    public void setFirmware(String firmware) {
        this.firmware = firmware;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String[] getSupportedBlockInterface() {
        return supportedBlockInterface;
    }

    public void setSupportedBlockInterface(String[] supportedBlockInterface) {
        this.supportedBlockInterface = supportedBlockInterface;
    }

    public String[] getSupportedFileSystemInterface() {
        return supportedFileSystemInterface;
    }

    public void setSupportedFileSystemInterface(String[] supportedFileSystemInterface) {
        this.supportedFileSystemInterface = supportedFileSystemInterface;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }
}
