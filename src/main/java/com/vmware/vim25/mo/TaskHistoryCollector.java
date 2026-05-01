// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.TaskFilterSpec;
import com.vmware.vim25.TaskInfo;
/* ===== END custom imports ===== */

public class TaskHistoryCollector extends HistoryCollector {

    public TaskHistoryCollector(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public TaskInfo[] getLatestPage() {
        return (TaskInfo[]) getCurrentProperty("latestPage");
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public TaskInfo[] readNextTasks(int maxCount) throws RuntimeFault, RemoteException {
    return getVimService().readNextTasks(getMOR(), maxCount);
}
    public TaskInfo[] readPreviousTasks(int maxCount) throws RuntimeFault, RemoteException {
    return getVimService().readPreviousTasks(getMOR(), maxCount);
}
    /* ===== END custom ===== */
}
