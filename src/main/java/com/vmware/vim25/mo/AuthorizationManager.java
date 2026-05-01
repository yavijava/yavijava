// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class AuthorizationManager extends ManagedObject {

    public AuthorizationManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public AuthorizationDescription getDescription() {
        return (AuthorizationDescription) getCurrentProperty("description");
    }

    public AuthorizationPrivilege[] getPrivilegeList() {
        return (AuthorizationPrivilege[]) getCurrentProperty("privilegeList");
    }

    public AuthorizationRole[] getRoleList() {
        return (AuthorizationRole[]) getCurrentProperty("roleList");
    }

    public int addRole(String name, String[] privIds) throws AlreadyExists, InvalidName, RuntimeFault, RemoteException {
        return getVimService().addAuthorizationRole(getMOR(), name, privIds);
    }

    public UserPrivilegeResult[] fetchUserPrivilegeOnEntities(ManagedEntity[] entities, String userName) throws RuntimeFault, RemoteException {
        return getVimService().fetchUserPrivilegeOnEntities(getMOR(), entities == null ? null : MorUtil.createMORs(entities), userName);
    }

    public EntityPrivilege[] hasUserPrivilegeOnEntities(ManagedObject[] entities, String userName, String[] privId) throws RuntimeFault, RemoteException {
        return getVimService().hasUserPrivilegeOnEntities(getMOR(), entities == null ? null : MorUtil.createMORs(entities), userName, privId);
    }

    public void mergePermissions(int srcRoleId, int dstRoleId) throws AuthMinimumAdminPermission, NotFound, RuntimeFault, RemoteException {
        getVimService().mergePermissions(getMOR(), srcRoleId, dstRoleId);
    }

    public void removeRole(int roleId, boolean failIfUsed) throws NotFound, RemoveFailed, RuntimeFault, RemoteException {
        getVimService().removeAuthorizationRole(getMOR(), roleId, failIfUsed);
    }

    public void updateRole(int roleId, String newName, String[] privIds) throws AlreadyExists, InvalidName, NotFound, RuntimeFault, RemoteException {
        getVimService().updateAuthorizationRole(getMOR(), roleId, newName, privIds);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public int addAuthorizationRole(String name, String[] privIds) throws InvalidName, AlreadyExists, RuntimeFault, RemoteException {
    return getVimService().addAuthorizationRole(getMOR(), name, privIds);
}
    /**
 * @deprecated as of SDK5.5, use hasPrivilegeOnEntity instead, which fixed upper-case H typo in method name in 5.5
 */
public boolean[] HasPrivilegeOnEntity(ManagedEntity entity, String sessionId, String[] privId) throws RuntimeFault, RemoteException {
    return getVimService().hasPrivilegeOnEntity(getMOR(), entity.getMOR(), sessionId, privId);
}
    /**
 * @since SDK5.0
 */
public boolean[] hasPrivilegeOnEntity(ManagedEntity entity, String sessionId, String[] privId) throws RuntimeFault, RemoteException {
    return getVimService().hasPrivilegeOnEntity(getMOR(), entity.getMOR(), sessionId, privId);
}
    /**
 * @since SDK5.5
 */
public EntityPrivilege[] hasPrivilegeOnEntities(ManagedEntity[] entity, String sessionId, String[] privId) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = MorUtil.createMORs(entity);
    return getVimService().hasPrivilegeOnEntities(getMOR(), mors, sessionId, privId);
}
    public void removeEntityPermission(ManagedEntity entity, String user, boolean isGroup) throws AuthMinimumAdminPermission, NotFound, RuntimeFault, RemoteException {
    if (entity == null) {
        throw new IllegalArgumentException("entity must not be null.");
    }
    getVimService().removeEntityPermission(getMOR(), entity.getMOR(), user, isGroup);
}
    public void resetEntityPermissions(ManagedEntity entity, Permission[] permission) throws AuthMinimumAdminPermission, NotFound, UserNotFound, RuntimeFault, RemoteException {
    if (entity == null) {
        throw new IllegalArgumentException("entity must not be null.");
    }
    getVimService().resetEntityPermissions(getMOR(), entity.getMOR(), permission);
}
    public Permission[] retrieveEntityPermissions(ManagedEntity entity, boolean inherited) throws RuntimeFault, RemoteException {
    if (entity == null) {
        throw new IllegalArgumentException("entity must not be null.");
    }
    return getVimService().retrieveEntityPermissions(getMOR(), entity.getMOR(), inherited);
}
    public Permission[] retrieveAllPermissions() throws RuntimeFault, RemoteException {
    return getVimService().retrieveAllPermissions(getMOR());
}
    public Permission[] retrieveRolePermissions(int roleId) throws NotFound, RuntimeFault, RemoteException {
    return getVimService().retrieveRolePermissions(getMOR(), roleId);
}
    public void setEntityPermissions(ManagedEntity entity, Permission[] permission) throws AuthMinimumAdminPermission, NotFound, UserNotFound, RuntimeFault, RemoteException {
    if (entity == null) {
        throw new IllegalArgumentException("entity must not be null.");
    }
    getVimService().setEntityPermissions(getMOR(), entity.getMOR(), permission);
}
    /* ===== END custom ===== */
}
