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

public class DVPortStatus extends DynamicData
{
  public boolean linkUp;
  public boolean blocked;
  public NumericRange[] vlanIds;
  public Boolean trunkingMode;
  public Integer mtu;
  public String linkPeer;
  public String macAddress;
  public String statusDetail;
  public Boolean vmDirectPathGen2Active;
  public String[] vmDirectPathGen2InactiveReasonNetwork;
  public String[] vmDirectPathGen2InactiveReasonOther;
  public String vmDirectPathGen2InactiveReasonExtended;

  public boolean isLinkUp()
  {
    return this.linkUp;
  }

  public boolean isBlocked()
  {
    return this.blocked;
  }

  public NumericRange[] getVlanIds()
  {
    return this.vlanIds;
  }

  public Boolean getTrunkingMode()
  {
    return this.trunkingMode;
  }

  public Integer getMtu()
  {
    return this.mtu;
  }

  public String getLinkPeer()
  {
    return this.linkPeer;
  }

  public String getMacAddress()
  {
    return this.macAddress;
  }

  public String getStatusDetail()
  {
    return this.statusDetail;
  }

  public Boolean getVmDirectPathGen2Active()
  {
    return this.vmDirectPathGen2Active;
  }

  public String[] getVmDirectPathGen2InactiveReasonNetwork()
  {
    return this.vmDirectPathGen2InactiveReasonNetwork;
  }

  public String[] getVmDirectPathGen2InactiveReasonOther()
  {
    return this.vmDirectPathGen2InactiveReasonOther;
  }

  public String getVmDirectPathGen2InactiveReasonExtended()
  {
    return this.vmDirectPathGen2InactiveReasonExtended;
  }

  public void setLinkUp(boolean linkUp)
  {
    this.linkUp=linkUp;
  }

  public void setBlocked(boolean blocked)
  {
    this.blocked=blocked;
  }

  public void setVlanIds(NumericRange[] vlanIds)
  {
    this.vlanIds=vlanIds;
  }

  public void setTrunkingMode(Boolean trunkingMode)
  {
    this.trunkingMode=trunkingMode;
  }

  public void setMtu(Integer mtu)
  {
    this.mtu=mtu;
  }

  public void setLinkPeer(String linkPeer)
  {
    this.linkPeer=linkPeer;
  }

  public void setMacAddress(String macAddress)
  {
    this.macAddress=macAddress;
  }

  public void setStatusDetail(String statusDetail)
  {
    this.statusDetail=statusDetail;
  }

  public void setVmDirectPathGen2Active(Boolean vmDirectPathGen2Active)
  {
    this.vmDirectPathGen2Active=vmDirectPathGen2Active;
  }

  public void setVmDirectPathGen2InactiveReasonNetwork(String[] vmDirectPathGen2InactiveReasonNetwork)
  {
    this.vmDirectPathGen2InactiveReasonNetwork=vmDirectPathGen2InactiveReasonNetwork;
  }

  public void setVmDirectPathGen2InactiveReasonOther(String[] vmDirectPathGen2InactiveReasonOther)
  {
    this.vmDirectPathGen2InactiveReasonOther=vmDirectPathGen2InactiveReasonOther;
  }

  public void setVmDirectPathGen2InactiveReasonExtended(String vmDirectPathGen2InactiveReasonExtended)
  {
    this.vmDirectPathGen2InactiveReasonExtended=vmDirectPathGen2InactiveReasonExtended;
  }
}