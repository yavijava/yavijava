package com.vmware.vim25.mo;

import com.vmware.vim25.*;

import java.rmi.RemoteException;

/**
 * Copyright 2015 Michael Rice &lt;michael@michaelrice.org&gt;
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @since 6.0
 */
public class VRPResourceManager extends ManagedObject {

    /**
     * Constructor
     *
     * @param sc  ServerConnection
     * @param mor ManagedObjectReference
     */
    public VRPResourceManager(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    /**
     * Creates a new Virtual Resource Pool.
     *
     * @param spec The VRP is created to have this config. The spec can either have member hubs specified, or the child resource pools. If hubs are specified, a child resource pool will be created within every hub. If child resource pools are specified, the parents of these resource pools will be considered as hubs.
     * @return No description given.
     * @throws InsufficientResourcesFault
     * @throws InvalidState
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public String createVRP(VirtualResourcePoolSpec spec) throws InsufficientResourcesFault, InvalidState, RuntimeFault, RemoteException {
        return getVimService().createVRP(getMOR(), spec);
    }

    /**
     * Deletes a VRP with the given Id if it exists. During deletion, all of the child resource pools under the hubs
     * will be deleted. If there are any VMs under those resource pools, they will be moved directly under the hub. For
     * hubs that are cluster, those VMs will be moved to the root resource pool.
     *
     * @param vrpId The unique Id of the VRP
     * @throws InvalidState
     * @throws NotFound
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public void deleteVRP(String vrpId) throws InvalidState, NotFound, RuntimeFault, RemoteException {
        getVimService().deleteVRP(getMOR(), vrpId);
    }

    /**
     * Deploy a VM in a given VRP, hub pair. Before deployment, admission control is performed to make sure that VRP can
     * accommodate the VM's reservations. If the VM is already deployed in the same hub, the VM will remain deployed. The
     * API will just rerun the admission control checks.
     *
     * @param vrpId   The unique Id of the VRP.
     * @param vm      VirtualMachine to deploy
     * @param cluster Cluster to use.
     * @throws InsufficientResourcesFault
     * @throws NotFound
     * @throws InvalidState
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public void deployVM(String vrpId, VirtualMachine vm, ClusterComputeResource cluster) throws InsufficientResourcesFault, NotFound, InvalidState, RuntimeFault, RemoteException {
        getVimService().deployVM(getMOR(), vrpId, vm.getMOR(), cluster.getMOR());
    }

    /**
     * Get the list of Ids of all the Virtual Resource Pools in the system.
     *
     * @return List of Ids of all the Virtual Resource Pools in the system.
     * @throws InvalidState
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public String[] getAllVRPIds() throws InvalidState, RuntimeFault, RemoteException {
        return getVimService().getAllVRPIds(getMOR());
    }

    /**
     * Given the VRP Id and a hub, gets the associated child resource pool.
     *
     * @param vrpId ID of the VRP.
     * @param hub   ManagedEntity representing the hub.
     * @return A ResourcePool
     * @throws InvalidState
     * @throws NotFound
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public ResourcePool getChildRPforHub(String vrpId, ManagedEntity hub) throws InvalidState, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference rpMor = getVimService().getChildRPforHub(getMOR(), vrpId, hub.getMOR());
        return new ResourcePool(getServerConnection(), rpMor);
    }

    /**
     * Get ResourceConfigSpec for a resource pool that is under a member hub of some VRP. This is to get the settings
     * that DRS generated for that child resource pool. The setting might be absent for recently added resource pools.
     *
     * @param resourcePool The ResourcePool
     * @return ResourcePoolConfigSpec
     * @throws NotFound
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public ResourceConfigSpec getRPSettings(ResourcePool resourcePool) throws NotFound, RuntimeFault, RemoteException {
        return getVimService().getRPSettings(getMOR(), resourcePool.getMOR());
    }

    /**
     * Get the ID of the VRP a VM belongs to. If the VM does not belong to any VRP, the returned optional string will
     * not be set to any value.
     *
     * @param vm VirtualMachine to get VRP of
     * @return ID  of the VRP
     * @throws InvalidState
     * @throws NotFound
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public String getVRPofVM(VirtualMachine vm) throws InvalidState, NotFound, RuntimeFault, RemoteException {
        return getVimService().getVRPofVM(getMOR(), vm.getMOR());
    }

    /**
     * Get the settings for a VRP with the given Id if it exists. The returned VirtualResourcePoolSpec object will have
     * all of its fields populated.
     *
     * @param vrpId Id of the VRP.
     * @return VirtualResourcePoolSpec
     * @throws InvalidState
     * @throws NotFound
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public VirtualResourcePoolSpec getVRPSettings(String vrpId) throws InvalidState, NotFound, RuntimeFault, RemoteException {
        return getVimService().getVRPSettings(getMOR(), vrpId);
    }

    /**
     * Get the usage values for a VRP with the given Id.
     *
     * @param vrpId Id of the VRP.
     * @return VirtualResourcePoolUsage
     * @throws InvalidState
     * @throws NotFound
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public VirtualResourcePoolUsage getVRPUsage(String vrpId) throws InvalidState, NotFound, RuntimeFault, RemoteException {
        return getVimService().getVRPUsage(getMOR(), vrpId);
    }

    /**
     * Sets whether a cluster is managed by a Virtual Datacenter. Setting this to true will prevent users from disabling
     * DRS for the cluster.
     *
     * @param cluster Cluster object
     * @param status  True if the cluster is managed by a Virtual Datacenter
     * @throws InvalidState
     * @throws NotFound
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public void setManagedByVDC(ClusterComputeResource cluster, boolean status) throws InvalidState, NotFound, RuntimeFault, RemoteException {
        getVimService().setManagedByVDC(getMOR(), cluster.getMOR(), status);
    }

    /**
     * Undeploy a VM in given VRP, hub pair.
     *
     * @param vrpId   The unique Id of the VRP.
     * @param vm      VirtualMachine
     * @param cluster Cluster Object
     * @throws InvalidState
     * @throws NotFound
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public void undeployVM(String vrpId, VirtualMachine vm, ClusterComputeResource cluster) throws InvalidState, NotFound, RuntimeFault, RemoteException {
        getVimService().undeployVM(getMOR(), vrpId, vm.getMOR(), cluster.getMOR());
    }

    /**
     * Updates the configuration of an existing VRP.
     *
     * @param spec The VRP is updated to have this config. If any new hub is added, a child resource pool will be created under it. For removed hubs, their child resource pools will be deleted and all the VMs that were under those resource pools will be moved directly under the hub. If the hub is a cluster, the VMs will be moved to the root resource pool.
     * @throws InvalidState
     * @throws NotFound
     * @throws RuntimeFault
     * @throws RemoteException
     * @throws InsufficientResourcesFault
     */
    public void updateVRP(VRPEditSpec spec) throws InvalidState, NotFound, RuntimeFault, RemoteException, InsufficientResourcesFault {
        getVimService().updateVRP(getMOR(), spec);
    }
}
