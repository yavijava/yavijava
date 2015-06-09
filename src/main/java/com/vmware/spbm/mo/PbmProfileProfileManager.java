package com.vmware.spbm.mo;

import java.rmi.RemoteException;

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
import com.vmware.spbm.RuntimeFault;
import com.vmware.vim25.ManagedObjectReference;

/**
 * @author Atoka Sema
 */

public class PbmProfileProfileManager extends PbmManagedObject {
    public PbmProfileProfileManager(PbmServerConnection psc, ManagedObjectReference mor) {
        super(psc, mor);
    }

    public PbmCapabilityVendorResourceTypeInfo[] pbmFetchVendorInfo(PbmProfileResourceType resourceType)
            throws RuntimeFault, RemoteException {
        return getPbmService().pbmFetchVendorInfo(getMOR(), resourceType);
    }

    public PbmProfileResourceType[] pbmFetchResourceType() throws RuntimeFault, RemoteException {
        return getPbmService().pbmFetchResourceType(getMOR());
    }

    public PbmProfileId[] pbmQueryProfile(PbmProfileResourceType resourceType, String profileCategory)
            throws RuntimeFault, InvalidArgument, RemoteException {
        return getPbmService().pbmQueryProfile(getMOR(), resourceType, profileCategory);
    }

    public PbmProfile[] pbmRetrieveContent(PbmProfileId[] profileIds) throws RuntimeFault, InvalidArgument,
            RemoteException {
        return getPbmService().pbmRetrieveContent(getMOR(), profileIds);
    }

    public PbmProfileId pbmCreate(PbmCapabilityProfileCreateSpec createSpec) throws InvalidArgument, PbmDuplicateName,
            PbmFaultProfileStorageFault, RuntimeFault, RemoteException {
        return getPbmService().pbmCreate(getMOR(), createSpec);
    }

    public PbmProfileOperationOutcome[] pbmDelete(PbmProfileId[] profileId) throws RuntimeFault, RemoteException {
        return getPbmService().pbmDelete(getMOR(), profileId);
    }

    public void pbmAssignDefaultRequirementProfile(PbmProfileId profile, PbmPlacementHub[] datastores)
            throws InvalidArgument, PbmFault, PbmLegacyHubsNotSupported, PbmNonExistentHubs, RuntimeFault,
            RemoteException {
        getPbmService().pbmAssignDefaultRequirementProfile(getMOR(), profile, datastores);
    }

    public PbmCapabilityMetadataPerCategory[] pbmFetchCapabilityMetadata(PbmProfileResourceType resourceType,
            String vendorUuid) throws RuntimeFault, RemoteException {
        return getPbmService().pbmFetchCapabilityMetadata(getMOR(), resourceType, vendorUuid);
    }

    public PbmProfile[] pbmFindApplicableDefaultProfile(PbmPlacementHub[] datastores)
            throws InvalidArgument, PbmFault, PbmLegacyHubsNotSupported, PbmNonExistentHubs,
            RuntimeFault, RemoteException {
        return getPbmService().pbmFindApplicableDefaultProfile(getMOR(), datastores);
    }

    public PbmServerObjectRef[] PbmQueryAssociatedEntity(PbmProfileId profile, String entityType) throws PbmFault,
            RuntimeFault, RemoteException {
        return getPbmService().PbmQueryAssociatedEntity(getMOR(), profile, entityType);
    }

    public PbmProfileId[] pbmQueryAssociatedProfile(PbmServerObjectRef entity) throws PbmFault, RuntimeFault,
            RemoteException {
        return getPbmService().pbmQueryAssociatedProfile(getMOR(), entity);
    }

    public PbmQueryProfileResult[] pbmQueryAssociatedProfiles(PbmServerObjectRef[] entities)
            throws PbmFault, RuntimeFault, RemoteException {
       return getPbmService().pbmQueryAssociatedProfiles(getMOR(), entities);
    }

    public PbmProfileId pbmQueryDefaultRequirementProfile(PbmPlacementHub hub)
            throws InvalidArgument, PbmDuplicateName, PbmFaultProfileStorageFault,
            RuntimeFault, RemoteException {
        return getPbmService().pbmQueryDefaultRequirementProfile(getMOR(), hub);
    }

    public PbmDefaultProfileInfo[] pbmQueryDefaultRequirementProfiles(PbmPlacementHub[] datastores)
            throws PbmFault, PbmNonExistentHubs, RuntimeFault, RemoteException {
        return getPbmService().pbmQueryDefaultRequirementProfiles(getMOR(), datastores);
    }

    public PbmDatastoreSpaceStatistics[] pbmQuerySpaceStatsForStorageContainer(PbmServerObjectRef datastore, PbmProfileId[] capabilityProfileId) throws InvalidArgument, PbmFault, RuntimeFault, RemoteException {
        return getPbmService().pbmQuerySpaceStatsForStorageContainer(getMOR(), datastore, capabilityProfileId);
    }

    public void pbmResetDefaultRequirementProfile(PbmProfileId profile)
            throws RuntimeFault, RemoteException {
        getPbmService().pbmResetDefaultRequirementProfile(getMOR(), profile);
    }

    public void pbmResetVSanDefaultProfile() throws java.rmi.RemoteException, RuntimeFault {
        getPbmService().pbmResetVSanDefaultProfile(getMOR());
    }

    public void PbmUpdate(ManagedObjectReference _this, PbmProfileId profile,
            PbmCapabilityProfileUpdateSpec updateSpec) throws java.rmi.RemoteException, RuntimeFault {
        getPbmService().PbmUpdate(getMOR(), profile, updateSpec);
    }

}
