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

import com.vmware.vim25.AlarmState;
import com.vmware.vim25.CustomFieldValue;
import com.vmware.vim25.DuplicateName;
import com.vmware.vim25.Event;
import com.vmware.vim25.InvalidName;
import com.vmware.vim25.ManagedEntityStatus;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.Permission;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.Tag;
import com.vmware.vim25.VimFault;

/**
 * ManagedEntity represents the managed objects that can be listed in the inventory tree.
 * @author Steve JIN (sjin@vmware.com)
 */

public class ManagedEntity extends ExtensibleManagedObject 
{
	public ManagedEntity(ServerConnection sc, ManagedObjectReference mor) 
	{
		super(sc, mor);
	}
	
	/* =========================Accessors=================================*/
	
	/** @since SDK4.0 */
	public boolean getAlarmActionEabled()
	{
	  Boolean aae = (Boolean)getCurrentProperty("alarmActionsEnabled");
    return aae == null? false : aae.booleanValue();
	}
	
	public Event[] getConfigIssue()
	{
		return (Event[]) getCurrentProperty("configIssue");
	}
	
	public ManagedEntityStatus getConfigStatus()
	{
		return (ManagedEntityStatus) getCurrentProperty("configStatus");
	}

	public CustomFieldValue[] getCustomValue()
	{
		return (CustomFieldValue[]) getCurrentProperty("customValue");
	}

	public AlarmState[] getDeclaredAlarmState()
	{
		return (AlarmState[]) getCurrentProperty("declaredAlarmState");
	}
	
	public String[] getDisabledMethod()
	{
		return (String[]) getCurrentProperty("disabledMethod");
	}
	
	public int[] getEffectiveRole()
	{
		return (int[]) getCurrentProperty("effectiveRole");
	}
	
	public String getName()
	{
		return (String) getCurrentProperty("name");
	}
	
	public ManagedEntityStatus getOverallStatus()
	{
		return (ManagedEntityStatus) getCurrentProperty("overallStatus");
	}

	public ManagedEntity getParent()
	{
		return (ManagedEntity) this.getManagedObject("parent");
	}
	
	public Permission[] getPermission()
	{
		return (Permission[]) getCurrentProperty("permission");
	}

	public Task[] getRecentTasks()
	{
		return getTasks("recentTask");
	}

	/** @since SDK4.0 */
	public Tag[] getTag()
	{
		return (Tag[]) getCurrentProperty("tag");
	}
	
	public AlarmState[] getTriggeredAlarmState()
	{
		return (AlarmState[]) getCurrentProperty("triggeredAlarmState");
	}
	
	/* =========================Methods=================================*/
	
	public Task destroy_Task() throws VimFault, RuntimeFault, RemoteException 
	{
		ManagedObjectReference taskMor = getVimService().destroy_Task(getMOR());
		return new Task(getServerConnection(), taskMor);
	}
	
	public void reload() throws RuntimeFault, RemoteException 
	{
		getVimService().reload(getMOR());
	}
	
	public Task rename_Task(String name) throws InvalidName, DuplicateName, RuntimeFault, RemoteException 
	{
		ManagedObjectReference taskMor = getVimService().rename_Task(getMOR(), name);
		return new Task(getServerConnection(), taskMor);
	}




}
