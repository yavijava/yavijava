package com.vmware.vim25;

/**
 * Copyright 2015 Michael Rice &lt;michael@michaelrice.org&gt;
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class GatewayConnectFault extends HostConnectFault {

    /**
     * Details of the cause for this fault. This is the way in which Host
     * Gateway servers propagate opaque error messages through vCenter Server.
     */
    public LocalizableMessage details;
    /**
     * Identifier of the gateway that is used for the connection to the host.
     */
    public String gatewayId;
    /**
     * Human-readable information about the host gateway server.
     */
    public String gatewayInfo;
    /**
     * The type of the gateway used for the connection to the host.
     */
    public String gatewayType;

    public LocalizableMessage getDetails() {
        return details;
    }

    public void setDetails(LocalizableMessage details) {
        this.details = details;
    }

    public String getGatewayId() {
        return gatewayId;
    }

    public void setGatewayId(String gatewayId) {
        this.gatewayId = gatewayId;
    }

    public String getGatewayInfo() {
        return gatewayInfo;
    }

    public void setGatewayInfo(String gatewayInfo) {
        this.gatewayInfo = gatewayInfo;
    }

    public String getGatewayType() {
        return gatewayType;
    }

    public void setGatewayType(String gatewayType) {
        this.gatewayType = gatewayType;
    }
}
