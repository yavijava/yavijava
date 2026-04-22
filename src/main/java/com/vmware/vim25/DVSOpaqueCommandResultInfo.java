package com.vmware.vim25;

import lombok.Getter;
import lombok.Setter;

/**
 * @since SDK5.5
 */
public class DVSOpaqueCommandResultInfo extends DynamicData {
    @Getter @Setter public ManagedObjectReference obj;
    @Getter @Setter public MethodFault fault;
}
