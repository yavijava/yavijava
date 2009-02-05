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

public class PerfQuerySpec extends DynamicData
{
  public ManagedObjectReference entity;
  public java.util.Calendar startTime;
  public java.util.Calendar endTime;
  public Integer maxSample;
  public PerfMetricId[] metricId;
  public Integer intervalId;
  public String format;

  public ManagedObjectReference getEntity()
  {
    return this.entity;
  }

  public java.util.Calendar getStartTime()
  {
    return this.startTime;
  }

  public java.util.Calendar getEndTime()
  {
    return this.endTime;
  }

  public Integer getMaxSample()
  {
    return this.maxSample;
  }

  public PerfMetricId[] getMetricId()
  {
    return this.metricId;
  }

  public Integer getIntervalId()
  {
    return this.intervalId;
  }

  public String getFormat()
  {
    return this.format;
  }

  public void setEntity(ManagedObjectReference entity)
  {
    this.entity=entity;
  }

  public void setStartTime(java.util.Calendar startTime)
  {
    this.startTime=startTime;
  }

  public void setEndTime(java.util.Calendar endTime)
  {
    this.endTime=endTime;
  }

  public void setMaxSample(Integer maxSample)
  {
    this.maxSample=maxSample;
  }

  public void setMetricId(PerfMetricId[] metricId)
  {
    this.metricId=metricId;
  }

  public void setIntervalId(Integer intervalId)
  {
    this.intervalId=intervalId;
  }

  public void setFormat(String format)
  {
    this.format=format;
  }
}