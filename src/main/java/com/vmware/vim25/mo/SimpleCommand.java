// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class SimpleCommand extends ManagedObject {

    public SimpleCommand(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public SimpleCommandEncoding getEncodingType() {
        return (SimpleCommandEncoding) getCurrentProperty("encodingType");
    }

    public ServiceManagerServiceInfo getEntity() {
        return (ServiceManagerServiceInfo) getCurrentProperty("entity");
    }

    public String execute(String[] arguments) throws RuntimeFault, RemoteException {
        return getVimService().executeSimpleCommand(getMOR(), arguments);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
