package com.vmware.vim25;
import lombok.Getter;
import lombok.Setter;
import java.util.Calendar;

/**
 * Created by Michael Rice on Fri Nov 18 12:45:25 CST 2016
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
 * @since 6.5
 */

public class CryptoManagerKmipCertificateInfo extends DynamicData {
    @Getter @Setter public String subject;
    @Getter @Setter public String issuer;
    @Getter @Setter public String serialNumber;
    @Getter @Setter public Calendar notBefore;
    @Getter @Setter public Calendar notAfter;
    @Getter @Setter public String fingerprint;
    @Getter @Setter public Calendar checkTime;
    @Getter @Setter public Integer secondsSinceValid;
    @Getter @Setter public Integer secondsBeforeExpire;
}
