// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;
import java.util.Calendar;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class PerformanceManager extends ManagedObject {

    public PerformanceManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public PerformanceDescription getDescription() {
        return (PerformanceDescription) getCurrentProperty("description");
    }

    public PerfInterval[] getHistoricalInterval() {
        return (PerfInterval[]) getCurrentProperty("historicalInterval");
    }

    public PerfCounterInfo[] getPerfCounter() {
        return (PerfCounterInfo[]) getCurrentProperty("perfCounter");
    }

    public void createHistoricalInterval(PerfInterval intervalId) throws RuntimeFault, RemoteException {
        getVimService().createPerfInterval(getMOR(), intervalId);
    }

    public PerfMetricId[] queryAvailableMetric(ManagedObject entity, Calendar beginTime, Calendar endTime, int intervalId) throws RuntimeFault, RemoteException {
        return getVimService().queryAvailablePerfMetric(getMOR(), entity == null ? null : entity.getMOR(), beginTime, endTime, intervalId);
    }

    public PerfCompositeMetric queryCompositeStats(PerfQuerySpec querySpec) throws RuntimeFault, RemoteException {
        return getVimService().queryPerfComposite(getMOR(), querySpec);
    }

    public PerfCounterInfo[] queryCounter(int[] counterId) throws RuntimeFault, RemoteException {
        return getVimService().queryPerfCounter(getMOR(), counterId);
    }

    public PerfCounterInfo[] queryCounterByLevel(int level) throws RuntimeFault, RemoteException {
        return getVimService().queryPerfCounterByLevel(getMOR(), level);
    }

    public PerfProviderSummary queryProviderSummary(ManagedObject entity) throws RuntimeFault, RemoteException {
        return getVimService().queryPerfProviderSummary(getMOR(), entity == null ? null : entity.getMOR());
    }

    public PerfEntityMetricBase[] queryStats(PerfQuerySpec[] querySpec) throws RuntimeFault, RemoteException {
        return getVimService().queryPerf(getMOR(), querySpec);
    }

    public void removeHistoricalInterval(int samplePeriod) throws RuntimeFault, RemoteException {
        getVimService().removePerfInterval(getMOR(), samplePeriod);
    }

    public void resetCounterLevelMapping(int[] counters) throws RuntimeFault, RemoteException {
        getVimService().resetCounterLevelMapping(getMOR(), counters);
    }

    public void updateCounterLevelMapping(PerformanceManagerCounterLevelMapping[] counterLevelMap) throws RuntimeFault, RemoteException {
        getVimService().updateCounterLevelMapping(getMOR(), counterLevelMap);
    }

    public void updateHistoricalInterval(PerfInterval interval) throws RuntimeFault, RemoteException {
        getVimService().updatePerfInterval(getMOR(), interval);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public PerfMetricId[] queryAvailablePerfMetric(ManagedEntity entity, Calendar beginTime, Calendar endTime, Integer intervalId) throws RuntimeFault, RemoteException {
    if (entity == null) {
        throw new IllegalArgumentException("entity must not be null.");
    }
    return getVimService().queryAvailablePerfMetric(getMOR(), entity.getMOR(), beginTime, endTime, intervalId);
}
    public PerfEntityMetricBase[] queryPerf(PerfQuerySpec[] querySpec) throws RuntimeFault, RemoteException {
    return getVimService().queryPerf(getMOR(), querySpec);
}
    public PerfCompositeMetric queryPerfComposite(PerfQuerySpec querySpec) throws RuntimeFault, RemoteException {
    return getVimService().queryPerfComposite(getMOR(), querySpec);
}
    public PerfCounterInfo[] queryPerfCounter(int[] counterIds) throws RuntimeFault, RemoteException {
    return getVimService().queryPerfCounter(getMOR(), counterIds);
}
    public PerfCounterInfo[] queryPerfCounterByLevel(int level) throws RuntimeFault, RemoteException {
    return getVimService().queryPerfCounterByLevel(getMOR(), level);
}
    public PerfProviderSummary queryPerfProviderSummary(ManagedEntity entity) throws RuntimeFault, RemoteException {
    if (entity == null) {
        throw new IllegalArgumentException("entity must not be null.");
    }
    return getVimService().queryPerfProviderSummary(getMOR(), entity.getMOR());
}
    /* ===== END custom ===== */
}
