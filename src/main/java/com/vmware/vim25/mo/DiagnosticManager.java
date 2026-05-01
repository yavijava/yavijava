// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class DiagnosticManager extends ManagedObject {

    public DiagnosticManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public DiagnosticManagerLogHeader browse(HostSystem host, String key, int start, int lines) throws CannotAccessFile, RuntimeFault, RemoteException {
        return getVimService().browseDiagnosticLog(getMOR(), host == null ? null : host.getMOR(), key, start, lines);
    }

    public void emitSyslogMark(String message) throws RuntimeFault, RemoteException {
        getVimService().emitSyslogMark(getMOR(), message);
    }

    public DiagnosticManagerAuditRecordResult fetchAuditRecords(String token) throws InvalidState, SystemError, RuntimeFault, RemoteException {
        return getVimService().fetchAuditRecords(getMOR(), token);
    }

    public Task generateLogBundles(boolean includeDefault, HostSystem[] host) throws LogBundlingFailed, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().generateLogBundles_Task(getMOR(), includeDefault, host == null ? null : MorUtil.createMORs(host));
        return new Task(getServerConnection(), taskMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public DiagnosticManagerLogHeader browseDiagnosticLog(HostSystem host, String key, int start, int lines) throws CannotAccessFile, RuntimeFault, RemoteException {
    return getVimService().browseDiagnosticLog(getMOR(), host == null ? null : host.getMOR(), key, start, lines);
}
    public DiagnosticManagerLogDescriptor[] queryDescriptions(HostSystem host) throws RuntimeFault, RemoteException {
    return getVimService().queryDescriptions(getMOR(), host == null ? null : host.getMOR());
}
    /** Backward-compat alias for {@link #generateLogBundles(boolean, HostSystem[])}. */
    public Task generateLogBundles_Task(boolean includeDefault, HostSystem[] hosts) throws LogBundlingFailed, TaskInProgress, RuntimeFault, RemoteException {
        return generateLogBundles(includeDefault, hosts);
    }
    /* ===== END custom ===== */
}
