// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostSystem extends ManagedEntity {

    public HostSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public AnswerFileStatusResult getAnswerFileValidationResult() {
        return (AnswerFileStatusResult) getCurrentProperty("answerFileValidationResult");
    }

    public AnswerFileStatusResult getAnswerFileValidationState() {
        return (AnswerFileStatusResult) getCurrentProperty("answerFileValidationState");
    }

    public HostCapability getCapability() {
        return (HostCapability) getCurrentProperty("capability");
    }

    public ComplianceResult getComplianceCheckResult() {
        return (ComplianceResult) getCurrentProperty("complianceCheckResult");
    }

    public HostSystemComplianceCheckState getComplianceCheckState() {
        return (HostSystemComplianceCheckState) getCurrentProperty("complianceCheckState");
    }

    public HostConfigInfo getConfig() {
        return (HostConfigInfo) getCurrentProperty("config");
    }

    public Datastore[] getDatastore() {
        return getDatastores("datastore");
    }

    public HostDatastoreBrowser getDatastoreBrowser() {
        return (HostDatastoreBrowser) this.getManagedObject("datastoreBrowser");
    }

    public HostHardwareInfo getHardware() {
        return (HostHardwareInfo) getCurrentProperty("hardware");
    }

    public HostLicensableResourceInfo getLicensableResource() {
        return (HostLicensableResourceInfo) getCurrentProperty("licensableResource");
    }

    public Network[] getNetwork() {
        return getNetworks("network");
    }

    public ApplyHostProfileConfigurationSpec getPrecheckRemediationResult() {
        return (ApplyHostProfileConfigurationSpec) getCurrentProperty("precheckRemediationResult");
    }

    public ApplyHostProfileConfigurationResult getRemediationResult() {
        return (ApplyHostProfileConfigurationResult) getCurrentProperty("remediationResult");
    }

    public HostSystemRemediationState getRemediationState() {
        return (HostSystemRemediationState) getCurrentProperty("remediationState");
    }

    public HostRuntimeInfo getRuntime() {
        return (HostRuntimeInfo) getCurrentProperty("runtime");
    }

    public HostListSummary getSummary() {
        return (HostListSummary) getCurrentProperty("summary");
    }

    public HostSystemResourceInfo getSystemResources() {
        return (HostSystemResourceInfo) getCurrentProperty("systemResources");
    }

    public VirtualMachine[] getVm() {
        return getVms("vm");
    }

    public void configureCryptoKey(CryptoKeyId keyId) throws RuntimeFault, RemoteException {
        getVimService().configureCryptoKey(getMOR(), keyId);
    }

    public Task disconnectHost_Task() throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().disconnectHost_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public void enableCrypto(CryptoKeyPlain keyPlain) throws InvalidState, RuntimeFault, RemoteException {
        getVimService().enableCrypto(getMOR(), keyPlain);
    }

    public void enterLockdownMode() throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().enterLockdownMode(getMOR());
    }

    public Task enterMaintenanceMode_Task(int timeout, boolean evacuatePoweredOffVms, HostMaintenanceSpec maintenanceSpec) throws InvalidState, Timedout, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().enterMaintenanceMode_Task(getMOR(), timeout, evacuatePoweredOffVms, maintenanceSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task powerDownHostToStandBy_Task(int timeoutSec, boolean evacuatePoweredOffVms) throws HostPowerOpFailed, InvalidState, NotSupported, RequestCanceled, Timedout, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().powerDownHostToStandBy_Task(getMOR(), timeoutSec, evacuatePoweredOffVms);
        return new Task(getServerConnection(), resultMor);
    }

    public void exitLockdownMode() throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().exitLockdownMode(getMOR());
    }

    public Task exitMaintenanceMode_Task(int timeout) throws InvalidState, Timedout, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().exitMaintenanceMode_Task(getMOR(), timeout);
        return new Task(getServerConnection(), resultMor);
    }

    public Task powerUpHostFromStandBy_Task(int timeoutSec) throws HostPowerOpFailed, InvalidState, NotSupported, Timedout, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().powerUpHostFromStandBy_Task(getMOR(), timeoutSec);
        return new Task(getServerConnection(), resultMor);
    }

    public void prepareCrypto() throws InvalidState, RuntimeFault, RemoteException {
        getVimService().prepareCrypto(getMOR());
    }

    public String queryProductLockerLocation() throws HostConfigFault, RuntimeFault, RemoteException {
        return getVimService().queryProductLockerLocation(getMOR());
    }

    public Task rebootHost_Task(boolean force) throws InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().rebootHost_Task(getMOR(), force);
        return new Task(getServerConnection(), resultMor);
    }

    public Task reconfigureHostForDAS_Task() throws DasConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().reconfigureHostForDAS_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task reconnectHost_Task(HostConnectSpec cnxSpec, HostSystemReconnectSpec reconnectSpec) throws HostConnectFault, InvalidLogin, InvalidName, InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().reconnectHost_Task(getMOR(), cnxSpec, reconnectSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public long retrieveFreeEpcMemory() throws RuntimeFault, RemoteException {
        return getVimService().retrieveFreeEpcMemory(getMOR());
    }

    public Task shutdownHost_Task(boolean force) throws InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().shutdownHost_Task(getMOR(), force);
        return new Task(getServerConnection(), resultMor);
    }

    public void updateFlags(HostFlagInfo flagInfo) throws RuntimeFault, RemoteException {
        getVimService().updateFlags(getMOR(), flagInfo);
    }

    public void updateIpmi(HostIpmiInfo ipmiInfo) throws InvalidIpmiLoginInfo, InvalidIpmiMacAddress, RuntimeFault, RemoteException {
        getVimService().updateIpmi(getMOR(), ipmiInfo);
    }

    public Task updateProductLockerLocation_Task(String path) throws FileNotFound, HostConfigFault, InvalidArgument, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().updateProductLockerLocation_Task(getMOR(), path);
        return new Task(getServerConnection(), resultMor);
    }

    public void updateSystemResources(HostSystemResourceInfo resourceInfo) throws RuntimeFault, RemoteException {
        getVimService().updateSystemResources(getMOR(), resourceInfo);
    }

    public void updateSystemSwapConfiguration(HostSystemSwapConfiguration sysSwapConfig) throws RuntimeFault, RemoteException {
        getVimService().updateSystemSwapConfiguration(getMOR(), sysSwapConfig);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    private HostConfigManager configManager = null;
    public HostServiceTicket acquireCimServicesTicket() throws RuntimeFault, RemoteException {
    return getVimService().acquireCimServicesTicket(getMOR());
}
    /**
 * keep the old signature for compatibility
 */
public Task enterMaintenanceMode_Task(int timeout, boolean evacuatePoweredOffVms) throws Timedout, InvalidState, RuntimeFault, RemoteException {
    return enterMaintenanceMode_Task(timeout, evacuatePoweredOffVms, null);
}
    public HostConnectInfo queryHostConnectionInfo() throws RuntimeFault, RemoteException {
    return getVimService().queryHostConnectionInfo(getMOR());
}
    /**
 * @since SDK5.1
 */
public HostTpmAttestationReport queryTpmAttestationReport() throws RuntimeFault, RemoteException {
    return getVimService().queryTpmAttestationReport(getMOR());
}
    public long queryMemoryOverhead(long memorySize, int videoRamSize, int numVcpus) throws RuntimeFault, RemoteException {
    return getVimService().queryMemoryOverhead(getMOR(), memorySize, Integer.valueOf(videoRamSize), numVcpus);
}
    public long queryMemoryOverheadEx(VirtualMachineConfigInfo vmConfigInfo) throws RuntimeFault, RemoteException {
    return getVimService().queryMemoryOverheadEx(getMOR(), vmConfigInfo);
}
    //SDK4.1 signature for back compatibility
public Task reconnectHost_Task(HostConnectSpec hcs) throws InvalidName, InvalidLogin, InvalidState, HostConnectFault, RuntimeFault, RemoteException {
    return reconnectHost_Task(hcs, null);
}
    /**
 * @since SDK4.1
 */
public long retrieveHardwareUptime() throws RuntimeFault, RemoteException {
    return getVimService().retrieveHardwareUptime(getMOR());
}
    private HostConfigManager getConfigManager() throws InvalidProperty, RuntimeFault, RemoteException {
    if (configManager == null) {
        configManager = (HostConfigManager) getCurrentProperty("configManager");
    }
    return configManager;
}
    public OptionManager getOptionManager() throws InvalidProperty, RuntimeFault, RemoteException {
    return new OptionManager(getServerConnection(), getConfigManager().getAdvancedOption());
}
    public HostAutoStartManager getHostAutoStartManager() throws InvalidProperty, RuntimeFault, RemoteException {
    return new HostAutoStartManager(getServerConnection(), getConfigManager().getAutoStartManager());
}
    public HostBootDeviceSystem getHostBootDeviceSystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostBootDeviceSystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getBootDeviceSystem());
}
    public HostDateTimeSystem getHostDateTimeSystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostDateTimeSystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getDateTimeSystem());
}
    public HostDiagnosticSystem getHostDiagnosticSystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostDiagnosticSystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getDiagnosticSystem());
}
    public HostEsxAgentHostManager getHostEsxAgentHostManager() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostEsxAgentHostManager) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getEsxAgentHostManager());
}
    public HostCacheConfigurationManager getHostCacheConfigurationManager() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostCacheConfigurationManager) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getCacheConfigurationManager());
}
    public HostCpuSchedulerSystem getHostCpuSchedulerSystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostCpuSchedulerSystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getCpuScheduler());
}
    public HostDatastoreSystem getHostDatastoreSystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostDatastoreSystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getDatastoreSystem());
}
    public HostFirmwareSystem getHostFirmwareSystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostFirmwareSystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getFirmwareSystem());
}
    /**
 * @since SDK5.5
 */
