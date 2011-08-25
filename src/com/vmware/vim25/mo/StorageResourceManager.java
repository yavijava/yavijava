package com.vmware.vim25.mo;

import java.rmi.RemoteException;

import com.vmware.vim25.IORMNotSupportedHostOnDatastore;
import com.vmware.vim25.InaccessibleDatastore;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.StorageDrsConfigSpec;
import com.vmware.vim25.StorageIORMConfigOption;
import com.vmware.vim25.StorageIORMConfigSpec;
import com.vmware.vim25.StoragePlacementResult;
import com.vmware.vim25.StoragePlacementSpec;

public class StorageResourceManager extends ManagedObject
{
  
  /**
   * @since SDK5.0
   */
  public Task applyStorageDrsRecommendation_Task( String[] keys) throws RuntimeFault, RemoteException
  {
    ManagedObjectReference taskMor = getVimService().applyStorageDrsRecommendation_Task(getMOR(), keys);
    return new Task(getServerConnection(), taskMor);
  }
  
  /**
   * @since SDK5.0
   */
  public Task applyStorageDrsRecommendationToPod_Task(StoragePod pod, String key) throws RuntimeFault, RemoteException
  {
    ManagedObjectReference taskMor = getVimService().applyStorageDrsRecommendationToPod_Task(getMOR(), pod.getMOR(), key);
    return new Task(getServerConnection(), taskMor);    
  }

  /**
   * @since SDK5.0
   */
  public void cancelStorageDrsRecommendation(String[] keys) throws RuntimeFault, RemoteException
  {
    getVimService().cancelStorageDrsRecommendation(getMOR(), keys);
  }
  
  public Task configureDatastoreIORM_Task(Datastore datastore, StorageIORMConfigSpec spec) throws InaccessibleDatastore, IORMNotSupportedHostOnDatastore, RuntimeFault, RemoteException
  {
    ManagedObjectReference mor = getVimService().configureDatastoreIORM_Task(getMOR(), datastore.getMOR(), spec);
    return new Task(getServerConnection(), mor);
  }
  
  /**
   * @since SDK5.0
   */
  public Task configureStorageDrsForPod_Task(StoragePod pod, StorageDrsConfigSpec spec, boolean modify) throws RuntimeFault, RemoteException
  {
    ManagedObjectReference taskMor = getVimService().configureStorageDrsForPod_Task(getMOR(), pod.getMOR(), spec, modify);
    return new Task(getServerConnection(), taskMor);
  }
  
  public StorageIORMConfigOption queryIORMConfigOption(HostSystem host) throws RuntimeFault, RemoteException
  {
    return getVimService().queryIORMConfigOption(getMOR(), host.getMOR());
  }
  
  /**
   * @since SDK5.0
   */
  public StoragePlacementResult recommendDatastores(StoragePlacementSpec storageSpec) throws RuntimeFault, RemoteException
  {
    return getVimService().recommendDatastores(getMOR(), storageSpec);
  }

  /**
   * @since SDK5.0
   */
  public void refreshStorageDrsRecommendation(StoragePod pod) throws RuntimeFault, RemoteException
  {
    getVimService().refreshStorageDrsRecommendation(getMOR(), pod.getMOR());
  }
}