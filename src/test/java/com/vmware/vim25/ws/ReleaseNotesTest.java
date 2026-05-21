package com.vmware.vim25.ws;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.assertTrue;

public class ReleaseNotesTest {

    private static String updates() throws IOException {
        return new String(Files.readAllBytes(Paths.get("UPDATES.md")));
    }

    private static String relNote() throws IOException {
        return new String(Files.readAllBytes(Paths.get("rel-note.txt")));
    }

    @Test
    public void updatesDoc_referencesVersion9() throws IOException {
        assertTrue("Expected '9.0' release heading in UPDATES.md",
            updates().contains("Upgrade Notes — 9.0"));
    }

    @Test
    public void updatesDoc_documentsGuestManagerNpeFix() throws IOException {
        assertTrue("Expected GuestFileManager NPE fix entry in UPDATES.md",
            updates().contains("GuestFileManager"));
    }

    @Test
    public void updatesDoc_documentsHttpClient5_5_2() throws IOException {
        assertTrue("Expected httpclient5 5.5.2 in UPDATES.md dependency table",
            updates().contains("5.5.2"));
    }

    @Test
    public void updatesDoc_documentsCrlfCleanup() throws IOException {
        assertTrue("Expected CRLF line-ending cleanup entry in UPDATES.md",
            updates().contains("CRLF"));
    }

    @Test
    public void relNote_hasVersion9Entry() throws IOException {
        assertTrue("Expected 9.0 entry in rel-note.txt",
            relNote().contains("9.0"));
    }

    // --- items not covered in initial pass ---

    @Test
    public void updatesDoc_documentsInventoryNavigatorPagination() throws IOException {
        assertTrue("Expected InventoryNavigator pagination fix in UPDATES.md",
            updates().contains("InventoryNavigator"));
    }

    @Test
    public void updatesDoc_documentsHostnameVerifierFix() throws IOException {
        assertTrue("Expected HostnameVerifier IP-address fix in UPDATES.md",
            updates().contains("HostnameVerifier"));
    }

    @Test
    public void updatesDoc_documentsSerializableDataClasses() throws IOException {
        assertTrue("Expected Serializable vim25 data classes in UPDATES.md",
            updates().contains("Serializable"));
    }

    @Test
    public void updatesDoc_documentsTaskWaitForTaskTimeout() throws IOException {
        assertTrue("Expected Task.waitForTask timeout overload in UPDATES.md",
            updates().contains("waitForTask"));
    }

    @Test
    public void updatesDoc_documentsFailoverClusterWrappers() throws IOException {
        assertTrue("Expected FailoverCluster wrapper classes in UPDATES.md",
            updates().contains("FailoverCluster"));
    }

    @Test
    public void updatesDoc_documentsCacheInstanceAwaitReady() throws IOException {
        assertTrue("Expected CacheInstance.awaitReady in UPDATES.md",
            updates().contains("awaitReady"));
    }

    // --- 9.0.1 patch release ---

    @Test
    public void updatesDoc_documents901Section() throws IOException {
        assertTrue("Expected 9.0.1 section heading in UPDATES.md",
            updates().contains("9.0.1"));
    }

    @Test
    public void updatesDoc_documentsVtpmByteArrayFix() throws IOException {
        assertTrue("Expected VirtualTPM byte[][] fix entry in UPDATES.md",
            updates().contains("VirtualTPM"));
    }

    @Test
    public void updatesDoc_documentsSerialVersionUidLogSpamFix() throws IOException {
        assertTrue("Expected serialVersionUID log spam fix entry in UPDATES.md",
            updates().contains("serialVersionUID"));
    }

    @Test
    public void relNote_hasVersion901Entry() throws IOException {
        assertTrue("Expected 9.0.1 entry in rel-note.txt",
            relNote().contains("9.0.1"));
    }
}
