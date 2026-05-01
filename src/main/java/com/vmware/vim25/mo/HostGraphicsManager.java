// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.HostGraphicsInfo;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class HostGraphicsManager extends ExtensibleManagedObject {

    public HostGraphicsManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostGraphicsConfig getGraphicsConfig() {
        return (HostGraphicsConfig) getCurrentProperty("graphicsConfig");
    }

    public HostGraphicsInfo[] getGraphicsInfo() {
        return (HostGraphicsInfo[]) getCurrentProperty("graphicsInfo");
    }

    public HostSharedGpuCapabilities[] getSharedGpuCapabilities() {
        return (HostSharedGpuCapabilities[]) getCurrentProperty("sharedGpuCapabilities");
    }

    public String[] getSharedPassthruGpuTypes() {
        return (String[]) getCurrentProperty("sharedPassthruGpuTypes");
    }

    public void refresh() throws RuntimeFault, RemoteException {
        getVimService().refresh(getMOR());
    }

    public VirtualMachineVgpuDeviceInfo[] retrieveVgpuDeviceInfo() throws RuntimeFault, RemoteException {
        return getVimService().retrieveVgpuDeviceInfo(getMOR());
    }

    public VirtualMachineVgpuProfileInfo[] retrieveVgpuProfileInfo() throws RuntimeFault, RemoteException {
        return getVimService().retrieveVgpuProfileInfo(getMOR());
    }

    public void updateGraphicsConfig(HostGraphicsConfig config) throws RuntimeFault, RemoteException {
        getVimService().updateGraphicsConfig(getMOR(), config);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public boolean isSharedGraphicsActive() throws RuntimeFault, RemoteException {
    return getVimService().isSharedGraphicsActive(this.getMOR());
}
    /* ===== END custom ===== */
}
