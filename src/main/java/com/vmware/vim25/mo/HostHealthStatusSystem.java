// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.HealthSystemRuntime;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class HostHealthStatusSystem extends ManagedObject {

    public HostHealthStatusSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HealthSystemRuntime getRuntime() {
        return (HealthSystemRuntime) getCurrentProperty("runtime");
    }

    public void clearSystemEventLog() throws RuntimeFault, RemoteException {
        getVimService().clearSystemEventLog(getMOR());
    }

    public SystemEventInfo[] fetchSystemEventLog() throws RuntimeFault, RemoteException {
        return getVimService().fetchSystemEventLog(getMOR());
    }

    public void refresh() throws RuntimeFault, RemoteException {
        getVimService().refresh(getMOR());
    }

    public void resetSystemHealthInfo() throws RuntimeFault, RemoteException {
        getVimService().resetSystemHealthInfo(getMOR());
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public void refreshHealthStatusSystem() throws RuntimeFault, RemoteException {
        getVimService().refreshHealthStatusSystem(getMOR());
    }
    /* ===== END custom ===== */
}
