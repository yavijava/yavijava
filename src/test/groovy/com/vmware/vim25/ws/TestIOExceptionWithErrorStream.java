package com.vmware.vim25.ws;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class TestIOExceptionWithErrorStream extends HttpURLConnection{
    TestIOExceptionWithErrorStream() throws MalformedURLException{
        super(new URL("http://www.foo.com"));
    }
    @Override
    public void disconnect() {
    }
    @Override
    public boolean usingProxy() {
        return false;
    }
    @Override
    public void connect() throws IOException {
    }
    @Override
    public InputStream getInputStream() throws IOException{
        throw new IOException();
    }
    @Override
    public InputStream getErrorStream() {
        String s = "There was an error retrieving the InputStream";
        return new ByteArrayInputStream(s.getBytes());
    }
}
