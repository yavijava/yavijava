package com.vmware.spbm.ws;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.log4j.Logger;

import com.vmware.vim25.ws.Argument;
import com.vmware.vim25.ws.SoapAction;
import com.vmware.vim25.ws.SoapClient;
import com.vmware.vim25.ws.TrustAllSSL;
import com.vmware.vim25.ws.XmlGen;

/**
 * The PBM Web Service Engine
 * 
 * @author Atoka Sema
 */

public class PbmWSClient extends SoapClient {

    private static final Logger log = Logger.getLogger(PbmWSClient.class);

    // vCenter Single Sign On session cookie value without the key
    // Sample: d198d6a893334cb02889b85a59666baa3b298aca
    private String vCenterSSOCookie;

    public PbmWSClient(String serverUrl, String vCenterCookie) throws MalformedURLException {
        this(serverUrl, vCenterCookie, true);
    }

    public String getvCenterCookie() {
        return vCenterSSOCookie;
    }

    public void setvCenterCookie(String vCenterCookie) {
        this.vCenterSSOCookie = vCenterCookie;
    }

    public PbmWSClient(String serverUrl, String vCenterCookie, boolean ignoreCert) throws MalformedURLException {
        if (serverUrl.endsWith("/")) {
            serverUrl = serverUrl.substring(0, serverUrl.length() - 1);
        }
        this.vCenterSSOCookie = vCenterCookie;
        log.trace("Creating WSClient to server URL: " + serverUrl);
        log.trace("Ignore ssl: " + ignoreCert);
        this.baseUrl = new URL(serverUrl);
        if (ignoreCert) {
            try {
                TrustAllSSL.trustAllHttpsCertificates();
                HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String urlHostName, SSLSession session) {
                        return true;
                    }
                });
            } catch (Exception ignored) {
            }
        }
    }

    /**
     * Function to insert vcenter session cookie information in SOAP body
     * <S:Header> <vcSessionCookie
     * xmlns="#">"02b38ac24a3f07cbf3a8074407fc9ba7f4dfe953"</vcSessionCookie>
     * </S:Header>
     * 
     * @param soapMsg
     * @param vCenterCookie
     * @return
     */
    private String insertCookie(String soapMsg, String vCenterCookie) {
        StringBuffer strBuffer = new StringBuffer(soapMsg);
        StringBuffer sessionHeader = new StringBuffer();
        sessionHeader.append("<soapenv:Header>");
        sessionHeader.append("<vcSessionCookie xmlns=\"#\">");
        sessionHeader.append("\"" + vCenterCookie + "\"");
        sessionHeader.append("</vcSessionCookie>");
        sessionHeader.append("</soapenv:Header>");
        strBuffer.insert(strBuffer.indexOf("<soapenv:Body>"), sessionHeader.toString());
        return strBuffer.toString();
    }

    @Override
    public Object invoke(String methodName, Argument[] paras, String returnType) throws RemoteException {
        log.trace("Invoking method: " + methodName);
        String soapMsg = marshall(methodName, paras);
        // Insert vcenter session cookie information to soap body
        soapMsg = insertCookie(soapMsg, vCenterSSOCookie);

        InputStream is = null;
        try {
            is = post(soapMsg);
            log.trace("Converting xml response from server to: " + returnType);
            return unMarshall(returnType, is);
        } catch (Exception e1) {
            log.error("Exception caught while invoking method: " + methodName, e1);
            // Fixes issue-28 still need to write a test which may require
            // further refacotring but this at least gets the InvalidLogin
            // working.
            try {
                throw (RemoteException) e1;
            } catch (ClassCastException ignore) {
                throw new RemoteException("Exception caught trying to invoke method " + methodName, e1);
            }
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException ignored) {
                }
            }
        }
    }

    @Override
    public StringBuffer invokeAsString(String methodName, Argument[] paras) throws RemoteException {
        String soapMsg = XmlGen.toXML(methodName, paras, this.vimNameSpace);

        try {
            InputStream is = post(soapMsg);
            return readStream(is);
        } catch (Exception e) {
            throw new RemoteException("PBM SDK invoke exception:" + e);
        }
    }

    protected InputStream post(String soapMsg) throws IOException {
        HttpURLConnection postCon = (HttpURLConnection) baseUrl.openConnection();

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
        } catch (ProtocolException e) {
            log.debug("ProtocolException caught.", e);
        }
        postCon.setDoOutput(true);
        postCon.setDoInput(true);
        postCon.setRequestProperty(SoapAction.SOAP_ACTION_HEADER.toString(), soapAction);
        postCon.setRequestProperty("Content-Type", "text/xml; charset=utf-8");

        if (cookie != null) {
            log.trace("Setting PBM Cookie: " + cookie);
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
        } catch (IOException ioe) {
            log.debug("Caught an IOException. Reading ErrorStream for results.", ioe);
            is = postCon.getErrorStream();
        }

        if (cookie == null) {
            cookie = postCon.getHeaderField("Set-Cookie");
            log.trace("Cookie was null. Fetching Set-Cookie header to get new Cookie. " + cookie);
        }
        return is;
    }

    protected OutputStreamWriter createOutputStreamWriter(OutputStream os) throws UnsupportedEncodingException {
        return new OutputStreamWriter(os, "UTF8");
    }
}
