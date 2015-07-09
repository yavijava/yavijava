/*================================================================================
Copyright (c) 2013 Steve Jin, All Rights Reserved.
Copyright (c) 2009 VMware, Inc. All Rights Reserved.
Copyright (c) 2014, 2015 Michael Rice, All Rights Reserved.

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

import org.apache.log4j.Logger;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.rmi.RemoteException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

/**
 * The Web Service Engine
 *
 * @author Steve Jin (sjin@vmware.com)
 * @author Michael Rice (michael@michaelrice.org)
 */

public class WSClient extends SoapClient {

    private static final Logger log = Logger.getLogger(WSClient.class);
    
    /**
     * The {@link SSLSocketFactory} when ignoring the certificates.
     */
    private final SSLSocketFactory sslSocketFactory;

    XmlGen xmlGen = new XmlGenDom();

    public WSClient(String serverUrl) throws MalformedURLException {
        this(serverUrl, true);
    }

    public WSClient(String serverUrl, boolean ignoreCert) throws MalformedURLException {
        if (serverUrl.endsWith("/")) {
            serverUrl = serverUrl.substring(0, serverUrl.length() - 1);
        }
        log.trace("Creating WSClient to server URL: " + serverUrl);
        log.trace("Ignore ssl: " + ignoreCert);
        this.baseUrl = new URL(serverUrl);
        
        try {
            this.sslSocketFactory = ignoreCert ? TrustAllSSL.getTrustContext().getSocketFactory() : null;
        } 
        catch (NoSuchAlgorithmException e) {
            log.debug("Unable to find suitable algorithm while attempting to communicate with remote server.", e);
            throw new IllegalArgumentException("Unable to find suitable algorithm while attempting to communicate with remote server.", e);
        }
        catch (KeyManagementException e) {
            log.debug("Key Management exception while attempting to communicate with remote server.", e);
            throw new IllegalArgumentException("Key Management exception while attempting to communicate with remote server.", e);
        }
    }

    public Object invoke(String methodName, Argument[] paras, String returnType) throws RemoteException {
        log.trace("Invoking method: " + methodName);
        String soapMsg = marshall(methodName, paras);

        InputStream is = null;
        try {
            is = post(soapMsg);
            log.trace("Converting xml response from server to: " + returnType);
            return unMarshall(returnType, is);
        }
        catch (Exception e1) {
            log.error("Exception caught while invoking method: " + methodName, e1);
            // Fixes issue-28 still need to write a test which may require
            // further refacotring but this at least gets the InvalidLogin working.
            try {
                throw (RemoteException) e1;
            }
            catch (ClassCastException ignore) {
                throw new RemoteException("Exception caught trying to invoke method " + methodName, e1);
            }
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                }
                catch (IOException ignored) {
                }
            }
        }
    }

    public StringBuffer invokeAsString(String methodName, Argument[] paras) throws RemoteException {
        String soapMsg = XmlGen.toXML(methodName, paras, this.vimNameSpace);

        try {
            InputStream is = post(soapMsg);
            return readStream(is);
        }
        catch (Exception e) {
            throw new RemoteException("VI SDK invoke exception:" + e);
        }
    }

    protected InputStream post(String soapMsg) throws IOException {
        HttpURLConnection postCon = (HttpURLConnection) baseUrl.openConnection();

        if (sslSocketFactory != null) {
            ((HttpsURLConnection) postCon).setSSLSocketFactory(sslSocketFactory);
        }

        log.trace("POST: " + soapAction);
        log.trace("Payload: " + soapMsg);
        if (connectTimeout > 0) {
            postCon.setConnectTimeout(connectTimeout);
        }
        if (readTimeout > 0) {
            postCon.setReadTimeout(readTimeout);
        }

        try {
            postCon.setRequestMethod("POST");
        }
        catch (ProtocolException e) {
            log.debug("ProtocolException caught.", e);
        }

        postCon.setDoOutput(true);
        postCon.setDoInput(true);
        postCon.setRequestProperty(SoapAction.SOAP_ACTION_HEADER.toString(), soapAction);
        postCon.setRequestProperty("Content-Type", "text/xml; charset=utf-8");

        if (cookie != null) {
            log.trace("Setting Cookie.");
            postCon.setRequestProperty("Cookie", cookie);
        }

        OutputStream os = postCon.getOutputStream();
        OutputStreamWriter out = createOutputStreamWriter(os);

        out.write(soapMsg);
        out.close();

        InputStream is;

        try {
            is = postCon.getInputStream();
            log.trace("Successfully fetched InputStream.");
        }
        catch (IOException ioe) {
            log.debug("Caught an IOException. Reading ErrorStream for results.", ioe);
            is = postCon.getErrorStream();
        }

        if (cookie == null) {
            cookie = postCon.getHeaderField("Set-Cookie");
            log.trace("Cookie was null. Fetching Set-Cookie header to get new Cookie.");
        }
        return is;
    }

    protected OutputStreamWriter createOutputStreamWriter(OutputStream os) throws UnsupportedEncodingException {
        return new OutputStreamWriter(os, "UTF8");
    }

}
