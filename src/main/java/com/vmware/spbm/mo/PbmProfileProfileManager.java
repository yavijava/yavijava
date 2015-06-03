package com.vmware.spbm.mo;

import java.rmi.RemoteException;

import com.vmware.vim25.ManagedObjectReference;
import com.vmware.spbm.PbmCapabilityVendorNamespaceInfo;
import com.vmware.spbm.PbmProfileResourceType;
import com.vmware.vim25.RuntimeFault;

/**
 * @author Atoka Sema
 */

public class PbmProfileProfileManager extends PbmManagedObject {
    public PbmProfileProfileManager(PbmServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    public PbmCapabilityVendorNamespaceInfo[] pbmFetchVendorInfo(PbmProfileResourceType resourceType)
                    throws RuntimeFault, RemoteException {
        return getPbmService().pbmFetchVendorInfo(getMOR(), resourceType);
    }

    public PbmProfileResourceType[] pbmFetchResourceType() throws RuntimeFault, RemoteException {
        return getPbmService().pbmFetchResourceType(getMOR());
    }
}
