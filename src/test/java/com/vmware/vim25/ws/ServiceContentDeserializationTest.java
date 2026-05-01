package com.vmware.vim25.ws;

import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ServiceContent;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Regression tests for ServiceContent deserialization against captured
 * vCenter SOAP responses. Each manager MOR present in the response must
 * round-trip into the corresponding ServiceContent field.
 *
 * Captured vCenter 9.0.0 RetrieveServiceContent response is at
 * {@code src/test/java/com/vmware/vim25/ws/xml/RetrieveServiceContentResponse_9_0.xml}.
 */
public class ServiceContentDeserializationTest {

    private ServiceContent parseFixture(String fixturePath) throws Exception {
        InputStream is = new FileInputStream(new File(fixturePath));
        XmlGenDom xmlGenDom = new XmlGenDom();
        Object obj = xmlGenDom.fromXML("ServiceContent", is);
        assertNotNull("fromXML returned null", obj);
        return (ServiceContent) obj;
    }

    private void assertMor(ServiceContent sc, String fieldName, String expectedType, String expectedVal,
                           ManagedObjectReference actual) {
        assertNotNull(
            "ServiceContent." + fieldName + " was null after deserialization — "
                + "the SOAP response contained <" + fieldName + " type=\"" + expectedType + "\">" + expectedVal + "</" + fieldName + ">. "
                + "This usually means XmlGenDom.fromXml is silently dropping the field.",
            actual);
        assertEquals(fieldName + ".type", expectedType, actual.getType());
        assertEquals(fieldName + ".val", expectedVal, actual.getVal());
    }

