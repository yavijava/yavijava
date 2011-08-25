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
import com.vmware.vim25.FileTransferInformation;
import com.vmware.vim25.GuestAuthentication;
import com.vmware.vim25.GuestFileAttributes;
import com.vmware.vim25.GuestListFileInfo;
import com.vmware.vim25.GuestOperationsFault;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.TaskInProgress;


/**
 * provides APIs to manipulate the guest operating system files.
 * @author Steve Jin (http://www.doublecloud.org)
 * @since SDK5.0
 */

public class GuestFileManager extends ManagedObject
{
  private VirtualMachine vm = null;
  
  public GuestFileManager(ServerConnection sc, ManagedObjectReference mor, VirtualMachine vm) 
  {
    super(sc, mor);
    this.vm = vm;
  }

  public VirtualMachine getVM()
  {
    return vm;
  }
  
  public void changeFileAttributesInGuest(GuestAuthentication auth, String guestFilePath, GuestFileAttributes fileAttributes) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException
  {
    getVimService().changeFileAttributesInGuest(getMOR(), vm.getMOR(), auth, guestFilePath, fileAttributes);
  }
  
  public String createTemporaryDirectoryInGuest(GuestAuthentication auth, String prefix, String suffix, String directoryPath) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException
  {
    return getVimService().createTemporaryDirectoryInGuest(getMOR(), vm.getMOR(), auth, prefix, suffix, directoryPath);
  }
  
  public String createTemporaryFileInGuest(GuestAuthentication auth, String prefix, String suffix, String directoryPath) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException
  {
    return getVimService().createTemporaryFileInGuest(getMOR(), vm.getMOR(), auth, prefix, suffix, directoryPath);
  }
  
  public void deleteDirectoryInGuest(GuestAuthentication auth, String directoryPath, boolean recursive) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException
  {
    getVimService().deleteDirectoryInGuest(getMOR(), vm.getMOR(), auth, directoryPath, recursive);
  }
  
  public void deleteFileInGuest(GuestAuthentication auth, String filePath) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException
  {
    getVimService().deleteFileInGuest(getMOR(), vm.getMOR(), auth, filePath);
  }
  
  public FileTransferInformation initiateFileTransferFromGuest(GuestAuthentication auth, String guestFilePath) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException
  {
    return getVimService().initiateFileTransferFromGuest(getMOR(), vm.getMOR(), auth, guestFilePath);  
  }
  
  public String initiateFileTransferToGuest(GuestAuthentication auth, String guestFilePath, GuestFileAttributes fileAttributes, long fileSize, boolean overwrite) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException
  {
    return getVimService().initiateFileTransferToGuest(getMOR(), vm.getMOR(), auth, guestFilePath, fileAttributes, fileSize, overwrite);
  }
  
  public GuestListFileInfo listFilesInGuest(GuestAuthentication auth, String filePath, int index, int maxResults, String matchPattern) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException
  {
    return getVimService().listFilesInGuest(getMOR(), vm.getMOR(), auth, filePath, index, maxResults, matchPattern);
  }
  
  public void makeDirectoryInGuest(GuestAuthentication auth, String directoryPath, boolean createParentDirectories) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException
  {
    getVimService().makeDirectoryInGuest(getMOR(), vm.getMOR(), auth, directoryPath, createParentDirectories);
  }
  
  public void moveDirectoryInGuest(GuestAuthentication auth, String srcDirectoryPath, String dstDirectoryPath) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException
  { 
    getVimService().moveDirectoryInGuest(getMOR(), vm.getMOR(), auth, srcDirectoryPath, dstDirectoryPath);
  }
  
  public void moveFileInGuest(GuestAuthentication auth, String srcFilePath, String dstFilePath, boolean overwrite) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException
  {
    getVimService().moveFileInGuest(getMOR(), vm.getMOR(), auth, srcFilePath, dstFilePath, overwrite);
  }
}