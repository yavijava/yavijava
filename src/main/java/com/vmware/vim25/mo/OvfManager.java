// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class OvfManager extends ManagedObject {

    public OvfManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public OvfOptionInfo[] getOvfExportOption() {
        return (OvfOptionInfo[]) getCurrentProperty("ovfExportOption");
    }

    public OvfOptionInfo[] getOvfImportOption() {
        return (OvfOptionInfo[]) getCurrentProperty("ovfImportOption");
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public OvfCreateDescriptorResult createDescriptor(ManagedEntity obj, OvfCreateDescriptorParams cdp) throws TaskInProgress, VmConfigFault, ConcurrentAccess, FileFault, InvalidState, RuntimeFault, RemoteException {
    return getVimService().createDescriptor(getMOR(), obj.getMOR(), cdp);
}
    public OvfCreateImportSpecResult createImportSpec(String ovfDescriptor, ResourcePool resourcePool, Datastore datastore, OvfCreateImportSpecParams cisp) throws TaskInProgress, VmConfigFault, ConcurrentAccess, FileFault, InvalidState, InvalidDatastore, RuntimeFault, RemoteException {
    return getVimService().createImportSpec(getMOR(), ovfDescriptor, resourcePool.getMOR(), datastore.getMOR(), cisp);
}
    public OvfParseDescriptorResult parseDescriptor(String ovfDescriptor, OvfParseDescriptorParams pdp) throws TaskInProgress, VmConfigFault, ConcurrentAccess, FileFault, InvalidState, RuntimeFault, RemoteException {
    return getVimService().parseDescriptor(getMOR(), ovfDescriptor, pdp);
}
    public OvfValidateHostResult validateHost(String ovfDescriptor, HostSystem host, OvfValidateHostParams vhp) throws TaskInProgress, ConcurrentAccess, FileFault, InvalidState, RuntimeFault, RemoteException {
    return getVimService().validateHost(getMOR(), ovfDescriptor, host.getMOR(), vhp);
}
    /* ===== END custom ===== */
}
