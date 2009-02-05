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

public class ClusterDrsMigration extends DynamicData
{
  public String key;
  public java.util.Calendar time;
  public ManagedObjectReference vm;
  public Integer cpuLoad;
  public Long memoryLoad;
  public ManagedObjectReference source;
  public Integer sourceCpuLoad;
  public Long sourceMemoryLoad;
  public ManagedObjectReference destination;
  public Integer destinationCpuLoad;
  public Long destinationMemoryLoad;

  public String getKey()
  {
    return this.key;
  }

  public java.util.Calendar getTime()
  {
    return this.time;
  }

  public ManagedObjectReference getVm()
  {
    return this.vm;
  }

  public Integer getCpuLoad()
  {
    return this.cpuLoad;
  }

  public Long getMemoryLoad()
  {
    return this.memoryLoad;
  }

  public ManagedObjectReference getSource()
  {
    return this.source;
  }

  public Integer getSourceCpuLoad()
  {
    return this.sourceCpuLoad;
  }

  public Long getSourceMemoryLoad()
  {
    return this.sourceMemoryLoad;
  }

  public ManagedObjectReference getDestination()
  {
    return this.destination;
  }

  public Integer getDestinationCpuLoad()
  {
    return this.destinationCpuLoad;
  }

  public Long getDestinationMemoryLoad()
  {
    return this.destinationMemoryLoad;
  }

  public void setKey(String key)
  {
    this.key=key;
  }

  public void setTime(java.util.Calendar time)
  {
    this.time=time;
  }

  public void setVm(ManagedObjectReference vm)
  {
    this.vm=vm;
  }

  public void setCpuLoad(Integer cpuLoad)
  {
    this.cpuLoad=cpuLoad;
  }

  public void setMemoryLoad(Long memoryLoad)
  {
    this.memoryLoad=memoryLoad;
  }

  public void setSource(ManagedObjectReference source)
  {
    this.source=source;
  }

  public void setSourceCpuLoad(Integer sourceCpuLoad)
  {
    this.sourceCpuLoad=sourceCpuLoad;
  }

  public void setSourceMemoryLoad(Long sourceMemoryLoad)
  {
    this.sourceMemoryLoad=sourceMemoryLoad;
  }

  public void setDestination(ManagedObjectReference destination)
  {
    this.destination=destination;
  }

  public void setDestinationCpuLoad(Integer destinationCpuLoad)
  {
    this.destinationCpuLoad=destinationCpuLoad;
  }

  public void setDestinationMemoryLoad(Long destinationMemoryLoad)
  {
    this.destinationMemoryLoad=destinationMemoryLoad;
  }
}