package com.vmware.spbm.ws;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import com.vmware.vim25.ws.Client;

/**
 * Atoka Sema
 */
final public class PbmClientCreator {

    public static Class<?> clientClass = PbmWSClient.class;

    public static Client getClient(String url, String sessionStr, boolean ignoreCert) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Constructor<?> constructor = clientClass.getConstructor(String.class, String.class, boolean.class);
        return (Client) constructor.newInstance(new Object[]{url, sessionStr, ignoreCert});
    }
}
