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

public class ComputeResourceSummary extends DynamicData
{
  public int totalCpu;
  public long totalMemory;
  public short numCpuCores;
  public short numCpuThreads;
  public int effectiveCpu;
  public long effectiveMemory;
  public int numHosts;
  public int numEffectiveHosts;
  public ManagedEntityStatus overallStatus;

  public int getTotalCpu()
  {
    return this.totalCpu;
  }

  public long getTotalMemory()
  {
    return this.totalMemory;
  }

  public short getNumCpuCores()
  {
    return this.numCpuCores;
  }

  public short getNumCpuThreads()
  {
    return this.numCpuThreads;
  }

  public int getEffectiveCpu()
  {
    return this.effectiveCpu;
  }

  public long getEffectiveMemory()
  {
    return this.effectiveMemory;
  }

  public int getNumHosts()
  {
    return this.numHosts;
  }

  public int getNumEffectiveHosts()
  {
    return this.numEffectiveHosts;
  }

  public ManagedEntityStatus getOverallStatus()
  {
    return this.overallStatus;
  }

  public void setTotalCpu(int totalCpu)
  {
    this.totalCpu=totalCpu;
  }

  public void setTotalMemory(long totalMemory)
  {
    this.totalMemory=totalMemory;
  }

  public void setNumCpuCores(short numCpuCores)
  {
    this.numCpuCores=numCpuCores;
  }

  public void setNumCpuThreads(short numCpuThreads)
  {
    this.numCpuThreads=numCpuThreads;
  }

  public void setEffectiveCpu(int effectiveCpu)
  {
    this.effectiveCpu=effectiveCpu;
  }

  public void setEffectiveMemory(long effectiveMemory)
  {
    this.effectiveMemory=effectiveMemory;
  }

  public void setNumHosts(int numHosts)
  {
    this.numHosts=numHosts;
  }

  public void setNumEffectiveHosts(int numEffectiveHosts)
  {
    this.numEffectiveHosts=numEffectiveHosts;
  }

  public void setOverallStatus(ManagedEntityStatus overallStatus)
  {
    this.overallStatus=overallStatus;
  }
}