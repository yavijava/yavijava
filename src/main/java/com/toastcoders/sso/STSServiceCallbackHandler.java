
/**
 * STSServiceCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

package com.toastcoders.sso;

/**
 * STSServiceCallbackHandler Callback class, Users can extend this class and implement
 * their own receiveResult and receiveError methods.
 */
public abstract class STSServiceCallbackHandler {


    protected Object clientData;

    /**
     * User can pass in any object that needs to be accessed once the NonBlocking
     * Web service call is finished and appropriate method of this CallBack is called.
     *
     * @param clientData Object mechanism by which the user can pass in user data
     *                   that will be avilable at the time this callback is called.
     */
    public STSServiceCallbackHandler(Object clientData) {
        this.clientData = clientData;
    }

    /**
     * Please use this constructor if you don't want to set any clientData
     */
    public STSServiceCallbackHandler() {
        this.clientData = null;
    }

    /**
     * Get the client data
     */

    public Object getClientData() {
        return clientData;
    }


    /**
     * auto generated Axis2 call back method for renew method
     * override this method for handling normal response from renew operation
     */
    public void receiveResultrenew(com.toastcoders.sso.STSServiceStub.RequestSecurityTokenResponse result) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from renew operation
     */
    public void receiveErrorrenew(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for challenge method
     * override this method for handling normal response from challenge operation
     */
    public void receiveResultchallenge(
        com.toastcoders.sso.STSServiceStub.RequestSecurityTokenResponseCollection result
    ) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from challenge operation
     */
    public void receiveErrorchallenge(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for validate method
     * override this method for handling normal response from validate operation
     */
    public void receiveResultvalidate(
        com.toastcoders.sso.STSServiceStub.RequestSecurityTokenResponse result
    ) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from validate operation
     */
    public void receiveErrorvalidate(java.lang.Exception e) {
    }

    /**
     * auto generated Axis2 call back method for issue method
     * override this method for handling normal response from issue operation
     */
    public void receiveResultissue(
        com.toastcoders.sso.STSServiceStub.RequestSecurityTokenResponseCollection result
    ) {
    }

    /**
     * auto generated Axis2 Error handler
     * override this method for handling error response from issue operation
     */
    public void receiveErrorissue(java.lang.Exception e) {
    }
}