    @Test
    public void allManagerMorsFromVcenter9_0_DeserializeIntoServiceContent() throws Exception {
        ServiceContent sc = parseFixture(
            "src/test/java/com/vmware/vim25/ws/xml/RetrieveServiceContentResponse_9_0.xml");

        // Every MOR child of <returnval> in the captured 9.0 response must
        // populate the corresponding field on ServiceContent.
        assertMor(sc, "rootFolder", "Folder", "group-d1", sc.getRootFolder());
        assertMor(sc, "propertyCollector", "PropertyCollector", "propertyCollector", sc.getPropertyCollector());
        assertMor(sc, "viewManager", "ViewManager", "ViewManager", sc.getViewManager());
        assertMor(sc, "setting", "OptionManager", "VpxSettings", sc.getSetting());
        assertMor(sc, "userDirectory", "UserDirectory", "UserDirectory", sc.getUserDirectory());
        assertMor(sc, "sessionManager", "SessionManager", "SessionManager", sc.getSessionManager());
        assertMor(sc, "authorizationManager", "AuthorizationManager", "AuthorizationManager", sc.getAuthorizationManager());
        assertMor(sc, "serviceManager", "ServiceManager", "ServiceMgr", sc.getServiceManager());
        assertMor(sc, "perfManager", "PerformanceManager", "PerfMgr", sc.getPerfManager());
        assertMor(sc, "scheduledTaskManager", "ScheduledTaskManager", "ScheduledTaskManager", sc.getScheduledTaskManager());
        assertMor(sc, "alarmManager", "AlarmManager", "AlarmManager", sc.getAlarmManager());
        assertMor(sc, "eventManager", "EventManager", "EventManager", sc.getEventManager());
        assertMor(sc, "taskManager", "TaskManager", "TaskManager", sc.getTaskManager());
        assertMor(sc, "extensionManager", "ExtensionManager", "ExtensionManager", sc.getExtensionManager());
        assertMor(sc, "customizationSpecManager", "CustomizationSpecManager", "CustomizationSpecManager", sc.getCustomizationSpecManager());
        assertMor(sc, "guestCustomizationManager", "VirtualMachineGuestCustomizationManager", "GuestCustomizationManager", sc.getGuestCustomizationManager());
        assertMor(sc, "customFieldsManager", "CustomFieldsManager", "CustomFieldsManager", sc.getCustomFieldsManager());
        assertMor(sc, "diagnosticManager", "DiagnosticManager", "DiagMgr", sc.getDiagnosticManager());
        assertMor(sc, "licenseManager", "LicenseManager", "LicenseManager", sc.getLicenseManager());
        assertMor(sc, "searchIndex", "SearchIndex", "SearchIndex", sc.getSearchIndex());
        assertMor(sc, "fileManager", "FileManager", "FileManager", sc.getFileManager());
        assertMor(sc, "datastoreNamespaceManager", "DatastoreNamespaceManager", "DatastoreNamespaceManager", sc.getDatastoreNamespaceManager());
        assertMor(sc, "virtualDiskManager", "VirtualDiskManager", "virtualDiskManager", sc.getVirtualDiskManager());
        assertMor(sc, "snmpSystem", "HostSnmpSystem", "SnmpSystem", sc.getSnmpSystem());
        assertMor(sc, "vmProvisioningChecker", "VirtualMachineProvisioningChecker", "ProvChecker", sc.getVmProvisioningChecker());
        assertMor(sc, "vmCompatibilityChecker", "VirtualMachineCompatibilityChecker", "CompatChecker", sc.getVmCompatibilityChecker());
        assertMor(sc, "ovfManager", "OvfManager", "OvfManager", sc.getOvfManager());
        assertMor(sc, "ipPoolManager", "IpPoolManager", "IpPoolManager", sc.getIpPoolManager());
        assertMor(sc, "dvSwitchManager", "DistributedVirtualSwitchManager", "DVSManager", sc.getDvSwitchManager());
        assertMor(sc, "hostProfileManager", "HostProfileManager", "HostProfileManager", sc.getHostProfileManager());
        assertMor(sc, "clusterProfileManager", "ClusterProfileManager", "ClusterProfileManager", sc.getClusterProfileManager());
        assertMor(sc, "complianceManager", "ProfileComplianceManager", "MoComplianceManager", sc.getComplianceManager());
        assertMor(sc, "localizationManager", "LocalizationManager", "LocalizationManager", sc.getLocalizationManager());
        assertMor(sc, "storageResourceManager", "StorageResourceManager", "StorageResourceManager", sc.getStorageResourceManager());
        assertMor(sc, "guestOperationsManager", "GuestOperationsManager", "guestOperationsManager", sc.getGuestOperationsManager());
        assertMor(sc, "overheadMemoryManager", "OverheadMemoryManager", "OverheadMemoryManager", sc.getOverheadMemoryManager());
        assertMor(sc, "certificateManager", "CertificateManager", "certificateManager", sc.getCertificateManager());
        assertMor(sc, "ioFilterManager", "IoFilterManager", "IoFilterManager", sc.getIoFilterManager());
        assertMor(sc, "vStorageObjectManager", "VcenterVStorageObjectManager", "VStorageObjectManager", sc.getVStorageObjectManager());
        assertMor(sc, "hostSpecManager", "HostSpecificationManager", "HostSpecificationManager", sc.getHostSpecManager());
        assertMor(sc, "cryptoManager", "CryptoManagerKmip", "CryptoManager", sc.getCryptoManager());
        assertMor(sc, "healthUpdateManager", "HealthUpdateManager", "HealthUpdateManager", sc.getHealthUpdateManager());
        assertMor(sc, "failoverClusterConfigurator", "FailoverClusterConfigurator", "FailoverClusterConfigurator", sc.getFailoverClusterConfigurator());
        assertMor(sc, "failoverClusterManager", "FailoverClusterManager", "FailoverClusterManager", sc.getFailoverClusterManager());
        assertMor(sc, "tenantManager", "TenantTenantManager", "TenantManager-24580438", sc.getTenantManager());
        assertMor(sc, "siteInfoManager", "SiteInfoManager", "SiteInfoManager", sc.getSiteInfoManager());
        assertMor(sc, "storageQueryManager", "StorageQueryManager", "StorageQueryManager", sc.getStorageQueryManager());
        assertMor(sc, "directPathProfileManager", "DirectPathProfileManager", "DirectPathProfileMgr", sc.getDirectPathProfileManager());

        assertNotNull("about should be deserialized", sc.getAbout());
        assertEquals("VMware vCenter Server", sc.getAbout().getName());
        assertEquals("9.0.0", sc.getAbout().getVersion());
    }
}
