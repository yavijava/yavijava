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

public class HostPatchManagerStatus extends DynamicData
{
  public String id;
  public boolean applicable;
  public String[] reason;
  public String integrity;
  public boolean installed;
  public String[] installState;
  public HostPatchManagerStatusPrerequisitePatch[] prerequisitePatch;
  public boolean restartRequired;
  public boolean reconnectRequired;
  public boolean vmOffRequired;
  public String[] supersededPatchIds;

  public String getId()
  {
    return this.id;
  }

  public boolean isApplicable()
  {
    return this.applicable;
  }

  public String[] getReason()
  {
    return this.reason;
  }

  public String getIntegrity()
  {
    return this.integrity;
  }

  public boolean isInstalled()
  {
    return this.installed;
  }

  public String[] getInstallState()
  {
    return this.installState;
  }

  public HostPatchManagerStatusPrerequisitePatch[] getPrerequisitePatch()
  {
    return this.prerequisitePatch;
  }

  public boolean isRestartRequired()
  {
    return this.restartRequired;
  }

  public boolean isReconnectRequired()
  {
    return this.reconnectRequired;
  }

  public boolean isVmOffRequired()
  {
    return this.vmOffRequired;
  }

  public String[] getSupersededPatchIds()
  {
    return this.supersededPatchIds;
  }

  public void setId(String id)
  {
    this.id=id;
  }

  public void setApplicable(boolean applicable)
  {
    this.applicable=applicable;
  }

  public void setReason(String[] reason)
  {
    this.reason=reason;
  }

  public void setIntegrity(String integrity)
  {
    this.integrity=integrity;
  }

  public void setInstalled(boolean installed)
  {
    this.installed=installed;
  }

  public void setInstallState(String[] installState)
  {
    this.installState=installState;
  }

  public void setPrerequisitePatch(HostPatchManagerStatusPrerequisitePatch[] prerequisitePatch)
  {
    this.prerequisitePatch=prerequisitePatch;
  }

  public void setRestartRequired(boolean restartRequired)
  {
    this.restartRequired=restartRequired;
  }

  public void setReconnectRequired(boolean reconnectRequired)
  {
    this.reconnectRequired=reconnectRequired;
  }

  public void setVmOffRequired(boolean vmOffRequired)
  {
    this.vmOffRequired=vmOffRequired;
  }

  public void setSupersededPatchIds(String[] supersededPatchIds)
  {
    this.supersededPatchIds=supersededPatchIds;
  }
}