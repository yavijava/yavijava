// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;
import java.util.Calendar;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostProfile extends Profile {

    public HostProfile(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public Calendar getComplianceCheckTime() {
        return (Calendar) getCurrentProperty("complianceCheckTime");
    }

    public HostSystem getReferenceHost() {
        return (HostSystem) this.getManagedObject("referenceHost");
    }

    public HostProfileValidationFailureInfo getValidationFailureInfo() {
        return (HostProfileValidationFailureInfo) getCurrentProperty("validationFailureInfo");
    }

    public String getValidationState() {
        return (String) getCurrentProperty("validationState");
    }

    public Calendar getValidationStateUpdateTime() {
        return (Calendar) getCurrentProperty("validationStateUpdateTime");
    }

    public void resetValidationState() throws RuntimeFault, RemoteException {
        getVimService().hostProfileResetValidationState(getMOR());
    }

    public void update(HostProfileConfigSpec config) throws DuplicateName, ProfileUpdateFailed, RuntimeFault, RemoteException {
        getVimService().updateHostProfile(getMOR(), config);
    }

    public void updateReferenceHost(HostSystem host) throws RuntimeFault, RemoteException {
        getVimService().updateReferenceHost(getMOR(), host == null ? null : host.getMOR());
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public ProfileExecuteResult executeHostProfile(HostSystem host, ProfileDeferredPolicyOptionParameter[] deferredParam) throws RuntimeFault, RemoteException {
    return getVimService().executeHostProfile(getMOR(), host.getMOR(), deferredParam);
}
    /* ===== END custom ===== */
}
