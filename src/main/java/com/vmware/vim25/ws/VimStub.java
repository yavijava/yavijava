/*================================================================================
Copyright (c) 2013 Steve Jin. All Rights Reserved.

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

package com.vmware.vim25.ws;

import com.vmware.vim25.*;
import org.apache.log4j.Logger;

import javax.net.ssl.TrustManager;
import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.lang.Object;

/**
 * @author Steve Jin (http://www.doublecloud.org)
 * @version 5.1
 */

public class VimStub {

    private Client wsc = null;
    /**
     * Setup logger
     */
    private static Logger log = Logger.getLogger(VimStub.class);

    public VimStub(String url, boolean ignoreCert) {
        try {
            this.wsc = ClientCreator.getClient(url, ignoreCert);
        }
        catch (NoSuchMethodException e) {
            log.error("Error detected for url: " + url + " ignoreSSL: " + ignoreCert, e);
        }
        catch (IllegalAccessException e) {
            log.error("Error detected for url: " + url + " ignoreSSL: " + ignoreCert, e);
        }
        catch (InvocationTargetException e) {
            log.error("Error detected for url: " + url + " ignoreSSL: " + ignoreCert, e);
        }
        catch (InstantiationException e) {
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

    public void destroyPropertyFilter(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DestroyPropertyFilter", paras, null);
    }

    public ManagedObjectReference createFilter(ManagedObjectReference _this, PropertyFilterSpec spec, boolean partialUpdates) throws java.rmi.RemoteException, InvalidProperty, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "PropertyFilterSpec", spec);
        paras[2] = new Argument("partialUpdates", "boolean", partialUpdates);
        return (ManagedObjectReference) getWsc().invoke("CreateFilter", paras, "ManagedObjectReference");
    }

