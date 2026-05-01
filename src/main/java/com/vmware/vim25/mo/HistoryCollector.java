// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class HistoryCollector extends ManagedObject {

    public HistoryCollector(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public Object getFilter() {
        return (Object) getCurrentProperty("filter");
    }

    public void destroyCollector() throws RuntimeFault, RemoteException {
        getVimService().destroyCollector(getMOR());
    }

    public void resetCollector() throws RuntimeFault, RemoteException {
        getVimService().resetCollector(getMOR());
    }

    public void rewindCollector() throws RuntimeFault, RemoteException {
        getVimService().rewindCollector(getMOR());
    }

    public void setCollectorPageSize(int maxCount) throws RuntimeFault, RemoteException {
        getVimService().setCollectorPageSize(getMOR(), maxCount);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
