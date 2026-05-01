// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class ClusterEVCManager extends ExtensibleManagedObject {

    public ClusterEVCManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public ClusterEVCManagerEVCState getEvcState() {
        return (ClusterEVCManagerEVCState) getCurrentProperty("evcState");
    }

    public ClusterComputeResource getManagedCluster() {
        return (ClusterComputeResource) this.getManagedObject("managedCluster");
    }

    public Task checkAddHostEvc_Task(HostConnectSpec cnxSpec) throws HostConnectFault, InvalidLogin, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().checkAddHostEvc_Task(getMOR(), cnxSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task checkConfigureEvcMode_Task(String evcModeKey, String evcGraphicsModeKey) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().checkConfigureEvcMode_Task(getMOR(), evcModeKey, evcGraphicsModeKey);
        return new Task(getServerConnection(), resultMor);
    }

    public Task configureEvcMode_Task(String evcModeKey, String evcGraphicsModeKey) throws EVCConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().configureEvcMode_Task(getMOR(), evcModeKey, evcGraphicsModeKey);
        return new Task(getServerConnection(), resultMor);
    }

    public Task disableEvcMode_Task() throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().disableEvcMode_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