public HostGraphicsManager getHostGraphicsManager() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostGraphicsManager) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getGraphicsManager());
}
    /**
 * @since SDK4.0
 */
public HostKernelModuleSystem getHostKernelModuleSystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostKernelModuleSystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getKernelModuleSystem());
}
    /**
 * @since SDK4.0
 */
public LicenseManager getLicenseManager() throws InvalidProperty, RuntimeFault, RemoteException {
    return (LicenseManager) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getLicenseManager());
}
    /**
 * @since SDK4.0
 */
public HostPciPassthruSystem getHostPciPassthruSystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostPciPassthruSystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getPciPassthruSystem());
}
    /**
 * @since SDK4.0
 */
public HostVirtualNicManager getHostVirtualNicManager() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostVirtualNicManager) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getVirtualNicManager());
}
    public HostHealthStatusSystem getHealthStatusSystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostHealthStatusSystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getHealthStatusSystem());
}
    public HostFirewallSystem getHostFirewallSystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostFirewallSystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getFirewallSystem());
}
    public HostImageConfigManager getHostImageConfigManager() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostImageConfigManager) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getImageConfigManager());
}
    public HostMemorySystem getHostMemorySystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostMemorySystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getMemoryManager());
}
    public HostNetworkSystem getHostNetworkSystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostNetworkSystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getNetworkSystem());
}
    public HostPatchManager getHostPatchManager() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostPatchManager) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getPatchManager());
}
    public HostServiceSystem getHostServiceSystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostServiceSystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getServiceSystem());
}
    public HostSnmpSystem getHostSnmpSystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostSnmpSystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getSnmpSystem());
}
    public HostStorageSystem getHostStorageSystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostStorageSystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getStorageSystem());
}
    /**
 * @since SDK5.5
 */
