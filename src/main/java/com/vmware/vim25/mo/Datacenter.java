// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class Datacenter extends ManagedEntity {

    public Datacenter(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public DatacenterConfigInfo getConfiguration() {
        return (DatacenterConfigInfo) getCurrentProperty("configuration");
    }

    public Datastore[] getDatastore() {
        return getDatastores("datastore");
    }

    public Folder getDatastoreFolder() {
        return (Folder) this.getManagedObject("datastoreFolder");
    }

    public Folder getHostFolder() {
        return (Folder) this.getManagedObject("hostFolder");
    }

    public Network[] getNetwork() {
        return getNetworks("network");
    }

    public Folder getNetworkFolder() {
        return (Folder) this.getManagedObject("networkFolder");
    }

    public Folder getVmFolder() {
        return (Folder) this.getManagedObject("vmFolder");
    }

    public DatacenterBasicConnectInfo[] batchQueryConnectInfo(HostConnectSpec[] hostSpecs) throws RuntimeFault, RemoteException {
        return getVimService().batchQueryConnectInfo(getMOR(), hostSpecs);
    }

    public VirtualMachineConfigOptionDescriptor[] queryConfigOptionDescriptor() throws RuntimeFault, RemoteException {
        return getVimService().queryConfigOptionDescriptor(getMOR());
    }

    public HostConnectInfo queryConnectionInfo(String hostname, int port, String username, String password, String sslThumbprint, String sslCertificate) throws HostConnectFault, InvalidLogin, RuntimeFault, RemoteException {
        return getVimService().queryConnectionInfo(getMOR(), hostname, port, username, password, sslThumbprint, sslCertificate);
    }

    public Task reconfigureDatacenter_Task(DatacenterConfigSpec spec, boolean modify) throws RuntimeFault, RemoteException {
        ManagedObjectReference resultMor = getVimService().reconfigureDatacenter_Task(getMOR(), spec, modify);
        return new Task(getServerConnection(), resultMor);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    /**
 * old signature for back compatibility with 2.5 and 4.0
 */
public Task powerOnMultiVM_Task(VirtualMachine[] vms) throws RuntimeFault, RemoteException {
    return powerOnMultiVM_Task(vms, null);
}
    /**
 * @since SDK4.1
 */
public Task powerOnMultiVM_Task(VirtualMachine[] vms, OptionValue[] option) throws RuntimeFault, RemoteException {
    if (vms == null) {
        throw new IllegalArgumentException("vms must not be null.");
    }
    ManagedObjectReference[] mors = MorUtil.createMORs(vms);
    ManagedObjectReference tmor = getVimService().powerOnMultiVM_Task(getMOR(), mors, option);
    return new Task(getServerConnection(), tmor);
}
    public HostConnectInfo queryConnectionInfo(String hostname, int port, String username, String password, String sslThumbprint) throws InvalidLogin, HostConnectFault, RuntimeFault, RemoteException {
    return getVimService().queryConnectionInfo(getMOR(), hostname, port, username, password, sslThumbprint, null);
}
    /**
 * @since SDK5.1
 */
public VirtualMachineConfigOptionDescriptor[] queryDatacenterConfigOptionDescriptor() throws RuntimeFault, RemoteException {
    return getVimService().queryDatacenterConfigOptionDescriptor(getMOR());
}
    /**
 * This method provides a way of getting basic information about a host without adding it to a datacenter. This
 * method is similar to QueryConnectionInfo, but it takes a HostConnectSpec as argument, instead of list of
 * parameters.
 *
 * @param spec The connection spec for the host to be queried. It must contain values for all parameters required by QueryConnectionInfo See QueryConnectionInfo or a list of thrown expections.
 * @return HostConnectInfo
 * @throws GatewayConnectFault
 * @throws GatewayHostNotReachable
 * @throws GatewayNotFound
 * @throws GatewayNotReachable
 * @throws GatewayOperationRefused
 * @throws GatewayToHostAuthFault
 * @throws GatewayToHostTrustVerifyFault
 * @throws HostConnectFault
 * @throws InvalidArgument
 * @throws InvalidLogin
 * @throws RuntimeFault
 * @throws RemoteException
 * @since 6.0
 */
public HostConnectInfo queryConnectionInfoViaSpec(HostConnectSpec spec) throws GatewayConnectFault, GatewayHostNotReachable, GatewayNotFound, GatewayNotReachable, GatewayOperationRefused, GatewayToHostAuthFault, GatewayToHostTrustVerifyFault, HostConnectFault, InvalidArgument, InvalidLogin, RuntimeFault, RemoteException {
    return getVimService().queryConnectionInfoViaSpec(getMOR(), spec);
}
    /* ===== END custom ===== */
}
