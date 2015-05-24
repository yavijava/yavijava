/*================================================================================
Copyright (c) 2008 VMware, Inc. All Rights Reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, 
this list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice, 
this list of conditions and the following disclaimer in the documentation 
and/or other materials provided with the distribution.

* Neither the name of VMware, Inc. nor the names of its contributors may be used
to endorse or promote products derived from this software without specific prior 
written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL VMWARE, INC. OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.
================================================================================*/

package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;

import java.rmi.RemoteException;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 *
 * @author Steve JIN (http://www.doublecloud.org)
 */

public class ClusterComputeResource extends ComputeResource {

    public ClusterComputeResource(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    public ClusterActionHistory[] getActionHistory() {
        return (ClusterActionHistory[]) this.getCurrentProperty("actionHistory");
    }

    /*
     * @deprecated
     */
    public ClusterConfigInfo getConfiguration() {
        return (ClusterConfigInfo) getCurrentProperty("configuration");
    }

    /**
     * @since 4.0
     */
    public ClusterDrsFaults[] getDrsFault() {
        return (ClusterDrsFaults[]) getCurrentProperty("drsFault");
    }

    public ClusterDrsRecommendation[] getDrsRecommendation() {
        return (ClusterDrsRecommendation[]) getCurrentProperty("drsRecommendation");
    }

    public ClusterDrsMigration[] getMigrationHistory() {
        return (ClusterDrsMigration[]) getCurrentProperty("migrationHistory");
    }

    public ClusterRecommendation[] getRecommendation() {
        return (ClusterRecommendation[]) getCurrentProperty("recommendation");
    }

    // SDK 2.5 signature for back compatibility
    public Task addHost_Task(HostConnectSpec spec, boolean asConnected, ResourcePool resourcePool) throws InvalidLogin, HostConnectFault, RuntimeFault, RemoteException {
        return addHost_Task(spec, asConnected, resourcePool, null);
    }

    // new SDK 4.0 signature
    public Task addHost_Task(HostConnectSpec spec, boolean asConnected, ResourcePool resourcePool, String license) throws InvalidLogin, HostConnectFault, RuntimeFault, RemoteException {
        ManagedObjectReference taskMOR = getVimService().addHost_Task(getMOR(), spec, asConnected, resourcePool == null ? null : resourcePool.getMOR(), license);
        return new Task(getServerConnection(), taskMOR);
    }

    public void applyRecommendation(String key) throws RuntimeFault, RemoteException {
        getVimService().applyRecommendation(getMOR(), key);
    }

    /**
     * @since SDK4.1
     */
    public void cancelRecommendation(String key) throws RuntimeFault, RemoteException {
        getVimService().cancelRecommendation(getMOR(), key);
    }

    /**
     * @since SDK5.0
     */
    public ClusterEnterMaintenanceResult clusterEnterMaintenanceMode(HostSystem[] hosts, OptionValue[] option) throws RuntimeFault, RemoteException {
        ManagedObjectReference[] hostMors = MorUtil.createMORs(hosts);
        return getVimService().clusterEnterMaintenanceMode(getMOR(), hostMors, option);
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

    public Task reconfigureCluster_Task(ClusterConfigSpec spec, boolean modify) throws RuntimeFault, RemoteException {
        ManagedObjectReference taskMOR = getVimService().reconfigureCluster_Task(getMOR(), spec, modify);
        return new Task(getServerConnection(), taskMOR);
    }

    public void refreshRecommendation() throws RuntimeFault, RemoteException {
        getVimService().refreshRecommendation(getMOR());
    }

    /**
     * @since 4.0
     */
    public ClusterDasAdvancedRuntimeInfo retrieveDasAdvancedRuntimeInfo() throws RuntimeFault, RemoteException {
        return getVimService().retrieveDasAdvancedRuntimeInfo(getMOR());
    }

    /**
     * Returns A managed object that controls Enhanced vMotion Compatibility mode for this cluster.
     *
     * @return EvcManager
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public ClusterEVCManager evcManager() throws RuntimeFault, RemoteException {
        ManagedObjectReference cevcmgrMor = getVimService().evcManager(getMOR());
        return new ClusterEVCManager(getServerConnection(), cevcmgrMor);
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

    /**
     * Stamp all rules in the cluster with ruleUuid. If a rule has ruleUuid field set, and it has a value, leave it
     * untouched. If rule's ruleUuid field is unset, generate a UUID and stamp the rule.
     *
     * @return Task
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public Task stampAllRulesWithUuid_Task() throws RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().stampAllRulesWithUuid_Task(getMOR());
        return new Task(getServerConnection(), taskMor);
    }
}
