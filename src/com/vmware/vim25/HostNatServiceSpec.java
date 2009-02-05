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

public class HostNatServiceSpec extends DynamicData
{
  public String virtualSwitch;
  public boolean activeFtp;
  public boolean allowAnyOui;
  public boolean configPort;
  public String ipGatewayAddress;
  public int udpTimeout;
  public HostNatServicePortForwardSpec[] portForward;
  public HostNatServiceNameServiceSpec nameService;

  public String getVirtualSwitch()
  {
    return this.virtualSwitch;
  }

  public boolean isActiveFtp()
  {
    return this.activeFtp;
  }

  public boolean isAllowAnyOui()
  {
    return this.allowAnyOui;
  }

  public boolean isConfigPort()
  {
    return this.configPort;
  }

  public String getIpGatewayAddress()
  {
    return this.ipGatewayAddress;
  }

  public int getUdpTimeout()
  {
    return this.udpTimeout;
  }

  public HostNatServicePortForwardSpec[] getPortForward()
  {
    return this.portForward;
  }

  public HostNatServiceNameServiceSpec getNameService()
  {
    return this.nameService;
  }

  public void setVirtualSwitch(String virtualSwitch)
  {
    this.virtualSwitch=virtualSwitch;
  }

  public void setActiveFtp(boolean activeFtp)
  {
    this.activeFtp=activeFtp;
  }

  public void setAllowAnyOui(boolean allowAnyOui)
  {
    this.allowAnyOui=allowAnyOui;
  }

  public void setConfigPort(boolean configPort)
  {
    this.configPort=configPort;
  }

  public void setIpGatewayAddress(String ipGatewayAddress)
  {
    this.ipGatewayAddress=ipGatewayAddress;
  }

  public void setUdpTimeout(int udpTimeout)
  {
    this.udpTimeout=udpTimeout;
  }

  public void setPortForward(HostNatServicePortForwardSpec[] portForward)
  {
    this.portForward=portForward;
  }

  public void setNameService(HostNatServiceNameServiceSpec nameService)
  {
    this.nameService=nameService;
  }
}