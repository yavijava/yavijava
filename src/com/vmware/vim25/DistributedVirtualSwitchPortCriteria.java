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

public class DistributedVirtualSwitchPortCriteria extends DynamicData
{
  public Boolean connected;
  public Boolean active;
  public Boolean uplinkPort;
  public ManagedObjectReference scope;
  public String[] portgroupKey;
  public Boolean inside;
  public String[] portKey;

  public Boolean getConnected()
  {
    return this.connected;
  }

  public Boolean getActive()
  {
    return this.active;
  }

  public Boolean getUplinkPort()
  {
    return this.uplinkPort;
  }

  public ManagedObjectReference getScope()
  {
    return this.scope;
  }

  public String[] getPortgroupKey()
  {
    return this.portgroupKey;
  }

  public Boolean getInside()
  {
    return this.inside;
  }

  public String[] getPortKey()
  {
    return this.portKey;
  }

  public void setConnected(Boolean connected)
  {
    this.connected=connected;
  }

  public void setActive(Boolean active)
  {
    this.active=active;
  }

  public void setUplinkPort(Boolean uplinkPort)
  {
    this.uplinkPort=uplinkPort;
  }

  public void setScope(ManagedObjectReference scope)
  {
    this.scope=scope;
  }

  public void setPortgroupKey(String[] portgroupKey)
  {
    this.portgroupKey=portgroupKey;
  }

  public void setInside(Boolean inside)
  {
    this.inside=inside;
  }

  public void setPortKey(String[] portKey)
  {
    this.portKey=portKey;
  }
}