package com.vmware.vim25;

public class ArrayOfDVSOpaqueCommandResultInfo {
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
