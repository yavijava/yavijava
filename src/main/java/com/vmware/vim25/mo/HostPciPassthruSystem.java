// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostPciPassthruSystem extends ExtensibleManagedObject {

    public HostPciPassthruSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostPciPassthruInfo[] getPciPassthruInfo() {
        return (HostPciPassthruInfo[]) getCurrentProperty("pciPassthruInfo");
    }

    public HostSriovDevicePoolInfo[] getSriovDevicePoolInfo() {
        return (HostSriovDevicePoolInfo[]) getCurrentProperty("sriovDevicePoolInfo");
    }

    public void refresh() throws RuntimeFault, RemoteException {
        getVimService().refresh(getMOR());
    }

    public void updatePassthruConfig(HostPciPassthruConfig[] config) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().updatePassthruConfig(getMOR(), config);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
