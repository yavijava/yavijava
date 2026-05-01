// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class VirtualMachine extends ManagedEntity {

    public VirtualMachine(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public VirtualMachineCapability getCapability() {
        return (VirtualMachineCapability) getCurrentProperty("capability");
    }

    public VirtualMachineConfigInfo getConfig() {
        return (VirtualMachineConfigInfo) getCurrentProperty("config");
    }

    public Datastore[] getDatastore() {
        return getDatastores("datastore");
    }

    public EnvironmentBrowser getEnvironmentBrowser() {
        return (EnvironmentBrowser) this.getManagedObject("environmentBrowser");
    }

    public GuestInfo getGuest() {
        return (GuestInfo) getCurrentProperty("guest");
    }

    public ManagedEntityStatus getGuestHeartbeatStatus() {
        return (ManagedEntityStatus) getCurrentProperty("guestHeartbeatStatus");
    }

    public VirtualMachineFileLayout getLayout() {
        return (VirtualMachineFileLayout) getCurrentProperty("layout");
    }

    public VirtualMachineFileLayoutEx getLayoutEx() {
        return (VirtualMachineFileLayoutEx) getCurrentProperty("layoutEx");
    }

    public Network[] getNetwork() {
        return getNetworks("network");
    }

    public ResourceConfigSpec getResourceConfig() {
        return (ResourceConfigSpec) getCurrentProperty("resourceConfig");
    }

    public ResourcePool getResourcePool() {
        return (ResourcePool) this.getManagedObject("resourcePool");
    }

    public VirtualMachineRuntimeInfo getRuntime() {
        return (VirtualMachineRuntimeInfo) getCurrentProperty("runtime");
    }

    public VirtualMachineSnapshotInfo getSnapshot() {
        return (VirtualMachineSnapshotInfo) getCurrentProperty("snapshot");
    }

    public VirtualMachineStorageInfo getStorage() {
        return (VirtualMachineStorageInfo) getCurrentProperty("storage");
    }

    public VirtualMachineSummary getSummary() {
        return (VirtualMachineSummary) getCurrentProperty("summary");
    }

    public void answerVM(String questionId, String answerChoice) throws ConcurrentAccess, RuntimeFault, RemoteException {
        getVimService().answerVM(getMOR(), questionId, answerChoice);
    }

    public Task applyEvcModeVM_Task(HostFeatureMask[] mask, boolean completeMasks) throws InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().applyEvcModeVM_Task(getMOR(), mask, completeMasks);
        return new Task(getServerConnection(), resultMor);
    }

    public Task attachDisk_Task(ID diskId, Datastore datastore, int controllerKey, int unitNumber) throws DeviceUnsupportedForVmVersion, FileFault, InvalidController, InvalidDatastore, InvalidState, MissingController, NotFound, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().attachDisk_Task(getMOR(), diskId, datastore == null ? null : datastore.getMOR(), controllerKey, unitNumber);
        return new Task(getServerConnection(), resultMor);
    }

    public void checkCustomizationSpec(CustomizationSpec spec) throws CustomizationFault, RuntimeFault, RemoteException {
        getVimService().checkCustomizationSpec(getMOR(), spec);
    }

    public Task consolidateVMDisks_Task() throws FileFault, InvalidState, TaskInProgress, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().consolidateVMDisks_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task createScreenshot_Task() throws FileFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createScreenshot_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task createSecondaryVM_Task(HostSystem host) throws FileFault, InsufficientResourcesFault, InvalidState, TaskInProgress, VmConfigFault, VmFaultToleranceIssue, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createSecondaryVM_Task(getMOR(), host == null ? null : host.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task createSecondaryVMEx_Task(HostSystem host, FaultToleranceConfigSpec spec) throws FileFault, InsufficientResourcesFault, InvalidState, TaskInProgress, VmConfigFault, VmFaultToleranceIssue, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createSecondaryVMEx_Task(getMOR(), host == null ? null : host.getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task createSnapshot_Task(String name, String description, boolean memory, boolean quiesce) throws FileFault, InvalidName, InvalidState, SnapshotFault, TaskInProgress, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createSnapshot_Task(getMOR(), name, description, memory, quiesce);
        return new Task(getServerConnection(), resultMor);
    }

    public Task createSnapshotEx_Task(String name, String description, boolean memory, VirtualMachineGuestQuiesceSpec quiesceSpec) throws FileFault, InvalidName, InvalidState, SnapshotFault, TaskInProgress, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createSnapshotEx_Task(getMOR(), name, description, memory, quiesceSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task cryptoUnlock_Task() throws InvalidState, NotSupported, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().cryptoUnlock_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task customizeVM_Task(CustomizationSpec spec) throws CustomizationFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().customizeVM_Task(getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public void defragmentAllDisks() throws FileFault, InvalidPowerState, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().defragmentAllDisks(getMOR());
    }

    public Task detachDisk_Task(ID diskId) throws FileFault, InvalidState, NotFound, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().detachDisk_Task(getMOR(), diskId);
        return new Task(getServerConnection(), resultMor);
    }

    public Task disableSecondaryVM_Task(VirtualMachine vm) throws InvalidState, TaskInProgress, VmFaultToleranceIssue, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().disableSecondaryVM_Task(getMOR(), vm == null ? null : vm.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public boolean dropConnections(VirtualMachineConnection[] listOfConnections) throws InvalidState, RuntimeFault, RemoteException {
        return getVimService().dropConnections(getMOR(), listOfConnections);
    }

    public Task enableSecondaryVM_Task(VirtualMachine vm, HostSystem host) throws InvalidState, TaskInProgress, VmConfigFault, VmFaultToleranceIssue, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().enableSecondaryVM_Task(getMOR(), vm == null ? null : vm.getMOR(), host == null ? null : host.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task estimateStorageForConsolidateSnapshots_Task() throws FileFault, InvalidState, TaskInProgress, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().estimateStorageForConsolidateSnapshots_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public HttpNfcLease exportVm() throws FileFault, InvalidPowerState, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().exportVm(getMOR());
        return new HttpNfcLease(getServerConnection(), resultMor);
    }

    public Task instantClone_Task(VirtualMachineInstantCloneSpec spec) throws DisallowedMigrationDeviceAttached, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().instantClone_Task(getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task makePrimaryVM_Task(VirtualMachine vm) throws InvalidState, TaskInProgress, VmFaultToleranceIssue, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().makePrimaryVM_Task(getMOR(), vm == null ? null : vm.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public void markAsTemplate() throws FileFault, InvalidState, VmConfigFault, RuntimeFault, RemoteException {
        getVimService().markAsTemplate(getMOR());
    }

    public Task migrateVM_Task(ResourcePool pool, HostSystem host, VirtualMachineMovePriority priority, VirtualMachinePowerState state) throws FileFault, InsufficientResourcesFault, InvalidState, MigrationFault, Timedout, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().migrateVM_Task(getMOR(), pool == null ? null : pool.getMOR(), host == null ? null : host.getMOR(), priority, state);
        return new Task(getServerConnection(), resultMor);
    }

    public void mountToolsInstaller() throws InvalidState, VmConfigFault, VmToolsUpgradeFault, RuntimeFault, RemoteException {
        getVimService().mountToolsInstaller(getMOR());
    }

    public Task powerOffVM_Task() throws InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().powerOffVM_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task powerOnVM_Task(HostSystem host) throws FileFault, InsufficientResourcesFault, InvalidState, TaskInProgress, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().powerOnVM_Task(getMOR(), host == null ? null : host.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task promoteDisks_Task(boolean unlink, VirtualDisk[] disks) throws InvalidPowerState, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().promoteDisks_Task(getMOR(), unlink, disks);
        return new Task(getServerConnection(), resultMor);
    }

    public int putUsbScanCodes(UsbScanCodeSpec spec) throws RuntimeFault, RemoteException {
        return getVimService().putUsbScanCodes(getMOR(), spec);
    }

    public VirtualMachineConnection[] queryConnections() throws InvalidState, Timedout, VmConfigFault, RuntimeFault, RemoteException {
        return getVimService().queryConnections(getMOR());
    }

    public void rebootGuest() throws InvalidState, TaskInProgress, ToolsUnavailable, RuntimeFault, RemoteException {
        getVimService().rebootGuest(getMOR());
    }

    public Task reconfigVM_Task(VirtualMachineConfigSpec spec) throws ConcurrentAccess, DuplicateName, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidName, InvalidState, TaskInProgress, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().reconfigVM_Task(getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public void refreshStorageInfo() throws RuntimeFault, RemoteException {
        getVimService().refreshStorageInfo(getMOR());
    }

    public Task reloadVirtualMachineFromPath_Task(String configurationPath) throws AlreadyExists, FileFault, InvalidPowerState, InvalidState, TaskInProgress, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().reloadVirtualMachineFromPath_Task(getMOR(), configurationPath);
        return new Task(getServerConnection(), resultMor);
    }

    public Task relocateVM_Task(VirtualMachineRelocateSpec spec, VirtualMachineMovePriority priority) throws FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidState, MigrationFault, Timedout, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().relocateVM_Task(getMOR(), spec, priority);
        return new Task(getServerConnection(), resultMor);
    }

    public Task removeAllSnapshots_Task(boolean consolidate, SnapshotSelectionSpec spec) throws InvalidState, SnapshotFault, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().removeAllSnapshots_Task(getMOR(), consolidate, spec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task resetVM_Task() throws InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().resetVM_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public void resetGuestInformation() throws InvalidState, RuntimeFault, RemoteException {
        getVimService().resetGuestInformation(getMOR());
    }

    public Task revertToCurrentSnapshot_Task(HostSystem host, boolean suppressPowerOn) throws InsufficientResourcesFault, InvalidState, NotFound, SnapshotFault, TaskInProgress, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().revertToCurrentSnapshot_Task(getMOR(), host == null ? null : host.getMOR(), suppressPowerOn);
        return new Task(getServerConnection(), resultMor);
    }

    public void sendNMI() throws InvalidState, RuntimeFault, RemoteException {
        getVimService().sendNMI(getMOR());
    }

    public void setDisplayTopology(VirtualMachineDisplayTopology[] displays) throws InvalidState, ToolsUnavailable, RuntimeFault, RemoteException {
        getVimService().setDisplayTopology(getMOR(), displays);
    }

    public void setScreenResolution(int width, int height) throws InvalidState, ToolsUnavailable, RuntimeFault, RemoteException {
        getVimService().setScreenResolution(getMOR(), width, height);
    }

    public void shutdownGuest() throws InvalidState, TaskInProgress, ToolsUnavailable, RuntimeFault, RemoteException {
        getVimService().shutdownGuest(getMOR());
    }

    public void standbyGuest() throws InvalidState, TaskInProgress, ToolsUnavailable, RuntimeFault, RemoteException {
        getVimService().standbyGuest(getMOR());
    }

    public Task startRecording_Task(String name, String description) throws FileFault, HostIncompatibleForRecordReplay, InvalidName, InvalidPowerState, InvalidState, RecordReplayDisabled, SnapshotFault, TaskInProgress, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().startRecording_Task(getMOR(), name, description);
        return new Task(getServerConnection(), resultMor);
    }

    public Task startReplaying_Task(VirtualMachineSnapshot replaySnapshot) throws FileFault, HostIncompatibleForRecordReplay, InvalidPowerState, InvalidState, NotFound, RecordReplayDisabled, SnapshotFault, TaskInProgress, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().startReplaying_Task(getMOR(), replaySnapshot == null ? null : replaySnapshot.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task stopRecording_Task() throws FileFault, InvalidPowerState, InvalidState, SnapshotFault, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().stopRecording_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task stopReplaying_Task() throws FileFault, InvalidPowerState, InvalidState, SnapshotFault, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().stopReplaying_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task suspendVM_Task() throws InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().suspendVM_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public void terminateVM() throws InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().terminateVM(getMOR());
    }

    public Task terminateFaultTolerantVM_Task(VirtualMachine vm) throws InvalidState, TaskInProgress, VmFaultToleranceIssue, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().terminateFaultTolerantVM_Task(getMOR(), vm == null ? null : vm.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task turnOffFaultToleranceForVM_Task() throws InvalidState, TaskInProgress, VmFaultToleranceIssue, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().turnOffFaultToleranceForVM_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public void unmountToolsInstaller() throws InvalidState, VmConfigFault, RuntimeFault, RemoteException {
        getVimService().unmountToolsInstaller(getMOR());
    }

    public void unregisterVM() throws InvalidPowerState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().unregisterVM(getMOR());
    }

    public Task upgradeTools_Task(String installerOptions) throws InvalidState, TaskInProgress, ToolsUnavailable, VmConfigFault, VmToolsUpgradeFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().upgradeTools_Task(getMOR(), installerOptions);
        return new Task(getServerConnection(), resultMor);
    }

    public Task upgradeVM_Task(String version) throws AlreadyUpgraded, InvalidState, NoDiskFound, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().upgradeVM_Task(getMOR(), version);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public VirtualMachineSnapshot getCurrentSnapShot() throws InvalidProperty, RuntimeFault, RemoteException {
        return (VirtualMachineSnapshot) getManagedObject("snapshot.currentSnapshot");
    }
    /**
 * @since SDK4.1
 */
