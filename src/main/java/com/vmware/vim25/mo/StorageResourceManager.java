// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class StorageResourceManager extends ManagedObject {

    public StorageResourceManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public Task applyRecommendation(String[] key) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().applyStorageDrsRecommendation_Task(getMOR(), key);
        return new Task(getServerConnection(), resultMor);
    }

    public Task applyRecommendationToPod(StoragePod pod, String key) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().applyStorageDrsRecommendationToPod_Task(getMOR(), pod == null ? null : pod.getMOR(), key);
        return new Task(getServerConnection(), resultMor);
    }

    public void cancelRecommendation(String[] key) throws RuntimeFault, RemoteException {
        getVimService().cancelStorageDrsRecommendation(getMOR(), key);
    }

    public Task configureDatastoreIORM(Datastore datastore, StorageIORMConfigSpec spec) throws IORMNotSupportedHostOnDatastore, InaccessibleDatastore, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().configureDatastoreIORM_Task(getMOR(), datastore == null ? null : datastore.getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task configureStorageDrsForPod(StoragePod pod, StorageDrsConfigSpec spec, boolean modify) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().configureStorageDrsForPod_Task(getMOR(), pod == null ? null : pod.getMOR(), spec, modify);
        return new Task(getServerConnection(), resultMor);
    }

    public void refreshRecommendation(StoragePod pod) throws RuntimeFault, RemoteException {
        getVimService().refreshStorageDrsRecommendation(getMOR(), pod == null ? null : pod.getMOR());
    }

    public Task refreshRecommendationsForPod(StoragePod pod) throws InvalidArgument, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().refreshStorageDrsRecommendationsForPod_Task(getMOR(), pod == null ? null : pod.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public LocalizedMethodFault validateStoragePodConfig(StoragePod pod, StorageDrsConfigSpec spec) throws RuntimeFault, RemoteException {
        return getVimService().validateStoragePodConfig(getMOR(), pod == null ? null : pod.getMOR(), spec);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /**
 * @since SDK5.1
 */
public StoragePerformanceSummary[] queryDatastorePerformanceSummary(Datastore datastore) throws NotFound, RuntimeFault, RemoteException {
    return getVimService().queryDatastorePerformanceSummary(getMOR(), datastore.getMOR());
}
    public StorageIORMConfigOption queryIORMConfigOption(HostSystem host) throws RuntimeFault, RemoteException {
    return getVimService().queryIORMConfigOption(getMOR(), host.getMOR());
}
    /**
 * @since SDK5.0
 */
public StoragePlacementResult recommendDatastores(StoragePlacementSpec storageSpec) throws RuntimeFault, RemoteException {
    return getVimService().recommendDatastores(getMOR(), storageSpec);
}
    /* ===== END custom ===== */
}
