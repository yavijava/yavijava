// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.Event;
import com.vmware.vim25.EventFilterSpec;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class EventHistoryCollector extends HistoryCollector {

    public EventHistoryCollector(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public boolean getInitialized() {
        return (boolean) getCurrentProperty("initialized");
    }

    public Event[] getLatestPage() {
        return (Event[]) getCurrentProperty("latestPage");
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public EventFilterSpec getFilter() {
        return (EventFilterSpec) getCurrentProperty("filter");
    }
    public Event[] readNextEvents(int maxCount) throws RuntimeFault, RemoteException {
    return getVimService().readNextEvents(getMOR(), maxCount);
}
    public Event[] readPreviousEvents(int maxCount) throws RuntimeFault, RemoteException {
    return getVimService().readPreviousEvents(getMOR(), maxCount);
}
    /* ===== END custom ===== */
}
