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

public class HostConfigSpec extends DynamicData
{
  public HostNasVolumeConfig[] nasDatastore;
  public HostNetworkConfig network;
  public HostVirtualNicManagerNicTypeSelection[] nicTypeSelection;
  public HostServiceConfig[] service;
  public HostFirewallConfig firewall;
  public OptionValue[] option;
  public String datastorePrincipal;
  public String datastorePrincipalPasswd;
  public HostDateTimeConfig datetime;
  public HostStorageDeviceInfo storageDevice;
  public HostLicenseSpec license;
  public HostSecuritySpec security;
  public HostAccountSpec[] userAccount;
  public HostAccountSpec[] usergroupAccount;
  public HostMemorySpec memory;

  public HostNasVolumeConfig[] getNasDatastore()
  {
    return this.nasDatastore;
  }

  public HostNetworkConfig getNetwork()
  {
    return this.network;
  }

  public HostVirtualNicManagerNicTypeSelection[] getNicTypeSelection()
  {
    return this.nicTypeSelection;
  }

  public HostServiceConfig[] getService()
  {
    return this.service;
  }

  public HostFirewallConfig getFirewall()
  {
    return this.firewall;
  }

  public OptionValue[] getOption()
  {
    return this.option;
  }

  public String getDatastorePrincipal()
  {
    return this.datastorePrincipal;
  }

  public String getDatastorePrincipalPasswd()
  {
    return this.datastorePrincipalPasswd;
  }

  public HostDateTimeConfig getDatetime()
  {
    return this.datetime;
  }

  public HostStorageDeviceInfo getStorageDevice()
  {
    return this.storageDevice;
  }

  public HostLicenseSpec getLicense()
  {
    return this.license;
  }

  public HostSecuritySpec getSecurity()
  {
    return this.security;
  }

  public HostAccountSpec[] getUserAccount()
  {
    return this.userAccount;
  }

  public HostAccountSpec[] getUsergroupAccount()
  {
    return this.usergroupAccount;
  }

  public HostMemorySpec getMemory()
  {
    return this.memory;
  }

  public void setNasDatastore(HostNasVolumeConfig[] nasDatastore)
  {
    this.nasDatastore=nasDatastore;
  }

  public void setNetwork(HostNetworkConfig network)
  {
    this.network=network;
  }

  public void setNicTypeSelection(HostVirtualNicManagerNicTypeSelection[] nicTypeSelection)
  {
    this.nicTypeSelection=nicTypeSelection;
  }

  public void setService(HostServiceConfig[] service)
  {
    this.service=service;
  }

  public void setFirewall(HostFirewallConfig firewall)
  {
    this.firewall=firewall;
  }

  public void setOption(OptionValue[] option)
  {
    this.option=option;
  }

  public void setDatastorePrincipal(String datastorePrincipal)
  {
    this.datastorePrincipal=datastorePrincipal;
  }

  public void setDatastorePrincipalPasswd(String datastorePrincipalPasswd)
  {
    this.datastorePrincipalPasswd=datastorePrincipalPasswd;
  }

  public void setDatetime(HostDateTimeConfig datetime)
  {
    this.datetime=datetime;
  }

  public void setStorageDevice(HostStorageDeviceInfo storageDevice)
  {
    this.storageDevice=storageDevice;
  }

  public void setLicense(HostLicenseSpec license)
  {
    this.license=license;
  }

  public void setSecurity(HostSecuritySpec security)
  {
    this.security=security;
  }

  public void setUserAccount(HostAccountSpec[] userAccount)
  {
    this.userAccount=userAccount;
  }

  public void setUsergroupAccount(HostAccountSpec[] usergroupAccount)
  {
    this.usergroupAccount=usergroupAccount;
  }

  public void setMemory(HostMemorySpec memory)
  {
    this.memory=memory;
  }
}