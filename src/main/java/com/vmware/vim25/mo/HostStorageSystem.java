// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostStorageSystem extends ExtensibleManagedObject {

    public HostStorageSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostFileSystemVolumeInfo getFileSystemVolumeInfo() {
        return (HostFileSystemVolumeInfo) getCurrentProperty("fileSystemVolumeInfo");
    }

    public HostMultipathStateInfo getMultipathStateInfo() {
        return (HostMultipathStateInfo) getCurrentProperty("multipathStateInfo");
    }

    public HostStorageDeviceInfo getStorageDeviceInfo() {
        return (HostStorageDeviceInfo) getCurrentProperty("storageDeviceInfo");
    }

    public String[] getSystemFile() {
        return (String[]) getCurrentProperty("systemFile");
    }

    public void addInternetScsiSendTargets(String iScsiHbaDevice, HostInternetScsiHbaSendTarget[] targets) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().addInternetScsiSendTargets(getMOR(), iScsiHbaDevice, targets);
    }

    public void addInternetScsiStaticTargets(String iScsiHbaDevice, HostInternetScsiHbaStaticTarget[] targets) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().addInternetScsiStaticTargets(getMOR(), iScsiHbaDevice, targets);
    }

    public void attachScsiLun(String lunUuid) throws HostConfigFault, InvalidState, NotFound, RuntimeFault, RemoteException {
        getVimService().attachScsiLun(getMOR(), lunUuid);
    }

    public Task attachScsiLunEx(String[] lunUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().attachScsiLunEx_Task(getMOR(), lunUuid);
        return new Task(getServerConnection(), resultMor);
    }

    public void attachVmfsExtent(String vmfsPath, HostScsiDiskPartition extent) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().attachVmfsExtent(getMOR(), vmfsPath, extent);
    }

    public void changeNFSUserPassword(String password) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().changeNFSUserPassword(getMOR(), password);
    }

    public void clearNFSUser() throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().clearNFSUser(getMOR());
    }

    public void connectNvmeController(HostNvmeConnectSpec connectSpec) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().connectNvmeController(getMOR(), connectSpec);
    }

    public Task connectNvmeControllerEx(HostNvmeConnectSpec[] connectSpec) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().connectNvmeControllerEx_Task(getMOR(), connectSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public void createNvmeOverRdmaAdapter(String rdmaDeviceName) throws HostConfigFault, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().createNvmeOverRdmaAdapter(getMOR(), rdmaDeviceName);
    }

    public void createSoftwareAdapter(HostHbaCreateSpec spec) throws HostConfigFault, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().createSoftwareAdapter(getMOR(), spec);
    }

    public void deleteScsiLunState(String lunCanonicalName) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().deleteScsiLunState(getMOR(), lunCanonicalName);
    }

    public void deleteVffsVolumeState(String vffsUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().deleteVffsVolumeState(getMOR(), vffsUuid);
    }

    public void deleteVmfsVolumeState(String vmfsUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().deleteVmfsVolumeState(getMOR(), vmfsUuid);
    }

    public void destroyVffs(String vffsPath) throws HostConfigFault, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().destroyVffs(getMOR(), vffsPath);
    }

    public void detachScsiLun(String lunUuid) throws HostConfigFault, InvalidState, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().detachScsiLun(getMOR(), lunUuid);
    }

    public Task detachScsiLunEx(String[] lunUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().detachScsiLunEx_Task(getMOR(), lunUuid);
        return new Task(getServerConnection(), resultMor);
    }

    public void disableMultipathPath(String pathName) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().disableMultipathPath(getMOR(), pathName);
    }

    public void disconnectNvmeController(HostNvmeDisconnectSpec disconnectSpec) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().disconnectNvmeController(getMOR(), disconnectSpec);
    }

    public Task disconnectNvmeControllerEx(HostNvmeDisconnectSpec[] disconnectSpec) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().disconnectNvmeControllerEx_Task(getMOR(), disconnectSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public void discoverFcoeHbas(FcoeConfigFcoeSpecification fcoeSpec) throws FcoeFaultPnicHasNoPortSet, HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().discoverFcoeHbas(getMOR(), fcoeSpec);
    }

    public HostNvmeDiscoveryLog discoverNvmeControllers(HostNvmeDiscoverSpec discoverSpec) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        return getVimService().discoverNvmeControllers(getMOR(), discoverSpec);
    }

    public void enableMultipathPath(String pathName) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().enableMultipathPath(getMOR(), pathName);
    }

    public void expandVmfsExtent(String vmfsPath, HostScsiDiskPartition extent) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().expandVmfsExtent(getMOR(), vmfsPath, extent);
    }

    public void extendVffs(String vffsPath, String devicePath, HostDiskPartitionSpec spec) throws HostConfigFault, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().extendVffs(getMOR(), vffsPath, devicePath, spec);
    }

    public HostVffsVolume formatVffs(HostVffsSpec createSpec) throws AlreadyExists, HostConfigFault, ResourceInUse, RuntimeFault, RemoteException {
        return getVimService().formatVffs(getMOR(), createSpec);
    }

    public Task markAsLocal(String scsiDiskUuid) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().markAsLocal_Task(getMOR(), scsiDiskUuid);
        return new Task(getServerConnection(), resultMor);
    }

    public Task markAsNonLocal(String scsiDiskUuid) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().markAsNonLocal_Task(getMOR(), scsiDiskUuid);
        return new Task(getServerConnection(), resultMor);
    }

    public Task markAsNonSsd(String scsiDiskUuid) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().markAsNonSsd_Task(getMOR(), scsiDiskUuid);
        return new Task(getServerConnection(), resultMor);
    }

    public Task markAsSsd(String scsiDiskUuid) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().markAsSsd_Task(getMOR(), scsiDiskUuid);
        return new Task(getServerConnection(), resultMor);
    }

    public void markForRemoval(String hbaName, boolean remove) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().markForRemoval(getMOR(), hbaName, remove);
    }

    public void markPerenniallyReserved(String lunUuid, boolean state) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().markPerenniallyReserved(getMOR(), lunUuid, state);
    }

    public Task markPerenniallyReservedEx(String[] lunUuid, boolean state) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().markPerenniallyReservedEx_Task(getMOR(), lunUuid, state);
        return new Task(getServerConnection(), resultMor);
    }

    public void mountVffsVolume(String vffsUuid) throws HostConfigFault, InvalidState, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().mountVffsVolume(getMOR(), vffsUuid);
    }

    public void mountVmfsVolume(String vmfsUuid) throws HostConfigFault, InvalidState, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().mountVmfsVolume(getMOR(), vmfsUuid);
    }

    public Task mountVmfsVolumeEx(String[] vmfsUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().mountVmfsVolumeEx_Task(getMOR(), vmfsUuid);
        return new Task(getServerConnection(), resultMor);
    }

    public VmfsConfigOption[] queryVmfsConfigOption() throws RuntimeFault, RemoteException {
        return getVimService().queryVmfsConfigOption(getMOR());
    }

    public void refresh() throws RuntimeFault, RemoteException {
        getVimService().refreshStorageSystem(getMOR());
    }

    public void removeInternetScsiSendTargets(String iScsiHbaDevice, HostInternetScsiHbaSendTarget[] targets, boolean force) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().removeInternetScsiSendTargets(getMOR(), iScsiHbaDevice, targets, force);
    }

    public void removeInternetScsiStaticTargets(String iScsiHbaDevice, HostInternetScsiHbaStaticTarget[] targets) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().removeInternetScsiStaticTargets(getMOR(), iScsiHbaDevice, targets);
    }

    public void removeNvmeOverRdmaAdapter(String hbaDeviceName) throws HostConfigFault, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().removeNvmeOverRdmaAdapter(getMOR(), hbaDeviceName);
    }

    public void removeSoftwareAdapter(String hbaDeviceName) throws HostConfigFault, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().removeSoftwareAdapter(getMOR(), hbaDeviceName);
    }

    public void rescanAllHba() throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().rescanAllHba(getMOR());
    }

    public void rescanHba(String hbaDevice) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().rescanHba(getMOR(), hbaDevice);
    }

    public void rescanVffs() throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().rescanVffs(getMOR());
    }

    public void rescanVmfs() throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().rescanVmfs(getMOR());
    }

    public Task resolveMultipleUnresolvedVmfsVolumesEx(HostUnresolvedVmfsResolutionSpec[] resolutionSpec) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().resolveMultipleUnresolvedVmfsVolumesEx_Task(getMOR(), resolutionSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public void setMultipathLunPolicy(String lunId, HostMultipathInfoLogicalUnitPolicy policy) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().setMultipathLunPolicy(getMOR(), lunId, policy);
    }

    public void setNFSUser(String user, String password) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().setNFSUser(getMOR(), user, password);
    }

    public Task turnDiskLocatorLedOff(String[] scsiDiskUuids) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().turnDiskLocatorLedOff_Task(getMOR(), scsiDiskUuids);
        return new Task(getServerConnection(), resultMor);
    }

    public Task turnDiskLocatorLedOn(String[] scsiDiskUuids) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().turnDiskLocatorLedOn_Task(getMOR(), scsiDiskUuids);
        return new Task(getServerConnection(), resultMor);
    }

    public Task unmapVmfsVolumeEx(String[] vmfsUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().unmapVmfsVolumeEx_Task(getMOR(), vmfsUuid);
        return new Task(getServerConnection(), resultMor);
    }

    public void unmountForceMountedVmfsVolume(String vmfsUuid) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().unmountForceMountedVmfsVolume(getMOR(), vmfsUuid);
    }

    public void unmountVffsVolume(String vffsUuid) throws HostConfigFault, InvalidState, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().unmountVffsVolume(getMOR(), vffsUuid);
    }

    public void unmountVmfsVolume(String vmfsUuid) throws HostConfigFault, InvalidState, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().unmountVmfsVolume(getMOR(), vmfsUuid);
    }

    public Task unmountVmfsVolumeEx(String[] vmfsUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().unmountVmfsVolumeEx_Task(getMOR(), vmfsUuid);
        return new Task(getServerConnection(), resultMor);
    }

    public void updateDiskPartitions(String devicePath, HostDiskPartitionSpec spec) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateDiskPartitions(getMOR(), devicePath, spec);
    }

    public void updateHppMultipathLunPolicy(String lunId, HostMultipathInfoHppLogicalUnitPolicy policy) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateHppMultipathLunPolicy(getMOR(), lunId, policy);
    }

    public void updateInternetScsiAdvancedOptions(String iScsiHbaDevice, HostInternetScsiHbaTargetSet targetSet, HostInternetScsiHbaParamValue[] options) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateInternetScsiAdvancedOptions(getMOR(), iScsiHbaDevice, targetSet, options);
    }

    public void updateInternetScsiAlias(String iScsiHbaDevice, String iScsiAlias) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateInternetScsiAlias(getMOR(), iScsiHbaDevice, iScsiAlias);
    }

    public void updateInternetScsiAuthenticationProperties(String iScsiHbaDevice, HostInternetScsiHbaAuthenticationProperties authenticationProperties, HostInternetScsiHbaTargetSet targetSet) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateInternetScsiAuthenticationProperties(getMOR(), iScsiHbaDevice, authenticationProperties, targetSet);
    }

    public void updateInternetScsiDigestProperties(String iScsiHbaDevice, HostInternetScsiHbaTargetSet targetSet, HostInternetScsiHbaDigestProperties digestProperties) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateInternetScsiDigestProperties(getMOR(), iScsiHbaDevice, targetSet, digestProperties);
    }

    public void updateInternetScsiDiscoveryProperties(String iScsiHbaDevice, HostInternetScsiHbaDiscoveryProperties discoveryProperties) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateInternetScsiDiscoveryProperties(getMOR(), iScsiHbaDevice, discoveryProperties);
    }

    public void updateInternetScsiIPProperties(String iScsiHbaDevice, HostInternetScsiHbaIPProperties ipProperties) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateInternetScsiIPProperties(getMOR(), iScsiHbaDevice, ipProperties);
    }

    public void updateInternetScsiName(String iScsiHbaDevice, String iScsiName) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateInternetScsiName(getMOR(), iScsiHbaDevice, iScsiName);
    }

    public void updateScsiLunDisplayName(String lunUuid, String displayName) throws DuplicateName, HostConfigFault, InvalidName, NotFound, RuntimeFault, RemoteException {
        getVimService().updateScsiLunDisplayName(getMOR(), lunUuid, displayName);
    }

    public void updateSoftwareInternetScsiEnabled(boolean enabled) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().updateSoftwareInternetScsiEnabled(getMOR(), enabled);
    }

    public void updateVmfsUnmapBandwidth(String vmfsUuid, VmfsUnmapBandwidthSpec unmapBandwidthSpec) throws RuntimeFault, RemoteException {
        getVimService().updateVmfsUnmapBandwidth(getMOR(), vmfsUuid, unmapBandwidthSpec);
    }

    public void updateVmfsUnmapPriority(String vmfsUuid, String unmapPriority) throws RuntimeFault, RemoteException {
        getVimService().updateVmfsUnmapPriority(getMOR(), vmfsUuid, unmapPriority);
    }

    public void upgradeVmLayout() throws RuntimeFault, RemoteException {
        getVimService().upgradeVmLayout(getMOR());
    }

    public void upgradeVmfs(String vmfsPath) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().upgradeVmfs(getMOR(), vmfsPath);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    //SDK4.1 signature for back compatibility
