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
}
