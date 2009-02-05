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

package com.vmware.vim.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.net.URLEncoder;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class RestClient
{
  private String baseUrl = null;
  
  static 
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
  
  public RestClient(String serverUrl, String username, String password)
  {
    if(serverUrl.endsWith("/"))
    {
      serverUrl = serverUrl.substring(0, serverUrl.length()-1);
    } 
    else if (serverUrl.endsWith("/mob"))
    {
      serverUrl = serverUrl.substring(0, serverUrl.length()-4);
    }
    else if (serverUrl.endsWith("/mob/"))
    {
      serverUrl = serverUrl.substring(0, serverUrl.length()-5);
    }

    this.baseUrl = serverUrl;
    setLogin(username, password);
  }

  public String get(String urlStr) throws IOException
  {
    urlStr = preProcessUrl(urlStr);
    
    StringBuffer sb = getRawPage(urlStr);

    int start = sb.indexOf("<xml id=\"objData\">");
    int objPos = sb.indexOf("<object>", start);
    sb.replace(objPos, objPos+8 , "<object xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance'>");
    int end = sb.indexOf("</textarea>", objPos);
    
    return sb.substring(start, end);
  }
  
  private String preProcessUrl(String url)
  {
    if(url==null || url.equals("/"))
    {
      url = baseUrl + "/mob";
    }
    else if(!(url.startsWith("http") || url.startsWith("https")))
    {
      if(url.startsWith("/mob/?moid="))
      {
        url = baseUrl + url;
      }
      else if(url.startsWith("moid="))
      {
        url = baseUrl + "/mob/?" + url;
      }
      else if(url.startsWith("?moid="))
      {
        url = baseUrl + "/mob/" + url;
      }
    }
    return url;
  }
  
  private StringBuffer getRawPage(String urlStr) throws IOException
  {
    HttpURLConnection conn = (HttpURLConnection) new URL(urlStr).openConnection();
    conn.connect();
    
    return readStream(conn.getInputStream());
  }

  public String post(String urlStr) throws Exception
  {
    return post(urlStr, new Hashtable<String, String>());
  }
    
  public String post(String urlStr, Map<String, String> para) throws Exception
  {
    urlStr = preProcessUrl(urlStr);
    
    HttpURLConnection getCon = (HttpURLConnection) new URL(
        urlStr).openConnection();
    getCon.connect();
    String cookie = getCon.getHeaderField("Set-Cookie");
    cookie = cookie.substring(0, cookie.indexOf(";"));
    
    HttpURLConnection postCon = (HttpURLConnection) new URL(urlStr).openConnection();
    postCon.setRequestMethod("POST");
    postCon.setDoOutput(true);
    postCon.setDoInput(true);
    postCon.setRequestProperty("Cookie", cookie);

    OutputStream os = postCon.getOutputStream();
    OutputStreamWriter out = new OutputStreamWriter(os);

    Iterator<String> keys = para.keySet().iterator();
    while(keys.hasNext())
    {
      String key = keys.next();
      String value = para.get(key);
      key = URLEncoder.encode(key, "UTF-8");
      value = URLEncoder.encode(value, "UTF-8");
      out.write(key + "=" + value);
    }
    out.close();

    InputStream is = postCon.getInputStream();
    StringBuffer sb = readStream(is);
    String resultFlag = "Method Invocation Result:";
    int start = sb.indexOf(resultFlag);

    String result = sb.substring(start + resultFlag.length());
    return ResultConverter.convert2Xml(result);
  }
  
  public String getUrlStr()
  {
    return this.baseUrl;
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

  private static class TrustAllManager 
    implements X509TrustManager 
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
  
  private void setLogin(String username, String password)
  {
    final String user = username;
    final String pass = password;
    Authenticator.setDefault(new Authenticator() 
    {
      protected PasswordAuthentication getPasswordAuthentication() 
      {
          return new PasswordAuthentication (user, pass.toCharArray());
      }
    }
    );
  }
}
