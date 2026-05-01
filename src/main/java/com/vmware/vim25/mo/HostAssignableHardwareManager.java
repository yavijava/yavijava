// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostAssignableHardwareManager extends ManagedObject {

    public HostAssignableHardwareManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostAssignableHardwareBinding[] getBinding() {
        return (HostAssignableHardwareBinding[]) getCurrentProperty("binding");
    }

    public HostAssignableHardwareConfig getConfig() {
        return (HostAssignableHardwareConfig) getCurrentProperty("config");
    }

    public byte[] downloadDescriptionTree() throws RuntimeFault, RemoteException {
        return getVimService().downloadDescriptionTree(getMOR());
    }

    public VirtualMachineDynamicPassthroughInfo[] retrieveDynamicPassthroughInfo() throws RuntimeFault, RemoteException {
        return getVimService().retrieveDynamicPassthroughInfo(getMOR());
    }

    public VirtualMachineVendorDeviceGroupInfo[] retrieveVendorDeviceGroupInfo() throws RuntimeFault, RemoteException {
        return getVimService().retrieveVendorDeviceGroupInfo(getMOR());
    }

    public void updateConfig(HostAssignableHardwareConfig config) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().updateAssignableHardwareConfig(getMOR(), config);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
