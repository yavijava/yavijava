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

public class HostSystemInfo extends DynamicData
{
  public String vendor;
  public String model;
  public String uuid;
  public HostSystemIdentificationInfo[] otherIdentifyingInfo;

  public String getVendor()
  {
    return this.vendor;
  }

  public String getModel()
  {
    return this.model;
  }

  public String getUuid()
  {
    return this.uuid;
  }

  public HostSystemIdentificationInfo[] getOtherIdentifyingInfo()
  {
    return this.otherIdentifyingInfo;
  }

  public void setVendor(String vendor)
  {
    this.vendor=vendor;
  }

  public void setModel(String model)
  {
    this.model=model;
  }

  public void setUuid(String uuid)
  {
    this.uuid=uuid;
  }

  public void setOtherIdentifyingInfo(HostSystemIdentificationInfo[] otherIdentifyingInfo)
  {
    this.otherIdentifyingInfo=otherIdentifyingInfo;
  }
}