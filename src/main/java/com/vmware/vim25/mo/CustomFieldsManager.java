// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class CustomFieldsManager extends ManagedObject {

    public CustomFieldsManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public CustomFieldDef[] getField() {
        return (CustomFieldDef[]) getCurrentProperty("field");
    }

    public CustomFieldDef addFieldDefinition(String name, String moType, PrivilegePolicyDef fieldDefPolicy, PrivilegePolicyDef fieldPolicy) throws DuplicateName, InvalidPrivilege, RuntimeFault, RemoteException {
        return getVimService().addCustomFieldDef(getMOR(), name, moType, fieldDefPolicy, fieldPolicy);
    }

    public void removeFieldDefinition(int key) throws RuntimeFault, RemoteException {
        getVimService().removeCustomFieldDef(getMOR(), key);
    }

    public void renameFieldDefinition(int key, String name) throws DuplicateName, RuntimeFault, RemoteException {
        getVimService().renameCustomFieldDef(getMOR(), key, name);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public CustomFieldDef addCustomFieldDef(String name, String moType, PrivilegePolicyDef fieldDefPolicy, PrivilegePolicyDef fieldPolicy) throws DuplicateName, InvalidPrivilege, RuntimeFault, RemoteException {
    return getVimService().addCustomFieldDef(getMOR(), name, moType, fieldDefPolicy, fieldPolicy);
}
    public void setField(ManagedEntity entity, int key, String value) throws RuntimeFault, RemoteException {
    if (entity == null) {
        throw new IllegalArgumentException("entity must not be null.");
    }
    getVimService().setField(getMOR(), entity.getMOR(), key, value);
}
    /* ===== END custom ===== */
}
