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

public class OvfValidateHostResult extends DynamicData
{
  public Long downloadSize;
  public Long flatDeploymentSize;
  public Long sparseDeploymentSize;
  public LocalizedMethodFault[] error;
  public LocalizedMethodFault[] warning;
  public String[] supportedDiskProvisioning;

  public Long getDownloadSize()
  {
    return this.downloadSize;
  }

  public Long getFlatDeploymentSize()
  {
    return this.flatDeploymentSize;
  }

  public Long getSparseDeploymentSize()
  {
    return this.sparseDeploymentSize;
  }

  public LocalizedMethodFault[] getError()
  {
    return this.error;
  }

  public LocalizedMethodFault[] getWarning()
  {
    return this.warning;
  }

  public String[] getSupportedDiskProvisioning()
  {
    return this.supportedDiskProvisioning;
  }

  public void setDownloadSize(Long downloadSize)
  {
    this.downloadSize=downloadSize;
  }

  public void setFlatDeploymentSize(Long flatDeploymentSize)
  {
    this.flatDeploymentSize=flatDeploymentSize;
  }

  public void setSparseDeploymentSize(Long sparseDeploymentSize)
  {
    this.sparseDeploymentSize=sparseDeploymentSize;
  }

  public void setError(LocalizedMethodFault[] error)
  {
    this.error=error;
  }

  public void setWarning(LocalizedMethodFault[] warning)
  {
    this.warning=warning;
  }

  public void setSupportedDiskProvisioning(String[] supportedDiskProvisioning)
  {
    this.supportedDiskProvisioning=supportedDiskProvisioning;
  }
}