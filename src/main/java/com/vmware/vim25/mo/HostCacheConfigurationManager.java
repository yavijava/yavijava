// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.HostCacheConfigurationInfo;
import com.vmware.vim25.HostCacheConfigurationSpec;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class HostCacheConfigurationManager extends ManagedObject {

    public HostCacheConfigurationManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostCacheConfigurationInfo[] getCacheConfigurationInfo() {
        return (HostCacheConfigurationInfo[]) getCurrentProperty("cacheConfigurationInfo");
    }

    public Task configureHostCache_Task(HostCacheConfigurationSpec spec) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().configureHostCache_Task(getMOR(), spec);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
