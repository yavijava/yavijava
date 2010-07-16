package com.vmware.vim25.mo;

import com.vmware.vim25.ManagedObjectReference;

public class HostLocalAuthentication extends HostAuthenticationStore
{
  public HostLocalAuthentication(ServerConnection sc, ManagedObjectReference mor) 
  {
    super(sc, mor);
  }
}