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

package com.vmware.vim25.mox;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import com.vmware.vim25.ConcurrentAccess;
import com.vmware.vim25.ConfigTarget;
import com.vmware.vim25.DeviceNotSupported;
import com.vmware.vim25.DistributedVirtualPortgroupInfo;
import com.vmware.vim25.DistributedVirtualPortgroupPortgroupType;
import com.vmware.vim25.DistributedVirtualSwitchPortConnection;
import com.vmware.vim25.DuplicateName;
import com.vmware.vim25.FileFault;
import com.vmware.vim25.GuestOsDescriptor;
import com.vmware.vim25.InsufficientResourcesFault;
import com.vmware.vim25.InvalidDatastore;
import com.vmware.vim25.InvalidName;
import com.vmware.vim25.InvalidPowerState;
import com.vmware.vim25.InvalidProperty;
import com.vmware.vim25.InvalidState;
import com.vmware.vim25.NetworkSummary;
import com.vmware.vim25.RuntimeFault;
import com.vmware.vim25.TaskInProgress;
import com.vmware.vim25.VirtualCdrom;
import com.vmware.vim25.VirtualCdromAtapiBackingInfo;
import com.vmware.vim25.VirtualCdromIsoBackingInfo;
import com.vmware.vim25.VirtualCdromRemotePassthroughBackingInfo;
import com.vmware.vim25.VirtualController;
import com.vmware.vim25.VirtualDevice;
import com.vmware.vim25.VirtualDeviceBackingInfo;
import com.vmware.vim25.VirtualDeviceConfigSpec;
import com.vmware.vim25.VirtualDeviceConfigSpecFileOperation;
import com.vmware.vim25.VirtualDeviceConfigSpecOperation;
import com.vmware.vim25.VirtualDeviceConnectInfo;
import com.vmware.vim25.VirtualDeviceFileBackingInfo;
import com.vmware.vim25.VirtualDisk;
import com.vmware.vim25.VirtualDiskFlatVer2BackingInfo;
import com.vmware.vim25.VirtualDiskMode;
import com.vmware.vim25.VirtualDiskType;
import com.vmware.vim25.VirtualE1000;
import com.vmware.vim25.VirtualEthernetCard;
import com.vmware.vim25.VirtualEthernetCardDistributedVirtualPortBackingInfo;
import com.vmware.vim25.VirtualEthernetCardNetworkBackingInfo;
import com.vmware.vim25.VirtualFloppy;
import com.vmware.vim25.VirtualFloppyDeviceBackingInfo;
import com.vmware.vim25.VirtualFloppyImageBackingInfo;
import com.vmware.vim25.VirtualFloppyRemoteDeviceBackingInfo;
import com.vmware.vim25.VirtualIDEController;
import com.vmware.vim25.VirtualMachineCdromInfo;
import com.vmware.vim25.VirtualMachineConfigOption;
import com.vmware.vim25.VirtualMachineConfigSpec;
import com.vmware.vim25.VirtualMachineNetworkInfo;
import com.vmware.vim25.VirtualMachinePowerState;
import com.vmware.vim25.VirtualPCNet32;
import com.vmware.vim25.VirtualSCSIController;
import com.vmware.vim25.VirtualUSB;
import com.vmware.vim25.VirtualUSBController;
import com.vmware.vim25.VirtualVmxnet;
import com.vmware.vim25.VirtualVmxnet2;
import com.vmware.vim25.VirtualVmxnet3;
import com.vmware.vim25.VmConfigFault;
import com.vmware.vim25.mo.ComputeResource;
import com.vmware.vim25.mo.EnvironmentBrowser;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.Task;
import com.vmware.vim25.mo.VirtualMachine;

/**
 * VirtualMachineDeviceManager manages the virtual devices in a much
 * simplified way than using the reconfigVM_Task() method defined in
 * VirtualMachine managed object.

 * Devices it manages include: FloppyDrive, CdDrive, NetworkAdapter, UsbDevice, HardDisk
 * Operations include:
    create -- create something new
    add -- add something existing but not yet attached to the virtual machine
    remove -- remove the device(s) from the virtual machine
    get -- retrieve the device(s) from the virtual machine
    update -- update the existing device with new configuration
    
    @author Steve Jin (http://www.doublecloud.org)
*/

public class VirtualMachineDeviceManager
{
  private VirtualMachine vm;
  
  public VirtualMachineDeviceManager(VirtualMachine vm)
  {
    this.vm = vm;
  }
  
  public VirtualMachine getVM()
  {
    return this.vm;
  }

