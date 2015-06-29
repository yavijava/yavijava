package com.vmware.vim25.ws

import com.vmware.vim25.InvalidLogin
import com.vmware.vim25.ManagedObjectReference
import spock.lang.Specification

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
class WSClientSpec extends Specification {

    def 'test Login fails with InvalidLogin when invalid info is used'() {
        setup:
        InputStream inputStream = new FileInputStream(new File("src/test/java/com/vmware/vim25/ws/xml/InvalidLoginFault.xml"))

        WSClient wsClient = Spy(WSClient,constructorArgs:["https://foo.com/sdk", true]) {post(*_) >> inputStream}
        ManagedObjectReference managedObjectReference = new ManagedObjectReference()
        managedObjectReference.setType("UserSession")
        managedObjectReference.val = "user-123"

        Argument[] paras = new Argument[4]
        paras[0] = new Argument("_this", "ManagedObjectReference", managedObjectReference)
        paras[1] = new Argument("userName", "String", null)
        paras[2] = new Argument("password", "String", null)
        paras[3] = new Argument("locale", "String", null)

        when:

        wsClient.invoke("Login", paras, "UserSession")

        then:
        thrown(InvalidLogin)
    }
}
