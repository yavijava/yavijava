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

public class GuestNicInfo extends DynamicData
{
  public String network;
  public String[] ipAddress;
  public String macAddress;
  public boolean connected;
  public int deviceConfigId;

  public String getNetwork()
  {
    return this.network;
  }

  public String[] getIpAddress()
  {
    return this.ipAddress;
  }

  public String getMacAddress()
  {
    return this.macAddress;
  }

  public boolean isConnected()
  {
    return this.connected;
  }

  public int getDeviceConfigId()
  {
    return this.deviceConfigId;
  }

  public void setNetwork(String network)
  {
    this.network=network;
  }

  public void setIpAddress(String[] ipAddress)
  {
    this.ipAddress=ipAddress;
  }

  public void setMacAddress(String macAddress)
  {
    this.macAddress=macAddress;
  }

  public void setConnected(boolean connected)
  {
    this.connected=connected;
  }

  public void setDeviceConfigId(int deviceConfigId)
  {
    this.deviceConfigId=deviceConfigId;
  }
}