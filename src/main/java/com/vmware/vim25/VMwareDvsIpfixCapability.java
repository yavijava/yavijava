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

public class VMwareDvsIpfixCapability extends DynamicData {
    public Boolean ipfixSupported;

    public Boolean ipv6ForIpfixSupported;

    public Boolean observationDomainIdSupported;

    public Boolean getIpfixSupported() {
        return ipfixSupported;
    }

    public void setIpfixSupported(Boolean ipfixSupported) {
        this.ipfixSupported = ipfixSupported;
    }

    public Boolean getIpv6ForIpfixSupported() {
        return ipv6ForIpfixSupported;
    }

    public void setIpv6ForIpfixSupported(Boolean ipv6ForIpfixSupported) {
        this.ipv6ForIpfixSupported = ipv6ForIpfixSupported;
    }

    public Boolean getObservationDomainIdSupported() {
        return observationDomainIdSupported;
    }

    public void setObservationDomainIdSupported(Boolean observationDomainIdSupported) {
        this.observationDomainIdSupported = observationDomainIdSupported;
    }

}
