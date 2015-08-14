package com.vmware.vim25.ws;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class TestIOExceptionNullErrorStream extends HttpURLConnection{
    TestIOExceptionNullErrorStream() throws MalformedURLException{
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
    public InputStream getErrorStream(){
        return null;
    }
}
