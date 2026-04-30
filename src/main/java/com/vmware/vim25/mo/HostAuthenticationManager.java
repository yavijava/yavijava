// auto generated using yavijava_generator
package com.vmware.vim25.mo;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.HostAuthenticationManagerInfo;
import com.vmware.vim25.ManagedObjectReference;
/* ===== END custom imports ===== */


import com.vmware.vim25.*;
import java.rmi.RemoteException;
import java.util.Calendar;

public class HostAuthenticationManager extends ManagedObject {

    public HostAuthenticationManagerInfo getInfo() {
        return (HostAuthenticationManagerInfo) getCurrentProperty("info");
    }
    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public HostAuthenticationStore[] getSupportedStore() {
    ManagedObjectReference[] mors = (ManagedObjectReference[]) getCurrentProperty("supportedStore");
    HostAuthenticationStore[] hass = new HostAuthenticationStore[mors.length];
    for (int i = 0; i < mors.length; i++) {
        hass[i] = new HostAuthenticationStore(getServerConnection(), mors[i]);
    }
    return hass;
}
    /* ===== END custom ===== */
}
