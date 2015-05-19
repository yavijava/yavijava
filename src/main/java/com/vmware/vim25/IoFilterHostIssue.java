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
 * Information about the issues on a host.
 *
 * @author Jaidil Karippara
 * @version 1.0
 * @since vSphere 6.0
 */
public class IoFilterHostIssue extends DynamicData {

    //Host having issue.
    public ManagedObjectReference host;
    //List of faults. 
    public LocalizedMethodFault[] issue;
    
}
