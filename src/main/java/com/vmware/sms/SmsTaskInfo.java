package com.vmware.sms;

import com.vmware.sms.faults.LocalizedMethodFault;
import com.vmware.sms.mo.SmsTask;
import com.vmware.vim25.ManagedObjectReference;

import java.util.Date;

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
public class SmsTaskInfo extends DynamicData {

    public Date completionTime;
    public LocalizedMethodFault error;
    public String key;
    public ManagedObjectReference object;
    public int progress;
    public Object result;
    public Date startTime;
    public String state;
    public SmsTask task;

    public Date getCompletionTime() {
        return completionTime;
    }

    public void setCompletionTime(Date completionTime) {
        this.completionTime = completionTime;
    }

    public LocalizedMethodFault getError() {
        return error;
    }

    public void setError(LocalizedMethodFault error) {
        this.error = error;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ManagedObjectReference getObject() {
        return object;
    }

    public void setObject(ManagedObjectReference object) {
        this.object = object;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public SmsTask getTask() {
        return task;
    }

    public void setTask(SmsTask task) {
        this.task = task;
    }
}
