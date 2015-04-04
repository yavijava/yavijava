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
 */
public class GuestAuthAliasInfo extends DynamicData {

    /**
     * User-supplied data to describe the subject.
     */
    public String comment;

    /**
     * The subject.
     */
    public GuestAuthSubject guestAuthSubject;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public GuestAuthSubject getGuestAuthSubject() {
        return guestAuthSubject;
    }

    public void setGuestAuthSubject(GuestAuthSubject guestAuthSubject) {
        this.guestAuthSubject = guestAuthSubject;
    }
}
