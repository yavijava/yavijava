// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.InvalidDatastore;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.mo.util.MorUtil;
/* ===== END custom imports ===== */

public class SearchIndex extends ManagedObject {

    public SearchIndex(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /**
 * find a managed object in the inventory tree.
 *
 * @param inventoryPath The inventory path to the managed object searched.
 * @return ManagedEntity object.
 * @throws RemoteException
 * @throws RuntimeFault
 */
public ManagedEntity findByInventoryPath(String inventoryPath) throws RuntimeFault, RemoteException {
    ManagedObjectReference mor = getVimService().findByInventoryPath(getMOR(), inventoryPath);
    return MorUtil.createExactManagedEntity(getServerConnection(), mor);
}
    /**
 * Find a Virtual Machine or Host System by its IP address.
 *
 * @param datacenter The datacenter within which it searches. If null is passed, all inventory is searched.
 * @param ip         The IP address of the VM or Host.
 * @param vmOnly     When set true only searches for VM; otherwise only for Host.
 * @return A ManagedEntity to either HostSystem or VirtualMachine having the IP address.
 * @throws RuntimeFault
 * @throws RemoteException
 */
public ManagedEntity findByIp(Datacenter datacenter, String ip, boolean vmOnly) throws RuntimeFault, RemoteException {
    ManagedObjectReference mor = getVimService().findByIp(getMOR(), datacenter == null ? null : datacenter.getMOR(), ip, vmOnly);
    return MorUtil.createExactManagedEntity(getServerConnection(), mor);
}
    public ManagedEntity findByDnsName(Datacenter datacenter, String dnsName, boolean vmOnly) throws RuntimeFault, RemoteException {
    ManagedObjectReference mor = getVimService().findByDnsName(getMOR(), datacenter == null ? null : datacenter.getMOR(), dnsName, vmOnly);
    return MorUtil.createExactManagedEntity(getServerConnection(), mor);
}
    /**
 * @since SDK4.0
 */
public ManagedEntity[] findAllByDnsName(Datacenter datacenter, String dnsName, boolean vmSearch) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = getVimService().findAllByDnsName(getMOR(), datacenter == null ? null : datacenter.getMOR(), dnsName, vmSearch);
    return MorUtil.createManagedEntities(getServerConnection(), mors);
}
    /**
 * @since SDK4.0
 */
public ManagedEntity[] findAllByIp(Datacenter datacenter, String ip, boolean vmSearch) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = getVimService().findAllByIp(getMOR(), datacenter == null ? null : datacenter.getMOR(), ip, vmSearch);
    return MorUtil.createManagedEntities(getServerConnection(), mors);
}
    /**
 * @since SDK4.0
 */
public ManagedEntity[] findAllByUuid(Datacenter datacenter, String uuid, boolean vmSearch, boolean instanceUuid) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = getVimService().findAllByUuid(getMOR(), datacenter == null ? null : datacenter.getMOR(), uuid, vmSearch, instanceUuid);
    return MorUtil.createManagedEntities(getServerConnection(), mors);
}
    /**
 * Find a VM by its location on a datastore
 *
 * @param datacenter The datacenter within which it searches.
 * @param dPath      The datastore path, for example, "[storage1] WinXP/WinXP.vmx".
 * @return A VirtualMachine that pointed by the dPath
 * @throws RemoteException
 * @throws RuntimeFault
 * @throws InvalidDatastore
 */
public VirtualMachine findByDatastorePath(Datacenter datacenter, String dPath) throws InvalidDatastore, RuntimeFault, RemoteException {
    if (datacenter == null) {
        throw new IllegalArgumentException("datacenter must not be null.");
    }
    ManagedObjectReference mor = getVimService().findByDatastorePath(getMOR(), datacenter.getMOR(), dPath);
    return (VirtualMachine) MorUtil.createExactManagedEntity(getServerConnection(), mor);
}
    //SDK2.5 signature for back compatibility
public ManagedEntity findByUuid(Datacenter datacenter, String uuid, boolean vmOnly) throws RuntimeFault, RemoteException {
    return findByUuid(datacenter, uuid, vmOnly, null);
}
    //SDK4.0 signature
public ManagedEntity findByUuid(Datacenter datacenter, String uuid, boolean vmOnly, Boolean instanceUuid) throws RuntimeFault, RemoteException {
    ManagedObjectReference mor = getVimService().findByUuid(getMOR(), datacenter == null ? null : datacenter.getMOR(), uuid, vmOnly, instanceUuid);
    return MorUtil.createExactManagedEntity(getServerConnection(), mor);
}
    /**
 * Find a child entity under a ManagedObjectReference in the inventory.
 *
 * @param parent The parent managed entity.
 * @param name   The name of the child to search.
 * @return A child entity.
 * @throws RemoteException
 * @throws RuntimeFault
 */
public ManagedEntity findChild(ManagedEntity parent, String name) throws RuntimeFault, RemoteException {
    if (parent == null) {
        throw new IllegalArgumentException("parent entity must not be null.");
    }
    ManagedObjectReference mor = getVimService().findChild(getMOR(), parent.getMOR(), name);
    return MorUtil.createExactManagedEntity(getServerConnection(), mor);
}
    /* ===== END custom ===== */
}