public ManagedEntity getParentVApp() {
    ManagedObjectReference mor = (ManagedObjectReference) getCurrentProperty("parentVApp");
    return new ManagedEntity(getServerConnection(), mor);
}
    /**
 * @since SDK4.1
 */
public VirtualMachineSnapshot[] getRootSnapshot() {
    ManagedObjectReference[] mors = (ManagedObjectReference[]) getCurrentProperty("rootSnapshot");
    if (mors == null) {
        return new VirtualMachineSnapshot[0];
    }
    VirtualMachineSnapshot[] vmns = new VirtualMachineSnapshot[mors.length];
    for (int i = 0; i < mors.length; i++) {
        vmns[i] = new VirtualMachineSnapshot(getServerConnection(), mors[i]);
    }
    return vmns;
}
    /**
 * @deprecated as of SDK4.1. Use acquireTicket instead.
 */
public VirtualMachineMksTicket acquireMksTicket() throws RuntimeFault, RemoteException {
    return getVimService().acquireMksTicket(getMOR());
}
    /**
 * @since SDK4.1
 */
public VirtualMachineTicket acquireTicket(String ticketType) throws InvalidState, RuntimeFault, RemoteException {
    return getVimService().acquireTicket(getMOR(), ticketType);
}
    public Task cloneVM_Task(Folder folder, String name, VirtualMachineCloneSpec spec) throws VmConfigFault, TaskInProgress, CustomizationFault, FileFault, InvalidState, InsufficientResourcesFault, MigrationFault, InvalidDatastore, RuntimeFault, RemoteException {
    if (folder == null) {
        throw new IllegalArgumentException("folder must not be null.");
    }
    ManagedObjectReference mor = getVimService().cloneVM_Task(getMOR(), folder.getMOR(), name, spec);
    return new Task(getServerConnection(), mor);
}
    /**
 * @since 6.0
 */
