// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostVMotionSystem extends ExtensibleManagedObject {

    public HostVMotionSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostIpConfig getIpConfig() {
        return (HostIpConfig) getCurrentProperty("ipConfig");
    }

    public HostVMotionNetConfig getNetConfig() {
        return (HostVMotionNetConfig) getCurrentProperty("netConfig");
    }

    public void deselectVnic() throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().deselectVnic(getMOR());
    }

    public void selectVnic(String device) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().selectVnic(getMOR(), device);
    }

    public void updateIpConfig(HostIpConfig ipConfig) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateIpConfig(getMOR(), ipConfig);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
