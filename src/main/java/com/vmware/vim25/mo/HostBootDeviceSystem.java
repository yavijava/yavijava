// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.HostBootDeviceInfo;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class HostBootDeviceSystem extends ManagedObject {

    public HostBootDeviceSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void updateBootDevice(String key) throws RuntimeFault, RemoteException {
        getVimService().updateBootDevice(getMOR(), key);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public HostBootDeviceInfo queryBootDevices() throws RuntimeFault, RemoteException {
    return getVimService().queryBootDevices(getMOR());
}
    /* ===== END custom ===== */
}
