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

public class ExtensionServerInfo extends DynamicData
{
  public String url;
  public Description description;
  public String company;
  public String type;
  public String[] adminEmail;
  public String serverThumbprint;

  public String getUrl()
  {
    return this.url;
  }

  public Description getDescription()
  {
    return this.description;
  }

  public String getCompany()
  {
    return this.company;
  }

  public String getType()
  {
    return this.type;
  }

  public String[] getAdminEmail()
  {
    return this.adminEmail;
  }

  public String getServerThumbprint()
  {
    return this.serverThumbprint;
  }

  public void setUrl(String url)
  {
    this.url=url;
  }

  public void setDescription(Description description)
  {
    this.description=description;
  }

  public void setCompany(String company)
  {
    this.company=company;
  }

  public void setType(String type)
  {
    this.type=type;
  }

  public void setAdminEmail(String[] adminEmail)
  {
    this.adminEmail=adminEmail;
  }

  public void setServerThumbprint(String serverThumbprint)
  {
    this.serverThumbprint=serverThumbprint;
  }
}