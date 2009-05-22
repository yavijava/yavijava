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

public class HostApplyProfile extends ApplyProfile
{
  public HostMemoryProfile memory;
  public StorageProfile storage;
  public NetworkProfile network;
  public DateTimeProfile datetime;
  public FirewallProfile firewall;
  public SecurityProfile security;
  public ServiceProfile[] service;
  public OptionProfile[] option;
  public UserProfile[] userAccount;
  public UserGroupProfile[] usergroupAccount;

  public HostMemoryProfile getMemory()
  {
    return this.memory;
  }

  public StorageProfile getStorage()
  {
    return this.storage;
  }

  public NetworkProfile getNetwork()
  {
    return this.network;
  }

  public DateTimeProfile getDatetime()
  {
    return this.datetime;
  }

  public FirewallProfile getFirewall()
  {
    return this.firewall;
  }

  public SecurityProfile getSecurity()
  {
    return this.security;
  }

  public ServiceProfile[] getService()
  {
    return this.service;
  }

  public OptionProfile[] getOption()
  {
    return this.option;
  }

  public UserProfile[] getUserAccount()
  {
    return this.userAccount;
  }

  public UserGroupProfile[] getUsergroupAccount()
  {
    return this.usergroupAccount;
  }

  public void setMemory(HostMemoryProfile memory)
  {
    this.memory=memory;
  }

  public void setStorage(StorageProfile storage)
  {
    this.storage=storage;
  }

  public void setNetwork(NetworkProfile network)
  {
    this.network=network;
  }

  public void setDatetime(DateTimeProfile datetime)
  {
    this.datetime=datetime;
  }

  public void setFirewall(FirewallProfile firewall)
  {
    this.firewall=firewall;
  }

  public void setSecurity(SecurityProfile security)
  {
    this.security=security;
  }

  public void setService(ServiceProfile[] service)
  {
    this.service=service;
  }

  public void setOption(OptionProfile[] option)
  {
    this.option=option;
  }

  public void setUserAccount(UserProfile[] userAccount)
  {
    this.userAccount=userAccount;
  }

  public void setUsergroupAccount(UserGroupProfile[] usergroupAccount)
  {
    this.usergroupAccount=usergroupAccount;
  }
}