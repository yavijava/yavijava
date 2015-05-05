package com.vmware.vim25;

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
public class HostAccessControlEntry extends DynamicData {

    public HostAccessMode accessMode;
    public boolean group;
    public String principal;

    public HostAccessMode getAccessMode() {
        return accessMode;
    }

    public void setAccessMode(HostAccessMode accessMode) {
        this.accessMode = accessMode;
    }

    public boolean isGroup() {
        return group;
    }

    public void setGroup(boolean group) {
        this.group = group;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }
}
