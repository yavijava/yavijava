package com.vmware.vim25.ws;

import org.apache.http.Header;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.log4j.Logger;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.rmi.RemoteException;

/**
 * Created by Michael Rice on 8/12/14.
 *
 * Copyright 2014 Michael Rice
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class ApacheHttpClient extends SoapClient {

    /**
     * What rolls down stairs alone or in pairs?
     * Its log log log!
     */
    private static final Logger log = Logger.getLogger(ApacheHttpClient.class);

    /**
     * Trust all the ssl stuff no matter what!?!
     *
     * We do true here because by default all the vsphere stuff
     * is self signed.
     */
    private boolean trustAllSSL = true;

    /**
     * The XML serialization/de-serialization engine
     */
    XmlGen xmlGen = new XmlGenDom();

    /**
     * Primary constructor
     *
     * @param serverUrl <code>String</code> of the url to the vi server
     * @param ignoreCert <code>boolean</code> to check or ignore ssl. Default ignore
     * @throws MalformedURLException
     */
    public ApacheHttpClient(String serverUrl, boolean ignoreCert) throws MalformedURLException {
        if (serverUrl.endsWith("/")) {
            serverUrl = serverUrl.substring(0, serverUrl.length() - 1);
        }
        trustAllSSL = ignoreCert;
        log.trace("Creating ApacheHttpClient to server URL: " + serverUrl);
        log.trace("Ignore ssl: " + ignoreCert);
        this.baseUrl = new URL(serverUrl);
        if (trustAllSSL) {
            try {
                TrustAllSSL.trustAllHttpsCertificates();
                HttpsURLConnection.setDefaultHostnameVerifier(
                    new HostnameVerifier() {
                        public boolean verify(String urlHostName, SSLSession session) {
                            return true;
                        }
                    }
                );
            }
            catch (Exception ignored) {
                log.error("An exception was caught while trying to trust all SSL.", ignored);
            }
        }
    }

    /**
     *
     * @param url
     * @throws MalformedURLException
     */
    public ApacheHttpClient(String url) throws MalformedURLException {
        this(url, true);
    }

    /**
     * Invoke a given method with supplied {@link com.vmware.vim25.ws.Argument} on the remote vi server.
     * This method typically creates the payload needed to send to the vi server. For example you would
     * pass in RetrieveServiceContent for the methodName, next the params needed for the method. Next give
     * the returnType the parser should convert the response to in this case the string ServiceContent
     * <p/>
     * Returns an {@link Object} of the given return type. Using the example above you would get
     * a {@link com.vmware.vim25.ServiceContent} Object.
     * <p/>
     *
     * @param methodName Name of the method to execute
     * @param paras      Array of Arguments aka params for the method
     * @param returnType String name of the return type
     * @return Object
     *
     * @throws java.rmi.RemoteException
     */
    @Override
    public Object invoke(String methodName, Argument[] paras, String returnType) throws RemoteException {
        log.trace("Invoking method: " + methodName);
        String soapMsg = XmlGen.toXML(methodName, paras, this.vimNameSpace);
        InputStream is = null;
        try {
            is = post(soapMsg);
            log.trace("Converting xml response from server to: " + returnType);
            return xmlGen.fromXML(returnType, is);
        }
        catch (Exception e1) {
            log.error("Exception caught while invoking method.", e1);
            throw new RemoteException("VI SDK invoke exception:" + e1);
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

    /**
     * Invoke a given method with supplied {@link com.vmware.vim25.ws.Argument} on the remote vi server.
     * Returns a {@link StringBuffer} This works the same as the above call except there is no
     * conversion done on the return data and instead you just get back the StringBuffer content.
     *
     * @param methodName Name of the method to execute
     * @param paras      Array of Arguments aka params for the method
     * @return StringBuffer with the
     *
     * @throws java.rmi.RemoteException
     */
    @Override
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

    private InputStream post(String payload) {
        CloseableHttpClient httpclient;
        RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(this.connectTimeout)
            .setSocketTimeout(this.readTimeout)
            .build();
        if (trustAllSSL) {
            httpclient = HttpClients.custom().setSSLSocketFactory(ApacheTrustSelfSigned.trust()).build();

        }
        else {
            httpclient = HttpClients.createDefault();
        }
        HttpPost httpPost;
        StringEntity stringEntity;
        try {
            stringEntity = new StringEntity(payload);
            log.trace("Converted payload to String entity.");
        }
        catch (UnsupportedEncodingException e) {
            log.error("Failed to convert payload to StringEntity. Unsupported Encoding Exception caught. Payload: " + payload, e);
            return null;
        }
        try {
            httpPost = new HttpPost(this.baseUrl.toURI());
        }
        catch (URISyntaxException e) {
            log.error("Malformed URI sent: " + this.baseUrl.toString(), e);
            return null;
        }
        httpPost.setConfig(requestConfig);
        httpPost.setHeader(SoapAction.SOAP_ACTION_HEADER.toString(), soapAction);
        httpPost.setHeader("Content-Type", "text/xml; charset=utf-8");
        if (cookie != null) {
            log.trace("Setting Cookie.");
            httpPost.setHeader("Cookie", cookie);
        }
        httpPost.setEntity(stringEntity);
        try {
            CloseableHttpResponse response = httpclient.execute(httpPost);
            InputStream inputStream = response.getEntity().getContent();
            if (cookie == null) {
                Header cookieHeader = (Header) response.headerIterator("Set-Cookie");
                cookie = cookieHeader.getValue();
            }
            return inputStream;
        }
        catch (IOException e) {
            log.error("", e);
        }
        return null;
    }
}
