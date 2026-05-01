// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.mo.util.MorUtil;
/* ===== END custom imports ===== */

public class InventoryView extends ManagedObjectView {

    public InventoryView(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public ManagedEntity[] closeInventoryViewFolder(ManagedEntity[] entities) throws RuntimeFault, RemoteException {
    if (entities == null) {
        throw new IllegalArgumentException("entities must not be null.");
    }
    ManagedObjectReference[] mors = getVimService().closeInventoryViewFolder(getMOR(), MorUtil.createMORs(entities));
    return MorUtil.createManagedEntities(getServerConnection(), mors);
}
    public ManagedEntity[] openInventoryViewFolder(ManagedEntity[] entities) throws RuntimeFault, RemoteException {
    if (entities == null) {
        throw new IllegalArgumentException("entities must not be null.");
    }
    ManagedObjectReference[] mors = getVimService().openInventoryViewFolder(getMOR(), MorUtil.createMORs(entities));
    return MorUtil.createManagedEntities(getServerConnection(), mors);
}
    /* ===== END custom ===== */
}
