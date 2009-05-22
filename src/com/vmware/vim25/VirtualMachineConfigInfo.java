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

public class VirtualMachineConfigInfo extends DynamicData
{
  public String changeVersion;
  public Calendar modified;
  public String name;
  public String guestFullName;
  public String version;
  public String uuid;
  public String instanceUuid;
  public long[] npivNodeWorldWideName;
  public long[] npivPortWorldWideName;
  public String npivWorldWideNameType;
  public Short npivDesiredNodeWwns;
  public Short npivDesiredPortWwns;
  public Boolean npivTemporaryDisabled;
  public Boolean npivOnNonRdmDisks;
  public String locationId;
  public boolean template;
  public String guestId;
  public String alternateGuestName;
  public String annotation;
  public VirtualMachineFileInfo files;
  public ToolsConfigInfo tools;
  public VirtualMachineFlagInfo flags;
  public VirtualMachineConsolePreferences consolePreferences;
  public VirtualMachineDefaultPowerOpInfo defaultPowerOps;
  public VirtualHardware hardware;
  public ResourceAllocationInfo cpuAllocation;
  public ResourceAllocationInfo memoryAllocation;
  public Boolean memoryHotAddEnabled;
  public Boolean cpuHotAddEnabled;
  public Boolean cpuHotRemoveEnabled;
  public Long hotPlugMemoryLimit;
  public Long hotPlugMemoryIncrementSize;
  public VirtualMachineAffinityInfo cpuAffinity;
  public VirtualMachineAffinityInfo memoryAffinity;
  public VirtualMachineNetworkShaperInfo networkShaper;
  public OptionValue[] extraConfig;
  public HostCpuIdInfo[] cpuFeatureMask;
  public VirtualMachineConfigInfoDatastoreUrlPair[] datastoreUrl;
  public String swapPlacement;
  public VirtualMachineBootOptions bootOptions;
  public FaultToleranceConfigInfo ftInfo;
  public VmConfigInfo vAppConfig;
  public Boolean vAssertsEnabled;
  public Boolean changeTrackingEnabled;

  public String getChangeVersion()
  {
    return this.changeVersion;
  }

  public Calendar getModified()
  {
    return this.modified;
  }

  public String getName()
  {
    return this.name;
  }

  public String getGuestFullName()
  {
    return this.guestFullName;
  }

  public String getVersion()
  {
    return this.version;
  }

  public String getUuid()
  {
    return this.uuid;
  }

  public String getInstanceUuid()
  {
    return this.instanceUuid;
  }

  public long[] getNpivNodeWorldWideName()
  {
    return this.npivNodeWorldWideName;
  }

  public long[] getNpivPortWorldWideName()
  {
    return this.npivPortWorldWideName;
  }

  public String getNpivWorldWideNameType()
  {
    return this.npivWorldWideNameType;
  }

  public Short getNpivDesiredNodeWwns()
  {
    return this.npivDesiredNodeWwns;
  }

  public Short getNpivDesiredPortWwns()
  {
    return this.npivDesiredPortWwns;
  }

  public Boolean getNpivTemporaryDisabled()
  {
    return this.npivTemporaryDisabled;
  }

  public Boolean getNpivOnNonRdmDisks()
  {
    return this.npivOnNonRdmDisks;
  }

  public String getLocationId()
  {
    return this.locationId;
  }

  public boolean isTemplate()
  {
    return this.template;
  }

  public String getGuestId()
  {
    return this.guestId;
  }

  public String getAlternateGuestName()
  {
    return this.alternateGuestName;
  }

  public String getAnnotation()
  {
    return this.annotation;
  }

  public VirtualMachineFileInfo getFiles()
  {
    return this.files;
  }

  public ToolsConfigInfo getTools()
  {
    return this.tools;
  }

  public VirtualMachineFlagInfo getFlags()
  {
    return this.flags;
  }

  public VirtualMachineConsolePreferences getConsolePreferences()
  {
    return this.consolePreferences;
  }

  public VirtualMachineDefaultPowerOpInfo getDefaultPowerOps()
  {
    return this.defaultPowerOps;
  }

