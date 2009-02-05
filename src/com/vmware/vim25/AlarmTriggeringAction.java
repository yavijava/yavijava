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

public class AlarmTriggeringAction extends AlarmAction
{
  public Action action;
  public boolean green2yellow;
  public boolean yellow2red;
  public boolean red2yellow;
  public boolean yellow2green;

  public Action getAction()
  {
    return this.action;
  }

  public boolean isGreen2yellow()
  {
    return this.green2yellow;
  }

  public boolean isYellow2red()
  {
    return this.yellow2red;
  }

  public boolean isRed2yellow()
  {
    return this.red2yellow;
  }

  public boolean isYellow2green()
  {
    return this.yellow2green;
  }

  public void setAction(Action action)
  {
    this.action=action;
  }

  public void setGreen2yellow(boolean green2yellow)
  {
    this.green2yellow=green2yellow;
  }

  public void setYellow2red(boolean yellow2red)
  {
    this.yellow2red=yellow2red;
  }

  public void setRed2yellow(boolean red2yellow)
  {
    this.red2yellow=red2yellow;
  }

  public void setYellow2green(boolean yellow2green)
  {
    this.yellow2green=yellow2green;
  }
}