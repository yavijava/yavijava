package com.vmware.vim25;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Steve Jin (http://www.doublecloud.org)
 * @version 5.1
 */

public class IscsiPortInfo extends DynamicData {
    @Getter @Setter public String vnicDevice;
    @Getter @Setter public HostVirtualNic vnic;
    @Getter @Setter public String pnicDevice;
    @Getter @Setter public PhysicalNic pnic;
    @Getter @Setter public String switchName;
    @Getter @Setter public String switchUuid;
    @Getter @Setter public String portgroupName;
    @Getter @Setter public String portgroupKey;
    @Getter @Setter public String portKey;
    @Getter @Setter public String opaqueNetworkId;
    @Getter @Setter public String opaqueNetworkType;
    @Getter @Setter public String opaqueNetworkName;
    @Getter @Setter public String externalId;
    @Getter @Setter public IscsiStatus complianceStatus;
    @Getter @Setter public String pathStatus;
}
