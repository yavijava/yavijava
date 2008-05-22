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
import com.vmware.vim25.mo.util.*;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 * @author Steve JIN (sjin@vmware.com)
 */

public class ViewManager extends ManagedObject 
{

	public ViewManager(ServerConnection sc, ManagedObjectReference mor) 
	{
		super(sc, mor);
	}
	
	public View[] getViewList()
	{
		return getViews("viewList");
	}
	
	public ContainerView createContainerView(ManagedEntity container, String[] type, boolean recursive) throws RuntimeFault, RemoteException 
	{
		if(container==null)
		{
			throw new IllegalArgumentException("container must not be null.");
		}
		return new ContainerView(getServerConnection(),
				getVimService().createContainerView(getMOR(), container.getMOR(), type, recursive));
	}
	
	public InventoryView createInventoryView() throws RuntimeFault, RemoteException 
	{
		return new InventoryView(getServerConnection(),
				getVimService().createInventoryView(getMOR()));
	}
	
	public ListView createListView(ManagedObject[] mos) throws RuntimeFault, RemoteException 
	{
		return new ListView(getServerConnection(),
				getVimService().createListView(getMOR(), mos==null? null : MorUtil.createMORs(mos)) );
	}
	
	public ListView createListViewFromView(View view) throws RuntimeFault, RemoteException 
	{
		if(view==null)
		{
			throw new IllegalArgumentException("view must not be null.");
		}
		ManagedObjectReference mor = getVimService().createListViewFromView(getMOR(), view.getMOR());
		return new ListView(getServerConnection(), mor);
	}

}
