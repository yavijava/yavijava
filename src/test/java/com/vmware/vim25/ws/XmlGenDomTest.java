package com.vmware.vim25.ws;

import com.vmware.vim25.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.ReflectPermission;
import java.rmi.RemoteException;
import java.security.AccessControlException;
import java.util.Objects;

public class XmlGenDomTest {

    @Test
    public void testFromXML_UnknownClass() throws Exception {
        // simulate with non-existing class
        InputStream inputStream = new FileInputStream(new File("src/test/resources/xml/UnknownConfigSpec.xml"));
        XmlGenDom xmlGenDom = new XmlGenDom();
        Object nullObject = xmlGenDom.fromXML("UnknownConfigSpec", inputStream);
        assert nullObject == null;
    }

    @Test(expected = InvalidLogin.class)
    public void testFromXML_Throws_Invalid_Login_When_Login_is_Invalid() throws Exception {
        InputStream inputStream = new FileInputStream(new File("src/test/java/com/vmware/vim25/ws/xml/InvalidLoginFault.xml"));
        XmlGenDom xmlGenDom = new XmlGenDom();
        xmlGenDom.fromXML("Login", inputStream);
    }

    @Test(expected = RemoteException.class)
    public void parseSoapFault_Throws_RuntimeException() throws Exception {
        InputStream inputStream = new FileInputStream(new File("src/test/java/com/vmware/vim25/ws/xml/CatchRuntimeExceptionTest.xml"));
        XmlGenDom xmlGenDom = new XmlGenDom();
        xmlGenDom.fromXML("Login", inputStream);
    }

    @Test
    public void set_Detail_Message_Adds_Detail_Message_to_Exception() throws Exception {
        InputStream inputStream = new FileInputStream(new File("src/test/java/com/vmware/vim25/ws/xml/InvalidLoginFault.xml"));
        XmlGenDom xmlGenDom = new XmlGenDom();
        try{
            xmlGenDom.fromXML("Login", inputStream);
        } catch (InvalidLogin e) {
            Assert.assertTrue(e.getMessage().equals("Cannot complete login due to an incorrect user name or password."));
        }
    }

    @Test
    public void set_Detail_Message_throws_Exception() throws Exception {
        SecurityManager previous = System.getSecurityManager();
        try {
            SecurityManager securityManager = new SecurityManager() {
                @Override
                public void checkPermission(java.security.Permission perm) {
                    if (perm instanceof ReflectPermission && "suppressAccessChecks".equals((perm.getName()))) {
                        for (StackTraceElement elem : Thread.currentThread().getStackTrace()) {
                            if ("com.vmware.vim25.ws.XmlGenDom".equals(elem.getClassName())) {
                                throw new AccessControlException("Access Denied!");
                            }
                        }
                    }
                }
            };
            System.setSecurityManager(securityManager);

            Throwable throwable = new Throwable("Illegal Access");
            Throwable noMessage = (Throwable) XmlGenDom.setDetailMessageInException(throwable, "Error occured");
            Assert.assertFalse(noMessage.getMessage().equals("Error occured"));
        } catch (Exception e) {
            throw e;
        } finally {
            System.setSecurityManager(previous);
        }
    }

