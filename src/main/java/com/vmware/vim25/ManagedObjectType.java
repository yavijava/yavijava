package com.vmware.vim25;

/**
 * Created by Michael Rice on Fri Apr 24 22:47:37 CDT 2026
 * This code is auto generated using yavijava_generator
 * https://github.com/yavijava/yavijava_generator
 *
 * Copyright 2015 Michael Rice
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @since 6.0
 */

public enum ManagedObjectType {

    PropertyCollector("PropertyCollector"),
    PropertyFilter("PropertyFilter"),
    AuthorizationManager("AuthorizationManager"),
    CertificateManager("CertificateManager"),
    ClusterComputeResource("ClusterComputeResource"),
    ComputeResource("ComputeResource"),
    CustomFieldsManager("CustomFieldsManager"),
    CustomizationSpecManager("CustomizationSpecManager"),
    Datacenter("Datacenter"),
    Datastore("Datastore"),
    DatastoreNamespaceManager("DatastoreNamespaceManager"),
    DiagnosticManager("DiagnosticManager"),
    DirectPathProfileManager("DirectPathProfileManager"),
    DistributedVirtualSwitch("DistributedVirtualSwitch"),
    EnvironmentBrowser("EnvironmentBrowser"),
    ExtensibleManagedObject("ExtensibleManagedObject"),
    ExtensionManager("ExtensionManager"),
    FileManager("FileManager"),
    Folder("Folder"),
    HealthUpdateManager("HealthUpdateManager"),
    HistoryCollector("HistoryCollector"),
    HostSystem("HostSystem"),
    HttpNfcLease("HttpNfcLease"),
    IoFilterManager("IoFilterManager"),
    IpPoolManager("IpPoolManager"),
    LicenseAssignmentManager("LicenseAssignmentManager"),
    LicenseManager("LicenseManager"),
    LocalizationManager("LocalizationManager"),
    ManagedEntity("ManagedEntity"),
    Network("Network"),
    OpaqueNetwork("OpaqueNetwork"),
    OverheadMemoryManager("OverheadMemoryManager"),
    OvfManager("OvfManager"),
    PerformanceManager("PerformanceManager"),
    ResourcePlanningManager("ResourcePlanningManager"),
    ResourcePool("ResourcePool"),
    SearchIndex("SearchIndex"),
    ServiceInstance("ServiceInstance"),
    ServiceManager("ServiceManager"),
    SessionManager("SessionManager"),
    SimpleCommand("SimpleCommand"),
    SiteInfoManager("SiteInfoManager"),
    StoragePod("StoragePod"),
    StorageQueryManager("StorageQueryManager"),
    StorageResourceManager("StorageResourceManager"),
    Task("Task"),
    TaskHistoryCollector("TaskHistoryCollector"),
    TaskManager("TaskManager"),
    UserDirectory("UserDirectory"),
    VirtualApp("VirtualApp"),
    VirtualDiskManager("VirtualDiskManager"),
    VirtualMachine("VirtualMachine"),
    VirtualizationManager("VirtualizationManager"),
    VsanUpgradeSystem("VsanUpgradeSystem"),
    Alarm("Alarm"),
    AlarmManager("AlarmManager"),
    ClusterEVCManager("ClusterEVCManager"),
    DistributedVirtualPortgroup("DistributedVirtualPortgroup"),
    DistributedVirtualSwitchManager("DistributedVirtualSwitchManager"),
    VmwareDistributedVirtualSwitch("VmwareDistributedVirtualSwitch"),
    CryptoManager("CryptoManager"),
    CryptoManagerHost("CryptoManagerHost"),
    CryptoManagerHostKMS("CryptoManagerHostKMS"),
    CryptoManagerKmip("CryptoManagerKmip"),
    EventHistoryCollector("EventHistoryCollector"),
    EventManager("EventManager"),
    HostActiveDirectoryAuthentication("HostActiveDirectoryAuthentication"),
    HostAssignableHardwareManager("HostAssignableHardwareManager"),
    HostAuthenticationManager("HostAuthenticationManager"),
    HostAuthenticationStore("HostAuthenticationStore"),
    HostAutoStartManager("HostAutoStartManager"),
    HostBootDeviceSystem("HostBootDeviceSystem"),
    HostCacheConfigurationManager("HostCacheConfigurationManager"),
    HostCertificateManager("HostCertificateManager"),
    HostCpuSchedulerSystem("HostCpuSchedulerSystem"),
    HostDatastoreBrowser("HostDatastoreBrowser"),
    HostDatastoreSystem("HostDatastoreSystem"),
    HostDateTimeSystem("HostDateTimeSystem"),
    HostDiagnosticSystem("HostDiagnosticSystem"),
    HostDirectoryStore("HostDirectoryStore"),
    HostEsxAgentHostManager("HostEsxAgentHostManager"),
    HostFirewallSystem("HostFirewallSystem"),
    HostFirmwareSystem("HostFirmwareSystem"),
    HostGraphicsManager("HostGraphicsManager"),
    HostHealthStatusSystem("HostHealthStatusSystem"),
    HostAccessManager("HostAccessManager"),
    HostImageConfigManager("HostImageConfigManager"),
    IscsiManager("IscsiManager"),
    HostKernelModuleSystem("HostKernelModuleSystem"),
    HostLocalAccountManager("HostLocalAccountManager"),
    HostLocalAuthentication("HostLocalAuthentication"),
    HostMemorySystem("HostMemorySystem"),
    MessageBusProxy("MessageBusProxy"),
    HostNetworkSystem("HostNetworkSystem"),
    HostNvdimmSystem("HostNvdimmSystem"),
    HostPatchManager("HostPatchManager"),
    HostPciPassthruSystem("HostPciPassthruSystem"),
    HostPowerSystem("HostPowerSystem"),
    HostServiceSystem("HostServiceSystem"),
    HostSnmpSystem("HostSnmpSystem"),
    HostStorageSystem("HostStorageSystem"),
    HostVFlashManager("HostVFlashManager"),
    HostVMotionSystem("HostVMotionSystem"),
    HostVirtualNicManager("HostVirtualNicManager"),
    HostVsanInternalSystem("HostVsanInternalSystem"),
    HostVsanSystem("HostVsanSystem"),
    OptionManager("OptionManager"),
    ProfileComplianceManager("ProfileComplianceManager"),
    Profile("Profile"),
    ProfileManager("ProfileManager"),
    ClusterProfile("ClusterProfile"),
    ClusterProfileManager("ClusterProfileManager"),
    HostProfile("HostProfile"),
    HostSpecificationManager("HostSpecificationManager"),
    HostProfileManager("HostProfileManager"),
    ScheduledTask("ScheduledTask"),
    ScheduledTaskManager("ScheduledTaskManager"),
    TenantTenantManager("TenantTenantManager"),
    FailoverClusterConfigurator("FailoverClusterConfigurator"),
    FailoverClusterManager("FailoverClusterManager"),
    ContainerView("ContainerView"),
    InventoryView("InventoryView"),
    ListView("ListView"),
    ManagedObjectView("ManagedObjectView"),
    View("View"),
    ViewManager("ViewManager"),
    VirtualMachineGuestCustomizationManager("VirtualMachineGuestCustomizationManager"),
    VirtualMachineSnapshot("VirtualMachineSnapshot"),
    VirtualMachineCompatibilityChecker("VirtualMachineCompatibilityChecker"),
    VirtualMachineProvisioningChecker("VirtualMachineProvisioningChecker"),
    GuestAliasManager("GuestAliasManager"),
    GuestAuthManager("GuestAuthManager"),
    GuestFileManager("GuestFileManager"),
    GuestOperationsManager("GuestOperationsManager"),
    GuestProcessManager("GuestProcessManager"),
    GuestWindowsRegistryManager("GuestWindowsRegistryManager"),
    VStorageObjectManagerBase("VStorageObjectManagerBase"),
    HostVStorageObjectManager("HostVStorageObjectManager"),
    VcenterVStorageObjectManager("VcenterVStorageObjectManager");

    private String val;

    ManagedObjectType(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return this.val;
    }
}
