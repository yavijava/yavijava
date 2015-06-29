/*================================================================================
Copyright (c) 2013 Steve Jin. All Rights Reserved.

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

import java.rmi.RemoteException;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 *
 * @author Steve JIN (http://www.doublecloud.org)
 * @author Michael Rice (http://errr-online.com/)
 * @since SDK5.5
 */

public class HostVsanInternalSystem extends ManagedObject {

    public HostVsanInternalSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    /**
     * Abdicate ownership of DOM objects. The objects must be currently owned by this host.
     * Which host has ownership of an object at a given point in time can be queried from
     * QueryVsanObjects() or QueryCmmds() APIs. Abidcating ownership tears down DOM owner
     * in-memory state. Hosts in the cluster will then compete to become the new owner of
     * the object, similar to a host failure event. There is a short interuption of IO flow
     * while the owner re-election is going on, but it is transparent to any consumers of the
     * object. This API is meant as a troubleshooting and debugging tool. It is internal
     * at this point and can be used to resolve issues where DOM owner gets "stuck".
     *
     * @param uuids List of VSAN/DOM object UUIDs.
     * @return String[]
     * @throws RemoteException
     * @throws RuntimeFault
     * @since 6.0
     */
    public String[] abdicateDomOwnership(String[] uuids) throws RuntimeFault, RemoteException {
        return getVimService().abdicateDomOwnership(getMOR(), uuids);
    }

    /**
     * Determine if given objects can be provisioned. Determines if the objects of the
     * given size can be provisioned with the given policies. The API is intended to
     * answer the question: can these objects be provisioned with the given policy using
     * the current cluster topology (#hosts and #disks) and does NOT take into account
     * free space on the disk, size of disks, etc. If the objects cannot be provisioned,
     * the API returns the reason for not being able to satisfy the policy. If the objects
     * can be provisioned, the API returns the cost of provisioning objects with this policy.
     * Please note: This API ignores forceProvisioning.
     *
     * @param npbs                 List of NewPolicyBatch structure with sizes and policies.
     * @param ignoreSatisfiability Optionally populate PolicyCost even though object cannot be provisioned in the current cluster topology.
     * @return List of PolicySatisfiability objects, one for each specified size.
     * @throws VimFault
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public VsanPolicySatisfiability[] canProvisionObjects(VsanNewPolicyBatch[] npbs, Boolean ignoreSatisfiability) throws VimFault, RuntimeFault, RemoteException {
        return getVimService().canProvisionObjects(getMOR(), npbs, ignoreSatisfiability);
    }

    public VsanPolicySatisfiability[] canProvisionObjects(VsanNewPolicyBatch[] npbs) throws VimFault, RuntimeFault, RemoteException {
        return canProvisionObjects(npbs, null);
    }

    /**
     * Delete VSAN objects. This API is internal and intended for troubleshooting/debugging only
     * WARNING: This API can be slow because we do IOs to all the objects. This API can be used
     * to delete VSAN objects. DOM won't allow access to objects which have lost quorum. Such
     * objects can be deleted with the optional "force" flag. These objects may however re-appear
     * with quorum if the absent components come back (network partition gets resolved, etc.)
     *
     * @param uuids List of object UUIDs to be deleted.
     * @param force Optional force delete.
     * @return List of DeleteVsanObjectsResult.
     * @throws RuntimeFault
     * @throws VimFault
     * @throws RemoteException
     * @since 6.0
     */
    public HostVsanInternalSystemDeleteVsanObjectsResult[] deleteVsanObjects(String[] uuids, Boolean force) throws RuntimeFault, VimFault, RemoteException {
        return getVimService().deleteVsanObjects(getMOR(), uuids, force);
    }

    public HostVsanInternalSystemDeleteVsanObjectsResult[] deleteVsanObjects(String[] uuids) throws RuntimeFault, VimFault, RemoteException {
        return deleteVsanObjects(uuids, null);
    }

