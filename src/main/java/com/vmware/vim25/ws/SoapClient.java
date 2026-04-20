package com.vmware.vim25.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.TrustManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import java.security.cert.CertificateEncodingException;

/**
 * Created by Michael Rice on 8/10/14.
 * <p>
 * Copyright 2014 Michael Rice
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public abstract class SoapClient implements Client {

    private static Logger log = LoggerFactory.getLogger(SoapClient.class);
    public String soapAction;
    public URL baseUrl = null;
    public String cookie = null;
    public String thumbprint = null;
    public String vimNameSpace = null;
    public int connectTimeout = 0;
    public int readTimeout = 0;
    protected TrustManager trustManager;

    XmlGen xmlGen = new XmlGenDom();

    /*===============================================
       * API versions *
      "2.0.0"    VI 3.0
      "2.5.0"    VI 3.5 (and u1)
      "2.5u2"   VI 3.5u2 (and u3, u4)
      "4.0"       vSphere 4.0 (and u1)
      "4.1"       vSphere 4.1
      "5.0"       vSphere 5.0
      "5.1"       vSphere 5.1
      ===============================================
    */
    public void setSoapActionOnApiVersion(String apiVersion) {
        log.trace("API Version detected: " + apiVersion);
        if ("4.0".equals(apiVersion)) {
            soapAction = SoapAction.SOAP_ACTION_V40.toString();
        }
        else if ("4.1".equals(apiVersion)) {
            soapAction = SoapAction.SOAP_ACTION_V41.toString();
        }
        else if ("5.0".equals(apiVersion)) {
            soapAction = SoapAction.SOAP_ACTION_V50.toString();
        }
        else if ("5.1".equals(apiVersion)) {
            soapAction = SoapAction.SOAP_ACTION_V51.toString();
        }
        else if ("5.5".equals(apiVersion)) {
            soapAction = SoapAction.SOAP_ACTION_V55.toString();
        }
        else if ("6.0".equals(apiVersion)) {
            soapAction = SoapAction.SOAP_ACTION_V60.toString();
        }
        else { //always defaults to latest version
            soapAction = SoapAction.SOAP_ACTION_V60.toString();
        }
        log.trace("Set soapAction to: " + soapAction);
    }

    /**
     * Returns the {@link java.net.URL} that will be used in the connection.
     *
     * @return <code>URL</code> of the vi server used by this Client
     */
    public URL getBaseUrl() {
        return this.baseUrl;
    }

    /**
     * Set the baseUrl for use in this Client
     *
     * @param baseUrl
     */
    public void setBaseUrl(URL baseUrl) {
        this.baseUrl = baseUrl;
    }

    /**
     * Returns the <code>String</code> of the Cookie from the Set-Cookie header
     * unless it was manually set in which case it returns that.
     *
     * @return String from the Set-Cookie header
     */
    public String getCookie() {
        return cookie;
    }

    public void setServerThumbprint(String thumbprint) {
        this.thumbprint = thumbprint;
    }

    public String getServerThumbprint() {
        return thumbprint;
    }

    public static String computeX509CertificateThumbprint(X509Certificate cert) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            return hexify(md.digest(cert.getEncoded()));
        }
        catch (NoSuchAlgorithmException ignore1) {
            return null;
        }
        catch (CertificateEncodingException ignore2) {
            return null;
        }
    }

    public static String hexify (byte bytes[]) {
        char[] hexDigits = {
            '0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'A', 'B',
            'C', 'D', 'E', 'F'
        };
        StringBuffer buf = new StringBuffer(bytes.length * 3);
        for (int i = 0; i < bytes.length; i++) {
            if (i != 0) buf.append(':');
            buf.append(hexDigits[(bytes[i] & 0xf0) >> 4]);
            buf.append(hexDigits[bytes[i] & 0x0f]);
        }
        return buf.toString();
    }

    /**
     * Primarily used to set the cookie from the Set-Cookie header
     *
     * @param cookie String from the Set-Cookie header
     */
    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    /**
     * @return
     */
    public String getVimNameSpace() {
        return vimNameSpace;
    }

    /**
     * @param vimNameSpace
     */
    public void setVimNameSpace(String vimNameSpace) {
        this.vimNameSpace = vimNameSpace;
    }

    public int getConnectTimeout() {
        return this.connectTimeout;
    }

    /**
     * @param timeoutMilliSec
     */
    public void setConnectTimeout(int timeoutMilliSec) {
        this.connectTimeout = timeoutMilliSec;
    }

    /**
     * Returns the time in milliseconds that is set for the read timeout
     * <p>
     * This time may not be the same as what the underlying client uses. If
     * for example the client does not support this and is for some reason
     * hard coded to some value this value.
     *
     * @return int
     */
    public int getReadTimeout() {
        return this.readTimeout;
    }

    /**
     * Set the read timeout.
     * <p>
     * Sets the read timeout to a specified timeout, in milliseconds.
     * A non-zero value specifies the timeout when reading from Input
     * stream when a connection is established to a resource. If the
     * timeout expires before there is data available for read, a
     * java.net.SocketTimeoutException is raised. A timeout of zero
     * is interpreted as an infinite timeout.
     * <p>
     * This value will be used by the underlying http client used if
     * it is supported. By default that is the WSClient which uses
     * HTTPURLConnection which uses URLConnection
     *
     * @param timeoutMilliSec int
     */
    public void setReadTimeout(int timeoutMilliSec) {
        this.readTimeout = timeoutMilliSec;
    }

    public TrustManager getTrustManager() {
        return trustManager;
    }

    public StringBuffer readStream(InputStream is) throws IOException {
        log.trace("Building StringBuffer from InputStream response.");
        StringBuffer sb = new StringBuffer();
        BufferedReader in = new BufferedReader(new InputStreamReader(is));
        String lineStr;
        while ((lineStr = in.readLine()) != null) {
            sb.append(lineStr);
        }
        in.close();
        return sb;
    }

    /**
     * This method will marshall the java payload object in to xml payload.
     *
     * @param methodName
     * @param paras
     * @return String - XML SoapMessage
     */
    public String marshall(String methodName, Argument[] paras) {
        String soapMsg = XmlGen.toXML(methodName, paras, vimNameSpace);
        if (log.isTraceEnabled()) {
            log.trace("Marshalled Payload String xml: " + soapMsg);
        }
        return soapMsg;
    }

    /**
     * This method will unmarshall the response inputstream to Java Object of
     * returnType type.
     *
     * @param returnType
     * @param is
     * @return Object - Converted Response inputstream
     */
    public Object unMarshall(String returnType, InputStream is) throws Exception {
        return xmlGen.fromXML(returnType, is);
    }
}
