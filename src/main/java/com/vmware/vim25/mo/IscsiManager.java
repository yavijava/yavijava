// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class IscsiManager extends ManagedObject {

    public IscsiManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void bindVnic(String iScsiHbaName, String vnicDevice) throws IscsiFault, IscsiFaultInvalidVnic, IscsiFaultVnicAlreadyBound, IscsiFaultVnicHasMultipleUplinks, IscsiFaultVnicHasNoUplinks, IscsiFaultVnicHasWrongUplink, IscsiFaultVnicNotFound, NotFound, PlatformConfigFault, RuntimeFault, RemoteException {
        getVimService().bindVnic(getMOR(), iScsiHbaName, vnicDevice);
    }

    public void unbindVnic(String iScsiHbaName, String vnicDevice, boolean force) throws IscsiFault, IscsiFaultVnicHasActivePaths, IscsiFaultVnicIsLastPath, IscsiFaultVnicNotBound, NotFound, PlatformConfigFault, RuntimeFault, RemoteException {
        getVimService().unbindVnic(getMOR(), iScsiHbaName, vnicDevice, force);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public IscsiPortInfo[] queryBoundVnics(String iScsiHbaName) throws IscsiFault, NotFound, RuntimeFault, RemoteException {
    return getVimService().queryBoundVnics(getMOR(), iScsiHbaName);
}
    public IscsiPortInfo[] queryCandidateNics(String iScsiHbaName) throws IscsiFault, NotFound, RuntimeFault, RemoteException {
    return getVimService().queryCandidateNics(getMOR(), iScsiHbaName);
}
    public IscsiMigrationDependency queryMigrationDependencies(String[] pnicDevice) throws RuntimeFault, RemoteException {
    return getVimService().queryMigrationDependencies(getMOR(), pnicDevice);
}
    public IscsiStatus queryPnicStatus(String pnicDevice) throws IscsiFault, RuntimeFault, RemoteException {
    return getVimService().queryPnicStatus(getMOR(), pnicDevice);
}
    public IscsiStatus queryVnicStatus(String vnicDevice) throws IscsiFault, RuntimeFault, RemoteException {
    return getVimService().queryVnicStatus(getMOR(), vnicDevice);
}
    /* ===== END custom ===== */
}