    /**
     * Get VSAN object extended attributes. This API is internal and intended for troubleshooting/debugging situations
     * in the field. WARNING: This API can be slow because we do IOs (reads) to all the objects. This API can be used
     * to get extended attributes of any object in the VSAN cluster from any host provided the object is accessible
     * from that host. In case of an error, we return a dict with key "Error" for that object.
     *
     * @param uuids List of object UUIDs.
     * @return JSON string with the extended attributes.
     * @throws RuntimeFault
     * @throws RemoteException
     * @throws VimFault
     * @since 6.0
     */
    public String getVsanObjExtAttrs(String[] uuids) throws RuntimeFault, RemoteException, VimFault {
        return getVimService().getVsanObjExtAttrs(getMOR(), uuids);
    }

    /**
     * @param queries
     * @return
     * @throws RuntimeFault
     * @throws RemoteException
     * @deprecated use {@link HostVsanInternalSystem#queryCmmds(HostVsanInternalSystemCmmdsQuery[])}
     */
    public String QueryCmmds(HostVsanInternalSystemCmmdsQuery[] queries) throws RuntimeFault, RemoteException {
        return queryCmmds(queries);
    }

    public String queryCmmds(HostVsanInternalSystemCmmdsQuery[] queries) throws RuntimeFault, RemoteException {
        return getVimService().queryCmmds(this.getMOR(), queries);
    }

    public String queryObjectsOnPhysicalVsanDisk(String[] disks) throws RuntimeFault, RemoteException {
        return getVimService().queryObjectsOnPhysicalVsanDisk(this.getMOR(), disks);
    }

    public String queryPhysicalVsanDisks(String[] props) throws RuntimeFault, RemoteException {
        return getVimService().queryPhysicalVsanDisks(this.getMOR(), props);
    }

    /**
     * Query information about VSAN DOM objects that are currently syncing data. Instead of returning all objects,
     * only such objects are returned that are currently resyncing any stale components or syncing fresh replicas.
     * The API returns the same output format as queryVsanObjects(). It retrieves information about syncing all objects,
     * or retricts the search for syncing objects to the UUID list provided. In order to make this API efficient, the
     * output of this API contains the found DOM_OBJECT, and referenced LSOM_OBJECT and DISK entries.
     *
     * @param uuids List of VSAN/DOM object UUIDs to restrict search to.
     * @return JSON string with the results
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public String querySyncingVsanObjects(String[] uuids) throws RuntimeFault, RemoteException {
        return getVimService().querySyncingVsanObjects(getMOR(), uuids);
    }

    /**
     * Query VSAN object UUIDs by filtering conditions. The API queries CMMDS by given filtering conditions (initially
     * only for object version) and return object UUID in an array with limited elements count. If caller specified the
     * inputs objects UUID, then only these objects will be checked for the filtering conditions, and return ones which
     * satisfy the filtering condition. In this case, the 'limit' parameter will be ignored.
     *
     * @param uuids   Objects UUID will be checked against the filtering conditions.
     * @param limit   To limit the size of the result set.
     * @param version Filtering condition 1: object version.
     * @return String array of object uuids which satisfy the filtering conditions.
     * @throws VsanFault
     * @throws RemoteException
     * @throws RuntimeFault
     * @since 6.0
     */
    public String[] queryVsanObjectUuidsByFilter(String[] uuids, int limit, int version) throws VsanFault, RemoteException, RuntimeFault {
        return getVimService().queryVsanObjectUuidsByFilter(getMOR(), uuids, limit, version);
    }

