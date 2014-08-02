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
package com.vmware.vim25.mo.samples.network;

import java.net.URL;
import java.rmi.RemoteException;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;

/**
 * http://vijava.sf.net
 * @author Steve Jin (sjin@vmware.com)
 */

public class AddDVS
{
  public static void main(String[] args) throws Exception 
  {
    if(args.length != 3)
    {
      System.out.println("Usage: java AddNIC <url> <username> <password>");
      return;
    }

    ServiceInstance si = new ServiceInstance(new URL(args[0]), args[1], args[2], true);
    
    // find the data center called "pvlan" under the root of inventory
    Datacenter dc = (Datacenter) si.getSearchIndex().findByInventoryPath("pvlan");
    
    DistributedVirtualSwitch dvs = createDVS(dc);

    if(dvs!=null)
    {
      createDVSPortGroup(dvs);
    }
  }

  private static DistributedVirtualSwitch createDVS(Datacenter dc)
      throws InvalidProperty, RuntimeFault, RemoteException,
      DvsNotAuthorized, DvsFault, DuplicateName, InvalidName,
      NotFound, InterruptedException
  {
    Folder netFolder = dc.getNetworkFolder();

    DVSCreateSpec dcs = new DVSCreateSpec();
    DVSConfigSpec dcfg = new DVSConfigSpec();
    dcs.setConfigSpec(dcfg);
    dcfg.setName("MyDVS");
    
    DVSNameArrayUplinkPortPolicy dvsUplink = new DVSNameArrayUplinkPortPolicy();
    dvsUplink.setUplinkPortName(new String[] {"dvUplink1", "dvUplink2", "dvUplink3"});
    dcfg.setUplinkPortPolicy(dvsUplink);
    
    ManagedEntity[] hosts = new InventoryNavigator(dc).searchManagedEntities("HostSystem");

    DistributedVirtualSwitchHostMemberConfigSpec[] dvsHosts
    = new DistributedVirtualSwitchHostMemberConfigSpec[hosts.length];
    dcfg.setHost(dvsHosts);
    
    for(int i=0; i<hosts.length; i++)
    {
      dvsHosts[i] = new DistributedVirtualSwitchHostMemberConfigSpec();
      dvsHosts[i].setOperation("add");
      dvsHosts[i].setHost(hosts[i].getMOR());
      
      DistributedVirtualSwitchHostMemberPnicBacking dvsPnic = 
        new DistributedVirtualSwitchHostMemberPnicBacking();
      
      PhysicalNic[] pnics = ((HostSystem)hosts[i]).getConfig().getNetwork().getPnic();
      
      DistributedVirtualSwitchHostMemberPnicSpec[] pnicSpecs =
        new DistributedVirtualSwitchHostMemberPnicSpec[pnics.length];
      
      for(int j=0; j<pnics.length; j++)
      {
        pnicSpecs[j] = new DistributedVirtualSwitchHostMemberPnicSpec();
        pnicSpecs[j].setPnicDevice(pnics[j].getDevice());
      }
      dvsPnic.setPnicSpec(pnicSpecs);
    }
    
    Task task = netFolder.createDVS_Task(dcs);
    TaskInfo ti = waitFor(task);
    
    if(ti.getState() == TaskInfoState.error)
    {
      System.out.println("Failed to create a new DVS.");
      return null;
    }

    System.out.println("A new DVS has been created successfully.");
    ManagedObjectReference dvsMor = (ManagedObjectReference) ti.getResult();
    DistributedVirtualSwitch dvs = (DistributedVirtualSwitch)
      MorUtil.createExactManagedEntity(dc.getServerConnection(), dvsMor);
    return dvs;
  }

  private static  DistributedVirtualPortgroup createDVSPortGroup(DistributedVirtualSwitch dvs) 
    throws DvsFault, DuplicateName, InvalidName, RuntimeFault, RemoteException, InterruptedException
  {
    // create port group under this DVS
    DVPortgroupConfigSpec[] dvpgs = new DVPortgroupConfigSpec[1];
    dvpgs[0] = new DVPortgroupConfigSpec();
    dvpgs[0].setName("dvPortGroup10");
    dvpgs[0].setNumPorts(128);
    dvpgs[0].setType("earlyBinding");
    VMwareDVSPortSetting vport = new VMwareDVSPortSetting();
    dvpgs[0].setDefaultPortConfig(vport);
    
    VmwareDistributedVirtualSwitchVlanIdSpec vlan = 
      new VmwareDistributedVirtualSwitchVlanIdSpec();
    vport.setVlan(vlan);
    vlan.setInherited(false);
    vlan.setVlanId(0);
    Task task_pg = dvs.addDVPortgroup_Task(dvpgs);

    TaskInfo ti = waitFor(task_pg);
    
    if(ti.getState() == TaskInfoState.error)
    {
      System.out.println("Failed to create a new DVS.");
      return null;
    }
    System.out.println("A new DVS port group has been created successfully.");
    ManagedObjectReference pgMor = (ManagedObjectReference) ti.getResult();
    DistributedVirtualPortgroup pg = (DistributedVirtualPortgroup)
      MorUtil.createExactManagedEntity(dvs.getServerConnection(), pgMor);
    return pg;
  }
  
  private static TaskInfo waitFor(Task task) throws RemoteException, InterruptedException 
  {
    while(true)
    {
      TaskInfo ti = task.getTaskInfo();
      TaskInfoState state = ti.getState();
      if(state == TaskInfoState.success || state == TaskInfoState.error)
      {
        return ti;
      }
      Thread.sleep(1000);
    }
  }
}