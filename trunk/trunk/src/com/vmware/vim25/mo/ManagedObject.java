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

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.rmi.RemoteException;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.*;

/**
 * This class is intended to provide a wrapper around a managed object class.
 * The abstraction will hide the web service details and make the managed
 * objects OO style in the client side programming.
 * Every managed object class can inherit from this and take advantage of this
 * abstraction.
 * @author Steve JIN (sjin@vmware.com)
 */

abstract public class ManagedObject 
{
	private static String MO_PACKAGE_NAME = null;
	static 
	{
		MO_PACKAGE_NAME = ManagedObject.class.getPackage().getName();
	}
	
	/** holds the ServerConnection instance */
	private ServerConnection serverConnection = null;
	/** holds the ExtensionManager managed object reference */
	private ManagedObjectReference mor =  null;
	
	protected ManagedObject()
	{
	}
	
	/**
	 * Constructor that reuse exiting web service connection
	 * Use this contructor when you can re-use existing web service connection.
	 * @param serverConnection
	 * @param mor
	 */
	public ManagedObject(ServerConnection serverConnection, ManagedObjectReference mor)
	{
		this.serverConnection = serverConnection;
		this.mor = mor;
	}
	

	/**
	 * Set the ManagedObjectReference object pointing to the managed object
	 */
	protected void setMOR(ManagedObjectReference mor)
	{
		this.mor = mor;
	}
	
	/**
	 * get the ManagedObjectReference object pointing to the managed object
	 * @return
	 */
	public ManagedObjectReference getMOR()
	{
		return this.mor;
	}

	/**
	 * Get the web service
	 * @return
	 */
	protected VimPortType getVimService() 
	{
		return serverConnection.getVimService();
	}

	public ServerConnection getServerConnection() 
	{
		return serverConnection;
	}

	/**
	 * Set up the ServerConnection, only when it hasn't been set yet.
	 * @param sc
	 */
	protected void setServerConnection(ServerConnection sc)
	{
		if(this.serverConnection==null)
		{
			this.serverConnection = sc;
		}
	}

	protected ObjectContent retrieveObjectProperties(String[] properties) 
	{
		PropertySpec pSpec = new PropertySpec();
		pSpec.setAll(new Boolean (properties == null || properties.length == 0)); //if true, all props of this obj are to be read regardless of propName
		pSpec.setType(getMOR().getType());
		pSpec.setPathSet(properties);
		
		ObjectSpec oSpec = new ObjectSpec();
		oSpec.setObj(getMOR());
		oSpec.setSkip(Boolean.FALSE);
		
		PropertyFilterSpec pfSpec = new PropertyFilterSpec();
		pfSpec.setObjectSet(new ObjectSpec[] { oSpec });
		pfSpec.setPropSet(new PropertySpec[] { pSpec });
		
		PropertyCollector pc = getServerConnection().getServiceInstance().getPropertyCollector();
		
		ObjectContent[] objs;
		try
		{
			objs = pc.retrieveProperties(new PropertyFilterSpec[] { pfSpec });
		} catch(Exception e)
		{
			throw new RuntimeException(e);
		}

		if (objs == null || objs[0]==null)
			return null;
		else
			return objs[0];
	}
	
	/**
	 * @param propertyName The property name of current managed object
	 * @return it will return either an array of related data objects, or an data object itself.
	 * ManagedObjectReference objects are data objects!!!
	 * @throws RemoteException 
	 * @throws RuntimeFault 
	 * @throws InvalidProperty 
	 * @
	 */
	
	protected Object getCurrentProperty(String propertyName)  
	{
		ObjectContent objContent = retrieveObjectProperties(new String[] { propertyName });
		      
		Object propertyValue = null;
		   	
		if (objContent != null) 
		{
			DynamicProperty[] dynaProps = objContent.getPropSet();
		   		
			if ((dynaProps != null) && (dynaProps[0]!= null)) 
			{
				propertyValue = convertProperty(dynaProps[0].getVal());
			}
		}
		return propertyValue;
	}
	/**
	 * Get a nested property using a property path, e.g. "config.alternateGuestName"
	 * The property path cannot include ManagedObjectReference type.
	 * @param propPath
	 * @return Object, the caller needs to do casting to real type
	*/
	public Object getPropertyByPath(String propPath)
	{
		return getCurrentProperty(propPath);
	}

