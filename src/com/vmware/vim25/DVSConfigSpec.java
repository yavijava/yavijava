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

public class DVSConfigSpec extends DynamicData
{
  public String configVersion;
  public String name;
  public Integer numStandalonePorts;
  public Integer maxPorts;
  public DVSUplinkPortPolicy uplinkPortPolicy;
  public ManagedObjectReference[] uplinkPortgroup;
  public DVPortSetting defaultPortConfig;
  public DistributedVirtualSwitchHostMemberConfigSpec[] host;
  public String extensionKey;
  public String description;
  public DVSPolicy policy;
  public DistributedVirtualSwitchKeyedOpaqueBlob[] vendorSpecificConfig;
  public DVSContactInfo contact;

  public String getConfigVersion()
  {
    return this.configVersion;
  }

  public String getName()
  {
    return this.name;
  }

  public Integer getNumStandalonePorts()
  {
    return this.numStandalonePorts;
  }

  public Integer getMaxPorts()
  {
    return this.maxPorts;
  }

  public DVSUplinkPortPolicy getUplinkPortPolicy()
  {
    return this.uplinkPortPolicy;
  }

  public ManagedObjectReference[] getUplinkPortgroup()
  {
    return this.uplinkPortgroup;
  }

  public DVPortSetting getDefaultPortConfig()
  {
    return this.defaultPortConfig;
  }

  public DistributedVirtualSwitchHostMemberConfigSpec[] getHost()
  {
    return this.host;
  }

  public String getExtensionKey()
  {
    return this.extensionKey;
  }

  public String getDescription()
  {
    return this.description;
  }

  public DVSPolicy getPolicy()
  {
    return this.policy;
  }

  public DistributedVirtualSwitchKeyedOpaqueBlob[] getVendorSpecificConfig()
  {
    return this.vendorSpecificConfig;
  }

  public DVSContactInfo getContact()
  {
    return this.contact;
  }

  public void setConfigVersion(String configVersion)
  {
    this.configVersion=configVersion;
  }

  public void setName(String name)
  {
    this.name=name;
  }

  public void setNumStandalonePorts(Integer numStandalonePorts)
  {
    this.numStandalonePorts=numStandalonePorts;
  }

  public void setMaxPorts(Integer maxPorts)
  {
    this.maxPorts=maxPorts;
  }

  public void setUplinkPortPolicy(DVSUplinkPortPolicy uplinkPortPolicy)
  {
    this.uplinkPortPolicy=uplinkPortPolicy;
  }

  public void setUplinkPortgroup(ManagedObjectReference[] uplinkPortgroup)
  {
    this.uplinkPortgroup=uplinkPortgroup;
  }

  public void setDefaultPortConfig(DVPortSetting defaultPortConfig)
  {
    this.defaultPortConfig=defaultPortConfig;
  }

  public void setHost(DistributedVirtualSwitchHostMemberConfigSpec[] host)
  {
    this.host=host;
  }

  public void setExtensionKey(String extensionKey)
  {
    this.extensionKey=extensionKey;
  }

  public void setDescription(String description)
  {
    this.description=description;
  }

  public void setPolicy(DVSPolicy policy)
  {
    this.policy=policy;
  }

  public void setVendorSpecificConfig(DistributedVirtualSwitchKeyedOpaqueBlob[] vendorSpecificConfig)
  {
    this.vendorSpecificConfig=vendorSpecificConfig;
  }

  public void setContact(DVSContactInfo contact)
  {
    this.contact=contact;
  }
}