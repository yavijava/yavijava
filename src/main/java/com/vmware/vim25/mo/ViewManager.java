// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class ViewManager extends ManagedObject {

    public ViewManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public View[] getViewList() {
        return getViews("viewList");
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public ContainerView createContainerView(ManagedEntity container, String[] type, boolean recursive) throws RuntimeFault, RemoteException {
    if (container == null) {
        throw new IllegalArgumentException("container must not be null.");
    }
    return new ContainerView(getServerConnection(), getVimService().createContainerView(getMOR(), container.getMOR(), type, recursive));
}
    public InventoryView createInventoryView() throws RuntimeFault, RemoteException {
    return new InventoryView(getServerConnection(), getVimService().createInventoryView(getMOR()));
}
    public ListView createListView(ManagedObject[] mos) throws RuntimeFault, RemoteException {
    return new ListView(getServerConnection(), getVimService().createListView(getMOR(), mos == null ? null : MorUtil.createMORs(mos)));
}
    public ListView createListViewFromView(View view) throws RuntimeFault, RemoteException {
    if (view == null) {
        throw new IllegalArgumentException("view must not be null.");
    }
    ManagedObjectReference mor = getVimService().createListViewFromView(getMOR(), view.getMOR());
    return new ListView(getServerConnection(), mor);
}
    /* ===== END custom ===== */
}
