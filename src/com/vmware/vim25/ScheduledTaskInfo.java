/*================================================================================
Copyright (c) 2009 VMware, Inc. All Rights Reserved.

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

package com.vmware.vim25;
import java.util.Calendar;

/**
@author Steve Jin (sjin@vmware.com)
*/

public class ScheduledTaskInfo extends ScheduledTaskSpec
{
  public ManagedObjectReference scheduledTask;
  public ManagedObjectReference entity;
  public Calendar lastModifiedTime;
  public String lastModifiedUser;
  public Calendar nextRunTime;
  public Calendar prevRunTime;
  public TaskInfoState state;
  public LocalizedMethodFault error;
  public Object result;
  public Integer progress;
  public ManagedObjectReference activeTask;
  public ManagedObjectReference taskObject;

  public ManagedObjectReference getScheduledTask()
  {
    return this.scheduledTask;
  }

  public ManagedObjectReference getEntity()
  {
    return this.entity;
  }

  public Calendar getLastModifiedTime()
  {
    return this.lastModifiedTime;
  }

  public String getLastModifiedUser()
  {
    return this.lastModifiedUser;
  }

  public Calendar getNextRunTime()
  {
    return this.nextRunTime;
  }

  public Calendar getPrevRunTime()
  {
    return this.prevRunTime;
  }

  public TaskInfoState getState()
  {
    return this.state;
  }

  public LocalizedMethodFault getError()
  {
    return this.error;
  }

  public Object getResult()
  {
    return this.result;
  }

  public Integer getProgress()
  {
    return this.progress;
  }

  public ManagedObjectReference getActiveTask()
  {
    return this.activeTask;
  }

  public ManagedObjectReference getTaskObject()
  {
    return this.taskObject;
  }

  public void setScheduledTask(ManagedObjectReference scheduledTask)
  {
    this.scheduledTask=scheduledTask;
  }

  public void setEntity(ManagedObjectReference entity)
  {
    this.entity=entity;
  }

  public void setLastModifiedTime(Calendar lastModifiedTime)
  {
    this.lastModifiedTime=lastModifiedTime;
  }

  public void setLastModifiedUser(String lastModifiedUser)
  {
    this.lastModifiedUser=lastModifiedUser;
  }

  public void setNextRunTime(Calendar nextRunTime)
  {
    this.nextRunTime=nextRunTime;
  }

  public void setPrevRunTime(Calendar prevRunTime)
  {
    this.prevRunTime=prevRunTime;
  }

  public void setState(TaskInfoState state)
  {
    this.state=state;
  }

  public void setError(LocalizedMethodFault error)
  {
    this.error=error;
  }

  public void setResult(Object result)
  {
    this.result=result;
  }

  public void setProgress(Integer progress)
  {
    this.progress=progress;
  }

  public void setActiveTask(ManagedObjectReference activeTask)
  {
    this.activeTask=activeTask;
  }

  public void setTaskObject(ManagedObjectReference taskObject)
  {
    this.taskObject=taskObject;
  }
}