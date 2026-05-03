package com.vmware.vim25.ws;

import org.junit.Test;

import javax.net.ssl.X509TrustManager;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import static org.junit.Assert.*;

public class ApacheHttpClientTest {

    private static final X509TrustManager NOOP_TRUST_MANAGER = new X509TrustManager() {
        public X509Certificate[] getAcceptedIssuers() { return new X509Certificate[0]; }
        public void checkClientTrusted(X509Certificate[] c, String a) throws CertificateException {}
        public void checkServerTrusted(X509Certificate[] c, String a) throws CertificateException {}
    };

    @Test
    public void constructor_stripsTrailingSlash() throws Exception {
        ApacheHttpClient client = new ApacheHttpClient("http://vcenter.example.com/", true);
        assertEquals("http://vcenter.example.com", client.getBaseUrl().toString());
    }

    @Test
    public void constructor_noTrailingSlash_urlUnchanged() throws Exception {
        ApacheHttpClient client = new ApacheHttpClient("http://vcenter.example.com", true);
        assertEquals("http://vcenter.example.com", client.getBaseUrl().toString());
    }

    @Test
    public void constructor_ignoreCertTrue_setsTrustAllSSL() throws Exception {
        ApacheHttpClient client = new ApacheHttpClient("http://vcenter.example.com", true);
        Field f = ApacheHttpClient.class.getDeclaredField("trustAllSSL");
        f.setAccessible(true);
        assertTrue(f.getBoolean(client));
    }

    @Test
    public void constructor_ignoreCertFalse_clearsTrustAllSSL() throws Exception {
        ApacheHttpClient client = new ApacheHttpClient("http://vcenter.example.com", false);
        Field f = ApacheHttpClient.class.getDeclaredField("trustAllSSL");
        f.setAccessible(true);
        assertFalse(f.getBoolean(client));
    }

    @Test
    public void oneArgConstructor_defaultsIgnoreCertToTrue() throws Exception {
        ApacheHttpClient client = new ApacheHttpClient("http://vcenter.example.com");
        Field f = ApacheHttpClient.class.getDeclaredField("trustAllSSL");
        f.setAccessible(true);
        assertTrue(f.getBoolean(client));
    }

    @Test
    public void constructor_withTrustManager_storesTrustManager() throws Exception {
        ApacheHttpClient client = new ApacheHttpClient("http://vcenter.example.com", false, NOOP_TRUST_MANAGER);
        assertSame(NOOP_TRUST_MANAGER, client.getTrustManager());
    }

    @Test(expected = MalformedURLException.class)
    public void constructor_malformedUrl_throwsMalformedURLException() throws Exception {
        new ApacheHttpClient("not-a-url", true);
    }

    @Test
    public void post_returnsBufferedStream_closesHttpResources() throws Exception {
        try (ServerSocket serverSocket = new ServerSocket(0)) {
            int port = serverSocket.getLocalPort();
            Thread serverThread = new Thread(() -> {
                try (Socket socket = serverSocket.accept()) {
                    BufferedReader reader = new BufferedReader(
                        new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
                    String line;
                    while ((line = reader.readLine()) != null && !line.isEmpty()) { /* drain headers */ }
                    String body = "<response/>";
                    String http = "HTTP/1.1 200 OK\r\n"
                        + "Content-Type: text/xml\r\n"
                        + "Content-Length: " + body.length() + "\r\n"
                        + "\r\n"
                        + body;
                    socket.getOutputStream().write(http.getBytes(StandardCharsets.UTF_8));
                    socket.getOutputStream().flush();
                } catch (IOException ignored) {}
            });
            serverThread.setDaemon(true);
            serverThread.start();

            ApacheHttpClient client = new ApacheHttpClient("http://localhost:" + port, false);
            Method postMethod = ApacheHttpClient.class.getDeclaredMethod("post", String.class);
            postMethod.setAccessible(true);

            InputStream result = (InputStream) postMethod.invoke(client, "<request/>");

            assertNotNull(result);
            assertTrue("Expected ByteArrayInputStream but got " + result.getClass().getName(),
                result instanceof ByteArrayInputStream);
        }
    }
}
