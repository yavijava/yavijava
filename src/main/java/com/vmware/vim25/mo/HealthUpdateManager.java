// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HealthUpdateManager extends ManagedObject {

    public HealthUpdateManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public String addFilter(String providerId, String filterName, String[] infoIds) throws NotFound, RuntimeFault, RemoteException {
        return getVimService().addFilter(getMOR(), providerId, filterName, infoIds);
    }

    public void addFilterEntities(String filterId, ManagedEntity[] entities) throws NotFound, RuntimeFault, RemoteException {
        getVimService().addFilterEntities(getMOR(), filterId, entities == null ? null : MorUtil.createMORs(entities));
    }

    public void addMonitoredEntities(String providerId, ManagedEntity[] entities) throws NotFound, RuntimeFault, RemoteException {
        getVimService().addMonitoredEntities(getMOR(), providerId, entities == null ? null : MorUtil.createMORs(entities));
    }

    public boolean hasMonitoredEntity(String providerId, ManagedEntity entity) throws NotFound, RuntimeFault, RemoteException {
        return getVimService().hasMonitoredEntity(getMOR(), providerId, entity == null ? null : entity.getMOR());
    }

    public boolean hasProvider(String id) throws RuntimeFault, RemoteException {
        return getVimService().hasProvider(getMOR(), id);
    }

    public void postHealthUpdates(String providerId, HealthUpdate[] updates) throws NotFound, RuntimeFault, RemoteException {
        getVimService().postHealthUpdates(getMOR(), providerId, updates);
    }

    public ManagedObjectReference[] queryFilterEntities(String filterId) throws NotFound, RuntimeFault, RemoteException {
        return getVimService().queryFilterEntities(getMOR(), filterId);
    }

    public String[] queryFilterInfoIds(String filterId) throws NotFound, RuntimeFault, RemoteException {
        return getVimService().queryFilterInfoIds(getMOR(), filterId);
    }

    public String[] queryFilterList(String providerId) throws NotFound, RuntimeFault, RemoteException {
        return getVimService().queryFilterList(getMOR(), providerId);
    }

    public String queryFilterName(String filterId) throws NotFound, RuntimeFault, RemoteException {
        return getVimService().queryFilterName(getMOR(), filterId);
    }

    public HealthUpdateInfo[] queryHealthUpdateInfos(String providerId) throws NotFound, RuntimeFault, RemoteException {
        return getVimService().queryHealthUpdateInfos(getMOR(), providerId);
    }

    public HealthUpdate[] queryHealthUpdates(String providerId) throws NotFound, RuntimeFault, RemoteException {
        return getVimService().queryHealthUpdates(getMOR(), providerId);
    }

    public ManagedObjectReference[] queryMonitoredEntities(String providerId) throws NotFound, RuntimeFault, RemoteException {
        return getVimService().queryMonitoredEntities(getMOR(), providerId);
    }

    public String[] queryProviderList() throws RuntimeFault, RemoteException {
        return getVimService().queryProviderList(getMOR());
    }

    public String queryProviderName(String id) throws NotFound, RuntimeFault, RemoteException {
        return getVimService().queryProviderName(getMOR(), id);
    }

    public ManagedObjectReference[] queryUnmonitoredHosts(String providerId, ClusterComputeResource cluster) throws NotFound, RuntimeFault, RemoteException {
        return getVimService().queryUnmonitoredHosts(getMOR(), providerId, cluster == null ? null : cluster.getMOR());
    }

    public String registerProvider(String name, HealthUpdateInfo[] healthUpdateInfo) throws RuntimeFault, RemoteException {
        return getVimService().registerHealthUpdateProvider(getMOR(), name, healthUpdateInfo);
    }

    public void removeFilter(String filterId) throws NotFound, RuntimeFault, RemoteException {
        getVimService().removeFilter(getMOR(), filterId);
    }

    public void removeFilterEntities(String filterId, ManagedEntity[] entities) throws NotFound, RuntimeFault, RemoteException {
        getVimService().removeFilterEntities(getMOR(), filterId, entities == null ? null : MorUtil.createMORs(entities));
    }

    public void removeMonitoredEntities(String providerId, ManagedEntity[] entities) throws InvalidState, NotFound, RuntimeFault, RemoteException {
        getVimService().removeMonitoredEntities(getMOR(), providerId, entities == null ? null : MorUtil.createMORs(entities));
    }

    public void unregisterProvider(String providerId) throws InvalidState, NotFound, RuntimeFault, RemoteException {
        getVimService().unregisterHealthUpdateProvider(getMOR(), providerId);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
