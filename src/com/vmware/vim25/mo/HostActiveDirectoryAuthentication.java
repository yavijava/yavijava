package com.vmware.vim25.mo;

import java.rmi.RemoteException;

import com.vmware.vim25.ActiveDirectoryFault;
import com.vmware.vim25.AuthMinimumAdminPermission;
import com.vmware.vim25.HostConfigFault;
import com.vmware.vim25.InvalidLogin;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.TaskInProgress;

/** @since SDK4.1 */
public class HostActiveDirectoryAuthentication extends HostDirectoryStore
{
  public HostActiveDirectoryAuthentication(ServerConnection sc, ManagedObjectReference mor) 
  {
    super(sc, mor);
  }
  
  public Task joinDomain_Task(String domainName, String userName, String password) throws InvalidState, HostConfigFault, InvalidLogin, ActiveDirectoryFault, TaskInProgress, RuntimeFault, RemoteException
  {
    ManagedObjectReference mor = getVimService().joinDomain_Task(getMOR(), domainName, userName, password);
    return new Task(getServerConnection(), mor);
  }
  
  public Task leaveCurrentDomain_Task(boolean force) throws InvalidState, AuthMinimumAdminPermission, ActiveDirectoryFault, TaskInProgress, RuntimeFault, RemoteException
  {
    ManagedObjectReference mor = getVimService().leaveCurrentDomain_Task(getMOR(), force);
    return new Task(getServerConnection(), mor);
  }
  
}
