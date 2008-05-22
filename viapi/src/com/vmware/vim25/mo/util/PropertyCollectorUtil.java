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

import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.SelectionSpec;
import com.vmware.vim25.TraversalSpec;

/**
 * Utility class for the PropertyCollector API.
 * @author Steve JIN (sjin@vmware.com)
 */
public class PropertyCollectorUtil 
{

	public static PropertySpec createPropertySpec(String type, boolean allProp, String[] pathSet)
	{
		  return new PropertySpec(null, null,
		           type, //Name of the managed object type being collected.
		           new Boolean(allProp), //whether or not all properties of the object are read. If this property is set to true, the pathSet property is ignored. 
		           pathSet);
	}

	public static SelectionSpec[] createSelectionSpec(String[] names)
	{
		SelectionSpec[] sss = new SelectionSpec[names.length];
		for(int i=0; i<names.length; i++)
		{
			sss[i] = new SelectionSpec(null, null, names[i]);
		}
		return sss;
	}

	public static TraversalSpec createTraversalSpec(String name, String type, String path, String[] selectPath)
	{
		return	createTraversalSpec(name, type, path, createSelectionSpec(selectPath));
	}
	
	public static TraversalSpec createTraversalSpec(String name, String type, String path, SelectionSpec[] selectSet)
	{
		return	new TraversalSpec(null, null, 
			name, // Name of the selection specification. 
			type, // Name of the object type containing the property. 
			path, // Name of the property to use in order to select additional objects. 
			Boolean.FALSE, // Flag to indicate whether or not to filter the object in the "path" field. 
			selectSet );
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