  /*############################################################
  Floppy Drive Management
  ############################################################*/
  /**
   * @param floppyImagePath - i.e. "[storage1] myVM/myFloppy.flp" Note: there is a space after ].
   */
  public Task addFloppyDriveFromISO(String floppyImagePath, boolean startConnected) throws InvalidName, VmConfigFault, DuplicateName, TaskInProgress, FileFault, InvalidState, ConcurrentAccess, InvalidDatastore, InsufficientResourcesFault, RuntimeFault, RemoteException
  {
    return addFloppyDrive(floppyImagePath, null, null, startConnected);
  }
  
  /**
   * @param hostDevice - i.e. "/dev/fd0" 
   */
  public Task addFloppyDriveFromHost(String hostDevice, boolean startConnected) throws InvalidName, VmConfigFault, DuplicateName, TaskInProgress, FileFault, InvalidState, ConcurrentAccess, InvalidDatastore, InsufficientResourcesFault, RuntimeFault, RemoteException
  {
    return addFloppyDrive(null, null, hostDevice, startConnected);
  }

  public Task createFloppyDrive(String floppyImagePath, boolean startConnected) throws InvalidName, VmConfigFault, DuplicateName, TaskInProgress, FileFault, InvalidState, ConcurrentAccess, InvalidDatastore, InsufficientResourcesFault, RuntimeFault, RemoteException
  {
    return addFloppyDrive(null, floppyImagePath, null, startConnected);
  }

  private Task addFloppyDrive(String floppyImagePath, String newFloppyImagePath, String hostDevice, boolean startConnected) throws InvalidName, VmConfigFault, DuplicateName, TaskInProgress, FileFault, InvalidState, ConcurrentAccess, InvalidDatastore, InsufficientResourcesFault, RuntimeFault, RemoteException 
  {
    // Any VM associated with the device must be powered off.
    if(vm.getRuntime().getPowerState() == VirtualMachinePowerState.poweredOff)
    {
      throw new RuntimeException("Invalid power state: power off this VM before adding a floppy drive.");
    }

    VirtualFloppy floppy = new VirtualFloppy();
    floppy.connectable = new VirtualDeviceConnectInfo();
    floppy.connectable.startConnected = startConnected;

    if (hostDevice != null) 
    {
      VirtualFloppyDeviceBackingInfo backing = new VirtualFloppyDeviceBackingInfo();
      backing.deviceName = hostDevice;
      floppy.backing = backing;
    } 
    else if (floppyImagePath != null) 
    {
      VirtualFloppyImageBackingInfo backing = new VirtualFloppyImageBackingInfo();
      backing.fileName = floppyImagePath;
      floppy.backing = backing;
    }
    else if (newFloppyImagePath != null) 
    {
      VirtualFloppyImageBackingInfo backing = new VirtualFloppyImageBackingInfo();
      backing.fileName = newFloppyImagePath;
      floppy.backing = backing;
    } 
    else 
    {
       // The VIM API doesn't allow for the possibility of adding a drive 
       // without hooking it up to something. In an ideal world, I'd probably
       // want an ISO backing without having to specify a valid ISO at this 
       // time. So we'll create a remote passthrough backing and just set it 
       // as not connected.
       VirtualFloppyRemoteDeviceBackingInfo backing = new VirtualFloppyRemoteDeviceBackingInfo();
       backing.deviceName = "";
       floppy.backing = backing;
       floppy.connectable.startConnected = false;
       floppy.connectable.connected = false;
     }

     floppy.key = -1;

     VirtualDeviceConfigSpec floppySpec = new VirtualDeviceConfigSpec();
     floppySpec.operation = VirtualDeviceConfigSpecOperation.add;
     if (newFloppyImagePath != null) 
     {
       floppySpec.fileOperation = VirtualDeviceConfigSpecFileOperation.create;
     }
     floppySpec.device = floppy;

     VirtualMachineConfigSpec config = new VirtualMachineConfigSpec();
     config.deviceChange = new VirtualDeviceConfigSpec[] { floppySpec };

     VirtualIDEController controller = getFirstAvailableController(VirtualIDEController.class);

     if (controller != null) 
     {
        config.deviceChange[0].device.controllerKey = controller.key;
     } 
     else 
     {
       throw new RuntimeException("No available IDE controller for floppy drive.");
     }
     
    return vm.reconfigVM_Task(config);
  }
  
  /*############################################################
  PassthroughDevice Management
  ############################################################*/
  //TODO: All of these 3 methods
  //type: either SCSI or PCI (4.0 and higher)
  public String getPassThroughDevice(String type)
  {
    return "";
  }
  
