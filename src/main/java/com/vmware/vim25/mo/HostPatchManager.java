// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostPatchManager extends ManagedObject {

    public HostPatchManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public Task checkHostPatch_Task(String[] metaUrls, String[] bundleUrls, HostPatchManagerPatchManagerOperationSpec spec) throws InvalidState, PlatformConfigFault, RequestCanceled, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().checkHostPatch_Task(getMOR(), metaUrls, bundleUrls, spec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task installHostPatchV2_Task(String[] metaUrls, String[] bundleUrls, String[] vibUrls, HostPatchManagerPatchManagerOperationSpec spec) throws InvalidState, PlatformConfigFault, RequestCanceled, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().installHostPatchV2_Task(getMOR(), metaUrls, bundleUrls, vibUrls, spec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task queryHostPatch_Task(HostPatchManagerPatchManagerOperationSpec spec) throws InvalidState, PlatformConfigFault, RequestCanceled, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().queryHostPatch_Task(getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task scanHostPatchV2_Task(String[] metaUrls, String[] bundleUrls, HostPatchManagerPatchManagerOperationSpec spec) throws InvalidState, PlatformConfigFault, RequestCanceled, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().scanHostPatchV2_Task(getMOR(), metaUrls, bundleUrls, spec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task stageHostPatch_Task(String[] metaUrls, String[] bundleUrls, String[] vibUrls, HostPatchManagerPatchManagerOperationSpec spec) throws InvalidState, PlatformConfigFault, RequestCanceled, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().stageHostPatch_Task(getMOR(), metaUrls, bundleUrls, vibUrls, spec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task uninstallHostPatch_Task(String[] bulletinIds, HostPatchManagerPatchManagerOperationSpec spec) throws InvalidState, PlatformConfigFault, TaskInProgress, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().uninstallHostPatch_Task(getMOR(), bulletinIds, spec);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public Task installHostPatch_Task(HostPatchManagerLocator repository, String updateID, Boolean force) throws PatchInstallFailed, NoDiskSpace, TaskInProgress, RebootRequired, PatchBinariesNotFound, InvalidState, PatchNotApplicable, PatchMetadataInvalid, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().installHostPatch_Task(getMOR(), repository, updateID, force));
}
    public Task scanHostPatch_Task(HostPatchManagerLocator repository, String[] updateID) throws PlatformConfigFault, RequestCanceled, PatchMetadataInvalid, RuntimeFault, RemoteException {
    return new Task(getServerConnection(), getVimService().scanHostPatch_Task(getMOR(), repository, updateID));
}
    /* ===== END custom ===== */
}
