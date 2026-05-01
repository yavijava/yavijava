// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class EventManager extends ManagedObject {

    public EventManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public EventDescription getDescription() {
        return (EventDescription) getCurrentProperty("description");
    }

    public Event getLatestEvent() {
        return (Event) getCurrentProperty("latestEvent");
    }

    public EventHistoryCollector createCollector(EventFilterSpec filter) throws InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createCollectorForEvents(getMOR(), filter);
        return new EventHistoryCollector(getServerConnection(), resultMor);
    }

    public void postEvent(Event eventToPost, TaskInfo taskInfo) throws InvalidEvent, RuntimeFault, RemoteException {
        getVimService().postEvent(getMOR(), eventToPost, taskInfo);
    }

    public Event[] queryEvent(EventFilterSpec filter, EventManagerEventViewSpec eventViewSpec) throws RuntimeFault, RemoteException {
        return getVimService().queryEvents(getMOR(), filter, eventViewSpec);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public int getMaxCollector() {
    return ((Integer) getCurrentProperty("maxCollector")).intValue();
}
    public EventHistoryCollector createCollectorForEvents(EventFilterSpec filter) throws InvalidState, RuntimeFault, RemoteException {
    return new EventHistoryCollector(getServerConnection(), getVimService().createCollectorForEvents(getMOR(), filter));
}
    public void logUserEvent(ManagedEntity entity, String msg) throws RuntimeFault, RemoteException {
    if (entity == null) {
        throw new IllegalArgumentException("entity must not be null.");
    }
    getVimService().logUserEvent(getMOR(), entity.getMOR(), msg);
}
    public Event[] queryEvents(EventFilterSpec filter) throws RuntimeFault, RemoteException {
    return getVimService().queryEvents(getMOR(), filter, null);
}
    public EventArgDesc[] retrieveArgumentDescription(String eventTypeId) throws RuntimeFault, RemoteException {
    return getVimService().retrieveArgumentDescription(getMOR(), eventTypeId);
}
    /* ===== END custom ===== */
}
