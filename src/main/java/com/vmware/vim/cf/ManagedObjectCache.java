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
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ConcurrentHashMap;

import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.ObjectUpdate;
import com.vmware.vim25.PropertyChange;
import com.vmware.vim25.PropertyFilterUpdate;
import com.vmware.vim25.mo.ManagedObject;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.util.MorUtil;

import static com.vmware.vim.cf.NullObject.NULL;

/**
 * @author Steve JIN (sjin@vmware.com)
 */

class ManagedObjectCache implements Observer
{
    // each value is yet another child HashMap corresponding to a ManagedObject
    // The child HashMap has key -- property name; value -- property value
    private Map<ManagedObjectReference, Map<String, Object>> items;
    private boolean isReady = false;
    private ServiceInstance si;

    ManagedObjectCache(ServiceInstance si)
    {
      this.si = si;
      items = new ConcurrentHashMap<ManagedObjectReference, Map<String, Object>>();
    }
    
    public Map<ManagedObjectReference, Map<String, Object>> getCachedItems()
    {
        return items;
    }

    public void update(Observable obj, Object arg)
    {
        if (arg instanceof PropertyFilterUpdate[])
        {
            PropertyFilterUpdate[] pfus = (PropertyFilterUpdate[]) arg;
            
            for(int i=0; pfus!=null && i< pfus.length; i++)
            {
                ObjectUpdate[] ous = pfus[i].getObjectSet();
                for(int j=0; ous!=null && j < ous.length; j++)
                {
                    ManagedObjectReference mor = ous[j].getObj();
                    if(! items.containsKey(mor))
                    {
                        items.put(mor, new ConcurrentHashMap<String, Object>());
                    }
                    Map<String, Object> moMap = items.get(mor);
                    
                    PropertyChange[] pcs = ous[j].getChangeSet();
                    if(pcs==null)
                    {
                      continue;
                    }
                    for(int k=0; k < pcs.length; k++)
                    {
                    	  Object value = pcs[k].getVal();
                    	  value = value == null ? NULL : value; //null is not allowed as value in CHM
                    	  String propName = pcs[k].getName();
                    	  if(moMap.containsKey(propName))
                    	  {
                    	    moMap.put(propName, value);
                    	  }
                    	  else
                    	  {
                    	    String parentPropName = getExistingParentPropName(moMap, propName);
                    	    if(parentPropName != null)
                    	    {
                    	      ManagedObject mo = MorUtil.createExactManagedObject(si.getServerConnection(), mor);
                    	      moMap.put(parentPropName, mo.getPropertyByPath(parentPropName));
                    	    }
                    	    else
                    	    { //almost impossible to be here.
                    	      moMap.put(propName, value);
                    	    }
                    	  }
                    }
                }
            }
        }
        isReady = true;
    }
    
    private String getExistingParentPropName(Map<String, Object> moMap, String propName)
    {
      //remove everything after the first "["
      int pos = propName.indexOf("[");
      if(pos != -1)
      {
        propName = propName.substring(0, pos);
      }
      
      while(true)
      {
        int lastDot = propName.lastIndexOf(".");
        if(lastDot==-1)
        {
          return null;
        }
        propName = propName.substring(0, lastDot);
        if(moMap.containsKey(propName))
        {
          return propName;
        }
      }
    }
    
    public boolean isReady()
    {
    	return isReady;
    }
}