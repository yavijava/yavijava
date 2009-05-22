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

public class VmwareUplinkPortTeamingPolicy extends InheritablePolicy
{
  public StringPolicy policy;
  public BoolPolicy reversePolicy;
  public BoolPolicy notifySwitches;
  public BoolPolicy rollingOrder;
  public DVSFailureCriteria failureCriteria;
  public VMwareUplinkPortOrderPolicy uplinkPortOrder;

  public StringPolicy getPolicy()
  {
    return this.policy;
  }

  public BoolPolicy getReversePolicy()
  {
    return this.reversePolicy;
  }

  public BoolPolicy getNotifySwitches()
  {
    return this.notifySwitches;
  }

  public BoolPolicy getRollingOrder()
  {
    return this.rollingOrder;
  }

  public DVSFailureCriteria getFailureCriteria()
  {
    return this.failureCriteria;
  }

  public VMwareUplinkPortOrderPolicy getUplinkPortOrder()
  {
    return this.uplinkPortOrder;
  }

  public void setPolicy(StringPolicy policy)
  {
    this.policy=policy;
  }

  public void setReversePolicy(BoolPolicy reversePolicy)
  {
    this.reversePolicy=reversePolicy;
  }

  public void setNotifySwitches(BoolPolicy notifySwitches)
  {
    this.notifySwitches=notifySwitches;
  }

  public void setRollingOrder(BoolPolicy rollingOrder)
  {
    this.rollingOrder=rollingOrder;
  }

  public void setFailureCriteria(DVSFailureCriteria failureCriteria)
  {
    this.failureCriteria=failureCriteria;
  }

  public void setUplinkPortOrder(VMwareUplinkPortOrderPolicy uplinkPortOrder)
  {
    this.uplinkPortOrder=uplinkPortOrder;
  }
}