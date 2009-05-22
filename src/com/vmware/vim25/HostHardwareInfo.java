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

public class HostHardwareInfo extends DynamicData
{
  public HostSystemInfo systemInfo;
  public HostCpuPowerManagementInfo cpuPowerManagementInfo;
  public HostCpuInfo cpuInfo;
  public HostCpuPackage[] cpuPkg;
  public long memorySize;
  public HostNumaInfo numaInfo;
  public HostPciDevice[] pciDevice;
  public HostCpuIdInfo[] cpuFeature;
  public HostBIOSInfo biosInfo;

  public HostSystemInfo getSystemInfo()
  {
    return this.systemInfo;
  }

  public HostCpuPowerManagementInfo getCpuPowerManagementInfo()
  {
    return this.cpuPowerManagementInfo;
  }

  public HostCpuInfo getCpuInfo()
  {
    return this.cpuInfo;
  }

  public HostCpuPackage[] getCpuPkg()
  {
    return this.cpuPkg;
  }

  public long getMemorySize()
  {
    return this.memorySize;
  }

  public HostNumaInfo getNumaInfo()
  {
    return this.numaInfo;
  }

  public HostPciDevice[] getPciDevice()
  {
    return this.pciDevice;
  }

  public HostCpuIdInfo[] getCpuFeature()
  {
    return this.cpuFeature;
  }

  public HostBIOSInfo getBiosInfo()
  {
    return this.biosInfo;
  }

  public void setSystemInfo(HostSystemInfo systemInfo)
  {
    this.systemInfo=systemInfo;
  }

  public void setCpuPowerManagementInfo(HostCpuPowerManagementInfo cpuPowerManagementInfo)
  {
    this.cpuPowerManagementInfo=cpuPowerManagementInfo;
  }

  public void setCpuInfo(HostCpuInfo cpuInfo)
  {
    this.cpuInfo=cpuInfo;
  }

  public void setCpuPkg(HostCpuPackage[] cpuPkg)
  {
    this.cpuPkg=cpuPkg;
  }

  public void setMemorySize(long memorySize)
  {
    this.memorySize=memorySize;
  }

  public void setNumaInfo(HostNumaInfo numaInfo)
  {
    this.numaInfo=numaInfo;
  }

  public void setPciDevice(HostPciDevice[] pciDevice)
  {
    this.pciDevice=pciDevice;
  }

  public void setCpuFeature(HostCpuIdInfo[] cpuFeature)
  {
    this.cpuFeature=cpuFeature;
  }

  public void setBiosInfo(HostBIOSInfo biosInfo)
  {
    this.biosInfo=biosInfo;
  }
}