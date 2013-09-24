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

/**
* @author Steve Jin (http://www.doublecloud.org)
* @version 5.1
*/

@SuppressWarnings("all")
public class StorageIORMConfigSpec extends DynamicData {
  public Boolean enabled;
  public String congestionThresholdMode;
  public Integer congestionThreshold;
  public Integer percentOfPeakThroughput;
  public Boolean statsCollectionEnabled;
  public Boolean statsAggregationDisabled;

  public Boolean getEnabled() {
    return this.enabled;
  }

  public String getCongestionThresholdMode() {
    return this.congestionThresholdMode;
  }

  public Integer getCongestionThreshold() {
    return this.congestionThreshold;
  }

  public Integer getPercentOfPeakThroughput() {
    return this.percentOfPeakThroughput;
  }

  public Boolean getStatsCollectionEnabled() {
    return this.statsCollectionEnabled;
  }

  public Boolean getStatsAggregationDisabled() {
    return this.statsAggregationDisabled;
  }

  public void setEnabled(Boolean enabled) {
    this.enabled=enabled;
  }

  public void setCongestionThresholdMode(String congestionThresholdMode) {
    this.congestionThresholdMode=congestionThresholdMode;
  }

  public void setCongestionThreshold(Integer congestionThreshold) {
    this.congestionThreshold=congestionThreshold;
  }

  public void setPercentOfPeakThroughput(Integer percentOfPeakThroughput) {
    this.percentOfPeakThroughput=percentOfPeakThroughput;
  }

  public void setStatsCollectionEnabled(Boolean statsCollectionEnabled) {
    this.statsCollectionEnabled=statsCollectionEnabled;
  }

  public void setStatsAggregationDisabled(Boolean statsAggregationDisabled) {
    this.statsAggregationDisabled=statsAggregationDisabled;
  }
}