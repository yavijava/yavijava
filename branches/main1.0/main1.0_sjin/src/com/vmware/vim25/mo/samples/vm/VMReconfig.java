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

import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;


/**
*<pre>This sample reconfigures a virtual machine which includes reconfiguring
*the disk size,disk mode etc.

*<b>Parameters:</b>
*vmname     [required]:  Name of the virtual machine
*device     [required]:  cpu|memory|disk|cd|nic
*operation  [optional]:  add|remove
*value      [required]:  high|low|normal|numeric value 
*disksize   [optional]:  Size of virtual disk
*diskmode   [optional]:  persistent|independent_persistent,independent_nonpersistent
*
*<b>Command:</b> To configure virtual machine. i.e.changing the CPU shares to 100
*run.bat com.vmware.samples.vm.VMReconfig --url [webserviceurl] 
*--username [username] --password [password] --vmname [vmname] --device [device]
*--operation [operation] --value [value] --disksize [disksize] --diskmode [diskmode]
*
*<b>Command:</b> To configure a virtual machine to add a hard disk with name HardDiskA and 
*Disksize = 100
*run.bat com.vmware.samples.vm.VMReconfig --url [webserviceurl] 
*--username [username] --password [password] --vmname [vmname] --device [disk]
*--operation [add]  --value [A] --disksize [100]

*<b>Command:</b> To configure a virtual machine to delete a NIC
*run.bat com.vmware.samples.vm.VMReconfig --url [webserviceurl] 
*--username [username] --password [password] --vmname [vmname] --device [nic]
*--operation [remove]  --value [name of the nic]
</pre>
*/


public class VMReconfig 
{    
	static CommandLineParser clp = null;
   
	private static void reConfig(CommandLineParser clp, VirtualMachine vm) throws Exception 
	{
      String deviceType = clp.get_option("device");
      VirtualMachineConfigSpec vmConfigSpec = new VirtualMachineConfigSpec();
      
      if(deviceType.equalsIgnoreCase("memory")) 
      {
         System.out.println("Reconfiguring The Virtual Machine For Memory Update " + clp.get_option("vmname"));
         try 
         {
            vmConfigSpec.setMemoryAllocation(getShares(clp.get_option("value")));          
         }
         catch(java.lang.NumberFormatException nfe) 
         {
            System.out.println("Value of Memory update must be either Custom or Integer");
            return;
         }
      }
      else if(deviceType.equalsIgnoreCase("cpu")) 
      {
         System.out.println("Reconfiguring The Virtual Machine For CPU Update " + clp.get_option("vmname"));       
         try 
         {
            vmConfigSpec.setCpuAllocation(getShares(clp.get_option("value")));
         }
         catch(java.lang.NumberFormatException nfe) 
         {
            System.out.println("Value of CPU update must be either Custom or Integer");
            return;
         }
      }
      else if(deviceType.equalsIgnoreCase("disk")) 
      {
         System.out.println("Reconfiguring The Virtual Machine For Disk Update " + clp.get_option("vmname"));                 
         VirtualDeviceConfigSpec vdiskSpec = getDiskDeviceConfigSpec(vm);
         if(vdiskSpec != null) 
         {
            VirtualDeviceConfigSpec [] vdiskSpecArray = {vdiskSpec};         
            vmConfigSpec.setDeviceChange(vdiskSpecArray);
         }
         else 
         {
            return;
         }
      }
      else if(deviceType.equalsIgnoreCase("nic")) 
      {
         System.out.println("Reconfiguring The Virtual Machine For NIC Update " + clp.get_option("vmname"));                          
         VirtualDeviceConfigSpec nicSpec = getNICDeviceConfigSpec(vm);
         if(nicSpec != null) 
         {
            VirtualDeviceConfigSpec [] nicSpecArray = {nicSpec};                     
            vmConfigSpec.setDeviceChange(nicSpecArray);
         }
         else 
         {
        	 return;
         }          
      }
      else if(deviceType.equalsIgnoreCase("cd")) 
      {
         System.out.println("Reconfiguring The Virtual Machine For CD Update " + clp.get_option("vmname"));                          
         VirtualDeviceConfigSpec cdSpec = getCDDeviceConfigSpec(vm);
         if(cdSpec != null) 
         {
        	 VirtualDeviceConfigSpec [] cdSpecArray = {cdSpec};                     
        	 vmConfigSpec.setDeviceChange(cdSpecArray);
         }
         else 
         {
            return;
         } 
      }
      else 
      {
         System.out.println("Invlaid device type [memory|cpu|disk|nic|cd]");
         return;
      }      
      Task task = vm.reconfigVM_Task(vmConfigSpec);
      task.waitForMe();
   }
   
