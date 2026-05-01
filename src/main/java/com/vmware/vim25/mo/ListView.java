// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class ListView extends ManagedObjectView {

    public ListView(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public ManagedEntity[] modifyListView(ManagedEntity[] add, ManagedEntity[] remove) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = getVimService().modifyListView(getMOR(), add == null ? null : MorUtil.createMORs(add), remove == null ? null : MorUtil.createMORs(remove));
    return MorUtil.createManagedEntities(getServerConnection(), mors);
}
    public ManagedEntity[] resetListView(ManagedEntity[] obj) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = getVimService().resetListView(getMOR(), obj == null ? null : MorUtil.createMORs(obj));
    return MorUtil.createManagedEntities(getServerConnection(), mors);
}
    public void resetListViewFromView(View view) throws RuntimeFault, RemoteException {
    if (view == null) {
        throw new IllegalArgumentException("view must not be null.");
    }
    getVimService().resetListViewFromView(getMOR(), view.getMOR());
}
    /* ===== END custom ===== */
}
