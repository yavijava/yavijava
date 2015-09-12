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

import java.rmi.RemoteException;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 *
 * @author Steve JIN (http://www.doublecloud.org)
 */

public class HostStorageSystem extends ExtensibleManagedObject {

    public HostStorageSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostFileSystemVolumeInfo getFileSystemVolumeInfo() {
        return (HostFileSystemVolumeInfo) getCurrentProperty("fileSystemVolumeInfo");
    }

    /**
     * @since 4.0
     */
    public HostMultipathStateInfo getMultipathStateInfo() {
        return (HostMultipathStateInfo) getCurrentProperty("multipathStateInfo");
    }

    public HostStorageDeviceInfo getStorageDeviceInfo() {
        return (HostStorageDeviceInfo) getCurrentProperty("storageDeviceInfo");
    }

    /**
     * @since SDK4.1
     */
    public String[] getSystemFile() {
        return (String[]) getCurrentProperty("systemFile");
    }

    public void addInternetScsiSendTargets(String iScsiHbaDevice, HostInternetScsiHbaSendTarget[] targets) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().addInternetScsiSendTargets(getMOR(), iScsiHbaDevice, targets);
    }

    public void addInternetScsiStaticTargets(String iScsiHbaDevice, HostInternetScsiHbaStaticTarget[] targets) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().addInternetScsiStaticTargets(getMOR(), iScsiHbaDevice, targets);
    }

    /**
     * @since SDK5.0
     */
    public void attachScsiLun(String lunUuid) throws NotFound, HostConfigFault, InvalidState, RuntimeFault, RemoteException {
        getVimService().attachScsiLun(getMOR(), lunUuid);
    }

    public void attachVmfsExtent(String vmfsPath, HostScsiDiskPartition extent) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().attachVmfsExtent(getMOR(), vmfsPath, extent);
    }

    //SDK4.1 signature for back compatibility
    public HostDiskPartitionInfo computeDiskPartitionInfo(String devicePath, HostDiskPartitionLayout layout) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        return computeDiskPartitionInfo(devicePath, layout, null);
    }

    //SDK5.0 signature
    public HostDiskPartitionInfo computeDiskPartitionInfo(String devicePath, HostDiskPartitionLayout layout, String partitionFormat) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        return getVimService().computeDiskPartitionInfo(getMOR(), devicePath, layout, partitionFormat);
    }

    /**
     * @since 4.0
     */
    //SDK4.1 signature for back compatibility
    public HostDiskPartitionInfo computeDiskPartitionInfoForResize(HostScsiDiskPartition partition, HostDiskPartitionBlockRange blockRange) throws NotFound, HostConfigFault, RuntimeFault, RemoteException {
        return computeDiskPartitionInfoForResize(partition, blockRange, null);
    }

    //SDK5.0 signature
    public HostDiskPartitionInfo computeDiskPartitionInfoForResize(HostScsiDiskPartition partition, HostDiskPartitionBlockRange blockRange, String partitionFormat) throws NotFound, HostConfigFault, RuntimeFault, RemoteException {
        return getVimService().computeDiskPartitionInfoForResize(getMOR(), partition, blockRange, partitionFormat);
    }

    /**
     * @since SDK5.5
     */
    public void deleteVffsVolumeState(String vffsUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().deleteVffsVolumeState(this.getMOR(), vffsUuid);
    }

    /**
     * @since SDK5.5
     */
    public void destroyVffs(String vffsPath) throws NotFound, HostConfigFault, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().destroyVffs(this.getMOR(), vffsPath);
    }

    /**
     * @since SDK5.0
     */
    public void detachScsiLun(String lunUuid) throws NotFound, HostConfigFault, InvalidState, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().detachScsiLun(getMOR(), lunUuid);
    }

    public void disableMultipathPath(String pathName) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().disableMultipathPath(getMOR(), pathName);
    }

    /**
     * @since SDK5.0
     */
    public void discoverFcoeHbas(FcoeConfigFcoeSpecification fcoeSpec) throws FcoeFaultPnicHasNoPortSet, HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().discoverFcoeHbas(getMOR(), fcoeSpec);
    }

    public void enableMultipathPath(String pathName) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().enableMultipathPath(getMOR(), pathName);
    }

    /**
     * @since 4.0
     */
    public void expandVmfsExtent(String vmfsPath, HostScsiDiskPartition extent) throws NotFound, HostConfigFault, RuntimeFault, RemoteException {
        getVimService().expandVmfsExtent(getMOR(), vmfsPath, extent);
    }

    /**
     * @since SDK5.5
     */
    public void extendVffs(String vffsPath, String devicePath, HostDiskPartitionSpec spec) throws NotFound, HostConfigFault, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().extendVffs(this.getMOR(), vffsPath, devicePath, spec);
    }

    /**
     * @since SDK5.5
     */
    public void formatVffs(String vffsPath, String devicePath, HostVffsSpec createSpec) throws AlreadyExists, HostConfigFault, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().formatVffs(this.getMOR(), createSpec);
    }

    public HostVmfsVolume formatVmfs(HostVmfsSpec createSpec) throws HostConfigFault, AlreadyExists, RuntimeFault, RemoteException {
        return getVimService().formatVmfs(getMOR(), createSpec);
    }

    /**
     * @since SDK5.0
     */
    public void markForRemoval(String hbaName, boolean remove) throws NotFound, HostConfigFault, RuntimeFault, RemoteException {
        getVimService().markForRemoval(getMOR(), hbaName, remove);
    }

    /**
     * @since SDK5.5
     */
    public void mountVffsVolume(String vffsUuid) throws NotFound, InvalidState, HostConfigFault, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().mountVffsVolume(this.getMOR(), vffsUuid);
    }

    /**
     * @since SDK5.0
     */
    public void mountVmfsVolume(String vmfsUuid) throws NotFound, InvalidState, HostConfigFault, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().mountVmfsVolume(getMOR(), vmfsUuid);
    }

    /**
     * @since SDK5.5
     */
    public HostScsiDisk[] queryAvailableSsds(String vffsPath) throws NotFound, HostConfigFault, RuntimeFault, RemoteException {
        return getVimService().queryAvailableSsds(this.getMOR(), vffsPath);
    }

    /**
     * @since 4.0
     */
    public HostPathSelectionPolicyOption[] queryPathSelectionPolicyOptions() throws HostConfigFault, RuntimeFault, RemoteException {
        return getVimService().queryPathSelectionPolicyOptions(getMOR());
    }

    /**
     * @since 4.0
     */
    public HostStorageArrayTypePolicyOption[] queryStorageArrayTypePolicyOptions() throws HostConfigFault, RuntimeFault, RemoteException {
        return getVimService().queryStorageArrayTypePolicyOptions(getMOR());
    }

    /**
     * @since 4.0
     */
    public HostUnresolvedVmfsVolume[] queryUnresolvedVmfsVolume() throws RuntimeFault, RemoteException {
        return getVimService().queryUnresolvedVmfsVolume(getMOR());
    }

    public void refreshStorageSystem() throws RuntimeFault, RemoteException {
        getVimService().refreshStorageSystem(getMOR());
    }

    public void removeInternetScsiSendTargets(String iScsiHbaDevice, HostInternetScsiHbaSendTarget[] targets) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().removeInternetScsiSendTargets(getMOR(), iScsiHbaDevice, targets);
    }

    public void removeInternetScsiStaticTargets(String iScsiHbaDevice, HostInternetScsiHbaStaticTarget[] targets) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().removeInternetScsiStaticTargets(getMOR(), iScsiHbaDevice, targets);
    }

    public void rescanAllHba() throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().rescanAllHba(getMOR());
    }

    public void rescanHba(String hbaDevice) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().rescanHba(getMOR(), hbaDevice);
    }

    /**
     * @since SDK5.5
     */
    public void rescanVffs() throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().rescanVffs(this.getMOR());
    }

    public void rescanVmfs() throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().rescanVmfs(getMOR());
    }

    /**
     * @since 4.0
     */
    public HostUnresolvedVmfsResolutionResult[] resolveMultipleUnresolvedVmfsVolumes(HostUnresolvedVmfsResolutionSpec[] resolutionSpec) throws HostConfigFault, RuntimeFault, RemoteException {
        return getVimService().resolveMultipleUnresolvedVmfsVolumes(getMOR(), resolutionSpec);
    }

    /**
     * @since SDK5.5
     */
    public Task resolveMultipleUnresolvedVmfsVolumesEx_Task(HostUnresolvedVmfsResolutionSpec[] resolutionSpec) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference mor = getVimService().resolveMultipleUnresolvedVmfsVolumesEx_Task(this.getMOR(), resolutionSpec);
        return new Task(this.getServerConnection(), mor);
    }

    public HostDiskPartitionInfo[] retrieveDiskPartitionInfo(String[] devicePath) throws RuntimeFault, RemoteException {
        return getVimService().retrieveDiskPartitionInfo(getMOR(), devicePath);
    }

    public void setMultipathLunPolicy(String lunId, HostMultipathInfoLogicalUnitPolicy policy) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().setMultipathLunPolicy(getMOR(), lunId, policy);
    }

    /**
     * @since SDK4.0
     */
    public void unmountForceMountedVmfsVolume(String vmfsUuid) throws NotFound, HostConfigFault, RuntimeFault, RemoteException {
        getVimService().unmountForceMountedVmfsVolume(getMOR(), vmfsUuid);
    }

    /**
     * @since SDK5.5
     */
    public void unmountVffsVolume(String vffsUuid) throws NotFound, InvalidState, HostConfigFault, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().unmountVffsVolume(this.getMOR(), vffsUuid);
    }

    /**
     * @since SDK5.0
     */
    public void unmountVmfsVolume(String vmfsUuid) throws NotFound, InvalidState, HostConfigFault, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().unmountVmfsVolume(getMOR(), vmfsUuid);
    }

    public void updateDiskPartitions(String devicePath, HostDiskPartitionSpec spec) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateDiskPartitions(getMOR(), devicePath, spec);
    }

    public void updateInternetScsiAlias(String iScsiHbaDevice, String iScsiAlias) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateInternetScsiAlias(getMOR(), iScsiHbaDevice, iScsiAlias);
    }

    //SDK2.5 signature for back compatibility
    public void updateInternetScsiAuthenticationProperties(String iScsiHbaDevice, HostInternetScsiHbaAuthenticationProperties authenticationProperties)
        throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        updateInternetScsiAuthenticationProperties(iScsiHbaDevice, authenticationProperties, null);
    }

    //SDK4.0 signature
    public void updateInternetScsiAuthenticationProperties(String iScsiHbaDevice, HostInternetScsiHbaAuthenticationProperties authenticationProperties, HostInternetScsiHbaTargetSet targetSet)
        throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateInternetScsiAuthenticationProperties(getMOR(), iScsiHbaDevice, authenticationProperties, targetSet);
    }

    /**
     * @since 4.0
     */
    public void updateInternetScsiAdvancedOptions(String iScsiHbaDevice, HostInternetScsiHbaTargetSet targetSet, HostInternetScsiHbaParamValue[] options) throws NotFound, HostConfigFault, RuntimeFault, RemoteException {
        getVimService().updateInternetScsiAdvancedOptions(getMOR(), iScsiHbaDevice, targetSet, options);
    }

    /**
     * @since 4.0
     */
    public void updateInternetScsiDigestProperties(String iScsiHbaDevice, HostInternetScsiHbaTargetSet targetSet, HostInternetScsiHbaDigestProperties digestProperties) throws NotFound, HostConfigFault, RuntimeFault, RemoteException {
        getVimService().updateInternetScsiDigestProperties(getMOR(), iScsiHbaDevice, targetSet, digestProperties);
    }

    /**
     * @since 4.0
     */
    public void updateScsiLunDisplayName(String lunUuid, String displayName) throws NotFound, HostConfigFault, InvalidName, DuplicateName, RuntimeFault, RemoteException {
        getVimService().updateScsiLunDisplayName(getMOR(), lunUuid, displayName);
    }

    public void updateInternetScsiDiscoveryProperties(String iScsiHbaDevice, HostInternetScsiHbaDiscoveryProperties discoveryProperties)
        throws NotFound, RuntimeFault, RemoteException {
        getVimService().updateInternetScsiDiscoveryProperties(getMOR(), iScsiHbaDevice, discoveryProperties);
    }

    public void updateInternetScsiIPProperties(String iScsiHbaDevice, HostInternetScsiHbaIPProperties ipProperties)
        throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateInternetScsiIPProperties(getMOR(), iScsiHbaDevice, ipProperties);
    }

    public void updateInternetScsiName(String iScsiHbaDevice, String iScsiName) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateInternetScsiName(getMOR(), iScsiHbaDevice, iScsiName);
    }

    public void updateSoftwareInternetScsiEnabled(boolean enabled) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().updateSoftwareInternetScsiEnabled(getMOR(), enabled);
    }

    public void upgradeVmfs(String vmfsPath) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().upgradeVmfs(getMOR(), vmfsPath);
    }

    public void upgradeVmLayout(String vmfsPath) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().upgradeVmfs(getMOR(), vmfsPath);
    }

    /**
     * Attach one or more SCSI LUNs. This is an asynchronous, batch operation of attachScisLun.
     *
     * @param lunUuid each element specifies UUID of LUN to be attached.
     * @return Task
     * @throws HostConfigFault
     * @throws RuntimeFault
     * @throws RemoteException
     * @see #attachScsiLun(String) for operational details.
     * @since 6.0
     */
    public Task attachScsiLunEx_Task(String[] lunUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().attachScsiLunEx_Task(getMOR(), lunUuid);
        return new Task(getServerConnection(), taskMor);
    }

    /**
     * Change password for existing NFS user. This method shall be called after the NFS user has been created on the host.
     *
     * @param password New Password
     * @throws HostConfigFault
     * @throws NotFound
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public void changeNFSUserPassword(String password) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().changeNFSUserPassword(getMOR(), password);
    }

    /**
     * Clear the NFS user configured on the esx host
     *
     * @throws HostConfigFault
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public void clearNFSUser() throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().clearNFSUser(getMOR());
    }

    /**
     * Detach one or more SCSI LUNs. This is an asynchronous, batch operation of detachScisLun.
     *
     * @param lunUuid each element specifies UUID of LUN to be detached.
     * @return Task
     * @throws HostConfigFault
     * @throws RuntimeFault
     * @throws RemoteException
     * @see #detachScsiLun(String) ScsiLun for operational details.
     * @since 6.0
     */
    public Task detachScsiLunEx_Task(String[] lunUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().detachScsiLunEx_Task(getMOR(), lunUuid);
        return new Task(getServerConnection(), taskMor);
    }

    /**
     * Mark a disk to local disk, due to the reason that local disks behind some controllers might not be recognized as
     * local correctly. Task failure might lose existing claim rules on the disk.
     *
     * @param scsiDiskUuid The SCSI disk UUID.
     * @return Task
     * @throws HostConfigFault
     * @throws NotFound
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public Task markAsLocal_Task(String scsiDiskUuid) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().markAsLocal_Task(getMOR(), scsiDiskUuid);
        return new Task(getServerConnection(), taskMor);
    }

    /**
     * Mark a disk to remote disk, which is the opposite operation of {@link #markAsLocal_Task} Task failure might lose existing
     * claim rules on the disk.
     *
     * @param scsiDiskUuid The SCSI disk UUID.
     * @return Task
     * @throws HostConfigFault
     * @throws NotFound
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public Task markAsNonLocal_Task(String scsiDiskUuid) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().markAsNonLocal_Task(getMOR(), scsiDiskUuid);
        return new Task(getServerConnection(), taskMor);
    }

    /**
     * Mark a disk to SSD, due to the reason that SSDs behind some controllers might not be recognized as SSD correctly.
     * Task failure might lose existing claim rules on the disk.
     *
     * @param scsiDiskUuid The SCSI disk UUID.
     * @return Task
     * @throws HostConfigFault
     * @throws NotFound
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public Task markAsNonSsd_Task(String scsiDiskUuid) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().markAsNonSsd_Task(getMOR(), scsiDiskUuid);
        return new Task(getServerConnection(), taskMor);
    }

    /**
     * Mark a disk to SSD, due to the reason that SSDs behind some controllers might not be recognized as SSD correctly.
     * Task failure might lose existing claim rules on the disk.
     *
     * @param scsiDiskUuid The SCSI disk UUID.
     * @return Task
     * @throws HostConfigFault
     * @throws NotFound
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public Task markAsSsd_Task(String scsiDiskUuid) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().markAsSsd_Task(getMOR(), scsiDiskUuid);
        return new Task(getServerConnection(), taskMor);
    }

    /**
     * Mount one or more VMFS volumes. This is an asynchronous, batch operation of mountVmfsVolume.
     *
     * @param vmfsUuid each element specifies the UUID of a VMFS volume to be unmounted.
     * @return Task
     * @throws HostConfigFault
     * @throws RuntimeFault
     * @throws RemoteException
     * @see #mountVmfsVolume for operational details.
     * @since 6.0
     */
    public Task mountVmfsVolumeEx_Task(String[] vmfsUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().mountVmfsVolumeEx_Task(getMOR(), vmfsUuid);
        return new Task(getServerConnection(), taskMor);
    }

    /**
     * Query the NFS user configured on the esx host
     *
     * @return UserInfo objects. See {@link com.vmware.vim25.HostNasVolumeUserInfo}
     * @throws HostConfigFault
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public HostNasVolumeUserInfo queryNFSUser() throws HostConfigFault, RuntimeFault, RemoteException {
        return getVimService().queryNFSUser(getMOR());
    }

    /**
     * Set NFS username and password on the host. The specified password is stored encrypted at the host and overwrites
     * any previous password configuration. This information is only needed when the host has mounted NFS volumes with
     * security types that require user credentials for accessing data. The password is used to acquire credentials that
     * the NFS client needs to use in order to secure NFS traffic using RPCSECGSS. The client will access files on all
     * volumes mounted on this host (that are mounted with the relevant security type) on behalf of specified user.
     * <p>
     * At present, this API supports only file system NFSv4.1.
     *
     * @param user     Username
     * @param password Passowrd
     * @throws HostConfigFault
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public void setNFSUser(String user, String password) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().setNFSUser(getMOR(), user, password);
    }

    /**
     * Turn off one or more disk locator LEDs. This is a batch operation to turn off one or more disk locator LEDs,
     * which is the opposite operation of {@link #turnDiskLocatorLedOn_Task}
     *
     * @param scsiDiskUuids The SCSI disk UUIDs for which the disk locator LED should be turned off.
     * @return Task
     * @throws HostConfigFault
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public Task turnDiskLocatorLedOff_Task(String[] scsiDiskUuids) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().turnDiskLocatorLedOff_Task(getMOR(), scsiDiskUuids);
        return new Task(getServerConnection(), taskMor);
    }

    /**
     * Turn on one or more disk locator LEDs, duration is the maximum that hardware can support. This is a batch
     * operation to turn on one or more disk locator LEDs, so that user can easily locate the ScsiDisk on physical
     * infrastructure.
     *
     * @param scsiDiskUuids The SCSI disk UUIDs for which the disk locator LED should be turned on.
     * @return Task
     * @throws HostConfigFault
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public Task turnDiskLocatorLedOn_Task(String[] scsiDiskUuids) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().turnDiskLocatorLedOn_Task(getMOR(), scsiDiskUuids);
        return new Task(getServerConnection(), taskMor);
    }

    /**
     * Unmap one or more VMFS volumes. This is an asynchronous, batch operation. The operation unmaps free blocks in
     * each VMFS volume.
     *
     * @param vmfsUuid each element specifies the UUID of a VMFS volume to be unmapped.
     * @return Task
     * @throws HostConfigFault
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public Task unmapVmfsVolumeEx_Task(String[] vmfsUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().unmapVmfsVolumeEx_Task(getMOR(), vmfsUuid);
        return new Task(getServerConnection(), taskMor);
    }

    /**
     * Unmount one or more VMFS volumes. This is an asynchronous, batch operation of unmountVmfsVolume.
     *
     * @param vmfsUuid each element specifies the UUID of a VMFS volume to be unmounted.
     * @return Task
     * @throws HostConfigFault
     * @throws RuntimeFault
     * @throws RemoteException
     * @see #unmountVmfsVolume for operational details.
     * @since 6.0
     */
    public Task unmountVmfsVolumeEx_Task(String[] vmfsUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().unmountVmfsVolumeEx_Task(getMOR(), vmfsUuid);
        return new Task(getServerConnection(), taskMor);
    }
}