  public VirtualHardware getHardware()
  {
    return this.hardware;
  }

  public ResourceAllocationInfo getCpuAllocation()
  {
    return this.cpuAllocation;
  }

  public ResourceAllocationInfo getMemoryAllocation()
  {
    return this.memoryAllocation;
  }

  public Boolean getMemoryHotAddEnabled()
  {
    return this.memoryHotAddEnabled;
  }

  public Boolean getCpuHotAddEnabled()
  {
    return this.cpuHotAddEnabled;
  }

  public Boolean getCpuHotRemoveEnabled()
  {
    return this.cpuHotRemoveEnabled;
  }

  public Long getHotPlugMemoryLimit()
  {
    return this.hotPlugMemoryLimit;
  }

  public Long getHotPlugMemoryIncrementSize()
  {
    return this.hotPlugMemoryIncrementSize;
  }

  public VirtualMachineAffinityInfo getCpuAffinity()
  {
    return this.cpuAffinity;
  }

  public VirtualMachineAffinityInfo getMemoryAffinity()
  {
    return this.memoryAffinity;
  }

  public VirtualMachineNetworkShaperInfo getNetworkShaper()
  {
    return this.networkShaper;
  }

  public OptionValue[] getExtraConfig()
  {
    return this.extraConfig;
  }

  public HostCpuIdInfo[] getCpuFeatureMask()
  {
    return this.cpuFeatureMask;
  }

  public VirtualMachineConfigInfoDatastoreUrlPair[] getDatastoreUrl()
  {
    return this.datastoreUrl;
  }

  public String getSwapPlacement()
  {
    return this.swapPlacement;
  }

  public VirtualMachineBootOptions getBootOptions()
  {
    return this.bootOptions;
  }

  public FaultToleranceConfigInfo getFtInfo()
  {
    return this.ftInfo;
  }

  public VmConfigInfo getVAppConfig()
  {
    return this.vAppConfig;
  }

  public Boolean getVAssertsEnabled()
  {
    return this.vAssertsEnabled;
  }

  public Boolean getChangeTrackingEnabled()
  {
    return this.changeTrackingEnabled;
  }

  public void setChangeVersion(String changeVersion)
  {
    this.changeVersion=changeVersion;
  }

  public void setModified(Calendar modified)
  {
    this.modified=modified;
  }

  public void setName(String name)
  {
    this.name=name;
  }

  public void setGuestFullName(String guestFullName)
  {
    this.guestFullName=guestFullName;
  }

  public void setVersion(String version)
  {
    this.version=version;
  }

  public void setUuid(String uuid)
  {
    this.uuid=uuid;
  }

  public void setInstanceUuid(String instanceUuid)
  {
    this.instanceUuid=instanceUuid;
  }

  public void setNpivNodeWorldWideName(long[] npivNodeWorldWideName)
  {
    this.npivNodeWorldWideName=npivNodeWorldWideName;
  }

  public void setNpivPortWorldWideName(long[] npivPortWorldWideName)
  {
    this.npivPortWorldWideName=npivPortWorldWideName;
  }

  public void setNpivWorldWideNameType(String npivWorldWideNameType)
  {
    this.npivWorldWideNameType=npivWorldWideNameType;
  }

  public void setNpivDesiredNodeWwns(Short npivDesiredNodeWwns)
  {
    this.npivDesiredNodeWwns=npivDesiredNodeWwns;
  }

  public void setNpivDesiredPortWwns(Short npivDesiredPortWwns)
  {
    this.npivDesiredPortWwns=npivDesiredPortWwns;
  }

  public void setNpivTemporaryDisabled(Boolean npivTemporaryDisabled)
  {
    this.npivTemporaryDisabled=npivTemporaryDisabled;
  }

  public void setNpivOnNonRdmDisks(Boolean npivOnNonRdmDisks)
  {
    this.npivOnNonRdmDisks=npivOnNonRdmDisks;
  }

  public void setLocationId(String locationId)
  {
    this.locationId=locationId;
  }

