// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class ServiceManager extends ManagedObject {

    public ServiceManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public ServiceManagerServiceInfo[] getService() {
        return (ServiceManagerServiceInfo[]) getCurrentProperty("service");
    }

    public ServiceManagerServiceInfo[] queryServiceList(String serviceName, String[] location) throws RuntimeFault, RemoteException {
        return getVimService().queryServiceList(getMOR(), serviceName, location);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
