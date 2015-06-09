package com.vmware.spbm.ws;

import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;

import com.vmware.spbm.InvalidArgument;
import com.vmware.spbm.PbmCapabilityMetadataPerCategory;
import com.vmware.spbm.PbmCapabilityProfileCreateSpec;
import com.vmware.spbm.PbmCapabilityProfileUpdateSpec;
import com.vmware.spbm.PbmCapabilityVendorResourceTypeInfo;
import com.vmware.spbm.PbmDatastoreSpaceStatistics;
import com.vmware.spbm.PbmDefaultProfileInfo;
import com.vmware.spbm.PbmDuplicateName;
import com.vmware.spbm.PbmFault;
import com.vmware.spbm.PbmFaultProfileStorageFault;
import com.vmware.spbm.PbmLegacyHubsNotSupported;
import com.vmware.spbm.PbmNonExistentHubs;
import com.vmware.spbm.PbmPlacementHub;
import com.vmware.spbm.PbmProfile;
import com.vmware.spbm.PbmProfileId;
import com.vmware.spbm.PbmProfileOperationOutcome;
import com.vmware.spbm.PbmProfileResourceType;
import com.vmware.spbm.PbmQueryProfileResult;
import com.vmware.spbm.PbmServerObjectRef;
import com.vmware.spbm.PbmServiceInstanceContent;
import com.vmware.spbm.RuntimeFault;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ws.Argument;
import com.vmware.vim25.ws.Client;

/**
 * @author Atoka Sema
 */

public class PbmStub {

    private Client wsc = null;
    /**
     * Setup logger
     */
    private static Logger log = Logger.getLogger(PbmStub.class);

    public PbmStub(String url, String sessionStr, boolean ignoreCert) throws java.net.MalformedURLException {
        try {
            this.wsc = PbmClientCreator.getClient(url, sessionStr, ignoreCert);
        } catch (NoSuchMethodException e) {
            log.error("Error detected for url: " + url + " ignoreSSL: " + ignoreCert, e);
        } catch (IllegalAccessException e) {
            log.error("Error detected for url: " + url + " ignoreSSL: " + ignoreCert, e);
        } catch (InvocationTargetException e) {
            log.error("Error detected for url: " + url + " ignoreSSL: " + ignoreCert, e);
        } catch (InstantiationException e) {
            log.error("Error detected for url: " + url + " ignoreSSL: " + ignoreCert, e);
        }
    }

    public PbmStub(Client wsc) {
        this.wsc = wsc;
    }

    public Client getWsc() {
        return wsc;
    }

