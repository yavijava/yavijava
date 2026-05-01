// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
import java.net.MalformedURLException;
/* ===== END custom imports ===== */

public class SessionManager extends ManagedObject {

    public SessionManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public UserSession getCurrentSession() {
        return (UserSession) getCurrentProperty("currentSession");
    }

    public String getDefaultLocale() {
        return (String) getCurrentProperty("defaultLocale");
    }

    public String getMessage() {
        return (String) getCurrentProperty("message");
    }

    public String[] getMessageLocaleList() {
        return (String[]) getCurrentProperty("messageLocaleList");
    }

    public UserSession[] getSessionList() {
        return (UserSession[]) getCurrentProperty("sessionList");
    }

    public String[] getSupportedLocaleList() {
        return (String[]) getCurrentProperty("supportedLocaleList");
    }

    public void logout() throws RuntimeFault, RemoteException {
        getVimService().logout(getMOR());
    }

    public void setLocale(String locale) throws InvalidLocale, RuntimeFault, RemoteException {
        getVimService().setLocale(getMOR(), locale);
    }

    public void terminateSession(String[] sessionId) throws NotFound, RuntimeFault, RemoteException {
        getVimService().terminateSession(getMOR(), sessionId);
    }

    public void updateServiceMessage(String message) throws RuntimeFault, RemoteException {
        getVimService().updateServiceMessage(getMOR(), message);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public SessionManagerLocalTicket acquireLocalTicket(String userName) throws InvalidLogin, RuntimeFault, RemoteException {
    return getVimService().acquireLocalTicket(getMOR(), userName);
}
    /**
 * @since SDK5.0
 */
public SessionManagerGenericServiceTicket acquireGenericServiceTicket(SessionManagerServiceRequestSpec spec) throws RuntimeFault, RemoteException {
    return getVimService().acquireGenericServiceTicket(getMOR(), spec);
}
    /**
 * @since SDK4.0
 * You don't need to use this method. Instead, look at the other cloneSession method.
 */
public UserSession cloneSession(String cloneTicket) throws InvalidLogin, RuntimeFault, RemoteException {
    return getVimService().cloneSession(getMOR(), cloneTicket);
}
    /**
 * Copyright 2009 NetApp, contribution by Eric Forgette
 * Modified by Steve Jin (sjin@vmware.com)
 * <p>
 * This constructor builds a new ServiceInstance based on a ServiceInstance.
 * The new ServiceInstance is effectively a clone of the first.  This clone will
 * NOT become invalid when the first is logged out.
 *
 * @throws RemoteException
 * @throws RuntimeFault
 * @throws InvalidLogin
 * @throws MalformedURLException
 * @author Eric Forgette (forgette@netapp.com)
 */
public ServiceInstance cloneSession(boolean ignoreCert) throws InvalidLogin, RuntimeFault, RemoteException, MalformedURLException {
    ServiceInstance oldsi = getServerConnection().getServiceInstance();
    ServerConnection oldsc = oldsi.getServerConnection();
    String ticket = oldsi.getSessionManager().acquireCloneTicket();
    VimPortType vimService = new VimPortType(oldsc.getUrl().toString(), ignoreCert);
    vimService.getWsc().setVimNameSpace(oldsc.getVimService().getWsc().getVimNameSpace());
    vimService.getWsc().setSoapActionOnApiVersion(oldsi.getAboutInfo().getApiVersion());
    ServerConnection newsc = new ServerConnection(oldsc.getUrl(), vimService, null);
    ServiceInstance newsi = new ServiceInstance(newsc);
    newsc.setServiceInstance(newsi);
    UserSession userSession = newsi.getSessionManager().cloneSession(ticket);
    newsc.setUserSession(userSession);
    return newsi;
}
    /**
 * @since SDK4.0
 * This method is called in the cloneSession method. If you happen to use this method,
 * please double check if it's really needed.
 */
public String acquireCloneTicket() throws RuntimeFault, RemoteException {
    return getVimService().acquireCloneTicket(getMOR());
}
    /**
 * @since SDK4.0
 */
public UserSession loginExtensionBySubjectName(String extensionKey, String locale) throws InvalidLogin, InvalidLocale, NotFound, NoClientCertificate, NoSubjectName, RuntimeFault, RemoteException {
    return getVimService().loginExtensionBySubjectName(getMOR(), extensionKey, locale);
}
    /**
 * @since SDK4.0
 */
public UserSession loginExtensionByCertificate(String extensionKey, String locale) throws InvalidLogin, InvalidLocale, NoClientCertificate, RuntimeFault, RemoteException {
    return getVimService().loginExtensionByCertificate(getMOR(), extensionKey, locale);
}
    public UserSession impersonateUser(String userName, String locale) throws InvalidLogin, InvalidLocale, RuntimeFault, RemoteException {
    return getVimService().impersonateUser(getMOR(), userName, locale);
}
    public UserSession login(String userName, String password, String locale) throws InvalidLogin, InvalidLocale, RuntimeFault, RemoteException {
    return getVimService().login(getMOR(), userName, password, locale);
}
    public UserSession loginBySSPI(String base64Token, String locale) throws InvalidLogin, InvalidLocale, SSPIChallenge, RuntimeFault, RemoteException {
    return getVimService().loginBySSPI(getMOR(), base64Token, locale);
}
    /**
 * @since SDK5.1
 */
public UserSession loginByToken(String locale) throws InvalidLogin, InvalidLocale, RuntimeFault, RemoteException {
    return getVimService().loginByToken(getMOR(), locale);
}
    public boolean sessionIsActive(String sessionID, String userName) throws RuntimeFault, RemoteException {
    return getVimService().sessionIsActive(getMOR(), sessionID, userName);
}
    /* ===== END custom ===== */
}
