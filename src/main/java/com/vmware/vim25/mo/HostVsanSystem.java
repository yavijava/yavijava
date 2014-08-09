/*================================================================================
Copyright (c) 2013 Steve Jin. All Rights Reserved.

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

import com.vmware.vim25.HostScsiDisk;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.VsanHostClusterStatus;
import com.vmware.vim25.VsanHostConfigInfo;
import com.vmware.vim25.VsanHostDiskMapping;
import com.vmware.vim25.VsanHostDiskResult;

/**
 * The managed object class corresponding to the one defined in VI SDK API reference.
 * @author Steve JIN (http://www.doublecloud.org)
 * @since SDK5.5
 */

public class HostVsanSystem extends ManagedObject 
{
	public HostVsanSystem(ServerConnection serverConnection, ManagedObjectReference mor) 
	{
		super(serverConnection, mor);
	}
	
  public VsanHostConfigInfo getConfig()
  {
    return (VsanHostConfigInfo) getCurrentProperty("config");
  }
  
  public Task addDisks_Task(HostScsiDisk[] disk) throws RuntimeFault, RemoteException
  {
    ManagedObjectReference mor = getVimService().addDisks_Task(this.getMOR(), disk);
    return new Task(getServerConnection(), mor);
  }
  
  public Task initializeDisks_Task(VsanHostDiskMapping[] mapping) throws RuntimeFault, RemoteException
  {
    ManagedObjectReference mor = getVimService().initializeDisks_Task(this.getMOR(), mapping);
    return new Task(getServerConnection(), mor);
  }
  
  public VsanHostDiskResult[] queryDisksForVsan(String[] canonicalName) throws RuntimeFault, RemoteException
  {
    return getVimService().queryDisksForVsan(this.getMOR(), canonicalName);
  }
  
  public VsanHostClusterStatus queryHostStatus() throws RuntimeFault, RemoteException
  {
    return getVimService().queryHostStatus(this.getMOR());
  }
  
  public Task removeDisk_Task(HostScsiDisk[] disk) throws RuntimeFault, RemoteException
  {
    ManagedObjectReference mor = getVimService().removeDisk_Task(this.getMOR(), disk);
    return new Task(getServerConnection(), mor);
  }
  
  public Task removeDiskMapping_Task( VsanHostDiskMapping[] mapping) throws RuntimeFault, RemoteException
  {
    ManagedObjectReference mor = getVimService().removeDiskMapping_Task(this.getMOR(), mapping);
    return new Task(getServerConnection(), mor);
  }
  
  public Task updateVsan_Task(VsanHostConfigInfo config) throws RuntimeFault, RemoteException
  {
    ManagedObjectReference mor = getVimService().updateVsan_Task(this.getMOR(), config);
    return new Task(getServerConnection(), mor);
  }
}