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

package com.vmware.vim.rest.sample;

import java.io.StringReader;
import java.util.Hashtable;
import java.util.Map;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.xml.sax.InputSource;

import com.vmware.vim.rest.CachedManagedObject;
import com.vmware.vim.rest.RestClient;
import com.vmware.vim.rest.RestManagedObject;

public class RestAppDemo
{
  public static void main(String[] args) throws Exception
  {
    RestClient rc = new RestClient("https://8.8.8.8", "root", "pass");
    runRestLevel(rc);
    runMOLevel(rc);
  }

  public static void runMOLevel(RestClient rc) throws Exception
  {
    
    RestManagedObject si = new RestManagedObject(rc, "ServiceInstance");

    System.out.println("name:" + si.getPropertyAsString("content.about.fullName"));
    System.out.println(si.invoke("currentTime"));
    System.out.println(si.invoke("retrieveContent"));

    String allXml = si.getAllProperties();
    System.out.println(allXml);
    CachedManagedObject csi = new CachedManagedObject(allXml);
    System.out.println("name:" + csi.getProperty("content.about.fullName"));
    System.out.println("root:" + csi.getProperty("content.rootFolder"));
    System.out.println("cap:" + si.getPropertyAsString("capability.multiHostSupported"));
    
    String em_id = si.getPropertyAsString("content.eventManager");
    RestManagedObject eventMgr = new RestManagedObject(rc, em_id); 
    System.out.println("latest evt:" + eventMgr.getPropertyAsString("latest.fullFormattedMessage"));
    
    RestManagedObject vm = new RestManagedObject(rc, "48");
    System.out.println("reload:" + vm.invoke("reload"));
    CachedManagedObject cvm = new CachedManagedObject(vm.getAllProperties());
    System.out.println("Roles:" + cvm.getProperty("effectiveRole"));
  }
  
  public static void runRestLevel(RestClient rc) throws Exception
  {
    String contentXml = rc.get("moid=ServiceInstance&doPath=content");
    System.out.println(contentXml);
    
    XPath xpath = XPathFactory.newInstance().newXPath();
    String emMOR = xpath.evaluate("//eventManager/text()", new InputSource(new StringReader(contentXml)));
    System.out.println("view:" + emMOR);
    String lastEventXml = rc.get("moid=" + emMOR + "&doPath=latestEvent");
    xpath.reset();
    String eMessage = xpath.evaluate("//fullFormattedMessage/text()", new InputSource(new StringReader(lastEventXml)));
    System.out.println("Latest Event: " + eMessage);

    System.out.println(rc.get(null));
    System.out.println(rc.get("?moid=ServiceInstance&doPath=content%2eabout"));
    long start = System.currentTimeMillis();
    System.out.println(rc.get("?moid=48"));
    long end = System.currentTimeMillis();
    System.out.println("time taken:" + (end-start));
    Map<String, String> para = new Hashtable<String, String>();
    para.put("newName", "Melody_SuSe");
    System.out.println(rc.post("moid=48&method=rename", para));
    Map<String, String> para1 = new Hashtable<String, String>();
    System.out.println(rc.post("http://10.20.143.205/mob/?moid=48&method=acquireMksTicket", para1));
  }
}
