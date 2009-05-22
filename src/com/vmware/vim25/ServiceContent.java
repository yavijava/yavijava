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

public class ServiceContent extends DynamicData
{
  public ManagedObjectReference rootFolder;
  public ManagedObjectReference propertyCollector;
  public ManagedObjectReference viewManager;
  public AboutInfo about;
  public ManagedObjectReference setting;
  public ManagedObjectReference userDirectory;
  public ManagedObjectReference sessionManager;
  public ManagedObjectReference authorizationManager;
  public ManagedObjectReference perfManager;
  public ManagedObjectReference scheduledTaskManager;
  public ManagedObjectReference alarmManager;
  public ManagedObjectReference eventManager;
  public ManagedObjectReference taskManager;
  public ManagedObjectReference extensionManager;
  public ManagedObjectReference customizationSpecManager;
  public ManagedObjectReference customFieldsManager;
  public ManagedObjectReference accountManager;
  public ManagedObjectReference diagnosticManager;
  public ManagedObjectReference licenseManager;
  public ManagedObjectReference searchIndex;
  public ManagedObjectReference fileManager;
  public ManagedObjectReference virtualDiskManager;
  public ManagedObjectReference virtualizationManager;
  public ManagedObjectReference snmpSystem;
  public ManagedObjectReference vmProvisioningChecker;
  public ManagedObjectReference vmCompatibilityChecker;
  public ManagedObjectReference ovfManager;
  public ManagedObjectReference ipPoolManager;
  public ManagedObjectReference dvSwitchManager;
  public ManagedObjectReference hostProfileManager;
  public ManagedObjectReference clusterProfileManager;
  public ManagedObjectReference complianceManager;
  public ManagedObjectReference localizationManager;

  public ManagedObjectReference getRootFolder()
  {
    return this.rootFolder;
  }

  public ManagedObjectReference getPropertyCollector()
  {
    return this.propertyCollector;
  }

  public ManagedObjectReference getViewManager()
  {
    return this.viewManager;
  }

  public AboutInfo getAbout()
  {
    return this.about;
  }

  public ManagedObjectReference getSetting()
  {
    return this.setting;
  }

  public ManagedObjectReference getUserDirectory()
  {
    return this.userDirectory;
  }

  public ManagedObjectReference getSessionManager()
  {
    return this.sessionManager;
  }

  public ManagedObjectReference getAuthorizationManager()
  {
    return this.authorizationManager;
  }

  public ManagedObjectReference getPerfManager()
  {
    return this.perfManager;
  }

  public ManagedObjectReference getScheduledTaskManager()
  {
    return this.scheduledTaskManager;
  }

  public ManagedObjectReference getAlarmManager()
  {
    return this.alarmManager;
  }

  public ManagedObjectReference getEventManager()
  {
    return this.eventManager;
  }

  public ManagedObjectReference getTaskManager()
  {
    return this.taskManager;
  }

  public ManagedObjectReference getExtensionManager()
  {
    return this.extensionManager;
  }

  public ManagedObjectReference getCustomizationSpecManager()
  {
    return this.customizationSpecManager;
  }

  public ManagedObjectReference getCustomFieldsManager()
  {
    return this.customFieldsManager;
  }

  public ManagedObjectReference getAccountManager()
  {
    return this.accountManager;
  }

  public ManagedObjectReference getDiagnosticManager()
  {
    return this.diagnosticManager;
  }

  public ManagedObjectReference getLicenseManager()
  {
    return this.licenseManager;
  }

  public ManagedObjectReference getSearchIndex()
  {
    return this.searchIndex;
  }

  public ManagedObjectReference getFileManager()
  {
    return this.fileManager;
  }

  public ManagedObjectReference getVirtualDiskManager()
  {
    return this.virtualDiskManager;
  }

  public ManagedObjectReference getVirtualizationManager()
  {
    return this.virtualizationManager;
  }

  public ManagedObjectReference getSnmpSystem()
  {
    return this.snmpSystem;
  }

  public ManagedObjectReference getVmProvisioningChecker()
  {
    return this.vmProvisioningChecker;
  }

  public ManagedObjectReference getVmCompatibilityChecker()
  {
    return this.vmCompatibilityChecker;
  }

  public ManagedObjectReference getOvfManager()
  {
    return this.ovfManager;
  }

  public ManagedObjectReference getIpPoolManager()
  {
    return this.ipPoolManager;
  }

  public ManagedObjectReference getDvSwitchManager()
  {
    return this.dvSwitchManager;
  }

  public ManagedObjectReference getHostProfileManager()
  {
    return this.hostProfileManager;
  }

