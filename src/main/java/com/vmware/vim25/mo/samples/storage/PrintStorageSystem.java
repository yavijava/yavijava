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

import com.vmware.vim25.HostFileSystemMountInfo;
import com.vmware.vim25.HostFileSystemVolume;
import com.vmware.vim25.HostFileSystemVolumeInfo;
import com.vmware.vim25.HostHostBusAdapter;
import com.vmware.vim25.HostMountInfo;
import com.vmware.vim25.HostMultipathInfo;
import com.vmware.vim25.HostMultipathInfoLogicalUnit;
import com.vmware.vim25.HostMultipathInfoLogicalUnitPolicy;
import com.vmware.vim25.HostMultipathInfoPath;
import com.vmware.vim25.HostScsiTopology;
import com.vmware.vim25.HostScsiTopologyInterface;
import com.vmware.vim25.HostScsiTopologyLun;
import com.vmware.vim25.HostScsiTopologyTarget;
import com.vmware.vim25.HostStorageDeviceInfo;
import com.vmware.vim25.ScsiLun;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostStorageSystem;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class PrintStorageSystem
{
  public static void main(String[] args) throws Exception
  {
    if(args.length != 3)
    {
      System.out.println("Usage: java PrintStorageSystem " 
        + "<url> <username> <password>");
      return;
    }

    ServiceInstance si = new ServiceInstance(
      new URL(args[0]), args[1], args[2], true);
    
    String hostname = "sjin-dev1.eng.vmware.com";

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
    
    HostStorageSystem hds = host.getHostStorageSystem();
    
    System.out.println("Supported file system volume types:");   
    HostFileSystemVolumeInfo vi = hds.getFileSystemVolumeInfo();
    printFileVolumeInfo(vi);

    System.out.println("\nStorage device information:");   
    HostStorageDeviceInfo hsdi = hds.getStorageDeviceInfo();
    printStorageDeviceInfo(hsdi);
    
    si.getServerConnection().logout();
  }

  static void printStorageDeviceInfo(HostStorageDeviceInfo hsdi)
  {
    System.out.println("\nHost bus adapters");
    printHBAs(hsdi.getHostBusAdapter());
    
    System.out.println("\nMultipath information");
    HostMultipathInfo hmi = hsdi.getMultipathInfo();
    printMultiPathInfo(hmi);
    
    System.out.println("\nSCSI LUNs");
    printScsiLuns(hsdi.getScsiLun());
    
    HostScsiTopology hst = hsdi.getScsiTopology();
    printScsiTopology(hst);
    
    System.out.println("\nSoftware iSCSI enabled:" 
        + hsdi.isSoftwareInternetScsiEnabled());
  }

  static void printHBAs(HostHostBusAdapter[] hbas)
  {
    for(int i=0; hbas!=null && i<hbas.length; i++)
    {
      System.out.println("Device:" + hbas[i].getDevice());
      System.out.println("Bus:" + hbas[i].getBus());
      System.out.println("Driver:" + hbas[i].getDriver());
      System.out.println("Key:" + hbas[i].getKey());
      System.out.println("Model:" + hbas[i].getModel());
      System.out.println("PCI:" + hbas[i].getPci());
      System.out.println("Status:" + hbas[i].getStatus());
    }
  }
  
  static void printScsiTopology(HostScsiTopology hst)
  {
    HostScsiTopologyInterface[] hstis = hst.getAdapter();
    
    for(int i=0; hstis!=null && i<hstis.length; i++)
    {
      System.out.println("Adapter:" + hstis[i].getAdapter());
      System.out.println("Key:" + hstis[i].getKey());
      HostScsiTopologyTarget[] hstts = hstis[i].getTarget();
      
      for(int j=0; hstts!=null && j<hstts.length; j++)
      {
        System.out.println("Key:" + hstts[j].getKey());
        System.out.println("Target:" + hstts[j].getTarget());
        System.out.println("Transport:" 
            + hstts[j].getTransport().getClass().getName());
        HostScsiTopologyLun[] luns = hstts[j].getLun();
        for(int k=0; luns!=null && k<luns.length; k++)
        {
          System.out.println("Key:" + luns[k].getKey());
          System.out.println("LUN:" + luns[k].getLun());
          System.out.println("ScsiLun:" + luns[k].getScsiLun());
        }
      }
    }
  }
  
  static void printScsiLuns(ScsiLun[] sls)
  {
    for(int i=0; sls!=null && i<sls.length; i++)
    {
      System.out.println("UUID:" + sls[i].getUuid());
      System.out.println("CanonicalName:" 
          + sls[i].getCanonicalName());
      System.out.println("LunType:" + sls[i].getLunType());
      System.out.print("OperationalState:");
      String[] states = sls[i].getOperationalState();
      for(int j=0; states!=null && j<states.length; j++)
      {
        System.out.print(states[j] + " ");
      }
      System.out.println("\nSCSI Level:" 
          + sls[i].getScsiLevel());
      System.out.println("Vendor:" + sls[i].getVendor());
    }
  }
  
  static void printMultiPathInfo(HostMultipathInfo hmi)
  {
    HostMultipathInfoLogicalUnit[] lus = hmi.getLun();
    for(int i=0; lus!=null && i<lus.length; i++)
    {
      System.out.println("ID:" + lus[i].getId());
      System.out.println("Key:" + lus[i].getKey());
      System.out.println("LUN:" + lus[i].getLun());

      HostMultipathInfoPath[] hmips = lus[i].getPath();
      for(int j=0; hmips!=null && j<hmips.length; j++)
      {
        System.out.println("Adpator:" + hmips[j].getAdapter());
        System.out.println("Key:" + hmips[j].getLun());
        System.out.println("Name:" + hmips[j].getName());
        System.out.println("PathState:" 
            + hmips[j].getPathState());
        System.out.println("Transport:" 
            + hmips[j].getTransport().getClass().getName());
      }
      HostMultipathInfoLogicalUnitPolicy policy = 
          lus[i].getPolicy();
      System.out.println("Policy:" + policy.getPolicy());
    }
  }
  
  static void printFileVolumeInfo(HostFileSystemVolumeInfo info)
  {
    String[] volTypes = info.getVolumeTypeList();
    for(int i=0; volTypes!=null && i<volTypes.length; i++)
    {
      System.out.println(volTypes[i]);
    }
    
    System.out.println("\nThe file system volumes mounted:");
    HostFileSystemMountInfo[] mis = info.getMountInfo();
    for(int i=0; mis!=null && i<mis.length; i++)
    {
      HostMountInfo hmi = mis[i].getMountInfo();
      System.out.println("\nAccessible:" + hmi.getAccessible());
      System.out.println("AccessMode:" + hmi.getAccessMode());
      System.out.println("Path:" + hmi.getPath());
      
      HostFileSystemVolume hfsv = mis[i].getVolume();
      System.out.println("Capacity:" + hfsv.getCapacity());
      System.out.println("Name:" + hfsv.getName());
      System.out.println("Type:" + hfsv.getType());
    }
  }
}
