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

public class DVPortgroupConfigInfo extends DynamicData
{
  public String key;
  public String name;
  public int numPorts;
  public ManagedObjectReference distributedVirtualSwitch;
  public DVPortSetting defaultPortConfig;
  public String description;
  public String type;
  public DVPortgroupPolicy policy;
  public String portNameFormat;
  public ManagedObjectReference[] scope;
  public DistributedVirtualSwitchKeyedOpaqueBlob[] vendorSpecificConfig;
  public String configVersion;

  public String getKey()
  {
    return this.key;
  }

  public String getName()
  {
    return this.name;
  }

  public int getNumPorts()
  {
    return this.numPorts;
  }

  public ManagedObjectReference getDistributedVirtualSwitch()
  {
    return this.distributedVirtualSwitch;
  }

  public DVPortSetting getDefaultPortConfig()
  {
    return this.defaultPortConfig;
  }

  public String getDescription()
  {
    return this.description;
  }

  public String getType()
  {
    return this.type;
  }

  public DVPortgroupPolicy getPolicy()
  {
    return this.policy;
  }

  public String getPortNameFormat()
  {
    return this.portNameFormat;
  }

  public ManagedObjectReference[] getScope()
  {
    return this.scope;
  }

  public DistributedVirtualSwitchKeyedOpaqueBlob[] getVendorSpecificConfig()
  {
    return this.vendorSpecificConfig;
  }

  public String getConfigVersion()
  {
    return this.configVersion;
  }

  public void setKey(String key)
  {
    this.key=key;
  }

  public void setName(String name)
  {
    this.name=name;
  }

  public void setNumPorts(int numPorts)
  {
    this.numPorts=numPorts;
  }

  public void setDistributedVirtualSwitch(ManagedObjectReference distributedVirtualSwitch)
  {
    this.distributedVirtualSwitch=distributedVirtualSwitch;
  }

  public void setDefaultPortConfig(DVPortSetting defaultPortConfig)
  {
    this.defaultPortConfig=defaultPortConfig;
  }

  public void setDescription(String description)
  {
    this.description=description;
  }

  public void setType(String type)
  {
    this.type=type;
  }

  public void setPolicy(DVPortgroupPolicy policy)
  {
    this.policy=policy;
  }

  public void setPortNameFormat(String portNameFormat)
  {
    this.portNameFormat=portNameFormat;
  }

  public void setScope(ManagedObjectReference[] scope)
  {
    this.scope=scope;
  }

  public void setVendorSpecificConfig(DistributedVirtualSwitchKeyedOpaqueBlob[] vendorSpecificConfig)
  {
    this.vendorSpecificConfig=vendorSpecificConfig;
  }

  public void setConfigVersion(String configVersion)
  {
    this.configVersion=configVersion;
  }
}