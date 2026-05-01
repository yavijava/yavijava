package com.vmware.vim25;

public class ArrayOfDVSOpaqueCommandResultInfo implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    public DVSOpaqueCommandResultInfo[] DVSOpaqueCommandResultInfo;

    public DVSOpaqueCommandResultInfo[] getDVSOpaqueCommandResultInfo() {
        return this.DVSOpaqueCommandResultInfo;
    }

    public DVSOpaqueCommandResultInfo getDVSOpaqueCommandResultInfo(int i) {
        return this.DVSOpaqueCommandResultInfo[i];
    }

    public void setDVSOpaqueCommandResultInfo(DVSOpaqueCommandResultInfo[] DVSOpaqueCommandResultInfo) {
        this.DVSOpaqueCommandResultInfo = DVSOpaqueCommandResultInfo;
    }
}
