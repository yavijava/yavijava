// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class ClusterComputeResource extends ComputeResource {

    public ClusterComputeResource(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public ClusterActionHistory[] getActionHistory() {
        return (ClusterActionHistory[]) getCurrentProperty("actionHistory");
    }

    public ClusterConfigInfo getConfiguration() {
        return (ClusterConfigInfo) getCurrentProperty("configuration");
    }

    public ClusterDrsFaults[] getDrsFault() {
        return (ClusterDrsFaults[]) getCurrentProperty("drsFault");
    }

    public ClusterDrsRecommendation[] getDrsRecommendation() {
        return (ClusterDrsRecommendation[]) getCurrentProperty("drsRecommendation");
    }

    public ClusterComputeResourceHCIConfigInfo getHciConfig() {
        return (ClusterComputeResourceHCIConfigInfo) getCurrentProperty("hciConfig");
    }

    public ClusterDrsMigration[] getMigrationHistory() {
        return (ClusterDrsMigration[]) getCurrentProperty("migrationHistory");
    }

    public ClusterRecommendation[] getRecommendation() {
        return (ClusterRecommendation[]) getCurrentProperty("recommendation");
    }

    public ClusterComputeResourceSummary getSummaryEx() {
        return (ClusterComputeResourceSummary) getCurrentProperty("summaryEx");
    }

    public void abandonHciWorkflow() throws InvalidState, RuntimeFault, RemoteException {
        getVimService().abandonHciWorkflow(getMOR());
    }

    public Task addHost_Task(HostConnectSpec spec, boolean asConnected, ResourcePool resourcePool, String license) throws DuplicateName, HostConnectFault, InvalidLogin, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().addHost_Task(getMOR(), spec, asConnected, resourcePool == null ? null : resourcePool.getMOR(), license);
        return new Task(getServerConnection(), resultMor);
    }

    public void applyRecommendation(String key) throws RuntimeFault, RemoteException {
        getVimService().applyRecommendation(getMOR(), key);
    }

    public void cancelRecommendation(String key) throws RuntimeFault, RemoteException {
        getVimService().cancelRecommendation(getMOR(), key);
    }

    public Task configureHCI_Task(ClusterComputeResourceHCIConfigSpec clusterSpec, ClusterComputeResourceHostConfigurationInput[] hostInputs) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().configureHCI_Task(getMOR(), clusterSpec, hostInputs);
        return new Task(getServerConnection(), resultMor);
    }

    public ClusterEnterMaintenanceResult clusterEnterMaintenanceMode(HostSystem[] host, OptionValue[] option, ClusterComputeResourceMaintenanceInfo info) throws RuntimeFault, RemoteException {
        return getVimService().clusterEnterMaintenanceMode(getMOR(), host == null ? null : MorUtil.createMORs(host), option, info);
    }

    public ClusterEVCManager evcManager() throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().evcManager(getMOR());
        return new ClusterEVCManager(getServerConnection(), resultMor);
    }

    public Task extendHCI_Task(ClusterComputeResourceHostConfigurationInput[] hostInputs, SDDCBase vSanConfigSpec) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().extendHCI_Task(getMOR(), hostInputs, vSanConfigSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public Datastore[] getSystemVMsRestrictedDatastores() throws RuntimeFault, RemoteException {
        ManagedObjectReference[] mors = getVimService().getSystemVMsRestrictedDatastores(getMOR());
        if (mors == null) return new Datastore[0];
        Datastore[] ds = new Datastore[mors.length];
        for (int i = 0; i < mors.length; i++) {
            ds[i] = new Datastore(getServerConnection(), mors[i]);
        }
        return ds;
    }

    public Task reconfigureCluster_Task(ClusterConfigSpec spec, boolean modify) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().reconfigureCluster_Task(getMOR(), spec, modify);
        return new Task(getServerConnection(), resultMor);
    }

    public void refreshRecommendation() throws RuntimeFault, RemoteException {
        getVimService().refreshRecommendation(getMOR());
    }

    public void setCryptoMode(String cryptoMode, ClusterComputeResourceCryptoModePolicy policy) throws InvalidArgument, InvalidRequest, RuntimeFault, RemoteException {
        getVimService().setCryptoMode(getMOR(), cryptoMode, policy);
    }

    public Task stampAllRulesWithUuid_Task() throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().stampAllRulesWithUuid_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public ClusterComputeResourceValidationResultBase[] validateHCIConfiguration(ClusterComputeResourceHCIConfigSpec hciConfigSpec, HostSystem[] hosts) throws InvalidState, RuntimeFault, RemoteException {
        return getVimService().validateHCIConfiguration(getMOR(), hciConfigSpec, hosts == null ? null : MorUtil.createMORs(hosts));
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    // SDK 2.5 signature for back compatibility
public Task addHost_Task(HostConnectSpec spec, boolean asConnected, ResourcePool resourcePool) throws InvalidLogin, HostConnectFault, RuntimeFault, RemoteException {
    return addHost_Task(spec, asConnected, resourcePool, null);
}
    /**
 * @since SDK5.0
 */
public ClusterEnterMaintenanceResult clusterEnterMaintenanceMode(HostSystem[] hosts, OptionValue[] option) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] hostMors = MorUtil.createMORs(hosts);
    return getVimService().clusterEnterMaintenanceMode(getMOR(), hostMors, option, null);
}
    public Task moveHostInto_Task(HostSystem host, ResourcePool resourcePool) throws TooManyHosts, InvalidState, RuntimeFault, RemoteException {
    if (host == null) {
        throw new IllegalArgumentException("host must not be null.");
    }
    ManagedObjectReference taskMOR = getVimService().moveHostInto_Task(getMOR(), host.getMOR(), resourcePool == null ? null : resourcePool.getMOR());
    return new Task(getServerConnection(), taskMOR);
}
    public Task moveInto_Task(HostSystem[] hosts) throws TooManyHosts, DuplicateName, InvalidState, RuntimeFault, RemoteException {
    if (hosts == null) {
        throw new IllegalArgumentException("hosts must not be null.");
    }
    ManagedObjectReference taskMOR = getVimService().moveInto_Task(getMOR(), MorUtil.createMORs(hosts));
    return new Task(getServerConnection(), taskMOR);
}
    public ClusterHostRecommendation[] recommendHostsForVm(VirtualMachine vm, ResourcePool pool) throws RuntimeFault, RemoteException {
    if (vm == null) {
        throw new IllegalArgumentException("vm must not be null.");
    }
    return getVimService().recommendHostsForVm(getMOR(), vm.getMOR(), pool == null ? null : pool.getMOR());
}
    /**
 * @since 4.0
 */