   private static VirtualDeviceConfigSpec getCDDeviceConfigSpec(VirtualMachine vm) throws Exception 
   {
	   String ops = clp.get_option("operation");
	   VirtualDeviceConfigSpec cdSpec = new VirtualDeviceConfigSpec();
	   VirtualMachineConfigInfo vmConfigInfo = vm.getConfig(); 
      
	   if(ops.equalsIgnoreCase("Add")) 
	   {                        
         cdSpec.setOperation(VirtualDeviceConfigSpecOperation.add);         

         VirtualCdrom cdrom =  new VirtualCdrom();
         
         VirtualCdromIsoBackingInfo cdDeviceBacking = new  VirtualCdromIsoBackingInfo();
         DatastoreSummary dsum = getDataStoreSummary(vm);        
         cdDeviceBacking.setDatastore(dsum.getDatastore());
         cdDeviceBacking.setFileName("["+dsum.getName()+"] "+ clp.get_option("vmname") 
                                   + "/"+clp.get_option("value")+".iso");
         
         VirtualDevice vd = getIDEController(vm);          
         cdrom.setBacking(cdDeviceBacking);                    
         cdrom.setControllerKey(vd.getKey());
         cdrom.setUnitNumber(vd.getUnitNumber());
         cdrom.setKey(-1);          
         
         cdSpec.setDevice(cdrom);
         
         return cdSpec;          
      }
      else 
      {
    	  VirtualCdrom cdRemove = null;
    	  VirtualDevice [] test = vmConfigInfo.getHardware().getDevice();
    	  cdSpec.setOperation(VirtualDeviceConfigSpecOperation.remove);
         for(int k=0;k<test.length;k++)
         {
            if(test[k].getDeviceInfo().getLabel().equalsIgnoreCase(clp.get_option("value")))
            {                             
               cdRemove = (VirtualCdrom)test[k];
            }
         }
         if(cdRemove != null) 
         {
            cdSpec.setDevice(cdRemove);
         }
         else 
         {
            System.out.println("No device available " + clp.get_option("value"));
            return null;
         }
      }
      return cdSpec;
   }
   
   private static DatastoreSummary getDataStoreSummary(VirtualMachine vm) throws Exception 
   {
      DatastoreSummary dsSum = null;
      VirtualMachineRuntimeInfo vmRuntimeInfo = vm.getRuntime();
      EnvironmentBrowser envBrowser = vm.getEnvironmentBrowser(); 
      ManagedObjectReference hmor = vmRuntimeInfo.getHost();
      
      if(hmor != null) 
      {       
    	  ConfigTarget configTarget = envBrowser.queryConfigTarget(new HostSystem(vm.getServerConnection(), hmor));       
    	  if(configTarget.getDatastore() != null)
    	  {
            for (int i = 0; i < configTarget.getDatastore().length; i++) 
            {
               VirtualMachineDatastoreInfo vdsInfo = configTarget.getDatastore(i);
               DatastoreSummary dsSummary = vdsInfo.getDatastore();
               if (dsSummary.isAccessible()) 
               {
                  dsSum = dsSummary;
                  break;
               }
            }
         }
         return dsSum;
      }
      else 
      {
         System.out.println("No Datastore found");
         return null;
      }
   }
   
