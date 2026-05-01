// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostVFlashManager extends ManagedObject {

    public HostVFlashManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostVFlashManagerVFlashConfigInfo getVFlashConfigInfo() {
        return (HostVFlashManagerVFlashConfigInfo) getCurrentProperty("vFlashConfigInfo");
    }

    public void configureHostVFlashCache(HostVFlashManagerVFlashCacheConfigSpec spec) throws HostConfigFault, InaccessibleVFlashSource, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().hostConfigVFlashCache(getMOR(), spec);
    }

    public void configureVFlashResource(HostVFlashManagerVFlashResourceConfigSpec spec) throws HostConfigFault, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().hostConfigureVFlashResource(getMOR(), spec);
    }

    public Task configureVFlashResourceEx(String[] devicePath) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().configureVFlashResourceEx_Task(getMOR(), devicePath);
        return new Task(getServerConnection(), resultMor);
    }

    public void removeVFlashResource() throws HostConfigFault, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().hostRemoveVFlashResource(getMOR());
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public VirtualDiskVFlashCacheConfigInfo hostGetVFlashModuleDefaultConfig(String vFlashModule) throws NotFound, HostConfigFault, RuntimeFault, RemoteException {
    return getVimService().hostGetVFlashModuleDefaultConfig(this.getMOR(), vFlashModule);
}
    /* ===== END custom ===== */
}
