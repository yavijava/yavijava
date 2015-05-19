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
 * @since vSphere API 6.0
 * 
 * @author Jaidil Karippara
 * @version 1.0
 */
public class VirtualEthernetCardResourceAllocation extends DynamicData {
    public Long limit;
    public Long reservation;
    public SharesInfo share;
    public Long getLimit() {
        return limit;
    }
    public void setLimit(Long limit) {
        this.limit = limit;
    }
    public Long getReservation() {
        return reservation;
    }
    public void setReservation(Long reservation) {
        this.reservation = reservation;
    }
    public SharesInfo getShare() {
        return share;
    }
    public void setShare(SharesInfo share) {
        this.share = share;
    }
    
    
}