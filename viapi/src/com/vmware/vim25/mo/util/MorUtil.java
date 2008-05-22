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

package com.vmware.vim25.mo.util;

import java.lang.reflect.Constructor;
import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;

/**
 * Utility class for the Managed Object and ManagedObjectReference.
 * @author Steve JIN (sjin@vmware.com)
 */

public class MorUtil 
{
	final public static String moPackageName = "com.vmware.vim25.mo";

	public static ManagedObjectReference[] createMORs(ManagedObject[] mos)
	{
		if(mos==null)
		{
			throw new IllegalArgumentException();
		}
		ManagedObjectReference[] mors = new ManagedObjectReference[mos.length];
		for(int i=0; i<mos.length; i++)
		{
			mors[i] = mos[i].getMOR();
		}
		return mors;
	}

	public static ManagedObject createExactManagedObject(ServerConnection sc, ManagedObjectReference mor)
	{
		if(mor==null)
		{
			return null;
		}
		
		String moType = mor.getType();

		try
		{
			Class moClass = Class.forName(moPackageName + "." + moType);
			Constructor constructor = moClass.getConstructor(
					new Class[] {ServerConnection.class, ManagedObjectReference.class});
			return (ManagedObject) constructor.newInstance( new Object[] { sc, mor} );
		} catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static ManagedEntity createExactManagedEntity(ServerConnection sc, ManagedObjectReference mor) 
	{
		return (ManagedEntity) createExactManagedObject(sc, mor);
	}
	
	public String methodFaultToString(MethodFault mf) 
	{
		return "Type : " + mf.getClass().getName() + 
			"\n Actor : " + mf.getFaultActor() + 
		    "\n Code : " + mf.getFaultNode() +
		    "\n Reason : " + mf.getFaultReason() +
		    "\n Fault String : " + mf.getFaultString();
	}

	public static ManagedEntity[] createManagedEntities(ServerConnection sc, ManagedObjectReference[] mors) 
	{
		ManagedEntity[] mes = new ManagedEntity[mors.length];
		
		for(int i=0; i< mors.length; i++)
		{
			mes[i] = createExactManagedEntity(sc, mors[i]);
		}
		
		return mes;
	}

}
