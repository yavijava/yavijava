// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.mo.util.MorUtil;
/* ===== END custom imports ===== */

public class ResourcePool extends ManagedEntity {

    public ResourcePool(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public ResourceConfigSpec[] getChildConfiguration() {
        return (ResourceConfigSpec[]) getCurrentProperty("childConfiguration");
    }

    public ResourceConfigSpec getConfig() {
        return (ResourceConfigSpec) getCurrentProperty("config");
    }

    public String getNamespace() {
        return (String) getCurrentProperty("namespace");
    }

    public ComputeResource getOwner() {
        return (ComputeResource) this.getManagedObject("owner");
    }

    public ResourcePool[] getResourcePool() {
        return getResourcePools("resourcePool");
    }

    public ResourcePoolRuntimeInfo getRuntime() {
        return (ResourcePoolRuntimeInfo) getCurrentProperty("runtime");
    }

    public ResourcePoolSummary getSummary() {
        return (ResourcePoolSummary) getCurrentProperty("summary");
    }

    public VirtualMachine[] getVm() {
        return getVms("vm");
    }

    public ResourcePool createResourcePool(String name, ResourceConfigSpec spec) throws DuplicateName, InsufficientResourcesFault, InvalidName, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createResourcePool(getMOR(), name, spec);
        return new ResourcePool(getServerConnection(), resultMor);
    }

    public VirtualApp createVApp(String name, ResourceConfigSpec resSpec, VAppConfigSpec configSpec, Folder vmFolder) throws DuplicateName, InsufficientResourcesFault, InvalidName, InvalidState, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createVApp(getMOR(), name, resSpec, configSpec, vmFolder == null ? null : vmFolder.getMOR());
        return new VirtualApp(getServerConnection(), resultMor);
    }

    public Task createVM_Task(VirtualMachineConfigSpec config, HostSystem host) throws FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidName, OutOfBounds, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createVM_Task(getMOR(), config, getMOR(), host == null ? null : host.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public void destroyChildren() throws RuntimeFault, RemoteException {
        getVimService().destroyChildren(getMOR());
    }

    public HttpNfcLease importVApp(ImportSpec spec, Folder folder, HostSystem host) throws DuplicateName, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidName, OutOfBounds, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().importVApp(getMOR(), spec, folder == null ? null : folder.getMOR(), host == null ? null : host.getMOR());
        return new HttpNfcLease(getServerConnection(), resultMor);
    }

    public void refreshRuntime() throws RuntimeFault, RemoteException {
        getVimService().refreshRuntime(getMOR());
    }

    public Task registerChildVM_Task(String path, String name, HostSystem host) throws AlreadyExists, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidName, NotFound, OutOfBounds, VmConfigFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().registerChildVM_Task(getMOR(), path, name, host == null ? null : host.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public void updateChildResourceConfiguration(ResourceConfigSpec[] spec) throws InsufficientResourcesFault, InvalidState, RuntimeFault, RemoteException {
        getVimService().updateChildResourceConfiguration(getMOR(), spec);
    }

    public void updateConfig(String name, ResourceConfigSpec config) throws ConcurrentAccess, DuplicateName, InsufficientResourcesFault, InvalidName, RuntimeFault, RemoteException {
        getVimService().updateConfig(getMOR(), name, config);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public void moveIntoResourcePool(ManagedEntity[] entities) throws DuplicateName, InsufficientResourcesFault, RuntimeFault, RemoteException {
    if (entities == null) {
        throw new IllegalArgumentException("entities must not be null.");
    }
    getVimService().moveIntoResourcePool(getMOR(), MorUtil.createMORs(entities));
}
    /**
 * @since SDK4.1
 */
public ResourceConfigOption queryResourceConfigOption() throws RuntimeFault, RemoteException {
    return getVimService().queryResourceConfigOption(getMOR());
}
    /* ===== END custom ===== */
}
