package com.vmware.vim25;

import com.vmware.vim25.ws.WSClient;

public class VimPortType extends com.vmware.vim25.ws.VimStub 
{
  public VimPortType(String url, boolean ignoreCert) throws java.net.MalformedURLException
  {
    super(url, ignoreCert);
  }
  
  public VimPortType(WSClient url) throws java.net.MalformedURLException
  {
    super(url);
  }
}
