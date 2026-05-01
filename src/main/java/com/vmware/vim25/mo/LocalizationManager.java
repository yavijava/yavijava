// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.LocalizationManagerMessageCatalog;
import com.vmware.vim25.ManagedObjectReference;
/* ===== END custom imports ===== */

public class LocalizationManager extends ManagedObject {

    public LocalizationManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public LocalizationManagerMessageCatalog[] getCatalog() {
        return (LocalizationManagerMessageCatalog[]) getCurrentProperty("catalog");
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