public Task createSecondaryVMEx_Task(HostSystem host) throws FileFault, InsufficientResourcesFault, InvalidState, ManagedObjectNotFound, NotSupported, RuntimeFault, TaskInProgress, VmConfigFault, VmFaultToleranceIssue, RemoteException {
    return createSecondaryVMEx_Task(host, null);
}
    /**
 * @since 6.0
 */
public Task createSecondaryVMEx_Task(FaultToleranceConfigSpec spec) throws FileFault, InsufficientResourcesFault, InvalidState, ManagedObjectNotFound, NotSupported, RuntimeFault, TaskInProgress, VmConfigFault, VmFaultToleranceIssue, RemoteException {
    return createSecondaryVMEx_Task(null, spec);
}
    /**
 * @since SDK4.0
 */
public String extractOvfEnvironment() throws InvalidState, RuntimeFault, RemoteException {
    return getVimService().extractOvfEnvironment(getMOR());
}
    public void markAsVirtualMachine(ResourcePool pool, HostSystem host) throws VmConfigFault, FileFault, InvalidState, InvalidDatastore, RuntimeFault, RemoteException {
    if (pool == null) {
        throw new IllegalArgumentException("pool must not be null.");
    }
    getVimService().markAsVirtualMachine(getMOR(), pool.getMOR(), host == null ? null : host.getMOR());
}
    /**
 * @since SDK4.0
 */
