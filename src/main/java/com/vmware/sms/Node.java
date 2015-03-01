package com.vmware.sms;

import com.vmware.sms.types.NodeStatus;

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
public class Node extends DynamicData {

    public EntityReference entity;
    public String name;
    public NodeProperty[] property;
    public NodeStatus status;

    public EntityReference getEntity() {
        return entity;
    }

    public void setEntity(EntityReference entity) {
        this.entity = entity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NodeProperty[] getProperty() {
        return property;
    }

    public void setProperty(NodeProperty[] property) {
        this.property = property;
    }

    public NodeStatus getStatus() {
        return status;
    }

    public void setStatus(NodeStatus status) {
        this.status = status;
    }
}
