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

public class PhysicalNic extends DynamicData
{
  public String key;
  public String device;
  public String pci;
  public String driver;
  public PhysicalNicLinkInfo linkSpeed;
  public PhysicalNicLinkInfo[] validLinkSpecification;
  public PhysicalNicSpec spec;
  public boolean wakeOnLanSupported;
  public String mac;

  public String getKey()
  {
    return this.key;
  }

  public String getDevice()
  {
    return this.device;
  }

  public String getPci()
  {
    return this.pci;
  }

  public String getDriver()
  {
    return this.driver;
  }

  public PhysicalNicLinkInfo getLinkSpeed()
  {
    return this.linkSpeed;
  }

  public PhysicalNicLinkInfo[] getValidLinkSpecification()
  {
    return this.validLinkSpecification;
  }

  public PhysicalNicSpec getSpec()
  {
    return this.spec;
  }

  public boolean isWakeOnLanSupported()
  {
    return this.wakeOnLanSupported;
  }

  public String getMac()
  {
    return this.mac;
  }

  public void setKey(String key)
  {
    this.key=key;
  }

  public void setDevice(String device)
  {
    this.device=device;
  }

  public void setPci(String pci)
  {
    this.pci=pci;
  }

  public void setDriver(String driver)
  {
    this.driver=driver;
  }

  public void setLinkSpeed(PhysicalNicLinkInfo linkSpeed)
  {
    this.linkSpeed=linkSpeed;
  }

  public void setValidLinkSpecification(PhysicalNicLinkInfo[] validLinkSpecification)
  {
    this.validLinkSpecification=validLinkSpecification;
  }

  public void setSpec(PhysicalNicSpec spec)
  {
    this.spec=spec;
  }

  public void setWakeOnLanSupported(boolean wakeOnLanSupported)
  {
    this.wakeOnLanSupported=wakeOnLanSupported;
  }

  public void setMac(String mac)
  {
    this.mac=mac;
  }
}