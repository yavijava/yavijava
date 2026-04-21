/*================================================================================
Copyright (c) 2013 Steve Jin. All Rights Reserved.

Redistribution and use in source and binary forms, with or without modification, 
are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, 
this list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice, 
this list of conditions and the following disclaimer in the documentation 
and/or other materials provided with the distribution.

* Neither the name of VMware, Inc. nor the names of its contributors may be used
to endorse or promote products derived from this software without specific prior 
written permission.

THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
IN NO EVENT SHALL VMWARE, INC. OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, 
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT 
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR 
PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, 
WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) 
ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
POSSIBILITY OF SUCH DAMAGE.
================================================================================*/

package com.vmware.vim25;
import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

/**
 * @author Steve Jin (http://www.doublecloud.org)
 * @version 5.1
 */

public class HostRuntimeInfo extends DynamicData {
    @Getter @Setter public HostSystemConnectionState connectionState;
    @Getter @Setter public HostSystemPowerState powerState;
    @Getter @Setter public String standbyMode;
    @Getter @Setter public boolean inMaintenanceMode;
    @Getter @Setter public Boolean inQuarantineMode;
    @Getter @Setter public Calendar bootTime;
    @Getter @Setter public HealthSystemRuntime healthSystemRuntime;
    @Getter @Setter public ClusterDasFdmHostState dasHostState;
    @Getter @Setter public HostTpmDigestInfo[] tpmPcrValues;
    @Getter @Setter public VsanHostRuntimeInfo vsanRuntimeInfo;
    @Getter @Setter public HostRuntimeInfoNetworkRuntimeInfo networkRuntimeInfo;
    @Getter @Setter public HostVFlashManagerVFlashResourceRunTimeInfo vFlashResourceRuntimeInfo;
    @Getter @Setter public Long hostMaxVirtualDiskCapacity;
    @Getter @Setter public String cryptoState;
    @Getter @Setter public CryptoKeyId cryptoKeyId;
}
