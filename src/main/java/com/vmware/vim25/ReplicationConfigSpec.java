package com.vmware.vim25;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Michael Rice on Sun May 24 16:15:35 CDT 2015
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

public class ReplicationConfigSpec extends DynamicData {
    @Getter @Setter public long generation;
    @Getter @Setter public String vmReplicationId;
    @Getter @Setter public String destination;
    @Getter @Setter public int port;
    @Getter @Setter public long rpo;
    @Getter @Setter public boolean quiesceGuestEnabled;
    @Getter @Setter public boolean paused;
    @Getter @Setter public boolean oppUpdatesEnabled;
    @Getter @Setter public Boolean netCompressionEnabled;
    @Getter @Setter public ReplicationInfoDiskSettings[] disk;
}
