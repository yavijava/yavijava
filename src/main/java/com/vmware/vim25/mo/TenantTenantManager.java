// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class TenantTenantManager extends ManagedObject {

    public TenantTenantManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void markServiceProviderEntities(ManagedEntity[] entity) throws AuthMinimumAdminPermission, ManagedObjectNotFound, RuntimeFault, RemoteException {
        getVimService().markServiceProviderEntities(getMOR(), entity == null ? null : MorUtil.createMORs(entity));
    }

    public ManagedObjectReference[] retrieveServiceProviderEntities() throws RuntimeFault, RemoteException {
        return getVimService().retrieveServiceProviderEntities(getMOR());
    }

    public void unmarkServiceProviderEntities(ManagedEntity[] entity) throws ManagedObjectNotFound, RuntimeFault, RemoteException {
        getVimService().unmarkServiceProviderEntities(getMOR(), entity == null ? null : MorUtil.createMORs(entity));
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
