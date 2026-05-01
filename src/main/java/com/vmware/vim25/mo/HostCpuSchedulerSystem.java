// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.HostHyperThreadScheduleInfo;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class HostCpuSchedulerSystem extends ExtensibleManagedObject {

    public HostCpuSchedulerSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostCpuSchedulerInfo getCpuSchedulerInfo() {
        return (HostCpuSchedulerInfo) getCurrentProperty("cpuSchedulerInfo");
    }

    public HostHyperThreadScheduleInfo getHyperthreadInfo() {
        return (HostHyperThreadScheduleInfo) getCurrentProperty("hyperthreadInfo");
    }

    public void disableHyperThreading() throws RuntimeFault, RemoteException {
        getVimService().disableHyperThreading(getMOR());
    }

    public void enableHyperThreading() throws RuntimeFault, RemoteException {
        getVimService().enableHyperThreading(getMOR());
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
