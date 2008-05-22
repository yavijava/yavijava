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

package com.vmware.vim25.mo.samples;

import java.net.URL;
import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;

/**
*<Pre>This sample displays the CanonicalName,Vendor,Model,Data,Namespace and NamespaceId of the host
*SCSI LUN name. 
*
*<b>Parameters:</b>
*hostname        [required]:  Name of the host
*</pre>
* @author sjin
*/

public class SCSILunName 
{

   public static void main(String args[]) throws Exception
   {
		CommandLineParser clp = new CommandLineParser(constructOptions(), args);
		String urlStr = clp.get_option("url");
		String username = clp.get_option("username");
		String password = clp.get_option("password");
        String hostname = clp.get_option("hostname");

		ServiceInstance si = new ServiceInstance(new URL(urlStr), username, password, true);
		HostSystem host = (HostSystem) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("HostSystem", hostname);

		if(host!=null)
		{
			ScsiLun[] scsiLuns = (ScsiLun[])host.getConfig().getStorageDevice().getScsiLun();
			
			try
			{
              if (scsiLuns != null && scsiLuns.length > 0) 
              {
                 for (int i=0; i < scsiLuns.length; i++ )
                 {
                    System.out.println("\nSCSI LUN " + (i+1));
                    System.out.println("--------------");
                    printScsiLunInfo(scsiLuns[i]);
                    
                    Datastore[] datastores = host.getDatastores();
                    System.out.println("\nVMFS Affected ");
                    printVMFS(datastores, scsiLuns[i].getCanonicalName());
                    System.out.println("Virtual Machines ");
                    printVMs(datastores, scsiLuns[i].getCanonicalName());
                 }
              }
           }
           catch(Exception e) 
           {
              System.out.println("error" + e);
              e.printStackTrace();
           }
        }
        else 
        {
           System.out.println("Host "+ hostname + " not found");
        }

		si.getServerConnection().logout();
   }
   
   private static OptionSpec[] constructOptions() 
   {
      return new OptionSpec[] {
    	  new OptionSpec("hostname","String",1 ,"Name of the host",null)
      };
   }
   
    static void printScsiLunInfo(ScsiLun scsiLun)
	{
       String canName = scsiLun.getCanonicalName();
       String vendor = scsiLun.getVendor();
       String model = scsiLun.getModel();
       ScsiLunDurableName scsiLunDurableName = scsiLun.getDurableName();

       byte data[] = scsiLunDurableName.getData();
       System.out.print("\nData            : ");
       for (int j = 0; j < data.length ; j++ )
       {
          System.out.print(data[j] + " ");
       }

       String namespace = scsiLunDurableName.getNamespace();
       byte namespaceId = scsiLunDurableName.getNamespaceId();
       System.out.println("\nCanonical Name  : " + canName);
       System.out.println("\nvendor  : " + vendor);
       System.out.println("\nmodel  : " + model);
       System.out.println("Namespace       : " + namespace);
       System.out.println("Namespace ID    : " + namespaceId);
   }
    
	/**This subroutine prints the virtual machine file system volumes affected by the given SCSI LUN.*/

	static void printVMFS(Datastore[] datastores,String canName) throws Exception
	{
      boolean vmfsFlag = false;
      for (int i=0;i<datastores.length ; i++ ) 
      {
    	  DatastoreInfo dsInfo = datastores[i].getInfo();
    	  if(dsInfo instanceof VmfsDatastoreInfo)
    	  {
    		  VmfsDatastoreInfo vds = (VmfsDatastoreInfo) dsInfo;
    		  HostVmfsVolume hvms = vds.getVmfs();
    		  String vmfsName  = vds.getName();
    		  HostScsiDiskPartition hdp[] = hvms.getExtent();
    		  for (int j =0;j< hdp.length ; j++ )  
    		  {
    			  if(hdp[j].getDiskName().equals(canName))
    			  {
    				  vmfsFlag = true;
    				  System.out.println(" " + vmfsName + "\n");
    			  }
    		  }
    	  }
      }
      if (!vmfsFlag) 
      {
            System.out.println(" None\n");
      }
   }

   /** This subroutine prints the virtual machines affected by the given SCSI LUN. */

   static void printVMs(Datastore[] datastores,String canName) throws Exception 
   {
	   boolean vmFlag = false;
	   for (int i=0;i<datastores.length ; i++ ) 
	   {
		   DatastoreInfo dsInfo = datastores[i].getInfo();
		   if(dsInfo instanceof VmfsDatastoreInfo)
		   {
			   VmfsDatastoreInfo vds = (VmfsDatastoreInfo) dsInfo;
			   HostVmfsVolume hvms = vds.getVmfs();
			   HostScsiDiskPartition hdp[] = hvms.getExtent();
			   for (int j =0;j< hdp.length ; j++ ) 
			   {
				   if(hdp[j].getDiskName().equals(canName))
				   {
					   VirtualMachine[] vms = datastores[i].getVms();
					   for (int k=0; k<vms.length ; k++ ) 
					   {
                           vmFlag = true;
                           System.out.println(" "+vms[k].getName());
                        }
                    }
			   }
		   }
	   }
	   if (!vmFlag) 
	   {
            System.out.println(" None\n");
	   }
   }
   
}
