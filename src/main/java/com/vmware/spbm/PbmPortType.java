package com.vmware.spbm;

import com.vmware.spbm.ws.PbmStub;
import com.vmware.vim25.ws.SoapClient;

/**
 * @author Atoka Sema
 */

public class PbmPortType extends PbmStub {
    public PbmPortType(String url, boolean ignoreCert) throws java.net.MalformedURLException {
        super(url, ignoreCert);
    }

    public PbmPortType(SoapClient url) throws java.net.MalformedURLException {
        super(url);
    }
}