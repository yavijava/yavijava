/*================================================================================
Copyright (c) 2009 VMware, Inc. All Rights Reserved.

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

package com.vmware.vim25;

/**
@author Steve Jin (sjin@vmware.com)
*/

public class ConfigTarget extends DynamicData
{
  public int numCpus;
  public int numCpuCores;
  public int numNumaNodes;
  public VirtualMachineDatastoreInfo[] datastore;
  public VirtualMachineNetworkInfo[] network;
  public DistributedVirtualPortgroupInfo[] distributedVirtualPortgroup;
  public DistributedVirtualSwitchInfo[] distributedVirtualSwitch;
  public VirtualMachineCdromInfo[] cdRom;
  public VirtualMachineSerialInfo[] serial;
  public VirtualMachineParallelInfo[] parallel;
  public VirtualMachineSoundInfo[] sound;
  public VirtualMachineUsbInfo[] usb;
  public VirtualMachineFloppyInfo[] floppy;
  public VirtualMachineLegacyNetworkSwitchInfo[] legacyNetworkInfo;
  public VirtualMachineScsiPassthroughInfo[] scsiPassthrough;
  public VirtualMachineScsiDiskDeviceInfo[] scsiDisk;
  public VirtualMachineIdeDiskDeviceInfo[] ideDisk;
  public int maxMemMBOptimalPerf;
  public ResourcePoolRuntimeInfo resourcePool;
  public Boolean autoVmotion;
  public VirtualMachinePciPassthroughInfo[] pciPassthrough;

  public int getNumCpus()
  {
    return this.numCpus;
  }

  public int getNumCpuCores()
  {
    return this.numCpuCores;
  }

  public int getNumNumaNodes()
  {
    return this.numNumaNodes;
  }

  public VirtualMachineDatastoreInfo[] getDatastore()
  {
    return this.datastore;
  }

  public VirtualMachineNetworkInfo[] getNetwork()
  {
    return this.network;
  }

  public DistributedVirtualPortgroupInfo[] getDistributedVirtualPortgroup()
  {
    return this.distributedVirtualPortgroup;
  }

  public DistributedVirtualSwitchInfo[] getDistributedVirtualSwitch()
  {
    return this.distributedVirtualSwitch;
  }

  public VirtualMachineCdromInfo[] getCdRom()
  {
    return this.cdRom;
  }

  public VirtualMachineSerialInfo[] getSerial()
  {
    return this.serial;
  }

  public VirtualMachineParallelInfo[] getParallel()
  {
    return this.parallel;
  }

  public VirtualMachineSoundInfo[] getSound()
  {
    return this.sound;
  }

  public VirtualMachineUsbInfo[] getUsb()
  {
    return this.usb;
  }

  public VirtualMachineFloppyInfo[] getFloppy()
  {
    return this.floppy;
  }

  public VirtualMachineLegacyNetworkSwitchInfo[] getLegacyNetworkInfo()
  {
    return this.legacyNetworkInfo;
  }

  public VirtualMachineScsiPassthroughInfo[] getScsiPassthrough()
  {
    return this.scsiPassthrough;
  }

  public VirtualMachineScsiDiskDeviceInfo[] getScsiDisk()
  {
    return this.scsiDisk;
  }

  public VirtualMachineIdeDiskDeviceInfo[] getIdeDisk()
  {
    return this.ideDisk;
  }

  public int getMaxMemMBOptimalPerf()
  {
    return this.maxMemMBOptimalPerf;
  }

  public ResourcePoolRuntimeInfo getResourcePool()
  {
    return this.resourcePool;
  }

  public Boolean getAutoVmotion()
  {
    return this.autoVmotion;
  }

  public VirtualMachinePciPassthroughInfo[] getPciPassthrough()
  {
    return this.pciPassthrough;
  }

  public void setNumCpus(int numCpus)
  {
    this.numCpus=numCpus;
  }

  public void setNumCpuCores(int numCpuCores)
  {
    this.numCpuCores=numCpuCores;
  }

  public void setNumNumaNodes(int numNumaNodes)
  {
    this.numNumaNodes=numNumaNodes;
  }

  public void setDatastore(VirtualMachineDatastoreInfo[] datastore)
  {
    this.datastore=datastore;
  }

  public void setNetwork(VirtualMachineNetworkInfo[] network)
  {
    this.network=network;
  }

  public void setDistributedVirtualPortgroup(DistributedVirtualPortgroupInfo[] distributedVirtualPortgroup)
  {
    this.distributedVirtualPortgroup=distributedVirtualPortgroup;
  }

  public void setDistributedVirtualSwitch(DistributedVirtualSwitchInfo[] distributedVirtualSwitch)
  {
    this.distributedVirtualSwitch=distributedVirtualSwitch;
  }

  public void setCdRom(VirtualMachineCdromInfo[] cdRom)
  {
    this.cdRom=cdRom;
  }

  public void setSerial(VirtualMachineSerialInfo[] serial)
  {
    this.serial=serial;
  }

  public void setParallel(VirtualMachineParallelInfo[] parallel)
  {
    this.parallel=parallel;
  }

  public void setSound(VirtualMachineSoundInfo[] sound)
  {
    this.sound=sound;
  }

  public void setUsb(VirtualMachineUsbInfo[] usb)
  {
    this.usb=usb;
  }

  public void setFloppy(VirtualMachineFloppyInfo[] floppy)
  {
    this.floppy=floppy;
  }

  public void setLegacyNetworkInfo(VirtualMachineLegacyNetworkSwitchInfo[] legacyNetworkInfo)
  {
    this.legacyNetworkInfo=legacyNetworkInfo;
  }

  public void setScsiPassthrough(VirtualMachineScsiPassthroughInfo[] scsiPassthrough)
  {
    this.scsiPassthrough=scsiPassthrough;
  }

  public void setScsiDisk(VirtualMachineScsiDiskDeviceInfo[] scsiDisk)
  {
    this.scsiDisk=scsiDisk;
  }

  public void setIdeDisk(VirtualMachineIdeDiskDeviceInfo[] ideDisk)
  {
    this.ideDisk=ideDisk;
  }

  public void setMaxMemMBOptimalPerf(int maxMemMBOptimalPerf)
  {
    this.maxMemMBOptimalPerf=maxMemMBOptimalPerf;
  }

  public void setResourcePool(ResourcePoolRuntimeInfo resourcePool)
  {
    this.resourcePool=resourcePool;
  }

  public void setAutoVmotion(Boolean autoVmotion)
  {
    this.autoVmotion=autoVmotion;
  }

  public void setPciPassthrough(VirtualMachinePciPassthroughInfo[] pciPassthrough)
  {
    this.pciPassthrough=pciPassthrough;
  }
}