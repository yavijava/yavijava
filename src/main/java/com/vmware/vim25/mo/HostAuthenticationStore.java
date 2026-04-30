// auto generated using yavijava_generator
package com.vmware.vim25.mo;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.HostAuthenticationStoreInfo;
import com.vmware.vim25.ManagedObjectReference;
/* ===== END custom imports ===== */


import com.vmware.vim25.*;
import java.rmi.RemoteException;
import java.util.Calendar;

public class HostAuthenticationStore extends ManagedObject {

    public HostAuthenticationStore(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    public HostAuthenticationStoreInfo getInfo() {
        return (HostAuthenticationStoreInfo) getCurrentProperty("info");
    }
    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
