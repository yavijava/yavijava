// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class CustomizationSpecManager extends ManagedObject {

    public CustomizationSpecManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public byte[] getEncryptionKey() {
        return (byte[]) getCurrentProperty("encryptionKey");
    }

    public CustomizationSpecInfo[] getInfo() {
        return (CustomizationSpecInfo[]) getCurrentProperty("info");
    }

    public void checkResources(String guestOs) throws CustomizationFault, RuntimeFault, RemoteException {
        getVimService().checkCustomizationResources(getMOR(), guestOs);
    }

    public void create(CustomizationSpecItem item) throws AlreadyExists, CustomizationFault, RuntimeFault, RemoteException {
        getVimService().createCustomizationSpec(getMOR(), item);
    }

    public void delete(String name) throws NotFound, RuntimeFault, RemoteException {
        getVimService().deleteCustomizationSpec(getMOR(), name);
    }

    public void duplicate(String name, String newName) throws AlreadyExists, NotFound, RuntimeFault, RemoteException {
        getVimService().duplicateCustomizationSpec(getMOR(), name, newName);
    }

    public boolean exists(String name) throws RuntimeFault, RemoteException {
        return getVimService().doesCustomizationSpecExist(getMOR(), name);
    }

    public CustomizationSpecItem get(String name) throws NotFound, RuntimeFault, RemoteException {
        return getVimService().getCustomizationSpec(getMOR(), name);
    }

    public boolean isGuestOsCustomizable(String guestId) throws RuntimeFault, RemoteException {
        return getVimService().isGuestOsCustomizable(getMOR(), guestId);
    }

    public void overwrite(CustomizationSpecItem item) throws ConcurrentAccess, CustomizationFault, NotFound, RuntimeFault, RemoteException {
        getVimService().overwriteCustomizationSpec(getMOR(), item);
    }

    public void rename(String name, String newName) throws AlreadyExists, NotFound, RuntimeFault, RemoteException {
        getVimService().renameCustomizationSpec(getMOR(), name, newName);
    }

    public String specItemToXml(CustomizationSpecItem item) throws RuntimeFault, RemoteException {
        return getVimService().customizationSpecItemToXml(getMOR(), item);
    }

    public CustomizationSpecItem xmlToSpecItem(String specItemXml) throws CustomizationFault, RuntimeFault, RemoteException {
        return getVimService().xmlToCustomizationSpecItem(getMOR(), specItemXml);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public String customizationSpecItemToXml(CustomizationSpecItem item) throws RuntimeFault, RemoteException {
    return getVimService().customizationSpecItemToXml(getMOR(), item);
}
    public boolean doesCustomizationSpecExist(String name) throws RuntimeFault, RemoteException {
    return getVimService().doesCustomizationSpecExist(getMOR(), name);
}
    public CustomizationSpecItem getCustomizationSpec(String name) throws NotFound, RuntimeFault, RemoteException {
    return getVimService().getCustomizationSpec(getMOR(), name);
}
    public CustomizationSpecItem xmlToCustomizationSpecItem(String specItemXml) throws CustomizationFault, RuntimeFault, RemoteException {
    return getVimService().xmlToCustomizationSpecItem(getMOR(), specItemXml);
}
    /* ===== END custom ===== */
}
