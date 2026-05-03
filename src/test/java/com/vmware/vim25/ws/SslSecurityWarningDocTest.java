package com.vmware.vim25.ws;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class SslSecurityWarningDocTest {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> sources() {
        return Arrays.asList(new Object[][]{
            {"src/main/java/com/vmware/vim25/ws/ApacheTrustSelfSigned.java"},
            {"src/main/java/com/vmware/vim25/ws/CustomSSLTrustContextCreator.java"},
            {"src/main/java/com/vmware/vim25/mo/util/VerUtil.java"},
        });
    }

    private final String sourcePath;

    public SslSecurityWarningDocTest(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    @Test
    public void sourceContainsSslDisablesSecurityWarning() throws IOException {
        String source = new String(Files.readAllBytes(Paths.get(sourcePath)));
        assertTrue("Expected @apiNote SSL security warning in " + sourcePath,
            source.contains("@apiNote"));
    }
}
