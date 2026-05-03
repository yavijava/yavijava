package com.vmware.vim25.mo

import com.vmware.vim25.HostConfigSpec
import com.vmware.vim25.HostVsanInternalSystemCmmdsQuery
import com.vmware.vim25.PropertyFilterSpec
import spock.lang.Specification
import spock.lang.Unroll

class DeprecatedAnnotationsSpec extends Specification {

    @Unroll
    def "#clazz.simpleName.#methodName carries @Deprecated annotation"() {
        expect:
        clazz.getDeclaredMethod(methodName, *paramTypes).isAnnotationPresent(Deprecated.class)

        where:
        clazz                    | methodName                         | paramTypes
        ServerConnection         | "getUserSession"                   | []
        VirtualMachine           | "acquireMksTicket"                 | []
        VirtualMachine           | "queryFaultToleranceCompatibility" | []
        HostSystem               | "getHostVMotionSystem"             | []
        AuthorizationManager     | "HasPrivilegeOnEntity"             | [ManagedEntity.class, String.class, String[].class]
        ExtensionManager         | "printAllExtensions"               | []
        LicenseManager           | "getSourceAvailable"               | []
        PropertyCollector        | "retrieveProperties"               | [PropertyFilterSpec[].class]
        PropertyCollector        | "waitForUpdates"                   | [String.class]
        HostProfileManager       | "generateConfigTaskList"           | [HostConfigSpec.class, HostSystem.class]
        Task                     | "waitForMe"                        | []
        HostVsanInternalSystem   | "QueryCmmds"                       | [HostVsanInternalSystemCmmdsQuery[].class]
    }
}
