// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.HostConfigFault;
import com.vmware.vim25.PowerSystemCapability;
import com.vmware.vim25.PowerSystemInfo;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class HostPowerSystem extends ManagedObject {

    public HostPowerSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public PowerSystemCapability getCapability() {
        return (PowerSystemCapability) getCurrentProperty("capability");
    }

    public PowerSystemInfo getInfo() {
        return (PowerSystemInfo) getCurrentProperty("info");
    }

    public void configurePolicy(int key) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().configurePowerPolicy(getMOR(), key);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
