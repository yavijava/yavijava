// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.NotFound;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.UserSearchResult;
/* ===== END custom imports ===== */

public class UserDirectory extends ManagedObject {

    public UserDirectory(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public String[] getDomainList() {
        return (String[]) getCurrentProperty("domainList");
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public UserSearchResult[] retrieveUserGroups(String domain, String searchStr, String belongsToGroup, String belongsToUser, boolean exactMatch, boolean findUsers, boolean findGroups) throws NotFound, RuntimeFault, RemoteException {
    return getVimService().retrieveUserGroups(getMOR(), domain, searchStr, belongsToGroup, belongsToUser, exactMatch, findUsers, findGroups);
}
    /* ===== END custom ===== */
}
