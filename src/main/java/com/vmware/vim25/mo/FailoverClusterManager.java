// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class FailoverClusterManager extends ManagedObject {

    public FailoverClusterManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public String getClusterMode() throws RuntimeFault, RemoteException {
        return getVimService().getClusterMode(getMOR());
    }

    public VchaClusterHealth getVchaClusterHealth() throws RuntimeFault, RemoteException {
        return getVimService().getVchaClusterHealth(getMOR());
    }

    public Task initiateFailover_Task(boolean planned) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().initiateFailover_Task(getMOR(), planned);
        return new Task(getServerConnection(), resultMor);
    }

    public Task setClusterMode_Task(String mode) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().setClusterMode_Task(getMOR(), mode);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
