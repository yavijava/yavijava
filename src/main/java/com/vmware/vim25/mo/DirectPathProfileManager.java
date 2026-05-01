// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class DirectPathProfileManager extends ManagedObject {

    public DirectPathProfileManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public String createDirectPathProfile(DirectPathProfileManagerCreateSpec spec) throws AlreadyExists, InvalidArgument, RuntimeFault, RemoteException {
        return getVimService().directPathProfileManagerCreate(getMOR(), spec);
    }

    public void deleteDirectPathProfile(String id) throws NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().directPathProfileManagerDelete(getMOR(), id);
    }

    public DirectPathProfileInfo[] listDirectPathProfiles(DirectPathProfileManagerFilterSpec filterSpec) throws RuntimeFault, RemoteException {
        return getVimService().directPathProfileManagerList(getMOR(), filterSpec);
    }

    public DirectPathProfileManagerCapacityResult[] queryDirectPathProfileCapacity(DirectPathProfileManagerTargetEntity target, DirectPathProfileManagerCapacityQuerySpec[] querySpec) throws InvalidArgument, RuntimeFault, RemoteException {
        return getVimService().directPathProfileManagerQueryCapacity(getMOR(), target, querySpec);
    }

    public void updateDirectPathProfile(String id, DirectPathProfileManagerUpdateSpec spec) throws AlreadyExists, InvalidArgument, NotFound, RuntimeFault, RemoteException {
        getVimService().directPathProfileManagerUpdate(getMOR(), id, spec);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
