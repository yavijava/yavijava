package com.vmware.vim25.mo;

import com.vmware.vim25.TaskInfo;
import com.vmware.vim25.TaskInfoState;
import org.junit.Test;

import java.rmi.RemoteException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TaskTest {

    private static Task taskReturning(TaskInfoState state) {
        TaskInfo info = new TaskInfo();
        info.setState(state);
        return new Task(null, null) {
            @Override
            public TaskInfo getTaskInfo() throws RemoteException {
                return info;
            }
        };
    }

    @Test
    public void waitForTask_returnsSuccessString_whenTaskSucceeds() throws Exception {
        Task task = taskReturning(TaskInfoState.success);
        assertEquals("success", task.waitForTask(0, 0));
    }

    @Test
    public void waitForTask_returnsErrorString_whenTaskFails() throws Exception {
        Task task = taskReturning(TaskInfoState.error);
        assertEquals("error", task.waitForTask(0, 0));
    }

    @Test
    public void waitForTask_doesNotSleepAfterTaskSucceeds() throws Exception {
        Task task = taskReturning(TaskInfoState.success);
        long start = System.currentTimeMillis();
        task.waitForTask(5000, 5000);
        long elapsed = System.currentTimeMillis() - start;
        assertTrue("waitForTask slept after task completed; elapsed=" + elapsed + "ms", elapsed < 1000);
    }

    @Test
    public void waitForTask_doesNotSleepAfterTaskFails() throws Exception {
        Task task = taskReturning(TaskInfoState.error);
        long start = System.currentTimeMillis();
        task.waitForTask(5000, 5000);
        long elapsed = System.currentTimeMillis() - start;
        assertTrue("waitForTask slept after task failed; elapsed=" + elapsed + "ms", elapsed < 1000);
    }
}
