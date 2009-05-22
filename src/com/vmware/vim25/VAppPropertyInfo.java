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

public class VAppPropertyInfo extends DynamicData
{
  public int key;
  public String classId;
  public String instanceId;
  public String id;
  public String category;
  public String label;
  public String type;
  public Boolean userConfigurable;
  public String defaultValue;
  public String value;
  public String description;

  public int getKey()
  {
    return this.key;
  }

  public String getClassId()
  {
    return this.classId;
  }

  public String getInstanceId()
  {
    return this.instanceId;
  }

  public String getId()
  {
    return this.id;
  }

  public String getCategory()
  {
    return this.category;
  }

  public String getLabel()
  {
    return this.label;
  }

  public String getType()
  {
    return this.type;
  }

  public Boolean getUserConfigurable()
  {
    return this.userConfigurable;
  }

  public String getDefaultValue()
  {
    return this.defaultValue;
  }

  public String getValue()
  {
    return this.value;
  }

  public String getDescription()
  {
    return this.description;
  }

  public void setKey(int key)
  {
    this.key=key;
  }

  public void setClassId(String classId)
  {
    this.classId=classId;
  }

  public void setInstanceId(String instanceId)
  {
    this.instanceId=instanceId;
  }

  public void setId(String id)
  {
    this.id=id;
  }

  public void setCategory(String category)
  {
    this.category=category;
  }

  public void setLabel(String label)
  {
    this.label=label;
  }

  public void setType(String type)
  {
    this.type=type;
  }

  public void setUserConfigurable(Boolean userConfigurable)
  {
    this.userConfigurable=userConfigurable;
  }

  public void setDefaultValue(String defaultValue)
  {
    this.defaultValue=defaultValue;
  }

  public void setValue(String value)
  {
    this.value=value;
  }

  public void setDescription(String description)
  {
    this.description=description;
  }
}