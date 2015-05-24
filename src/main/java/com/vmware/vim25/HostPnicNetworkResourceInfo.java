package com.vmware.vim25;

/**
 * Created by Michael Rice on Wed May 20 23:39:36 CDT 2015
 * <p/>
 * Copyright 2015 Michael Rice
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
 *
 * @since 6.0
 */

public class HostPnicNetworkResourceInfo extends DynamicData {
    public String pnicDevice;

    public long availableBandwidthForVMTraffic;

    public long unusedBandwidthForVMTraffic;

    public HostPlacedVirtualNicIdentifier[] placedVirtualNics;

    public String getPnicDevice() {
        return pnicDevice;
    }

    public void setPnicDevice(String pnicDevice) {
        this.pnicDevice = pnicDevice;
    }

    public long getAvailableBandwidthForVMTraffic() {
        return availableBandwidthForVMTraffic;
    }

    public void setAvailableBandwidthForVMTraffic(long availableBandwidthForVMTraffic) {
        this.availableBandwidthForVMTraffic = availableBandwidthForVMTraffic;
    }

    public long getUnusedBandwidthForVMTraffic() {
        return unusedBandwidthForVMTraffic;
    }

    public void setUnusedBandwidthForVMTraffic(long unusedBandwidthForVMTraffic) {
        this.unusedBandwidthForVMTraffic = unusedBandwidthForVMTraffic;
    }

    public HostPlacedVirtualNicIdentifier[] getPlacedVirtualNics() {
        return placedVirtualNics;
    }

    public void setPlacedVirtualNics(HostPlacedVirtualNicIdentifier[] placedVirtualNics) {
        this.placedVirtualNics = placedVirtualNics;
    }

}
