package com.vmware.spbm.mo;

import java.net.URL;

import com.vmware.spbm.PbmPortType;
import com.vmware.vim25.ws.SoapClient;

/**
 * @author Atoka Sema
 */

public class PbmServerConnection {
    private URL url = null;
    private PbmServiceInstance pbmServiceInstance = null;
    private PbmPortType pbmService = null;

    public PbmServerConnection(URL url, PbmPortType pbmService, PbmServiceInstance pbmServiceInstance) {
        this.url = url;
        this.pbmService = pbmService;
        this.pbmServiceInstance = pbmServiceInstance;
    }

    /**
     * @return the current session string in format like: vmware_soap_session="B3240D15-34DF-4BB8-B902-A844FDF42E85"
     */
    public String getSessionStr() {
        SoapClient wsc = (SoapClient) pbmService.getWsc();
        return wsc.getCookie();
    }

    /**
     * Disconnect from the server and clean up
     */
    public void logout() {
        if (pbmService != null) {
            try {
                // TODO
                // pbmServiceInstance.getSessionManager().logout();
            } catch (Exception e) {
                System.err.println("Failed to disconnect...");
            }
            pbmService = null;
            pbmServiceInstance = null;
        }
    }

    public PbmServiceInstance getPbmServiceInstance() {
        return pbmServiceInstance;
    }

    public PbmPortType getPbmService() {
        return pbmService;
    }

    public URL getUrl() {
        return url;
    }

    public void setPbmServiceInstance(PbmServiceInstance pbmServiceInstance) {
        this.pbmServiceInstance = pbmServiceInstance;
    }

}
