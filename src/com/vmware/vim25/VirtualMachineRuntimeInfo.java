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

public class VirtualMachineRuntimeInfo extends DynamicData
{
  public ManagedObjectReference host;
  public VirtualMachineConnectionState connectionState;
  public VirtualMachinePowerState powerState;
  public boolean toolsInstallerMounted;
  public java.util.Calendar suspendTime;
  public java.util.Calendar bootTime;
  public Long suspendInterval;
  public VirtualMachineQuestionInfo question;
  public Long memoryOverhead;
  public Integer maxCpuUsage;
  public Integer maxMemoryUsage;
  public int numMksConnections;

  public ManagedObjectReference getHost()
  {
    return this.host;
  }

  public VirtualMachineConnectionState getConnectionState()
  {
    return this.connectionState;
  }

  public VirtualMachinePowerState getPowerState()
  {
    return this.powerState;
  }

  public boolean isToolsInstallerMounted()
  {
    return this.toolsInstallerMounted;
  }

  public java.util.Calendar getSuspendTime()
  {
    return this.suspendTime;
  }

  public java.util.Calendar getBootTime()
  {
    return this.bootTime;
  }

  public Long getSuspendInterval()
  {
    return this.suspendInterval;
  }

  public VirtualMachineQuestionInfo getQuestion()
  {
    return this.question;
  }

  public Long getMemoryOverhead()
  {
    return this.memoryOverhead;
  }

  public Integer getMaxCpuUsage()
  {
    return this.maxCpuUsage;
  }

  public Integer getMaxMemoryUsage()
  {
    return this.maxMemoryUsage;
  }

  public int getNumMksConnections()
  {
    return this.numMksConnections;
  }

  public void setHost(ManagedObjectReference host)
  {
    this.host=host;
  }

  public void setConnectionState(VirtualMachineConnectionState connectionState)
  {
    this.connectionState=connectionState;
  }

  public void setPowerState(VirtualMachinePowerState powerState)
  {
    this.powerState=powerState;
  }

  public void setToolsInstallerMounted(boolean toolsInstallerMounted)
  {
    this.toolsInstallerMounted=toolsInstallerMounted;
  }

  public void setSuspendTime(java.util.Calendar suspendTime)
  {
    this.suspendTime=suspendTime;
  }

  public void setBootTime(java.util.Calendar bootTime)
  {
    this.bootTime=bootTime;
  }

  public void setSuspendInterval(Long suspendInterval)
  {
    this.suspendInterval=suspendInterval;
  }

  public void setQuestion(VirtualMachineQuestionInfo question)
  {
    this.question=question;
  }

  public void setMemoryOverhead(Long memoryOverhead)
  {
    this.memoryOverhead=memoryOverhead;
  }

  public void setMaxCpuUsage(Integer maxCpuUsage)
  {
    this.maxCpuUsage=maxCpuUsage;
  }

  public void setMaxMemoryUsage(Integer maxMemoryUsage)
  {
    this.maxMemoryUsage=maxMemoryUsage;
  }

  public void setNumMksConnections(int numMksConnections)
  {
    this.numMksConnections=numMksConnections;
  }
}