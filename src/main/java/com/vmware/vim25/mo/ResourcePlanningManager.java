// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.DatabaseSizeEstimate;
import com.vmware.vim25.DatabaseSizeParam;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class ResourcePlanningManager extends ManagedObject {

    public ResourcePlanningManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public DatabaseSizeEstimate estimateDatabaseSize(DatabaseSizeParam dbSizeParam) throws RuntimeFault, RemoteException {
    return getVimService().estimateDatabaseSize(getMOR(), dbSizeParam);
}
    /* ===== END custom ===== */
}
