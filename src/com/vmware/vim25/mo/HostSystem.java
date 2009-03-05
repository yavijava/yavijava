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
import com.vmware.vim25.mo.util.*;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 * @author Steve JIN (sjin@vmware.com)
 */

public class HostSystem extends ManagedEntity 
{
	
	private HostConfigManager configManager = null;
	
	public HostSystem(ServerConnection sc, ManagedObjectReference mor) 
	{
		super(sc, mor);
	}
	
	public HostCapability getCapability()
	{
		return (HostCapability) getCurrentProperty("capability");
	}
	
	public HostConfigInfo getConfig()
	{
		return (HostConfigInfo) getCurrentProperty("config");
	}
	
	public Datastore[] getDatastores() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return getDatastores("datastore");
	}
	
	public HostDatastoreBrowser getDatastoreBrowser() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (HostDatastoreBrowser) getManagedObject("datastoreBrowser");
	}
	
	public HostHardwareInfo getHardware()
	{
		return (HostHardwareInfo) getCurrentProperty("hardware");
	}
	
	public Network[] getNetworks() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return getNetworks("network");
	}
	
	public HostRuntimeInfo getRuntime()
	{
		return (HostRuntimeInfo) getCurrentProperty("runtime");
	}
	
	public HostListSummary getSummary()
	{
		return (HostListSummary) getCurrentProperty("summary");
	}

	public HostSystemResourceInfo getSystemResources()
	{
		return (HostSystemResourceInfo) getCurrentProperty("systemResources");
	}
	
	public VirtualMachine[] getVms() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return getVms("vm");
	}
	
	public HostServiceTicket acquireCimServicesTicket() throws RuntimeFault, RemoteException 
	{
		return getVimService().acquireCimServicesTicket(getMOR());
	}
	
	public Task disconnectHost() throws RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().disconnectHost_Task(getMOR());
		return new Task(getServerConnection(), mor);
	}
	
	public Task enterMaintenanceMode(int timeout, boolean evacuatePoweredOffVms) throws Timedout, InvalidState, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().enterMaintenanceMode_Task(getMOR(), timeout, new Boolean(evacuatePoweredOffVms));
		return new Task(getServerConnection(), mor);
	}
	
	public Task exitMaintenanceMode(int timeout) throws Timedout, InvalidState, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().exitMaintenanceMode_Task(getMOR(), timeout);
		return new Task(getServerConnection(), mor);
	}
	
	public Task powerDownHostToStandBy(int timeSec, boolean evacuatePoweredOffVms) throws RequestCanceled, HostPowerOpFailed, NotSupported, Timedout, InvalidState, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().powerDownHostToStandBy_Task(getMOR(), timeSec, new Boolean(evacuatePoweredOffVms));
		return new Task(getServerConnection(), mor);
	}

	public Task powerUpHostFromStandBy(int timeSec) throws HostPowerOpFailed, NotSupported, Timedout, InvalidState, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().powerUpHostFromStandBy_Task(getMOR(), timeSec);
		return new Task(getServerConnection(), mor);
	}

	public HostConnectInfo queryHostConnectionInfo() throws RuntimeFault, RemoteException 
	{
		return getVimService().queryHostConnectionInfo(getMOR());
	}
	
	public long queryMemoryOverhead(long memorySize, int videoRamSize, int numVcpus) throws RuntimeFault, RemoteException 
	{
		return getVimService().queryMemoryOverhead(getMOR(), memorySize, new Integer(videoRamSize), numVcpus);
	}
	
	public long queryMemoryOverheadEx(VirtualMachineConfigInfo vmConfigInfo) throws RuntimeFault, RemoteException 
	{
		return getVimService().queryMemoryOverheadEx(getMOR(), vmConfigInfo);
	}

	public Task rebootHost(boolean force) throws InvalidState, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().rebootHost_Task(getMOR(), force);
		return new Task(getServerConnection(), mor);
	}
	
	public Task reconfigureHostForDAS() throws DasConfigFault, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().reconfigureHostForDAS_Task(getMOR());
		return new Task(getServerConnection(), mor);
	}
	
	public Task reconnectHost_Task(HostConnectSpec hcs) throws InvalidName, InvalidLogin, InvalidState, HostConnectFault, RuntimeFault, RemoteException 
	{
		ManagedObjectReference mor = getVimService().reconnectHost_Task(getMOR(), hcs);
		return new Task(getServerConnection(), mor);
	}
	
	public Task shutdownHost(boolean force) throws InvalidState, NotSupported, RuntimeFault, RemoteException
	{
		ManagedObjectReference mor = getVimService().shutdownHost_Task(getMOR(), force);
		return new Task(getServerConnection(), mor);
	}
	
	public void updateFlags(HostFlagInfo hfi) throws RuntimeFault, RemoteException 
	{
		getVimService().updateFlags(getMOR(), hfi);
	}
	
	public void updateSystemResources(HostSystemResourceInfo resourceInfo) throws RuntimeFault, RemoteException 
	{
		getVimService().updateSystemResources(getMOR(), resourceInfo);
	}
	
	private HostConfigManager getConfigManager() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		if(configManager==null)
		{
			configManager = (HostConfigManager)getCurrentProperty("configManager");
		}
		return configManager;
	}
	
	public OptionManager getOptionManager() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return new OptionManager(getServerConnection(),
				getConfigManager().getAdvancedOption());
	}
	
	public HostAutoStartManager getHostAutoStartManager() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return new HostAutoStartManager(getServerConnection(),
				getConfigManager().getAutoStartManager());
	}

	public HostBootDeviceSystem getHostBootDeviceSystem() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (HostBootDeviceSystem) MorUtil.createExactManagedObject(getServerConnection(),
				getConfigManager().getBootDeviceSystem());
	}

	public HostDateTimeSystem getHostDateTimeSystem() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (HostDateTimeSystem) MorUtil.createExactManagedObject(getServerConnection(),
				getConfigManager().getDateTimeSystem());
	}
	
	public HostDiagnosticSystem getHostDiagnosticSystem() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (HostDiagnosticSystem) MorUtil.createExactManagedObject(getServerConnection(),
				getConfigManager().getDiagnosticSystem());
	}

	public HostCpuSchedulerSystem getHostCpuSchedulerSystem() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (HostCpuSchedulerSystem) MorUtil.createExactManagedObject(getServerConnection(),
				getConfigManager().getCpuScheduler());
	}

	public HostDatastoreSystem getHostDatastoreSystem() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (HostDatastoreSystem) MorUtil.createExactManagedObject(getServerConnection(),
				getConfigManager().getDatastoreSystem());
	}
	
	public HostFirmwareSystem getHostFirmwareSystem() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (HostFirmwareSystem) MorUtil.createExactManagedObject(getServerConnection(),
				getConfigManager().getFirmwareSystem());
	}

	public HostHealthStatusSystem getHealthStatusSystem() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (HostHealthStatusSystem) MorUtil.createExactManagedObject(getServerConnection(),
				getConfigManager().getHealthStatusSystem());
	}

	public HostFirewallSystem getHostFirewallSystem() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (HostFirewallSystem) MorUtil.createExactManagedObject(getServerConnection(),
				getConfigManager().getFirewallSystem());
	}

	public HostMemorySystem getHostMemorySystem() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (HostMemorySystem) MorUtil.createExactManagedObject(getServerConnection(),
				getConfigManager().getMemoryManager());
	}

	public HostNetworkSystem getHostNetworkSystem() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (HostNetworkSystem) MorUtil.createExactManagedObject(getServerConnection(),
				getConfigManager().getNetworkSystem());
	}

	public HostPatchManager getHostPatchManager() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (HostPatchManager) MorUtil.createExactManagedObject(getServerConnection(),
				getConfigManager().getPatchManager());
	}

	public HostServiceSystem getHostServiceSystem() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (HostServiceSystem) MorUtil.createExactManagedObject(getServerConnection(),
				getConfigManager().getServiceSystem());
	}

	public HostSnmpSystem getHostSnmpSystem() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (HostSnmpSystem) MorUtil.createExactManagedObject(getServerConnection(),
				getConfigManager().getSnmpSystem());
	}
	
	public HostStorageSystem getHostStorageSystem() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (HostStorageSystem) MorUtil.createExactManagedObject(getServerConnection(),
				getConfigManager().getStorageSystem());
	}
	
	public HostVMotionSystem getHostVMotionSystem() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (HostVMotionSystem) MorUtil.createExactManagedObject(getServerConnection(),
				getConfigManager().getVmotionSystem());
	}
	
}
