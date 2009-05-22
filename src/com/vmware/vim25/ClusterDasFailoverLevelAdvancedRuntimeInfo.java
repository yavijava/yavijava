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

public class ClusterDasFailoverLevelAdvancedRuntimeInfo extends ClusterDasAdvancedRuntimeInfo
{
  public ClusterDasFailoverLevelAdvancedRuntimeInfoSlotInfo slotInfo;
  public int totalSlots;
  public int usedSlots;
  public int unreservedSlots;
  public int totalVms;
  public int totalHosts;
  public int totalGoodHosts;
  public ClusterDasFailoverLevelAdvancedRuntimeInfoHostSlots[] hostSlots;

  public ClusterDasFailoverLevelAdvancedRuntimeInfoSlotInfo getSlotInfo()
  {
    return this.slotInfo;
  }

  public int getTotalSlots()
  {
    return this.totalSlots;
  }

  public int getUsedSlots()
  {
    return this.usedSlots;
  }

  public int getUnreservedSlots()
  {
    return this.unreservedSlots;
  }

  public int getTotalVms()
  {
    return this.totalVms;
  }

  public int getTotalHosts()
  {
    return this.totalHosts;
  }

  public int getTotalGoodHosts()
  {
    return this.totalGoodHosts;
  }

  public ClusterDasFailoverLevelAdvancedRuntimeInfoHostSlots[] getHostSlots()
  {
    return this.hostSlots;
  }

  public void setSlotInfo(ClusterDasFailoverLevelAdvancedRuntimeInfoSlotInfo slotInfo)
  {
    this.slotInfo=slotInfo;
  }

  public void setTotalSlots(int totalSlots)
  {
    this.totalSlots=totalSlots;
  }

  public void setUsedSlots(int usedSlots)
  {
    this.usedSlots=usedSlots;
  }

  public void setUnreservedSlots(int unreservedSlots)
  {
    this.unreservedSlots=unreservedSlots;
  }

  public void setTotalVms(int totalVms)
  {
    this.totalVms=totalVms;
  }

  public void setTotalHosts(int totalHosts)
  {
    this.totalHosts=totalHosts;
  }

  public void setTotalGoodHosts(int totalGoodHosts)
  {
    this.totalGoodHosts=totalGoodHosts;
  }

  public void setHostSlots(ClusterDasFailoverLevelAdvancedRuntimeInfoHostSlots[] hostSlots)
  {
    this.hostSlots=hostSlots;
  }
}