    public ObjectContent[] retrieveProperties(ManagedObjectReference _this, PropertyFilterSpec[] specSet) throws java.rmi.RemoteException, InvalidProperty, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("specSet", "PropertyFilterSpec[]", specSet);
        return (ObjectContent[]) getWsc().invoke("RetrieveProperties", paras, "ObjectContent[]");
    }

    public UpdateSet checkForUpdates(ManagedObjectReference _this, String version) throws java.rmi.RemoteException, InvalidCollectorVersion, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("version", "String", version);
        return (UpdateSet) getWsc().invoke("CheckForUpdates", paras, "UpdateSet");
    }

    public UpdateSet waitForUpdates(ManagedObjectReference _this, String version) throws java.rmi.RemoteException, InvalidCollectorVersion, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("version", "String", version);
        return (UpdateSet) getWsc().invoke("WaitForUpdates", paras, "UpdateSet");
    }

    public void cancelWaitForUpdates(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("CancelWaitForUpdates", paras, null);
    }

    public UpdateSet waitForUpdatesEx(ManagedObjectReference _this, String version, WaitOptions options) throws java.rmi.RemoteException, InvalidCollectorVersion, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("version", "String", version);
        paras[2] = new Argument("options", "WaitOptions", options);
        return (UpdateSet) getWsc().invoke("WaitForUpdatesEx", paras, "UpdateSet");
    }

    public RetrieveResult retrievePropertiesEx(ManagedObjectReference _this, PropertyFilterSpec[] specSet, RetrieveOptions options) throws java.rmi.RemoteException, InvalidProperty, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("specSet", "PropertyFilterSpec[]", specSet);
        paras[2] = new Argument("options", "RetrieveOptions", options);
        return (RetrieveResult) getWsc().invoke("RetrievePropertiesEx", paras, "RetrieveResult");
    }

    public RetrieveResult continueRetrievePropertiesEx(ManagedObjectReference _this, String token) throws java.rmi.RemoteException, InvalidProperty, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("token", "String", token);
        return (RetrieveResult) getWsc().invoke("ContinueRetrievePropertiesEx", paras, "RetrieveResult");
    }

    public void cancelRetrievePropertiesEx(ManagedObjectReference _this, String token) throws java.rmi.RemoteException, InvalidProperty, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("token", "String", token);
        getWsc().invoke("CancelRetrievePropertiesEx", paras, null);
    }

    public ManagedObjectReference createPropertyCollector(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("CreatePropertyCollector", paras, "ManagedObjectReference");
    }

    public void destroyPropertyCollector(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DestroyPropertyCollector", paras, null);
    }

    public int addAuthorizationRole(ManagedObjectReference _this, String name, String[] privIds) throws java.rmi.RemoteException, AlreadyExists, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("privIds", "String[]", privIds);
        Integer ret = (Integer) getWsc().invoke("AddAuthorizationRole", paras, "int");
        return ret.intValue();
    }

    public void removeAuthorizationRole(ManagedObjectReference _this, int roleId, boolean failIfUsed) throws java.rmi.RemoteException, NotFound, RemoveFailed, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("roleId", "int", roleId);
        paras[2] = new Argument("failIfUsed", "boolean", failIfUsed);
        getWsc().invoke("RemoveAuthorizationRole", paras, null);
    }

    public void updateAuthorizationRole(ManagedObjectReference _this, int roleId, String newName, String[] privIds) throws java.rmi.RemoteException, NotFound, InvalidName, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("roleId", "int", roleId);
        paras[2] = new Argument("newName", "String", newName);
        paras[3] = new Argument("privIds", "String[]", privIds);
        getWsc().invoke("UpdateAuthorizationRole", paras, null);
    }

    public void mergePermissions(ManagedObjectReference _this, int srcRoleId, int dstRoleId) throws java.rmi.RemoteException, NotFound, AuthMinimumAdminPermission, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("srcRoleId", "int", srcRoleId);
        paras[2] = new Argument("dstRoleId", "int", dstRoleId);
        getWsc().invoke("MergePermissions", paras, null);
    }

    public Permission[] retrieveRolePermissions(ManagedObjectReference _this, int roleId) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("roleId", "int", roleId);
        return (Permission[]) getWsc().invoke("RetrieveRolePermissions", paras, "Permission[]");
    }

    public Permission[] retrieveEntityPermissions(ManagedObjectReference _this, ManagedObjectReference entity, boolean inherited) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("inherited", "boolean", inherited);
        return (Permission[]) getWsc().invoke("RetrieveEntityPermissions", paras, "Permission[]");
    }

    public Permission[] retrieveAllPermissions(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (Permission[]) getWsc().invoke("RetrieveAllPermissions", paras, "Permission[]");
    }

    public void setEntityPermissions(ManagedObjectReference _this, ManagedObjectReference entity, Permission[] permission) throws java.rmi.RemoteException, UserNotFound, NotFound, AuthMinimumAdminPermission, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("permission", "Permission[]", permission);
        getWsc().invoke("SetEntityPermissions", paras, null);
    }

    public void resetEntityPermissions(ManagedObjectReference _this, ManagedObjectReference entity, Permission[] permission) throws java.rmi.RemoteException, UserNotFound, NotFound, AuthMinimumAdminPermission, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("permission", "Permission[]", permission);
        getWsc().invoke("ResetEntityPermissions", paras, null);
    }

    public void removeEntityPermission(ManagedObjectReference _this, ManagedObjectReference entity, String user, boolean isGroup) throws java.rmi.RemoteException, NotFound, AuthMinimumAdminPermission, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("user", "String", user);
        paras[3] = new Argument("isGroup", "boolean", isGroup);
        getWsc().invoke("RemoveEntityPermission", paras, null);
    }

    public boolean[] hasPrivilegeOnEntity(ManagedObjectReference _this, ManagedObjectReference entity, String sessionId, String[] privId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("sessionId", "String", sessionId);
        paras[3] = new Argument("privId", "String[]", privId);
        return (boolean[]) getWsc().invoke("HasPrivilegeOnEntity", paras, "boolean[]");
    }

    public EntityPrivilege[] hasPrivilegeOnEntities(ManagedObjectReference _this, ManagedObjectReference[] entity, String sessionId, String[] privId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        paras[2] = new Argument("sessionId", "String", sessionId);
        paras[3] = new Argument("privId", "String[]", privId);
        return (EntityPrivilege[]) getWsc().invoke("HasPrivilegeOnEntities", paras, "EntityPrivilege[]");
    }

    public ManagedObjectReference reconfigureCluster_Task(ManagedObjectReference _this, ClusterConfigSpec spec, boolean modify) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "ClusterConfigSpec", spec);
        paras[2] = new Argument("modify", "boolean", modify);
        return (ManagedObjectReference) getWsc().invoke("ReconfigureCluster_Task", paras, "ManagedObjectReference");
    }

    public void applyRecommendation(ManagedObjectReference _this, String key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String", key);
        getWsc().invoke("ApplyRecommendation", paras, null);
    }

    public void cancelRecommendation(ManagedObjectReference _this, String key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String", key);
        getWsc().invoke("CancelRecommendation", paras, null);
    }

    public ClusterHostRecommendation[] recommendHostsForVm(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference pool) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("pool", "ManagedObjectReference", pool);
        return (ClusterHostRecommendation[]) getWsc().invoke("RecommendHostsForVm", paras, "ClusterHostRecommendation[]");
    }

    public ManagedObjectReference addHost_Task(ManagedObjectReference _this, HostConnectSpec spec, boolean asConnected, ManagedObjectReference resourcePool, String license) throws java.rmi.RemoteException, InvalidLogin, HostConnectFault, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostConnectSpec", spec);
        paras[2] = new Argument("asConnected", "boolean", asConnected);
        paras[3] = new Argument("resourcePool", "ManagedObjectReference", resourcePool);
        paras[4] = new Argument("license", "String", license);
        return (ManagedObjectReference) getWsc().invoke("AddHost_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference moveInto_Task(ManagedObjectReference _this, ManagedObjectReference[] host) throws java.rmi.RemoteException, DuplicateName, TooManyHosts, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference[]", host);
        return (ManagedObjectReference) getWsc().invoke("MoveInto_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference moveHostInto_Task(ManagedObjectReference _this, ManagedObjectReference host, ManagedObjectReference resourcePool) throws java.rmi.RemoteException, TooManyHosts, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("resourcePool", "ManagedObjectReference", resourcePool);
        return (ManagedObjectReference) getWsc().invoke("MoveHostInto_Task", paras, "ManagedObjectReference");
    }

    public void refreshRecommendation(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshRecommendation", paras, null);
    }

    public ClusterDasAdvancedRuntimeInfo retrieveDasAdvancedRuntimeInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ClusterDasAdvancedRuntimeInfo) getWsc().invoke("RetrieveDasAdvancedRuntimeInfo", paras, "ClusterDasAdvancedRuntimeInfo");
    }

    public ClusterEnterMaintenanceResult clusterEnterMaintenanceMode(ManagedObjectReference _this, ManagedObjectReference[] host, OptionValue[] option) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference[]", host);
        paras[2] = new Argument("option", "OptionValue[]", option);
        return (ClusterEnterMaintenanceResult) getWsc().invoke("ClusterEnterMaintenanceMode", paras, "ClusterEnterMaintenanceResult");
    }

    public ManagedObjectReference reconfigureComputeResource_Task(ManagedObjectReference _this, ComputeResourceConfigSpec spec, boolean modify) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "ComputeResourceConfigSpec", spec);
        paras[2] = new Argument("modify", "boolean", modify);
        return (ManagedObjectReference) getWsc().invoke("ReconfigureComputeResource_Task", paras, "ManagedObjectReference");
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

    public void removeCustomFieldDef(ManagedObjectReference _this, int key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "int", key);
        getWsc().invoke("RemoveCustomFieldDef", paras, null);
    }

    public void renameCustomFieldDef(ManagedObjectReference _this, int key, String name) throws java.rmi.RemoteException, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "int", key);
        paras[2] = new Argument("name", "String", name);
        getWsc().invoke("RenameCustomFieldDef", paras, null);
    }

    public void setField(ManagedObjectReference _this, ManagedObjectReference entity, int key, String value) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("key", "int", key);
        paras[3] = new Argument("value", "String", value);
        getWsc().invoke("SetField", paras, null);
    }

    public boolean doesCustomizationSpecExist(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        Boolean ret = (Boolean) getWsc().invoke("DoesCustomizationSpecExist", paras, "boolean");
        return ret.booleanValue();
    }

    public CustomizationSpecItem getCustomizationSpec(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (CustomizationSpecItem) getWsc().invoke("GetCustomizationSpec", paras, "CustomizationSpecItem");
    }

    public void createCustomizationSpec(ManagedObjectReference _this, CustomizationSpecItem item) throws java.rmi.RemoteException, CustomizationFault, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("item", "CustomizationSpecItem", item);
        getWsc().invoke("CreateCustomizationSpec", paras, null);
    }

    public void overwriteCustomizationSpec(ManagedObjectReference _this, CustomizationSpecItem item) throws java.rmi.RemoteException, CustomizationFault, NotFound, ConcurrentAccess, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("item", "CustomizationSpecItem", item);
        getWsc().invoke("OverwriteCustomizationSpec", paras, null);
    }

    public void deleteCustomizationSpec(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        getWsc().invoke("DeleteCustomizationSpec", paras, null);
    }

    public void duplicateCustomizationSpec(ManagedObjectReference _this, String name, String newName) throws java.rmi.RemoteException, NotFound, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("newName", "String", newName);
        getWsc().invoke("DuplicateCustomizationSpec", paras, null);
    }

    public void renameCustomizationSpec(ManagedObjectReference _this, String name, String newName) throws java.rmi.RemoteException, NotFound, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("newName", "String", newName);
        getWsc().invoke("RenameCustomizationSpec", paras, null);
    }

    public String customizationSpecItemToXml(ManagedObjectReference _this, CustomizationSpecItem item) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("item", "CustomizationSpecItem", item);
        return (String) getWsc().invoke("CustomizationSpecItemToXml", paras, "String");
    }

    public CustomizationSpecItem xmlToCustomizationSpecItem(ManagedObjectReference _this, String specItemXml) throws java.rmi.RemoteException, CustomizationFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("specItemXml", "String", specItemXml);
        return (CustomizationSpecItem) getWsc().invoke("XmlToCustomizationSpecItem", paras, "CustomizationSpecItem");
    }

    public void checkCustomizationResources(ManagedObjectReference _this, String guestOs) throws java.rmi.RemoteException, CustomizationFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("guestOs", "String", guestOs);
        getWsc().invoke("CheckCustomizationResources", paras, null);
    }

    public HostConnectInfo queryConnectionInfo(ManagedObjectReference _this, String hostname, int port, String username, String password, String sslThumbprint) throws java.rmi.RemoteException, InvalidLogin, HostConnectFault, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hostname", "String", hostname);
        paras[2] = new Argument("port", "int", port);
        paras[3] = new Argument("username", "String", username);
        paras[4] = new Argument("password", "String", password);
        paras[5] = new Argument("sslThumbprint", "String", sslThumbprint);
        return (HostConnectInfo) getWsc().invoke("QueryConnectionInfo", paras, "HostConnectInfo");
    }

    public ManagedObjectReference powerOnMultiVM_Task(ManagedObjectReference _this, ManagedObjectReference[] vm, OptionValue[] option) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference[]", vm);
        paras[2] = new Argument("option", "OptionValue[]", option);
        return (ManagedObjectReference) getWsc().invoke("PowerOnMultiVM_Task", paras, "ManagedObjectReference");
    }

    public VirtualMachineConfigOptionDescriptor[] queryDatacenterConfigOptionDescriptor(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VirtualMachineConfigOptionDescriptor[]) getWsc().invoke("queryDatacenterConfigOptionDescriptor", paras, "VirtualMachineConfigOptionDescriptor[]");
    }

    public ManagedObjectReference reconfigureDatacenter_Task(ManagedObjectReference _this, DatacenterConfigSpec spec, boolean modify) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DatacenterConfigSpec", spec);
        paras[2] = new Argument("modify", "boolean", modify);
        return (ManagedObjectReference) getWsc().invoke("ReconfigureDatacenter_Task", paras, "ManagedObjectReference");
    }

    public void refreshDatastore(ManagedObjectReference _this) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshDatastore", paras, null);
    }

    public void refreshDatastoreStorageInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshDatastoreStorageInfo", paras, null);
    }

    public ManagedObjectReference updateVirtualMachineFiles_Task(ManagedObjectReference _this, DatastoreMountPathDatastorePair[] mountPathDatastoreMapping) throws java.rmi.RemoteException, ResourceInUse, PlatformConfigFault, TaskInProgress, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("mountPathDatastoreMapping", "DatastoreMountPathDatastorePair[]", mountPathDatastoreMapping);
        return (ManagedObjectReference) getWsc().invoke("UpdateVirtualMachineFiles_Task", paras, "ManagedObjectReference");
    }

    public void renameDatastore(ManagedObjectReference _this, String newName) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("newName", "String", newName);
        getWsc().invoke("RenameDatastore", paras, null);
    }

    public void destroyDatastore(ManagedObjectReference _this) throws java.rmi.RemoteException, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DestroyDatastore", paras, null);
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

    public String createDirectory(ManagedObjectReference _this, ManagedObjectReference datastore, String displayName, String policy) throws java.rmi.RemoteException, CannotCreateFile, FileAlreadyExists, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("displayName", "String", displayName);
        paras[3] = new Argument("policy", "String", policy);
        return (String) getWsc().invoke("CreateDirectory", paras, "String");
    }

    public void deleteDirectory(ManagedObjectReference _this, ManagedObjectReference datacenter, String datastorePath) throws java.rmi.RemoteException, FileFault, FileNotFound, InvalidDatastore, InvalidDatastorePath, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("datastorePath", "String", datastorePath);
        getWsc().invoke("DeleteDirectory", paras, null);
    }

    public DiagnosticManagerLogDescriptor[] queryDescriptions(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (DiagnosticManagerLogDescriptor[]) getWsc().invoke("QueryDescriptions", paras, "DiagnosticManagerLogDescriptor[]");
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

    public ManagedObjectReference generateLogBundles_Task(ManagedObjectReference _this, boolean includeDefault, ManagedObjectReference[] host) throws java.rmi.RemoteException, LogBundlingFailed, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("includeDefault", "boolean", includeDefault);
        paras[2] = new Argument("host", "ManagedObjectReference[]", host);
        return (ManagedObjectReference) getWsc().invoke("GenerateLogBundles_Task", paras, "ManagedObjectReference");
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

    public int[] queryUsedVlanIdInDvs(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (int[]) getWsc().invoke("QueryUsedVlanIdInDvs", paras, "int[]");
    }

    public ManagedObjectReference reconfigureDvs_Task(ManagedObjectReference _this, DVSConfigSpec spec) throws java.rmi.RemoteException, DvsFault, ConcurrentAccess, DuplicateName, InvalidState, InvalidName, NotFound, AlreadyExists, LimitExceeded, ResourceInUse, ResourceNotAvailable, DvsNotAuthorized, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DVSConfigSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("ReconfigureDvs_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference performDvsProductSpecOperation_Task(ManagedObjectReference _this, String operation, DistributedVirtualSwitchProductSpec productSpec) throws java.rmi.RemoteException, TaskInProgress, InvalidState, DvsFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("operation", "String", operation);
        paras[2] = new Argument("productSpec", "DistributedVirtualSwitchProductSpec", productSpec);
        return (ManagedObjectReference) getWsc().invoke("PerformDvsProductSpecOperation_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference mergeDvs_Task(ManagedObjectReference _this, ManagedObjectReference dvs) throws java.rmi.RemoteException, DvsFault, NotFound, ResourceInUse, InvalidHostState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dvs", "ManagedObjectReference", dvs);
        return (ManagedObjectReference) getWsc().invoke("MergeDvs_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference addDVPortgroup_Task(ManagedObjectReference _this, DVPortgroupConfigSpec[] spec) throws java.rmi.RemoteException, DvsFault, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DVPortgroupConfigSpec[]", spec);
        return (ManagedObjectReference) getWsc().invoke("AddDVPortgroup_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference moveDVPort_Task(ManagedObjectReference _this, String[] portKey, String destinationPortgroupKey) throws java.rmi.RemoteException, DvsFault, NotFound, ConcurrentAccess, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portKey", "String[]", portKey);
        paras[2] = new Argument("destinationPortgroupKey", "String", destinationPortgroupKey);
        return (ManagedObjectReference) getWsc().invoke("MoveDVPort_Task", paras, "ManagedObjectReference");
    }

    public void updateDvsCapability(ManagedObjectReference _this, DVSCapability capability) throws java.rmi.RemoteException, DvsFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("capability", "DVSCapability", capability);
        getWsc().invoke("UpdateDvsCapability", paras, null);
    }

    public ManagedObjectReference reconfigureDVPort_Task(ManagedObjectReference _this, DVPortConfigSpec[] port) throws java.rmi.RemoteException, DvsFault, NotFound, ResourceInUse, ConcurrentAccess, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("port", "DVPortConfigSpec[]", port);
        return (ManagedObjectReference) getWsc().invoke("ReconfigureDVPort_Task", paras, "ManagedObjectReference");
    }

    public void refreshDVPortState(ManagedObjectReference _this, String[] portKeys) throws java.rmi.RemoteException, DvsFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portKeys", "String[]", portKeys);
        getWsc().invoke("RefreshDVPortState", paras, null);
    }

    public ManagedObjectReference rectifyDvsHost_Task(ManagedObjectReference _this, ManagedObjectReference[] hosts) throws java.rmi.RemoteException, DvsFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hosts", "ManagedObjectReference[]", hosts);
        return (ManagedObjectReference) getWsc().invoke("RectifyDvsHost_Task", paras, "ManagedObjectReference");
    }

    public void updateNetworkResourcePool(ManagedObjectReference _this, DVSNetworkResourcePoolConfigSpec[] configSpec) throws java.rmi.RemoteException, DvsFault, NotFound, InvalidName, ConcurrentAccess, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configSpec", "DVSNetworkResourcePoolConfigSpec[]", configSpec);
        getWsc().invoke("UpdateNetworkResourcePool", paras, null);
    }

    public void addNetworkResourcePool(ManagedObjectReference _this, DVSNetworkResourcePoolConfigSpec[] configSpec) throws java.rmi.RemoteException, DvsFault, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configSpec", "DVSNetworkResourcePoolConfigSpec[]", configSpec);
        getWsc().invoke("AddNetworkResourcePool", paras, null);
    }

    public void removeNetworkResourcePool(ManagedObjectReference _this, String[] key) throws java.rmi.RemoteException, DvsFault, NotFound, InvalidName, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String[]", key);
        getWsc().invoke("RemoveNetworkResourcePool", paras, null);
    }

    public void enableNetworkResourceManagement(ManagedObjectReference _this, boolean enable) throws java.rmi.RemoteException, DvsFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("enable", "boolean", enable);
        getWsc().invoke("EnableNetworkResourceManagement", paras, null);
    }

    public ManagedObjectReference dVSRollback_Task(ManagedObjectReference _this, EntityBackupConfig entityBackup) throws java.rmi.RemoteException, DvsFault, RollbackFailure, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entityBackup", "EntityBackupConfig", entityBackup);
        return (ManagedObjectReference) getWsc().invoke("DVSRollback_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createDVPortgroup_Task(ManagedObjectReference _this, DVPortgroupConfigSpec spec) throws java.rmi.RemoteException, DvsFault, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DVPortgroupConfigSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateDVPortgroup_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference updateDVSHealthCheckConfig_Task(ManagedObjectReference _this, DVSHealthCheckConfig[] healthCheckConfig) throws java.rmi.RemoteException, DvsFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("healthCheckConfig", "DVSHealthCheckConfig[]", healthCheckConfig);
        return (ManagedObjectReference) getWsc().invoke("UpdateDVSHealthCheckConfig_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference lookupDvPortGroup(ManagedObjectReference _this, String portgroupKey) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portgroupKey", "String", portgroupKey);
        return (ManagedObjectReference) getWsc().invoke("LookupDvPortGroup", paras, "ManagedObjectReference");
    }

    public VirtualMachineConfigOptionDescriptor[] queryConfigOptionDescriptor(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VirtualMachineConfigOptionDescriptor[]) getWsc().invoke("QueryConfigOptionDescriptor", paras, "VirtualMachineConfigOptionDescriptor[]");
    }

    public VirtualMachineConfigOption queryConfigOption(ManagedObjectReference _this, String key, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String", key);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (VirtualMachineConfigOption) getWsc().invoke("QueryConfigOption", paras, "VirtualMachineConfigOption");
    }

    public ConfigTarget queryConfigTarget(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (ConfigTarget) getWsc().invoke("QueryConfigTarget", paras, "ConfigTarget");
    }

    public HostCapability queryTargetCapabilities(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (HostCapability) getWsc().invoke("QueryTargetCapabilities", paras, "HostCapability");
    }

    public void setCustomValue(ManagedObjectReference _this, String key, String value) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String", key);
        paras[2] = new Argument("value", "String", value);
        getWsc().invoke("setCustomValue", paras, null);
    }

    public void unregisterExtension(ManagedObjectReference _this, String extensionKey) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        getWsc().invoke("UnregisterExtension", paras, null);
    }

    public Extension findExtension(ManagedObjectReference _this, String extensionKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        return (Extension) getWsc().invoke("FindExtension", paras, "Extension");
    }

    public void registerExtension(ManagedObjectReference _this, Extension extension) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extension", "Extension", extension);
        getWsc().invoke("RegisterExtension", paras, null);
    }

    public void updateExtension(ManagedObjectReference _this, Extension extension) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extension", "Extension", extension);
        getWsc().invoke("UpdateExtension", paras, null);
    }

    public String getPublicKey(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) getWsc().invoke("GetPublicKey", paras, "String");
    }

    public void setPublicKey(ManagedObjectReference _this, String extensionKey, String publicKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        paras[2] = new Argument("publicKey", "String", publicKey);
        getWsc().invoke("SetPublicKey", paras, null);
    }

    public void setExtensionCertificate(ManagedObjectReference _this, String extensionKey, String certificatePem) throws java.rmi.RemoteException, NotFound, NoClientCertificate, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        paras[2] = new Argument("certificatePem", "String", certificatePem);
        getWsc().invoke("SetExtensionCertificate", paras, null);
    }

    public ManagedObjectReference[] queryManagedBy(ManagedObjectReference _this, String extensionKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        return (ManagedObjectReference[]) getWsc().invoke("QueryManagedBy", paras, "ManagedObjectReference[]");
    }

    public ExtensionManagerIpAllocationUsage[] queryExtensionIpAllocationUsage(ManagedObjectReference _this, String[] extensionKeys) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKeys", "String[]", extensionKeys);
        return (ExtensionManagerIpAllocationUsage[]) getWsc().invoke("QueryExtensionIpAllocationUsage", paras, "ExtensionManagerIpAllocationUsage[]");
    }

    public ManagedObjectReference moveDatastoreFile_Task(ManagedObjectReference _this, String sourceName, ManagedObjectReference sourceDatacenter, String destinationName, ManagedObjectReference destinationDatacenter, Boolean force) throws java.rmi.RemoteException, InvalidDatastore, FileFault, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sourceName", "String", sourceName);
        paras[2] = new Argument("sourceDatacenter", "ManagedObjectReference", sourceDatacenter);
        paras[3] = new Argument("destinationName", "String", destinationName);
        paras[4] = new Argument("destinationDatacenter", "ManagedObjectReference", destinationDatacenter);
        paras[5] = new Argument("force", "Boolean", force);
        return (ManagedObjectReference) getWsc().invoke("MoveDatastoreFile_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference copyDatastoreFile_Task(ManagedObjectReference _this, String sourceName, ManagedObjectReference sourceDatacenter, String destinationName, ManagedObjectReference destinationDatacenter, Boolean force) throws java.rmi.RemoteException, InvalidDatastore, FileFault, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sourceName", "String", sourceName);
        paras[2] = new Argument("sourceDatacenter", "ManagedObjectReference", sourceDatacenter);
        paras[3] = new Argument("destinationName", "String", destinationName);
        paras[4] = new Argument("destinationDatacenter", "ManagedObjectReference", destinationDatacenter);
        paras[5] = new Argument("force", "Boolean", force);
        return (ManagedObjectReference) getWsc().invoke("CopyDatastoreFile_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference deleteDatastoreFile_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, InvalidDatastore, FileFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) getWsc().invoke("DeleteDatastoreFile_Task", paras, "ManagedObjectReference");
    }

    public void makeDirectory(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, Boolean createParentDirectories) throws java.rmi.RemoteException, InvalidDatastore, FileFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("createParentDirectories", "Boolean", createParentDirectories);
        getWsc().invoke("MakeDirectory", paras, null);
    }

    public void changeOwner(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, String owner) throws java.rmi.RemoteException, InvalidDatastore, FileFault, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("owner", "String", owner);
        getWsc().invoke("ChangeOwner", paras, null);
    }

    public ManagedObjectReference createFolder(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (ManagedObjectReference) getWsc().invoke("CreateFolder", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference moveIntoFolder_Task(ManagedObjectReference _this, ManagedObjectReference[] list) throws java.rmi.RemoteException, DuplicateName, InvalidFolder, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("list", "ManagedObjectReference[]", list);
        return (ManagedObjectReference) getWsc().invoke("MoveIntoFolder_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createVM_Task(ManagedObjectReference _this, VirtualMachineConfigSpec config, ManagedObjectReference pool, ManagedObjectReference host) throws java.rmi.RemoteException, VmConfigFault, FileFault, OutOfBounds, DuplicateName, InvalidName, InvalidDatastore, InsufficientResourcesFault, AlreadyExists, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "VirtualMachineConfigSpec", config);
        paras[2] = new Argument("pool", "ManagedObjectReference", pool);
        paras[3] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("CreateVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference registerVM_Task(ManagedObjectReference _this, String path, String name, boolean asTemplate, ManagedObjectReference pool, ManagedObjectReference host) throws java.rmi.RemoteException, OutOfBounds, DuplicateName, AlreadyExists, InvalidDatastore, NotFound, InvalidName, VmConfigFault, InsufficientResourcesFault, FileFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("path", "String", path);
        paras[2] = new Argument("name", "String", name);
        paras[3] = new Argument("asTemplate", "boolean", asTemplate);
        paras[4] = new Argument("pool", "ManagedObjectReference", pool);
        paras[5] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("RegisterVM_Task", paras, "ManagedObjectReference");
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

    public ManagedObjectReference addStandaloneHost_Task(ManagedObjectReference _this, HostConnectSpec spec, ComputeResourceConfigSpec compResSpec, boolean addConnected, String license) throws java.rmi.RemoteException, InvalidLogin, HostConnectFault, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostConnectSpec", spec);
        paras[2] = new Argument("compResSpec", "ComputeResourceConfigSpec", compResSpec);
        paras[3] = new Argument("addConnected", "boolean", addConnected);
        paras[4] = new Argument("license", "String", license);
        return (ManagedObjectReference) getWsc().invoke("AddStandaloneHost_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createDatacenter(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (ManagedObjectReference) getWsc().invoke("CreateDatacenter", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference unregisterAndDestroy_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, ConcurrentAccess, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("UnregisterAndDestroy_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createDVS_Task(ManagedObjectReference _this, DVSCreateSpec spec) throws java.rmi.RemoteException, DvsFault, DuplicateName, InvalidName, NotFound, DvsNotAuthorized, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DVSCreateSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateDVS_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createStoragePod(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (ManagedObjectReference) getWsc().invoke("CreateStoragePod", paras, "ManagedObjectReference");
    }

    public void setCollectorPageSize(ManagedObjectReference _this, int maxCount) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("maxCount", "int", maxCount);
        getWsc().invoke("SetCollectorPageSize", paras, null);
    }

    public void rewindCollector(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RewindCollector", paras, null);
    }

    public void resetCollector(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("ResetCollector", paras, null);
    }

    public void destroyCollector(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DestroyCollector", paras, null);
    }

    public HostTpmAttestationReport queryTpmAttestationReport(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostTpmAttestationReport) getWsc().invoke("QueryTpmAttestationReport", paras, "HostTpmAttestationReport");
    }

    public HostConnectInfo queryHostConnectionInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostConnectInfo) getWsc().invoke("QueryHostConnectionInfo", paras, "HostConnectInfo");
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

    public ManagedObjectReference reconnectHost_Task(ManagedObjectReference _this, HostConnectSpec cnxSpec, HostSystemReconnectSpec reconnectSpec) throws java.rmi.RemoteException, InvalidLogin, InvalidState, InvalidName, HostConnectFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cnxSpec", "HostConnectSpec", cnxSpec);
        paras[2] = new Argument("reconnectSpec", "HostSystemReconnectSpec", reconnectSpec);
        return (ManagedObjectReference) getWsc().invoke("ReconnectHost_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference disconnectHost_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("DisconnectHost_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference enterMaintenanceMode_Task(ManagedObjectReference _this, int timeout, Boolean evacuatePoweredOffVms, HostMaintenanceSpec maintenanceSpec) throws java.rmi.RemoteException, InvalidState, Timedout, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("timeout", "int", timeout);
        paras[2] = new Argument("evacuatePoweredOffVms", "Boolean", evacuatePoweredOffVms);
        paras[3] = new Argument("maintenanceSpec", "HostMaintenanceSpec", maintenanceSpec);
        return (ManagedObjectReference) getWsc().invoke("EnterMaintenanceMode_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference exitMaintenanceMode_Task(ManagedObjectReference _this, int timeout) throws java.rmi.RemoteException, InvalidState, Timedout, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("timeout", "int", timeout);
        return (ManagedObjectReference) getWsc().invoke("ExitMaintenanceMode_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference rebootHost_Task(ManagedObjectReference _this, boolean force) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("force", "boolean", force);
        return (ManagedObjectReference) getWsc().invoke("RebootHost_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference shutdownHost_Task(ManagedObjectReference _this, boolean force) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("force", "boolean", force);
        return (ManagedObjectReference) getWsc().invoke("ShutdownHost_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference powerDownHostToStandBy_Task(ManagedObjectReference _this, int timeoutSec, Boolean evacuatePoweredOffVms) throws java.rmi.RemoteException, HostPowerOpFailed, InvalidState, NotSupported, Timedout, RequestCanceled, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("timeoutSec", "int", timeoutSec);
        paras[2] = new Argument("evacuatePoweredOffVms", "Boolean", evacuatePoweredOffVms);
        return (ManagedObjectReference) getWsc().invoke("PowerDownHostToStandBy_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference powerUpHostFromStandBy_Task(ManagedObjectReference _this, int timeoutSec) throws java.rmi.RemoteException, HostPowerOpFailed, InvalidState, NotSupported, Timedout, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("timeoutSec", "int", timeoutSec);
        return (ManagedObjectReference) getWsc().invoke("PowerUpHostFromStandBy_Task", paras, "ManagedObjectReference");
    }

    public long queryMemoryOverhead(ManagedObjectReference _this, long memorySize, int videoRamSize, int numVcpus) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("memorySize", "long", memorySize);
        paras[2] = new Argument("videoRamSize", "int", videoRamSize);
        paras[3] = new Argument("numVcpus", "int", numVcpus);
        Long ret = (Long) getWsc().invoke("QueryMemoryOverhead", paras, "long");
        return ret.longValue();
    }

    public long queryMemoryOverheadEx(ManagedObjectReference _this, VirtualMachineConfigInfo vmConfigInfo) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmConfigInfo", "VirtualMachineConfigInfo", vmConfigInfo);
        Long ret = (Long) getWsc().invoke("QueryMemoryOverheadEx", paras, "long");
        return ret.longValue();
    }

    public ManagedObjectReference reconfigureHostForDAS_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, DasConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("ReconfigureHostForDAS_Task", paras, "ManagedObjectReference");
    }

    public void updateFlags(ManagedObjectReference _this, HostFlagInfo flagInfo) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("flagInfo", "HostFlagInfo", flagInfo);
        getWsc().invoke("UpdateFlags", paras, null);
    }

    public void enterLockdownMode(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("EnterLockdownMode", paras, null);
    }

    public void exitLockdownMode(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("ExitLockdownMode", paras, null);
    }

    public HostServiceTicket acquireCimServicesTicket(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostServiceTicket) getWsc().invoke("AcquireCimServicesTicket", paras, "HostServiceTicket");
    }

    public void updateIpmi(ManagedObjectReference _this, HostIpmiInfo ipmiInfo) throws java.rmi.RemoteException, InvalidIpmiLoginInfo, InvalidIpmiMacAddress, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ipmiInfo", "HostIpmiInfo", ipmiInfo);
        getWsc().invoke("UpdateIpmi", paras, null);
    }

    public long retrieveHardwareUptime(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        Long ret = (Long) getWsc().invoke("RetrieveHardwareUptime", paras, "long");
        return ret.longValue();
    }

    public HttpNfcLeaseManifestEntry[] httpNfcLeaseGetManifest(ManagedObjectReference _this) throws java.rmi.RemoteException, Timedout, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HttpNfcLeaseManifestEntry[]) getWsc().invoke("HttpNfcLeaseGetManifest", paras, "HttpNfcLeaseManifestEntry[]");
    }

    public void httpNfcLeaseComplete(ManagedObjectReference _this) throws java.rmi.RemoteException, Timedout, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("HttpNfcLeaseComplete", paras, null);
    }

    public void httpNfcLeaseAbort(ManagedObjectReference _this, LocalizedMethodFault fault) throws java.rmi.RemoteException, Timedout, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("fault", "LocalizedMethodFault", fault);
        getWsc().invoke("HttpNfcLeaseAbort", paras, null);
    }

    public void httpNfcLeaseProgress(ManagedObjectReference _this, int percent) throws java.rmi.RemoteException, Timedout, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("percent", "int", percent);
        getWsc().invoke("HttpNfcLeaseProgress", paras, null);
    }

    public IpPool[] queryIpPools(ManagedObjectReference _this, ManagedObjectReference dc) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        return (IpPool[]) getWsc().invoke("QueryIpPools", paras, "IpPool[]");
    }

    public int createIpPool(ManagedObjectReference _this, ManagedObjectReference dc, IpPool pool) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("pool", "IpPool", pool);
        Integer ret = (Integer) getWsc().invoke("CreateIpPool", paras, "int");
        return ret.intValue();
    }

    public void updateIpPool(ManagedObjectReference _this, ManagedObjectReference dc, IpPool pool) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("pool", "IpPool", pool);
        getWsc().invoke("UpdateIpPool", paras, null);
    }

    public void destroyIpPool(ManagedObjectReference _this, ManagedObjectReference dc, int id, boolean force) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("id", "int", id);
        paras[3] = new Argument("force", "boolean", force);
        getWsc().invoke("DestroyIpPool", paras, null);
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

    public void releaseIpAllocation(ManagedObjectReference _this, ManagedObjectReference dc, int poolId, String allocationId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("poolId", "int", poolId);
        paras[3] = new Argument("allocationId", "String", allocationId);
        getWsc().invoke("ReleaseIpAllocation", paras, null);
    }

    public IpPoolManagerIpAllocation[] queryIPAllocations(ManagedObjectReference _this, ManagedObjectReference dc, int poolId, String extensionKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("poolId", "int", poolId);
        paras[3] = new Argument("extensionKey", "String", extensionKey);
        return (IpPoolManagerIpAllocation[]) getWsc().invoke("QueryIPAllocations", paras, "IpPoolManagerIpAllocation[]");
    }

    public LicenseManagerLicenseInfo updateAssignedLicense(ManagedObjectReference _this, String entity, String licenseKey, String entityDisplayName) throws java.rmi.RemoteException, LicenseEntityNotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "String", entity);
        paras[2] = new Argument("licenseKey", "String", licenseKey);
        paras[3] = new Argument("entityDisplayName", "String", entityDisplayName);
        return (LicenseManagerLicenseInfo) getWsc().invoke("UpdateAssignedLicense", paras, "LicenseManagerLicenseInfo");
    }

    public void removeAssignedLicense(ManagedObjectReference _this, String entityId) throws java.rmi.RemoteException, LicenseEntityNotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entityId", "String", entityId);
        getWsc().invoke("RemoveAssignedLicense", paras, null);
    }

    public LicenseAssignmentManagerLicenseAssignment[] queryAssignedLicenses(ManagedObjectReference _this, String entityId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entityId", "String", entityId);
        return (LicenseAssignmentManagerLicenseAssignment[]) getWsc().invoke("QueryAssignedLicenses", paras, "LicenseAssignmentManagerLicenseAssignment[]");
    }

    public LicenseFeatureInfo[] querySupportedFeatures(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (LicenseFeatureInfo[]) getWsc().invoke("QuerySupportedFeatures", paras, "LicenseFeatureInfo[]");
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

    public void setLicenseEdition(ManagedObjectReference _this, ManagedObjectReference host, String featureKey) throws java.rmi.RemoteException, InvalidState, LicenseServerUnavailable, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("featureKey", "String", featureKey);
        getWsc().invoke("SetLicenseEdition", paras, null);
    }

    public boolean checkLicenseFeature(ManagedObjectReference _this, ManagedObjectReference host, String featureKey) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("featureKey", "String", featureKey);
        Boolean ret = (Boolean) getWsc().invoke("CheckLicenseFeature", paras, "boolean");
        return ret.booleanValue();
    }

    public boolean enableFeature(ManagedObjectReference _this, ManagedObjectReference host, String featureKey) throws java.rmi.RemoteException, InvalidState, LicenseServerUnavailable, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("featureKey", "String", featureKey);
        Boolean ret = (Boolean) getWsc().invoke("EnableFeature", paras, "boolean");
        return ret.booleanValue();
    }

    public boolean disableFeature(ManagedObjectReference _this, ManagedObjectReference host, String featureKey) throws java.rmi.RemoteException, InvalidState, LicenseServerUnavailable, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("featureKey", "String", featureKey);
        Boolean ret = (Boolean) getWsc().invoke("DisableFeature", paras, "boolean");
        return ret.booleanValue();
    }

    public void configureLicenseSource(ManagedObjectReference _this, ManagedObjectReference host, LicenseSource licenseSource) throws java.rmi.RemoteException, CannotAccessLocalSource, InvalidLicense, LicenseServerUnavailable, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("licenseSource", "LicenseSource", licenseSource);
        getWsc().invoke("ConfigureLicenseSource", paras, null);
    }

    public LicenseManagerLicenseInfo updateLicense(ManagedObjectReference _this, String licenseKey, KeyValue[] labels) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        paras[2] = new Argument("labels", "KeyValue[]", labels);
        return (LicenseManagerLicenseInfo) getWsc().invoke("UpdateLicense", paras, "LicenseManagerLicenseInfo");
    }

    public LicenseManagerLicenseInfo addLicense(ManagedObjectReference _this, String licenseKey, KeyValue[] labels) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        paras[2] = new Argument("labels", "KeyValue[]", labels);
        return (LicenseManagerLicenseInfo) getWsc().invoke("AddLicense", paras, "LicenseManagerLicenseInfo");
    }

    public void removeLicense(ManagedObjectReference _this, String licenseKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        getWsc().invoke("RemoveLicense", paras, null);
    }

    public LicenseManagerLicenseInfo decodeLicense(ManagedObjectReference _this, String licenseKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        return (LicenseManagerLicenseInfo) getWsc().invoke("DecodeLicense", paras, "LicenseManagerLicenseInfo");
    }

    public void updateLicenseLabel(ManagedObjectReference _this, String licenseKey, String labelKey, String labelValue) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        paras[2] = new Argument("labelKey", "String", labelKey);
        paras[3] = new Argument("labelValue", "String", labelValue);
        getWsc().invoke("UpdateLicenseLabel", paras, null);
    }

    public void removeLicenseLabel(ManagedObjectReference _this, String licenseKey, String labelKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        paras[2] = new Argument("labelKey", "String", labelKey);
        getWsc().invoke("RemoveLicenseLabel", paras, null);
    }

    public void reload(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("Reload", paras, null);
    }

    public ManagedObjectReference rename_Task(ManagedObjectReference _this, String newName) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("newName", "String", newName);
        return (ManagedObjectReference) getWsc().invoke("Rename_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference destroy_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, VimFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("Destroy_Task", paras, "ManagedObjectReference");
    }

    public void destroyNetwork(ManagedObjectReference _this) throws java.rmi.RemoteException, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DestroyNetwork", paras, null);
    }

    public OvfValidateHostResult validateHost(ManagedObjectReference _this, String ovfDescriptor, ManagedObjectReference host, OvfValidateHostParams vhp) throws java.rmi.RemoteException, TaskInProgress, ConcurrentAccess, FileFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ovfDescriptor", "String", ovfDescriptor);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        paras[3] = new Argument("vhp", "OvfValidateHostParams", vhp);
        return (OvfValidateHostResult) getWsc().invoke("ValidateHost", paras, "OvfValidateHostResult");
    }

    public OvfParseDescriptorResult parseDescriptor(ManagedObjectReference _this, String ovfDescriptor, OvfParseDescriptorParams pdp) throws java.rmi.RemoteException, TaskInProgress, VmConfigFault, ConcurrentAccess, FileFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ovfDescriptor", "String", ovfDescriptor);
        paras[2] = new Argument("pdp", "OvfParseDescriptorParams", pdp);
        return (OvfParseDescriptorResult) getWsc().invoke("ParseDescriptor", paras, "OvfParseDescriptorResult");
    }

    public OvfCreateImportSpecResult createImportSpec(ManagedObjectReference _this, String ovfDescriptor, ManagedObjectReference resourcePool, ManagedObjectReference datastore, OvfCreateImportSpecParams cisp) throws java.rmi.RemoteException, TaskInProgress, VmConfigFault, ConcurrentAccess, FileFault, InvalidState, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ovfDescriptor", "String", ovfDescriptor);
        paras[2] = new Argument("resourcePool", "ManagedObjectReference", resourcePool);
        paras[3] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[4] = new Argument("cisp", "OvfCreateImportSpecParams", cisp);
        return (OvfCreateImportSpecResult) getWsc().invoke("CreateImportSpec", paras, "OvfCreateImportSpecResult");
    }

    public OvfCreateDescriptorResult createDescriptor(ManagedObjectReference _this, ManagedObjectReference obj, OvfCreateDescriptorParams cdp) throws java.rmi.RemoteException, TaskInProgress, VmConfigFault, ConcurrentAccess, FileFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("obj", "ManagedObjectReference", obj);
        paras[2] = new Argument("cdp", "OvfCreateDescriptorParams", cdp);
        return (OvfCreateDescriptorResult) getWsc().invoke("CreateDescriptor", paras, "OvfCreateDescriptorResult");
    }

    public PerfProviderSummary queryPerfProviderSummary(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        return (PerfProviderSummary) getWsc().invoke("QueryPerfProviderSummary", paras, "PerfProviderSummary");
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

    public void createPerfInterval(ManagedObjectReference _this, PerfInterval intervalId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("intervalId", "PerfInterval", intervalId);
        getWsc().invoke("CreatePerfInterval", paras, null);
    }

    public void removePerfInterval(ManagedObjectReference _this, int samplePeriod) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("samplePeriod", "int", samplePeriod);
        getWsc().invoke("RemovePerfInterval", paras, null);
    }

    public void updatePerfInterval(ManagedObjectReference _this, PerfInterval interval) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("interval", "PerfInterval", interval);
        getWsc().invoke("UpdatePerfInterval", paras, null);
    }

    public void updateCounterLevelMapping(ManagedObjectReference _this, PerformanceManagerCounterLevelMapping[] counterLevelMap) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("counterLevelMap", "PerformanceManagerCounterLevelMapping[]", counterLevelMap);
        getWsc().invoke("UpdateCounterLevelMapping", paras, null);
    }

    public void resetCounterLevelMapping(ManagedObjectReference _this, int[] counters) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("counters", "int[]", counters);
        getWsc().invoke("ResetCounterLevelMapping", paras, null);
    }

    public DatabaseSizeEstimate estimateDatabaseSize(ManagedObjectReference _this, DatabaseSizeParam dbSizeParam) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dbSizeParam", "DatabaseSizeParam", dbSizeParam);
        return (DatabaseSizeEstimate) getWsc().invoke("EstimateDatabaseSize", paras, "DatabaseSizeEstimate");
    }

    public void updateConfig(ManagedObjectReference _this, String name, ResourceConfigSpec config) throws java.rmi.RemoteException, InvalidName, DuplicateName, InsufficientResourcesFault, ConcurrentAccess, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("config", "ResourceConfigSpec", config);
        getWsc().invoke("UpdateConfig", paras, null);
    }

    public void moveIntoResourcePool(ManagedObjectReference _this, ManagedObjectReference[] list) throws java.rmi.RemoteException, DuplicateName, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("list", "ManagedObjectReference[]", list);
        getWsc().invoke("MoveIntoResourcePool", paras, null);
    }

    public void updateChildResourceConfiguration(ManagedObjectReference _this, ResourceConfigSpec[] spec) throws java.rmi.RemoteException, InvalidState, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "ResourceConfigSpec[]", spec);
        getWsc().invoke("UpdateChildResourceConfiguration", paras, null);
    }

    public ManagedObjectReference createResourcePool(ManagedObjectReference _this, String name, ResourceConfigSpec spec) throws java.rmi.RemoteException, InvalidName, DuplicateName, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("spec", "ResourceConfigSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateResourcePool", paras, "ManagedObjectReference");
    }

    public void destroyChildren(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DestroyChildren", paras, null);
    }

    public ManagedObjectReference createVApp(ManagedObjectReference _this, String name, ResourceConfigSpec resSpec, VAppConfigSpec configSpec, ManagedObjectReference vmFolder) throws java.rmi.RemoteException, InvalidName, DuplicateName, InsufficientResourcesFault, InvalidState, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("resSpec", "ResourceConfigSpec", resSpec);
        paras[3] = new Argument("configSpec", "VAppConfigSpec", configSpec);
        paras[4] = new Argument("vmFolder", "ManagedObjectReference", vmFolder);
        return (ManagedObjectReference) getWsc().invoke("CreateVApp", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createChildVM_Task(ManagedObjectReference _this, VirtualMachineConfigSpec config, ManagedObjectReference host) throws java.rmi.RemoteException, VmConfigFault, FileFault, OutOfBounds, InvalidName, InvalidDatastore, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "VirtualMachineConfigSpec", config);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("CreateChildVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference registerChildVM_Task(ManagedObjectReference _this, String path, String name, ManagedObjectReference host) throws java.rmi.RemoteException, OutOfBounds, AlreadyExists, InvalidDatastore, NotFound, InvalidName, VmConfigFault, InsufficientResourcesFault, FileFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("path", "String", path);
        paras[2] = new Argument("name", "String", name);
        paras[3] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("RegisterChildVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference importVApp(ManagedObjectReference _this, ImportSpec spec, ManagedObjectReference folder, ManagedObjectReference host) throws java.rmi.RemoteException, VmConfigFault, FileFault, OutOfBounds, DuplicateName, InvalidName, InvalidDatastore, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "ImportSpec", spec);
        paras[2] = new Argument("folder", "ManagedObjectReference", folder);
        paras[3] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("ImportVApp", paras, "ManagedObjectReference");
    }

    public ResourceConfigOption queryResourceConfigOption(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ResourceConfigOption) getWsc().invoke("QueryResourceConfigOption", paras, "ResourceConfigOption");
    }

    public void refreshRuntime(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshRuntime", paras, null);
    }

    public ManagedObjectReference findByUuid(ManagedObjectReference _this, ManagedObjectReference datacenter, String uuid, boolean vmSearch, Boolean instanceUuid) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("uuid", "String", uuid);
        paras[3] = new Argument("vmSearch", "boolean", vmSearch);
        paras[4] = new Argument("instanceUuid", "Boolean", instanceUuid);
        return (ManagedObjectReference) getWsc().invoke("FindByUuid", paras, "ManagedObjectReference");
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

    public ManagedObjectReference findByIp(ManagedObjectReference _this, ManagedObjectReference datacenter, String ip, boolean vmSearch) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("ip", "String", ip);
        paras[3] = new Argument("vmSearch", "boolean", vmSearch);
        return (ManagedObjectReference) getWsc().invoke("FindByIp", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference findByInventoryPath(ManagedObjectReference _this, String inventoryPath) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("inventoryPath", "String", inventoryPath);
        return (ManagedObjectReference) getWsc().invoke("FindByInventoryPath", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference findChild(ManagedObjectReference _this, ManagedObjectReference entity, String name) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("name", "String", name);
        return (ManagedObjectReference) getWsc().invoke("FindChild", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference[] findAllByUuid(ManagedObjectReference _this, ManagedObjectReference datacenter, String uuid, boolean vmSearch, Boolean instanceUuid) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("uuid", "String", uuid);
        paras[3] = new Argument("vmSearch", "boolean", vmSearch);
        paras[4] = new Argument("instanceUuid", "Boolean", instanceUuid);
        return (ManagedObjectReference[]) getWsc().invoke("FindAllByUuid", paras, "ManagedObjectReference[]");
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

    public Calendar currentTime(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (Calendar) getWsc().invoke("CurrentTime", paras, "Calendar");
    }

    public ServiceContent retrieveServiceContent(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ServiceContent) getWsc().invoke("RetrieveServiceContent", paras, "ServiceContent");
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

    public HostVMotionCompatibility[] queryVMotionCompatibility(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference[] host, String[] compatibility) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("host", "ManagedObjectReference[]", host);
        paras[3] = new Argument("compatibility", "String[]", compatibility);
        return (HostVMotionCompatibility[]) getWsc().invoke("QueryVMotionCompatibility", paras, "HostVMotionCompatibility[]");
    }

    public ProductComponentInfo[] retrieveProductComponents(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ProductComponentInfo[]) getWsc().invoke("RetrieveProductComponents", paras, "ProductComponentInfo[]");
    }

    public ServiceManagerServiceInfo[] queryServiceList(ManagedObjectReference _this, String serviceName, String[] location) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("serviceName", "String", serviceName);
        paras[2] = new Argument("location", "String[]", location);
        return (ServiceManagerServiceInfo[]) getWsc().invoke("QueryServiceList", paras, "ServiceManagerServiceInfo[]");
    }

    public void updateServiceMessage(ManagedObjectReference _this, String message) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("message", "String", message);
        getWsc().invoke("UpdateServiceMessage", paras, null);
    }

    public UserSession loginByToken(ManagedObjectReference _this, String locale) throws java.rmi.RemoteException, InvalidLogin, InvalidLocale, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("locale", "String", locale);
        return (UserSession) getWsc().invoke("LoginByToken", paras, "UserSession");
    }

    public UserSession login(ManagedObjectReference _this, String userName, String password, String locale) throws java.rmi.RemoteException, InvalidLogin, InvalidLocale, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("userName", "String", userName);
        paras[2] = new Argument("password", "String", password);
        paras[3] = new Argument("locale", "String", locale);
        return (UserSession) getWsc().invoke("Login", paras, "UserSession");
    }

    public UserSession loginBySSPI(ManagedObjectReference _this, String base64Token, String locale) throws java.rmi.RemoteException, SSPIChallenge, InvalidLogin, InvalidLocale, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("base64Token", "String", base64Token);
        paras[2] = new Argument("locale", "String", locale);
        return (UserSession) getWsc().invoke("LoginBySSPI", paras, "UserSession");
    }

    public void logout(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("Logout", paras, null);
    }

    public SessionManagerLocalTicket acquireLocalTicket(ManagedObjectReference _this, String userName) throws java.rmi.RemoteException, InvalidLogin, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("userName", "String", userName);
        return (SessionManagerLocalTicket) getWsc().invoke("AcquireLocalTicket", paras, "SessionManagerLocalTicket");
    }

    public SessionManagerGenericServiceTicket acquireGenericServiceTicket(ManagedObjectReference _this, SessionManagerServiceRequestSpec spec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "SessionManagerServiceRequestSpec", spec);
        return (SessionManagerGenericServiceTicket) getWsc().invoke("AcquireGenericServiceTicket", paras, "SessionManagerGenericServiceTicket");
    }

    public void terminateSession(ManagedObjectReference _this, String[] sessionId) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sessionId", "String[]", sessionId);
        getWsc().invoke("TerminateSession", paras, null);
    }

    public void setLocale(ManagedObjectReference _this, String locale) throws java.rmi.RemoteException, InvalidLocale, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("locale", "String", locale);
        getWsc().invoke("SetLocale", paras, null);
    }

    public UserSession loginExtensionBySubjectName(ManagedObjectReference _this, String extensionKey, String locale) throws java.rmi.RemoteException, InvalidLogin, InvalidLocale, NotFound, NoClientCertificate, NoSubjectName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        paras[2] = new Argument("locale", "String", locale);
        return (UserSession) getWsc().invoke("LoginExtensionBySubjectName", paras, "UserSession");
    }

    public UserSession loginExtensionByCertificate(ManagedObjectReference _this, String extensionKey, String locale) throws java.rmi.RemoteException, InvalidLogin, InvalidLocale, NoClientCertificate, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        paras[2] = new Argument("locale", "String", locale);
        return (UserSession) getWsc().invoke("LoginExtensionByCertificate", paras, "UserSession");
    }

    public UserSession impersonateUser(ManagedObjectReference _this, String userName, String locale) throws java.rmi.RemoteException, InvalidLogin, InvalidLocale, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("userName", "String", userName);
        paras[2] = new Argument("locale", "String", locale);
        return (UserSession) getWsc().invoke("ImpersonateUser", paras, "UserSession");
    }

    public boolean sessionIsActive(ManagedObjectReference _this, String sessionID, String userName) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sessionID", "String", sessionID);
        paras[2] = new Argument("userName", "String", userName);
        Boolean ret = (Boolean) getWsc().invoke("SessionIsActive", paras, "boolean");
        return ret.booleanValue();
    }

    public String acquireCloneTicket(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) getWsc().invoke("AcquireCloneTicket", paras, "String");
    }

    public UserSession cloneSession(ManagedObjectReference _this, String cloneTicket) throws java.rmi.RemoteException, InvalidLogin, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cloneTicket", "String", cloneTicket);
        return (UserSession) getWsc().invoke("CloneSession", paras, "UserSession");
    }

    public String executeSimpleCommand(ManagedObjectReference _this, String[] arguments) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("arguments", "String[]", arguments);
        return (String) getWsc().invoke("ExecuteSimpleCommand", paras, "String");
    }

    public ManagedObjectReference configureDatastoreIORM_Task(ManagedObjectReference _this, ManagedObjectReference datastore, StorageIORMConfigSpec spec) throws java.rmi.RemoteException, IORMNotSupportedHostOnDatastore, InaccessibleDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("spec", "StorageIORMConfigSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("ConfigureDatastoreIORM_Task", paras, "ManagedObjectReference");
    }

    public StorageIORMConfigOption queryIORMConfigOption(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (StorageIORMConfigOption) getWsc().invoke("QueryIORMConfigOption", paras, "StorageIORMConfigOption");
    }

    public StoragePerformanceSummary[] queryDatastorePerformanceSummary(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (StoragePerformanceSummary[]) getWsc().invoke("QueryDatastorePerformanceSummary", paras, "StoragePerformanceSummary[]");
    }

    public ManagedObjectReference applyStorageDrsRecommendationToPod_Task(ManagedObjectReference _this, ManagedObjectReference pod, String key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pod", "ManagedObjectReference", pod);
        paras[2] = new Argument("key", "String", key);
        return (ManagedObjectReference) getWsc().invoke("ApplyStorageDrsRecommendationToPod_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference applyStorageDrsRecommendation_Task(ManagedObjectReference _this, String[] key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String[]", key);
        return (ManagedObjectReference) getWsc().invoke("ApplyStorageDrsRecommendation_Task", paras, "ManagedObjectReference");
    }

    public void cancelStorageDrsRecommendation(ManagedObjectReference _this, String[] key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String[]", key);
        getWsc().invoke("CancelStorageDrsRecommendation", paras, null);
    }

    public void refreshStorageDrsRecommendation(ManagedObjectReference _this, ManagedObjectReference pod) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pod", "ManagedObjectReference", pod);
        getWsc().invoke("RefreshStorageDrsRecommendation", paras, null);
    }

    public ManagedObjectReference configureStorageDrsForPod_Task(ManagedObjectReference _this, ManagedObjectReference pod, StorageDrsConfigSpec spec, boolean modify) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pod", "ManagedObjectReference", pod);
        paras[2] = new Argument("spec", "StorageDrsConfigSpec", spec);
        paras[3] = new Argument("modify", "boolean", modify);
        return (ManagedObjectReference) getWsc().invoke("ConfigureStorageDrsForPod_Task", paras, "ManagedObjectReference");
    }

    public StoragePlacementResult recommendDatastores(ManagedObjectReference _this, StoragePlacementSpec storageSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("storageSpec", "StoragePlacementSpec", storageSpec);
        return (StoragePlacementResult) getWsc().invoke("RecommendDatastores", paras, "StoragePlacementResult");
    }

    public void cancelTask(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("CancelTask", paras, null);
    }

    public void updateProgress(ManagedObjectReference _this, int percentDone) throws java.rmi.RemoteException, InvalidState, OutOfBounds, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("percentDone", "int", percentDone);
        getWsc().invoke("UpdateProgress", paras, null);
    }

    public void setTaskState(ManagedObjectReference _this, TaskInfoState state, Object result, LocalizedMethodFault fault) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("state", "TaskInfoState", state);
        paras[2] = new Argument("result", "Object", result);
        paras[3] = new Argument("fault", "LocalizedMethodFault", fault);
        getWsc().invoke("SetTaskState", paras, null);
    }

    public void setTaskDescription(ManagedObjectReference _this, LocalizableMessage description) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("description", "LocalizableMessage", description);
        getWsc().invoke("SetTaskDescription", paras, null);
    }

    public TaskInfo[] readNextTasks(ManagedObjectReference _this, int maxCount) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("maxCount", "int", maxCount);
        return (TaskInfo[]) getWsc().invoke("ReadNextTasks", paras, "TaskInfo[]");
    }

    public TaskInfo[] readPreviousTasks(ManagedObjectReference _this, int maxCount) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("maxCount", "int", maxCount);
        return (TaskInfo[]) getWsc().invoke("ReadPreviousTasks", paras, "TaskInfo[]");
    }

    public ManagedObjectReference createCollectorForTasks(ManagedObjectReference _this, TaskFilterSpec filter) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filter", "TaskFilterSpec", filter);
        return (ManagedObjectReference) getWsc().invoke("CreateCollectorForTasks", paras, "ManagedObjectReference");
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

    public void updateVAppConfig(ManagedObjectReference _this, VAppConfigSpec spec) throws java.rmi.RemoteException, TaskInProgress, VmConfigFault, ConcurrentAccess, FileFault, InvalidName, DuplicateName, InvalidState, InsufficientResourcesFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VAppConfigSpec", spec);
        getWsc().invoke("UpdateVAppConfig", paras, null);
    }

    public void updateLinkedChildren(ManagedObjectReference _this, VirtualAppLinkInfo[] addChangeSet, ManagedObjectReference[] removeSet) throws java.rmi.RemoteException, ConcurrentAccess, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("addChangeSet", "VirtualAppLinkInfo[]", addChangeSet);
        paras[2] = new Argument("removeSet", "ManagedObjectReference[]", removeSet);
        getWsc().invoke("UpdateLinkedChildren", paras, null);
    }

    public ManagedObjectReference cloneVApp_Task(ManagedObjectReference _this, String name, ManagedObjectReference target, VAppCloneSpec spec) throws java.rmi.RemoteException, InvalidState, InvalidDatastore, TaskInProgress, VmConfigFault, FileFault, MigrationFault, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("target", "ManagedObjectReference", target);
        paras[3] = new Argument("spec", "VAppCloneSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CloneVApp_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference exportVApp(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidPowerState, TaskInProgress, InvalidState, FileFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("ExportVApp", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference powerOnVApp_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidState, InsufficientResourcesFault, VmConfigFault, VAppConfigFault, FileFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("PowerOnVApp_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference powerOffVApp_Task(ManagedObjectReference _this, boolean force) throws java.rmi.RemoteException, TaskInProgress, InvalidState, VAppConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("force", "boolean", force);
        return (ManagedObjectReference) getWsc().invoke("PowerOffVApp_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference suspendVApp_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidState, VAppConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("SuspendVApp_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference unregisterVApp_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, ConcurrentAccess, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("unregisterVApp_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, VirtualDiskSpec spec) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("spec", "VirtualDiskSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference deleteVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) getWsc().invoke("DeleteVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference moveVirtualDisk_Task(ManagedObjectReference _this, String sourceName, ManagedObjectReference sourceDatacenter, String destName, ManagedObjectReference destDatacenter, Boolean force, VirtualMachineProfileSpec[] profile) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[7];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sourceName", "String", sourceName);
        paras[2] = new Argument("sourceDatacenter", "ManagedObjectReference", sourceDatacenter);
        paras[3] = new Argument("destName", "String", destName);
        paras[4] = new Argument("destDatacenter", "ManagedObjectReference", destDatacenter);
        paras[5] = new Argument("force", "Boolean", force);
        paras[6] = new Argument("profile", "VirtualMachineProfileSpec[]", profile);
        return (ManagedObjectReference) getWsc().invoke("MoveVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference copyVirtualDisk_Task(ManagedObjectReference _this, String sourceName, ManagedObjectReference sourceDatacenter, String destName, ManagedObjectReference destDatacenter, VirtualDiskSpec destSpec, Boolean force) throws java.rmi.RemoteException, FileFault, InvalidDiskFormat, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[7];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sourceName", "String", sourceName);
        paras[2] = new Argument("sourceDatacenter", "ManagedObjectReference", sourceDatacenter);
        paras[3] = new Argument("destName", "String", destName);
        paras[4] = new Argument("destDatacenter", "ManagedObjectReference", destDatacenter);
        paras[5] = new Argument("destSpec", "VirtualDiskSpec", destSpec);
        paras[6] = new Argument("force", "Boolean", force);
        return (ManagedObjectReference) getWsc().invoke("CopyVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference extendVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, long newCapacityKb, Boolean eagerZero) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("newCapacityKb", "long", newCapacityKb);
        paras[4] = new Argument("eagerZero", "Boolean", eagerZero);
        return (ManagedObjectReference) getWsc().invoke("ExtendVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public int queryVirtualDiskFragmentation(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        Integer ret = (Integer) getWsc().invoke("QueryVirtualDiskFragmentation", paras, "int");
        return ret.intValue();
    }

    public ManagedObjectReference defragmentVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) getWsc().invoke("DefragmentVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference shrinkVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, Boolean copy) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("copy", "Boolean", copy);
        return (ManagedObjectReference) getWsc().invoke("ShrinkVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference inflateVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) getWsc().invoke("InflateVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference eagerZeroVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) getWsc().invoke("EagerZeroVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference zeroFillVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) getWsc().invoke("ZeroFillVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public void setVirtualDiskUuid(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, String uuid) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("uuid", "String", uuid);
        getWsc().invoke("SetVirtualDiskUuid", paras, null);
    }

    public String queryVirtualDiskUuid(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (String) getWsc().invoke("QueryVirtualDiskUuid", paras, "String");
    }

    public HostDiskDimensionsChs queryVirtualDiskGeometry(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (HostDiskDimensionsChs) getWsc().invoke("QueryVirtualDiskGeometry", paras, "HostDiskDimensionsChs");
    }

    public void refreshStorageInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshStorageInfo", paras, null);
    }

    public ManagedObjectReference createSnapshot_Task(ManagedObjectReference _this, String name, String description, boolean memory, boolean quiesce) throws java.rmi.RemoteException, TaskInProgress, SnapshotFault, VmConfigFault, FileFault, InvalidName, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("description", "String", description);
        paras[3] = new Argument("memory", "boolean", memory);
        paras[4] = new Argument("quiesce", "boolean", quiesce);
        return (ManagedObjectReference) getWsc().invoke("CreateSnapshot_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference revertToCurrentSnapshot_Task(ManagedObjectReference _this, ManagedObjectReference host, Boolean suppressPowerOn) throws java.rmi.RemoteException, TaskInProgress, SnapshotFault, InsufficientResourcesFault, InvalidState, VmConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("suppressPowerOn", "Boolean", suppressPowerOn);
        return (ManagedObjectReference) getWsc().invoke("RevertToCurrentSnapshot_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference removeAllSnapshots_Task(ManagedObjectReference _this, Boolean consolidate) throws java.rmi.RemoteException, TaskInProgress, InvalidState, SnapshotFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("consolidate", "Boolean", consolidate);
        return (ManagedObjectReference) getWsc().invoke("RemoveAllSnapshots_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference consolidateVMDisks_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidState, FileFault, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("ConsolidateVMDisks_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference estimateStorageForConsolidateSnapshots_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidState, FileFault, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("EstimateStorageForConsolidateSnapshots_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference reconfigVM_Task(ManagedObjectReference _this, VirtualMachineConfigSpec spec) throws java.rmi.RemoteException, TaskInProgress, VmConfigFault, ConcurrentAccess, FileFault, InvalidName, DuplicateName, InvalidState, InsufficientResourcesFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VirtualMachineConfigSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("ReconfigVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference upgradeVM_Task(ManagedObjectReference _this, String version) throws java.rmi.RemoteException, InvalidState, TaskInProgress, AlreadyUpgraded, NoDiskFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("version", "String", version);
        return (ManagedObjectReference) getWsc().invoke("UpgradeVM_Task", paras, "ManagedObjectReference");
    }

    public String extractOvfEnvironment(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) getWsc().invoke("ExtractOvfEnvironment", paras, "String");
    }

    public ManagedObjectReference powerOnVM_Task(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, TaskInProgress, InvalidState, InsufficientResourcesFault, VmConfigFault, FileFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("PowerOnVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference powerOffVM_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("PowerOffVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference suspendVM_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("SuspendVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference resetVM_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("ResetVM_Task", paras, "ManagedObjectReference");
    }

    public void shutdownGuest(ManagedObjectReference _this) throws java.rmi.RemoteException, ToolsUnavailable, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("ShutdownGuest", paras, null);
    }

    public void rebootGuest(ManagedObjectReference _this) throws java.rmi.RemoteException, ToolsUnavailable, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RebootGuest", paras, null);
    }

    public void standbyGuest(ManagedObjectReference _this) throws java.rmi.RemoteException, ToolsUnavailable, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("StandbyGuest", paras, null);
    }

    public void answerVM(ManagedObjectReference _this, String questionId, String answerChoice) throws java.rmi.RemoteException, ConcurrentAccess, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("questionId", "String", questionId);
        paras[2] = new Argument("answerChoice", "String", answerChoice);
        getWsc().invoke("AnswerVM", paras, null);
    }

    public ManagedObjectReference customizeVM_Task(ManagedObjectReference _this, CustomizationSpec spec) throws java.rmi.RemoteException, CustomizationFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "CustomizationSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CustomizeVM_Task", paras, "ManagedObjectReference");
    }

    public void checkCustomizationSpec(ManagedObjectReference _this, CustomizationSpec spec) throws java.rmi.RemoteException, CustomizationFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "CustomizationSpec", spec);
        getWsc().invoke("CheckCustomizationSpec", paras, null);
    }

    public ManagedObjectReference migrateVM_Task(ManagedObjectReference _this, ManagedObjectReference pool, ManagedObjectReference host, VirtualMachineMovePriority priority, VirtualMachinePowerState state) throws java.rmi.RemoteException, MigrationFault, FileFault, Timedout, InsufficientResourcesFault, InvalidState, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pool", "ManagedObjectReference", pool);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        paras[3] = new Argument("priority", "VirtualMachineMovePriority", priority);
        paras[4] = new Argument("state", "VirtualMachinePowerState", state);
        return (ManagedObjectReference) getWsc().invoke("MigrateVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference relocateVM_Task(ManagedObjectReference _this, VirtualMachineRelocateSpec spec, VirtualMachineMovePriority priority) throws java.rmi.RemoteException, InvalidState, InvalidDatastore, MigrationFault, VmConfigFault, FileFault, Timedout, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VirtualMachineRelocateSpec", spec);
        paras[2] = new Argument("priority", "VirtualMachineMovePriority", priority);
        return (ManagedObjectReference) getWsc().invoke("RelocateVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference cloneVM_Task(ManagedObjectReference _this, ManagedObjectReference folder, String name, VirtualMachineCloneSpec spec) throws java.rmi.RemoteException, CustomizationFault, InvalidState, InvalidDatastore, TaskInProgress, VmConfigFault, FileFault, MigrationFault, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("folder", "ManagedObjectReference", folder);
        paras[2] = new Argument("name", "String", name);
        paras[3] = new Argument("spec", "VirtualMachineCloneSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CloneVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference exportVm(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidPowerState, TaskInProgress, InvalidState, FileFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("ExportVm", paras, "ManagedObjectReference");
    }

    public void markAsTemplate(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, VmConfigFault, FileFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("MarkAsTemplate", paras, null);
    }

    public void markAsVirtualMachine(ManagedObjectReference _this, ManagedObjectReference pool, ManagedObjectReference host) throws java.rmi.RemoteException, InvalidState, InvalidDatastore, VmConfigFault, FileFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pool", "ManagedObjectReference", pool);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        getWsc().invoke("MarkAsVirtualMachine", paras, null);
    }

    public void unregisterVM(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidPowerState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("UnregisterVM", paras, null);
    }

    public void resetGuestInformation(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("ResetGuestInformation", paras, null);
    }

    public void mountToolsInstaller(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, VmConfigFault, VmToolsUpgradeFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("MountToolsInstaller", paras, null);
    }

    public void unmountToolsInstaller(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("UnmountToolsInstaller", paras, null);
    }

    public ManagedObjectReference upgradeTools_Task(ManagedObjectReference _this, String installerOptions) throws java.rmi.RemoteException, InvalidState, TaskInProgress, VmToolsUpgradeFault, ToolsUnavailable, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("installerOptions", "String", installerOptions);
        return (ManagedObjectReference) getWsc().invoke("UpgradeTools_Task", paras, "ManagedObjectReference");
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

    public void setScreenResolution(ManagedObjectReference _this, int width, int height) throws java.rmi.RemoteException, InvalidState, ToolsUnavailable, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("width", "int", width);
        paras[2] = new Argument("height", "int", height);
        getWsc().invoke("SetScreenResolution", paras, null);
    }

    public void defragmentAllDisks(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, InvalidPowerState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DefragmentAllDisks", paras, null);
    }

    public ManagedObjectReference createSecondaryVM_Task(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, TaskInProgress, InvalidState, InsufficientResourcesFault, VmFaultToleranceIssue, FileFault, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("CreateSecondaryVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createSecondaryVMEx_Task(ManagedObjectReference _this, ManagedObjectReference host, FaultToleranceConfigSpec spec) throws FileFault, InsufficientResourcesFault, InvalidState, ManagedObjectNotFound, NotSupported, RuntimeFault, TaskInProgress, VmConfigFault, VmFaultToleranceIssue, RemoteException {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("host", "ManagedObjectReference", host);
        params[2] = new Argument("spec", "FaultToleranceConfigSpec", host);
        return (ManagedObjectReference) getWsc().invoke("CreateSecondaryVMEx_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference turnOffFaultToleranceForVM_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, VmFaultToleranceIssue, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("TurnOffFaultToleranceForVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference makePrimaryVM_Task(ManagedObjectReference _this, ManagedObjectReference vm) throws java.rmi.RemoteException, TaskInProgress, VmFaultToleranceIssue, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        return (ManagedObjectReference) getWsc().invoke("MakePrimaryVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference terminateFaultTolerantVM_Task(ManagedObjectReference _this, ManagedObjectReference vm) throws java.rmi.RemoteException, TaskInProgress, VmFaultToleranceIssue, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        return (ManagedObjectReference) getWsc().invoke("TerminateFaultTolerantVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference disableSecondaryVM_Task(ManagedObjectReference _this, ManagedObjectReference vm) throws java.rmi.RemoteException, TaskInProgress, VmFaultToleranceIssue, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        return (ManagedObjectReference) getWsc().invoke("DisableSecondaryVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference enableSecondaryVM_Task(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference host) throws java.rmi.RemoteException, TaskInProgress, VmFaultToleranceIssue, InvalidState, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("EnableSecondaryVM_Task", paras, "ManagedObjectReference");
    }

    public void setDisplayTopology(ManagedObjectReference _this, VirtualMachineDisplayTopology[] displays) throws java.rmi.RemoteException, InvalidState, ToolsUnavailable, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("displays", "VirtualMachineDisplayTopology[]", displays);
        getWsc().invoke("SetDisplayTopology", paras, null);
    }

    public ManagedObjectReference startRecording_Task(ManagedObjectReference _this, String name, String description) throws java.rmi.RemoteException, InvalidState, InvalidPowerState, TaskInProgress, FileFault, SnapshotFault, VmConfigFault, RecordReplayDisabled, HostIncompatibleForRecordReplay, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("description", "String", description);
        return (ManagedObjectReference) getWsc().invoke("StartRecording_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference stopRecording_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, InvalidPowerState, TaskInProgress, FileFault, SnapshotFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("StopRecording_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference startReplaying_Task(ManagedObjectReference _this, ManagedObjectReference replaySnapshot) throws java.rmi.RemoteException, InvalidState, InvalidPowerState, TaskInProgress, FileFault, SnapshotFault, NotFound, VmConfigFault, RecordReplayDisabled, HostIncompatibleForRecordReplay, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("replaySnapshot", "ManagedObjectReference", replaySnapshot);
        return (ManagedObjectReference) getWsc().invoke("StartReplaying_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference stopReplaying_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, InvalidPowerState, TaskInProgress, FileFault, SnapshotFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("StopReplaying_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference promoteDisks_Task(ManagedObjectReference _this, boolean unlink, VirtualDisk[] disks) throws java.rmi.RemoteException, InvalidState, InvalidPowerState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("unlink", "boolean", unlink);
        paras[2] = new Argument("disks", "VirtualDisk[]", disks);
        return (ManagedObjectReference) getWsc().invoke("PromoteDisks_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createScreenshot_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, FileFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("CreateScreenshot_Task", paras, "ManagedObjectReference");
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

    public String[] queryUnownedFiles(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String[]) getWsc().invoke("QueryUnownedFiles", paras, "String[]");
    }

    public ManagedObjectReference reloadVirtualMachineFromPath_Task(ManagedObjectReference _this, String configurationPath) throws java.rmi.RemoteException, InvalidPowerState, TaskInProgress, FileFault, InvalidState, VmConfigFault, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configurationPath", "String", configurationPath);
        return (ManagedObjectReference) getWsc().invoke("reloadVirtualMachineFromPath_Task", paras, "ManagedObjectReference");
    }

    public LocalizedMethodFault[] queryFaultToleranceCompatibility(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (LocalizedMethodFault[]) getWsc().invoke("QueryFaultToleranceCompatibility", paras, "LocalizedMethodFault[]");
    }

    public LocalizedMethodFault[] queryFaultToleranceCompatibilityEx(ManagedObjectReference _this, Boolean forLegacyFt) throws java.rmi.RemoteException, InvalidState, VmConfigFault, RuntimeFault {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("forLegacyFt", "Boolean", forLegacyFt);
        return (LocalizedMethodFault[]) getWsc().invoke("QueryFaultToleranceCompatibilityEx", params, "LocalizedMethodFault[]");
    }

    public void terminateVM(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("TerminateVM", paras, null);
    }

    public void removeAlarm(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RemoveAlarm", paras, null);
    }

    public void reconfigureAlarm(ManagedObjectReference _this, AlarmSpec spec) throws java.rmi.RemoteException, InvalidName, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "AlarmSpec", spec);
        getWsc().invoke("ReconfigureAlarm", paras, null);
    }

    public ManagedObjectReference createAlarm(ManagedObjectReference _this, ManagedObjectReference entity, AlarmSpec spec) throws java.rmi.RemoteException, InvalidName, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("spec", "AlarmSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateAlarm", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference[] getAlarm(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        return (ManagedObjectReference[]) getWsc().invoke("GetAlarm", paras, "ManagedObjectReference[]");
    }

    public boolean areAlarmActionsEnabled(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        Boolean ret = (Boolean) getWsc().invoke("AreAlarmActionsEnabled", paras, "boolean");
        return ret.booleanValue();
    }

    public void enableAlarmActions(ManagedObjectReference _this, ManagedObjectReference entity, boolean enabled) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("enabled", "boolean", enabled);
        getWsc().invoke("EnableAlarmActions", paras, null);
    }

    public AlarmState[] getAlarmState(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        return (AlarmState[]) getWsc().invoke("GetAlarmState", paras, "AlarmState[]");
    }

    public void acknowledgeAlarm(ManagedObjectReference _this, ManagedObjectReference alarm, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("alarm", "ManagedObjectReference", alarm);
        paras[2] = new Argument("entity", "ManagedObjectReference", entity);
        getWsc().invoke("AcknowledgeAlarm", paras, null);
    }

    public void setAlarmStatus(ManagedObjectReference _this, ManagedObjectReference alarm, ManagedObjectReference entity, String status) throws RemoteException, RuntimeFault {
        Argument[] params = new Argument[4];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("alarm", "ManagedObjectReference", alarm);
        params[2] = new Argument("entity", "ManagedObjectReference", entity);
        params[3] = new Argument("status", "String", status);
        getWsc().invoke("SetAlarmStatus", params, null);
    }

    public ManagedObjectReference reconfigureDVPortgroup_Task(ManagedObjectReference _this, DVPortgroupConfigSpec spec) throws java.rmi.RemoteException, DvsFault, ConcurrentAccess, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DVPortgroupConfigSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("ReconfigureDVPortgroup_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference dVPortgroupRollback_Task(ManagedObjectReference _this, EntityBackupConfig entityBackup) throws java.rmi.RemoteException, DvsFault, RollbackFailure, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entityBackup", "EntityBackupConfig", entityBackup);
        return (ManagedObjectReference) getWsc().invoke("DVPortgroupRollback_Task", paras, "ManagedObjectReference");
    }

    public DistributedVirtualSwitchProductSpec[] queryAvailableDvsSpec(ManagedObjectReference _this, Boolean recommended) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("recommended", "Boolean", recommended);
        return (DistributedVirtualSwitchProductSpec[]) getWsc().invoke("QueryAvailableDvsSpec", paras, "DistributedVirtualSwitchProductSpec[]");
    }

    public ManagedObjectReference[] queryCompatibleHostForNewDvs(ManagedObjectReference _this, ManagedObjectReference container, boolean recursive, DistributedVirtualSwitchProductSpec switchProductSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("container", "ManagedObjectReference", container);
        paras[2] = new Argument("recursive", "boolean", recursive);
        paras[3] = new Argument("switchProductSpec", "DistributedVirtualSwitchProductSpec", switchProductSpec);
        return (ManagedObjectReference[]) getWsc().invoke("QueryCompatibleHostForNewDvs", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference[] queryCompatibleHostForExistingDvs(ManagedObjectReference _this, ManagedObjectReference container, boolean recursive, ManagedObjectReference dvs) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("container", "ManagedObjectReference", container);
        paras[2] = new Argument("recursive", "boolean", recursive);
        paras[3] = new Argument("dvs", "ManagedObjectReference", dvs);
        return (ManagedObjectReference[]) getWsc().invoke("QueryCompatibleHostForExistingDvs", paras, "ManagedObjectReference[]");
    }

    public DistributedVirtualSwitchHostProductSpec[] queryDvsCompatibleHostSpec(ManagedObjectReference _this, DistributedVirtualSwitchProductSpec switchProductSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("switchProductSpec", "DistributedVirtualSwitchProductSpec", switchProductSpec);
        return (DistributedVirtualSwitchHostProductSpec[]) getWsc().invoke("QueryDvsCompatibleHostSpec", paras, "DistributedVirtualSwitchHostProductSpec[]");
    }

    public DVSFeatureCapability queryDvsFeatureCapability(ManagedObjectReference _this, DistributedVirtualSwitchProductSpec switchProductSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("switchProductSpec", "DistributedVirtualSwitchProductSpec", switchProductSpec);
        return (DVSFeatureCapability) getWsc().invoke("QueryDvsFeatureCapability", paras, "DVSFeatureCapability");
    }

    public ManagedObjectReference queryDvsByUuid(ManagedObjectReference _this, String uuid) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("uuid", "String", uuid);
        return (ManagedObjectReference) getWsc().invoke("QueryDvsByUuid", paras, "ManagedObjectReference");
    }

    public DVSManagerDvsConfigTarget queryDvsConfigTarget(ManagedObjectReference _this, ManagedObjectReference host, ManagedObjectReference dvs) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("dvs", "ManagedObjectReference", dvs);
        return (DVSManagerDvsConfigTarget) getWsc().invoke("QueryDvsConfigTarget", paras, "DVSManagerDvsConfigTarget");
    }

    public DistributedVirtualSwitchManagerCompatibilityResult[] queryDvsCheckCompatibility(ManagedObjectReference _this, DistributedVirtualSwitchManagerHostContainer hostContainer, DistributedVirtualSwitchManagerDvsProductSpec dvsProductSpec, DistributedVirtualSwitchManagerHostDvsFilterSpec[] hostFilterSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hostContainer", "DistributedVirtualSwitchManagerHostContainer", hostContainer);
        paras[2] = new Argument("dvsProductSpec", "DistributedVirtualSwitchManagerDvsProductSpec", dvsProductSpec);
        paras[3] = new Argument("hostFilterSpec", "DistributedVirtualSwitchManagerHostDvsFilterSpec[]", hostFilterSpec);
        return (DistributedVirtualSwitchManagerCompatibilityResult[]) getWsc().invoke("QueryDvsCheckCompatibility", paras, "DistributedVirtualSwitchManagerCompatibilityResult[]");
    }

    public ManagedObjectReference rectifyDvsOnHost_Task(ManagedObjectReference _this, ManagedObjectReference[] hosts) throws java.rmi.RemoteException, DvsFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hosts", "ManagedObjectReference[]", hosts);
        return (ManagedObjectReference) getWsc().invoke("RectifyDvsOnHost_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference dVSManagerExportEntity_Task(ManagedObjectReference _this, SelectionSet[] selectionSet) throws java.rmi.RemoteException, NotFound, BackupBlobWriteFailure, RuntimeFault {
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

    public ManagedObjectReference updateDVSLacpGroupConfig_Task(ManagedObjectReference _this, VMwareDvsLacpGroupSpec[] lacpGroupSpec) throws java.rmi.RemoteException, DvsFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lacpGroupSpec", "VMwareDvsLacpGroupSpec[]", lacpGroupSpec);
        return (ManagedObjectReference) getWsc().invoke("UpdateDVSLacpGroupConfig_Task", paras, "ManagedObjectReference");
    }

    public Event[] readNextEvents(ManagedObjectReference _this, int maxCount) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("maxCount", "int", maxCount);
        return (Event[]) getWsc().invoke("ReadNextEvents", paras, "Event[]");
    }

    public Event[] readPreviousEvents(ManagedObjectReference _this, int maxCount) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("maxCount", "int", maxCount);
        return (Event[]) getWsc().invoke("ReadPreviousEvents", paras, "Event[]");
    }

    public EventArgDesc[] retrieveArgumentDescription(ManagedObjectReference _this, String eventTypeId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("eventTypeId", "String", eventTypeId);
        return (EventArgDesc[]) getWsc().invoke("RetrieveArgumentDescription", paras, "EventArgDesc[]");
    }

    public ManagedObjectReference createCollectorForEvents(ManagedObjectReference _this, EventFilterSpec filter) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filter", "EventFilterSpec", filter);
        return (ManagedObjectReference) getWsc().invoke("CreateCollectorForEvents", paras, "ManagedObjectReference");
    }

    public void logUserEvent(ManagedObjectReference _this, ManagedObjectReference entity, String msg) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("msg", "String", msg);
        getWsc().invoke("LogUserEvent", paras, null);
    }

    public Event[] queryEvents(ManagedObjectReference _this, EventFilterSpec filter) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filter", "EventFilterSpec", filter);
        return (Event[]) getWsc().invoke("QueryEvents", paras, "Event[]");
    }

    public void postEvent(ManagedObjectReference _this, Event eventToPost, TaskInfo taskInfo) throws java.rmi.RemoteException, InvalidEvent, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("eventToPost", "Event", eventToPost);
        paras[2] = new Argument("taskInfo", "TaskInfo", taskInfo);
        getWsc().invoke("PostEvent", paras, null);
    }

    public ManagedObjectReference joinDomain_Task(ManagedObjectReference _this, String domainName, String userName, String password) throws java.rmi.RemoteException, InvalidState, HostConfigFault, InvalidLogin, ActiveDirectoryFault, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("domainName", "String", domainName);
        paras[2] = new Argument("userName", "String", userName);
        paras[3] = new Argument("password", "String", password);
        return (ManagedObjectReference) getWsc().invoke("JoinDomain_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference joinDomainWithCAM_Task(ManagedObjectReference _this, String domainName, String camServer) throws java.rmi.RemoteException, InvalidState, HostConfigFault, ActiveDirectoryFault, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("domainName", "String", domainName);
        paras[2] = new Argument("camServer", "String", camServer);
        return (ManagedObjectReference) getWsc().invoke("JoinDomainWithCAM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference importCertificateForCAM_Task(ManagedObjectReference _this, String certPath, String camServer) throws java.rmi.RemoteException, FileNotFound, ActiveDirectoryFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("certPath", "String", certPath);
        paras[2] = new Argument("camServer", "String", camServer);
        return (ManagedObjectReference) getWsc().invoke("ImportCertificateForCAM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference leaveCurrentDomain_Task(ManagedObjectReference _this, boolean force) throws java.rmi.RemoteException, InvalidState, AuthMinimumAdminPermission, ActiveDirectoryFault, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("force", "boolean", force);
        return (ManagedObjectReference) getWsc().invoke("LeaveCurrentDomain_Task", paras, "ManagedObjectReference");
    }

    public void reconfigureAutostart(ManagedObjectReference _this, HostAutoStartManagerConfig spec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostAutoStartManagerConfig", spec);
        getWsc().invoke("ReconfigureAutostart", paras, null);
    }

    public void autoStartPowerOn(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("AutoStartPowerOn", paras, null);
    }

    public void autoStartPowerOff(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("AutoStartPowerOff", paras, null);
    }

    public HostBootDeviceInfo queryBootDevices(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostBootDeviceInfo) getWsc().invoke("QueryBootDevices", paras, "HostBootDeviceInfo");
    }

    public void updateBootDevice(ManagedObjectReference _this, String key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String", key);
        getWsc().invoke("UpdateBootDevice", paras, null);
    }

    public ManagedObjectReference configureHostCache_Task(ManagedObjectReference _this, HostCacheConfigurationSpec spec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostCacheConfigurationSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("ConfigureHostCache_Task", paras, "ManagedObjectReference");
    }

    public void enableHyperThreading(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("EnableHyperThreading", paras, null);
    }

    public void disableHyperThreading(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DisableHyperThreading", paras, null);
    }

    public ManagedObjectReference searchDatastore_Task(ManagedObjectReference _this, String datastorePath, HostDatastoreBrowserSearchSpec searchSpec) throws java.rmi.RemoteException, InvalidDatastore, FileFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastorePath", "String", datastorePath);
        paras[2] = new Argument("searchSpec", "HostDatastoreBrowserSearchSpec", searchSpec);
        return (ManagedObjectReference) getWsc().invoke("SearchDatastore_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference searchDatastoreSubFolders_Task(ManagedObjectReference _this, String datastorePath, HostDatastoreBrowserSearchSpec searchSpec) throws java.rmi.RemoteException, InvalidDatastore, FileFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastorePath", "String", datastorePath);
        paras[2] = new Argument("searchSpec", "HostDatastoreBrowserSearchSpec", searchSpec);
        return (ManagedObjectReference) getWsc().invoke("SearchDatastoreSubFolders_Task", paras, "ManagedObjectReference");
    }

    public void deleteFile(ManagedObjectReference _this, String datastorePath) throws java.rmi.RemoteException, InvalidDatastore, FileFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastorePath", "String", datastorePath);
        getWsc().invoke("DeleteFile", paras, null);
    }

    public void updateLocalSwapDatastore(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, InaccessibleDatastore, DatastoreNotWritableOnHost, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        getWsc().invoke("UpdateLocalSwapDatastore", paras, null);
    }

    public HostScsiDisk[] queryAvailableDisksForVmfs(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (HostScsiDisk[]) getWsc().invoke("QueryAvailableDisksForVmfs", paras, "HostScsiDisk[]");
    }

    public VmfsDatastoreOption[] queryVmfsDatastoreCreateOptions(ManagedObjectReference _this, String devicePath) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("devicePath", "String", devicePath);
        return (VmfsDatastoreOption[]) getWsc().invoke("QueryVmfsDatastoreCreateOptions", paras, "VmfsDatastoreOption[]");
    }

    public VmfsDatastoreOption[] queryVmfsDatastoreCreateOptions(ManagedObjectReference _this, String devicePath, int vmfsMajorVersion) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("devicePath", "String", devicePath);
        paras[2] = new Argument("vmfsMajorVersion", "int", vmfsMajorVersion);
        return (VmfsDatastoreOption[]) getWsc().invoke("QueryVmfsDatastoreCreateOptions", paras, "VmfsDatastoreOption[]");
    }

    public ManagedObjectReference createVmfsDatastore(ManagedObjectReference _this, VmfsDatastoreCreateSpec spec) throws java.rmi.RemoteException, DuplicateName, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VmfsDatastoreCreateSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateVmfsDatastore", paras, "ManagedObjectReference");
    }

    public VmfsDatastoreOption[] queryVmfsDatastoreExtendOptions(ManagedObjectReference _this, ManagedObjectReference datastore, String devicePath, Boolean suppressExpandCandidates) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("devicePath", "String", devicePath);
        paras[3] = new Argument("suppressExpandCandidates", "Boolean", suppressExpandCandidates);
        return (VmfsDatastoreOption[]) getWsc().invoke("QueryVmfsDatastoreExtendOptions", paras, "VmfsDatastoreOption[]");
    }

    public VmfsDatastoreOption[] queryVmfsDatastoreExpandOptions(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (VmfsDatastoreOption[]) getWsc().invoke("QueryVmfsDatastoreExpandOptions", paras, "VmfsDatastoreOption[]");
    }

    public ManagedObjectReference extendVmfsDatastore(ManagedObjectReference _this, ManagedObjectReference datastore, VmfsDatastoreExtendSpec spec) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("spec", "VmfsDatastoreExtendSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("ExtendVmfsDatastore", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference expandVmfsDatastore(ManagedObjectReference _this, ManagedObjectReference datastore, VmfsDatastoreExpandSpec spec) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("spec", "VmfsDatastoreExpandSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("ExpandVmfsDatastore", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createNasDatastore(ManagedObjectReference _this, HostNasVolumeSpec spec) throws java.rmi.RemoteException, DuplicateName, AlreadyExists, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostNasVolumeSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateNasDatastore", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createLocalDatastore(ManagedObjectReference _this, String name, String path) throws java.rmi.RemoteException, DuplicateName, HostConfigFault, FileNotFound, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("path", "String", path);
        return (ManagedObjectReference) getWsc().invoke("CreateLocalDatastore", paras, "ManagedObjectReference");
    }

    public void removeDatastore(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, NotFound, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        getWsc().invoke("RemoveDatastore", paras, null);
    }

    public void configureDatastorePrincipal(ManagedObjectReference _this, String userName, String password) throws java.rmi.RemoteException, InvalidState, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("userName", "String", userName);
        paras[2] = new Argument("password", "String", password);
        getWsc().invoke("ConfigureDatastorePrincipal", paras, null);
    }

    public HostUnresolvedVmfsVolume[] queryUnresolvedVmfsVolumes(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostUnresolvedVmfsVolume[]) getWsc().invoke("QueryUnresolvedVmfsVolumes", paras, "HostUnresolvedVmfsVolume[]");
    }

    public ManagedObjectReference resignatureUnresolvedVmfsVolume_Task(ManagedObjectReference _this, HostUnresolvedVmfsResignatureSpec resolutionSpec) throws java.rmi.RemoteException, VmfsAmbiguousMount, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("resolutionSpec", "HostUnresolvedVmfsResignatureSpec", resolutionSpec);
        return (ManagedObjectReference) getWsc().invoke("ResignatureUnresolvedVmfsVolume_Task", paras, "ManagedObjectReference");
    }

    public void updateDateTimeConfig(ManagedObjectReference _this, HostDateTimeConfig config) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostDateTimeConfig", config);
        getWsc().invoke("UpdateDateTimeConfig", paras, null);
    }

    public HostDateTimeSystemTimeZone[] queryAvailableTimeZones(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostDateTimeSystemTimeZone[]) getWsc().invoke("QueryAvailableTimeZones", paras, "HostDateTimeSystemTimeZone[]");
    }

    public Calendar queryDateTime(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (Calendar) getWsc().invoke("QueryDateTime", paras, "Calendar");
    }

    public void updateDateTime(ManagedObjectReference _this, Calendar dateTime) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dateTime", "Calendar", dateTime);
        getWsc().invoke("UpdateDateTime", paras, null);
    }

    public void refreshDateTimeSystem(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshDateTimeSystem", paras, null);
    }

    public HostDiagnosticPartition[] queryAvailablePartition(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostDiagnosticPartition[]) getWsc().invoke("QueryAvailablePartition", paras, "HostDiagnosticPartition[]");
    }

    public void selectActivePartition(ManagedObjectReference _this, HostScsiDiskPartition partition) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("partition", "HostScsiDiskPartition", partition);
        getWsc().invoke("SelectActivePartition", paras, null);
    }

    public HostDiagnosticPartitionCreateOption[] queryPartitionCreateOptions(ManagedObjectReference _this, String storageType, String diagnosticType) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("storageType", "String", storageType);
        paras[2] = new Argument("diagnosticType", "String", diagnosticType);
        return (HostDiagnosticPartitionCreateOption[]) getWsc().invoke("QueryPartitionCreateOptions", paras, "HostDiagnosticPartitionCreateOption[]");
    }

    public HostDiagnosticPartitionCreateDescription queryPartitionCreateDesc(ManagedObjectReference _this, String diskUuid, String diagnosticType) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("diskUuid", "String", diskUuid);
        paras[2] = new Argument("diagnosticType", "String", diagnosticType);
        return (HostDiagnosticPartitionCreateDescription) getWsc().invoke("QueryPartitionCreateDesc", paras, "HostDiagnosticPartitionCreateDescription");
    }

    public void createDiagnosticPartition(ManagedObjectReference _this, HostDiagnosticPartitionCreateSpec spec) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostDiagnosticPartitionCreateSpec", spec);
        getWsc().invoke("CreateDiagnosticPartition", paras, null);
    }

    public void esxAgentHostManagerUpdateConfig(ManagedObjectReference _this, HostEsxAgentHostManagerConfigInfo configInfo) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configInfo", "HostEsxAgentHostManagerConfigInfo", configInfo);
        getWsc().invoke("EsxAgentHostManagerUpdateConfig", paras, null);
    }

    public void updateDefaultPolicy(ManagedObjectReference _this, HostFirewallDefaultPolicy defaultPolicy) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("defaultPolicy", "HostFirewallDefaultPolicy", defaultPolicy);
        getWsc().invoke("UpdateDefaultPolicy", paras, null);
    }

    public void enableRuleset(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        getWsc().invoke("EnableRuleset", paras, null);
    }

    public void disableRuleset(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        getWsc().invoke("DisableRuleset", paras, null);
    }

    public void updateRuleset(ManagedObjectReference _this, String id, HostFirewallRulesetRulesetSpec spec) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        paras[2] = new Argument("spec", "HostFirewallRulesetRulesetSpec", spec);
        getWsc().invoke("UpdateRuleset", paras, null);
    }

    public void refreshFirewall(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshFirewall", paras, null);
    }

    public void resetFirmwareToFactoryDefaults(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("ResetFirmwareToFactoryDefaults", paras, null);
    }

    public String backupFirmwareConfiguration(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) getWsc().invoke("BackupFirmwareConfiguration", paras, "String");
    }

    public String queryFirmwareConfigUploadURL(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) getWsc().invoke("QueryFirmwareConfigUploadURL", paras, "String");
    }

    public void restoreFirmwareConfiguration(ManagedObjectReference _this, boolean force) throws java.rmi.RemoteException, InvalidState, FileFault, MismatchedBundle, InvalidBundle, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("force", "boolean", force);
        getWsc().invoke("RestoreFirmwareConfiguration", paras, null);
    }

    public void refreshGraphicsManager(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshGraphicsManager", paras, null);
    }

    public boolean isSharedGraphicsActive(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        Boolean ret = (Boolean) getWsc().invoke("IsSharedGraphicsActive", paras, "boolean");
        return ret.booleanValue();
    }

    public void refreshHealthStatusSystem(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshHealthStatusSystem", paras, null);
    }

    public void resetSystemHealthInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("ResetSystemHealthInfo", paras, null);
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

    public void updateHostImageAcceptanceLevel(ManagedObjectReference _this, String newAcceptanceLevel) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("newAcceptanceLevel", "String", newAcceptanceLevel);
        getWsc().invoke("UpdateHostImageAcceptanceLevel", paras, null);
    }

    public IscsiStatus queryVnicStatus(ManagedObjectReference _this, String vnicDevice) throws java.rmi.RemoteException, IscsiFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vnicDevice", "String", vnicDevice);
        return (IscsiStatus) getWsc().invoke("QueryVnicStatus", paras, "IscsiStatus");
    }

    public IscsiStatus queryPnicStatus(ManagedObjectReference _this, String pnicDevice) throws java.rmi.RemoteException, IscsiFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pnicDevice", "String", pnicDevice);
        return (IscsiStatus) getWsc().invoke("QueryPnicStatus", paras, "IscsiStatus");
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

    public void bindVnic(ManagedObjectReference _this, String iScsiHbaName, String vnicDevice) throws java.rmi.RemoteException, IscsiFaultVnicAlreadyBound, IscsiFaultVnicHasNoUplinks, IscsiFaultVnicHasMultipleUplinks, IscsiFaultVnicHasWrongUplink, IscsiFaultVnicNotFound, IscsiFaultInvalidVnic, PlatformConfigFault, IscsiFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaName", "String", iScsiHbaName);
        paras[2] = new Argument("vnicDevice", "String", vnicDevice);
        getWsc().invoke("BindVnic", paras, null);
    }

    public void unbindVnic(ManagedObjectReference _this, String iScsiHbaName, String vnicDevice, boolean force) throws java.rmi.RemoteException, IscsiFaultVnicNotBound, IscsiFaultVnicHasActivePaths, IscsiFaultVnicIsLastPath, PlatformConfigFault, IscsiFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaName", "String", iScsiHbaName);
        paras[2] = new Argument("vnicDevice", "String", vnicDevice);
        paras[3] = new Argument("force", "boolean", force);
        getWsc().invoke("UnbindVnic", paras, null);
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

    public void updateModuleOptionString(ManagedObjectReference _this, String name, String options) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("options", "String", options);
        getWsc().invoke("UpdateModuleOptionString", paras, null);
    }

    public String queryConfiguredModuleOptionString(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (String) getWsc().invoke("QueryConfiguredModuleOptionString", paras, "String");
    }

    public void createUser(ManagedObjectReference _this, HostAccountSpec user) throws java.rmi.RemoteException, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("user", "HostAccountSpec", user);
        getWsc().invoke("CreateUser", paras, null);
    }

    public void updateUser(ManagedObjectReference _this, HostAccountSpec user) throws java.rmi.RemoteException, UserNotFound, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("user", "HostAccountSpec", user);
        getWsc().invoke("UpdateUser", paras, null);
    }

    public void createGroup(ManagedObjectReference _this, HostAccountSpec group) throws java.rmi.RemoteException, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("group", "HostAccountSpec", group);
        getWsc().invoke("CreateGroup", paras, null);
    }

    public void removeUser(ManagedObjectReference _this, String userName) throws java.rmi.RemoteException, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("userName", "String", userName);
        getWsc().invoke("RemoveUser", paras, null);
    }

    public void removeGroup(ManagedObjectReference _this, String groupName) throws java.rmi.RemoteException, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("groupName", "String", groupName);
        getWsc().invoke("RemoveGroup", paras, null);
    }

    public void assignUserToGroup(ManagedObjectReference _this, String user, String group) throws java.rmi.RemoteException, UserNotFound, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("user", "String", user);
        paras[2] = new Argument("group", "String", group);
        getWsc().invoke("AssignUserToGroup", paras, null);
    }

    public void unassignUserFromGroup(ManagedObjectReference _this, String user, String group) throws java.rmi.RemoteException, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("user", "String", user);
        paras[2] = new Argument("group", "String", group);
        getWsc().invoke("UnassignUserFromGroup", paras, null);
    }

    public void reconfigureServiceConsoleReservation(ManagedObjectReference _this, long cfgBytes) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cfgBytes", "long", cfgBytes);
        getWsc().invoke("ReconfigureServiceConsoleReservation", paras, null);
    }

    public void reconfigureVirtualMachineReservation(ManagedObjectReference _this, VirtualMachineMemoryReservationSpec spec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VirtualMachineMemoryReservationSpec", spec);
        getWsc().invoke("ReconfigureVirtualMachineReservation", paras, null);
    }

    public HostNetworkConfigResult updateNetworkConfig(ManagedObjectReference _this, HostNetworkConfig config, String changeMode) throws java.rmi.RemoteException, AlreadyExists, NotFound, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostNetworkConfig", config);
        paras[2] = new Argument("changeMode", "String", changeMode);
        return (HostNetworkConfigResult) getWsc().invoke("UpdateNetworkConfig", paras, "HostNetworkConfigResult");
    }

    public void updateDnsConfig(ManagedObjectReference _this, HostDnsConfig config) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostDnsConfig", config);
        getWsc().invoke("UpdateDnsConfig", paras, null);
    }

    public void updateIpRouteConfig(ManagedObjectReference _this, HostIpRouteConfig config) throws java.rmi.RemoteException, HostConfigFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostIpRouteConfig", config);
        getWsc().invoke("UpdateIpRouteConfig", paras, null);
    }

    public void updateConsoleIpRouteConfig(ManagedObjectReference _this, HostIpRouteConfig config) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostIpRouteConfig", config);
        getWsc().invoke("UpdateConsoleIpRouteConfig", paras, null);
    }

    public void updateIpRouteTableConfig(ManagedObjectReference _this, HostIpRouteTableConfig config) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostIpRouteTableConfig", config);
        getWsc().invoke("UpdateIpRouteTableConfig", paras, null);
    }

    public void addVirtualSwitch(ManagedObjectReference _this, String vswitchName, HostVirtualSwitchSpec spec) throws java.rmi.RemoteException, AlreadyExists, ResourceInUse, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vswitchName", "String", vswitchName);
        paras[2] = new Argument("spec", "HostVirtualSwitchSpec", spec);
        getWsc().invoke("AddVirtualSwitch", paras, null);
    }

    public void removeVirtualSwitch(ManagedObjectReference _this, String vswitchName) throws java.rmi.RemoteException, NotFound, ResourceInUse, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vswitchName", "String", vswitchName);
        getWsc().invoke("RemoveVirtualSwitch", paras, null);
    }

    public void updateVirtualSwitch(ManagedObjectReference _this, String vswitchName, HostVirtualSwitchSpec spec) throws java.rmi.RemoteException, ResourceInUse, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vswitchName", "String", vswitchName);
        paras[2] = new Argument("spec", "HostVirtualSwitchSpec", spec);
        getWsc().invoke("UpdateVirtualSwitch", paras, null);
    }

    public void addPortGroup(ManagedObjectReference _this, HostPortGroupSpec portgrp) throws java.rmi.RemoteException, AlreadyExists, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portgrp", "HostPortGroupSpec", portgrp);
        getWsc().invoke("AddPortGroup", paras, null);
    }

    public void removePortGroup(ManagedObjectReference _this, String pgName) throws java.rmi.RemoteException, NotFound, ResourceInUse, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pgName", "String", pgName);
        getWsc().invoke("RemovePortGroup", paras, null);
    }

    public void updatePortGroup(ManagedObjectReference _this, String pgName, HostPortGroupSpec portgrp) throws java.rmi.RemoteException, AlreadyExists, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pgName", "String", pgName);
        paras[2] = new Argument("portgrp", "HostPortGroupSpec", portgrp);
        getWsc().invoke("UpdatePortGroup", paras, null);
    }

    public void updatePhysicalNicLinkSpeed(ManagedObjectReference _this, String device, PhysicalNicLinkInfo linkSpeed) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        paras[2] = new Argument("linkSpeed", "PhysicalNicLinkInfo", linkSpeed);
        getWsc().invoke("UpdatePhysicalNicLinkSpeed", paras, null);
    }

    public PhysicalNicHintInfo[] queryNetworkHint(ManagedObjectReference _this, String[] device) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String[]", device);
        return (PhysicalNicHintInfo[]) getWsc().invoke("QueryNetworkHint", paras, "PhysicalNicHintInfo[]");
    }

    public String addVirtualNic(ManagedObjectReference _this, String portgroup, HostVirtualNicSpec nic) throws java.rmi.RemoteException, AlreadyExists, HostConfigFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portgroup", "String", portgroup);
        paras[2] = new Argument("nic", "HostVirtualNicSpec", nic);
        return (String) getWsc().invoke("AddVirtualNic", paras, "String");
    }

    public void removeVirtualNic(ManagedObjectReference _this, String device) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        getWsc().invoke("RemoveVirtualNic", paras, null);
    }

    public void updateVirtualNic(ManagedObjectReference _this, String device, HostVirtualNicSpec nic) throws java.rmi.RemoteException, NotFound, HostConfigFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        paras[2] = new Argument("nic", "HostVirtualNicSpec", nic);
        getWsc().invoke("UpdateVirtualNic", paras, null);
    }

    public String addServiceConsoleVirtualNic(ManagedObjectReference _this, String portgroup, HostVirtualNicSpec nic) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portgroup", "String", portgroup);
        paras[2] = new Argument("nic", "HostVirtualNicSpec", nic);
        return (String) getWsc().invoke("AddServiceConsoleVirtualNic", paras, "String");
    }

    public void removeServiceConsoleVirtualNic(ManagedObjectReference _this, String device) throws java.rmi.RemoteException, NotFound, ResourceInUse, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        getWsc().invoke("RemoveServiceConsoleVirtualNic", paras, null);
    }

    public void updateServiceConsoleVirtualNic(ManagedObjectReference _this, String device, HostVirtualNicSpec nic) throws java.rmi.RemoteException, NotFound, ResourceInUse, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        paras[2] = new Argument("nic", "HostVirtualNicSpec", nic);
        getWsc().invoke("UpdateServiceConsoleVirtualNic", paras, null);
    }

    public void restartServiceConsoleVirtualNic(ManagedObjectReference _this, String device) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        getWsc().invoke("RestartServiceConsoleVirtualNic", paras, null);
    }

    public void refreshNetworkSystem(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshNetworkSystem", paras, null);
    }

    public ManagedObjectReference checkHostPatch_Task(ManagedObjectReference _this, String[] metaUrls, String[] bundleUrls, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, RequestCanceled, InvalidState, TaskInProgress, PlatformConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("metaUrls", "String[]", metaUrls);
        paras[2] = new Argument("bundleUrls", "String[]", bundleUrls);
        paras[3] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CheckHostPatch_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference scanHostPatch_Task(ManagedObjectReference _this, HostPatchManagerLocator repository, String[] updateID) throws java.rmi.RemoteException, RequestCanceled, PatchMetadataInvalid, PlatformConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("repository", "HostPatchManagerLocator", repository);
        paras[2] = new Argument("updateID", "String[]", updateID);
        return (ManagedObjectReference) getWsc().invoke("ScanHostPatch_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference scanHostPatchV2_Task(ManagedObjectReference _this, String[] metaUrls, String[] bundleUrls, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, RequestCanceled, InvalidState, TaskInProgress, PlatformConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("metaUrls", "String[]", metaUrls);
        paras[2] = new Argument("bundleUrls", "String[]", bundleUrls);
        paras[3] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("ScanHostPatchV2_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference stageHostPatch_Task(ManagedObjectReference _this, String[] metaUrls, String[] bundleUrls, String[] vibUrls, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, RequestCanceled, InvalidState, TaskInProgress, PlatformConfigFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("metaUrls", "String[]", metaUrls);
        paras[2] = new Argument("bundleUrls", "String[]", bundleUrls);
        paras[3] = new Argument("vibUrls", "String[]", vibUrls);
        paras[4] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("StageHostPatch_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference installHostPatch_Task(ManagedObjectReference _this, HostPatchManagerLocator repository, String updateID, Boolean force) throws java.rmi.RemoteException, PatchMetadataInvalid, PatchBinariesNotFound, PatchNotApplicable, NoDiskSpace, PatchInstallFailed, RebootRequired, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("repository", "HostPatchManagerLocator", repository);
        paras[2] = new Argument("updateID", "String", updateID);
        paras[3] = new Argument("force", "Boolean", force);
        return (ManagedObjectReference) getWsc().invoke("InstallHostPatch_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference installHostPatchV2_Task(ManagedObjectReference _this, String[] metaUrls, String[] bundleUrls, String[] vibUrls, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, RequestCanceled, InvalidState, TaskInProgress, PlatformConfigFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("metaUrls", "String[]", metaUrls);
        paras[2] = new Argument("bundleUrls", "String[]", bundleUrls);
        paras[3] = new Argument("vibUrls", "String[]", vibUrls);
        paras[4] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("InstallHostPatchV2_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference uninstallHostPatch_Task(ManagedObjectReference _this, String[] bulletinIds, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, InvalidState, TaskInProgress, PlatformConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("bulletinIds", "String[]", bulletinIds);
        paras[2] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("UninstallHostPatch_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference queryHostPatch_Task(ManagedObjectReference _this, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, RequestCanceled, InvalidState, TaskInProgress, PlatformConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("QueryHostPatch_Task", paras, "ManagedObjectReference");
    }

    public void refresh(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("Refresh", paras, null);
    }

    public void updatePassthruConfig(ManagedObjectReference _this, HostPciPassthruConfig[] config) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostPciPassthruConfig[]", config);
        getWsc().invoke("UpdatePassthruConfig", paras, null);
    }

    public void configurePowerPolicy(ManagedObjectReference _this, int key) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "int", key);
        getWsc().invoke("ConfigurePowerPolicy", paras, null);
    }

    public void updateServicePolicy(ManagedObjectReference _this, String id, String policy) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        paras[2] = new Argument("policy", "String", policy);
        getWsc().invoke("UpdateServicePolicy", paras, null);
    }

    public void startService(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, InvalidState, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        getWsc().invoke("StartService", paras, null);
    }

    public void stopService(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, InvalidState, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        getWsc().invoke("StopService", paras, null);
    }

    public void restartService(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, InvalidState, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        getWsc().invoke("RestartService", paras, null);
    }

    public void uninstallService(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        getWsc().invoke("UninstallService", paras, null);
    }

    public void refreshServices(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshServices", paras, null);
    }

    public void reconfigureSnmpAgent(ManagedObjectReference _this, HostSnmpConfigSpec spec) throws java.rmi.RemoteException, NotFound, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostSnmpConfigSpec", spec);
        getWsc().invoke("ReconfigureSnmpAgent", paras, null);
    }

    public void sendTestNotification(ManagedObjectReference _this) throws java.rmi.RemoteException, NotFound, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("SendTestNotification", paras, null);
    }

    public HostDiskPartitionInfo[] retrieveDiskPartitionInfo(ManagedObjectReference _this, String[] devicePath) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("devicePath", "String[]", devicePath);
        return (HostDiskPartitionInfo[]) getWsc().invoke("RetrieveDiskPartitionInfo", paras, "HostDiskPartitionInfo[]");
    }

    public HostDiskPartitionInfo computeDiskPartitionInfo(ManagedObjectReference _this, String devicePath, HostDiskPartitionLayout layout, String partitionFormat) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("devicePath", "String", devicePath);
        paras[2] = new Argument("layout", "HostDiskPartitionLayout", layout);
        paras[3] = new Argument("partitionFormat", "String", partitionFormat);
        return (HostDiskPartitionInfo) getWsc().invoke("ComputeDiskPartitionInfo", paras, "HostDiskPartitionInfo");
    }

    public HostDiskPartitionInfo computeDiskPartitionInfoForResize(ManagedObjectReference _this, HostScsiDiskPartition partition, HostDiskPartitionBlockRange blockRange, String partitionFormat) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("partition", "HostScsiDiskPartition", partition);
        paras[2] = new Argument("blockRange", "HostDiskPartitionBlockRange", blockRange);
        paras[3] = new Argument("partitionFormat", "String", partitionFormat);
        return (HostDiskPartitionInfo) getWsc().invoke("ComputeDiskPartitionInfoForResize", paras, "HostDiskPartitionInfo");
    }

    public void updateDiskPartitions(ManagedObjectReference _this, String devicePath, HostDiskPartitionSpec spec) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("devicePath", "String", devicePath);
        paras[2] = new Argument("spec", "HostDiskPartitionSpec", spec);
        getWsc().invoke("UpdateDiskPartitions", paras, null);
    }

    public HostVmfsVolume formatVmfs(ManagedObjectReference _this, HostVmfsSpec createSpec) throws java.rmi.RemoteException, AlreadyExists, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("createSpec", "HostVmfsSpec", createSpec);
        return (HostVmfsVolume) getWsc().invoke("FormatVmfs", paras, "HostVmfsVolume");
    }

    public void mountVmfsVolume(ManagedObjectReference _this, String vmfsUuid) throws java.rmi.RemoteException, NotFound, InvalidState, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsUuid", "String", vmfsUuid);
        getWsc().invoke("MountVmfsVolume", paras, null);
    }

    public void unmountVmfsVolume(ManagedObjectReference _this, String vmfsUuid) throws java.rmi.RemoteException, NotFound, InvalidState, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsUuid", "String", vmfsUuid);
        getWsc().invoke("UnmountVmfsVolume", paras, null);
    }

    public void deleteVmfsVolumeState(ManagedObjectReference _this, String vmfsUuid) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsUuid", "String", vmfsUuid);
        getWsc().invoke("DeleteVmfsVolumeState", paras, null);
    }

    public void rescanVmfs(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RescanVmfs", paras, null);
    }

    public void attachVmfsExtent(ManagedObjectReference _this, String vmfsPath, HostScsiDiskPartition extent) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsPath", "String", vmfsPath);
        paras[2] = new Argument("extent", "HostScsiDiskPartition", extent);
        getWsc().invoke("AttachVmfsExtent", paras, null);
    }

    public void expandVmfsExtent(ManagedObjectReference _this, String vmfsPath, HostScsiDiskPartition extent) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsPath", "String", vmfsPath);
        paras[2] = new Argument("extent", "HostScsiDiskPartition", extent);
        getWsc().invoke("ExpandVmfsExtent", paras, null);
    }

    public void upgradeVmfs(ManagedObjectReference _this, String vmfsPath) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
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

    public HostUnresolvedVmfsVolume[] queryUnresolvedVmfsVolume(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostUnresolvedVmfsVolume[]) getWsc().invoke("QueryUnresolvedVmfsVolume", paras, "HostUnresolvedVmfsVolume[]");
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

    public void unmountForceMountedVmfsVolume(ManagedObjectReference _this, String vmfsUuid) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsUuid", "String", vmfsUuid);
        getWsc().invoke("UnmountForceMountedVmfsVolume", paras, null);
    }

    public void rescanHba(ManagedObjectReference _this, String hbaDevice) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hbaDevice", "String", hbaDevice);
        getWsc().invoke("RescanHba", paras, null);
    }

    public void rescanAllHba(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RescanAllHba", paras, null);
    }

    public void updateSoftwareInternetScsiEnabled(ManagedObjectReference _this, boolean enabled) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("enabled", "boolean", enabled);
        getWsc().invoke("UpdateSoftwareInternetScsiEnabled", paras, null);
    }

    public void updateInternetScsiDiscoveryProperties(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaDiscoveryProperties discoveryProperties) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("discoveryProperties", "HostInternetScsiHbaDiscoveryProperties", discoveryProperties);
        getWsc().invoke("UpdateInternetScsiDiscoveryProperties", paras, null);
    }

    public void updateInternetScsiAuthenticationProperties(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaAuthenticationProperties authenticationProperties, HostInternetScsiHbaTargetSet targetSet) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("authenticationProperties", "HostInternetScsiHbaAuthenticationProperties", authenticationProperties);
        paras[3] = new Argument("targetSet", "HostInternetScsiHbaTargetSet", targetSet);
        getWsc().invoke("UpdateInternetScsiAuthenticationProperties", paras, null);
    }

    public void updateInternetScsiDigestProperties(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaTargetSet targetSet, HostInternetScsiHbaDigestProperties digestProperties) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targetSet", "HostInternetScsiHbaTargetSet", targetSet);
        paras[3] = new Argument("digestProperties", "HostInternetScsiHbaDigestProperties", digestProperties);
        getWsc().invoke("UpdateInternetScsiDigestProperties", paras, null);
    }

    public void updateInternetScsiAdvancedOptions(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaTargetSet targetSet, HostInternetScsiHbaParamValue[] options) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targetSet", "HostInternetScsiHbaTargetSet", targetSet);
        paras[3] = new Argument("options", "HostInternetScsiHbaParamValue[]", options);
        getWsc().invoke("UpdateInternetScsiAdvancedOptions", paras, null);
    }

    public void updateInternetScsiIPProperties(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaIPProperties ipProperties) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("ipProperties", "HostInternetScsiHbaIPProperties", ipProperties);
        getWsc().invoke("UpdateInternetScsiIPProperties", paras, null);
    }

    public void updateInternetScsiName(ManagedObjectReference _this, String iScsiHbaDevice, String iScsiName) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("iScsiName", "String", iScsiName);
        getWsc().invoke("UpdateInternetScsiName", paras, null);
    }

    public void updateInternetScsiAlias(ManagedObjectReference _this, String iScsiHbaDevice, String iScsiAlias) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("iScsiAlias", "String", iScsiAlias);
        getWsc().invoke("UpdateInternetScsiAlias", paras, null);
    }

    public void addInternetScsiSendTargets(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaSendTarget[] targets) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targets", "HostInternetScsiHbaSendTarget[]", targets);
        getWsc().invoke("AddInternetScsiSendTargets", paras, null);
    }

    public void removeInternetScsiSendTargets(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaSendTarget[] targets) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targets", "HostInternetScsiHbaSendTarget[]", targets);
        getWsc().invoke("RemoveInternetScsiSendTargets", paras, null);
    }

    public void addInternetScsiStaticTargets(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaStaticTarget[] targets) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targets", "HostInternetScsiHbaStaticTarget[]", targets);
        getWsc().invoke("AddInternetScsiStaticTargets", paras, null);
    }

    public void removeInternetScsiStaticTargets(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaStaticTarget[] targets) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targets", "HostInternetScsiHbaStaticTarget[]", targets);
        getWsc().invoke("RemoveInternetScsiStaticTargets", paras, null);
    }

    public void enableMultipathPath(ManagedObjectReference _this, String pathName) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pathName", "String", pathName);
        getWsc().invoke("EnableMultipathPath", paras, null);
    }

    public void disableMultipathPath(ManagedObjectReference _this, String pathName) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pathName", "String", pathName);
        getWsc().invoke("DisableMultipathPath", paras, null);
    }

    public void setMultipathLunPolicy(ManagedObjectReference _this, String lunId, HostMultipathInfoLogicalUnitPolicy policy) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunId", "String", lunId);
        paras[2] = new Argument("policy", "HostMultipathInfoLogicalUnitPolicy", policy);
        getWsc().invoke("SetMultipathLunPolicy", paras, null);
    }

    public HostPathSelectionPolicyOption[] queryPathSelectionPolicyOptions(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostPathSelectionPolicyOption[]) getWsc().invoke("QueryPathSelectionPolicyOptions", paras, "HostPathSelectionPolicyOption[]");
    }

    public HostStorageArrayTypePolicyOption[] queryStorageArrayTypePolicyOptions(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostStorageArrayTypePolicyOption[]) getWsc().invoke("QueryStorageArrayTypePolicyOptions", paras, "HostStorageArrayTypePolicyOption[]");
    }

    public void updateScsiLunDisplayName(ManagedObjectReference _this, String lunUuid, String displayName) throws java.rmi.RemoteException, NotFound, HostConfigFault, InvalidName, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunUuid", "String", lunUuid);
        paras[2] = new Argument("displayName", "String", displayName);
        getWsc().invoke("UpdateScsiLunDisplayName", paras, null);
    }

    public void detachScsiLun(ManagedObjectReference _this, String lunUuid) throws java.rmi.RemoteException, NotFound, HostConfigFault, InvalidState, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunUuid", "String", lunUuid);
        getWsc().invoke("DetachScsiLun", paras, null);
    }

    public void deleteScsiLunState(ManagedObjectReference _this, String lunCanonicalName) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunCanonicalName", "String", lunCanonicalName);
        getWsc().invoke("DeleteScsiLunState", paras, null);
    }

    public void attachScsiLun(ManagedObjectReference _this, String lunUuid) throws java.rmi.RemoteException, NotFound, HostConfigFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunUuid", "String", lunUuid);
        getWsc().invoke("AttachScsiLun", paras, null);
    }

    public void refreshStorageSystem(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RefreshStorageSystem", paras, null);
    }

    public void discoverFcoeHbas(ManagedObjectReference _this, FcoeConfigFcoeSpecification fcoeSpec) throws java.rmi.RemoteException, FcoeFaultPnicHasNoPortSet, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("fcoeSpec", "FcoeConfigFcoeSpecification", fcoeSpec);
        getWsc().invoke("DiscoverFcoeHbas", paras, null);
    }

    public void markForRemoval(ManagedObjectReference _this, String hbaName, boolean remove) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hbaName", "String", hbaName);
        paras[2] = new Argument("remove", "boolean", remove);
        getWsc().invoke("MarkForRemoval", paras, null);
    }

    public HostVffsVolume formatVffs(ManagedObjectReference _this, HostVffsSpec createSpec) throws java.rmi.RemoteException, AlreadyExists, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("createSpec", "HostVffsSpec", createSpec);
        return (HostVffsVolume) getWsc().invoke("FormatVffs", paras, "HostVffsVolume");
    }

    public void extendVffs(ManagedObjectReference _this, String vffsPath, String devicePath, HostDiskPartitionSpec spec) throws java.rmi.RemoteException, NotFound, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsPath", "String", vffsPath);
        paras[2] = new Argument("devicePath", "String", devicePath);
        paras[3] = new Argument("spec", "HostDiskPartitionSpec", spec);
        getWsc().invoke("ExtendVffs", paras, null);
    }

    public void destroyVffs(ManagedObjectReference _this, String vffsPath) throws java.rmi.RemoteException, NotFound, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsPath", "String", vffsPath);
        getWsc().invoke("DestroyVffs", paras, null);
    }

    public void mountVffsVolume(ManagedObjectReference _this, String vffsUuid) throws java.rmi.RemoteException, NotFound, InvalidState, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsUuid", "String", vffsUuid);
        getWsc().invoke("MountVffsVolume", paras, null);
    }

    public void unmountVffsVolume(ManagedObjectReference _this, String vffsUuid) throws java.rmi.RemoteException, NotFound, InvalidState, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsUuid", "String", vffsUuid);
        getWsc().invoke("UnmountVffsVolume", paras, null);
    }

    public void deleteVffsVolumeState(ManagedObjectReference _this, String vffsUuid) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsUuid", "String", vffsUuid);
        getWsc().invoke("DeleteVffsVolumeState", paras, null);
    }

    public void rescanVffs(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RescanVffs", paras, null);
    }

    public HostScsiDisk[] queryAvailableSsds(ManagedObjectReference _this, String vffsPath) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsPath", "String", vffsPath);
        return (HostScsiDisk[]) getWsc().invoke("QueryAvailableSsds", paras, "HostScsiDisk[]");
    }

    public ManagedObjectReference configureVFlashResourceEx_Task(ManagedObjectReference _this, String[] devicePath) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("devicePath", "String[]", devicePath);
        return (ManagedObjectReference) getWsc().invoke("ConfigureVFlashResourceEx_Task", paras, "ManagedObjectReference");
    }

    public void hostConfigureVFlashResource(ManagedObjectReference _this, HostVFlashManagerVFlashResourceConfigSpec spec) throws java.rmi.RemoteException, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostVFlashManagerVFlashResourceConfigSpec", spec);
        getWsc().invoke("HostConfigureVFlashResource", paras, null);
    }

    public void hostRemoveVFlashResource(ManagedObjectReference _this) throws java.rmi.RemoteException, NotFound, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("HostRemoveVFlashResource", paras, null);
    }

    public void hostConfigVFlashCache(ManagedObjectReference _this, HostVFlashManagerVFlashCacheConfigSpec spec) throws java.rmi.RemoteException, HostConfigFault, InaccessibleVFlashSource, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostVFlashManagerVFlashCacheConfigSpec", spec);
        getWsc().invoke("HostConfigVFlashCache", paras, null);
    }

    public VirtualDiskVFlashCacheConfigInfo hostGetVFlashModuleDefaultConfig(ManagedObjectReference _this, String vFlashModule) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vFlashModule", "String", vFlashModule);
        return (VirtualDiskVFlashCacheConfigInfo) getWsc().invoke("HostGetVFlashModuleDefaultConfig", paras, "VirtualDiskVFlashCacheConfigInfo");
    }

    public void updateIpConfig(ManagedObjectReference _this, HostIpConfig ipConfig) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ipConfig", "HostIpConfig", ipConfig);
        getWsc().invoke("UpdateIpConfig", paras, null);
    }

    public void selectVnic(ManagedObjectReference _this, String device) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        getWsc().invoke("SelectVnic", paras, null);
    }

    public void deselectVnic(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DeselectVnic", paras, null);
    }

    public VirtualNicManagerNetConfig queryNetConfig(ManagedObjectReference _this, String nicType) throws java.rmi.RemoteException, HostConfigFault, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("nicType", "String", nicType);
        return (VirtualNicManagerNetConfig) getWsc().invoke("QueryNetConfig", paras, "VirtualNicManagerNetConfig");
    }

    public void selectVnicForNicType(ManagedObjectReference _this, String nicType, String device) throws java.rmi.RemoteException, HostConfigFault, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("nicType", "String", nicType);
        paras[2] = new Argument("device", "String", device);
        getWsc().invoke("SelectVnicForNicType", paras, null);
    }

    public void deselectVnicForNicType(ManagedObjectReference _this, String nicType, String device) throws java.rmi.RemoteException, HostConfigFault, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("nicType", "String", nicType);
        paras[2] = new Argument("device", "String", device);
        getWsc().invoke("DeselectVnicForNicType", paras, null);
    }

    public String queryCmmds(ManagedObjectReference _this, HostVsanInternalSystemCmmdsQuery[] queries) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("queries", "HostVsanInternalSystemCmmdsQuery[]", queries);
        return (String) getWsc().invoke("QueryCmmds", paras, "String");
    }

    public String queryPhysicalVsanDisks(ManagedObjectReference _this, String[] props) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("props", "String[]", props);
        return (String) getWsc().invoke("QueryPhysicalVsanDisks", paras, "String");
    }

    public String queryVsanObjects(ManagedObjectReference _this, String[] uuids) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("uuids", "String[]", uuids);
        return (String) getWsc().invoke("QueryVsanObjects", paras, "String");
    }

    public String queryObjectsOnPhysicalVsanDisk(ManagedObjectReference _this, String[] disks) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("disks", "String[]", disks);
        return (String) getWsc().invoke("QueryObjectsOnPhysicalVsanDisk", paras, "String");
    }

    public VsanHostDiskResult[] queryDisksForVsan(ManagedObjectReference _this, String[] canonicalName) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("canonicalName", "String[]", canonicalName);
        return (VsanHostDiskResult[]) getWsc().invoke("QueryDisksForVsan", paras, "VsanHostDiskResult[]");
    }

    public String[] abdicateDomOwnership(ManagedObjectReference _this, String[] uuids) throws RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("uuids", "String[]", uuids);
        return (String[]) getWsc().invoke("AbdicateDomOwnership", params, "Sring[]");
    }

    public ManagedObjectReference addDisks_Task(ManagedObjectReference _this, HostScsiDisk[] disk) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("disk", "HostScsiDisk[]", disk);
        return (ManagedObjectReference) getWsc().invoke("AddDisks_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference initializeDisks_Task(ManagedObjectReference _this, VsanHostDiskMapping[] mapping) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("mapping", "VsanHostDiskMapping[]", mapping);
        return (ManagedObjectReference) getWsc().invoke("InitializeDisks_Task", paras, "ManagedObjectReference");
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

    public ManagedObjectReference updateVsan_Task(ManagedObjectReference _this, VsanHostConfigInfo config) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "VsanHostConfigInfo", config);
        return (ManagedObjectReference) getWsc().invoke("UpdateVsan_Task", paras, "ManagedObjectReference");
    }

    public VsanHostClusterStatus queryHostStatus(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VsanHostClusterStatus) getWsc().invoke("QueryHostStatus", paras, "VsanHostClusterStatus");
    }

    public OptionValue[] queryOptions(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (OptionValue[]) getWsc().invoke("QueryOptions", paras, "OptionValue[]");
    }

    public void updateOptions(ManagedObjectReference _this, OptionValue[] changedValue) throws java.rmi.RemoteException, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("changedValue", "OptionValue[]", changedValue);
        getWsc().invoke("UpdateOptions", paras, null);
    }

    public ManagedObjectReference checkCompliance_Task(ManagedObjectReference _this, ManagedObjectReference[] profile, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profile", "ManagedObjectReference[]", profile);
        paras[2] = new Argument("entity", "ManagedObjectReference[]", entity);
        return (ManagedObjectReference) getWsc().invoke("CheckCompliance_Task", paras, "ManagedObjectReference");
    }

    public ComplianceResult[] queryComplianceStatus(ManagedObjectReference _this, ManagedObjectReference[] profile, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profile", "ManagedObjectReference[]", profile);
        paras[2] = new Argument("entity", "ManagedObjectReference[]", entity);
        return (ComplianceResult[]) getWsc().invoke("QueryComplianceStatus", paras, "ComplianceResult[]");
    }

    public void clearComplianceStatus(ManagedObjectReference _this, ManagedObjectReference[] profile, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profile", "ManagedObjectReference[]", profile);
        paras[2] = new Argument("entity", "ManagedObjectReference[]", entity);
        getWsc().invoke("ClearComplianceStatus", paras, null);
    }

    public ProfileExpressionMetadata[] queryExpressionMetadata(ManagedObjectReference _this, String[] expressionName, ManagedObjectReference profile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("expressionName", "String[]", expressionName);
        paras[2] = new Argument("profile", "ManagedObjectReference", profile);
        return (ProfileExpressionMetadata[]) getWsc().invoke("QueryExpressionMetadata", paras, "ProfileExpressionMetadata[]");
    }

    public ProfileDescription retrieveDescription(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ProfileDescription) getWsc().invoke("RetrieveDescription", paras, "ProfileDescription");
    }

    public void destroyProfile(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DestroyProfile", paras, null);
    }

    public void associateProfile(ManagedObjectReference _this, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        getWsc().invoke("AssociateProfile", paras, null);
    }

    public void dissociateProfile(ManagedObjectReference _this, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        getWsc().invoke("DissociateProfile", paras, null);
    }

    public ManagedObjectReference checkProfileCompliance_Task(ManagedObjectReference _this, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        return (ManagedObjectReference) getWsc().invoke("CheckProfileCompliance_Task", paras, "ManagedObjectReference");
    }

    public String exportProfile(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) getWsc().invoke("ExportProfile", paras, "String");
    }

    public ManagedObjectReference createProfile(ManagedObjectReference _this, ProfileCreateSpec createSpec) throws java.rmi.RemoteException, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("createSpec", "ProfileCreateSpec", createSpec);
        return (ManagedObjectReference) getWsc().invoke("CreateProfile", paras, "ManagedObjectReference");
    }

    public ProfilePolicyMetadata[] queryPolicyMetadata(ManagedObjectReference _this, String[] policyName, ManagedObjectReference profile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("policyName", "String[]", policyName);
        paras[2] = new Argument("profile", "ManagedObjectReference", profile);
        return (ProfilePolicyMetadata[]) getWsc().invoke("QueryPolicyMetadata", paras, "ProfilePolicyMetadata[]");
    }

    public ManagedObjectReference[] findAssociatedProfile(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        return (ManagedObjectReference[]) getWsc().invoke("FindAssociatedProfile", paras, "ManagedObjectReference[]");
    }

    public void updateClusterProfile(ManagedObjectReference _this, ClusterProfileConfigSpec config) throws java.rmi.RemoteException, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "ClusterProfileConfigSpec", config);
        getWsc().invoke("UpdateClusterProfile", paras, null);
    }

    public void updateReferenceHost(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        getWsc().invoke("UpdateReferenceHost", paras, null);
    }

    public void updateHostProfile(ManagedObjectReference _this, HostProfileConfigSpec config) throws java.rmi.RemoteException, DuplicateName, ProfileUpdateFailed, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostProfileConfigSpec", config);
        getWsc().invoke("UpdateHostProfile", paras, null);
    }

    public ProfileExecuteResult executeHostProfile(ManagedObjectReference _this, ManagedObjectReference host, ProfileDeferredPolicyOptionParameter[] deferredParam) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("deferredParam", "ProfileDeferredPolicyOptionParameter[]", deferredParam);
        return (ProfileExecuteResult) getWsc().invoke("ExecuteHostProfile", paras, "ProfileExecuteResult");
    }

    public ManagedObjectReference applyHostConfig_Task(ManagedObjectReference _this, ManagedObjectReference host, HostConfigSpec configSpec, ProfileDeferredPolicyOptionParameter[] userInput) throws java.rmi.RemoteException, InvalidState, HostConfigFailed, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("configSpec", "HostConfigSpec", configSpec);
        paras[3] = new Argument("userInput", "ProfileDeferredPolicyOptionParameter[]", userInput);
        return (ManagedObjectReference) getWsc().invoke("ApplyHostConfig_Task", paras, "ManagedObjectReference");
    }

    public HostProfileManagerConfigTaskList generateConfigTaskList(ManagedObjectReference _this, HostConfigSpec configSpec, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configSpec", "HostConfigSpec", configSpec);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (HostProfileManagerConfigTaskList) getWsc().invoke("GenerateConfigTaskList", paras, "HostProfileManagerConfigTaskList");
    }

    public ManagedObjectReference generateHostProfileTaskList_Task(ManagedObjectReference _this, HostConfigSpec configSpec, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configSpec", "HostConfigSpec", configSpec);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("GenerateHostProfileTaskList_Task", paras, "ManagedObjectReference");
    }

    public ProfileMetadata[] queryHostProfileMetadata(ManagedObjectReference _this, String[] profileName, ManagedObjectReference profile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profileName", "String[]", profileName);
        paras[2] = new Argument("profile", "ManagedObjectReference", profile);
        return (ProfileMetadata[]) getWsc().invoke("QueryHostProfileMetadata", paras, "ProfileMetadata[]");
    }

    public ProfileProfileStructure queryProfileStructure(ManagedObjectReference _this, ManagedObjectReference profile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profile", "ManagedObjectReference", profile);
        return (ProfileProfileStructure) getWsc().invoke("QueryProfileStructure", paras, "ProfileProfileStructure");
    }

    public ApplyProfile createDefaultProfile(ManagedObjectReference _this, String profileType, String profileTypeName, ManagedObjectReference profile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profileType", "String", profileType);
        paras[2] = new Argument("profileTypeName", "String", profileTypeName);
        paras[3] = new Argument("profile", "ManagedObjectReference", profile);
        return (ApplyProfile) getWsc().invoke("CreateDefaultProfile", paras, "ApplyProfile");
    }

    public ManagedObjectReference updateAnswerFile_Task(ManagedObjectReference _this, ManagedObjectReference host, AnswerFileCreateSpec configSpec) throws java.rmi.RemoteException, AnswerFileUpdateFailed, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("configSpec", "AnswerFileCreateSpec", configSpec);
        return (ManagedObjectReference) getWsc().invoke("UpdateAnswerFile_Task", paras, "ManagedObjectReference");
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

    public ManagedObjectReference exportAnswerFile_Task(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("ExportAnswerFile_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference checkAnswerFileStatus_Task(ManagedObjectReference _this, ManagedObjectReference[] host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference[]", host);
        return (ManagedObjectReference) getWsc().invoke("CheckAnswerFileStatus_Task", paras, "ManagedObjectReference");
    }

    public AnswerFileStatusResult[] queryAnswerFileStatus(ManagedObjectReference _this, ManagedObjectReference[] host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference[]", host);
        return (AnswerFileStatusResult[]) getWsc().invoke("QueryAnswerFileStatus", paras, "AnswerFileStatusResult[]");
    }

    public void removeScheduledTask(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RemoveScheduledTask", paras, null);
    }

    public void reconfigureScheduledTask(ManagedObjectReference _this, ScheduledTaskSpec spec) throws java.rmi.RemoteException, InvalidState, InvalidName, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "ScheduledTaskSpec", spec);
        getWsc().invoke("ReconfigureScheduledTask", paras, null);
    }

    public void runScheduledTask(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("RunScheduledTask", paras, null);
    }

    public ManagedObjectReference createScheduledTask(ManagedObjectReference _this, ManagedObjectReference entity, ScheduledTaskSpec spec) throws java.rmi.RemoteException, InvalidName, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("spec", "ScheduledTaskSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateScheduledTask", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference[] retrieveEntityScheduledTask(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        return (ManagedObjectReference[]) getWsc().invoke("RetrieveEntityScheduledTask", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference createObjectScheduledTask(ManagedObjectReference _this, ManagedObjectReference obj, ScheduledTaskSpec spec) throws java.rmi.RemoteException, InvalidName, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("obj", "ManagedObjectReference", obj);
        paras[2] = new Argument("spec", "ScheduledTaskSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateObjectScheduledTask", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference[] retrieveObjectScheduledTask(ManagedObjectReference _this, ManagedObjectReference obj) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("obj", "ManagedObjectReference", obj);
        return (ManagedObjectReference[]) getWsc().invoke("RetrieveObjectScheduledTask", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference[] openInventoryViewFolder(ManagedObjectReference _this, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        return (ManagedObjectReference[]) getWsc().invoke("OpenInventoryViewFolder", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference[] closeInventoryViewFolder(ManagedObjectReference _this, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        return (ManagedObjectReference[]) getWsc().invoke("CloseInventoryViewFolder", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference[] modifyListView(ManagedObjectReference _this, ManagedObjectReference[] add, ManagedObjectReference[] remove) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("add", "ManagedObjectReference[]", add);
        paras[2] = new Argument("remove", "ManagedObjectReference[]", remove);
        return (ManagedObjectReference[]) getWsc().invoke("ModifyListView", paras, "ManagedObjectReference[]");
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

    public void destroyView(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DestroyView", paras, null);
    }

    public ManagedObjectReference createInventoryView(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("CreateInventoryView", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createContainerView(ManagedObjectReference _this, ManagedObjectReference container, String[] type, boolean recursive) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("container", "ManagedObjectReference", container);
        paras[2] = new Argument("type", "String[]", type);
        paras[3] = new Argument("recursive", "boolean", recursive);
        return (ManagedObjectReference) getWsc().invoke("CreateContainerView", paras, "ManagedObjectReference");
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

    public ManagedObjectReference revertToSnapshot_Task(ManagedObjectReference _this, ManagedObjectReference host, Boolean suppressPowerOn) throws java.rmi.RemoteException, TaskInProgress, InsufficientResourcesFault, InvalidState, FileFault, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("suppressPowerOn", "Boolean", suppressPowerOn);
        return (ManagedObjectReference) getWsc().invoke("RevertToSnapshot_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference removeSnapshot_Task(ManagedObjectReference _this, boolean removeChildren, Boolean consolidate) throws java.rmi.RemoteException, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("removeChildren", "boolean", removeChildren);
        paras[2] = new Argument("consolidate", "Boolean", consolidate);
        return (ManagedObjectReference) getWsc().invoke("RemoveSnapshot_Task", paras, "ManagedObjectReference");
    }

    public void renameSnapshot(ManagedObjectReference _this, String name, String description) throws java.rmi.RemoteException, InvalidName, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("description", "String", description);
        getWsc().invoke("RenameSnapshot", paras, null);
    }

    public ManagedObjectReference exportSnapshot(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidState, FileFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("ExportSnapshot", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference checkCompatibility_Task(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference host, ManagedObjectReference pool, String[] testType) throws java.rmi.RemoteException, InvalidState, NoActiveHostInCluster, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        paras[3] = new Argument("pool", "ManagedObjectReference", pool);
        paras[4] = new Argument("testType", "String[]", testType);
        return (ManagedObjectReference) getWsc().invoke("CheckCompatibility_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference queryVMotionCompatibilityEx_Task(ManagedObjectReference _this, ManagedObjectReference[] vm, ManagedObjectReference[] host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference[]", vm);
        paras[2] = new Argument("host", "ManagedObjectReference[]", host);
        return (ManagedObjectReference) getWsc().invoke("QueryVMotionCompatibilityEx_Task", paras, "ManagedObjectReference");
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

    public ManagedObjectReference checkRelocate_Task(ManagedObjectReference _this, ManagedObjectReference vm, VirtualMachineRelocateSpec spec, String[] testType) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("spec", "VirtualMachineRelocateSpec", spec);
        paras[3] = new Argument("testType", "String[]", testType);
        return (ManagedObjectReference) getWsc().invoke("CheckRelocate_Task", paras, "ManagedObjectReference");
    }

    public void validateCredentialsInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        getWsc().invoke("ValidateCredentialsInGuest", paras, null);
    }

    public GuestAuthentication acquireCredentialsInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication requestedAuth, long sessionID) throws java.rmi.RemoteException, GuestOperationsFault, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("requestedAuth", "GuestAuthentication", requestedAuth);
        paras[3] = new Argument("sessionID", "long", sessionID);
        return (GuestAuthentication) getWsc().invoke("AcquireCredentialsInGuest", paras, "GuestAuthentication");
    }

    public void releaseCredentialsInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth) throws java.rmi.RemoteException, GuestOperationsFault, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        getWsc().invoke("ReleaseCredentialsInGuest", paras, null);
    }

    public void makeDirectoryInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String directoryPath, boolean createParentDirectories) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("directoryPath", "String", directoryPath);
        paras[4] = new Argument("createParentDirectories", "boolean", createParentDirectories);
        getWsc().invoke("MakeDirectoryInGuest", paras, null);
    }

    public void deleteFileInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String filePath) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("filePath", "String", filePath);
        getWsc().invoke("DeleteFileInGuest", paras, null);
    }

    public void deleteDirectoryInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String directoryPath, boolean recursive) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("directoryPath", "String", directoryPath);
        paras[4] = new Argument("recursive", "boolean", recursive);
        getWsc().invoke("DeleteDirectoryInGuest", paras, null);
    }

    public void moveDirectoryInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String srcDirectoryPath, String dstDirectoryPath) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("srcDirectoryPath", "String", srcDirectoryPath);
        paras[4] = new Argument("dstDirectoryPath", "String", dstDirectoryPath);
        getWsc().invoke("MoveDirectoryInGuest", paras, null);
    }

    public void moveFileInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String srcFilePath, String dstFilePath, boolean overwrite) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("srcFilePath", "String", srcFilePath);
        paras[4] = new Argument("dstFilePath", "String", dstFilePath);
        paras[5] = new Argument("overwrite", "boolean", overwrite);
        getWsc().invoke("MoveFileInGuest", paras, null);
    }

    public String createTemporaryFileInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String prefix, String suffix, String directoryPath) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("prefix", "String", prefix);
        paras[4] = new Argument("suffix", "String", suffix);
        paras[5] = new Argument("directoryPath", "String", directoryPath);
        return (String) getWsc().invoke("CreateTemporaryFileInGuest", paras, "String");
    }

    public String createTemporaryDirectoryInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String prefix, String suffix, String directoryPath) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("prefix", "String", prefix);
        paras[4] = new Argument("suffix", "String", suffix);
        paras[5] = new Argument("directoryPath", "String", directoryPath);
        return (String) getWsc().invoke("CreateTemporaryDirectoryInGuest", paras, "String");
    }

    public GuestListFileInfo listFilesInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String filePath, int index, int maxResults, String matchPattern) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
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

    public void changeFileAttributesInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String guestFilePath, GuestFileAttributes fileAttributes) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("guestFilePath", "String", guestFilePath);
        paras[4] = new Argument("fileAttributes", "GuestFileAttributes", fileAttributes);
        getWsc().invoke("ChangeFileAttributesInGuest", paras, null);
    }

    public FileTransferInformation initiateFileTransferFromGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String guestFilePath) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("guestFilePath", "String", guestFilePath);
        return (FileTransferInformation) getWsc().invoke("InitiateFileTransferFromGuest", paras, "FileTransferInformation");
    }

    public String initiateFileTransferToGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String guestFilePath, GuestFileAttributes fileAttributes, long fileSize, boolean overwrite) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
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

    public long startProgramInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, GuestProgramSpec spec) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("spec", "GuestProgramSpec", spec);
        Long ret = (Long) getWsc().invoke("StartProgramInGuest", paras, "long");
        return ret.longValue();
    }

    public GuestProcessInfo[] listProcessesInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, long[] pids) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("pids", "long[]", pids);
        return (GuestProcessInfo[]) getWsc().invoke("ListProcessesInGuest", paras, "GuestProcessInfo[]");
    }

    public void terminateProcessInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, long pid) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("pid", "long", pid);
        getWsc().invoke("TerminateProcessInGuest", paras, null);
    }

    public String[] readEnvironmentVariableInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String[] names) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("names", "String[]", names);
        return (String[]) getWsc().invoke("ReadEnvironmentVariableInGuest", paras, "String[]");
    }

    public ManagedObjectReference certMgrRefreshCACertificatesAndCRLs_Task(ManagedObjectReference _this, ManagedObjectReference[] hosts) throws RuntimeFault, SystemError, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("host", "ManagedObjectReference[]", hosts);
        return (ManagedObjectReference) getWsc().invoke("CertMgrRefreshCACertificatesAndCRLs_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference certMgrRefreshCertificates_Task(ManagedObjectReference _this, ManagedObjectReference[] hosts) throws RuntimeFault, SystemError, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("host", "ManagedObjectReference[]", hosts);
        return (ManagedObjectReference) getWsc().invoke("CertMgrRefreshCertificates_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference certMgrRevokeCertificates_Task(ManagedObjectReference _this, ManagedObjectReference[] hosts) throws RuntimeFault, SystemError, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("host", "ManagedObjectReference[]", hosts);
        return (ManagedObjectReference) getWsc().invoke("CertMgrRevokeCertificates_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference checkAddHostEvc_Task(ManagedObjectReference _this, HostConnectSpec hostConnectSpec) throws GatewayConnectFault, HostConnectFault, InvalidLogin, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("cnxSpec", "HostConnectSpec", hostConnectSpec);
        return (ManagedObjectReference) getWsc().invoke("CheckAddHostEvc_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference checkConfigureEvcMode_Task(ManagedObjectReference _this, String evcModeKey) throws RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("evcModeKey", "String", evcModeKey);
        return (ManagedObjectReference) getWsc().invoke("CheckConfigureEvcMode_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference configureEvcMode_Task(ManagedObjectReference _this, String evcModeKey) throws RuntimeFault, RemoteException, EVCConfigFault {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("evcModeKey", "String", evcModeKey);
        return (ManagedObjectReference) getWsc().invoke("ConfigureEvcMode_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference disableEvcMode_Task(ManagedObjectReference _this) throws RemoteException, RuntimeFault {
        Argument[] params = new Argument[1];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("DisableEvcMode_Task", params, "ManagedObjectReference");
    }

    public void addGuestAlias(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication guestAuthentication,
                              String userName, boolean mapCert, String base64Cert, GuestAuthAliasInfo guestAuthAliasInfo)
        throws GuestComponentsOutOfDate, GuestMultipleMappings, GuestOperationsFault, GuestOperationsUnavailable,
        GuestPermissionDenied, InvalidArgument, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest,
        OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
        Argument[] params = new Argument[7];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vm", "ManagedObjectReference", vm);
        params[2] = new Argument("auth", "GuestAuthentication", guestAuthentication);
        params[3] = new Argument("username", "String", userName);
        params[4] = new Argument("mapCert", "boolean", mapCert);
        params[5] = new Argument("base64Cert", "String", base64Cert);
        params[6] = new Argument("aliasInfo", "GuestAuthAliasInfo", guestAuthAliasInfo);
        getWsc().invoke("AddGuestAlias", params, null);
    }

    public GuestAliases[] listGuestAliases(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String userName) throws RemoteException {
        Argument[] params = new Argument[4];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vm", "ManagedObjectReference", vm);
        params[2] = new Argument("auth", "GuestAuthentication", auth);
        params[3] = new Argument("username", "String", userName);
        return (GuestAliases[]) getWsc().invoke("ListGuestAliases", params, "GuestAliases[]");
    }


    public GuestMappedAliases[] listGuestMappedAliases(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth) throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable,
        GuestPermissionDenied, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest,
        RuntimeFault, TaskInProgress, RemoteException {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vm", "ManagedObjectReference", vm);
        params[2] = new Argument("auth", "GuestAuthentication", auth);
        return (GuestMappedAliases[]) getWsc().invoke("ListGuestMappedAliases", params, "GuestMappedAliases[]");
    }

    public void removeGuestAlias(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String userName, String base64Cert, GuestAuthSubject subject) throws GuestComponentsOutOfDate, GuestOperationsFault,
        GuestOperationsUnavailable, GuestPermissionDenied, InvalidArgument, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest,
        RuntimeFault, TaskInProgress, RemoteException {
        Argument[] params = new Argument[6];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vm", "ManagedObjectReference", vm);
        params[2] = new Argument("auth", "GuestAuthentication", auth);
        params[3] = new Argument("username", "String", userName);
        params[4] = new Argument("base64Cert", "String", base64Cert);
        params[5] = new Argument("subject", "GuestAuthSubject", subject);
        getWsc().invoke("RemoveGuestAlias", params, null);
    }

    public void removeGuestAliasByCert(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String userName, String base64Cert) throws GuestComponentsOutOfDate, GuestOperationsFault,
        GuestOperationsUnavailable, GuestPermissionDenied, InvalidArgument, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest,
        RuntimeFault, TaskInProgress, RemoteException {
        Argument[] params = new Argument[5];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vm", "ManagedObjectReference", vm);
        params[2] = new Argument("auth", "GuestAuthentication", auth);
        params[3] = new Argument("username", "String", userName);
        params[4] = new Argument("base64Cert", "String", base64Cert);
        getWsc().invoke("RemoveGuestAliasByCert", params, null);
    }

    public void createRegistryKeyInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean isVolatile, String classType) throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable,
        GuestPermissionDenied, GuestRegistryKeyAlreadyExists, GuestRegistryKeyInvalid, GuestRegistryKeyParentVolatile, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
        Argument[] params = new Argument[6];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vm", "ManagedObjectReference", vm);
        params[2] = new Argument("auth", "GuestAuthentication", auth);
        params[3] = new Argument("keyName", "GuestRegKeyNameSpec", keyName);
        params[4] = new Argument("isVolatile", "boolean", isVolatile);
        params[5] = new Argument("classType", "String", classType);
        getWsc().invoke("CreateRegistryKeyInGuest", params, null);
    }

    public void deleteRegistryKeyInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean recursive) throws GuestComponentsOutOfDate, GuestOperationsFault,
        GuestOperationsUnavailable, GuestPermissionDenied, GuestRegistryKeyHasSubkeys, GuestRegistryKeyInvalid, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest,
        OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
        Argument[] params = new Argument[5];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vm", "ManagedObjectReference", vm);
        params[2] = new Argument("auth", "GuestAuthentication", auth);
        params[3] = new Argument("keyName", "GuestRegKeyNameSpec", keyName);
        params[4] = new Argument("recursive", "boolean", recursive);
        getWsc().invoke("DeleteRegistryKeyInGuest", params, null);
    }

    public void deleteRegistryValueInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, GuestRegValueNameSpec valueName) throws GuestComponentsOutOfDate, GuestOperationsFault,
        GuestOperationsUnavailable, GuestPermissionDenied, GuestRegistryKeyInvalid, GuestRegistryValueNotFound, InvalidGuestLogin, InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest,
        RuntimeFault, TaskInProgress, RemoteException {
        Argument[] params = new Argument[4];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vm", "ManagedObjectReference", vm);
        params[2] = new Argument("auth", "GuestAuthentication", auth);
        params[3] = new Argument("valueName", "GuestRegValueNameSpec", valueName);
        getWsc().invoke("DeleteRegistryValueInGuest", params, null);
    }

    public GuestRegKeyRecordSpec[] listRegistryKeysInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean recursive, String matchPattern)
        throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable, GuestPermissionDenied, GuestRegistryKeyInvalid, InvalidGuestLogin, InvalidPowerState,
        InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
        Argument[] params = new Argument[6];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vm", "ManagedObjectReference", vm);
        params[2] = new Argument("auth", "GuestAuthentication", auth);
        params[3] = new Argument("keyName", "GuestRegKeyNameSpec", keyName);
        params[4] = new Argument("recursive", "boolean", recursive);
        params[5] = new Argument("matchPattern", "String", matchPattern);
        return (GuestRegKeyRecordSpec[]) getWsc().invoke("ListRegistryKeysInGuest", params, "GuestRegKeyRecordSpec[]");
    }

    public GuestRegValueSpec[] listRegistryValuesInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, GuestRegKeyNameSpec keyName, boolean expandStrings, String matchPattern) throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable, GuestPermissionDenied, GuestRegistryKeyInvalid, InvalidGuestLogin, InvalidPowerState,
        InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
        Argument[] params = new Argument[6];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vm", "ManagedObjectReference", vm);
        params[2] = new Argument("auth", "GuestAuthentication", auth);
        params[3] = new Argument("keyName", "GuestRegKeyNameSpec", keyName);
        params[4] = new Argument("expandStrings", "boolean", expandStrings);
        params[5] = new Argument("matchPattern", "String", matchPattern);
        return (GuestRegValueSpec[]) getWsc().invoke("ListRegistryValuesInGuest", params, "GuestRegValueSpec[]");
    }

    public void setRegistryValueInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, GuestRegValueSpec value)
        throws GuestComponentsOutOfDate, GuestOperationsFault, GuestOperationsUnavailable, GuestPermissionDenied, GuestRegistryKeyInvalid, InvalidGuestLogin,
        InvalidPowerState, InvalidState, OperationDisabledByGuest, OperationNotSupportedByGuest, RuntimeFault, TaskInProgress, RemoteException {
        Argument[] params = new Argument[4];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vm", "ManagedObjectReference", vm);
        params[2] = new Argument("auth", "GuestAuthentication", auth);
        params[3] = new Argument("value", "GuestRegValueSpec", value);
        getWsc().invoke("SetRegistryValueInGuest", params, null);
    }

    public VsanPolicySatisfiability[] canProvisionObjects(ManagedObjectReference _this, VsanNewPolicyBatch[] npbs, Boolean ignoreSatisfiability) throws VimFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("npbs", "VsanNewPolicyBatch[]", npbs);
        params[2] = new Argument("ignoreSatisfiability", "Boolean", ignoreSatisfiability);
        return (VsanPolicySatisfiability[]) getWsc().invoke("CanProvisionObjects", params, "VsanPolicySatisfiability[]");
    }

    public HostVsanInternalSystemDeleteVsanObjectsResult[] deleteVsanObjects(ManagedObjectReference _this, String[] uuids, Boolean force) throws VimFault, RemoteException, RuntimeFault {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("uuids", "String[]", uuids);
        params[2] = new Argument("force", "Boolean", force);
        return (HostVsanInternalSystemDeleteVsanObjectsResult[]) getWsc().invoke("DeleteVsanObjects", params, "HostVsanInternalSystemDeleteVsanObjectsResult[]");
    }

    public String getVsanObjExtAttrs(ManagedObjectReference _this, String[] uuids) throws RuntimeFault, VimFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("uuids", "String[]", uuids);
        return (String) getWsc().invoke("GetVsanObjExtAttrs", params, "String");
    }

    public String querySyncingVsanObjects(ManagedObjectReference _this, String[] uuids) throws RemoteException, RuntimeFault {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("uuids", "String[]", uuids);
        return (String) getWsc().invoke("QuerySyncingVsanObjects", params, "String");
    }

    public String[] queryVsanObjectUuidsByFilter(ManagedObjectReference _this, String[] uuids, int limit, int version) throws RuntimeFault, VsanFault, RemoteException {
        Argument[] params = new Argument[4];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("uuids", "String[]", uuids);
        params[2] = new Argument("limit", "int", limit);
        params[3] = new Argument("version", "int", version);
        return (String[]) getWsc().invoke("QueryVsanObjectUuidsByFilter", params, "String[]");
    }

    public String queryVsanStatistics(ManagedObjectReference _this, String[] labels) throws RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("labels", "String[]", labels);
        return (String) getWsc().invoke("QueryVsanStatistics", params, "String");
    }

    public VsanPolicySatisfiability[] reconfigurationSatisfiable(ManagedObjectReference _this, VsanPolicyChangeBatch[] pcbs, Boolean ignoreSatisfiability) throws RuntimeFault, VimFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("ignoreSatisfiability", "Boolean", ignoreSatisfiability);
        return (VsanPolicySatisfiability[]) getWsc().invoke("ReconfigurationSatisfiable", params, "VsanPolicySatisfiability[]");
    }

    public void reconfigureDomObject(ManagedObjectReference _this, String uuid, String policy) throws RemoteException, RuntimeFault {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("uuid", "String", uuid);
        params[2] = new Argument("policy", "String", policy);
        getWsc().invoke("ReconfigureDomObject", params, null);
    }

    public HostVsanInternalSystemVsanPhysicalDiskDiagnosticsResult[] runVsanPhysicalDiskDiagnostics(ManagedObjectReference _this, String[] disks) throws RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("disks", "String[]", disks);
        return (HostVsanInternalSystemVsanPhysicalDiskDiagnosticsResult[]) getWsc().invoke("RunVsanPhysicalDiskDiagnostics", params, "HostVsanInternalSystemVsanPhysicalDiskDiagnosticsResult[]");
    }

    public HostVsanInternalSystemVsanObjectOperationResult[] upgradeVsanObjects(ManagedObjectReference _this, String[] uuids, int newVersion) throws RuntimeFault, VsanFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("uuids", "String[]", uuids);
        params[2] = new Argument("newVersion", "int", newVersion);
        return (HostVsanInternalSystemVsanObjectOperationResult[]) getWsc().invoke("UpgradeVsanObjects", params, "HostVsanInternalSystemVsanObjectOperationResult[]");
    }

    public void changeAccessMode(ManagedObjectReference _this, String principal, boolean isGroup, HostAccessMode accessMode) throws AuthMinimumAdminPermission, InvalidArgument, RuntimeFault, SecurityError, UserNotFound, RemoteException {
        Argument[] params = new Argument[4];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("principal", "String", principal);
        params[2] = new Argument("isGroup", "boolean", isGroup);
        params[3] = new Argument("accessMode", "HostAccessMode", accessMode);
        getWsc().invoke("ChangeAccessMode", params, null);
    }

    public void changeHostLockdownMode(ManagedObjectReference _this, HostLockdownMode mode) throws AuthMinimumAdminPermission, NoPermission, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("mode", "HostLockdownMode", mode);
        getWsc().invoke("ChangeHostLockdownMode", params, null);
    }

    public String[] queryLockdownExceptions(ManagedObjectReference _this) throws RuntimeFault, RemoteException {
        Argument[] params = new Argument[1];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String[]) getWsc().invoke("QueryLockdownExceptions", params, "String[]");
    }

    public String[] querySystemUsers(ManagedObjectReference _this) throws RuntimeFault, RemoteException {
        Argument[] params = new Argument[1];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String[]) getWsc().invoke("QuerySystemUsers", params, "String[]");
    }

    public HostAccessControlEntry[] retrieveHostAccessControlEntries(ManagedObjectReference _this) throws RuntimeFault, RemoteException {
        Argument[] params = new Argument[1];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostAccessControlEntry[]) getWsc().invoke("RetrieveHostAccessControlEntries", params, "HostAccessControlEntry[]");
    }

    public void updateLockdownExceptions(ManagedObjectReference _this, String[] users) throws AuthMinimumAdminPermission, RemoteException, RuntimeFault, UserNotFound {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("users", "String[]", users);
        getWsc().invoke("UpdateLockdownExceptions", params, null);
    }

    public void updateSystemUsers(ManagedObjectReference _this, String[] users) throws InvalidArgument, RemoteException, RuntimeFault, UserNotFound {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("users", "String[]", users);
        getWsc().invoke("UpdateSystemUsers", params, null);
    }

    public String generateCertificateSigningRequest(ManagedObjectReference _this, boolean useIpAddressAsCommonName) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("useIpAddressAsCommonName", "boolean", useIpAddressAsCommonName);
        return (String) getWsc().invoke("GenerateCertificateSigningRequest", params, "String");
    }

    public String generateCertificateSigningRequestByDn(ManagedObjectReference _this, String distinguishedName) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("distinguishedName", "String", distinguishedName);
        return (String) getWsc().invoke("GenerateCertificateSigningRequestByDn", params, "String");
    }

    public void installServerCertificate(ManagedObjectReference _this, String cert) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("cert", "String", cert);
        getWsc().invoke("InstallServerCertificate", params, null);
    }

    public String[] listCACertificateRevocationLists(ManagedObjectReference _this) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[1];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String[]) getWsc().invoke("ListCACertificateRevocationLists", params, "String[]");
    }

    public String[] listCACertificates(ManagedObjectReference _this) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[1];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String[]) getWsc().invoke("ListCACertificates", params, "String[]");
    }

    public void replaceCACertificatesAndCRLs(ManagedObjectReference _this, String[] caCert, String[] caCrl) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("caCert", "String[]", caCert);
        params[2] = new Argument("caCrl", "String[]", caCrl);
        getWsc().invoke("ReplaceCACertificatesAndCRLs", params, null);
    }

    public long lookupVmOverheadMemory(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference host) throws InvalidArgument, InvalidType, ManagedObjectNotFound, NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vm", "ManagedObjectReference", vm);
        params[2] = new Argument("host", "ManagedObjectReference", host);
        Long ret = (Long) getWsc().invoke("LookupVmOverheadMemory", params, "long");
        return ret.longValue();
    }

    public ManagedObjectReference performVsanUpgrade_Task(ManagedObjectReference _this, ManagedObjectReference cluster, Boolean performObjectUpgrade,
                                                          Boolean downgradeFormat, Boolean allowReducedRedundancy, ManagedObjectReference[] excludeHosts)
        throws RuntimeFault, VsanFault, RemoteException {
        Argument[] params = new Argument[6];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("cluster", "ManagedObjectReference", cluster);
        params[2] = new Argument("performObjectUpgrade", "Boolean", performObjectUpgrade);
        params[3] = new Argument("downgradeFormat", "Boolean", downgradeFormat);
        params[4] = new Argument("allowReducedRedundancy", "Boolean", allowReducedRedundancy);
        params[5] = new Argument("excludeHosts", "ManagedObjectReference[]", excludeHosts);
        return (ManagedObjectReference) getWsc().invoke("PerformVsanUpgrade_Task", params, "ManagedObjectReference");
    }

    public VsanUpgradeSystemPreflightCheckResult performVsanUpgradePreflightCheck(ManagedObjectReference _this, ManagedObjectReference cluster, Boolean downgradeFormat) throws RemoteException, RuntimeFault, VsanFault {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("cluster", "ManagedObjectReference", cluster);
        params[2] = new Argument("downgradeFormat", "Boolean", downgradeFormat);
        return (VsanUpgradeSystemPreflightCheckResult) getWsc().invoke("PerformVsanUpgradePreflightCheck", params, "VsanUpgradeSystemPreflightCheckResult");
    }

    public VsanUpgradeSystemUpgradeStatus queryVsanUpgradeStatus(ManagedObjectReference _this, ManagedObjectReference cluster) throws RuntimeFault, VsanFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("cluster", "ManagedObjectReference", cluster);
        return (VsanUpgradeSystemUpgradeStatus) getWsc().invoke("QueryVsanUpgradeStatus", params, "VsanUpgradeSystemUpgradeStatus");
    }

    public String createVRP(ManagedObjectReference _this, VirtualResourcePoolSpec spec) throws InsufficientResourcesFault, InvalidState, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("spec", "VirtualResourcePoolSpec", spec);
        return (String) getWsc().invoke("CreateVRP", params, "String");
    }

    public void deleteVRP(ManagedObjectReference _this, String vrpId) throws InvalidState, NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vrpId", "String", vrpId);
        getWsc().invoke("DeleteVRP", params, null);
    }

    public void deployVM(ManagedObjectReference _this, String vrpId, ManagedObjectReference vm, ManagedObjectReference cluster) throws InsufficientResourcesFault, InvalidState, NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[4];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vrpId", "String", vrpId);
        params[2] = new Argument("vm", "ManagedObjectReference", vm);
        params[3] = new Argument("cluster", "ManagedObjectReference", cluster);
        getWsc().invoke("DeployVM", params, null);
    }

    public String[] getAllVRPIds(ManagedObjectReference _this) throws InvalidState, RuntimeFault, RemoteException {
        Argument[] params = new Argument[1];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String[]) getWsc().invoke("GetAllVRPIds", params, "String[]");
    }

    public ManagedObjectReference getChildRPforHub(ManagedObjectReference _this, String vrpId, ManagedObjectReference hub) throws InvalidState, RuntimeFault, NotFound, RemoteException {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vrpId", "String", vrpId);
        params[2] = new Argument("hub", "ManagedObjectreference", hub);
        return (ManagedObjectReference) getWsc().invoke("GetChildRPforHub", params, "ManagedObjectReference");
    }

    public ResourceConfigSpec getRPSettings(ManagedObjectReference _this, ManagedObjectReference resourcePool) throws NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("resourcePool", "ManagedObjectReference", resourcePool);
        return (ResourceConfigSpec) getWsc().invoke("GetRPSettings", params, "ResourceConfigSpec");
    }

    public String getVRPofVM(ManagedObjectReference _this, ManagedObjectReference vm) throws InvalidState, NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vm", "ManagedObjectReference", vm);
        return (String) getWsc().invoke("GetVRPofVM", params, "String");
    }

    public VirtualResourcePoolSpec getVRPSettings(ManagedObjectReference _this, String vrpId) throws InvalidState, NotFound, RuntimeException, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vrpId", "String", vrpId);
        return (VirtualResourcePoolSpec) getWsc().invoke("GetVRPSettings", params, "VirtualResourcePoolSpec");
    }

    public VirtualResourcePoolUsage getVRPUsage(ManagedObjectReference _this, String vrpId) throws InvalidState, NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vm", "ManagedObjectReference", vrpId);
        return (VirtualResourcePoolUsage) getWsc().invoke("GetVRPofVM", params, "VirtualResourcePoolUsage");
    }

    public void setManagedByVDC(ManagedObjectReference _this, ManagedObjectReference cluster, boolean status) throws InvalidState, NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("cluster", "ManagedObjectReference", cluster);
        params[2] = new Argument("status", "boolean", status);
        getWsc().invoke("SetManagedByVDC", params, null);
    }

    public void undeployVM(ManagedObjectReference _this, String vrpId, ManagedObjectReference vm, ManagedObjectReference cluster) throws InvalidState, NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[4];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vrpId", "String", vrpId);
        params[2] = new Argument("vm", "ManagedObjectReference", vm);
        params[3] = new Argument("cluster", "ManagedObjectReference", cluster);
        getWsc().invoke("UndeployVM", params, null);
    }

    public void updateVRP(ManagedObjectReference _this, VRPEditSpec spec) throws InvalidState, NotFound, RuntimeFault, RemoteException, InsufficientResourcesFault {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("spec", "VRPEditSpec", spec);
        getWsc().invoke("UpdateVRP", params, null);
    }

    public ManagedObjectReference evcManager(ManagedObjectReference _this) throws RuntimeFault, RemoteException {
        Argument[] params = new Argument[1];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("EvcManager", params, "ManagedObjectReference");
    }

    public ClusterRuleInfo[] findRulesForVm(ManagedObjectReference _this, ManagedObjectReference vm) throws RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vm", "ManagedObjectReference", vm);
        return (ClusterRuleInfo[]) getWsc().invoke("FindRulesForVm", params, "ClusterRuleInfo[]");
    }

    public ClusterResourceUsageSummary getResourceUsage(ManagedObjectReference _this) throws RuntimeFault, RemoteException {
        Argument[] params = new Argument[1];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ClusterResourceUsageSummary) getWsc().invoke("GetResourceUsage", params, "ClusterResourceUsageSummary");
    }

    public PlacementResult placeVm(ManagedObjectReference _this, PlacementSpec placementSpec) throws InvalidArgument, InvalidState, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("placementSpec", "PlacementSpec", placementSpec);
        return (PlacementResult) getWsc().invoke("PlaceVm", params, "PlacementResult");
    }

    public ManagedObjectReference stampAllRulesWithUuid_Task(ManagedObjectReference _this) throws RuntimeFault, RemoteException {
        Argument[] params = new Argument[1];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("StampAllRulesWithUuid_Task", params, "ManagedObjectReference");
    }

    public HostConnectInfo queryConnectionInfoViaSpec(ManagedObjectReference _this, HostConnectSpec spec) throws GatewayConnectFault, GatewayHostNotReachable, GatewayNotFound, GatewayNotReachable, GatewayOperationRefused, GatewayToHostAuthFault, GatewayToHostTrustVerifyFault, HostConnectFault, InvalidArgument, InvalidLogin, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("spec", "HostConnectSpec", spec);
        return (HostConnectInfo) getWsc().invoke("QueryConnectionInfoViaSpec", params, "HostConnectInfo");
    }

    public ManagedObjectReference dvsReconfigureVmVnicNetworkResourcePool_Task(ManagedObjectReference _this, DvsVmVnicResourcePoolConfigSpec[] configSpec) throws ConcurrentAccess, ConflictingConfiguration, DvsFault, DvsNotAuthorized, InvalidName, NotFound, NotSupported, ResourceInUse, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("configSpec", "DvsVmVnicResourcePoolConfigSpec[]", configSpec);
        return (ManagedObjectReference) getWsc().invoke("DvsReconfigureVmVnicNetworkResourcePool_Task", params, "ManagedObjectReference");
    }

    public VirtualMachineConfigOption queryConfigOptionEx(ManagedObjectReference _this, EnvironmentBrowserConfigOptionQuerySpec spec) throws InvalidArgument, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("spec", "EnvironmentBrowserConfigOptionQuerySpec", spec);
        return (VirtualMachineConfigOption) getWsc().invoke("QueryConfigOptionEx", params, "VirtualMachineConfigOption");
    }

    public void importUnmanagedSnapshot(ManagedObjectReference _this, String vdisk, ManagedObjectReference datacenter, String vvolId) throws InvalidDatastore, NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[4];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vdisk", "String", vdisk);
        params[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        params[3] = new Argument("vvolId", "String", vvolId);
        getWsc().invoke("ImportUnmanagedSnapshot", params, null);
    }

    public ManagedObjectReference createVvolDatastore(ManagedObjectReference _this, HostDatastoreSystemVvolDatastoreSpec spec) throws DuplicateName, HostConfigFault, InvalidName, NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("spec", "HostDatastoreSystemVvolDatastoreSpec", spec);
        return (ManagedObjectReference) getWsc().invoke("CreateVvolDatastore", params, "ManagedObjectReference");
    }

    public ManagedObjectReference removeDatastoreEx_Task(ManagedObjectReference _this, ManagedObjectReference[] datastore) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("datastore", "ManagedObjectReference[]", datastore);
        return (ManagedObjectReference) getWsc().invoke("RemoveDatastoreEx_Task", params, "ManagedObjectReference");
    }

    public void sendNMI(ManagedObjectReference _this) throws InvalidState, RuntimeFault, RemoteException {
        Argument[] params = new Argument[1];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("SendNMI", params, null);
    }

    public ManagedObjectReference evacuateVsanNode_Task(ManagedObjectReference _this, HostMaintenanceSpec maintenanceSpec, int timeout) throws InvalidState, RequestCanceled, RuntimeFault, Timedout, VsanFault, RemoteException {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("maintenanceSpec", "HostMaintenanceSpec", maintenanceSpec);
        params[2] = new Argument("timeout", "int", timeout);
        return (ManagedObjectReference) getWsc().invoke("EvacuateVsanNode_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference recommissionVsanNode_Task(ManagedObjectReference _this) throws InvalidState, RuntimeFault, VsanFault, RemoteException {
        Argument[] params = new Argument[1];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) getWsc().invoke("RecommissionVsanNode_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference unmountDiskMapping_Task(ManagedObjectReference _this, VsanHostDiskMapping[] mapping) throws InvalidState, RuntimeFault, VsanFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("mapping", "VsanHostDiskMapping[]", mapping);
        return (ManagedObjectReference) getWsc().invoke("UnmountDiskMapping_Task", params, "ManagedObjectReference");
    }

    public void disableSmartCardAuthentication(ManagedObjectReference _this) throws ActiveDirectoryFault, HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[1];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("DisableSmartCardAuthentication", params, null);
    }

    public void enableSmartCardAuthentication(ManagedObjectReference _this) throws ActiveDirectoryFault, HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[1];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("EnbleSmartCardAuthentication", params, null);
    }

    public void installSmartCardTrustAnchor(ManagedObjectReference _this, String cert) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("cert", "String", cert);
        getWsc().invoke("InstallSmartCardTrustAnchor", params, null);
    }

    public String[] listSmartCardTrustAnchors(ManagedObjectReference _this) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[1];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String[]) getWsc().invoke("ListSmartCardTrustAnchors", params, "String[]");
    }

    public void removeSmartCardTrustAnchor(ManagedObjectReference _this, String issuer, String serial) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("issuer", "String", issuer);
        params[2] = new Argument("serial", "String", serial);
        getWsc().invoke("RemoveSmartCardTrustAnchor", params, null);
    }

    public void removeSmartCardTrustAnchorByFingerprint(ManagedObjectReference _this, String fingerprint, String digest) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("fingerprint", "String", fingerprint);
        params[2] = new Argument("digest", "String", digest);
        getWsc().invoke("RemoveSmartCardTrustAnchorByFingerprint", params, null);
    }

    public void replaceSmartCardTrustAnchors(ManagedObjectReference _this, String[] certs) throws RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("certs", "String[]", certs);
        getWsc().invoke("ReplaceSmartCardTrustAnchors", params, null);
    }

    public ManagedObjectReference attachScsiLunEx_Task(ManagedObjectReference _this, String[] lunUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("lunUuid", "String[]", lunUuid);
        return (ManagedObjectReference) getWsc().invoke("AttachScsiLunEx_Task", params, "ManagedObjectReference");
    }

    public void changeNFSUserPassword(ManagedObjectReference _this, String password) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("password", "String", password);
        getWsc().invoke("ChangeNFSUserPassword", params, null);
    }

    public void clearNFSUser(ManagedObjectReference _this) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[1];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        getWsc().invoke("ClearNFSUser", params, null);
    }

    public ManagedObjectReference detachScsiLunEx_Task(ManagedObjectReference _this, String[] lunUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("lunUuid", "String[]", lunUuid);
        return (ManagedObjectReference) getWsc().invoke("DetachScsiLunEx_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference markAsLocal_Task(ManagedObjectReference _this, String scsiDiskUuid) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("scsiDiskUuid", "String", scsiDiskUuid);
        return (ManagedObjectReference) getWsc().invoke("MarkAsLocal_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference markAsNonLocal_Task(ManagedObjectReference _this, String scsiDiskUuid) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("scsiDiskUuid", "String", scsiDiskUuid);
        return (ManagedObjectReference) getWsc().invoke("MarkAsNonLocal_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference markAsNonSsd_Task(ManagedObjectReference _this, String scsiDiskUuid) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("scsiDiskUuid", "String", scsiDiskUuid);
        return (ManagedObjectReference) getWsc().invoke("MarkAsNonSsd_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference markAsSsd_Task(ManagedObjectReference _this, String scsiDiskUuid) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("scsiDiskUuid", "String", scsiDiskUuid);
        return (ManagedObjectReference) getWsc().invoke("MarkAsSsd_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference mountVmfsVolumeEx_Task(ManagedObjectReference _this, String[] vmfsUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vmfsUuid", "String[]", vmfsUuid);
        return (ManagedObjectReference) getWsc().invoke("MountVmfsVolumeEx_Task", params, "ManagedObjectReference");
    }

    public HostNasVolumeUserInfo queryNFSUser(ManagedObjectReference _this) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[1];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostNasVolumeUserInfo) getWsc().invoke("QueryNFSUser", params, "HostNasVolumeUserInfo");
    }

    public void setNFSUser(ManagedObjectReference _this, String user, String password) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("user", "String", user);
        params[2] = new Argument("password", "String", password);
        getWsc().invoke("SetNFSUser", params, null);
    }

    public ManagedObjectReference turnDiskLocatorLedOff_Task(ManagedObjectReference _this, String[] scsiDiskUuids) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("scsiDiskUuids", "String[]", scsiDiskUuids);
        return (ManagedObjectReference) getWsc().invoke("TurnDiskLocatorLedOff_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference turnDiskLocatorLedOn_Task(ManagedObjectReference _this, String[] scsiDiskUuids) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("scsiDiskUuids", "String[]", scsiDiskUuids);
        return (ManagedObjectReference) getWsc().invoke("TurnDiskLocatorLedOn_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference unmapVmfsVolumeEx_Task(ManagedObjectReference _this, String[] vmfsUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vmfsUuid", "String[]", vmfsUuid);
        return (ManagedObjectReference) getWsc().invoke("UnmapVmfsVolumeEx_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference unmountVmfsVolumeEx_Task(ManagedObjectReference _this, String[] vmfsUuid) throws HostConfigFault, RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vmfsUuid", "String[]", vmfsUuid);
        return (ManagedObjectReference) getWsc().invoke("UnmountVmfsVolumeEx_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference installIoFilter_Task(ManagedObjectReference _this, String vibUrl, ManagedObjectReference compRes) throws AlreadyExists, InvalidArgument, RuntimeFault, RemoteException {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("vibUrl", "String", vibUrl);
        params[2] = new Argument("compRes", "ManagedObjectReference", compRes);
        return (ManagedObjectReference) getWsc().invoke("InstallIoFilter_Task", params, "ManagedObjectReference");
    }

    public VirtualDiskId[] queryDisksUsingFilter(ManagedObjectReference _this, String filterId, ManagedObjectReference compRes) throws NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("filterId", "String", filterId);
        params[2] = new Argument("compRes", "ManagedObjectReference", compRes);
        return (VirtualDiskId[]) getWsc().invoke("QueryDisksUsingFilter", params, "VirtualDiskId[]");
    }

    public ClusterIoFilterInfo[] queryIoFilterInfo(ManagedObjectReference _this, ManagedObjectReference compRes) throws RuntimeFault, RemoteException {
        Argument[] params = new Argument[2];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("compRes", "ManagedObjectReference", compRes);
        return (ClusterIoFilterInfo[]) getWsc().invoke("QueryIoFilterInfo", params, "ClusterIoFilterInfo[]");
    }

    public IoFilterQueryIssueResult queryIoFilterIssues(ManagedObjectReference _this, String filterId, ManagedObjectReference compRes) throws NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("filterId", "String", filterId);
        params[2] = new Argument("compRes", "ManagedObjectReference", compRes);
        return (IoFilterQueryIssueResult) getWsc().invoke("QueryIoFilterIssues", params, "IoFilterQueryIssueResult");
    }

    public ManagedObjectReference resolveInstallationErrorsOnCluster_Task(ManagedObjectReference _this, String filterId, ManagedObjectReference cluster) throws NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("filterId", "String", filterId);
        params[2] = new Argument("cluster", "ManagedObjectReference", cluster);
        return (ManagedObjectReference) getWsc().invoke("ResolveInstallationErrorsOnCluster_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference resolveInstallationErrorsOnHost_Task(ManagedObjectReference _this, String filterId, ManagedObjectReference host) throws NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("filterId", "String", filterId);
        params[2] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) getWsc().invoke("ResolveInstallationErrorsOnHost_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference uninstallIoFilter_Task(ManagedObjectReference _this, String filterId, ManagedObjectReference compRes) throws FilterInUse, InvalidArgument, InvalidState, NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[3];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("filterId", "String", filterId);
        params[2] = new Argument("compRes", "ManagedObjectReference", compRes);
        return (ManagedObjectReference) getWsc().invoke("UninstallIoFilter_Task", params, "ManagedObjectReference");
    }

    public ManagedObjectReference upgradeIoFilter_Task(ManagedObjectReference _this, String filterId, ManagedObjectReference compRes, String vibUrl) throws InvalidArgument, InvalidState, NotFound, RuntimeFault, RemoteException {
        Argument[] params = new Argument[4];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("filterId", "String", filterId);
        params[2] = new Argument("compRes", "ManagedObjectReference", compRes);
        params[3] = new Argument("vibUrl", "String", vibUrl);
        return (ManagedObjectReference) getWsc().invoke("UpgradeIoFilter_Task", params, "ManagedObjectReference");
    }
}