    @Test(expected = RemoteException.class)
    public void testFromXML_Throws_DocumentException() throws Exception {
        InputStream inputStream = new FileInputStream(new File("src/test/java/com/vmware/vim25/ws/xml/CatchDocumentExceptionTest.xml"));
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

    @Test
    public void testFromXML_vmxConfigChecksum_with_Base64_value_parses_correctly_to_byteArray() throws Exception {
        InputStream inputStream = new FileInputStream(new File("src/test/resources/xml/RetrievePropertiesVirtualMachineConfigInfoWithBase64BinaryFields.xml"));
        XmlGenDom xmlGenDom = new XmlGenDom();
        ObjectContent objectContent = (ObjectContent) xmlGenDom.fromXML("ObjectContent", inputStream);
        DynamicProperty[] dps = objectContent.getPropSet();
        VirtualMachineConfigInfo configInfo = (VirtualMachineConfigInfo) dps[0].getVal();
        byte[] exptected = javax.xml.bind.DatatypeConverter.parseBase64Binary("ox991LwhCGLf2gntXqKkSPdqC+A=");
        Assert.assertArrayEquals(configInfo.getVmxConfigChecksum(), exptected);
    }

    @Test
    public void testFromXML_payload_with_normal_byte_array_parses_into_byte_array() throws Exception {
        InputStream inputStream = new FileInputStream(new File("src/test/resources/xml/RetrievePropertiesHostSystemWithByteArray.xml"));
        XmlGenDom xmlGenDom = new XmlGenDom();
        ObjectContent objectContent = (ObjectContent) xmlGenDom.fromXML("ObjectContent", inputStream);
        DynamicProperty[] dps = objectContent.getPropSet();
        HostConfigInfo hostConfigInfo = (HostConfigInfo) dps[0].getVal();
        String actualCert = "";
        for (byte b: hostConfigInfo.certificate) {
            actualCert += (char) b;
        }
        String expectedCert = "-----BEGIN CERTIFICATE-----\n" +
            "MIID8TCCAtmgAwIBAgIGUYXaqhnAMA0GCSqGSIb3DQEBBQUAMBsxGTAXBgNVBAoT\n" +
            "EFZNd2FyZSBJbnN0YWxsZXIwHhcNMTIwMzEzMTgwNTM0WhcNMjMwOTEyMTgwNTM0\n" +
            "WjCB+jELMAkGA1UEBhMCVVMxEzARBgNVBAgTCkNhbGlmb3JuaWExEjAQBgNVBAcT\n" +
            "CVBhbG8gQWx0bzEUMBIGA1UEChMLVk13YXJlLCBJbmMxLjAsBgNVBAsTJVZNd2Fy\n" +
            "ZSBFU1ggU2VydmVyIERlZmF1bHQgQ2VydGlmaWNhdGUxKjAoBgkqhkiG9w0BCQEW\n" +
            "G3NzbC1jZXJ0aWZpY2F0ZXNAdm13YXJlLmNvbTEeMBwGA1UEAxMVbG9jYWxob3N0\n" +
            "LmxvY2FsZG9tYWluMTAwLgYJKoZIhvcNAQkCEyExMzMxNjYxOTMzLDU2NGQ3NzYx\n" +
            "NzI2NTIwNDk2ZTYzMmUwggEiMA0GCSqGSIb3DQEBAQUAA4IBDwAwggEKAoIBAQCs\n" +
            "IZvV/C3wuOMqbby0CCevkTw3SQmBH63s5r+fNTUjkyxgvq1dvqJiaGcV0xcH980N\n" +
            "HU5TgxdD3WcV0yeDJdc5f14JilsMMdqd9MN7PFfRlOWylvvSjcyCUixxMZOxGLLy\n" +
            "gJaYxsOOt60AJbaGn4efcsr9/PgF3yOgXBKIiOd0EaBzb+fshMQCHiS9Kx92IzmV\n" +
            "2q+jKTPH/miY7whQF8YeW6z3f+8LTHiOKm6u2+8a3kb2is/NuLgt4iiPFuHWjM2h\n" +
            "TIjssehJqLK1O1np3cE9YcojgT4rLe/BnfvekM56DLZ75oM59QpOONqcT1KHrln/\n" +
            "hh4R2gvkGQPkx/Mtz/+pAgMBAAGjWzBZMAkGA1UdEwQCMAAwCwYDVR0PBAQDAgSw\n" +
            "MB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjAgBgNVHREEGTAXghVsb2Nh\n" +
            "bGhvc3QubG9jYWxkb21haW4wDQYJKoZIhvcNAQEFBQADggEBAF74Mxb4pmeaFmvC\n" +
            "BOX4TpIPKnWdwL0anmceeZtQJ2QNbc3QwFFCDh29+jxm2BbowHau4FgpY0xngvwJ\n" +
            "rCSfa0iw5K4TAEhYQMnDdylNmqxEaJ+Hs8C2Vs7kzpVJItZrJlNLsPEM6hKY/ZFx\n" +
            "x/huXEnva2kqQIxvl7HIDPwTDbnetEmaa85MXRLQ/UWo+lTJd9iRaGwxnXoZ/nl4\n" +
            "qe06mVt64QsRj/SlrkH6J4TMjD/YNh81A/JydlPqFKM0dvib9US+ZVAJRaSoEMXe\n" +
            "4rfcRl7Ddu29cCqIv81aJwW+ZAdxfY/QsRsvRXp1X/tozj6rE5+vAznvyCAtHR2I\n" +
            "VOTvbDk=\n" +
            "-----END CERTIFICATE-----\n";
        Assert.assertEquals(actualCert, expectedCert);
    }

    @Test
    public void testFromXML_environment_variables_return_as_string_array() throws Exception {
        InputStream inputStream = new FileInputStream(new File("src/test/java/com/vmware/vim25/ws/xml/ReadEnvironmentVariableInGuest.xml"));
        XmlGenDom xmlGenDom = new XmlGenDom();
        String[] strings = (String[]) xmlGenDom.fromXML("String[]", inputStream);
        assert strings.getClass().isArray();
    }

    @Test
    public void testFromXML_Folder_GetChildrenTypes() throws Exception {
        InputStream inputStream = new FileInputStream(new File("src/test/java/com/vmware/vim25/ws/xml/Folder_GetChildType_String_Array.xml"));
        XmlGenDom xmlGenDom = new XmlGenDom();
        String[] strings = (String[]) xmlGenDom.fromXML("String[]", inputStream);
        assert strings.getClass().isArray();
    }
}