public ClusterDasAdvancedRuntimeInfo retrieveDasAdvancedRuntimeInfo() throws RuntimeFault, RemoteException {
    return getVimService().retrieveDasAdvancedRuntimeInfo(getMOR());
}
    /**
 * Finds all enabled and disabled VM-VM Affinity and Anti-Affinity rules, involving the given Virtual Machine.
 *
 * @param vm The vm whose rules need to be looked up.
 * @return Array of rule info
 * @throws RuntimeFault
 * @throws RemoteException
 * @since 6.0
 */
public ClusterRuleInfo[] findRulesForVm(VirtualMachine vm) throws RuntimeFault, RemoteException {
    return getVimService().findRulesForVm(getMOR(), vm.getMOR());
}
    /**
 * This API can be invoked to get the current CPU, memory and storage usage in the cluster.
 *
 * @return An instance of ClusterResourceUsageSummary
 * @throws RuntimeFault
 * @throws RemoteException
 * @since 6.0
 */
public ClusterResourceUsageSummary getResourceUsage() throws RuntimeFault, RemoteException {
    return getVimService().getResourceUsage(getMOR());
}
    /**
 * This method returns a PlacementResult object. This API can be invoked to ask DRS for a set of recommendations for
 * moving a virtual machine and its virtual disks into a cluster.
 *
 * @param placementSpec Specification for placing a virtual machine and its virtual disks
 * @return PlacementResult
 * @throws InvalidArgument
 * @throws InvalidState
 * @throws RuntimeFault
 * @throws RemoteException
 * @since 6.0
 */
public PlacementResult placeVm(PlacementSpec placementSpec) throws InvalidArgument, InvalidState, RuntimeFault, RemoteException {
    return getVimService().placeVm(getMOR(), placementSpec);
}
    /* ===== END custom ===== */
}
