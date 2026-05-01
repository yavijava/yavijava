// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostSnmpSystem extends ManagedObject {

    public HostSnmpSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostSnmpConfigSpec getConfiguration() {
        return (HostSnmpConfigSpec) getCurrentProperty("configuration");
    }

    public HostSnmpSystemAgentLimits getLimits() {
        return (HostSnmpSystemAgentLimits) getCurrentProperty("limits");
    }

    public void reconfigureSnmpAgent(HostSnmpConfigSpec spec) throws InsufficientResourcesFault, NotFound, RuntimeFault, RemoteException {
        getVimService().reconfigureSnmpAgent(getMOR(), spec);
    }

    public void sendTestNotification() throws InsufficientResourcesFault, NotFound, RuntimeFault, RemoteException {
        getVimService().sendTestNotification(getMOR());
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
