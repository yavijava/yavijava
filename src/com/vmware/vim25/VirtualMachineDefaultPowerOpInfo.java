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

public class VirtualMachineDefaultPowerOpInfo extends DynamicData
{
  public String powerOffType;
  public String suspendType;
  public String resetType;
  public String defaultPowerOffType;
  public String defaultSuspendType;
  public String defaultResetType;
  public String standbyAction;

  public String getPowerOffType()
  {
    return this.powerOffType;
  }

  public String getSuspendType()
  {
    return this.suspendType;
  }

  public String getResetType()
  {
    return this.resetType;
  }

  public String getDefaultPowerOffType()
  {
    return this.defaultPowerOffType;
  }

  public String getDefaultSuspendType()
  {
    return this.defaultSuspendType;
  }

  public String getDefaultResetType()
  {
    return this.defaultResetType;
  }

  public String getStandbyAction()
  {
    return this.standbyAction;
  }

  public void setPowerOffType(String powerOffType)
  {
    this.powerOffType=powerOffType;
  }

  public void setSuspendType(String suspendType)
  {
    this.suspendType=suspendType;
  }

  public void setResetType(String resetType)
  {
    this.resetType=resetType;
  }

  public void setDefaultPowerOffType(String defaultPowerOffType)
  {
    this.defaultPowerOffType=defaultPowerOffType;
  }

  public void setDefaultSuspendType(String defaultSuspendType)
  {
    this.defaultSuspendType=defaultSuspendType;
  }

  public void setDefaultResetType(String defaultResetType)
  {
    this.defaultResetType=defaultResetType;
  }

  public void setStandbyAction(String standbyAction)
  {
    this.standbyAction=standbyAction;
  }
}