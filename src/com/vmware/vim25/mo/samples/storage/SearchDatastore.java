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

import com.vmware.vim25.ArrayOfHostDatastoreBrowserSearchResults;
import com.vmware.vim25.DatastoreInfo;
import com.vmware.vim25.FileInfo;
import com.vmware.vim25.FileQuery;
import com.vmware.vim25.FileQueryFlags;
import com.vmware.vim25.HostDatastoreBrowserSearchResults;
import com.vmware.vim25.HostDatastoreBrowserSearchSpec;
import com.vmware.vim25.VmDiskFileInfo;
import com.vmware.vim25.VmDiskFileQuery;
import com.vmware.vim25.mo.Datastore;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostDatastoreBrowser;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class SearchDatastore
{
  public static void main(String[] args) throws Exception 
  {
    if(args.length != 3)
    {
      System.out.println("Usage: java SearchDatastore <url> " 
        + "<username> <password>");
      return;
    }
    
    ServiceInstance si = new ServiceInstance(
        new URL(args[0]), args[1], args[2], true);
    
    String hostname = "10.20.143.205";
    String datastorePath = "[storage1 (2)]";

    Folder rootFolder = si.getRootFolder();
    HostSystem host = null;

    host = (HostSystem) new InventoryNavigator(
        rootFolder).searchManagedEntity("HostSystem", hostname);

    if(host==null)
    {
      System.out.println("Host not found");
      si.getServerConnection().logout();
      return;
    }
    
    HostDatastoreBrowser hdb = host.getDatastoreBrowser();
  
    System.out.println("print out the names of the datastores");
    Datastore[] ds = hdb.getDatastores();
    for(int i=0; ds!=null && i<ds.length; i++)
    {
      System.out.println("datastore["+i+"]:");
      DatastoreInfo di = ds[i].getInfo();
      System.out.println("Name:" + di.getName());
      System.out.println("FreeSpace:" + di.getFreeSpace());
      System.out.println("MaxFileSize:" + di.getMaxFileSize());
    }
    
    System.out.println("print out supported query types");
    FileQuery[] fqs = hdb.getSupportedType();
    for(int i=0; fqs!=null && i<fqs.length; i++)
    {
      System.out.println("FileQuery["+i+"]=" 
          + fqs[i].getClass().getName());
    }
    
    HostDatastoreBrowserSearchSpec hdbss = 
      new HostDatastoreBrowserSearchSpec();
    hdbss.setQuery(new FileQuery[] { new VmDiskFileQuery()});
    FileQueryFlags fqf = new FileQueryFlags();
    fqf.setFileSize(true);
    fqf.setModification(true);
    hdbss.setDetails(fqf);
    hdbss.setSearchCaseInsensitive(false);
    hdbss.setMatchPattern(new String[] {"sdk*.*"});
    
    Task task = hdb.searchDatastoreSubFolders_Task(
        datastorePath, hdbss);
    if(task.waitForMe()==Task.SUCCESS)
    {
      Object obj = task.getTaskInfo().getResult();
      if(obj instanceof ArrayOfHostDatastoreBrowserSearchResults)
      {
        HostDatastoreBrowserSearchResults[] results = 
          ((ArrayOfHostDatastoreBrowserSearchResults)
              obj).getHostDatastoreBrowserSearchResults();
        
        for(int i=0; i<results.length; i++)
        {
          HostDatastoreBrowserSearchResults result = results[i];
          System.out.println("\nFolder:" 
              + result.getFolderPath());
          FileInfo[] fis = result.getFile();
          for(int j=0; fis!=null && j<fis.length; j++)
          {
            System.out.println("Path:" + fis[j].getPath());
            System.out.println("FileSize:" 
                + fis[j].getFileSize());
            System.out.println("Modified:" 
                + fis[j].getModification().getTime());
            if(fis[j] instanceof VmDiskFileInfo)
            {
              printExtraDiskFileInfo((VmDiskFileInfo)fis[j]);
            }
          }
        }
      }
      si.getServerConnection().logout();
    }
  }
    
  static void printExtraDiskFileInfo(VmDiskFileInfo info)
  {
    System.out.println("CapacityKB:" + info.getCapacityKb());
    System.out.println("ControllerType:" 
        + info.getControllerType());
    System.out.println("DiskType:" + info.getDiskType());
    System.out.println("DiskExtents:");
    String[] exts = info.getDiskExtents();
    for(int i =0; i<exts.length; i++)
    {
      System.out.print(exts[i] + " ");
    }
  }
}