  public void addPassthroughDevice()
  {
    
  }
  public void removePassthroughDevice()
  {
    
  }
  

  /*############################################################
  CD/DVC Drive Management
  ############################################################*/
  public void addCdDriveFromIso(String isoPath, boolean startConnected) throws InvalidProperty, RuntimeFault, RemoteException, InterruptedException
  {
    addCdDrive(isoPath, null, startConnected);
  }

  public void addCdDriveFromHost(String hostDevice, boolean startConnected) throws InvalidProperty, RuntimeFault, RemoteException, InterruptedException
  {
    addCdDrive(null, hostDevice, startConnected);
  }
  
  private void addCdDrive(String isoPath, String hostDevice, boolean startConnected) throws InvalidProperty, RuntimeFault, RemoteException, InterruptedException
  {
    VirtualMachinePowerState powerState = vm.getRuntime().getPowerState();
    if(powerState != VirtualMachinePowerState.poweredOff)
    {
      throw new RuntimeException("VM is not yet powered off for adding a CD drive.");
    }
    
    VirtualCdrom cdrom = new VirtualCdrom();
    cdrom.connectable = new VirtualDeviceConnectInfo();
    cdrom.connectable.allowGuestControl = true;
    cdrom.connectable.startConnected = startConnected;

    if (hostDevice != null) 
    {
      validateCdromHostDevice(hostDevice);
      VirtualCdromAtapiBackingInfo backing = new VirtualCdromAtapiBackingInfo();
      backing.deviceName = hostDevice;
      cdrom.backing = backing;
    }
    else if (isoPath != null) 
    {
      VirtualCdromIsoBackingInfo backing = new VirtualCdromIsoBackingInfo();
      backing.fileName = isoPath;
      cdrom.backing = backing;
    } 
    else 
    {
      // We don't allow adding a CD drive without hooking it up to something. 
      // In an ideal world, you may want an ISO backing without having to specify a valid ISO 
      // at this time. Create a remote passthrough backing and just set it as not connected.
      VirtualCdromRemotePassthroughBackingInfo backing = new VirtualCdromRemotePassthroughBackingInfo();
      backing.exclusive = true;
      backing.deviceName = "";
      cdrom.backing = backing;
    }

    cdrom.key = -1;

    VirtualDeviceConfigSpec cdSpec = new VirtualDeviceConfigSpec();
    cdSpec.operation = VirtualDeviceConfigSpecOperation.add;
    cdSpec.device = cdrom;

    VirtualMachineConfigSpec config = new VirtualMachineConfigSpec();
    config.deviceChange = new VirtualDeviceConfigSpec[] { cdSpec };

    VirtualIDEController controller = getFirstAvailableController(VirtualIDEController.class);

    if (controller != null) 
    {
      config.deviceChange[0].device.controllerKey = controller.key;
    }
    else 
    {
      throw new RuntimeException("No free IDE controller for addtional CD Drive.");
    }
    
    Task task = vm.reconfigVM_Task(config);
    task.waitForTask();
  }

  private void validateCdromHostDevice(String hostDevice) throws InvalidProperty, RuntimeFault, RemoteException 
  {
    List<String> validCdList = getValidCdromOnHost();

    if (!validCdList.contains(hostDevice))
    {
      throw new RuntimeException("Invalid host device path for CD drives.");
    }
  }
  
  private List<String> getValidCdromOnHost() throws InvalidProperty, RuntimeFault, RemoteException 
  {
    List<String> result = new ArrayList<String>();

    EnvironmentBrowser envBrower = vm.getEnvironmentBrowser();

    ConfigTarget configTarget;

    try 
    {
      configTarget = envBrower.queryConfigTarget(null);
    } 
    catch (Exception ex) 
    {
      throw new RuntimeException("Error in getting Cdrom devices from host.");
    }

    if(configTarget != null && configTarget.cdRom != null) 
    {
      for(VirtualMachineCdromInfo cdromInfo : configTarget.cdRom) 
      {
               result.add(cdromInfo.name);
      }
    }
    return result;
  }


