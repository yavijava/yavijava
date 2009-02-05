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

public class GuestOsDescriptor extends DynamicData
{
  public String id;
  public String family;
  public String fullName;
  public int supportedMaxCPUs;
  public int supportedMinMemMB;
  public int supportedMaxMemMB;
  public int recommendedMemMB;
  public int recommendedColorDepth;
  public String[] supportedDiskControllerList;
  public String recommendedSCSIController;
  public String recommendedDiskController;
  public int supportedNumDisks;
  public int recommendedDiskSizeMB;
  public String[] supportedEthernetCard;
  public String recommendedEthernetCard;
  public Boolean supportsSlaveDisk;
  public HostCpuIdInfo[] cpuFeatureMask;
  public boolean supportsWakeOnLan;

  public String getId()
  {
    return this.id;
  }

  public String getFamily()
  {
    return this.family;
  }

  public String getFullName()
  {
    return this.fullName;
  }

  public int getSupportedMaxCPUs()
  {
    return this.supportedMaxCPUs;
  }

  public int getSupportedMinMemMB()
  {
    return this.supportedMinMemMB;
  }

  public int getSupportedMaxMemMB()
  {
    return this.supportedMaxMemMB;
  }

  public int getRecommendedMemMB()
  {
    return this.recommendedMemMB;
  }

  public int getRecommendedColorDepth()
  {
    return this.recommendedColorDepth;
  }

  public String[] getSupportedDiskControllerList()
  {
    return this.supportedDiskControllerList;
  }

  public String getRecommendedSCSIController()
  {
    return this.recommendedSCSIController;
  }

  public String getRecommendedDiskController()
  {
    return this.recommendedDiskController;
  }

  public int getSupportedNumDisks()
  {
    return this.supportedNumDisks;
  }

  public int getRecommendedDiskSizeMB()
  {
    return this.recommendedDiskSizeMB;
  }

  public String[] getSupportedEthernetCard()
  {
    return this.supportedEthernetCard;
  }

  public String getRecommendedEthernetCard()
  {
    return this.recommendedEthernetCard;
  }

  public Boolean getSupportsSlaveDisk()
  {
    return this.supportsSlaveDisk;
  }

  public HostCpuIdInfo[] getCpuFeatureMask()
  {
    return this.cpuFeatureMask;
  }

  public boolean isSupportsWakeOnLan()
  {
    return this.supportsWakeOnLan;
  }

  public void setId(String id)
  {
    this.id=id;
  }

  public void setFamily(String family)
  {
    this.family=family;
  }

  public void setFullName(String fullName)
  {
    this.fullName=fullName;
  }

  public void setSupportedMaxCPUs(int supportedMaxCPUs)
  {
    this.supportedMaxCPUs=supportedMaxCPUs;
  }

  public void setSupportedMinMemMB(int supportedMinMemMB)
  {
    this.supportedMinMemMB=supportedMinMemMB;
  }

  public void setSupportedMaxMemMB(int supportedMaxMemMB)
  {
    this.supportedMaxMemMB=supportedMaxMemMB;
  }

  public void setRecommendedMemMB(int recommendedMemMB)
  {
    this.recommendedMemMB=recommendedMemMB;
  }

  public void setRecommendedColorDepth(int recommendedColorDepth)
  {
    this.recommendedColorDepth=recommendedColorDepth;
  }

  public void setSupportedDiskControllerList(String[] supportedDiskControllerList)
  {
    this.supportedDiskControllerList=supportedDiskControllerList;
  }

  public void setRecommendedSCSIController(String recommendedSCSIController)
  {
    this.recommendedSCSIController=recommendedSCSIController;
  }

  public void setRecommendedDiskController(String recommendedDiskController)
  {
    this.recommendedDiskController=recommendedDiskController;
  }

  public void setSupportedNumDisks(int supportedNumDisks)
  {
    this.supportedNumDisks=supportedNumDisks;
  }

  public void setRecommendedDiskSizeMB(int recommendedDiskSizeMB)
  {
    this.recommendedDiskSizeMB=recommendedDiskSizeMB;
  }

  public void setSupportedEthernetCard(String[] supportedEthernetCard)
  {
    this.supportedEthernetCard=supportedEthernetCard;
  }

  public void setRecommendedEthernetCard(String recommendedEthernetCard)
  {
    this.recommendedEthernetCard=recommendedEthernetCard;
  }

  public void setSupportsSlaveDisk(Boolean supportsSlaveDisk)
  {
    this.supportsSlaveDisk=supportsSlaveDisk;
  }

  public void setCpuFeatureMask(HostCpuIdInfo[] cpuFeatureMask)
  {
    this.cpuFeatureMask=cpuFeatureMask;
  }

  public void setSupportsWakeOnLan(boolean supportsWakeOnLan)
  {
    this.supportsWakeOnLan=supportsWakeOnLan;
  }
}