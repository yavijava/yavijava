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

public class HostDhcpServiceSpec extends DynamicData
{
  public String virtualSwitch;
  public int defaultLeaseDuration;
  public String leaseBeginIp;
  public String leaseEndIp;
  public int maxLeaseDuration;
  public boolean unlimitedLease;
  public String ipSubnetAddr;
  public String ipSubnetMask;

  public String getVirtualSwitch()
  {
    return this.virtualSwitch;
  }

  public int getDefaultLeaseDuration()
  {
    return this.defaultLeaseDuration;
  }

  public String getLeaseBeginIp()
  {
    return this.leaseBeginIp;
  }

  public String getLeaseEndIp()
  {
    return this.leaseEndIp;
  }

  public int getMaxLeaseDuration()
  {
    return this.maxLeaseDuration;
  }

  public boolean isUnlimitedLease()
  {
    return this.unlimitedLease;
  }

  public String getIpSubnetAddr()
  {
    return this.ipSubnetAddr;
  }

  public String getIpSubnetMask()
  {
    return this.ipSubnetMask;
  }

  public void setVirtualSwitch(String virtualSwitch)
  {
    this.virtualSwitch=virtualSwitch;
  }

  public void setDefaultLeaseDuration(int defaultLeaseDuration)
  {
    this.defaultLeaseDuration=defaultLeaseDuration;
  }

  public void setLeaseBeginIp(String leaseBeginIp)
  {
    this.leaseBeginIp=leaseBeginIp;
  }

  public void setLeaseEndIp(String leaseEndIp)
  {
    this.leaseEndIp=leaseEndIp;
  }

  public void setMaxLeaseDuration(int maxLeaseDuration)
  {
    this.maxLeaseDuration=maxLeaseDuration;
  }

  public void setUnlimitedLease(boolean unlimitedLease)
  {
    this.unlimitedLease=unlimitedLease;
  }

  public void setIpSubnetAddr(String ipSubnetAddr)
  {
    this.ipSubnetAddr=ipSubnetAddr;
  }

  public void setIpSubnetMask(String ipSubnetMask)
  {
    this.ipSubnetMask=ipSubnetMask;
  }
}