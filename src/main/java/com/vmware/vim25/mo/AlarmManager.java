/*================================================================================
Copyright (c) 2008 VMware, Inc. All Rights Reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, 
this list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice, 
this list of conditions and the following disclaimer in the documentation 
and/or other materials provided with the distribution.

* Neither the name of VMware, Inc. nor the names of its contributors may be used
to endorse or promote products derived from this software without specific prior 
written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL VMWARE, INC. OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.
================================================================================*/

package com.vmware.vim25.mo;

import com.vmware.vim25.*;

import java.rmi.RemoteException;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 *
 * @author Steve JIN (http://www.doublecloud.org)
 */

public class AlarmManager extends ManagedObject {
    public AlarmManager(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    /**
     * Gets the values used by default for the client alarm wizard.
     *
     * @return The default setting for each {@link AlarmExpression}
     */
    public AlarmExpression[] getDefaultExpression() {
        return (AlarmExpression[]) getCurrentProperty("defaultExpression");
    }

    /**
     * @return The set of descriptions used in alarms.
     */
    public AlarmDescription getDescription() {
        return (AlarmDescription) this.getCurrentProperty("description");
    }

    /**
     * Acknowledge the alarm for a managed entity.
     *
     * @param alarm
     *            The {@link Alarm} to acknowledge.
     * @param entity
     *            The {@link ManagedEntity} which the alarm applies to.
     * @throws RuntimeFault
     *             if any unhandled runtime fault occurs
     * @throws RemoteException
     * @since 4.0
     */
    public void acknowledgeAlarm(Alarm alarm, ManagedEntity entity) throws RuntimeFault, RemoteException {
        getVimService().acknowledgeAlarm(getMOR(), alarm.getMOR(), entity.getMOR());
    }

    /**
     * Set the status of an alarm for the given managed entity. Not a public
     * VMware API.
     *
     * @param alarm
     *            The {@link Alarm} to set the status of.
     * @param entity
     *            The {@link ManagedEntity} the alarm applies to.
     * @param status
     *            The string status corresponding to a
     *            {@link ManagedEntityStatus} to set.
     * @throws RuntimeFault
     *             if any unhandled runtime fault occurs
     * @throws RemoteException
     * @since 4.x added to yavija for 5.5b.07
     */
    public void setAlarmStatus(Alarm alarm, ManagedEntity entity, String status) throws RuntimeFault, RemoteException {
        getVimService().setAlarmStatus(getMOR(), alarm.getMOR(), entity.getMOR(), status);
    }

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
     * Toggles alarms on the given managed entity.
     *
     * @param entity
     *            The {@link ManagedEntity} to toggle alarms on.
     * @param enabled
     *            Whether to enable or disable alarms.
     * @throws RuntimeFault
     *             if any unhandled runtime fault occurs
     * @throws RemoteException
     * @since 4.0
     */
    public void enableAlarmActions(ManagedEntity entity, boolean enabled) throws RuntimeFault, RemoteException {
        getVimService().enableAlarmActions(getMOR(), entity.getMOR(), enabled);
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
            return new Alarm[]{};
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
}
