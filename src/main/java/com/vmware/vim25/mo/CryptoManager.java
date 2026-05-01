// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class CryptoManager extends ManagedObject {

    public CryptoManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void addKey(CryptoKeyPlain key) throws AlreadyExists, InvalidState, RuntimeFault, RemoteException {
        getVimService().addKey(getMOR(), key);
    }

    public CryptoKeyResult[] addKeys(CryptoKeyPlain[] keys) throws InvalidState, RuntimeFault, RemoteException {
        return getVimService().addKeys(getMOR(), keys);
    }

    public void removeKey(CryptoKeyId key, boolean force) throws ResourceInUse, RuntimeFault, RemoteException {
        getVimService().removeKey(getMOR(), key, force);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public boolean getEnabled() {
    Boolean enabled = (Boolean) this.getCurrentProperty("enabled");
    return enabled != null && enabled.booleanValue();
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
    return listKeys(0);
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
    /* ===== END custom ===== */
}
