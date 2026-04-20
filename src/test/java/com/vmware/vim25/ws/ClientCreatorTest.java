package com.vmware.vim25.ws;

import org.junit.After;
import org.junit.Test;

import java.rmi.RemoteException;

import static org.junit.Assert.*;

public class ClientCreatorTest {

    @After
    public void resetClientClass() {
        ClientCreator.clientClass = WSClient.class;
    }

    @Test
    public void defaultClientClass_isWSClient() {
        assertSame(WSClient.class, ClientCreator.clientClass);
    }

    @Test
    public void getClient_withIgnoreCert_returnsWSClientInstance() throws Exception {
        Client client = ClientCreator.getClient("https://vcenter.example.com/sdk", true);
        assertNotNull(client);
        assertTrue(client instanceof WSClient);
    }

    @Test
    public void getClient_withIgnoreCertFalse_returnsWSClientInstance() throws Exception {
        Client client = ClientCreator.getClient("https://vcenter.example.com/sdk", false);
        assertNotNull(client);
        assertTrue(client instanceof WSClient);
    }

    @Test
    public void getClient_usesCustomClientClass_whenSet() throws Exception {
        ClientCreator.clientClass = StubClient.class;
        Client client = ClientCreator.getClient("https://vcenter.example.com/sdk", false);
        assertTrue(client instanceof StubClient);
    }

    // Minimal stub to verify ClientCreator uses clientClass field
    public static class StubClient extends WSClient {
        public StubClient(String url, boolean ignoreCert) throws Exception {
            super(url, ignoreCert);
        }
    }
}
