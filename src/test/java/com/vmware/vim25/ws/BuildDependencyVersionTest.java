package com.vmware.vim25.ws;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class BuildDependencyVersionTest {

    private static String buildGradle() throws IOException {
        return new String(Files.readAllBytes(Paths.get("build.gradle")));
    }

    @Test
    public void objenesis_isAtLeast_3_4() throws IOException {
        assertTrue("Expected objenesis:3.4 in build.gradle",
            buildGradle().contains("objenesis:3.4"));
    }

    @Test
    public void lombok_isAtLeast_1_18_38() throws IOException {
        assertTrue("Expected lombok:1.18.38 in build.gradle",
            buildGradle().contains("lombok:1.18.38"));
    }
}