  public ManagedObjectReference getClusterProfileManager()
  {
    return this.clusterProfileManager;
  }

  public ManagedObjectReference getComplianceManager()
  {
    return this.complianceManager;
  }

  public ManagedObjectReference getLocalizationManager()
  {
    return this.localizationManager;
  }

  public void setRootFolder(ManagedObjectReference rootFolder)
  {
    this.rootFolder=rootFolder;
  }

  public void setPropertyCollector(ManagedObjectReference propertyCollector)
  {
    this.propertyCollector=propertyCollector;
  }

  public void setViewManager(ManagedObjectReference viewManager)
  {
    this.viewManager=viewManager;
  }

  public void setAbout(AboutInfo about)
  {
    this.about=about;
  }

  public void setSetting(ManagedObjectReference setting)
  {
    this.setting=setting;
  }

  public void setUserDirectory(ManagedObjectReference userDirectory)
  {
    this.userDirectory=userDirectory;
  }

  public void setSessionManager(ManagedObjectReference sessionManager)
  {
    this.sessionManager=sessionManager;
  }

  public void setAuthorizationManager(ManagedObjectReference authorizationManager)
  {
    this.authorizationManager=authorizationManager;
  }

  public void setPerfManager(ManagedObjectReference perfManager)
  {
    this.perfManager=perfManager;
  }

  public void setScheduledTaskManager(ManagedObjectReference scheduledTaskManager)
  {
    this.scheduledTaskManager=scheduledTaskManager;
  }

  public void setAlarmManager(ManagedObjectReference alarmManager)
  {
    this.alarmManager=alarmManager;
  }

  public void setEventManager(ManagedObjectReference eventManager)
  {
    this.eventManager=eventManager;
  }

  public void setTaskManager(ManagedObjectReference taskManager)
  {
    this.taskManager=taskManager;
  }

  public void setExtensionManager(ManagedObjectReference extensionManager)
  {
    this.extensionManager=extensionManager;
  }

  public void setCustomizationSpecManager(ManagedObjectReference customizationSpecManager)
  {
    this.customizationSpecManager=customizationSpecManager;
  }

  public void setCustomFieldsManager(ManagedObjectReference customFieldsManager)
  {
    this.customFieldsManager=customFieldsManager;
  }

  public void setAccountManager(ManagedObjectReference accountManager)
  {
    this.accountManager=accountManager;
  }

  public void setDiagnosticManager(ManagedObjectReference diagnosticManager)
  {
    this.diagnosticManager=diagnosticManager;
  }

  public void setLicenseManager(ManagedObjectReference licenseManager)
  {
    this.licenseManager=licenseManager;
  }

  public void setSearchIndex(ManagedObjectReference searchIndex)
  {
    this.searchIndex=searchIndex;
  }

  public void setFileManager(ManagedObjectReference fileManager)
  {
    this.fileManager=fileManager;
  }

  public void setVirtualDiskManager(ManagedObjectReference virtualDiskManager)
  {
    this.virtualDiskManager=virtualDiskManager;
  }

  public void setVirtualizationManager(ManagedObjectReference virtualizationManager)
  {
    this.virtualizationManager=virtualizationManager;
  }

  public void setSnmpSystem(ManagedObjectReference snmpSystem)
  {
    this.snmpSystem=snmpSystem;
  }

  public void setVmProvisioningChecker(ManagedObjectReference vmProvisioningChecker)
  {
    this.vmProvisioningChecker=vmProvisioningChecker;
  }

  public void setVmCompatibilityChecker(ManagedObjectReference vmCompatibilityChecker)
  {
    this.vmCompatibilityChecker=vmCompatibilityChecker;
  }

  public void setOvfManager(ManagedObjectReference ovfManager)
  {
    this.ovfManager=ovfManager;
  }

  public void setIpPoolManager(ManagedObjectReference ipPoolManager)
  {
    this.ipPoolManager=ipPoolManager;
  }

  public void setDvSwitchManager(ManagedObjectReference dvSwitchManager)
  {
    this.dvSwitchManager=dvSwitchManager;
  }

  public void setHostProfileManager(ManagedObjectReference hostProfileManager)
  {
    this.hostProfileManager=hostProfileManager;
  }

  public void setClusterProfileManager(ManagedObjectReference clusterProfileManager)
  {
    this.clusterProfileManager=clusterProfileManager;
  }

  public void setComplianceManager(ManagedObjectReference complianceManager)
  {
    this.complianceManager=complianceManager;
  }

  public void setLocalizationManager(ManagedObjectReference localizationManager)
  {
    this.localizationManager=localizationManager;
  }
}