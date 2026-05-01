// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class TaskManager extends ManagedObject {

    public TaskManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public TaskDescription getDescription() {
        return (TaskDescription) getCurrentProperty("description");
    }

    public Task[] getRecentTask() {
        return getTasks("recentTask");
    }

    public TaskHistoryCollector createCollectorWithInfoFilterForTasks(TaskFilterSpec filter, TaskInfoFilterSpec infoFilter) throws InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().createCollectorWithInfoFilterForTasks(getMOR(), filter, infoFilter);
        return new TaskHistoryCollector(getServerConnection(), resultMor);
    }

    public TaskInfo[] readNextTasksByViewSpec(TaskManagerTaskViewSpec viewSpec, TaskFilterSpec filterSpec, TaskInfoFilterSpec infoFilterSpec) throws RuntimeFault, RemoteException {
        return getVimService().readNextTasksByViewSpec(getMOR(), viewSpec, filterSpec, infoFilterSpec);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /**
 * @deprecated the misspelled word. Use getDescription() instead
 */
public TaskDescription getDescriptioin() {
    return getDescription();
}
    public int getMaxCollector() {
    return ((Integer) getCurrentProperty("maxCollector")).intValue();
}
    public TaskHistoryCollector createCollectorForTasks(TaskFilterSpec filter) throws InvalidState, RuntimeFault, RemoteException {
    return new TaskHistoryCollector(getServerConnection(), getVimService().createCollectorForTasks(getMOR(), filter));
}
    //SDK2.5 signature for back compatibility
public TaskInfo createTask(ManagedObject obj, String taskTypeId, String initiatedBy, boolean cancelable) throws RuntimeFault, RemoteException {
    return createTask(obj, taskTypeId, initiatedBy, cancelable, null);
}
    //SDK4.0 signature
public TaskInfo createTask(ManagedObject obj, String taskTypeId, String initiatedBy, boolean cancelable, String parentTaskKey) throws RuntimeFault, RemoteException {
    if (obj == null) {
        throw new IllegalArgumentException("obj must not be null.");
    }
    return createTask(obj, taskTypeId, initiatedBy, cancelable, parentTaskKey, null);
}
    // SDK 6.0
public TaskInfo createTask(ManagedObject obj, String taskTypeId, String initiatedBy, boolean cancelable, String parentTaskKey, String activationId) throws RuntimeFault, RemoteException {
    if (obj == null) {
        throw new IllegalArgumentException("obj must not be null.");
    }
    return getVimService().createTask(getMOR(), obj.getMOR(), taskTypeId, initiatedBy, cancelable, parentTaskKey, activationId);
}
    /** Backward-compat alias for {@link #getRecentTask()}. */
    public Task[] getRecentTasks() {
        return getRecentTask();
    }
    /* ===== END custom ===== */
}
