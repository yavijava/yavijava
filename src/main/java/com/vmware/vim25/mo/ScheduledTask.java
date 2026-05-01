// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class ScheduledTask extends ExtensibleManagedObject {

    public ScheduledTask(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public ScheduledTaskInfo getInfo() {
        return (ScheduledTaskInfo) getCurrentProperty("info");
    }

    public void reconfigureScheduledTask(ScheduledTaskSpec spec) throws DuplicateName, InvalidName, InvalidState, RuntimeFault, RemoteException {
        getVimService().reconfigureScheduledTask(getMOR(), spec);
    }

    public void removeScheduledTask() throws InvalidState, RuntimeFault, RemoteException {
        getVimService().removeScheduledTask(getMOR());
    }

    public void runScheduledTask() throws InvalidState, RuntimeFault, RemoteException {
        getVimService().runScheduledTask(getMOR());
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
