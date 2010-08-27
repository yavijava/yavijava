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

package com.vmware.vim25.mo.util;

import java.net.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.io.*;
import javax.net.ssl.*;
import java.security.cert.*;

/** The returned XML data is in the following format:
 *
 *<pre>
 *<?xml version="1.0" encoding="UTF-8" ?>
 * <!--
 * Copyright 2005-2007 VMware, Inc.  All rights reserved.
 * -->
 *<definitions targetNamespace="urn:vim25Service"
 *  xmlns="http://schemas.xmlsoap.org/wsdl/"
 *  xmlns:soap="http://schemas.xmlsoap.org/wsdl/soap/"
 *  xmlns:interface="urn:vim25"
 *   >
 *  <import location="vim.wsdl" namespace="urn:vim25" />
 *  <service name="VimService">
 *     <port binding="interface:VimBinding" name="VimPort">
 *        <soap:address location="https://localhost/sdk/vimService" />
 *     </port>
 *  </service>
 * </definitions>
 * </pre>
 * 
 * Utility class for checking the version of VISDK the server supports.
 * @author Steve JIN (sjin@vmware.com)
 */
public class VerUtil 
{
	/**
	 * Retrieve the target server's name space
	 * @param target, either IP or host name
	 * @return the namespace, e.g. urn:vim25Service
	 * @throws IOException when there is a network issue or service issue on the target server
	 * @throws RuntimeException wrapping NoSuchAlgorithmException, KeyManagementException which are
	 *         not likely to happen. If it happens, you can catch the runtime exception and unwrapp it
	 *         for the real exceptions.
	 */
  public static String getTargetNameSpace(String target) throws IOException 
  {
    String version = "";
    String urlStr = "https://"+ target + "/sdk/vimService?wsdl";

    try
    {
      trustAllHttpsCertificates();
    } catch(Exception e)
    {
      throw new RuntimeException(e);
    }
    
    HttpsURLConnection.setDefaultHostnameVerifier(
  	    new HostnameVerifier() {
  	      public boolean verify(String urlHostName, SSLSession session) 
  	      {
  	    	  return true;
  	      }
  	});
  	  
    URL url = new URL(urlStr);
    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
    conn.connect();
    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
  	  
    String xmlWSDL = "";
    String line;
    while (( line = in.readLine()) != null) 
    {
      xmlWSDL = xmlWSDL + line;
    }
       
    int start = xmlWSDL.indexOf("targetNamespace") + "targetNamespace".length();
    start = xmlWSDL.indexOf("\"", start);
    int end = xmlWSDL.indexOf("\"", start+1);
    version = xmlWSDL.substring(start+1, end);

    return version;       
  }
   
  private static void trustAllHttpsCertificates() throws NoSuchAlgorithmException, KeyManagementException  
  {
    javax.net.ssl.TrustManager[] trustAllCerts = new javax.net.ssl.TrustManager[1]; 
    javax.net.ssl.TrustManager tm = new miTM(); 
    trustAllCerts[0] = tm;
    javax.net.ssl.SSLContext sc = javax.net.ssl.SSLContext.getInstance("SSL"); 
    sc.init(null, trustAllCerts, null); 
    javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory()); 
  }
   
  private static class miTM implements TrustManager, X509TrustManager 
  {
    public X509Certificate[] getAcceptedIssuers() 
    {
      return null;
    } 
    public boolean isServerTrusted(X509Certificate[] certs) 
    {
      return true;
    }
    public boolean isClientTrusted(X509Certificate[] certs) 
    {
      return true;
    } 
    public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException 
    {
      return;
    } 
    public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException 
    {
      return;
    }
  }
}