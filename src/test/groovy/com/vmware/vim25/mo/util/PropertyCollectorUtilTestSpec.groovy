package com.vmware.vim25.mo.util

import com.vmware.vim25.ArrayOfManagedObjectReference
import com.vmware.vim25.ManagedObjectReference
import com.vmware.vim25.ObjectSpec
import com.vmware.vim25.SelectionSpec

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
class PropertyCollectorUtilTestSpec extends Specification {

    PropertyCollectorUtil propertyCollectorUtil

    def setup() {
        propertyCollectorUtil = new PropertyCollectorUtil()
    }

    def "ConvertProperty when passed a string returns that string"() {
        setup:
        String foo = "foo"

        when:
        Object thing = propertyCollectorUtil.convertProperty(foo)
        then:
        thing == "foo"
    }

    def "ConvertProperty when passed a null throws IllegalArgumentException"() {
        when:
        propertyCollectorUtil.convertProperty(null)
        then:
        thrown(IllegalArgumentException)
    }

    def "ConvertProperty when passed an ArrayOfManagedObjectRefrence returns ManagedObjectRefrence[]"() {
        setup:
        ManagedObjectReference mor1 = new ManagedObjectReference()
        mor1.setType("VirtualMachine")
        mor1.setVal("vm-12345")
        ManagedObjectReference mor2 = new ManagedObjectReference()
        mor2.setType("VirtualMachine")
        mor2.setVal("vm-12346")

        ArrayOfManagedObjectReference arrayOfManagedObjectReference = new ArrayOfManagedObjectReference()
        arrayOfManagedObjectReference.managedObjectReference = [mor1, mor2]
        when:
        Object foo = propertyCollectorUtil.convertProperty(arrayOfManagedObjectReference)
        then:
        foo instanceof ManagedObjectReference[]
    }

    def "ConvertProperty when passed a string[] returns that string[]"() {
        setup:
        String[] foo = ["string1", "string2"] as String[]

        when:
        Object thing = propertyCollectorUtil.convertProperty(foo)
        then:
        thing == foo
        thing instanceof String[]
    }

    class ArrayOfBad {}

    def "ConvertProperty when passed an ArrayOfBad returns null"() {
        setup:
        ArrayOfBad bad = new ArrayOfBad()
        when:
        Object thing = propertyCollectorUtil.convertProperty(bad)
        then:
        thing == null
    }

    def "CreatObjectSpec returns valid objectspec"() {
        setup:
        ManagedObjectReference mor1 = new ManagedObjectReference()
        mor1.type = "VirtualMachine"
        mor1.val = "vm-12345"
        SelectionSpec[] sets = new SelectionSpec[2]
        SelectionSpec spec1 = new SelectionSpec()
        spec1.name = "name"
        SelectionSpec spec2 = new SelectionSpec()
        spec2.name = "memory"
        sets[0] = spec1
        sets[1] = spec2

        when:
        ObjectSpec objectSpec = propertyCollectorUtil.creatObjectSpec(mor1, true, sets)

        then:
        objectSpec.getObj() == mor1
    }
}
