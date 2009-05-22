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

public class HostPciDevice extends DynamicData
{
  public String id;
  public short classId;
  public byte bus;
  public byte slot;
  public byte function;
  public short vendorId;
  public short subVendorId;
  public String vendorName;
  public short deviceId;
  public short subDeviceId;
  public String parentBridge;
  public String deviceName;

  public String getId()
  {
    return this.id;
  }

  public short getClassId()
  {
    return this.classId;
  }

  public byte getBus()
  {
    return this.bus;
  }

  public byte getSlot()
  {
    return this.slot;
  }

  public byte getFunction()
  {
    return this.function;
  }

  public short getVendorId()
  {
    return this.vendorId;
  }

  public short getSubVendorId()
  {
    return this.subVendorId;
  }

  public String getVendorName()
  {
    return this.vendorName;
  }

  public short getDeviceId()
  {
    return this.deviceId;
  }

  public short getSubDeviceId()
  {
    return this.subDeviceId;
  }

  public String getParentBridge()
  {
    return this.parentBridge;
  }

  public String getDeviceName()
  {
    return this.deviceName;
  }

  public void setId(String id)
  {
    this.id=id;
  }

  public void setClassId(short classId)
  {
    this.classId=classId;
  }

  public void setBus(byte bus)
  {
    this.bus=bus;
  }

  public void setSlot(byte slot)
  {
    this.slot=slot;
  }

  public void setFunction(byte function)
  {
    this.function=function;
  }

  public void setVendorId(short vendorId)
  {
    this.vendorId=vendorId;
  }

  public void setSubVendorId(short subVendorId)
  {
    this.subVendorId=subVendorId;
  }

  public void setVendorName(String vendorName)
  {
    this.vendorName=vendorName;
  }

  public void setDeviceId(short deviceId)
  {
    this.deviceId=deviceId;
  }

  public void setSubDeviceId(short subDeviceId)
  {
    this.subDeviceId=subDeviceId;
  }

  public void setParentBridge(String parentBridge)
  {
    this.parentBridge=parentBridge;
  }

  public void setDeviceName(String deviceName)
  {
    this.deviceName=deviceName;
  }
}