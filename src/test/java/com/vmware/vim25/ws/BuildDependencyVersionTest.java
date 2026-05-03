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

    @Test
    public void intTest_task_calls_useJUnitPlatform() throws IOException {
        String content = buildGradle();
        int first = content.indexOf("useJUnitPlatform()");
        int second = content.indexOf("useJUnitPlatform()", first + 1);
        assertTrue("Expected useJUnitPlatform() in both test and intTest tasks", second != -1);
    }

    @Test
    public void intTest_task_has_addOpens_jvmArg() throws IOException {
        String content = buildGradle();
        int first = content.indexOf("java.base/java.lang=ALL-UNNAMED");
        int second = content.indexOf("java.base/java.lang=ALL-UNNAMED", first + 1);
        assertTrue("Expected --add-opens java.base/java.lang=ALL-UNNAMED in both test and intTest tasks",
            second != -1);
    }
}
