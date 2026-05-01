// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.ComplianceResult;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ProfileExpressionMetadata;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class ProfileComplianceManager extends ManagedObject {

    public ProfileComplianceManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void clearComplianceStatus(Profile[] profile, ManagedEntity[] entity) throws RuntimeFault, RemoteException {
        getVimService().clearComplianceStatus(getMOR(), profile == null ? null : MorUtil.createMORs(profile), entity == null ? null : MorUtil.createMORs(entity));
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public Task checkCompliance_Task(Profile[] profile, ManagedEntity[] entity) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] ps = convertMors(profile);
    ManagedObjectReference[] es = convertMors(entity);
    ManagedObjectReference taskMor = getVimService().checkCompliance_Task(getMOR(), ps, es);
    return new Task(getServerConnection(), taskMor);
}
    public ComplianceResult[] queryComplianceStatus(Profile[] profile, ManagedEntity[] entity) throws RuntimeFault, RemoteException {
    return getVimService().queryComplianceStatus(getMOR(), convertMors(profile), convertMors(entity));
}
    //SDK4.1 signature for back compatibility
public ProfileExpressionMetadata[] queryExpressionMetadata(String[] expressionName) throws RuntimeFault, RemoteException {
    return queryExpressionMetadata(expressionName, null);
}
    //SDK5.0 signature
public ProfileExpressionMetadata[] queryExpressionMetadata(String[] expressionName, Profile profile) throws RuntimeFault, RemoteException {
    return getVimService().queryExpressionMetadata(getMOR(), expressionName, profile == null ? null : profile.getMOR());
}
    /* ===== END custom ===== */
}
