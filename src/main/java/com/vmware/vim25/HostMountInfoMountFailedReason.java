package com.vmware.vim25;

/**
 * Created by Michael Rice on Fri Apr 24 22:47:38 CDT 2026
 * This code is auto generated using yavijava_generator
 * https://github.com/yavijava/yavijava_generator
 *
 * Copyright 2015 Michael Rice
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * @since 6.0
 */

public enum HostMountInfoMountFailedReason {

    CONNECT_FAILURE("CONNECT_FAILURE"),
    MOUNT_NOT_SUPPORTED("MOUNT_NOT_SUPPORTED"),
    NFS_NOT_SUPPORTED("NFS_NOT_SUPPORTED"),
    MOUNT_DENIED("MOUNT_DENIED"),
    MOUNT_NOT_DIR("MOUNT_NOT_DIR"),
    VOLUME_LIMIT_EXCEEDED("VOLUME_LIMIT_EXCEEDED"),
    CONN_LIMIT_EXCEEDED("CONN_LIMIT_EXCEEDED"),
    MOUNT_EXISTS("MOUNT_EXISTS"),
    OTHERS("OTHERS");

    private String val;

    HostMountInfoMountFailedReason(String val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return this.val;
    }
}
