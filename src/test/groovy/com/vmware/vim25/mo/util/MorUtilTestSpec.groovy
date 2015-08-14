package com.vmware.vim25.mo.util

import com.vmware.vim25.ManagedObjectReference
import com.vmware.vim25.mo.ManagedObject
import com.vmware.vim25.mo.ServerConnection
import com.vmware.vim25.mo.VirtualMachine
import spock.lang.Specification
import static groovy.test.GroovyAssert.shouldFail

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
class MorUtilTestSpec extends Specification {

    def "test MorUtil createMORs returns properly formatted MOR[]"() {
        setup:
        ServerConnection sc = Mock(ServerConnection)
        ManagedObjectReference mor1 = new ManagedObjectReference()
        mor1.type = "VirtualMachine"
        mor1.val = "vm-12345"
        ManagedObject mo1 = new VirtualMachine(sc, mor1)
        ManagedObject[] mos = new ManagedObject[1]
        mos[0] = mo1

        when:
        ManagedObjectReference[] mors = MorUtil.createMORs(mos)

        then:
        mors[0].val == mo1.getMOR().val
    }

    def "test CreateExactManagedObject returns a VirtualMachine when passed a Mor of a vm"() {
        setup:
        ManagedObjectReference mor1 = new ManagedObjectReference()
        mor1.type = "VirtualMachine"
        mor1.val = "vm-12345"
        ServerConnection sc = Mock(ServerConnection)

        when:
        ManagedObject vm1 = MorUtil.createExactManagedObject(sc, mor1)

        then:
        vm1 instanceof VirtualMachine
    }

    def "test createMOR produces a valid MOR so you can make a VirtualMachine when asked to"() {
        setup:
        String val = "vm-12345"
        String type = "VirtualMachine"
        ServerConnection sc = Mock(ServerConnection)

        when:
        ManagedObjectReference vmMOR = MorUtil.createMOR(type, val)
        VirtualMachine vm = new VirtualMachine(sc, vmMOR)

        then:
        vm.getMOR().val == val
    }

    def "test CreateExactManagedObject throws an IllegalArgumentException on ClassNotFoundException"() {
        setup:
        ManagedObjectReference mor1 = new ManagedObjectReference()
        mor1.type = "null"
        mor1.val = "vm-12345"
        ServerConnection sc = Mock(ServerConnection)

        when:
        String message = shouldFail IllegalArgumentException, {MorUtil.createExactManagedObject(sc, mor1)}

        then:
        message.contains("vijava does not have an associated class for this mor: vm-12345")
    }

    def "test CreateExactManagedObject throws an IllegalArgumentException on NoSuchMethodException"() {
        setup:
        ManagedObjectReference mor1 = new ManagedObjectReference()
        mor1.type = "ServiceInstance"
        mor1.val = "vm-12345"
        ServerConnection sc = Mock(ServerConnection)
        MorUtil mu = Mock(MorUtil)

        when:
        String message = shouldFail IllegalArgumentException, {MorUtil.createExactManagedObject(sc, mor1)}

        then:
        message.contains("No constructor found in vijava for class: com.vmware.vim25.mo.ServiceInstance")
    }

    def "test CreateExactManagedObject throws an IllegalArgumentException on InstantiationException"() {
        setup:
        ManagedObjectReference mor1 = new ManagedObjectReference()
        mor1.type = "ManagedObject"
        mor1.val = "vm-12345"
        ServerConnection sc = Mock(ServerConnection)


        when:
        String message = shouldFail IllegalArgumentException, {MorUtil.createExactManagedObject(sc, mor1)}

        then:
        message.contains("vijava is unable to create a managed object from this mor: vm-12345")
    }

    def "test CreateExactManagedObject throws an IllegalArgumentException on InvocationTargetException"() {
        setup:
        ManagedObjectReference mor1 = new ManagedObjectReference()
        mor1.type = "TestInvocationTargetException"
        mor1.val = "vm-12345"
        ServerConnection sc = new ServerConnection(null, null, null)


        when:
        String message = shouldFail IllegalArgumentException, {MorUtil.createExactManagedObject(sc, mor1)}

        then:
        message.contains("vijava is unable to create a managed object from this mor: vm-12345")
    }

    def "test CreateExactManagedObject throws uncaught Exception"() {
        setup:
        ManagedObjectReference mor1 = new ManagedObjectReference()
        mor1.type = "TestExceptionNotCaught"
        mor1.val = "vm-12345"
        ServerConnection sc = new ServerConnection(null, null, null)


        when:
        String message = shouldFail ClassCastException, {MorUtil.createExactManagedObject(sc, mor1)}

        then:
        message.contains("com.vmware.vim25.mo.TestExceptionNotCaught cannot be cast to com.vmware.vim25.mo.ManagedObject")
    }
}
