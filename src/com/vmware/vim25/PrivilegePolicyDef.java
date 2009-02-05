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

public class PrivilegePolicyDef extends DynamicData
{
  public String createPrivilege;
  public String readPrivilege;
  public String updatePrivilege;
  public String deletePrivilege;

  public String getCreatePrivilege()
  {
    return this.createPrivilege;
  }

  public String getReadPrivilege()
  {
    return this.readPrivilege;
  }

  public String getUpdatePrivilege()
  {
    return this.updatePrivilege;
  }

  public String getDeletePrivilege()
  {
    return this.deletePrivilege;
  }

  public void setCreatePrivilege(String createPrivilege)
  {
    this.createPrivilege=createPrivilege;
  }

  public void setReadPrivilege(String readPrivilege)
  {
    this.readPrivilege=readPrivilege;
  }

  public void setUpdatePrivilege(String updatePrivilege)
  {
    this.updatePrivilege=updatePrivilege;
  }

  public void setDeletePrivilege(String deletePrivilege)
  {
    this.deletePrivilege=deletePrivilege;
  }
}