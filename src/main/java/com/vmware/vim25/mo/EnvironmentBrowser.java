// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class EnvironmentBrowser extends ManagedObject {

    public EnvironmentBrowser(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostDatastoreBrowser getDatastoreBrowser() {
        return (HostDatastoreBrowser) this.getManagedObject("datastoreBrowser");
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public VirtualMachineConfigOption queryConfigOption(String key, HostSystem host) throws RuntimeFault, RemoteException {
    return getVimService().queryConfigOption(getMOR(), key, host == null ? null : host.getMOR());
}
    public VirtualMachineConfigOptionDescriptor[] queryConfigOptionDescriptor() throws RuntimeFault, RemoteException {
    return getVimService().queryConfigOptionDescriptor(getMOR());
}
    public ConfigTarget queryConfigTarget(HostSystem host) throws RuntimeFault, RemoteException {
    return getVimService().queryConfigTarget(getMOR(), host == null ? null : host.getMOR());
}
    public HostCapability queryTargetCapabilities(HostSystem host) throws RuntimeFault, RemoteException {
    return getVimService().queryTargetCapabilities(getMOR(), host == null ? null : host.getMOR());
}
    /**
 * Query for a virtual machine configuration option matching the key or host or both given in the
 * {@link com.vmware.vim25.EnvironmentBrowserConfigOptionQuerySpec EnvironmentBrowserConfigOptionQuerySpec}. For
 * more details see {@link #queryConfigOption queryConfigOption}
 * If the Environment Browser belongs to a virtual machine and the spec argument is omitted, the method returns the
 * ConfigOption object corresponding to the vmx version of the virutal machine and the guestOSDescriptor list
 * contains only the guestId of the virutal machine.
 *
 * @param spec -
 *             Search criteria and filters to control the result. If a key or host (or both) are specified, they
 *             will be used to search for a config option. If guestId is nonempty, the guestOSDescriptor array of
 *             the config option is filtered to match against the guest IDs in the spec. If there is no match, the
 *             whole list is returned. If the spec argument is omitted, the default VirtualMachineConfigOption for
 *             this environment browser is returned.
 * @return Returns the VirtualMachineConfigOption object. If invoked on a cluster with no hosts, or if the VirtualMachineConfigOption with given key is not found for the given host, null is returned.
 * @throws InvalidArgument
 * @throws RuntimeFault
 * @throws RemoteException
 * @since 6.0
 */
public VirtualMachineConfigOption queryConfigOptionEx(EnvironmentBrowserConfigOptionQuerySpec spec) throws InvalidArgument, RuntimeFault, RemoteException {
    return getVimService().queryConfigOptionEx(getMOR(), spec);
}
    public VirtualMachineConfigOption queryConfigOptionEx() throws InvalidArgument, RuntimeFault, RemoteException {
    return queryConfigOptionEx(null);
}
    /* ===== END custom ===== */
}
