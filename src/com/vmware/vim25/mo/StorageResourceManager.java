package com.vmware.vim25.mo;

import java.rmi.RemoteException;

import com.vmware.vim25.IORMNotSupportedHostOnDatastore;
import com.vmware.vim25.InaccessibleDatastore;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.StorageIORMConfigOption;
import com.vmware.vim25.StorageIORMConfigSpec;

public class StorageResourceManager extends ManagedObject
{
  public Task configureDatastoreIORM_Task(Datastore datastore, StorageIORMConfigSpec spec) throws InaccessibleDatastore, IORMNotSupportedHostOnDatastore, RuntimeFault, RemoteException
  {
    ManagedObjectReference mor = getVimService().configureDatastoreIORM_Task(getMOR(), datastore.getMOR(), spec);
    return new Task(getServerConnection(), mor);
  }
  
  public StorageIORMConfigOption queryIORMConfigOption(HostSystem host) throws RuntimeFault, RemoteException
  {
    return getVimService().queryIORMConfigOption(getMOR(), host.getMOR());
  }
}