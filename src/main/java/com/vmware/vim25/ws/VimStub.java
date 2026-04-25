/*================================================================================
Copyright (c) 2013 Steve Jin. All Rights Reserved.

Auto-generated dispatch table — do not edit by hand.
// auto generated using yavijava_generator
================================================================================*/

package com.vmware.vim25.ws;

import com.vmware.vim25.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.TrustManager;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.Calendar;

public class VimStub {

    private Client wsc = null;
    private static Logger log = LoggerFactory.getLogger(VimStub.class);

    public VimStub(String url, boolean ignoreCert) {
        try {
            this.wsc = ClientCreator.getClient(url, ignoreCert);
        } catch (NoSuchMethodException | IllegalAccessException
               | InvocationTargetException | InstantiationException e) {
            log.error("Error detected for url: " + url + " ignoreSSL: " + ignoreCert, e);
        }
    }

    public VimStub(String url, TrustManager trustManager) {
        try {
            this.wsc = ClientCreator.getClient(url, trustManager);
        } catch (Exception e) {
            log.error("Error detected for url: " + url + " trustManager: " + trustManager, e);
        }
    }

    public VimStub(Client wsc) {
        this.wsc = wsc;
    }

    public Client getWsc() {
        return wsc;
    }

    public void abandonHciWorkflow(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("AbandonHciWorkflow", paras, null);
    }

