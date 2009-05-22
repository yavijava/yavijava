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

import com.vmware.vim25.ComplianceResult;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ProfileExpressionMetadata;
import com.vmware.vim25.RuntimeFault;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 * @since 4.0
 * @author Steve JIN (sjin@vmware.com)
 */
public class ProfileComplianceManager extends ManagedObject 
{
	public ProfileComplianceManager(ServerConnection sc, ManagedObjectReference mor) 
	{
		super(sc, mor);
	}
	
	public Task checkCompliance_Task(Profile[] profile, ManagedEntity[] entity) throws RuntimeFault, RemoteException
	{
		ManagedObjectReference[] ps = convertMors(profile);
		ManagedObjectReference[] es = convertMors(entity);
		
		ManagedObjectReference taskMor = getVimService().checkCompliance_Task(getMOR(), ps, es);
		return new Task(getServerConnection(), taskMor);
	}

	public void clearComplianceStatus(Profile[] profile, ManagedEntity[] entity) throws RuntimeFault, RemoteException
	{
		getVimService().clearComplianceStatus(getMOR(), 
				convertMors(profile), convertMors(entity));
	}
	
	public ComplianceResult[] queryComplianceStatus(Profile[] profile, ManagedEntity[] entity) throws RuntimeFault, RemoteException
	{
		return getVimService().queryComplianceStatus(getMOR(), convertMors(profile), convertMors(entity));
	}
	
	public ProfileExpressionMetadata[] queryExpressionMetadata(String[] expressionName) throws RuntimeFault, RemoteException
	{
		return getVimService().queryExpressionMetadata(getMOR(), expressionName);
	}
}