public HostVFlashManager getHostVFlashManager() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostVFlashManager) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getVFlashManager());
}
    public IscsiManager getIscsiManager() throws InvalidProperty, RuntimeFault, RemoteException {
    return (IscsiManager) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getIscsiManager());
}
    /**
 * @deprecated as of SDK 4.0, use getHostVirtualNicManager instead
 */
@Deprecated
public HostVMotionSystem getHostVMotionSystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostVMotionSystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getVmotionSystem());
}
    /**
 * @since SDK5.5
 */
public HostVsanInternalSystem getHostVsanInternalSystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostVsanInternalSystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getVsanInternalSystem());
}
    /**
 * @since SDK5.5
 */
public HostVsanSystem getHostVsanSystem() throws InvalidProperty, RuntimeFault, RemoteException {
    return (HostVsanSystem) MorUtil.createExactManagedObject(getServerConnection(), getConfigManager().getVsanSystem());
}
    /** Backward-compat alias for {@link #getNetwork()}. */
    public Network[] getNetworks() {
        return getNetwork();
    }
    /** Backward-compat alias for {@link #getDatastore()}. */
    public Datastore[] getDatastores() {
        return getDatastore();
    }
    /** Backward-compat alias for {@link #getVm()}. */
    public VirtualMachine[] getVms() {
        return getVm();
    }
    /* ===== END custom ===== */
}
