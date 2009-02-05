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

public class ScsiLun extends HostDevice
{
  public String key;
  public String uuid;
  public String canonicalName;
  public String lunType;
  public String vendor;
  public String model;
  public String revision;
  public Integer scsiLevel;
  public String serialNumber;
  public ScsiLunDurableName durableName;
  public ScsiLunDurableName[] alternateName;
  public byte[] standardInquiry;
  public Integer queueDepth;
  public String[] operationalState;

  public String getKey()
  {
    return this.key;
  }

  public String getUuid()
  {
    return this.uuid;
  }

  public String getCanonicalName()
  {
    return this.canonicalName;
  }

  public String getLunType()
  {
    return this.lunType;
  }

  public String getVendor()
  {
    return this.vendor;
  }

  public String getModel()
  {
    return this.model;
  }

  public String getRevision()
  {
    return this.revision;
  }

  public Integer getScsiLevel()
  {
    return this.scsiLevel;
  }

  public String getSerialNumber()
  {
    return this.serialNumber;
  }

  public ScsiLunDurableName getDurableName()
  {
    return this.durableName;
  }

  public ScsiLunDurableName[] getAlternateName()
  {
    return this.alternateName;
  }

  public byte[] getStandardInquiry()
  {
    return this.standardInquiry;
  }

  public Integer getQueueDepth()
  {
    return this.queueDepth;
  }

  public String[] getOperationalState()
  {
    return this.operationalState;
  }

  public void setKey(String key)
  {
    this.key=key;
  }

  public void setUuid(String uuid)
  {
    this.uuid=uuid;
  }

  public void setCanonicalName(String canonicalName)
  {
    this.canonicalName=canonicalName;
  }

  public void setLunType(String lunType)
  {
    this.lunType=lunType;
  }

  public void setVendor(String vendor)
  {
    this.vendor=vendor;
  }

  public void setModel(String model)
  {
    this.model=model;
  }

  public void setRevision(String revision)
  {
    this.revision=revision;
  }

  public void setScsiLevel(Integer scsiLevel)
  {
    this.scsiLevel=scsiLevel;
  }

  public void setSerialNumber(String serialNumber)
  {
    this.serialNumber=serialNumber;
  }

  public void setDurableName(ScsiLunDurableName durableName)
  {
    this.durableName=durableName;
  }

  public void setAlternateName(ScsiLunDurableName[] alternateName)
  {
    this.alternateName=alternateName;
  }

  public void setStandardInquiry(byte[] standardInquiry)
  {
    this.standardInquiry=standardInquiry;
  }

  public void setQueueDepth(Integer queueDepth)
  {
    this.queueDepth=queueDepth;
  }

  public void setOperationalState(String[] operationalState)
  {
    this.operationalState=operationalState;
  }
}