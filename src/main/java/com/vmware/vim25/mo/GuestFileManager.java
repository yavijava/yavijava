// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class GuestFileManager extends ManagedObject {

    public GuestFileManager(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public void changeFileAttributesInGuest(VirtualMachine vm, GuestAuthentication auth, String guestFilePath, GuestFileAttributes fileAttributes) throws FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().changeFileAttributesInGuest(getMOR(), vm == null ? null : vm.getMOR(), auth, guestFilePath, fileAttributes);
    }

    public void deleteDirectoryInGuest(VirtualMachine vm, GuestAuthentication auth, String directoryPath, boolean recursive) throws FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().deleteDirectoryInGuest(getMOR(), vm == null ? null : vm.getMOR(), auth, directoryPath, recursive);
    }

    public void deleteFileInGuest(VirtualMachine vm, GuestAuthentication auth, String filePath) throws FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().deleteFileInGuest(getMOR(), vm == null ? null : vm.getMOR(), auth, filePath);
    }

    public FileTransferInformation initiateFileTransferFromGuest(VirtualMachine vm, GuestAuthentication auth, String guestFilePath) throws FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        return getVimService().initiateFileTransferFromGuest(getMOR(), vm == null ? null : vm.getMOR(), auth, guestFilePath);
    }

    public String initiateFileTransferToGuest(VirtualMachine vm, GuestAuthentication auth, String guestFilePath, GuestFileAttributes fileAttributes, long fileSize, boolean overwrite) throws FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        return getVimService().initiateFileTransferToGuest(getMOR(), vm == null ? null : vm.getMOR(), auth, guestFilePath, fileAttributes, fileSize, overwrite);
    }

    public void makeDirectoryInGuest(VirtualMachine vm, GuestAuthentication auth, String directoryPath, boolean createParentDirectories) throws FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().makeDirectoryInGuest(getMOR(), vm == null ? null : vm.getMOR(), auth, directoryPath, createParentDirectories);
    }

    public void moveDirectoryInGuest(VirtualMachine vm, GuestAuthentication auth, String srcDirectoryPath, String dstDirectoryPath) throws FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().moveDirectoryInGuest(getMOR(), vm == null ? null : vm.getMOR(), auth, srcDirectoryPath, dstDirectoryPath);
    }

    public void moveFileInGuest(VirtualMachine vm, GuestAuthentication auth, String srcFilePath, String dstFilePath, boolean overwrite) throws FileFault, GuestOperationsFault, InvalidState, TaskInProgress, RuntimeFault, RemoteException {
        getVimService().moveFileInGuest(getMOR(), vm == null ? null : vm.getMOR(), auth, srcFilePath, dstFilePath, overwrite);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    private VirtualMachine vm = null;
    public VirtualMachine getVM() {
    return vm;
}
    public void setVM(VirtualMachine vm) {
    this.vm = vm;
}
    public String createTemporaryDirectoryInGuest(GuestAuthentication auth, String prefix, String suffix, String directoryPath) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException {
    return getVimService().createTemporaryDirectoryInGuest(getMOR(), vm.getMOR(), auth, prefix, suffix, directoryPath);
}
    public String createTemporaryFileInGuest(GuestAuthentication auth, String prefix, String suffix, String directoryPath) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException {
    return getVimService().createTemporaryFileInGuest(getMOR(), vm.getMOR(), auth, prefix, suffix, directoryPath);
}
    public FileTransferInformation initiateFileTransferFromGuest(GuestAuthentication auth, String guestFilePath) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException {
    return getVimService().initiateFileTransferFromGuest(getMOR(), vm.getMOR(), auth, guestFilePath);
}
    public String initiateFileTransferToGuest(GuestAuthentication auth, String guestFilePath, GuestFileAttributes fileAttributes, long fileSize, boolean overwrite) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException {
    return getVimService().initiateFileTransferToGuest(getMOR(), vm.getMOR(), auth, guestFilePath, fileAttributes, fileSize, overwrite);
}
    public GuestListFileInfo listFilesInGuest(GuestAuthentication auth, String filePath, int index, int maxResults, String matchPattern) throws GuestOperationsFault, InvalidState, TaskInProgress, FileFault, RuntimeFault, RemoteException {
    return getVimService().listFilesInGuest(getMOR(), vm.getMOR(), auth, filePath, index, maxResults, matchPattern);
}
    /* ===== END custom ===== */
}
