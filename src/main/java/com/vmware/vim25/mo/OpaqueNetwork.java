// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.ManagedObjectReference;
/* ===== END custom imports ===== */

public class OpaqueNetwork extends Network {

    public OpaqueNetwork(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public OpaqueNetworkCapability getCapability() {
        return (OpaqueNetworkCapability) getCurrentProperty("capability");
    }

    public OptionValue[] getExtraConfig() {
        return (OptionValue[]) getCurrentProperty("extraConfig");
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
