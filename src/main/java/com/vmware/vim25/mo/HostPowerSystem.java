package com.vmware.vim25.mo;

import com.vmware.vim25.HostConfigFault;
import com.vmware.vim25.PowerSystemCapability;
import com.vmware.vim25.PowerSystemInfo;
import com.vmware.vim25.RuntimeFault;

import java.rmi.RemoteException;

public class HostPowerSystem extends ManagedObject {
    public PowerSystemCapability getCapability() {
        return (PowerSystemCapability) getCurrentProperty("capability");
    }

    public PowerSystemInfo getInfo() {
        return (PowerSystemInfo) getCurrentProperty("info");
    }

    public void configurePowerPolicy(int key) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().configurePowerPolicy(getMOR(), key);
    }
}