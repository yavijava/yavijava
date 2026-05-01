// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import com.vmware.vim25.IpPool;
import com.vmware.vim25.IpPoolManagerIpAllocation;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
/* ===== END custom imports ===== */

public class IpPoolManager extends ManagedObject {

    public IpPoolManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void destroyIpPool(Datacenter dc, int id, boolean force) throws InvalidState, RuntimeFault, RemoteException {
        getVimService().destroyIpPool(getMOR(), dc == null ? null : dc.getMOR(), id, force);
    }

    public void releaseIpAllocation(Datacenter dc, int poolId, String allocationId) throws RuntimeFault, RemoteException {
        getVimService().releaseIpAllocation(getMOR(), dc == null ? null : dc.getMOR(), poolId, allocationId);
    }

    public void updateIpPool(Datacenter dc, IpPool pool) throws RuntimeFault, RemoteException {
        getVimService().updateIpPool(getMOR(), dc == null ? null : dc.getMOR(), pool);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public int createIpPool(Datacenter dc, IpPool pool) throws RuntimeFault, RemoteException {
    return getVimService().createIpPool(getMOR(), dc.getMOR(), pool);
}
    public IpPool[] queryIpPools(Datacenter dc) throws RuntimeFault, RemoteException {
    return getVimService().queryIpPools(getMOR(), dc.getMOR());
}
    /**
 * @since SDK5.1
 */
public String allocateIpv4Address(Datacenter dc, int poolId, String allocationId) throws RuntimeFault, RemoteException {
    return getVimService().allocateIpv4Address(getMOR(), dc.getMOR(), poolId, allocationId);
}
    /**
 * @since SDK5.1
 */
public String allocateIpv6Address(Datacenter dc, int poolId, String allocationId) throws RuntimeFault, RemoteException {
    return getVimService().allocateIpv6Address(getMOR(), dc.getMOR(), poolId, allocationId);
}
    /**
 * @since SDK5.1
 */
public IpPoolManagerIpAllocation[] queryIPAllocations(Datacenter dc, int poolId, String extensionKey) throws RuntimeFault, RemoteException {
    return getVimService().queryIPAllocations(getMOR(), dc.getMOR(), poolId, extensionKey);
}
    /* ===== END custom ===== */
}
