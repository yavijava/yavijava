// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class ComputeResource extends ManagedEntity {

    public ComputeResource(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public boolean getConfigManagerEnabled() {
        return (boolean) getCurrentProperty("configManagerEnabled");
    }

    public ComputeResourceConfigInfo getConfigurationEx() {
        return (ComputeResourceConfigInfo) getCurrentProperty("configurationEx");
    }

    public Datastore[] getDatastore() {
        return getDatastores("datastore");
    }

    public EnvironmentBrowser getEnvironmentBrowser() {
        return (EnvironmentBrowser) this.getManagedObject("environmentBrowser");
    }

    public HostSystem[] getHost() {
        return getHosts("host");
    }

    public boolean getLifecycleManaged() {
        return (boolean) getCurrentProperty("lifecycleManaged");
    }

    public Network[] getNetwork() {
        return getNetworks("network");
    }

    public String getNetworkBootMode() {
        return (String) getCurrentProperty("networkBootMode");
    }

    public ResourcePool getResourcePool() {
        return (ResourcePool) this.getManagedObject("resourcePool");
    }

    public ComputeResourceSummary getSummary() {
        return (ComputeResourceSummary) getCurrentProperty("summary");
    }

    public Task disableNetworkBoot_Task() throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().disableNetworkBoot_Task(getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task enableNetworkBoot_Task(String networkBootMode) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().enableNetworkBoot_Task(getMOR(), networkBootMode);
        return new Task(getServerConnection(), resultMor);
    }

    public Task reconfigureComputeResource_Task(ComputeResourceConfigSpec spec, boolean modify) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().reconfigureComputeResource_Task(getMOR(), spec, modify);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /** Backward-compat alias for {@link #getNetwork()}. */
    public Network[] getNetworks() {
        return getNetwork();
    }
    /* ===== END custom ===== */
}
