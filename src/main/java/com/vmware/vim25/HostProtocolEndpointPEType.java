package com.vmware.vim25;

/**
 * Created by Michael Rice on Mon May 25 21:12:07 CDT 2015
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

public enum HostProtocolEndpointPEType {

    block("block"),
    nas("nas");

    private String val;

    HostProtocolEndpointPEType(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return this.val;
    }
}
