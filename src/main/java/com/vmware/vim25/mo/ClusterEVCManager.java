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
 */

/**
 * @since 6.0
 */
public class ClusterEVCManager extends ExtensibleManagedObject {

    /**
     * EVC-related state of the managed cluster.
     */
    public ClusterEVCManagerEVCState getEvcState() {
        return (ClusterEVCManagerEVCState) getCurrentProperty("evcState");
    }

    /**
     * Cluster associated with this manager object.
     */
    public ClusterComputeResource getManagedCluster() {
        return (ClusterComputeResource) getCurrentProperty("managedCluster");
    }

    /**
     * Class Constructor
     *
     * @param serverConnection ServerConnection
     * @param mor              ManagedObjectReference
     * @see com.vmware.vim25.mo.ServerConnection
     * @see com.vmware.vim25.ManagedObjectReference
     */
    public ClusterEVCManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    /**
     * Test the validity of adding a host into the managed cluster.
     * Note that this method only tests EVC admission control; host-add may fail for other reasons.
     *
     * @param hostConnectSpec The spec that will be used to add the host.
     * @return Task with which to monitor the operation.
     * @throws GatewayConnectFault Thrown if the host is managed via gateway and attempts to connect to the host have failed. A more specific subclass may be thrown.
     * @throws HostConnectFault    Thrown if an error occurred when attempting to connect to the host. Typically, a more specific subclass is thrown.
     * @throws InvalidLogin        Thrown if authentication with the host fails.
     * @throws RuntimeFault        Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
     * @throws RemoteException
     * @see com.vmware.vim25.HostConnectSpec
     */
    public Task checkAddHostEvc_Task(HostConnectSpec hostConnectSpec) throws GatewayConnectFault, HostConnectFault, InvalidLogin, RuntimeFault, RemoteException {
        ManagedObjectReference task = getVimService().checkAddHostEvc_Task(getMOR(), hostConnectSpec);
        return new Task(getServerConnection(), task);
    }

    /**
     * Test the validity of configuring an EVC mode on the managed cluster.
     *
     * @param evcModeKey A key referencing the desired EVC mode.
     * @return Task with which to monitor the operation.
     * @throws RuntimeFault    Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
     * @throws RemoteException
     */
    public Task checkConfigureEvcMode_Task(String evcModeKey) throws RuntimeFault, RemoteException {
        ManagedObjectReference task = getVimService().checkConfigureEvcMode_Task(getMOR(), evcModeKey);
        return new Task(getServerConnection(), task);
    }

    /**
     * Set the EVC mode. If EVC is currently disabled, then this will enable EVC.
     * The parameter must specify a key to one of the EVC modes listed in the supportedEVCMode
     * array property. If there are no modes listed there, then EVC may not currently be enabled;
     * reference the other properties in EVCState to determine what conditions are blocking EVC.
     *
     * @param evcModeKey A key referencing the desired EVC mode.
     * @return Task with which to monitor the operation
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public Task configureEvcMode_Task(String evcModeKey) throws RuntimeFault, RemoteException, EVCConfigFault {
        ManagedObjectReference task = getVimService().configureEvcMode_Task(getMOR(), evcModeKey);
        return new Task(getServerConnection(), task);
    }

    /**
     * Disable EVC. EVC may be disabled at any time.
     *
     * @return Task with which to monitor the operation.
     * @throws RuntimeFault    Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
     * @throws RemoteException
     */
    public Task disableEvcMode_Task() throws RuntimeFault, RemoteException {
        ManagedObjectReference task = getVimService().disableEvcMode_Task(getMOR());
        return new Task(getServerConnection(), task);
    }
}
