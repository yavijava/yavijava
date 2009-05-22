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

public class HostInternetScsiHbaAuthenticationCapabilities extends DynamicData
{
  public boolean chapAuthSettable;
  public boolean krb5AuthSettable;
  public boolean srpAuthSettable;
  public boolean spkmAuthSettable;
  public Boolean mutualChapSettable;
  public Boolean targetChapSettable;
  public Boolean targetMutualChapSettable;

  public boolean isChapAuthSettable()
  {
    return this.chapAuthSettable;
  }

  public boolean isKrb5AuthSettable()
  {
    return this.krb5AuthSettable;
  }

  public boolean isSrpAuthSettable()
  {
    return this.srpAuthSettable;
  }

  public boolean isSpkmAuthSettable()
  {
    return this.spkmAuthSettable;
  }

  public Boolean getMutualChapSettable()
  {
    return this.mutualChapSettable;
  }

  public Boolean getTargetChapSettable()
  {
    return this.targetChapSettable;
  }

  public Boolean getTargetMutualChapSettable()
  {
    return this.targetMutualChapSettable;
  }

  public void setChapAuthSettable(boolean chapAuthSettable)
  {
    this.chapAuthSettable=chapAuthSettable;
  }

  public void setKrb5AuthSettable(boolean krb5AuthSettable)
  {
    this.krb5AuthSettable=krb5AuthSettable;
  }

  public void setSrpAuthSettable(boolean srpAuthSettable)
  {
    this.srpAuthSettable=srpAuthSettable;
  }

  public void setSpkmAuthSettable(boolean spkmAuthSettable)
  {
    this.spkmAuthSettable=spkmAuthSettable;
  }

  public void setMutualChapSettable(Boolean mutualChapSettable)
  {
    this.mutualChapSettable=mutualChapSettable;
  }

  public void setTargetChapSettable(Boolean targetChapSettable)
  {
    this.targetChapSettable=targetChapSettable;
  }

  public void setTargetMutualChapSettable(Boolean targetMutualChapSettable)
  {
    this.targetMutualChapSettable=targetMutualChapSettable;
  }
}