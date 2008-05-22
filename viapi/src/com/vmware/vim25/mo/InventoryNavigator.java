package com.vmware.vim25.mo;

import java.rmi.RemoteException;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.*;
import com.vmware.vim25.mo.util.PropertyCollectorUtil;

public class InventoryNavigator
{
	private ManagedEntity rootEntity = null;
	
	public InventoryNavigator(ManagedEntity rootEntity)
	{
		this.rootEntity = rootEntity;
	}

	/**
	 * Retrieve container contents from specified parent recursively if requested.
	 * @param recurse retrieve contents recursively from the root down
	 * @throws RemoteException 
	 * @throws RuntimeFault 
	 * @throws InvalidProperty 
	 */
	public ManagedEntity[] searchManagedEntities(boolean recurse) throws InvalidProperty, RuntimeFault, RemoteException  
	{
		String[][] typeinfo = new String[][] { new String[] { "ManagedEntity", }};
		return searchManagedEntities(typeinfo, recurse);
	}

	/**
    * Get the first ManagedObjectReference from current node for the specified type
    */
	public ManagedEntity[] searchManagedEntities(String type) throws InvalidProperty, RuntimeFault, RemoteException  
	{
		String[][] typeinfo = new String[][] { new String[] { type,  "name",}, };
		return searchManagedEntities(typeinfo, true);
	}

	/**
	* Retrieve content recursively with multiple properties.
	* the typeinfo array contains typename + properties to retrieve.
	*
	* @param typeinfo 2D array of properties for each typename
	* @param recurse retrieve contents recursively from the root down
	*
	* @return retrieved object contents
	 * @throws RemoteException 
	 * @throws RuntimeFault 
	 * @throws InvalidProperty 
	*/
	public ManagedEntity[] searchManagedEntities(String[][] typeinfo, boolean recurse ) throws InvalidProperty, RuntimeFault, RemoteException  
	{
		ObjectContent[] ocs = retrieveObjectContents(typeinfo, recurse);
		return createManagedEntities(ocs);
	}
	
	private ObjectContent[] retrieveObjectContents(String[][] typeinfo, boolean recurse ) throws InvalidProperty, RuntimeFault, RemoteException
	{
		if (typeinfo == null || typeinfo.length == 0) 
		{
			return null;
		}
	
		PropertyCollector pc = rootEntity.getServerConnection().getServiceInstance().getPropertyCollector();
	
		SelectionSpec[] selectionSpecs = null;
		if (recurse) 
		{
			selectionSpecs = PropertyCollectorUtil.buildFullTraversal();
		}
	
		PropertySpec[] propspecary = PropertyCollectorUtil.buildPropertySpecArray(typeinfo);
	
		PropertyFilterSpec spec = new PropertyFilterSpec(null,null,
	        propspecary, new ObjectSpec[] { 
	           new ObjectSpec(null,null, rootEntity.getMOR(), Boolean.FALSE, selectionSpecs) 
	        }
	     );
	
		return pc.retrieveProperties(new PropertyFilterSpec[] { spec } );
	}
			
	private ManagedEntity[] createManagedEntities(ObjectContent[] ocs) 
	{
		if(ocs==null)
		{
			return new ManagedEntity[] {};
		}
		ManagedEntity[] mes = new ManagedEntity[ocs.length];
		
		for(int i=0; i<mes.length; i++)
		{
			ManagedObjectReference mor = ocs[i].getObj();
			mes[i] = MorUtil.createExactManagedEntity(rootEntity.getServerConnection(), mor);
		}
		return mes;
	}
	
   /**
    * Get the ManagedObjectReference for an item under the
    * specified parent node that has the type and name specified.
    *
    * @param type type of the managed object
    * @param name name to match
    * @return First ManagedEntity object of the type / name pair found
    * @throws RemoteException 
    * @throws RuntimeFault 
    * @throws InvalidProperty 
    */
	public ManagedEntity searchManagedEntity(String type, String name) throws InvalidProperty, RuntimeFault, RemoteException  
	{
		if (name == null || name.length() == 0)
		{
			return null;
		}
		
		if(type==null) 
		{
			type = "ManagedEntity";
		}
		
		String[][] typeinfo = new String[][] { new String[] { type,  "name",}, };

		ObjectContent[] ocs = retrieveObjectContents(typeinfo, true);

		if (ocs.length == 0) 
		{
			return null;
		}

		for (int i = 0; i < ocs.length; i++) 
		{
			DynamicProperty[] propSet = ocs[i].getPropSet();
			
			if (propSet.length > 0) 
			{
				String nameInPropSet = (String) propSet[0].getVal();
				if(name.equalsIgnoreCase(nameInPropSet))
				{
					ManagedObjectReference mor = ocs[i].getObj();
					return MorUtil.createExactManagedEntity(rootEntity.getServerConnection(), mor);
				}
			}
		}
		return null;
	}

}
