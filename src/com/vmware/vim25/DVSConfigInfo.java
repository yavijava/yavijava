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
import java.util.Calendar;

/**
@author Steve Jin (sjin@vmware.com)
*/

public class DVSConfigInfo extends DynamicData
{
  public String uuid;
  public String name;
  public int numStandalonePorts;
  public int numPorts;
  public int maxPorts;
  public DVSUplinkPortPolicy uplinkPortPolicy;
  public ManagedObjectReference[] uplinkPortgroup;
  public DVPortSetting defaultPortConfig;
  public DistributedVirtualSwitchHostMember[] host;
  public DistributedVirtualSwitchProductSpec productInfo;
  public DistributedVirtualSwitchProductSpec targetInfo;
  public String extensionKey;
  public DistributedVirtualSwitchKeyedOpaqueBlob[] vendorSpecificConfig;
  public DVSPolicy policy;
  public String description;
  public String configVersion;
  public DVSContactInfo contact;
  public Calendar createTime;
  public Boolean networkResourceManagementEnabled;

  public String getUuid()
  {
    return this.uuid;
  }

  public String getName()
  {
    return this.name;
  }

  public int getNumStandalonePorts()
  {
    return this.numStandalonePorts;
  }

  public int getNumPorts()
  {
    return this.numPorts;
  }

  public int getMaxPorts()
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

  public DistributedVirtualSwitchHostMember[] getHost()
  {
    return this.host;
  }

  public DistributedVirtualSwitchProductSpec getProductInfo()
  {
    return this.productInfo;
  }

  public DistributedVirtualSwitchProductSpec getTargetInfo()
  {
    return this.targetInfo;
  }

  public String getExtensionKey()
  {
    return this.extensionKey;
  }

  public DistributedVirtualSwitchKeyedOpaqueBlob[] getVendorSpecificConfig()
  {
    return this.vendorSpecificConfig;
  }

  public DVSPolicy getPolicy()
  {
    return this.policy;
  }

  public String getDescription()
  {
    return this.description;
  }

  public String getConfigVersion()
  {
    return this.configVersion;
  }

  public DVSContactInfo getContact()
  {
    return this.contact;
  }

  public Calendar getCreateTime()
  {
    return this.createTime;
  }

  public Boolean getNetworkResourceManagementEnabled()
  {
    return this.networkResourceManagementEnabled;
  }

  public void setUuid(String uuid)
  {
    this.uuid=uuid;
  }

  public void setName(String name)
  {
    this.name=name;
  }

  public void setNumStandalonePorts(int numStandalonePorts)
  {
    this.numStandalonePorts=numStandalonePorts;
  }

  public void setNumPorts(int numPorts)
  {
    this.numPorts=numPorts;
  }

  public void setMaxPorts(int maxPorts)
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

  public void setHost(DistributedVirtualSwitchHostMember[] host)
  {
    this.host=host;
  }

  public void setProductInfo(DistributedVirtualSwitchProductSpec productInfo)
  {
    this.productInfo=productInfo;
  }

  public void setTargetInfo(DistributedVirtualSwitchProductSpec targetInfo)
  {
    this.targetInfo=targetInfo;
  }

  public void setExtensionKey(String extensionKey)
  {
    this.extensionKey=extensionKey;
  }

  public void setVendorSpecificConfig(DistributedVirtualSwitchKeyedOpaqueBlob[] vendorSpecificConfig)
  {
    this.vendorSpecificConfig=vendorSpecificConfig;
  }

  public void setPolicy(DVSPolicy policy)
  {
    this.policy=policy;
  }

  public void setDescription(String description)
  {
    this.description=description;
  }

  public void setConfigVersion(String configVersion)
  {
    this.configVersion=configVersion;
  }

  public void setContact(DVSContactInfo contact)
  {
    this.contact=contact;
  }

  public void setCreateTime(Calendar createTime)
  {
    this.createTime=createTime;
  }

  public void setNetworkResourceManagementEnabled(Boolean networkResourceManagementEnabled)
  {
    this.networkResourceManagementEnabled=networkResourceManagementEnabled;
  }
}