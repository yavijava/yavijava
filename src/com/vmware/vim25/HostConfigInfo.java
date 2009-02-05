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

public class HostConfigInfo extends DynamicData
{
  public ManagedObjectReference host;
  public AboutInfo product;
  public HostHyperThreadScheduleInfo hyperThread;
  public ServiceConsoleReservationInfo consoleReservation;
  public VirtualMachineMemoryReservationInfo virtualMachineReservation;
  public HostStorageDeviceInfo storageDevice;
  public HostFileSystemVolumeInfo fileSystemVolume;
  public HostNetworkInfo network;
  public HostVMotionInfo vmotion;
  public HostNetCapabilities capabilities;
  public HostDatastoreSystemCapabilities datastoreCapabilities;
  public HostNetOffloadCapabilities offloadCapabilities;
  public HostServiceInfo service;
  public HostFirewallInfo firewall;
  public HostAutoStartManagerConfig autoStart;
  public HostDiagnosticPartition activeDiagnosticPartition;
  public OptionValue[] option;
  public OptionDef[] optionDef;
  public String datastorePrincipal;
  public ManagedObjectReference localSwapDatastore;
  public HostSystemResourceInfo systemResources;
  public HostDateTimeInfo dateTimeInfo;
  public HostFlagInfo flags;
  public Boolean adminDisabled;

  public ManagedObjectReference getHost()
  {
    return this.host;
  }

  public AboutInfo getProduct()
  {
    return this.product;
  }

  public HostHyperThreadScheduleInfo getHyperThread()
  {
    return this.hyperThread;
  }

  public ServiceConsoleReservationInfo getConsoleReservation()
  {
    return this.consoleReservation;
  }

  public VirtualMachineMemoryReservationInfo getVirtualMachineReservation()
  {
    return this.virtualMachineReservation;
  }

  public HostStorageDeviceInfo getStorageDevice()
  {
    return this.storageDevice;
  }

  public HostFileSystemVolumeInfo getFileSystemVolume()
  {
    return this.fileSystemVolume;
  }

  public HostNetworkInfo getNetwork()
  {
    return this.network;
  }

  public HostVMotionInfo getVmotion()
  {
    return this.vmotion;
  }

  public HostNetCapabilities getCapabilities()
  {
    return this.capabilities;
  }

  public HostDatastoreSystemCapabilities getDatastoreCapabilities()
  {
    return this.datastoreCapabilities;
  }

  public HostNetOffloadCapabilities getOffloadCapabilities()
  {
    return this.offloadCapabilities;
  }

  public HostServiceInfo getService()
  {
    return this.service;
  }

  public HostFirewallInfo getFirewall()
  {
    return this.firewall;
  }

  public HostAutoStartManagerConfig getAutoStart()
  {
    return this.autoStart;
  }

  public HostDiagnosticPartition getActiveDiagnosticPartition()
  {
    return this.activeDiagnosticPartition;
  }

  public OptionValue[] getOption()
  {
    return this.option;
  }

  public OptionDef[] getOptionDef()
  {
    return this.optionDef;
  }

  public String getDatastorePrincipal()
  {
    return this.datastorePrincipal;
  }

  public ManagedObjectReference getLocalSwapDatastore()
  {
    return this.localSwapDatastore;
  }

  public HostSystemResourceInfo getSystemResources()
  {
    return this.systemResources;
  }

  public HostDateTimeInfo getDateTimeInfo()
  {
    return this.dateTimeInfo;
  }

  public HostFlagInfo getFlags()
  {
    return this.flags;
  }

  public Boolean getAdminDisabled()
  {
    return this.adminDisabled;
  }

  public void setHost(ManagedObjectReference host)
  {
    this.host=host;
  }

  public void setProduct(AboutInfo product)
  {
    this.product=product;
  }

  public void setHyperThread(HostHyperThreadScheduleInfo hyperThread)
  {
    this.hyperThread=hyperThread;
  }

  public void setConsoleReservation(ServiceConsoleReservationInfo consoleReservation)
  {
    this.consoleReservation=consoleReservation;
  }

  public void setVirtualMachineReservation(VirtualMachineMemoryReservationInfo virtualMachineReservation)
  {
    this.virtualMachineReservation=virtualMachineReservation;
  }

  public void setStorageDevice(HostStorageDeviceInfo storageDevice)
  {
    this.storageDevice=storageDevice;
  }

  public void setFileSystemVolume(HostFileSystemVolumeInfo fileSystemVolume)
  {
    this.fileSystemVolume=fileSystemVolume;
  }

  public void setNetwork(HostNetworkInfo network)
  {
    this.network=network;
  }

  public void setVmotion(HostVMotionInfo vmotion)
  {
    this.vmotion=vmotion;
  }

  public void setCapabilities(HostNetCapabilities capabilities)
  {
    this.capabilities=capabilities;
  }

  public void setDatastoreCapabilities(HostDatastoreSystemCapabilities datastoreCapabilities)
  {
    this.datastoreCapabilities=datastoreCapabilities;
  }

  public void setOffloadCapabilities(HostNetOffloadCapabilities offloadCapabilities)
  {
    this.offloadCapabilities=offloadCapabilities;
  }

  public void setService(HostServiceInfo service)
  {
    this.service=service;
  }

  public void setFirewall(HostFirewallInfo firewall)
  {
    this.firewall=firewall;
  }

  public void setAutoStart(HostAutoStartManagerConfig autoStart)
  {
    this.autoStart=autoStart;
  }

  public void setActiveDiagnosticPartition(HostDiagnosticPartition activeDiagnosticPartition)
  {
    this.activeDiagnosticPartition=activeDiagnosticPartition;
  }

  public void setOption(OptionValue[] option)
  {
    this.option=option;
  }

  public void setOptionDef(OptionDef[] optionDef)
  {
    this.optionDef=optionDef;
  }

  public void setDatastorePrincipal(String datastorePrincipal)
  {
    this.datastorePrincipal=datastorePrincipal;
  }

  public void setLocalSwapDatastore(ManagedObjectReference localSwapDatastore)
  {
    this.localSwapDatastore=localSwapDatastore;
  }

  public void setSystemResources(HostSystemResourceInfo systemResources)
  {
    this.systemResources=systemResources;
  }

  public void setDateTimeInfo(HostDateTimeInfo dateTimeInfo)
  {
    this.dateTimeInfo=dateTimeInfo;
  }

  public void setFlags(HostFlagInfo flags)
  {
    this.flags=flags;
  }

  public void setAdminDisabled(Boolean adminDisabled)
  {
    this.adminDisabled=adminDisabled;
  }
}