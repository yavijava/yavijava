// auto generated using yavijava_generator
package com.vmware.vim25.mo;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.KernelModuleInfo;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.NotFound;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */


import com.vmware.vim25.*;
import java.rmi.RemoteException;
import java.util.Calendar;

public class HostKernelModuleSystem extends ManagedObject {

    public HostKernelModuleSystem(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
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
