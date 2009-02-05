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

public class HostNatServiceNameServiceSpec extends DynamicData
{
  public boolean dnsAutoDetect;
  public String dnsPolicy;
  public int dnsRetries;
  public int dnsTimeout;
  public String[] dnsNameServer;
  public int nbdsTimeout;
  public int nbnsRetries;
  public int nbnsTimeout;

  public boolean isDnsAutoDetect()
  {
    return this.dnsAutoDetect;
  }

  public String getDnsPolicy()
  {
    return this.dnsPolicy;
  }

  public int getDnsRetries()
  {
    return this.dnsRetries;
  }

  public int getDnsTimeout()
  {
    return this.dnsTimeout;
  }

  public String[] getDnsNameServer()
  {
    return this.dnsNameServer;
  }

  public int getNbdsTimeout()
  {
    return this.nbdsTimeout;
  }

  public int getNbnsRetries()
  {
    return this.nbnsRetries;
  }

  public int getNbnsTimeout()
  {
    return this.nbnsTimeout;
  }

  public void setDnsAutoDetect(boolean dnsAutoDetect)
  {
    this.dnsAutoDetect=dnsAutoDetect;
  }

  public void setDnsPolicy(String dnsPolicy)
  {
    this.dnsPolicy=dnsPolicy;
  }

  public void setDnsRetries(int dnsRetries)
  {
    this.dnsRetries=dnsRetries;
  }

  public void setDnsTimeout(int dnsTimeout)
  {
    this.dnsTimeout=dnsTimeout;
  }

  public void setDnsNameServer(String[] dnsNameServer)
  {
    this.dnsNameServer=dnsNameServer;
  }

  public void setNbdsTimeout(int nbdsTimeout)
  {
    this.nbdsTimeout=nbdsTimeout;
  }

  public void setNbnsRetries(int nbnsRetries)
  {
    this.nbnsRetries=nbnsRetries;
  }

  public void setNbnsTimeout(int nbnsTimeout)
  {
    this.nbnsTimeout=nbnsTimeout;
  }
}