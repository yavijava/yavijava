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

public class PhysicalNicCdpDeviceCapability extends DynamicData
{
  public boolean router;
  public boolean transparentBridge;
  public boolean sourceRouteBridge;
  public boolean networkSwitch;
  public boolean host;
  public boolean igmpEnabled;
  public boolean repeater;

  public boolean isRouter()
  {
    return this.router;
  }

  public boolean isTransparentBridge()
  {
    return this.transparentBridge;
  }

  public boolean isSourceRouteBridge()
  {
    return this.sourceRouteBridge;
  }

  public boolean isNetworkSwitch()
  {
    return this.networkSwitch;
  }

  public boolean isHost()
  {
    return this.host;
  }

  public boolean isIgmpEnabled()
  {
    return this.igmpEnabled;
  }

  public boolean isRepeater()
  {
    return this.repeater;
  }

  public void setRouter(boolean router)
  {
    this.router=router;
  }

  public void setTransparentBridge(boolean transparentBridge)
  {
    this.transparentBridge=transparentBridge;
  }

  public void setSourceRouteBridge(boolean sourceRouteBridge)
  {
    this.sourceRouteBridge=sourceRouteBridge;
  }

  public void setNetworkSwitch(boolean networkSwitch)
  {
    this.networkSwitch=networkSwitch;
  }

  public void setHost(boolean host)
  {
    this.host=host;
  }

  public void setIgmpEnabled(boolean igmpEnabled)
  {
    this.igmpEnabled=igmpEnabled;
  }

  public void setRepeater(boolean repeater)
  {
    this.repeater=repeater;
  }
}