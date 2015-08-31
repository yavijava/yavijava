package com.vmware.vim25.ws;

import javax.net.ssl.TrustManager;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by Michael Rice on 8/11/14.
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
final public class ClientCreator {

    public static Class<?> clientClass = WSClient.class;

    public static Client getClient(String url, boolean ignoreCert) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor = clientClass.getConstructor(String.class, boolean.class);
        return (Client) constructor.newInstance(url, ignoreCert);
    }

    public static Client getClient(String url, TrustManager trustManager) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor = clientClass.getConstructor(String.class, boolean.class, TrustManager.class);
        return (Client) constructor.newInstance(url, false, trustManager);
    }
}