   private static VirtualDevice getIDEController(VirtualMachine vm) throws Exception 
   {
      VirtualDevice ideCtlr = null;
      VirtualDevice [] defaultDevices = getDefaultDevices(vm);
      for (int i = 0; i < defaultDevices.length; i++) 
      {
         if (defaultDevices[i] instanceof VirtualIDEController) 
         {
            ideCtlr = defaultDevices[i];             
            break;
         }
      }
      return ideCtlr;
   }
   
   private static VirtualDevice[] getDefaultDevices(VirtualMachine vm) throws Exception 
   {
      VirtualMachineRuntimeInfo vmRuntimeInfo = vm.getRuntime();
      EnvironmentBrowser envBrowser = vm.getEnvironmentBrowser(); 
      ManagedObjectReference hmor = vmRuntimeInfo.getHost();
      
      VirtualMachineConfigOption cfgOpt = envBrowser.queryConfigOption(null,  new HostSystem(vm.getServerConnection(), hmor));
      
      VirtualDevice[] defaultDevs = null;

      if (cfgOpt == null) 
      {
    	  throw new Exception("No VirtualHardwareInfo found in ComputeResource");
      }
      else 
      {
         defaultDevs = cfgOpt.getDefaultDevice();
         if (defaultDevs == null) 
         {
            throw new Exception("No Datastore found in ComputeResource");
         }
      }
      return defaultDevs;
   }   
   
   
   private static VirtualDeviceConfigSpec getNICDeviceConfigSpec(VirtualMachine vm) throws Exception 
   {
      String ops = clp.get_option("operation");
      VirtualDeviceConfigSpec nicSpec = new VirtualDeviceConfigSpec();      
      VirtualMachineConfigInfo vmConfigInfo  = vm.getConfig();
      
      if(ops.equalsIgnoreCase("Add")) 
      {
         String networkName = getNetworkName(vm); 
         if(networkName != null) 
         {
            nicSpec.setOperation(VirtualDeviceConfigSpecOperation.add);
            VirtualEthernetCard nic =  new VirtualPCNet32();
            VirtualEthernetCardNetworkBackingInfo nicBacking = new VirtualEthernetCardNetworkBackingInfo();
            nicBacking.setDeviceName(networkName);
            nic.setAddressType("generated");
            nic.setBacking(nicBacking);
            nic.setKey(4);
            nicSpec.setDevice(nic);
         }
         else 
         {
            return null;
         }
      }
      else if(ops.equalsIgnoreCase("Remove")) 
      {
         VirtualEthernetCard nic = null;
         VirtualDevice [] test = vmConfigInfo.getHardware().getDevice();
         nicSpec.setOperation(VirtualDeviceConfigSpecOperation.remove);
         for(int k=0;k<test.length;k++)
         {
        	 if(test[k].getDeviceInfo().getLabel().equalsIgnoreCase( clp.get_option("value")))
        	 {                             
        		 nic = (VirtualEthernetCard)test[k];
        	 }
         }
         if(nic != null) 
         {
            nicSpec.setDevice(nic);
         }
         else 
         {
            System.out.println("No device available " + clp.get_option("value"));
            return null;
         }
      }
      return nicSpec;
   }
   
   private static String getNetworkName(VirtualMachine vm) throws Exception 
   {
      String networkName = null;
      VirtualMachineRuntimeInfo vmRuntimeInfo = vm.getRuntime();
      
      EnvironmentBrowser envBrowser = vm.getEnvironmentBrowser();
      ManagedObjectReference hmor = vmRuntimeInfo.getHost();
      
      if(hmor != null) 
      {       
         ConfigTarget configTarget = envBrowser.queryConfigTarget(new HostSystem(vm.getServerConnection(), hmor));       
         if(configTarget.getNetwork() != null) 
         {
            for (int i = 0; i < configTarget.getNetwork().length; i++) 
            {
               VirtualMachineNetworkInfo netInfo = configTarget.getNetwork(i);
               NetworkSummary netSummary = netInfo.getNetwork();
               if (netSummary.isAccessible()) 
               {
                  if(netSummary.getName().equalsIgnoreCase(clp.get_option("value"))) 
                  {
                     networkName = netSummary.getName();
                     break;
                  }
               }
            }
            if(networkName == null) 
            {
               System.out.println("Specify the Correct Network Name");
               return null;
            }
         }
         System.out.println("network Name " + networkName);
         return networkName;
      }
      else 
      {
         System.out.println("No Host is responsible to run this VM");
         return null;
      }
   }
   
