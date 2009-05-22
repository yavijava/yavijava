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

public class AlarmState extends DynamicData
{
  public String key;
  public ManagedObjectReference entity;
  public ManagedObjectReference alarm;
  public ManagedEntityStatus overallStatus;
  public Calendar time;
  public Boolean acknowledged;
  public String acknowledgedByUser;
  public Calendar acknowledgedTime;

  public String getKey()
  {
    return this.key;
  }

  public ManagedObjectReference getEntity()
  {
    return this.entity;
  }

  public ManagedObjectReference getAlarm()
  {
    return this.alarm;
  }

  public ManagedEntityStatus getOverallStatus()
  {
    return this.overallStatus;
  }

  public Calendar getTime()
  {
    return this.time;
  }

  public Boolean getAcknowledged()
  {
    return this.acknowledged;
  }

  public String getAcknowledgedByUser()
  {
    return this.acknowledgedByUser;
  }

  public Calendar getAcknowledgedTime()
  {
    return this.acknowledgedTime;
  }

  public void setKey(String key)
  {
    this.key=key;
  }

  public void setEntity(ManagedObjectReference entity)
  {
    this.entity=entity;
  }

  public void setAlarm(ManagedObjectReference alarm)
  {
    this.alarm=alarm;
  }

  public void setOverallStatus(ManagedEntityStatus overallStatus)
  {
    this.overallStatus=overallStatus;
  }

  public void setTime(Calendar time)
  {
    this.time=time;
  }

  public void setAcknowledged(Boolean acknowledged)
  {
    this.acknowledged=acknowledged;
  }

  public void setAcknowledgedByUser(String acknowledgedByUser)
  {
    this.acknowledgedByUser=acknowledgedByUser;
  }

  public void setAcknowledgedTime(Calendar acknowledgedTime)
  {
    this.acknowledgedTime=acknowledgedTime;
  }
}