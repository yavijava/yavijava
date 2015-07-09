package com.vmware.vim25.mo;

import com.vmware.vim25.*;

import java.rmi.RemoteException;

/**
 * Copyright 2015 Michael Rice &lt;michael@michaelrice.org&gt;
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @since 6.0
 */
public class OverheadMemoryManager extends ManagedObject {

    public OverheadMemoryManager(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    /**
     * Return static VM overhead memory value in bytes for a (vm, host) pair from the overhead memory module (OMM)
     * in Virtual Center.
     *
     * @param vm   The Virtual Machine
     * @param host The Host
     * @return Overhead memory value, if found in the OMM.
     * @throws InvalidArgument
     * @throws InvalidType
     * @throws ManagedObjectNotFound
     * @throws NotFound
     * @throws RuntimeFault
     * @throws RemoteException
     */
    public long lookupVmOverheadMemory(VirtualMachine vm, HostSystem host) throws InvalidArgument, InvalidType, ManagedObjectNotFound, NotFound, RuntimeFault, RemoteException {
        return getVimService().lookupVmOverheadMemory(getMOR(), vm.getMOR(), host.getMOR());
    }
}
