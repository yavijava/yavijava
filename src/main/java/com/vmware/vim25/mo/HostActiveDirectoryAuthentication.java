package com.vmware.vim25.mo;

import java.rmi.RemoteException;

import com.vmware.vim25.ActiveDirectoryFault;
import com.vmware.vim25.AuthMinimumAdminPermission;
import com.vmware.vim25.FileNotFound;
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
  
  /**
   * @since SDK5.0
   */
  public Task importCertificateForCAM_Task(String certPath, String camServer) throws FileNotFound, ActiveDirectoryFault, RuntimeFault, RemoteException
  {
    ManagedObjectReference mor = getVimService().importCertificateForCAM_Task(getMOR(), certPath, camServer);
    return new Task(getServerConnection(), mor);
  }
  
  public Task joinDomain_Task(String domainName, String userName, String password) throws InvalidState, HostConfigFault, InvalidLogin, ActiveDirectoryFault, TaskInProgress, RuntimeFault, RemoteException
  {
    ManagedObjectReference mor = getVimService().joinDomain_Task(getMOR(), domainName, userName, password);
    return new Task(getServerConnection(), mor);
  }

  /**
   * @since SDK5.0
   */
  public Task joinDomainWithCAM_Task(String domainName, String camServer) throws InvalidState, HostConfigFault, ActiveDirectoryFault, TaskInProgress, RuntimeFault, RemoteException
  {
    ManagedObjectReference mor = getVimService().joinDomainWithCAM_Task(getMOR(), domainName, camServer);
    return new Task(getServerConnection(), mor);
  }
  
  public Task leaveCurrentDomain_Task(boolean force) throws InvalidState, AuthMinimumAdminPermission, ActiveDirectoryFault, TaskInProgress, RuntimeFault, RemoteException
  {
    ManagedObjectReference mor = getVimService().leaveCurrentDomain_Task(getMOR(), force);
    return new Task(getServerConnection(), mor);
  }
  
}
