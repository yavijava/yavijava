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

import java.net.MalformedURLException;
import java.rmi.RemoteException;

import com.vmware.vim25.*;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 * @author Steve JIN (sjin@vmware.com)
 */

public class SessionManager extends ManagedObject 
{

	public SessionManager(ServerConnection serverConnection, ManagedObjectReference mor) 
	{
		super(serverConnection, mor);
	}
	
	public UserSession getCurrentSession()
	{
		return (UserSession) getCurrentProperty("currentSession");
	}

	public String getDefaultLocale()
	{
		return (String) getCurrentProperty("defaultLocale");
	}

	public String getMessage()
	{
		return (String) getCurrentProperty("message");
	}
	
	public String[] getMessageLocaleList()
	{
		return (String[]) getCurrentProperty("messageLocaleList");
	}
	
	public UserSession[] getSessionList()
	{
		return (UserSession[]) getCurrentProperty("sessionList");
	}
	
	public String[] getSupportedLocaleList()
	{
		return (String[]) getCurrentProperty("supportedLocaleList");
	}
	
	public SessionManagerLocalTicket acquireLocalTicket(String userName) throws InvalidLogin, RuntimeFault, RemoteException 
	{
		return getVimService().acquireLocalTicket(getMOR(), userName);
	}
	
	/** @since SDK4.0 
	 * You don't need to use this method. Instead, look at the other cloneSession method.
	 * */
	public UserSession cloneSession(String cloneTicket) throws InvalidLogin, RuntimeFault, RemoteException
	{
		return getVimService().cloneSession(getMOR(), cloneTicket);
	}
	
  /**
   * Copyright 2009 NetApp, contribution by Eric Forgette
   * Modified by Steve Jin (sjin@vmware.com)
   * 
   * This constructor builds a new ServiceInstance based on a ServiceInstance.
   * The new ServiceInstance is effectively a clone of the first.  This clone will
   * NOT become invalid when the first is logged out.
   * 
   * @author Eric Forgette (forgette@netapp.com)
   * @throws RemoteException 
   * @throws RuntimeFault 
   * @throws InvalidLogin 
   * @throws MalformedURLException 
   * 
   */
	public ServiceInstance cloneSession(boolean ignoreCert) throws InvalidLogin, RuntimeFault, RemoteException, MalformedURLException
	{
	  ServiceInstance oldsi = getServerConnection().getServiceInstance();
	  ServerConnection oldsc = oldsi.getServerConnection();
    String ticket = oldsi.getSessionManager().acquireCloneTicket();
	  
    VimPortType vimService = new VimPortType(oldsc.getUrl().toString(), ignoreCert);
    vimService.getWsc().setVimNameSpace(oldsc.getVimService().getWsc().getVimNameSpace());

    ServerConnection newsc = new ServerConnection(oldsc.getUrl(), vimService, null);
    ServiceInstance newsi = new ServiceInstance(newsc);
    newsc.setServiceInstance(newsi);
    
    UserSession userSession = newsi.getSessionManager().cloneSession(ticket);
    newsc.setUserSession(userSession);
    return newsi;
	}

	/** @since SDK4.0 
	 * This method is called in the cloneSession method. If you happen to use this method,
	 * please double check if it's really needed.
	 * */
	public String acquireCloneTicket() throws RuntimeFault, RemoteException
	{
		return getVimService().acquireCloneTicket(getMOR());
	}
	
	/** @since SDK4.0 */
	public UserSession loginExtensionBySubjectName(String extensionKey, String locale) throws InvalidLogin, InvalidLocale, NotFound, NoClientCertificate, NoSubjectName, RuntimeFault, RemoteException
	{
		return getVimService().loginExtensionBySubjectName(getMOR(), extensionKey, locale);
	}
	
	public UserSession impersonateUser(String userName, String locale) throws InvalidLogin, InvalidLocale, RuntimeFault, RemoteException 
	{
		return getVimService().impersonateUser(getMOR(), userName, locale);
	}
	
	public UserSession login(String userName, String password, String locale) throws InvalidLogin, InvalidLocale, RuntimeFault, RemoteException 
	{
		return getVimService().login(getMOR(), userName, password, locale);
	}
	
	public UserSession loginBySSPI(String base64Token, String locale) throws InvalidLogin, InvalidLocale, SSPIChallenge, RuntimeFault, RemoteException 
	{
		return getVimService().loginBySSPI(getMOR(), base64Token, locale);
	}
	
	public void logout() throws RuntimeFault, RemoteException 
	{
		getVimService().logout(getMOR());
	}
	
	public boolean sessionIsActive(String sessionID, String userName) throws RuntimeFault, RemoteException 
	{
		return getVimService().sessionIsActive(getMOR(), sessionID, userName);
	}
	
	public void setLocale(String locale) throws InvalidLocale, RuntimeFault, RemoteException 
	{
		getVimService().setLocale(getMOR(), locale);
	}
	
	public void terminateSession(String[] sessionIDs) throws NotFound, RuntimeFault, RemoteException 
	{
		getVimService().terminateSession(getMOR(), sessionIDs);
	}
	
	public void updateServiceMessage(String message) throws RuntimeFault, RemoteException 
	{
		getVimService().updateServiceMessage(getMOR(), message);
	}
	
}
