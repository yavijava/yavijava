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

public class KernelModuleInfo extends DynamicData
{
  public int id;
  public String name;
  public String version;
  public String filename;
  public String optionString;
  public boolean loaded;
  public boolean enabled;
  public int useCount;
  public KernelModuleSectionInfo readOnlySection;
  public KernelModuleSectionInfo writableSection;
  public KernelModuleSectionInfo textSection;
  public KernelModuleSectionInfo dataSection;
  public KernelModuleSectionInfo bssSection;

  public int getId()
  {
    return this.id;
  }

  public String getName()
  {
    return this.name;
  }

  public String getVersion()
  {
    return this.version;
  }

  public String getFilename()
  {
    return this.filename;
  }

  public String getOptionString()
  {
    return this.optionString;
  }

  public boolean isLoaded()
  {
    return this.loaded;
  }

  public boolean isEnabled()
  {
    return this.enabled;
  }

  public int getUseCount()
  {
    return this.useCount;
  }

  public KernelModuleSectionInfo getReadOnlySection()
  {
    return this.readOnlySection;
  }

  public KernelModuleSectionInfo getWritableSection()
  {
    return this.writableSection;
  }

  public KernelModuleSectionInfo getTextSection()
  {
    return this.textSection;
  }

  public KernelModuleSectionInfo getDataSection()
  {
    return this.dataSection;
  }

  public KernelModuleSectionInfo getBssSection()
  {
    return this.bssSection;
  }

  public void setId(int id)
  {
    this.id=id;
  }

  public void setName(String name)
  {
    this.name=name;
  }

  public void setVersion(String version)
  {
    this.version=version;
  }

  public void setFilename(String filename)
  {
    this.filename=filename;
  }

  public void setOptionString(String optionString)
  {
    this.optionString=optionString;
  }

  public void setLoaded(boolean loaded)
  {
    this.loaded=loaded;
  }

  public void setEnabled(boolean enabled)
  {
    this.enabled=enabled;
  }

  public void setUseCount(int useCount)
  {
    this.useCount=useCount;
  }

  public void setReadOnlySection(KernelModuleSectionInfo readOnlySection)
  {
    this.readOnlySection=readOnlySection;
  }

  public void setWritableSection(KernelModuleSectionInfo writableSection)
  {
    this.writableSection=writableSection;
  }

  public void setTextSection(KernelModuleSectionInfo textSection)
  {
    this.textSection=textSection;
  }

  public void setDataSection(KernelModuleSectionInfo dataSection)
  {
    this.dataSection=dataSection;
  }

  public void setBssSection(KernelModuleSectionInfo bssSection)
  {
    this.bssSection=bssSection;
  }
}