  /*############################################################
  Hard Disk Management
  ############################################################*/
  public void createHardDisk(int diskSizeMB, VirtualDiskType type, VirtualDiskMode mode) throws Exception
  {
    VirtualMachineConfigSpec vmConfigSpec = new VirtualMachineConfigSpec();
    VirtualDeviceConfigSpec diskSpec = new VirtualDeviceConfigSpec();      
    
    VirtualDiskFlatVer2BackingInfo diskfileBacking = new VirtualDiskFlatVer2BackingInfo();
    diskfileBacking.setFileName("");
    diskfileBacking.setDiskMode(mode.toString());
    diskfileBacking.setThinProvisioned(type==VirtualDiskType.thin);

    VirtualSCSIController scsiController = getFirstAvailableController(VirtualSCSIController.class);
    int unitNumber = getFirstFreeUnitNumberForController(scsiController);
    VirtualDisk disk = new VirtualDisk();
    disk.setControllerKey(scsiController.key);
    disk.setUnitNumber(unitNumber);
    disk.setBacking(diskfileBacking);
    disk.setCapacityInKB(1024 * diskSizeMB);
    disk.setKey(-1);
    
    diskSpec.setOperation(VirtualDeviceConfigSpecOperation.add);           
    diskSpec.setFileOperation(VirtualDeviceConfigSpecFileOperation.create);           
    diskSpec.setDevice(disk);
    VirtualDeviceConfigSpec vdiskSpec = diskSpec;
    VirtualDeviceConfigSpec [] vdiskSpecArray = {vdiskSpec};         

    vmConfigSpec.setDeviceChange(vdiskSpecArray);
    Task task = vm.reconfigVM_Task(vmConfigSpec);

    task.waitForTask(200, 100);
  }
  
  public void addHardDisk(String diskFilePath, VirtualDiskMode diskMode) throws Exception
  {
    VirtualMachineConfigSpec vmConfigSpec = new VirtualMachineConfigSpec();

    VirtualDeviceConfigSpec diskSpec = new VirtualDeviceConfigSpec();
    VirtualDeviceConfigSpec[] vdiskSpecArray = {diskSpec};
    vmConfigSpec.setDeviceChange(vdiskSpecArray);
    
    VirtualDiskFlatVer2BackingInfo diskfileBacking = new VirtualDiskFlatVer2BackingInfo();
    diskfileBacking.setFileName(diskFilePath);
    diskfileBacking.setDiskMode(diskMode.toString());

    
    VirtualSCSIController scsiController = getFirstAvailableController(VirtualSCSIController.class);
    int unitNumber = getFirstFreeUnitNumberForController(scsiController);

    VirtualDisk disk = new VirtualDisk();
    disk.setControllerKey(scsiController.key);
    disk.setUnitNumber(unitNumber);
    disk.setBacking(diskfileBacking);
    //Unlike required by API ref, the capacityKB is optional. So skip setCapacityInKB() method.
    disk.setKey(-100);

    diskSpec.setOperation(VirtualDeviceConfigSpecOperation.add);           
    diskSpec.setDevice(disk);                 
    
    Task task = vm.reconfigVM_Task(vmConfigSpec);

    task.waitForTask(200, 100);
  }
  
  public VirtualDisk findHardDisk(String diskName) 
  {
    VirtualDevice[] devices = getAllVirtualDevices();
    
    for(int i=0; i<devices.length; i++) 
    {
      if(devices[i] instanceof VirtualDisk) 
      {
        VirtualDisk vDisk = (VirtualDisk)devices[i];
        if(diskName.equalsIgnoreCase(vDisk.getDeviceInfo().getLabel())) 
        {
          return vDisk;
        }
      }
    }
    return null;
  } 
  
  private int getFirstFreeUnitNumberForController(VirtualController controller) 
  {
    // If there are some devices attached then search which nodes are free
    // otherwise all nodes are free so just return the first one.
    if (controller.device == null) 
    {
      return 0;
    }
    
    int maxNodes = getMaxNodesPerControllerOfType(controller);

    if (controller.device.length < maxNodes) 
    {
      List<Integer> usedNodeList = new ArrayList<Integer>();
      VirtualDevice[] devices = getAllVirtualDevices();

      // If this is SCSI controller then its controller also occupies one node.
      if (controller instanceof VirtualSCSIController) 
      {
        usedNodeList.add(((VirtualSCSIController) controller).scsiCtlrUnitNumber);
      }

      for(VirtualDevice device : devices)
      {
        if(device.controllerKey!=null && device.controllerKey == controller.key) 
        {
          usedNodeList.add(device.unitNumber);
        }
      }
      for(int i=0; i<maxNodes; i++)
      {
        if (!usedNodeList.contains(i)) 
        {
          return i;
        }
      }
    }
    
    return -1;
  }
  

