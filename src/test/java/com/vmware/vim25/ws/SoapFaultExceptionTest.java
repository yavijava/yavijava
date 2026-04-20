package com.vmware.vim25.ws;

import org.junit.Test;

import java.rmi.RemoteException;

import static org.junit.Assert.*;

public class SoapFaultExceptionTest {

    @Test
    public void isARemoteException() {
        assertTrue(new SoapFaultException() instanceof RemoteException);
    }

    @Test
    public void defaultValues_areNull() {
        SoapFaultException ex = new SoapFaultException();
        assertNull(ex.getFaultCode());
        assertNull(ex.getFaultString());
        assertNull(ex.getFaultActor());
    }

    @Test
    public void setFaultCode_roundTrips() {
        SoapFaultException ex = new SoapFaultException();
        ex.setFaultCode("Server.Authentication");
        assertEquals("Server.Authentication", ex.getFaultCode());
    }

    @Test
    public void setFaultString_roundTrips() {
        SoapFaultException ex = new SoapFaultException();
        ex.setFaultString("Cannot complete login due to an incorrect user name or password.");
        assertEquals("Cannot complete login due to an incorrect user name or password.", ex.getFaultString());
    }

    @Test
    public void setFaultActor_roundTrips() {
        SoapFaultException ex = new SoapFaultException();
        ex.setFaultActor("urn:vim25");
        assertEquals("urn:vim25", ex.getFaultActor());
    }

    @Test
    public void allFieldsIndependent() {
        SoapFaultException ex = new SoapFaultException();
        ex.setFaultCode("code");
        ex.setFaultString("string");
        ex.setFaultActor("actor");
        assertEquals("code", ex.getFaultCode());
        assertEquals("string", ex.getFaultString());
        assertEquals("actor", ex.getFaultActor());
    }
}
