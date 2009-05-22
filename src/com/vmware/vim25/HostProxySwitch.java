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

public class HostProxySwitch extends DynamicData
{
  public String dvsUuid;
  public String dvsName;
  public String key;
  public int numPorts;
  public int numPortsAvailable;
  public KeyValue[] uplinkPort;
  public Integer mtu;
  public String[] pnic;
  public HostProxySwitchSpec spec;

  public String getDvsUuid()
  {
    return this.dvsUuid;
  }

  public String getDvsName()
  {
    return this.dvsName;
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

  public KeyValue[] getUplinkPort()
  {
    return this.uplinkPort;
  }

  public Integer getMtu()
  {
    return this.mtu;
  }

  public String[] getPnic()
  {
    return this.pnic;
  }

  public HostProxySwitchSpec getSpec()
  {
    return this.spec;
  }

  public void setDvsUuid(String dvsUuid)
  {
    this.dvsUuid=dvsUuid;
  }

  public void setDvsName(String dvsName)
  {
    this.dvsName=dvsName;
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

  public void setUplinkPort(KeyValue[] uplinkPort)
  {
    this.uplinkPort=uplinkPort;
  }

  public void setMtu(Integer mtu)
  {
    this.mtu=mtu;
  }

  public void setPnic(String[] pnic)
  {
    this.pnic=pnic;
  }

  public void setSpec(HostProxySwitchSpec spec)
  {
    this.spec=spec;
  }
}