  /*############################################################
  Network Adapter Management
  ############################################################*/
/** Create a new virtual network adapter on the VM
 * Your MAC address should start with 00:50:56
   */
  public void createNetworkAdapter(VirtualNetworkAdapterType type, String networkName, String macAddress, boolean wakeOnLan, boolean startConnected) throws InvalidProperty, RuntimeFault, RemoteException, InterruptedException
  {
    VirtualMachinePowerState powerState = vm.getRuntime().getPowerState();
    String vmVerStr = vm.getConfig().getVersion();
    int vmVer = Integer.parseInt(vmVerStr.substring(vmVerStr.length()-2));
    
    if((powerState == VirtualMachinePowerState.suspended) ||
      (powerState == VirtualMachinePowerState.suspended && vmVer < 7))
    {
      throw new InvalidPowerState();
    }
    
    HostSystem host = new HostSystem(vm.getServerConnection(), vm.getRuntime().getHost());
    ComputeResource cr = (ComputeResource) host.getParent();
    EnvironmentBrowser envBrowser = cr.getEnvironmentBrowser();
    ConfigTarget configTarget = envBrowser.queryConfigTarget(host);
    VirtualMachineConfigOption vmCfgOpt = envBrowser.queryConfigOption(null, host);

    type = validateNicType(vmCfgOpt.getGuestOSDescriptor(), vm.getConfig().getGuestId(), type);

    VirtualDeviceConfigSpec nicSpec = createNicSpec(type, networkName, macAddress, wakeOnLan, startConnected, configTarget);
    
    VirtualMachineConfigSpec vmConfigSpec = new VirtualMachineConfigSpec();
    vmConfigSpec.setDeviceChange(new VirtualDeviceConfigSpec []{nicSpec});
    Task task = vm.reconfigVM_Task(vmConfigSpec);

    task.waitForTask(200, 100);
  }
  
  private VirtualDeviceConfigSpec createNicSpec( VirtualNetworkAdapterType adapterType, String networkName, String macAddress, boolean wakeOnLan, boolean startConnected, ConfigTarget configTarget) 
  {
    VirtualDeviceConfigSpec result = null;
    DistributedVirtualPortgroupInfo dvPortgroupInfo = null;
    
    // Try vDS portgroup first
    if (configTarget.distributedVirtualPortgroup != null) 
    {
      dvPortgroupInfo = findDVPortgroupInfo(configTarget.distributedVirtualPortgroup, networkName);
    }
    
    if (dvPortgroupInfo != null) 
    {
      validateDVPortGroupForVNicConnection(dvPortgroupInfo);
      VirtualEthernetCardDistributedVirtualPortBackingInfo nicBacking = new VirtualEthernetCardDistributedVirtualPortBackingInfo();
      nicBacking.port = new DistributedVirtualSwitchPortConnection();
      nicBacking.port.portgroupKey = dvPortgroupInfo.portgroupKey;
      nicBacking.port.switchUuid = dvPortgroupInfo.switchUuid;
      result = createNicSpec(adapterType, macAddress, wakeOnLan, startConnected, nicBacking);
    }
    else 
    {
      NetworkSummary netSummary = getHostNetworkSummaryByName(
               networkName, configTarget.network);
      VirtualEthernetCardNetworkBackingInfo nicBacking = new VirtualEthernetCardNetworkBackingInfo();
      nicBacking.network = netSummary.network;
      nicBacking.deviceName = netSummary.name;
      result = createNicSpec(adapterType, macAddress, wakeOnLan, startConnected, nicBacking);
    }
    return result;
  }
  
  // Validate if vDS Portgroup can be bound to vnic
  private void validateDVPortGroupForVNicConnection(DistributedVirtualPortgroupInfo dvPortgroupInfo) 
  {
    if (dvPortgroupInfo.uplinkPortgroup) 
    {
      throw new RuntimeException("The vDS portgroup's uplinkPortgroup should not be null");
    }

    DistributedVirtualPortgroupPortgroupType portgroupType = DistributedVirtualPortgroupPortgroupType.valueOf(dvPortgroupInfo.portgroupType);

    String prodLineId = vm.getServerConnection().getServiceInstance().getAboutInfo().getProductLineId();
    // standalone host cannot do early or late binding 
    if (prodLineId.indexOf("ESX")!=-1 &&
        (portgroupType == DistributedVirtualPortgroupPortgroupType.earlyBinding ||
        portgroupType == DistributedVirtualPortgroupPortgroupType.lateBinding)) 
    {
      throw new RuntimeException("ESX does not support early or late binding!");
     }
  }

