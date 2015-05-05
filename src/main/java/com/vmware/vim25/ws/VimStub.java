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

    public VimStub(String url, boolean ignoreCert) throws java.net.MalformedURLException {
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

    public VimStub(Client wsc) {
        this.wsc = wsc;
    }

    public Client getWsc() {
        return wsc;
    }

    public void destroyPropertyFilter(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("DestroyPropertyFilter", paras, null);
    }

    public ManagedObjectReference createFilter(ManagedObjectReference _this, PropertyFilterSpec spec, boolean partialUpdates) throws java.rmi.RemoteException, InvalidProperty, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "PropertyFilterSpec", spec);
        paras[2] = new Argument("partialUpdates", "boolean", partialUpdates);
        return (ManagedObjectReference) wsc.invoke("CreateFilter", paras, "ManagedObjectReference");
    }

    public ObjectContent[] retrieveProperties(ManagedObjectReference _this, PropertyFilterSpec[] specSet) throws java.rmi.RemoteException, InvalidProperty, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("specSet", "PropertyFilterSpec[]", specSet);
        return (ObjectContent[]) wsc.invoke("RetrieveProperties", paras, "ObjectContent[]");
    }

    public UpdateSet checkForUpdates(ManagedObjectReference _this, String version) throws java.rmi.RemoteException, InvalidCollectorVersion, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("version", "String", version);
        return (UpdateSet) wsc.invoke("CheckForUpdates", paras, "UpdateSet");
    }

    public UpdateSet waitForUpdates(ManagedObjectReference _this, String version) throws java.rmi.RemoteException, InvalidCollectorVersion, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("version", "String", version);
        return (UpdateSet) wsc.invoke("WaitForUpdates", paras, "UpdateSet");
    }

    public void cancelWaitForUpdates(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("CancelWaitForUpdates", paras, null);
    }

    public UpdateSet waitForUpdatesEx(ManagedObjectReference _this, String version, WaitOptions options) throws java.rmi.RemoteException, InvalidCollectorVersion, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("version", "String", version);
        paras[2] = new Argument("options", "WaitOptions", options);
        return (UpdateSet) wsc.invoke("WaitForUpdatesEx", paras, "UpdateSet");
    }

    public RetrieveResult retrievePropertiesEx(ManagedObjectReference _this, PropertyFilterSpec[] specSet, RetrieveOptions options) throws java.rmi.RemoteException, InvalidProperty, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("specSet", "PropertyFilterSpec[]", specSet);
        paras[2] = new Argument("options", "RetrieveOptions", options);
        return (RetrieveResult) wsc.invoke("RetrievePropertiesEx", paras, "RetrieveResult");
    }

    public RetrieveResult continueRetrievePropertiesEx(ManagedObjectReference _this, String token) throws java.rmi.RemoteException, InvalidProperty, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("token", "String", token);
        return (RetrieveResult) wsc.invoke("ContinueRetrievePropertiesEx", paras, "RetrieveResult");
    }

    public void cancelRetrievePropertiesEx(ManagedObjectReference _this, String token) throws java.rmi.RemoteException, InvalidProperty, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("token", "String", token);
        wsc.invoke("CancelRetrievePropertiesEx", paras, null);
    }

    public ManagedObjectReference createPropertyCollector(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("CreatePropertyCollector", paras, "ManagedObjectReference");
    }

    public void destroyPropertyCollector(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("DestroyPropertyCollector", paras, null);
    }

    public int addAuthorizationRole(ManagedObjectReference _this, String name, String[] privIds) throws java.rmi.RemoteException, AlreadyExists, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("privIds", "String[]", privIds);
        Integer ret = (Integer) wsc.invoke("AddAuthorizationRole", paras, "int");
        return ret.intValue();
    }

    public void removeAuthorizationRole(ManagedObjectReference _this, int roleId, boolean failIfUsed) throws java.rmi.RemoteException, NotFound, RemoveFailed, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("roleId", "int", roleId);
        paras[2] = new Argument("failIfUsed", "boolean", failIfUsed);
        wsc.invoke("RemoveAuthorizationRole", paras, null);
    }

    public void updateAuthorizationRole(ManagedObjectReference _this, int roleId, String newName, String[] privIds) throws java.rmi.RemoteException, NotFound, InvalidName, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("roleId", "int", roleId);
        paras[2] = new Argument("newName", "String", newName);
        paras[3] = new Argument("privIds", "String[]", privIds);
        wsc.invoke("UpdateAuthorizationRole", paras, null);
    }

    public void mergePermissions(ManagedObjectReference _this, int srcRoleId, int dstRoleId) throws java.rmi.RemoteException, NotFound, AuthMinimumAdminPermission, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("srcRoleId", "int", srcRoleId);
        paras[2] = new Argument("dstRoleId", "int", dstRoleId);
        wsc.invoke("MergePermissions", paras, null);
    }

    public Permission[] retrieveRolePermissions(ManagedObjectReference _this, int roleId) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("roleId", "int", roleId);
        return (Permission[]) wsc.invoke("RetrieveRolePermissions", paras, "Permission[]");
    }

    public Permission[] retrieveEntityPermissions(ManagedObjectReference _this, ManagedObjectReference entity, boolean inherited) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("inherited", "boolean", inherited);
        return (Permission[]) wsc.invoke("RetrieveEntityPermissions", paras, "Permission[]");
    }

    public Permission[] retrieveAllPermissions(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (Permission[]) wsc.invoke("RetrieveAllPermissions", paras, "Permission[]");
    }

    public void setEntityPermissions(ManagedObjectReference _this, ManagedObjectReference entity, Permission[] permission) throws java.rmi.RemoteException, UserNotFound, NotFound, AuthMinimumAdminPermission, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("permission", "Permission[]", permission);
        wsc.invoke("SetEntityPermissions", paras, null);
    }

    public void resetEntityPermissions(ManagedObjectReference _this, ManagedObjectReference entity, Permission[] permission) throws java.rmi.RemoteException, UserNotFound, NotFound, AuthMinimumAdminPermission, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("permission", "Permission[]", permission);
        wsc.invoke("ResetEntityPermissions", paras, null);
    }

    public void removeEntityPermission(ManagedObjectReference _this, ManagedObjectReference entity, String user, boolean isGroup) throws java.rmi.RemoteException, NotFound, AuthMinimumAdminPermission, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("user", "String", user);
        paras[3] = new Argument("isGroup", "boolean", isGroup);
        wsc.invoke("RemoveEntityPermission", paras, null);
    }

    public boolean[] hasPrivilegeOnEntity(ManagedObjectReference _this, ManagedObjectReference entity, String sessionId, String[] privId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("sessionId", "String", sessionId);
        paras[3] = new Argument("privId", "String[]", privId);
        return (boolean[]) wsc.invoke("HasPrivilegeOnEntity", paras, "boolean[]");
    }

    public EntityPrivilege[] hasPrivilegeOnEntities(ManagedObjectReference _this, ManagedObjectReference[] entity, String sessionId, String[] privId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        paras[2] = new Argument("sessionId", "String", sessionId);
        paras[3] = new Argument("privId", "String[]", privId);
        return (EntityPrivilege[]) wsc.invoke("HasPrivilegeOnEntities", paras, "EntityPrivilege[]");
    }

    public ManagedObjectReference reconfigureCluster_Task(ManagedObjectReference _this, ClusterConfigSpec spec, boolean modify) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "ClusterConfigSpec", spec);
        paras[2] = new Argument("modify", "boolean", modify);
        return (ManagedObjectReference) wsc.invoke("ReconfigureCluster_Task", paras, "ManagedObjectReference");
    }

    public void applyRecommendation(ManagedObjectReference _this, String key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String", key);
        wsc.invoke("ApplyRecommendation", paras, null);
    }

    public void cancelRecommendation(ManagedObjectReference _this, String key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String", key);
        wsc.invoke("CancelRecommendation", paras, null);
    }

    public ClusterHostRecommendation[] recommendHostsForVm(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference pool) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("pool", "ManagedObjectReference", pool);
        return (ClusterHostRecommendation[]) wsc.invoke("RecommendHostsForVm", paras, "ClusterHostRecommendation[]");
    }

    public ManagedObjectReference addHost_Task(ManagedObjectReference _this, HostConnectSpec spec, boolean asConnected, ManagedObjectReference resourcePool, String license) throws java.rmi.RemoteException, InvalidLogin, HostConnectFault, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostConnectSpec", spec);
        paras[2] = new Argument("asConnected", "boolean", asConnected);
        paras[3] = new Argument("resourcePool", "ManagedObjectReference", resourcePool);
        paras[4] = new Argument("license", "String", license);
        return (ManagedObjectReference) wsc.invoke("AddHost_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference moveInto_Task(ManagedObjectReference _this, ManagedObjectReference[] host) throws java.rmi.RemoteException, DuplicateName, TooManyHosts, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference[]", host);
        return (ManagedObjectReference) wsc.invoke("MoveInto_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference moveHostInto_Task(ManagedObjectReference _this, ManagedObjectReference host, ManagedObjectReference resourcePool) throws java.rmi.RemoteException, TooManyHosts, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("resourcePool", "ManagedObjectReference", resourcePool);
        return (ManagedObjectReference) wsc.invoke("MoveHostInto_Task", paras, "ManagedObjectReference");
    }

    public void refreshRecommendation(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RefreshRecommendation", paras, null);
    }

    public ClusterDasAdvancedRuntimeInfo retrieveDasAdvancedRuntimeInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ClusterDasAdvancedRuntimeInfo) wsc.invoke("RetrieveDasAdvancedRuntimeInfo", paras, "ClusterDasAdvancedRuntimeInfo");
    }

    public ClusterEnterMaintenanceResult clusterEnterMaintenanceMode(ManagedObjectReference _this, ManagedObjectReference[] host, OptionValue[] option) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference[]", host);
        paras[2] = new Argument("option", "OptionValue[]", option);
        return (ClusterEnterMaintenanceResult) wsc.invoke("ClusterEnterMaintenanceMode", paras, "ClusterEnterMaintenanceResult");
    }

    public ManagedObjectReference reconfigureComputeResource_Task(ManagedObjectReference _this, ComputeResourceConfigSpec spec, boolean modify) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "ComputeResourceConfigSpec", spec);
        paras[2] = new Argument("modify", "boolean", modify);
        return (ManagedObjectReference) wsc.invoke("ReconfigureComputeResource_Task", paras, "ManagedObjectReference");
    }

    public CustomFieldDef addCustomFieldDef(ManagedObjectReference _this, String name, String moType, PrivilegePolicyDef fieldDefPolicy, PrivilegePolicyDef fieldPolicy) throws java.rmi.RemoteException, DuplicateName, InvalidPrivilege, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("moType", "String", moType);
        paras[3] = new Argument("fieldDefPolicy", "PrivilegePolicyDef", fieldDefPolicy);
        paras[4] = new Argument("fieldPolicy", "PrivilegePolicyDef", fieldPolicy);
        return (CustomFieldDef) wsc.invoke("AddCustomFieldDef", paras, "CustomFieldDef");
    }

    public void removeCustomFieldDef(ManagedObjectReference _this, int key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "int", key);
        wsc.invoke("RemoveCustomFieldDef", paras, null);
    }

    public void renameCustomFieldDef(ManagedObjectReference _this, int key, String name) throws java.rmi.RemoteException, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "int", key);
        paras[2] = new Argument("name", "String", name);
        wsc.invoke("RenameCustomFieldDef", paras, null);
    }

    public void setField(ManagedObjectReference _this, ManagedObjectReference entity, int key, String value) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("key", "int", key);
        paras[3] = new Argument("value", "String", value);
        wsc.invoke("SetField", paras, null);
    }

    public boolean doesCustomizationSpecExist(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        Boolean ret = (Boolean) wsc.invoke("DoesCustomizationSpecExist", paras, "boolean");
        return ret.booleanValue();
    }

    public CustomizationSpecItem getCustomizationSpec(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (CustomizationSpecItem) wsc.invoke("GetCustomizationSpec", paras, "CustomizationSpecItem");
    }

    public void createCustomizationSpec(ManagedObjectReference _this, CustomizationSpecItem item) throws java.rmi.RemoteException, CustomizationFault, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("item", "CustomizationSpecItem", item);
        wsc.invoke("CreateCustomizationSpec", paras, null);
    }

    public void overwriteCustomizationSpec(ManagedObjectReference _this, CustomizationSpecItem item) throws java.rmi.RemoteException, CustomizationFault, NotFound, ConcurrentAccess, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("item", "CustomizationSpecItem", item);
        wsc.invoke("OverwriteCustomizationSpec", paras, null);
    }

    public void deleteCustomizationSpec(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        wsc.invoke("DeleteCustomizationSpec", paras, null);
    }

    public void duplicateCustomizationSpec(ManagedObjectReference _this, String name, String newName) throws java.rmi.RemoteException, NotFound, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("newName", "String", newName);
        wsc.invoke("DuplicateCustomizationSpec", paras, null);
    }

    public void renameCustomizationSpec(ManagedObjectReference _this, String name, String newName) throws java.rmi.RemoteException, NotFound, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("newName", "String", newName);
        wsc.invoke("RenameCustomizationSpec", paras, null);
    }

    public String customizationSpecItemToXml(ManagedObjectReference _this, CustomizationSpecItem item) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("item", "CustomizationSpecItem", item);
        return (String) wsc.invoke("CustomizationSpecItemToXml", paras, "String");
    }

    public CustomizationSpecItem xmlToCustomizationSpecItem(ManagedObjectReference _this, String specItemXml) throws java.rmi.RemoteException, CustomizationFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("specItemXml", "String", specItemXml);
        return (CustomizationSpecItem) wsc.invoke("XmlToCustomizationSpecItem", paras, "CustomizationSpecItem");
    }

    public void checkCustomizationResources(ManagedObjectReference _this, String guestOs) throws java.rmi.RemoteException, CustomizationFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("guestOs", "String", guestOs);
        wsc.invoke("CheckCustomizationResources", paras, null);
    }

    public HostConnectInfo queryConnectionInfo(ManagedObjectReference _this, String hostname, int port, String username, String password, String sslThumbprint) throws java.rmi.RemoteException, InvalidLogin, HostConnectFault, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hostname", "String", hostname);
        paras[2] = new Argument("port", "int", port);
        paras[3] = new Argument("username", "String", username);
        paras[4] = new Argument("password", "String", password);
        paras[5] = new Argument("sslThumbprint", "String", sslThumbprint);
        return (HostConnectInfo) wsc.invoke("QueryConnectionInfo", paras, "HostConnectInfo");
    }

    public ManagedObjectReference powerOnMultiVM_Task(ManagedObjectReference _this, ManagedObjectReference[] vm, OptionValue[] option) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference[]", vm);
        paras[2] = new Argument("option", "OptionValue[]", option);
        return (ManagedObjectReference) wsc.invoke("PowerOnMultiVM_Task", paras, "ManagedObjectReference");
    }

    public VirtualMachineConfigOptionDescriptor[] queryDatacenterConfigOptionDescriptor(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VirtualMachineConfigOptionDescriptor[]) wsc.invoke("queryDatacenterConfigOptionDescriptor", paras, "VirtualMachineConfigOptionDescriptor[]");
    }

    public ManagedObjectReference reconfigureDatacenter_Task(ManagedObjectReference _this, DatacenterConfigSpec spec, boolean modify) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DatacenterConfigSpec", spec);
        paras[2] = new Argument("modify", "boolean", modify);
        return (ManagedObjectReference) wsc.invoke("ReconfigureDatacenter_Task", paras, "ManagedObjectReference");
    }

    public void refreshDatastore(ManagedObjectReference _this) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RefreshDatastore", paras, null);
    }

    public void refreshDatastoreStorageInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RefreshDatastoreStorageInfo", paras, null);
    }

    public ManagedObjectReference updateVirtualMachineFiles_Task(ManagedObjectReference _this, DatastoreMountPathDatastorePair[] mountPathDatastoreMapping) throws java.rmi.RemoteException, ResourceInUse, PlatformConfigFault, TaskInProgress, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("mountPathDatastoreMapping", "DatastoreMountPathDatastorePair[]", mountPathDatastoreMapping);
        return (ManagedObjectReference) wsc.invoke("UpdateVirtualMachineFiles_Task", paras, "ManagedObjectReference");
    }

    public void renameDatastore(ManagedObjectReference _this, String newName) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("newName", "String", newName);
        wsc.invoke("RenameDatastore", paras, null);
    }

    public void destroyDatastore(ManagedObjectReference _this) throws java.rmi.RemoteException, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("DestroyDatastore", paras, null);
    }

    public StoragePlacementResult datastoreEnterMaintenanceMode(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (StoragePlacementResult) wsc.invoke("DatastoreEnterMaintenanceMode", paras, "StoragePlacementResult");
    }

    public ManagedObjectReference datastoreExitMaintenanceMode_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("DatastoreExitMaintenanceMode_Task", paras, "ManagedObjectReference");
    }

    public String createDirectory(ManagedObjectReference _this, ManagedObjectReference datastore, String displayName, String policy) throws java.rmi.RemoteException, CannotCreateFile, FileAlreadyExists, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("displayName", "String", displayName);
        paras[3] = new Argument("policy", "String", policy);
        return (String) wsc.invoke("CreateDirectory", paras, "String");
    }

    public void deleteDirectory(ManagedObjectReference _this, ManagedObjectReference datacenter, String datastorePath) throws java.rmi.RemoteException, FileFault, FileNotFound, InvalidDatastore, InvalidDatastorePath, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("datastorePath", "String", datastorePath);
        wsc.invoke("DeleteDirectory", paras, null);
    }

    public DiagnosticManagerLogDescriptor[] queryDescriptions(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (DiagnosticManagerLogDescriptor[]) wsc.invoke("QueryDescriptions", paras, "DiagnosticManagerLogDescriptor[]");
    }

    public DiagnosticManagerLogHeader browseDiagnosticLog(ManagedObjectReference _this, ManagedObjectReference host, String key, int start, int lines) throws java.rmi.RemoteException, CannotAccessFile, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("key", "String", key);
        paras[3] = new Argument("start", "int", start);
        paras[4] = new Argument("lines", "int", lines);
        return (DiagnosticManagerLogHeader) wsc.invoke("BrowseDiagnosticLog", paras, "DiagnosticManagerLogHeader");
    }

    public ManagedObjectReference generateLogBundles_Task(ManagedObjectReference _this, boolean includeDefault, ManagedObjectReference[] host) throws java.rmi.RemoteException, LogBundlingFailed, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("includeDefault", "boolean", includeDefault);
        paras[2] = new Argument("host", "ManagedObjectReference[]", host);
        return (ManagedObjectReference) wsc.invoke("GenerateLogBundles_Task", paras, "ManagedObjectReference");
    }

    public String[] fetchDVPortKeys(ManagedObjectReference _this, DistributedVirtualSwitchPortCriteria criteria) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("criteria", "DistributedVirtualSwitchPortCriteria", criteria);
        return (String[]) wsc.invoke("FetchDVPortKeys", paras, "String[]");
    }

    public DistributedVirtualPort[] fetchDVPorts(ManagedObjectReference _this, DistributedVirtualSwitchPortCriteria criteria) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("criteria", "DistributedVirtualSwitchPortCriteria", criteria);
        return (DistributedVirtualPort[]) wsc.invoke("FetchDVPorts", paras, "DistributedVirtualPort[]");
    }

    public int[] queryUsedVlanIdInDvs(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (int[]) wsc.invoke("QueryUsedVlanIdInDvs", paras, "int[]");
    }

    public ManagedObjectReference reconfigureDvs_Task(ManagedObjectReference _this, DVSConfigSpec spec) throws java.rmi.RemoteException, DvsFault, ConcurrentAccess, DuplicateName, InvalidState, InvalidName, NotFound, AlreadyExists, LimitExceeded, ResourceInUse, ResourceNotAvailable, DvsNotAuthorized, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DVSConfigSpec", spec);
        return (ManagedObjectReference) wsc.invoke("ReconfigureDvs_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference performDvsProductSpecOperation_Task(ManagedObjectReference _this, String operation, DistributedVirtualSwitchProductSpec productSpec) throws java.rmi.RemoteException, TaskInProgress, InvalidState, DvsFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("operation", "String", operation);
        paras[2] = new Argument("productSpec", "DistributedVirtualSwitchProductSpec", productSpec);
        return (ManagedObjectReference) wsc.invoke("PerformDvsProductSpecOperation_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference mergeDvs_Task(ManagedObjectReference _this, ManagedObjectReference dvs) throws java.rmi.RemoteException, DvsFault, NotFound, ResourceInUse, InvalidHostState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dvs", "ManagedObjectReference", dvs);
        return (ManagedObjectReference) wsc.invoke("MergeDvs_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference addDVPortgroup_Task(ManagedObjectReference _this, DVPortgroupConfigSpec[] spec) throws java.rmi.RemoteException, DvsFault, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DVPortgroupConfigSpec[]", spec);
        return (ManagedObjectReference) wsc.invoke("AddDVPortgroup_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference moveDVPort_Task(ManagedObjectReference _this, String[] portKey, String destinationPortgroupKey) throws java.rmi.RemoteException, DvsFault, NotFound, ConcurrentAccess, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portKey", "String[]", portKey);
        paras[2] = new Argument("destinationPortgroupKey", "String", destinationPortgroupKey);
        return (ManagedObjectReference) wsc.invoke("MoveDVPort_Task", paras, "ManagedObjectReference");
    }

    public void updateDvsCapability(ManagedObjectReference _this, DVSCapability capability) throws java.rmi.RemoteException, DvsFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("capability", "DVSCapability", capability);
        wsc.invoke("UpdateDvsCapability", paras, null);
    }

    public ManagedObjectReference reconfigureDVPort_Task(ManagedObjectReference _this, DVPortConfigSpec[] port) throws java.rmi.RemoteException, DvsFault, NotFound, ResourceInUse, ConcurrentAccess, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("port", "DVPortConfigSpec[]", port);
        return (ManagedObjectReference) wsc.invoke("ReconfigureDVPort_Task", paras, "ManagedObjectReference");
    }

    public void refreshDVPortState(ManagedObjectReference _this, String[] portKeys) throws java.rmi.RemoteException, DvsFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portKeys", "String[]", portKeys);
        wsc.invoke("RefreshDVPortState", paras, null);
    }

    public ManagedObjectReference rectifyDvsHost_Task(ManagedObjectReference _this, ManagedObjectReference[] hosts) throws java.rmi.RemoteException, DvsFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hosts", "ManagedObjectReference[]", hosts);
        return (ManagedObjectReference) wsc.invoke("RectifyDvsHost_Task", paras, "ManagedObjectReference");
    }

    public void updateNetworkResourcePool(ManagedObjectReference _this, DVSNetworkResourcePoolConfigSpec[] configSpec) throws java.rmi.RemoteException, DvsFault, NotFound, InvalidName, ConcurrentAccess, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configSpec", "DVSNetworkResourcePoolConfigSpec[]", configSpec);
        wsc.invoke("UpdateNetworkResourcePool", paras, null);
    }

    public void addNetworkResourcePool(ManagedObjectReference _this, DVSNetworkResourcePoolConfigSpec[] configSpec) throws java.rmi.RemoteException, DvsFault, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configSpec", "DVSNetworkResourcePoolConfigSpec[]", configSpec);
        wsc.invoke("AddNetworkResourcePool", paras, null);
    }

    public void removeNetworkResourcePool(ManagedObjectReference _this, String[] key) throws java.rmi.RemoteException, DvsFault, NotFound, InvalidName, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String[]", key);
        wsc.invoke("RemoveNetworkResourcePool", paras, null);
    }

    public void enableNetworkResourceManagement(ManagedObjectReference _this, boolean enable) throws java.rmi.RemoteException, DvsFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("enable", "boolean", enable);
        wsc.invoke("EnableNetworkResourceManagement", paras, null);
    }

    public ManagedObjectReference dVSRollback_Task(ManagedObjectReference _this, EntityBackupConfig entityBackup) throws java.rmi.RemoteException, DvsFault, RollbackFailure, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entityBackup", "EntityBackupConfig", entityBackup);
        return (ManagedObjectReference) wsc.invoke("DVSRollback_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createDVPortgroup_Task(ManagedObjectReference _this, DVPortgroupConfigSpec spec) throws java.rmi.RemoteException, DvsFault, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DVPortgroupConfigSpec", spec);
        return (ManagedObjectReference) wsc.invoke("CreateDVPortgroup_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference updateDVSHealthCheckConfig_Task(ManagedObjectReference _this, DVSHealthCheckConfig[] healthCheckConfig) throws java.rmi.RemoteException, DvsFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("healthCheckConfig", "DVSHealthCheckConfig[]", healthCheckConfig);
        return (ManagedObjectReference) wsc.invoke("UpdateDVSHealthCheckConfig_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference lookupDvPortGroup(ManagedObjectReference _this, String portgroupKey) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portgroupKey", "String", portgroupKey);
        return (ManagedObjectReference) wsc.invoke("LookupDvPortGroup", paras, "ManagedObjectReference");
    }

    public VirtualMachineConfigOptionDescriptor[] queryConfigOptionDescriptor(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VirtualMachineConfigOptionDescriptor[]) wsc.invoke("QueryConfigOptionDescriptor", paras, "VirtualMachineConfigOptionDescriptor[]");
    }

    public VirtualMachineConfigOption queryConfigOption(ManagedObjectReference _this, String key, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String", key);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (VirtualMachineConfigOption) wsc.invoke("QueryConfigOption", paras, "VirtualMachineConfigOption");
    }

    public ConfigTarget queryConfigTarget(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (ConfigTarget) wsc.invoke("QueryConfigTarget", paras, "ConfigTarget");
    }

    public HostCapability queryTargetCapabilities(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (HostCapability) wsc.invoke("QueryTargetCapabilities", paras, "HostCapability");
    }

    public void setCustomValue(ManagedObjectReference _this, String key, String value) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String", key);
        paras[2] = new Argument("value", "String", value);
        wsc.invoke("setCustomValue", paras, null);
    }

    public void unregisterExtension(ManagedObjectReference _this, String extensionKey) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        wsc.invoke("UnregisterExtension", paras, null);
    }

    public Extension findExtension(ManagedObjectReference _this, String extensionKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        return (Extension) wsc.invoke("FindExtension", paras, "Extension");
    }

    public void registerExtension(ManagedObjectReference _this, Extension extension) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extension", "Extension", extension);
        wsc.invoke("RegisterExtension", paras, null);
    }

    public void updateExtension(ManagedObjectReference _this, Extension extension) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extension", "Extension", extension);
        wsc.invoke("UpdateExtension", paras, null);
    }

    public String getPublicKey(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) wsc.invoke("GetPublicKey", paras, "String");
    }

    public void setPublicKey(ManagedObjectReference _this, String extensionKey, String publicKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        paras[2] = new Argument("publicKey", "String", publicKey);
        wsc.invoke("SetPublicKey", paras, null);
    }

    public void setExtensionCertificate(ManagedObjectReference _this, String extensionKey, String certificatePem) throws java.rmi.RemoteException, NotFound, NoClientCertificate, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        paras[2] = new Argument("certificatePem", "String", certificatePem);
        wsc.invoke("SetExtensionCertificate", paras, null);
    }

    public ManagedObjectReference[] queryManagedBy(ManagedObjectReference _this, String extensionKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        return (ManagedObjectReference[]) wsc.invoke("QueryManagedBy", paras, "ManagedObjectReference[]");
    }

    public ExtensionManagerIpAllocationUsage[] queryExtensionIpAllocationUsage(ManagedObjectReference _this, String[] extensionKeys) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKeys", "String[]", extensionKeys);
        return (ExtensionManagerIpAllocationUsage[]) wsc.invoke("QueryExtensionIpAllocationUsage", paras, "ExtensionManagerIpAllocationUsage[]");
    }

    public ManagedObjectReference moveDatastoreFile_Task(ManagedObjectReference _this, String sourceName, ManagedObjectReference sourceDatacenter, String destinationName, ManagedObjectReference destinationDatacenter, Boolean force) throws java.rmi.RemoteException, InvalidDatastore, FileFault, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sourceName", "String", sourceName);
        paras[2] = new Argument("sourceDatacenter", "ManagedObjectReference", sourceDatacenter);
        paras[3] = new Argument("destinationName", "String", destinationName);
        paras[4] = new Argument("destinationDatacenter", "ManagedObjectReference", destinationDatacenter);
        paras[5] = new Argument("force", "Boolean", force);
        return (ManagedObjectReference) wsc.invoke("MoveDatastoreFile_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference copyDatastoreFile_Task(ManagedObjectReference _this, String sourceName, ManagedObjectReference sourceDatacenter, String destinationName, ManagedObjectReference destinationDatacenter, Boolean force) throws java.rmi.RemoteException, InvalidDatastore, FileFault, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sourceName", "String", sourceName);
        paras[2] = new Argument("sourceDatacenter", "ManagedObjectReference", sourceDatacenter);
        paras[3] = new Argument("destinationName", "String", destinationName);
        paras[4] = new Argument("destinationDatacenter", "ManagedObjectReference", destinationDatacenter);
        paras[5] = new Argument("force", "Boolean", force);
        return (ManagedObjectReference) wsc.invoke("CopyDatastoreFile_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference deleteDatastoreFile_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, InvalidDatastore, FileFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) wsc.invoke("DeleteDatastoreFile_Task", paras, "ManagedObjectReference");
    }

    public void makeDirectory(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, Boolean createParentDirectories) throws java.rmi.RemoteException, InvalidDatastore, FileFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("createParentDirectories", "Boolean", createParentDirectories);
        wsc.invoke("MakeDirectory", paras, null);
    }

    public void changeOwner(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, String owner) throws java.rmi.RemoteException, InvalidDatastore, FileFault, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("owner", "String", owner);
        wsc.invoke("ChangeOwner", paras, null);
    }

    public ManagedObjectReference createFolder(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (ManagedObjectReference) wsc.invoke("CreateFolder", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference moveIntoFolder_Task(ManagedObjectReference _this, ManagedObjectReference[] list) throws java.rmi.RemoteException, DuplicateName, InvalidFolder, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("list", "ManagedObjectReference[]", list);
        return (ManagedObjectReference) wsc.invoke("MoveIntoFolder_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createVM_Task(ManagedObjectReference _this, VirtualMachineConfigSpec config, ManagedObjectReference pool, ManagedObjectReference host) throws java.rmi.RemoteException, VmConfigFault, FileFault, OutOfBounds, DuplicateName, InvalidName, InvalidDatastore, InsufficientResourcesFault, AlreadyExists, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "VirtualMachineConfigSpec", config);
        paras[2] = new Argument("pool", "ManagedObjectReference", pool);
        paras[3] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) wsc.invoke("CreateVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference registerVM_Task(ManagedObjectReference _this, String path, String name, boolean asTemplate, ManagedObjectReference pool, ManagedObjectReference host) throws java.rmi.RemoteException, OutOfBounds, DuplicateName, AlreadyExists, InvalidDatastore, NotFound, InvalidName, VmConfigFault, InsufficientResourcesFault, FileFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("path", "String", path);
        paras[2] = new Argument("name", "String", name);
        paras[3] = new Argument("asTemplate", "boolean", asTemplate);
        paras[4] = new Argument("pool", "ManagedObjectReference", pool);
        paras[5] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) wsc.invoke("RegisterVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createCluster(ManagedObjectReference _this, String name, ClusterConfigSpec spec) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("spec", "ClusterConfigSpec", spec);
        return (ManagedObjectReference) wsc.invoke("CreateCluster", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createClusterEx(ManagedObjectReference _this, String name, ClusterConfigSpecEx spec) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("spec", "ClusterConfigSpecEx", spec);
        return (ManagedObjectReference) wsc.invoke("CreateClusterEx", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference addStandaloneHost_Task(ManagedObjectReference _this, HostConnectSpec spec, ComputeResourceConfigSpec compResSpec, boolean addConnected, String license) throws java.rmi.RemoteException, InvalidLogin, HostConnectFault, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostConnectSpec", spec);
        paras[2] = new Argument("compResSpec", "ComputeResourceConfigSpec", compResSpec);
        paras[3] = new Argument("addConnected", "boolean", addConnected);
        paras[4] = new Argument("license", "String", license);
        return (ManagedObjectReference) wsc.invoke("AddStandaloneHost_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createDatacenter(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (ManagedObjectReference) wsc.invoke("CreateDatacenter", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference unregisterAndDestroy_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, ConcurrentAccess, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("UnregisterAndDestroy_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createDVS_Task(ManagedObjectReference _this, DVSCreateSpec spec) throws java.rmi.RemoteException, DvsFault, DuplicateName, InvalidName, NotFound, DvsNotAuthorized, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DVSCreateSpec", spec);
        return (ManagedObjectReference) wsc.invoke("CreateDVS_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createStoragePod(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (ManagedObjectReference) wsc.invoke("CreateStoragePod", paras, "ManagedObjectReference");
    }

    public void setCollectorPageSize(ManagedObjectReference _this, int maxCount) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("maxCount", "int", maxCount);
        wsc.invoke("SetCollectorPageSize", paras, null);
    }

    public void rewindCollector(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RewindCollector", paras, null);
    }

    public void resetCollector(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("ResetCollector", paras, null);
    }

    public void destroyCollector(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("DestroyCollector", paras, null);
    }

    public HostTpmAttestationReport queryTpmAttestationReport(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostTpmAttestationReport) wsc.invoke("QueryTpmAttestationReport", paras, "HostTpmAttestationReport");
    }

    public HostConnectInfo queryHostConnectionInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostConnectInfo) wsc.invoke("QueryHostConnectionInfo", paras, "HostConnectInfo");
    }

    public void updateSystemResources(ManagedObjectReference _this, HostSystemResourceInfo resourceInfo) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("resourceInfo", "HostSystemResourceInfo", resourceInfo);
        wsc.invoke("UpdateSystemResources", paras, null);
    }

    public void updateSystemSwapConfiguration(ManagedObjectReference _this, HostSystemSwapConfiguration sysSwapConfig) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sysSwapConfig", "HostSystemSwapConfiguration", sysSwapConfig);
        wsc.invoke("UpdateSystemSwapConfiguration", paras, null);
    }

    public ManagedObjectReference reconnectHost_Task(ManagedObjectReference _this, HostConnectSpec cnxSpec, HostSystemReconnectSpec reconnectSpec) throws java.rmi.RemoteException, InvalidLogin, InvalidState, InvalidName, HostConnectFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cnxSpec", "HostConnectSpec", cnxSpec);
        paras[2] = new Argument("reconnectSpec", "HostSystemReconnectSpec", reconnectSpec);
        return (ManagedObjectReference) wsc.invoke("ReconnectHost_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference disconnectHost_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("DisconnectHost_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference enterMaintenanceMode_Task(ManagedObjectReference _this, int timeout, Boolean evacuatePoweredOffVms, HostMaintenanceSpec maintenanceSpec) throws java.rmi.RemoteException, InvalidState, Timedout, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("timeout", "int", timeout);
        paras[2] = new Argument("evacuatePoweredOffVms", "Boolean", evacuatePoweredOffVms);
        paras[3] = new Argument("maintenanceSpec", "HostMaintenanceSpec", maintenanceSpec);
        return (ManagedObjectReference) wsc.invoke("EnterMaintenanceMode_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference exitMaintenanceMode_Task(ManagedObjectReference _this, int timeout) throws java.rmi.RemoteException, InvalidState, Timedout, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("timeout", "int", timeout);
        return (ManagedObjectReference) wsc.invoke("ExitMaintenanceMode_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference rebootHost_Task(ManagedObjectReference _this, boolean force) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("force", "boolean", force);
        return (ManagedObjectReference) wsc.invoke("RebootHost_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference shutdownHost_Task(ManagedObjectReference _this, boolean force) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("force", "boolean", force);
        return (ManagedObjectReference) wsc.invoke("ShutdownHost_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference powerDownHostToStandBy_Task(ManagedObjectReference _this, int timeoutSec, Boolean evacuatePoweredOffVms) throws java.rmi.RemoteException, HostPowerOpFailed, InvalidState, NotSupported, Timedout, RequestCanceled, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("timeoutSec", "int", timeoutSec);
        paras[2] = new Argument("evacuatePoweredOffVms", "Boolean", evacuatePoweredOffVms);
        return (ManagedObjectReference) wsc.invoke("PowerDownHostToStandBy_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference powerUpHostFromStandBy_Task(ManagedObjectReference _this, int timeoutSec) throws java.rmi.RemoteException, HostPowerOpFailed, InvalidState, NotSupported, Timedout, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("timeoutSec", "int", timeoutSec);
        return (ManagedObjectReference) wsc.invoke("PowerUpHostFromStandBy_Task", paras, "ManagedObjectReference");
    }

    public long queryMemoryOverhead(ManagedObjectReference _this, long memorySize, int videoRamSize, int numVcpus) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("memorySize", "long", memorySize);
        paras[2] = new Argument("videoRamSize", "int", videoRamSize);
        paras[3] = new Argument("numVcpus", "int", numVcpus);
        Long ret = (Long) wsc.invoke("QueryMemoryOverhead", paras, "long");
        return ret.longValue();
    }

    public long queryMemoryOverheadEx(ManagedObjectReference _this, VirtualMachineConfigInfo vmConfigInfo) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmConfigInfo", "VirtualMachineConfigInfo", vmConfigInfo);
        Long ret = (Long) wsc.invoke("QueryMemoryOverheadEx", paras, "long");
        return ret.longValue();
    }

    public ManagedObjectReference reconfigureHostForDAS_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, DasConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("ReconfigureHostForDAS_Task", paras, "ManagedObjectReference");
    }

    public void updateFlags(ManagedObjectReference _this, HostFlagInfo flagInfo) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("flagInfo", "HostFlagInfo", flagInfo);
        wsc.invoke("UpdateFlags", paras, null);
    }

    public void enterLockdownMode(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("EnterLockdownMode", paras, null);
    }

    public void exitLockdownMode(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("ExitLockdownMode", paras, null);
    }

    public HostServiceTicket acquireCimServicesTicket(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostServiceTicket) wsc.invoke("AcquireCimServicesTicket", paras, "HostServiceTicket");
    }

    public void updateIpmi(ManagedObjectReference _this, HostIpmiInfo ipmiInfo) throws java.rmi.RemoteException, InvalidIpmiLoginInfo, InvalidIpmiMacAddress, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ipmiInfo", "HostIpmiInfo", ipmiInfo);
        wsc.invoke("UpdateIpmi", paras, null);
    }

    public long retrieveHardwareUptime(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        Long ret = (Long) wsc.invoke("RetrieveHardwareUptime", paras, "long");
        return ret.longValue();
    }

    public HttpNfcLeaseManifestEntry[] httpNfcLeaseGetManifest(ManagedObjectReference _this) throws java.rmi.RemoteException, Timedout, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HttpNfcLeaseManifestEntry[]) wsc.invoke("HttpNfcLeaseGetManifest", paras, "HttpNfcLeaseManifestEntry[]");
    }

    public void httpNfcLeaseComplete(ManagedObjectReference _this) throws java.rmi.RemoteException, Timedout, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("HttpNfcLeaseComplete", paras, null);
    }

    public void httpNfcLeaseAbort(ManagedObjectReference _this, LocalizedMethodFault fault) throws java.rmi.RemoteException, Timedout, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("fault", "LocalizedMethodFault", fault);
        wsc.invoke("HttpNfcLeaseAbort", paras, null);
    }

    public void httpNfcLeaseProgress(ManagedObjectReference _this, int percent) throws java.rmi.RemoteException, Timedout, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("percent", "int", percent);
        wsc.invoke("HttpNfcLeaseProgress", paras, null);
    }

    public IpPool[] queryIpPools(ManagedObjectReference _this, ManagedObjectReference dc) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        return (IpPool[]) wsc.invoke("QueryIpPools", paras, "IpPool[]");
    }

    public int createIpPool(ManagedObjectReference _this, ManagedObjectReference dc, IpPool pool) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("pool", "IpPool", pool);
        Integer ret = (Integer) wsc.invoke("CreateIpPool", paras, "int");
        return ret.intValue();
    }

    public void updateIpPool(ManagedObjectReference _this, ManagedObjectReference dc, IpPool pool) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("pool", "IpPool", pool);
        wsc.invoke("UpdateIpPool", paras, null);
    }

    public void destroyIpPool(ManagedObjectReference _this, ManagedObjectReference dc, int id, boolean force) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("id", "int", id);
        paras[3] = new Argument("force", "boolean", force);
        wsc.invoke("DestroyIpPool", paras, null);
    }

    public String allocateIpv4Address(ManagedObjectReference _this, ManagedObjectReference dc, int poolId, String allocationId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("poolId", "int", poolId);
        paras[3] = new Argument("allocationId", "String", allocationId);
        return (String) wsc.invoke("AllocateIpv4Address", paras, "String");
    }

    public String allocateIpv6Address(ManagedObjectReference _this, ManagedObjectReference dc, int poolId, String allocationId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("poolId", "int", poolId);
        paras[3] = new Argument("allocationId", "String", allocationId);
        return (String) wsc.invoke("AllocateIpv6Address", paras, "String");
    }

    public void releaseIpAllocation(ManagedObjectReference _this, ManagedObjectReference dc, int poolId, String allocationId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("poolId", "int", poolId);
        paras[3] = new Argument("allocationId", "String", allocationId);
        wsc.invoke("ReleaseIpAllocation", paras, null);
    }

    public IpPoolManagerIpAllocation[] queryIPAllocations(ManagedObjectReference _this, ManagedObjectReference dc, int poolId, String extensionKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dc", "ManagedObjectReference", dc);
        paras[2] = new Argument("poolId", "int", poolId);
        paras[3] = new Argument("extensionKey", "String", extensionKey);
        return (IpPoolManagerIpAllocation[]) wsc.invoke("QueryIPAllocations", paras, "IpPoolManagerIpAllocation[]");
    }

    public LicenseManagerLicenseInfo updateAssignedLicense(ManagedObjectReference _this, String entity, String licenseKey, String entityDisplayName) throws java.rmi.RemoteException, LicenseEntityNotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "String", entity);
        paras[2] = new Argument("licenseKey", "String", licenseKey);
        paras[3] = new Argument("entityDisplayName", "String", entityDisplayName);
        return (LicenseManagerLicenseInfo) wsc.invoke("UpdateAssignedLicense", paras, "LicenseManagerLicenseInfo");
    }

    public void removeAssignedLicense(ManagedObjectReference _this, String entityId) throws java.rmi.RemoteException, LicenseEntityNotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entityId", "String", entityId);
        wsc.invoke("RemoveAssignedLicense", paras, null);
    }

    public LicenseAssignmentManagerLicenseAssignment[] queryAssignedLicenses(ManagedObjectReference _this, String entityId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entityId", "String", entityId);
        return (LicenseAssignmentManagerLicenseAssignment[]) wsc.invoke("QueryAssignedLicenses", paras, "LicenseAssignmentManagerLicenseAssignment[]");
    }

    public LicenseFeatureInfo[] querySupportedFeatures(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (LicenseFeatureInfo[]) wsc.invoke("QuerySupportedFeatures", paras, "LicenseFeatureInfo[]");
    }

    public LicenseAvailabilityInfo[] queryLicenseSourceAvailability(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (LicenseAvailabilityInfo[]) wsc.invoke("QueryLicenseSourceAvailability", paras, "LicenseAvailabilityInfo[]");
    }

    public LicenseUsageInfo queryLicenseUsage(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (LicenseUsageInfo) wsc.invoke("QueryLicenseUsage", paras, "LicenseUsageInfo");
    }

    public void setLicenseEdition(ManagedObjectReference _this, ManagedObjectReference host, String featureKey) throws java.rmi.RemoteException, InvalidState, LicenseServerUnavailable, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("featureKey", "String", featureKey);
        wsc.invoke("SetLicenseEdition", paras, null);
    }

    public boolean checkLicenseFeature(ManagedObjectReference _this, ManagedObjectReference host, String featureKey) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("featureKey", "String", featureKey);
        Boolean ret = (Boolean) wsc.invoke("CheckLicenseFeature", paras, "boolean");
        return ret.booleanValue();
    }

    public boolean enableFeature(ManagedObjectReference _this, ManagedObjectReference host, String featureKey) throws java.rmi.RemoteException, InvalidState, LicenseServerUnavailable, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("featureKey", "String", featureKey);
        Boolean ret = (Boolean) wsc.invoke("EnableFeature", paras, "boolean");
        return ret.booleanValue();
    }

    public boolean disableFeature(ManagedObjectReference _this, ManagedObjectReference host, String featureKey) throws java.rmi.RemoteException, InvalidState, LicenseServerUnavailable, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("featureKey", "String", featureKey);
        Boolean ret = (Boolean) wsc.invoke("DisableFeature", paras, "boolean");
        return ret.booleanValue();
    }

    public void configureLicenseSource(ManagedObjectReference _this, ManagedObjectReference host, LicenseSource licenseSource) throws java.rmi.RemoteException, CannotAccessLocalSource, InvalidLicense, LicenseServerUnavailable, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("licenseSource", "LicenseSource", licenseSource);
        wsc.invoke("ConfigureLicenseSource", paras, null);
    }

    public LicenseManagerLicenseInfo updateLicense(ManagedObjectReference _this, String licenseKey, KeyValue[] labels) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        paras[2] = new Argument("labels", "KeyValue[]", labels);
        return (LicenseManagerLicenseInfo) wsc.invoke("UpdateLicense", paras, "LicenseManagerLicenseInfo");
    }

    public LicenseManagerLicenseInfo addLicense(ManagedObjectReference _this, String licenseKey, KeyValue[] labels) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        paras[2] = new Argument("labels", "KeyValue[]", labels);
        return (LicenseManagerLicenseInfo) wsc.invoke("AddLicense", paras, "LicenseManagerLicenseInfo");
    }

    public void removeLicense(ManagedObjectReference _this, String licenseKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        wsc.invoke("RemoveLicense", paras, null);
    }

    public LicenseManagerLicenseInfo decodeLicense(ManagedObjectReference _this, String licenseKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        return (LicenseManagerLicenseInfo) wsc.invoke("DecodeLicense", paras, "LicenseManagerLicenseInfo");
    }

    public void updateLicenseLabel(ManagedObjectReference _this, String licenseKey, String labelKey, String labelValue) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        paras[2] = new Argument("labelKey", "String", labelKey);
        paras[3] = new Argument("labelValue", "String", labelValue);
        wsc.invoke("UpdateLicenseLabel", paras, null);
    }

    public void removeLicenseLabel(ManagedObjectReference _this, String licenseKey, String labelKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("licenseKey", "String", licenseKey);
        paras[2] = new Argument("labelKey", "String", labelKey);
        wsc.invoke("RemoveLicenseLabel", paras, null);
    }

    public void reload(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("Reload", paras, null);
    }

    public ManagedObjectReference rename_Task(ManagedObjectReference _this, String newName) throws java.rmi.RemoteException, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("newName", "String", newName);
        return (ManagedObjectReference) wsc.invoke("Rename_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference destroy_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, VimFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("Destroy_Task", paras, "ManagedObjectReference");
    }

    public void destroyNetwork(ManagedObjectReference _this) throws java.rmi.RemoteException, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("DestroyNetwork", paras, null);
    }

    public OvfValidateHostResult validateHost(ManagedObjectReference _this, String ovfDescriptor, ManagedObjectReference host, OvfValidateHostParams vhp) throws java.rmi.RemoteException, TaskInProgress, ConcurrentAccess, FileFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ovfDescriptor", "String", ovfDescriptor);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        paras[3] = new Argument("vhp", "OvfValidateHostParams", vhp);
        return (OvfValidateHostResult) wsc.invoke("ValidateHost", paras, "OvfValidateHostResult");
    }

    public OvfParseDescriptorResult parseDescriptor(ManagedObjectReference _this, String ovfDescriptor, OvfParseDescriptorParams pdp) throws java.rmi.RemoteException, TaskInProgress, VmConfigFault, ConcurrentAccess, FileFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ovfDescriptor", "String", ovfDescriptor);
        paras[2] = new Argument("pdp", "OvfParseDescriptorParams", pdp);
        return (OvfParseDescriptorResult) wsc.invoke("ParseDescriptor", paras, "OvfParseDescriptorResult");
    }

    public OvfCreateImportSpecResult createImportSpec(ManagedObjectReference _this, String ovfDescriptor, ManagedObjectReference resourcePool, ManagedObjectReference datastore, OvfCreateImportSpecParams cisp) throws java.rmi.RemoteException, TaskInProgress, VmConfigFault, ConcurrentAccess, FileFault, InvalidState, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ovfDescriptor", "String", ovfDescriptor);
        paras[2] = new Argument("resourcePool", "ManagedObjectReference", resourcePool);
        paras[3] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[4] = new Argument("cisp", "OvfCreateImportSpecParams", cisp);
        return (OvfCreateImportSpecResult) wsc.invoke("CreateImportSpec", paras, "OvfCreateImportSpecResult");
    }

    public OvfCreateDescriptorResult createDescriptor(ManagedObjectReference _this, ManagedObjectReference obj, OvfCreateDescriptorParams cdp) throws java.rmi.RemoteException, TaskInProgress, VmConfigFault, ConcurrentAccess, FileFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("obj", "ManagedObjectReference", obj);
        paras[2] = new Argument("cdp", "OvfCreateDescriptorParams", cdp);
        return (OvfCreateDescriptorResult) wsc.invoke("CreateDescriptor", paras, "OvfCreateDescriptorResult");
    }

    public PerfProviderSummary queryPerfProviderSummary(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        return (PerfProviderSummary) wsc.invoke("QueryPerfProviderSummary", paras, "PerfProviderSummary");
    }

    public PerfMetricId[] queryAvailablePerfMetric(ManagedObjectReference _this, ManagedObjectReference entity, Calendar beginTime, Calendar endTime, int intervalId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("beginTime", "Calendar", beginTime);
        paras[3] = new Argument("endTime", "Calendar", endTime);
        paras[4] = new Argument("intervalId", "int", intervalId);
        return (PerfMetricId[]) wsc.invoke("QueryAvailablePerfMetric", paras, "PerfMetricId[]");
    }

    public PerfCounterInfo[] queryPerfCounter(ManagedObjectReference _this, int[] counterId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("counterId", "int[]", counterId);
        return (PerfCounterInfo[]) wsc.invoke("QueryPerfCounter", paras, "PerfCounterInfo[]");
    }

    public PerfCounterInfo[] queryPerfCounterByLevel(ManagedObjectReference _this, int level) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("level", "int", level);
        return (PerfCounterInfo[]) wsc.invoke("QueryPerfCounterByLevel", paras, "PerfCounterInfo[]");
    }

    public PerfEntityMetricBase[] queryPerf(ManagedObjectReference _this, PerfQuerySpec[] querySpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("querySpec", "PerfQuerySpec[]", querySpec);
        return (PerfEntityMetricBase[]) wsc.invoke("QueryPerf", paras, "PerfEntityMetricBase[]");
    }

    public PerfCompositeMetric queryPerfComposite(ManagedObjectReference _this, PerfQuerySpec querySpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("querySpec", "PerfQuerySpec", querySpec);
        return (PerfCompositeMetric) wsc.invoke("QueryPerfComposite", paras, "PerfCompositeMetric");
    }

    public void createPerfInterval(ManagedObjectReference _this, PerfInterval intervalId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("intervalId", "PerfInterval", intervalId);
        wsc.invoke("CreatePerfInterval", paras, null);
    }

    public void removePerfInterval(ManagedObjectReference _this, int samplePeriod) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("samplePeriod", "int", samplePeriod);
        wsc.invoke("RemovePerfInterval", paras, null);
    }

    public void updatePerfInterval(ManagedObjectReference _this, PerfInterval interval) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("interval", "PerfInterval", interval);
        wsc.invoke("UpdatePerfInterval", paras, null);
    }

    public void updateCounterLevelMapping(ManagedObjectReference _this, PerformanceManagerCounterLevelMapping[] counterLevelMap) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("counterLevelMap", "PerformanceManagerCounterLevelMapping[]", counterLevelMap);
        wsc.invoke("UpdateCounterLevelMapping", paras, null);
    }

    public void resetCounterLevelMapping(ManagedObjectReference _this, int[] counters) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("counters", "int[]", counters);
        wsc.invoke("ResetCounterLevelMapping", paras, null);
    }

    public DatabaseSizeEstimate estimateDatabaseSize(ManagedObjectReference _this, DatabaseSizeParam dbSizeParam) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dbSizeParam", "DatabaseSizeParam", dbSizeParam);
        return (DatabaseSizeEstimate) wsc.invoke("EstimateDatabaseSize", paras, "DatabaseSizeEstimate");
    }

    public void updateConfig(ManagedObjectReference _this, String name, ResourceConfigSpec config) throws java.rmi.RemoteException, InvalidName, DuplicateName, InsufficientResourcesFault, ConcurrentAccess, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("config", "ResourceConfigSpec", config);
        wsc.invoke("UpdateConfig", paras, null);
    }

    public void moveIntoResourcePool(ManagedObjectReference _this, ManagedObjectReference[] list) throws java.rmi.RemoteException, DuplicateName, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("list", "ManagedObjectReference[]", list);
        wsc.invoke("MoveIntoResourcePool", paras, null);
    }

    public void updateChildResourceConfiguration(ManagedObjectReference _this, ResourceConfigSpec[] spec) throws java.rmi.RemoteException, InvalidState, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "ResourceConfigSpec[]", spec);
        wsc.invoke("UpdateChildResourceConfiguration", paras, null);
    }

    public ManagedObjectReference createResourcePool(ManagedObjectReference _this, String name, ResourceConfigSpec spec) throws java.rmi.RemoteException, InvalidName, DuplicateName, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("spec", "ResourceConfigSpec", spec);
        return (ManagedObjectReference) wsc.invoke("CreateResourcePool", paras, "ManagedObjectReference");
    }

    public void destroyChildren(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("DestroyChildren", paras, null);
    }

    public ManagedObjectReference createVApp(ManagedObjectReference _this, String name, ResourceConfigSpec resSpec, VAppConfigSpec configSpec, ManagedObjectReference vmFolder) throws java.rmi.RemoteException, InvalidName, DuplicateName, InsufficientResourcesFault, InvalidState, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("resSpec", "ResourceConfigSpec", resSpec);
        paras[3] = new Argument("configSpec", "VAppConfigSpec", configSpec);
        paras[4] = new Argument("vmFolder", "ManagedObjectReference", vmFolder);
        return (ManagedObjectReference) wsc.invoke("CreateVApp", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createChildVM_Task(ManagedObjectReference _this, VirtualMachineConfigSpec config, ManagedObjectReference host) throws java.rmi.RemoteException, VmConfigFault, FileFault, OutOfBounds, InvalidName, InvalidDatastore, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "VirtualMachineConfigSpec", config);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) wsc.invoke("CreateChildVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference registerChildVM_Task(ManagedObjectReference _this, String path, String name, ManagedObjectReference host) throws java.rmi.RemoteException, OutOfBounds, AlreadyExists, InvalidDatastore, NotFound, InvalidName, VmConfigFault, InsufficientResourcesFault, FileFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("path", "String", path);
        paras[2] = new Argument("name", "String", name);
        paras[3] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) wsc.invoke("RegisterChildVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference importVApp(ManagedObjectReference _this, ImportSpec spec, ManagedObjectReference folder, ManagedObjectReference host) throws java.rmi.RemoteException, VmConfigFault, FileFault, OutOfBounds, DuplicateName, InvalidName, InvalidDatastore, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "ImportSpec", spec);
        paras[2] = new Argument("folder", "ManagedObjectReference", folder);
        paras[3] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) wsc.invoke("ImportVApp", paras, "ManagedObjectReference");
    }

    public ResourceConfigOption queryResourceConfigOption(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ResourceConfigOption) wsc.invoke("QueryResourceConfigOption", paras, "ResourceConfigOption");
    }

    public void refreshRuntime(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RefreshRuntime", paras, null);
    }

    public ManagedObjectReference findByUuid(ManagedObjectReference _this, ManagedObjectReference datacenter, String uuid, boolean vmSearch, Boolean instanceUuid) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("uuid", "String", uuid);
        paras[3] = new Argument("vmSearch", "boolean", vmSearch);
        paras[4] = new Argument("instanceUuid", "Boolean", instanceUuid);
        return (ManagedObjectReference) wsc.invoke("FindByUuid", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference findByDatastorePath(ManagedObjectReference _this, ManagedObjectReference datacenter, String path) throws java.rmi.RemoteException, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("path", "String", path);
        return (ManagedObjectReference) wsc.invoke("FindByDatastorePath", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference findByDnsName(ManagedObjectReference _this, ManagedObjectReference datacenter, String dnsName, boolean vmSearch) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("dnsName", "String", dnsName);
        paras[3] = new Argument("vmSearch", "boolean", vmSearch);
        return (ManagedObjectReference) wsc.invoke("FindByDnsName", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference findByIp(ManagedObjectReference _this, ManagedObjectReference datacenter, String ip, boolean vmSearch) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("ip", "String", ip);
        paras[3] = new Argument("vmSearch", "boolean", vmSearch);
        return (ManagedObjectReference) wsc.invoke("FindByIp", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference findByInventoryPath(ManagedObjectReference _this, String inventoryPath) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("inventoryPath", "String", inventoryPath);
        return (ManagedObjectReference) wsc.invoke("FindByInventoryPath", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference findChild(ManagedObjectReference _this, ManagedObjectReference entity, String name) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("name", "String", name);
        return (ManagedObjectReference) wsc.invoke("FindChild", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference[] findAllByUuid(ManagedObjectReference _this, ManagedObjectReference datacenter, String uuid, boolean vmSearch, Boolean instanceUuid) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("uuid", "String", uuid);
        paras[3] = new Argument("vmSearch", "boolean", vmSearch);
        paras[4] = new Argument("instanceUuid", "Boolean", instanceUuid);
        return (ManagedObjectReference[]) wsc.invoke("FindAllByUuid", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference[] findAllByDnsName(ManagedObjectReference _this, ManagedObjectReference datacenter, String dnsName, boolean vmSearch) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("dnsName", "String", dnsName);
        paras[3] = new Argument("vmSearch", "boolean", vmSearch);
        return (ManagedObjectReference[]) wsc.invoke("FindAllByDnsName", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference[] findAllByIp(ManagedObjectReference _this, ManagedObjectReference datacenter, String ip, boolean vmSearch) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[2] = new Argument("ip", "String", ip);
        paras[3] = new Argument("vmSearch", "boolean", vmSearch);
        return (ManagedObjectReference[]) wsc.invoke("FindAllByIp", paras, "ManagedObjectReference[]");
    }

    public Calendar currentTime(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (Calendar) wsc.invoke("CurrentTime", paras, "Calendar");
    }

    public ServiceContent retrieveServiceContent(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ServiceContent) wsc.invoke("RetrieveServiceContent", paras, "ServiceContent");
    }

    public Event[] validateMigration(ManagedObjectReference _this, ManagedObjectReference[] vm, VirtualMachinePowerState state, String[] testType, ManagedObjectReference pool, ManagedObjectReference host) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference[]", vm);
        paras[2] = new Argument("state", "VirtualMachinePowerState", state);
        paras[3] = new Argument("testType", "String[]", testType);
        paras[4] = new Argument("pool", "ManagedObjectReference", pool);
        paras[5] = new Argument("host", "ManagedObjectReference", host);
        return (Event[]) wsc.invoke("ValidateMigration", paras, "Event[]");
    }

    public HostVMotionCompatibility[] queryVMotionCompatibility(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference[] host, String[] compatibility) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("host", "ManagedObjectReference[]", host);
        paras[3] = new Argument("compatibility", "String[]", compatibility);
        return (HostVMotionCompatibility[]) wsc.invoke("QueryVMotionCompatibility", paras, "HostVMotionCompatibility[]");
    }

    public ProductComponentInfo[] retrieveProductComponents(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ProductComponentInfo[]) wsc.invoke("RetrieveProductComponents", paras, "ProductComponentInfo[]");
    }

    public ServiceManagerServiceInfo[] queryServiceList(ManagedObjectReference _this, String serviceName, String[] location) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("serviceName", "String", serviceName);
        paras[2] = new Argument("location", "String[]", location);
        return (ServiceManagerServiceInfo[]) wsc.invoke("QueryServiceList", paras, "ServiceManagerServiceInfo[]");
    }

    public void updateServiceMessage(ManagedObjectReference _this, String message) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("message", "String", message);
        wsc.invoke("UpdateServiceMessage", paras, null);
    }

    public UserSession loginByToken(ManagedObjectReference _this, String locale) throws java.rmi.RemoteException, InvalidLogin, InvalidLocale, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("locale", "String", locale);
        return (UserSession) wsc.invoke("LoginByToken", paras, "UserSession");
    }

    public UserSession login(ManagedObjectReference _this, String userName, String password, String locale) throws java.rmi.RemoteException, InvalidLogin, InvalidLocale, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("userName", "String", userName);
        paras[2] = new Argument("password", "String", password);
        paras[3] = new Argument("locale", "String", locale);
        return (UserSession) wsc.invoke("Login", paras, "UserSession");
    }

    public UserSession loginBySSPI(ManagedObjectReference _this, String base64Token, String locale) throws java.rmi.RemoteException, SSPIChallenge, InvalidLogin, InvalidLocale, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("base64Token", "String", base64Token);
        paras[2] = new Argument("locale", "String", locale);
        return (UserSession) wsc.invoke("LoginBySSPI", paras, "UserSession");
    }

    public void logout(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("Logout", paras, null);
    }

    public SessionManagerLocalTicket acquireLocalTicket(ManagedObjectReference _this, String userName) throws java.rmi.RemoteException, InvalidLogin, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("userName", "String", userName);
        return (SessionManagerLocalTicket) wsc.invoke("AcquireLocalTicket", paras, "SessionManagerLocalTicket");
    }

    public SessionManagerGenericServiceTicket acquireGenericServiceTicket(ManagedObjectReference _this, SessionManagerServiceRequestSpec spec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "SessionManagerServiceRequestSpec", spec);
        return (SessionManagerGenericServiceTicket) wsc.invoke("AcquireGenericServiceTicket", paras, "SessionManagerGenericServiceTicket");
    }

    public void terminateSession(ManagedObjectReference _this, String[] sessionId) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sessionId", "String[]", sessionId);
        wsc.invoke("TerminateSession", paras, null);
    }

    public void setLocale(ManagedObjectReference _this, String locale) throws java.rmi.RemoteException, InvalidLocale, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("locale", "String", locale);
        wsc.invoke("SetLocale", paras, null);
    }

    public UserSession loginExtensionBySubjectName(ManagedObjectReference _this, String extensionKey, String locale) throws java.rmi.RemoteException, InvalidLogin, InvalidLocale, NotFound, NoClientCertificate, NoSubjectName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        paras[2] = new Argument("locale", "String", locale);
        return (UserSession) wsc.invoke("LoginExtensionBySubjectName", paras, "UserSession");
    }

    public UserSession loginExtensionByCertificate(ManagedObjectReference _this, String extensionKey, String locale) throws java.rmi.RemoteException, InvalidLogin, InvalidLocale, NoClientCertificate, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("extensionKey", "String", extensionKey);
        paras[2] = new Argument("locale", "String", locale);
        return (UserSession) wsc.invoke("LoginExtensionByCertificate", paras, "UserSession");
    }

    public UserSession impersonateUser(ManagedObjectReference _this, String userName, String locale) throws java.rmi.RemoteException, InvalidLogin, InvalidLocale, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("userName", "String", userName);
        paras[2] = new Argument("locale", "String", locale);
        return (UserSession) wsc.invoke("ImpersonateUser", paras, "UserSession");
    }

    public boolean sessionIsActive(ManagedObjectReference _this, String sessionID, String userName) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("sessionID", "String", sessionID);
        paras[2] = new Argument("userName", "String", userName);
        Boolean ret = (Boolean) wsc.invoke("SessionIsActive", paras, "boolean");
        return ret.booleanValue();
    }

    public String acquireCloneTicket(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) wsc.invoke("AcquireCloneTicket", paras, "String");
    }

    public UserSession cloneSession(ManagedObjectReference _this, String cloneTicket) throws java.rmi.RemoteException, InvalidLogin, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cloneTicket", "String", cloneTicket);
        return (UserSession) wsc.invoke("CloneSession", paras, "UserSession");
    }

    public String executeSimpleCommand(ManagedObjectReference _this, String[] arguments) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("arguments", "String[]", arguments);
        return (String) wsc.invoke("ExecuteSimpleCommand", paras, "String");
    }

    public ManagedObjectReference configureDatastoreIORM_Task(ManagedObjectReference _this, ManagedObjectReference datastore, StorageIORMConfigSpec spec) throws java.rmi.RemoteException, IORMNotSupportedHostOnDatastore, InaccessibleDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("spec", "StorageIORMConfigSpec", spec);
        return (ManagedObjectReference) wsc.invoke("ConfigureDatastoreIORM_Task", paras, "ManagedObjectReference");
    }

    public StorageIORMConfigOption queryIORMConfigOption(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (StorageIORMConfigOption) wsc.invoke("QueryIORMConfigOption", paras, "StorageIORMConfigOption");
    }

    public StoragePerformanceSummary[] queryDatastorePerformanceSummary(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (StoragePerformanceSummary[]) wsc.invoke("QueryDatastorePerformanceSummary", paras, "StoragePerformanceSummary[]");
    }

    public ManagedObjectReference applyStorageDrsRecommendationToPod_Task(ManagedObjectReference _this, ManagedObjectReference pod, String key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pod", "ManagedObjectReference", pod);
        paras[2] = new Argument("key", "String", key);
        return (ManagedObjectReference) wsc.invoke("ApplyStorageDrsRecommendationToPod_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference applyStorageDrsRecommendation_Task(ManagedObjectReference _this, String[] key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String[]", key);
        return (ManagedObjectReference) wsc.invoke("ApplyStorageDrsRecommendation_Task", paras, "ManagedObjectReference");
    }

    public void cancelStorageDrsRecommendation(ManagedObjectReference _this, String[] key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String[]", key);
        wsc.invoke("CancelStorageDrsRecommendation", paras, null);
    }

    public void refreshStorageDrsRecommendation(ManagedObjectReference _this, ManagedObjectReference pod) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pod", "ManagedObjectReference", pod);
        wsc.invoke("RefreshStorageDrsRecommendation", paras, null);
    }

    public ManagedObjectReference configureStorageDrsForPod_Task(ManagedObjectReference _this, ManagedObjectReference pod, StorageDrsConfigSpec spec, boolean modify) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pod", "ManagedObjectReference", pod);
        paras[2] = new Argument("spec", "StorageDrsConfigSpec", spec);
        paras[3] = new Argument("modify", "boolean", modify);
        return (ManagedObjectReference) wsc.invoke("ConfigureStorageDrsForPod_Task", paras, "ManagedObjectReference");
    }

    public StoragePlacementResult recommendDatastores(ManagedObjectReference _this, StoragePlacementSpec storageSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("storageSpec", "StoragePlacementSpec", storageSpec);
        return (StoragePlacementResult) wsc.invoke("RecommendDatastores", paras, "StoragePlacementResult");
    }

    public void cancelTask(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("CancelTask", paras, null);
    }

    public void updateProgress(ManagedObjectReference _this, int percentDone) throws java.rmi.RemoteException, InvalidState, OutOfBounds, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("percentDone", "int", percentDone);
        wsc.invoke("UpdateProgress", paras, null);
    }

    public void setTaskState(ManagedObjectReference _this, TaskInfoState state, Object result, LocalizedMethodFault fault) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("state", "TaskInfoState", state);
        paras[2] = new Argument("result", "Object", result);
        paras[3] = new Argument("fault", "LocalizedMethodFault", fault);
        wsc.invoke("SetTaskState", paras, null);
    }

    public void setTaskDescription(ManagedObjectReference _this, LocalizableMessage description) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("description", "LocalizableMessage", description);
        wsc.invoke("SetTaskDescription", paras, null);
    }

    public TaskInfo[] readNextTasks(ManagedObjectReference _this, int maxCount) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("maxCount", "int", maxCount);
        return (TaskInfo[]) wsc.invoke("ReadNextTasks", paras, "TaskInfo[]");
    }

    public TaskInfo[] readPreviousTasks(ManagedObjectReference _this, int maxCount) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("maxCount", "int", maxCount);
        return (TaskInfo[]) wsc.invoke("ReadPreviousTasks", paras, "TaskInfo[]");
    }

    public ManagedObjectReference createCollectorForTasks(ManagedObjectReference _this, TaskFilterSpec filter) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filter", "TaskFilterSpec", filter);
        return (ManagedObjectReference) wsc.invoke("CreateCollectorForTasks", paras, "ManagedObjectReference");
    }

    public TaskInfo createTask(ManagedObjectReference _this, ManagedObjectReference obj, String taskTypeId, String initiatedBy, boolean cancelable, String parentTaskKey) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("obj", "ManagedObjectReference", obj);
        paras[2] = new Argument("taskTypeId", "String", taskTypeId);
        paras[3] = new Argument("initiatedBy", "String", initiatedBy);
        paras[4] = new Argument("cancelable", "boolean", cancelable);
        paras[5] = new Argument("parentTaskKey", "String", parentTaskKey);
        return (TaskInfo) wsc.invoke("CreateTask", paras, "TaskInfo");
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
        return (UserSearchResult[]) wsc.invoke("RetrieveUserGroups", paras, "UserSearchResult[]");
    }

    public void updateVAppConfig(ManagedObjectReference _this, VAppConfigSpec spec) throws java.rmi.RemoteException, TaskInProgress, VmConfigFault, ConcurrentAccess, FileFault, InvalidName, DuplicateName, InvalidState, InsufficientResourcesFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VAppConfigSpec", spec);
        wsc.invoke("UpdateVAppConfig", paras, null);
    }

    public void updateLinkedChildren(ManagedObjectReference _this, VirtualAppLinkInfo[] addChangeSet, ManagedObjectReference[] removeSet) throws java.rmi.RemoteException, ConcurrentAccess, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("addChangeSet", "VirtualAppLinkInfo[]", addChangeSet);
        paras[2] = new Argument("removeSet", "ManagedObjectReference[]", removeSet);
        wsc.invoke("UpdateLinkedChildren", paras, null);
    }

    public ManagedObjectReference cloneVApp_Task(ManagedObjectReference _this, String name, ManagedObjectReference target, VAppCloneSpec spec) throws java.rmi.RemoteException, InvalidState, InvalidDatastore, TaskInProgress, VmConfigFault, FileFault, MigrationFault, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("target", "ManagedObjectReference", target);
        paras[3] = new Argument("spec", "VAppCloneSpec", spec);
        return (ManagedObjectReference) wsc.invoke("CloneVApp_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference exportVApp(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidPowerState, TaskInProgress, InvalidState, FileFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("ExportVApp", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference powerOnVApp_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidState, InsufficientResourcesFault, VmConfigFault, VAppConfigFault, FileFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("PowerOnVApp_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference powerOffVApp_Task(ManagedObjectReference _this, boolean force) throws java.rmi.RemoteException, TaskInProgress, InvalidState, VAppConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("force", "boolean", force);
        return (ManagedObjectReference) wsc.invoke("PowerOffVApp_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference suspendVApp_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidState, VAppConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("SuspendVApp_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference unregisterVApp_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, ConcurrentAccess, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("unregisterVApp_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, VirtualDiskSpec spec) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("spec", "VirtualDiskSpec", spec);
        return (ManagedObjectReference) wsc.invoke("CreateVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference deleteVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) wsc.invoke("DeleteVirtualDisk_Task", paras, "ManagedObjectReference");
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
        return (ManagedObjectReference) wsc.invoke("MoveVirtualDisk_Task", paras, "ManagedObjectReference");
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
        return (ManagedObjectReference) wsc.invoke("CopyVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference extendVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, long newCapacityKb, Boolean eagerZero) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("newCapacityKb", "long", newCapacityKb);
        paras[4] = new Argument("eagerZero", "Boolean", eagerZero);
        return (ManagedObjectReference) wsc.invoke("ExtendVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public int queryVirtualDiskFragmentation(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        Integer ret = (Integer) wsc.invoke("QueryVirtualDiskFragmentation", paras, "int");
        return ret.intValue();
    }

    public ManagedObjectReference defragmentVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) wsc.invoke("DefragmentVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference shrinkVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, Boolean copy) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("copy", "Boolean", copy);
        return (ManagedObjectReference) wsc.invoke("ShrinkVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference inflateVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) wsc.invoke("InflateVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference eagerZeroVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) wsc.invoke("EagerZeroVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference zeroFillVirtualDisk_Task(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (ManagedObjectReference) wsc.invoke("ZeroFillVirtualDisk_Task", paras, "ManagedObjectReference");
    }

    public void setVirtualDiskUuid(ManagedObjectReference _this, String name, ManagedObjectReference datacenter, String uuid) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        paras[3] = new Argument("uuid", "String", uuid);
        wsc.invoke("SetVirtualDiskUuid", paras, null);
    }

    public String queryVirtualDiskUuid(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (String) wsc.invoke("QueryVirtualDiskUuid", paras, "String");
    }

    public HostDiskDimensionsChs queryVirtualDiskGeometry(ManagedObjectReference _this, String name, ManagedObjectReference datacenter) throws java.rmi.RemoteException, FileFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("datacenter", "ManagedObjectReference", datacenter);
        return (HostDiskDimensionsChs) wsc.invoke("QueryVirtualDiskGeometry", paras, "HostDiskDimensionsChs");
    }

    public void refreshStorageInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RefreshStorageInfo", paras, null);
    }

    public ManagedObjectReference createSnapshot_Task(ManagedObjectReference _this, String name, String description, boolean memory, boolean quiesce) throws java.rmi.RemoteException, TaskInProgress, SnapshotFault, VmConfigFault, FileFault, InvalidName, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("description", "String", description);
        paras[3] = new Argument("memory", "boolean", memory);
        paras[4] = new Argument("quiesce", "boolean", quiesce);
        return (ManagedObjectReference) wsc.invoke("CreateSnapshot_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference revertToCurrentSnapshot_Task(ManagedObjectReference _this, ManagedObjectReference host, Boolean suppressPowerOn) throws java.rmi.RemoteException, TaskInProgress, SnapshotFault, InsufficientResourcesFault, InvalidState, VmConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("suppressPowerOn", "Boolean", suppressPowerOn);
        return (ManagedObjectReference) wsc.invoke("RevertToCurrentSnapshot_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference removeAllSnapshots_Task(ManagedObjectReference _this, Boolean consolidate) throws java.rmi.RemoteException, TaskInProgress, InvalidState, SnapshotFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("consolidate", "Boolean", consolidate);
        return (ManagedObjectReference) wsc.invoke("RemoveAllSnapshots_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference consolidateVMDisks_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidState, FileFault, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("ConsolidateVMDisks_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference estimateStorageForConsolidateSnapshots_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidState, FileFault, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("EstimateStorageForConsolidateSnapshots_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference reconfigVM_Task(ManagedObjectReference _this, VirtualMachineConfigSpec spec) throws java.rmi.RemoteException, TaskInProgress, VmConfigFault, ConcurrentAccess, FileFault, InvalidName, DuplicateName, InvalidState, InsufficientResourcesFault, InvalidDatastore, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VirtualMachineConfigSpec", spec);
        return (ManagedObjectReference) wsc.invoke("ReconfigVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference upgradeVM_Task(ManagedObjectReference _this, String version) throws java.rmi.RemoteException, InvalidState, TaskInProgress, AlreadyUpgraded, NoDiskFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("version", "String", version);
        return (ManagedObjectReference) wsc.invoke("UpgradeVM_Task", paras, "ManagedObjectReference");
    }

    public String extractOvfEnvironment(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) wsc.invoke("ExtractOvfEnvironment", paras, "String");
    }

    public ManagedObjectReference powerOnVM_Task(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, TaskInProgress, InvalidState, InsufficientResourcesFault, VmConfigFault, FileFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) wsc.invoke("PowerOnVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference powerOffVM_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("PowerOffVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference suspendVM_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("SuspendVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference resetVM_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("ResetVM_Task", paras, "ManagedObjectReference");
    }

    public void shutdownGuest(ManagedObjectReference _this) throws java.rmi.RemoteException, ToolsUnavailable, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("ShutdownGuest", paras, null);
    }

    public void rebootGuest(ManagedObjectReference _this) throws java.rmi.RemoteException, ToolsUnavailable, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RebootGuest", paras, null);
    }

    public void standbyGuest(ManagedObjectReference _this) throws java.rmi.RemoteException, ToolsUnavailable, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("StandbyGuest", paras, null);
    }

    public void answerVM(ManagedObjectReference _this, String questionId, String answerChoice) throws java.rmi.RemoteException, ConcurrentAccess, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("questionId", "String", questionId);
        paras[2] = new Argument("answerChoice", "String", answerChoice);
        wsc.invoke("AnswerVM", paras, null);
    }

    public ManagedObjectReference customizeVM_Task(ManagedObjectReference _this, CustomizationSpec spec) throws java.rmi.RemoteException, CustomizationFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "CustomizationSpec", spec);
        return (ManagedObjectReference) wsc.invoke("CustomizeVM_Task", paras, "ManagedObjectReference");
    }

    public void checkCustomizationSpec(ManagedObjectReference _this, CustomizationSpec spec) throws java.rmi.RemoteException, CustomizationFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "CustomizationSpec", spec);
        wsc.invoke("CheckCustomizationSpec", paras, null);
    }

    public ManagedObjectReference migrateVM_Task(ManagedObjectReference _this, ManagedObjectReference pool, ManagedObjectReference host, VirtualMachineMovePriority priority, VirtualMachinePowerState state) throws java.rmi.RemoteException, MigrationFault, FileFault, Timedout, InsufficientResourcesFault, InvalidState, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pool", "ManagedObjectReference", pool);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        paras[3] = new Argument("priority", "VirtualMachineMovePriority", priority);
        paras[4] = new Argument("state", "VirtualMachinePowerState", state);
        return (ManagedObjectReference) wsc.invoke("MigrateVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference relocateVM_Task(ManagedObjectReference _this, VirtualMachineRelocateSpec spec, VirtualMachineMovePriority priority) throws java.rmi.RemoteException, InvalidState, InvalidDatastore, MigrationFault, VmConfigFault, FileFault, Timedout, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VirtualMachineRelocateSpec", spec);
        paras[2] = new Argument("priority", "VirtualMachineMovePriority", priority);
        return (ManagedObjectReference) wsc.invoke("RelocateVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference cloneVM_Task(ManagedObjectReference _this, ManagedObjectReference folder, String name, VirtualMachineCloneSpec spec) throws java.rmi.RemoteException, CustomizationFault, InvalidState, InvalidDatastore, TaskInProgress, VmConfigFault, FileFault, MigrationFault, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("folder", "ManagedObjectReference", folder);
        paras[2] = new Argument("name", "String", name);
        paras[3] = new Argument("spec", "VirtualMachineCloneSpec", spec);
        return (ManagedObjectReference) wsc.invoke("CloneVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference exportVm(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidPowerState, TaskInProgress, InvalidState, FileFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("ExportVm", paras, "ManagedObjectReference");
    }

    public void markAsTemplate(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, VmConfigFault, FileFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("MarkAsTemplate", paras, null);
    }

    public void markAsVirtualMachine(ManagedObjectReference _this, ManagedObjectReference pool, ManagedObjectReference host) throws java.rmi.RemoteException, InvalidState, InvalidDatastore, VmConfigFault, FileFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pool", "ManagedObjectReference", pool);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        wsc.invoke("MarkAsVirtualMachine", paras, null);
    }

    public void unregisterVM(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidPowerState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("UnregisterVM", paras, null);
    }

    public void resetGuestInformation(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("ResetGuestInformation", paras, null);
    }

    public void mountToolsInstaller(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, VmConfigFault, VmToolsUpgradeFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("MountToolsInstaller", paras, null);
    }

    public void unmountToolsInstaller(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("UnmountToolsInstaller", paras, null);
    }

    public ManagedObjectReference upgradeTools_Task(ManagedObjectReference _this, String installerOptions) throws java.rmi.RemoteException, InvalidState, TaskInProgress, VmToolsUpgradeFault, ToolsUnavailable, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("installerOptions", "String", installerOptions);
        return (ManagedObjectReference) wsc.invoke("UpgradeTools_Task", paras, "ManagedObjectReference");
    }

    public VirtualMachineMksTicket acquireMksTicket(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VirtualMachineMksTicket) wsc.invoke("AcquireMksTicket", paras, "VirtualMachineMksTicket");
    }

    public VirtualMachineTicket acquireTicket(ManagedObjectReference _this, String ticketType) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ticketType", "String", ticketType);
        return (VirtualMachineTicket) wsc.invoke("AcquireTicket", paras, "VirtualMachineTicket");
    }

    public void setScreenResolution(ManagedObjectReference _this, int width, int height) throws java.rmi.RemoteException, InvalidState, ToolsUnavailable, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("width", "int", width);
        paras[2] = new Argument("height", "int", height);
        wsc.invoke("SetScreenResolution", paras, null);
    }

    public void defragmentAllDisks(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, InvalidPowerState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("DefragmentAllDisks", paras, null);
    }

    public ManagedObjectReference createSecondaryVM_Task(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, TaskInProgress, InvalidState, InsufficientResourcesFault, VmFaultToleranceIssue, FileFault, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) wsc.invoke("CreateSecondaryVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference turnOffFaultToleranceForVM_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, VmFaultToleranceIssue, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("TurnOffFaultToleranceForVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference makePrimaryVM_Task(ManagedObjectReference _this, ManagedObjectReference vm) throws java.rmi.RemoteException, TaskInProgress, VmFaultToleranceIssue, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        return (ManagedObjectReference) wsc.invoke("MakePrimaryVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference terminateFaultTolerantVM_Task(ManagedObjectReference _this, ManagedObjectReference vm) throws java.rmi.RemoteException, TaskInProgress, VmFaultToleranceIssue, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        return (ManagedObjectReference) wsc.invoke("TerminateFaultTolerantVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference disableSecondaryVM_Task(ManagedObjectReference _this, ManagedObjectReference vm) throws java.rmi.RemoteException, TaskInProgress, VmFaultToleranceIssue, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        return (ManagedObjectReference) wsc.invoke("DisableSecondaryVM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference enableSecondaryVM_Task(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference host) throws java.rmi.RemoteException, TaskInProgress, VmFaultToleranceIssue, InvalidState, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) wsc.invoke("EnableSecondaryVM_Task", paras, "ManagedObjectReference");
    }

    public void setDisplayTopology(ManagedObjectReference _this, VirtualMachineDisplayTopology[] displays) throws java.rmi.RemoteException, InvalidState, ToolsUnavailable, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("displays", "VirtualMachineDisplayTopology[]", displays);
        wsc.invoke("SetDisplayTopology", paras, null);
    }

    public ManagedObjectReference startRecording_Task(ManagedObjectReference _this, String name, String description) throws java.rmi.RemoteException, InvalidState, InvalidPowerState, TaskInProgress, FileFault, SnapshotFault, VmConfigFault, RecordReplayDisabled, HostIncompatibleForRecordReplay, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("description", "String", description);
        return (ManagedObjectReference) wsc.invoke("StartRecording_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference stopRecording_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, InvalidPowerState, TaskInProgress, FileFault, SnapshotFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("StopRecording_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference startReplaying_Task(ManagedObjectReference _this, ManagedObjectReference replaySnapshot) throws java.rmi.RemoteException, InvalidState, InvalidPowerState, TaskInProgress, FileFault, SnapshotFault, NotFound, VmConfigFault, RecordReplayDisabled, HostIncompatibleForRecordReplay, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("replaySnapshot", "ManagedObjectReference", replaySnapshot);
        return (ManagedObjectReference) wsc.invoke("StartReplaying_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference stopReplaying_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, InvalidPowerState, TaskInProgress, FileFault, SnapshotFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("StopReplaying_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference promoteDisks_Task(ManagedObjectReference _this, boolean unlink, VirtualDisk[] disks) throws java.rmi.RemoteException, InvalidState, InvalidPowerState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("unlink", "boolean", unlink);
        paras[2] = new Argument("disks", "VirtualDisk[]", disks);
        return (ManagedObjectReference) wsc.invoke("PromoteDisks_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createScreenshot_Task(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, FileFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("CreateScreenshot_Task", paras, "ManagedObjectReference");
    }

    public DiskChangeInfo queryChangedDiskAreas(ManagedObjectReference _this, ManagedObjectReference snapshot, int deviceKey, long startOffset, String changeId) throws java.rmi.RemoteException, FileFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("snapshot", "ManagedObjectReference", snapshot);
        paras[2] = new Argument("deviceKey", "int", deviceKey);
        paras[3] = new Argument("startOffset", "long", startOffset);
        paras[4] = new Argument("changeId", "String", changeId);
        return (DiskChangeInfo) wsc.invoke("QueryChangedDiskAreas", paras, "DiskChangeInfo");
    }

    public String[] queryUnownedFiles(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String[]) wsc.invoke("QueryUnownedFiles", paras, "String[]");
    }

    public ManagedObjectReference reloadVirtualMachineFromPath_Task(ManagedObjectReference _this, String configurationPath) throws java.rmi.RemoteException, InvalidPowerState, TaskInProgress, FileFault, InvalidState, VmConfigFault, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configurationPath", "String", configurationPath);
        return (ManagedObjectReference) wsc.invoke("reloadVirtualMachineFromPath_Task", paras, "ManagedObjectReference");
    }

    public LocalizedMethodFault[] queryFaultToleranceCompatibility(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (LocalizedMethodFault[]) wsc.invoke("QueryFaultToleranceCompatibility", paras, "LocalizedMethodFault[]");
    }

    public void terminateVM(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("TerminateVM", paras, null);
    }

    public void removeAlarm(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RemoveAlarm", paras, null);
    }

    public void reconfigureAlarm(ManagedObjectReference _this, AlarmSpec spec) throws java.rmi.RemoteException, InvalidName, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "AlarmSpec", spec);
        wsc.invoke("ReconfigureAlarm", paras, null);
    }

    public ManagedObjectReference createAlarm(ManagedObjectReference _this, ManagedObjectReference entity, AlarmSpec spec) throws java.rmi.RemoteException, InvalidName, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("spec", "AlarmSpec", spec);
        return (ManagedObjectReference) wsc.invoke("CreateAlarm", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference[] getAlarm(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        return (ManagedObjectReference[]) wsc.invoke("GetAlarm", paras, "ManagedObjectReference[]");
    }

    public boolean areAlarmActionsEnabled(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        Boolean ret = (Boolean) wsc.invoke("AreAlarmActionsEnabled", paras, "boolean");
        return ret.booleanValue();
    }

    public void enableAlarmActions(ManagedObjectReference _this, ManagedObjectReference entity, boolean enabled) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("enabled", "boolean", enabled);
        wsc.invoke("EnableAlarmActions", paras, null);
    }

    public AlarmState[] getAlarmState(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        return (AlarmState[]) wsc.invoke("GetAlarmState", paras, "AlarmState[]");
    }

    public void acknowledgeAlarm(ManagedObjectReference _this, ManagedObjectReference alarm, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("alarm", "ManagedObjectReference", alarm);
        paras[2] = new Argument("entity", "ManagedObjectReference", entity);
        wsc.invoke("AcknowledgeAlarm", paras, null);
    }

    public void setAlarmStatus(ManagedObjectReference _this, ManagedObjectReference alarm, ManagedObjectReference entity, String status) throws RemoteException, RuntimeFault {
        Argument[] params = new Argument[4];
        params[0] = new Argument("_this", "ManagedObjectReference", _this);
        params[1] = new Argument("alarm", "ManagedObjectReference", alarm);
        params[2] = new Argument("entity", "ManagedObjectReference", entity);
        params[3] = new Argument("status", "String", status);
        wsc.invoke("SetAlarmStatus", params, null);
    }

    public ManagedObjectReference reconfigureDVPortgroup_Task(ManagedObjectReference _this, DVPortgroupConfigSpec spec) throws java.rmi.RemoteException, DvsFault, ConcurrentAccess, DuplicateName, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "DVPortgroupConfigSpec", spec);
        return (ManagedObjectReference) wsc.invoke("ReconfigureDVPortgroup_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference dVPortgroupRollback_Task(ManagedObjectReference _this, EntityBackupConfig entityBackup) throws java.rmi.RemoteException, DvsFault, RollbackFailure, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entityBackup", "EntityBackupConfig", entityBackup);
        return (ManagedObjectReference) wsc.invoke("DVPortgroupRollback_Task", paras, "ManagedObjectReference");
    }

    public DistributedVirtualSwitchProductSpec[] queryAvailableDvsSpec(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (DistributedVirtualSwitchProductSpec[]) wsc.invoke("QueryAvailableDvsSpec", paras, "DistributedVirtualSwitchProductSpec[]");
    }

    public ManagedObjectReference[] queryCompatibleHostForNewDvs(ManagedObjectReference _this, ManagedObjectReference container, boolean recursive, DistributedVirtualSwitchProductSpec switchProductSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("container", "ManagedObjectReference", container);
        paras[2] = new Argument("recursive", "boolean", recursive);
        paras[3] = new Argument("switchProductSpec", "DistributedVirtualSwitchProductSpec", switchProductSpec);
        return (ManagedObjectReference[]) wsc.invoke("QueryCompatibleHostForNewDvs", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference[] queryCompatibleHostForExistingDvs(ManagedObjectReference _this, ManagedObjectReference container, boolean recursive, ManagedObjectReference dvs) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("container", "ManagedObjectReference", container);
        paras[2] = new Argument("recursive", "boolean", recursive);
        paras[3] = new Argument("dvs", "ManagedObjectReference", dvs);
        return (ManagedObjectReference[]) wsc.invoke("QueryCompatibleHostForExistingDvs", paras, "ManagedObjectReference[]");
    }

    public DistributedVirtualSwitchHostProductSpec[] queryDvsCompatibleHostSpec(ManagedObjectReference _this, DistributedVirtualSwitchProductSpec switchProductSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("switchProductSpec", "DistributedVirtualSwitchProductSpec", switchProductSpec);
        return (DistributedVirtualSwitchHostProductSpec[]) wsc.invoke("QueryDvsCompatibleHostSpec", paras, "DistributedVirtualSwitchHostProductSpec[]");
    }

    public DVSFeatureCapability queryDvsFeatureCapability(ManagedObjectReference _this, DistributedVirtualSwitchProductSpec switchProductSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("switchProductSpec", "DistributedVirtualSwitchProductSpec", switchProductSpec);
        return (DVSFeatureCapability) wsc.invoke("QueryDvsFeatureCapability", paras, "DVSFeatureCapability");
    }

    public ManagedObjectReference queryDvsByUuid(ManagedObjectReference _this, String uuid) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("uuid", "String", uuid);
        return (ManagedObjectReference) wsc.invoke("QueryDvsByUuid", paras, "ManagedObjectReference");
    }

    public DVSManagerDvsConfigTarget queryDvsConfigTarget(ManagedObjectReference _this, ManagedObjectReference host, ManagedObjectReference dvs) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("dvs", "ManagedObjectReference", dvs);
        return (DVSManagerDvsConfigTarget) wsc.invoke("QueryDvsConfigTarget", paras, "DVSManagerDvsConfigTarget");
    }

    public DistributedVirtualSwitchManagerCompatibilityResult[] queryDvsCheckCompatibility(ManagedObjectReference _this, DistributedVirtualSwitchManagerHostContainer hostContainer, DistributedVirtualSwitchManagerDvsProductSpec dvsProductSpec, DistributedVirtualSwitchManagerHostDvsFilterSpec[] hostFilterSpec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hostContainer", "DistributedVirtualSwitchManagerHostContainer", hostContainer);
        paras[2] = new Argument("dvsProductSpec", "DistributedVirtualSwitchManagerDvsProductSpec", dvsProductSpec);
        paras[3] = new Argument("hostFilterSpec", "DistributedVirtualSwitchManagerHostDvsFilterSpec[]", hostFilterSpec);
        return (DistributedVirtualSwitchManagerCompatibilityResult[]) wsc.invoke("QueryDvsCheckCompatibility", paras, "DistributedVirtualSwitchManagerCompatibilityResult[]");
    }

    public ManagedObjectReference rectifyDvsOnHost_Task(ManagedObjectReference _this, ManagedObjectReference[] hosts) throws java.rmi.RemoteException, DvsFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hosts", "ManagedObjectReference[]", hosts);
        return (ManagedObjectReference) wsc.invoke("RectifyDvsOnHost_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference dVSManagerExportEntity_Task(ManagedObjectReference _this, SelectionSet[] selectionSet) throws java.rmi.RemoteException, NotFound, BackupBlobWriteFailure, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("selectionSet", "SelectionSet[]", selectionSet);
        return (ManagedObjectReference) wsc.invoke("DVSManagerExportEntity_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference dVSManagerImportEntity_Task(ManagedObjectReference _this, EntityBackupConfig[] entityBackup, String importType) throws java.rmi.RemoteException, DvsFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entityBackup", "EntityBackupConfig[]", entityBackup);
        paras[2] = new Argument("importType", "String", importType);
        return (ManagedObjectReference) wsc.invoke("DVSManagerImportEntity_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference dVSManagerLookupDvPortGroup(ManagedObjectReference _this, String switchUuid, String portgroupKey) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("switchUuid", "String", switchUuid);
        paras[2] = new Argument("portgroupKey", "String", portgroupKey);
        return (ManagedObjectReference) wsc.invoke("DVSManagerLookupDvPortGroup", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference updateDVSLacpGroupConfig_Task(ManagedObjectReference _this, VMwareDvsLacpGroupSpec[] lacpGroupSpec) throws java.rmi.RemoteException, DvsFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lacpGroupSpec", "VMwareDvsLacpGroupSpec[]", lacpGroupSpec);
        return (ManagedObjectReference) wsc.invoke("UpdateDVSLacpGroupConfig_Task", paras, "ManagedObjectReference");
    }

    public Event[] readNextEvents(ManagedObjectReference _this, int maxCount) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("maxCount", "int", maxCount);
        return (Event[]) wsc.invoke("ReadNextEvents", paras, "Event[]");
    }

    public Event[] readPreviousEvents(ManagedObjectReference _this, int maxCount) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("maxCount", "int", maxCount);
        return (Event[]) wsc.invoke("ReadPreviousEvents", paras, "Event[]");
    }

    public EventArgDesc[] retrieveArgumentDescription(ManagedObjectReference _this, String eventTypeId) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("eventTypeId", "String", eventTypeId);
        return (EventArgDesc[]) wsc.invoke("RetrieveArgumentDescription", paras, "EventArgDesc[]");
    }

    public ManagedObjectReference createCollectorForEvents(ManagedObjectReference _this, EventFilterSpec filter) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filter", "EventFilterSpec", filter);
        return (ManagedObjectReference) wsc.invoke("CreateCollectorForEvents", paras, "ManagedObjectReference");
    }

    public void logUserEvent(ManagedObjectReference _this, ManagedObjectReference entity, String msg) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("msg", "String", msg);
        wsc.invoke("LogUserEvent", paras, null);
    }

    public Event[] queryEvents(ManagedObjectReference _this, EventFilterSpec filter) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("filter", "EventFilterSpec", filter);
        return (Event[]) wsc.invoke("QueryEvents", paras, "Event[]");
    }

    public void postEvent(ManagedObjectReference _this, Event eventToPost, TaskInfo taskInfo) throws java.rmi.RemoteException, InvalidEvent, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("eventToPost", "Event", eventToPost);
        paras[2] = new Argument("taskInfo", "TaskInfo", taskInfo);
        wsc.invoke("PostEvent", paras, null);
    }

    public ManagedObjectReference joinDomain_Task(ManagedObjectReference _this, String domainName, String userName, String password) throws java.rmi.RemoteException, InvalidState, HostConfigFault, InvalidLogin, ActiveDirectoryFault, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("domainName", "String", domainName);
        paras[2] = new Argument("userName", "String", userName);
        paras[3] = new Argument("password", "String", password);
        return (ManagedObjectReference) wsc.invoke("JoinDomain_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference joinDomainWithCAM_Task(ManagedObjectReference _this, String domainName, String camServer) throws java.rmi.RemoteException, InvalidState, HostConfigFault, ActiveDirectoryFault, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("domainName", "String", domainName);
        paras[2] = new Argument("camServer", "String", camServer);
        return (ManagedObjectReference) wsc.invoke("JoinDomainWithCAM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference importCertificateForCAM_Task(ManagedObjectReference _this, String certPath, String camServer) throws java.rmi.RemoteException, FileNotFound, ActiveDirectoryFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("certPath", "String", certPath);
        paras[2] = new Argument("camServer", "String", camServer);
        return (ManagedObjectReference) wsc.invoke("ImportCertificateForCAM_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference leaveCurrentDomain_Task(ManagedObjectReference _this, boolean force) throws java.rmi.RemoteException, InvalidState, AuthMinimumAdminPermission, ActiveDirectoryFault, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("force", "boolean", force);
        return (ManagedObjectReference) wsc.invoke("LeaveCurrentDomain_Task", paras, "ManagedObjectReference");
    }

    public void reconfigureAutostart(ManagedObjectReference _this, HostAutoStartManagerConfig spec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostAutoStartManagerConfig", spec);
        wsc.invoke("ReconfigureAutostart", paras, null);
    }

    public void autoStartPowerOn(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("AutoStartPowerOn", paras, null);
    }

    public void autoStartPowerOff(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("AutoStartPowerOff", paras, null);
    }

    public HostBootDeviceInfo queryBootDevices(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostBootDeviceInfo) wsc.invoke("QueryBootDevices", paras, "HostBootDeviceInfo");
    }

    public void updateBootDevice(ManagedObjectReference _this, String key) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "String", key);
        wsc.invoke("UpdateBootDevice", paras, null);
    }

    public ManagedObjectReference configureHostCache_Task(ManagedObjectReference _this, HostCacheConfigurationSpec spec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostCacheConfigurationSpec", spec);
        return (ManagedObjectReference) wsc.invoke("ConfigureHostCache_Task", paras, "ManagedObjectReference");
    }

    public void enableHyperThreading(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("EnableHyperThreading", paras, null);
    }

    public void disableHyperThreading(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("DisableHyperThreading", paras, null);
    }

    public ManagedObjectReference searchDatastore_Task(ManagedObjectReference _this, String datastorePath, HostDatastoreBrowserSearchSpec searchSpec) throws java.rmi.RemoteException, InvalidDatastore, FileFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastorePath", "String", datastorePath);
        paras[2] = new Argument("searchSpec", "HostDatastoreBrowserSearchSpec", searchSpec);
        return (ManagedObjectReference) wsc.invoke("SearchDatastore_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference searchDatastoreSubFolders_Task(ManagedObjectReference _this, String datastorePath, HostDatastoreBrowserSearchSpec searchSpec) throws java.rmi.RemoteException, InvalidDatastore, FileFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastorePath", "String", datastorePath);
        paras[2] = new Argument("searchSpec", "HostDatastoreBrowserSearchSpec", searchSpec);
        return (ManagedObjectReference) wsc.invoke("SearchDatastoreSubFolders_Task", paras, "ManagedObjectReference");
    }

    public void deleteFile(ManagedObjectReference _this, String datastorePath) throws java.rmi.RemoteException, InvalidDatastore, FileFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastorePath", "String", datastorePath);
        wsc.invoke("DeleteFile", paras, null);
    }

    public void updateLocalSwapDatastore(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, InaccessibleDatastore, DatastoreNotWritableOnHost, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        wsc.invoke("UpdateLocalSwapDatastore", paras, null);
    }

    public HostScsiDisk[] queryAvailableDisksForVmfs(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (HostScsiDisk[]) wsc.invoke("QueryAvailableDisksForVmfs", paras, "HostScsiDisk[]");
    }

    public VmfsDatastoreOption[] queryVmfsDatastoreCreateOptions(ManagedObjectReference _this, String devicePath) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("devicePath", "String", devicePath);
        return (VmfsDatastoreOption[]) wsc.invoke("QueryVmfsDatastoreCreateOptions", paras, "VmfsDatastoreOption[]");
    }

    public VmfsDatastoreOption[] queryVmfsDatastoreCreateOptions(ManagedObjectReference _this, String devicePath, int vmfsMajorVersion) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("devicePath", "String", devicePath);
        paras[2] = new Argument("vmfsMajorVersion", "int", vmfsMajorVersion);
        return (VmfsDatastoreOption[]) wsc.invoke("QueryVmfsDatastoreCreateOptions", paras, "VmfsDatastoreOption[]");
    }

    public ManagedObjectReference createVmfsDatastore(ManagedObjectReference _this, VmfsDatastoreCreateSpec spec) throws java.rmi.RemoteException, DuplicateName, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VmfsDatastoreCreateSpec", spec);
        return (ManagedObjectReference) wsc.invoke("CreateVmfsDatastore", paras, "ManagedObjectReference");
    }

    public VmfsDatastoreOption[] queryVmfsDatastoreExtendOptions(ManagedObjectReference _this, ManagedObjectReference datastore, String devicePath, Boolean suppressExpandCandidates) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("devicePath", "String", devicePath);
        paras[3] = new Argument("suppressExpandCandidates", "Boolean", suppressExpandCandidates);
        return (VmfsDatastoreOption[]) wsc.invoke("QueryVmfsDatastoreExtendOptions", paras, "VmfsDatastoreOption[]");
    }

    public VmfsDatastoreOption[] queryVmfsDatastoreExpandOptions(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        return (VmfsDatastoreOption[]) wsc.invoke("QueryVmfsDatastoreExpandOptions", paras, "VmfsDatastoreOption[]");
    }

    public ManagedObjectReference extendVmfsDatastore(ManagedObjectReference _this, ManagedObjectReference datastore, VmfsDatastoreExtendSpec spec) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("spec", "VmfsDatastoreExtendSpec", spec);
        return (ManagedObjectReference) wsc.invoke("ExtendVmfsDatastore", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference expandVmfsDatastore(ManagedObjectReference _this, ManagedObjectReference datastore, VmfsDatastoreExpandSpec spec) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        paras[2] = new Argument("spec", "VmfsDatastoreExpandSpec", spec);
        return (ManagedObjectReference) wsc.invoke("ExpandVmfsDatastore", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createNasDatastore(ManagedObjectReference _this, HostNasVolumeSpec spec) throws java.rmi.RemoteException, DuplicateName, AlreadyExists, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostNasVolumeSpec", spec);
        return (ManagedObjectReference) wsc.invoke("CreateNasDatastore", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createLocalDatastore(ManagedObjectReference _this, String name, String path) throws java.rmi.RemoteException, DuplicateName, HostConfigFault, FileNotFound, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("path", "String", path);
        return (ManagedObjectReference) wsc.invoke("CreateLocalDatastore", paras, "ManagedObjectReference");
    }

    public void removeDatastore(ManagedObjectReference _this, ManagedObjectReference datastore) throws java.rmi.RemoteException, NotFound, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("datastore", "ManagedObjectReference", datastore);
        wsc.invoke("RemoveDatastore", paras, null);
    }

    public void configureDatastorePrincipal(ManagedObjectReference _this, String userName, String password) throws java.rmi.RemoteException, InvalidState, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("userName", "String", userName);
        paras[2] = new Argument("password", "String", password);
        wsc.invoke("ConfigureDatastorePrincipal", paras, null);
    }

    public HostUnresolvedVmfsVolume[] queryUnresolvedVmfsVolumes(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostUnresolvedVmfsVolume[]) wsc.invoke("QueryUnresolvedVmfsVolumes", paras, "HostUnresolvedVmfsVolume[]");
    }

    public ManagedObjectReference resignatureUnresolvedVmfsVolume_Task(ManagedObjectReference _this, HostUnresolvedVmfsResignatureSpec resolutionSpec) throws java.rmi.RemoteException, VmfsAmbiguousMount, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("resolutionSpec", "HostUnresolvedVmfsResignatureSpec", resolutionSpec);
        return (ManagedObjectReference) wsc.invoke("ResignatureUnresolvedVmfsVolume_Task", paras, "ManagedObjectReference");
    }

    public void updateDateTimeConfig(ManagedObjectReference _this, HostDateTimeConfig config) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostDateTimeConfig", config);
        wsc.invoke("UpdateDateTimeConfig", paras, null);
    }

    public HostDateTimeSystemTimeZone[] queryAvailableTimeZones(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostDateTimeSystemTimeZone[]) wsc.invoke("QueryAvailableTimeZones", paras, "HostDateTimeSystemTimeZone[]");
    }

    public Calendar queryDateTime(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (Calendar) wsc.invoke("QueryDateTime", paras, "Calendar");
    }

    public void updateDateTime(ManagedObjectReference _this, Calendar dateTime) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("dateTime", "Calendar", dateTime);
        wsc.invoke("UpdateDateTime", paras, null);
    }

    public void refreshDateTimeSystem(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RefreshDateTimeSystem", paras, null);
    }

    public HostDiagnosticPartition[] queryAvailablePartition(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostDiagnosticPartition[]) wsc.invoke("QueryAvailablePartition", paras, "HostDiagnosticPartition[]");
    }

    public void selectActivePartition(ManagedObjectReference _this, HostScsiDiskPartition partition) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("partition", "HostScsiDiskPartition", partition);
        wsc.invoke("SelectActivePartition", paras, null);
    }

    public HostDiagnosticPartitionCreateOption[] queryPartitionCreateOptions(ManagedObjectReference _this, String storageType, String diagnosticType) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("storageType", "String", storageType);
        paras[2] = new Argument("diagnosticType", "String", diagnosticType);
        return (HostDiagnosticPartitionCreateOption[]) wsc.invoke("QueryPartitionCreateOptions", paras, "HostDiagnosticPartitionCreateOption[]");
    }

    public HostDiagnosticPartitionCreateDescription queryPartitionCreateDesc(ManagedObjectReference _this, String diskUuid, String diagnosticType) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("diskUuid", "String", diskUuid);
        paras[2] = new Argument("diagnosticType", "String", diagnosticType);
        return (HostDiagnosticPartitionCreateDescription) wsc.invoke("QueryPartitionCreateDesc", paras, "HostDiagnosticPartitionCreateDescription");
    }

    public void createDiagnosticPartition(ManagedObjectReference _this, HostDiagnosticPartitionCreateSpec spec) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostDiagnosticPartitionCreateSpec", spec);
        wsc.invoke("CreateDiagnosticPartition", paras, null);
    }

    public void esxAgentHostManagerUpdateConfig(ManagedObjectReference _this, HostEsxAgentHostManagerConfigInfo configInfo) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configInfo", "HostEsxAgentHostManagerConfigInfo", configInfo);
        wsc.invoke("EsxAgentHostManagerUpdateConfig", paras, null);
    }

    public void updateDefaultPolicy(ManagedObjectReference _this, HostFirewallDefaultPolicy defaultPolicy) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("defaultPolicy", "HostFirewallDefaultPolicy", defaultPolicy);
        wsc.invoke("UpdateDefaultPolicy", paras, null);
    }

    public void enableRuleset(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        wsc.invoke("EnableRuleset", paras, null);
    }

    public void disableRuleset(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        wsc.invoke("DisableRuleset", paras, null);
    }

    public void updateRuleset(ManagedObjectReference _this, String id, HostFirewallRulesetRulesetSpec spec) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        paras[2] = new Argument("spec", "HostFirewallRulesetRulesetSpec", spec);
        wsc.invoke("UpdateRuleset", paras, null);
    }

    public void refreshFirewall(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RefreshFirewall", paras, null);
    }

    public void resetFirmwareToFactoryDefaults(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("ResetFirmwareToFactoryDefaults", paras, null);
    }

    public String backupFirmwareConfiguration(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) wsc.invoke("BackupFirmwareConfiguration", paras, "String");
    }

    public String queryFirmwareConfigUploadURL(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) wsc.invoke("QueryFirmwareConfigUploadURL", paras, "String");
    }

    public void restoreFirmwareConfiguration(ManagedObjectReference _this, boolean force) throws java.rmi.RemoteException, InvalidState, FileFault, MismatchedBundle, InvalidBundle, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("force", "boolean", force);
        wsc.invoke("RestoreFirmwareConfiguration", paras, null);
    }

    public void refreshGraphicsManager(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RefreshGraphicsManager", paras, null);
    }

    public boolean isSharedGraphicsActive(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        Boolean ret = (Boolean) wsc.invoke("IsSharedGraphicsActive", paras, "boolean");
        return ret.booleanValue();
    }

    public void refreshHealthStatusSystem(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RefreshHealthStatusSystem", paras, null);
    }

    public void resetSystemHealthInfo(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("ResetSystemHealthInfo", paras, null);
    }

    public String hostImageConfigGetAcceptance(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) wsc.invoke("HostImageConfigGetAcceptance", paras, "String");
    }

    public HostImageProfileSummary hostImageConfigGetProfile(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostImageProfileSummary) wsc.invoke("HostImageConfigGetProfile", paras, "HostImageProfileSummary");
    }

    public void updateHostImageAcceptanceLevel(ManagedObjectReference _this, String newAcceptanceLevel) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("newAcceptanceLevel", "String", newAcceptanceLevel);
        wsc.invoke("UpdateHostImageAcceptanceLevel", paras, null);
    }

    public IscsiStatus queryVnicStatus(ManagedObjectReference _this, String vnicDevice) throws java.rmi.RemoteException, IscsiFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vnicDevice", "String", vnicDevice);
        return (IscsiStatus) wsc.invoke("QueryVnicStatus", paras, "IscsiStatus");
    }

    public IscsiStatus queryPnicStatus(ManagedObjectReference _this, String pnicDevice) throws java.rmi.RemoteException, IscsiFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pnicDevice", "String", pnicDevice);
        return (IscsiStatus) wsc.invoke("QueryPnicStatus", paras, "IscsiStatus");
    }

    public IscsiPortInfo[] queryBoundVnics(ManagedObjectReference _this, String iScsiHbaName) throws java.rmi.RemoteException, IscsiFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaName", "String", iScsiHbaName);
        return (IscsiPortInfo[]) wsc.invoke("QueryBoundVnics", paras, "IscsiPortInfo[]");
    }

    public IscsiPortInfo[] queryCandidateNics(ManagedObjectReference _this, String iScsiHbaName) throws java.rmi.RemoteException, IscsiFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaName", "String", iScsiHbaName);
        return (IscsiPortInfo[]) wsc.invoke("QueryCandidateNics", paras, "IscsiPortInfo[]");
    }

    public void bindVnic(ManagedObjectReference _this, String iScsiHbaName, String vnicDevice) throws java.rmi.RemoteException, IscsiFaultVnicAlreadyBound, IscsiFaultVnicHasNoUplinks, IscsiFaultVnicHasMultipleUplinks, IscsiFaultVnicHasWrongUplink, IscsiFaultVnicNotFound, IscsiFaultInvalidVnic, PlatformConfigFault, IscsiFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaName", "String", iScsiHbaName);
        paras[2] = new Argument("vnicDevice", "String", vnicDevice);
        wsc.invoke("BindVnic", paras, null);
    }

    public void unbindVnic(ManagedObjectReference _this, String iScsiHbaName, String vnicDevice, boolean force) throws java.rmi.RemoteException, IscsiFaultVnicNotBound, IscsiFaultVnicHasActivePaths, IscsiFaultVnicIsLastPath, PlatformConfigFault, IscsiFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaName", "String", iScsiHbaName);
        paras[2] = new Argument("vnicDevice", "String", vnicDevice);
        paras[3] = new Argument("force", "boolean", force);
        wsc.invoke("UnbindVnic", paras, null);
    }

    public IscsiMigrationDependency queryMigrationDependencies(ManagedObjectReference _this, String[] pnicDevice) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pnicDevice", "String[]", pnicDevice);
        return (IscsiMigrationDependency) wsc.invoke("QueryMigrationDependencies", paras, "IscsiMigrationDependency");
    }

    public KernelModuleInfo[] queryModules(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (KernelModuleInfo[]) wsc.invoke("QueryModules", paras, "KernelModuleInfo[]");
    }

    public void updateModuleOptionString(ManagedObjectReference _this, String name, String options) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("options", "String", options);
        wsc.invoke("UpdateModuleOptionString", paras, null);
    }

    public String queryConfiguredModuleOptionString(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (String) wsc.invoke("QueryConfiguredModuleOptionString", paras, "String");
    }

    public void createUser(ManagedObjectReference _this, HostAccountSpec user) throws java.rmi.RemoteException, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("user", "HostAccountSpec", user);
        wsc.invoke("CreateUser", paras, null);
    }

    public void updateUser(ManagedObjectReference _this, HostAccountSpec user) throws java.rmi.RemoteException, UserNotFound, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("user", "HostAccountSpec", user);
        wsc.invoke("UpdateUser", paras, null);
    }

    public void createGroup(ManagedObjectReference _this, HostAccountSpec group) throws java.rmi.RemoteException, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("group", "HostAccountSpec", group);
        wsc.invoke("CreateGroup", paras, null);
    }

    public void removeUser(ManagedObjectReference _this, String userName) throws java.rmi.RemoteException, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("userName", "String", userName);
        wsc.invoke("RemoveUser", paras, null);
    }

    public void removeGroup(ManagedObjectReference _this, String groupName) throws java.rmi.RemoteException, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("groupName", "String", groupName);
        wsc.invoke("RemoveGroup", paras, null);
    }

    public void assignUserToGroup(ManagedObjectReference _this, String user, String group) throws java.rmi.RemoteException, UserNotFound, AlreadyExists, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("user", "String", user);
        paras[2] = new Argument("group", "String", group);
        wsc.invoke("AssignUserToGroup", paras, null);
    }

    public void unassignUserFromGroup(ManagedObjectReference _this, String user, String group) throws java.rmi.RemoteException, UserNotFound, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("user", "String", user);
        paras[2] = new Argument("group", "String", group);
        wsc.invoke("UnassignUserFromGroup", paras, null);
    }

    public void reconfigureServiceConsoleReservation(ManagedObjectReference _this, long cfgBytes) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("cfgBytes", "long", cfgBytes);
        wsc.invoke("ReconfigureServiceConsoleReservation", paras, null);
    }

    public void reconfigureVirtualMachineReservation(ManagedObjectReference _this, VirtualMachineMemoryReservationSpec spec) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "VirtualMachineMemoryReservationSpec", spec);
        wsc.invoke("ReconfigureVirtualMachineReservation", paras, null);
    }

    public HostNetworkConfigResult updateNetworkConfig(ManagedObjectReference _this, HostNetworkConfig config, String changeMode) throws java.rmi.RemoteException, AlreadyExists, NotFound, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostNetworkConfig", config);
        paras[2] = new Argument("changeMode", "String", changeMode);
        return (HostNetworkConfigResult) wsc.invoke("UpdateNetworkConfig", paras, "HostNetworkConfigResult");
    }

    public void updateDnsConfig(ManagedObjectReference _this, HostDnsConfig config) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostDnsConfig", config);
        wsc.invoke("UpdateDnsConfig", paras, null);
    }

    public void updateIpRouteConfig(ManagedObjectReference _this, HostIpRouteConfig config) throws java.rmi.RemoteException, HostConfigFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostIpRouteConfig", config);
        wsc.invoke("UpdateIpRouteConfig", paras, null);
    }

    public void updateConsoleIpRouteConfig(ManagedObjectReference _this, HostIpRouteConfig config) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostIpRouteConfig", config);
        wsc.invoke("UpdateConsoleIpRouteConfig", paras, null);
    }

    public void updateIpRouteTableConfig(ManagedObjectReference _this, HostIpRouteTableConfig config) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostIpRouteTableConfig", config);
        wsc.invoke("UpdateIpRouteTableConfig", paras, null);
    }

    public void addVirtualSwitch(ManagedObjectReference _this, String vswitchName, HostVirtualSwitchSpec spec) throws java.rmi.RemoteException, AlreadyExists, ResourceInUse, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vswitchName", "String", vswitchName);
        paras[2] = new Argument("spec", "HostVirtualSwitchSpec", spec);
        wsc.invoke("AddVirtualSwitch", paras, null);
    }

    public void removeVirtualSwitch(ManagedObjectReference _this, String vswitchName) throws java.rmi.RemoteException, NotFound, ResourceInUse, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vswitchName", "String", vswitchName);
        wsc.invoke("RemoveVirtualSwitch", paras, null);
    }

    public void updateVirtualSwitch(ManagedObjectReference _this, String vswitchName, HostVirtualSwitchSpec spec) throws java.rmi.RemoteException, ResourceInUse, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vswitchName", "String", vswitchName);
        paras[2] = new Argument("spec", "HostVirtualSwitchSpec", spec);
        wsc.invoke("UpdateVirtualSwitch", paras, null);
    }

    public void addPortGroup(ManagedObjectReference _this, HostPortGroupSpec portgrp) throws java.rmi.RemoteException, AlreadyExists, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portgrp", "HostPortGroupSpec", portgrp);
        wsc.invoke("AddPortGroup", paras, null);
    }

    public void removePortGroup(ManagedObjectReference _this, String pgName) throws java.rmi.RemoteException, NotFound, ResourceInUse, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pgName", "String", pgName);
        wsc.invoke("RemovePortGroup", paras, null);
    }

    public void updatePortGroup(ManagedObjectReference _this, String pgName, HostPortGroupSpec portgrp) throws java.rmi.RemoteException, AlreadyExists, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pgName", "String", pgName);
        paras[2] = new Argument("portgrp", "HostPortGroupSpec", portgrp);
        wsc.invoke("UpdatePortGroup", paras, null);
    }

    public void updatePhysicalNicLinkSpeed(ManagedObjectReference _this, String device, PhysicalNicLinkInfo linkSpeed) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        paras[2] = new Argument("linkSpeed", "PhysicalNicLinkInfo", linkSpeed);
        wsc.invoke("UpdatePhysicalNicLinkSpeed", paras, null);
    }

    public PhysicalNicHintInfo[] queryNetworkHint(ManagedObjectReference _this, String[] device) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String[]", device);
        return (PhysicalNicHintInfo[]) wsc.invoke("QueryNetworkHint", paras, "PhysicalNicHintInfo[]");
    }

    public String addVirtualNic(ManagedObjectReference _this, String portgroup, HostVirtualNicSpec nic) throws java.rmi.RemoteException, AlreadyExists, HostConfigFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portgroup", "String", portgroup);
        paras[2] = new Argument("nic", "HostVirtualNicSpec", nic);
        return (String) wsc.invoke("AddVirtualNic", paras, "String");
    }

    public void removeVirtualNic(ManagedObjectReference _this, String device) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        wsc.invoke("RemoveVirtualNic", paras, null);
    }

    public void updateVirtualNic(ManagedObjectReference _this, String device, HostVirtualNicSpec nic) throws java.rmi.RemoteException, NotFound, HostConfigFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        paras[2] = new Argument("nic", "HostVirtualNicSpec", nic);
        wsc.invoke("UpdateVirtualNic", paras, null);
    }

    public String addServiceConsoleVirtualNic(ManagedObjectReference _this, String portgroup, HostVirtualNicSpec nic) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("portgroup", "String", portgroup);
        paras[2] = new Argument("nic", "HostVirtualNicSpec", nic);
        return (String) wsc.invoke("AddServiceConsoleVirtualNic", paras, "String");
    }

    public void removeServiceConsoleVirtualNic(ManagedObjectReference _this, String device) throws java.rmi.RemoteException, NotFound, ResourceInUse, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        wsc.invoke("RemoveServiceConsoleVirtualNic", paras, null);
    }

    public void updateServiceConsoleVirtualNic(ManagedObjectReference _this, String device, HostVirtualNicSpec nic) throws java.rmi.RemoteException, NotFound, ResourceInUse, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        paras[2] = new Argument("nic", "HostVirtualNicSpec", nic);
        wsc.invoke("UpdateServiceConsoleVirtualNic", paras, null);
    }

    public void restartServiceConsoleVirtualNic(ManagedObjectReference _this, String device) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        wsc.invoke("RestartServiceConsoleVirtualNic", paras, null);
    }

    public void refreshNetworkSystem(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RefreshNetworkSystem", paras, null);
    }

    public ManagedObjectReference checkHostPatch_Task(ManagedObjectReference _this, String[] metaUrls, String[] bundleUrls, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, RequestCanceled, InvalidState, TaskInProgress, PlatformConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("metaUrls", "String[]", metaUrls);
        paras[2] = new Argument("bundleUrls", "String[]", bundleUrls);
        paras[3] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) wsc.invoke("CheckHostPatch_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference scanHostPatch_Task(ManagedObjectReference _this, HostPatchManagerLocator repository, String[] updateID) throws java.rmi.RemoteException, RequestCanceled, PatchMetadataInvalid, PlatformConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("repository", "HostPatchManagerLocator", repository);
        paras[2] = new Argument("updateID", "String[]", updateID);
        return (ManagedObjectReference) wsc.invoke("ScanHostPatch_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference scanHostPatchV2_Task(ManagedObjectReference _this, String[] metaUrls, String[] bundleUrls, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, RequestCanceled, InvalidState, TaskInProgress, PlatformConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("metaUrls", "String[]", metaUrls);
        paras[2] = new Argument("bundleUrls", "String[]", bundleUrls);
        paras[3] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) wsc.invoke("ScanHostPatchV2_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference stageHostPatch_Task(ManagedObjectReference _this, String[] metaUrls, String[] bundleUrls, String[] vibUrls, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, RequestCanceled, InvalidState, TaskInProgress, PlatformConfigFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("metaUrls", "String[]", metaUrls);
        paras[2] = new Argument("bundleUrls", "String[]", bundleUrls);
        paras[3] = new Argument("vibUrls", "String[]", vibUrls);
        paras[4] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) wsc.invoke("StageHostPatch_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference installHostPatch_Task(ManagedObjectReference _this, HostPatchManagerLocator repository, String updateID, Boolean force) throws java.rmi.RemoteException, PatchMetadataInvalid, PatchBinariesNotFound, PatchNotApplicable, NoDiskSpace, PatchInstallFailed, RebootRequired, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("repository", "HostPatchManagerLocator", repository);
        paras[2] = new Argument("updateID", "String", updateID);
        paras[3] = new Argument("force", "Boolean", force);
        return (ManagedObjectReference) wsc.invoke("InstallHostPatch_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference installHostPatchV2_Task(ManagedObjectReference _this, String[] metaUrls, String[] bundleUrls, String[] vibUrls, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, RequestCanceled, InvalidState, TaskInProgress, PlatformConfigFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("metaUrls", "String[]", metaUrls);
        paras[2] = new Argument("bundleUrls", "String[]", bundleUrls);
        paras[3] = new Argument("vibUrls", "String[]", vibUrls);
        paras[4] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) wsc.invoke("InstallHostPatchV2_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference uninstallHostPatch_Task(ManagedObjectReference _this, String[] bulletinIds, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, InvalidState, TaskInProgress, PlatformConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("bulletinIds", "String[]", bulletinIds);
        paras[2] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) wsc.invoke("UninstallHostPatch_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference queryHostPatch_Task(ManagedObjectReference _this, HostPatchManagerPatchManagerOperationSpec spec) throws java.rmi.RemoteException, RequestCanceled, InvalidState, TaskInProgress, PlatformConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostPatchManagerPatchManagerOperationSpec", spec);
        return (ManagedObjectReference) wsc.invoke("QueryHostPatch_Task", paras, "ManagedObjectReference");
    }

    public void refresh(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("Refresh", paras, null);
    }

    public void updatePassthruConfig(ManagedObjectReference _this, HostPciPassthruConfig[] config) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostPciPassthruConfig[]", config);
        wsc.invoke("UpdatePassthruConfig", paras, null);
    }

    public void configurePowerPolicy(ManagedObjectReference _this, int key) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("key", "int", key);
        wsc.invoke("ConfigurePowerPolicy", paras, null);
    }

    public void updateServicePolicy(ManagedObjectReference _this, String id, String policy) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        paras[2] = new Argument("policy", "String", policy);
        wsc.invoke("UpdateServicePolicy", paras, null);
    }

    public void startService(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, InvalidState, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        wsc.invoke("StartService", paras, null);
    }

    public void stopService(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, InvalidState, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        wsc.invoke("StopService", paras, null);
    }

    public void restartService(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, InvalidState, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        wsc.invoke("RestartService", paras, null);
    }

    public void uninstallService(ManagedObjectReference _this, String id) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("id", "String", id);
        wsc.invoke("UninstallService", paras, null);
    }

    public void refreshServices(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RefreshServices", paras, null);
    }

    public void reconfigureSnmpAgent(ManagedObjectReference _this, HostSnmpConfigSpec spec) throws java.rmi.RemoteException, NotFound, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostSnmpConfigSpec", spec);
        wsc.invoke("ReconfigureSnmpAgent", paras, null);
    }

    public void sendTestNotification(ManagedObjectReference _this) throws java.rmi.RemoteException, NotFound, InsufficientResourcesFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("SendTestNotification", paras, null);
    }

    public HostDiskPartitionInfo[] retrieveDiskPartitionInfo(ManagedObjectReference _this, String[] devicePath) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("devicePath", "String[]", devicePath);
        return (HostDiskPartitionInfo[]) wsc.invoke("RetrieveDiskPartitionInfo", paras, "HostDiskPartitionInfo[]");
    }

    public HostDiskPartitionInfo computeDiskPartitionInfo(ManagedObjectReference _this, String devicePath, HostDiskPartitionLayout layout, String partitionFormat) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("devicePath", "String", devicePath);
        paras[2] = new Argument("layout", "HostDiskPartitionLayout", layout);
        paras[3] = new Argument("partitionFormat", "String", partitionFormat);
        return (HostDiskPartitionInfo) wsc.invoke("ComputeDiskPartitionInfo", paras, "HostDiskPartitionInfo");
    }

    public HostDiskPartitionInfo computeDiskPartitionInfoForResize(ManagedObjectReference _this, HostScsiDiskPartition partition, HostDiskPartitionBlockRange blockRange, String partitionFormat) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("partition", "HostScsiDiskPartition", partition);
        paras[2] = new Argument("blockRange", "HostDiskPartitionBlockRange", blockRange);
        paras[3] = new Argument("partitionFormat", "String", partitionFormat);
        return (HostDiskPartitionInfo) wsc.invoke("ComputeDiskPartitionInfoForResize", paras, "HostDiskPartitionInfo");
    }

    public void updateDiskPartitions(ManagedObjectReference _this, String devicePath, HostDiskPartitionSpec spec) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("devicePath", "String", devicePath);
        paras[2] = new Argument("spec", "HostDiskPartitionSpec", spec);
        wsc.invoke("UpdateDiskPartitions", paras, null);
    }

    public HostVmfsVolume formatVmfs(ManagedObjectReference _this, HostVmfsSpec createSpec) throws java.rmi.RemoteException, AlreadyExists, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("createSpec", "HostVmfsSpec", createSpec);
        return (HostVmfsVolume) wsc.invoke("FormatVmfs", paras, "HostVmfsVolume");
    }

    public void mountVmfsVolume(ManagedObjectReference _this, String vmfsUuid) throws java.rmi.RemoteException, NotFound, InvalidState, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsUuid", "String", vmfsUuid);
        wsc.invoke("MountVmfsVolume", paras, null);
    }

    public void unmountVmfsVolume(ManagedObjectReference _this, String vmfsUuid) throws java.rmi.RemoteException, NotFound, InvalidState, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsUuid", "String", vmfsUuid);
        wsc.invoke("UnmountVmfsVolume", paras, null);
    }

    public void deleteVmfsVolumeState(ManagedObjectReference _this, String vmfsUuid) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsUuid", "String", vmfsUuid);
        wsc.invoke("DeleteVmfsVolumeState", paras, null);
    }

    public void rescanVmfs(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RescanVmfs", paras, null);
    }

    public void attachVmfsExtent(ManagedObjectReference _this, String vmfsPath, HostScsiDiskPartition extent) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsPath", "String", vmfsPath);
        paras[2] = new Argument("extent", "HostScsiDiskPartition", extent);
        wsc.invoke("AttachVmfsExtent", paras, null);
    }

    public void expandVmfsExtent(ManagedObjectReference _this, String vmfsPath, HostScsiDiskPartition extent) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsPath", "String", vmfsPath);
        paras[2] = new Argument("extent", "HostScsiDiskPartition", extent);
        wsc.invoke("ExpandVmfsExtent", paras, null);
    }

    public void upgradeVmfs(ManagedObjectReference _this, String vmfsPath) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsPath", "String", vmfsPath);
        wsc.invoke("UpgradeVmfs", paras, null);
    }

    public void upgradeVmLayout(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("UpgradeVmLayout", paras, null);
    }

    public HostUnresolvedVmfsVolume[] queryUnresolvedVmfsVolume(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostUnresolvedVmfsVolume[]) wsc.invoke("QueryUnresolvedVmfsVolume", paras, "HostUnresolvedVmfsVolume[]");
    }

    public HostUnresolvedVmfsResolutionResult[] resolveMultipleUnresolvedVmfsVolumes(ManagedObjectReference _this, HostUnresolvedVmfsResolutionSpec[] resolutionSpec) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("resolutionSpec", "HostUnresolvedVmfsResolutionSpec[]", resolutionSpec);
        return (HostUnresolvedVmfsResolutionResult[]) wsc.invoke("ResolveMultipleUnresolvedVmfsVolumes", paras, "HostUnresolvedVmfsResolutionResult[]");
    }

    public ManagedObjectReference resolveMultipleUnresolvedVmfsVolumesEx_Task(ManagedObjectReference _this, HostUnresolvedVmfsResolutionSpec[] resolutionSpec) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("resolutionSpec", "HostUnresolvedVmfsResolutionSpec[]", resolutionSpec);
        return (ManagedObjectReference) wsc.invoke("ResolveMultipleUnresolvedVmfsVolumesEx_Task", paras, "ManagedObjectReference");
    }

    public void unmountForceMountedVmfsVolume(ManagedObjectReference _this, String vmfsUuid) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vmfsUuid", "String", vmfsUuid);
        wsc.invoke("UnmountForceMountedVmfsVolume", paras, null);
    }

    public void rescanHba(ManagedObjectReference _this, String hbaDevice) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hbaDevice", "String", hbaDevice);
        wsc.invoke("RescanHba", paras, null);
    }

    public void rescanAllHba(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RescanAllHba", paras, null);
    }

    public void updateSoftwareInternetScsiEnabled(ManagedObjectReference _this, boolean enabled) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("enabled", "boolean", enabled);
        wsc.invoke("UpdateSoftwareInternetScsiEnabled", paras, null);
    }

    public void updateInternetScsiDiscoveryProperties(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaDiscoveryProperties discoveryProperties) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("discoveryProperties", "HostInternetScsiHbaDiscoveryProperties", discoveryProperties);
        wsc.invoke("UpdateInternetScsiDiscoveryProperties", paras, null);
    }

    public void updateInternetScsiAuthenticationProperties(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaAuthenticationProperties authenticationProperties, HostInternetScsiHbaTargetSet targetSet) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("authenticationProperties", "HostInternetScsiHbaAuthenticationProperties", authenticationProperties);
        paras[3] = new Argument("targetSet", "HostInternetScsiHbaTargetSet", targetSet);
        wsc.invoke("UpdateInternetScsiAuthenticationProperties", paras, null);
    }

    public void updateInternetScsiDigestProperties(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaTargetSet targetSet, HostInternetScsiHbaDigestProperties digestProperties) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targetSet", "HostInternetScsiHbaTargetSet", targetSet);
        paras[3] = new Argument("digestProperties", "HostInternetScsiHbaDigestProperties", digestProperties);
        wsc.invoke("UpdateInternetScsiDigestProperties", paras, null);
    }

    public void updateInternetScsiAdvancedOptions(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaTargetSet targetSet, HostInternetScsiHbaParamValue[] options) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targetSet", "HostInternetScsiHbaTargetSet", targetSet);
        paras[3] = new Argument("options", "HostInternetScsiHbaParamValue[]", options);
        wsc.invoke("UpdateInternetScsiAdvancedOptions", paras, null);
    }

    public void updateInternetScsiIPProperties(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaIPProperties ipProperties) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("ipProperties", "HostInternetScsiHbaIPProperties", ipProperties);
        wsc.invoke("UpdateInternetScsiIPProperties", paras, null);
    }

    public void updateInternetScsiName(ManagedObjectReference _this, String iScsiHbaDevice, String iScsiName) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("iScsiName", "String", iScsiName);
        wsc.invoke("UpdateInternetScsiName", paras, null);
    }

    public void updateInternetScsiAlias(ManagedObjectReference _this, String iScsiHbaDevice, String iScsiAlias) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("iScsiAlias", "String", iScsiAlias);
        wsc.invoke("UpdateInternetScsiAlias", paras, null);
    }

    public void addInternetScsiSendTargets(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaSendTarget[] targets) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targets", "HostInternetScsiHbaSendTarget[]", targets);
        wsc.invoke("AddInternetScsiSendTargets", paras, null);
    }

    public void removeInternetScsiSendTargets(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaSendTarget[] targets) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targets", "HostInternetScsiHbaSendTarget[]", targets);
        wsc.invoke("RemoveInternetScsiSendTargets", paras, null);
    }

    public void addInternetScsiStaticTargets(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaStaticTarget[] targets) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targets", "HostInternetScsiHbaStaticTarget[]", targets);
        wsc.invoke("AddInternetScsiStaticTargets", paras, null);
    }

    public void removeInternetScsiStaticTargets(ManagedObjectReference _this, String iScsiHbaDevice, HostInternetScsiHbaStaticTarget[] targets) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("iScsiHbaDevice", "String", iScsiHbaDevice);
        paras[2] = new Argument("targets", "HostInternetScsiHbaStaticTarget[]", targets);
        wsc.invoke("RemoveInternetScsiStaticTargets", paras, null);
    }

    public void enableMultipathPath(ManagedObjectReference _this, String pathName) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pathName", "String", pathName);
        wsc.invoke("EnableMultipathPath", paras, null);
    }

    public void disableMultipathPath(ManagedObjectReference _this, String pathName) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("pathName", "String", pathName);
        wsc.invoke("DisableMultipathPath", paras, null);
    }

    public void setMultipathLunPolicy(ManagedObjectReference _this, String lunId, HostMultipathInfoLogicalUnitPolicy policy) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunId", "String", lunId);
        paras[2] = new Argument("policy", "HostMultipathInfoLogicalUnitPolicy", policy);
        wsc.invoke("SetMultipathLunPolicy", paras, null);
    }

    public HostPathSelectionPolicyOption[] queryPathSelectionPolicyOptions(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostPathSelectionPolicyOption[]) wsc.invoke("QueryPathSelectionPolicyOptions", paras, "HostPathSelectionPolicyOption[]");
    }

    public HostStorageArrayTypePolicyOption[] queryStorageArrayTypePolicyOptions(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (HostStorageArrayTypePolicyOption[]) wsc.invoke("QueryStorageArrayTypePolicyOptions", paras, "HostStorageArrayTypePolicyOption[]");
    }

    public void updateScsiLunDisplayName(ManagedObjectReference _this, String lunUuid, String displayName) throws java.rmi.RemoteException, NotFound, HostConfigFault, InvalidName, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunUuid", "String", lunUuid);
        paras[2] = new Argument("displayName", "String", displayName);
        wsc.invoke("UpdateScsiLunDisplayName", paras, null);
    }

    public void detachScsiLun(ManagedObjectReference _this, String lunUuid) throws java.rmi.RemoteException, NotFound, HostConfigFault, InvalidState, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunUuid", "String", lunUuid);
        wsc.invoke("DetachScsiLun", paras, null);
    }

    public void deleteScsiLunState(ManagedObjectReference _this, String lunCanonicalName) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunCanonicalName", "String", lunCanonicalName);
        wsc.invoke("DeleteScsiLunState", paras, null);
    }

    public void attachScsiLun(ManagedObjectReference _this, String lunUuid) throws java.rmi.RemoteException, NotFound, HostConfigFault, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("lunUuid", "String", lunUuid);
        wsc.invoke("AttachScsiLun", paras, null);
    }

    public void refreshStorageSystem(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RefreshStorageSystem", paras, null);
    }

    public void discoverFcoeHbas(ManagedObjectReference _this, FcoeConfigFcoeSpecification fcoeSpec) throws java.rmi.RemoteException, FcoeFaultPnicHasNoPortSet, HostConfigFault, NotFound, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("fcoeSpec", "FcoeConfigFcoeSpecification", fcoeSpec);
        wsc.invoke("DiscoverFcoeHbas", paras, null);
    }

    public void markForRemoval(ManagedObjectReference _this, String hbaName, boolean remove) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("hbaName", "String", hbaName);
        paras[2] = new Argument("remove", "boolean", remove);
        wsc.invoke("MarkForRemoval", paras, null);
    }

    public HostVffsVolume formatVffs(ManagedObjectReference _this, HostVffsSpec createSpec) throws java.rmi.RemoteException, AlreadyExists, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("createSpec", "HostVffsSpec", createSpec);
        return (HostVffsVolume) wsc.invoke("FormatVffs", paras, "HostVffsVolume");
    }

    public void extendVffs(ManagedObjectReference _this, String vffsPath, String devicePath, HostDiskPartitionSpec spec) throws java.rmi.RemoteException, NotFound, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsPath", "String", vffsPath);
        paras[2] = new Argument("devicePath", "String", devicePath);
        paras[3] = new Argument("spec", "HostDiskPartitionSpec", spec);
        wsc.invoke("ExtendVffs", paras, null);
    }

    public void destroyVffs(ManagedObjectReference _this, String vffsPath) throws java.rmi.RemoteException, NotFound, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsPath", "String", vffsPath);
        wsc.invoke("DestroyVffs", paras, null);
    }

    public void mountVffsVolume(ManagedObjectReference _this, String vffsUuid) throws java.rmi.RemoteException, NotFound, InvalidState, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsUuid", "String", vffsUuid);
        wsc.invoke("MountVffsVolume", paras, null);
    }

    public void unmountVffsVolume(ManagedObjectReference _this, String vffsUuid) throws java.rmi.RemoteException, NotFound, InvalidState, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsUuid", "String", vffsUuid);
        wsc.invoke("UnmountVffsVolume", paras, null);
    }

    public void deleteVffsVolumeState(ManagedObjectReference _this, String vffsUuid) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsUuid", "String", vffsUuid);
        wsc.invoke("DeleteVffsVolumeState", paras, null);
    }

    public void rescanVffs(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RescanVffs", paras, null);
    }

    public HostScsiDisk[] queryAvailableSsds(ManagedObjectReference _this, String vffsPath) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vffsPath", "String", vffsPath);
        return (HostScsiDisk[]) wsc.invoke("QueryAvailableSsds", paras, "HostScsiDisk[]");
    }

    public ManagedObjectReference configureVFlashResourceEx_Task(ManagedObjectReference _this, String[] devicePath) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("devicePath", "String[]", devicePath);
        return (ManagedObjectReference) wsc.invoke("ConfigureVFlashResourceEx_Task", paras, "ManagedObjectReference");
    }

    public void hostConfigureVFlashResource(ManagedObjectReference _this, HostVFlashManagerVFlashResourceConfigSpec spec) throws java.rmi.RemoteException, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostVFlashManagerVFlashResourceConfigSpec", spec);
        wsc.invoke("HostConfigureVFlashResource", paras, null);
    }

    public void hostRemoveVFlashResource(ManagedObjectReference _this) throws java.rmi.RemoteException, NotFound, HostConfigFault, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("HostRemoveVFlashResource", paras, null);
    }

    public void hostConfigVFlashCache(ManagedObjectReference _this, HostVFlashManagerVFlashCacheConfigSpec spec) throws java.rmi.RemoteException, HostConfigFault, InaccessibleVFlashSource, ResourceInUse, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "HostVFlashManagerVFlashCacheConfigSpec", spec);
        wsc.invoke("HostConfigVFlashCache", paras, null);
    }

    public VirtualDiskVFlashCacheConfigInfo hostGetVFlashModuleDefaultConfig(ManagedObjectReference _this, String vFlashModule) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vFlashModule", "String", vFlashModule);
        return (VirtualDiskVFlashCacheConfigInfo) wsc.invoke("HostGetVFlashModuleDefaultConfig", paras, "VirtualDiskVFlashCacheConfigInfo");
    }

    public void updateIpConfig(ManagedObjectReference _this, HostIpConfig ipConfig) throws java.rmi.RemoteException, NotFound, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("ipConfig", "HostIpConfig", ipConfig);
        wsc.invoke("UpdateIpConfig", paras, null);
    }

    public void selectVnic(ManagedObjectReference _this, String device) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("device", "String", device);
        wsc.invoke("SelectVnic", paras, null);
    }

    public void deselectVnic(ManagedObjectReference _this) throws java.rmi.RemoteException, HostConfigFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("DeselectVnic", paras, null);
    }

    public VirtualNicManagerNetConfig queryNetConfig(ManagedObjectReference _this, String nicType) throws java.rmi.RemoteException, HostConfigFault, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("nicType", "String", nicType);
        return (VirtualNicManagerNetConfig) wsc.invoke("QueryNetConfig", paras, "VirtualNicManagerNetConfig");
    }

    public void selectVnicForNicType(ManagedObjectReference _this, String nicType, String device) throws java.rmi.RemoteException, HostConfigFault, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("nicType", "String", nicType);
        paras[2] = new Argument("device", "String", device);
        wsc.invoke("SelectVnicForNicType", paras, null);
    }

    public void deselectVnicForNicType(ManagedObjectReference _this, String nicType, String device) throws java.rmi.RemoteException, HostConfigFault, InvalidArgument, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("nicType", "String", nicType);
        paras[2] = new Argument("device", "String", device);
        wsc.invoke("DeselectVnicForNicType", paras, null);
    }

    public String queryCmmds(ManagedObjectReference _this, HostVsanInternalSystemCmmdsQuery[] queries) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("queries", "HostVsanInternalSystemCmmdsQuery[]", queries);
        return (String) wsc.invoke("QueryCmmds", paras, "String");
    }

    public String queryPhysicalVsanDisks(ManagedObjectReference _this, String[] props) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("props", "String[]", props);
        return (String) wsc.invoke("QueryPhysicalVsanDisks", paras, "String");
    }

    public String queryVsanObjects(ManagedObjectReference _this, String[] uuids) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("uuids", "String[]", uuids);
        return (String) wsc.invoke("QueryVsanObjects", paras, "String");
    }

    public String queryObjectsOnPhysicalVsanDisk(ManagedObjectReference _this, String[] disks) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("disks", "String[]", disks);
        return (String) wsc.invoke("QueryObjectsOnPhysicalVsanDisk", paras, "String");
    }

    public VsanHostDiskResult[] queryDisksForVsan(ManagedObjectReference _this, String[] canonicalName) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("canonicalName", "String[]", canonicalName);
        return (VsanHostDiskResult[]) wsc.invoke("QueryDisksForVsan", paras, "VsanHostDiskResult[]");
    }

    public ManagedObjectReference addDisks_Task(ManagedObjectReference _this, HostScsiDisk[] disk) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("disk", "HostScsiDisk[]", disk);
        return (ManagedObjectReference) wsc.invoke("AddDisks_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference initializeDisks_Task(ManagedObjectReference _this, VsanHostDiskMapping[] mapping) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("mapping", "VsanHostDiskMapping[]", mapping);
        return (ManagedObjectReference) wsc.invoke("InitializeDisks_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference removeDisk_Task(ManagedObjectReference _this, HostScsiDisk[] disk) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("disk", "HostScsiDisk[]", disk);
        return (ManagedObjectReference) wsc.invoke("RemoveDisk_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference removeDiskMapping_Task(ManagedObjectReference _this, VsanHostDiskMapping[] mapping) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("mapping", "VsanHostDiskMapping[]", mapping);
        return (ManagedObjectReference) wsc.invoke("RemoveDiskMapping_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference updateVsan_Task(ManagedObjectReference _this, VsanHostConfigInfo config) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "VsanHostConfigInfo", config);
        return (ManagedObjectReference) wsc.invoke("UpdateVsan_Task", paras, "ManagedObjectReference");
    }

    public VsanHostClusterStatus queryHostStatus(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (VsanHostClusterStatus) wsc.invoke("QueryHostStatus", paras, "VsanHostClusterStatus");
    }

    public OptionValue[] queryOptions(ManagedObjectReference _this, String name) throws java.rmi.RemoteException, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        return (OptionValue[]) wsc.invoke("QueryOptions", paras, "OptionValue[]");
    }

    public void updateOptions(ManagedObjectReference _this, OptionValue[] changedValue) throws java.rmi.RemoteException, InvalidName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("changedValue", "OptionValue[]", changedValue);
        wsc.invoke("UpdateOptions", paras, null);
    }

    public ManagedObjectReference checkCompliance_Task(ManagedObjectReference _this, ManagedObjectReference[] profile, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profile", "ManagedObjectReference[]", profile);
        paras[2] = new Argument("entity", "ManagedObjectReference[]", entity);
        return (ManagedObjectReference) wsc.invoke("CheckCompliance_Task", paras, "ManagedObjectReference");
    }

    public ComplianceResult[] queryComplianceStatus(ManagedObjectReference _this, ManagedObjectReference[] profile, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profile", "ManagedObjectReference[]", profile);
        paras[2] = new Argument("entity", "ManagedObjectReference[]", entity);
        return (ComplianceResult[]) wsc.invoke("QueryComplianceStatus", paras, "ComplianceResult[]");
    }

    public void clearComplianceStatus(ManagedObjectReference _this, ManagedObjectReference[] profile, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profile", "ManagedObjectReference[]", profile);
        paras[2] = new Argument("entity", "ManagedObjectReference[]", entity);
        wsc.invoke("ClearComplianceStatus", paras, null);
    }

    public ProfileExpressionMetadata[] queryExpressionMetadata(ManagedObjectReference _this, String[] expressionName, ManagedObjectReference profile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("expressionName", "String[]", expressionName);
        paras[2] = new Argument("profile", "ManagedObjectReference", profile);
        return (ProfileExpressionMetadata[]) wsc.invoke("QueryExpressionMetadata", paras, "ProfileExpressionMetadata[]");
    }

    public ProfileDescription retrieveDescription(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ProfileDescription) wsc.invoke("RetrieveDescription", paras, "ProfileDescription");
    }

    public void destroyProfile(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("DestroyProfile", paras, null);
    }

    public void associateProfile(ManagedObjectReference _this, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        wsc.invoke("AssociateProfile", paras, null);
    }

    public void dissociateProfile(ManagedObjectReference _this, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        wsc.invoke("DissociateProfile", paras, null);
    }

    public ManagedObjectReference checkProfileCompliance_Task(ManagedObjectReference _this, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        return (ManagedObjectReference) wsc.invoke("CheckProfileCompliance_Task", paras, "ManagedObjectReference");
    }

    public String exportProfile(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (String) wsc.invoke("ExportProfile", paras, "String");
    }

    public ManagedObjectReference createProfile(ManagedObjectReference _this, ProfileCreateSpec createSpec) throws java.rmi.RemoteException, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("createSpec", "ProfileCreateSpec", createSpec);
        return (ManagedObjectReference) wsc.invoke("CreateProfile", paras, "ManagedObjectReference");
    }

    public ProfilePolicyMetadata[] queryPolicyMetadata(ManagedObjectReference _this, String[] policyName, ManagedObjectReference profile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("policyName", "String[]", policyName);
        paras[2] = new Argument("profile", "ManagedObjectReference", profile);
        return (ProfilePolicyMetadata[]) wsc.invoke("QueryPolicyMetadata", paras, "ProfilePolicyMetadata[]");
    }

    public ManagedObjectReference[] findAssociatedProfile(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        return (ManagedObjectReference[]) wsc.invoke("FindAssociatedProfile", paras, "ManagedObjectReference[]");
    }

    public void updateClusterProfile(ManagedObjectReference _this, ClusterProfileConfigSpec config) throws java.rmi.RemoteException, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "ClusterProfileConfigSpec", config);
        wsc.invoke("UpdateClusterProfile", paras, null);
    }

    public void updateReferenceHost(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        wsc.invoke("UpdateReferenceHost", paras, null);
    }

    public void updateHostProfile(ManagedObjectReference _this, HostProfileConfigSpec config) throws java.rmi.RemoteException, DuplicateName, ProfileUpdateFailed, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("config", "HostProfileConfigSpec", config);
        wsc.invoke("UpdateHostProfile", paras, null);
    }

    public ProfileExecuteResult executeHostProfile(ManagedObjectReference _this, ManagedObjectReference host, ProfileDeferredPolicyOptionParameter[] deferredParam) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("deferredParam", "ProfileDeferredPolicyOptionParameter[]", deferredParam);
        return (ProfileExecuteResult) wsc.invoke("ExecuteHostProfile", paras, "ProfileExecuteResult");
    }

    public ManagedObjectReference applyHostConfig_Task(ManagedObjectReference _this, ManagedObjectReference host, HostConfigSpec configSpec, ProfileDeferredPolicyOptionParameter[] userInput) throws java.rmi.RemoteException, InvalidState, HostConfigFailed, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("configSpec", "HostConfigSpec", configSpec);
        paras[3] = new Argument("userInput", "ProfileDeferredPolicyOptionParameter[]", userInput);
        return (ManagedObjectReference) wsc.invoke("ApplyHostConfig_Task", paras, "ManagedObjectReference");
    }

    public HostProfileManagerConfigTaskList generateConfigTaskList(ManagedObjectReference _this, HostConfigSpec configSpec, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configSpec", "HostConfigSpec", configSpec);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (HostProfileManagerConfigTaskList) wsc.invoke("GenerateConfigTaskList", paras, "HostProfileManagerConfigTaskList");
    }

    public ManagedObjectReference generateHostProfileTaskList_Task(ManagedObjectReference _this, HostConfigSpec configSpec, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("configSpec", "HostConfigSpec", configSpec);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) wsc.invoke("GenerateHostProfileTaskList_Task", paras, "ManagedObjectReference");
    }

    public ProfileMetadata[] queryHostProfileMetadata(ManagedObjectReference _this, String[] profileName, ManagedObjectReference profile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profileName", "String[]", profileName);
        paras[2] = new Argument("profile", "ManagedObjectReference", profile);
        return (ProfileMetadata[]) wsc.invoke("QueryHostProfileMetadata", paras, "ProfileMetadata[]");
    }

    public ProfileProfileStructure queryProfileStructure(ManagedObjectReference _this, ManagedObjectReference profile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profile", "ManagedObjectReference", profile);
        return (ProfileProfileStructure) wsc.invoke("QueryProfileStructure", paras, "ProfileProfileStructure");
    }

    public ApplyProfile createDefaultProfile(ManagedObjectReference _this, String profileType, String profileTypeName, ManagedObjectReference profile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("profileType", "String", profileType);
        paras[2] = new Argument("profileTypeName", "String", profileTypeName);
        paras[3] = new Argument("profile", "ManagedObjectReference", profile);
        return (ApplyProfile) wsc.invoke("CreateDefaultProfile", paras, "ApplyProfile");
    }

    public ManagedObjectReference updateAnswerFile_Task(ManagedObjectReference _this, ManagedObjectReference host, AnswerFileCreateSpec configSpec) throws java.rmi.RemoteException, AnswerFileUpdateFailed, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("configSpec", "AnswerFileCreateSpec", configSpec);
        return (ManagedObjectReference) wsc.invoke("UpdateAnswerFile_Task", paras, "ManagedObjectReference");
    }

    public AnswerFile retrieveAnswerFile(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (AnswerFile) wsc.invoke("RetrieveAnswerFile", paras, "AnswerFile");
    }

    public AnswerFile retrieveAnswerFileForProfile(ManagedObjectReference _this, ManagedObjectReference host, HostApplyProfile applyProfile) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("applyProfile", "HostApplyProfile", applyProfile);
        return (AnswerFile) wsc.invoke("RetrieveAnswerFileForProfile", paras, "AnswerFile");
    }

    public ManagedObjectReference exportAnswerFile_Task(ManagedObjectReference _this, ManagedObjectReference host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        return (ManagedObjectReference) wsc.invoke("ExportAnswerFile_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference checkAnswerFileStatus_Task(ManagedObjectReference _this, ManagedObjectReference[] host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference[]", host);
        return (ManagedObjectReference) wsc.invoke("CheckAnswerFileStatus_Task", paras, "ManagedObjectReference");
    }

    public AnswerFileStatusResult[] queryAnswerFileStatus(ManagedObjectReference _this, ManagedObjectReference[] host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference[]", host);
        return (AnswerFileStatusResult[]) wsc.invoke("QueryAnswerFileStatus", paras, "AnswerFileStatusResult[]");
    }

    public void removeScheduledTask(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RemoveScheduledTask", paras, null);
    }

    public void reconfigureScheduledTask(ManagedObjectReference _this, ScheduledTaskSpec spec) throws java.rmi.RemoteException, InvalidState, InvalidName, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("spec", "ScheduledTaskSpec", spec);
        wsc.invoke("ReconfigureScheduledTask", paras, null);
    }

    public void runScheduledTask(ManagedObjectReference _this) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("RunScheduledTask", paras, null);
    }

    public ManagedObjectReference createScheduledTask(ManagedObjectReference _this, ManagedObjectReference entity, ScheduledTaskSpec spec) throws java.rmi.RemoteException, InvalidName, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        paras[2] = new Argument("spec", "ScheduledTaskSpec", spec);
        return (ManagedObjectReference) wsc.invoke("CreateScheduledTask", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference[] retrieveEntityScheduledTask(ManagedObjectReference _this, ManagedObjectReference entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference", entity);
        return (ManagedObjectReference[]) wsc.invoke("RetrieveEntityScheduledTask", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference createObjectScheduledTask(ManagedObjectReference _this, ManagedObjectReference obj, ScheduledTaskSpec spec) throws java.rmi.RemoteException, InvalidName, DuplicateName, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("obj", "ManagedObjectReference", obj);
        paras[2] = new Argument("spec", "ScheduledTaskSpec", spec);
        return (ManagedObjectReference) wsc.invoke("CreateObjectScheduledTask", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference[] retrieveObjectScheduledTask(ManagedObjectReference _this, ManagedObjectReference obj) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("obj", "ManagedObjectReference", obj);
        return (ManagedObjectReference[]) wsc.invoke("RetrieveObjectScheduledTask", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference[] openInventoryViewFolder(ManagedObjectReference _this, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        return (ManagedObjectReference[]) wsc.invoke("OpenInventoryViewFolder", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference[] closeInventoryViewFolder(ManagedObjectReference _this, ManagedObjectReference[] entity) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("entity", "ManagedObjectReference[]", entity);
        return (ManagedObjectReference[]) wsc.invoke("CloseInventoryViewFolder", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference[] modifyListView(ManagedObjectReference _this, ManagedObjectReference[] add, ManagedObjectReference[] remove) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("add", "ManagedObjectReference[]", add);
        paras[2] = new Argument("remove", "ManagedObjectReference[]", remove);
        return (ManagedObjectReference[]) wsc.invoke("ModifyListView", paras, "ManagedObjectReference[]");
    }

    public ManagedObjectReference[] resetListView(ManagedObjectReference _this, ManagedObjectReference[] obj) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("obj", "ManagedObjectReference[]", obj);
        return (ManagedObjectReference[]) wsc.invoke("ResetListView", paras, "ManagedObjectReference[]");
    }

    public void resetListViewFromView(ManagedObjectReference _this, ManagedObjectReference view) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("view", "ManagedObjectReference", view);
        wsc.invoke("ResetListViewFromView", paras, null);
    }

    public void destroyView(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        wsc.invoke("DestroyView", paras, null);
    }

    public ManagedObjectReference createInventoryView(ManagedObjectReference _this) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("CreateInventoryView", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createContainerView(ManagedObjectReference _this, ManagedObjectReference container, String[] type, boolean recursive) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("container", "ManagedObjectReference", container);
        paras[2] = new Argument("type", "String[]", type);
        paras[3] = new Argument("recursive", "boolean", recursive);
        return (ManagedObjectReference) wsc.invoke("CreateContainerView", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createListView(ManagedObjectReference _this, ManagedObjectReference[] obj) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("obj", "ManagedObjectReference[]", obj);
        return (ManagedObjectReference) wsc.invoke("CreateListView", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference createListViewFromView(ManagedObjectReference _this, ManagedObjectReference view) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[2];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("view", "ManagedObjectReference", view);
        return (ManagedObjectReference) wsc.invoke("CreateListViewFromView", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference revertToSnapshot_Task(ManagedObjectReference _this, ManagedObjectReference host, Boolean suppressPowerOn) throws java.rmi.RemoteException, TaskInProgress, InsufficientResourcesFault, InvalidState, FileFault, VmConfigFault, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("host", "ManagedObjectReference", host);
        paras[2] = new Argument("suppressPowerOn", "Boolean", suppressPowerOn);
        return (ManagedObjectReference) wsc.invoke("RevertToSnapshot_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference removeSnapshot_Task(ManagedObjectReference _this, boolean removeChildren, Boolean consolidate) throws java.rmi.RemoteException, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("removeChildren", "boolean", removeChildren);
        paras[2] = new Argument("consolidate", "Boolean", consolidate);
        return (ManagedObjectReference) wsc.invoke("RemoveSnapshot_Task", paras, "ManagedObjectReference");
    }

    public void renameSnapshot(ManagedObjectReference _this, String name, String description) throws java.rmi.RemoteException, InvalidName, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("name", "String", name);
        paras[2] = new Argument("description", "String", description);
        wsc.invoke("RenameSnapshot", paras, null);
    }

    public ManagedObjectReference exportSnapshot(ManagedObjectReference _this) throws java.rmi.RemoteException, TaskInProgress, InvalidState, FileFault, RuntimeFault {
        Argument[] paras = new Argument[1];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        return (ManagedObjectReference) wsc.invoke("ExportSnapshot", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference checkCompatibility_Task(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference host, ManagedObjectReference pool, String[] testType) throws java.rmi.RemoteException, InvalidState, NoActiveHostInCluster, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        paras[3] = new Argument("pool", "ManagedObjectReference", pool);
        paras[4] = new Argument("testType", "String[]", testType);
        return (ManagedObjectReference) wsc.invoke("CheckCompatibility_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference queryVMotionCompatibilityEx_Task(ManagedObjectReference _this, ManagedObjectReference[] vm, ManagedObjectReference[] host) throws java.rmi.RemoteException, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference[]", vm);
        paras[2] = new Argument("host", "ManagedObjectReference[]", host);
        return (ManagedObjectReference) wsc.invoke("QueryVMotionCompatibilityEx_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference checkMigrate_Task(ManagedObjectReference _this, ManagedObjectReference vm, ManagedObjectReference host, ManagedObjectReference pool, VirtualMachinePowerState state, String[] testType) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("host", "ManagedObjectReference", host);
        paras[3] = new Argument("pool", "ManagedObjectReference", pool);
        paras[4] = new Argument("state", "VirtualMachinePowerState", state);
        paras[5] = new Argument("testType", "String[]", testType);
        return (ManagedObjectReference) wsc.invoke("CheckMigrate_Task", paras, "ManagedObjectReference");
    }

    public ManagedObjectReference checkRelocate_Task(ManagedObjectReference _this, ManagedObjectReference vm, VirtualMachineRelocateSpec spec, String[] testType) throws java.rmi.RemoteException, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("spec", "VirtualMachineRelocateSpec", spec);
        paras[3] = new Argument("testType", "String[]", testType);
        return (ManagedObjectReference) wsc.invoke("CheckRelocate_Task", paras, "ManagedObjectReference");
    }

    public void validateCredentialsInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        wsc.invoke("ValidateCredentialsInGuest", paras, null);
    }

    public GuestAuthentication acquireCredentialsInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication requestedAuth, long sessionID) throws java.rmi.RemoteException, GuestOperationsFault, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("requestedAuth", "GuestAuthentication", requestedAuth);
        paras[3] = new Argument("sessionID", "long", sessionID);
        return (GuestAuthentication) wsc.invoke("AcquireCredentialsInGuest", paras, "GuestAuthentication");
    }

    public void releaseCredentialsInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth) throws java.rmi.RemoteException, GuestOperationsFault, TaskInProgress, InvalidState, RuntimeFault {
        Argument[] paras = new Argument[3];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        wsc.invoke("ReleaseCredentialsInGuest", paras, null);
    }

    public void makeDirectoryInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String directoryPath, boolean createParentDirectories) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("directoryPath", "String", directoryPath);
        paras[4] = new Argument("createParentDirectories", "boolean", createParentDirectories);
        wsc.invoke("MakeDirectoryInGuest", paras, null);
    }

    public void deleteFileInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String filePath) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("filePath", "String", filePath);
        wsc.invoke("DeleteFileInGuest", paras, null);
    }

    public void deleteDirectoryInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String directoryPath, boolean recursive) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("directoryPath", "String", directoryPath);
        paras[4] = new Argument("recursive", "boolean", recursive);
        wsc.invoke("DeleteDirectoryInGuest", paras, null);
    }

    public void moveDirectoryInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String srcDirectoryPath, String dstDirectoryPath) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("srcDirectoryPath", "String", srcDirectoryPath);
        paras[4] = new Argument("dstDirectoryPath", "String", dstDirectoryPath);
        wsc.invoke("MoveDirectoryInGuest", paras, null);
    }

    public void moveFileInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String srcFilePath, String dstFilePath, boolean overwrite) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("srcFilePath", "String", srcFilePath);
        paras[4] = new Argument("dstFilePath", "String", dstFilePath);
        paras[5] = new Argument("overwrite", "boolean", overwrite);
        wsc.invoke("MoveFileInGuest", paras, null);
    }

    public String createTemporaryFileInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String prefix, String suffix, String directoryPath) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("prefix", "String", prefix);
        paras[4] = new Argument("suffix", "String", suffix);
        paras[5] = new Argument("directoryPath", "String", directoryPath);
        return (String) wsc.invoke("CreateTemporaryFileInGuest", paras, "String");
    }

    public String createTemporaryDirectoryInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String prefix, String suffix, String directoryPath) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[6];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("prefix", "String", prefix);
        paras[4] = new Argument("suffix", "String", suffix);
        paras[5] = new Argument("directoryPath", "String", directoryPath);
        return (String) wsc.invoke("CreateTemporaryDirectoryInGuest", paras, "String");
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
        return (GuestListFileInfo) wsc.invoke("ListFilesInGuest", paras, "GuestListFileInfo");
    }

    public void changeFileAttributesInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String guestFilePath, GuestFileAttributes fileAttributes) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[5];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("guestFilePath", "String", guestFilePath);
        paras[4] = new Argument("fileAttributes", "GuestFileAttributes", fileAttributes);
        wsc.invoke("ChangeFileAttributesInGuest", paras, null);
    }

    public FileTransferInformation initiateFileTransferFromGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String guestFilePath) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("guestFilePath", "String", guestFilePath);
        return (FileTransferInformation) wsc.invoke("InitiateFileTransferFromGuest", paras, "FileTransferInformation");
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
        return (String) wsc.invoke("InitiateFileTransferToGuest", paras, "String");
    }

    public long startProgramInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, GuestProgramSpec spec) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("spec", "GuestProgramSpec", spec);
        Long ret = (Long) wsc.invoke("StartProgramInGuest", paras, "long");
        return ret.longValue();
    }

    public GuestProcessInfo[] listProcessesInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, long[] pids) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("pids", "long[]", pids);
        return (GuestProcessInfo[]) wsc.invoke("ListProcessesInGuest", paras, "GuestProcessInfo[]");
    }

    public void terminateProcessInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, long pid) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("pid", "long", pid);
        wsc.invoke("TerminateProcessInGuest", paras, null);
    }

    public String[] readEnvironmentVariableInGuest(ManagedObjectReference _this, ManagedObjectReference vm, GuestAuthentication auth, String[] names) throws java.rmi.RemoteException, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault {
        Argument[] paras = new Argument[4];
        paras[0] = new Argument("_this", "ManagedObjectReference", _this);
        paras[1] = new Argument("vm", "ManagedObjectReference", vm);
        paras[2] = new Argument("auth", "GuestAuthentication", auth);
        paras[3] = new Argument("names", "String[]", names);
        return (String[]) wsc.invoke("ReadEnvironmentVariableInGuest", paras, "String[]");
    }

}