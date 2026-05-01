// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class AlarmManager extends ManagedObject {

    public AlarmManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public AlarmExpression[] getDefaultExpression() {
        return (AlarmExpression[]) getCurrentProperty("defaultExpression");
    }

    public AlarmDescription getDescription() {
        return (AlarmDescription) getCurrentProperty("description");
    }

    public void acknowledgeAlarm(Alarm alarm, ManagedEntity entity) throws RuntimeFault, RemoteException {
        getVimService().acknowledgeAlarm(getMOR(), alarm == null ? null : alarm.getMOR(), entity == null ? null : entity.getMOR());
    }

    public void clearTriggeredAlarms(AlarmFilterSpec filter) throws RuntimeFault, RemoteException {
        getVimService().clearTriggeredAlarms(getMOR(), filter);
    }

    public Alarm create(ManagedEntity entity, AlarmSpec spec) throws DuplicateName, InvalidName, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createAlarm(getMOR(), entity == null ? null : entity.getMOR(), spec);
        return new Alarm(getServerConnection(), resultMor);
    }

    public void disableAlarm(Alarm alarm, ManagedEntity entity) throws RuntimeFault, RemoteException {
        getVimService().disableAlarm(getMOR(), alarm == null ? null : alarm.getMOR(), entity == null ? null : entity.getMOR());
    }

    public void enableAlarm(Alarm alarm, ManagedEntity entity) throws RuntimeFault, RemoteException {
        getVimService().enableAlarm(getMOR(), alarm == null ? null : alarm.getMOR(), entity == null ? null : entity.getMOR());
    }

    public boolean getAlarmActionsEnabled(ManagedEntity entity) throws RuntimeFault, RemoteException {
        return getVimService().areAlarmActionsEnabled(getMOR(), entity == null ? null : entity.getMOR());
    }

    public void setAlarmActionsEnabled(ManagedEntity entity, boolean enabled) throws RuntimeFault, RemoteException {
        getVimService().enableAlarmActions(getMOR(), entity == null ? null : entity.getMOR(), enabled);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /**
 * Whether or not alarm actions are available on the given ManagedEntity
 *
 * @param entity
 *            The {@link ManagedEntity} to query.
 * @return true if alarm actions are available
 * @throws RuntimeFault
 *             if any unhandled runtime fault occurs
 * @throws RemoteException
 * @since 4.0
 */
public boolean areAlarmActionsEnabled(ManagedEntity entity) throws RuntimeFault, RemoteException {
    return getVimService().areAlarmActionsEnabled(getMOR(), entity.getMOR());
}
    /**
 * Create an alarm against the given managed entity using the alarm
 * specification
 *
 * @param me
 *            The {@link ManagedEntity} to alarm against.
 * @param as
 *            The {@link AlarmSpec} used to generate the alarm.
 * @return The new {@link Alarm} created
 * @throws InvalidName
 *             if the alarm name exceeds the max length or is empty.
 * @throws DuplicateName
 *             if an alarm with the same name already exists.
 * @throws RuntimeFault
 *             if any unhandled runtime fault occurs
 * @throws RemoteException
 */
public Alarm createAlarm(ManagedEntity me, AlarmSpec as) throws InvalidName, DuplicateName, RuntimeFault, RemoteException {
    if (me == null) {
        throw new IllegalArgumentException("entity must not be null.");
    }
    ManagedObjectReference mor = getVimService().createAlarm(getMOR(), me.getMOR(), as);
    return new Alarm(getServerConnection(), mor);
}
    /**
 * @param me
 * @return
 * @throws RuntimeFault
 * @throws RemoteException
 */
public Alarm[] getAlarm(ManagedEntity me) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = getVimService().getAlarm(getMOR(), me == null ? null : me.getMOR());
    if (mors == null) {
        return new Alarm[] {};
    }
    Alarm[] alarms = new Alarm[mors.length];
    for (int i = 0; i < mors.length; i++) {
        alarms[i] = new Alarm(getServerConnection(), mors[i]);
    }
    return alarms;
}
    /**
 * @param me
 * @return
 * @throws RuntimeFault
 * @throws RemoteException
 */
public AlarmState[] getAlarmState(ManagedEntity me) throws RuntimeFault, RemoteException {
    if (me == null) {
        throw new IllegalArgumentException("entity must not be null.");
    }
    return getVimService().getAlarmState(getMOR(), me.getMOR());
}
    /* ===== END custom ===== */
}
