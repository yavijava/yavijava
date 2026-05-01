// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class ScheduledTaskManager extends ManagedObject {

    public ScheduledTaskManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public ScheduledTaskDescription getDescription() {
        return (ScheduledTaskDescription) getCurrentProperty("description");
    }

    public ScheduledTask[] getScheduledTask() {
        return getScheduledTasks("scheduledTask");
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public ScheduledTaskDescription getDescriptioin() {
        return (ScheduledTaskDescription) getCurrentProperty("description");
    }
    public ScheduledTask createScheduledTask(ManagedEntity entity, ScheduledTaskSpec spec) throws InvalidName, DuplicateName, RuntimeFault, RemoteException {
    if (entity == null) {
        throw new IllegalArgumentException("entity must not be null.");
    }
    return new ScheduledTask(getServerConnection(), getVimService().createScheduledTask(getMOR(), entity.getMOR(), spec));
}
    /**
 * @since SDK4.0
 */
public ScheduledTask createObjectScheduledTask(ManagedObject obj, ScheduledTaskSpec spec) throws InvalidName, DuplicateName, RuntimeFault, RemoteException {
    if (obj == null) {
        throw new IllegalArgumentException("managed object must not be null.");
    }
    return new ScheduledTask(getServerConnection(), getVimService().createObjectScheduledTask(getMOR(), obj.getMOR(), spec));
}
    public ScheduledTask[] retrieveEntityScheduledTask(ManagedEntity entity) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = getVimService().retrieveEntityScheduledTask(getMOR(), entity == null ? null : entity.getMOR());
    ScheduledTask[] tasks = new ScheduledTask[mors.length];
    for (int i = 0; i < mors.length; i++) {
        tasks[i] = new ScheduledTask(getServerConnection(), mors[i]);
    }
    return tasks;
}
    /**
 * @since SDK4.0
 */
public ScheduledTask[] retrieveObjectScheduledTask(ManagedObject obj) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = getVimService().retrieveObjectScheduledTask(getMOR(), obj == null ? null : obj.getMOR());
    ScheduledTask[] tasks = new ScheduledTask[mors.length];
    for (int i = 0; i < mors.length; i++) {
        tasks[i] = new ScheduledTask(getServerConnection(), mors[i]);
    }
    return tasks;
}
    /* ===== END custom ===== */
}
