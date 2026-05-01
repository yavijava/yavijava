// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.NetworkSummary;
import com.vmware.vim25.ResourceInUse;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class Network extends ManagedEntity {

    public Network(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostSystem[] getHost() {
        return getHosts("host");
    }

    public NetworkSummary getSummary() {
        return (NetworkSummary) getCurrentProperty("summary");
    }

    public VirtualMachine[] getVm() {
        return getVms("vm");
    }

    public void destroyNetwork() throws ResourceInUse, RuntimeFault, RemoteException {
        getVimService().destroyNetwork(getMOR());
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
