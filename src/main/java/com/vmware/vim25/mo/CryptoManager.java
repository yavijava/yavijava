package com.vmware.vim25.mo;

import com.vmware.vim25.*;

import java.rmi.RemoteException;

/**
 * Copyright 2016 Michael Rice <michael@michaelrice.org>
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
public class CryptoManager extends ManagedObject {

    public CryptoManager(ServerConnection sc, ManagedObjectReference mor) {
        super(sc, mor);
    }

    public boolean getEnabled() {
        Boolean enabled = (Boolean) this.getCurrentProperty("enabled");
        return enabled != null && enabled.booleanValue();
    }

    /**
     * Add an existing key.
     *
     * @param key [in] The cryptographic key to add.
     * @throws AlreadyExists in case the key is already in the key cache
     * @throws InvalidArgument in case the keyID is duplicated or key properties are incorrect.
     * @throws InvalidState in case the host is not Crypto Safe
     * @throws RuntimeFault Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
     * @throws RemoteException
     */
    public void addKey(CryptoKeyPlain key) throws AlreadyExists, InvalidArgument, InvalidState, RuntimeFault, RemoteException {
        getVimService().addKey(getMOR(), key);
    }

    /**
     * Add multiple existing keys.
     *
     * @param keys [in] List of cryptographic keys to add.
     * @throws InvalidState in case the host is not Crypto Safe
     * @throws RuntimeFault Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
     * @throws RemoteException
     */
    public void addKeys(CryptoKeyPlain[] keys) throws InvalidState, RuntimeFault, RemoteException {
        getVimService().addKeys(getMOR(), keys);
    }

    /**
     * List keys.
     * * When executed against the host, lists all the keys added to the host's key cache by AddKey/AddKeys.
     * * When executed against the VC, lists all the keys used by the correctly registered VMs,
     * and the host key.
     * @return List of known keys.
     * @throws RuntimeFault Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
     * @throws RemoteException
     */
    public CryptoKeyId[] listKeys() throws RuntimeFault, RemoteException {
        return getVimService().listKeys(getMOR());
    }

    /**
     * List keys.
     * * When executed against the host, lists all the keys added to the host's key cache by AddKey/AddKeys.
     * * When executed against the VC, lists all the keys used by the correctly registered VMs,
     * and the host key.
     *
     * @param limit [in] maximum keys to return.
     * @return List of known keys.
     * @throws RuntimeFault Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
     * @throws RemoteException
     */
    public CryptoKeyId[] listKeys(int limit) throws RuntimeFault, RemoteException {
        return getVimService().listKeys(getMOR(), limit);
    }

    /**
     * Remove a key (only the UUID is needed to remove). If "force" is true, removal will happen even if the key is in use.
     *
     * @param key [in] The key to remove.
     * @param force [in] Remove the key even if in use or not existent.
     * @throws InvalidArgument in case the keyID is not found and "force" is false.
     * @throws ResourceInUse Thrown if the key is used to encrypt any object and "force" is false.
     * @throws RuntimeFault Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
     * @throws RemoteException
     */
    public void removeKey(CryptoKeyId key, boolean force) throws InvalidArgument, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().removeKey(getMOR(), key, force);
    }

    /**
     * Remove multiple keys (only the UUID is needed to remove). If "force" is set, removal will happen even
     * if they are in use.
     *
     * @param keys [in] List of keys to remove.
     * @param force [in] Remove the key even if in use. Always successful.
     * @return {@link com.vmware.vim25.CryptoKeyResult CryptoKeyResult}
     * @throws RuntimeFault Thrown if any type of runtime fault is thrown that is not covered by the other faults; for example, a communication error.
     * @throws RemoteException
     */
    public CryptoKeyResult[] removeKeys(CryptoKeyId[] keys, boolean force) throws RuntimeFault, RemoteException {
        return getVimService().removeKeys(getMOR(), keys, force);
    }
}
