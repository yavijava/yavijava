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

public class VirtualMachine extends ManagedEntity 
{
	public VirtualMachine(ServerConnection sc, ManagedObjectReference mor) 
	{
		super(sc, mor);
	}

	public VirtualMachineCapability getCapability()
	{
		return (VirtualMachineCapability) getCurrentProperty("capability");
	}
	
	public VirtualMachineConfigInfo getConfig()
	{
		return (VirtualMachineConfigInfo) getCurrentProperty("config");
	}
	
	public Datastore[] getDatastores() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return getDatastores("datastore");
	}
	
	public EnvironmentBrowser getEnvironmentBrowser() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (EnvironmentBrowser) getManagedObject("environmentBrowser");
	}
	
	public GuestInfo getGuest()
	{
		return (GuestInfo) getCurrentProperty("guest");
	}

	public ManagedEntityStatus getGuestHeartbeatStatus()
	{
		return (ManagedEntityStatus) getCurrentProperty("guestHeartbeatStatus");
	}
	
	public VirtualMachineFileLayout getLayout()
	{
		return (VirtualMachineFileLayout) getCurrentProperty("layout");
	}
	
	public Network[] getNetworks() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return getNetworks("network");
	}

	public ResourceConfigSpec getResourceConfig()
	{
		return (ResourceConfigSpec) getCurrentProperty("resourceConfig");
	}

	public ResourcePool getResourcePool() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (ResourcePool) getManagedObject("resourcePool");
	}
	
	public VirtualMachineRuntimeInfo getRuntime()
	{
		return (VirtualMachineRuntimeInfo) getCurrentProperty("runtime");
	}
	
	public VirtualMachineSnapshotInfo getSnapshot()
	{
		return (VirtualMachineSnapshotInfo) getCurrentProperty("snapshot");
	}
	
	public VirtualMachineSnapshot getCurrentSnapShot() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (VirtualMachineSnapshot) getManagedObject("snapshot.currentSnapshot");
	}

	public 	VirtualMachineSummary getSummary()
	{
		return (VirtualMachineSummary) getCurrentProperty("summary");
	}
	
	public VirtualMachineMksTicket acquireMksTicket() throws RuntimeFault, RemoteException 
	{
		return getVimService().acquireMksTicket(getMOR());
	}
		
	public void answerVM(String questionId, String answerChoice) throws ConcurrentAccess, RuntimeFault, RemoteException 
	{
		getVimService().answerVM(getMOR(), questionId, answerChoice);
	}
		
	public void checkCustomizationSpec(CustomizationSpec spec) throws CustomizationFault, RuntimeFault, RemoteException 
	{
		getVimService().checkCustomizationSpec(getMOR(), spec);
	}
	
	public Task cloneVM_Task(Folder folder, String name, VirtualMachineCloneSpec spec) throws VmConfigFault, TaskInProgress, CustomizationFault, FileFault, InvalidState, InsufficientResourcesFault, MigrationFault, InvalidDatastore, RuntimeFault, RemoteException 
	{
		if(folder==null)
		{
			throw new IllegalArgumentException("folder must not be null.");
		}
		ManagedObjectReference mor = getVimService().cloneVM_Task(getMOR(), folder.getMOR(), name, spec);
		return new Task(getServerConnection(), mor);
	}
	
	public Task createSnapshot_Task(String name, String description, boolean memory, boolean quiesce) throws InvalidName, VmConfigFault, SnapshotFault, TaskInProgress, FileFault, InvalidState, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().createSnapshot_Task(getMOR(), name, description, memory, quiesce);
		return new Task(getServerConnection(), mor);
	}
	
	public Task customizeVM_Task(CustomizationSpec spec) throws CustomizationFault, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().customizeVM_Task(getMOR(), spec);
		return new Task(getServerConnection(), mor);
	}
	
	public void defragmentAllDisks() throws InvalidPowerState, TaskInProgress, FileFault, InvalidState, RuntimeFault, RemoteException 
	{
		getVimService().defragmentAllDisks(getMOR());
	}
	
	public void markAsTemplate() throws VmConfigFault, InvalidState, RuntimeFault, RemoteException 
	{
		getVimService().markAsTemplate(getMOR());
	}
	
	public void markAsVirtualMachine(ResourcePool pool, HostSystem host) throws VmConfigFault, FileFault, InvalidState, InvalidDatastore, RuntimeFault, RemoteException 
	{
		if(pool==null)
		{
			throw new IllegalArgumentException("pool must not be null.");
		}
		getVimService().markAsVirtualMachine(getMOR(), pool.getMOR(), host==null? null : host.getMOR());
	}
		
	public Task migrateVM_Task(ResourcePool pool, HostSystem host, VirtualMachineMovePriority priority, 
			VirtualMachinePowerState state) throws VmConfigFault, Timedout, FileFault, InvalidState, InsufficientResourcesFault, MigrationFault, RuntimeFault, RemoteException	
	{
		ManagedObjectReference mor = getVimService().migrateVM_Task(getMOR(), pool==null? null : pool.getMOR(), host==null? null : host.getMOR(), priority, state);
		return new Task(getServerConnection(), mor);
	}
	
	public void mountToolsInstaller() throws InvalidState, RuntimeFault, RemoteException 
	{
		getVimService().mountToolsInstaller(getMOR());
	}

	public Task powerOffVM_Task() throws TaskInProgress, InvalidState, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().powerOffVM_Task(getMOR());
		return new Task(getServerConnection(), mor);
	}
	
	public Task powerOnVM_Task(HostSystem host) throws VmConfigFault, TaskInProgress, FileFault, InvalidState, InsufficientResourcesFault, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().powerOnVM_Task(getMOR(), host==null? null : host.getMOR());
		return new Task(getServerConnection(), mor);
	}
	
	public void rebootGuest() throws TaskInProgress, InvalidState, ToolsUnavailable, RuntimeFault, RemoteException 
	{
		getVimService().rebootGuest(getMOR());
	}
	
	public Task reconfigVM_Task(VirtualMachineConfigSpec spec) throws InvalidName, VmConfigFault, DuplicateName, TaskInProgress, FileFault, InvalidState, ConcurrentAccess, InvalidDatastore, InsufficientResourcesFault, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().reconfigVM_Task(getMOR(), spec);
		return new Task(getServerConnection(), mor);
	}
	
	public Task relocateVM_Task(VirtualMachineRelocateSpec spec) throws VmConfigFault, Timedout, FileFault, InvalidState, InsufficientResourcesFault, MigrationFault, InvalidDatastore, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().relocateVM_Task(getMOR(), spec);
		return new Task(getServerConnection(), mor);
	}
		
	public Task removeAllSnapshots_Task() throws SnapshotFault, TaskInProgress, InvalidState, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().removeAllSnapshots_Task(getMOR());
		return new Task(getServerConnection(), mor);
	}
	
	public void resetGuestInformation() throws InvalidState, RuntimeFault, RemoteException 
	{
		getVimService().resetGuestInformation(getMOR());
	}
	
	public Task resetVM_Task() throws TaskInProgress, InvalidState, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().resetVM_Task(getMOR());
		return new Task(getServerConnection(), mor);
	}
	
	public Task revertToCurrentSnapshot_Task(HostSystem host) throws VmConfigFault, SnapshotFault, TaskInProgress, InvalidState, InsufficientResourcesFault, NotFound, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().revertToCurrentSnapshot_Task(getMOR(), host==null? null : host.getMOR());
		return new Task(getServerConnection(), mor);
	}
	
	public void setScreenResolution(int width, int height) throws InvalidPowerState, ToolsUnavailable, RuntimeFault, RemoteException 
	{
		getVimService().setScreenResolution(getMOR(), width, height);
	}

	public void shutdownGuest() throws TaskInProgress, InvalidState, ToolsUnavailable, RuntimeFault, RemoteException 
	{
		getVimService().shutdownGuest(getMOR());
	}
	
	public void standbyGuest() throws TaskInProgress, InvalidState, ToolsUnavailable, RuntimeFault, RemoteException 
	{
		getVimService().standbyGuest(getMOR());
	}
	
	public Task suspendVM_Task() throws TaskInProgress, InvalidState, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().suspendVM_Task(getMOR());
		return new Task(getServerConnection(), mor);
	}
	
	public void unmountToolsInstaller() throws InvalidState, RuntimeFault, RemoteException 
	{
		getVimService().unmountToolsInstaller(getMOR());
	}
	
	public void unregisterVM() throws InvalidPowerState, RuntimeFault, RemoteException 
	{
		getVimService().unregisterVM(getMOR());
	}
	
	public Task upgradeTools_Task(String installerOptions) throws TaskInProgress, VmToolsUpgradeFault, InvalidState, ToolsUnavailable, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().upgradeTools_Task(getMOR(), installerOptions);
		return new Task(getServerConnection(), mor);
	}
	
	public Task upgradeVM_Task(String version) throws TaskInProgress, InvalidState, AlreadyUpgraded, NoDiskFound, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().upgradeVM_Task(getMOR(), version);
		return new Task(getServerConnection(), mor);
	}
	
}
