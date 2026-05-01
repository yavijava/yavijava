// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.DvsFault;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.VMwareDvsLacpGroupSpec;
/* ===== END custom imports ===== */

public class VmwareDistributedVirtualSwitch extends DistributedVirtualSwitch {

    public VmwareDistributedVirtualSwitch(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public Task updateLacpGroupConfig(VMwareDvsLacpGroupSpec[] lacpGroupSpec) throws DvsFault, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().updateDVSLacpGroupConfig_Task(getMOR(), lacpGroupSpec);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
