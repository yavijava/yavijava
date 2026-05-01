// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class ExtensionManager extends ManagedObject {

    public ExtensionManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public Extension[] getExtensionList() {
        return (Extension[]) getCurrentProperty("extensionList");
    }

    public String getPublicKey() throws RuntimeFault, RemoteException {
        return getVimService().getPublicKey(getMOR());
    }

    public void setCertificate(String extensionKey, String certificatePem) throws NoClientCertificate, NotFound, RuntimeFault, RemoteException {
        getVimService().setExtensionCertificate(getMOR(), extensionKey, certificatePem);
    }

    public void setPublicKey(String extensionKey, String publicKey) throws RuntimeFault, RemoteException {
        getVimService().setPublicKey(getMOR(), extensionKey, publicKey);
    }

    public void setServiceAccount(String extensionKey, String serviceAccount) throws NotFound, RuntimeFault, RemoteException {
        getVimService().setServiceAccount(getMOR(), extensionKey, serviceAccount);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /**
 * @since SDK5.1
 */
public ExtensionManagerIpAllocationUsage[] queryExtensionIpAllocationUsage(String[] extensionKeys) throws RuntimeFault, RemoteException {
    return getVimService().queryExtensionIpAllocationUsage(getMOR(), extensionKeys);
}
    /**
 * @since SDK5.0
 */
public ManagedEntity[] queryManagedBy(String extensionKey) throws RuntimeFault, RemoteException {
    ManagedObjectReference[] mors = getVimService().queryManagedBy(getMOR(), extensionKey);
    return MorUtil.createManagedEntities(getServerConnection(), mors);
}
    /**
 * Un-register an existing plugin If <code>keyStr</code> is null then a
 * <code>NullPointerException</code> is thrown.
 *
 * @param keyStr The unique key of the plugin
 * @throws RemoteException
 * @throws RuntimeFault
 * @throws NotFound        either because of the web service itself, or because of the
 *                         service provider unable to handle the request.
 */
public void unregisterExtension(String keyStr) throws NotFound, RuntimeFault, RemoteException {
    if (keyStr == null) {
        throw new NullPointerException();
    }
    getVimService().unregisterExtension(getMOR(), keyStr);
}
    /**
 * Update an existing plugin with modified information If
 * <code>extension</code> is null then a <code>NullPointerException</code> is
 * thrown.
 *
 * @param extension The extension object with updated information
 * @throws RemoteException
 * @throws RuntimeFault
 * @throws NotFound        either because of the web service itself, or because of the
 *                         service provider unable to handle the request.
 */
public void updateExtension(Extension extension) throws NotFound, RuntimeFault, RemoteException {
    if (extension == null) {
        throw new NullPointerException();
    }
    encodeUrl(extension);
    getVimService().updateExtension(getMOR(), extension);
}
    /**
 * Register a new plugin If <code>extension</code> is null then a
 * <code>NullPointerException</code> is thrown.
 *
 * @param extension The extension object to be registered
 * @throws RemoteException
 * @throws RuntimeFault    either because of the web service itself, or because of the
 *                         service provider unable to handle the request.
 */
public void registerExtension(Extension extension) throws RuntimeFault, RemoteException {
    if (extension == null) {
        throw new NullPointerException();
    }
    encodeUrl(extension);
    getVimService().registerExtension(getMOR(), extension);
}
    /**
 * Find the extension based on the unique key of the plugin If
 * <code>keyStr</code> is null then a <code>NullPointerException</code>
 *
 * @param keyStr The unique key for the plugin
 * @return The extension object found with the unique key
 * @throws RemoteException
 * @throws RuntimeFault
 * @throws RemoteException if something is wrong with web service call, either because of
 *                         the web service itself, or because of the service provider unable
 *                         to handle the request.
 */
public Extension findExtension(String keyStr) throws RuntimeFault, RemoteException {
    if (keyStr == null) {
        throw new NullPointerException();
    }
    return getVimService().findExtension(getMOR(), keyStr);
}
    protected void encodeUrl(Extension extension) {
    // replace all the & in the url with &amp;
    for (int i = 0; extension.client != null && i < extension.client.length; i++) {
        ExtensionClientInfo eci = extension.client[i];
        if (eci.url.contains("&")) {
            eci.url = eci.url.replaceAll("&", "&amp;");
        }
    }
    for (int i = 0; extension.server != null && i < extension.server.length; i++) {
        ExtensionServerInfo esi = extension.server[i];
        if (esi.url.contains("&")) {
            esi.url = esi.url.replaceAll("&", "&amp;");
        }
    }
}
    /**
 * Print out information of all the plugins to stdout
 *
 * @deprecated
 */
public void printAllExtensions() {
    Extension[] exts = getExtensionList();
    System.out.println("There are totally " + exts.length + " plugin(s) registered.");
    for (int i = 0; i < exts.length; i++) {
        System.out.println("\n ---- Plugin # " + (i + 1) + " ---- ");
        System.out.println("Key: " + exts[i].getKey());
        System.out.println("Version: " + exts[i].getVersion());
        System.out.println("Registration Time: " + exts[i].getLastHeartbeatTime().getTime());
        System.out.println("Configuration URL: " + exts[i].getServer()[0].getUrl());
    }
}
    /* ===== END custom ===== */
}