   private static VirtualDeviceConfigSpec getDiskDeviceConfigSpec(VirtualMachine vm) throws Exception
   {
      String ops = clp.get_option("operation");
      VirtualDeviceConfigSpec diskSpec = new VirtualDeviceConfigSpec();      
      VirtualMachineConfigInfo vmConfigInfo = (VirtualMachineConfigInfo)vm.getConfig();
      
      if(ops.equalsIgnoreCase("Add")) 
      { 
         VirtualDisk disk =  new VirtualDisk();
         VirtualDiskFlatVer2BackingInfo diskfileBacking = new VirtualDiskFlatVer2BackingInfo();    
         String dsName  = getDataStoreName(vm, Integer.parseInt(clp.get_option("disksize")));         
         
         int ckey = 0;
         int unitNumber = 0;
     
         VirtualDevice [] test = vmConfigInfo.getHardware().getDevice();
         for(int k=0;k<test.length;k++)
         {
            if(test[k].getDeviceInfo().getLabel().equalsIgnoreCase("SCSI Controller 0"))
            {
               ckey = test[k].getKey();                                
            }
         }
        
         unitNumber = test.length + 1;                
         String fileName = "["+dsName+"] "+ clp.get_option("vmname") + "/" + clp.get_option("value") + ".vmdk";
         
         diskfileBacking.setFileName(fileName);
         diskfileBacking.setDiskMode(clp.get_option("diskmode"));
      
         disk.setControllerKey(ckey);
         disk.setUnitNumber(unitNumber);
         disk.setBacking(diskfileBacking);
         int size = 1024 * (Integer.parseInt(clp.get_option("disksize")));
         disk.setCapacityInKB(size);
         disk.setKey(-1);
         
         diskSpec.setOperation(VirtualDeviceConfigSpecOperation.add);           
         diskSpec.setFileOperation(VirtualDeviceConfigSpecFileOperation.create);           
         diskSpec.setDevice(disk);                 
      }
      else if(ops.equalsIgnoreCase("Remove")) 
      {                             
         VirtualDisk disk =  null;
         VirtualDevice [] test = vmConfigInfo.getHardware().getDevice();
         for(int k=0;k<test.length;k++)
         {
            if(test[k].getDeviceInfo().getLabel().equalsIgnoreCase(clp.get_option("value")))
            {                             
               disk = (VirtualDisk)test[k];
            }
         }             
         if(disk != null) 
         {
            diskSpec.setOperation(VirtualDeviceConfigSpecOperation.remove);           
            diskSpec.setFileOperation(VirtualDeviceConfigSpecFileOperation.destroy);           
            diskSpec.setDevice(disk);                 
         }
         else 
         {
            System.out.println("No device found " + clp.get_option("value"));
            return null;
         }
      }
      return diskSpec;
   }
   
   private static String getDataStoreName(VirtualMachine vm, int size) throws Exception
   {
      String dsName = null;
      Datastore[] datastores = vm.getDatastores();
      for(int i=0; i<datastores.length; i++) 
      {
         DatastoreSummary ds = datastores[i].getSummary(); 
         if(ds.getFreeSpace() > size) 
         {
        	dsName = ds.getName();
            break;           
         }
      }
      return dsName;
   }
   
