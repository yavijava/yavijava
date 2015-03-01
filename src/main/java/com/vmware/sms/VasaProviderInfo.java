package com.vmware.sms;

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
public class VasaProviderInfo extends SmsProviderInfo {

    public String certificate;
    public String lastSyncTime;
    public String namespace;
    public String providerId;
    public RelatedStorageArray[] relatedStorageArray;
    public String status;
    public String[] supportedProfile;
    public String[] supportedProviderProfile;
    public SupportedVendorModelMapping[] supportedVendorModelMapping;
    public String url;
    public String vasaVersion;

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getLastSyncTime() {
        return lastSyncTime;
    }

    public void setLastSyncTime(String lastSyncTime) {
        this.lastSyncTime = lastSyncTime;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getProviderId() {
        return providerId;
    }

    public void setProviderId(String providerId) {
        this.providerId = providerId;
    }

    public RelatedStorageArray[] getRelatedStorageArray() {
        return relatedStorageArray;
    }

    public void setRelatedStorageArray(RelatedStorageArray[] relatedStorageArray) {
        this.relatedStorageArray = relatedStorageArray;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] getSupportedProfile() {
        return supportedProfile;
    }

    public void setSupportedProfile(String[] supportedProfile) {
        this.supportedProfile = supportedProfile;
    }

    public String[] getSupportedProviderProfile() {
        return supportedProviderProfile;
    }

    public void setSupportedProviderProfile(String[] supportedProviderProfile) {
        this.supportedProviderProfile = supportedProviderProfile;
    }

    public SupportedVendorModelMapping[] getSupportedVendorModelMapping() {
        return supportedVendorModelMapping;
    }

    public void setSupportedVendorModelMapping(SupportedVendorModelMapping[] supportedVendorModelMapping) {
        this.supportedVendorModelMapping = supportedVendorModelMapping;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVasaVersion() {
        return vasaVersion;
    }

    public void setVasaVersion(String vasaVersion) {
        this.vasaVersion = vasaVersion;
    }
}
