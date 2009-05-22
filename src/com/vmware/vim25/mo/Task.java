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

import com.vmware.vim25.InvalidProperty;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.LocalizedMethodFault;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.MethodFault;
import com.vmware.vim25.OutOfBounds;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.TaskInfo;
import com.vmware.vim25.TaskInfoState;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 * @author Steve JIN (sjin@vmware.com)
 */

public class Task extends ExtensibleManagedObject 
{
	public static final String PROPNAME_INFO = "info";
	public static final String SUCCESS = "success";

	public Task(ServerConnection serverConnection, ManagedObjectReference mor) 
	{
		super(serverConnection, mor);
	}

	public TaskInfo getTaskInfo() throws InvalidProperty, RuntimeFault, RemoteException 
	{
		return (TaskInfo) getCurrentProperty(PROPNAME_INFO);
	}
	
	public ManagedEntity getAssociatedManagedEntity()
	{
		return (ManagedEntity) getManagedObject("info.entity");
	}
	
	public ManagedEntity[] getLockedManagedEntities()
	{
		return (ManagedEntity[]) getManagedObjects("info.locked");
	}
	
	public void cancelTask() throws RuntimeFault, RemoteException 
	{
		getVimService().cancelTask(getMOR());
	}
	
	public void setTaskState(TaskInfoState tis, Object result, LocalizedMethodFault fault) throws InvalidState, RuntimeFault, RemoteException 
	{
		getVimService().setTaskState(getMOR(), tis, result, fault);
	}
	
	public void updateProgress(int percentDone) throws InvalidState, OutOfBounds, RuntimeFault, RemoteException 
	{
		getVimService().updateProgress(getMOR(), percentDone);
	}
	
	public String waitForMe() throws InvalidProperty, RuntimeFault, RemoteException  
	{   
		
		Object[] result = waitForValues(
                new String[] { "info.state", "info.error" }, 
                new String[] { "state" },
                new Object[][] { new Object[] { TaskInfoState.success, TaskInfoState.error } });      

		if (result[0].equals(TaskInfoState.success)) 
		{      	 
			return SUCCESS;
		}
		else 
		{
			TaskInfo tinfo = (TaskInfo) getCurrentProperty(PROPNAME_INFO);      	 
			LocalizedMethodFault fault = tinfo.getError();
			String error = "Error Occured";
			if(fault!=null) 
			{
				MethodFault mf = fault.getFault();
				throw mf;
			}
			return error;
		}
	}
	
}
