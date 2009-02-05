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

public class VirtualMachineQuickStats extends DynamicData
{
  public Integer overallCpuUsage;
  public Integer guestMemoryUsage;
  public Integer hostMemoryUsage;
  public ManagedEntityStatus guestHeartbeatStatus;
  public Integer distributedCpuEntitlement;
  public Integer distributedMemoryEntitlement;

  public Integer getOverallCpuUsage()
  {
    return this.overallCpuUsage;
  }

  public Integer getGuestMemoryUsage()
  {
    return this.guestMemoryUsage;
  }

  public Integer getHostMemoryUsage()
  {
    return this.hostMemoryUsage;
  }

  public ManagedEntityStatus getGuestHeartbeatStatus()
  {
    return this.guestHeartbeatStatus;
  }

  public Integer getDistributedCpuEntitlement()
  {
    return this.distributedCpuEntitlement;
  }

  public Integer getDistributedMemoryEntitlement()
  {
    return this.distributedMemoryEntitlement;
  }

  public void setOverallCpuUsage(Integer overallCpuUsage)
  {
    this.overallCpuUsage=overallCpuUsage;
  }

  public void setGuestMemoryUsage(Integer guestMemoryUsage)
  {
    this.guestMemoryUsage=guestMemoryUsage;
  }

  public void setHostMemoryUsage(Integer hostMemoryUsage)
  {
    this.hostMemoryUsage=hostMemoryUsage;
  }

  public void setGuestHeartbeatStatus(ManagedEntityStatus guestHeartbeatStatus)
  {
    this.guestHeartbeatStatus=guestHeartbeatStatus;
  }

  public void setDistributedCpuEntitlement(Integer distributedCpuEntitlement)
  {
    this.distributedCpuEntitlement=distributedCpuEntitlement;
  }

  public void setDistributedMemoryEntitlement(Integer distributedMemoryEntitlement)
  {
    this.distributedMemoryEntitlement=distributedMemoryEntitlement;
  }
}