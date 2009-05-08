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

package com.vmware.vim.cf;
import java.util.Map;

import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.mo.ManagedObject;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * @author Steve JIN (sjin@vmware.com)
 */

public class CacheInstance 
{
  ServiceInstance si = null;
	ManagedObjectWatcher mom = null;
	ManagedObjectCache cache = null;
	Thread mThread = null;
	
	public CacheInstance(ServiceInstance si)
	{
	  this.si = si;
		mom = new ManagedObjectWatcher(si.getPropertyCollector());
		cache = new ManagedObjectCache();
		mom.addObserver(cache);
	}
	
	public void watch(ManagedObject[] mos, String[] props)
	{
		mom.watch(mos, props);
	}
	
	public void watch(PropertyFilterSpec pfs)
	{
		mom.watch(pfs);
	}

  public Object getCopy(ManagedObject mo, String propName)
  {
     Object obj = get(mo.getMOR(), propName);
     try
     {
       obj = DeepCopier.deepCopy(obj);
     } catch(Exception e)
     {
       throw new RuntimeException(e);
     }
     return obj;
   }

  public Object getCopy(ManagedObjectReference mor, String propName)
  {
    return getCopy(mor, propName);
  }
   
	public Object get(ManagedObject mo, String propName)
	{
		return get(mo.getMOR(), propName);
	}
	
	public Object get(ManagedObjectReference mor, String propName)
	{
	  Map<ManagedObjectReference, Map<String, Object>> items = cache.getCachedItems();
	  
    Map<String, Object> moMap =  items.get(mor);
	  if(moMap!=null)
	  {
		return moMap.get(propName);
	  }
	  return null;
	}

	public void start()
	{
	  mThread = new Thread(mom);
	  mThread.setName("MonitorThead for " + si.getServerConnection().getUrl());
	  mThread.start();
	}
	
	public void destroy()
	{
		mom.cleanUp();
		mThread.stop();
		si = null;
		mom = null;
		cache = null;
		mThread = null;
	}
	
	public ServiceInstance getServiceInstance()
	{
	  return si;
	}
	
	public boolean isReady()
	{
		return cache.isReady();
	}
}