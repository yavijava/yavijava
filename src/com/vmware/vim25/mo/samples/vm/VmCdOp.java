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

package com.vmware.vim25.mo.samples.vm;

import java.net.URL;

import com.vmware.vim25.ConfigTarget;
import com.vmware.vim25.DatastoreSummary;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.NetworkSummary;
import com.vmware.vim25.VirtualCdrom;
import com.vmware.vim25.VirtualCdromIsoBackingInfo;
import com.vmware.vim25.VirtualDevice;
import com.vmware.vim25.VirtualDeviceConfigSpec;
import com.vmware.vim25.VirtualDeviceConfigSpecFileOperation;
import com.vmware.vim25.VirtualDeviceConfigSpecOperation;
import com.vmware.vim25.VirtualDisk;
import com.vmware.vim25.VirtualDiskFlatVer2BackingInfo;
import com.vmware.vim25.VirtualIDEController;
import com.vmware.vim25.VirtualMachineConfigInfo;
import com.vmware.vim25.VirtualMachineConfigOption;
import com.vmware.vim25.VirtualMachineConfigSpec;
import com.vmware.vim25.VirtualMachineDatastoreInfo;
import com.vmware.vim25.VirtualMachineNetworkInfo;
import com.vmware.vim25.VirtualMachineRuntimeInfo;
import com.vmware.vim25.mo.Datastore;
import com.vmware.vim25.mo.EnvironmentBrowser;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;
import com.vmware.vim25.mo.VirtualMachine;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class VmCdOp 
{    
  public static void main(String[] args) throws Exception 
  {     
    if(args.length!=5)
    {
      System.out.println("Usage: java VmCdOp <url> " +
            "<username> <password> <vmname> <device> <op>");
      System.out.println("device - disk|cd");
      System.out.println("op - add|remove");
      System.exit(0);
    }
    String vmname = args[3];
    String op = args[5];
 
    ServiceInstance si = new ServiceInstance(
        new URL(args[0]), args[1], args[2], true);

    Folder rootFolder = si.getRootFolder();
    VirtualMachine vm = (VirtualMachine) new InventoryNavigator(
      rootFolder).searchManagedEntity("VirtualMachine", vmname);

    if(vm==null)
    {
      System.out.println("No VM " + vmname + " found");
      si.getServerConnection().logout();
      return;
    }
    
    VirtualMachineConfigSpec vmConfigSpec = new VirtualMachineConfigSpec();
    
    if("add".equalsIgnoreCase(op)) 
    {
      String dsName ="storage1 (2)";
      String iso = "vimaster";
      VirtualDeviceConfigSpec cdSpec = createAddCdConfigSpec(vm, dsName, iso);
      vmConfigSpec.setDeviceChange(new VirtualDeviceConfigSpec[]{cdSpec});
    }
    else if("remove".equalsIgnoreCase(op)) 
    {
      String cdName = "CD/DVD Drive 2";
      VirtualDeviceConfigSpec cdSpec = createRemoveCdConfigSpec(vm, cdName);
      vmConfigSpec.setDeviceChange(new VirtualDeviceConfigSpec[]{cdSpec});
    }
    else 
    {
      System.out.println("Invlaid device type [disk|cd]");
      return;
    }
    
    Task task = vm.reconfigVM_Task(vmConfigSpec);
    task.waitForMe();
  }

  static VirtualDeviceConfigSpec createAddCdConfigSpec(VirtualMachine vm, String dsName, String isoName) throws Exception 
  {
    VirtualDeviceConfigSpec cdSpec = new VirtualDeviceConfigSpec();

    cdSpec.setOperation(VirtualDeviceConfigSpecOperation.add);         

    VirtualCdrom cdrom =  new VirtualCdrom();
    VirtualCdromIsoBackingInfo cdDeviceBacking = new  VirtualCdromIsoBackingInfo();
    DatastoreSummary ds = findDatastoreSummary(vm, dsName);
    cdDeviceBacking.setDatastore(ds.getDatastore());
    cdDeviceBacking.setFileName("[" + dsName +"] "+ vm.getName() 
        + "/" + isoName + ".iso");
    VirtualDevice vd = getIDEController(vm);          
    cdrom.setBacking(cdDeviceBacking);                    
    cdrom.setControllerKey(vd.getKey());
    cdrom.setUnitNumber(vd.getUnitNumber());
    cdrom.setKey(-1);          

    cdSpec.setDevice(cdrom);

    return cdSpec;          
  }
  
  static VirtualDeviceConfigSpec createRemoveCdConfigSpec(VirtualMachine vm, String cdName) throws Exception 
  {
    VirtualDeviceConfigSpec cdSpec = new VirtualDeviceConfigSpec();
    cdSpec.setOperation(VirtualDeviceConfigSpecOperation.remove);
    VirtualCdrom cdRemove = (VirtualCdrom)findVirtualDevice(vm.getConfig(), cdName);
    if(cdRemove != null) 
    {
      cdSpec.setDevice(cdRemove);
      return cdSpec;
    }
    else 
    {
      System.out.println("No device available " + cdName);
      return null;
    }
  }

  private static VirtualDevice findVirtualDevice(
      VirtualMachineConfigInfo vmConfig, String name)
  {
    VirtualDevice [] devices = vmConfig.getHardware().getDevice();
    for(int i=0;i<devices.length;i++)
    {
      if(devices[i].getDeviceInfo().getLabel().equals(name))
      {                             
        return devices[i];
      }
    }
    return null;
  }

  static DatastoreSummary findDatastoreSummary(VirtualMachine vm, String dsName) throws Exception 
  {
    DatastoreSummary dsSum = null;
    VirtualMachineRuntimeInfo vmRuntimeInfo = vm.getRuntime();
    EnvironmentBrowser envBrowser = vm.getEnvironmentBrowser(); 
    ManagedObjectReference hmor = vmRuntimeInfo.getHost();

    if(hmor == null)
    {
      System.out.println("No Datastore found");
      return null;
    }
    
    ConfigTarget configTarget = envBrowser.queryConfigTarget(new HostSystem(vm.getServerConnection(), hmor));
    VirtualMachineDatastoreInfo[] dis = configTarget.getDatastore();
    for (int i=0; dis!=null && i<dis.length; i++) 
    {
      dsSum = dis[i].getDatastore();
      if (dsSum.isAccessible() && dsName.equals(dsSum.getName())) 
      {
        break;
      }
    }
    return dsSum;
  }

  static VirtualDevice getIDEController(VirtualMachine vm) 
    throws Exception 
  {
    VirtualDevice ideController = null;
    VirtualDevice [] defaultDevices = getDefaultDevices(vm);
    for (int i = 0; i < defaultDevices.length; i++) 
    {
      if (defaultDevices[i] instanceof VirtualIDEController) 
      {
        ideController = defaultDevices[i];             
        break;
      }
    }
    return ideController;
  }

  static VirtualDevice[] getDefaultDevices(VirtualMachine vm) 
  throws Exception 
  {
    VirtualMachineRuntimeInfo vmRuntimeInfo = vm.getRuntime();
    EnvironmentBrowser envBrowser = vm.getEnvironmentBrowser(); 
    ManagedObjectReference hmor = vmRuntimeInfo.getHost();
    VirtualMachineConfigOption cfgOpt = envBrowser.queryConfigOption(null, new HostSystem(vm.getServerConnection(), hmor));
    VirtualDevice[] defaultDevs = null;
    if (cfgOpt != null) 
    {
      defaultDevs = cfgOpt.getDefaultDevice();
      if (defaultDevs == null) 
      {
        throw new Exception("No Datastore found in ComputeResource");
      }
    }
    else
    {
      throw new Exception("No VirtualHardwareInfo found in ComputeResource");
    }
    return defaultDevs;
  }
}
