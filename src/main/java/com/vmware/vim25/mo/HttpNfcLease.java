// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HttpNfcLease extends ManagedObject {

    public HttpNfcLease(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HttpNfcLeaseCapabilities getCapabilities() {
        return (HttpNfcLeaseCapabilities) getCurrentProperty("capabilities");
    }

    public MethodFault getError() {
        return (MethodFault) getCurrentProperty("error");
    }

    public HttpNfcLeaseInfo getInfo() {
        return (HttpNfcLeaseInfo) getCurrentProperty("info");
    }

    public String getMode() {
        return (String) getCurrentProperty("mode");
    }

    public HttpNfcLeaseState getState() {
        return (HttpNfcLeaseState) getCurrentProperty("state");
    }

    public int getTransferProgress() {
        return (int) getCurrentProperty("transferProgress");
    }

    public void httpNfcLeaseAbort(LocalizedMethodFault fault) throws InvalidState, Timedout, RuntimeFault, RemoteException {
        getVimService().httpNfcLeaseAbort(getMOR(), fault);
    }

    public void httpNfcLeaseComplete() throws InvalidState, Timedout, RuntimeFault, RemoteException {
        getVimService().httpNfcLeaseComplete(getMOR());
    }

    public HttpNfcLeaseProbeResult[] httpNfcLeaseProbeUrls(HttpNfcLeaseSourceFile[] files, int timeout) throws InvalidState, RuntimeFault, RemoteException {
        return getVimService().httpNfcLeaseProbeUrls(getMOR(), files, timeout);
    }

    public void httpNfcLeaseProgress(int percent) throws Timedout, RuntimeFault, RemoteException {
        getVimService().httpNfcLeaseProgress(getMOR(), percent);
    }

    public Task httpNfcLeasePullFromUrls_Task(HttpNfcLeaseSourceFile[] files) throws HttpFault, InvalidState, SSLVerifyFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().httpNfcLeasePullFromUrls_Task(getMOR(), files);
        return new Task(getServerConnection(), resultMor);
    }

    public void httpNfcLeaseSetManifestChecksumType(KeyValue[] deviceUrlsToChecksumTypes) throws InvalidState, RuntimeFault, RemoteException {
        getVimService().httpNfcLeaseSetManifestChecksumType(getMOR(), deviceUrlsToChecksumTypes);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public int getInitializeProgress() {
    return ((Integer) getCurrentProperty("initializeProgress")).intValue();
}
    /**
 * @since SDK4.1
 */
public HttpNfcLeaseManifestEntry[] httpNfcLeaseGetManifest() throws Timedout, InvalidState, RuntimeFault, RemoteException {
    return getVimService().httpNfcLeaseGetManifest(getMOR());
}
    /* ===== END custom ===== */
}
