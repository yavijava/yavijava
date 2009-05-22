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

public class HostConfigManager extends DynamicData
{
  public ManagedObjectReference cpuScheduler;
  public ManagedObjectReference datastoreSystem;
  public ManagedObjectReference memoryManager;
  public ManagedObjectReference storageSystem;
  public ManagedObjectReference networkSystem;
  public ManagedObjectReference vmotionSystem;
  public ManagedObjectReference virtualNicManager;
  public ManagedObjectReference serviceSystem;
  public ManagedObjectReference firewallSystem;
  public ManagedObjectReference advancedOption;
  public ManagedObjectReference diagnosticSystem;
  public ManagedObjectReference autoStartManager;
  public ManagedObjectReference snmpSystem;
  public ManagedObjectReference dateTimeSystem;
  public ManagedObjectReference patchManager;
  public ManagedObjectReference bootDeviceSystem;
  public ManagedObjectReference firmwareSystem;
  public ManagedObjectReference healthStatusSystem;
  public ManagedObjectReference pciPassthruSystem;
  public ManagedObjectReference licenseManager;
  public ManagedObjectReference kernelModuleSystem;

  public ManagedObjectReference getCpuScheduler()
  {
    return this.cpuScheduler;
  }

  public ManagedObjectReference getDatastoreSystem()
  {
    return this.datastoreSystem;
  }

  public ManagedObjectReference getMemoryManager()
  {
    return this.memoryManager;
  }

  public ManagedObjectReference getStorageSystem()
  {
    return this.storageSystem;
  }

  public ManagedObjectReference getNetworkSystem()
  {
    return this.networkSystem;
  }

  public ManagedObjectReference getVmotionSystem()
  {
    return this.vmotionSystem;
  }

  public ManagedObjectReference getVirtualNicManager()
  {
    return this.virtualNicManager;
  }

  public ManagedObjectReference getServiceSystem()
  {
    return this.serviceSystem;
  }

  public ManagedObjectReference getFirewallSystem()
  {
    return this.firewallSystem;
  }

  public ManagedObjectReference getAdvancedOption()
  {
    return this.advancedOption;
  }

  public ManagedObjectReference getDiagnosticSystem()
  {
    return this.diagnosticSystem;
  }

  public ManagedObjectReference getAutoStartManager()
  {
    return this.autoStartManager;
  }

  public ManagedObjectReference getSnmpSystem()
  {
    return this.snmpSystem;
  }

  public ManagedObjectReference getDateTimeSystem()
  {
    return this.dateTimeSystem;
  }

  public ManagedObjectReference getPatchManager()
  {
    return this.patchManager;
  }

  public ManagedObjectReference getBootDeviceSystem()
  {
    return this.bootDeviceSystem;
  }

  public ManagedObjectReference getFirmwareSystem()
  {
    return this.firmwareSystem;
  }

  public ManagedObjectReference getHealthStatusSystem()
  {
    return this.healthStatusSystem;
  }

  public ManagedObjectReference getPciPassthruSystem()
  {
    return this.pciPassthruSystem;
  }

  public ManagedObjectReference getLicenseManager()
  {
    return this.licenseManager;
  }

  public ManagedObjectReference getKernelModuleSystem()
  {
    return this.kernelModuleSystem;
  }

  public void setCpuScheduler(ManagedObjectReference cpuScheduler)
  {
    this.cpuScheduler=cpuScheduler;
  }

  public void setDatastoreSystem(ManagedObjectReference datastoreSystem)
  {
    this.datastoreSystem=datastoreSystem;
  }

  public void setMemoryManager(ManagedObjectReference memoryManager)
  {
    this.memoryManager=memoryManager;
  }

  public void setStorageSystem(ManagedObjectReference storageSystem)
  {
    this.storageSystem=storageSystem;
  }

  public void setNetworkSystem(ManagedObjectReference networkSystem)
  {
    this.networkSystem=networkSystem;
  }

  public void setVmotionSystem(ManagedObjectReference vmotionSystem)
  {
    this.vmotionSystem=vmotionSystem;
  }

  public void setVirtualNicManager(ManagedObjectReference virtualNicManager)
  {
    this.virtualNicManager=virtualNicManager;
  }

  public void setServiceSystem(ManagedObjectReference serviceSystem)
  {
    this.serviceSystem=serviceSystem;
  }

  public void setFirewallSystem(ManagedObjectReference firewallSystem)
  {
    this.firewallSystem=firewallSystem;
  }

  public void setAdvancedOption(ManagedObjectReference advancedOption)
  {
    this.advancedOption=advancedOption;
  }

  public void setDiagnosticSystem(ManagedObjectReference diagnosticSystem)
  {
    this.diagnosticSystem=diagnosticSystem;
  }

  public void setAutoStartManager(ManagedObjectReference autoStartManager)
  {
    this.autoStartManager=autoStartManager;
  }

  public void setSnmpSystem(ManagedObjectReference snmpSystem)
  {
    this.snmpSystem=snmpSystem;
  }

  public void setDateTimeSystem(ManagedObjectReference dateTimeSystem)
  {
    this.dateTimeSystem=dateTimeSystem;
  }

  public void setPatchManager(ManagedObjectReference patchManager)
  {
    this.patchManager=patchManager;
  }

  public void setBootDeviceSystem(ManagedObjectReference bootDeviceSystem)
  {
    this.bootDeviceSystem=bootDeviceSystem;
  }

  public void setFirmwareSystem(ManagedObjectReference firmwareSystem)
  {
    this.firmwareSystem=firmwareSystem;
  }

  public void setHealthStatusSystem(ManagedObjectReference healthStatusSystem)
  {
    this.healthStatusSystem=healthStatusSystem;
  }

  public void setPciPassthruSystem(ManagedObjectReference pciPassthruSystem)
  {
    this.pciPassthruSystem=pciPassthruSystem;
  }

  public void setLicenseManager(ManagedObjectReference licenseManager)
  {
    this.licenseManager=licenseManager;
  }

  public void setKernelModuleSystem(ManagedObjectReference kernelModuleSystem)
  {
    this.kernelModuleSystem=kernelModuleSystem;
  }
}