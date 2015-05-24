package com.vmware.vim25;

/**
 * Copyright 2015 Michael Rice <michael@michaelrice.org>
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @since 6.0
 */
public enum HostAccessMode {

    /**
     * Describes a propagating Admin role on the root inventory object (root folder) on the host,
     * and no other non-Admin role on any other object. The same permissions are needed to login
     * to local or remote shell (ESXiShell or SSH).
     */
    accessAdmin("accessAdmin"),

    /**
     * Describes a propagating NoAccess role on the root inventory object (root folder) on the host,
     * and no other roles. Even if the user has another (redundant) NoAccess role on some other
     * inventory object, then the access mode for this user will be classified as accessOther.
     * <p/>
     * This mode may be used to restrict a specific user account without restricting the access mode
     * for the group to which the user belongs.
     */
    accessNoAccess("accessNoAccess"),

    /**
     * Indicates that the user has no explicitly defined permissions or roles. This is used when we
     * want to remove all permissions for some user.
     * <p/>
     * Note that this is not the same as accessNoAccess.
     */
    accessNone("accessNone"),

    /**
     * Describes a combination of one or more roles/permissions which are none of the above.
     */
    accessOther("accessOther"),

    /**
     * Describes a propagating ReadOnly role on the root inventory object (root folder) on
     * the host, and no other roles. Even if the user has another (redundant) ReadOnly role
     * on some other inventory object, then the access mode for this user will be accessOther.
     */
    accessReadOnly("accessReadOnly");

    private String value;

    HostAccessMode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
