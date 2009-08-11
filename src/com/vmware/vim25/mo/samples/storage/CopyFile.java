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

package com.vmware.vim25.mo.samples.storage;

import java.net.URL;

import com.vmware.vim25.mo.Datacenter;
import com.vmware.vim25.mo.FileManager;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class CopyFile
{
  public static void main(String[] args) throws Exception
  {
    if(args.length != 3)
    {
      System.out.println("Usage: java CopyFile " 
        + "<url> <username> <password>");
      return;
    }

    ServiceInstance si = new ServiceInstance(
      new URL(args[0]), args[1], args[2], true);

    Datacenter dc = (Datacenter)new InventoryNavigator(
        si.getRootFolder()).searchManagedEntity(
            "Datacenter", "ha-datacenter");
    FileManager fileMgr = si.getFileManager();
    if(fileMgr==null)
    {
      System.out.println("FileManager not available.");
      si.getServerConnection().logout();
      return;
    }
    
    String basePath = "[storage1 (2)] Nostalgia011";
    String dirPath = basePath + "/" + "testDir";
    // create parent directories if needed - true
    fileMgr.makeDirectory(dirPath, dc, true);
    
    String srcPath = basePath + "/Nostalgia011.vmdk";
    String dstPath = dirPath + "/copy of Nostalgia011.vmdk";
    Task cTask = fileMgr.copyDatastoreFile_Task(srcPath, dc, 
        dstPath, dc, true);

    if(cTask.waitForMe()==Task.SUCCESS)
    {
      System.out.println("File copied successfully!");
    }
    else
    {
      System.out.println("File copy failed!");
      return;
    }
    Thread.sleep(30*1000);
    
    fileMgr.deleteDatastoreFile_Task(dstPath, dc);
    fileMgr.deleteDatastoreFile_Task(dirPath, dc);
    si.getServerConnection().logout();
  }
}