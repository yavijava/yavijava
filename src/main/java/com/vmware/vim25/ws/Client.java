package com.vmware.vim25.ws;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.rmi.RemoteException;

/**
 * Copyright 2014 Michael Rice
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

public interface Client {

    public Object invoke(String methodName, Argument[] paras, String returnType) throws RemoteException;
    public StringBuffer invokeAsString(String methodName, Argument[] paras) throws RemoteException;
    public InputStream post(String soapMsg) throws IOException;
    public URL getBaseUrl();
    public void setBaseUrl(URL baseUrl);
    public String getCookie();

    public void setCookie(String cookie);
    public String getVimNameSpace();
    public void setVimNameSpace(String vimNameSpace);

    public void setConnectTimeout(int timeoutMilliSec);
    public int getConnectTimeout();

    public void setReadTimeout(int timeoutMilliSec);
    public int getReadTimeout();

    public void setSoapActionOnApiVersion(String apiVersion);

}
