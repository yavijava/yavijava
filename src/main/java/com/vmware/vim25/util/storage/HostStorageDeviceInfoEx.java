package com.vmware.vim25.util.storage;

import com.vmware.vim25.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zahe1469 on 9/4/2014.
 */
public class HostStorageDeviceInfoEx {

    /**
     * Logger to log information.
     */
    Logger log = LoggerFactory.getLogger(HostStorageDeviceInfoEx.class);

    /**
     * Host Storage Device Information.
     */
    private HostStorageDeviceInfo storageDeviceInfo;

    /**
     * Default constructor.
     *
     * @param storageDeviceInfo
     */
    public HostStorageDeviceInfoEx(HostStorageDeviceInfo storageDeviceInfo) {
        this.storageDeviceInfo = storageDeviceInfo;
        collectScsiRuntimeNames();
    }

    /**
     * All the ScsiLun Keys and their Runtime Names mapped together.
     */
    public Map<String, String> scsiRuntimeNames = new HashMap<String, String>();

    /**
     * Returns the map of [(ScsiLun Keys) : RuntimeName]
     *
     * @return
     */
    public Map getScsiRuntimeNames() {
        return this.scsiRuntimeNames;
    }

    /**
     * Returns the RuntimeName for a given ScsiLun.
     *
     * @param scsiLun
     * @return
     */
    public String getScsiRuntimeName(ScsiLun scsiLun) {
        return this.scsiRuntimeNames.get(scsiLun.key);
    }

    /**
     * Collects Runtime names for all ScsiLuns on a Host where the ScsiLun type is "disk".
     */
    private void collectScsiRuntimeNames() {

        // To hold all the Scsi Luns that are disks
        ArrayList<ScsiLun> sortedScsiLuns = new ArrayList<ScsiLun>();

        // Check to see that this device has luns
        if (storageDeviceInfo.getScsiLun().length == 0) {
            log.trace("There are no Scsi LUNS on this storage device.");
            return;
        }

        // Collect all the scsi luns which are disks
        for (ScsiLun lun : storageDeviceInfo.getScsiLun()) {
            if (lun.lunType.equals("disk")) {
                sortedScsiLuns.add(lun);
            }
        }

        // To collect the Scsi Topology information
        ArrayList<Map> scsiTopologyInfo = new ArrayList<Map>();

        // Get the HostScsiTopology information
        HostScsiTopology scsiTopology = storageDeviceInfo.scsiTopology;

        // Check to see that adapters are present
        if (null == scsiTopology.adapter || scsiTopology.adapter.length == 0) {
            log.trace("There are no adapters on this storage device.");
            return;
        }

        // Get the adapters from scsi topology
        for (HostScsiTopologyInterface adapter : scsiTopology.adapter) {

            // Check to see that these adapters have targets
            if (null == adapter.target || adapter.target.length == 0) {
                log.trace("This adapter has no targets. Adapter:" + adapter.adapter);
                continue;
            }

            // For each target on these adapters
            for (HostScsiTopologyTarget target : adapter.target) {

                // Check to see that the target has LUNs
                if (null == target.lun || target.lun.length == 0) {
                    log.trace("This target has no LUNs on it. Target:" + target.key);
                    continue;
                }

                // For each lun on these targets
                for (HostScsiTopologyLun lun : target.lun) {

                    // Create a Map with The target key and lun information
                    Map<String, Object> scsiInfo = new HashMap<String, Object>();

                    // Add this information to map
                    scsiInfo.put("key", target.key);
                    scsiInfo.put("lunInfo", lun);

                    // Add this map to Scsi info list
                    scsiTopologyInfo.add(scsiInfo);
                }
            }
        }

        // Make sure that information is available.
        if (sortedScsiLuns.size() == 0 || scsiTopologyInfo.size() == 0) {
            log.trace("There is no SCSI Lun information on this host");
            return;
        }

        // For each Lun in sortedScsiLuns
        for (ScsiLun lun : sortedScsiLuns) {

            // For each of the ScisiTopology
            for (Map info : scsiTopologyInfo) {

                // Get the lun information on the target
                HostScsiTopologyLun scsiTopologyLun = (HostScsiTopologyLun) info.get("lunInfo");

                // If the target
                if (scsiTopologyLun.scsiLun.equals(lun.key)) {

                    // Get the key name and split it
                    String[] names = info.get("key").toString().split("-");
                    String name = names[names.length - 1];

                    // The name will look something like this: "vmhba0:2:0"
                    // This needs to be split with ':' such that we have ["vmhba0", "2", "0"]
                    String[] nameSplit = name.split(":");

                    // We then get the lun number from info
                    // We create the RuntimeName (A:C:T:L form) which will finally look like: "vmhba0:C2:T0:L0"
                    // "L" is followed by the Lun Number
                    // Create a Map with LunKey vs RuntimeName
                    this.scsiRuntimeNames.put(lun.key, (nameSplit[0] + ":C" + nameSplit[1] + ":T" + nameSplit[2] + ":L" + scsiTopologyLun.getLun()));
                }
            }
        }
    }
}
