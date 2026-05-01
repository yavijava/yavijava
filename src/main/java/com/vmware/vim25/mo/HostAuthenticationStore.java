// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.HostAuthenticationStoreInfo;
import com.vmware.vim25.ManagedObjectReference;
/* ===== END custom imports ===== */

public class HostAuthenticationStore extends ManagedObject {

    public HostAuthenticationStore(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostAuthenticationStoreInfo getInfo() {
        return (HostAuthenticationStoreInfo) getCurrentProperty("info");
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
