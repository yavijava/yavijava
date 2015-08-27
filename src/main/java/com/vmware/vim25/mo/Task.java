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

public class Task extends ExtensibleManagedObject {
    public static final String PROPNAME_INFO = "info";
    public static final String SUCCESS = "success";

    public Task(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public TaskInfo getTaskInfo() throws InvalidProperty, RuntimeFault, RemoteException {
        return (TaskInfo) getCurrentProperty(PROPNAME_INFO);
    }

    public ManagedEntity getAssociatedManagedEntity() {
        return (ManagedEntity) getManagedObject("info.entity");
    }

    public ManagedEntity[] getLockedManagedEntities() {
        return (ManagedEntity[]) getManagedObjects("info.locked");
    }

    public void cancelTask() throws RuntimeFault, RemoteException {
        getVimService().cancelTask(getMOR());
    }

    public void setTaskState(TaskInfoState tis, Object result, LocalizedMethodFault fault) throws InvalidState, RuntimeFault, RemoteException {
        getVimService().setTaskState(getMOR(), tis, result, fault);
    }

    public void updateProgress(int percentDone) throws InvalidState, OutOfBounds, RuntimeFault, RemoteException {
        getVimService().updateProgress(getMOR(), percentDone);
    }

    /**
     * @since SDK4.0
     */
    public void setTaskDescription(LocalizableMessage description) throws RuntimeFault, RemoteException {
        getVimService().setTaskDescription(getMOR(), description);
    }

    /**
     * If there is another thread or client calling waitForUpdate(), the behavior of this
     * method is not predictable. This usually happens with VI Client plug-in which shares
     * the session with the VI Client which use waitForUpdate() extensively.
     * The safer way is to poll the related info.state and check its value.
     *
     * @return
     * @throws InvalidProperty
     * @throws RuntimeFault
     * @throws RemoteException
     * @deprecated
     */
    public String waitForMe() throws InvalidProperty, RuntimeFault, RemoteException {

        Object[] result = waitForValues(
            new String[]{"info.state", "info.error"},
            new String[]{"state"},
            new Object[][]{new Object[]{TaskInfoState.success, TaskInfoState.error}});

        if (result[0].equals(TaskInfoState.success)) {
            return SUCCESS;
        }
        else {
            TaskInfo tinfo = (TaskInfo) getCurrentProperty(PROPNAME_INFO);
            LocalizedMethodFault fault = tinfo.getError();
            String error = "Error Occured";
            if (fault != null) {
                MethodFault mf = fault.getFault();
                throw mf;
            }
            return error;
        }
    }

    /**
     * Copyright 2009 NetApp, contribution by Eric Forgette
     * <p>
     * This is a "drop-in" replacement for waitForMe() that uses a timed polling
     * in place of waitForValues.
     * <p>
     * This method will eat 3 exceptions while trying to get TaskInfo and TaskState.
     * On the fourth try, the captured exception is thrown.
     *
     * @return String based on TaskInfoState
     * @throws RuntimeFault
     * @throws RemoteException
     * @throws InterruptedException
     * @throws RuntimeException     if the third exception is not RuntimeFault or RemoteException
     * @author Eric Forgette (forgette@netapp.com)
     */
    public String waitForTask() throws RuntimeFault, RemoteException, InterruptedException {
        return waitForTask(500, 1000);
    }

    /**
     * Copyright 2009 NetApp, contribution by Eric Forgette
     * <p>
     * This is a replacement for waitForMe() that uses a timed polling
     * in place of waitForValues.  The delay between each poll is
     * configurable based on the last seen task state.  The method will sleep
     * for the number of milliseconds specified in runningDelayInMillSecond
     * while the task is in the running state.
     * The method will sleep for the number of milliseconds specified
     * in queuedDelayInMillSecond while the task is in the queued state.
     * <p>
     * This method will eat 3 exceptions while trying to get TaskInfo and TaskState.
     * On the fourth try, the captured exception is thrown.
     *
     * @param runningDelayInMillSecond - number of milliseconds to sleep between polls for a running task
     * @param queuedDelayInMillSecond  - number of milliseconds to sleep between polls for a queued task
     * @return String based on TaskInfoState
     * @throws RuntimeFault
     * @throws RemoteException
     * @throws InterruptedException
     * @throws RuntimeException     if the third exception is not RuntimeFault or RemoteException
     * @author Eric Forgette (forgette@netapp.com)
     */
    public String waitForTask(int runningDelayInMillSecond, int queuedDelayInMillSecond) throws RuntimeFault, RemoteException, InterruptedException {
        TaskInfoState tState = null;
        int tries = 0;
        int maxTries = 3;
        Exception getInfoException = null;

        while ((tState == null) || tState.equals(TaskInfoState.running) || tState.equals(TaskInfoState.queued)) {
            tState = null;
            getInfoException = null;
            tries = 0;
            // under load getTaskInfo may return null when there really is valid task info, so we try 3 times to get it.
            while (tState == null) {
                tries++;
                if (tries > maxTries) {
                    if (getInfoException == null) {
                        throw new NullPointerException();
                    }
                    else if (getInfoException instanceof RuntimeFault) {
                        throw (RuntimeFault) getInfoException;
                    }
                    else if (getInfoException instanceof RemoteException) {
                        throw (RemoteException) getInfoException;
                    }
                    else {
                        throw new RuntimeException(getInfoException);
                    }
                }

                try {
                    tState = getTaskInfo().getState();
                }
                catch (Exception e) {
                    //silently catch 3 exceptions
                    getInfoException = e;
                }
            }

            // sleep for a specified time based on task state.
            if (tState.equals(TaskInfoState.running)) {
                Thread.sleep(runningDelayInMillSecond);
            }
            else {
                Thread.sleep(queuedDelayInMillSecond);
            }
        }
        return tState.toString();
    }
}