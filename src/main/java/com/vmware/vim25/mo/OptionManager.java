// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class OptionManager extends ManagedObject {

    public OptionManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public OptionValue[] getSetting() {
        return (OptionValue[]) getCurrentProperty("setting");
    }

    public OptionDef[] getSupportedOption() {
        return (OptionDef[]) getCurrentProperty("supportedOption");
    }

    public void updateOptions(OptionValue[] changedValue) throws InvalidName, RuntimeFault, RemoteException {
        getVimService().updateOptions(getMOR(), changedValue);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public OptionValue[] queryOptions(String name) throws InvalidName, RuntimeFault, RemoteException {
    return getVimService().queryOptions(getMOR(), name);
}
    /* ===== END custom ===== */
}
