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
import java.util.Calendar;

/**
@author Steve Jin (sjin@vmware.com)
*/

public class VirtualMachineSnapshotTree extends DynamicData
{
  public ManagedObjectReference snapshot;
  public ManagedObjectReference vm;
  public String name;
  public String description;
  public Integer id;
  public Calendar createTime;
  public VirtualMachinePowerState state;
  public boolean quiesced;
  public String backupManifest;
  public VirtualMachineSnapshotTree[] childSnapshotList;
  public Boolean replaySupported;

  public ManagedObjectReference getSnapshot()
  {
    return this.snapshot;
  }

  public ManagedObjectReference getVm()
  {
    return this.vm;
  }

  public String getName()
  {
    return this.name;
  }

  public String getDescription()
  {
    return this.description;
  }

  public Integer getId()
  {
    return this.id;
  }

  public Calendar getCreateTime()
  {
    return this.createTime;
  }

  public VirtualMachinePowerState getState()
  {
    return this.state;
  }

  public boolean isQuiesced()
  {
    return this.quiesced;
  }

  public String getBackupManifest()
  {
    return this.backupManifest;
  }

  public VirtualMachineSnapshotTree[] getChildSnapshotList()
  {
    return this.childSnapshotList;
  }

  public Boolean getReplaySupported()
  {
    return this.replaySupported;
  }

  public void setSnapshot(ManagedObjectReference snapshot)
  {
    this.snapshot=snapshot;
  }

  public void setVm(ManagedObjectReference vm)
  {
    this.vm=vm;
  }

  public void setName(String name)
  {
    this.name=name;
  }

  public void setDescription(String description)
  {
    this.description=description;
  }

  public void setId(Integer id)
  {
    this.id=id;
  }

  public void setCreateTime(Calendar createTime)
  {
    this.createTime=createTime;
  }

  public void setState(VirtualMachinePowerState state)
  {
    this.state=state;
  }

  public void setQuiesced(boolean quiesced)
  {
    this.quiesced=quiesced;
  }

  public void setBackupManifest(String backupManifest)
  {
    this.backupManifest=backupManifest;
  }

  public void setChildSnapshotList(VirtualMachineSnapshotTree[] childSnapshotList)
  {
    this.childSnapshotList=childSnapshotList;
  }

  public void setReplaySupported(Boolean replaySupported)
  {
    this.replaySupported=replaySupported;
  }
}