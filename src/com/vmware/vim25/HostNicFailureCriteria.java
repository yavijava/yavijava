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

public class HostNicFailureCriteria extends DynamicData
{
  public String checkSpeed;
  public Integer speed;
  public Boolean checkDuplex;
  public Boolean fullDuplex;
  public Boolean checkErrorPercent;
  public Integer percentage;
  public Boolean checkBeacon;

  public String getCheckSpeed()
  {
    return this.checkSpeed;
  }

  public Integer getSpeed()
  {
    return this.speed;
  }

  public Boolean getCheckDuplex()
  {
    return this.checkDuplex;
  }

  public Boolean getFullDuplex()
  {
    return this.fullDuplex;
  }

  public Boolean getCheckErrorPercent()
  {
    return this.checkErrorPercent;
  }

  public Integer getPercentage()
  {
    return this.percentage;
  }

  public Boolean getCheckBeacon()
  {
    return this.checkBeacon;
  }

  public void setCheckSpeed(String checkSpeed)
  {
    this.checkSpeed=checkSpeed;
  }

  public void setSpeed(Integer speed)
  {
    this.speed=speed;
  }

  public void setCheckDuplex(Boolean checkDuplex)
  {
    this.checkDuplex=checkDuplex;
  }

  public void setFullDuplex(Boolean fullDuplex)
  {
    this.fullDuplex=fullDuplex;
  }

  public void setCheckErrorPercent(Boolean checkErrorPercent)
  {
    this.checkErrorPercent=checkErrorPercent;
  }

  public void setPercentage(Integer percentage)
  {
    this.percentage=percentage;
  }

  public void setCheckBeacon(Boolean checkBeacon)
  {
    this.checkBeacon=checkBeacon;
  }
}