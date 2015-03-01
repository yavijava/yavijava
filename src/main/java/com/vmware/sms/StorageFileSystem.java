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
public class StorageFileSystem extends DynamicData {

    public StorageFileSystemInfo[] info;
    public boolean nativeSnapshotSupported;
    public String thinProvisioningStatus;
    public String type;
    public String uuid;
    public String version;

    public StorageFileSystemInfo[] getInfo() {
        return info;
    }

    public void setInfo(StorageFileSystemInfo[] info) {
        this.info = info;
    }

    public boolean isNativeSnapshotSupported() {
        return nativeSnapshotSupported;
    }

    public void setNativeSnapshotSupported(boolean nativeSnapshotSupported) {
        this.nativeSnapshotSupported = nativeSnapshotSupported;
    }

    public String getThinProvisioningStatus() {
        return thinProvisioningStatus;
    }

    public void setThinProvisioningStatus(String thinProvisioningStatus) {
        this.thinProvisioningStatus = thinProvisioningStatus;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
