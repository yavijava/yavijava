// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class CryptoManagerHost extends CryptoManager {

    public CryptoManagerHost(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public Task changeKey(CryptoKeyPlain newKey) throws InvalidState, RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().changeKey_Task(getMOR(), newKey);
        return new Task(getServerConnection(), resultMor);
    }

    public void disable() throws InvalidState, RuntimeFault, RemoteException {
        getVimService().cryptoManagerHostDisable(getMOR());
    }

    public void enable(CryptoKeyPlain initialKey) throws AlreadyExists, InvalidState, RuntimeFault, RemoteException {
        getVimService().cryptoManagerHostEnable(getMOR(), initialKey);
    }

    public CryptoManagerHostKeyStatus[] getCryptoKeyStatus(CryptoKeyId[] keys) throws RuntimeFault, RemoteException {
        return getVimService().getCryptoKeyStatus(getMOR(), keys);
    }

    public void prepare() throws InvalidState, RuntimeFault, RemoteException {
        getVimService().cryptoManagerHostPrepare(getMOR());
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /* ===== END custom ===== */
}
