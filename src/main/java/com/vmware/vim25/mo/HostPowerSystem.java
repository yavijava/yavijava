// auto generated using yavijava_generator
package com.vmware.vim25.mo;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.HostConfigFault;
import com.vmware.vim25.PowerSystemCapability;
import com.vmware.vim25.PowerSystemInfo;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */


import com.vmware.vim25.*;
import java.rmi.RemoteException;
import java.util.Calendar;

public class HostPowerSystem extends ManagedObject {

    public PowerSystemCapability getCapability() {
        return (PowerSystemCapability) getCurrentProperty("capability");
    }

    public PowerSystemInfo getInfo() {
        return (PowerSystemInfo) getCurrentProperty("info");
    }

    public void configurePowerPolicy(int key) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().configurePowerPolicy(getMOR(), key);
    }
    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