  public void setTemplate(boolean template)
  {
    this.template=template;
  }

  public void setGuestId(String guestId)
  {
    this.guestId=guestId;
  }

  public void setAlternateGuestName(String alternateGuestName)
  {
    this.alternateGuestName=alternateGuestName;
  }

  public void setAnnotation(String annotation)
  {
    this.annotation=annotation;
  }

  public void setFiles(VirtualMachineFileInfo files)
  {
    this.files=files;
  }

  public void setTools(ToolsConfigInfo tools)
  {
    this.tools=tools;
  }

  public void setFlags(VirtualMachineFlagInfo flags)
  {
    this.flags=flags;
  }

  public void setConsolePreferences(VirtualMachineConsolePreferences consolePreferences)
  {
    this.consolePreferences=consolePreferences;
  }

  public void setDefaultPowerOps(VirtualMachineDefaultPowerOpInfo defaultPowerOps)
  {
    this.defaultPowerOps=defaultPowerOps;
  }

  public void setHardware(VirtualHardware hardware)
  {
    this.hardware=hardware;
  }

  public void setCpuAllocation(ResourceAllocationInfo cpuAllocation)
  {
    this.cpuAllocation=cpuAllocation;
  }

  public void setMemoryAllocation(ResourceAllocationInfo memoryAllocation)
  {
    this.memoryAllocation=memoryAllocation;
  }

  public void setMemoryHotAddEnabled(Boolean memoryHotAddEnabled)
  {
    this.memoryHotAddEnabled=memoryHotAddEnabled;
  }

  public void setCpuHotAddEnabled(Boolean cpuHotAddEnabled)
  {
    this.cpuHotAddEnabled=cpuHotAddEnabled;
  }

  public void setCpuHotRemoveEnabled(Boolean cpuHotRemoveEnabled)
  {
    this.cpuHotRemoveEnabled=cpuHotRemoveEnabled;
  }

  public void setHotPlugMemoryLimit(Long hotPlugMemoryLimit)
  {
    this.hotPlugMemoryLimit=hotPlugMemoryLimit;
  }

  public void setHotPlugMemoryIncrementSize(Long hotPlugMemoryIncrementSize)
  {
    this.hotPlugMemoryIncrementSize=hotPlugMemoryIncrementSize;
  }

  public void setCpuAffinity(VirtualMachineAffinityInfo cpuAffinity)
  {
    this.cpuAffinity=cpuAffinity;
  }

  public void setMemoryAffinity(VirtualMachineAffinityInfo memoryAffinity)
  {
    this.memoryAffinity=memoryAffinity;
  }

  public void setNetworkShaper(VirtualMachineNetworkShaperInfo networkShaper)
  {
    this.networkShaper=networkShaper;
  }

  public void setExtraConfig(OptionValue[] extraConfig)
  {
    this.extraConfig=extraConfig;
  }

  public void setCpuFeatureMask(HostCpuIdInfo[] cpuFeatureMask)
  {
    this.cpuFeatureMask=cpuFeatureMask;
  }

  public void setDatastoreUrl(VirtualMachineConfigInfoDatastoreUrlPair[] datastoreUrl)
  {
    this.datastoreUrl=datastoreUrl;
  }

  public void setSwapPlacement(String swapPlacement)
  {
    this.swapPlacement=swapPlacement;
  }

  public void setBootOptions(VirtualMachineBootOptions bootOptions)
  {
    this.bootOptions=bootOptions;
  }

  public void setFtInfo(FaultToleranceConfigInfo ftInfo)
  {
    this.ftInfo=ftInfo;
  }

  public void setVAppConfig(VmConfigInfo vAppConfig)
  {
    this.vAppConfig=vAppConfig;
  }

  public void setVAssertsEnabled(Boolean vAssertsEnabled)
  {
    this.vAssertsEnabled=vAssertsEnabled;
  }

  public void setChangeTrackingEnabled(Boolean changeTrackingEnabled)
  {
    this.changeTrackingEnabled=changeTrackingEnabled;
  }
}