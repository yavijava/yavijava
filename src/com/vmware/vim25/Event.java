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

public class Event extends DynamicData
{
  public int key;
  public int chainId;
  public Calendar createdTime;
  public String userName;
  public DatacenterEventArgument datacenter;
  public ComputeResourceEventArgument computeResource;
  public HostEventArgument host;
  public VmEventArgument vm;
  public DatastoreEventArgument ds;
  public NetworkEventArgument net;
  public DvsEventArgument dvs;
  public String fullFormattedMessage;
  public String changeTag;

  public int getKey()
  {
    return this.key;
  }

  public int getChainId()
  {
    return this.chainId;
  }

  public Calendar getCreatedTime()
  {
    return this.createdTime;
  }

  public String getUserName()
  {
    return this.userName;
  }

  public DatacenterEventArgument getDatacenter()
  {
    return this.datacenter;
  }

  public ComputeResourceEventArgument getComputeResource()
  {
    return this.computeResource;
  }

  public HostEventArgument getHost()
  {
    return this.host;
  }

  public VmEventArgument getVm()
  {
    return this.vm;
  }

  public DatastoreEventArgument getDs()
  {
    return this.ds;
  }

  public NetworkEventArgument getNet()
  {
    return this.net;
  }

  public DvsEventArgument getDvs()
  {
    return this.dvs;
  }

  public String getFullFormattedMessage()
  {
    return this.fullFormattedMessage;
  }

  public String getChangeTag()
  {
    return this.changeTag;
  }

  public void setKey(int key)
  {
    this.key=key;
  }

  public void setChainId(int chainId)
  {
    this.chainId=chainId;
  }

  public void setCreatedTime(Calendar createdTime)
  {
    this.createdTime=createdTime;
  }

  public void setUserName(String userName)
  {
    this.userName=userName;
  }

  public void setDatacenter(DatacenterEventArgument datacenter)
  {
    this.datacenter=datacenter;
  }

  public void setComputeResource(ComputeResourceEventArgument computeResource)
  {
    this.computeResource=computeResource;
  }

  public void setHost(HostEventArgument host)
  {
    this.host=host;
  }

  public void setVm(VmEventArgument vm)
  {
    this.vm=vm;
  }

  public void setDs(DatastoreEventArgument ds)
  {
    this.ds=ds;
  }

  public void setNet(NetworkEventArgument net)
  {
    this.net=net;
  }

  public void setDvs(DvsEventArgument dvs)
  {
    this.dvs=dvs;
  }

  public void setFullFormattedMessage(String fullFormattedMessage)
  {
    this.fullFormattedMessage=fullFormattedMessage;
  }

  public void setChangeTag(String changeTag)
  {
    this.changeTag=changeTag;
  }
}