public HostDiskPartitionInfo computeDiskPartitionInfo(String devicePath, HostDiskPartitionLayout layout) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
    return computeDiskPartitionInfo(devicePath, layout, null);
}
    //SDK5.0 signature
public HostDiskPartitionInfo computeDiskPartitionInfo(String devicePath, HostDiskPartitionLayout layout, String partitionFormat) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
    return getVimService().computeDiskPartitionInfo(getMOR(), devicePath, layout, partitionFormat);
}
    //SDK4.1 signature for back compatibility
public HostDiskPartitionInfo computeDiskPartitionInfoForResize(HostScsiDiskPartition partition, HostDiskPartitionBlockRange blockRange) throws NotFound, HostConfigFault, RuntimeFault, RemoteException {
    return computeDiskPartitionInfoForResize(partition, blockRange, null);
}
    //SDK5.0 signature
public HostDiskPartitionInfo computeDiskPartitionInfoForResize(HostScsiDiskPartition partition, HostDiskPartitionBlockRange blockRange, String partitionFormat) throws NotFound, HostConfigFault, RuntimeFault, RemoteException {
    return getVimService().computeDiskPartitionInfoForResize(getMOR(), partition, blockRange, partitionFormat);
}
    public HostVmfsVolume formatVmfs(HostVmfsSpec createSpec) throws HostConfigFault, AlreadyExists, RuntimeFault, RemoteException {
    return getVimService().formatVmfs(getMOR(), createSpec);
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
    public void removeInternetScsiSendTargets(String iScsiHbaDevice, HostInternetScsiHbaSendTarget[] targets) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
    removeInternetScsiSendTargets(iScsiHbaDevice, targets, false);
}
    /**
 * @since 4.0
 */
public HostUnresolvedVmfsResolutionResult[] resolveMultipleUnresolvedVmfsVolumes(HostUnresolvedVmfsResolutionSpec[] resolutionSpec) throws HostConfigFault, RuntimeFault, RemoteException {
    return getVimService().resolveMultipleUnresolvedVmfsVolumes(getMOR(), resolutionSpec);
}
    public HostDiskPartitionInfo[] retrieveDiskPartitionInfo(String[] devicePath) throws RuntimeFault, RemoteException {
    return getVimService().retrieveDiskPartitionInfo(getMOR(), devicePath);
}
    //SDK2.5 signature for back compatibility
public void updateInternetScsiAuthenticationProperties(String iScsiHbaDevice, HostInternetScsiHbaAuthenticationProperties authenticationProperties) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
    updateInternetScsiAuthenticationProperties(iScsiHbaDevice, authenticationProperties, null);
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
    /* ===== END custom ===== */
}
