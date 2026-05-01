// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;
import java.util.Calendar;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.HostConfigFault;
import com.vmware.vim25.HostImageProfileSummary;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class HostImageConfigManager extends ManagedObject {

    public HostImageConfigManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public SoftwarePackage[] fetchSoftwarePackages() throws RuntimeFault, RemoteException {
        return getVimService().fetchSoftwarePackages(getMOR());
    }

    public Calendar installDate() throws RuntimeFault, RemoteException {
        return getVimService().installDate(getMOR());
    }

    public void updateHostImageAcceptanceLevel(String newAcceptanceLevel) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().updateHostImageAcceptanceLevel(getMOR(), newAcceptanceLevel);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public String hostImageConfigGetAcceptance() throws HostConfigFault, RuntimeFault, RemoteException {
    return getVimService().hostImageConfigGetAcceptance(getMOR());
}
    public HostImageProfileSummary hostImageConfigGetProfile() throws RuntimeFault, RemoteException {
    return getVimService().hostImageConfigGetProfile(getMOR());
}
    /* ===== END custom ===== */
}
