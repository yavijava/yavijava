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

public class ResourcePoolQuickStats extends DynamicData
{
  public Long overallCpuUsage;
  public Long overallCpuDemand;
  public Long guestMemoryUsage;
  public Long hostMemoryUsage;
  public Long distributedCpuEntitlement;
  public Long distributedMemoryEntitlement;
  public Integer staticCpuEntitlement;
  public Integer staticMemoryEntitlement;
  public Long privateMemory;
  public Long sharedMemory;
  public Long swappedMemory;
  public Long balloonedMemory;
  public Long overheadMemory;
  public Long consumedOverheadMemory;
  public Long compressedMemory;

  public Long getOverallCpuUsage()
  {
    return this.overallCpuUsage;
  }

  public Long getOverallCpuDemand()
  {
    return this.overallCpuDemand;
  }

  public Long getGuestMemoryUsage()
  {
    return this.guestMemoryUsage;
  }

  public Long getHostMemoryUsage()
  {
    return this.hostMemoryUsage;
  }

  public Long getDistributedCpuEntitlement()
  {
    return this.distributedCpuEntitlement;
  }

  public Long getDistributedMemoryEntitlement()
  {
    return this.distributedMemoryEntitlement;
  }

  public Integer getStaticCpuEntitlement()
  {
    return this.staticCpuEntitlement;
  }

  public Integer getStaticMemoryEntitlement()
  {
    return this.staticMemoryEntitlement;
  }

  public Long getPrivateMemory()
  {
    return this.privateMemory;
  }

  public Long getSharedMemory()
  {
    return this.sharedMemory;
  }

  public Long getSwappedMemory()
  {
    return this.swappedMemory;
  }

  public Long getBalloonedMemory()
  {
    return this.balloonedMemory;
  }

  public Long getOverheadMemory()
  {
    return this.overheadMemory;
  }

  public Long getConsumedOverheadMemory()
  {
    return this.consumedOverheadMemory;
  }

  public Long getCompressedMemory()
  {
    return this.compressedMemory;
  }

  public void setOverallCpuUsage(Long overallCpuUsage)
  {
    this.overallCpuUsage=overallCpuUsage;
  }

  public void setOverallCpuDemand(Long overallCpuDemand)
  {
    this.overallCpuDemand=overallCpuDemand;
  }

  public void setGuestMemoryUsage(Long guestMemoryUsage)
  {
    this.guestMemoryUsage=guestMemoryUsage;
  }

  public void setHostMemoryUsage(Long hostMemoryUsage)
  {
    this.hostMemoryUsage=hostMemoryUsage;
  }

  public void setDistributedCpuEntitlement(Long distributedCpuEntitlement)
  {
    this.distributedCpuEntitlement=distributedCpuEntitlement;
  }

  public void setDistributedMemoryEntitlement(Long distributedMemoryEntitlement)
  {
    this.distributedMemoryEntitlement=distributedMemoryEntitlement;
  }

  public void setStaticCpuEntitlement(Integer staticCpuEntitlement)
  {
    this.staticCpuEntitlement=staticCpuEntitlement;
  }

  public void setStaticMemoryEntitlement(Integer staticMemoryEntitlement)
  {
    this.staticMemoryEntitlement=staticMemoryEntitlement;
  }

  public void setPrivateMemory(Long privateMemory)
  {
    this.privateMemory=privateMemory;
  }

  public void setSharedMemory(Long sharedMemory)
  {
    this.sharedMemory=sharedMemory;
  }

  public void setSwappedMemory(Long swappedMemory)
  {
    this.swappedMemory=swappedMemory;
  }

  public void setBalloonedMemory(Long balloonedMemory)
  {
    this.balloonedMemory=balloonedMemory;
  }

  public void setOverheadMemory(Long overheadMemory)
  {
    this.overheadMemory=overheadMemory;
  }

  public void setConsumedOverheadMemory(Long consumedOverheadMemory)
  {
    this.consumedOverheadMemory=consumedOverheadMemory;
  }

  public void setCompressedMemory(Long compressedMemory)
  {
    this.compressedMemory=compressedMemory;
  }
}