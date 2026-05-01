// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostServiceSystem extends ExtensibleManagedObject {

    public HostServiceSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostServiceInfo getServiceInfo() {
        return (HostServiceInfo) getCurrentProperty("serviceInfo");
    }

    public void refresh() throws RuntimeFault, RemoteException {
        getVimService().refreshServices(getMOR());
    }

    public void restart(String id) throws HostConfigFault, InvalidState, NotFound, RuntimeFault, RemoteException {
        getVimService().restartService(getMOR(), id);
    }

    public void start(String id) throws HostConfigFault, InvalidState, NotFound, RuntimeFault, RemoteException {
        getVimService().startService(getMOR(), id);
    }

    public void stop(String id) throws HostConfigFault, InvalidState, NotFound, RuntimeFault, RemoteException {
        getVimService().stopService(getMOR(), id);
    }

    public void uninstall(String id) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().uninstallService(getMOR(), id);
    }

    public void updatePolicy(String id, String policy) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateServicePolicy(getMOR(), id, policy);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
