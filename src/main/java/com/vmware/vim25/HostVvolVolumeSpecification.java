package com.vmware.vim25;

/**
 * Created by Michael Rice on Wed May 20 23:39:36 CDT 2015
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

public class HostVvolVolumeSpecification extends DynamicData {
    public long maxSizeInMB;

    public String volumeName;

    public VimVasaProviderInfo[] vasaProviderInfo;

    public VASAStorageArray[] storageArray;

    public String uuid;

    public long getMaxSizeInMB() {
        return maxSizeInMB;
    }

    public void setMaxSizeInMB(long maxSizeInMB) {
        this.maxSizeInMB = maxSizeInMB;
    }

    public String getVolumeName() {
        return volumeName;
    }

    public void setVolumeName(String volumeName) {
        this.volumeName = volumeName;
    }

    public VimVasaProviderInfo[] getVasaProviderInfo() {
        return vasaProviderInfo;
    }

    public void setVasaProviderInfo(VimVasaProviderInfo[] vasaProviderInfo) {
        this.vasaProviderInfo = vasaProviderInfo;
    }

    public VASAStorageArray[] getStorageArray() {
        return storageArray;
    }

    public void setStorageArray(VASAStorageArray[] storageArray) {
        this.storageArray = storageArray;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

}
