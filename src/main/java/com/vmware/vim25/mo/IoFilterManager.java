package com.vmware.vim25.mo;

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

import java.rmi.RemoteException;

import com.vmware.vim25.AlreadyExists;
import com.vmware.vim25.ClusterIoFilterInfo;
import com.vmware.vim25.FilterInUse;
import com.vmware.vim25.InvalidArgument;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.IoFilterQueryIssueResult;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.NotFound;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.VirtualDiskId;

/**
 * Interface to manage IO Filters installed on the ESXi hosts and IO Filter configurations on virtual disks. IO Filters
 * are customized filters provided by third parties to process I/Os to virtual disks. They can be used to provide data
 * services such as flash caching and replication. This interface is only supported on vCenter server.
 * 
 * @since vSphere API 6.0
 * 
 * @author Jaidil Karippara
 */
public class IoFilterManager extends ManagedObject {

    public IoFilterManager(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    /**
     * Install an IO Filter on a compute resource. IO Filters can only be installed on a cluster.
     * 
     * @param vibUrl
     *            - The URL that points to the IO Filter VIB package.
     * @param compRes
     *            - The compute resource to install the IO Filter on. "compRes" must be a cluster.
     * @return - This method returns a Task object with which to monitor the operation. The task is set to success if
     *         the filter is installed on all the hosts in the compute resource successfully. If the task fails, first
     *         check error to see the error. If the error indicates that installation has failed on the hosts, use
     *         QueryIoFilterIssues to get the detailed errors occured during installation on each host. The dynamic
     *         privilege check ensures that the user must have Host.Config.Patch privilege for all the hosts in the
     *         compute resource.
     * @throws AlreadyExists
     *             - Thrown if another VIB with the same name and vendor has been installed.
     * @throws InvalidArgument
     *             - Thrown if "compRes" is a standalone host.
     * @throws RuntimeFault
     *             - Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example,
     *             a communication error.
     * @throws RemoteException
     */
    public Task installIoFilter_Task(String vibUrl, ComputeResource compRes) throws AlreadyExists, InvalidArgument, RuntimeFault, RemoteException {
        return new Task(getServerConnection(), getVimService().installIoFilter_Task(getMOR(), vibUrl, compRes.getMOR()));
    }

    /**
     * Queries and return the list of virtual disks that use an IO Filter installed on a compute resource.
     *
     * @param filterId
     *            - ID of the filter.
     *
     * @param compRes
     *            - The compute resource. "compRes" must be a cluster.
     * @return VirtualDiskId[] - An array of VirtualDiskId objects that use the given IO Filter installed on the compute
     *         resource Filters that are installed on the compute resource.
     * @throws RemoteException
     * @throws RuntimeFault
     *             - Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example,
     *             a communication error.
     */
    public VirtualDiskId[] queryDisksUsingFilter(String filterId, ComputeResource compRes) throws RemoteException, RuntimeFault {
        return getVimService().queryDisksUsingFilter(getMOR(), filterId, compRes.getMOR());
    }

    /**
     * Queries and return the information for the IO Filters that are installed on the cluster.
     *
     * @param compRes
     *            - The compute resource. "compRes" must be a cluster.
     * @return ClusterIoFilterInfo[] - An array of ClusterIoFilterInfo objects that contain the information for the IO
     *         Filters that are installed on the compute resource.
     * @throws RemoteException
     * @throws RuntimeFault
     *             - Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example,
     *             a communication error.
     */
    public ClusterIoFilterInfo[] queryIoFilterInfo(ComputeResource compRes) throws RemoteException, RuntimeFault {
        return getVimService().queryIoFilterInfo(getMOR(), compRes.getMOR());
    }

    /**
     * Return the issues that occured during the last installation/uninstallation/upgrade operation of an IO Filter on a
     * compute resource
     *
     * @param filterId
     *            - ID of the filter.
     *
     * @param compRes
     *            - The compute resource. "compRes" must be a cluster.
     * @return IoFilterQueryIssueResult - Result for QueryIoFilterIssues. Filters that are installed on the compute
     *         resource.
     * @throws RemoteException
     * @throws RuntimeFault
     *             - Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example,
     *             a communication error.
     */
    public IoFilterQueryIssueResult queryIoFilterIssues(String filterId, ComputeResource compRes)
        throws RemoteException, RuntimeFault {
        return getVimService().queryIoFilterIssues(getMOR(), filterId, compRes.getMOR());
    }

    /**
     * Resolve the errors occured during an installation/uninstallation/upgrade operation of an IO Filter on a cluster.
     * Depending on the nature of the installation failure, vCenter will take the appropriate actions to resolve it. For
     * example, retry or resume installation.
     *
     * @param filterId
     *            - ID of the filter.
     * @param cluster
     *            - The compute resource to install the IO Filter on. "compRes" must be a cluster.
     * @return - This method returns a Task object with which to monitor the operation. The task is set to success if
     *         all the errors related to the filter are resolved on the cluster. If the task fails, first check error to
     *         see the error. If the error indicates that issues persist on the cluster, use QueryIoFilterIssues to get
     *         the detailed errors on the hosts in the cluster. The dynamic privilege check will ensure that the
     *         appropriate privileges must be acquired for all the hosts in the cluster based on the remediation
     *         actions. For example, Host.Config.Maintenance privilege and Host.Config.Patch privileges must be required
     *         for upgrading a VIB.
     * @throws RuntimeFault
     *             - Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example,
     *             a communication error.
     * @throws NotFound
     * @throws RemoteException
     */
    public Task resolveInstallationErrorsOnCluster_Task(String filterId, ClusterComputeResource cluster) throws NotFound, RuntimeFault, RemoteException {
        return new Task(getServerConnection(), getVimService().resolveInstallationErrorsOnCluster_Task(getMOR(), filterId, cluster.getMOR()));
    }

    /**
     * Resolve the errors occured during an installation/uninstallation/upgrade operation of an IO Filter on a host.
     * Depending on the nature of the installation failure, vCenter will take the appropriate actions to resolve it. For
     * example, retry or resume installation.
     *
     * @param filterId
     *            - ID of the filter.
     * @param host
     *            - The host to fix the issues on.
     * @return - This method returns a Task object with which to monitor the operation. The task is set to success if
     *         all the errors related to the filter are resolved on the cluster. If the task fails, first check error to
     *         see the error. If the error indicates that issues persist on the cluster, use QueryIoFilterIssues to get
     *         the detailed errors on the hosts in the cluster. The dynamic privilege check will ensure that the
     *         appropriate privileges must be acquired for all the hosts in the cluster based on the remediation
     *         actions. For example, Host.Config.Maintenance privilege and Host.Config.Patch privileges must be required
     *         for upgrading a VIB.
     * @throws RuntimeFault
     *             - Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example,
     *             a communication error.
     * @throws NotFound
     * @throws RemoteException
     */
    public Task resolveInstallationErrorsOnHost_Task(String filterId, HostSystem host) throws NotFound, RuntimeFault, RemoteException {
        return new Task(getServerConnection(), getVimService().resolveInstallationErrorsOnHost_Task(getMOR(), filterId, host.getMOR()));
    }

    /**
     * Uninstall an IO Filter on a compute resource. IO Filters can only be installed on a cluster.
     * 
     * @param filterId
     *            - ID of the filter.
     * @param cluster
     *            - The compute resource to install the IO Filter on. "compRes" must be a cluster.
     * @return - This method returns a Task object with which to monitor the operation. The task is set to success if
     *         the filter is installed on all the hosts in the compute resource successfully. If the task fails, first
     *         check error to see the error. If the error indicates that installation has failed on the hosts, use
     *         QueryIoFilterIssues to get the detailed errors occured during installation on each host. The dynamic
     *         privilege check ensures that the user must have Host.Config.Patch privilege for all the hosts in the
     *         compute resource.
     * @throws FilterInUse
     *             Thrown if the filter to be uninstalled is being used by a virtual disk.
     * @throws InvalidState
     *             Thrown if "compRes" is a cluster and DRS is disabled on the cluster.
     * @throws NotFound
     *             Thrown if the filter is not installed on the cluster. - Thrown if another VIB with the same name and
     *             vendor has been installed.
     * @throws InvalidArgument
     *             - Thrown if "compRes" is a standalone host.
     * @throws RuntimeFault
     *             - Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example,
     *             a communication error.
     * @throws RemoteException
     */
    public Task unInstallIoFilter_Task(String filterId, ComputeResource cluster) throws FilterInUse, InvalidArgument, InvalidState, NotFound, RuntimeFault, RemoteException {
        return new Task(getServerConnection(), getVimService().uninstallIoFilter_Task(getMOR(), filterId, cluster.getMOR()));
    }

    /**
     * Upgrade an IO Filter on a compute resource.
     * 
     * @param filterId
     *            - ID of the filter.
     * @param cluster
     *            - The compute resource to install the IO Filter on. "compRes" must be a cluster.
     * 
     * @param vibUrl
     *            - The URL that points to the IO Filter VIB package.
     *            
     * @return - This method returns a Task object with which to monitor the operation. The task is set to success if
     *         the filter is installed on all the hosts in the compute resource successfully. If the task fails, first
     *         check error to see the error. If the error indicates that installation has failed on the hosts, use
     *         QueryIoFilterIssues to get the detailed errors occured during installation on each host. The dynamic
     *         privilege check ensures that the user must have Host.Config.Patch privilege for all the hosts in the
     *         compute resource.
     * @throws InvalidState
     *             Thrown if "compRes" is a cluster and DRS is disabled on the cluster.
     * @throws NotFound
     *             Thrown if the filter is not installed on the cluster. - Thrown if another VIB with the same name and
     *             vendor has been installed.
     * @throws InvalidArgument
     *             - Thrown if "compRes" is a standalone host.
     * @throws RuntimeFault
     *             - Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example,
     *             a communication error.
     * @throws RemoteException
     */
    public Task upgradeIoFilter_Task(String filterId, ComputeResource cluster, String vibUrl) throws InvalidArgument, InvalidState, NotFound, RuntimeFault, RemoteException {
        return new Task(getServerConnection(), getVimService().upgradeIoFilter_Task(getMOR(), filterId, cluster.getMOR(), vibUrl));
    }
}
