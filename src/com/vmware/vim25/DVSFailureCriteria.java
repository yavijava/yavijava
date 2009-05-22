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

public class DVSFailureCriteria extends InheritablePolicy
{
  public StringPolicy checkSpeed;
  public IntPolicy speed;
  public BoolPolicy checkDuplex;
  public BoolPolicy fullDuplex;
  public BoolPolicy checkErrorPercent;
  public IntPolicy percentage;
  public BoolPolicy checkBeacon;

  public StringPolicy getCheckSpeed()
  {
    return this.checkSpeed;
  }

  public IntPolicy getSpeed()
  {
    return this.speed;
  }

  public BoolPolicy getCheckDuplex()
  {
    return this.checkDuplex;
  }

  public BoolPolicy getFullDuplex()
  {
    return this.fullDuplex;
  }

  public BoolPolicy getCheckErrorPercent()
  {
    return this.checkErrorPercent;
  }

  public IntPolicy getPercentage()
  {
    return this.percentage;
  }

  public BoolPolicy getCheckBeacon()
  {
    return this.checkBeacon;
  }

  public void setCheckSpeed(StringPolicy checkSpeed)
  {
    this.checkSpeed=checkSpeed;
  }

  public void setSpeed(IntPolicy speed)
  {
    this.speed=speed;
  }

  public void setCheckDuplex(BoolPolicy checkDuplex)
  {
    this.checkDuplex=checkDuplex;
  }

  public void setFullDuplex(BoolPolicy fullDuplex)
  {
    this.fullDuplex=fullDuplex;
  }

  public void setCheckErrorPercent(BoolPolicy checkErrorPercent)
  {
    this.checkErrorPercent=checkErrorPercent;
  }

  public void setPercentage(IntPolicy percentage)
  {
    this.percentage=percentage;
  }

  public void setCheckBeacon(BoolPolicy checkBeacon)
  {
    this.checkBeacon=checkBeacon;
  }
}