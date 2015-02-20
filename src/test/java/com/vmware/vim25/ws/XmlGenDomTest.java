package com.vmware.vim25.ws;

import com.vmware.vim25.InvalidLogin;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class XmlGenDomTest {

    @Test(expected = InvalidLogin.class)
    public void testFromXML_Throws_Invalid_Login_When_Login_is_Invalid() throws Exception {
        InputStream inputStream = new FileInputStream(new File("src/test/java/com/vmware/vim25/ws/xml/InvalidLoginFault.xml"));
        XmlGenDom xmlGenDom = new XmlGenDom();
        xmlGenDom.fromXML("Login", inputStream);
    }

}