/*================================================================================
Copyright (c) 2008 VMware, Inc. All Rights Reserved.

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

package com.vmware.vim25.mo.samples;

import java.net.URL;
import java.util.Enumeration;

import org.sblim.wbem.cim.CIMNameSpace;
import org.sblim.wbem.cim.CIMObject;
import org.sblim.wbem.cim.CIMObjectPath;
import org.sblim.wbem.client.CIMClient;
import org.sblim.wbem.client.PasswordCredential;
import org.sblim.wbem.client.UserPrincipal;

import com.vmware.vim25.HostServiceTicket;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.HostSystem;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */
public class CimTicket 
{
  public static void main(String[] args) throws Exception
  {
    if(args.length!=3)
    {
      System.out.println("Usage: java CimTicket <url> " +
      		"<username> <password>");
      return;
    }
    String urlStr = args[0];
    String username = args[1];
    String password = args[2];

    ServiceInstance si = new ServiceInstance(new URL(urlStr),
        username, password, true);
    Folder rootFolder = si.getRootFolder();

    HostSystem host = (HostSystem) new InventoryNavigator(
        rootFolder).searchManagedEntities("HostSystem")[0];

    System.out.println(host.getName());
    HostServiceTicket ticket = host.acquireCimServicesTicket();
    System.out.println("\nHost Name:" + ticket.getHost());
    System.out.println("sessionId=" + ticket.getSessionId());
    System.out.println("sslThumpprint=" 
        + ticket.getSslThumbprint());
    System.out.println("serviceVersion=" 
        + ticket.getServiceVersion());
    System.out.println("service=" + ticket.getService());
    System.out.println("port=" + ticket.getPort());

    retrieveCimInfo(urlStr, ticket.getSessionId());

    si.getServerConnection().logout();
  }

  private static void retrieveCimInfo(
      String urlStr, String sessionId)
  {
    String serverUrl = urlStr.substring(0, 
        urlStr.lastIndexOf("/sdk"));
    String cimAgentAddress = serverUrl + ":5989";
    String namespace = "root/cimv2";
    UserPrincipal userPr = new UserPrincipal(sessionId);
    PasswordCredential pwCred = new PasswordCredential(
        sessionId.toCharArray());

    CIMNameSpace ns = new CIMNameSpace(
        cimAgentAddress, namespace);
    CIMClient cimClient = new CIMClient(ns, userPr, pwCred);
    CIMObjectPath rpCOP = new CIMObjectPath(
        "CIM_RegisteredProfile");

    System.out.println("Looking for children of " +
    		"CIM_RegisteredProfile");

    long enumerationStart = System.currentTimeMillis();
    Enumeration rpEnm = cimClient.enumerateInstances(rpCOP);
    long enumerationStop = System.currentTimeMillis();
    System.out.println("Enumeration completed in: " + 
      (enumerationStop - enumerationStart) / 1000 + " sec.\n");

    while (rpEnm.hasMoreElements()) 
    {
      CIMObject rp = (CIMObject) rpEnm.nextElement();
      System.out.println(" Found: " + rp);
    }
  }
}
