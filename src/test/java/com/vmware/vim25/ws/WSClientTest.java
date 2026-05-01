package com.vmware.vim25.ws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.rmi.RemoteException;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

import com.vmware.vim25.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class WSClientTest {

    @Test(expected = InvalidLogin.class)
    public void testUnMarshall_Throws_InvalidLogin_When_Login_is_Invalid() throws RemoteException {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("src/test/java/com/vmware/vim25/ws/xml/InvalidLoginFault.xml"));
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XmlGenDom xmlGenDom = new XmlGenDom();
        xmlGenDom.fromXML("Login", inputStream);
    }

    @Test
    public void applyHttpsConfig_ignoreCertTrue_setsTrustAllHostnameVerifierOnConnection() throws Exception {
        // Issue #115: when ignoreCert=true and the user connects by IP, the JDK default
        // hostname verifier rejects the connection because the cert's SAN doesn't match
        // the IP. Setting setDefaultHostnameVerifier globally inside TrustAllSSL is
        // unreliable (timing of when the connection captures the default). The verifier
        // must be set on each per-connection HttpsURLConnection.
        WSClient client = new WSClient("https://192.0.2.1/sdk", true);
        HttpsURLConnection con = (HttpsURLConnection) new URL("https://192.0.2.1/sdk").openConnection();

        client.applyHttpsConfig(con);

        HostnameVerifier verifier = con.getHostnameVerifier();
        assertNotNull("hostname verifier should be set when ignoreCert=true", verifier);
        assertTrue("trust-all verifier should accept any hostname",
            verifier.verify("any-host", null));
        assertTrue("trust-all verifier should accept IP address style hosts",
            verifier.verify("192.0.2.1", null));
        assertNotNull("ssl socket factory should be set", con.getSSLSocketFactory());
    }

    @Test
    public void applyHttpsConfig_ignoreCertFalse_doesNotOverrideHostnameVerifier() throws Exception {
        WSClient client = new WSClient("https://192.0.2.1/sdk", false);
        HttpsURLConnection con = (HttpsURLConnection) new URL("https://192.0.2.1/sdk").openConnection();
        HostnameVerifier original = con.getHostnameVerifier();

        client.applyHttpsConfig(con);

        // When ignoreCert=false we honor the JDK's default hostname verification;
        // overriding here would silently weaken security for users who didn't ask for it.
        assertSame("hostname verifier should be untouched when ignoreCert=false",
            original, con.getHostnameVerifier());
    }
}
