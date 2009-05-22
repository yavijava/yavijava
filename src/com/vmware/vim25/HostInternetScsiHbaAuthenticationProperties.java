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

public class HostInternetScsiHbaAuthenticationProperties extends DynamicData
{
  public boolean chapAuthEnabled;
  public String chapName;
  public String chapSecret;
  public String chapAuthenticationType;
  public Boolean chapInherited;
  public String mutualChapName;
  public String mutualChapSecret;
  public String mutualChapAuthenticationType;
  public Boolean mutualChapInherited;

  public boolean isChapAuthEnabled()
  {
    return this.chapAuthEnabled;
  }

  public String getChapName()
  {
    return this.chapName;
  }

  public String getChapSecret()
  {
    return this.chapSecret;
  }

  public String getChapAuthenticationType()
  {
    return this.chapAuthenticationType;
  }

  public Boolean getChapInherited()
  {
    return this.chapInherited;
  }

  public String getMutualChapName()
  {
    return this.mutualChapName;
  }

  public String getMutualChapSecret()
  {
    return this.mutualChapSecret;
  }

  public String getMutualChapAuthenticationType()
  {
    return this.mutualChapAuthenticationType;
  }

  public Boolean getMutualChapInherited()
  {
    return this.mutualChapInherited;
  }

  public void setChapAuthEnabled(boolean chapAuthEnabled)
  {
    this.chapAuthEnabled=chapAuthEnabled;
  }

  public void setChapName(String chapName)
  {
    this.chapName=chapName;
  }

  public void setChapSecret(String chapSecret)
  {
    this.chapSecret=chapSecret;
  }

  public void setChapAuthenticationType(String chapAuthenticationType)
  {
    this.chapAuthenticationType=chapAuthenticationType;
  }

  public void setChapInherited(Boolean chapInherited)
  {
    this.chapInherited=chapInherited;
  }

  public void setMutualChapName(String mutualChapName)
  {
    this.mutualChapName=mutualChapName;
  }

  public void setMutualChapSecret(String mutualChapSecret)
  {
    this.mutualChapSecret=mutualChapSecret;
  }

  public void setMutualChapAuthenticationType(String mutualChapAuthenticationType)
  {
    this.mutualChapAuthenticationType=mutualChapAuthenticationType;
  }

  public void setMutualChapInherited(Boolean mutualChapInherited)
  {
    this.mutualChapInherited=mutualChapInherited;
  }
}