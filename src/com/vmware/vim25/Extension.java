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

public class Extension extends DynamicData
{
  public Description description;
  public String key;
  public String company;
  public String type;
  public String version;
  public String subjectName;
  public ExtensionServerInfo[] server;
  public ExtensionClientInfo[] client;
  public ExtensionTaskTypeInfo[] taskList;
  public ExtensionEventTypeInfo[] eventList;
  public ExtensionFaultTypeInfo[] faultList;
  public ExtensionPrivilegeInfo[] privilegeList;
  public ExtensionResourceInfo[] resourceList;
  public Calendar lastHeartbeatTime;
  public ExtensionHealthInfo healthInfo;

  public Description getDescription()
  {
    return this.description;
  }

  public String getKey()
  {
    return this.key;
  }

  public String getCompany()
  {
    return this.company;
  }

  public String getType()
  {
    return this.type;
  }

  public String getVersion()
  {
    return this.version;
  }

  public String getSubjectName()
  {
    return this.subjectName;
  }

  public ExtensionServerInfo[] getServer()
  {
    return this.server;
  }

  public ExtensionClientInfo[] getClient()
  {
    return this.client;
  }

  public ExtensionTaskTypeInfo[] getTaskList()
  {
    return this.taskList;
  }

  public ExtensionEventTypeInfo[] getEventList()
  {
    return this.eventList;
  }

  public ExtensionFaultTypeInfo[] getFaultList()
  {
    return this.faultList;
  }

  public ExtensionPrivilegeInfo[] getPrivilegeList()
  {
    return this.privilegeList;
  }

  public ExtensionResourceInfo[] getResourceList()
  {
    return this.resourceList;
  }

  public Calendar getLastHeartbeatTime()
  {
    return this.lastHeartbeatTime;
  }

  public ExtensionHealthInfo getHealthInfo()
  {
    return this.healthInfo;
  }

  public void setDescription(Description description)
  {
    this.description=description;
  }

  public void setKey(String key)
  {
    this.key=key;
  }

  public void setCompany(String company)
  {
    this.company=company;
  }

  public void setType(String type)
  {
    this.type=type;
  }

  public void setVersion(String version)
  {
    this.version=version;
  }

  public void setSubjectName(String subjectName)
  {
    this.subjectName=subjectName;
  }

  public void setServer(ExtensionServerInfo[] server)
  {
    this.server=server;
  }

  public void setClient(ExtensionClientInfo[] client)
  {
    this.client=client;
  }

  public void setTaskList(ExtensionTaskTypeInfo[] taskList)
  {
    this.taskList=taskList;
  }

  public void setEventList(ExtensionEventTypeInfo[] eventList)
  {
    this.eventList=eventList;
  }

  public void setFaultList(ExtensionFaultTypeInfo[] faultList)
  {
    this.faultList=faultList;
  }

  public void setPrivilegeList(ExtensionPrivilegeInfo[] privilegeList)
  {
    this.privilegeList=privilegeList;
  }

  public void setResourceList(ExtensionResourceInfo[] resourceList)
  {
    this.resourceList=resourceList;
  }

  public void setLastHeartbeatTime(Calendar lastHeartbeatTime)
  {
    this.lastHeartbeatTime=lastHeartbeatTime;
  }

  public void setHealthInfo(ExtensionHealthInfo healthInfo)
  {
    this.healthInfo=healthInfo;
  }
}