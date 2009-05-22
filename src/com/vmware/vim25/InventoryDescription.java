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

public class InventoryDescription extends DynamicData
{
  public int numHosts;
  public int numVirtualMachines;
  public Integer numResourcePools;
  public Integer numClusters;
  public Integer numCpuDev;
  public Integer numNetDev;
  public Integer numDiskDev;
  public Integer numvCpuDev;
  public Integer numvNetDev;
  public Integer numvDiskDev;

  public int getNumHosts()
  {
    return this.numHosts;
  }

  public int getNumVirtualMachines()
  {
    return this.numVirtualMachines;
  }

  public Integer getNumResourcePools()
  {
    return this.numResourcePools;
  }

  public Integer getNumClusters()
  {
    return this.numClusters;
  }

  public Integer getNumCpuDev()
  {
    return this.numCpuDev;
  }

  public Integer getNumNetDev()
  {
    return this.numNetDev;
  }

  public Integer getNumDiskDev()
  {
    return this.numDiskDev;
  }

  public Integer getNumvCpuDev()
  {
    return this.numvCpuDev;
  }

  public Integer getNumvNetDev()
  {
    return this.numvNetDev;
  }

  public Integer getNumvDiskDev()
  {
    return this.numvDiskDev;
  }

  public void setNumHosts(int numHosts)
  {
    this.numHosts=numHosts;
  }

  public void setNumVirtualMachines(int numVirtualMachines)
  {
    this.numVirtualMachines=numVirtualMachines;
  }

  public void setNumResourcePools(Integer numResourcePools)
  {
    this.numResourcePools=numResourcePools;
  }

  public void setNumClusters(Integer numClusters)
  {
    this.numClusters=numClusters;
  }

  public void setNumCpuDev(Integer numCpuDev)
  {
    this.numCpuDev=numCpuDev;
  }

  public void setNumNetDev(Integer numNetDev)
  {
    this.numNetDev=numNetDev;
  }

  public void setNumDiskDev(Integer numDiskDev)
  {
    this.numDiskDev=numDiskDev;
  }

  public void setNumvCpuDev(Integer numvCpuDev)
  {
    this.numvCpuDev=numvCpuDev;
  }

  public void setNumvNetDev(Integer numvNetDev)
  {
    this.numvNetDev=numvNetDev;
  }

  public void setNumvDiskDev(Integer numvDiskDev)
  {
    this.numvDiskDev=numvDiskDev;
  }
}