    /**
     * Query VSAN system statistics. This is a low level API that gathers low level statistic counters from the system.
     * The details of the counters remain undocumented and unsupported at this point, and this API remains internal.
     * The data for this API call mostly comes from VSI, but also other tools like memstats. The caller can control
     * which counters are being retrieved by providing a list of labels.
     * The following labels are current supported: - TBD
     *
     * @param labels List of labels of counters to retrieve.
     * @return JSON string with the results
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public String queryVsanStatistics(String[] labels) throws RuntimeFault, RemoteException {
        return getVimService().queryVsanStatistics(getMOR(), labels);
    }

    /**
     * Determine if the given objects can be reconfigured with the given policies. The what-if determination only takes
     * into account the total number of hosts and total number of disks per host. The API is intended to answer the
     * question: is this reconfiguration possible using the current cluster topology (#hosts and #disks) and does NOT
     * take into account free space on the disk, size of disks, etc. If policy is not satisfiable, the API returns the
     * reason for not being able to satisfy the policy. If the policy is satisfiable, the API returns the cost of
     * provisioning objects with the new policy. This cost can be combined with current available free disk space to
     * compute if a particular operation is expected to succeed or fail.
     * Please note: This API ignores forceProvisioning.
     *
     * @param pcbs                 List of PolicyChangeBatch structure with uuids and policies.
     * @param ignoreSatisfiability Optionally populate PolicyCost even though object cannot be reconfigured in the current cluster topology.
     * @return List of PolicySatisfiability objects, one for each specified UUID.
     * @throws RemoteException
     * @throws RuntimeFault
     * @throws VimFault
     * @since 6.0
     */
    public VsanPolicySatisfiability[] reconfigurationSatisfiable(VsanPolicyChangeBatch[] pcbs, Boolean ignoreSatisfiability) throws RemoteException, RuntimeFault, VimFault {
        return getVimService().reconfigurationSatisfiable(getMOR(), pcbs, ignoreSatisfiability);
    }

    public VsanPolicySatisfiability[] reconfigurationSatisfiable(VsanPolicyChangeBatch[] pcbs) throws RemoteException, RuntimeFault, VimFault {
        return reconfigurationSatisfiable(pcbs, null);
    }

    /**
     * Reconfigure DOM object. Typically we expect VM centric APIs to be used for setting storage policies, i.e. to
     * use ReconfigVM() to change the policy/profile of a namespace directory or virtual disk. This is a low level API
     * to reconfigure any object known by UUID. This API is internal and intended for troubleshooting/debugging
     * situations in the field.
     *
     * @param uuid   DOM object UUID.
     * @param policy VSAN expression formatted policy string.
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public void reconfigureDomObject(String uuid, String policy) throws RuntimeFault, RemoteException {
        getVimService().reconfigureDomObject(getMOR(), uuid, policy);
    }

    /**
     * Runs diagnostics on VSAN physical disks. This method takes an active approach and creates a minimal and temporary
     * object on each physical MD disk consumed by VSAN across the entire VSAN cluster. The temporary objects are
     * deleted right away upon completion of creation. The result returns a list of all checked MDs, indicating wheather
     * or not there was a problem creating an object on that MD at the given point in time.
     *
     * @param disks List of VSAN disk UUIDs. If specified restricts the diagnostics run to VSAN disks present in the provided list.
     * @return A list of result structures. One per checked disk.
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public HostVsanInternalSystemVsanPhysicalDiskDiagnosticsResult[] runVsanPhysicalDiskDiagnostics(String[] disks) throws RuntimeFault, RemoteException {
        return getVimService().runVsanPhysicalDiskDiagnostics(getMOR(), disks);
    }

    /**
     * Upgrade VSAN objects version. Upgrade a set of objects' version to new one in batch mode. API caller should
     * limit the size of the inputs array, and suggested array size is 500 ~ 1000 initially. (The API will give more
     * realistic suggestion after more experiments, then will apply hard limits in future)
     *
     * @param uuids      The array of objects' UUID which will be upgraded.
     * @param newVersion The new version will be applied to objects.
     * @return
     * @throws RuntimeFault
     * @throws VsanFault
     * @throws RemoteException
     */
    public HostVsanInternalSystemVsanObjectOperationResult[] upgradeVsanObjects(String[] uuids, int newVersion) throws RuntimeFault, VsanFault, RemoteException {
        return getVimService().upgradeVsanObjects(getMOR(), uuids, newVersion);
    }

    public String queryVsanObjects(String[] uuids) throws RuntimeFault, RemoteException {
        return getVimService().queryVsanObjects(this.getMOR(), uuids);
    }

}