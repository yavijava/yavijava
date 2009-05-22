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
import java.util.Calendar;

/**
@author Steve Jin (sjin@vmware.com)
*/

public class UserSession extends DynamicData
{
  public String key;
  public String userName;
  public String fullName;
  public Calendar loginTime;
  public Calendar lastActiveTime;
  public String locale;
  public String messageLocale;

  public String getKey()
  {
    return this.key;
  }

  public String getUserName()
  {
    return this.userName;
  }

  public String getFullName()
  {
    return this.fullName;
  }

  public Calendar getLoginTime()
  {
    return this.loginTime;
  }

  public Calendar getLastActiveTime()
  {
    return this.lastActiveTime;
  }

  public String getLocale()
  {
    return this.locale;
  }

  public String getMessageLocale()
  {
    return this.messageLocale;
  }

  public void setKey(String key)
  {
    this.key=key;
  }

  public void setUserName(String userName)
  {
    this.userName=userName;
  }

  public void setFullName(String fullName)
  {
    this.fullName=fullName;
  }

  public void setLoginTime(Calendar loginTime)
  {
    this.loginTime=loginTime;
  }

  public void setLastActiveTime(Calendar lastActiveTime)
  {
    this.lastActiveTime=lastActiveTime;
  }

  public void setLocale(String locale)
  {
    this.locale=locale;
  }

  public void setMessageLocale(String messageLocale)
  {
    this.messageLocale=messageLocale;
  }
}