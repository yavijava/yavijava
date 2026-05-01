// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class LicenseManager extends ManagedObject {

    public LicenseManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public LicenseDiagnostics getDiagnostics() {
        return (LicenseDiagnostics) getCurrentProperty("diagnostics");
    }

    public LicenseManagerEvaluationInfo getEvaluation() {
        return (LicenseManagerEvaluationInfo) getCurrentProperty("evaluation");
    }

    public LicenseFeatureInfo[] getFeatureInfo() {
        return (LicenseFeatureInfo[]) getCurrentProperty("featureInfo");
    }

    public LicenseAssignmentManager getLicenseAssignmentManager() {
        return (LicenseAssignmentManager) this.getManagedObject("licenseAssignmentManager");
    }

    public String getLicensedEdition() {
        return (String) getCurrentProperty("licensedEdition");
    }

    public LicenseManagerLicenseInfo[] getLicenses() {
        return (LicenseManagerLicenseInfo[]) getCurrentProperty("licenses");
    }

    public LicenseSource getSource() {
        return (LicenseSource) getCurrentProperty("source");
    }

    public boolean checkFeature(HostSystem host, String featureKey) throws InvalidState, RuntimeFault, RemoteException {
        return getVimService().checkLicenseFeature(getMOR(), host == null ? null : host.getMOR(), featureKey);
    }

    public void configureSource(HostSystem host, LicenseSource licenseSource) throws CannotAccessLocalSource, InvalidLicense, LicenseServerUnavailable, RuntimeFault, RemoteException {
        getVimService().configureLicenseSource(getMOR(), host == null ? null : host.getMOR(), licenseSource);
    }

    public boolean disable(HostSystem host, String featureKey) throws InvalidState, LicenseServerUnavailable, RuntimeFault, RemoteException {
        return getVimService().disableFeature(getMOR(), host == null ? null : host.getMOR(), featureKey);
    }

    public boolean enable(HostSystem host, String featureKey) throws InvalidState, LicenseServerUnavailable, RuntimeFault, RemoteException {
        return getVimService().enableFeature(getMOR(), host == null ? null : host.getMOR(), featureKey);
    }

    public LicenseAvailabilityInfo[] querySourceAvailability(HostSystem host) throws RuntimeFault, RemoteException {
        return getVimService().queryLicenseSourceAvailability(getMOR(), host == null ? null : host.getMOR());
    }

    public LicenseUsageInfo queryUsage(HostSystem host) throws RuntimeFault, RemoteException {
        return getVimService().queryLicenseUsage(getMOR(), host == null ? null : host.getMOR());
    }

    public void removeLabel(String licenseKey, String labelKey) throws RuntimeFault, RemoteException {
        getVimService().removeLicenseLabel(getMOR(), licenseKey, labelKey);
    }

    public void removeLicense(String licenseKey) throws RuntimeFault, RemoteException {
        getVimService().removeLicense(getMOR(), licenseKey);
    }

    public void setEdition(HostSystem host, String featureKey) throws InvalidState, LicenseServerUnavailable, RuntimeFault, RemoteException {
        getVimService().setLicenseEdition(getMOR(), host == null ? null : host.getMOR(), featureKey);
    }

    public void updateLabel(String licenseKey, String labelKey, String labelValue) throws RuntimeFault, RemoteException {
        getVimService().updateLicenseLabel(getMOR(), licenseKey, labelKey, labelValue);
    }

    public LicenseManagerLicenseInfo updateLicense(String licenseKey, KeyValue[] labels) throws RuntimeFault, RemoteException {
        return getVimService().updateLicense(getMOR(), licenseKey, labels);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /**
 * @deprecated in SDK4.0
 */
public boolean getSourceAvailable() {
    return ((Boolean) getCurrentProperty("sourceAvailable")).booleanValue();
}
    /**
 * @since SDK4.0
 */
public LicenseManagerLicenseInfo addLicense(String licenseKey, KeyValue[] labels) throws RuntimeFault, RemoteException {
    return (LicenseManagerLicenseInfo) getVimService().addLicense(getMOR(), licenseKey, labels);
}
    /**
 * @since SDK4.0
 */
public LicenseManagerLicenseInfo decodeLicense(String licenseKey) throws RuntimeFault, RemoteException {
    return (LicenseManagerLicenseInfo) getVimService().decodeLicense(getMOR(), licenseKey);
}
    public boolean checkLicenseFeature(HostSystem host, String featureKey) throws InvalidState, RuntimeFault, RemoteException {
    return getVimService().checkLicenseFeature(getMOR(), host == null ? null : host.getMOR(), featureKey);
}
    public LicenseAvailabilityInfo[] queryLicenseSourceAvailability(HostSystem host) throws RuntimeFault, RemoteException {
    return getVimService().queryLicenseSourceAvailability(getMOR(), host == null ? null : host.getMOR());
}
    public LicenseUsageInfo queryLicenseUsage(HostSystem host) throws RuntimeFault, RemoteException {
    return getVimService().queryLicenseUsage(getMOR(), host == null ? null : host.getMOR());
}
    public LicenseFeatureInfo[] querySupportedFeatures(HostSystem host) throws RuntimeFault, RemoteException {
    return getVimService().querySupportedFeatures(getMOR(), host == null ? null : host.getMOR());
}
    /* ===== END custom ===== */
}
