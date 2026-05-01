// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class Alarm extends ExtensibleManagedObject {

    public Alarm(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public AlarmInfo getInfo() {
        return (AlarmInfo) getCurrentProperty("info");
    }

    public void reconfigureAlarm(AlarmSpec spec) throws DuplicateName, InvalidName, RuntimeFault, RemoteException {
        getVimService().reconfigureAlarm(getMOR(), spec);
    }

    public void removeAlarm() throws RuntimeFault, RemoteException {
        getVimService().removeAlarm(getMOR());
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public ManagedEntity getAssociatedEntity() {
        return (ManagedEntity) getManagedObject("info.entity");
    }
    /** Backward-compat alias for {@link #getInfo()}. */
    public AlarmInfo getAlarmInfo() {
        return getInfo();
    }
    /* ===== END custom ===== */
}
