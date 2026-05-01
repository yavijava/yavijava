// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostVirtualNicManager extends ExtensibleManagedObject {

    public HostVirtualNicManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostVirtualNicManagerInfo getInfo() {
        return (HostVirtualNicManagerInfo) getCurrentProperty("info");
    }

    public void deselectVnicForNicType(String nicType, String device) throws HostConfigFault, InvalidArgument, RuntimeFault, RemoteException {
        getVimService().deselectVnicForNicType(getMOR(), nicType, device);
    }

    public void selectVnicForNicType(String nicType, String device) throws HostConfigFault, InvalidArgument, RuntimeFault, RemoteException {
        getVimService().selectVnicForNicType(getMOR(), nicType, device);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public VirtualNicManagerNetConfig queryNetConfig(String nicType) throws HostConfigFault, InvalidArgument, RuntimeFault, RemoteException {
    return getVimService().queryNetConfig(getMOR(), nicType);
}
    /* ===== END custom ===== */
}
