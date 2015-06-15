package com.vmware.vim25.ws;

import com.vmware.vim25.InvalidLogin;
import com.vmware.vim25.UserSession;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Objects;

import static org.junit.Assert.*;

public class XmlGenDomTest {

    @Test(expected = InvalidLogin.class)
    public void testFromXML_Throws_Invalid_Login_When_Login_is_Invalid() throws Exception {
        InputStream inputStream = new FileInputStream(new File("src/test/java/com/vmware/vim25/ws/xml/InvalidLoginFault.xml"));
        XmlGenDom xmlGenDom = new XmlGenDom();
        xmlGenDom.fromXML("Login", inputStream);
    }

    @Test
    public void testFromXML_ValidUserSessionReturnsValidUserSession() throws Exception {
        InputStream inputStream = new FileInputStream(new File("src/test/resources/xml/UserSessionValidLoginSession.xml"));
        XmlGenDom xmlGenDom = new XmlGenDom();
        UserSession session = (UserSession) xmlGenDom.fromXML("UserSession", inputStream);
        assert Objects.equals(session.getKey(), "5202c417-3a62-54c8-db48-61c00c1909e4");
    }
}