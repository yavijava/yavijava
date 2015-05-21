package com.vmware.vim25;

/**
 * Created by Michael Rice on Wed May 20 23:39:35 CDT 2015
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

public class BatchResult extends DynamicData {
    public String result;

    public String hostKey;

    public ManagedObjectReference ds;

    public LocalizedMethodFault fault;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getHostKey() {
        return hostKey;
    }

    public void setHostKey(String hostKey) {
        this.hostKey = hostKey;
    }

    public ManagedObjectReference getDs() {
        return ds;
    }

    public void setDs(ManagedObjectReference ds) {
        this.ds = ds;
    }

    public LocalizedMethodFault getFault() {
        return fault;
    }

    public void setFault(LocalizedMethodFault fault) {
        this.fault = fault;
    }

}