	private Object convertProperty(Object dynaPropVal) 
	{
		Object propertyValue = null;
		
		Class propClass = dynaPropVal.getClass();
		String propName = propClass.getName();
		if (propName.indexOf("ArrayOf") != -1) //Check the dynamic propery for ArrayOfXXX object 
		{ 	
			String methodName = propName.substring(propName.indexOf("ArrayOf") +"ArrayOf".length());
//			 If object is ArrayOfXXX object, then get the XXX[] by invoking getXXX() on the object. For Ex:
//			 ArrayOfManagedObjectReference.getManagedObjectReference() returns ManagedObjectReference[] array.
			try
			{
				Method getMethod = propClass.getMethod("get" + methodName, (Class[])null);
				if (getMethod==null) 
				{
	            	getMethod = propClass.getMethod("get_" + methodName.toLowerCase(), (Class[])null);
	            }
	
				propertyValue = getMethod.invoke(dynaPropVal, (Object[])null);
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		} 
        else if (dynaPropVal.getClass().isArray()) //Handle the case of an unwrapped array being deserialized.
        { 
        	propertyValue = dynaPropVal;
        } 
        else 
        {
        	propertyValue = dynaPropVal;
        } 
		
		return propertyValue;
	}
	
	protected ManagedObject[] getManagedObjects(String propName, boolean mixedType) 
	{
		Object object = getCurrentProperty(propName);
		ManagedObjectReference[] mors = null;
		if(object instanceof ManagedObjectReference[])
		{
			mors = (ManagedObjectReference[]) object;
		}
		
		if(mors==null || mors.length==0)
		{
			return new ManagedObject[] {}; 
		}
		
		String moType = mors[0].getType();

		Object arr = new Object[mors.length];
		
		try
		{
			Class moClass = null;
			
			if(mixedType==false)
			{
				moClass = Class.forName(MO_PACKAGE_NAME + "." + moType);
			}else
			{
				moClass = Class.forName(MO_PACKAGE_NAME + "." + "ManagedObject");
			}
			
			Constructor constructor = moClass.getConstructor(new Class[] {ServerConnection.class, ManagedObjectReference.class});
		    arr = Array.newInstance(moClass, mors.length);
		    
			for(int i=0; i<mors.length; i++)
			{
				Array.set(arr, i, 
					constructor.newInstance(new Object[] { getServerConnection(), mors[i]}) );
			}
		} catch(Exception e)
		{
			e.printStackTrace();
		}
	
		return (ManagedObject[]) arr;
	}

	
	protected ManagedObject[] getManagedObjects(String propName) 
	{
		return getManagedObjects(propName, false);
	}
	
	protected Datastore[] getDatastores(String propName)
	{
		Object[] objs = getManagedObjects(propName);
		if(objs.length == 0)
		{
			return new Datastore[] {};
		}
		return (Datastore[]) objs;
	}

	protected Network[] getNetworks(String propName)
	{
		Object[] objs = getManagedObjects(propName);
		if(objs.length == 0)
		{
			return new Network[] {};
		}
		return (Network[]) objs;
	}

	protected VirtualMachine[] getVms(String propName)
	{
		ManagedObject[] objs = getManagedObjects(propName);
		if(objs.length == 0)
		{
			return new VirtualMachine[] {};
		}
		return (VirtualMachine[]) objs;
	}

	protected PropertyFilter[] getFilter(String propName)
	{
		Object[] objs = getManagedObjects(propName);
		if(objs.length == 0)
		{
			return new PropertyFilter[] {};
		}
		return (PropertyFilter[]) objs;
	}
	
	protected ResourcePool[] getResourcePools(String propName)
	{
		Object[] objs = getManagedObjects(propName);
		if(objs.length == 0)
		{
			return new ResourcePool[] {};
		}
		return (ResourcePool[]) objs;
	}
	
	protected Task[] getTasks(String propName)
	{
		Object[] objs = getManagedObjects(propName);
		if(objs.length == 0)
		{
			return new Task[] {};
		}
		return (Task[]) objs;
	}
	
	protected ScheduledTask[] getScheduledTasks(String propName)
	{
		Object[] objs = getManagedObjects(propName);
		if(objs.length == 0)
		{
			return new ScheduledTask[] {};
		}
		return (ScheduledTask[]) objs;
	}

	protected View[] getViews(String propName)
	{
		Object[] objs = getManagedObjects(propName);
		if(objs.length == 0)
		{
			return new View[] {};
		}
		return (View[]) objs;
	}

	protected HostSystem[] getHosts(String propName)
	{
		Object[] objs = getManagedObjects(propName);
		if(objs.length == 0)
		{
			return new HostSystem[] {};
		}
		return (HostSystem[]) objs;
	}

	protected ManagedObject getManagedObject(String propName) 
	{
		ManagedObjectReference mor = (ManagedObjectReference) getCurrentProperty(propName);
		return MorUtil.createExactManagedObject(getServerConnection(), mor);
	}
	
   /**
    *  Handle Updates for a single object.
    *  waits till expected values of properties to check are reached
    *  Destroys the ObjectFilter when done.
    *  @param filterProps Properties list to filter
    *  @param endWaitProps
    *    Properties list to check for expected values
    *    these be properties of a property in the filter properties list
    *  @param expectedVals values for properties to end the wait
    *  @return true indicating expected values were met, and false otherwise
 * @throws RemoteException 
 * @throws RuntimeFault 
 * @throws InvalidProperty 
    */
	protected Object[] waitForValues(String[] filterProps, String[] endWaitProps, Object[][] expectedVals) throws InvalidProperty, RuntimeFault, RemoteException  
	{
		String version = "";
		Object[] endVals = new Object[endWaitProps.length];
		Object[] filterVals = new Object[filterProps.length];
		
		ObjectSpec oSpec = new ObjectSpec();
		oSpec.setObj(getMOR());
		oSpec.setSkip(Boolean.FALSE);
		oSpec.setSelectSet(null);
		
		PropertySpec pSpec = new PropertySpec();
		pSpec.setAll(new Boolean (filterProps == null || filterProps.length == 0)); //if true, all props of this obj are to be read regardless of propName
		pSpec.setType(getMOR().getType());
		pSpec.setPathSet(filterProps);

		PropertyFilterSpec spec = new PropertyFilterSpec();
		spec.setObjectSet(new ObjectSpec[] { oSpec });
		spec.setPropSet(new PropertySpec[] { pSpec });

		PropertyCollector pc = serverConnection.getServiceInstance().getPropertyCollector();
		PropertyFilter pf = pc.createFilter(spec, true);
	
		boolean reached = false;
		
		while (!reached) 
		{
			UpdateSet updateset = pc.waitForUpdates(version);
			if(updateset==null)
			{
				continue;
			}
		    version = updateset.getVersion();
		    PropertyFilterUpdate[] filtupary = updateset.getFilterSet();
		    if (filtupary == null) 
		    {
		    	continue;
		    }

		    // Make this code more general purpose when PropCol changes later.
		    for (int i = 0; i < filtupary.length; i++) 
		    {
				PropertyFilterUpdate filtup = filtupary[i];
				ObjectUpdate[] objupary = filtup.getObjectSet();
		    	for (int j = 0; j < objupary.length; j++) 
		    	{
		    		ObjectUpdate objup = objupary[j];
		    		PropertyChange[] propchgary = objup.getChangeSet();
		            for (int k = 0; k < propchgary.length; k++) 
		           	{
		        		PropertyChange propchg = propchgary[k];
	                    updateValues(endWaitProps, endVals, propchg);
	                    updateValues(filterProps, filterVals, propchg);
		           	}
		    	}
		    }
		    
		    // Check if the expected values have been reached and exit the loop if done.
		    // Also exit the WaitForUpdates loop if this is the case.
		    for (int chgi = 0; chgi < endVals.length && !reached; chgi++) 
		    {
		    	for (int vali = 0; vali < expectedVals[chgi].length && !reached; vali++) 
		    	{
		    		Object expctdval = expectedVals[chgi][vali];
		    		reached = expctdval.equals(endVals[chgi]) || reached;
		    	}
		    }
		}

		pf.destroyPropertyFilter();

		return filterVals;
	}

	private void updateValues(String[] props, Object[] vals, PropertyChange propchg) 
	{
		for (int i = 0; i < props.length; i++) 
		{
			if (propchg.getName().lastIndexOf(props[i]) >= 0) 
			{
				if (propchg.getOp() == PropertyChangeOp.remove) 
				{
					vals[i] = "";
				} 
				else 
				{
					vals[i] = propchg.getVal();
				}
			}
		}
	}
	
	public String toString()
	{
		return mor.getType() + ":" + mor.get_value()
			+ "@" + getServerConnection().getUrl();
	}
	
}