public DiskChangeInfo queryChangedDiskAreas(VirtualMachineSnapshot snapshot, int deviceKey, long startOffset, String changeId) throws FileFault, NotFound, RuntimeFault, RemoteException {
    return getVimService().queryChangedDiskAreas(getMOR(), snapshot == null ? null : snapshot.getMOR(), deviceKey, startOffset, changeId);
}
    /**
 * @since SDK4.1
 * @deprecated As of 6.0 use {@link #queryFaultToleranceCompatibilityEx}
 */
public LocalizedMethodFault[] queryFaultToleranceCompatibility() throws InvalidState, VmConfigFault, RuntimeFault, RemoteException {
    return getVimService().queryFaultToleranceCompatibility(getMOR());
}
    /**
 * This API can be invoked to determine whether a virtual machine is compatible for Fault Tolerance. The API only
 * checks for VM-specific factors that impact compatibility for Fault Tolerance. Other requirements for Fault
 * Tolerance such as host processor compatibility, logging nic configuration and licensing are not covered by this
 * API. The query returns a list of faults, each fault corresponding to a specific incompatibility. If a given
 * virtual machine is compatible for Fault Tolerance, then the fault list returned will be empty.
 *
 * @param forLegacyFt checks for legacy record-replay FT compatibility only if this is set to true.
 * @return Localized Method Fault
 * @throws InvalidState
 * @throws VmConfigFault
 * @throws RuntimeFault
 * @throws RemoteException
 * @since 6.0
 */
