// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class ProfileManager extends ManagedObject {

    public ProfileManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public Profile createProfile(ProfileCreateSpec createSpec) throws DuplicateName, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createProfile(getMOR(), createSpec);
        return new Profile(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public Profile[] getProfile() {
    ManagedObjectReference[] mors = (ManagedObjectReference[]) getCurrentProperty("profile");
    return convert2Profiles(mors);
}
    public Profile[] findAssociatedProfile(ManagedEntity entity) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = getVimService().findAssociatedProfile(getMOR(), entity.getMOR());
    return convert2Profiles(mors);
}
    //SDK4.1 signature for back compatibility
public ProfilePolicyMetadata[] queryPolicyMetadata(String[] policyName) throws RuntimeFault, RemoteException {
    return queryPolicyMetadata(policyName, null);
}
    //SDK5.0 signature
public ProfilePolicyMetadata[] queryPolicyMetadata(String[] policyName, Profile profile) throws RuntimeFault, RemoteException {
    return getVimService().queryPolicyMetadata(getMOR(), policyName, profile == null ? null : profile.getMOR());
}
    private Profile[] convert2Profiles(ManagedObjectReference[] mors) {
    Profile[] pfs = new Profile[mors.length];
    for (int i = 0; i < mors.length; i++) {
        pfs[i] = new Profile(getServerConnection(), mors[i]);
    }
    return pfs;
}
    /* ===== END custom ===== */
}
