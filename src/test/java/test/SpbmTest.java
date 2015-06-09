package test;
import java.net.URL;

import com.vmware.spbm.PbmCapabilityMetadataPerCategory;
import com.vmware.spbm.PbmCapabilityVendorNamespaceInfo;
import com.vmware.spbm.PbmCapabilityVendorResourceTypeInfo;
import com.vmware.spbm.PbmProfile;
import com.vmware.spbm.PbmProfileCategoryEnum;
import com.vmware.spbm.PbmProfileId;
import com.vmware.spbm.PbmProfileResourceType;
import com.vmware.spbm.PbmProfileResourceTypeEnum;
import com.vmware.spbm.mo.PbmServiceInstance;


public class SpbmTest {
	public static void main(String[] args) {
		try {

			/*
		    final URL url = new URL("https", "vcserver60atoka.int.fusionio.com", "/sdk");
			ServiceInstance si = new ServiceInstance(url, "vsphere.local\\administrator", "vmware", true);
			si.currentTime();

			String cookieVal = si.getServerConnection().getSessionStr();
			String[] tokens = cookieVal.split(";");
			tokens = tokens[0].split("=");
			String extractedCookie = tokens[1];

			System.out.println("COOKIE: " + extractedCookie);
			//PbmServiceInstance pbmSi = new PbmServiceInstance(pbmUrl, extractedCookie, true);
			 */

			final URL pbmUrl = new URL("https", "vcserver60atoka.int.fusionio.com", "/pbm");
			//final URL pbmUrl = new URL("https", "127.0.0.1", 1545, "/pbm");
            PbmServiceInstance pbmSi = new PbmServiceInstance(pbmUrl, "536836432c4f93fb3c0ca272e415af85072f681e", true);
            PbmProfileResourceType resourceType = new PbmProfileResourceType();
            resourceType.setResourceType(PbmProfileResourceTypeEnum.STORAGE.toString());

            PbmCapabilityMetadataPerCategory[] PbmCapabilityMetadataPerCategory = pbmSi.getProfileManager().pbmFetchCapabilityMetadata(resourceType, "com.vmware.iofilters");

            PbmProfileResourceType[] PbmProfileResourceTypes = pbmSi.getProfileManager().pbmFetchResourceType();
			for (PbmProfileResourceType pbmProfileResourceType : PbmProfileResourceTypes) {
				System.out.println(pbmProfileResourceType.resourceType);
			}

			/*
			PbmCapabilityVendorResourceTypeInfo[] pbmCapabilityVendorResourceTypeInfos = pbmSi.getProfileManager().pbmFetchVendorInfo(PbmProfileResourceTypes[0]);
			for (PbmCapabilityVendorResourceTypeInfo pbmCapabilityVendorResourceTypeInfo : pbmCapabilityVendorResourceTypeInfos) {
				System.out.println(pbmCapabilityVendorResourceTypeInfo.resourceType);
				PbmCapabilityVendorNamespaceInfo[] PbmCapabilityVendorNamespaceInfos = pbmCapabilityVendorResourceTypeInfo.vendorNamespaceInfo;
				for (PbmCapabilityVendorNamespaceInfo pbmCapabilityVendorNamespaceInfo : PbmCapabilityVendorNamespaceInfos) {
					System.out.println(pbmCapabilityVendorNamespaceInfo.namespaceInfo.namespace);
					System.out.println(pbmCapabilityVendorNamespaceInfo.namespaceInfo.version);
					System.out.println(pbmCapabilityVendorNamespaceInfo.vendorInfo.vendorUuid);
					System.out.println(pbmCapabilityVendorNamespaceInfo.vendorInfo.info.key);
					System.out.println(pbmCapabilityVendorNamespaceInfo.vendorInfo.info.label);
					System.out.println(pbmCapabilityVendorNamespaceInfo.vendorInfo.info.messageCatalogKeyPrefix);
					System.out.println(pbmCapabilityVendorNamespaceInfo.vendorInfo.info.summary);
				}
			}
*/

			//com.vmware.iofilters
            PbmProfileId[]  profileIds = pbmSi.getProfileManager().pbmQueryProfile(PbmProfileResourceTypes[0], PbmProfileCategoryEnum.REQUIREMENT.toString());
            for (PbmProfileId pbmProfileId : profileIds) {
                System.out.println("pbmProfileId.uniqueId: " + pbmProfileId.uniqueId);
                System.out.println();
                System.out.println();
            }

            System.out.println();
            System.out.println();

            PbmProfile[] pbmProfiles = pbmSi.getProfileManager().pbmRetrieveContent(profileIds);
            for (PbmProfile pbmProfile : pbmProfiles) {
                System.out.println("pbmProfile.getName(): " + pbmProfile.name);
                System.out.println("pbmProfile.getDescription(): " + pbmProfile.description);
                System.out.println("pbmProfile.getCreationTime(): " + pbmProfile.creationTime);
                System.out.println("pbmProfile.getProfileId(): " + pbmProfile.profileId);
            }
			//System.out.println(PbmProfileResourceTypes.length);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}
