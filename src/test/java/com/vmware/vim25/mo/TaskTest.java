package com.vmware.vim25.mo;

import com.vmware.vim25.TaskInfo;
import com.vmware.vim25.TaskInfoState;
import org.junit.Test;

import java.rmi.RemoteException;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

    // Returns each state from the sequence on successive calls; once exhausted, sticks on the last value.
    private static Task taskReturning(final TaskInfoState... sequence) {
        return new Task(null, null) {
            private int idx = 0;

            @Override
            public TaskInfo getTaskInfo() throws RemoteException {
                TaskInfo info = new TaskInfo();
                info.setState(idx < sequence.length ? sequence[idx] : sequence[sequence.length - 1]);
                idx++;
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

    @Test
    public void waitForTask_withTimeout_returnsSuccessWhenTaskCompletesInTime() throws Exception {
        Task task = taskReturning(TaskInfoState.running, TaskInfoState.success);
        assertEquals("success", task.waitForTask(10, 10, 5000L));
    }

    @Test
    public void waitForTask_withTimeout_throwsTimeoutWhenTaskNeverCompletes() throws Exception {
        Task task = taskReturning(TaskInfoState.running);
        long start = System.currentTimeMillis();
        try {
            task.waitForTask(50, 50, 200L);
            fail("Expected TimeoutException when task stays running past the deadline");
        } catch (TimeoutException expected) {
            long elapsed = System.currentTimeMillis() - start;
            assertTrue("timed out too late; elapsed=" + elapsed + "ms", elapsed < 1000);
            assertTrue("timeout message should mention the limit", expected.getMessage().contains("200"));
        }
    }

    @Test
    public void waitForTask_zeroTimeout_meansNoTimeout() throws Exception {
        Task task = taskReturning(TaskInfoState.success);
        assertEquals("success", task.waitForTask(0, 0, 0L));
    }

    @Test
    public void waitForTask_singleArgTimeoutOverload_throwsTimeout() throws Exception {
        Task task = taskReturning(TaskInfoState.running);
        try {
            task.waitForTask(100L);
            fail("Expected TimeoutException");
        } catch (TimeoutException expected) {
            // expected
        }
    }
}