  private static NetworkSummary getHostNetworkSummaryByName(String networkName, VirtualMachineNetworkInfo[] hostNetworkList) 
  {
    NetworkSummary result = null;
    boolean isNetworkExistingOnHost = false;

     // Check each of the provided network names against host networks to see if it exists on host
    for (VirtualMachineNetworkInfo netInfo : hostNetworkList) 
    {
      if (networkName.equals(netInfo.name)) 
      {
        isNetworkExistingOnHost = true;

        if (netInfo.network.accessible) 
        {
          result = netInfo.network;
          break;
        }
        else
        {
          throw new RuntimeException("Network: " + networkName + " is not accessible."); 
        }
      }
    }
    if (!isNetworkExistingOnHost) 
    {
      throw new RuntimeException("Network: " + networkName + " does not exist on host network."); 
    }
    return result;
  }

  private static DistributedVirtualPortgroupInfo findDVPortgroupInfo(DistributedVirtualPortgroupInfo[] hostDistributedVirtualPortgroupInfo,
      String portgroupName) 
  {
    DistributedVirtualPortgroupInfo result = null;

    if (hostDistributedVirtualPortgroupInfo != null) 
    {
      for (DistributedVirtualPortgroupInfo portgroupInfo : hostDistributedVirtualPortgroupInfo) 
      {
        if (portgroupInfo.portgroupName.equalsIgnoreCase(portgroupName)) 
        {
          result = portgroupInfo;
          break;
        }
      }
    }
    return result;
  }
  
  private static VirtualDeviceConfigSpec createNicSpec(VirtualNetworkAdapterType adapterType, String macAddress, boolean wakeOnLan, boolean startConnected, VirtualDeviceBackingInfo nicBacking) 
  {
    VirtualDeviceConfigSpec result = new VirtualDeviceConfigSpec();

    VirtualEthernetCard device;
    switch (adapterType) 
    {
      case VirtualVmxnet:
        device = new VirtualVmxnet();
        break;
      case VirtualVmxnet2:
        device = new VirtualVmxnet2();
        break;
      case VirtualVmxnet3:
        device = new VirtualVmxnet3();
        break;
      case VirtualPCNet32:
        device = new VirtualPCNet32();
        break;
      case VirtualE1000:
        device = new VirtualE1000();
        break;
      default:
        device = new VirtualVmxnet();
        break;
    }

    if(macAddress==null)
    {
      device.addressType = "generated";
    }
    else
    {
      device.addressType = "manual";
      device.macAddress = macAddress;
    }
    device.wakeOnLanEnabled = wakeOnLan;
    
    device.backing = nicBacking;
    device.connectable = new VirtualDeviceConnectInfo();
    device.connectable.connected = true;
    device.connectable.startConnected = startConnected;
    device.key = -1;

    result.operation = VirtualDeviceConfigSpecOperation.add;
    result.device = device;

    return result;
  }

  // Check network adapter type if it's supported by the guest OS
  private static VirtualNetworkAdapterType validateNicType(GuestOsDescriptor[] guestOsDescriptorList,
     String guestId, VirtualNetworkAdapterType adapterType) throws DeviceNotSupported 
  {
    VirtualNetworkAdapterType result = adapterType;

    GuestOsDescriptor guestOsInfo = null;

    for (GuestOsDescriptor desc : guestOsDescriptorList) 
    {
      if(desc.getId().equalsIgnoreCase(guestId))
      {
        guestOsInfo = desc;
        break;
      }
    }

    if (adapterType == VirtualNetworkAdapterType.Unknown) 
    {
      result = TryGetNetworkAdapterType(guestOsInfo);
    } 
    else 
    {
      if (guestOsInfo.getSupportedEthernetCard() != null) 
      {
        boolean supported = false;
        List<String> supportedTypeList = new ArrayList<String>();

        for(String supportedAdapterName : guestOsInfo.getSupportedEthernetCard()) 
        {
          VirtualNetworkAdapterType supportedAdapterType = GetNetworkAdapterTypeByApiType(supportedAdapterName);
          supportedTypeList.add(supportedAdapterType.toString());

          if (supportedAdapterType == adapterType) 
          {
            supported = true;
            break;
          }
        }

        if (!supported) 
        {
          DeviceNotSupported dns = new DeviceNotSupported();
          dns.setDevice("Virtual NIC");
          dns.setReason("The requested NIC is not supported in this OS.");
          throw dns;
        }
      }
    }
    return result;
  }

