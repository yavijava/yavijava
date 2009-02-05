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

public class VirtualMachineConfigSummary extends DynamicData
{
  public String name;
  public boolean template;
  public String vmPathName;
  public Integer memorySizeMB;
  public Integer cpuReservation;
  public Integer memoryReservation;
  public Integer numCpu;
  public Integer numEthernetCards;
  public Integer numVirtualDisks;
  public String uuid;
  public String guestId;
  public String guestFullName;
  public String annotation;

  public String getName()
  {
    return this.name;
  }

  public boolean isTemplate()
  {
    return this.template;
  }

  public String getVmPathName()
  {
    return this.vmPathName;
  }

  public Integer getMemorySizeMB()
  {
    return this.memorySizeMB;
  }

  public Integer getCpuReservation()
  {
    return this.cpuReservation;
  }

  public Integer getMemoryReservation()
  {
    return this.memoryReservation;
  }

  public Integer getNumCpu()
  {
    return this.numCpu;
  }

  public Integer getNumEthernetCards()
  {
    return this.numEthernetCards;
  }

  public Integer getNumVirtualDisks()
  {
    return this.numVirtualDisks;
  }

  public String getUuid()
  {
    return this.uuid;
  }

  public String getGuestId()
  {
    return this.guestId;
  }

  public String getGuestFullName()
  {
    return this.guestFullName;
  }

  public String getAnnotation()
  {
    return this.annotation;
  }

  public void setName(String name)
  {
    this.name=name;
  }

  public void setTemplate(boolean template)
  {
    this.template=template;
  }

  public void setVmPathName(String vmPathName)
  {
    this.vmPathName=vmPathName;
  }

  public void setMemorySizeMB(Integer memorySizeMB)
  {
    this.memorySizeMB=memorySizeMB;
  }

  public void setCpuReservation(Integer cpuReservation)
  {
    this.cpuReservation=cpuReservation;
  }

  public void setMemoryReservation(Integer memoryReservation)
  {
    this.memoryReservation=memoryReservation;
  }

  public void setNumCpu(Integer numCpu)
  {
    this.numCpu=numCpu;
  }

  public void setNumEthernetCards(Integer numEthernetCards)
  {
    this.numEthernetCards=numEthernetCards;
  }

  public void setNumVirtualDisks(Integer numVirtualDisks)
  {
    this.numVirtualDisks=numVirtualDisks;
  }

  public void setUuid(String uuid)
  {
    this.uuid=uuid;
  }

  public void setGuestId(String guestId)
  {
    this.guestId=guestId;
  }

  public void setGuestFullName(String guestFullName)
  {
    this.guestFullName=guestFullName;
  }

  public void setAnnotation(String annotation)
  {
    this.annotation=annotation;
  }
}