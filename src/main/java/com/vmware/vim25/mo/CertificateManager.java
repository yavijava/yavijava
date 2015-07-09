package com.vmware.vim25.mo;

import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.SystemError;
import com.vmware.vim25.mo.util.MorUtil;

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
 */
public class CertificateManager extends ManagedObject {

    /**
     * Class constructor
     */
    public CertificateManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    /**
     * Returns a Task you can use to track the status of the job that
     * re-fetches certificates of trusted CAs and the Certificate
     * Revocation Lists (CRL) from the appropriate authoritative
     * source and pushes them to the hosts
     *
     * @param hostSystems an Array of HostSystem objects
     * @return Task from vSphere
     * @throws RuntimeFault    Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
     * @throws SystemError     Thrown if any of the needed actions fails.
     * @throws RemoteException
     * @see com.vmware.vim25.mo.Task
     */
    public Task certMgrRefreshCACertificatesAndCRLs_Task(HostSystem[] hostSystems) throws RuntimeFault, SystemError, RemoteException {
        ManagedObjectReference taskMor = getVimService().certMgrRefreshCACertificatesAndCRLs_Task(getMOR(), MorUtil.createMORs(hostSystems));
        return new Task(getServerConnection(), taskMor);
    }

    /**
     * Returns a Task you can use to track the status of the job that
     * gets CSRs from the hosts and then gets these certificates signed
     * by the VMware Certificate Service and pushes them down to the hosts.
     *
     * @param hostSystems an Array of HostSystem objects
     * @return Task from vSphere
     * @throws RuntimeFault    Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
     * @throws SystemError     Thrown if any of the needed actions fails.
     * @throws RemoteException
     * @see com.vmware.vim25.mo.Task
     */
    public Task certMgrRefreshCertificates_Task(HostSystem[] hostSystems) throws RuntimeFault, SystemError, RemoteException {
        ManagedObjectReference taskMor = getVimService().certMgrRefreshCertificates_Task(getMOR(), MorUtil.createMORs(hostSystems));
        return new Task(getServerConnection(), taskMor);
    }

    /**
     * Revokes the certificates of some hosts. Returns a Task to track
     * the status of the job.
     *
     * @param hostSystems an Array of HostSystem objects
     * @return Task from vSphere
     * @throws RuntimeFault    Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
     * @throws SystemError     Thrown if any of the needed actions fails.
     * @throws RemoteException
     * @see com.vmware.vim25.mo.Task
     */
    public Task certMgrRevokeCertificates_Task(HostSystem[] hostSystems) throws RuntimeFault, SystemError, RemoteException {
        ManagedObjectReference taskMor = getVimService().certMgrRevokeCertificates_Task(getMOR(), MorUtil.createMORs(hostSystems));
        return new Task(getServerConnection(), taskMor);
    }
}
