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

public class HostHardwareSummary extends DynamicData
{
  public String vendor;
  public String model;
  public String uuid;
  public HostSystemIdentificationInfo[] otherIdentifyingInfo;
  public long memorySize;
  public String cpuModel;
  public int cpuMhz;
  public short numCpuPkgs;
  public short numCpuCores;
  public short numCpuThreads;
  public int numNics;
  public int numHBAs;

  public String getVendor()
  {
    return this.vendor;
  }

  public String getModel()
  {
    return this.model;
  }

  public String getUuid()
  {
    return this.uuid;
  }

  public HostSystemIdentificationInfo[] getOtherIdentifyingInfo()
  {
    return this.otherIdentifyingInfo;
  }

  public long getMemorySize()
  {
    return this.memorySize;
  }

  public String getCpuModel()
  {
    return this.cpuModel;
  }

  public int getCpuMhz()
  {
    return this.cpuMhz;
  }

  public short getNumCpuPkgs()
  {
    return this.numCpuPkgs;
  }

  public short getNumCpuCores()
  {
    return this.numCpuCores;
  }

  public short getNumCpuThreads()
  {
    return this.numCpuThreads;
  }

  public int getNumNics()
  {
    return this.numNics;
  }

  public int getNumHBAs()
  {
    return this.numHBAs;
  }

  public void setVendor(String vendor)
  {
    this.vendor=vendor;
  }

  public void setModel(String model)
  {
    this.model=model;
  }

  public void setUuid(String uuid)
  {
    this.uuid=uuid;
  }

  public void setOtherIdentifyingInfo(HostSystemIdentificationInfo[] otherIdentifyingInfo)
  {
    this.otherIdentifyingInfo=otherIdentifyingInfo;
  }

  public void setMemorySize(long memorySize)
  {
    this.memorySize=memorySize;
  }

  public void setCpuModel(String cpuModel)
  {
    this.cpuModel=cpuModel;
  }

  public void setCpuMhz(int cpuMhz)
  {
    this.cpuMhz=cpuMhz;
  }

  public void setNumCpuPkgs(short numCpuPkgs)
  {
    this.numCpuPkgs=numCpuPkgs;
  }

  public void setNumCpuCores(short numCpuCores)
  {
    this.numCpuCores=numCpuCores;
  }

  public void setNumCpuThreads(short numCpuThreads)
  {
    this.numCpuThreads=numCpuThreads;
  }

  public void setNumNics(int numNics)
  {
    this.numNics=numNics;
  }

  public void setNumHBAs(int numHBAs)
  {
    this.numHBAs=numHBAs;
  }
}