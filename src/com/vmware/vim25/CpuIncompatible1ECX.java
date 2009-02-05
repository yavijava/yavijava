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

public class CpuIncompatible1ECX extends CpuIncompatible
{
  public boolean sse3;
  public boolean ssse3;
  public boolean sse41;
  public boolean sse42;
  public boolean other;
  public boolean otherOnly;

  public boolean isSse3()
  {
    return this.sse3;
  }

  public boolean isSsse3()
  {
    return this.ssse3;
  }

  public boolean isSse41()
  {
    return this.sse41;
  }

  public boolean isSse42()
  {
    return this.sse42;
  }

  public boolean isOther()
  {
    return this.other;
  }

  public boolean isOtherOnly()
  {
    return this.otherOnly;
  }

  public void setSse3(boolean sse3)
  {
    this.sse3=sse3;
  }

  public void setSsse3(boolean ssse3)
  {
    this.ssse3=ssse3;
  }

  public void setSse41(boolean sse41)
  {
    this.sse41=sse41;
  }

  public void setSse42(boolean sse42)
  {
    this.sse42=sse42;
  }

  public void setOther(boolean other)
  {
    this.other=other;
  }

  public void setOtherOnly(boolean otherOnly)
  {
    this.otherOnly=otherOnly;
  }
}