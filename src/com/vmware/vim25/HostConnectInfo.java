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

public class HostConnectInfo extends DynamicData
{
  public String serverIp;
  public HostListSummary host;
  public VirtualMachineSummary[] vm;
  public Boolean vimAccountNameRequired;
  public Boolean clusterSupported;
  public HostConnectInfoNetworkInfo[] network;
  public HostDatastoreConnectInfo[] datastore;
  public HostLicenseConnectInfo license;

  public String getServerIp()
  {
    return this.serverIp;
  }

  public HostListSummary getHost()
  {
    return this.host;
  }

  public VirtualMachineSummary[] getVm()
  {
    return this.vm;
  }

  public Boolean getVimAccountNameRequired()
  {
    return this.vimAccountNameRequired;
  }

  public Boolean getClusterSupported()
  {
    return this.clusterSupported;
  }

  public HostConnectInfoNetworkInfo[] getNetwork()
  {
    return this.network;
  }

  public HostDatastoreConnectInfo[] getDatastore()
  {
    return this.datastore;
  }

  public HostLicenseConnectInfo getLicense()
  {
    return this.license;
  }

  public void setServerIp(String serverIp)
  {
    this.serverIp=serverIp;
  }

  public void setHost(HostListSummary host)
  {
    this.host=host;
  }

  public void setVm(VirtualMachineSummary[] vm)
  {
    this.vm=vm;
  }

  public void setVimAccountNameRequired(Boolean vimAccountNameRequired)
  {
    this.vimAccountNameRequired=vimAccountNameRequired;
  }

  public void setClusterSupported(Boolean clusterSupported)
  {
    this.clusterSupported=clusterSupported;
  }

  public void setNetwork(HostConnectInfoNetworkInfo[] network)
  {
    this.network=network;
  }

  public void setDatastore(HostDatastoreConnectInfo[] datastore)
  {
    this.datastore=datastore;
  }

  public void setLicense(HostLicenseConnectInfo license)
  {
    this.license=license;
  }
}