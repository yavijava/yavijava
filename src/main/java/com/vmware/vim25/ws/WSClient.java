/*================================================================================
Copyright (c) 2013 Steve Jin, All Rights Reserved.
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

package com.vmware.vim25.ws;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.rmi.RemoteException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/** 
 * The Web Service Engine
 * @author Steve Jin (sjin@vmware.com)
*/

final public class WSClient
{
  private final static String SOAP_ACTION_HEADER = "SOAPAction";
  private final static String SOAP_ACTION_V40 = "urn:vim25/4.0";
  private final static String SOAP_ACTION_V41 = "urn:vim25/4.1";
  private final static String SOAP_ACTION_V50 = "urn:vim25/5.0";
  private final static String SOAP_ACTION_V51 = "urn:vim25/5.1";
  private final static String SOAP_ACTION_V55 = "urn:vim25/5.5";
  
  private URL baseUrl = null;
  private String cookie = null;
  private String vimNameSpace = null;
  private String soapAction = null;
  private int connectTimeout = 0;
  private int readTimeout = 0;
  
  XmlGen xmlGen = new XmlGenDom();
  
  public WSClient(String serverUrl) throws MalformedURLException 
  {
    this(serverUrl, true);
  }
  
  public WSClient(String serverUrl, boolean ignoreCert) throws MalformedURLException 
  {
    if(serverUrl.endsWith("/"))
    {
      serverUrl = serverUrl.substring(0, serverUrl.length()-1);
    } 
    this.baseUrl = new URL(serverUrl);
    if(ignoreCert)
    {
      try
      {
        trustAllHttpsCertificates();
        HttpsURLConnection.setDefaultHostnameVerifier
        (
          new HostnameVerifier() 
          {
            public boolean verify(String urlHostName, SSLSession session)
            {
              return true;
            }
          }
        );
      } catch (Exception e)  {}
    }
  }
  
  public Object invoke(String methodName, Argument[] paras, String returnType) throws RemoteException
  {
    String soapMsg = XmlGen.toXML(methodName, paras, this.vimNameSpace);
    
    InputStream is = null;
    try 
    {
      is = post(soapMsg);
      return xmlGen.fromXML(returnType, is);
    }
    catch (Exception e1) 
    {
      throw new RemoteException("VI SDK invoke exception:" + e1);
    }
    finally
    {
      if(is!=null) 
        try { is.close(); } catch(IOException ioe) {}
    }
  }
  
  public StringBuffer invokeAsString(String methodName, Argument[] paras) throws RemoteException
  {
    String soapMsg = XmlGen.toXML(methodName, paras, this.vimNameSpace);

    try 
    {
      InputStream is = post(soapMsg);
      return readStream(is);
    } catch (Exception e) 
    {
      throw new RemoteException("VI SDK invoke exception:" + e);
    }
  }

  public InputStream post(String soapMsg) throws IOException
  {
    HttpURLConnection postCon = (HttpURLConnection) baseUrl.openConnection();
    
    if(connectTimeout > 0)
      postCon.setConnectTimeout(connectTimeout);
    if(readTimeout > 0)
      postCon.setReadTimeout(readTimeout);
    
    try {
        postCon.setRequestMethod("POST");
    } catch (ProtocolException e) 
    {
        e.printStackTrace();
    }
    postCon.setDoOutput(true);
    postCon.setDoInput(true);
    postCon.setRequestProperty(SOAP_ACTION_HEADER, soapAction);
    postCon.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
    
    if(cookie!=null)
    {
      postCon.setRequestProperty("Cookie", cookie);
    }

    OutputStream os = postCon.getOutputStream();
    OutputStreamWriter out = new OutputStreamWriter(os, "UTF8");

    out.write(soapMsg);
    out.close();

    InputStream is;
    
    try
    {
    	is = postCon.getInputStream();
    } 
    catch(IOException ioe)
    {
    	is = postCon.getErrorStream();
    }
    
    if(cookie==null)
    {
      cookie = postCon.getHeaderField("Set-Cookie");
    }
    return is;
  }
  
  public URL getBaseUrl()
  {
    return this.baseUrl;
  }

  public void setBaseUrl(URL baseUrl)
  {
    this.baseUrl = baseUrl;
  }

  public String getCookie()
  {
    return cookie;
  }

  public void setCookie(String cookie)
  {
    this.cookie = cookie;
  }

  public String getVimNameSpace()
  {
    return vimNameSpace;
  }

  public void setVimNameSpace(String vimNameSpace)
  {
    this.vimNameSpace = vimNameSpace;
  }
  
  public void setConnectTimeout(int timeoutMilliSec)
  {
    this.connectTimeout = timeoutMilliSec;
  }

  public int getConnectTimeout()
  {
    return this.connectTimeout;
  }

  public void setReadTimeout(int timeoutMilliSec)
  {
    this.readTimeout = timeoutMilliSec;
  }
  
  public int getReadTimeout()
  {
    return this.readTimeout;
  }
  
/*===============================================
   * API versions *   
  "2.0.0"    VI 3.0
  "2.5.0"    VI 3.5 (and u1)
  "2.5u2"   VI 3.5u2 (and u3, u4)
  "4.0"       vSphere 4.0 (and u1)
  "4.1"       vSphere 4.1
  "5.0"       vSphere 5.0
  "5.1"       vSphere 5.1
  ===============================================*/
  public void setSoapActionOnApiVersion(String apiVersion)
  {
    if("4.0".equals(apiVersion))
    {
      soapAction = SOAP_ACTION_V40;
    }
    else if("4.1".equals(apiVersion))
    {
      soapAction = SOAP_ACTION_V41;
    }
    else if("5.0".equals(apiVersion))
    {
      soapAction = SOAP_ACTION_V50;
    }
    else if("5.1".equals(apiVersion))
    {
      soapAction = SOAP_ACTION_V51;
    }
    else if("5.5".equals(apiVersion))
    {
      soapAction = SOAP_ACTION_V55;
    }
    else
    { //always defaults to latest version 
      soapAction = SOAP_ACTION_V55;
    }
  }
  
  private StringBuffer readStream(InputStream is) throws IOException
  {
    StringBuffer sb = new StringBuffer();
    BufferedReader in = new BufferedReader(new InputStreamReader(is));
    String lineStr;
    while ((lineStr = in.readLine()) != null) 
    {
      sb.append(lineStr);
    }
    in.close();
    return sb;
  }
  
  private static void trustAllHttpsCertificates() 
    throws NoSuchAlgorithmException, KeyManagementException
  {
    TrustManager[] trustAllCerts = new TrustManager[1]; 
    trustAllCerts[0] = new TrustAllManager(); 
    SSLContext sc = SSLContext.getInstance("SSL"); 
    sc.init(null, trustAllCerts, null); 
    HttpsURLConnection.setDefaultSSLSocketFactory(
        sc.getSocketFactory());
  }

  private static class TrustAllManager implements X509TrustManager 
  {
    public X509Certificate[] getAcceptedIssuers() 
    {
      return null;
    } 
    public void checkServerTrusted(X509Certificate[] certs, 
        String authType)
      throws CertificateException 
    {
    } 
    public void checkClientTrusted(X509Certificate[] certs, 
        String authType)
    throws CertificateException 
    {
    }
  }
}
