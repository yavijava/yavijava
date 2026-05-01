// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.HostEsxAgentHostManagerConfigInfo;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class HostEsxAgentHostManager extends ManagedObject {

    public HostEsxAgentHostManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostEsxAgentHostManagerConfigInfo getConfigInfo() {
        return (HostEsxAgentHostManagerConfigInfo) getCurrentProperty("configInfo");
    }

    public void esxAgentHostManagerUpdateConfig(HostEsxAgentHostManagerConfigInfo configInfo) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().esxAgentHostManagerUpdateConfig(getMOR(), configInfo);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
