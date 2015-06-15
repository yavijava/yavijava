package com.vmware.spbm;

import com.vmware.spbm.ws.PbmStub;
import com.vmware.vim25.ws.SoapClient;

/**
 * @author Atoka Sema
 */

public class PbmPortType extends PbmStub {
    public PbmPortType(String url, String sessionStr, boolean ignoreCert) throws java.net.MalformedURLException {
        super(url, sessionStr, ignoreCert);
    }

    public PbmPortType(SoapClient url, String sessionStr) throws java.net.MalformedURLException {
        super(url);
    }
}