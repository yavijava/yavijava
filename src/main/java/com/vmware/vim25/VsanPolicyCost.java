package com.vmware.vim25;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Michael Rice on Thu Jun 11 17:52:06 CDT 2015
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

public class VsanPolicyCost extends DynamicData {
    @Getter @Setter public Long changeDataSize;
    @Getter @Setter public Long currentDataSize;
    @Getter @Setter public Long tempDataSize;
    @Getter @Setter public Long copyDataSize;
    @Getter @Setter public Long changeFlashReadCacheSize;
    @Getter @Setter public Long currentFlashReadCacheSize;
    @Getter @Setter public float currentDiskSpaceToAddressSpaceRatio;
    @Getter @Setter public float diskSpaceToAddressSpaceRatio;
}
