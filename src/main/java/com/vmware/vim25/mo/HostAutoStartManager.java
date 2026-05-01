// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.HostAutoStartManagerConfig;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class HostAutoStartManager extends ManagedObject {

    public HostAutoStartManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostAutoStartManagerConfig getConfig() {
        return (HostAutoStartManagerConfig) getCurrentProperty("config");
    }

    public void autoStartPowerOff() throws RuntimeFault, RemoteException {
        getVimService().autoStartPowerOff(getMOR());
    }

    public void autoStartPowerOn() throws RuntimeFault, RemoteException {
        getVimService().autoStartPowerOn(getMOR());
    }

    public void reconfigureAutostart(HostAutoStartManagerConfig spec) throws RuntimeFault, RemoteException {
        getVimService().reconfigureAutostart(getMOR(), spec);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
