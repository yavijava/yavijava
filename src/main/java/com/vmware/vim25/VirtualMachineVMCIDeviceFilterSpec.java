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

public class VirtualMachineVMCIDeviceFilterSpec extends DynamicData {
    public long rank;

    public String action;

    public String protocol;

    public String direction;

    public long lowerDstPortBoundary;

    public long upperDstPortBoundary;

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public long getLowerDstPortBoundary() {
        return lowerDstPortBoundary;
    }

    public void setLowerDstPortBoundary(long lowerDstPortBoundary) {
        this.lowerDstPortBoundary = lowerDstPortBoundary;
    }

    public long getUpperDstPortBoundary() {
        return upperDstPortBoundary;
    }

    public void setUpperDstPortBoundary(long upperDstPortBoundary) {
        this.upperDstPortBoundary = upperDstPortBoundary;
    }

}
