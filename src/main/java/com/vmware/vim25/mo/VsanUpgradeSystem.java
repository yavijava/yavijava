package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;

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
public class VsanUpgradeSystem extends ManagedObject {

    public VsanUpgradeSystem(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    /**
     * Start VSAN on-disk format upgrade process on a particular cluster. In order to perform this on-disk format
     * upgrade, the upgrade process will perform a rolling evacuation/remove/re-add operation to accomplish the upgrade.
     * In other words, one disk group at a time, it will evacuate the data from the disk group, then remove the old
     * format from the now empty disk group, then reformat the disk group with the new format. Once all disk groups have
     * been upgraded, and if the performObjectUpgrade parameter is set, the VSAN object version is also upgraded. Before
     * the object version is upgraded, it is possible to downgrade the cluster by passing the downgradeFormat parameter.
     * Once objects are of the new object version however, downgrade (and thus rollback) are no longer possible. The new
     * object version is required to allow objects to benefit from new VSAN features. This is a long running (hours to
     * days) task. In addition to normal task progress reporting, use the queryUpgradeStatus() API which allows to
     * retrieve in-depth status updates from the upgrade process. In there will be a detailed log of every operation the
     * upgrade process has taken or issues it encountered. Some are simple log messages, others refer to operations like
     * evacuating a disk group. For such log entries, the task object of the evacuation task is provided to allow
     * "sub-task" tracking. Before starting, the upgrade process will perform a pre-flight check, and abort if any of
     * the pre-conditions are not met.
     *
     * @param cluster                The cluster to be upgraded
     * @param performObjectUpgrade   After all disk groups have been updated, also upgrade all objects. Once started, rollback of the on disk format is no longer possible. Object upgrade unlocks new VSAN features.
     * @param downgradeFormat        Perform a on-disk format downgrade instead of upgrade. Only possible if no upgraded objects exist.
     * @param allowReducedRedundancy Removes the need for one disk group worth of free space, by allowing reduced redundancy during disk upgrade.
     * @param excludeHosts           Internal debug option meant for functional testing of VSAN upgrades. Skips upgrade on certain hosts and implies performObjectUpgrade being false. Should not be used by customers.
     * @return Task to monitor for status.
     * @throws RuntimeFault
     * @throws VsanFault
     * @throws RemoteException
     * @see #performVsanUpgradePreflightCheck performVsanUpgradePreflightCheck
     */
    public Task performVsanUpgrade_Task(ClusterComputeResource cluster, Boolean performObjectUpgrade,
                                        Boolean downgradeFormat, Boolean allowReducedRedundancy, HostSystem[] excludeHosts)
        throws RuntimeFault, VsanFault, RemoteException {
        ManagedObjectReference[] mors = excludeHosts == null ? null : MorUtil.createMORs(excludeHosts);
        ManagedObjectReference taskMor = getVimService().performVsanUpgrade_Task(getMOR(), cluster.getMOR(), performObjectUpgrade,
            downgradeFormat, allowReducedRedundancy, mors);
        return new Task(getServerConnection(), taskMor);
    }

    /**
     * Start VSAN on-disk format upgrade process on a particular cluster. In order to perform this on-disk format
     * upgrade, the upgrade process will perform a rolling evacuation/remove/re-add operation to accomplish the upgrade.
     * In other words, one disk group at a time, it will evacuate the data from the disk group, then remove the old
     * format from the now empty disk group, then reformat the disk group with the new format. Once all disk groups have
     * been upgraded, and if the performObjectUpgrade parameter is set, the VSAN object version is also upgraded. Before
     * the object version is upgraded, it is possible to downgrade the cluster by passing the downgradeFormat parameter.
     * Once objects are of the new object version however, downgrade (and thus rollback) are no longer possible. The new
     * object version is required to allow objects to benefit from new VSAN features. This is a long running (hours to
     * days) task. In addition to normal task progress reporting, use the queryUpgradeStatus() API which allows to
     * retrieve in-depth status updates from the upgrade process. In there will be a detailed log of every operation the
     * upgrade process has taken or issues it encountered. Some are simple log messages, others refer to operations like
     * evacuating a disk group. For such log entries, the task object of the evacuation task is provided to allow
     * "sub-task" tracking. Before starting, the upgrade process will perform a pre-flight check, and abort if any of
     * the pre-conditions are not met.
     *
     * @param cluster                The cluster to be upgraded
     * @param performObjectUpgrade   After all disk groups have been updated, also upgrade all objects. Once started, rollback of the on disk format is no longer possible. Object upgrade unlocks new VSAN features.
     * @param downgradeFormat        Perform a on-disk format downgrade instead of upgrade. Only possible if no upgraded objects exist.
     * @param allowReducedRedundancy Removes the need for one disk group worth of free space, by allowing reduced redundancy during disk upgrade.
     * @return Task to monitor
     * @throws RuntimeFault
     * @throws VsanFault
     * @throws RemoteException
     * @see #performVsanUpgradePreflightCheck performVsanUpgradePreflightCheck
     */
    public Task performVsanUpgrade_Task(ClusterComputeResource cluster, Boolean performObjectUpgrade,
                                        Boolean downgradeFormat, Boolean allowReducedRedundancy)
        throws RuntimeFault, VsanFault, RemoteException {
        return performVsanUpgrade_Task(cluster, performObjectUpgrade, downgradeFormat, allowReducedRedundancy, null);
    }

    /**
     * Start VSAN on-disk format upgrade process on a particular cluster. In order to perform this on-disk format
     * upgrade, the upgrade process will perform a rolling evacuation/remove/re-add operation to accomplish the upgrade.
     * In other words, one disk group at a time, it will evacuate the data from the disk group, then remove the old
     * format from the now empty disk group, then reformat the disk group with the new format. Once all disk groups have
     * been upgraded, and if the performObjectUpgrade parameter is set, the VSAN object version is also upgraded. Before
     * the object version is upgraded, it is possible to downgrade the cluster by passing the downgradeFormat parameter.
     * Once objects are of the new object version however, downgrade (and thus rollback) are no longer possible. The new
     * object version is required to allow objects to benefit from new VSAN features. This is a long running (hours to
     * days) task. In addition to normal task progress reporting, use the queryUpgradeStatus() API which allows to
     * retrieve in-depth status updates from the upgrade process. In there will be a detailed log of every operation the
     * upgrade process has taken or issues it encountered. Some are simple log messages, others refer to operations like
     * evacuating a disk group. For such log entries, the task object of the evacuation task is provided to allow
     * "sub-task" tracking. Before starting, the upgrade process will perform a pre-flight check, and abort if any of
     * the pre-conditions are not met.
     *
     * @param cluster              The cluster to be upgraded
     * @param performObjectUpgrade After all disk groups have been updated, also upgrade all objects. Once started, rollback of the on disk format is no longer possible. Object upgrade unlocks new VSAN features.
     * @param downgradeFormat      Perform a on-disk format downgrade instead of upgrade. Only possible if no upgraded objects exist.
     * @return Task to monitor
     * @throws RuntimeFault
     * @throws VsanFault
     * @throws RemoteException
     * @see #performVsanUpgradePreflightCheck performVsanUpgradePreflightCheck
     */
    public Task performVsanUpgrade_Task(ClusterComputeResource cluster, Boolean performObjectUpgrade, Boolean downgradeFormat)
        throws RuntimeFault, VsanFault, RemoteException {
        return performVsanUpgrade_Task(cluster, performObjectUpgrade, downgradeFormat, null, null);
    }

    /**
     * Start VSAN on-disk format upgrade process on a particular cluster. In order to perform this on-disk format
     * upgrade, the upgrade process will perform a rolling evacuation/remove/re-add operation to accomplish the upgrade.
     * In other words, one disk group at a time, it will evacuate the data from the disk group, then remove the old
     * format from the now empty disk group, then reformat the disk group with the new format. Once all disk groups have
     * been upgraded, and if the performObjectUpgrade parameter is set, the VSAN object version is also upgraded. Before
     * the object version is upgraded, it is possible to downgrade the cluster by passing the downgradeFormat parameter.
     * Once objects are of the new object version however, downgrade (and thus rollback) are no longer possible. The new
     * object version is required to allow objects to benefit from new VSAN features. This is a long running (hours to
     * days) task. In addition to normal task progress reporting, use the queryUpgradeStatus() API which allows to
     * retrieve in-depth status updates from the upgrade process. In there will be a detailed log of every operation the
     * upgrade process has taken or issues it encountered. Some are simple log messages, others refer to operations like
     * evacuating a disk group. For such log entries, the task object of the evacuation task is provided to allow
     * "sub-task" tracking. Before starting, the upgrade process will perform a pre-flight check, and abort if any of
     * the pre-conditions are not met.
     *
     * @param cluster              The cluster to be upgraded
     * @param performObjectUpgrade After all disk groups have been updated, also upgrade all objects. Once started, rollback of the on disk format is no longer possible. Object upgrade unlocks new VSAN features.
     * @return Task to monitor
     * @throws RuntimeFault
     * @throws VsanFault
     * @throws RemoteException
     * @see #performVsanUpgradePreflightCheck performVsanUpgradePreflightCheck
     */
    public Task performVsanUpgrade_Task(ClusterComputeResource cluster, Boolean performObjectUpgrade) throws RuntimeFault, VsanFault, RemoteException {
        return performVsanUpgrade_Task(cluster, performObjectUpgrade, null, null, null);
    }

    /**
     * Start VSAN on-disk format upgrade process on a particular cluster. In order to perform this on-disk format
     * upgrade, the upgrade process will perform a rolling evacuation/remove/re-add operation to accomplish the upgrade.
     * In other words, one disk group at a time, it will evacuate the data from the disk group, then remove the old
     * format from the now empty disk group, then reformat the disk group with the new format. Once all disk groups have
     * been upgraded, and if the performObjectUpgrade parameter is set, the VSAN object version is also upgraded. Before
     * the object version is upgraded, it is possible to downgrade the cluster by passing the downgradeFormat parameter.
     * Once objects are of the new object version however, downgrade (and thus rollback) are no longer possible. The new
     * object version is required to allow objects to benefit from new VSAN features. This is a long running (hours to
     * days) task. In addition to normal task progress reporting, use the queryUpgradeStatus() API which allows to
     * retrieve in-depth status updates from the upgrade process. In there will be a detailed log of every operation the
     * upgrade process has taken or issues it encountered. Some are simple log messages, others refer to operations like
     * evacuating a disk group. For such log entries, the task object of the evacuation task is provided to allow
     * "sub-task" tracking. Before starting, the upgrade process will perform a pre-flight check, and abort if any of
     * the pre-conditions are not met.
     *
     * @param cluster The cluster to be upgraded
     * @return Task to monitor
     * @throws RuntimeFault
     * @throws VsanFault
     * @throws RemoteException
     * @see #performVsanUpgradePreflightCheck performVsanUpgradePreflightCheck
     */
    public Task performVsanUpgrade_Task(ClusterComputeResource cluster) throws RuntimeFault, VsanFault, RemoteException {
        return performVsanUpgrade_Task(cluster, null, null, null, null);
    }

    /**
     * Perform an upgrade pre-flight check on a cluster.
     *
     * @param cluster         The cluster for which to perform the check.
     * @param downgradeFormat Intend to perform a on-disk format downgrade instead of upgrade. Adds additional checks.
     * @return Pre-flight check result.
     * @throws RuntimeFault
     * @throws VsanFault
     * @throws RemoteException
     */
    public VsanUpgradeSystemPreflightCheckResult performVsanUpgradePreflightCheck(ClusterComputeResource cluster, Boolean downgradeFormat) throws RuntimeFault, VsanFault, RemoteException {
        return getVimService().performVsanUpgradePreflightCheck(getMOR(), cluster.getMOR(), downgradeFormat);
    }

    /**
     * Perform an upgrade pre-flight check on a cluster.
     *
     * @param cluster The cluster for which to perform the check.
     * @return Pre-flight check result.
     * @throws RuntimeFault
     * @throws VsanFault
     * @throws RemoteException
     */
    public VsanUpgradeSystemPreflightCheckResult performVsanUpgradePreflightCheck(ClusterComputeResource cluster) throws RuntimeFault, VsanFault, RemoteException {
        return performVsanUpgradePreflightCheck(cluster, null);
    }

    /**
     * Retrieve the latest status of a running, or the previously completed, upgrade process. Information about previous
     * upgrade runs are not always, e.g. when VC gets restarted.
     *
     * @param cluster The cluster for which to retrieve the upgrade status.
     * @return Status
     * @throws RuntimeFault
     * @throws VsanFault
     * @throws RemoteException
     */
    public VsanUpgradeSystemUpgradeStatus queryVsanUpgradeStatus(ClusterComputeResource cluster) throws RuntimeFault, VsanFault, RemoteException {
        return getVimService().queryVsanUpgradeStatus(getMOR(), cluster.getMOR());
    }
}
