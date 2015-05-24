package com.vmware.vim25;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Michael Rice on Sun May 24 16:15:36 CDT 2015
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

public class VsanPolicyCost extends DynamicData {
    @Getter @Setter public long changeDataSize;
    @Getter @Setter public long currentDataSize;
    @Getter @Setter public long tempDataSize;
    @Getter @Setter public long copyDataSize;
    @Getter @Setter public long changeFlashReadCacheSize;
    @Getter @Setter public long currentFlashReadCacheSize;
    @Getter @Setter public float currentDiskSpaceToAddressSpaceRatio;
    @Getter @Setter public float diskSpaceToAddressSpaceRatio;
}
