// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.PodStorageDrsEntry;
import com.vmware.vim25.StoragePodSummary;
/* ===== END custom imports ===== */

public class StoragePod extends Folder {

    public StoragePod(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public PodStorageDrsEntry getPodStorageDrsEntry() {
        return (PodStorageDrsEntry) getCurrentProperty("podStorageDrsEntry");
    }

    public StoragePodSummary getSummary() {
        return (StoragePodSummary) getCurrentProperty("summary");
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
