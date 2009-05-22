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

import java.rmi.RemoteException;

import com.vmware.vim25.*;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 * @author Steve JIN (sjin@vmware.com)
 */

public class HostStorageSystem extends ExtensibleManagedObject 
{

	public HostStorageSystem(ServerConnection serverConnection, ManagedObjectReference mor) 
	{
		super(serverConnection, mor);
	}

	public HostFileSystemVolumeInfo getFileSystemVolumeInfo()
	{
		return (HostFileSystemVolumeInfo) getCurrentProperty("fileSystemVolumeInfo");
	}
	
	/**
	 * @since 4.0
	 */
	public HostMultipathStateInfo getMultipathStateInfo()
	{
		return (HostMultipathStateInfo) getCurrentProperty("multipathStateInfo");
	}

	public HostStorageDeviceInfo getStorageDeviceInfo()
	{
		return (HostStorageDeviceInfo) getCurrentProperty("storageDeviceInfo");
	}
	
	public void addInternetScsiSendTargets(String iScsiHbaDevice, HostInternetScsiHbaSendTarget[] targets) throws HostConfigFault, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().addInternetScsiSendTargets(getMOR(), iScsiHbaDevice, targets);
	}
	
	public void addInternetScsiStaticTargets(String iScsiHbaDevice, HostInternetScsiHbaStaticTarget[] targets) throws HostConfigFault, NotFound, RuntimeFault, RemoteException
	{
		getVimService().addInternetScsiStaticTargets(getMOR(), iScsiHbaDevice, targets);
	}
	
	public void attachVmfsExtent(String vmfsPath, HostScsiDiskPartition extent) throws HostConfigFault, NotFound, RuntimeFault, RemoteException
	{
		getVimService().attachVmfsExtent(getMOR(), vmfsPath, extent);
	}
	
	public HostDiskPartitionInfo computeDiskPartitionInfo(String devicePath, HostDiskPartitionLayout layout) throws HostConfigFault, NotFound, RuntimeFault, RemoteException
	{
		return getVimService().computeDiskPartitionInfo(getMOR(), devicePath, layout);
	}

	/**
	 * @since 4.0
	 */
	public HostDiskPartitionInfo computeDiskPartitionInfoForResize(HostScsiDiskPartition partition, HostDiskPartitionBlockRange blockRange) throws NotFound, HostConfigFault, RuntimeFault, RemoteException
	{
		return getVimService().computeDiskPartitionInfoForResize(getMOR(), partition, blockRange);
	}
	
	public void disableMultipathPath(String pathName) throws HostConfigFault, NotFound, RuntimeFault, RemoteException
	{
		getVimService().disableMultipathPath(getMOR(), pathName);
	}
	
	public void enableMultipathPath(String pathName) throws HostConfigFault, NotFound, RuntimeFault, RemoteException
	{
		getVimService().enableMultipathPath(getMOR(), pathName);
	}
	
	/**
	 * @since 4.0
	 */
	public void expandVmfsExtent(String vmfsPath, HostScsiDiskPartition extent) throws NotFound, HostConfigFault, RuntimeFault, RemoteException
	{
		getVimService().expandVmfsExtent(getMOR(), vmfsPath, extent);
	}
	
	public HostVmfsVolume formatVmfs(HostVmfsSpec createSpec) throws HostConfigFault, AlreadyExists, RuntimeFault, RemoteException
	{
		return getVimService().formatVmfs(getMOR(), createSpec);
	}
	
	/**
	 * @since 4.0
	 */
	public HostPathSelectionPolicyOption[] queryPathSelectionPolicyOptions() throws HostConfigFault, RuntimeFault, RemoteException
	{
		return getVimService().queryPathSelectionPolicyOptions(getMOR());
	}
	
	/**
	 * @since 4.0
	 */
	public HostStorageArrayTypePolicyOption[] queryStorageArrayTypePolicyOptions() throws HostConfigFault, RuntimeFault, RemoteException
	{
		return getVimService().queryStorageArrayTypePolicyOptions(getMOR());
	}

	/**
	 * @since 4.0
	 */
	public HostUnresolvedVmfsVolume[] queryUnresolvedVmfsVolume() throws RuntimeFault, RemoteException
	{
		return getVimService().queryUnresolvedVmfsVolume(getMOR());
	}
	
	public void refreshStorageSystem() throws RuntimeFault, RemoteException
	{
		getVimService().refreshStorageSystem(getMOR());
	}
	
	public void removeInternetScsiSendTargets(String iScsiHbaDevice,HostInternetScsiHbaSendTarget[] targets) throws HostConfigFault, NotFound, RuntimeFault, RemoteException
	{
		getVimService().removeInternetScsiSendTargets(getMOR(), iScsiHbaDevice, targets);
	}
	
	public void removeInternetScsiStaticTargets(String iScsiHbaDevice,HostInternetScsiHbaStaticTarget[] targets) throws HostConfigFault, NotFound, RuntimeFault, RemoteException
	{
		getVimService().removeInternetScsiStaticTargets(getMOR(), iScsiHbaDevice, targets);
	}
	
	public void rescanAllHba() throws HostConfigFault, RuntimeFault, RemoteException
	{
		getVimService().rescanAllHba(getMOR());
	}
	
	public void rescanHba(String hbaDevice) throws HostConfigFault, NotFound, RuntimeFault, RemoteException 
	{
		getVimService().rescanHba(getMOR(), hbaDevice);
	}
	
	public void rescanVmfs() throws HostConfigFault, RuntimeFault, RemoteException
	{
		getVimService().rescanVmfs(getMOR());
	}
	
	/**
	 * @since 4.0
	 */
	public HostUnresolvedVmfsResolutionResult[] resolveMultipleUnresolvedVmfsVolumes(HostUnresolvedVmfsResolutionSpec[] resolutionSpec) throws HostConfigFault, RuntimeFault, RemoteException
	{
		return getVimService().resolveMultipleUnresolvedVmfsVolumes(getMOR(), resolutionSpec);
	}
	
	public HostDiskPartitionInfo[] retrieveDiskPartitionInfo(String[] devicePath) throws RuntimeFault, RemoteException
	{
		return getVimService().retrieveDiskPartitionInfo(getMOR(), devicePath);
	}
	
	public void setMultipathLunPolicy(String lunId, HostMultipathInfoLogicalUnitPolicy policy) throws HostConfigFault, NotFound, RuntimeFault, RemoteException
	{
		getVimService().setMultipathLunPolicy(getMOR(), lunId, policy);
	}
	
	public void updateDiskPartitions(String devicePath, HostDiskPartitionSpec spec) throws HostConfigFault, NotFound, RuntimeFault, RemoteException
	{
		getVimService().updateDiskPartitions(getMOR(), devicePath, spec);
	}
	
	public void updateInternetScsiAlias(String iScsiHbaDevice, String iScsiAlias) throws HostConfigFault, NotFound, RuntimeFault, RemoteException
	{
		getVimService().updateInternetScsiAlias(getMOR(), iScsiHbaDevice, iScsiAlias);
	}
	
	//SDK2.5 signature for back compatibility
	public void updateInternetScsiAuthenticationProperties(String iScsiHbaDevice, HostInternetScsiHbaAuthenticationProperties authenticationProperties) 
		throws HostConfigFault, NotFound, RuntimeFault, RemoteException
	{
		updateInternetScsiAuthenticationProperties(iScsiHbaDevice, authenticationProperties, null);
	}
	
	//SDK4.0 signature
	public void updateInternetScsiAuthenticationProperties(String iScsiHbaDevice, HostInternetScsiHbaAuthenticationProperties authenticationProperties, HostInternetScsiHbaTargetSet targetSet) 
		throws HostConfigFault, NotFound, RuntimeFault, RemoteException
	{
		getVimService().updateInternetScsiAuthenticationProperties(getMOR(), iScsiHbaDevice, authenticationProperties, targetSet);
	}

	/**
	 * @since 4.0
	 */
	public void updateInternetScsiAdvancedOptions(String iScsiHbaDevice, HostInternetScsiHbaTargetSet targetSet, HostInternetScsiHbaParamValue[] options) throws NotFound, HostConfigFault, RuntimeFault, RemoteException
	{
		getVimService().updateInternetScsiAdvancedOptions(getMOR(), iScsiHbaDevice, targetSet, options);
	}

	/**
	 * @since 4.0
	 */
	public void updateInternetScsiDigestProperties(String iScsiHbaDevice, HostInternetScsiHbaTargetSet targetSet, HostInternetScsiHbaDigestProperties digestProperties) throws NotFound, HostConfigFault, RuntimeFault, RemoteException
	{
		getVimService().updateInternetScsiDigestProperties(getMOR(), iScsiHbaDevice, targetSet, digestProperties);
	}
	
	/**
	 * @since 4.0
	 */
	public void updateScsiLunDisplayName(String lunUuid, String displayName) throws NotFound, HostConfigFault, InvalidName, DuplicateName, RuntimeFault, RemoteException
	{
		getVimService().updateScsiLunDisplayName(getMOR(), lunUuid, displayName);
	}
	
	public void updateInternetScsiDiscoveryProperties(String iScsiHbaDevice, HostInternetScsiHbaDiscoveryProperties discoveryProperties) 
		throws NotFound, RuntimeFault, RemoteException
	{
		getVimService().updateInternetScsiDiscoveryProperties(getMOR(), iScsiHbaDevice, discoveryProperties);
	}

	public void updateInternetScsiIPProperties(String iScsiHbaDevice, HostInternetScsiHbaIPProperties ipProperties) 
		throws HostConfigFault, NotFound, RuntimeFault, RemoteException
	{
		getVimService().updateInternetScsiIPProperties(getMOR(), iScsiHbaDevice, ipProperties);
	}
	
	public void updateInternetScsiName(String iScsiHbaDevice, String iScsiName) throws HostConfigFault, NotFound, RuntimeFault, RemoteException
	{
		getVimService().updateInternetScsiName(getMOR(), iScsiHbaDevice, iScsiName);
	}
	
	public void updateSoftwareInternetScsiEnabled(boolean enabled) throws HostConfigFault, RuntimeFault, RemoteException
	{
		getVimService().updateSoftwareInternetScsiEnabled(getMOR(), enabled);
	}
	
	public void upgradeVmfs(String vmfsPath) throws HostConfigFault, NotFound, RuntimeFault, RemoteException
	{
		getVimService().upgradeVmfs(getMOR(), vmfsPath);
	}
	
	public void upgradeVmLayout(String vmfsPath) throws HostConfigFault, NotFound, RuntimeFault, RemoteException
	{
		getVimService().upgradeVmfs(getMOR(), vmfsPath);
	}
}
