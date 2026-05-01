// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;
import java.util.Calendar;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ProfileConfigInfo;
import com.vmware.vim25.ProfileDescription;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class Profile extends ManagedObject {

    public Profile(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public String getComplianceStatus() {
        return (String) getCurrentProperty("complianceStatus");
    }

    public ProfileConfigInfo getConfig() {
        return (ProfileConfigInfo) getCurrentProperty("config");
    }

    public Calendar getCreatedTime() {
        return (Calendar) getCurrentProperty("createdTime");
    }

    public ProfileDescription getDescription() {
        return (ProfileDescription) getCurrentProperty("description");
    }

    public Calendar getModifiedTime() {
        return (Calendar) getCurrentProperty("modifiedTime");
    }

    public String getName() {
        return (String) getCurrentProperty("name");
    }

    public void destroyProfile() throws RuntimeFault, RemoteException {
        getVimService().destroyProfile(getMOR());
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public ProfileDescription getDescriptioin() {
        return (ProfileDescription) getCurrentProperty("description");
    }
    public ManagedEntity[] getEntity() {
    Object[] objs = getManagedObjects("entity");
    if (objs.length == 0) {
        return new ManagedEntity[] {};
    }
    ManagedEntity[] mes = new ManagedEntity[objs.length];
    for (int i = 0; i < objs.length; i++) {
        mes[i] = (ManagedEntity) objs[i];
    }
    return mes;
}
    public void associateProfile(ManagedEntity[] mes) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = MorUtil.createMORs(mes);
    getVimService().associateProfile(getMOR(), mors);
}
    public Task checkProfileCompliance_Task(ManagedEntity[] mes) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = MorUtil.createMORs(mes);
    ManagedObjectReference taskMor = getVimService().checkProfileCompliance_Task(getMOR(), mors);
    return new Task(getServerConnection(), taskMor);
}
    public String exportProfile() throws RuntimeFault, RemoteException {
    return (String) getVimService().exportProfile(getMOR());
}
    public void dissociateProfile(ManagedEntity[] mes) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = MorUtil.createMORs(mes);
    getVimService().dissociateProfile(getMOR(), mors);
}
    /**
 * @since SDK5.0
 */
public ProfileDescription retrieveDescription() throws RuntimeFault, RemoteException {
    return getVimService().retrieveDescription(getMOR());
}
    /* ===== END custom ===== */
}
