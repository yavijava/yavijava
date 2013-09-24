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
public class StorageMigrationAction extends ClusterAction {
  public ManagedObjectReference vm;
  public VirtualMachineRelocateSpec relocateSpec;
  public ManagedObjectReference source;
  public ManagedObjectReference destination;
  public long sizeTransferred;
  public Float spaceUtilSrcBefore;
  public Float spaceUtilDstBefore;
  public Float spaceUtilSrcAfter;
  public Float spaceUtilDstAfter;
  public Float ioLatencySrcBefore;
  public Float ioLatencyDstBefore;

  public ManagedObjectReference getVm() {
    return this.vm;
  }

  public VirtualMachineRelocateSpec getRelocateSpec() {
    return this.relocateSpec;
  }

  public ManagedObjectReference getSource() {
    return this.source;
  }

  public ManagedObjectReference getDestination() {
    return this.destination;
  }

  public long getSizeTransferred() {
    return this.sizeTransferred;
  }

  public Float getSpaceUtilSrcBefore() {
    return this.spaceUtilSrcBefore;
  }

  public Float getSpaceUtilDstBefore() {
    return this.spaceUtilDstBefore;
  }

  public Float getSpaceUtilSrcAfter() {
    return this.spaceUtilSrcAfter;
  }

  public Float getSpaceUtilDstAfter() {
    return this.spaceUtilDstAfter;
  }

  public Float getIoLatencySrcBefore() {
    return this.ioLatencySrcBefore;
  }

  public Float getIoLatencyDstBefore() {
    return this.ioLatencyDstBefore;
  }

  public void setVm(ManagedObjectReference vm) {
    this.vm=vm;
  }

  public void setRelocateSpec(VirtualMachineRelocateSpec relocateSpec) {
    this.relocateSpec=relocateSpec;
  }

  public void setSource(ManagedObjectReference source) {
    this.source=source;
  }

  public void setDestination(ManagedObjectReference destination) {
    this.destination=destination;
  }

  public void setSizeTransferred(long sizeTransferred) {
    this.sizeTransferred=sizeTransferred;
  }

  public void setSpaceUtilSrcBefore(Float spaceUtilSrcBefore) {
    this.spaceUtilSrcBefore=spaceUtilSrcBefore;
  }

  public void setSpaceUtilDstBefore(Float spaceUtilDstBefore) {
    this.spaceUtilDstBefore=spaceUtilDstBefore;
  }

  public void setSpaceUtilSrcAfter(Float spaceUtilSrcAfter) {
    this.spaceUtilSrcAfter=spaceUtilSrcAfter;
  }

  public void setSpaceUtilDstAfter(Float spaceUtilDstAfter) {
    this.spaceUtilDstAfter=spaceUtilDstAfter;
  }

  public void setIoLatencySrcBefore(Float ioLatencySrcBefore) {
    this.ioLatencySrcBefore=ioLatencySrcBefore;
  }

  public void setIoLatencyDstBefore(Float ioLatencyDstBefore) {
    this.ioLatencyDstBefore=ioLatencyDstBefore;
  }
}