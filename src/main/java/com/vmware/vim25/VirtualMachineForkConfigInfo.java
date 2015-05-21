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

public class VirtualMachineForkConfigInfo extends DynamicData {
    public Boolean parentEnabled;

    public String childForkGroupId;

    public String childType;

    public Boolean getParentEnabled() {
        return parentEnabled;
    }

    public void setParentEnabled(Boolean parentEnabled) {
        this.parentEnabled = parentEnabled;
    }

    public String getChildForkGroupId() {
        return childForkGroupId;
    }

    public void setChildForkGroupId(String childForkGroupId) {
        this.childForkGroupId = childForkGroupId;
    }

    public String getChildType() {
        return childType;
    }

    public void setChildType(String childType) {
        this.childType = childType;
    }

}
