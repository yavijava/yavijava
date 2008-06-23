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

import java.rmi.RemoteException;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.sso.Base64;

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
	
	/**
	 * Logs into the VI server using the current Windows credentials set.
	 * @return The UserSession object.
	 * @throws Exception
	 */
	public UserSession login() throws Exception
	{
		// The return value of LoginBySSPI -- the method we will be calling.
		UserSession us = null;

		// Createa a SSPIHelper object and some of its parameter defs.
		com.vmware.vim25.mo.sso.SSPIHelper ch = 
			new com.vmware.vim25.mo.sso.SSPIHelper();
		byte[] st = null;
		boolean [] kp = new boolean[] { true };

		// Get the base64 token for the current Windows logon session.
		byte[] ct = ch.InitializeClient( st, kp  );
		String ct_b64 = Base64.encodeBytes( ct );

		// Attempt to login to the VI server with this token.
		try
		{
			us = loginBySSPI( ct_b64, null );
		}
		
		/*
		 * If an exception is thrown and it is a SSPIChallenge then that
		 * means the VI server is not completely tired of us yet, it just
		 * wants us to try again. It sent us a base64 encoded challenge
		 * response that we can use to complete the credential acquisition.
		 */
		catch ( SSPIChallenge e )
		{
			String st_b64 = e.getBase64Token();
			st = Base64.decode( st_b64 );

			// Complete the credentials acquisition, this time with
			// the second part of the package.
			ct = ch.InitializeClient( st, kp );
			ct_b64 = Base64.encodeBytes( ct );

			// Now login to the VI server, and this time we mean it!
			us = loginBySSPI( ct_b64, null );
		}
		
		return ( us );
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