   private static ResourceAllocationInfo getShares(String val) throws Exception 
   {
      ResourceAllocationInfo raInfo = new ResourceAllocationInfo();
      SharesInfo sharesInfo = new SharesInfo();
     
      if(val.equalsIgnoreCase(SharesLevel._high)) 
      {       
         sharesInfo.setLevel(SharesLevel.high);          
      }
      else if(val.equalsIgnoreCase(SharesLevel._normal)) 
      {
         sharesInfo.setLevel(SharesLevel.normal);
      }
      else if(val.equalsIgnoreCase(SharesLevel._low)) 
      {
         sharesInfo.setLevel(SharesLevel.low);
      }
      else 
      {
         sharesInfo.setLevel(SharesLevel.custom);          
         sharesInfo.setShares(Integer.parseInt(val));          
      }    
      raInfo.setShares(sharesInfo);
      return raInfo;
   }

   private static boolean customValidation(CommandLineParser clp) throws Exception{
      boolean flag = true;
      String device = clp.get_option("device");
      if(device.equalsIgnoreCase("disk")) {
         if((!clp.option_is_set("operation")) || (!clp.option_is_set("disksize")) 
               || (!clp.option_is_set("diskmode"))) {
            System.out.println("For update disk operation, disksize "
               +"and diskmode are the Mandatory options");
            flag = false;
         }
      }
      if(device.equalsIgnoreCase("nic")) {
         if((!clp.option_is_set("operation")) ) {
            System.out.println("For update nic operation is the Mandatory options");
            flag = false;
         }
      }
      if(device.equalsIgnoreCase("cd")) {
         if((!clp.option_is_set("operation"))) {
            System.out.println("For update cd operation is the Mandatory options");
            flag = false;
         }
      }
      if(device.equalsIgnoreCase("cpu") || device.equalsIgnoreCase("memory")) {
         if(Integer.parseInt(clp.get_option("value")) <= 0 ) {
            System.out.println("CPU and Memory shares must be a greater than zero");
            flag = false;
         }
      }
      if(device.equalsIgnoreCase("disk")) {
          if(Integer.parseInt(clp.get_option("disksize")) <= 0 ) {
             System.out.println("Disksize must be a greater than zero");
             flag = false;
          }
      }
      if(clp.option_is_set("operation")) {
         if(clp.get_option("operation").equalsIgnoreCase("add") 
            || clp.get_option("operation").equalsIgnoreCase("remove")) {}
         else {
            System.out.println("Operation must be either add or remove");
            flag = false;
         }
      }
      return flag;             
   }
   
   private static OptionSpec[] constructOptions() 
   {
     OptionSpec [] useroptions = new OptionSpec[6];
     useroptions[0] = new OptionSpec("vmname","String",1
                                     ,"Name of the virtual machine", null);
     useroptions[1] = new OptionSpec("device","String",1,
                                     "Type of device {cpu|memory|disk|cd|nic}", null);
     useroptions[2] = new OptionSpec("operation","String",0
                                     ,"{add|remove}" , null);
     useroptions[3] = new OptionSpec("value","String",1,
                                     "{numeric(For Memory and CPU high|" + "low|normal|numeric value)|deviceId}", null);
     useroptions[4] = new OptionSpec("disksize","Integer",0
                                     ,"Size of virtual disk", null);
     useroptions[5] = new OptionSpec("diskmode","String",0,
                                     "{persistent|independent_persistent,"
                                     +"independent_nonpersistent}", null);
     return useroptions;
   }
   
   
   // TODO ** need to clean up more
   public static void main(String[] args) throws Exception 
   {     
	    clp = new CommandLineParser(constructOptions(), args);
	   	String urlStr = clp.get_option("url");
  	    String username = clp.get_option("username");
	    String password = clp.get_option("password");
	    String vmname = clp.get_option("vmname");
		ServiceInstance si = new ServiceInstance(new URL(urlStr), username, password, true);
		
		Folder rootFolder = si.getRootFolder();
		VirtualMachine vm = (VirtualMachine) new InventoryNavigator(rootFolder).searchManagedEntity("VirtualMachine", vmname);
	   
		boolean valid = customValidation(clp);
		if(valid) 
		{
			reConfig(clp, vm);
		}
        else 
        {
            System.out.println("Virtual Machine " + clp.get_option("vmname") + " Not Found");
        }
   }
}
