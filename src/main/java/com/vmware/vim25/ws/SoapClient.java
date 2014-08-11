package com.vmware.vim25.ws;

import org.apache.log4j.Logger;

/**
 * Created by Michael Rice on 8/10/14.
 *
 * Copyright 2014 Michael Rice
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public abstract class SoapClient implements Client {

    public String soapAction;
    private static Logger log = Logger.getLogger(SoapClient.class);

    /*===============================================
       * API versions *
      "2.0.0"    VI 3.0
      "2.5.0"    VI 3.5 (and u1)
      "2.5u2"   VI 3.5u2 (and u3, u4)
      "4.0"       vSphere 4.0 (and u1)
      "4.1"       vSphere 4.1
      "5.0"       vSphere 5.0
      "5.1"       vSphere 5.1
      ===============================================
    */
    public void setSoapActionOnApiVersion(String apiVersion) {
        if ("4.0".equals(apiVersion)) {
            soapAction = SoapAction.SOAP_ACTION_V40.toString();
        }
        else if ("4.1".equals(apiVersion)) {
            soapAction = SoapAction.SOAP_ACTION_V41.toString();
        }
        else if ("5.0".equals(apiVersion)) {
            soapAction = SoapAction.SOAP_ACTION_V50.toString();
        }
        else if ("5.1".equals(apiVersion)) {
            soapAction = SoapAction.SOAP_ACTION_V51.toString();
        }
        else if ("5.5".equals(apiVersion)) {
            soapAction = SoapAction.SOAP_ACTION_V55.toString();
        }
        else { //always defaults to latest version
            soapAction = SoapAction.SOAP_ACTION_V55.toString();
        }
        log.trace("Set soapAction to: " + soapAction);
    }

}
