// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.KernelModuleInfo;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.NotFound;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class HostKernelModuleSystem extends ManagedObject {

    public HostKernelModuleSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void updateModuleOptionString(String name, String options) throws NotFound, RuntimeFault, RemoteException {
        getVimService().updateModuleOptionString(getMOR(), name, options);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public String queryConfiguredModuleOptionString(String name) throws NotFound, RuntimeFault, RemoteException {
    return getVimService().queryConfiguredModuleOptionString(getMOR(), name);
}
    public KernelModuleInfo[] queryModules() throws RemoteException, RuntimeFault {
    return getVimService().queryModules(getMOR());
}
    /* ===== END custom ===== */
}
