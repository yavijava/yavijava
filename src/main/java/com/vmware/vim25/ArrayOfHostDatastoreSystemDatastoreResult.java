package com.vmware.vim25;

public class ArrayOfHostDatastoreSystemDatastoreResult implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    public HostDatastoreSystemDatastoreResult[] HostDatastoreSystemDatastoreResult;

    public HostDatastoreSystemDatastoreResult[] getHostDatastoreSystemDatastoreResult() {
        return this.HostDatastoreSystemDatastoreResult;
    }

    public HostDatastoreSystemDatastoreResult getHostDatastoreSystemDatastoreResult(int i) {
        return this.HostDatastoreSystemDatastoreResult[i];
    }

    public void setHostDatastoreSystemDatastoreResult(HostDatastoreSystemDatastoreResult[] HostDatastoreSystemDatastoreResult) {
        this.HostDatastoreSystemDatastoreResult = HostDatastoreSystemDatastoreResult;
    }
}