    public String[] abdicateDomOwnership(ManagedObjectReference _this, String[] uuids) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("uuids", "String[]", uuids);
        return (String[]) getWsc().invoke("AbdicateDomOwnership", paras, "String[]");
    }

    public ManagedObjectReference abortCustomization_Task(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth) throws java.rmi.RemoteException, CustomizationFault, GuestPermissionDenied, InvalidGuestLogin, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        return (ManagedObjectReference) getWsc().invoke("AbortCustomization_Task", paras, "ManagedObjectReference");
    }

    public void acknowledgeAlarm(ManagedObjectReference _this, ManagedObjectReference alarm, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("alarm", "ManagedObjectReference", alarm);
        paras[2] = new Argument("entity", "ManagedObjectReference", entity);
        getWsc().invoke("AcknowledgeAlarm", paras, null);
    }

    public HostServiceTicket acquireCimServicesTicket(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostServiceTicket) getWsc().invoke("AcquireCimServicesTicket", paras, "HostServiceTicket");
    }

    public String acquireCloneTicket(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) getWsc().invoke("AcquireCloneTicket", paras, "String");
    }

    public GuestAuthentication acquireCredentialsInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication requestedAuth, long sessionID) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("requestedAuth", "GuestAuthentication", requestedAuth);
        paras[3] = new Argument("sessionID", "long", sessionID);
        return (GuestAuthentication) getWsc().invoke("AcquireCredentialsInGuest", paras, "GuestAuthentication");
    }

    public SessionManagerGenericServiceTicket acquireGenericServiceTicket(ManagedObjectReference _this, SessionManagerServiceRequestSpec spec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "SessionManagerServiceRequestSpec", spec);
        return (SessionManagerGenericServiceTicket) getWsc().invoke("AcquireGenericServiceTicket", paras, "SessionManagerGenericServiceTicket");
    }

    public SessionManagerLocalTicket acquireLocalTicket(ManagedObjectReference _this, String userName) throws java.rmi.RemoteException, InvalidLogin, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("userName", "String", userName);
        return (SessionManagerLocalTicket) getWsc().invoke("AcquireLocalTicket", paras, "SessionManagerLocalTicket");
    }

    public VirtualMachineMksTicket acquireMksTicket(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VirtualMachineMksTicket) getWsc().invoke("AcquireMksTicket", paras, "VirtualMachineMksTicket");
    }

    public VirtualMachineTicket acquireTicket(ManagedObjectReference _this, String ticketType) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ticketType", "String", ticketType);
        return (VirtualMachineTicket) getWsc().invoke("AcquireTicket", paras, "VirtualMachineTicket");
    }

    public int addAuthorizationRole(ManagedObjectReference _this, String name, String[] privIds) throws java.rmi.RemoteException, AlreadyExists, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("privIds", "String[]", privIds);
        return (int) getWsc().invoke("AddAuthorizationRole", paras, "int");
    }

    public CustomFieldDef addCustomFieldDef(ManagedObjectReference _this, String name, String moType, PrivilegePolicyDef fieldDefPolicy, PrivilegePolicyDef fieldPolicy) throws java.rmi.RemoteException, DuplicateName, InvalidPrivilege, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("moType", "String", moType);
        paras[3] = new Argument("fieldDefPolicy", "PrivilegePolicyDef", fieldDefPolicy);
        paras[4] = new Argument("fieldPolicy", "PrivilegePolicyDef", fieldPolicy);
        return (CustomFieldDef) getWsc().invoke("AddCustomFieldDef", paras, "CustomFieldDef");
    }

    public ManagedObjectReference addDisks_Task(ManagedObjectReference _this, HostScsiDisk[] disk) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("disk", "HostScsiDisk[]", disk);
        return (ManagedObjectReference) getWsc().invoke("AddDisks_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference addDVPortgroup_Task(ManagedObjectReference _this, DVPortgroupConfigSpec[] spec) throws java.rmi.RemoteException, DuplicateName, DvsFault, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DVPortgroupConfigSpec[]", spec);
        return (ManagedObjectReference) getWsc().invoke("AddDVPortgroup_Task", paras, "ManagedObjectReference");
    }

    public String addFilter(ManagedObjectReference _this, String providerId, String filterName, String[] infoIds) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("providerId", "String", providerId);
        paras[2] = new Argument("filterName", "String", filterName);
        paras[3] = new Argument("infoIds", "String[]", infoIds);
        return (String) getWsc().invoke("AddFilter", paras, "String");
    }

    public void addFilterEntities(ManagedObjectReference _this, String filterId, ManagedObjectReference[] entities) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filterId", "String", filterId);
        paras[2] = new Argument("entities", "ManagedObjectReference[]", entities);
        getWsc().invoke("AddFilterEntities", paras, null);
    }

    public void addGuestAlias(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String username, boolean mapCert, String base64Cert, GuestAuthAliasInfo aliasInfo) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[7];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("username", "String", username);
        paras[4] = new Argument("mapCert", "boolean", mapCert);
        paras[5] = new Argument("base64Cert", "String", base64Cert);
        paras[6] = new Argument("aliasInfo", "GuestAuthAliasInfo", aliasInfo);
        getWsc().invoke("AddGuestAlias", paras, null);
    }

    public ManagedObjectReference addHost_Task(ManagedObjectReference _this, HostConnectSpec spec, boolean asConnected, ManagedObjectReference resourcePool, String license) throws java.rmi.RemoteException, DuplicateName, HostConnectFault, InvalidLogin, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostConnectSpec", spec);
        paras[2] = new Argument("asConnected", "boolean", asConnected);
        paras[3] = new Argument("resourcePool", "ManagedObjectReference", resourcePool);
        paras[4] = new Argument("license", "String", license);
        return (ManagedObjectReference) getWsc().invoke("AddHost_Task", paras, "ManagedObjectReference");
    }

    public void addInternetScsiSendTargets(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaSendTarget[] targets) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targets", "HostInternetScsiHbaSendTarget[]", targets);
        getWsc().invoke("AddInternetScsiSendTargets", paras, null);
    }

    public void addInternetScsiStaticTargets(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaStaticTarget[] targets) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targets", "HostInternetScsiHbaStaticTarget[]", targets);
        getWsc().invoke("AddInternetScsiStaticTargets", paras, null);
    }

    public void addKey(ManagedObjectReference _this, CryptoKeyPlain key) throws java.rmi.RemoteException, AlreadyExists, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "CryptoKeyPlain", key);
        getWsc().invoke("AddKey", paras, null);
    }

    public CryptoKeyResult[] addKeys(ManagedObjectReference _this, CryptoKeyPlain[] keys) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("keys", "CryptoKeyPlain[]", keys);
        return (CryptoKeyResult[]) getWsc().invoke("AddKeys", paras, "CryptoKeyResult[]");
    }

    public LicenseManagerLicenseInfo addLicense(ManagedObjectReference _this, String licenseKey, KeyValue[] labels) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        paras[2] = new Argument("labels", "KeyValue[]", labels);
        return (LicenseManagerLicenseInfo) getWsc().invoke("AddLicense", paras, "LicenseManagerLicenseInfo");
    }

    public void addMonitoredEntities(ManagedObjectReference _this, String providerId, ManagedObjectReference[] entities) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("providerId", "String", providerId);
        paras[2] = new Argument("entities", "ManagedObjectReference[]", entities);
        getWsc().invoke("AddMonitoredEntities", paras, null);
    }

    public void addNetworkResourcePool(ManagedObjectReference _this, DVSNetworkResourcePoolConfigSpec[] configSpec) throws java.rmi.RemoteException, DvsFault, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configSpec", "DVSNetworkResourcePoolConfigSpec[]", configSpec);
        getWsc().invoke("AddNetworkResourcePool", paras, null);
    }

    public void addPortGroup(ManagedObjectReference _this, HostPortGroupSpec portgrp) throws java.rmi.RemoteException, AlreadyExists, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portgrp", "HostPortGroupSpec", portgrp);
        getWsc().invoke("AddPortGroup", paras, null);
    }

    public String addServiceConsoleVirtualNic(ManagedObjectReference _this, String portgroup, HostVirtualNicSpec nic) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portgroup", "String", portgroup);
        paras[2] = new Argument("nic", "HostVirtualNicSpec", nic);
        return (String) getWsc().invoke("AddServiceConsoleVirtualNic", paras, "String");
    }

    public ManagedObjectReference addStandaloneHost_Task(ManagedObjectReference _this, HostConnectSpec spec, ComputeResourceConfigSpec compResSpec, boolean addConnected, String license) throws java.rmi.RemoteException, DuplicateName, HostConnectFault, InvalidLogin, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostConnectSpec", spec);
        paras[2] = new Argument("compResSpec", "ComputeResourceConfigSpec", compResSpec);
        paras[3] = new Argument("addConnected", "boolean", addConnected);
        paras[4] = new Argument("license", "String", license);
        return (ManagedObjectReference) getWsc().invoke("AddStandaloneHost_Task", paras, "ManagedObjectReference");
    }

    public String addVirtualNic(ManagedObjectReference _this, String portgroup, HostVirtualNicSpec nic) throws java.rmi.RemoteException, AlreadyExists, HostConfigFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portgroup", "String", portgroup);
        paras[2] = new Argument("nic", "HostVirtualNicSpec", nic);
        return (String) getWsc().invoke("AddVirtualNic", paras, "String");
    }

    public void addVirtualSwitch(ManagedObjectReference _this, String vswitchName, HostVirtualSwitchSpec spec) throws java.rmi.RemoteException, AlreadyExists, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vswitchName", "String", vswitchName);
        paras[2] = new Argument("spec", "HostVirtualSwitchSpec", spec);
        getWsc().invoke("AddVirtualSwitch", paras, null);
    }

    public String allocateIpv4Address(ManagedObjectReference _this, ManagedObjectReference dc, int poolId, String allocationId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("poolId", "int", poolId);
        paras[3] = new Argument("allocationId", "String", allocationId);
        return (String) getWsc().invoke("AllocateIpv4Address", paras, "String");
    }

    public String allocateIpv6Address(ManagedObjectReference _this, ManagedObjectReference dc, int poolId, String allocationId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("poolId", "int", poolId);
        paras[3] = new Argument("allocationId", "String", allocationId);
        return (String) getWsc().invoke("AllocateIpv6Address", paras, "String");
    }

    public void answerVM(ManagedObjectReference _this, String questionId, String answerChoice) throws java.rmi.RemoteException, ConcurrentAccess, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("questionId", "String", questionId);
        paras[2] = new Argument("answerChoice", "String", answerChoice);
        getWsc().invoke("AnswerVM", paras, null);
    }

    public ManagedObjectReference applyEntitiesConfig_Task(ManagedObjectReference _this, ApplyHostProfileConfigurationSpec[] applyConfigSpecs) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("applyConfigSpecs", "ApplyHostProfileConfigurationSpec[]", applyConfigSpecs);
        return (ManagedObjectReference) getWsc().invoke("ApplyEntitiesConfig_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference applyEvcModeVM_Task(ManagedObjectReference _this, HostFeatureMask[] mask, boolean completeMasks) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("mask", "HostFeatureMask[]", mask);
        paras[2] = new Argument("completeMasks", "boolean", completeMasks);
        return (ManagedObjectReference) getWsc().invoke("ApplyEvcModeVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference applyHostConfig_Task(ManagedObjectReference _this, ManagedObjectReference host, HostConfigSpec configSpec, ProfileDeferredPolicyOptionParameter[] userInput) throws java.rmi.RemoteException, HostConfigFailed, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("configSpec", "HostConfigSpec", configSpec);
        paras[3] = new Argument("userInput", "ProfileDeferredPolicyOptionParameter[]", userInput);
        return (ManagedObjectReference) getWsc().invoke("ApplyHostConfig_Task", paras, "ManagedObjectReference");
    }

    public void applyRecommendation(ManagedObjectReference _this, String key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String", key);
        getWsc().invoke("ApplyRecommendation", paras, null);
    }

    public ManagedObjectReference applyStorageDrsRecommendation_Task(ManagedObjectReference _this, String[] key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String[]", key);
        return (ManagedObjectReference) getWsc().invoke("ApplyStorageDrsRecommendation_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference applyStorageDrsRecommendationToPod_Task(ManagedObjectReference _this, ManagedObjectReference pod, String key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pod", "ManagedObjectReference", pod);
        paras[2] = new Argument("key", "String", key);
        return (ManagedObjectReference) getWsc().invoke("ApplyStorageDrsRecommendationToPod_Task", paras, "ManagedObjectReference");
    }

    public boolean areAlarmActionsEnabled(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        return (boolean) getWsc().invoke("AreAlarmActionsEnabled", paras, "boolean");
    }

    public void assignUserToGroup(ManagedObjectReference _this, String user, String group) throws java.rmi.RemoteException, AlreadyExists, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("user", "String", user);
        paras[2] = new Argument("group", "String", group);
        getWsc().invoke("AssignUserToGroup", paras, null);
    }

    public void associateProfile(ManagedObjectReference _this, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        getWsc().invoke("AssociateProfile", paras, null);
    }

    public ManagedObjectReference attachDisk_Task(ManagedObjectReference _this, ID diskId, ManagedObjectReference datastore, int controllerKey, int unitNumber) throws java.rmi.RemoteException, DeviceUnsupportedForVmVersion, FileFault, InvalidController, InvalidDatastore, InvalidState, MissingController, NotFound, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("diskId", "ID", diskId);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("controllerKey", "int", controllerKey);
        paras[4] = new Argument("unitNumber", "int", unitNumber);
        return (ManagedObjectReference) getWsc().invoke("AttachDisk_Task", paras, "ManagedObjectReference");
    }

    public void attachScsiLun(ManagedObjectReference _this, String lunUuid) throws java.rmi.RemoteException, HostConfigFault, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunUuid", "String", lunUuid);
        getWsc().invoke("AttachScsiLun", paras, null);
    }

    public ManagedObjectReference attachScsiLunEx_Task(ManagedObjectReference _this, String[] lunUuid) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunUuid", "String[]", lunUuid);
        return (ManagedObjectReference) getWsc().invoke("AttachScsiLunEx_Task", paras, "ManagedObjectReference");
    }

    public void attachTagToVStorageObject(ManagedObjectReference _this, ID id, String category, String tag) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("category", "String", category);
        paras[3] = new Argument("tag", "String", tag);
        getWsc().invoke("AttachTagToVStorageObject", paras, null);
    }

    public void attachVmfsExtent(ManagedObjectReference _this, String vmfsPath, HostScsiDiskPartition extent) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsPath", "String", vmfsPath);
        paras[2] = new Argument("extent", "HostScsiDiskPartition", extent);
        getWsc().invoke("AttachVmfsExtent", paras, null);
    }

    public void autoStartPowerOff(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("AutoStartPowerOff", paras, null);
    }

    public void autoStartPowerOn(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("AutoStartPowerOn", paras, null);
    }

    public String backupFirmwareConfiguration(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) getWsc().invoke("BackupFirmwareConfiguration", paras, "String");
    }

    public ManagedObjectReference batchAddHostsToCluster_Task(ManagedObjectReference _this, ManagedObjectReference cluster, FolderNewHostSpec[] newHosts, ManagedObjectReference[] existingHosts, ComputeResourceConfigSpec compResSpec, String desiredState) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cluster", "ManagedObjectReference", cluster);
        paras[2] = new Argument("newHosts", "FolderNewHostSpec[]", newHosts);
        paras[3] = new Argument("existingHosts", "ManagedObjectReference[]", existingHosts);
        paras[4] = new Argument("compResSpec", "ComputeResourceConfigSpec", compResSpec);
        paras[5] = new Argument("desiredState", "String", desiredState);
        return (ManagedObjectReference) getWsc().invoke("BatchAddHostsToCluster_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference batchAddStandaloneHosts_Task(ManagedObjectReference _this, FolderNewHostSpec[] newHosts, ComputeResourceConfigSpec compResSpec, boolean addConnected) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("newHosts", "FolderNewHostSpec[]", newHosts);
        paras[2] = new Argument("compResSpec", "ComputeResourceConfigSpec", compResSpec);
        paras[3] = new Argument("addConnected", "boolean", addConnected);
        return (ManagedObjectReference) getWsc().invoke("BatchAddStandaloneHosts_Task", paras, "ManagedObjectReference");
    }

    public DatacenterBasicConnectInfo[] batchQueryConnectInfo(ManagedObjectReference _this, HostConnectSpec[] hostSpecs) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hostSpecs", "HostConnectSpec[]", hostSpecs);
        return (DatacenterBasicConnectInfo[]) getWsc().invoke("BatchQueryConnectInfo", paras, "DatacenterBasicConnectInfo[]");
    }

    public void bindVnic(ManagedObjectReference _this, String iScsiHbaName, String vnicDevice) throws java.rmi.RemoteException, IscsiFault, IscsiFaultInvalidVnic, IscsiFaultVnicAlreadyBound, IscsiFaultVnicHasMultipleUplinks, IscsiFaultVnicHasNoUplinks, IscsiFaultVnicHasWrongUplink, IscsiFaultVnicNotFound, NotFound, PlatformConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaName", "String", iScsiHbaName);
        paras[2] = new Argument("vnicDevice", "String", vnicDevice);
        getWsc().invoke("BindVnic", paras, null);
    }

    public DiagnosticManagerLogHeader browseDiagnosticLog(ManagedObjectReference _this, ManagedObjectReference host, String key, int start, int lines) throws java.rmi.RemoteException, CannotAccessFile, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("key", "String", key);
        paras[3] = new Argument("start", "int", start);
        paras[4] = new Argument("lines", "int", lines);
        return (DiagnosticManagerLogHeader) getWsc().invoke("BrowseDiagnosticLog", paras, "DiagnosticManagerLogHeader");
    }

    public void cancelRecommendation(ManagedObjectReference _this, String key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String", key);
        getWsc().invoke("CancelRecommendation", paras, null);
    }

    public void cancelRetrievePropertiesEx(ManagedObjectReference _this, String token) throws java.rmi.RemoteException, InvalidProperty, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("token", "String", token);
        getWsc().invoke("CancelRetrievePropertiesEx", paras, null);
    }

    public void cancelStorageDrsRecommendation(ManagedObjectReference _this, String[] key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String[]", key);
        getWsc().invoke("CancelStorageDrsRecommendation", paras, null);
    }

    public void cancelTask(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("CancelTask", paras, null);
    }

    public void cancelWaitForUpdates(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("CancelWaitForUpdates", paras, null);
    }

    public VsanPolicySatisfiability[] canProvisionObjects(ManagedObjectReference _this, VsanNewPolicyBatch[] npbs, boolean ignoreSatisfiability) throws java.rmi.RemoteException, VimFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("npbs", "VsanNewPolicyBatch[]", npbs);
        paras[2] = new Argument("ignoreSatisfiability", "boolean", ignoreSatisfiability);
        return (VsanPolicySatisfiability[]) getWsc().invoke("CanProvisionObjects", paras, "VsanPolicySatisfiability[]");
    }

    public ManagedObjectReference certMgrRefreshCACertificatesAndCRLs_Task(ManagedObjectReference _this, ManagedObjectReference[] host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference[]", host);
        return (ManagedObjectReference) getWsc().invoke("CertMgrRefreshCACertificatesAndCRLs_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference certMgrRefreshCertificates_Task(ManagedObjectReference _this, ManagedObjectReference[] host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference[]", host);
        return (ManagedObjectReference) getWsc().invoke("CertMgrRefreshCertificates_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference certMgrRevokeCertificates_Task(ManagedObjectReference _this, ManagedObjectReference[] host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference[]", host);
        return (ManagedObjectReference) getWsc().invoke("CertMgrRevokeCertificates_Task", paras, "ManagedObjectReference");
    }

    public void changeAccessMode(ManagedObjectReference _this, String principal, boolean isGroup, HostAccessMode accessMode) throws java.rmi.RemoteException, AuthMinimumAdminPermission, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("principal", "String", principal);
        paras[2] = new Argument("isGroup", "boolean", isGroup);
        paras[3] = new Argument("accessMode", "HostAccessMode", accessMode);
        getWsc().invoke("ChangeAccessMode", paras, null);
    }

    public void changeFileAttributesInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String guestFilePath, GuestFileAttributes fileAttributes) throws java.rmi.RemoteException, FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("guestFilePath", "String", guestFilePath);
        paras[4] = new Argument("fileAttributes", "GuestFileAttributes", fileAttributes);
        getWsc().invoke("ChangeFileAttributesInGuest", paras, null);
    }

    public ManagedObjectReference changeKey_Task(ManagedObjectReference _this, CryptoKeyPlain newKey) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("newKey", "CryptoKeyPlain", newKey);
        return (ManagedObjectReference) getWsc().invoke("ChangeKey_Task", paras, "ManagedObjectReference");
    }

    public void changeLockdownMode(ManagedObjectReference _this, HostLockdownMode mode) throws java.rmi.RemoteException, AuthMinimumAdminPermission, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("mode", "HostLockdownMode", mode);
        getWsc().invoke("ChangeLockdownMode", paras, null);
    }

    public void changeNFSUserPassword(ManagedObjectReference _this, String password) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("password", "String", password);
        getWsc().invoke("ChangeNFSUserPassword", paras, null);
    }

    public void changeOwner(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, String owner) throws java.rmi.RemoteException, FileFault, InvalidDatastore, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("owner", "String", owner);
        getWsc().invoke("ChangeOwner", paras, null);
    }

    public void changePassword(ManagedObjectReference _this, String user, String oldPassword, String newPassword) throws java.rmi.RemoteException, InvalidLogin, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("user", "String", user);
        paras[2] = new Argument("oldPassword", "String", oldPassword);
        paras[3] = new Argument("newPassword", "String", newPassword);
        getWsc().invoke("ChangePassword", paras, null);
    }

    public ManagedObjectReference checkAddHostEvc_Task(ManagedObjectReference _this, HostConnectSpec cnxSpec) throws java.rmi.RemoteException, HostConnectFault, InvalidLogin, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cnxSpec", "HostConnectSpec", cnxSpec);
        return (ManagedObjectReference) getWsc().invoke("CheckAddHostEvc_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference checkAnswerFileStatus_Task(ManagedObjectReference _this, ManagedObjectReference[] host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference[]", host);
        return (ManagedObjectReference) getWsc().invoke("CheckAnswerFileStatus_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference checkClone_Task(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference folder, String name, VirtualMachineCloneSpec spec, String[] testType) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("folder", "ManagedObjectReference", folder);
        paras[3] = new Argument("name", "String", name);
        paras[4] = new Argument("spec", "VirtualMachineCloneSpec", spec);
        paras[5] = new Argument("testType", "String[]", testType);
        return (ManagedObjectReference) getWsc().invoke("CheckClone_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference checkCompatibility_Task(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference host, ManagedObjectReference pool, String[] testType) throws java.rmi.RemoteException, DatacenterMismatch, InvalidArgument, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        paras[3] = new Argument("pool", "ManagedObjectReference", pool);
        paras[4] = new Argument("testType", "String[]", testType);
        return (ManagedObjectReference) getWsc().invoke("CheckCompatibility_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference checkCompliance_Task(ManagedObjectReference _this, ManagedObjectReference[] profile, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profile", "ManagedObjectReference[]", profile);
        paras[2] = new Argument("entity", "ManagedObjectReference[]", entity);
        return (ManagedObjectReference) getWsc().invoke("CheckCompliance_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference checkConfigureEvcMode_Task(ManagedObjectReference _this, String evcModeKey, String evcGraphicsModeKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("evcModeKey", "String", evcModeKey);
        paras[2] = new Argument("evcGraphicsModeKey", "String", evcGraphicsModeKey);
        return (ManagedObjectReference) getWsc().invoke("CheckConfigureEvcMode_Task", paras, "ManagedObjectReference");
    }

    public void checkCustomizationResources(ManagedObjectReference _this, String guestOs) throws java.rmi.RemoteException, CustomizationFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("guestOs", "String", guestOs);
        getWsc().invoke("CheckCustomizationResources", paras, null);
    }

    public void checkCustomizationSpec(ManagedObjectReference _this, CustomizationSpec spec) throws java.rmi.RemoteException, CustomizationFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "CustomizationSpec", spec);
        getWsc().invoke("CheckCustomizationSpec", paras, null);
    }

    public UpdateSet checkForUpdates(ManagedObjectReference _this, String version) throws java.rmi.RemoteException, InvalidCollectorVersion, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("version", "String", version);
        return (UpdateSet) getWsc().invoke("CheckForUpdates", paras, "UpdateSet");
    }

    public ManagedObjectReference checkHostPatch_Task(ManagedObjectReference _this, String[] metaUrls, String[] bundleUrls, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, InvalidState, PlatformConfigFault, RequestCanceled, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("metaUrls", "String[]", metaUrls);
        paras[2] = new Argument("bundleUrls", "String[]", bundleUrls);
        paras[3] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CheckHostPatch_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference checkInstantClone_Task(ManagedObjectReference _this, ManagedObjectReference vm, VirtualMachineInstantCloneSpec spec, String[] testType) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("spec", "VirtualMachineInstantCloneSpec", spec);
        paras[3] = new Argument("testType", "String[]", testType);
        return (ManagedObjectReference) getWsc().invoke("CheckInstantClone_Task", paras, "ManagedObjectReference");
    }

    public boolean checkLicenseFeature(ManagedObjectReference _this, ManagedObjectReference host, String featureKey) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("featureKey", "String", featureKey);
        return (boolean) getWsc().invoke("CheckLicenseFeature", paras, "boolean");
    }

    public ManagedObjectReference checkMigrate_Task(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference host, ManagedObjectReference pool, VirtualMachinePowerState state, String[] testType) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        paras[3] = new Argument("pool", "ManagedObjectReference", pool);
        paras[4] = new Argument("state", "VirtualMachinePowerState", state);
        paras[5] = new Argument("testType", "String[]", testType);
        return (ManagedObjectReference) getWsc().invoke("CheckMigrate_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference checkPowerOn_Task(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference host, ManagedObjectReference pool, String[] testType) throws java.rmi.RemoteException, DatacenterMismatch, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        paras[3] = new Argument("pool", "ManagedObjectReference", pool);
        paras[4] = new Argument("testType", "String[]", testType);
        return (ManagedObjectReference) getWsc().invoke("CheckPowerOn_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference checkProfileCompliance_Task(ManagedObjectReference _this, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        return (ManagedObjectReference) getWsc().invoke("CheckProfileCompliance_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference checkRelocate_Task(ManagedObjectReference _this, ManagedObjectReference vm, VirtualMachineRelocateSpec spec, String[] testType) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("spec", "VirtualMachineRelocateSpec", spec);
        paras[3] = new Argument("testType", "String[]", testType);
        return (ManagedObjectReference) getWsc().invoke("CheckRelocate_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference checkVmConfig_Task(ManagedObjectReference _this, VirtualMachineConfigSpec spec, ManagedObjectReference vm, ManagedObjectReference host, ManagedObjectReference pool, String[] testType) throws java.rmi.RemoteException, DatacenterMismatch, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VirtualMachineConfigSpec", spec);
        paras[2] = new Argument("vm", "ManagedObjectReference", vm);
        paras[3] = new Argument("host", "ManagedObjectReference", host);
        paras[4] = new Argument("pool", "ManagedObjectReference", pool);
        paras[5] = new Argument("testType", "String[]", testType);
        return (ManagedObjectReference) getWsc().invoke("CheckVmConfig_Task", paras, "ManagedObjectReference");
    }

    public void clearComplianceStatus(ManagedObjectReference _this, ManagedObjectReference[] profile, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profile", "ManagedObjectReference[]", profile);
        paras[2] = new Argument("entity", "ManagedObjectReference[]", entity);
        getWsc().invoke("ClearComplianceStatus", paras, null);
    }

    public void clearNFSUser(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("ClearNFSUser", paras, null);
    }

    public void clearSystemEventLog(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("ClearSystemEventLog", paras, null);
    }

    public void clearTriggeredAlarms(ManagedObjectReference _this, AlarmFilterSpec filter) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filter", "AlarmFilterSpec", filter);
        getWsc().invoke("ClearTriggeredAlarms", paras, null);
    }

    public void clearVStorageObjectControlFlags(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, String[] controlFlags) throws java.rmi.RemoteException, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("controlFlags", "String[]", controlFlags);
        getWsc().invoke("ClearVStorageObjectControlFlags", paras, null);
    }

    public UserSession cloneSession(ManagedObjectReference _this, String cloneTicket) throws java.rmi.RemoteException, InvalidLogin, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cloneTicket", "String", cloneTicket);
        return (UserSession) getWsc().invoke("CloneSession", paras, "UserSession");
    }

    public ManagedObjectReference cloneVApp_Task(ManagedObjectReference _this, String name, ManagedObjectReference target, VAppCloneSpec spec) throws java.rmi.RemoteException, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidState, MigrationFault, TaskInProgress, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("target", "ManagedObjectReference", target);
        paras[3] = new Argument("spec", "VAppCloneSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CloneVApp_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference cloneVM_Task(ManagedObjectReference _this, ManagedObjectReference folder, String name, VirtualMachineCloneSpec spec) throws java.rmi.RemoteException, CustomizationFault, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidState, MigrationFault, TaskInProgress, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("folder", "ManagedObjectReference", folder);
        paras[2] = new Argument("name", "String", name);
        paras[3] = new Argument("spec", "VirtualMachineCloneSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CloneVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference cloneVStorageObject_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, VslmCloneSpec spec) throws java.rmi.RemoteException, FileFault, InvalidDatastore, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("spec", "VslmCloneSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CloneVStorageObject_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference[] closeInventoryViewFolder(ManagedObjectReference _this, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        return (ManagedObjectReference[]) getWsc().invoke("CloseInventoryViewFolder", paras, "ManagedObjectReference[]");
    }

    public ClusterEnterMaintenanceResult clusterEnterMaintenanceMode(ManagedObjectReference _this, ManagedObjectReference[] host, OptionValue[] option, ClusterComputeResourceMaintenanceInfo info) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference[]", host);
        paras[2] = new Argument("option", "OptionValue[]", option);
        paras[3] = new Argument("info", "ClusterComputeResourceMaintenanceInfo", info);
        return (ClusterEnterMaintenanceResult) getWsc().invoke("ClusterEnterMaintenanceMode", paras, "ClusterEnterMaintenanceResult");
    }

    public ManagedObjectReference compositeHostProfile_Task(ManagedObjectReference _this, ManagedObjectReference source, ManagedObjectReference[] targets, HostApplyProfile toBeMerged, HostApplyProfile toBeReplacedWith, HostApplyProfile toBeDeleted, HostApplyProfile enableStatusToBeCopied) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[7];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("source", "ManagedObjectReference", source);
        paras[2] = new Argument("targets", "ManagedObjectReference[]", targets);
        paras[3] = new Argument("toBeMerged", "HostApplyProfile", toBeMerged);
        paras[4] = new Argument("toBeReplacedWith", "HostApplyProfile", toBeReplacedWith);
        paras[5] = new Argument("toBeDeleted", "HostApplyProfile", toBeDeleted);
        paras[6] = new Argument("enableStatusToBeCopied", "HostApplyProfile", enableStatusToBeCopied);
        return (ManagedObjectReference) getWsc().invoke("CompositeHostProfile_Task", paras, "ManagedObjectReference");
    }

    public HostDiskPartitionInfo computeDiskPartitionInfo(ManagedObjectReference _this, String devicePath, HostDiskPartitionLayout layout, String partitionFormat) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("devicePath", "String", devicePath);
        paras[2] = new Argument("layout", "HostDiskPartitionLayout", layout);
        paras[3] = new Argument("partitionFormat", "String", partitionFormat);
        return (HostDiskPartitionInfo) getWsc().invoke("ComputeDiskPartitionInfo", paras, "HostDiskPartitionInfo");
    }

    public HostDiskPartitionInfo computeDiskPartitionInfoForResize(ManagedObjectReference _this, HostScsiDiskPartition partition, HostDiskPartitionBlockRange blockRange, String partitionFormat) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("partition", "HostScsiDiskPartition", partition);
        paras[2] = new Argument("blockRange", "HostDiskPartitionBlockRange", blockRange);
        paras[3] = new Argument("partitionFormat", "String", partitionFormat);
        return (HostDiskPartitionInfo) getWsc().invoke("ComputeDiskPartitionInfoForResize", paras, "HostDiskPartitionInfo");
    }

    public void configureCryptoKey(ManagedObjectReference _this, CryptoKeyId keyId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("keyId", "CryptoKeyId", keyId);
        getWsc().invoke("ConfigureCryptoKey", paras, null);
    }

    public ManagedObjectReference configureDatastoreIORM_Task(ManagedObjectReference _this, ManagedObjectReference datastore, StorageIORMConfigSpec spec) throws java.rmi.RemoteException, IORMNotSupportedHostOnDatastore, InaccessibleDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("spec", "StorageIORMConfigSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("ConfigureDatastoreIORM_Task", paras, "ManagedObjectReference");
    }

    public void configureDatastorePrincipal(ManagedObjectReference _this, String userName, String password) throws java.rmi.RemoteException, HostConfigFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("userName", "String", userName);
        paras[2] = new Argument("password", "String", password);
        getWsc().invoke("ConfigureDatastorePrincipal", paras, null);
    }

    public ManagedObjectReference configureEvcMode_Task(ManagedObjectReference _this, String evcModeKey, String evcGraphicsModeKey) throws java.rmi.RemoteException, EVCConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("evcModeKey", "String", evcModeKey);
        paras[2] = new Argument("evcGraphicsModeKey", "String", evcGraphicsModeKey);
        return (ManagedObjectReference) getWsc().invoke("ConfigureEvcMode_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference configureHCI_Task(ManagedObjectReference _this, ClusterComputeResourceHCIConfigSpec clusterSpec, ClusterComputeResourceHostConfigurationInput[] hostInputs) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("clusterSpec", "ClusterComputeResourceHCIConfigSpec", clusterSpec);
        paras[2] = new Argument("hostInputs", "ClusterComputeResourceHostConfigurationInput[]", hostInputs);
        return (ManagedObjectReference) getWsc().invoke("ConfigureHCI_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference configureHostCache_Task(ManagedObjectReference _this, HostCacheConfigurationSpec spec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostCacheConfigurationSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("ConfigureHostCache_Task", paras, "ManagedObjectReference");
    }

    public void configureLicenseSource(ManagedObjectReference _this, ManagedObjectReference host, LicenseSource licenseSource) throws java.rmi.RemoteException, CannotAccessLocalSource, InvalidLicense, LicenseServerUnavailable, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("licenseSource", "LicenseSource", licenseSource);
        getWsc().invoke("ConfigureLicenseSource", paras, null);
    }

    public void configurePowerPolicy(ManagedObjectReference _this, int key) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "int", key);
        getWsc().invoke("ConfigurePowerPolicy", paras, null);
    }

    public ManagedObjectReference configureStorageDrsForPod_Task(ManagedObjectReference _this, ManagedObjectReference pod, StorageDrsConfigSpec spec, boolean modify) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pod", "ManagedObjectReference", pod);
        paras[2] = new Argument("spec", "StorageDrsConfigSpec", spec);
        paras[3] = new Argument("modify", "boolean", modify);
        return (ManagedObjectReference) getWsc().invoke("ConfigureStorageDrsForPod_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference configureVcha_Task(ManagedObjectReference _this, VchaClusterConfigSpec configSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configSpec", "VchaClusterConfigSpec", configSpec);
        return (ManagedObjectReference) getWsc().invoke("configureVcha_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference configureVFlashResourceEx_Task(ManagedObjectReference _this, String[] devicePath) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("devicePath", "String[]", devicePath);
        return (ManagedObjectReference) getWsc().invoke("ConfigureVFlashResourceEx_Task", paras, "ManagedObjectReference");
    }

    public void connectNvmeController(ManagedObjectReference _this, HostNvmeConnectSpec connectSpec) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("connectSpec", "HostNvmeConnectSpec", connectSpec);
        getWsc().invoke("ConnectNvmeController", paras, null);
    }

    public ManagedObjectReference connectNvmeControllerEx_Task(ManagedObjectReference _this, HostNvmeConnectSpec[] connectSpec) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("connectSpec", "HostNvmeConnectSpec[]", connectSpec);
        return (ManagedObjectReference) getWsc().invoke("ConnectNvmeControllerEx_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference consolidateVMDisks_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, FileFault, InvalidState, TaskInProgress, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("ConsolidateVMDisks_Task", paras, "ManagedObjectReference");
    }

    public RetrieveResult continueRetrievePropertiesEx(ManagedObjectReference _this, String token) throws java.rmi.RemoteException, InvalidProperty, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("token", "String", token);
        return (RetrieveResult) getWsc().invoke("ContinueRetrievePropertiesEx", paras, "RetrieveResult");
    }

    public String convertNamespacePathToUuidPath(ManagedObjectReference _this, ManagedObjectReference datacenter, String namespaceUrl) throws java.rmi.RemoteException, InvalidDatastore, InvalidDatastorePath, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("namespaceUrl", "String", namespaceUrl);
        return (String) getWsc().invoke("ConvertNamespacePathToUuidPath", paras, "String");
    }

    public ManagedObjectReference copyDatastoreFile_Task(ManagedObjectReference _this, String sourceName, ManagedObjectReference sourceDatacenter, String destinationName, ManagedObjectReference destinationDatacenter, boolean force) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sourceName", "String", sourceName);
        paras[2] = new Argument("sourceDatacenter", "ManagedObjectReference", sourceDatacenter);
        paras[3] = new Argument("destinationName", "String", destinationName);
        paras[4] = new Argument("destinationDatacenter", "ManagedObjectReference", destinationDatacenter);
        paras[5] = new Argument("force", "boolean", force);
        return (ManagedObjectReference) getWsc().invoke("CopyDatastoreFile_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference copyVirtualDisk_Task(ManagedObjectReference _this, String sourceName, ManagedObjectReference sourceDatacenter, String destName, ManagedObjectReference destDatacenter, VirtualDiskSpec destSpec, boolean force) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidDiskFormat, RuntimeFault {
        Argument[] paras = new Argument[7];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sourceName", "String", sourceName);
        paras[2] = new Argument("sourceDatacenter", "ManagedObjectReference", sourceDatacenter);
        paras[3] = new Argument("destName", "String", destName);
        paras[4] = new Argument("destDatacenter", "ManagedObjectReference", destDatacenter);
        paras[5] = new Argument("destSpec", "VirtualDiskSpec", destSpec);
        paras[6] = new Argument("force", "boolean", force);
        return (ManagedObjectReference) getWsc().invoke("CopyVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createAlarm(ManagedObjectReference _this, ManagedObjectReference entity, AlarmSpec spec) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("spec", "AlarmSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateAlarm", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createChildVM_Task(ManagedObjectReference _this, VirtualMachineConfigSpec config, ManagedObjectReference host) throws java.rmi.RemoteException, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidName, OutOfBounds, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "VirtualMachineConfigSpec", config);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("CreateChildVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createCluster(ManagedObjectReference _this, String name, ClusterConfigSpec spec) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("spec", "ClusterConfigSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateCluster", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createClusterEx(ManagedObjectReference _this, String name, ClusterConfigSpecEx spec) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("spec", "ClusterConfigSpecEx", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateClusterEx", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createCollectorForEvents(ManagedObjectReference _this, EventFilterSpec filter) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filter", "EventFilterSpec", filter);
        return (ManagedObjectReference) getWsc().invoke("CreateCollectorForEvents", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createCollectorForTasks(ManagedObjectReference _this, TaskFilterSpec filter) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filter", "TaskFilterSpec", filter);
        return (ManagedObjectReference) getWsc().invoke("CreateCollectorForTasks", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createCollectorWithInfoFilterForTasks(ManagedObjectReference _this, TaskFilterSpec filter, TaskInfoFilterSpec infoFilter) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filter", "TaskFilterSpec", filter);
        paras[2] = new Argument("infoFilter", "TaskInfoFilterSpec", infoFilter);
        return (ManagedObjectReference) getWsc().invoke("CreateCollectorWithInfoFilterForTasks", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createContainerView(ManagedObjectReference _this, ManagedObjectReference container, String[] type, boolean recursive) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("container", "ManagedObjectReference", container);
        paras[2] = new Argument("type", "String[]", type);
        paras[3] = new Argument("recursive", "boolean", recursive);
        return (ManagedObjectReference) getWsc().invoke("CreateContainerView", paras, "ManagedObjectReference");
    }

    public void createCustomizationSpec(ManagedObjectReference _this, CustomizationSpecItem item) throws java.rmi.RemoteException, AlreadyExists, CustomizationFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("item", "CustomizationSpecItem", item);
        getWsc().invoke("CreateCustomizationSpec", paras, null);
    }

    public ManagedObjectReference createDatacenter(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (ManagedObjectReference) getWsc().invoke("CreateDatacenter", paras, "ManagedObjectReference");
    }

    public ApplyProfile createDefaultProfile(ManagedObjectReference _this, String profileType, String profileTypeName, ManagedObjectReference profile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profileType", "String", profileType);
        paras[2] = new Argument("profileTypeName", "String", profileTypeName);
        paras[3] = new Argument("profile", "ManagedObjectReference", profile);
        return (ApplyProfile) getWsc().invoke("CreateDefaultProfile", paras, "ApplyProfile");
    }

    public OvfCreateDescriptorResult createDescriptor(ManagedObjectReference _this, ManagedObjectReference obj, OvfCreateDescriptorParams cdp) throws java.rmi.RemoteException, ConcurrentAccess, FileFault, InvalidState, TaskInProgress, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("obj", "ManagedObjectReference", obj);
        paras[2] = new Argument("cdp", "OvfCreateDescriptorParams", cdp);
        return (OvfCreateDescriptorResult) getWsc().invoke("CreateDescriptor", paras, "OvfCreateDescriptorResult");
    }

    public void createDiagnosticPartition(ManagedObjectReference _this, HostDiagnosticPartitionCreateSpec spec) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostDiagnosticPartitionCreateSpec", spec);
        getWsc().invoke("CreateDiagnosticPartition", paras, null);
    }

    public String createDirectory(ManagedObjectReference _this, ManagedObjectReference datastore, String displayName, String policy, long size) throws java.rmi.RemoteException, CannotCreateFile, FileAlreadyExists, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("displayName", "String", displayName);
        paras[3] = new Argument("policy", "String", policy);
        paras[4] = new Argument("size", "long", size);
        return (String) getWsc().invoke("CreateDirectory", paras, "String");
    }

    public ManagedObjectReference createDisk_Task(ManagedObjectReference _this, VslmCreateSpec spec) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VslmCreateSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createDiskFromSnapshot_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, ID snapshotId, String name, VirtualMachineProfileSpec[] profile, CryptoSpec crypto, String path) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[8];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("snapshotId", "ID", snapshotId);
        paras[4] = new Argument("name", "String", name);
        paras[5] = new Argument("profile", "VirtualMachineProfileSpec[]", profile);
        paras[6] = new Argument("crypto", "CryptoSpec", crypto);
        paras[7] = new Argument("path", "String", path);
        return (ManagedObjectReference) getWsc().invoke("CreateDiskFromSnapshot_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createDVPortgroup_Task(ManagedObjectReference _this, DVPortgroupConfigSpec spec) throws java.rmi.RemoteException, DuplicateName, DvsFault, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DVPortgroupConfigSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateDVPortgroup_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createDVS_Task(ManagedObjectReference _this, DVSCreateSpec spec) throws java.rmi.RemoteException, DuplicateName, DvsFault, DvsNotAuthorized, InvalidName, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DVSCreateSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateDVS_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createFilter(ManagedObjectReference _this, PropertyFilterSpec spec, boolean partialUpdates) throws java.rmi.RemoteException, InvalidProperty, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "PropertyFilterSpec", spec);
        paras[2] = new Argument("partialUpdates", "boolean", partialUpdates);
        return (ManagedObjectReference) getWsc().invoke("CreateFilter", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createFolder(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (ManagedObjectReference) getWsc().invoke("CreateFolder", paras, "ManagedObjectReference");
    }

    public void createGroup(ManagedObjectReference _this, HostAccountSpec group) throws java.rmi.RemoteException, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("group", "HostAccountSpec", group);
        getWsc().invoke("CreateGroup", paras, null);
    }

    public OvfCreateImportSpecResult createImportSpec(ManagedObjectReference _this, String ovfDescriptor, ManagedObjectReference resourcePool, ManagedObjectReference datastore, OvfCreateImportSpecParams cisp) throws java.rmi.RemoteException, ConcurrentAccess, FileFault, InvalidDatastore, InvalidState, TaskInProgress, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ovfDescriptor", "String", ovfDescriptor);
        paras[2] = new Argument("resourcePool", "ManagedObjectReference", resourcePool);
        paras[3] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[4] = new Argument("cisp", "OvfCreateImportSpecParams", cisp);
        return (OvfCreateImportSpecResult) getWsc().invoke("CreateImportSpec", paras, "OvfCreateImportSpecResult");
    }

    public ManagedObjectReference createInventoryView(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("CreateInventoryView", paras, "ManagedObjectReference");
    }

    public int createIpPool(ManagedObjectReference _this, ManagedObjectReference dc, IpPool pool) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("pool", "IpPool", pool);
        return (int) getWsc().invoke("CreateIpPool", paras, "int");
    }

    public ManagedObjectReference createListView(ManagedObjectReference _this, ManagedObjectReference[] obj) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("obj", "ManagedObjectReference[]", obj);
        return (ManagedObjectReference) getWsc().invoke("CreateListView", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createListViewFromView(ManagedObjectReference _this, ManagedObjectReference view) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("view", "ManagedObjectReference", view);
        return (ManagedObjectReference) getWsc().invoke("CreateListViewFromView", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createLocalDatastore(ManagedObjectReference _this, String name, String path) throws java.rmi.RemoteException, DuplicateName, FileNotFound, HostConfigFault, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("path", "String", path);
        return (ManagedObjectReference) getWsc().invoke("CreateLocalDatastore", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createNasDatastore(ManagedObjectReference _this, HostNasVolumeSpec spec) throws java.rmi.RemoteException, AlreadyExists, DuplicateName, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostNasVolumeSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateNasDatastore", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createNvdimmNamespace_Task(ManagedObjectReference _this, NvdimmNamespaceCreateSpec createSpec) throws java.rmi.RemoteException, AlreadyExists, HostConfigFault, InvalidHostState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("createSpec", "NvdimmNamespaceCreateSpec", createSpec);
        return (ManagedObjectReference) getWsc().invoke("CreateNvdimmNamespace_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createNvdimmPMemNamespace_Task(ManagedObjectReference _this, NvdimmPMemNamespaceCreateSpec createSpec) throws java.rmi.RemoteException, AlreadyExists, HostConfigFault, InvalidHostState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("createSpec", "NvdimmPMemNamespaceCreateSpec", createSpec);
        return (ManagedObjectReference) getWsc().invoke("CreateNvdimmPMemNamespace_Task", paras, "ManagedObjectReference");
    }

    public void createNvmeOverRdmaAdapter(ManagedObjectReference _this, String rdmaDeviceName) throws java.rmi.RemoteException, HostConfigFault, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("rdmaDeviceName", "String", rdmaDeviceName);
        getWsc().invoke("CreateNvmeOverRdmaAdapter", paras, null);
    }

    public ManagedObjectReference createObjectScheduledTask(ManagedObjectReference _this, ManagedObjectReference obj, ScheduledTaskSpec spec) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("obj", "ManagedObjectReference", obj);
        paras[2] = new Argument("spec", "ScheduledTaskSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateObjectScheduledTask", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createPassiveNode_Task(ManagedObjectReference _this, PassiveNodeDeploymentSpec passiveDeploymentSpec, SourceNodeSpec sourceVcSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("passiveDeploymentSpec", "PassiveNodeDeploymentSpec", passiveDeploymentSpec);
        paras[2] = new Argument("sourceVcSpec", "SourceNodeSpec", sourceVcSpec);
        return (ManagedObjectReference) getWsc().invoke("createPassiveNode_Task", paras, "ManagedObjectReference");
    }

    public void createPerfInterval(ManagedObjectReference _this, PerfInterval intervalId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("intervalId", "PerfInterval", intervalId);
        getWsc().invoke("CreatePerfInterval", paras, null);
    }

    public ManagedObjectReference createProfile(ManagedObjectReference _this, ProfileCreateSpec createSpec) throws java.rmi.RemoteException, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("createSpec", "ProfileCreateSpec", createSpec);
        return (ManagedObjectReference) getWsc().invoke("CreateProfile", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createPropertyCollector(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("CreatePropertyCollector", paras, "ManagedObjectReference");
    }

    public void createRegistryKeyInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean isVolatile, String classType) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("keyName", "GuestRegKeyNameSpec", keyName);
        paras[4] = new Argument("isVolatile", "boolean", isVolatile);
        paras[5] = new Argument("classType", "String", classType);
        getWsc().invoke("CreateRegistryKeyInGuest", paras, null);
    }

    public ManagedObjectReference createResourcePool(ManagedObjectReference _this, String name, ResourceConfigSpec spec) throws java.rmi.RemoteException, DuplicateName, InsufficientResourcesFault, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("spec", "ResourceConfigSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateResourcePool", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createScheduledTask(ManagedObjectReference _this, ManagedObjectReference entity, ScheduledTaskSpec spec) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("spec", "ScheduledTaskSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateScheduledTask", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createScreenshot_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, FileFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("CreateScreenshot_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createSecondaryVM_Task(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, FileFault, InsufficientResourcesFault, InvalidState, TaskInProgress, VmConfigFault, VmFaultToleranceIssue, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("CreateSecondaryVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createSecondaryVMEx_Task(ManagedObjectReference _this, ManagedObjectReference host, FaultToleranceConfigSpec spec) throws java.rmi.RemoteException, FileFault, InsufficientResourcesFault, InvalidState, TaskInProgress, VmConfigFault, VmFaultToleranceIssue, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("spec", "FaultToleranceConfigSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateSecondaryVMEx_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createSnapshot_Task(ManagedObjectReference _this, String name, String description, boolean memory, boolean quiesce) throws java.rmi.RemoteException, FileFault, InvalidName, InvalidState, SnapshotFault, TaskInProgress, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("description", "String", description);
        paras[3] = new Argument("memory", "boolean", memory);
        paras[4] = new Argument("quiesce", "boolean", quiesce);
        return (ManagedObjectReference) getWsc().invoke("CreateSnapshot_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createSnapshotEx_Task(ManagedObjectReference _this, String name, String description, boolean memory, VirtualMachineGuestQuiesceSpec quiesceSpec) throws java.rmi.RemoteException, FileFault, InvalidName, InvalidState, SnapshotFault, TaskInProgress, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("description", "String", description);
        paras[3] = new Argument("memory", "boolean", memory);
        paras[4] = new Argument("quiesceSpec", "VirtualMachineGuestQuiesceSpec", quiesceSpec);
        return (ManagedObjectReference) getWsc().invoke("CreateSnapshotEx_Task", paras, "ManagedObjectReference");
    }

    public void createSoftwareAdapter(ManagedObjectReference _this, HostHbaCreateSpec spec) throws java.rmi.RemoteException, HostConfigFault, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostHbaCreateSpec", spec);
        getWsc().invoke("CreateSoftwareAdapter", paras, null);
    }

    public ManagedObjectReference createStoragePod(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (ManagedObjectReference) getWsc().invoke("CreateStoragePod", paras, "ManagedObjectReference");
    }

    public TaskInfo createTask(ManagedObjectReference _this, ManagedObjectReference obj, String taskTypeId, String initiatedBy, boolean cancelable, String parentTaskKey, String activationId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[7];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("obj", "ManagedObjectReference", obj);
        paras[2] = new Argument("taskTypeId", "String", taskTypeId);
        paras[3] = new Argument("initiatedBy", "String", initiatedBy);
        paras[4] = new Argument("cancelable", "boolean", cancelable);
        paras[5] = new Argument("parentTaskKey", "String", parentTaskKey);
        paras[6] = new Argument("activationId", "String", activationId);
        return (TaskInfo) getWsc().invoke("CreateTask", paras, "TaskInfo");
    }

    public String createTemporaryDirectoryInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String prefix, String suffix, String directoryPath) throws java.rmi.RemoteException, FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("prefix", "String", prefix);
        paras[4] = new Argument("suffix", "String", suffix);
        paras[5] = new Argument("directoryPath", "String", directoryPath);
        return (String) getWsc().invoke("CreateTemporaryDirectoryInGuest", paras, "String");
    }

    public String createTemporaryFileInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String prefix, String suffix, String directoryPath) throws java.rmi.RemoteException, FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("prefix", "String", prefix);
        paras[4] = new Argument("suffix", "String", suffix);
        paras[5] = new Argument("directoryPath", "String", directoryPath);
        return (String) getWsc().invoke("CreateTemporaryFileInGuest", paras, "String");
    }

    public void createUser(ManagedObjectReference _this, HostAccountSpec user) throws java.rmi.RemoteException, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("user", "HostAccountSpec", user);
        getWsc().invoke("CreateUser", paras, null);
    }

    public ManagedObjectReference createVApp(ManagedObjectReference _this, String name, ResourceConfigSpec resSpec, VAppConfigSpec configSpec, ManagedObjectReference vmFolder) throws java.rmi.RemoteException, DuplicateName, InsufficientResourcesFault, InvalidName, InvalidState, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("resSpec", "ResourceConfigSpec", resSpec);
        paras[3] = new Argument("configSpec", "VAppConfigSpec", configSpec);
        paras[4] = new Argument("vmFolder", "ManagedObjectReference", vmFolder);
        return (ManagedObjectReference) getWsc().invoke("CreateVApp", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, VirtualDiskSpec spec) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("spec", "VirtualDiskSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createVM_Task(ManagedObjectReference _this, VirtualMachineConfigSpec config, ManagedObjectReference pool, ManagedObjectReference host) throws java.rmi.RemoteException, AlreadyExists, DuplicateName, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidName, InvalidState, OutOfBounds, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "VirtualMachineConfigSpec", config);
        paras[2] = new Argument("pool", "ManagedObjectReference", pool);
        paras[3] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("CreateVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createVmfsDatastore(ManagedObjectReference _this, VmfsDatastoreCreateSpec spec) throws java.rmi.RemoteException, DuplicateName, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VmfsDatastoreCreateSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateVmfsDatastore", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createVvolDatastore(ManagedObjectReference _this, HostDatastoreSystemVvolDatastoreSpec spec) throws java.rmi.RemoteException, DuplicateName, HostConfigFault, InvalidName, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostDatastoreSystemVvolDatastoreSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateVvolDatastore", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createWitnessNode_Task(ManagedObjectReference _this, NodeDeploymentSpec witnessDeploymentSpec, SourceNodeSpec sourceVcSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("witnessDeploymentSpec", "NodeDeploymentSpec", witnessDeploymentSpec);
        paras[2] = new Argument("sourceVcSpec", "SourceNodeSpec", sourceVcSpec);
        return (ManagedObjectReference) getWsc().invoke("createWitnessNode_Task", paras, "ManagedObjectReference");
    }

    public void cryptoManagerHostDisable(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("CryptoManagerHostDisable", paras, null);
    }

    public void cryptoManagerHostEnable(ManagedObjectReference _this, CryptoKeyPlain initialKey) throws java.rmi.RemoteException, AlreadyExists, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("initialKey", "CryptoKeyPlain", initialKey);
        getWsc().invoke("CryptoManagerHostEnable", paras, null);
    }

    public void cryptoManagerHostPrepare(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("CryptoManagerHostPrepare", paras, null);
    }

    public ManagedObjectReference cryptoUnlock_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, NotSupported, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("CryptoUnlock_Task", paras, "ManagedObjectReference");
    }

    public Calendar currentTime(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (Calendar) getWsc().invoke("CurrentTime", paras, "Calendar");
    }

    public String customizationSpecItemToXml(ManagedObjectReference _this, CustomizationSpecItem item) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("item", "CustomizationSpecItem", item);
        return (String) getWsc().invoke("CustomizationSpecItemToXml", paras, "String");
    }

    public ManagedObjectReference customizeGuest_Task(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, CustomizationSpec spec, OptionValue[] configParams) throws java.rmi.RemoteException, CustomizationFault, GuestPermissionDenied, InvalidGuestLogin, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("spec", "CustomizationSpec", spec);
        paras[4] = new Argument("configParams", "OptionValue[]", configParams);
        return (ManagedObjectReference) getWsc().invoke("CustomizeGuest_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference customizeVM_Task(ManagedObjectReference _this, CustomizationSpec spec) throws java.rmi.RemoteException, CustomizationFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "CustomizationSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CustomizeVM_Task", paras, "ManagedObjectReference");
    }

    public StoragePlacementResult datastoreEnterMaintenanceMode(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (StoragePlacementResult) getWsc().invoke("DatastoreEnterMaintenanceMode", paras, "StoragePlacementResult");
    }

    public ManagedObjectReference datastoreExitMaintenanceMode_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("DatastoreExitMaintenanceMode_Task", paras, "ManagedObjectReference");
    }

    public LicenseManagerLicenseInfo decodeLicense(ManagedObjectReference _this, String licenseKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        return (LicenseManagerLicenseInfo) getWsc().invoke("DecodeLicense", paras, "LicenseManagerLicenseInfo");
    }

    public void defragmentAllDisks(ManagedObjectReference _this) throws java.rmi.RemoteException, FileFault, InvalidPowerState, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DefragmentAllDisks", paras, null);
    }

    public ManagedObjectReference defragmentVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) getWsc().invoke("DefragmentVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public void deleteCustomizationSpec(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        getWsc().invoke("DeleteCustomizationSpec", paras, null);
    }

    public ManagedObjectReference deleteDatastoreFile_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) getWsc().invoke("DeleteDatastoreFile_Task", paras, "ManagedObjectReference");
    }

    public void deleteDirectory(ManagedObjectReference _this, ManagedObjectReference datacenter, String datastorePath) throws java.rmi.RemoteException, FileFault, FileNotFound, InvalidDatastore, InvalidDatastorePath, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("datastorePath", "String", datastorePath);
        getWsc().invoke("DeleteDirectory", paras, null);
    }

    public void deleteDirectoryInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String directoryPath, boolean recursive) throws java.rmi.RemoteException, FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("directoryPath", "String", directoryPath);
        paras[4] = new Argument("recursive", "boolean", recursive);
        getWsc().invoke("DeleteDirectoryInGuest", paras, null);
    }

    public void deleteFile(ManagedObjectReference _this, String datastorePath) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastorePath", "String", datastorePath);
        getWsc().invoke("DeleteFile", paras, null);
    }

    public void deleteFileInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String filePath) throws java.rmi.RemoteException, FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("filePath", "String", filePath);
        getWsc().invoke("DeleteFileInGuest", paras, null);
    }

    public void deleteHostSpecification(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, HostSpecificationOperationFailed, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        getWsc().invoke("DeleteHostSpecification", paras, null);
    }

    public void deleteHostSubSpecification(ManagedObjectReference _this, ManagedObjectReference host, String subSpecName) throws java.rmi.RemoteException, HostSpecificationOperationFailed, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("subSpecName", "String", subSpecName);
        getWsc().invoke("DeleteHostSubSpecification", paras, null);
    }

    public ManagedObjectReference deleteNvdimmBlockNamespaces_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, InvalidHostState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("DeleteNvdimmBlockNamespaces_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference deleteNvdimmNamespace_Task(ManagedObjectReference _this, NvdimmNamespaceDeleteSpec deleteSpec) throws java.rmi.RemoteException, HostConfigFault, InvalidHostState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("deleteSpec", "NvdimmNamespaceDeleteSpec", deleteSpec);
        return (ManagedObjectReference) getWsc().invoke("DeleteNvdimmNamespace_Task", paras, "ManagedObjectReference");
    }

    public void deleteRegistryKeyInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean recursive) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("keyName", "GuestRegKeyNameSpec", keyName);
        paras[4] = new Argument("recursive", "boolean", recursive);
        getWsc().invoke("DeleteRegistryKeyInGuest", paras, null);
    }

    public void deleteRegistryValueInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, GuestRegValueNameSpec valueName) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("valueName", "GuestRegValueNameSpec", valueName);
        getWsc().invoke("DeleteRegistryValueInGuest", paras, null);
    }

    public void deleteScsiLunState(ManagedObjectReference _this, String lunCanonicalName) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunCanonicalName", "String", lunCanonicalName);
        getWsc().invoke("DeleteScsiLunState", paras, null);
    }

    public ManagedObjectReference deleteSnapshot_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, ID snapshotId) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("snapshotId", "ID", snapshotId);
        return (ManagedObjectReference) getWsc().invoke("DeleteSnapshot_Task", paras, "ManagedObjectReference");
    }

    public void deleteVffsVolumeState(ManagedObjectReference _this, String vffsUuid) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsUuid", "String", vffsUuid);
        getWsc().invoke("DeleteVffsVolumeState", paras, null);
    }

    public ManagedObjectReference deleteVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) getWsc().invoke("DeleteVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public void deleteVmfsVolumeState(ManagedObjectReference _this, String vmfsUuid) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsUuid", "String", vmfsUuid);
        getWsc().invoke("DeleteVmfsVolumeState", paras, null);
    }

    public HostVsanInternalSystemDeleteVsanObjectsResult[] deleteVsanObjects(ManagedObjectReference _this, String[] uuids, boolean force) throws java.rmi.RemoteException, VimFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("uuids", "String[]", uuids);
        paras[2] = new Argument("force", "boolean", force);
        return (HostVsanInternalSystemDeleteVsanObjectsResult[]) getWsc().invoke("DeleteVsanObjects", paras, "HostVsanInternalSystemDeleteVsanObjectsResult[]");
    }

    public ManagedObjectReference deleteVStorageObject_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (ManagedObjectReference) getWsc().invoke("DeleteVStorageObject_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference deleteVStorageObjectEx_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (ManagedObjectReference) getWsc().invoke("DeleteVStorageObjectEx_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference deployVcha_Task(ManagedObjectReference _this, VchaClusterDeploymentSpec deploymentSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("deploymentSpec", "VchaClusterDeploymentSpec", deploymentSpec);
        return (ManagedObjectReference) getWsc().invoke("deployVcha_Task", paras, "ManagedObjectReference");
    }

    public void deselectVnic(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DeselectVnic", paras, null);
    }

    public void deselectVnicForNicType(ManagedObjectReference _this, String nicType, String device) throws java.rmi.RemoteException, HostConfigFault, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("nicType", "String", nicType);
        paras[2] = new Argument("device", "String", device);
        getWsc().invoke("DeselectVnicForNicType", paras, null);
    }

    public ManagedObjectReference destroy_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, VimFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("Destroy_Task", paras, "ManagedObjectReference");
    }

    public void destroyChildren(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DestroyChildren", paras, null);
    }

    public void destroyCollector(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DestroyCollector", paras, null);
    }

    public void destroyDatastore(ManagedObjectReference _this) throws java.rmi.RemoteException, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DestroyDatastore", paras, null);
    }

    public void destroyIpPool(ManagedObjectReference _this, ManagedObjectReference dc, int id, boolean force) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("id", "int", id);
        paras[3] = new Argument("force", "boolean", force);
        getWsc().invoke("DestroyIpPool", paras, null);
    }

    public void destroyNetwork(ManagedObjectReference _this) throws java.rmi.RemoteException, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DestroyNetwork", paras, null);
    }

    public void destroyProfile(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DestroyProfile", paras, null);
    }

    public void destroyPropertyCollector(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DestroyPropertyCollector", paras, null);
    }

    public void destroyPropertyFilter(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DestroyPropertyFilter", paras, null);
    }

    public ManagedObjectReference destroyVcha_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("destroyVcha_Task", paras, "ManagedObjectReference");
    }

    public void destroyVffs(ManagedObjectReference _this, String vffsPath) throws java.rmi.RemoteException, HostConfigFault, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsPath", "String", vffsPath);
        getWsc().invoke("DestroyVffs", paras, null);
    }

    public void destroyView(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DestroyView", paras, null);
    }

    public ManagedObjectReference detachDisk_Task(ManagedObjectReference _this, ID diskId) throws java.rmi.RemoteException, FileFault, InvalidState, NotFound, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("diskId", "ID", diskId);
        return (ManagedObjectReference) getWsc().invoke("DetachDisk_Task", paras, "ManagedObjectReference");
    }

    public void detachScsiLun(ManagedObjectReference _this, String lunUuid) throws java.rmi.RemoteException, HostConfigFault, InvalidState, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunUuid", "String", lunUuid);
        getWsc().invoke("DetachScsiLun", paras, null);
    }

    public ManagedObjectReference detachScsiLunEx_Task(ManagedObjectReference _this, String[] lunUuid) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunUuid", "String[]", lunUuid);
        return (ManagedObjectReference) getWsc().invoke("DetachScsiLunEx_Task", paras, "ManagedObjectReference");
    }

    public void detachTagFromVStorageObject(ManagedObjectReference _this, ID id, String category, String tag) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("category", "String", category);
        paras[3] = new Argument("tag", "String", tag);
        getWsc().invoke("DetachTagFromVStorageObject", paras, null);
    }

    public String directPathProfileManagerCreate(ManagedObjectReference _this, DirectPathProfileManagerCreateSpec spec) throws java.rmi.RemoteException, AlreadyExists, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DirectPathProfileManagerCreateSpec", spec);
        return (String) getWsc().invoke("DirectPathProfileManagerCreate", paras, "String");
    }

    public void directPathProfileManagerDelete(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        getWsc().invoke("DirectPathProfileManagerDelete", paras, null);
    }

    public DirectPathProfileInfo[] directPathProfileManagerList(ManagedObjectReference _this, DirectPathProfileManagerFilterSpec filterSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filterSpec", "DirectPathProfileManagerFilterSpec", filterSpec);
        return (DirectPathProfileInfo[]) getWsc().invoke("DirectPathProfileManagerList", paras, "DirectPathProfileInfo[]");
    }

    public DirectPathProfileManagerCapacityResult[] directPathProfileManagerQueryCapacity(ManagedObjectReference _this, DirectPathProfileManagerTargetEntity target, DirectPathProfileManagerCapacityQuerySpec[] querySpec) throws java.rmi.RemoteException, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("target", "DirectPathProfileManagerTargetEntity", target);
        paras[2] = new Argument("querySpec", "DirectPathProfileManagerCapacityQuerySpec[]", querySpec);
        return (DirectPathProfileManagerCapacityResult[]) getWsc().invoke("DirectPathProfileManagerQueryCapacity", paras, "DirectPathProfileManagerCapacityResult[]");
    }

    public void directPathProfileManagerUpdate(ManagedObjectReference _this, String id, DirectPathProfileManagerUpdateSpec spec) throws java.rmi.RemoteException, AlreadyExists, InvalidArgument, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        paras[2] = new Argument("spec", "DirectPathProfileManagerUpdateSpec", spec);
        getWsc().invoke("DirectPathProfileManagerUpdate", paras, null);
    }

    public void disableAlarm(ManagedObjectReference _this, ManagedObjectReference alarm, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("alarm", "ManagedObjectReference", alarm);
        paras[2] = new Argument("entity", "ManagedObjectReference", entity);
        getWsc().invoke("DisableAlarm", paras, null);
    }

    public void disableClusteredVmdkSupport(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        getWsc().invoke("DisableClusteredVmdkSupport", paras, null);
    }

    public ManagedObjectReference disableEvcMode_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("DisableEvcMode_Task", paras, "ManagedObjectReference");
    }

    public boolean disableFeature(ManagedObjectReference _this, ManagedObjectReference host, String featureKey) throws java.rmi.RemoteException, InvalidState, LicenseServerUnavailable, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("featureKey", "String", featureKey);
        return (boolean) getWsc().invoke("DisableFeature", paras, "boolean");
    }

    public void disableHyperThreading(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DisableHyperThreading", paras, null);
    }

    public void disableMultipathPath(ManagedObjectReference _this, String pathName) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pathName", "String", pathName);
        getWsc().invoke("DisableMultipathPath", paras, null);
    }

    public ManagedObjectReference disableNetworkBoot_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("DisableNetworkBoot_Task", paras, "ManagedObjectReference");
    }

    public void disableRuleset(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        getWsc().invoke("DisableRuleset", paras, null);
    }

    public ManagedObjectReference disableSecondaryVM_Task(ManagedObjectReference _this, ManagedObjectReference vm) throws java.rmi.RemoteException, InvalidState, TaskInProgress, VmFaultToleranceIssue, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        return (ManagedObjectReference) getWsc().invoke("DisableSecondaryVM_Task", paras, "ManagedObjectReference");
    }

    public void disableSmartCardAuthentication(ManagedObjectReference _this) throws java.rmi.RemoteException, ActiveDirectoryFault, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DisableSmartCardAuthentication", paras, null);
    }

    public ManagedObjectReference disconnectHost_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("DisconnectHost_Task", paras, "ManagedObjectReference");
    }

    public void disconnectNvmeController(ManagedObjectReference _this, HostNvmeDisconnectSpec disconnectSpec) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("disconnectSpec", "HostNvmeDisconnectSpec", disconnectSpec);
        getWsc().invoke("DisconnectNvmeController", paras, null);
    }

    public ManagedObjectReference disconnectNvmeControllerEx_Task(ManagedObjectReference _this, HostNvmeDisconnectSpec[] disconnectSpec) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("disconnectSpec", "HostNvmeDisconnectSpec[]", disconnectSpec);
        return (ManagedObjectReference) getWsc().invoke("DisconnectNvmeControllerEx_Task", paras, "ManagedObjectReference");
    }

    public void discoverFcoeHbas(ManagedObjectReference _this, FcoeConfigFcoeSpecification fcoeSpec) throws java.rmi.RemoteException, FcoeFaultPnicHasNoPortSet, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("fcoeSpec", "FcoeConfigFcoeSpecification", fcoeSpec);
        getWsc().invoke("DiscoverFcoeHbas", paras, null);
    }

    public HostNvmeDiscoveryLog discoverNvmeControllers(ManagedObjectReference _this, HostNvmeDiscoverSpec discoverSpec) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("discoverSpec", "HostNvmeDiscoverSpec", discoverSpec);
        return (HostNvmeDiscoveryLog) getWsc().invoke("DiscoverNvmeControllers", paras, "HostNvmeDiscoveryLog");
    }

    public void dissociateProfile(ManagedObjectReference _this, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        getWsc().invoke("DissociateProfile", paras, null);
    }

    public boolean doesCustomizationSpecExist(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (boolean) getWsc().invoke("DoesCustomizationSpecExist", paras, "boolean");
    }

    public byte[] downloadDescriptionTree(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (byte[]) getWsc().invoke("DownloadDescriptionTree", paras, "byte[]");
    }

    public boolean dropConnections(ManagedObjectReference _this, VirtualMachineConnection[] listOfConnections) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("listOfConnections", "VirtualMachineConnection[]", listOfConnections);
        return (boolean) getWsc().invoke("DropConnections", paras, "boolean");
    }

    public void duplicateCustomizationSpec(ManagedObjectReference _this, String name, String newName) throws java.rmi.RemoteException, AlreadyExists, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("newName", "String", newName);
        getWsc().invoke("DuplicateCustomizationSpec", paras, null);
    }

    public ManagedObjectReference dVPortgroupRollback_Task(ManagedObjectReference _this, EntityBackupConfig entityBackup) throws java.rmi.RemoteException, DvsFault, RollbackFailure, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entityBackup", "EntityBackupConfig", entityBackup);
        return (ManagedObjectReference) getWsc().invoke("DVPortgroupRollback_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference dVSManagerExportEntity_Task(ManagedObjectReference _this, SelectionSet[] selectionSet) throws java.rmi.RemoteException, BackupBlobWriteFailure, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("selectionSet", "SelectionSet[]", selectionSet);
        return (ManagedObjectReference) getWsc().invoke("DVSManagerExportEntity_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference dVSManagerImportEntity_Task(ManagedObjectReference _this, EntityBackupConfig[] entityBackup, String importType) throws java.rmi.RemoteException, DvsFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entityBackup", "EntityBackupConfig[]", entityBackup);
        paras[2] = new Argument("importType", "String", importType);
        return (ManagedObjectReference) getWsc().invoke("DVSManagerImportEntity_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference dVSManagerLookupDvPortGroup(ManagedObjectReference _this, String switchUuid, String portgroupKey) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("switchUuid", "String", switchUuid);
        paras[2] = new Argument("portgroupKey", "String", portgroupKey);
        return (ManagedObjectReference) getWsc().invoke("DVSManagerLookupDvPortGroup", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference dvsReconfigureVmVnicNetworkResourcePool_Task(ManagedObjectReference _this, DvsVmVnicResourcePoolConfigSpec[] configSpec) throws java.rmi.RemoteException, ConcurrentAccess, ConflictingConfiguration, DvsFault, InvalidName, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configSpec", "DvsVmVnicResourcePoolConfigSpec[]", configSpec);
        return (ManagedObjectReference) getWsc().invoke("DvsReconfigureVmVnicNetworkResourcePool_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference dVSRollback_Task(ManagedObjectReference _this, EntityBackupConfig entityBackup) throws java.rmi.RemoteException, DvsFault, RollbackFailure, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entityBackup", "EntityBackupConfig", entityBackup);
        return (ManagedObjectReference) getWsc().invoke("DVSRollback_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference eagerZeroVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) getWsc().invoke("EagerZeroVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public void emitSyslogMark(ManagedObjectReference _this, String message) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("message", "String", message);
        getWsc().invoke("EmitSyslogMark", paras, null);
    }

    public void enableAlarm(ManagedObjectReference _this, ManagedObjectReference alarm, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("alarm", "ManagedObjectReference", alarm);
        paras[2] = new Argument("entity", "ManagedObjectReference", entity);
        getWsc().invoke("EnableAlarm", paras, null);
    }

    public void enableAlarmActions(ManagedObjectReference _this, ManagedObjectReference entity, boolean enabled) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("enabled", "boolean", enabled);
        getWsc().invoke("EnableAlarmActions", paras, null);
    }

    public void enableClusteredVmdkSupport(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        getWsc().invoke("EnableClusteredVmdkSupport", paras, null);
    }

    public void enableCrypto(ManagedObjectReference _this, CryptoKeyPlain keyPlain) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("keyPlain", "CryptoKeyPlain", keyPlain);
        getWsc().invoke("EnableCrypto", paras, null);
    }

    public boolean enableFeature(ManagedObjectReference _this, ManagedObjectReference host, String featureKey) throws java.rmi.RemoteException, InvalidState, LicenseServerUnavailable, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("featureKey", "String", featureKey);
        return (boolean) getWsc().invoke("EnableFeature", paras, "boolean");
    }

    public void enableHyperThreading(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("EnableHyperThreading", paras, null);
    }

    public void enableMultipathPath(ManagedObjectReference _this, String pathName) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pathName", "String", pathName);
        getWsc().invoke("EnableMultipathPath", paras, null);
    }

    public ManagedObjectReference enableNetworkBoot_Task(ManagedObjectReference _this, String networkBootMode) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("networkBootMode", "String", networkBootMode);
        return (ManagedObjectReference) getWsc().invoke("EnableNetworkBoot_Task", paras, "ManagedObjectReference");
    }

    public void enableNetworkResourceManagement(ManagedObjectReference _this, boolean enable) throws java.rmi.RemoteException, DvsFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("enable", "boolean", enable);
        getWsc().invoke("EnableNetworkResourceManagement", paras, null);
    }

    public void enableRuleset(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        getWsc().invoke("EnableRuleset", paras, null);
    }

    public ManagedObjectReference enableSecondaryVM_Task(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference host) throws java.rmi.RemoteException, InvalidState, TaskInProgress, VmConfigFault, VmFaultToleranceIssue, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("EnableSecondaryVM_Task", paras, "ManagedObjectReference");
    }

    public void enableSmartCardAuthentication(ManagedObjectReference _this) throws java.rmi.RemoteException, ActiveDirectoryFault, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("EnableSmartCardAuthentication", paras, null);
    }

    public void enterLockdownMode(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("EnterLockdownMode", paras, null);
    }

    public ManagedObjectReference enterMaintenanceMode_Task(ManagedObjectReference _this, int timeout, boolean evacuatePoweredOffVms, HostMaintenanceSpec maintenanceSpec) throws java.rmi.RemoteException, InvalidState, Timedout, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("timeout", "int", timeout);
        paras[2] = new Argument("evacuatePoweredOffVms", "boolean", evacuatePoweredOffVms);
        paras[3] = new Argument("maintenanceSpec", "HostMaintenanceSpec", maintenanceSpec);
        return (ManagedObjectReference) getWsc().invoke("EnterMaintenanceMode_Task", paras, "ManagedObjectReference");
    }

    public DatabaseSizeEstimate estimateDatabaseSize(ManagedObjectReference _this, DatabaseSizeParam dbSizeParam) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dbSizeParam", "DatabaseSizeParam", dbSizeParam);
        return (DatabaseSizeEstimate) getWsc().invoke("EstimateDatabaseSize", paras, "DatabaseSizeEstimate");
    }

    public ManagedObjectReference estimateStorageForConsolidateSnapshots_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, FileFault, InvalidState, TaskInProgress, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("EstimateStorageForConsolidateSnapshots_Task", paras, "ManagedObjectReference");
    }

    public void esxAgentHostManagerUpdateConfig(ManagedObjectReference _this, HostEsxAgentHostManagerConfigInfo configInfo) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configInfo", "HostEsxAgentHostManagerConfigInfo", configInfo);
        getWsc().invoke("EsxAgentHostManagerUpdateConfig", paras, null);
    }

    public ManagedObjectReference evacuateVsanNode_Task(ManagedObjectReference _this, HostMaintenanceSpec maintenanceSpec, int timeout) throws java.rmi.RemoteException, InvalidState, RequestCanceled, Timedout, VsanFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("maintenanceSpec", "HostMaintenanceSpec", maintenanceSpec);
        paras[2] = new Argument("timeout", "int", timeout);
        return (ManagedObjectReference) getWsc().invoke("EvacuateVsanNode_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference evcManager(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("EvcManager", paras, "ManagedObjectReference");
    }

    public ProfileExecuteResult executeHostProfile(ManagedObjectReference _this, ManagedObjectReference host, ProfileDeferredPolicyOptionParameter[] deferredParam) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("deferredParam", "ProfileDeferredPolicyOptionParameter[]", deferredParam);
        return (ProfileExecuteResult) getWsc().invoke("ExecuteHostProfile", paras, "ProfileExecuteResult");
    }

    public String executeSimpleCommand(ManagedObjectReference _this, String[] arguments) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("arguments", "String[]", arguments);
        return (String) getWsc().invoke("ExecuteSimpleCommand", paras, "String");
    }

    public void exitLockdownMode(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("ExitLockdownMode", paras, null);
    }

    public ManagedObjectReference exitMaintenanceMode_Task(ManagedObjectReference _this, int timeout) throws java.rmi.RemoteException, InvalidState, Timedout, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("timeout", "int", timeout);
        return (ManagedObjectReference) getWsc().invoke("ExitMaintenanceMode_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference expandVmfsDatastore(ManagedObjectReference _this, ManagedObjectReference datastore, VmfsDatastoreExpandSpec spec) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("spec", "VmfsDatastoreExpandSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("ExpandVmfsDatastore", paras, "ManagedObjectReference");
    }

    public void expandVmfsExtent(ManagedObjectReference _this, String vmfsPath, HostScsiDiskPartition extent) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsPath", "String", vmfsPath);
        paras[2] = new Argument("extent", "HostScsiDiskPartition", extent);
        getWsc().invoke("ExpandVmfsExtent", paras, null);
    }

    public ManagedObjectReference exportAnswerFile_Task(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("ExportAnswerFile_Task", paras, "ManagedObjectReference");
    }

    public String exportProfile(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) getWsc().invoke("ExportProfile", paras, "String");
    }

    public ManagedObjectReference exportSnapshot(ManagedObjectReference _this) throws java.rmi.RemoteException, FileFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("ExportSnapshot", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference exportVApp(ManagedObjectReference _this) throws java.rmi.RemoteException, FileFault, InvalidPowerState, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("ExportVApp", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference exportVm(ManagedObjectReference _this) throws java.rmi.RemoteException, FileFault, InvalidPowerState, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("ExportVm", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference extendDisk_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, long newCapacityInMB) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("newCapacityInMB", "long", newCapacityInMB);
        return (ManagedObjectReference) getWsc().invoke("ExtendDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference extendHCI_Task(ManagedObjectReference _this, ClusterComputeResourceHostConfigurationInput[] hostInputs, SDDCBase vSanConfigSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hostInputs", "ClusterComputeResourceHostConfigurationInput[]", hostInputs);
        paras[2] = new Argument("vSanConfigSpec", "SDDCBase", vSanConfigSpec);
        return (ManagedObjectReference) getWsc().invoke("ExtendHCI_Task", paras, "ManagedObjectReference");
    }

    public void extendVffs(ManagedObjectReference _this, String vffsPath, String devicePath, HostDiskPartitionSpec spec) throws java.rmi.RemoteException, HostConfigFault, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsPath", "String", vffsPath);
        paras[2] = new Argument("devicePath", "String", devicePath);
        paras[3] = new Argument("spec", "HostDiskPartitionSpec", spec);
        getWsc().invoke("ExtendVffs", paras, null);
    }

    public ManagedObjectReference extendVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, long newCapacityKb, boolean eagerZero) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("newCapacityKb", "long", newCapacityKb);
        paras[4] = new Argument("eagerZero", "boolean", eagerZero);
        return (ManagedObjectReference) getWsc().invoke("ExtendVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference extendVmfsDatastore(ManagedObjectReference _this, ManagedObjectReference datastore, VmfsDatastoreExtendSpec spec) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("spec", "VmfsDatastoreExtendSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("ExtendVmfsDatastore", paras, "ManagedObjectReference");
    }

    public String extractOvfEnvironment(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) getWsc().invoke("ExtractOvfEnvironment", paras, "String");
    }

    public DiagnosticManagerAuditRecordResult fetchAuditRecords(ManagedObjectReference _this, String token) throws java.rmi.RemoteException, InvalidState, SystemError, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("token", "String", token);
        return (DiagnosticManagerAuditRecordResult) getWsc().invoke("FetchAuditRecords", paras, "DiagnosticManagerAuditRecordResult");
    }

    public String[] fetchDVPortKeys(ManagedObjectReference _this, DistributedVirtualSwitchPortCriteria criteria) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("criteria", "DistributedVirtualSwitchPortCriteria", criteria);
        return (String[]) getWsc().invoke("FetchDVPortKeys", paras, "String[]");
    }

    public DistributedVirtualPort[] fetchDVPorts(ManagedObjectReference _this, DistributedVirtualSwitchPortCriteria criteria) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("criteria", "DistributedVirtualSwitchPortCriteria", criteria);
        return (DistributedVirtualPort[]) getWsc().invoke("FetchDVPorts", paras, "DistributedVirtualPort[]");
    }

    public SoftwarePackage[] fetchSoftwarePackages(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (SoftwarePackage[]) getWsc().invoke("fetchSoftwarePackages", paras, "SoftwarePackage[]");
    }

    public SystemEventInfo[] fetchSystemEventLog(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (SystemEventInfo[]) getWsc().invoke("FetchSystemEventLog", paras, "SystemEventInfo[]");
    }

    public UserPrivilegeResult[] fetchUserPrivilegeOnEntities(ManagedObjectReference _this, ManagedObjectReference[] entities, String userName) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entities", "ManagedObjectReference[]", entities);
        paras[2] = new Argument("userName", "String", userName);
        return (UserPrivilegeResult[]) getWsc().invoke("FetchUserPrivilegeOnEntities", paras, "UserPrivilegeResult[]");
    }

    public ManagedObjectReference[] findAllByDnsName(ManagedObjectReference _this, ManagedObjectReference datacenter, String dnsName, boolean vmSearch) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("dnsName", "String", dnsName);
        paras[3] = new Argument("vmSearch", "boolean", vmSearch);
        return (ManagedObjectReference[]) getWsc().invoke("FindAllByDnsName", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference[] findAllByIp(ManagedObjectReference _this, ManagedObjectReference datacenter, String ip, boolean vmSearch) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("ip", "String", ip);
        paras[3] = new Argument("vmSearch", "boolean", vmSearch);
        return (ManagedObjectReference[]) getWsc().invoke("FindAllByIp", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference[] findAllByUuid(ManagedObjectReference _this, ManagedObjectReference datacenter, String uuid, boolean vmSearch, boolean instanceUuid) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("uuid", "String", uuid);
        paras[3] = new Argument("vmSearch", "boolean", vmSearch);
        paras[4] = new Argument("instanceUuid", "boolean", instanceUuid);
        return (ManagedObjectReference[]) getWsc().invoke("FindAllByUuid", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference[] findAssociatedProfile(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        return (ManagedObjectReference[]) getWsc().invoke("FindAssociatedProfile", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference findByDatastorePath(ManagedObjectReference _this, ManagedObjectReference datacenter, String path) throws java.rmi.RemoteException, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("path", "String", path);
        return (ManagedObjectReference) getWsc().invoke("FindByDatastorePath", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference findByDnsName(ManagedObjectReference _this, ManagedObjectReference datacenter, String dnsName, boolean vmSearch) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("dnsName", "String", dnsName);
        paras[3] = new Argument("vmSearch", "boolean", vmSearch);
        return (ManagedObjectReference) getWsc().invoke("FindByDnsName", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference findByInventoryPath(ManagedObjectReference _this, String inventoryPath) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("inventoryPath", "String", inventoryPath);
        return (ManagedObjectReference) getWsc().invoke("FindByInventoryPath", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference findByIp(ManagedObjectReference _this, ManagedObjectReference datacenter, String ip, boolean vmSearch) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("ip", "String", ip);
        paras[3] = new Argument("vmSearch", "boolean", vmSearch);
        return (ManagedObjectReference) getWsc().invoke("FindByIp", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference findByUuid(ManagedObjectReference _this, ManagedObjectReference datacenter, String uuid, boolean vmSearch, boolean instanceUuid) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("uuid", "String", uuid);
        paras[3] = new Argument("vmSearch", "boolean", vmSearch);
        paras[4] = new Argument("instanceUuid", "boolean", instanceUuid);
        return (ManagedObjectReference) getWsc().invoke("FindByUuid", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference findChild(ManagedObjectReference _this, ManagedObjectReference entity, String name) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("name", "String", name);
        return (ManagedObjectReference) getWsc().invoke("FindChild", paras, "ManagedObjectReference");
    }

    public Extension findExtension(ManagedObjectReference _this, String extensionKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        return (Extension) getWsc().invoke("FindExtension", paras, "Extension");
    }

    public ClusterRuleInfo[] findRulesForVm(ManagedObjectReference _this, ManagedObjectReference vm) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        return (ClusterRuleInfo[]) getWsc().invoke("FindRulesForVm", paras, "ClusterRuleInfo[]");
    }

    public HostVffsVolume formatVffs(ManagedObjectReference _this, HostVffsSpec createSpec) throws java.rmi.RemoteException, AlreadyExists, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("createSpec", "HostVffsSpec", createSpec);
        return (HostVffsVolume) getWsc().invoke("FormatVffs", paras, "HostVffsVolume");
    }

    public HostVmfsVolume formatVmfs(ManagedObjectReference _this, HostVmfsSpec createSpec) throws java.rmi.RemoteException, AlreadyExists, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("createSpec", "HostVmfsSpec", createSpec);
        return (HostVmfsVolume) getWsc().invoke("FormatVmfs", paras, "HostVmfsVolume");
    }

    public String generateCertificateSigningRequest(ManagedObjectReference _this, boolean useIpAddressAsCommonName, HostCertificateManagerCertificateSpec spec) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("useIpAddressAsCommonName", "boolean", useIpAddressAsCommonName);
        paras[2] = new Argument("spec", "HostCertificateManagerCertificateSpec", spec);
        return (String) getWsc().invoke("GenerateCertificateSigningRequest", paras, "String");
    }

    public String generateCertificateSigningRequestByDn(ManagedObjectReference _this, String distinguishedName, HostCertificateManagerCertificateSpec spec) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("distinguishedName", "String", distinguishedName);
        paras[2] = new Argument("spec", "HostCertificateManagerCertificateSpec", spec);
        return (String) getWsc().invoke("GenerateCertificateSigningRequestByDn", paras, "String");
    }

    public String generateClientCsr(ManagedObjectReference _this, KeyProviderId cluster, CryptoManagerKmipCertSignRequest request) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cluster", "KeyProviderId", cluster);
        paras[2] = new Argument("request", "CryptoManagerKmipCertSignRequest", request);
        return (String) getWsc().invoke("GenerateClientCsr", paras, "String");
    }

    public HostProfileManagerConfigTaskList generateConfigTaskList(ManagedObjectReference _this, HostConfigSpec configSpec, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configSpec", "HostConfigSpec", configSpec);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (HostProfileManagerConfigTaskList) getWsc().invoke("GenerateConfigTaskList", paras, "HostProfileManagerConfigTaskList");
    }

    public ManagedObjectReference generateHostConfigTaskSpec_Task(ManagedObjectReference _this, StructuredCustomizations[] hostsInfo) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hostsInfo", "StructuredCustomizations[]", hostsInfo);
        return (ManagedObjectReference) getWsc().invoke("GenerateHostConfigTaskSpec_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference generateHostProfileTaskList_Task(ManagedObjectReference _this, HostConfigSpec configSpec, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configSpec", "HostConfigSpec", configSpec);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("GenerateHostProfileTaskList_Task", paras, "ManagedObjectReference");
    }

    public CryptoKeyResult generateKey(ManagedObjectReference _this, KeyProviderId keyProvider, CryptoManagerKmipCustomAttributeSpec spec, CryptoManagerKmipGenerateKeySpec keySpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("keyProvider", "KeyProviderId", keyProvider);
        paras[2] = new Argument("spec", "CryptoManagerKmipCustomAttributeSpec", spec);
        paras[3] = new Argument("keySpec", "CryptoManagerKmipGenerateKeySpec", keySpec);
        return (CryptoKeyResult) getWsc().invoke("GenerateKey", paras, "CryptoKeyResult");
    }

    public ManagedObjectReference generateLogBundles_Task(ManagedObjectReference _this, boolean includeDefault, ManagedObjectReference[] host) throws java.rmi.RemoteException, LogBundlingFailed, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("includeDefault", "boolean", includeDefault);
        paras[2] = new Argument("host", "ManagedObjectReference[]", host);
        return (ManagedObjectReference) getWsc().invoke("GenerateLogBundles_Task", paras, "ManagedObjectReference");
    }

    public String generateSelfSignedClientCert(ManagedObjectReference _this, KeyProviderId cluster, CryptoManagerKmipCertSignRequest request) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cluster", "KeyProviderId", cluster);
        paras[2] = new Argument("request", "CryptoManagerKmipCertSignRequest", request);
        return (String) getWsc().invoke("GenerateSelfSignedClientCert", paras, "String");
    }

    public ManagedObjectReference[] getAlarm(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        return (ManagedObjectReference[]) getWsc().invoke("GetAlarm", paras, "ManagedObjectReference[]");
    }

    public AlarmState[] getAlarmState(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        return (AlarmState[]) getWsc().invoke("GetAlarmState", paras, "AlarmState[]");
    }

    public String getClusterMode(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) getWsc().invoke("getClusterMode", paras, "String");
    }

    public CryptoManagerHostKeyStatus[] getCryptoKeyStatus(ManagedObjectReference _this, CryptoKeyId[] keys) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("keys", "CryptoKeyId[]", keys);
        return (CryptoManagerHostKeyStatus[]) getWsc().invoke("GetCryptoKeyStatus", paras, "CryptoManagerHostKeyStatus[]");
    }

    public CustomizationSpecItem getCustomizationSpec(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (CustomizationSpecItem) getWsc().invoke("GetCustomizationSpec", paras, "CustomizationSpecItem");
    }

    public KeyProviderId getDefaultKmsCluster(ManagedObjectReference _this, ManagedObjectReference entity, boolean defaultsToParent) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("defaultsToParent", "boolean", defaultsToParent);
        return (KeyProviderId) getWsc().invoke("GetDefaultKmsCluster", paras, "KeyProviderId");
    }

    public String getPublicKey(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) getWsc().invoke("GetPublicKey", paras, "String");
    }

    public ClusterResourceUsageSummary getResourceUsage(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ClusterResourceUsageSummary) getWsc().invoke("GetResourceUsage", paras, "ClusterResourceUsageSummary");
    }

    public SiteInfo getSiteInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (SiteInfo) getWsc().invoke("GetSiteInfo", paras, "SiteInfo");
    }

    public ManagedObjectReference[] getSystemVMsRestrictedDatastores(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference[]) getWsc().invoke("GetSystemVMsRestrictedDatastores", paras, "ManagedObjectReference[]");
    }

    public VchaClusterHealth getVchaClusterHealth(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VchaClusterHealth) getWsc().invoke("GetVchaClusterHealth", paras, "VchaClusterHealth");
    }

    public VchaClusterConfigInfo getVchaConfig(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VchaClusterConfigInfo) getWsc().invoke("getVchaConfig", paras, "VchaClusterConfigInfo");
    }

    public String getVsanObjExtAttrs(ManagedObjectReference _this, String[] uuids) throws java.rmi.RemoteException, VimFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("uuids", "String[]", uuids);
        return (String) getWsc().invoke("GetVsanObjExtAttrs", paras, "String");
    }

    public boolean hasMonitoredEntity(ManagedObjectReference _this, String providerId, ManagedObjectReference entity) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("providerId", "String", providerId);
        paras[2] = new Argument("entity", "ManagedObjectReference", entity);
        return (boolean) getWsc().invoke("HasMonitoredEntity", paras, "boolean");
    }

    public EntityPrivilege[] hasPrivilegeOnEntities(ManagedObjectReference _this, ManagedObjectReference[] entity, String sessionId, String[] privId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        paras[2] = new Argument("sessionId", "String", sessionId);
        paras[3] = new Argument("privId", "String[]", privId);
        return (EntityPrivilege[]) getWsc().invoke("HasPrivilegeOnEntities", paras, "EntityPrivilege[]");
    }

    public boolean[] hasPrivilegeOnEntity(ManagedObjectReference _this, ManagedObjectReference entity, String sessionId, String[] privId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("sessionId", "String", sessionId);
        paras[3] = new Argument("privId", "String[]", privId);
        return (boolean[]) getWsc().invoke("HasPrivilegeOnEntity", paras, "boolean[]");
    }

    public boolean hasProvider(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        return (boolean) getWsc().invoke("HasProvider", paras, "boolean");
    }

    public EntityPrivilege[] hasUserPrivilegeOnEntities(ManagedObjectReference _this, ManagedObjectReference[] entities, String userName, String[] privId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entities", "ManagedObjectReference[]", entities);
        paras[2] = new Argument("userName", "String", userName);
        paras[3] = new Argument("privId", "String[]", privId);
        return (EntityPrivilege[]) getWsc().invoke("HasUserPrivilegeOnEntities", paras, "EntityPrivilege[]");
    }

    public void hostClearVStorageObjectControlFlags(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, String[] controlFlags) throws java.rmi.RemoteException, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("controlFlags", "String[]", controlFlags);
        getWsc().invoke("HostClearVStorageObjectControlFlags", paras, null);
    }

    public ManagedObjectReference hostCloneVStorageObject_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, VslmCloneSpec spec) throws java.rmi.RemoteException, FileFault, InvalidDatastore, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("spec", "VslmCloneSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("HostCloneVStorageObject_Task", paras, "ManagedObjectReference");
    }

    public void hostConfigureVFlashResource(ManagedObjectReference _this, HostVFlashManagerVFlashResourceConfigSpec spec) throws java.rmi.RemoteException, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostVFlashManagerVFlashResourceConfigSpec", spec);
        getWsc().invoke("HostConfigureVFlashResource", paras, null);
    }

    public void hostConfigVFlashCache(ManagedObjectReference _this, HostVFlashManagerVFlashCacheConfigSpec spec) throws java.rmi.RemoteException, HostConfigFault, InaccessibleVFlashSource, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostVFlashManagerVFlashCacheConfigSpec", spec);
        getWsc().invoke("HostConfigVFlashCache", paras, null);
    }

    public ManagedObjectReference hostCreateDisk_Task(ManagedObjectReference _this, VslmCreateSpec spec) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VslmCreateSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("HostCreateDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference hostDeleteVStorageObject_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (ManagedObjectReference) getWsc().invoke("HostDeleteVStorageObject_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference hostDeleteVStorageObjectEx_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (ManagedObjectReference) getWsc().invoke("HostDeleteVStorageObjectEx_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference hostExtendDisk_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, long newCapacityInMB) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("newCapacityInMB", "long", newCapacityInMB);
        return (ManagedObjectReference) getWsc().invoke("HostExtendDisk_Task", paras, "ManagedObjectReference");
    }

    public VirtualDiskVFlashCacheConfigInfo hostGetVFlashModuleDefaultConfig(ManagedObjectReference _this, String vFlashModule) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vFlashModule", "String", vFlashModule);
        return (VirtualDiskVFlashCacheConfigInfo) getWsc().invoke("HostGetVFlashModuleDefaultConfig", paras, "VirtualDiskVFlashCacheConfigInfo");
    }

    public String hostImageConfigGetAcceptance(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) getWsc().invoke("HostImageConfigGetAcceptance", paras, "String");
    }

    public HostImageProfileSummary hostImageConfigGetProfile(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostImageProfileSummary) getWsc().invoke("HostImageConfigGetProfile", paras, "HostImageProfileSummary");
    }

    public ManagedObjectReference hostInflateDisk_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (ManagedObjectReference) getWsc().invoke("HostInflateDisk_Task", paras, "ManagedObjectReference");
    }

    public ID[] hostListVStorageObject(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (ID[]) getWsc().invoke("HostListVStorageObject", paras, "ID[]");
    }

    public void hostProfileResetValidationState(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("HostProfileResetValidationState", paras, null);
    }

    public String hostQueryVirtualDiskUuid(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (String) getWsc().invoke("HostQueryVirtualDiskUuid", paras, "String");
    }

    public ManagedObjectReference hostReconcileDatastoreInventory_Task(ManagedObjectReference _this, ManagedObjectReference datastore, boolean deepCleansing) throws java.rmi.RemoteException, InvalidDatastore, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("deepCleansing", "boolean", deepCleansing);
        return (ManagedObjectReference) getWsc().invoke("HostReconcileDatastoreInventory_Task", paras, "ManagedObjectReference");
    }

    public VStorageObject hostRegisterDisk(ManagedObjectReference _this, String path, String name, boolean modifyControlFlags) throws java.rmi.RemoteException, AlreadyExists, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("path", "String", path);
        paras[2] = new Argument("name", "String", name);
        paras[3] = new Argument("modifyControlFlags", "boolean", modifyControlFlags);
        return (VStorageObject) getWsc().invoke("HostRegisterDisk", paras, "VStorageObject");
    }

    public ManagedObjectReference hostRelocateVStorageObject_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, VslmRelocateSpec spec) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("spec", "VslmRelocateSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("HostRelocateVStorageObject_Task", paras, "ManagedObjectReference");
    }

    public void hostRemoveVFlashResource(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("HostRemoveVFlashResource", paras, null);
    }

    public void hostRenameVStorageObject(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, String name) throws java.rmi.RemoteException, FileFault, InvalidDatastore, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("name", "String", name);
        getWsc().invoke("HostRenameVStorageObject", paras, null);
    }

    public vslmInfrastructureObjectPolicy[] hostRetrieveVStorageInfrastructureObjectPolicy(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (vslmInfrastructureObjectPolicy[]) getWsc().invoke("HostRetrieveVStorageInfrastructureObjectPolicy", paras, "vslmInfrastructureObjectPolicy[]");
    }

    public VStorageObject hostRetrieveVStorageObject(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, String[] diskInfoFlags) throws java.rmi.RemoteException, FileFault, InvalidDatastore, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("diskInfoFlags", "String[]", diskInfoFlags);
        return (VStorageObject) getWsc().invoke("HostRetrieveVStorageObject", paras, "VStorageObject");
    }

    public KeyValue[] hostRetrieveVStorageObjectMetadata(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, ID snapshotId, String prefix) throws java.rmi.RemoteException, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("snapshotId", "ID", snapshotId);
        paras[4] = new Argument("prefix", "String", prefix);
        return (KeyValue[]) getWsc().invoke("HostRetrieveVStorageObjectMetadata", paras, "KeyValue[]");
    }

    public String hostRetrieveVStorageObjectMetadataValue(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, ID snapshotId, String key) throws java.rmi.RemoteException, InvalidDatastore, InvalidState, KeyNotFound, NotFound, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("snapshotId", "ID", snapshotId);
        paras[4] = new Argument("key", "String", key);
        return (String) getWsc().invoke("HostRetrieveVStorageObjectMetadataValue", paras, "String");
    }

    public VStorageObjectStateInfo hostRetrieveVStorageObjectState(ManagedObjectReference _this, ID id, ManagedObjectReference datastore) throws java.rmi.RemoteException, FileFault, InvalidDatastore, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (VStorageObjectStateInfo) getWsc().invoke("HostRetrieveVStorageObjectState", paras, "VStorageObjectStateInfo");
    }

    public void hostScheduleReconcileDatastoreInventory(ManagedObjectReference _this, ManagedObjectReference datastore, boolean deepCleansing) throws java.rmi.RemoteException, InvalidDatastore, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("deepCleansing", "boolean", deepCleansing);
        getWsc().invoke("HostScheduleReconcileDatastoreInventory", paras, null);
    }

    public ManagedObjectReference hostSetVirtualDiskUuid_Task(ManagedObjectReference _this, String name, String uuid) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("uuid", "String", uuid);
        return (ManagedObjectReference) getWsc().invoke("HostSetVirtualDiskUuid_Task", paras, "ManagedObjectReference");
    }

    public void hostSetVStorageObjectControlFlags(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, String[] controlFlags) throws java.rmi.RemoteException, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("controlFlags", "String[]", controlFlags);
        getWsc().invoke("HostSetVStorageObjectControlFlags", paras, null);
    }

    public ManagedObjectReference[] hostSpecGetUpdatedHosts(ManagedObjectReference _this, String startChangeID, String endChangeID) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("startChangeID", "String", startChangeID);
        paras[2] = new Argument("endChangeID", "String", endChangeID);
        return (ManagedObjectReference[]) getWsc().invoke("HostSpecGetUpdatedHosts", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference hostUpdateVStorageObjectMetadata_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, KeyValue[] metadata, String[] deleteKeys) throws java.rmi.RemoteException, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("metadata", "KeyValue[]", metadata);
        paras[4] = new Argument("deleteKeys", "String[]", deleteKeys);
        return (ManagedObjectReference) getWsc().invoke("HostUpdateVStorageObjectMetadata_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference hostUpdateVStorageObjectMetadataEx_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, KeyValue[] metadata, String[] deleteKeys) throws java.rmi.RemoteException, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("metadata", "KeyValue[]", metadata);
        paras[4] = new Argument("deleteKeys", "String[]", deleteKeys);
        return (ManagedObjectReference) getWsc().invoke("HostUpdateVStorageObjectMetadataEx_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference hostVStorageObjectCreateDiskFromSnapshot_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, ID snapshotId, String name, VirtualMachineProfileSpec[] profile, CryptoSpec crypto, String path, String provisioningType) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[9];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("snapshotId", "ID", snapshotId);
        paras[4] = new Argument("name", "String", name);
        paras[5] = new Argument("profile", "VirtualMachineProfileSpec[]", profile);
        paras[6] = new Argument("crypto", "CryptoSpec", crypto);
        paras[7] = new Argument("path", "String", path);
        paras[8] = new Argument("provisioningType", "String", provisioningType);
        return (ManagedObjectReference) getWsc().invoke("HostVStorageObjectCreateDiskFromSnapshot_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference hostVStorageObjectCreateSnapshot_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, String description) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("description", "String", description);
        return (ManagedObjectReference) getWsc().invoke("HostVStorageObjectCreateSnapshot_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference hostVStorageObjectDeleteSnapshot_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, ID snapshotId) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("snapshotId", "ID", snapshotId);
        return (ManagedObjectReference) getWsc().invoke("HostVStorageObjectDeleteSnapshot_Task", paras, "ManagedObjectReference");
    }

    public VStorageObjectSnapshotInfo hostVStorageObjectRetrieveSnapshotInfo(ManagedObjectReference _this, ID id, ManagedObjectReference datastore) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (VStorageObjectSnapshotInfo) getWsc().invoke("HostVStorageObjectRetrieveSnapshotInfo", paras, "VStorageObjectSnapshotInfo");
    }

    public ManagedObjectReference hostVStorageObjectRevert_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, ID snapshotId) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("snapshotId", "ID", snapshotId);
        return (ManagedObjectReference) getWsc().invoke("HostVStorageObjectRevert_Task", paras, "ManagedObjectReference");
    }

    public void httpNfcLeaseAbort(ManagedObjectReference _this, LocalizedMethodFault fault) throws java.rmi.RemoteException, InvalidState, Timedout, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("fault", "LocalizedMethodFault", fault);
        getWsc().invoke("HttpNfcLeaseAbort", paras, null);
    }

    public void httpNfcLeaseComplete(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, Timedout, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("HttpNfcLeaseComplete", paras, null);
    }

    public HttpNfcLeaseManifestEntry[] httpNfcLeaseGetManifest(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, Timedout, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HttpNfcLeaseManifestEntry[]) getWsc().invoke("HttpNfcLeaseGetManifest", paras, "HttpNfcLeaseManifestEntry[]");
    }

    public HttpNfcLeaseProbeResult[] httpNfcLeaseProbeUrls(ManagedObjectReference _this, HttpNfcLeaseSourceFile[] files, int timeout) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("files", "HttpNfcLeaseSourceFile[]", files);
        paras[2] = new Argument("timeout", "int", timeout);
        return (HttpNfcLeaseProbeResult[]) getWsc().invoke("HttpNfcLeaseProbeUrls", paras, "HttpNfcLeaseProbeResult[]");
    }

    public void httpNfcLeaseProgress(ManagedObjectReference _this, int percent) throws java.rmi.RemoteException, Timedout, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("percent", "int", percent);
        getWsc().invoke("HttpNfcLeaseProgress", paras, null);
    }

    public ManagedObjectReference httpNfcLeasePullFromUrls_Task(ManagedObjectReference _this, HttpNfcLeaseSourceFile[] files) throws java.rmi.RemoteException, HttpFault, InvalidState, SSLVerifyFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("files", "HttpNfcLeaseSourceFile[]", files);
        return (ManagedObjectReference) getWsc().invoke("HttpNfcLeasePullFromUrls_Task", paras, "ManagedObjectReference");
    }

    public void httpNfcLeaseSetManifestChecksumType(ManagedObjectReference _this, KeyValue[] deviceUrlsToChecksumTypes) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("deviceUrlsToChecksumTypes", "KeyValue[]", deviceUrlsToChecksumTypes);
        getWsc().invoke("HttpNfcLeaseSetManifestChecksumType", paras, null);
    }

    public UserSession impersonateUser(ManagedObjectReference _this, String userName, String locale) throws java.rmi.RemoteException, InvalidLocale, InvalidLogin, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("userName", "String", userName);
        paras[2] = new Argument("locale", "String", locale);
        return (UserSession) getWsc().invoke("ImpersonateUser", paras, "UserSession");
    }

    public ManagedObjectReference importCertificateForCAM_Task(ManagedObjectReference _this, String certPath, String camServer) throws java.rmi.RemoteException, ActiveDirectoryFault, FileNotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("certPath", "String", certPath);
        paras[2] = new Argument("camServer", "String", camServer);
        return (ManagedObjectReference) getWsc().invoke("ImportCertificateForCAM_Task", paras, "ManagedObjectReference");
    }

    public void importUnmanagedSnapshot(ManagedObjectReference _this, String vdisk, ManagedObjectReference datacenter, String vvolId) throws java.rmi.RemoteException, InvalidDatastore, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vdisk", "String", vdisk);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("vvolId", "String", vvolId);
        getWsc().invoke("ImportUnmanagedSnapshot", paras, null);
    }

    public ManagedObjectReference importVApp(ManagedObjectReference _this, ImportSpec spec, ManagedObjectReference folder, ManagedObjectReference host) throws java.rmi.RemoteException, DuplicateName, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidName, OutOfBounds, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "ImportSpec", spec);
        paras[2] = new Argument("folder", "ManagedObjectReference", folder);
        paras[3] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("ImportVApp", paras, "ManagedObjectReference");
    }

    public void increaseDirectorySize(ManagedObjectReference _this, ManagedObjectReference datacenter, String stableName, long size) throws java.rmi.RemoteException, FileFault, FileNotFound, InvalidArgument, InvalidDatastore, NotSupported, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("stableName", "String", stableName);
        paras[3] = new Argument("size", "long", size);
        getWsc().invoke("IncreaseDirectorySize", paras, null);
    }

    public ManagedObjectReference inflateDisk_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (ManagedObjectReference) getWsc().invoke("InflateDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference inflateVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) getWsc().invoke("InflateVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference initializeDisks_Task(ManagedObjectReference _this, VsanHostDiskMapping[] mapping) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("mapping", "VsanHostDiskMapping[]", mapping);
        return (ManagedObjectReference) getWsc().invoke("InitializeDisks_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference initiateFailover_Task(ManagedObjectReference _this, boolean planned) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("planned", "boolean", planned);
        return (ManagedObjectReference) getWsc().invoke("initiateFailover_Task", paras, "ManagedObjectReference");
    }

    public FileTransferInformation initiateFileTransferFromGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String guestFilePath) throws java.rmi.RemoteException, FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("guestFilePath", "String", guestFilePath);
        return (FileTransferInformation) getWsc().invoke("InitiateFileTransferFromGuest", paras, "FileTransferInformation");
    }

    public String initiateFileTransferToGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String guestFilePath, GuestFileAttributes fileAttributes, long fileSize, boolean overwrite) throws java.rmi.RemoteException, FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[7];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("guestFilePath", "String", guestFilePath);
        paras[4] = new Argument("fileAttributes", "GuestFileAttributes", fileAttributes);
        paras[5] = new Argument("fileSize", "long", fileSize);
        paras[6] = new Argument("overwrite", "boolean", overwrite);
        return (String) getWsc().invoke("InitiateFileTransferToGuest", paras, "String");
    }

    public ManagedObjectReference initiateTransitionToVLCM_Task(ManagedObjectReference _this, ManagedObjectReference cluster) throws java.rmi.RemoteException, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cluster", "ManagedObjectReference", cluster);
        return (ManagedObjectReference) getWsc().invoke("InitiateTransitionToVLCM_Task", paras, "ManagedObjectReference");
    }

    public Calendar installDate(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (Calendar) getWsc().invoke("installDate", paras, "Calendar");
    }

    public ManagedObjectReference installHostPatch_Task(ManagedObjectReference _this, HostPatchManagerLocator repository, String updateID, boolean force) throws java.rmi.RemoteException, InvalidState, NoDiskSpace, PatchBinariesNotFound, PatchInstallFailed, PatchMetadataInvalid, PatchNotApplicable, RebootRequired, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("repository", "HostPatchManagerLocator", repository);
        paras[2] = new Argument("updateID", "String", updateID);
        paras[3] = new Argument("force", "boolean", force);
        return (ManagedObjectReference) getWsc().invoke("InstallHostPatch_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference installHostPatchV2_Task(ManagedObjectReference _this, String[] metaUrls, String[] bundleUrls, String[] vibUrls, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, InvalidState, PlatformConfigFault, RequestCanceled, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("metaUrls", "String[]", metaUrls);
        paras[2] = new Argument("bundleUrls", "String[]", bundleUrls);
        paras[3] = new Argument("vibUrls", "String[]", vibUrls);
        paras[4] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("InstallHostPatchV2_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference installIoFilter_Task(ManagedObjectReference _this, String vibUrl, ManagedObjectReference compRes, IoFilterManagerSslTrust vibSslTrust) throws java.rmi.RemoteException, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vibUrl", "String", vibUrl);
        paras[2] = new Argument("compRes", "ManagedObjectReference", compRes);
        paras[3] = new Argument("vibSslTrust", "IoFilterManagerSslTrust", vibSslTrust);
        return (ManagedObjectReference) getWsc().invoke("InstallIoFilter_Task", paras, "ManagedObjectReference");
    }

    public void installServerCertificate(ManagedObjectReference _this, String cert) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cert", "String", cert);
        getWsc().invoke("InstallServerCertificate", paras, null);
    }

    public void installSmartCardTrustAnchor(ManagedObjectReference _this, String cert) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cert", "String", cert);
        getWsc().invoke("InstallSmartCardTrustAnchor", paras, null);
    }

    public ManagedObjectReference instantClone_Task(ManagedObjectReference _this, VirtualMachineInstantCloneSpec spec) throws java.rmi.RemoteException, DisallowedMigrationDeviceAttached, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VirtualMachineInstantCloneSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("InstantClone_Task", paras, "ManagedObjectReference");
    }

    public boolean isClusteredVmdkEnabled(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (boolean) getWsc().invoke("IsClusteredVmdkEnabled", paras, "boolean");
    }

    public boolean isGuestOsCustomizable(ManagedObjectReference _this, String guestId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("guestId", "String", guestId);
        return (boolean) getWsc().invoke("IsGuestOsCustomizable", paras, "boolean");
    }

    public boolean isKmsClusterActive(ManagedObjectReference _this, KeyProviderId cluster) throws java.rmi.RemoteException, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cluster", "KeyProviderId", cluster);
        return (boolean) getWsc().invoke("IsKmsClusterActive", paras, "boolean");
    }

    public boolean isSharedGraphicsActive(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (boolean) getWsc().invoke("IsSharedGraphicsActive", paras, "boolean");
    }

    public ManagedObjectReference joinDomain_Task(ManagedObjectReference _this, String domainName, String userName, String password) throws java.rmi.RemoteException, ActiveDirectoryFault, HostConfigFault, InvalidLogin, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("domainName", "String", domainName);
        paras[2] = new Argument("userName", "String", userName);
        paras[3] = new Argument("password", "String", password);
        return (ManagedObjectReference) getWsc().invoke("JoinDomain_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference joinDomainWithCAM_Task(ManagedObjectReference _this, String domainName, String camServer) throws java.rmi.RemoteException, ActiveDirectoryFault, HostConfigFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("domainName", "String", domainName);
        paras[2] = new Argument("camServer", "String", camServer);
        return (ManagedObjectReference) getWsc().invoke("JoinDomainWithCAM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference leaveCurrentDomain_Task(ManagedObjectReference _this, boolean force) throws java.rmi.RemoteException, ActiveDirectoryFault, AuthMinimumAdminPermission, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("force", "boolean", force);
        return (ManagedObjectReference) getWsc().invoke("LeaveCurrentDomain_Task", paras, "ManagedObjectReference");
    }

    public String[] listCACertificateRevocationLists(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String[]) getWsc().invoke("ListCACertificateRevocationLists", paras, "String[]");
    }

    public String[] listCACertificates(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String[]) getWsc().invoke("ListCACertificates", paras, "String[]");
    }

    public GuestListFileInfo listFilesInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String filePath, int index, int maxResults, String matchPattern) throws java.rmi.RemoteException, FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[7];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("filePath", "String", filePath);
        paras[4] = new Argument("index", "int", index);
        paras[5] = new Argument("maxResults", "int", maxResults);
        paras[6] = new Argument("matchPattern", "String", matchPattern);
        return (GuestListFileInfo) getWsc().invoke("ListFilesInGuest", paras, "GuestListFileInfo");
    }

    public GuestAliases[] listGuestAliases(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String username) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("username", "String", username);
        return (GuestAliases[]) getWsc().invoke("ListGuestAliases", paras, "GuestAliases[]");
    }

    public GuestMappedAliases[] listGuestMappedAliases(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        return (GuestMappedAliases[]) getWsc().invoke("ListGuestMappedAliases", paras, "GuestMappedAliases[]");
    }

    public CryptoKeyId[] listKeys(ManagedObjectReference _this, int limit) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("limit", "int", limit);
        return (CryptoKeyId[]) getWsc().invoke("ListKeys", paras, "CryptoKeyId[]");
    }

    public KmipClusterInfo[] listKmipServers(ManagedObjectReference _this, int limit) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("limit", "int", limit);
        return (KmipClusterInfo[]) getWsc().invoke("ListKmipServers", paras, "KmipClusterInfo[]");
    }

    public KmipClusterInfo[] listKmsClusters(ManagedObjectReference _this, boolean includeKmsServers, int managementTypeFilter, int statusFilter) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("includeKmsServers", "boolean", includeKmsServers);
        paras[2] = new Argument("managementTypeFilter", "int", managementTypeFilter);
        paras[3] = new Argument("statusFilter", "int", statusFilter);
        return (KmipClusterInfo[]) getWsc().invoke("ListKmsClusters", paras, "KmipClusterInfo[]");
    }

    public GuestProcessInfo[] listProcessesInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, long[] pids) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("pids", "long[]", pids);
        return (GuestProcessInfo[]) getWsc().invoke("ListProcessesInGuest", paras, "GuestProcessInfo[]");
    }

    public GuestRegKeyRecordSpec[] listRegistryKeysInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean recursive, String matchPattern) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("keyName", "GuestRegKeyNameSpec", keyName);
        paras[4] = new Argument("recursive", "boolean", recursive);
        paras[5] = new Argument("matchPattern", "String", matchPattern);
        return (GuestRegKeyRecordSpec[]) getWsc().invoke("ListRegistryKeysInGuest", paras, "GuestRegKeyRecordSpec[]");
    }

    public GuestRegValueSpec[] listRegistryValuesInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean expandStrings, String matchPattern) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("keyName", "GuestRegKeyNameSpec", keyName);
        paras[4] = new Argument("expandStrings", "boolean", expandStrings);
        paras[5] = new Argument("matchPattern", "String", matchPattern);
        return (GuestRegValueSpec[]) getWsc().invoke("ListRegistryValuesInGuest", paras, "GuestRegValueSpec[]");
    }

    public String[] listSmartCardTrustAnchors(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String[]) getWsc().invoke("ListSmartCardTrustAnchors", paras, "String[]");
    }

    public VslmTagEntry[] listTagsAttachedToVStorageObject(ManagedObjectReference _this, ID id) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        return (VslmTagEntry[]) getWsc().invoke("ListTagsAttachedToVStorageObject", paras, "VslmTagEntry[]");
    }

    public ID[] listVStorageObject(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (ID[]) getWsc().invoke("ListVStorageObject", paras, "ID[]");
    }

    public ID[] listVStorageObjectsAttachedToTag(ManagedObjectReference _this, String category, String tag) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("category", "String", category);
        paras[2] = new Argument("tag", "String", tag);
        return (ID[]) getWsc().invoke("ListVStorageObjectsAttachedToTag", paras, "ID[]");
    }

    public UserSession login(ManagedObjectReference _this, String userName, String password, String locale) throws java.rmi.RemoteException, InvalidLocale, InvalidLogin, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("userName", "String", userName);
        paras[2] = new Argument("password", "String", password);
        paras[3] = new Argument("locale", "String", locale);
        return (UserSession) getWsc().invoke("Login", paras, "UserSession");
    }

    public UserSession loginBySSPI(ManagedObjectReference _this, String base64Token, String locale) throws java.rmi.RemoteException, InvalidLocale, InvalidLogin, SSPIChallenge, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("base64Token", "String", base64Token);
        paras[2] = new Argument("locale", "String", locale);
        return (UserSession) getWsc().invoke("LoginBySSPI", paras, "UserSession");
    }

    public UserSession loginByToken(ManagedObjectReference _this, String locale) throws java.rmi.RemoteException, InvalidLocale, InvalidLogin, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("locale", "String", locale);
        return (UserSession) getWsc().invoke("LoginByToken", paras, "UserSession");
    }

    public UserSession loginExtensionByCertificate(ManagedObjectReference _this, String extensionKey, String locale) throws java.rmi.RemoteException, InvalidLocale, InvalidLogin, NoClientCertificate, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        paras[2] = new Argument("locale", "String", locale);
        return (UserSession) getWsc().invoke("LoginExtensionByCertificate", paras, "UserSession");
    }

    public UserSession loginExtensionBySubjectName(ManagedObjectReference _this, String extensionKey, String locale) throws java.rmi.RemoteException, InvalidLocale, InvalidLogin, NoClientCertificate, NoSubjectName, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        paras[2] = new Argument("locale", "String", locale);
        return (UserSession) getWsc().invoke("LoginExtensionBySubjectName", paras, "UserSession");
    }

    public void logout(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("Logout", paras, null);
    }

    public void logUserEvent(ManagedObjectReference _this, ManagedObjectReference entity, String msg) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("msg", "String", msg);
        getWsc().invoke("LogUserEvent", paras, null);
    }

    public ManagedObjectReference lookupDvPortGroup(ManagedObjectReference _this, String portgroupKey) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portgroupKey", "String", portgroupKey);
        return (ManagedObjectReference) getWsc().invoke("LookupDvPortGroup", paras, "ManagedObjectReference");
    }

    public long lookupVmOverheadMemory(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference host) throws java.rmi.RemoteException, InvalidArgument, InvalidType, ManagedObjectNotFound, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (long) getWsc().invoke("LookupVmOverheadMemory", paras, "long");
    }

    public void makeDirectory(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, boolean createParentDirectories) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("createParentDirectories", "boolean", createParentDirectories);
        getWsc().invoke("MakeDirectory", paras, null);
    }

    public void makeDirectoryInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String directoryPath, boolean createParentDirectories) throws java.rmi.RemoteException, FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("directoryPath", "String", directoryPath);
        paras[4] = new Argument("createParentDirectories", "boolean", createParentDirectories);
        getWsc().invoke("MakeDirectoryInGuest", paras, null);
    }

    public ManagedObjectReference makePrimaryVM_Task(ManagedObjectReference _this, ManagedObjectReference vm) throws java.rmi.RemoteException, InvalidState, TaskInProgress, VmFaultToleranceIssue, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        return (ManagedObjectReference) getWsc().invoke("MakePrimaryVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference markAsLocal_Task(ManagedObjectReference _this, String scsiDiskUuid) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("scsiDiskUuid", "String", scsiDiskUuid);
        return (ManagedObjectReference) getWsc().invoke("MarkAsLocal_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference markAsNonLocal_Task(ManagedObjectReference _this, String scsiDiskUuid) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("scsiDiskUuid", "String", scsiDiskUuid);
        return (ManagedObjectReference) getWsc().invoke("MarkAsNonLocal_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference markAsNonSsd_Task(ManagedObjectReference _this, String scsiDiskUuid) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("scsiDiskUuid", "String", scsiDiskUuid);
        return (ManagedObjectReference) getWsc().invoke("MarkAsNonSsd_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference markAsSsd_Task(ManagedObjectReference _this, String scsiDiskUuid) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("scsiDiskUuid", "String", scsiDiskUuid);
        return (ManagedObjectReference) getWsc().invoke("MarkAsSsd_Task", paras, "ManagedObjectReference");
    }

    public void markAsTemplate(ManagedObjectReference _this) throws java.rmi.RemoteException, FileFault, InvalidState, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("MarkAsTemplate", paras, null);
    }

    public void markAsVirtualMachine(ManagedObjectReference _this, ManagedObjectReference pool, ManagedObjectReference host) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pool", "ManagedObjectReference", pool);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        getWsc().invoke("MarkAsVirtualMachine", paras, null);
    }

    public void markDefault(ManagedObjectReference _this, KeyProviderId clusterId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("clusterId", "KeyProviderId", clusterId);
        getWsc().invoke("MarkDefault", paras, null);
    }

    public void markForRemoval(ManagedObjectReference _this, String hbaName, boolean remove) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hbaName", "String", hbaName);
        paras[2] = new Argument("remove", "boolean", remove);
        getWsc().invoke("MarkForRemoval", paras, null);
    }

    public void markPerenniallyReserved(ManagedObjectReference _this, String lunUuid, boolean state) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunUuid", "String", lunUuid);
        paras[2] = new Argument("state", "boolean", state);
        getWsc().invoke("MarkPerenniallyReserved", paras, null);
    }

    public ManagedObjectReference markPerenniallyReservedEx_Task(ManagedObjectReference _this, String[] lunUuid, boolean state) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunUuid", "String[]", lunUuid);
        paras[2] = new Argument("state", "boolean", state);
        return (ManagedObjectReference) getWsc().invoke("MarkPerenniallyReservedEx_Task", paras, "ManagedObjectReference");
    }

    public void markServiceProviderEntities(ManagedObjectReference _this, ManagedObjectReference[] entity) throws java.rmi.RemoteException, AuthMinimumAdminPermission, ManagedObjectNotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        getWsc().invoke("MarkServiceProviderEntities", paras, null);
    }

    public ManagedObjectReference mergeDvs_Task(ManagedObjectReference _this, ManagedObjectReference dvs) throws java.rmi.RemoteException, DvsFault, InvalidHostState, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dvs", "ManagedObjectReference", dvs);
        return (ManagedObjectReference) getWsc().invoke("MergeDvs_Task", paras, "ManagedObjectReference");
    }

    public void mergePermissions(ManagedObjectReference _this, int srcRoleId, int dstRoleId) throws java.rmi.RemoteException, AuthMinimumAdminPermission, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("srcRoleId", "int", srcRoleId);
        paras[2] = new Argument("dstRoleId", "int", dstRoleId);
        getWsc().invoke("MergePermissions", paras, null);
    }

    public ManagedObjectReference migrateVM_Task(ManagedObjectReference _this, ManagedObjectReference pool, ManagedObjectReference host, VirtualMachineMovePriority priority, VirtualMachinePowerState state) throws java.rmi.RemoteException, FileFault, InsufficientResourcesFault, InvalidState, MigrationFault, Timedout, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pool", "ManagedObjectReference", pool);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        paras[3] = new Argument("priority", "VirtualMachineMovePriority", priority);
        paras[4] = new Argument("state", "VirtualMachinePowerState", state);
        return (ManagedObjectReference) getWsc().invoke("MigrateVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference[] modifyListView(ManagedObjectReference _this, ManagedObjectReference[] add, ManagedObjectReference[] remove) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("add", "ManagedObjectReference[]", add);
        paras[2] = new Argument("remove", "ManagedObjectReference[]", remove);
        return (ManagedObjectReference[]) getWsc().invoke("ModifyListView", paras, "ManagedObjectReference[]");
    }

    public void mountToolsInstaller(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, VmConfigFault, VmToolsUpgradeFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("MountToolsInstaller", paras, null);
    }

    public void mountVffsVolume(ManagedObjectReference _this, String vffsUuid) throws java.rmi.RemoteException, HostConfigFault, InvalidState, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsUuid", "String", vffsUuid);
        getWsc().invoke("MountVffsVolume", paras, null);
    }

    public void mountVmfsVolume(ManagedObjectReference _this, String vmfsUuid) throws java.rmi.RemoteException, HostConfigFault, InvalidState, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsUuid", "String", vmfsUuid);
        getWsc().invoke("MountVmfsVolume", paras, null);
    }

    public ManagedObjectReference mountVmfsVolumeEx_Task(ManagedObjectReference _this, String[] vmfsUuid) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsUuid", "String[]", vmfsUuid);
        return (ManagedObjectReference) getWsc().invoke("MountVmfsVolumeEx_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference moveDatastoreFile_Task(ManagedObjectReference _this, String sourceName, ManagedObjectReference sourceDatacenter, String destinationName, ManagedObjectReference destinationDatacenter, boolean force) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sourceName", "String", sourceName);
        paras[2] = new Argument("sourceDatacenter", "ManagedObjectReference", sourceDatacenter);
        paras[3] = new Argument("destinationName", "String", destinationName);
        paras[4] = new Argument("destinationDatacenter", "ManagedObjectReference", destinationDatacenter);
        paras[5] = new Argument("force", "boolean", force);
        return (ManagedObjectReference) getWsc().invoke("MoveDatastoreFile_Task", paras, "ManagedObjectReference");
    }

    public void moveDirectoryInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String srcDirectoryPath, String dstDirectoryPath) throws java.rmi.RemoteException, FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("srcDirectoryPath", "String", srcDirectoryPath);
        paras[4] = new Argument("dstDirectoryPath", "String", dstDirectoryPath);
        getWsc().invoke("MoveDirectoryInGuest", paras, null);
    }

    public ManagedObjectReference moveDVPort_Task(ManagedObjectReference _this, String[] portKey, String destinationPortgroupKey) throws java.rmi.RemoteException, ConcurrentAccess, DvsFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portKey", "String[]", portKey);
        paras[2] = new Argument("destinationPortgroupKey", "String", destinationPortgroupKey);
        return (ManagedObjectReference) getWsc().invoke("MoveDVPort_Task", paras, "ManagedObjectReference");
    }

    public void moveFileInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String srcFilePath, String dstFilePath, boolean overwrite) throws java.rmi.RemoteException, FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("srcFilePath", "String", srcFilePath);
        paras[4] = new Argument("dstFilePath", "String", dstFilePath);
        paras[5] = new Argument("overwrite", "boolean", overwrite);
        getWsc().invoke("MoveFileInGuest", paras, null);
    }

    public ManagedObjectReference moveHostInto_Task(ManagedObjectReference _this, ManagedObjectReference host, ManagedObjectReference resourcePool) throws java.rmi.RemoteException, InvalidState, TooManyHosts, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("resourcePool", "ManagedObjectReference", resourcePool);
        return (ManagedObjectReference) getWsc().invoke("MoveHostInto_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference moveInto_Task(ManagedObjectReference _this, ManagedObjectReference[] host) throws java.rmi.RemoteException, DuplicateName, InvalidState, TooManyHosts, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference[]", host);
        return (ManagedObjectReference) getWsc().invoke("MoveInto_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference moveIntoFolder_Task(ManagedObjectReference _this, ManagedObjectReference[] list) throws java.rmi.RemoteException, DuplicateName, InvalidFolder, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("list", "ManagedObjectReference[]", list);
        return (ManagedObjectReference) getWsc().invoke("MoveIntoFolder_Task", paras, "ManagedObjectReference");
    }

    public void moveIntoResourcePool(ManagedObjectReference _this, ManagedObjectReference[] list) throws java.rmi.RemoteException, DuplicateName, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("list", "ManagedObjectReference[]", list);
        getWsc().invoke("MoveIntoResourcePool", paras, null);
    }

    public ManagedObjectReference moveVirtualDisk_Task(ManagedObjectReference _this, String sourceName, ManagedObjectReference sourceDatacenter, String destName, ManagedObjectReference destDatacenter, boolean force, VirtualMachineProfileSpec[] profile) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[7];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sourceName", "String", sourceName);
        paras[2] = new Argument("sourceDatacenter", "ManagedObjectReference", sourceDatacenter);
        paras[3] = new Argument("destName", "String", destName);
        paras[4] = new Argument("destDatacenter", "ManagedObjectReference", destDatacenter);
        paras[5] = new Argument("force", "boolean", force);
        paras[6] = new Argument("profile", "VirtualMachineProfileSpec[]", profile);
        return (ManagedObjectReference) getWsc().invoke("MoveVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public void notifyAffectedServices(ManagedObjectReference _this, String[] services) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("services", "String[]", services);
        getWsc().invoke("NotifyAffectedServices", paras, null);
    }

    public ManagedObjectReference[] openInventoryViewFolder(ManagedObjectReference _this, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        return (ManagedObjectReference[]) getWsc().invoke("OpenInventoryViewFolder", paras, "ManagedObjectReference[]");
    }

    public void overwriteCustomizationSpec(ManagedObjectReference _this, CustomizationSpecItem item) throws java.rmi.RemoteException, ConcurrentAccess, CustomizationFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("item", "CustomizationSpecItem", item);
        getWsc().invoke("OverwriteCustomizationSpec", paras, null);
    }

    public OvfParseDescriptorResult parseDescriptor(ManagedObjectReference _this, String ovfDescriptor, OvfParseDescriptorParams pdp) throws java.rmi.RemoteException, ConcurrentAccess, FileFault, InvalidState, TaskInProgress, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ovfDescriptor", "String", ovfDescriptor);
        paras[2] = new Argument("pdp", "OvfParseDescriptorParams", pdp);
        return (OvfParseDescriptorResult) getWsc().invoke("ParseDescriptor", paras, "OvfParseDescriptorResult");
    }

    public ManagedObjectReference performDvsProductSpecOperation_Task(ManagedObjectReference _this, String operation, DistributedVirtualSwitchProductSpec productSpec) throws java.rmi.RemoteException, DvsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("operation", "String", operation);
        paras[2] = new Argument("productSpec", "DistributedVirtualSwitchProductSpec", productSpec);
        return (ManagedObjectReference) getWsc().invoke("PerformDvsProductSpecOperation_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference performVsanUpgrade_Task(ManagedObjectReference _this, ManagedObjectReference cluster, boolean performObjectUpgrade, boolean downgradeFormat, boolean allowReducedRedundancy, ManagedObjectReference[] excludeHosts) throws java.rmi.RemoteException, VsanFault, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cluster", "ManagedObjectReference", cluster);
        paras[2] = new Argument("performObjectUpgrade", "boolean", performObjectUpgrade);
        paras[3] = new Argument("downgradeFormat", "boolean", downgradeFormat);
        paras[4] = new Argument("allowReducedRedundancy", "boolean", allowReducedRedundancy);
        paras[5] = new Argument("excludeHosts", "ManagedObjectReference[]", excludeHosts);
        return (ManagedObjectReference) getWsc().invoke("PerformVsanUpgrade_Task", paras, "ManagedObjectReference");
    }

    public VsanUpgradeSystemPreflightCheckResult performVsanUpgradePreflightCheck(ManagedObjectReference _this, ManagedObjectReference cluster, boolean downgradeFormat) throws java.rmi.RemoteException, VsanFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cluster", "ManagedObjectReference", cluster);
        paras[2] = new Argument("downgradeFormat", "boolean", downgradeFormat);
        return (VsanUpgradeSystemPreflightCheckResult) getWsc().invoke("PerformVsanUpgradePreflightCheck", paras, "VsanUpgradeSystemPreflightCheckResult");
    }

    public PlacementResult placeVm(ManagedObjectReference _this, PlacementSpec placementSpec) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("placementSpec", "PlacementSpec", placementSpec);
        return (PlacementResult) getWsc().invoke("PlaceVm", paras, "PlacementResult");
    }

    public void postEvent(ManagedObjectReference _this, Event eventToPost, TaskInfo taskInfo) throws java.rmi.RemoteException, InvalidEvent, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("eventToPost", "Event", eventToPost);
        paras[2] = new Argument("taskInfo", "TaskInfo", taskInfo);
        getWsc().invoke("PostEvent", paras, null);
    }

    public void postHealthUpdates(ManagedObjectReference _this, String providerId, HealthUpdate[] updates) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("providerId", "String", providerId);
        paras[2] = new Argument("updates", "HealthUpdate[]", updates);
        getWsc().invoke("PostHealthUpdates", paras, null);
    }

    public ManagedObjectReference powerDownHostToStandBy_Task(ManagedObjectReference _this, int timeoutSec, boolean evacuatePoweredOffVms) throws java.rmi.RemoteException, HostPowerOpFailed, InvalidState, NotSupported, RequestCanceled, Timedout, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("timeoutSec", "int", timeoutSec);
        paras[2] = new Argument("evacuatePoweredOffVms", "boolean", evacuatePoweredOffVms);
        return (ManagedObjectReference) getWsc().invoke("PowerDownHostToStandBy_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference powerOffVApp_Task(ManagedObjectReference _this, boolean force) throws java.rmi.RemoteException, InvalidState, TaskInProgress, VAppConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("force", "boolean", force);
        return (ManagedObjectReference) getWsc().invoke("PowerOffVApp_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference powerOffVM_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("PowerOffVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference powerOnMultiVM_Task(ManagedObjectReference _this, ManagedObjectReference[] vm, OptionValue[] option) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference[]", vm);
        paras[2] = new Argument("option", "OptionValue[]", option);
        return (ManagedObjectReference) getWsc().invoke("PowerOnMultiVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference powerOnVApp_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, FileFault, InsufficientResourcesFault, InvalidState, TaskInProgress, VAppConfigFault, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("PowerOnVApp_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference powerOnVM_Task(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, FileFault, InsufficientResourcesFault, InvalidState, TaskInProgress, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("PowerOnVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference powerUpHostFromStandBy_Task(ManagedObjectReference _this, int timeoutSec) throws java.rmi.RemoteException, HostPowerOpFailed, InvalidState, NotSupported, Timedout, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("timeoutSec", "int", timeoutSec);
        return (ManagedObjectReference) getWsc().invoke("PowerUpHostFromStandBy_Task", paras, "ManagedObjectReference");
    }

    public void prepareCrypto(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("PrepareCrypto", paras, null);
    }

    public ManagedObjectReference prepareVcha_Task(ManagedObjectReference _this, VchaClusterNetworkSpec networkSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("networkSpec", "VchaClusterNetworkSpec", networkSpec);
        return (ManagedObjectReference) getWsc().invoke("prepareVcha_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference promoteDisks_Task(ManagedObjectReference _this, boolean unlink, VirtualDisk[] disks) throws java.rmi.RemoteException, InvalidPowerState, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("unlink", "boolean", unlink);
        paras[2] = new Argument("disks", "VirtualDisk[]", disks);
        return (ManagedObjectReference) getWsc().invoke("PromoteDisks_Task", paras, "ManagedObjectReference");
    }

    public void provisionServerPrivateKey(ManagedObjectReference _this, String key) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String", key);
        getWsc().invoke("ProvisionServerPrivateKey", paras, null);
    }

    public int putUsbScanCodes(ManagedObjectReference _this, UsbScanCodeSpec spec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "UsbScanCodeSpec", spec);
        return (int) getWsc().invoke("PutUsbScanCodes", paras, "int");
    }

    public AnswerFileStatusResult[] queryAnswerFileStatus(ManagedObjectReference _this, ManagedObjectReference[] host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference[]", host);
        return (AnswerFileStatusResult[]) getWsc().invoke("QueryAnswerFileStatus", paras, "AnswerFileStatusResult[]");
    }

    public LicenseAssignmentManagerLicenseAssignment[] queryAssignedLicenses(ManagedObjectReference _this, String entityId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entityId", "String", entityId);
        return (LicenseAssignmentManagerLicenseAssignment[]) getWsc().invoke("QueryAssignedLicenses", paras, "LicenseAssignmentManagerLicenseAssignment[]");
    }

    public HostScsiDisk[] queryAvailableDisksForVmfs(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (HostScsiDisk[]) getWsc().invoke("QueryAvailableDisksForVmfs", paras, "HostScsiDisk[]");
    }

    public DistributedVirtualSwitchProductSpec[] queryAvailableDvsSpec(ManagedObjectReference _this, boolean recommended) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("recommended", "boolean", recommended);
        return (DistributedVirtualSwitchProductSpec[]) getWsc().invoke("QueryAvailableDvsSpec", paras, "DistributedVirtualSwitchProductSpec[]");
    }

    public HostDiagnosticPartition[] queryAvailablePartition(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostDiagnosticPartition[]) getWsc().invoke("QueryAvailablePartition", paras, "HostDiagnosticPartition[]");
    }

    public PerfMetricId[] queryAvailablePerfMetric(ManagedObjectReference _this, ManagedObjectReference entity, Calendar beginTime, Calendar endTime, int intervalId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("beginTime", "Calendar", beginTime);
        paras[3] = new Argument("endTime", "Calendar", endTime);
        paras[4] = new Argument("intervalId", "int", intervalId);
        return (PerfMetricId[]) getWsc().invoke("QueryAvailablePerfMetric", paras, "PerfMetricId[]");
    }

    public HostScsiDisk[] queryAvailableSsds(ManagedObjectReference _this, String vffsPath) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsPath", "String", vffsPath);
        return (HostScsiDisk[]) getWsc().invoke("QueryAvailableSsds", paras, "HostScsiDisk[]");
    }

    public HostDateTimeSystemTimeZone[] queryAvailableTimeZones(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostDateTimeSystemTimeZone[]) getWsc().invoke("QueryAvailableTimeZones", paras, "HostDateTimeSystemTimeZone[]");
    }

    public HostBootDeviceInfo queryBootDevices(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostBootDeviceInfo) getWsc().invoke("QueryBootDevices", paras, "HostBootDeviceInfo");
    }

    public IscsiPortInfo[] queryBoundVnics(ManagedObjectReference _this, String iScsiHbaName) throws java.rmi.RemoteException, IscsiFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaName", "String", iScsiHbaName);
        return (IscsiPortInfo[]) getWsc().invoke("QueryBoundVnics", paras, "IscsiPortInfo[]");
    }

    public IscsiPortInfo[] queryCandidateNics(ManagedObjectReference _this, String iScsiHbaName) throws java.rmi.RemoteException, IscsiFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaName", "String", iScsiHbaName);
        return (IscsiPortInfo[]) getWsc().invoke("QueryCandidateNics", paras, "IscsiPortInfo[]");
    }

    public DiskChangeInfo queryChangedDiskAreas(ManagedObjectReference _this, ManagedObjectReference snapshot, int deviceKey, long startOffset, String changeId) throws java.rmi.RemoteException, FileFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("snapshot", "ManagedObjectReference", snapshot);
        paras[2] = new Argument("deviceKey", "int", deviceKey);
        paras[3] = new Argument("startOffset", "long", startOffset);
        paras[4] = new Argument("changeId", "String", changeId);
        return (DiskChangeInfo) getWsc().invoke("QueryChangedDiskAreas", paras, "DiskChangeInfo");
    }

    public String queryCmmds(ManagedObjectReference _this, HostVsanInternalSystemCmmdsQuery[] queries) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("queries", "HostVsanInternalSystemCmmdsQuery[]", queries);
        return (String) getWsc().invoke("QueryCmmds", paras, "String");
    }

    public ManagedObjectReference[] queryCompatibleHostForExistingDvs(ManagedObjectReference _this, ManagedObjectReference container, boolean recursive, ManagedObjectReference dvs) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("container", "ManagedObjectReference", container);
        paras[2] = new Argument("recursive", "boolean", recursive);
        paras[3] = new Argument("dvs", "ManagedObjectReference", dvs);
        return (ManagedObjectReference[]) getWsc().invoke("QueryCompatibleHostForExistingDvs", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference[] queryCompatibleHostForNewDvs(ManagedObjectReference _this, ManagedObjectReference container, boolean recursive, DistributedVirtualSwitchProductSpec switchProductSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("container", "ManagedObjectReference", container);
        paras[2] = new Argument("recursive", "boolean", recursive);
        paras[3] = new Argument("switchProductSpec", "DistributedVirtualSwitchProductSpec", switchProductSpec);
        return (ManagedObjectReference[]) getWsc().invoke("QueryCompatibleHostForNewDvs", paras, "ManagedObjectReference[]");
    }

    public DVSManagerPhysicalNicsList[] queryCompatibleVmnicsFromHosts(ManagedObjectReference _this, ManagedObjectReference[] hosts, ManagedObjectReference dvs) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hosts", "ManagedObjectReference[]", hosts);
        paras[2] = new Argument("dvs", "ManagedObjectReference", dvs);
        return (DVSManagerPhysicalNicsList[]) getWsc().invoke("QueryCompatibleVmnicsFromHosts", paras, "DVSManagerPhysicalNicsList[]");
    }

    public ComplianceResult[] queryComplianceStatus(ManagedObjectReference _this, ManagedObjectReference[] profile, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profile", "ManagedObjectReference[]", profile);
        paras[2] = new Argument("entity", "ManagedObjectReference[]", entity);
        return (ComplianceResult[]) getWsc().invoke("QueryComplianceStatus", paras, "ComplianceResult[]");
    }

    public VirtualMachineConfigOption queryConfigOption(ManagedObjectReference _this, String key, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String", key);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (VirtualMachineConfigOption) getWsc().invoke("QueryConfigOption", paras, "VirtualMachineConfigOption");
    }

    public VirtualMachineConfigOptionDescriptor[] queryConfigOptionDescriptor(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VirtualMachineConfigOptionDescriptor[]) getWsc().invoke("QueryConfigOptionDescriptor", paras, "VirtualMachineConfigOptionDescriptor[]");
    }

    public VirtualMachineConfigOption queryConfigOptionEx(ManagedObjectReference _this, EnvironmentBrowserConfigOptionQuerySpec spec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "EnvironmentBrowserConfigOptionQuerySpec", spec);
        return (VirtualMachineConfigOption) getWsc().invoke("QueryConfigOptionEx", paras, "VirtualMachineConfigOption");
    }

    public ConfigTarget queryConfigTarget(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (ConfigTarget) getWsc().invoke("QueryConfigTarget", paras, "ConfigTarget");
    }

    public String queryConfiguredModuleOptionString(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (String) getWsc().invoke("QueryConfiguredModuleOptionString", paras, "String");
    }

    public HostConnectInfo queryConnectionInfo(ManagedObjectReference _this, String hostname, int port, String username, String password, String sslThumbprint, String sslCertificate) throws java.rmi.RemoteException, HostConnectFault, InvalidLogin, RuntimeFault {
        Argument[] paras = new Argument[7];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hostname", "String", hostname);
        paras[2] = new Argument("port", "int", port);
        paras[3] = new Argument("username", "String", username);
        paras[4] = new Argument("password", "String", password);
        paras[5] = new Argument("sslThumbprint", "String", sslThumbprint);
        paras[6] = new Argument("sslCertificate", "String", sslCertificate);
        return (HostConnectInfo) getWsc().invoke("QueryConnectionInfo", paras, "HostConnectInfo");
    }

    public HostConnectInfo queryConnectionInfoViaSpec(ManagedObjectReference _this, HostConnectSpec spec) throws java.rmi.RemoteException, HostConnectFault, InvalidLogin, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostConnectSpec", spec);
        return (HostConnectInfo) getWsc().invoke("QueryConnectionInfoViaSpec", paras, "HostConnectInfo");
    }

    public VirtualMachineConnection[] queryConnections(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, Timedout, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VirtualMachineConnection[]) getWsc().invoke("QueryConnections", paras, "VirtualMachineConnection[]");
    }

    public CryptoManagerKmipCryptoKeyStatus[] queryCryptoKeyStatus(ManagedObjectReference _this, CryptoKeyId[] keyIds, int checkKeyBitMap) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("keyIds", "CryptoKeyId[]", keyIds);
        paras[2] = new Argument("checkKeyBitMap", "int", checkKeyBitMap);
        return (CryptoManagerKmipCryptoKeyStatus[]) getWsc().invoke("QueryCryptoKeyStatus", paras, "CryptoManagerKmipCryptoKeyStatus[]");
    }

    public VirtualMachineConfigOptionDescriptor[] queryDatacenterConfigOptionDescriptor(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VirtualMachineConfigOptionDescriptor[]) getWsc().invoke("queryDatacenterConfigOptionDescriptor", paras, "VirtualMachineConfigOptionDescriptor[]");
    }

    public StoragePerformanceSummary[] queryDatastorePerformanceSummary(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (StoragePerformanceSummary[]) getWsc().invoke("QueryDatastorePerformanceSummary", paras, "StoragePerformanceSummary[]");
    }

    public Calendar queryDateTime(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (Calendar) getWsc().invoke("QueryDateTime", paras, "Calendar");
    }

    public DiagnosticManagerLogDescriptor[] queryDescriptions(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (DiagnosticManagerLogDescriptor[]) getWsc().invoke("QueryDescriptions", paras, "DiagnosticManagerLogDescriptor[]");
    }

    public DatastoreNamespaceManagerDirectoryInfo queryDirectoryInfo(ManagedObjectReference _this, ManagedObjectReference datacenter, String stableName) throws java.rmi.RemoteException, FileFault, FileNotFound, InvalidDatastore, NotSupported, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("stableName", "String", stableName);
        return (DatastoreNamespaceManagerDirectoryInfo) getWsc().invoke("QueryDirectoryInfo", paras, "DatastoreNamespaceManagerDirectoryInfo");
    }

    public VsanHostDiskResult[] queryDisksForVsan(ManagedObjectReference _this, String[] canonicalName) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("canonicalName", "String[]", canonicalName);
        return (VsanHostDiskResult[]) getWsc().invoke("QueryDisksForVsan", paras, "VsanHostDiskResult[]");
    }

    public VirtualDiskId[] queryDisksUsingFilter(ManagedObjectReference _this, String filterId, ManagedObjectReference compRes) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filterId", "String", filterId);
        paras[2] = new Argument("compRes", "ManagedObjectReference", compRes);
        return (VirtualDiskId[]) getWsc().invoke("QueryDisksUsingFilter", paras, "VirtualDiskId[]");
    }

    public ManagedObjectReference queryDvsByUuid(ManagedObjectReference _this, String uuid) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("uuid", "String", uuid);
        return (ManagedObjectReference) getWsc().invoke("QueryDvsByUuid", paras, "ManagedObjectReference");
    }

    public DistributedVirtualSwitchManagerCompatibilityResult[] queryDvsCheckCompatibility(ManagedObjectReference _this, DistributedVirtualSwitchManagerHostContainer hostContainer, DistributedVirtualSwitchManagerDvsProductSpec dvsProductSpec, DistributedVirtualSwitchManagerHostDvsFilterSpec[] hostFilterSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hostContainer", "DistributedVirtualSwitchManagerHostContainer", hostContainer);
        paras[2] = new Argument("dvsProductSpec", "DistributedVirtualSwitchManagerDvsProductSpec", dvsProductSpec);
        paras[3] = new Argument("hostFilterSpec", "DistributedVirtualSwitchManagerHostDvsFilterSpec[]", hostFilterSpec);
        return (DistributedVirtualSwitchManagerCompatibilityResult[]) getWsc().invoke("QueryDvsCheckCompatibility", paras, "DistributedVirtualSwitchManagerCompatibilityResult[]");
    }

    public DistributedVirtualSwitchHostProductSpec[] queryDvsCompatibleHostSpec(ManagedObjectReference _this, DistributedVirtualSwitchProductSpec switchProductSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("switchProductSpec", "DistributedVirtualSwitchProductSpec", switchProductSpec);
        return (DistributedVirtualSwitchHostProductSpec[]) getWsc().invoke("QueryDvsCompatibleHostSpec", paras, "DistributedVirtualSwitchHostProductSpec[]");
    }

    public DVSManagerDvsConfigTarget queryDvsConfigTarget(ManagedObjectReference _this, ManagedObjectReference host, ManagedObjectReference dvs) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("dvs", "ManagedObjectReference", dvs);
        return (DVSManagerDvsConfigTarget) getWsc().invoke("QueryDvsConfigTarget", paras, "DVSManagerDvsConfigTarget");
    }

    public DVSFeatureCapability queryDvsFeatureCapability(ManagedObjectReference _this, DistributedVirtualSwitchProductSpec switchProductSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("switchProductSpec", "DistributedVirtualSwitchProductSpec", switchProductSpec);
        return (DVSFeatureCapability) getWsc().invoke("QueryDvsFeatureCapability", paras, "DVSFeatureCapability");
    }

    public Event[] queryEvents(ManagedObjectReference _this, EventFilterSpec filter, EventManagerEventViewSpec eventViewSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filter", "EventFilterSpec", filter);
        paras[2] = new Argument("eventViewSpec", "EventManagerEventViewSpec", eventViewSpec);
        return (Event[]) getWsc().invoke("QueryEvents", paras, "Event[]");
    }

    public ProfileExpressionMetadata[] queryExpressionMetadata(ManagedObjectReference _this, String[] expressionName, ManagedObjectReference profile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("expressionName", "String[]", expressionName);
        paras[2] = new Argument("profile", "ManagedObjectReference", profile);
        return (ProfileExpressionMetadata[]) getWsc().invoke("QueryExpressionMetadata", paras, "ProfileExpressionMetadata[]");
    }

    public ExtensionManagerIpAllocationUsage[] queryExtensionIpAllocationUsage(ManagedObjectReference _this, String[] extensionKeys) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKeys", "String[]", extensionKeys);
        return (ExtensionManagerIpAllocationUsage[]) getWsc().invoke("QueryExtensionIpAllocationUsage", paras, "ExtensionManagerIpAllocationUsage[]");
    }

    public LocalizedMethodFault[] queryFaultToleranceCompatibility(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (LocalizedMethodFault[]) getWsc().invoke("QueryFaultToleranceCompatibility", paras, "LocalizedMethodFault[]");
    }

    public LocalizedMethodFault[] queryFaultToleranceCompatibilityEx(ManagedObjectReference _this, boolean forLegacyFt) throws java.rmi.RemoteException, InvalidState, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("forLegacyFt", "boolean", forLegacyFt);
        return (LocalizedMethodFault[]) getWsc().invoke("QueryFaultToleranceCompatibilityEx", paras, "LocalizedMethodFault[]");
    }

    public FileLockInfoResult queryFileLockInfo(ManagedObjectReference _this, String path, ManagedObjectReference host) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("path", "String", path);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (FileLockInfoResult) getWsc().invoke("QueryFileLockInfo", paras, "FileLockInfoResult");
    }

    public ManagedObjectReference[] queryFilterEntities(ManagedObjectReference _this, String filterId) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filterId", "String", filterId);
        return (ManagedObjectReference[]) getWsc().invoke("QueryFilterEntities", paras, "ManagedObjectReference[]");
    }

    public String[] queryFilterInfoIds(ManagedObjectReference _this, String filterId) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filterId", "String", filterId);
        return (String[]) getWsc().invoke("QueryFilterInfoIds", paras, "String[]");
    }

    public String[] queryFilterList(ManagedObjectReference _this, String providerId) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("providerId", "String", providerId);
        return (String[]) getWsc().invoke("QueryFilterList", paras, "String[]");
    }

    public String queryFilterName(ManagedObjectReference _this, String filterId) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filterId", "String", filterId);
        return (String) getWsc().invoke("QueryFilterName", paras, "String");
    }

    public String queryFirmwareConfigUploadURL(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) getWsc().invoke("QueryFirmwareConfigUploadURL", paras, "String");
    }

    public HealthUpdateInfo[] queryHealthUpdateInfos(ManagedObjectReference _this, String providerId) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("providerId", "String", providerId);
        return (HealthUpdateInfo[]) getWsc().invoke("QueryHealthUpdateInfos", paras, "HealthUpdateInfo[]");
    }

    public HealthUpdate[] queryHealthUpdates(ManagedObjectReference _this, String providerId) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("providerId", "String", providerId);
        return (HealthUpdate[]) getWsc().invoke("QueryHealthUpdates", paras, "HealthUpdate[]");
    }

    public HostConnectInfo queryHostConnectionInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostConnectInfo) getWsc().invoke("QueryHostConnectionInfo", paras, "HostConnectInfo");
    }

    public ManagedObjectReference queryHostPatch_Task(ManagedObjectReference _this, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, InvalidState, PlatformConfigFault, RequestCanceled, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("QueryHostPatch_Task", paras, "ManagedObjectReference");
    }

    public ProfileMetadata[] queryHostProfileMetadata(ManagedObjectReference _this, String[] profileName, ManagedObjectReference profile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profileName", "String[]", profileName);
        paras[2] = new Argument("profile", "ManagedObjectReference", profile);
        return (ProfileMetadata[]) getWsc().invoke("QueryHostProfileMetadata", paras, "ProfileMetadata[]");
    }

    public VsanHostClusterStatus queryHostStatus(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VsanHostClusterStatus) getWsc().invoke("QueryHostStatus", paras, "VsanHostClusterStatus");
    }

    public ManagedObjectReference[] queryHostsWithAttachedLun(ManagedObjectReference _this, String lunUuid) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunUuid", "String", lunUuid);
        return (ManagedObjectReference[]) getWsc().invoke("QueryHostsWithAttachedLun", paras, "ManagedObjectReference[]");
    }

    public ClusterIoFilterInfo[] queryIoFilterInfo(ManagedObjectReference _this, ManagedObjectReference compRes) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("compRes", "ManagedObjectReference", compRes);
        return (ClusterIoFilterInfo[]) getWsc().invoke("QueryIoFilterInfo", paras, "ClusterIoFilterInfo[]");
    }

    public IoFilterQueryIssueResult queryIoFilterIssues(ManagedObjectReference _this, String filterId, ManagedObjectReference compRes) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filterId", "String", filterId);
        paras[2] = new Argument("compRes", "ManagedObjectReference", compRes);
        return (IoFilterQueryIssueResult) getWsc().invoke("QueryIoFilterIssues", paras, "IoFilterQueryIssueResult");
    }

    public StorageIORMConfigOption queryIORMConfigOption(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (StorageIORMConfigOption) getWsc().invoke("QueryIORMConfigOption", paras, "StorageIORMConfigOption");
    }

    public IpPoolManagerIpAllocation[] queryIPAllocations(ManagedObjectReference _this, ManagedObjectReference dc, int poolId, String extensionKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("poolId", "int", poolId);
        paras[3] = new Argument("extensionKey", "String", extensionKey);
        return (IpPoolManagerIpAllocation[]) getWsc().invoke("QueryIPAllocations", paras, "IpPoolManagerIpAllocation[]");
    }

    public IpPool[] queryIpPools(ManagedObjectReference _this, ManagedObjectReference dc) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        return (IpPool[]) getWsc().invoke("QueryIpPools", paras, "IpPool[]");
    }

    public LicenseAvailabilityInfo[] queryLicenseSourceAvailability(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (LicenseAvailabilityInfo[]) getWsc().invoke("QueryLicenseSourceAvailability", paras, "LicenseAvailabilityInfo[]");
    }

    public LicenseUsageInfo queryLicenseUsage(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (LicenseUsageInfo) getWsc().invoke("QueryLicenseUsage", paras, "LicenseUsageInfo");
    }

    public String[] queryLockdownExceptions(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String[]) getWsc().invoke("QueryLockdownExceptions", paras, "String[]");
    }

    public ManagedObjectReference[] queryManagedBy(ManagedObjectReference _this, String extensionKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        return (ManagedObjectReference[]) getWsc().invoke("QueryManagedBy", paras, "ManagedObjectReference[]");
    }

    public long queryMaxQueueDepth(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (long) getWsc().invoke("QueryMaxQueueDepth", paras, "long");
    }

    public long queryMemoryOverhead(ManagedObjectReference _this, long memorySize, int videoRamSize, int numVcpus) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("memorySize", "long", memorySize);
        paras[2] = new Argument("videoRamSize", "int", videoRamSize);
        paras[3] = new Argument("numVcpus", "int", numVcpus);
        return (long) getWsc().invoke("QueryMemoryOverhead", paras, "long");
    }

    public long queryMemoryOverheadEx(ManagedObjectReference _this, VirtualMachineConfigInfo vmConfigInfo) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmConfigInfo", "VirtualMachineConfigInfo", vmConfigInfo);
        return (long) getWsc().invoke("QueryMemoryOverheadEx", paras, "long");
    }

    public IscsiMigrationDependency queryMigrationDependencies(ManagedObjectReference _this, String[] pnicDevice) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pnicDevice", "String[]", pnicDevice);
        return (IscsiMigrationDependency) getWsc().invoke("QueryMigrationDependencies", paras, "IscsiMigrationDependency");
    }

    public KernelModuleInfo[] queryModules(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (KernelModuleInfo[]) getWsc().invoke("QueryModules", paras, "KernelModuleInfo[]");
    }

    public ManagedObjectReference[] queryMonitoredEntities(ManagedObjectReference _this, String providerId) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("providerId", "String", providerId);
        return (ManagedObjectReference[]) getWsc().invoke("QueryMonitoredEntities", paras, "ManagedObjectReference[]");
    }

    public VirtualNicManagerNetConfig queryNetConfig(ManagedObjectReference _this, String nicType) throws java.rmi.RemoteException, HostConfigFault, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("nicType", "String", nicType);
        return (VirtualNicManagerNetConfig) getWsc().invoke("QueryNetConfig", paras, "VirtualNicManagerNetConfig");
    }

    public PhysicalNicHintInfo[] queryNetworkHint(ManagedObjectReference _this, String[] device) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String[]", device);
        return (PhysicalNicHintInfo[]) getWsc().invoke("QueryNetworkHint", paras, "PhysicalNicHintInfo[]");
    }

    public HostNasVolumeUserInfo queryNFSUser(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostNasVolumeUserInfo) getWsc().invoke("QueryNFSUser", paras, "HostNasVolumeUserInfo");
    }

    public String queryObjectsOnPhysicalVsanDisk(ManagedObjectReference _this, String[] disks) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("disks", "String[]", disks);
        return (String) getWsc().invoke("QueryObjectsOnPhysicalVsanDisk", paras, "String");
    }

    public OptionValue[] queryOptions(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (OptionValue[]) getWsc().invoke("QueryOptions", paras, "OptionValue[]");
    }

    public HostDiagnosticPartitionCreateDescription queryPartitionCreateDesc(ManagedObjectReference _this, String diskUuid, String diagnosticType) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("diskUuid", "String", diskUuid);
        paras[2] = new Argument("diagnosticType", "String", diagnosticType);
        return (HostDiagnosticPartitionCreateDescription) getWsc().invoke("QueryPartitionCreateDesc", paras, "HostDiagnosticPartitionCreateDescription");
    }

    public HostDiagnosticPartitionCreateOption[] queryPartitionCreateOptions(ManagedObjectReference _this, String storageType, String diagnosticType) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("storageType", "String", storageType);
        paras[2] = new Argument("diagnosticType", "String", diagnosticType);
        return (HostDiagnosticPartitionCreateOption[]) getWsc().invoke("QueryPartitionCreateOptions", paras, "HostDiagnosticPartitionCreateOption[]");
    }

    public HostPathSelectionPolicyOption[] queryPathSelectionPolicyOptions(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostPathSelectionPolicyOption[]) getWsc().invoke("QueryPathSelectionPolicyOptions", paras, "HostPathSelectionPolicyOption[]");
    }

    public PerfEntityMetricBase[] queryPerf(ManagedObjectReference _this, PerfQuerySpec[] querySpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("querySpec", "PerfQuerySpec[]", querySpec);
        return (PerfEntityMetricBase[]) getWsc().invoke("QueryPerf", paras, "PerfEntityMetricBase[]");
    }

    public PerfCompositeMetric queryPerfComposite(ManagedObjectReference _this, PerfQuerySpec querySpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("querySpec", "PerfQuerySpec", querySpec);
        return (PerfCompositeMetric) getWsc().invoke("QueryPerfComposite", paras, "PerfCompositeMetric");
    }

    public PerfCounterInfo[] queryPerfCounter(ManagedObjectReference _this, int[] counterId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("counterId", "int[]", counterId);
        return (PerfCounterInfo[]) getWsc().invoke("QueryPerfCounter", paras, "PerfCounterInfo[]");
    }

    public PerfCounterInfo[] queryPerfCounterByLevel(ManagedObjectReference _this, int level) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("level", "int", level);
        return (PerfCounterInfo[]) getWsc().invoke("QueryPerfCounterByLevel", paras, "PerfCounterInfo[]");
    }

    public PerfProviderSummary queryPerfProviderSummary(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        return (PerfProviderSummary) getWsc().invoke("QueryPerfProviderSummary", paras, "PerfProviderSummary");
    }

    public String queryPhysicalVsanDisks(ManagedObjectReference _this, String[] props) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("props", "String[]", props);
        return (String) getWsc().invoke("QueryPhysicalVsanDisks", paras, "String");
    }

    public IscsiStatus queryPnicStatus(ManagedObjectReference _this, String pnicDevice) throws java.rmi.RemoteException, IscsiFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pnicDevice", "String", pnicDevice);
        return (IscsiStatus) getWsc().invoke("QueryPnicStatus", paras, "IscsiStatus");
    }

    public ProfilePolicyMetadata[] queryPolicyMetadata(ManagedObjectReference _this, String[] policyName, ManagedObjectReference profile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("policyName", "String[]", policyName);
        paras[2] = new Argument("profile", "ManagedObjectReference", profile);
        return (ProfilePolicyMetadata[]) getWsc().invoke("QueryPolicyMetadata", paras, "ProfilePolicyMetadata[]");
    }

    public String queryProductLockerLocation(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) getWsc().invoke("QueryProductLockerLocation", paras, "String");
    }

    public ProfileProfileStructure queryProfileStructure(ManagedObjectReference _this, ManagedObjectReference profile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profile", "ManagedObjectReference", profile);
        return (ProfileProfileStructure) getWsc().invoke("QueryProfileStructure", paras, "ProfileProfileStructure");
    }

    public String[] queryProviderList(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String[]) getWsc().invoke("QueryProviderList", paras, "String[]");
    }

    public String queryProviderName(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        return (String) getWsc().invoke("QueryProviderName", paras, "String");
    }

    public ResourceConfigOption queryResourceConfigOption(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ResourceConfigOption) getWsc().invoke("QueryResourceConfigOption", paras, "ResourceConfigOption");
    }

    public ServiceManagerServiceInfo[] queryServiceList(ManagedObjectReference _this, String serviceName, String[] location) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("serviceName", "String", serviceName);
        paras[2] = new Argument("location", "String[]", location);
        return (ServiceManagerServiceInfo[]) getWsc().invoke("QueryServiceList", paras, "ServiceManagerServiceInfo[]");
    }

    public HostStorageArrayTypePolicyOption[] queryStorageArrayTypePolicyOptions(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostStorageArrayTypePolicyOption[]) getWsc().invoke("QueryStorageArrayTypePolicyOptions", paras, "HostStorageArrayTypePolicyOption[]");
    }

    public LicenseFeatureInfo[] querySupportedFeatures(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (LicenseFeatureInfo[]) getWsc().invoke("QuerySupportedFeatures", paras, "LicenseFeatureInfo[]");
    }

    public DistributedVirtualSwitchNetworkOffloadSpec[] querySupportedNetworkOffloadSpec(ManagedObjectReference _this, DistributedVirtualSwitchProductSpec switchProductSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("switchProductSpec", "DistributedVirtualSwitchProductSpec", switchProductSpec);
        return (DistributedVirtualSwitchNetworkOffloadSpec[]) getWsc().invoke("QuerySupportedNetworkOffloadSpec", paras, "DistributedVirtualSwitchNetworkOffloadSpec[]");
    }

    public String querySyncingVsanObjects(ManagedObjectReference _this, String[] uuids) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("uuids", "String[]", uuids);
        return (String) getWsc().invoke("QuerySyncingVsanObjects", paras, "String");
    }

    public String[] querySystemUsers(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String[]) getWsc().invoke("QuerySystemUsers", paras, "String[]");
    }

    public HostCapability queryTargetCapabilities(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (HostCapability) getWsc().invoke("QueryTargetCapabilities", paras, "HostCapability");
    }

    public HostTpmAttestationReport queryTpmAttestationReport(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostTpmAttestationReport) getWsc().invoke("QueryTpmAttestationReport", paras, "HostTpmAttestationReport");
    }

    public ManagedObjectReference[] queryUnmonitoredHosts(ManagedObjectReference _this, String providerId, ManagedObjectReference cluster) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("providerId", "String", providerId);
        paras[2] = new Argument("cluster", "ManagedObjectReference", cluster);
        return (ManagedObjectReference[]) getWsc().invoke("QueryUnmonitoredHosts", paras, "ManagedObjectReference[]");
    }

    public String[] queryUnownedFiles(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String[]) getWsc().invoke("QueryUnownedFiles", paras, "String[]");
    }

    public HostUnresolvedVmfsVolume[] queryUnresolvedVmfsVolume(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostUnresolvedVmfsVolume[]) getWsc().invoke("QueryUnresolvedVmfsVolume", paras, "HostUnresolvedVmfsVolume[]");
    }

    public HostUnresolvedVmfsVolume[] queryUnresolvedVmfsVolumes(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostUnresolvedVmfsVolume[]) getWsc().invoke("QueryUnresolvedVmfsVolumes", paras, "HostUnresolvedVmfsVolume[]");
    }

    public int[] queryUsedVlanIdInDvs(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (int[]) getWsc().invoke("QueryUsedVlanIdInDvs", paras, "int[]");
    }

    public int queryVirtualDiskFragmentation(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (int) getWsc().invoke("QueryVirtualDiskFragmentation", paras, "int");
    }

    public HostDiskDimensionsChs queryVirtualDiskGeometry(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (HostDiskDimensionsChs) getWsc().invoke("QueryVirtualDiskGeometry", paras, "HostDiskDimensionsChs");
    }

    public String queryVirtualDiskUuid(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (String) getWsc().invoke("QueryVirtualDiskUuid", paras, "String");
    }

    public String queryVirtualDiskUuidEx(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (String) getWsc().invoke("QueryVirtualDiskUuidEx", paras, "String");
    }

    public VmfsConfigOption[] queryVmfsConfigOption(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VmfsConfigOption[]) getWsc().invoke("QueryVmfsConfigOption", paras, "VmfsConfigOption[]");
    }

    public VmfsDatastoreOption[] queryVmfsDatastoreCreateOptions(ManagedObjectReference _this, String devicePath, int vmfsMajorVersion) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("devicePath", "String", devicePath);
        paras[2] = new Argument("vmfsMajorVersion", "int", vmfsMajorVersion);
        return (VmfsDatastoreOption[]) getWsc().invoke("QueryVmfsDatastoreCreateOptions", paras, "VmfsDatastoreOption[]");
    }

    public VmfsDatastoreOption[] queryVmfsDatastoreExpandOptions(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (VmfsDatastoreOption[]) getWsc().invoke("QueryVmfsDatastoreExpandOptions", paras, "VmfsDatastoreOption[]");
    }

    public VmfsDatastoreOption[] queryVmfsDatastoreExtendOptions(ManagedObjectReference _this, ManagedObjectReference datastore, String devicePath, boolean suppressExpandCandidates) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("devicePath", "String", devicePath);
        paras[3] = new Argument("suppressExpandCandidates", "boolean", suppressExpandCandidates);
        return (VmfsDatastoreOption[]) getWsc().invoke("QueryVmfsDatastoreExtendOptions", paras, "VmfsDatastoreOption[]");
    }

    public HostVMotionCompatibility[] queryVMotionCompatibility(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference[] host, String[] compatibility) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("host", "ManagedObjectReference[]", host);
        paras[3] = new Argument("compatibility", "String[]", compatibility);
        return (HostVMotionCompatibility[]) getWsc().invoke("QueryVMotionCompatibility", paras, "HostVMotionCompatibility[]");
    }

    public ManagedObjectReference queryVMotionCompatibilityEx_Task(ManagedObjectReference _this, ManagedObjectReference[] vm, ManagedObjectReference[] host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference[]", vm);
        paras[2] = new Argument("host", "ManagedObjectReference[]", host);
        return (ManagedObjectReference) getWsc().invoke("QueryVMotionCompatibilityEx_Task", paras, "ManagedObjectReference");
    }

    public IscsiStatus queryVnicStatus(ManagedObjectReference _this, String vnicDevice) throws java.rmi.RemoteException, IscsiFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vnicDevice", "String", vnicDevice);
        return (IscsiStatus) getWsc().invoke("QueryVnicStatus", paras, "IscsiStatus");
    }

    public String queryVsanObjects(ManagedObjectReference _this, String[] uuids) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("uuids", "String[]", uuids);
        return (String) getWsc().invoke("QueryVsanObjects", paras, "String");
    }

    public String[] queryVsanObjectUuidsByFilter(ManagedObjectReference _this, String[] uuids, int limit, int version) throws java.rmi.RemoteException, VsanFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("uuids", "String[]", uuids);
        paras[2] = new Argument("limit", "int", limit);
        paras[3] = new Argument("version", "int", version);
        return (String[]) getWsc().invoke("QueryVsanObjectUuidsByFilter", paras, "String[]");
    }

    public String queryVsanStatistics(ManagedObjectReference _this, String[] labels) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("labels", "String[]", labels);
        return (String) getWsc().invoke("QueryVsanStatistics", paras, "String");
    }

    public VsanUpgradeSystemUpgradeStatus queryVsanUpgradeStatus(ManagedObjectReference _this, ManagedObjectReference cluster) throws java.rmi.RemoteException, VsanFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cluster", "ManagedObjectReference", cluster);
        return (VsanUpgradeSystemUpgradeStatus) getWsc().invoke("QueryVsanUpgradeStatus", paras, "VsanUpgradeSystemUpgradeStatus");
    }

    public String[] readEnvironmentVariableInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String[] names) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("names", "String[]", names);
        return (String[]) getWsc().invoke("ReadEnvironmentVariableInGuest", paras, "String[]");
    }

    public Event[] readNextEvents(ManagedObjectReference _this, int maxCount) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("maxCount", "int", maxCount);
        return (Event[]) getWsc().invoke("ReadNextEvents", paras, "Event[]");
    }

    public TaskInfo[] readNextTasks(ManagedObjectReference _this, int maxCount) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("maxCount", "int", maxCount);
        return (TaskInfo[]) getWsc().invoke("ReadNextTasks", paras, "TaskInfo[]");
    }

    public TaskInfo[] readNextTasksByViewSpec(ManagedObjectReference _this, TaskManagerTaskViewSpec viewSpec, TaskFilterSpec filterSpec, TaskInfoFilterSpec infoFilterSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("viewSpec", "TaskManagerTaskViewSpec", viewSpec);
        paras[2] = new Argument("filterSpec", "TaskFilterSpec", filterSpec);
        paras[3] = new Argument("infoFilterSpec", "TaskInfoFilterSpec", infoFilterSpec);
        return (TaskInfo[]) getWsc().invoke("ReadNextTasksByViewSpec", paras, "TaskInfo[]");
    }

    public Event[] readPreviousEvents(ManagedObjectReference _this, int maxCount) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("maxCount", "int", maxCount);
        return (Event[]) getWsc().invoke("ReadPreviousEvents", paras, "Event[]");
    }

    public TaskInfo[] readPreviousTasks(ManagedObjectReference _this, int maxCount) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("maxCount", "int", maxCount);
        return (TaskInfo[]) getWsc().invoke("ReadPreviousTasks", paras, "TaskInfo[]");
    }

    public void rebootGuest(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, TaskInProgress, ToolsUnavailable, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RebootGuest", paras, null);
    }

    public ManagedObjectReference rebootHost_Task(ManagedObjectReference _this, boolean force) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("force", "boolean", force);
        return (ManagedObjectReference) getWsc().invoke("RebootHost_Task", paras, "ManagedObjectReference");
    }

    public StoragePlacementResult recommendDatastores(ManagedObjectReference _this, StoragePlacementSpec storageSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("storageSpec", "StoragePlacementSpec", storageSpec);
        return (StoragePlacementResult) getWsc().invoke("RecommendDatastores", paras, "StoragePlacementResult");
    }

    public ClusterHostRecommendation[] recommendHostsForVm(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference pool) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("pool", "ManagedObjectReference", pool);
        return (ClusterHostRecommendation[]) getWsc().invoke("RecommendHostsForVm", paras, "ClusterHostRecommendation[]");
    }

    public ManagedObjectReference recommissionVsanNode_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, VsanFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("RecommissionVsanNode_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference reconcileDatastoreInventory_Task(ManagedObjectReference _this, ManagedObjectReference datastore, boolean deepCleansing) throws java.rmi.RemoteException, InvalidDatastore, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("deepCleansing", "boolean", deepCleansing);
        return (ManagedObjectReference) getWsc().invoke("ReconcileDatastoreInventory_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference reconcileDatastoreInventoryEx_Task(ManagedObjectReference _this, VStorageObjectReconcileSpec spec) throws java.rmi.RemoteException, FileFault, InvalidArgument, InvalidDatastore, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VStorageObjectReconcileSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("ReconcileDatastoreInventoryEx_Task", paras, "ManagedObjectReference");
    }

    public VsanPolicySatisfiability[] reconfigurationSatisfiable(ManagedObjectReference _this, VsanPolicyChangeBatch[] pcbs, boolean ignoreSatisfiability) throws java.rmi.RemoteException, VimFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pcbs", "VsanPolicyChangeBatch[]", pcbs);
        paras[2] = new Argument("ignoreSatisfiability", "boolean", ignoreSatisfiability);
        return (VsanPolicySatisfiability[]) getWsc().invoke("ReconfigurationSatisfiable", paras, "VsanPolicySatisfiability[]");
    }

    public void reconfigureAlarm(ManagedObjectReference _this, AlarmSpec spec) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "AlarmSpec", spec);
        getWsc().invoke("ReconfigureAlarm", paras, null);
    }

    public void reconfigureAutostart(ManagedObjectReference _this, HostAutoStartManagerConfig spec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostAutoStartManagerConfig", spec);
        getWsc().invoke("ReconfigureAutostart", paras, null);
    }

    public ManagedObjectReference reconfigureCluster_Task(ManagedObjectReference _this, ClusterConfigSpec spec, boolean modify) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "ClusterConfigSpec", spec);
        paras[2] = new Argument("modify", "boolean", modify);
        return (ManagedObjectReference) getWsc().invoke("ReconfigureCluster_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference reconfigureComputeResource_Task(ManagedObjectReference _this, ComputeResourceConfigSpec spec, boolean modify) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "ComputeResourceConfigSpec", spec);
        paras[2] = new Argument("modify", "boolean", modify);
        return (ManagedObjectReference) getWsc().invoke("ReconfigureComputeResource_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference reconfigureDatacenter_Task(ManagedObjectReference _this, DatacenterConfigSpec spec, boolean modify) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DatacenterConfigSpec", spec);
        paras[2] = new Argument("modify", "boolean", modify);
        return (ManagedObjectReference) getWsc().invoke("ReconfigureDatacenter_Task", paras, "ManagedObjectReference");
    }

    public void reconfigureDomObject(ManagedObjectReference _this, String uuid, String policy) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("uuid", "String", uuid);
        paras[2] = new Argument("policy", "String", policy);
        getWsc().invoke("ReconfigureDomObject", paras, null);
    }

    public ManagedObjectReference reconfigureDVPort_Task(ManagedObjectReference _this, DVPortConfigSpec[] port) throws java.rmi.RemoteException, ConcurrentAccess, DvsFault, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("port", "DVPortConfigSpec[]", port);
        return (ManagedObjectReference) getWsc().invoke("ReconfigureDVPort_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference reconfigureDVPortgroup_Task(ManagedObjectReference _this, DVPortgroupConfigSpec spec) throws java.rmi.RemoteException, ConcurrentAccess, DuplicateName, DvsFault, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DVPortgroupConfigSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("ReconfigureDVPortgroup_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference reconfigureDvs_Task(ManagedObjectReference _this, DVSConfigSpec spec) throws java.rmi.RemoteException, AlreadyExists, ConcurrentAccess, DuplicateName, DvsFault, DvsNotAuthorized, InvalidName, InvalidState, LimitExceeded, NotFound, ResourceInUse, ResourceNotAvailable, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DVSConfigSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("ReconfigureDvs_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference reconfigureHostForDAS_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, DasConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("ReconfigureHostForDAS_Task", paras, "ManagedObjectReference");
    }

    public void reconfigureScheduledTask(ManagedObjectReference _this, ScheduledTaskSpec spec) throws java.rmi.RemoteException, DuplicateName, InvalidName, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "ScheduledTaskSpec", spec);
        getWsc().invoke("ReconfigureScheduledTask", paras, null);
    }

    public void reconfigureServiceConsoleReservation(ManagedObjectReference _this, long cfgBytes) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cfgBytes", "long", cfgBytes);
        getWsc().invoke("ReconfigureServiceConsoleReservation", paras, null);
    }

    public void reconfigureSnmpAgent(ManagedObjectReference _this, HostSnmpConfigSpec spec) throws java.rmi.RemoteException, InsufficientResourcesFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostSnmpConfigSpec", spec);
        getWsc().invoke("ReconfigureSnmpAgent", paras, null);
    }

    public void reconfigureVirtualMachineReservation(ManagedObjectReference _this, VirtualMachineMemoryReservationSpec spec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VirtualMachineMemoryReservationSpec", spec);
        getWsc().invoke("ReconfigureVirtualMachineReservation", paras, null);
    }

    public ManagedObjectReference reconfigVM_Task(ManagedObjectReference _this, VirtualMachineConfigSpec spec) throws java.rmi.RemoteException, ConcurrentAccess, DuplicateName, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidName, InvalidState, TaskInProgress, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VirtualMachineConfigSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("ReconfigVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference reconnectHost_Task(ManagedObjectReference _this, HostConnectSpec cnxSpec, HostSystemReconnectSpec reconnectSpec) throws java.rmi.RemoteException, HostConnectFault, InvalidLogin, InvalidName, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cnxSpec", "HostConnectSpec", cnxSpec);
        paras[2] = new Argument("reconnectSpec", "HostSystemReconnectSpec", reconnectSpec);
        return (ManagedObjectReference) getWsc().invoke("ReconnectHost_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference rectifyDvsHost_Task(ManagedObjectReference _this, ManagedObjectReference[] hosts) throws java.rmi.RemoteException, DvsFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hosts", "ManagedObjectReference[]", hosts);
        return (ManagedObjectReference) getWsc().invoke("RectifyDvsHost_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference rectifyDvsOnHost_Task(ManagedObjectReference _this, ManagedObjectReference[] hosts) throws java.rmi.RemoteException, DvsFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hosts", "ManagedObjectReference[]", hosts);
        return (ManagedObjectReference) getWsc().invoke("RectifyDvsOnHost_Task", paras, "ManagedObjectReference");
    }

    public void refresh(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("Refresh", paras, null);
    }

    public void refreshDatastore(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshDatastore", paras, null);
    }

    public void refreshDatastoreStorageInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshDatastoreStorageInfo", paras, null);
    }

    public void refreshDateTimeSystem(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshDateTimeSystem", paras, null);
    }

    public void refreshDVPortState(ManagedObjectReference _this, String[] portKeys) throws java.rmi.RemoteException, DvsFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portKeys", "String[]", portKeys);
        getWsc().invoke("RefreshDVPortState", paras, null);
    }

    public void refreshFirewall(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshFirewall", paras, null);
    }

    public void refreshGraphicsManager(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshGraphicsManager", paras, null);
    }

    public void refreshHealthStatusSystem(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshHealthStatusSystem", paras, null);
    }

    public void refreshNetworkSystem(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshNetworkSystem", paras, null);
    }

    public void refreshRecommendation(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshRecommendation", paras, null);
    }

    public void refreshRuntime(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshRuntime", paras, null);
    }

    public void refreshServices(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshServices", paras, null);
    }

    public void refreshStorageDrsRecommendation(ManagedObjectReference _this, ManagedObjectReference pod) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pod", "ManagedObjectReference", pod);
        getWsc().invoke("RefreshStorageDrsRecommendation", paras, null);
    }

    public ManagedObjectReference refreshStorageDrsRecommendationsForPod_Task(ManagedObjectReference _this, ManagedObjectReference pod) throws java.rmi.RemoteException, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pod", "ManagedObjectReference", pod);
        return (ManagedObjectReference) getWsc().invoke("RefreshStorageDrsRecommendationsForPod_Task", paras, "ManagedObjectReference");
    }

    public void refreshStorageInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshStorageInfo", paras, null);
    }

    public void refreshStorageSystem(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshStorageSystem", paras, null);
    }

    public ManagedObjectReference registerChildVM_Task(ManagedObjectReference _this, String path, String name, ManagedObjectReference host) throws java.rmi.RemoteException, AlreadyExists, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidName, NotFound, OutOfBounds, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("path", "String", path);
        paras[2] = new Argument("name", "String", name);
        paras[3] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("RegisterChildVM_Task", paras, "ManagedObjectReference");
    }

    public VStorageObject registerDisk(ManagedObjectReference _this, String path, String name) throws java.rmi.RemoteException, AlreadyExists, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("path", "String", path);
        paras[2] = new Argument("name", "String", name);
        return (VStorageObject) getWsc().invoke("RegisterDisk", paras, "VStorageObject");
    }

    public void registerExtension(ManagedObjectReference _this, Extension extension) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extension", "Extension", extension);
        getWsc().invoke("RegisterExtension", paras, null);
    }

    public String registerHealthUpdateProvider(ManagedObjectReference _this, String name, HealthUpdateInfo[] healthUpdateInfo) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("healthUpdateInfo", "HealthUpdateInfo[]", healthUpdateInfo);
        return (String) getWsc().invoke("RegisterHealthUpdateProvider", paras, "String");
    }

    public void registerKmipServer(ManagedObjectReference _this, KmipServerSpec server) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("server", "KmipServerSpec", server);
        getWsc().invoke("RegisterKmipServer", paras, null);
    }

    public void registerKmsCluster(ManagedObjectReference _this, KeyProviderId clusterId, String managementType) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("clusterId", "KeyProviderId", clusterId);
        paras[2] = new Argument("managementType", "String", managementType);
        getWsc().invoke("RegisterKmsCluster", paras, null);
    }

    public ManagedObjectReference registerVM_Task(ManagedObjectReference _this, String path, String name, boolean asTemplate, ManagedObjectReference pool, ManagedObjectReference host) throws java.rmi.RemoteException, AlreadyExists, DuplicateName, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidName, InvalidState, NotFound, OutOfBounds, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("path", "String", path);
        paras[2] = new Argument("name", "String", name);
        paras[3] = new Argument("asTemplate", "boolean", asTemplate);
        paras[4] = new Argument("pool", "ManagedObjectReference", pool);
        paras[5] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("RegisterVM_Task", paras, "ManagedObjectReference");
    }

    public void releaseCredentialsInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        getWsc().invoke("ReleaseCredentialsInGuest", paras, null);
    }

    public void releaseIpAllocation(ManagedObjectReference _this, ManagedObjectReference dc, int poolId, String allocationId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("poolId", "int", poolId);
        paras[3] = new Argument("allocationId", "String", allocationId);
        getWsc().invoke("ReleaseIpAllocation", paras, null);
    }

    public void releaseManagedSnapshot(ManagedObjectReference _this, String vdisk, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileNotFound, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vdisk", "String", vdisk);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        getWsc().invoke("ReleaseManagedSnapshot", paras, null);
    }

    public void reload(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("Reload", paras, null);
    }

    public ManagedObjectReference reloadVirtualMachineFromPath_Task(ManagedObjectReference _this, String configurationPath) throws java.rmi.RemoteException, AlreadyExists, FileFault, InvalidPowerState, InvalidState, TaskInProgress, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configurationPath", "String", configurationPath);
        return (ManagedObjectReference) getWsc().invoke("reloadVirtualMachineFromPath_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference relocateVM_Task(ManagedObjectReference _this, VirtualMachineRelocateSpec spec, VirtualMachineMovePriority priority) throws java.rmi.RemoteException, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidState, MigrationFault, Timedout, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VirtualMachineRelocateSpec", spec);
        paras[2] = new Argument("priority", "VirtualMachineMovePriority", priority);
        return (ManagedObjectReference) getWsc().invoke("RelocateVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference relocateVStorageObject_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, VslmRelocateSpec spec) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("spec", "VslmRelocateSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("RelocateVStorageObject_Task", paras, "ManagedObjectReference");
    }

    public void removeAlarm(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RemoveAlarm", paras, null);
    }

    public ManagedObjectReference removeAllSnapshots_Task(ManagedObjectReference _this, boolean consolidate, SnapshotSelectionSpec spec) throws java.rmi.RemoteException, InvalidState, SnapshotFault, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("consolidate", "boolean", consolidate);
        paras[2] = new Argument("spec", "SnapshotSelectionSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("RemoveAllSnapshots_Task", paras, "ManagedObjectReference");
    }

    public void removeAssignedLicense(ManagedObjectReference _this, String entityId) throws java.rmi.RemoteException, LicenseEntityNotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entityId", "String", entityId);
        getWsc().invoke("RemoveAssignedLicense", paras, null);
    }

    public void removeAuthorizationRole(ManagedObjectReference _this, int roleId, boolean failIfUsed) throws java.rmi.RemoteException, NotFound, RemoveFailed, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("roleId", "int", roleId);
        paras[2] = new Argument("failIfUsed", "boolean", failIfUsed);
        getWsc().invoke("RemoveAuthorizationRole", paras, null);
    }

    public void removeCustomFieldDef(ManagedObjectReference _this, int key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "int", key);
        getWsc().invoke("RemoveCustomFieldDef", paras, null);
    }

    public void removeDatastore(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, HostConfigFault, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        getWsc().invoke("RemoveDatastore", paras, null);
    }

    public ManagedObjectReference removeDatastoreEx_Task(ManagedObjectReference _this, ManagedObjectReference[] datastore) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference[]", datastore);
        return (ManagedObjectReference) getWsc().invoke("RemoveDatastoreEx_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference removeDisk_Task(ManagedObjectReference _this, HostScsiDisk[] disk, HostMaintenanceSpec maintenanceSpec, int timeout) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("disk", "HostScsiDisk[]", disk);
        paras[2] = new Argument("maintenanceSpec", "HostMaintenanceSpec", maintenanceSpec);
        paras[3] = new Argument("timeout", "int", timeout);
        return (ManagedObjectReference) getWsc().invoke("RemoveDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference removeDiskMapping_Task(ManagedObjectReference _this, VsanHostDiskMapping[] mapping, HostMaintenanceSpec maintenanceSpec, int timeout) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("mapping", "VsanHostDiskMapping[]", mapping);
        paras[2] = new Argument("maintenanceSpec", "HostMaintenanceSpec", maintenanceSpec);
        paras[3] = new Argument("timeout", "int", timeout);
        return (ManagedObjectReference) getWsc().invoke("RemoveDiskMapping_Task", paras, "ManagedObjectReference");
    }

    public void removeEntityPermission(ManagedObjectReference _this, ManagedObjectReference entity, String user, boolean isGroup) throws java.rmi.RemoteException, AuthMinimumAdminPermission, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("user", "String", user);
        paras[3] = new Argument("isGroup", "boolean", isGroup);
        getWsc().invoke("RemoveEntityPermission", paras, null);
    }

    public void removeFilter(ManagedObjectReference _this, String filterId) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filterId", "String", filterId);
        getWsc().invoke("RemoveFilter", paras, null);
    }

    public void removeFilterEntities(ManagedObjectReference _this, String filterId, ManagedObjectReference[] entities) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filterId", "String", filterId);
        paras[2] = new Argument("entities", "ManagedObjectReference[]", entities);
        getWsc().invoke("RemoveFilterEntities", paras, null);
    }

    public void removeGroup(ManagedObjectReference _this, String groupName) throws java.rmi.RemoteException, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("groupName", "String", groupName);
        getWsc().invoke("RemoveGroup", paras, null);
    }

    public void removeGuestAlias(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String username, String base64Cert, GuestAuthSubject subject) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("username", "String", username);
        paras[4] = new Argument("base64Cert", "String", base64Cert);
        paras[5] = new Argument("subject", "GuestAuthSubject", subject);
        getWsc().invoke("RemoveGuestAlias", paras, null);
    }

    public void removeGuestAliasByCert(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String username, String base64Cert) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("username", "String", username);
        paras[4] = new Argument("base64Cert", "String", base64Cert);
        getWsc().invoke("RemoveGuestAliasByCert", paras, null);
    }

    public void removeInternetScsiSendTargets(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaSendTarget[] targets, boolean force) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targets", "HostInternetScsiHbaSendTarget[]", targets);
        paras[3] = new Argument("force", "boolean", force);
        getWsc().invoke("RemoveInternetScsiSendTargets", paras, null);
    }

    public void removeInternetScsiStaticTargets(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaStaticTarget[] targets) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targets", "HostInternetScsiHbaStaticTarget[]", targets);
        getWsc().invoke("RemoveInternetScsiStaticTargets", paras, null);
    }

    public void removeKey(ManagedObjectReference _this, CryptoKeyId key, boolean force) throws java.rmi.RemoteException, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "CryptoKeyId", key);
        paras[2] = new Argument("force", "boolean", force);
        getWsc().invoke("RemoveKey", paras, null);
    }

    public CryptoKeyResult[] removeKeys(ManagedObjectReference _this, CryptoKeyId[] keys, boolean force) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("keys", "CryptoKeyId[]", keys);
        paras[2] = new Argument("force", "boolean", force);
        return (CryptoKeyResult[]) getWsc().invoke("RemoveKeys", paras, "CryptoKeyResult[]");
    }

    public void removeKmipServer(ManagedObjectReference _this, KeyProviderId clusterId, String serverName) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("clusterId", "KeyProviderId", clusterId);
        paras[2] = new Argument("serverName", "String", serverName);
        getWsc().invoke("RemoveKmipServer", paras, null);
    }

    public void removeLicense(ManagedObjectReference _this, String licenseKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        getWsc().invoke("RemoveLicense", paras, null);
    }

    public void removeLicenseLabel(ManagedObjectReference _this, String licenseKey, String labelKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        paras[2] = new Argument("labelKey", "String", labelKey);
        getWsc().invoke("RemoveLicenseLabel", paras, null);
    }

    public void removeMonitoredEntities(ManagedObjectReference _this, String providerId, ManagedObjectReference[] entities) throws java.rmi.RemoteException, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("providerId", "String", providerId);
        paras[2] = new Argument("entities", "ManagedObjectReference[]", entities);
        getWsc().invoke("RemoveMonitoredEntities", paras, null);
    }

    public void removeNetworkResourcePool(ManagedObjectReference _this, String[] key) throws java.rmi.RemoteException, DvsFault, InvalidName, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String[]", key);
        getWsc().invoke("RemoveNetworkResourcePool", paras, null);
    }

    public void removeNvmeOverRdmaAdapter(ManagedObjectReference _this, String hbaDeviceName) throws java.rmi.RemoteException, HostConfigFault, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hbaDeviceName", "String", hbaDeviceName);
        getWsc().invoke("RemoveNvmeOverRdmaAdapter", paras, null);
    }

    public void removePerfInterval(ManagedObjectReference _this, int samplePeriod) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("samplePeriod", "int", samplePeriod);
        getWsc().invoke("RemovePerfInterval", paras, null);
    }

    public void removePortGroup(ManagedObjectReference _this, String pgName) throws java.rmi.RemoteException, HostConfigFault, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pgName", "String", pgName);
        getWsc().invoke("RemovePortGroup", paras, null);
    }

    public void removeScheduledTask(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RemoveScheduledTask", paras, null);
    }

    public void removeServiceConsoleVirtualNic(ManagedObjectReference _this, String device) throws java.rmi.RemoteException, HostConfigFault, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        getWsc().invoke("RemoveServiceConsoleVirtualNic", paras, null);
    }

    public void removeSmartCardTrustAnchor(ManagedObjectReference _this, String issuer, String serial) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("issuer", "String", issuer);
        paras[2] = new Argument("serial", "String", serial);
        getWsc().invoke("RemoveSmartCardTrustAnchor", paras, null);
    }

    public void removeSmartCardTrustAnchorByFingerprint(ManagedObjectReference _this, String fingerprint, String digest) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("fingerprint", "String", fingerprint);
        paras[2] = new Argument("digest", "String", digest);
        getWsc().invoke("RemoveSmartCardTrustAnchorByFingerprint", paras, null);
    }

    public void removeSmartCardTrustAnchorCertificate(ManagedObjectReference _this, String certificate) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("certificate", "String", certificate);
        getWsc().invoke("RemoveSmartCardTrustAnchorCertificate", paras, null);
    }

    public ManagedObjectReference removeSnapshot_Task(ManagedObjectReference _this, boolean removeChildren, boolean consolidate) throws java.rmi.RemoteException, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("removeChildren", "boolean", removeChildren);
        paras[2] = new Argument("consolidate", "boolean", consolidate);
        return (ManagedObjectReference) getWsc().invoke("RemoveSnapshot_Task", paras, "ManagedObjectReference");
    }

    public void removeSoftwareAdapter(ManagedObjectReference _this, String hbaDeviceName) throws java.rmi.RemoteException, HostConfigFault, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hbaDeviceName", "String", hbaDeviceName);
        getWsc().invoke("RemoveSoftwareAdapter", paras, null);
    }

    public void removeUser(ManagedObjectReference _this, String userName) throws java.rmi.RemoteException, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("userName", "String", userName);
        getWsc().invoke("RemoveUser", paras, null);
    }

    public void removeVirtualNic(ManagedObjectReference _this, String device) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        getWsc().invoke("RemoveVirtualNic", paras, null);
    }

    public void removeVirtualSwitch(ManagedObjectReference _this, String vswitchName) throws java.rmi.RemoteException, HostConfigFault, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vswitchName", "String", vswitchName);
        getWsc().invoke("RemoveVirtualSwitch", paras, null);
    }

    public ManagedObjectReference rename_Task(ManagedObjectReference _this, String newName) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("newName", "String", newName);
        return (ManagedObjectReference) getWsc().invoke("Rename_Task", paras, "ManagedObjectReference");
    }

    public void renameCustomFieldDef(ManagedObjectReference _this, int key, String name) throws java.rmi.RemoteException, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "int", key);
        paras[2] = new Argument("name", "String", name);
        getWsc().invoke("RenameCustomFieldDef", paras, null);
    }

    public void renameCustomizationSpec(ManagedObjectReference _this, String name, String newName) throws java.rmi.RemoteException, AlreadyExists, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("newName", "String", newName);
        getWsc().invoke("RenameCustomizationSpec", paras, null);
    }

    public void renameDatastore(ManagedObjectReference _this, String newName) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("newName", "String", newName);
        getWsc().invoke("RenameDatastore", paras, null);
    }

    public void renameSnapshot(ManagedObjectReference _this, String name, String description) throws java.rmi.RemoteException, InvalidName, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("description", "String", description);
        getWsc().invoke("RenameSnapshot", paras, null);
    }

    public void renameVStorageObject(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, String name) throws java.rmi.RemoteException, FileFault, InvalidDatastore, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("name", "String", name);
        getWsc().invoke("RenameVStorageObject", paras, null);
    }

    public vslmVClockInfo renameVStorageObjectEx(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, String name) throws java.rmi.RemoteException, FileFault, InvalidDatastore, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("name", "String", name);
        return (vslmVClockInfo) getWsc().invoke("RenameVStorageObjectEx", paras, "vslmVClockInfo");
    }

    public void replaceCACertificatesAndCRLs(ManagedObjectReference _this, String[] caCert, String[] caCrl) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("caCert", "String[]", caCert);
        paras[2] = new Argument("caCrl", "String[]", caCrl);
        getWsc().invoke("ReplaceCACertificatesAndCRLs", paras, null);
    }

    public void replaceSmartCardTrustAnchors(ManagedObjectReference _this, String[] certs) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("certs", "String[]", certs);
        getWsc().invoke("ReplaceSmartCardTrustAnchors", paras, null);
    }

    public void rescanAllHba(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RescanAllHba", paras, null);
    }

    public void rescanHba(ManagedObjectReference _this, String hbaDevice) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hbaDevice", "String", hbaDevice);
        getWsc().invoke("RescanHba", paras, null);
    }

    public void rescanVffs(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RescanVffs", paras, null);
    }

    public void rescanVmfs(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RescanVmfs", paras, null);
    }

    public void resetCollector(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("ResetCollector", paras, null);
    }

    public void resetCounterLevelMapping(ManagedObjectReference _this, int[] counters) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("counters", "int[]", counters);
        getWsc().invoke("ResetCounterLevelMapping", paras, null);
    }

    public void resetEntityPermissions(ManagedObjectReference _this, ManagedObjectReference entity, Permission[] permission) throws java.rmi.RemoteException, AuthMinimumAdminPermission, NotFound, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("permission", "Permission[]", permission);
        getWsc().invoke("ResetEntityPermissions", paras, null);
    }

    public void resetFirmwareToFactoryDefaults(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("ResetFirmwareToFactoryDefaults", paras, null);
    }

    public void resetGuestInformation(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("ResetGuestInformation", paras, null);
    }

    public ManagedObjectReference[] resetListView(ManagedObjectReference _this, ManagedObjectReference[] obj) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("obj", "ManagedObjectReference[]", obj);
        return (ManagedObjectReference[]) getWsc().invoke("ResetListView", paras, "ManagedObjectReference[]");
    }

    public void resetListViewFromView(ManagedObjectReference _this, ManagedObjectReference view) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("view", "ManagedObjectReference", view);
        getWsc().invoke("ResetListViewFromView", paras, null);
    }

    public void resetSystemHealthInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("ResetSystemHealthInfo", paras, null);
    }

    public ManagedObjectReference resetVM_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("ResetVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference resignatureUnresolvedVmfsVolume_Task(ManagedObjectReference _this, HostUnresolvedVmfsResignatureSpec resolutionSpec) throws java.rmi.RemoteException, HostConfigFault, VmfsAmbiguousMount, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("resolutionSpec", "HostUnresolvedVmfsResignatureSpec", resolutionSpec);
        return (ManagedObjectReference) getWsc().invoke("ResignatureUnresolvedVmfsVolume_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference resolveInstallationErrorsOnCluster_Task(ManagedObjectReference _this, String filterId, ManagedObjectReference cluster) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filterId", "String", filterId);
        paras[2] = new Argument("cluster", "ManagedObjectReference", cluster);
        return (ManagedObjectReference) getWsc().invoke("ResolveInstallationErrorsOnCluster_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference resolveInstallationErrorsOnHost_Task(ManagedObjectReference _this, String filterId, ManagedObjectReference host) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filterId", "String", filterId);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("ResolveInstallationErrorsOnHost_Task", paras, "ManagedObjectReference");
    }

    public HostUnresolvedVmfsResolutionResult[] resolveMultipleUnresolvedVmfsVolumes(ManagedObjectReference _this, HostUnresolvedVmfsResolutionSpec[] resolutionSpec) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("resolutionSpec", "HostUnresolvedVmfsResolutionSpec[]", resolutionSpec);
        return (HostUnresolvedVmfsResolutionResult[]) getWsc().invoke("ResolveMultipleUnresolvedVmfsVolumes", paras, "HostUnresolvedVmfsResolutionResult[]");
    }

    public ManagedObjectReference resolveMultipleUnresolvedVmfsVolumesEx_Task(ManagedObjectReference _this, HostUnresolvedVmfsResolutionSpec[] resolutionSpec) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("resolutionSpec", "HostUnresolvedVmfsResolutionSpec[]", resolutionSpec);
        return (ManagedObjectReference) getWsc().invoke("ResolveMultipleUnresolvedVmfsVolumesEx_Task", paras, "ManagedObjectReference");
    }

    public void restartService(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, HostConfigFault, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        getWsc().invoke("RestartService", paras, null);
    }

    public void restartServiceConsoleVirtualNic(ManagedObjectReference _this, String device) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        getWsc().invoke("RestartServiceConsoleVirtualNic", paras, null);
    }

    public void restoreFirmwareConfiguration(ManagedObjectReference _this, boolean force) throws java.rmi.RemoteException, FileFault, InvalidBundle, InvalidState, MismatchedBundle, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("force", "boolean", force);
        getWsc().invoke("RestoreFirmwareConfiguration", paras, null);
    }

    public Permission[] retrieveAllPermissions(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (Permission[]) getWsc().invoke("RetrieveAllPermissions", paras, "Permission[]");
    }

    public AnswerFile retrieveAnswerFile(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (AnswerFile) getWsc().invoke("RetrieveAnswerFile", paras, "AnswerFile");
    }

    public AnswerFile retrieveAnswerFileForProfile(ManagedObjectReference _this, ManagedObjectReference host, HostApplyProfile applyProfile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("applyProfile", "HostApplyProfile", applyProfile);
        return (AnswerFile) getWsc().invoke("RetrieveAnswerFileForProfile", paras, "AnswerFile");
    }

    public EventArgDesc[] retrieveArgumentDescription(ManagedObjectReference _this, String eventTypeId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("eventTypeId", "String", eventTypeId);
        return (EventArgDesc[]) getWsc().invoke("RetrieveArgumentDescription", paras, "EventArgDesc[]");
    }

    public HostCertificateManagerCertificateInfo[] retrieveCertificateInfoList(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostCertificateManagerCertificateInfo[]) getWsc().invoke("RetrieveCertificateInfoList", paras, "HostCertificateManagerCertificateInfo[]");
    }

    public String retrieveClientCert(ManagedObjectReference _this, KeyProviderId cluster) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cluster", "KeyProviderId", cluster);
        return (String) getWsc().invoke("RetrieveClientCert", paras, "String");
    }

    public String retrieveClientCsr(ManagedObjectReference _this, KeyProviderId cluster) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cluster", "KeyProviderId", cluster);
        return (String) getWsc().invoke("RetrieveClientCsr", paras, "String");
    }

    public ClusterDasAdvancedRuntimeInfo retrieveDasAdvancedRuntimeInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ClusterDasAdvancedRuntimeInfo) getWsc().invoke("RetrieveDasAdvancedRuntimeInfo", paras, "ClusterDasAdvancedRuntimeInfo");
    }

    public ProfileDescription retrieveDescription(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ProfileDescription) getWsc().invoke("RetrieveDescription", paras, "ProfileDescription");
    }

    public HostDiskPartitionInfo[] retrieveDiskPartitionInfo(ManagedObjectReference _this, String[] devicePath) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("devicePath", "String[]", devicePath);
        return (HostDiskPartitionInfo[]) getWsc().invoke("RetrieveDiskPartitionInfo", paras, "HostDiskPartitionInfo[]");
    }

    public VirtualMachineDynamicPassthroughInfo[] retrieveDynamicPassthroughInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VirtualMachineDynamicPassthroughInfo[]) getWsc().invoke("RetrieveDynamicPassthroughInfo", paras, "VirtualMachineDynamicPassthroughInfo[]");
    }

    public Permission[] retrieveEntityPermissions(ManagedObjectReference _this, ManagedObjectReference entity, boolean inherited) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("inherited", "boolean", inherited);
        return (Permission[]) getWsc().invoke("RetrieveEntityPermissions", paras, "Permission[]");
    }

    public ManagedObjectReference[] retrieveEntityScheduledTask(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        return (ManagedObjectReference[]) getWsc().invoke("RetrieveEntityScheduledTask", paras, "ManagedObjectReference[]");
    }

    public long retrieveFreeEpcMemory(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (long) getWsc().invoke("RetrieveFreeEpcMemory", paras, "long");
    }

    public long retrieveHardwareUptime(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (long) getWsc().invoke("RetrieveHardwareUptime", paras, "long");
    }

    public HostAccessControlEntry[] retrieveHostAccessControlEntries(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostAccessControlEntry[]) getWsc().invoke("RetrieveHostAccessControlEntries", paras, "HostAccessControlEntry[]");
    }

    public StructuredCustomizations[] retrieveHostCustomizations(ManagedObjectReference _this, ManagedObjectReference[] hosts) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hosts", "ManagedObjectReference[]", hosts);
        return (StructuredCustomizations[]) getWsc().invoke("RetrieveHostCustomizations", paras, "StructuredCustomizations[]");
    }

    public StructuredCustomizations[] retrieveHostCustomizationsForProfile(ManagedObjectReference _this, ManagedObjectReference[] hosts, HostApplyProfile applyProfile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hosts", "ManagedObjectReference[]", hosts);
        paras[2] = new Argument("applyProfile", "HostApplyProfile", applyProfile);
        return (StructuredCustomizations[]) getWsc().invoke("RetrieveHostCustomizationsForProfile", paras, "StructuredCustomizations[]");
    }

    public HostSpecification retrieveHostSpecification(ManagedObjectReference _this, ManagedObjectReference host, boolean fromHost) throws java.rmi.RemoteException, HostSpecificationOperationFailed, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("fromHost", "boolean", fromHost);
        return (HostSpecification) getWsc().invoke("RetrieveHostSpecification", paras, "HostSpecification");
    }

    public CryptoManagerKmipServerCertInfo retrieveKmipServerCert(ManagedObjectReference _this, KeyProviderId keyProvider, KmipServerInfo server) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("keyProvider", "KeyProviderId", keyProvider);
        paras[2] = new Argument("server", "KmipServerInfo", server);
        return (CryptoManagerKmipServerCertInfo) getWsc().invoke("RetrieveKmipServerCert", paras, "CryptoManagerKmipServerCertInfo");
    }

    public ManagedObjectReference retrieveKmipServersStatus_Task(ManagedObjectReference _this, KmipClusterInfo[] clusters) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("clusters", "KmipClusterInfo[]", clusters);
        return (ManagedObjectReference) getWsc().invoke("RetrieveKmipServersStatus_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference[] retrieveObjectScheduledTask(ManagedObjectReference _this, ManagedObjectReference obj) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("obj", "ManagedObjectReference", obj);
        return (ManagedObjectReference[]) getWsc().invoke("RetrieveObjectScheduledTask", paras, "ManagedObjectReference[]");
    }

    public ProductComponentInfo[] retrieveProductComponents(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ProductComponentInfo[]) getWsc().invoke("RetrieveProductComponents", paras, "ProductComponentInfo[]");
    }

    public ObjectContent[] retrieveProperties(ManagedObjectReference _this, PropertyFilterSpec[] specSet) throws java.rmi.RemoteException, InvalidProperty, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("specSet", "PropertyFilterSpec[]", specSet);
        return (ObjectContent[]) getWsc().invoke("RetrieveProperties", paras, "ObjectContent[]");
    }

    public RetrieveResult retrievePropertiesEx(ManagedObjectReference _this, PropertyFilterSpec[] specSet, RetrieveOptions options) throws java.rmi.RemoteException, InvalidProperty, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("specSet", "PropertyFilterSpec[]", specSet);
        paras[2] = new Argument("options", "RetrieveOptions", options);
        return (RetrieveResult) getWsc().invoke("RetrievePropertiesEx", paras, "RetrieveResult");
    }

    public Permission[] retrieveRolePermissions(ManagedObjectReference _this, int roleId) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("roleId", "int", roleId);
        return (Permission[]) getWsc().invoke("RetrieveRolePermissions", paras, "Permission[]");
    }

    public String retrieveSelfSignedClientCert(ManagedObjectReference _this, KeyProviderId cluster) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cluster", "KeyProviderId", cluster);
        return (String) getWsc().invoke("RetrieveSelfSignedClientCert", paras, "String");
    }

    public ServiceContent retrieveServiceContent(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ServiceContent) getWsc().invoke("RetrieveServiceContent", paras, "ServiceContent");
    }

    public ManagedObjectReference[] retrieveServiceProviderEntities(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference[]) getWsc().invoke("RetrieveServiceProviderEntities", paras, "ManagedObjectReference[]");
    }

    public VStorageObjectSnapshotDetails retrieveSnapshotDetails(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, ID snapshotId) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("snapshotId", "ID", snapshotId);
        return (VStorageObjectSnapshotDetails) getWsc().invoke("RetrieveSnapshotDetails", paras, "VStorageObjectSnapshotDetails");
    }

    public VStorageObjectSnapshotInfo retrieveSnapshotInfo(ManagedObjectReference _this, ID id, ManagedObjectReference datastore) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (VStorageObjectSnapshotInfo) getWsc().invoke("RetrieveSnapshotInfo", paras, "VStorageObjectSnapshotInfo");
    }

    public UserSearchResult[] retrieveUserGroups(ManagedObjectReference _this, String domain, String searchStr, String belongsToGroup, String belongsToUser, boolean exactMatch, boolean findUsers, boolean findGroups) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[8];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("domain", "String", domain);
        paras[2] = new Argument("searchStr", "String", searchStr);
        paras[3] = new Argument("belongsToGroup", "String", belongsToGroup);
        paras[4] = new Argument("belongsToUser", "String", belongsToUser);
        paras[5] = new Argument("exactMatch", "boolean", exactMatch);
        paras[6] = new Argument("findUsers", "boolean", findUsers);
        paras[7] = new Argument("findGroups", "boolean", findGroups);
        return (UserSearchResult[]) getWsc().invoke("RetrieveUserGroups", paras, "UserSearchResult[]");
    }

    public VirtualMachineVendorDeviceGroupInfo[] retrieveVendorDeviceGroupInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VirtualMachineVendorDeviceGroupInfo[]) getWsc().invoke("RetrieveVendorDeviceGroupInfo", paras, "VirtualMachineVendorDeviceGroupInfo[]");
    }

    public VirtualMachineVgpuDeviceInfo[] retrieveVgpuDeviceInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VirtualMachineVgpuDeviceInfo[]) getWsc().invoke("RetrieveVgpuDeviceInfo", paras, "VirtualMachineVgpuDeviceInfo[]");
    }

    public VirtualMachineVgpuProfileInfo[] retrieveVgpuProfileInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VirtualMachineVgpuProfileInfo[]) getWsc().invoke("RetrieveVgpuProfileInfo", paras, "VirtualMachineVgpuProfileInfo[]");
    }

    public vslmInfrastructureObjectPolicy[] retrieveVStorageInfrastructureObjectPolicy(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (vslmInfrastructureObjectPolicy[]) getWsc().invoke("RetrieveVStorageInfrastructureObjectPolicy", paras, "vslmInfrastructureObjectPolicy[]");
    }

    public VStorageObject retrieveVStorageObject(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, String[] diskInfoFlags) throws java.rmi.RemoteException, FileFault, InvalidDatastore, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("diskInfoFlags", "String[]", diskInfoFlags);
        return (VStorageObject) getWsc().invoke("RetrieveVStorageObject", paras, "VStorageObject");
    }

    public VStorageObjectAssociations[] retrieveVStorageObjectAssociations(ManagedObjectReference _this, RetrieveVStorageObjSpec[] ids) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ids", "RetrieveVStorageObjSpec[]", ids);
        return (VStorageObjectAssociations[]) getWsc().invoke("RetrieveVStorageObjectAssociations", paras, "VStorageObjectAssociations[]");
    }

    public VStorageObjectStateInfo retrieveVStorageObjectState(ManagedObjectReference _this, ID id, ManagedObjectReference datastore) throws java.rmi.RemoteException, FileFault, InvalidDatastore, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (VStorageObjectStateInfo) getWsc().invoke("RetrieveVStorageObjectState", paras, "VStorageObjectStateInfo");
    }

    public ManagedObjectReference revertToCurrentSnapshot_Task(ManagedObjectReference _this, ManagedObjectReference host, boolean suppressPowerOn) throws java.rmi.RemoteException, InsufficientResourcesFault, InvalidState, NotFound, SnapshotFault, TaskInProgress, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("suppressPowerOn", "boolean", suppressPowerOn);
        return (ManagedObjectReference) getWsc().invoke("RevertToCurrentSnapshot_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference revertToSnapshot_Task(ManagedObjectReference _this, ManagedObjectReference host, boolean suppressPowerOn) throws java.rmi.RemoteException, FileFault, InsufficientResourcesFault, InvalidState, TaskInProgress, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("suppressPowerOn", "boolean", suppressPowerOn);
        return (ManagedObjectReference) getWsc().invoke("RevertToSnapshot_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference revertVStorageObject_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, ID snapshotId) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("snapshotId", "ID", snapshotId);
        return (ManagedObjectReference) getWsc().invoke("RevertVStorageObject_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference revertVStorageObjectEx_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, ID snapshotId) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("snapshotId", "ID", snapshotId);
        return (ManagedObjectReference) getWsc().invoke("RevertVStorageObjectEx_Task", paras, "ManagedObjectReference");
    }

    public void rewindCollector(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RewindCollector", paras, null);
    }

    public void runScheduledTask(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RunScheduledTask", paras, null);
    }

    public HostVsanInternalSystemVsanPhysicalDiskDiagnosticsResult[] runVsanPhysicalDiskDiagnostics(ManagedObjectReference _this, String[] disks) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("disks", "String[]", disks);
        return (HostVsanInternalSystemVsanPhysicalDiskDiagnosticsResult[]) getWsc().invoke("RunVsanPhysicalDiskDiagnostics", paras, "HostVsanInternalSystemVsanPhysicalDiskDiagnosticsResult[]");
    }

    public ManagedObjectReference scanHostPatch_Task(ManagedObjectReference _this, HostPatchManagerLocator repository, String[] updateID) throws java.rmi.RemoteException, PatchMetadataInvalid, PlatformConfigFault, RequestCanceled, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("repository", "HostPatchManagerLocator", repository);
        paras[2] = new Argument("updateID", "String[]", updateID);
        return (ManagedObjectReference) getWsc().invoke("ScanHostPatch_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference scanHostPatchV2_Task(ManagedObjectReference _this, String[] metaUrls, String[] bundleUrls, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, InvalidState, PlatformConfigFault, RequestCanceled, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("metaUrls", "String[]", metaUrls);
        paras[2] = new Argument("bundleUrls", "String[]", bundleUrls);
        paras[3] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("ScanHostPatchV2_Task", paras, "ManagedObjectReference");
    }

    public void scheduleReconcileDatastoreInventory(ManagedObjectReference _this, ManagedObjectReference datastore, boolean deepCleansing) throws java.rmi.RemoteException, InvalidDatastore, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("deepCleansing", "boolean", deepCleansing);
        getWsc().invoke("ScheduleReconcileDatastoreInventory", paras, null);
    }

    public ManagedObjectReference searchDatastore_Task(ManagedObjectReference _this, String datastorePath, HostDatastoreBrowserSearchSpec searchSpec) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastorePath", "String", datastorePath);
        paras[2] = new Argument("searchSpec", "HostDatastoreBrowserSearchSpec", searchSpec);
        return (ManagedObjectReference) getWsc().invoke("SearchDatastore_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference searchDatastoreSubFolders_Task(ManagedObjectReference _this, String datastorePath, HostDatastoreBrowserSearchSpec searchSpec) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastorePath", "String", datastorePath);
        paras[2] = new Argument("searchSpec", "HostDatastoreBrowserSearchSpec", searchSpec);
        return (ManagedObjectReference) getWsc().invoke("SearchDatastoreSubFolders_Task", paras, "ManagedObjectReference");
    }

    public void selectActivePartition(ManagedObjectReference _this, HostScsiDiskPartition partition) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("partition", "HostScsiDiskPartition", partition);
        getWsc().invoke("SelectActivePartition", paras, null);
    }

    public void selectVnic(ManagedObjectReference _this, String device) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        getWsc().invoke("SelectVnic", paras, null);
    }

    public void selectVnicForNicType(ManagedObjectReference _this, String nicType, String device) throws java.rmi.RemoteException, HostConfigFault, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("nicType", "String", nicType);
        paras[2] = new Argument("device", "String", device);
        getWsc().invoke("SelectVnicForNicType", paras, null);
    }

    public void sendNMI(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("SendNMI", paras, null);
    }

    public void sendTestNotification(ManagedObjectReference _this) throws java.rmi.RemoteException, InsufficientResourcesFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("SendTestNotification", paras, null);
    }

    public boolean sessionIsActive(ManagedObjectReference _this, String sessionID, String userName) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sessionID", "String", sessionID);
        paras[2] = new Argument("userName", "String", userName);
        return (boolean) getWsc().invoke("SessionIsActive", paras, "boolean");
    }

    public ManagedObjectReference setClusterMode_Task(ManagedObjectReference _this, String mode) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("mode", "String", mode);
        return (ManagedObjectReference) getWsc().invoke("setClusterMode_Task", paras, "ManagedObjectReference");
    }

    public void setCollectorPageSize(ManagedObjectReference _this, int maxCount) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("maxCount", "int", maxCount);
        getWsc().invoke("SetCollectorPageSize", paras, null);
    }

    public void setCryptoMode(ManagedObjectReference _this, String cryptoMode, ClusterComputeResourceCryptoModePolicy policy) throws java.rmi.RemoteException, InvalidArgument, InvalidRequest, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cryptoMode", "String", cryptoMode);
        paras[2] = new Argument("policy", "ClusterComputeResourceCryptoModePolicy", policy);
        getWsc().invoke("SetCryptoMode", paras, null);
    }

    public void setCustomValue(ManagedObjectReference _this, String key, String value) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String", key);
        paras[2] = new Argument("value", "String", value);
        getWsc().invoke("setCustomValue", paras, null);
    }

    public void setDefaultKmsCluster(ManagedObjectReference _this, ManagedObjectReference entity, KeyProviderId clusterId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("clusterId", "KeyProviderId", clusterId);
        getWsc().invoke("SetDefaultKmsCluster", paras, null);
    }

    public void setDisplayTopology(ManagedObjectReference _this, VirtualMachineDisplayTopology[] displays) throws java.rmi.RemoteException, InvalidState, ToolsUnavailable, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("displays", "VirtualMachineDisplayTopology[]", displays);
        getWsc().invoke("SetDisplayTopology", paras, null);
    }

    public void setEntityPermissions(ManagedObjectReference _this, ManagedObjectReference entity, Permission[] permission) throws java.rmi.RemoteException, AuthMinimumAdminPermission, NotFound, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("permission", "Permission[]", permission);
        getWsc().invoke("SetEntityPermissions", paras, null);
    }

    public void setExtensionCertificate(ManagedObjectReference _this, String extensionKey, String certificatePem) throws java.rmi.RemoteException, NoClientCertificate, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        paras[2] = new Argument("certificatePem", "String", certificatePem);
        getWsc().invoke("SetExtensionCertificate", paras, null);
    }

    public void setField(ManagedObjectReference _this, ManagedObjectReference entity, int key, String value) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("key", "int", key);
        paras[3] = new Argument("value", "String", value);
        getWsc().invoke("SetField", paras, null);
    }

    public CryptoKeyResult setKeyCustomAttributes(ManagedObjectReference _this, CryptoKeyId keyId, CryptoManagerKmipCustomAttributeSpec spec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("keyId", "CryptoKeyId", keyId);
        paras[2] = new Argument("spec", "CryptoManagerKmipCustomAttributeSpec", spec);
        return (CryptoKeyResult) getWsc().invoke("SetKeyCustomAttributes", paras, "CryptoKeyResult");
    }

    public void setLicenseEdition(ManagedObjectReference _this, ManagedObjectReference host, String featureKey) throws java.rmi.RemoteException, InvalidState, LicenseServerUnavailable, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("featureKey", "String", featureKey);
        getWsc().invoke("SetLicenseEdition", paras, null);
    }

    public void setLocale(ManagedObjectReference _this, String locale) throws java.rmi.RemoteException, InvalidLocale, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("locale", "String", locale);
        getWsc().invoke("SetLocale", paras, null);
    }

    public void setMaxQueueDepth(ManagedObjectReference _this, ManagedObjectReference datastore, long maxQdepth) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("maxQdepth", "long", maxQdepth);
        getWsc().invoke("SetMaxQueueDepth", paras, null);
    }

    public void setMultipathLunPolicy(ManagedObjectReference _this, String lunId, HostMultipathInfoLogicalUnitPolicy policy) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunId", "String", lunId);
        paras[2] = new Argument("policy", "HostMultipathInfoLogicalUnitPolicy", policy);
        getWsc().invoke("SetMultipathLunPolicy", paras, null);
    }

    public void setNFSUser(ManagedObjectReference _this, String user, String password) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("user", "String", user);
        paras[2] = new Argument("password", "String", password);
        getWsc().invoke("SetNFSUser", paras, null);
    }

    public void setPublicKey(ManagedObjectReference _this, String extensionKey, String publicKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        paras[2] = new Argument("publicKey", "String", publicKey);
        getWsc().invoke("SetPublicKey", paras, null);
    }

    public void setRegistryValueInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, GuestRegValueSpec value) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("value", "GuestRegValueSpec", value);
        getWsc().invoke("SetRegistryValueInGuest", paras, null);
    }

    public void setScreenResolution(ManagedObjectReference _this, int width, int height) throws java.rmi.RemoteException, InvalidState, ToolsUnavailable, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("width", "int", width);
        paras[2] = new Argument("height", "int", height);
        getWsc().invoke("SetScreenResolution", paras, null);
    }

    public void setServiceAccount(ManagedObjectReference _this, String extensionKey, String serviceAccount) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        paras[2] = new Argument("serviceAccount", "String", serviceAccount);
        getWsc().invoke("SetServiceAccount", paras, null);
    }

    public void setTaskDescription(ManagedObjectReference _this, LocalizableMessage description) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("description", "LocalizableMessage", description);
        getWsc().invoke("SetTaskDescription", paras, null);
    }

    public void setTaskState(ManagedObjectReference _this, TaskInfoState state, Object result, LocalizedMethodFault fault) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("state", "TaskInfoState", state);
        paras[2] = new Argument("result", "Object", result);
        paras[3] = new Argument("fault", "LocalizedMethodFault", fault);
        getWsc().invoke("SetTaskState", paras, null);
    }

    public void setVirtualDiskUuid(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, String uuid) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("uuid", "String", uuid);
        getWsc().invoke("SetVirtualDiskUuid", paras, null);
    }

    public ManagedObjectReference setVirtualDiskUuidEx_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, String uuid) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("uuid", "String", uuid);
        return (ManagedObjectReference) getWsc().invoke("SetVirtualDiskUuidEx_Task", paras, "ManagedObjectReference");
    }

    public void setVStorageObjectControlFlags(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, String[] controlFlags) throws java.rmi.RemoteException, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("controlFlags", "String[]", controlFlags);
        getWsc().invoke("SetVStorageObjectControlFlags", paras, null);
    }

    public ManagedObjectReference shrinkVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, boolean copy) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("copy", "boolean", copy);
        return (ManagedObjectReference) getWsc().invoke("ShrinkVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public void shutdownGuest(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, TaskInProgress, ToolsUnavailable, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("ShutdownGuest", paras, null);
    }

    public ManagedObjectReference shutdownHost_Task(ManagedObjectReference _this, boolean force) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("force", "boolean", force);
        return (ManagedObjectReference) getWsc().invoke("ShutdownHost_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference stageHostPatch_Task(ManagedObjectReference _this, String[] metaUrls, String[] bundleUrls, String[] vibUrls, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, InvalidState, PlatformConfigFault, RequestCanceled, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("metaUrls", "String[]", metaUrls);
        paras[2] = new Argument("bundleUrls", "String[]", bundleUrls);
        paras[3] = new Argument("vibUrls", "String[]", vibUrls);
        paras[4] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("StageHostPatch_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference stampAllRulesWithUuid_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("StampAllRulesWithUuid_Task", paras, "ManagedObjectReference");
    }

    public void standbyGuest(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, TaskInProgress, ToolsUnavailable, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("StandbyGuest", paras, null);
    }

    public void startDpuFailover(ManagedObjectReference _this, String dvsName, String targetDpuAlias) throws java.rmi.RemoteException, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dvsName", "String", dvsName);
        paras[2] = new Argument("targetDpuAlias", "String", targetDpuAlias);
        getWsc().invoke("startDpuFailover", paras, null);
    }

    public ManagedObjectReference startGuestNetwork_Task(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth) throws java.rmi.RemoteException, CustomizationFault, GuestPermissionDenied, InvalidGuestLogin, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        return (ManagedObjectReference) getWsc().invoke("StartGuestNetwork_Task", paras, "ManagedObjectReference");
    }

    public long startProgramInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, GuestProgramSpec spec) throws java.rmi.RemoteException, FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("spec", "GuestProgramSpec", spec);
        return (long) getWsc().invoke("StartProgramInGuest", paras, "long");
    }

    public ManagedObjectReference startRecording_Task(ManagedObjectReference _this, String name, String description) throws java.rmi.RemoteException, FileFault, HostIncompatibleForRecordReplay, InvalidName, InvalidPowerState, InvalidState, RecordReplayDisabled, SnapshotFault, TaskInProgress, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("description", "String", description);
        return (ManagedObjectReference) getWsc().invoke("StartRecording_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference startReplaying_Task(ManagedObjectReference _this, ManagedObjectReference replaySnapshot) throws java.rmi.RemoteException, FileFault, HostIncompatibleForRecordReplay, InvalidPowerState, InvalidState, NotFound, RecordReplayDisabled, SnapshotFault, TaskInProgress, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("replaySnapshot", "ManagedObjectReference", replaySnapshot);
        return (ManagedObjectReference) getWsc().invoke("StartReplaying_Task", paras, "ManagedObjectReference");
    }

    public void startService(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, HostConfigFault, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        getWsc().invoke("StartService", paras, null);
    }

    public ManagedObjectReference stopRecording_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, FileFault, InvalidPowerState, InvalidState, SnapshotFault, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("StopRecording_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference stopReplaying_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, FileFault, InvalidPowerState, InvalidState, SnapshotFault, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("StopReplaying_Task", paras, "ManagedObjectReference");
    }

    public void stopService(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, HostConfigFault, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        getWsc().invoke("StopService", paras, null);
    }

    public ManagedObjectReference suspendVApp_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, TaskInProgress, VAppConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("SuspendVApp_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference suspendVM_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("SuspendVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference terminateFaultTolerantVM_Task(ManagedObjectReference _this, ManagedObjectReference vm) throws java.rmi.RemoteException, InvalidState, TaskInProgress, VmFaultToleranceIssue, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        return (ManagedObjectReference) getWsc().invoke("TerminateFaultTolerantVM_Task", paras, "ManagedObjectReference");
    }

    public void terminateProcessInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, long pid) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("pid", "long", pid);
        getWsc().invoke("TerminateProcessInGuest", paras, null);
    }

    public void terminateSession(ManagedObjectReference _this, String[] sessionId) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sessionId", "String[]", sessionId);
        getWsc().invoke("TerminateSession", paras, null);
    }

    public void terminateVM(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("TerminateVM", paras, null);
    }

    public HostDateTimeSystemServiceTestResult testTimeService(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostDateTimeSystemServiceTestResult) getWsc().invoke("TestTimeService", paras, "HostDateTimeSystemServiceTestResult");
    }

    public ManagedObjectReference turnDiskLocatorLedOff_Task(ManagedObjectReference _this, String[] scsiDiskUuids) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("scsiDiskUuids", "String[]", scsiDiskUuids);
        return (ManagedObjectReference) getWsc().invoke("TurnDiskLocatorLedOff_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference turnDiskLocatorLedOn_Task(ManagedObjectReference _this, String[] scsiDiskUuids) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("scsiDiskUuids", "String[]", scsiDiskUuids);
        return (ManagedObjectReference) getWsc().invoke("TurnDiskLocatorLedOn_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference turnOffFaultToleranceForVM_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, TaskInProgress, VmFaultToleranceIssue, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("TurnOffFaultToleranceForVM_Task", paras, "ManagedObjectReference");
    }

    public void unassignUserFromGroup(ManagedObjectReference _this, String user, String group) throws java.rmi.RemoteException, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("user", "String", user);
        paras[2] = new Argument("group", "String", group);
        getWsc().invoke("UnassignUserFromGroup", paras, null);
    }

    public void unbindVnic(ManagedObjectReference _this, String iScsiHbaName, String vnicDevice, boolean force) throws java.rmi.RemoteException, IscsiFault, IscsiFaultVnicHasActivePaths, IscsiFaultVnicIsLastPath, IscsiFaultVnicNotBound, NotFound, PlatformConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaName", "String", iScsiHbaName);
        paras[2] = new Argument("vnicDevice", "String", vnicDevice);
        paras[3] = new Argument("force", "boolean", force);
        getWsc().invoke("UnbindVnic", paras, null);
    }

    public ManagedObjectReference uninstallHostPatch_Task(ManagedObjectReference _this, String[] bulletinIds, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, InvalidState, PlatformConfigFault, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("bulletinIds", "String[]", bulletinIds);
        paras[2] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("UninstallHostPatch_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference uninstallIoFilter_Task(ManagedObjectReference _this, String filterId, ManagedObjectReference compRes) throws java.rmi.RemoteException, FilterInUse, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filterId", "String", filterId);
        paras[2] = new Argument("compRes", "ManagedObjectReference", compRes);
        return (ManagedObjectReference) getWsc().invoke("UninstallIoFilter_Task", paras, "ManagedObjectReference");
    }

    public void uninstallService(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        getWsc().invoke("UninstallService", paras, null);
    }

    public ManagedObjectReference unmapVmfsVolumeEx_Task(ManagedObjectReference _this, String[] vmfsUuid) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsUuid", "String[]", vmfsUuid);
        return (ManagedObjectReference) getWsc().invoke("UnmapVmfsVolumeEx_Task", paras, "ManagedObjectReference");
    }

    public void unmarkServiceProviderEntities(ManagedObjectReference _this, ManagedObjectReference[] entity) throws java.rmi.RemoteException, ManagedObjectNotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        getWsc().invoke("UnmarkServiceProviderEntities", paras, null);
    }

    public ManagedObjectReference unmountDiskMapping_Task(ManagedObjectReference _this, VsanHostDiskMapping[] mapping) throws java.rmi.RemoteException, InvalidState, VsanFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("mapping", "VsanHostDiskMapping[]", mapping);
        return (ManagedObjectReference) getWsc().invoke("UnmountDiskMapping_Task", paras, "ManagedObjectReference");
    }

    public void unmountForceMountedVmfsVolume(ManagedObjectReference _this, String vmfsUuid) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsUuid", "String", vmfsUuid);
        getWsc().invoke("UnmountForceMountedVmfsVolume", paras, null);
    }

    public void unmountToolsInstaller(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("UnmountToolsInstaller", paras, null);
    }

    public void unmountVffsVolume(ManagedObjectReference _this, String vffsUuid) throws java.rmi.RemoteException, HostConfigFault, InvalidState, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsUuid", "String", vffsUuid);
        getWsc().invoke("UnmountVffsVolume", paras, null);
    }

    public void unmountVmfsVolume(ManagedObjectReference _this, String vmfsUuid) throws java.rmi.RemoteException, HostConfigFault, InvalidState, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsUuid", "String", vmfsUuid);
        getWsc().invoke("UnmountVmfsVolume", paras, null);
    }

    public ManagedObjectReference unmountVmfsVolumeEx_Task(ManagedObjectReference _this, String[] vmfsUuid) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsUuid", "String[]", vmfsUuid);
        return (ManagedObjectReference) getWsc().invoke("UnmountVmfsVolumeEx_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference unregisterAndDestroy_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, ConcurrentAccess, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("UnregisterAndDestroy_Task", paras, "ManagedObjectReference");
    }

    public void unregisterExtension(ManagedObjectReference _this, String extensionKey) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        getWsc().invoke("UnregisterExtension", paras, null);
    }

    public void unregisterHealthUpdateProvider(ManagedObjectReference _this, String providerId) throws java.rmi.RemoteException, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("providerId", "String", providerId);
        getWsc().invoke("UnregisterHealthUpdateProvider", paras, null);
    }

    public void unregisterKmsCluster(ManagedObjectReference _this, KeyProviderId clusterId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("clusterId", "KeyProviderId", clusterId);
        getWsc().invoke("UnregisterKmsCluster", paras, null);
    }

    public ManagedObjectReference unregisterVApp_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, ConcurrentAccess, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("unregisterVApp_Task", paras, "ManagedObjectReference");
    }

    public void unregisterVM(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidPowerState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("UnregisterVM", paras, null);
    }

    public ManagedObjectReference updateAnswerFile_Task(ManagedObjectReference _this, ManagedObjectReference host, AnswerFileCreateSpec configSpec) throws java.rmi.RemoteException, AnswerFileUpdateFailed, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("configSpec", "AnswerFileCreateSpec", configSpec);
        return (ManagedObjectReference) getWsc().invoke("UpdateAnswerFile_Task", paras, "ManagedObjectReference");
    }

    public void updateAssignableHardwareConfig(ManagedObjectReference _this, HostAssignableHardwareConfig config) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostAssignableHardwareConfig", config);
        getWsc().invoke("UpdateAssignableHardwareConfig", paras, null);
    }

    public LicenseManagerLicenseInfo updateAssignedLicense(ManagedObjectReference _this, String entity, String licenseKey, String entityDisplayName) throws java.rmi.RemoteException, LicenseEntityNotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "String", entity);
        paras[2] = new Argument("licenseKey", "String", licenseKey);
        paras[3] = new Argument("entityDisplayName", "String", entityDisplayName);
        return (LicenseManagerLicenseInfo) getWsc().invoke("UpdateAssignedLicense", paras, "LicenseManagerLicenseInfo");
    }

    public void updateAuthorizationRole(ManagedObjectReference _this, int roleId, String newName, String[] privIds) throws java.rmi.RemoteException, AlreadyExists, InvalidName, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("roleId", "int", roleId);
        paras[2] = new Argument("newName", "String", newName);
        paras[3] = new Argument("privIds", "String[]", privIds);
        getWsc().invoke("UpdateAuthorizationRole", paras, null);
    }

    public void updateBootDevice(ManagedObjectReference _this, String key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String", key);
        getWsc().invoke("UpdateBootDevice", paras, null);
    }

    public void updateChildResourceConfiguration(ManagedObjectReference _this, ResourceConfigSpec[] spec) throws java.rmi.RemoteException, InsufficientResourcesFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "ResourceConfigSpec[]", spec);
        getWsc().invoke("UpdateChildResourceConfiguration", paras, null);
    }

    public void updateClusterProfile(ManagedObjectReference _this, ClusterProfileConfigSpec config) throws java.rmi.RemoteException, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "ClusterProfileConfigSpec", config);
        getWsc().invoke("UpdateClusterProfile", paras, null);
    }

    public void updateConfig(ManagedObjectReference _this, String name, ResourceConfigSpec config) throws java.rmi.RemoteException, ConcurrentAccess, DuplicateName, InsufficientResourcesFault, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("config", "ResourceConfigSpec", config);
        getWsc().invoke("UpdateConfig", paras, null);
    }

    public void updateConsoleIpRouteConfig(ManagedObjectReference _this, HostIpRouteConfig config) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostIpRouteConfig", config);
        getWsc().invoke("UpdateConsoleIpRouteConfig", paras, null);
    }

    public void updateCounterLevelMapping(ManagedObjectReference _this, PerformanceManagerCounterLevelMapping[] counterLevelMap) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("counterLevelMap", "PerformanceManagerCounterLevelMapping[]", counterLevelMap);
        getWsc().invoke("UpdateCounterLevelMapping", paras, null);
    }

    public void updateDateTime(ManagedObjectReference _this, Calendar dateTime) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dateTime", "Calendar", dateTime);
        getWsc().invoke("UpdateDateTime", paras, null);
    }

    public void updateDateTimeConfig(ManagedObjectReference _this, HostDateTimeConfig config) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostDateTimeConfig", config);
        getWsc().invoke("UpdateDateTimeConfig", paras, null);
    }

    public void updateDefaultPolicy(ManagedObjectReference _this, HostFirewallDefaultPolicy defaultPolicy) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("defaultPolicy", "HostFirewallDefaultPolicy", defaultPolicy);
        getWsc().invoke("UpdateDefaultPolicy", paras, null);
    }

    public void updateDiskPartitions(ManagedObjectReference _this, String devicePath, HostDiskPartitionSpec spec) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("devicePath", "String", devicePath);
        paras[2] = new Argument("spec", "HostDiskPartitionSpec", spec);
        getWsc().invoke("UpdateDiskPartitions", paras, null);
    }

    public void updateDnsConfig(ManagedObjectReference _this, HostDnsConfig config) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostDnsConfig", config);
        getWsc().invoke("UpdateDnsConfig", paras, null);
    }

    public void updateDvsCapability(ManagedObjectReference _this, DVSCapability capability) throws java.rmi.RemoteException, DvsFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("capability", "DVSCapability", capability);
        getWsc().invoke("UpdateDvsCapability", paras, null);
    }

    public ManagedObjectReference updateDVSHealthCheckConfig_Task(ManagedObjectReference _this, DVSHealthCheckConfig[] healthCheckConfig) throws java.rmi.RemoteException, DvsFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("healthCheckConfig", "DVSHealthCheckConfig[]", healthCheckConfig);
        return (ManagedObjectReference) getWsc().invoke("UpdateDVSHealthCheckConfig_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference updateDVSLacpGroupConfig_Task(ManagedObjectReference _this, VMwareDvsLacpGroupSpec[] lacpGroupSpec) throws java.rmi.RemoteException, DvsFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lacpGroupSpec", "VMwareDvsLacpGroupSpec[]", lacpGroupSpec);
        return (ManagedObjectReference) getWsc().invoke("UpdateDVSLacpGroupConfig_Task", paras, "ManagedObjectReference");
    }

    public void updateExtension(ManagedObjectReference _this, Extension extension) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extension", "Extension", extension);
        getWsc().invoke("UpdateExtension", paras, null);
    }

    public void updateFlags(ManagedObjectReference _this, HostFlagInfo flagInfo) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("flagInfo", "HostFlagInfo", flagInfo);
        getWsc().invoke("UpdateFlags", paras, null);
    }

    public void updateGraphicsConfig(ManagedObjectReference _this, HostGraphicsConfig config) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostGraphicsConfig", config);
        getWsc().invoke("UpdateGraphicsConfig", paras, null);
    }

    public void updateHostImageAcceptanceLevel(ManagedObjectReference _this, String newAcceptanceLevel) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("newAcceptanceLevel", "String", newAcceptanceLevel);
        getWsc().invoke("UpdateHostImageAcceptanceLevel", paras, null);
    }

    public void updateHostProfile(ManagedObjectReference _this, HostProfileConfigSpec config) throws java.rmi.RemoteException, DuplicateName, ProfileUpdateFailed, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostProfileConfigSpec", config);
        getWsc().invoke("UpdateHostProfile", paras, null);
    }

    public void updateHostSpecification(ManagedObjectReference _this, ManagedObjectReference host, HostSpecification hostSpec) throws java.rmi.RemoteException, HostSpecificationOperationFailed, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("hostSpec", "HostSpecification", hostSpec);
        getWsc().invoke("UpdateHostSpecification", paras, null);
    }

    public void updateHostSubSpecification(ManagedObjectReference _this, ManagedObjectReference host, HostSubSpecification hostSubSpec) throws java.rmi.RemoteException, HostSpecificationOperationFailed, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("hostSubSpec", "HostSubSpecification", hostSubSpec);
        getWsc().invoke("UpdateHostSubSpecification", paras, null);
    }

    public void updateHppMultipathLunPolicy(ManagedObjectReference _this, String lunId, HostMultipathInfoHppLogicalUnitPolicy policy) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunId", "String", lunId);
        paras[2] = new Argument("policy", "HostMultipathInfoHppLogicalUnitPolicy", policy);
        getWsc().invoke("UpdateHppMultipathLunPolicy", paras, null);
    }

    public void updateInternetScsiAdvancedOptions(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaTargetSet targetSet, HostInternetScsiHbaParamValue[] options) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targetSet", "HostInternetScsiHbaTargetSet", targetSet);
        paras[3] = new Argument("options", "HostInternetScsiHbaParamValue[]", options);
        getWsc().invoke("UpdateInternetScsiAdvancedOptions", paras, null);
    }

    public void updateInternetScsiAlias(ManagedObjectReference _this, String iScsiHbaDevice, String iScsiAlias) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("iScsiAlias", "String", iScsiAlias);
        getWsc().invoke("UpdateInternetScsiAlias", paras, null);
    }

    public void updateInternetScsiAuthenticationProperties(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaAuthenticationProperties authenticationProperties, HostInternetScsiHbaTargetSet targetSet) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("authenticationProperties", "HostInternetScsiHbaAuthenticationProperties", authenticationProperties);
        paras[3] = new Argument("targetSet", "HostInternetScsiHbaTargetSet", targetSet);
        getWsc().invoke("UpdateInternetScsiAuthenticationProperties", paras, null);
    }

    public void updateInternetScsiDigestProperties(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaTargetSet targetSet, HostInternetScsiHbaDigestProperties digestProperties) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targetSet", "HostInternetScsiHbaTargetSet", targetSet);
        paras[3] = new Argument("digestProperties", "HostInternetScsiHbaDigestProperties", digestProperties);
        getWsc().invoke("UpdateInternetScsiDigestProperties", paras, null);
    }

    public void updateInternetScsiDiscoveryProperties(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaDiscoveryProperties discoveryProperties) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("discoveryProperties", "HostInternetScsiHbaDiscoveryProperties", discoveryProperties);
        getWsc().invoke("UpdateInternetScsiDiscoveryProperties", paras, null);
    }

    public void updateInternetScsiIPProperties(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaIPProperties ipProperties) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("ipProperties", "HostInternetScsiHbaIPProperties", ipProperties);
        getWsc().invoke("UpdateInternetScsiIPProperties", paras, null);
    }

    public void updateInternetScsiName(ManagedObjectReference _this, String iScsiHbaDevice, String iScsiName) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("iScsiName", "String", iScsiName);
        getWsc().invoke("UpdateInternetScsiName", paras, null);
    }

    public void updateIpConfig(ManagedObjectReference _this, HostIpConfig ipConfig) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ipConfig", "HostIpConfig", ipConfig);
        getWsc().invoke("UpdateIpConfig", paras, null);
    }

    public void updateIpmi(ManagedObjectReference _this, HostIpmiInfo ipmiInfo) throws java.rmi.RemoteException, InvalidIpmiLoginInfo, InvalidIpmiMacAddress, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ipmiInfo", "HostIpmiInfo", ipmiInfo);
        getWsc().invoke("UpdateIpmi", paras, null);
    }

    public void updateIpPool(ManagedObjectReference _this, ManagedObjectReference dc, IpPool pool) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("pool", "IpPool", pool);
        getWsc().invoke("UpdateIpPool", paras, null);
    }

    public void updateIpRouteConfig(ManagedObjectReference _this, HostIpRouteConfig config) throws java.rmi.RemoteException, HostConfigFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostIpRouteConfig", config);
        getWsc().invoke("UpdateIpRouteConfig", paras, null);
    }

    public void updateIpRouteTableConfig(ManagedObjectReference _this, HostIpRouteTableConfig config) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostIpRouteTableConfig", config);
        getWsc().invoke("UpdateIpRouteTableConfig", paras, null);
    }

    public void updateKmipServer(ManagedObjectReference _this, KmipServerSpec server) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("server", "KmipServerSpec", server);
        getWsc().invoke("UpdateKmipServer", paras, null);
    }

    public void updateKmsSignedCsrClientCert(ManagedObjectReference _this, KeyProviderId cluster, String certificate) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cluster", "KeyProviderId", cluster);
        paras[2] = new Argument("certificate", "String", certificate);
        getWsc().invoke("UpdateKmsSignedCsrClientCert", paras, null);
    }

    public LicenseManagerLicenseInfo updateLicense(ManagedObjectReference _this, String licenseKey, KeyValue[] labels) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        paras[2] = new Argument("labels", "KeyValue[]", labels);
        return (LicenseManagerLicenseInfo) getWsc().invoke("UpdateLicense", paras, "LicenseManagerLicenseInfo");
    }

    public void updateLicenseLabel(ManagedObjectReference _this, String licenseKey, String labelKey, String labelValue) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        paras[2] = new Argument("labelKey", "String", labelKey);
        paras[3] = new Argument("labelValue", "String", labelValue);
        getWsc().invoke("UpdateLicenseLabel", paras, null);
    }

    public void updateLinkedChildren(ManagedObjectReference _this, VirtualAppLinkInfo[] addChangeSet, ManagedObjectReference[] removeSet) throws java.rmi.RemoteException, ConcurrentAccess, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("addChangeSet", "VirtualAppLinkInfo[]", addChangeSet);
        paras[2] = new Argument("removeSet", "ManagedObjectReference[]", removeSet);
        getWsc().invoke("UpdateLinkedChildren", paras, null);
    }

    public void updateLocalSwapDatastore(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, DatastoreNotWritableOnHost, InaccessibleDatastore, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        getWsc().invoke("UpdateLocalSwapDatastore", paras, null);
    }

    public void updateLockdownExceptions(ManagedObjectReference _this, String[] users) throws java.rmi.RemoteException, AuthMinimumAdminPermission, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("users", "String[]", users);
        getWsc().invoke("UpdateLockdownExceptions", paras, null);
    }

    public void updateModuleOptionString(ManagedObjectReference _this, String name, String options) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("options", "String", options);
        getWsc().invoke("UpdateModuleOptionString", paras, null);
    }

    public HostNetworkConfigResult updateNetworkConfig(ManagedObjectReference _this, HostNetworkConfig config, String changeMode) throws java.rmi.RemoteException, AlreadyExists, HostConfigFault, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostNetworkConfig", config);
        paras[2] = new Argument("changeMode", "String", changeMode);
        return (HostNetworkConfigResult) getWsc().invoke("UpdateNetworkConfig", paras, "HostNetworkConfigResult");
    }

    public void updateNetworkResourcePool(ManagedObjectReference _this, DVSNetworkResourcePoolConfigSpec[] configSpec) throws java.rmi.RemoteException, ConcurrentAccess, DvsFault, InvalidName, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configSpec", "DVSNetworkResourcePoolConfigSpec[]", configSpec);
        getWsc().invoke("UpdateNetworkResourcePool", paras, null);
    }

    public void updateOptions(ManagedObjectReference _this, OptionValue[] changedValue) throws java.rmi.RemoteException, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("changedValue", "OptionValue[]", changedValue);
        getWsc().invoke("UpdateOptions", paras, null);
    }

    public void updatePassthruConfig(ManagedObjectReference _this, HostPciPassthruConfig[] config) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostPciPassthruConfig[]", config);
        getWsc().invoke("UpdatePassthruConfig", paras, null);
    }

    public void updatePerfInterval(ManagedObjectReference _this, PerfInterval interval) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("interval", "PerfInterval", interval);
        getWsc().invoke("UpdatePerfInterval", paras, null);
    }

    public void updatePhysicalNicLinkSpeed(ManagedObjectReference _this, String device, PhysicalNicLinkInfo linkSpeed) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        paras[2] = new Argument("linkSpeed", "PhysicalNicLinkInfo", linkSpeed);
        getWsc().invoke("UpdatePhysicalNicLinkSpeed", paras, null);
    }

    public void updatePortGroup(ManagedObjectReference _this, String pgName, HostPortGroupSpec portgrp) throws java.rmi.RemoteException, AlreadyExists, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pgName", "String", pgName);
        paras[2] = new Argument("portgrp", "HostPortGroupSpec", portgrp);
        getWsc().invoke("UpdatePortGroup", paras, null);
    }

    public ManagedObjectReference updateProductLockerLocation_Task(ManagedObjectReference _this, String path) throws java.rmi.RemoteException, FileNotFound, HostConfigFault, InvalidArgument, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("path", "String", path);
        return (ManagedObjectReference) getWsc().invoke("UpdateProductLockerLocation_Task", paras, "ManagedObjectReference");
    }

    public void updateProgress(ManagedObjectReference _this, int percentDone) throws java.rmi.RemoteException, InvalidState, OutOfBounds, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("percentDone", "int", percentDone);
        getWsc().invoke("UpdateProgress", paras, null);
    }

    public void updateReferenceHost(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        getWsc().invoke("UpdateReferenceHost", paras, null);
    }

    public void updateRuleset(ManagedObjectReference _this, String id, HostFirewallRulesetRulesetSpec spec) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        paras[2] = new Argument("spec", "HostFirewallRulesetRulesetSpec", spec);
        getWsc().invoke("UpdateRuleset", paras, null);
    }

    public void updateScsiLunDisplayName(ManagedObjectReference _this, String lunUuid, String displayName) throws java.rmi.RemoteException, DuplicateName, HostConfigFault, InvalidName, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunUuid", "String", lunUuid);
        paras[2] = new Argument("displayName", "String", displayName);
        getWsc().invoke("UpdateScsiLunDisplayName", paras, null);
    }

    public void updateSelfSignedClientCert(ManagedObjectReference _this, KeyProviderId cluster, String certificate) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cluster", "KeyProviderId", cluster);
        paras[2] = new Argument("certificate", "String", certificate);
        getWsc().invoke("UpdateSelfSignedClientCert", paras, null);
    }

    public void updateServiceConsoleVirtualNic(ManagedObjectReference _this, String device, HostVirtualNicSpec nic) throws java.rmi.RemoteException, HostConfigFault, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        paras[2] = new Argument("nic", "HostVirtualNicSpec", nic);
        getWsc().invoke("UpdateServiceConsoleVirtualNic", paras, null);
    }

    public void updateServiceMessage(ManagedObjectReference _this, String message) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("message", "String", message);
        getWsc().invoke("UpdateServiceMessage", paras, null);
    }

    public void updateServicePolicy(ManagedObjectReference _this, String id, String policy) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        paras[2] = new Argument("policy", "String", policy);
        getWsc().invoke("UpdateServicePolicy", paras, null);
    }

    public void updateSoftwareInternetScsiEnabled(ManagedObjectReference _this, boolean enabled) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("enabled", "boolean", enabled);
        getWsc().invoke("UpdateSoftwareInternetScsiEnabled", paras, null);
    }

    public void updateSystemResources(ManagedObjectReference _this, HostSystemResourceInfo resourceInfo) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("resourceInfo", "HostSystemResourceInfo", resourceInfo);
        getWsc().invoke("UpdateSystemResources", paras, null);
    }

    public void updateSystemSwapConfiguration(ManagedObjectReference _this, HostSystemSwapConfiguration sysSwapConfig) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sysSwapConfig", "HostSystemSwapConfiguration", sysSwapConfig);
        getWsc().invoke("UpdateSystemSwapConfiguration", paras, null);
    }

    public void updateSystemUsers(ManagedObjectReference _this, String[] users) throws java.rmi.RemoteException, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("users", "String[]", users);
        getWsc().invoke("UpdateSystemUsers", paras, null);
    }

    public void updateUser(ManagedObjectReference _this, HostAccountSpec user) throws java.rmi.RemoteException, AlreadyExists, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("user", "HostAccountSpec", user);
        getWsc().invoke("UpdateUser", paras, null);
    }

    public void updateVAppConfig(ManagedObjectReference _this, VAppConfigSpec spec) throws java.rmi.RemoteException, ConcurrentAccess, DuplicateName, FileFault, InsufficientResourcesFault, InvalidDatastore, InvalidName, InvalidState, TaskInProgress, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VAppConfigSpec", spec);
        getWsc().invoke("UpdateVAppConfig", paras, null);
    }

    public ManagedObjectReference updateVirtualMachineFiles_Task(ManagedObjectReference _this, DatastoreMountPathDatastorePair[] mountPathDatastoreMapping) throws java.rmi.RemoteException, InvalidDatastore, PlatformConfigFault, ResourceInUse, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("mountPathDatastoreMapping", "DatastoreMountPathDatastorePair[]", mountPathDatastoreMapping);
        return (ManagedObjectReference) getWsc().invoke("UpdateVirtualMachineFiles_Task", paras, "ManagedObjectReference");
    }

    public void updateVirtualNic(ManagedObjectReference _this, String device, HostVirtualNicSpec nic) throws java.rmi.RemoteException, HostConfigFault, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        paras[2] = new Argument("nic", "HostVirtualNicSpec", nic);
        getWsc().invoke("UpdateVirtualNic", paras, null);
    }

    public void updateVirtualSwitch(ManagedObjectReference _this, String vswitchName, HostVirtualSwitchSpec spec) throws java.rmi.RemoteException, HostConfigFault, NotFound, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vswitchName", "String", vswitchName);
        paras[2] = new Argument("spec", "HostVirtualSwitchSpec", spec);
        getWsc().invoke("UpdateVirtualSwitch", paras, null);
    }

    public void updateVmfsUnmapBandwidth(ManagedObjectReference _this, String vmfsUuid, VmfsUnmapBandwidthSpec unmapBandwidthSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsUuid", "String", vmfsUuid);
        paras[2] = new Argument("unmapBandwidthSpec", "VmfsUnmapBandwidthSpec", unmapBandwidthSpec);
        getWsc().invoke("UpdateVmfsUnmapBandwidth", paras, null);
    }

    public void updateVmfsUnmapPriority(ManagedObjectReference _this, String vmfsUuid, String unmapPriority) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsUuid", "String", vmfsUuid);
        paras[2] = new Argument("unmapPriority", "String", unmapPriority);
        getWsc().invoke("UpdateVmfsUnmapPriority", paras, null);
    }

    public ManagedObjectReference updateVsan_Task(ManagedObjectReference _this, VsanHostConfigInfo config) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "VsanHostConfigInfo", config);
        return (ManagedObjectReference) getWsc().invoke("UpdateVsan_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference updateVStorageInfrastructureObjectPolicy_Task(ManagedObjectReference _this, vslmInfrastructureObjectPolicySpec spec) throws java.rmi.RemoteException, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "vslmInfrastructureObjectPolicySpec", spec);
        return (ManagedObjectReference) getWsc().invoke("UpdateVStorageInfrastructureObjectPolicy_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference updateVStorageObjectCrypto_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, VirtualMachineProfileSpec[] profile, DiskCryptoSpec disksCrypto) throws java.rmi.RemoteException, FileFault, InvalidDatastore, NotFound, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("profile", "VirtualMachineProfileSpec[]", profile);
        paras[4] = new Argument("disksCrypto", "DiskCryptoSpec", disksCrypto);
        return (ManagedObjectReference) getWsc().invoke("UpdateVStorageObjectCrypto_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference updateVStorageObjectPolicy_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, VirtualMachineProfileSpec[] profile) throws java.rmi.RemoteException, FileFault, InvalidDatastore, NotFound, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("profile", "VirtualMachineProfileSpec[]", profile);
        return (ManagedObjectReference) getWsc().invoke("UpdateVStorageObjectPolicy_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference updateVVolVirtualMachineFiles_Task(ManagedObjectReference _this, DatastoreVVolContainerFailoverPair[] failoverPair) throws java.rmi.RemoteException, InvalidDatastore, NotSupported, PlatformConfigFault, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("failoverPair", "DatastoreVVolContainerFailoverPair[]", failoverPair);
        return (ManagedObjectReference) getWsc().invoke("UpdateVVolVirtualMachineFiles_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference upgradeIoFilter_Task(ManagedObjectReference _this, String filterId, ManagedObjectReference compRes, String vibUrl, IoFilterManagerSslTrust vibSslTrust) throws java.rmi.RemoteException, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filterId", "String", filterId);
        paras[2] = new Argument("compRes", "ManagedObjectReference", compRes);
        paras[3] = new Argument("vibUrl", "String", vibUrl);
        paras[4] = new Argument("vibSslTrust", "IoFilterManagerSslTrust", vibSslTrust);
        return (ManagedObjectReference) getWsc().invoke("UpgradeIoFilter_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference upgradeTools_Task(ManagedObjectReference _this, String installerOptions) throws java.rmi.RemoteException, InvalidState, TaskInProgress, ToolsUnavailable, VmConfigFault, VmToolsUpgradeFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("installerOptions", "String", installerOptions);
        return (ManagedObjectReference) getWsc().invoke("UpgradeTools_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference upgradeVM_Task(ManagedObjectReference _this, String version) throws java.rmi.RemoteException, AlreadyUpgraded, InvalidState, NoDiskFound, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("version", "String", version);
        return (ManagedObjectReference) getWsc().invoke("UpgradeVM_Task", paras, "ManagedObjectReference");
    }

    public void upgradeVmfs(ManagedObjectReference _this, String vmfsPath) throws java.rmi.RemoteException, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsPath", "String", vmfsPath);
        getWsc().invoke("UpgradeVmfs", paras, null);
    }

    public void upgradeVmLayout(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("UpgradeVmLayout", paras, null);
    }

    public HostVsanInternalSystemVsanObjectOperationResult[] upgradeVsanObjects(ManagedObjectReference _this, String[] uuids, int newVersion) throws java.rmi.RemoteException, VsanFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("uuids", "String[]", uuids);
        paras[2] = new Argument("newVersion", "int", newVersion);
        return (HostVsanInternalSystemVsanObjectOperationResult[]) getWsc().invoke("UpgradeVsanObjects", paras, "HostVsanInternalSystemVsanObjectOperationResult[]");
    }

    public void uploadClientCert(ManagedObjectReference _this, KeyProviderId cluster, String certificate, String privateKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cluster", "KeyProviderId", cluster);
        paras[2] = new Argument("certificate", "String", certificate);
        paras[3] = new Argument("privateKey", "String", privateKey);
        getWsc().invoke("UploadClientCert", paras, null);
    }

    public void uploadKmipServerCert(ManagedObjectReference _this, KeyProviderId cluster, String certificate) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cluster", "KeyProviderId", cluster);
        paras[2] = new Argument("certificate", "String", certificate);
        getWsc().invoke("UploadKmipServerCert", paras, null);
    }

    public void validateCredentialsInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        getWsc().invoke("ValidateCredentialsInGuest", paras, null);
    }

    public ClusterComputeResourceValidationResultBase[] validateHCIConfiguration(ManagedObjectReference _this, ClusterComputeResourceHCIConfigSpec hciConfigSpec, ManagedObjectReference[] hosts) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hciConfigSpec", "ClusterComputeResourceHCIConfigSpec", hciConfigSpec);
        paras[2] = new Argument("hosts", "ManagedObjectReference[]", hosts);
        return (ClusterComputeResourceValidationResultBase[]) getWsc().invoke("ValidateHCIConfiguration", paras, "ClusterComputeResourceValidationResultBase[]");
    }

    public OvfValidateHostResult validateHost(ManagedObjectReference _this, String ovfDescriptor, ManagedObjectReference host, OvfValidateHostParams vhp) throws java.rmi.RemoteException, ConcurrentAccess, FileFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ovfDescriptor", "String", ovfDescriptor);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        paras[3] = new Argument("vhp", "OvfValidateHostParams", vhp);
        return (OvfValidateHostResult) getWsc().invoke("ValidateHost", paras, "OvfValidateHostResult");
    }

    public ManagedObjectReference validateHostProfileComposition_Task(ManagedObjectReference _this, ManagedObjectReference source, ManagedObjectReference[] targets, HostApplyProfile toBeMerged, HostApplyProfile toReplaceWith, HostApplyProfile toBeDeleted, HostApplyProfile enableStatusToBeCopied, boolean errorOnly) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[8];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("source", "ManagedObjectReference", source);
        paras[2] = new Argument("targets", "ManagedObjectReference[]", targets);
        paras[3] = new Argument("toBeMerged", "HostApplyProfile", toBeMerged);
        paras[4] = new Argument("toReplaceWith", "HostApplyProfile", toReplaceWith);
        paras[5] = new Argument("toBeDeleted", "HostApplyProfile", toBeDeleted);
        paras[6] = new Argument("enableStatusToBeCopied", "HostApplyProfile", enableStatusToBeCopied);
        paras[7] = new Argument("errorOnly", "boolean", errorOnly);
        return (ManagedObjectReference) getWsc().invoke("ValidateHostProfileComposition_Task", paras, "ManagedObjectReference");
    }

    public Event[] validateMigration(ManagedObjectReference _this, ManagedObjectReference[] vm, VirtualMachinePowerState state, String[] testType, ManagedObjectReference pool, ManagedObjectReference host) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference[]", vm);
        paras[2] = new Argument("state", "VirtualMachinePowerState", state);
        paras[3] = new Argument("testType", "String[]", testType);
        paras[4] = new Argument("pool", "ManagedObjectReference", pool);
        paras[5] = new Argument("host", "ManagedObjectReference", host);
        return (Event[]) getWsc().invoke("ValidateMigration", paras, "Event[]");
    }

    public LocalizedMethodFault validateStoragePodConfig(ManagedObjectReference _this, ManagedObjectReference pod, StorageDrsConfigSpec spec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pod", "ManagedObjectReference", pod);
        paras[2] = new Argument("spec", "StorageDrsConfigSpec", spec);
        return (LocalizedMethodFault) getWsc().invoke("ValidateStoragePodConfig", paras, "LocalizedMethodFault");
    }

    public ManagedObjectReference vCenterUpdateVStorageObjectMetadataEx_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, KeyValue[] metadata, String[] deleteKeys) throws java.rmi.RemoteException, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("metadata", "KeyValue[]", metadata);
        paras[4] = new Argument("deleteKeys", "String[]", deleteKeys);
        return (ManagedObjectReference) getWsc().invoke("VCenterUpdateVStorageObjectMetadataEx_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference vStorageObjectCreateSnapshot_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, String description) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("description", "String", description);
        return (ManagedObjectReference) getWsc().invoke("VStorageObjectCreateSnapshot_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference vStorageObjectCreateSnapshotEx_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, String description) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("description", "String", description);
        return (ManagedObjectReference) getWsc().invoke("VStorageObjectCreateSnapshotEx_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference vStorageObjectDeleteSnapshotEx2_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, ID snapshotId) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("snapshotId", "ID", snapshotId);
        return (ManagedObjectReference) getWsc().invoke("VStorageObjectDeleteSnapshotEx2_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference vStorageObjectDeleteSnapshotEx_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, ID snapshotId) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("snapshotId", "ID", snapshotId);
        return (ManagedObjectReference) getWsc().invoke("VStorageObjectDeleteSnapshotEx_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference vStorageObjectExtendDiskEx_Task(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, long newCapacityInMB) throws java.rmi.RemoteException, FileFault, InvalidDatastore, InvalidState, NotFound, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("newCapacityInMB", "long", newCapacityInMB);
        return (ManagedObjectReference) getWsc().invoke("VStorageObjectExtendDiskEx_Task", paras, "ManagedObjectReference");
    }

    public DiskChangeInfo vstorageObjectVCenterQueryChangedDiskAreas(ManagedObjectReference _this, ID id, ManagedObjectReference datastore, ID snapshotId, long startOffset, String changeId) throws java.rmi.RemoteException, FileFault, InvalidArgument, InvalidDatastore, InvalidState, NotFound, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "ID", id);
        paras[2] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[3] = new Argument("snapshotId", "ID", snapshotId);
        paras[4] = new Argument("startOffset", "long", startOffset);
        paras[5] = new Argument("changeId", "String", changeId);
        return (DiskChangeInfo) getWsc().invoke("VstorageObjectVCenterQueryChangedDiskAreas", paras, "DiskChangeInfo");
    }

    public UpdateSet waitForUpdates(ManagedObjectReference _this, String version) throws java.rmi.RemoteException, InvalidCollectorVersion, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("version", "String", version);
        return (UpdateSet) getWsc().invoke("WaitForUpdates", paras, "UpdateSet");
    }

    public UpdateSet waitForUpdatesEx(ManagedObjectReference _this, String version, WaitOptions options) throws java.rmi.RemoteException, InvalidCollectorVersion, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("version", "String", version);
        paras[2] = new Argument("options", "WaitOptions", options);
        return (UpdateSet) getWsc().invoke("WaitForUpdatesEx", paras, "UpdateSet");
    }

    public CustomizationSpecItem xmlToCustomizationSpecItem(ManagedObjectReference _this, String specItemXml) throws java.rmi.RemoteException, CustomizationFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("specItemXml", "String", specItemXml);
        return (CustomizationSpecItem) getWsc().invoke("XmlToCustomizationSpecItem", paras, "CustomizationSpecItem");
    }

    public ManagedObjectReference zeroFillVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) getWsc().invoke("ZeroFillVirtualDisk_Task", paras, "ManagedObjectReference");
    }

}
