package com.vmware.vim25;

/**
 * Copyright 2015 
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */


/**
 * 
 * Information about an IO Filter on a compute resource.
 *
 * @author Jaidil Karippara
 * @version 1.0
 * @since vSphere 6.0
 */
public class IoFilterQueryIssueResult extends DynamicData {

    /*
     * The operation that was performed for the IO Filter. The set of possible values are described in IoFilterOperation.
     * If opType is uninstall, and the uninstallation of the filter was sucessful on all the hosts in the cluster, the
     * filter will be removed from the cluster's filter list.
     */
    public String opType;
    
    //The issues on hosts. 
    IoFilterHostIssue [] hostIssue;

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public IoFilterHostIssue[] getHostIssue() {
        return hostIssue;
    }

    public void setHostIssue(IoFilterHostIssue[] hostIssue) {
        this.hostIssue = hostIssue;
    }

    
}