  // Returns VirtualEthernetCard type recommended for the selected GuestOs
  private static VirtualNetworkAdapterType TryGetNetworkAdapterType(GuestOsDescriptor guestOsInfo) 
  {
    String ethernetCardType = guestOsInfo.getRecommendedEthernetCard();

    if ((ethernetCardType == null || ethernetCardType.isEmpty()) &&
        (guestOsInfo.getSupportedEthernetCard()!= null) &&
        ((guestOsInfo.getSupportedEthernetCard().length > 0))) 
    {
      ethernetCardType = guestOsInfo.getSupportedEthernetCard()[0];
    }
    return GetNetworkAdapterTypeByApiType(ethernetCardType);
  }
  
  private static VirtualNetworkAdapterType GetNetworkAdapterTypeByApiType(String ethernetCardType) 
  {
    return VirtualNetworkAdapterType.valueOf(ethernetCardType);
  }
  
  
  /*############################################################
  Common Code for All Types of Devices
  ############################################################*/
  
  /**
   * Remove the device. Make sure the VM is powered off before calling this method.
   * If destroyDeviceBacking is true, it deletes backings for example files in datastore. BE CAREFUL! 
   */
  public Task removeDevice(VirtualDevice device, boolean destroyDeviceBacking) throws InvalidName, VmConfigFault, DuplicateName, TaskInProgress, FileFault, InvalidState, ConcurrentAccess, InvalidDatastore, InsufficientResourcesFault, RuntimeFault, RemoteException
  {
    ArrayList<VirtualDevice> deviceList = new ArrayList<VirtualDevice>();
    deviceList.add(device);
    return removeDevices(deviceList, destroyDeviceBacking); 
  }
  
  
  /**
   * Remove all devices as listed in the deviceList. These devices can be different types. 
   * Make sure the VM is powered off before calling this method.
   * If destroyDeviceBacking is true, it deletes backings for example files in datastore. BE CAREFUL! 
   */
  public Task removeDevices(List<VirtualDevice> deviceList, boolean destroyDeviceBacking) throws InvalidName, VmConfigFault, DuplicateName, TaskInProgress, FileFault, InvalidState, ConcurrentAccess, InvalidDatastore, InsufficientResourcesFault, RuntimeFault, RemoteException 
  {
    List<VirtualDeviceConfigSpec> configSpecList = new ArrayList<VirtualDeviceConfigSpec>();

    boolean allDevicesSupportHotRemoval = allSupportHotRemoval(deviceList);
    VirtualMachinePowerState powerState = vm.getRuntime().getPowerState();
    if (!allDevicesSupportHotRemoval && powerState!= VirtualMachinePowerState.poweredOff ) 
    {
      throw new RuntimeException("Invalid power state: power off the VM first.");
    }

    for(VirtualDevice device : deviceList) 
    {
      try 
      {
        // Empty SCSI controller removal
        // If the device's SCSI controller will get free after device removal
        // then also remove the controller. But only if the VM is powered off.
        if (device instanceof VirtualDisk && powerState == VirtualMachinePowerState.poweredOff) 
        {
          List<VirtualSCSIController> contollerList = getVirtualDevicesOfType(VirtualSCSIController.class);
          for(VirtualSCSIController controller : contollerList) 
          {
            if (controller.key == device.controllerKey) 
            {
              if (controller.device.length == 1 && controller.device[0] == device.key) 
              {
                 VirtualDeviceConfigSpec controllerSpec = new VirtualDeviceConfigSpec();
                 controllerSpec.operation = VirtualDeviceConfigSpecOperation.remove;
                 controllerSpec.device = controller;
                 configSpecList.add(controllerSpec);
              }
              break;
            }
          }
         }

         //region Usb controller removal.
         // If the device's SCSI controller will get free after device removal, also remove the controller.
         if (device instanceof VirtualUSB) 
         {
           //TODO remove duplication of this and above section of code
           List<VirtualUSBController> contollerList = getVirtualDevicesOfType(VirtualUSBController.class);
           for (VirtualUSBController controller : contollerList) 
           {
             if (controller.key == device.controllerKey) 
             {
               if (controller.device.length == 1 && controller.device[0] == device.key) 
               {
                 VirtualDeviceConfigSpec controllerSpec = new VirtualDeviceConfigSpec();
                 controllerSpec.operation = VirtualDeviceConfigSpecOperation.remove;
                 controllerSpec.device = controller;
                 configSpecList.add(controllerSpec);
               }
               break;
             }
           }
          // remove the Usb controller when we want to remove the usb device.
          continue;
         }

         VirtualDeviceConfigSpec deviceSpec = new VirtualDeviceConfigSpec();
         deviceSpec.operation = VirtualDeviceConfigSpecOperation.remove;
         deviceSpec.device = device;
         if(destroyDeviceBacking) 
         {
           deviceSpec.fileOperation = VirtualDeviceConfigSpecFileOperation.destroy;
         }

         configSpecList.add(deviceSpec);
      }
      catch (Exception ex) 
      {
        throw new RuntimeException(ex);
      }
    }

    if (configSpecList.size() > 0) 
    {
      VirtualMachineConfigSpec config = new VirtualMachineConfigSpec();
      config.deviceChange = new VirtualDeviceConfigSpec[configSpecList.size()];
      for(int i=0; i< configSpecList.size(); i++)
      {
        config.deviceChange[i] = configSpecList.get(i);
      }
      Task task = vm.reconfigVM_Task(config);
      return task;
    }
    return null;
  }
  