public LocalizedMethodFault[] queryFaultToleranceCompatibilityEx(Boolean forLegacyFt) throws InvalidState, VmConfigFault, RuntimeFault, RemoteException {
    return getVimService().queryFaultToleranceCompatibilityEx(getMOR(), forLegacyFt);
}
    /**
 * @since 6.0
 */
public LocalizedMethodFault[] queryFaultToleranceCompatibilityEx() throws InvalidState, VmConfigFault, RuntimeFault, RemoteException {
    return queryFaultToleranceCompatibilityEx(null);
}
    /**
 * @since SDK4.0
 */
public String[] queryUnownedFiles() throws RuntimeFault, RemoteException {
    return getVimService().queryUnownedFiles(getMOR());
}
    //SDK2.5 signature for back compatibility
public Task relocateVM_Task(VirtualMachineRelocateSpec spec) throws VmConfigFault, Timedout, FileFault, InvalidState, InsufficientResourcesFault, MigrationFault, InvalidDatastore, RuntimeFault, RemoteException {
    return relocateVM_Task(spec, null);
}
    //SDK4.1 signature for back compatibility
public Task removeAllSnapshots_Task() throws SnapshotFault, TaskInProgress, InvalidState, RuntimeFault, RemoteException {
    return removeAllSnapshots_Task(false, null);
}
    //SDK2.5 signature for back compatibility
public Task revertToCurrentSnapshot_Task(HostSystem host) throws VmConfigFault, SnapshotFault, TaskInProgress, InvalidState, InsufficientResourcesFault, NotFound, RuntimeFault, RemoteException {
    return revertToCurrentSnapshot_Task(host, false);
}
    /** Backward-compat alias for {@link #getDatastore()}. */
    public Datastore[] getDatastores() {
        return getDatastore();
    }
    /* ===== END custom ===== */
}
