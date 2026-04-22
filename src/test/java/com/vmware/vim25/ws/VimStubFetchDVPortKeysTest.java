package com.vmware.vim25.ws;

import com.vmware.vim25.ManagedObjectReference;
import org.junit.Test;

import javax.net.ssl.TrustManager;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class VimStubFetchDVPortKeysTest {

    private static Client clientReturning(Object result) {
        return new Client() {
            public Object invoke(String m, Argument[] p, String r) { return result; }
            public StringBuffer invokeAsString(String m, Argument[] p) { return null; }
            public URL getBaseUrl() { return null; }
            public void setBaseUrl(URL u) {}
            public String getCookie() { return null; }
            public void setCookie(String c) {}
            public String getVimNameSpace() { return null; }
            public void setVimNameSpace(String v) {}
            public int getConnectTimeout() { return 0; }
            public void setConnectTimeout(int t) {}
            public int getReadTimeout() { return 0; }
            public void setReadTimeout(int t) {}
            public TrustManager getTrustManager() { return null; }
            public void setSoapActionOnApiVersion(String v) {}
            public String marshall(String m, Argument[] p) { return null; }
            public Object unMarshall(String r, InputStream is) { return null; }
            public StringBuffer readStream(InputStream s) throws IOException { return null; }
        };
    }

    @Test
    public void fetchDVPortKeys_whenServerReturnsStringArray_returnsStringArray() throws Exception {
        VimStub stub = new VimStub(clientReturning(new String[]{"port-1", "port-2"}));
        String[] result = stub.fetchDVPortKeys(new ManagedObjectReference(), null);
        assertArrayEquals(new String[]{"port-1", "port-2"}, result);
    }

    @Test
    public void fetchDVPortKeys_whenServerReturnsArrayList_returnsStringArray() throws Exception {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("port-1", "port-2"));
        VimStub stub = new VimStub(clientReturning(list));
        String[] result = stub.fetchDVPortKeys(new ManagedObjectReference(), null);
        assertArrayEquals(new String[]{"port-1", "port-2"}, result);
    }

    @Test
    public void fetchDVPortKeys_whenServerReturnsEmptyArrayList_returnsEmptyStringArray() throws Exception {
        VimStub stub = new VimStub(clientReturning(new ArrayList<String>()));
        String[] result = stub.fetchDVPortKeys(new ManagedObjectReference(), null);
        assertArrayEquals(new String[0], result);
    }
}
