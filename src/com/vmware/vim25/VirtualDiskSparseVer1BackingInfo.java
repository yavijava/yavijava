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

public class VirtualDiskSparseVer1BackingInfo extends VirtualDeviceFileBackingInfo
{
  public String diskMode;
  public Boolean split;
  public Boolean writeThrough;
  public Long spaceUsedInKB;

  public String getDiskMode()
  {
    return this.diskMode;
  }

  public Boolean getSplit()
  {
    return this.split;
  }

  public Boolean getWriteThrough()
  {
    return this.writeThrough;
  }

  public Long getSpaceUsedInKB()
  {
    return this.spaceUsedInKB;
  }

  public void setDiskMode(String diskMode)
  {
    this.diskMode=diskMode;
  }

  public void setSplit(Boolean split)
  {
    this.split=split;
  }

  public void setWriteThrough(Boolean writeThrough)
  {
    this.writeThrough=writeThrough;
  }

  public void setSpaceUsedInKB(Long spaceUsedInKB)
  {
    this.spaceUsedInKB=spaceUsedInKB;
  }
}