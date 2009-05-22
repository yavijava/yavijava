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

public class VirtualDeviceOption extends DynamicData
{
  public String type;
  public VirtualDeviceConnectOption connectOption;
  public String controllerType;
  public BoolOption autoAssignController;
  public VirtualDeviceBackingOption[] backingOption;
  public Integer defaultBackingOptionIndex;
  public String[] licensingLimit;
  public boolean deprecated;
  public boolean plugAndPlay;
  public Boolean hotRemoveSupported;

  public String getType()
  {
    return this.type;
  }

  public VirtualDeviceConnectOption getConnectOption()
  {
    return this.connectOption;
  }

  public String getControllerType()
  {
    return this.controllerType;
  }

  public BoolOption getAutoAssignController()
  {
    return this.autoAssignController;
  }

  public VirtualDeviceBackingOption[] getBackingOption()
  {
    return this.backingOption;
  }

  public Integer getDefaultBackingOptionIndex()
  {
    return this.defaultBackingOptionIndex;
  }

  public String[] getLicensingLimit()
  {
    return this.licensingLimit;
  }

  public boolean isDeprecated()
  {
    return this.deprecated;
  }

  public boolean isPlugAndPlay()
  {
    return this.plugAndPlay;
  }

  public Boolean getHotRemoveSupported()
  {
    return this.hotRemoveSupported;
  }

  public void setType(String type)
  {
    this.type=type;
  }

  public void setConnectOption(VirtualDeviceConnectOption connectOption)
  {
    this.connectOption=connectOption;
  }

  public void setControllerType(String controllerType)
  {
    this.controllerType=controllerType;
  }

  public void setAutoAssignController(BoolOption autoAssignController)
  {
    this.autoAssignController=autoAssignController;
  }

  public void setBackingOption(VirtualDeviceBackingOption[] backingOption)
  {
    this.backingOption=backingOption;
  }

  public void setDefaultBackingOptionIndex(Integer defaultBackingOptionIndex)
  {
    this.defaultBackingOptionIndex=defaultBackingOptionIndex;
  }

  public void setLicensingLimit(String[] licensingLimit)
  {
    this.licensingLimit=licensingLimit;
  }

  public void setDeprecated(boolean deprecated)
  {
    this.deprecated=deprecated;
  }

  public void setPlugAndPlay(boolean plugAndPlay)
  {
    this.plugAndPlay=plugAndPlay;
  }

  public void setHotRemoveSupported(Boolean hotRemoveSupported)
  {
    this.hotRemoveSupported=hotRemoveSupported;
  }
}