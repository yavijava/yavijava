// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostDiagnosticSystem extends ManagedObject {

    public HostDiagnosticSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostDiagnosticPartition getActivePartition() {
        return (HostDiagnosticPartition) getCurrentProperty("activePartition");
    }

    public void createDiagnosticPartition(HostDiagnosticPartitionCreateSpec spec) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().createDiagnosticPartition(getMOR(), spec);
    }

    public void selectActivePartition(HostScsiDiskPartition partition) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().selectActivePartition(getMOR(), partition);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public HostDiagnosticPartition[] queryAvailablePartition() throws HostConfigFault, RuntimeFault, RemoteException {
    return getVimService().queryAvailablePartition(getMOR());
}
    public HostDiagnosticPartitionCreateDescription queryPartitionCreateDesc(String diskUuid, String diagnosticType) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
    return getVimService().queryPartitionCreateDesc(getMOR(), diskUuid, diagnosticType);
}
    public HostDiagnosticPartitionCreateOption[] queryPartitionCreateOptions(String storageType, String diagnosticType) throws HostConfigFault, RuntimeFault, RemoteException {
    return getVimService().queryPartitionCreateOptions(getMOR(), storageType, diagnosticType);
}
    /* ===== END custom ===== */
}