  /**
   * Get all the virtual devices of a virtual machine
   * @return VirtualDevice[]
   */
  public VirtualDevice[] getAllVirtualDevices() 
  {
    VirtualDevice[] devices = (VirtualDevice[]) vm.getPropertyByPath("config.hardware.device");
    return devices;
  }

  @SuppressWarnings("unchecked")
  public <T extends VirtualDevice> List<T> getVirtualDevicesOfType(Class<T> clazz) 
  {
    List<T> result = new ArrayList<T>();
    
    VirtualDevice[] devices = getAllVirtualDevices();
    
    for(VirtualDevice dev : devices)
    {
      if(clazz.isInstance(dev)) // dynamic equivalent of instanceof operator
      {
        result.add((T)dev);
      }
    }
    return result;
  }
  
  public VirtualDevice getDeviceByBackingFileName(String name)
  {
    if(name==null)
    {
      throw new IllegalArgumentException("name must not be null!");
    }
      
    VirtualDevice[] devices = this.getAllVirtualDevices(); 
  
    for(VirtualDevice device : devices)
    {
      VirtualDeviceBackingInfo bi = device.getBacking();
      if(bi instanceof VirtualDeviceFileBackingInfo)
      {
        String fileName = ((VirtualDeviceFileBackingInfo)bi).getFileName();
        if(name.equals(fileName))
          return device;
      }
     }
     return null;
  }
  
  private <T extends VirtualController> T getFirstAvailableController(Class<T> clazz)
  {
    VirtualController vc = createControllerInstance(clazz);
    int maxNodes = getMaxNodesPerControllerOfType(vc);

    for (T controller : getVirtualDevicesOfType(clazz)) 
    {
      // Check if controller can accept addition of new devices.
      if (controller.device == null || controller.device.length < maxNodes) 
      {
        return controller;
      }
    }
    return null;
  }

  private <T extends VirtualController> VirtualController createControllerInstance(Class<T> clazz)
  {
    VirtualController vc = null;
    try
    {
      vc = (T) clazz.newInstance();
    }
    catch (InstantiationException e)
    {
      e.printStackTrace();
    }
    catch (IllegalAccessException e)
    {
      e.printStackTrace();
    }
    return vc;
  }
  
  private static int getMaxNodesPerControllerOfType(VirtualController controller) 
  {
    int count = 0;

    if ( VirtualSCSIController.class.isInstance(controller) )
    {
      // The actual device nodes of SCSI controller are 16
      // but one of them is reserved for the controller itself
      // so this means that the maximum free nodes are 15.
      count = 16;
    }
    else if (VirtualIDEController.class.isInstance(controller)) 
    {
      count = 2;
    }
    else 
    {
      throw new RuntimeException("Unknown controller type - " + controller.getDeviceInfo().getLabel());
    }
    return count;
  }
  
  private boolean allSupportHotRemoval(List<VirtualDevice> devices)
  {
    for(VirtualDevice device : devices)
    {
      if(device instanceof VirtualUSB || device instanceof VirtualDisk)
        return true;
    }
    return false;
  }
  
  /**
   * Enumeration for all the possible network adapter types
   */
  @SuppressWarnings("unused")
  public static enum VirtualNetworkAdapterType
  {
    VirtualE1000 ("VirtualE1000"),
    VirtualPCNet32 ("VirtualPCNet32"),
    VirtualVmxnet ("VirtualVmxnet"),
    VirtualVmxnet2 ("VirtualVmxnet2"),
    VirtualVmxnet3 ("VirtualVmxnet3"),
    Unknown ("Unknown");

    private final String val;
    private VirtualNetworkAdapterType(String val)
    {
      this.val = val;
    }
  }
  
}