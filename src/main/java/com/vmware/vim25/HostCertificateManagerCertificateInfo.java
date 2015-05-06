package com.vmware.vim25;

import java.util.Calendar;

/**
 * Copyright 2015 Michael Rice <michael@michaelrice.org>
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class HostCertificateManagerCertificateInfo extends DynamicData {

    /**
     * The issuer of the certificate.
     */
    public String issuer;
    /**
     * Unknown
     */
    public Calendar notAfter;
    /**
     * The validity of the certificate.
     */
    public Calendar notBefore;
    /**
     * The status of the certificate in vCenter Server. The possible values for status are as described in
     * {@link com.vmware.vim25.HostCertificateManagerCertificateInfoCertificateStatus HostCertificateManagerCertificateInfoCertificateStatus}.
     * If queried directly from an ESX host, the property is set to unknown.
     */
    public String status;
    /**
     * The subject of the certificate.
     */
    public String subject;

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public Calendar getNotAfter() {
        return notAfter;
    }

    public void setNotAfter(Calendar notAfter) {
        this.notAfter = notAfter;
    }

    public Calendar getNotBefore() {
        return notBefore;
    }

    public void setNotBefore(Calendar notBefore) {
        this.notBefore = notBefore;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
