package com.vmware.vim25.ws;

import com.vmware.vim25.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
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
    public void set_Detail_Message_overwrites_existing_message() throws Exception {
        Throwable throwable = new Throwable("original message");
        Throwable result = (Throwable) XmlGenDom.setDetailMessageInException(throwable, "new message");
        Assert.assertEquals("new message", result.getMessage());
    }

    @Test(expected = RemoteException.class)
    public void testFromXML_Throws_DocumentException() throws Exception {
        InputStream inputStream = new FileInputStream(new File("src/test/java/com/vmware/vim25/ws/xml/CatchDocumentExceptionTest.xml"));
        XmlGenDom xmlGenDom = new XmlGenDom();
        xmlGenDom.fromXML("Login", inputStream);
    }

    @Test
    public void fromXML_documentException_causeIsUnwrappedParseError_notDocumentException() throws Exception {
        // The RemoteException thrown for a DocumentException must expose the underlying
        // parse error as its cause, not the DocumentException wrapper itself.
        String malformedXml = "<not-closed";
        InputStream is = new ByteArrayInputStream(malformedXml.getBytes(StandardCharsets.UTF_8));
        try {
            new XmlGenDom().fromXML("String", is);
            Assert.fail("Expected RemoteException");
        } catch (RemoteException e) {
            Assert.assertNotNull("RemoteException must have a cause", e.getCause());
            Assert.assertFalse("cause must not be the DocumentException wrapper itself",
                e.getCause() instanceof org.dom4j.DocumentException);
        }
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
        byte[] exptected = java.util.Base64.getDecoder().decode("ox991LwhCGLf2gntXqKkSPdqC+A=");
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

    @Test
    public void testFromXML_When_UpdateSet_Contains_Base64_Binary_No_Exception_Is_Thrown() throws Exception {
        InputStream inputStream = new FileInputStream(new File("src/test/resources/xml/UpdateSetWithBase64Binary.xml"));
        XmlGenDom xmlGenDom = new XmlGenDom();
        UpdateSet updateSet = (UpdateSet) xmlGenDom.fromXML("UpdateSet", inputStream);
    }

    @Test(expected = RemoteException.class)
    public void fromXML_withDoctypeDeclaration_throwsRemoteException() throws Exception {
        // DOCTYPE declarations must be rejected to prevent XXE attacks and offline
        // DTD-fetch failures (issues #293, #240).
        String payload = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<!DOCTYPE foo>\n" +
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            "  <soapenv:Body><foo/></soapenv:Body>\n" +
            "</soapenv:Envelope>";
        InputStream is = new ByteArrayInputStream(payload.getBytes(StandardCharsets.UTF_8));
        new XmlGenDom().fromXML("String", is);
    }

    @Test(expected = RemoteException.class)
    public void fromXML_withExternalEntityReference_throwsRemoteException() throws Exception {
        // External entity injection must be blocked (issue #293).
        String payload = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<!DOCTYPE foo [<!ENTITY xxe SYSTEM \"file:///etc/passwd\">]>\n" +
            "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
            "  <soapenv:Body><foo>&xxe;</foo></soapenv:Body>\n" +
            "</soapenv:Envelope>";
        InputStream is = new ByteArrayInputStream(payload.getBytes(StandardCharsets.UTF_8));
        new XmlGenDom().fromXML("String", is);
    }

    @Test
    public void testFromXML_ObjectContentWithMissingSet_ParsesMissingPropertyFault() throws Exception {
        InputStream inputStream = new FileInputStream(
            new File("src/test/java/com/vmware/vim25/ws/xml/ObjectContentWithMissingSet.xml"));
        XmlGenDom xmlGenDom = new XmlGenDom();
        ObjectContent objectContent = (ObjectContent) xmlGenDom.fromXML("ObjectContent", inputStream);

        Assert.assertNotNull("missingSet should be populated", objectContent.getMissingSet());
        Assert.assertEquals(1, objectContent.getMissingSet().length);

        MissingProperty mp = objectContent.getMissingSet()[0];
        Assert.assertEquals("config", mp.getPath());
        Assert.assertNotNull("MissingProperty.fault should not be null", mp.getFault());
        Assert.assertEquals(
            "Permission to perform this operation was denied.",
            mp.getFault().getLocalizedMessage());
        Assert.assertNotNull("LocalizedMethodFault.fault should not be null", mp.getFault().getFault());
        Assert.assertTrue(
            "inner fault should be a NoPermission",
            mp.getFault().getFault() instanceof com.vmware.vim25.NoPermission);

        com.vmware.vim25.NoPermission np =
            (com.vmware.vim25.NoPermission) mp.getFault().getFault();
        Assert.assertEquals("System.Read", np.privilegeId);
    }

    @Test
    public void testFromXML_TagArrayProperty_DeserializesAsTagArray() throws Exception {
        // Issue #228: ManagedEntity.tag (Tag[]) and triggeredAlarmState (AlarmState[])
        // came back as raw java.lang.Object via DynamicProperty.val. The XML in the
        // wild uses xsi:type="ArrayOfTag" / "ArrayOfAlarmState" wrappers around the items.
        InputStream inputStream = new FileInputStream(
            new File("src/test/java/com/vmware/vim25/ws/xml/ObjectContentWithTagAndAlarmState.xml"));
        XmlGenDom xmlGenDom = new XmlGenDom();
        ObjectContent objectContent = (ObjectContent) xmlGenDom.fromXML("ObjectContent", inputStream);

        Assert.assertNotNull(objectContent.getPropSet());
        Assert.assertEquals(2, objectContent.getPropSet().length);

        Object tagVal = objectContent.getPropSet()[0].getVal();
        Assert.assertNotNull("tag value should not be null", tagVal);
        Assert.assertTrue(
            "tag value should be Tag[], got " + tagVal.getClass().getName(),
            tagVal instanceof Tag[]);
        Tag[] tags = (Tag[]) tagVal;
        Assert.assertEquals(2, tags.length);
        Assert.assertEquals("com.vmware.cis.tagging.Tag:abcd-1234", tags[0].getKey());
        Assert.assertEquals("com.vmware.cis.tagging.Tag:efgh-5678", tags[1].getKey());

        Object alarmVal = objectContent.getPropSet()[1].getVal();
        Assert.assertNotNull("triggeredAlarmState value should not be null", alarmVal);
        Assert.assertTrue(
            "triggeredAlarmState value should be AlarmState[], got " + alarmVal.getClass().getName(),
            alarmVal instanceof AlarmState[]);
        AlarmState[] states = (AlarmState[]) alarmVal;
        Assert.assertEquals(1, states.length);
        Assert.assertEquals("alarm-1.vm-42", states[0].getKey());
        Assert.assertEquals(ManagedEntityStatus.red, states[0].getOverallStatus());
    }

    @Test
    public void testFromXML_VirtualTPM_with_byteArrayArray_fields_deserialize_correctly() throws Exception {
        InputStream inputStream = new FileInputStream(new File("src/test/resources/xml/VirtualTPMWithEndorsementKeyCSR.xml"));
        XmlGenDom xmlGenDom = new XmlGenDom();
        VirtualTPM vtpm = (VirtualTPM) xmlGenDom.fromXML("VirtualTPM", inputStream);
        Assert.assertNotNull("VirtualTPM should not be null", vtpm);
        Assert.assertNotNull("endorsementKeyCertificateSigningRequest should not be null",
            vtpm.endorsementKeyCertificateSigningRequest);
        Assert.assertEquals("should have 2 CSR entries", 2,
            vtpm.endorsementKeyCertificateSigningRequest.length);
        Assert.assertArrayEquals("first CSR entry should decode to 0x01 0x02 0x03",
            new byte[]{0x01, 0x02, 0x03}, vtpm.endorsementKeyCertificateSigningRequest[0]);
        Assert.assertArrayEquals("second CSR entry should decode to 0x04 0x05 0x06",
            new byte[]{0x04, 0x05, 0x06}, vtpm.endorsementKeyCertificateSigningRequest[1]);
        Assert.assertNotNull("endorsementKeyCertificate should not be null",
            vtpm.endorsementKeyCertificate);
        Assert.assertEquals("should have 2 certificate entries", 2,
            vtpm.endorsementKeyCertificate.length);
        Assert.assertArrayEquals("first certificate entry should decode to 0x07 0x08 0x09",
            new byte[]{0x07, 0x08, 0x09}, vtpm.endorsementKeyCertificate[0]);
        Assert.assertArrayEquals("second certificate entry should decode to 0x0A 0x0B 0x0C",
            new byte[]{0x0A, 0x0B, 0x0C}, vtpm.endorsementKeyCertificate[1]);
    }

    @Test
    public void testFromXML_PerfCounterInfoWithUnknownSubtype_ParsesGracefully() throws Exception {
        InputStream inputStream = new FileInputStream(
            new File("src/test/java/com/vmware/vim25/ws/xml/PerfCounterInfoWithUnknownSubtype.xml"));
        XmlGenDom xmlGenDom = new XmlGenDom();
        ObjectContent objectContent = (ObjectContent) xmlGenDom.fromXML("ObjectContent", inputStream);

        Assert.assertNotNull(objectContent.getPropSet());
        Assert.assertEquals(1, objectContent.getPropSet().length);

        PerfCounterInfo[] counters = (PerfCounterInfo[]) objectContent.getPropSet()[0].getVal();
        Assert.assertNotNull("counter array should not be null", counters);
        Assert.assertEquals("should have parsed both counters", 2, counters.length);

        Assert.assertEquals("first counter key", 1, counters[0].getKey());
        Assert.assertEquals("unknown-subtype counter key should be 369", 369, counters[1].getKey());
    }
}
