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

public class EventEx extends Event
{
  public String eventTypeId;
  public String severity;
  public String message;
  public KeyAnyValue[] arguments;
  public String objectId;
  public String objectType;
  public String objectName;
  public LocalizedMethodFault fault;

  public String getEventTypeId()
  {
    return this.eventTypeId;
  }

  public String getSeverity()
  {
    return this.severity;
  }

  public String getMessage()
  {
    return this.message;
  }

  public KeyAnyValue[] getArguments()
  {
    return this.arguments;
  }

  public String getObjectId()
  {
    return this.objectId;
  }

  public String getObjectType()
  {
    return this.objectType;
  }

  public String getObjectName()
  {
    return this.objectName;
  }

  public LocalizedMethodFault getFault()
  {
    return this.fault;
  }

  public void setEventTypeId(String eventTypeId)
  {
    this.eventTypeId=eventTypeId;
  }

  public void setSeverity(String severity)
  {
    this.severity=severity;
  }

  public void setMessage(String message)
  {
    this.message=message;
  }

  public void setArguments(KeyAnyValue[] arguments)
  {
    this.arguments=arguments;
  }

  public void setObjectId(String objectId)
  {
    this.objectId=objectId;
  }

  public void setObjectType(String objectType)
  {
    this.objectType=objectType;
  }

  public void setObjectName(String objectName)
  {
    this.objectName=objectName;
  }

  public void setFault(LocalizedMethodFault fault)
  {
    this.fault=fault;
  }
}