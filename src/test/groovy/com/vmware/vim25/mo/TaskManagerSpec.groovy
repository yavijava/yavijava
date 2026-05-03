package com.vmware.vim25.mo

import spock.lang.Specification

class TaskManagerSpec extends Specification {

    def "TaskManager does not expose misspelled getDescriptioin method"() {
        when:
        TaskManager.getMethod("getDescriptioin")

        then:
        thrown(NoSuchMethodException)
    }

    def "TaskManager exposes correctly spelled getDescription method"() {
        expect:
        TaskManager.getMethod("getDescription") != null
    }
}
