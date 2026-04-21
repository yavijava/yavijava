package com.vmware.vim25.ws;

/**
 * Created by Michael Rice on 8/9/14.
 * <p>
 * Copyright 2014 Michael Rice
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public enum SoapAction {

    SOAP_ACTION_HEADER("SOAPAction"),
    SOAP_ACTION_V40("urn:vim25/4.0"),
    SOAP_ACTION_V41("urn:vim25/4.1"),
    SOAP_ACTION_V50("urn:vim25/5.0"),
    SOAP_ACTION_V51("urn:vim25/5.1"),
    SOAP_ACTION_V55("urn:vim25/5.5"),
    SOAP_ACTION_V60("urn:vim25/6.0"),
    SOAP_ACTION_V65("urn:vim25/6.5");

    private final String value;

    SoapAction(String name) {
        value = name;
    }

    public String toString() {
        return value;
    }

    public boolean equalsName(String otherName) {
        return (otherName != null) && value.equals(otherName);
    }
}
