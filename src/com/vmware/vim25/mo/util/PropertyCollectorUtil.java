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

import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.util.Hashtable;
import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;


/**
 * Utility class for the PropertyCollector API.
 * @author Steve JIN (sjin@vmware.com)
 */
public class PropertyCollectorUtil 
{
	/**
	 * Retrieves properties from multiple managed objects.
	 * @param mos the array of managed objects which could be of single type or mixed types. When they are mix-typed,
	 * the moType must be super type of all these managed objects.
	 * @param moType the type of the managed object. This managed object type must have all the properties defined as
	 * in propPaths. 
	 * @param propPaths the array of property path which has dot as separator, for example, "name", "guest.toolsStatus".
	 * @return an array of Hashtable whose order is the same as the mos array. Each Hashtable has the properties for
	 * one managed object. Note: some of the properties you want to retrieve might not be set, and therefore you don't
	 * have an entry in the Hashtable at all. In other words, it's possible for you to get null for a property from the 
	 * resulted Hashtable.
	 * @throws InvalidProperty
	 * @throws RuntimeFault
	 * @throws RemoteException
	 */

	public static Hashtable[] retrieveProperties(ManagedObject[] mos, String moType,
			String[] propPaths) throws InvalidProperty, 
			RuntimeFault, RemoteException
	{
		if( mos==null )
			throw new IllegalArgumentException("Managed object array cannot be null.");
		if( mos.length ==0 || mos[0]==null )
			return new Hashtable[] {};
		
		PropertyCollector pc = mos[0].getServerConnection().getServiceInstance().getPropertyCollector();
		ObjectSpec[] oss = new ObjectSpec[mos.length]; 
		for(int i=0; i<oss.length; i++)
		{
			oss[i] = new ObjectSpec();
			oss[i].setObj(mos[i].getMOR());
		}

		PropertySpec pSpec = createPropertySpec(moType, false, propPaths);

		PropertyFilterSpec pfs = new PropertyFilterSpec();
		pfs.setObjectSet(oss);
		pfs.setPropSet(new PropertySpec[] {pSpec});
		
		ObjectContent[] objs = pc.retrieveProperties(
				new PropertyFilterSpec[] { pfs } );
		
		Hashtable[] pTables = new Hashtable[mos.length];
		
		for (int i=0; objs!=null && i<objs.length && objs[i]!= null; i++)
		{
			DynamicProperty[] props = objs[i].getPropSet();
			ManagedObjectReference mor = objs[i].getObj();
			
			int index = -1;
			if(mor.getType().equals(mos[i].getMOR().getType()) && 
			   mor.get_value().equals(mos[i].getMOR().get_value()))
			{
				index = i;
			}
			else
			{
				index = findIndex(mos, mor);
				if(index==-1)
					throw new RuntimeException("Unexpected managed object in result: " + mor.getType() +":" + mor.get_value());
			}
			pTables[index] = new Hashtable();
			for(int j=0; props!=null && j < props.length; j++)
			{
				pTables[index].put(props[j].getName(), convertProperty(props[j].getVal()));
			}
		}
		return pTables;
	}
	
	private static int findIndex (ManagedObject[] mos, ManagedObjectReference mor)
	{
		for(int i=0; i<mos.length; i++)
		{
			if(mor.getType().equals(mos[i].getMOR().getType()) && 
			   mor.get_value().equals(mos[i].getMOR().get_value()))
			return i;
		}
		return -1;
	}

	public static Object convertProperty(Object dynaPropVal) 
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
				Method getMethod = null; 
				try
				{
					getMethod = propClass.getMethod("get" + methodName, (Class[])null);
				} catch(NoSuchMethodException nsme)
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
	
	public static ObjectSpec creatObjectSpec(ManagedObjectReference mor, boolean skip, SelectionSpec[] selSet ) 
	{
		ObjectSpec oSpec = new ObjectSpec();
		oSpec.setObj(mor);
		oSpec.setSkip(skip);
		oSpec.setSelectSet(selSet);
		return oSpec;
	}
	
