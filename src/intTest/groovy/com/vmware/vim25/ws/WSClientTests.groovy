package com.vmware.vim25.ws

import com.vmware.vim25.mo.ServiceInstance
import spock.lang.Specification

import java.rmi.RemoteException

/**
 *  Copyright 2015 Michael Rice <michael@michaelrice.org>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
class WSClientTests extends Specification {

    def 'test UnknownHost Exception gets wrapped in RemoteException'() {
        when:
        ServiceInstance serviceInstance = new ServiceInstance(new URL("https://sdfsdfsf.co.ck"), "", true)
        then:
        def e = thrown(RemoteException)
        e.cause instanceof UnknownHostException

    }
}
