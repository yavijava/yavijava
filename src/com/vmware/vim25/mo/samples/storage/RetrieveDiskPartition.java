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

import com.vmware.vim25.HostDiskPartitionInfo;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.ws.*;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class RetrieveDiskPartition
{
  public static void main(String[] args) throws Exception
  {
    if(args.length != 3)
    {
      System.out.println("Usage: java RetrieveDiskPartition " +
      		"<url> <username> <password>");
      return;
    }

    ServiceInstance si = new ServiceInstance(
            new URL(args[0]), args[1], args[2], true);
    
    Folder rootFolder = si.getRootFolder();
    HostSystem host = (HostSystem) new InventoryNavigator(
        rootFolder).searchManagedEntities("HostSystem")[0];

    HostStorageSystem hss = host.getHostStorageSystem();
    
    try{
      hss.upgradeVmfs("vmhba0:0:0:1");
    } catch(Exception e)
    {
      e.printStackTrace();
    }
    
    HostDiskPartitionInfo[] hdpi =hss.retrieveDiskPartitionInfo(
        new String[] {"/vmfs/devices/disks/vml.0100000000334b5335474c3136303030303937303952375834535433313436"});
    for(int i=0; hdpi!=null && i<hdpi.length; i++)
    {
      System.out.println("deviceName:" + hdpi[i].getDeviceName());
      System.out.println("spec.totalS:" + hdpi[i].getSpec().getTotalSectors());
    }
    si.getServerConnection().logout();
  }
}