	public static PropertySpec createPropertySpec(String type, boolean allProp, String[] pathSet)
	{
		PropertySpec pSpec = new PropertySpec();
		pSpec.setType(type);
		pSpec.setAll(allProp); //whether or not all properties of the object are read. If this property is set to true, the pathSet property is ignored.
		pSpec.setPathSet(pathSet);
		return pSpec;
	}

	public static SelectionSpec[] createSelectionSpec(String[] names)
	{
		SelectionSpec[] sss = new SelectionSpec[names.length];
		for(int i=0; i<names.length; i++)
		{
			sss[i] = new SelectionSpec();
			sss[i].setName(names[i]);
		}
		return sss;
	}

	public static TraversalSpec createTraversalSpec(String name, String type, String path, String[] selectPath)
	{
		return	createTraversalSpec(name, type, path, createSelectionSpec(selectPath));
	}
	
	public static TraversalSpec createTraversalSpec(String name, String type, String path, SelectionSpec[] selectSet)
	{
		TraversalSpec ts = new TraversalSpec();
		ts.setName(name);
		ts.setType(type);
		ts.setPath(path);
		ts.setSkip(Boolean.FALSE);
		ts.setSelectSet(selectSet);
		return ts;
	}

	/**
	* This code takes an array of [typename, property, property, ...]
	* and converts it into a PropertySpec[].
	* @param typeProplists 2D array of type and properties to retrieve
	* @return Array of container filter specs
	*/
	public static PropertySpec[] buildPropertySpecArray( String[][] typeProplists )
	{
		PropertySpec[] pSpecs = new PropertySpec[typeProplists.length];
		
		for(int i = 0; i< typeProplists.length; i++) 
		{
			String type = typeProplists[i][0];
			String[] props = new String[typeProplists[i].length-1];
			for(int j=0; j<props.length; j++)
			{
				props[j]= typeProplists[i][j+1];
			}
			
			boolean all = (props.length==0)? true : false;
			pSpecs[i] = createPropertySpec(type, all, props);
	      }
	      return pSpecs;
	   }

	/**
	* This method creates a SelectionSpec[] to traverses the entire
	* inventory tree starting at a Folder
	* @return The SelectionSpec[]
	*/
	public static SelectionSpec [] buildFullTraversal() 
	{
		// Recurse through all ResourcePools
		TraversalSpec rpToRp = createTraversalSpec( "rpToRp",
	            "ResourcePool", "resourcePool",
	            new String[]{ "rpToRp", "rpToVm"});
		
		// Recurse through all ResourcePools	  
		TraversalSpec rpToVm = createTraversalSpec( "rpToVm", 
	            "ResourcePool", "vm", 
	            new SelectionSpec[] {});
	      
		// Traversal through ResourcePool branch
		TraversalSpec crToRp = createTraversalSpec( "crToRp",
	            "ComputeResource", "resourcePool",
	            new String[]{ "rpToRp", "rpToVm" });
	
		// Traversal through host branch
		TraversalSpec crToH = createTraversalSpec( "crToH", 
				"ComputeResource",  "host",
				new SelectionSpec[] {});
	
		// Traversal through hostFolder branch
		TraversalSpec dcToHf = createTraversalSpec( "dcToHf", 
				"Datacenter", "hostFolder", 
				new String[] {"visitFolders"});
	
		// Traversal through vmFolder branch
		TraversalSpec dcToVmf = createTraversalSpec( "dcToVmf",  
				"Datacenter", "vmFolder", 
				new String[] {"visitFolders"});
	
		// Recurse through all Hosts
		TraversalSpec HToVm = createTraversalSpec( "HToVm",
				"HostSystem", "vm", 
				new String[] {"visitFolders"});
	
		// Recurse through the folders
		TraversalSpec visitFolders = createTraversalSpec( "visitFolders", 
		  "Folder",  "childEntity", 
		  new String[] {"visitFolders", "dcToHf", "dcToVmf", "crToH", "crToRp", "HToVm", "rpToVm"});
	
		return new SelectionSpec [] {visitFolders,dcToVmf,dcToHf,crToH,crToRp,rpToRp,HToVm,rpToVm};
	}

}
