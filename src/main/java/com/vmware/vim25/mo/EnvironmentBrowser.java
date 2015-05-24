/*================================================================================
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

import java.rmi.RemoteException;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 *
 * @author Steve JIN (http://www.doublecloud.org)
 */

public class EnvironmentBrowser extends ManagedObject {

    public EnvironmentBrowser(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostDatastoreBrowser getDatastoreBrowser() {
        return (HostDatastoreBrowser) this.getManagedObject("datastoreBrowser");
    }

    public VirtualMachineConfigOption queryConfigOption(String key, HostSystem host) throws RuntimeFault, RemoteException {
        return getVimService().queryConfigOption(getMOR(), key, host == null ? null : host.getMOR());
    }

    public VirtualMachineConfigOptionDescriptor[] queryConfigOptionDescriptor() throws RuntimeFault, RemoteException {
        return getVimService().queryConfigOptionDescriptor(getMOR());
    }

    public ConfigTarget queryConfigTarget(HostSystem host) throws RuntimeFault, RemoteException {
        return getVimService().queryConfigTarget(getMOR(), host == null ? null : host.getMOR());
    }

    public HostCapability queryTargetCapabilities(HostSystem host) throws RuntimeFault, RemoteException {
        return getVimService().queryTargetCapabilities(getMOR(), host == null ? null : host.getMOR());
    }

    /**
     * Query for a virtual machine configuration option matching the key or host or both given in the
     * {@link com.vmware.vim25.EnvironmentBrowserConfigOptionQuerySpec EnvironmentBrowserConfigOptionQuerySpec}. For
     * more details see {@link #queryConfigOption queryConfigOption}
     * If the Environment Browser belongs to a virtual machine and the spec argument is omitted, the method returns the
     * ConfigOption object corresponding to the vmx version of the virutal machine and the guestOSDescriptor list
     * contains only the guestId of the virutal machine.
     *
     * @param spec -
     *             Search criteria and filters to control the result. If a key or host (or both) are specified, they
     *             will be used to search for a config option. If guestId is nonempty, the guestOSDescriptor array of
     *             the config option is filtered to match against the guest IDs in the spec. If there is no match, the
     *             whole list is returned. If the spec argument is omitted, the default VirtualMachineConfigOption for
     *             this environment browser is returned.
     * @return Returns the VirtualMachineConfigOption object. If invoked on a cluster with no hosts, or if the VirtualMachineConfigOption with given key is not found for the given host, null is returned.
     * @throws InvalidArgument
     * @throws RuntimeFault
     * @throws RemoteException
     * @since 6.0
     */
    public VirtualMachineConfigOption queryConfigOptionEx(EnvironmentBrowserConfigOptionQuerySpec spec) throws InvalidArgument, RuntimeFault, RemoteException {
        return getVimService().queryConfigOptionEx(getMOR(), spec);
    }

    public VirtualMachineConfigOption queryConfigOptionEx() throws InvalidArgument, RuntimeFault, RemoteException {
        return queryConfigOptionEx(null);
    }
}
