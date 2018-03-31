package com.vmware.vim25.ws;

import javax.net.ssl.TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.rmi.RemoteException;

/**
 * Copyright 2014 Michael Rice
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

public interface Client {

    /**
     * Invoke a given method with supplied {@link com.vmware.vim25.ws.Argument} on the remote vi server.
     * This method typically creates the payload needed to send to the vi server. For example you would
     * pass in RetrieveServiceContent for the methodName, next the params needed for the method. Next give
     * the returnType the parser should convert the response to in this case the string ServiceContent
     * <p>
     * Returns an {@link java.lang.Object} of the given return type. Using the example above you would get
     * a {@link com.vmware.vim25.ServiceContent} Object.
     * <p>
     *
     * @param methodName Name of the method to execute
     * @param paras      Array of Arguments aka params for the method
     * @param returnType String name of the return type
     * @return Object
     * @throws RemoteException
     */
    public Object invoke(String methodName, Argument[] paras, String returnType) throws RemoteException;

    /**
     * Invoke a given method with supplied {@link com.vmware.vim25.ws.Argument} on the remote vi server.
     * Returns a {@link java.lang.StringBuffer} This works the same as the above call except there is no
     * conversion done on the return data and instead you just get back the StringBuffer content.
     *
     * @param methodName Name of the method to execute
     * @param paras      Array of Arguments aka params for the method
     * @return StringBuffer with the
     * @throws RemoteException
     */
    public StringBuffer invokeAsString(String methodName, Argument[] paras) throws RemoteException;

    /**
     * Returns the {@link java.net.URL} that will be used in the connection.
     *
     * @return <code>URL</code> of the vi server used by this Client
     */
    public URL getBaseUrl();

    /**
     * Set the baseUrl for use in this Client
     *
     * @param baseUrl <code>URL</code> to be used by this Client
     */
    public void setBaseUrl(URL baseUrl);

    /**
     * Returns the <code>String</code> of the Cookie from the Set-Cookie header
     * unless it was manually set in which case it returns that.
     *
     * @return String from the Set-Cookie header
     */
    public String getCookie();

    /**
     * Primarily used to set the cookie from the Set-Cookie header
     *
     * @param cookie String from the Set-Cookie header
     */
    public void setCookie(String cookie);

    /**
     * Get the vim namespace used in SOAP payloads
     *
     * @return vim namespace used in SOAP Payloads
     */
    public String getVimNameSpace();

    /**
     * Sets the vim name space for the SOAP payload.
     *
     * @param vimNameSpace String
     */
    public void setVimNameSpace(String vimNameSpace);

    /**
     * Basic getter
     *
     * @return Time in milliseconds as an <code>int</code>
     */
    public int getConnectTimeout();

    /**
     * Sets a specified timeout value, in milliseconds, to be used
     * when opening a communications link to the resource referenced
     * by this Client.  If the timeout expires before the
     * connection can be established, a
     * java.net.SocketTimeoutException is raised. A timeout of zero is
     * interpreted as an infinite timeout. This is only used if your
     * client supports this setting.
     * <p>
     * <p> Some non-standard implementation of this method may ignore
     * the specified timeout. To see the connect timeout set, please
     * call getConnectTimeout().
     *
     * @param timeoutMilliSec an <code>int</code> that specifies the connect timeout value in milliseconds
     */
    public void setConnectTimeout(int timeoutMilliSec);

    /**
     * Returns the time in milliseconds that is set for the read timeout
     * <p>
     * This time may not be the same as what the underlying client uses. If
     * for example the client does not support this and is for some reason
     * hard coded to some value this value.
     *
     * @return Time in milliseconds
     */
    public int getReadTimeout();

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
     * @param timeoutMilliSec Integer time in milliseconds
     */
    public void setReadTimeout(int timeoutMilliSec);

    public TrustManager getTrustManager();

    /**
     * Sets the api version. The oldest supported will be v4.0
     *
     * @param apiVersion String with the api version.
     */
    public void setSoapActionOnApiVersion(String apiVersion);

    /**
     * Marshal the JAVA Object into a XML payload to send to the
     * server
     *
     * @param methodName String Name of the method to execute
     * @param paras      Array of Arguments aka params for the method
     * @return
     */
    public String marshall(String methodName, Argument[] paras);

    /**
     * Convert from an InputStream filled with an XML response
     * from the server to a given JAVA Object of returnType
     *
     * @param returnType
     * @param is
     * @return
     */
    public Object unMarshall(String returnType, InputStream is) throws Exception;

    /**
     * Read an InputStream filled with an XML response
     * from the server.
     *
     * @param stream
     * @return
     * @throws IOException
     */
    public StringBuffer readStream(InputStream stream) throws IOException;
}
