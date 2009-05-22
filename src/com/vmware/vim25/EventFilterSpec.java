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

/**
@author Steve Jin (sjin@vmware.com)
*/

public class EventFilterSpec extends DynamicData
{
  public EventFilterSpecByEntity entity;
  public EventFilterSpecByTime time;
  public EventFilterSpecByUsername userName;
  public Integer eventChainId;
  public ManagedObjectReference alarm;
  public ManagedObjectReference scheduledTask;
  public Boolean disableFullMessage;
  public String[] category;
  public String[] type;
  public String[] tag;
  public String[] eventTypeId;

  public EventFilterSpecByEntity getEntity()
  {
    return this.entity;
  }

  public EventFilterSpecByTime getTime()
  {
    return this.time;
  }

  public EventFilterSpecByUsername getUserName()
  {
    return this.userName;
  }

  public Integer getEventChainId()
  {
    return this.eventChainId;
  }

  public ManagedObjectReference getAlarm()
  {
    return this.alarm;
  }

  public ManagedObjectReference getScheduledTask()
  {
    return this.scheduledTask;
  }

  public Boolean getDisableFullMessage()
  {
    return this.disableFullMessage;
  }

  public String[] getCategory()
  {
    return this.category;
  }

  public String[] getType()
  {
    return this.type;
  }

  public String[] getTag()
  {
    return this.tag;
  }

  public String[] getEventTypeId()
  {
    return this.eventTypeId;
  }

  public void setEntity(EventFilterSpecByEntity entity)
  {
    this.entity=entity;
  }

  public void setTime(EventFilterSpecByTime time)
  {
    this.time=time;
  }

  public void setUserName(EventFilterSpecByUsername userName)
  {
    this.userName=userName;
  }

  public void setEventChainId(Integer eventChainId)
  {
    this.eventChainId=eventChainId;
  }

  public void setAlarm(ManagedObjectReference alarm)
  {
    this.alarm=alarm;
  }

  public void setScheduledTask(ManagedObjectReference scheduledTask)
  {
    this.scheduledTask=scheduledTask;
  }

  public void setDisableFullMessage(Boolean disableFullMessage)
  {
    this.disableFullMessage=disableFullMessage;
  }

  public void setCategory(String[] category)
  {
    this.category=category;
  }

  public void setType(String[] type)
  {
    this.type=type;
  }

  public void setTag(String[] tag)
  {
    this.tag=tag;
  }

  public void setEventTypeId(String[] eventTypeId)
  {
    this.eventTypeId=eventTypeId;
  }
}