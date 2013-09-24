/*================================================================================
Copyright (c) 2013 Steve Jin. All Rights Reserved.

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
* @author Steve Jin (http://www.doublecloud.org)
* @version 5.1
*/

@SuppressWarnings("all")
public class VirtualHardware extends DynamicData {
  public int numCPU;
  public Integer numCoresPerSocket;
  public int memoryMB;
  public Boolean virtualICH7MPresent;
  public Boolean virtualSMCPresent;
  public VirtualDevice[] device;

  public int getNumCPU() {
    return this.numCPU;
  }

  public Integer getNumCoresPerSocket() {
    return this.numCoresPerSocket;
  }

  public int getMemoryMB() {
    return this.memoryMB;
  }

  public Boolean getVirtualICH7MPresent() {
    return this.virtualICH7MPresent;
  }

  public Boolean getVirtualSMCPresent() {
    return this.virtualSMCPresent;
  }

  public VirtualDevice[] getDevice() {
    return this.device;
  }

  public void setNumCPU(int numCPU) {
    this.numCPU=numCPU;
  }

  public void setNumCoresPerSocket(Integer numCoresPerSocket) {
    this.numCoresPerSocket=numCoresPerSocket;
  }

  public void setMemoryMB(int memoryMB) {
    this.memoryMB=memoryMB;
  }

  public void setVirtualICH7MPresent(Boolean virtualICH7MPresent) {
    this.virtualICH7MPresent=virtualICH7MPresent;
  }

  public void setVirtualSMCPresent(Boolean virtualSMCPresent) {
    this.virtualSMCPresent=virtualSMCPresent;
  }

  public void setDevice(VirtualDevice[] device) {
    this.device=device;
  }
}