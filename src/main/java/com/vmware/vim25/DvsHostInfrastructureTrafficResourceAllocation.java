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

public class DvsHostInfrastructureTrafficResourceAllocation extends DynamicData {
    public long limit;

    public SharesInfo shares;

    public long reservation;

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }

    public SharesInfo getShares() {
        return shares;
    }

    public void setShares(SharesInfo shares) {
        this.shares = shares;
    }

    public long getReservation() {
        return reservation;
    }

    public void setReservation(long reservation) {
        this.reservation = reservation;
    }

}
