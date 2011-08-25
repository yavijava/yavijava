/*================================================================================
Copyright (c) 2011 VMware, Inc. All Rights Reserved.

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

import java.rmi.RemoteException;

import com.vmware.vim25.FileFault;
import com.vmware.vim25.GuestAuthentication;
import com.vmware.vim25.GuestOperationsFault;
import com.vmware.vim25.GuestProcessInfo;
import com.vmware.vim25.GuestProgramSpec;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.TaskInProgress;


/**
 * provides APIs to manipulate the guest operating system processes
 * @author Steve Jin (http://www.doublecloud.org)
 * @since SDK5.0
 */

public class GuestProcessManager extends ManagedObject
{
  private VirtualMachine vm = null;
  
  public GuestProcessManager(ServerConnection sc, ManagedObjectReference mor, VirtualMachine vm) 
  {
    super(sc, mor);
    this.vm = vm;
  }

  public VirtualMachine getVM()
  {
    return vm;
  }
  
  public GuestProcessInfo[] listProcessesInGuest(GuestAuthentication auth, long[] pids) throws GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException
  {
    return getVimService().listProcessesInGuest(getMOR(), vm.getMOR(), auth, pids);
  }
  
  public String[] readEnvironmentVariableInGuest(GuestAuthentication auth, String[] names) throws GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException
  {
    return getVimService().readEnvironmentVariableInGuest(getMOR(), vm.getMOR(), auth, names);
  }
  
  public long startProgramInGuest(GuestAuthentication auth, GuestProgramSpec spec) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException
  {
    return getVimService().startProgramInGuest(getMOR(), vm.getMOR(), auth, spec);
  }
  
  public void terminateProcessInGuest(GuestAuthentication auth, long pid) throws GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException
  {
    getVimService().terminateProcessInGuest(getMOR(), vm.getMOR(), auth, pid);
  }
}