/*================================================================================
Copyright (c) 2012 Steve Jin. All Rights Reserved.
Copyright (c) 2008 VMware, Inc. All Rights Reserved.

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

package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;

import java.rmi.RemoteException;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 *
 * @author Steve JIN (http://www.doublecloud.org)
 * @since 4.0
 */

public class DistributedVirtualSwitchManager extends ManagedObject {
    public DistributedVirtualSwitchManager(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    public DistributedVirtualSwitchProductSpec[] queryAvailableDvsSpec() throws RuntimeFault, RemoteException {
        return queryAvailableDvsSpec(null);
    }

    /**
     * This operation returns a list of switch product specifications that are supported by the vCenter Server.
     *
     * @param recommended If set to true, return only the recommened versions. If set to false, return only the not recommended versions. If unset, return all supported versions.
     * @return DistributedVirtualSwitchProductSpec[]
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public DistributedVirtualSwitchProductSpec[] queryAvailableDvsSpec(Boolean recommended) throws RuntimeFault, RemoteException {
        return getVimService().queryAvailableDvsSpec(getMOR(), recommended);
    }

    public HostSystem[] queryCompatibleHostForExistingDvs(ManagedEntity container, boolean recursive, DistributedVirtualSwitch dvs) throws RuntimeFault, RemoteException {
        ManagedObjectReference[] mors = getVimService().queryCompatibleHostForExistingDvs(getMOR(), container.getMOR(), recursive, dvs.getMOR());

        HostSystem[] hosts = new HostSystem[mors.length];
        for (int i = 0; i < hosts.length; i++) {
            hosts[i] = new HostSystem(getServerConnection(), mors[i]);
        }
        return hosts;
    }

    public HostSystem[] queryCompatibleHostForNewDvs(ManagedEntity container, boolean recursive, DistributedVirtualSwitchProductSpec switchProductSpec) throws RuntimeFault, RemoteException {
        ManagedObjectReference[] mors = getVimService().queryCompatibleHostForNewDvs(getMOR(), container.getMOR(), recursive, switchProductSpec);

        HostSystem[] hosts = new HostSystem[mors.length];
        for (int i = 0; i < hosts.length; i++) {
            hosts[i] = new HostSystem(getServerConnection(), mors[i]);
        }
        return hosts;
    }

    public DistributedVirtualSwitchHostProductSpec[] queryDvsCompatibleHostSpec(DistributedVirtualSwitchProductSpec switchProductSpec) throws RuntimeFault, RemoteException {
        return getVimService().queryDvsCompatibleHostSpec(getMOR(), switchProductSpec);
    }

    /**
     * @since SDK4.1
     */
    public DistributedVirtualSwitchManagerCompatibilityResult[] queryDvsCheckCompatibility(
        DistributedVirtualSwitchManagerHostContainer hostContainer, DistributedVirtualSwitchManagerDvsProductSpec dvsProductSpec,
        DistributedVirtualSwitchManagerHostDvsFilterSpec[] hostFilterSpec) throws RuntimeFault, RemoteException {
        return getVimService().queryDvsCheckCompatibility(getMOR(), hostContainer, dvsProductSpec, hostFilterSpec);
    }


    public DVSManagerDvsConfigTarget queryDvsConfigTarget(HostSystem host, DistributedVirtualSwitch dvs) throws RuntimeFault, RemoteException {
        return getVimService().queryDvsConfigTarget(getMOR(),
            host == null ? null : host.getMOR(),
            dvs == null ? null : dvs.getMOR());
    }

    public DistributedVirtualSwitch queryDvsByUuid(String uuid) throws NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference mor = getVimService().queryDvsByUuid(getMOR(), uuid);
        return new DistributedVirtualSwitch(getServerConnection(), mor);
    }

    /**
     * @since SDK4.1
     */
    public DVSFeatureCapability queryDvsFeatureCapability(DistributedVirtualSwitchProductSpec switchProductSpec) throws RuntimeFault, RemoteException {
        return getVimService().queryDvsFeatureCapability(getMOR(), switchProductSpec);
    }

    /**
     * @since SDK5.0
     */
    public Task rectifyDvsOnHost_Task(HostSystem[] hosts) throws DvsFault, RuntimeFault, RemoteException {
        ManagedObjectReference[] hostMors = MorUtil.createMORs(hosts);
        ManagedObjectReference taskMor = getVimService().rectifyDvsOnHost_Task(getMOR(), hostMors);
        return new Task(getServerConnection(), taskMor);
    }

    /**
     * @since SDK5.1
     */
    public Task dVSManagerExportEntity_Task(SelectionSet[] selectionSet) throws BackupBlobWriteFailure, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().dVSManagerExportEntity_Task(getMOR(), selectionSet);
        return new Task(getServerConnection(), taskMor);
    }

    /**
     * @since SDK5.1
     */
    public Task dVSManagerImportEntity_Task(EntityBackupConfig[] entityBackup, String importType) throws DvsFault, NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference taskMor = getVimService().dVSManagerImportEntity_Task(getMOR(), entityBackup, importType);
        return new Task(getServerConnection(), taskMor);
    }

    /**
     * @since SDK5.1
     */
    public DistributedVirtualPortgroup dVSManagerLookupDvPortGroup(String switchUuid, String portgroupKey) throws NotFound, RuntimeFault, RemoteException {
        ManagedObjectReference mor = getVimService().dVSManagerLookupDvPortGroup(getMOR(), switchUuid, portgroupKey);
        return new DistributedVirtualPortgroup(getServerConnection(), mor);
    }
}