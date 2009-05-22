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

public class HostConnectSpec extends DynamicData
{
  public String hostName;
  public Integer port;
  public String sslThumbprint;
  public String userName;
  public String password;
  public ManagedObjectReference vmFolder;
  public boolean force;
  public String vimAccountName;
  public String vimAccountPassword;
  public String managementIp;

  public String getHostName()
  {
    return this.hostName;
  }

  public Integer getPort()
  {
    return this.port;
  }

  public String getSslThumbprint()
  {
    return this.sslThumbprint;
  }

  public String getUserName()
  {
    return this.userName;
  }

  public String getPassword()
  {
    return this.password;
  }

  public ManagedObjectReference getVmFolder()
  {
    return this.vmFolder;
  }

  public boolean isForce()
  {
    return this.force;
  }

  public String getVimAccountName()
  {
    return this.vimAccountName;
  }

  public String getVimAccountPassword()
  {
    return this.vimAccountPassword;
  }

  public String getManagementIp()
  {
    return this.managementIp;
  }

  public void setHostName(String hostName)
  {
    this.hostName=hostName;
  }

  public void setPort(Integer port)
  {
    this.port=port;
  }

  public void setSslThumbprint(String sslThumbprint)
  {
    this.sslThumbprint=sslThumbprint;
  }

  public void setUserName(String userName)
  {
    this.userName=userName;
  }

  public void setPassword(String password)
  {
    this.password=password;
  }

  public void setVmFolder(ManagedObjectReference vmFolder)
  {
    this.vmFolder=vmFolder;
  }

  public void setForce(boolean force)
  {
    this.force=force;
  }

  public void setVimAccountName(String vimAccountName)
  {
    this.vimAccountName=vimAccountName;
  }

  public void setVimAccountPassword(String vimAccountPassword)
  {
    this.vimAccountPassword=vimAccountPassword;
  }

  public void setManagementIp(String managementIp)
  {
    this.managementIp=managementIp;
  }
}