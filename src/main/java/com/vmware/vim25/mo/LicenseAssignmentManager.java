// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.LicenseAssignmentManagerLicenseAssignment;
import com.vmware.vim25.LicenseManagerLicenseInfo;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class LicenseAssignmentManager extends ManagedObject {

    public LicenseAssignmentManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void removeAssignedLicense(String entityId) throws LicenseEntityNotFound, RuntimeFault, RemoteException {
        getVimService().removeAssignedLicense(getMOR(), entityId);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public LicenseAssignmentManagerLicenseAssignment[] queryAssignedLicenses(String entityId) throws RuntimeFault, RemoteException {
    return getVimService().queryAssignedLicenses(getMOR(), entityId);
}
    public LicenseManagerLicenseInfo updateAssignedLicense(String entity, String licenseKey, String entityDisplayName) throws RuntimeFault, RemoteException {
    return getVimService().updateAssignedLicense(getMOR(), entity, licenseKey, entityDisplayName);
}
    /* ===== END custom ===== */
}
