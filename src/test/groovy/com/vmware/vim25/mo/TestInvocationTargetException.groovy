package com.vmware.vim25.mo

import com.vmware.vim25.ManagedObjectReference

/**
 * Created by willkandrade on 7/29/15.
 */
class TestInvocationTargetException extends ManagedEntity{
    public TestInvocationTargetException(ServerConnection sc, ManagedObjectReference mor) {
        super (sc, mor)
        throw new RuntimeException()
    }
}
