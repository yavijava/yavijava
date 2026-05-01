// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;
import java.util.Calendar;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostDateTimeSystem extends ManagedObject {

    public HostDateTimeSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostDateTimeInfo getDateTimeInfo() {
        return (HostDateTimeInfo) getCurrentProperty("dateTimeInfo");
    }

    public void refresh() throws RuntimeFault, RemoteException {
        getVimService().refresh(getMOR());
    }

    public HostDateTimeSystemServiceTestResult testTimeService() throws RuntimeFault, RemoteException {
        return getVimService().testTimeService(getMOR());
    }

    public void updateDateTimeConfig(HostDateTimeConfig config) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().updateDateTimeConfig(getMOR(), config);
    }

    public void updateDateTime(Calendar dateTime) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().updateDateTime(getMOR(), dateTime);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public HostDateTimeSystemTimeZone[] queryAvailableTimeZones() throws RuntimeFault, RemoteException {
    return getVimService().queryAvailableTimeZones(getMOR());
}
    public Calendar queryDateTime() throws RuntimeFault, RemoteException {
    return getVimService().queryDateTime(getMOR());
}
    /* ===== END custom ===== */
}
