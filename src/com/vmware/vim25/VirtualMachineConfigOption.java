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

public class VirtualMachineConfigOption extends DynamicData
{
  public String version;
  public String description;
  public GuestOsDescriptor[] guestOSDescriptor;
  public int guestOSDefaultIndex;
  public VirtualHardwareOption hardwareOptions;
  public VirtualMachineCapability capabilities;
  public DatastoreOption datastore;
  public VirtualDevice[] defaultDevice;
  public String[] supportedMonitorType;

  public String getVersion()
  {
    return this.version;
  }

  public String getDescription()
  {
    return this.description;
  }

  public GuestOsDescriptor[] getGuestOSDescriptor()
  {
    return this.guestOSDescriptor;
  }

  public int getGuestOSDefaultIndex()
  {
    return this.guestOSDefaultIndex;
  }

  public VirtualHardwareOption getHardwareOptions()
  {
    return this.hardwareOptions;
  }

  public VirtualMachineCapability getCapabilities()
  {
    return this.capabilities;
  }

  public DatastoreOption getDatastore()
  {
    return this.datastore;
  }

  public VirtualDevice[] getDefaultDevice()
  {
    return this.defaultDevice;
  }

  public String[] getSupportedMonitorType()
  {
    return this.supportedMonitorType;
  }

  public void setVersion(String version)
  {
    this.version=version;
  }

  public void setDescription(String description)
  {
    this.description=description;
  }

  public void setGuestOSDescriptor(GuestOsDescriptor[] guestOSDescriptor)
  {
    this.guestOSDescriptor=guestOSDescriptor;
  }

  public void setGuestOSDefaultIndex(int guestOSDefaultIndex)
  {
    this.guestOSDefaultIndex=guestOSDefaultIndex;
  }

  public void setHardwareOptions(VirtualHardwareOption hardwareOptions)
  {
    this.hardwareOptions=hardwareOptions;
  }

  public void setCapabilities(VirtualMachineCapability capabilities)
  {
    this.capabilities=capabilities;
  }

  public void setDatastore(DatastoreOption datastore)
  {
    this.datastore=datastore;
  }

  public void setDefaultDevice(VirtualDevice[] defaultDevice)
  {
    this.defaultDevice=defaultDevice;
  }

  public void setSupportedMonitorType(String[] supportedMonitorType)
  {
    this.supportedMonitorType=supportedMonitorType;
  }
}