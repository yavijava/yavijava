// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostNetworkSystem extends ExtensibleManagedObject {

    public HostNetworkSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostNetCapabilities getCapabilities() {
        return (HostNetCapabilities) getCurrentProperty("capabilities");
    }

    public HostIpRouteConfig getConsoleIpRouteConfig() {
        return (HostIpRouteConfig) getCurrentProperty("consoleIpRouteConfig");
    }

    public HostDnsConfig getDnsConfig() {
        return (HostDnsConfig) getCurrentProperty("dnsConfig");
    }

    public HostIpRouteConfig getIpRouteConfig() {
        return (HostIpRouteConfig) getCurrentProperty("ipRouteConfig");
    }

    public HostNetworkConfig getNetworkConfig() {
        return (HostNetworkConfig) getCurrentProperty("networkConfig");
    }

    public HostNetworkInfo getNetworkInfo() {
        return (HostNetworkInfo) getCurrentProperty("networkInfo");
    }

    public HostNetOffloadCapabilities getOffloadCapabilities() {
        return (HostNetOffloadCapabilities) getCurrentProperty("offloadCapabilities");
    }

    public void addPortGroup(HostPortGroupSpec portgrp) throws AlreadyExists, HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().addPortGroup(getMOR(), portgrp);
    }

    public void addVirtualSwitch(String vswitchName, HostVirtualSwitchSpec spec) throws AlreadyExists, HostConfigFault, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().addVirtualSwitch(getMOR(), vswitchName, spec);
    }

    public void refresh() throws RuntimeFault, RemoteException {
        getVimService().refresh(getMOR());
    }

    public void removePortGroup(String pgName) throws HostConfigFault, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().removePortGroup(getMOR(), pgName);
    }

    public void removeServiceConsoleVirtualNic(String device) throws HostConfigFault, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().removeServiceConsoleVirtualNic(getMOR(), device);
    }

    public void removeVirtualNic(String device) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().removeVirtualNic(getMOR(), device);
    }

    public void removeVirtualSwitch(String vswitchName) throws HostConfigFault, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().removeVirtualSwitch(getMOR(), vswitchName);
    }

    public void restartServiceConsoleVirtualNic(String device) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().restartServiceConsoleVirtualNic(getMOR(), device);
    }

    public void startDpuFailover(String dvsName, String targetDpuAlias) throws InvalidArgument, RuntimeFault, RemoteException {
        getVimService().startDpuFailover(getMOR(), dvsName, targetDpuAlias);
    }

    public void updateConsoleIpRouteConfig(HostIpRouteConfig config) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().updateConsoleIpRouteConfig(getMOR(), config);
    }

    public void updateDnsConfig(HostDnsConfig config) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateDnsConfig(getMOR(), config);
    }

    public void updateIpRouteConfig(HostIpRouteConfig config) throws HostConfigFault, InvalidState, RuntimeFault, RemoteException {
        getVimService().updateIpRouteConfig(getMOR(), config);
    }

    public void updateIpRouteTableConfig(HostIpRouteTableConfig config) throws HostConfigFault, RuntimeFault, RemoteException {
        getVimService().updateIpRouteTableConfig(getMOR(), config);
    }

    public HostNetworkConfigResult updateNetworkConfig(HostNetworkConfig config, String changeMode) throws AlreadyExists, HostConfigFault, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        return getVimService().updateNetworkConfig(getMOR(), config, changeMode);
    }

    public void updatePhysicalNicLinkSpeed(String device, PhysicalNicLinkInfo linkSpeed) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updatePhysicalNicLinkSpeed(getMOR(), device, linkSpeed);
    }

    public void updatePortGroup(String pgName, HostPortGroupSpec portgrp) throws AlreadyExists, HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updatePortGroup(getMOR(), pgName, portgrp);
    }

    public void updateServiceConsoleVirtualNic(String device, HostVirtualNicSpec nic) throws HostConfigFault, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().updateServiceConsoleVirtualNic(getMOR(), device, nic);
    }

    public void updateVirtualNic(String device, HostVirtualNicSpec nic) throws HostConfigFault, InvalidState, NotFound, RuntimeFault, RemoteException {
        getVimService().updateVirtualNic(getMOR(), device, nic);
    }

    public void updateVirtualSwitch(String vswitchName, HostVirtualSwitchSpec spec) throws HostConfigFault, NotFound, ResourceInUse, RuntimeFault, RemoteException {
        getVimService().updateVirtualSwitch(getMOR(), vswitchName, spec);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public String addServiceConsoleVirtualNic(String portgroup, HostVirtualNicSpec spec) throws HostConfigFault, RuntimeFault, RemoteException {
    return getVimService().addServiceConsoleVirtualNic(getMOR(), portgroup, spec);
}
    public String addVirtualNic(String portgroup, HostVirtualNicSpec nicSpec) throws HostConfigFault, AlreadyExists, RuntimeFault, RemoteException {
    return getVimService().addVirtualNic(getMOR(), portgroup, nicSpec);
}
    public PhysicalNicHintInfo[] queryNetworkHint(String[] devices) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
    return getVimService().queryNetworkHint(getMOR(), devices);
}
    /* ===== END custom ===== */
}
