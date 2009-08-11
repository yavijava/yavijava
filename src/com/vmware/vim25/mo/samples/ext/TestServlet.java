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

package com.vmware.vim25.mo.samples.ext;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.util.MorUtil;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class TestServlet extends HttpServlet 
{
  public final static String MOREF = "moref";
  public final static String SESSION_ID = "sessionId";
  public final static String SERVICE_URL = "serviceUrl";
  public final static String LOCALE = "locale";

  protected void service(
      HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException 
  {
    PrintWriter out = response.getWriter();

    String morStr = request.getParameter(MOREF);
    String type = morStr.substring(0, morStr.indexOf(":"));
    String value = morStr.substring(morStr.indexOf(":")+1);

    ManagedObjectReference mor = new ManagedObjectReference();
    mor.setType(type);
    mor.set_value(value);

    String sessionStr = "vmware_soap_session=\"" 
      + request.getParameter(SESSION_ID) + "\"";

    System.out.println("morStr:" + morStr);
    System.out.println("serviceUrl" 
        + request.getParameter(SERVICE_URL) );
    System.out.println("session:" + sessionStr);

    ServiceInstance si = new ServiceInstance(new URL(
        request.getParameter(SERVICE_URL)),sessionStr, true);

    ManagedEntity me = MorUtil.createExactManagedEntity(
        si.getServerConnection(), mor);

    String name = me.getName();
    out.println("name:" + name);
    out.println(DateFormat.getDateTimeInstance().format(
        new Date()));
  }

}
