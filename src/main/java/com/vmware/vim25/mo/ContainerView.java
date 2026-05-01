// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.ManagedObjectReference;
/* ===== END custom imports ===== */

public class ContainerView extends ManagedObjectView {

    public ContainerView(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public ManagedEntity getContainer() {
        return (ManagedEntity) this.getManagedObject("container");
    }

    public String[] getType() {
        return (String[]) getCurrentProperty("type");
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public boolean getRecursive() {
    return ((Boolean) getCurrentProperty("recursive")).booleanValue();
}
    /* ===== END custom ===== */
}
