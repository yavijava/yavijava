// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostFirmwareSystem extends ManagedObject {

    public HostFirmwareSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void resetFirmwareToFactoryDefaults() throws InvalidState, RuntimeFault, RemoteException {
        getVimService().resetFirmwareToFactoryDefaults(getMOR());
    }

    public void restoreFirmwareConfiguration(boolean force) throws FileFault, InvalidBundle, InvalidState, MismatchedBundle, RuntimeFault, RemoteException {
        getVimService().restoreFirmwareConfiguration(getMOR(), force);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public String backupFirmwareConfiguration() throws RuntimeFault, RemoteException {
    return getVimService().backupFirmwareConfiguration(getMOR());
}
    public String queryFirmwareConfigUploadURL() throws RuntimeFault, RemoteException {
    return getVimService().queryFirmwareConfigUploadURL(getMOR());
}
    /* ===== END custom ===== */
}
