// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class FailoverClusterConfigurator extends ManagedObject {

    public FailoverClusterConfigurator(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public Task configureVcha_Task(VchaClusterConfigSpec configSpec) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().configureVcha_Task(getMOR(), configSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task createPassiveNode_Task(PassiveNodeDeploymentSpec passiveDeploymentSpec, SourceNodeSpec sourceVcSpec) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createPassiveNode_Task(getMOR(), passiveDeploymentSpec, sourceVcSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task createWitnessNode_Task(NodeDeploymentSpec witnessDeploymentSpec, SourceNodeSpec sourceVcSpec) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createWitnessNode_Task(getMOR(), witnessDeploymentSpec, sourceVcSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task deployVcha_Task(VchaClusterDeploymentSpec deploymentSpec) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().deployVcha_Task(getMOR(), deploymentSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task destroyVcha_Task() throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().destroyVcha_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public VchaClusterConfigInfo getVchaConfig() throws RuntimeFault, RemoteException {
        return getVimService().getVchaConfig(getMOR());
    }

    public Task prepareVcha_Task(VchaClusterNetworkSpec networkSpec) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().prepareVcha_Task(getMOR(), networkSpec);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
