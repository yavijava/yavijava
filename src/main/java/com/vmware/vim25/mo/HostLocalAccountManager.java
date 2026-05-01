// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostLocalAccountManager extends ManagedObject {

    public HostLocalAccountManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void assignUserToGroup(String user, String group) throws AlreadyExists, UserNotFound, RuntimeFault, RemoteException {
        getVimService().assignUserToGroup(getMOR(), user, group);
    }

    public void changePassword(String user, String oldPassword, String newPassword) throws InvalidLogin, RuntimeFault, RemoteException {
        getVimService().changePassword(getMOR(), user, oldPassword, newPassword);
    }

    public void createGroup(HostAccountSpec group) throws AlreadyExists, RuntimeFault, RemoteException {
        getVimService().createGroup(getMOR(), group);
    }

    public void createUser(HostAccountSpec user) throws AlreadyExists, RuntimeFault, RemoteException {
        getVimService().createUser(getMOR(), user);
    }

    public void removeGroup(String groupName) throws UserNotFound, RuntimeFault, RemoteException {
        getVimService().removeGroup(getMOR(), groupName);
    }

    public void removeUser(String userName) throws UserNotFound, RuntimeFault, RemoteException {
        getVimService().removeUser(getMOR(), userName);
    }

    public void unassignUserFromGroup(String user, String group) throws UserNotFound, RuntimeFault, RemoteException {
        getVimService().unassignUserFromGroup(getMOR(), user, group);
    }

    public void updateUser(HostAccountSpec user) throws AlreadyExists, UserNotFound, RuntimeFault, RemoteException {
        getVimService().updateUser(getMOR(), user);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
