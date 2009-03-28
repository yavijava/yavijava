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

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.vmware.vim25.ManagedObjectReference;

import java.rmi.RemoteException;

/** 
 * The Web Service Engine
 * @author Steve Jin (sjin@vmware.com)
*/

public final class WSClient
{
  private final static String SOAP_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><soapenv:Envelope xmlns:soapenc=\"http://schemas.xmlsoap.org/soap/encoding/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"><soapenv:Body>"; 
  private final static String SOAP_END = "</soapenv:Body></soapenv:Envelope>";
  
  private URL baseUrl = null;
  private String cookie = null;
  private String vimNameSpace = null;
  private SAXReader reader = new SAXReader();
  
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
  
  public Object invoke(ManagedObjectReference mor, String methodName, Argument[] paras, String returnType) throws IOException
  {
    Argument[] fullParas = new Argument[paras.length + 1];
    fullParas[0] = new Argument("_this", mor);
    System.arraycopy(paras, 0, fullParas, 1, paras.length);
    return invoke(methodName, fullParas, returnType);
  }

  public Object invoke(String methodName, Argument[] paras, String returnType) throws RemoteException
  {
    Element root = invoke(methodName, paras);
    Element body = (Element) root.elements().get(0);
    Element resp = (Element) body.elements().get(0);
    
    if(resp.getName().indexOf("Fault")!=-1)
    {   
      try 
      {
        SoapFaultException sfe = XmlGen.parseSoapFault(resp);
        if(sfe.detail!=null)
        {
          throw (RemoteException) sfe.detail;
        }
      } catch (Exception e) 
      {
        throw new RemoteException("Exception in WSClient.invoke:", e);
      }
      return null;
    }
    else
    {
      if(returnType!=null)
      {
        try 
        {
          return XmlGen.fromXML(returnType, resp);
        } 
        catch (Exception e) 
        {
          throw new RemoteException("Exception in WSClient.invoke:", e);
        }
      }
      else
      {
        return null;
      }
    }
  }
  
  public Element invoke(String methodName, Argument[] paras) throws RemoteException
  {
    String soapMsg = createSoapMessage(methodName, paras);

    Element root = null;
    try 
    {
      InputStream is = post(soapMsg);
      Document doc = reader.read(is);
	    root = doc.getRootElement();
    } catch (Exception e) 
    {
      throw new RemoteException("VI SDK invoke exception:" + e);
    }
    
    return root;
  }
  
  public StringBuffer invokeAsString(String methodName, Argument[] paras) throws RemoteException
  {
    String soapMsg = createSoapMessage(methodName, paras);

    try 
    {
      InputStream is = post(soapMsg);
      return readStream(is);
    } catch (Exception e) 
    {
      throw new RemoteException("VI SDK invoke exception:" + e);
    }
  }

  private String createSoapMessage(String methodName, Argument[] paras)
  {
    StringBuffer sb = new StringBuffer();
    sb.append(SOAP_HEADER);

    sb.append("<" + methodName + vimNameSpace);
		
    for(int i=0; i<paras.length; i++)
    {
      String key = paras[i].getName();
      Object obj = paras[i].getValue();
      sb.append(XmlGen.toXML(key, obj)); //, null));
    }

    sb.append("</" + methodName + ">");
    sb.append(SOAP_END);
    return sb.toString();
  }
  
  public InputStream post(String soapMsg) throws IOException
  {
    HttpURLConnection postCon = (HttpURLConnection) baseUrl.openConnection();
    try {
        postCon.setRequestMethod("POST");
    } catch (ProtocolException e) 
    {
        e.printStackTrace();
    }
    postCon.setDoOutput(true);
    postCon.setDoInput(true);
    if(cookie!=null)
    {
      postCon.setRequestProperty("Cookie", cookie);
    }

    OutputStream os = postCon.getOutputStream();
    OutputStreamWriter out = new OutputStreamWriter(os);

    out.write(soapMsg);
    out.close();

    InputStream is = postCon.getInputStream();
    
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
