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

public class HostVirtualSwitch extends DynamicData
{
  public String name;
  public String key;
  public int numPorts;
  public int numPortsAvailable;
  public Integer mtu;
  public String[] portgroup;
  public String[] pnic;
  public HostVirtualSwitchSpec spec;

  public String getName()
  {
    return this.name;
  }

  public String getKey()
  {
    return this.key;
  }

  public int getNumPorts()
  {
    return this.numPorts;
  }

  public int getNumPortsAvailable()
  {
    return this.numPortsAvailable;
  }

  public Integer getMtu()
  {
    return this.mtu;
  }

  public String[] getPortgroup()
  {
    return this.portgroup;
  }

  public String[] getPnic()
  {
    return this.pnic;
  }

  public HostVirtualSwitchSpec getSpec()
  {
    return this.spec;
  }

  public void setName(String name)
  {
    this.name=name;
  }

  public void setKey(String key)
  {
    this.key=key;
  }

  public void setNumPorts(int numPorts)
  {
    this.numPorts=numPorts;
  }

  public void setNumPortsAvailable(int numPortsAvailable)
  {
    this.numPortsAvailable=numPortsAvailable;
  }

  public void setMtu(Integer mtu)
  {
    this.mtu=mtu;
  }

  public void setPortgroup(String[] portgroup)
  {
    this.portgroup=portgroup;
  }

  public void setPnic(String[] pnic)
  {
    this.pnic=pnic;
  }

  public void setSpec(HostVirtualSwitchSpec spec)
  {
    this.spec=spec;
  }
}