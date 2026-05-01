// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.mo.util.MorUtil;
/* ===== END custom imports ===== */

public class HostProfileManager extends ProfileManager {

    public HostProfileManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public Task applyEntitiesConfig_Task(ApplyHostProfileConfigurationSpec[] applyConfigSpecs) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().applyEntitiesConfig_Task(getMOR(), applyConfigSpecs);
        return new Task(getServerConnection(), resultMor);
    }

    public Task applyHostConfig_Task(HostSystem host, HostConfigSpec configSpec, ProfileDeferredPolicyOptionParameter[] userInput) throws HostConfigFailed, InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().applyHostConfig_Task(getMOR(), host == null ? null : host.getMOR(), configSpec, userInput);
        return new Task(getServerConnection(), resultMor);
    }

    public Task compositeHostProfile_Task(Profile source, Profile[] targets, HostApplyProfile toBeMerged, HostApplyProfile toBeReplacedWith, HostApplyProfile toBeDeleted, HostApplyProfile enableStatusToBeCopied) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().compositeHostProfile_Task(getMOR(), source == null ? null : source.getMOR(), targets == null ? null : MorUtil.createMORs(targets), toBeMerged, toBeReplacedWith, toBeDeleted, enableStatusToBeCopied);
        return new Task(getServerConnection(), resultMor);
    }

    public Task exportAnswerFile_Task(HostSystem host) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().exportAnswerFile_Task(getMOR(), host == null ? null : host.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public Task generateHostConfigTaskSpec_Task(StructuredCustomizations[] hostsInfo) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().generateHostConfigTaskSpec_Task(getMOR(), hostsInfo);
        return new Task(getServerConnection(), resultMor);
    }

    public Task generateHostProfileTaskList_Task(HostConfigSpec configSpec, HostSystem host) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().generateHostProfileTaskList_Task(getMOR(), configSpec, host == null ? null : host.getMOR());
        return new Task(getServerConnection(), resultMor);
    }

    public StructuredCustomizations[] retrieveHostCustomizations(HostSystem[] hosts) throws RuntimeFault, RemoteException {
        return getVimService().retrieveHostCustomizations(getMOR(), hosts == null ? null : MorUtil.createMORs(hosts));
    }

    public StructuredCustomizations[] retrieveHostCustomizationsForProfile(HostSystem[] hosts, HostApplyProfile applyProfile) throws RuntimeFault, RemoteException {
        return getVimService().retrieveHostCustomizationsForProfile(getMOR(), hosts == null ? null : MorUtil.createMORs(hosts), applyProfile);
    }

    public Task updateAnswerFile_Task(HostSystem host, AnswerFileCreateSpec configSpec) throws AnswerFileUpdateFailed, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().updateAnswerFile_Task(getMOR(), host == null ? null : host.getMOR(), configSpec);
        return new Task(getServerConnection(), resultMor);
    }

    public Task validateHostProfileComposition_Task(Profile source, Profile[] targets, HostApplyProfile toBeMerged, HostApplyProfile toReplaceWith, HostApplyProfile toBeDeleted, HostApplyProfile enableStatusToBeCopied, boolean errorOnly) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().validateHostProfileComposition_Task(getMOR(), source == null ? null : source.getMOR(), targets == null ? null : MorUtil.createMORs(targets), toBeMerged, toReplaceWith, toBeDeleted, enableStatusToBeCopied, errorOnly);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    //SDK4.1 signature for back compatibility
public Task applyHostConfig_Task(HostSystem host, HostConfigSpec configSpec) throws HostConfigFailed, InvalidState, RuntimeFault, RemoteException {
    return applyHostConfig_Task(host, configSpec, null);
}
    /**
 * @since SDK5.0
 */
public Task checkAnswerFileStatus_Task(HostSystem[] hosts) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] hostMors = MorUtil.createMORs(hosts);
    ManagedObjectReference taskMor = getVimService().checkAnswerFileStatus_Task(getMOR(), hostMors);
    return new Task(getServerConnection(), taskMor);
}
    //SDK4.1 signature for back compatibility
public ApplyProfile createDefaultProfile(String profileType) throws RuntimeFault, RemoteException {
    return createDefaultProfile(profileType, null, null);
}
    //SDK5.0 signature
public ApplyProfile createDefaultProfile(String profileType, String profileTypeName, Profile profile) throws RuntimeFault, RemoteException {
    return getVimService().createDefaultProfile(getMOR(), profileType, profileTypeName, profile == null ? null : profile.getMOR());
}
    /**
 * @deprecated as of SDK5.5, use generateHostProfileTaskList_Task() instead
 */
public HostProfileManagerConfigTaskList generateConfigTaskList(HostConfigSpec configSpec, HostSystem host) throws RuntimeFault, RemoteException {
    return getVimService().generateConfigTaskList(getMOR(), configSpec, host.getMOR());
}
    /**
 * @since SDK5.0
 */
public AnswerFileStatusResult[] queryAnswerFileStatus(HostSystem[] hosts) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] hostMors = MorUtil.createMORs(hosts);
    return getVimService().queryAnswerFileStatus(getMOR(), hostMors);
}
    //SDK4.1 signature for back compatibility
public ProfileMetadata[] queryHostProfileMetadata(String[] profileName) throws RuntimeFault, RemoteException {
    return getVimService().queryHostProfileMetadata(getMOR(), profileName, null);
}
    //SDK5.0 signature
public ProfileMetadata[] queryHostProfileMetadata(String[] profileNames, Profile profile) throws RuntimeFault, RemoteException {
    return getVimService().queryHostProfileMetadata(getMOR(), profileNames, profile == null ? null : profile.getMOR());
}
    /**
 * @since SDK5.0
 */
public ProfileProfileStructure queryProfileStructure(Profile profile) throws RuntimeFault, RemoteException {
    return getVimService().queryProfileStructure(getMOR(), profile.getMOR());
}
    /**
 * @since SDK5.0
 */
public AnswerFile retrieveAnswerFile(HostSystem host) throws RuntimeFault, RemoteException {
    return getVimService().retrieveAnswerFile(getMOR(), host.getMOR());
}
    /**
 * @since SDK5.1
 */
public AnswerFile retrieveAnswerFileForProfile(HostSystem host, HostApplyProfile applyProfile) throws RuntimeFault, RemoteException {
    return getVimService().retrieveAnswerFileForProfile(getMOR(), host == null ? null : host.getMOR(), applyProfile);
}
    /* ===== END custom ===== */
}