    public PbmServiceInstanceContent retrievePbmServiceInstanceContent(ManagedObjectReference _this)
            throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (PbmServiceInstanceContent) getWsc().invoke("PbmRetrieveServiceContent", paras,
                "PbmServiceInstanceContent");
    }

    public PbmCapabilityVendorResourceTypeInfo[] pbmFetchVendorInfo(ManagedObjectReference _this,
            PbmProfileResourceType resourceType) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("resourceType", "PbmProfileResourceType", resourceType);
        return (PbmCapabilityVendorResourceTypeInfo[]) getWsc().invoke("PbmFetchVendorInfo", paras,
                "PbmCapabilityVendorResourceTypeInfo[]");
    }

    public PbmProfileResourceType[] pbmFetchResourceType(ManagedObjectReference _this) throws java.rmi.RemoteException,
            RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (PbmProfileResourceType[]) getWsc().invoke("PbmFetchResourceType", paras, "PbmProfileResourceType[]");
    }

    public PbmProfileId[] pbmQueryProfile(ManagedObjectReference _this, PbmProfileResourceType resourceType,
            String profileCategory) throws java.rmi.RemoteException, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("resourceType", "PbmProfileResourceType", resourceType);
        paras[2] = new Argument("profileCategory", "String", profileCategory);
        return (PbmProfileId[]) getWsc().invoke("PbmQueryProfile", paras, "PbmProfileId[]");
    }

    public PbmProfile[] pbmRetrieveContent(ManagedObjectReference _this, PbmProfileId[] profileIds)
            throws java.rmi.RemoteException, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profileIds", "PbmProfileId[]", profileIds);
        return (PbmProfile[]) getWsc().invoke("PbmRetrieveContent", paras, "PbmProfile[]");
    }

    public PbmProfileId pbmCreate(ManagedObjectReference _this, PbmCapabilityProfileCreateSpec createSpec)
            throws java.rmi.RemoteException, InvalidArgument, PbmDuplicateName, PbmFaultProfileStorageFault,
            RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("createSpec", "PbmCapabilityProfileCreateSpec", createSpec);
        return (PbmProfileId) getWsc().invoke("PbmCreate", paras, "PbmProfileId");
    }

    public PbmProfileOperationOutcome[] pbmDelete(ManagedObjectReference _this, PbmProfileId[] profileId)
            throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("createSpec", "PbmProfileId[]", profileId);
        return (PbmProfileOperationOutcome[]) getWsc().invoke("PbmDelete", paras, "PbmProfileOperationOutcome[]");
    }

    public void pbmAssignDefaultRequirementProfile(ManagedObjectReference _this, PbmProfileId profile,
            PbmPlacementHub[] datastores) throws java.rmi.RemoteException, InvalidArgument, PbmFault,
            PbmLegacyHubsNotSupported, PbmNonExistentHubs, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profile", "PbmProfileId", profile);
        paras[2] = new Argument("datastores", "PbmPlacementHub[]", datastores);
        getWsc().invoke("PbmAssignDefaultRequirementProfile", paras, null);
    }

    public PbmCapabilityMetadataPerCategory[] pbmFetchCapabilityMetadata(ManagedObjectReference _this,
            PbmProfileResourceType resourceType, String vendorUuid) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("resourceType", "PbmProfileResourceType", resourceType);
        paras[2] = new Argument("vendorUuid", "String", vendorUuid);
        return (PbmCapabilityMetadataPerCategory[]) getWsc().invoke("PbmFetchCapabilityMetadata", paras,
                "PbmCapabilityMetadataPerCategory[]");
    }

    public PbmProfile[] pbmFindApplicableDefaultProfile(ManagedObjectReference _this, PbmPlacementHub[] datastores)
            throws java.rmi.RemoteException, InvalidArgument, PbmFault, PbmLegacyHubsNotSupported, PbmNonExistentHubs,
            RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastores", "PbmPlacementHub[]", datastores);
        return (PbmProfile[]) getWsc().invoke("PbmFindApplicableDefaultProfile", paras, "PbmProfile[]");
    }

    public PbmServerObjectRef[] PbmQueryAssociatedEntity(ManagedObjectReference _this, PbmProfileId profile, String entityType)
            throws java.rmi.RemoteException, PbmFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profile", "PbmProfileId", profile);
        paras[2] = new Argument("entityType", "String", entityType);
        return (PbmServerObjectRef[]) getWsc().invoke("PbmQueryAssociatedEntity", paras, "PbmServerObjectRef[]");
    }

    public PbmProfileId[] pbmQueryAssociatedProfile(ManagedObjectReference _this, PbmServerObjectRef entity)
            throws java.rmi.RemoteException, PbmFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "PbmServerObjectRef", entity);
        return (PbmProfileId[]) getWsc().invoke("PbmQueryAssociatedProfile", paras, "PbmProfileId[]");
    }

    public PbmQueryProfileResult[] pbmQueryAssociatedProfiles(ManagedObjectReference _this, PbmServerObjectRef[] entities)
            throws java.rmi.RemoteException, PbmFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entities", "PbmServerObjectRef[]", entities);
        return (PbmQueryProfileResult[]) getWsc().invoke("PbmQueryAssociatedProfiles", paras, "PbmQueryProfileResult[]");
    }

    public PbmProfileId pbmQueryDefaultRequirementProfile(ManagedObjectReference _this, PbmPlacementHub hub)
            throws java.rmi.RemoteException, InvalidArgument, PbmDuplicateName, PbmFaultProfileStorageFault,
            RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hub", "PbmPlacementHub", hub);
        return (PbmProfileId) getWsc().invoke("PbmQueryDefaultRequirementProfile", paras, "PbmProfileId");
    }

    public PbmDefaultProfileInfo[] pbmQueryDefaultRequirementProfiles(ManagedObjectReference _this, PbmPlacementHub[] datastores)
            throws java.rmi.RemoteException, PbmFault, PbmNonExistentHubs, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastores", "PbmPlacementHub[]", datastores);
        return (PbmDefaultProfileInfo[]) getWsc().invoke("PbmQueryDefaultRequirementProfiles", paras, "PbmDefaultProfileInfo[]");
    }

    public PbmDatastoreSpaceStatistics[] pbmQuerySpaceStatsForStorageContainer(ManagedObjectReference _this,
            PbmServerObjectRef datastore, PbmProfileId[] capabilityProfileId) throws java.rmi.RemoteException,
            InvalidArgument, PbmFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "PbmServerObjectRef", datastore);
        paras[2] = new Argument("capabilityProfileId", "PbmProfileId[]", capabilityProfileId);
        return (PbmDatastoreSpaceStatistics[]) getWsc().invoke("PbmQuerySpaceStatsForStorageContainer", paras,
                "PbmDatastoreSpaceStatistics[]");
    }

    public void pbmResetDefaultRequirementProfile(ManagedObjectReference _this, PbmProfileId profile)
            throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profile", "PbmProfileId", profile);
        getWsc().invoke("PbmResetDefaultRequirementProfile", paras, null);
    }

    public void pbmResetVSanDefaultProfile(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("PbmResetVSanDefaultProfile", paras, null);
    }

    public void PbmUpdate(ManagedObjectReference _this, PbmProfileId profile,
            PbmCapabilityProfileUpdateSpec updateSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profile", "PbmProfileId", profile);
        paras[2] = new Argument("updateSpec", "PbmCapabilityProfileUpdateSpec", updateSpec);
        getWsc().invoke("PbmUpdate", paras, null);
    }
}
