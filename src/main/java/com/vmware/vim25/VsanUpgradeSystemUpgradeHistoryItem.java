package com.vmware.vim25;

import java.util.Calendar;

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
public class VsanUpgradeSystemUpgradeHistoryItem extends DynamicData {

    public ManagedObjectReference host;
    public String message;
    public ManagedObjectReference task;
    public Calendar timeStamp;

    public ManagedObjectReference getHost() {
        return host;
    }

    public void setHost(ManagedObjectReference host) {
        this.host = host;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ManagedObjectReference getTask() {
        return task;
    }

    public void setTask(ManagedObjectReference task) {
        this.task = task;
    }

    public Calendar getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Calendar timeStamp) {
        this.timeStamp = timeStamp;
    }
}
