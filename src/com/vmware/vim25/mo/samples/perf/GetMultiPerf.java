/*================================================================================
Copyright (c) 2008 VMware, Inc. All Rights Reserved.

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

package com.vmware.vim25.mo.samples.perf;

import java.net.URL;
import java.util.Calendar;

import com.vmware.vim25.PerfCompositeMetric;
import com.vmware.vim25.PerfEntityMetric;
import com.vmware.vim25.PerfEntityMetricBase;
import com.vmware.vim25.PerfEntityMetricCSV;
import com.vmware.vim25.PerfMetricId;
import com.vmware.vim25.PerfMetricIntSeries;
import com.vmware.vim25.PerfMetricSeries;
import com.vmware.vim25.PerfMetricSeriesCSV;
import com.vmware.vim25.PerfQuerySpec;
import com.vmware.vim25.PerfSampleInfo;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.PerformanceManager;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.VirtualMachine;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class GetMultiPerf 
{
  public static void main(String[] args) throws Exception
  {
    if(args.length != 4)
    {
      System.out.println("Usage: java GetMultiPerf " 
        + "<url> <username> <password> <vmname>");
      return;
    }

    ServiceInstance si = new ServiceInstance(
      new URL(args[0]), args[1], args[2], true);

    String vmname = args[3];
    VirtualMachine vm = (VirtualMachine) new InventoryNavigator(
      si.getRootFolder()).searchManagedEntity(
        "VirtualMachine", vmname);

    if(vm == null)
    {
      System.out.println("Virtual Machine " + vmname 
          + " cannot be found.");
      si.getServerConnection().logout();
      return;
    }

    PerformanceManager perfMgr = si.getPerformanceManager();

    int perfInterval = 1800; // 30 minutes for PastWeek
    
    // retrieve all the available perf metrics for vm
    PerfMetricId[] pmis = perfMgr.queryAvailablePerfMetric(
        vm, null, null, perfInterval);
    
    Calendar curTime = si.currentTime();
    
    PerfQuerySpec qSpec = new PerfQuerySpec();
    qSpec.setEntity(vm.getRuntime().getHost());
    //metricIDs must be provided, or InvalidArgumentFault 
    qSpec.setMetricId(pmis);
    qSpec.setFormat("normal"); //optional since it's default
    qSpec.setIntervalId(perfInterval); 

    Calendar startTime = (Calendar) curTime.clone();
    startTime.roll(Calendar.DATE, -4);
    System.out.println("start:" + startTime.getTime());
    qSpec.setStartTime(startTime);
    
    Calendar endTime = (Calendar) curTime.clone();
    endTime.roll(Calendar.DATE, -3);
    System.out.println("end:" + endTime.getTime());
    qSpec.setEndTime(endTime);
    
    PerfCompositeMetric pv = perfMgr.queryPerfComposite(qSpec);
    if(pv != null)
    {
      printPerfMetric(pv.getEntity());
      PerfEntityMetricBase[] pembs = pv.getChildEntity();
      for(int i=0; pembs!=null && i< pembs.length; i++)
      {
        printPerfMetric(pembs[i]);
      }
    }
    si.getServerConnection().logout();
  }

  static void printPerfMetric(PerfEntityMetricBase val)
  {
    String entityDesc = val.getEntity().getType() 
        + ":" + val.getEntity().get_value();
    System.out.println("Entity:" + entityDesc);
    if(val instanceof PerfEntityMetric)
    {
      printPerfMetric((PerfEntityMetric)val);
    }
    else if(val instanceof PerfEntityMetricCSV)
    {
      printPerfMetricCSV((PerfEntityMetricCSV)val);
    }
    else
    {
      System.out.println("UnExpected sub-type of " +
      		"PerfEntityMetricBase.");
    }
  }
  
  static void printPerfMetric(PerfEntityMetric pem)
  {
    PerfMetricSeries[] vals = pem.getValue();
    PerfSampleInfo[]  infos = pem.getSampleInfo();
    
    System.out.println("Sampling Times and Intervales:");
    for(int i=0; infos!=null && i<infos.length; i++)
    {
        System.out.println("sample time: " 
          + infos[i].getTimestamp().getTime());
        System.out.println("sample interval (sec):" 
          + infos[i].getInterval());
    }
    
    System.out.println("\nSample values:");
    for(int j=0; vals!=null && j<vals.length; ++j)
    {
      System.out.println("Perf counter ID:" 
          + vals[j].getId().getCounterId());
      System.out.println("Device instance ID:" 
          + vals[j].getId().getInstance());
      
      if(vals[j] instanceof PerfMetricIntSeries)
      {
        PerfMetricIntSeries val = (PerfMetricIntSeries) vals[j];
        long[] longs = val.getValue();
        for(int k=0; k<longs.length; k++) 
        {
          System.out.print(longs[k] + " ");
        }
        System.out.println("Total:"+longs.length);
      }
      else if(vals[j] instanceof PerfMetricSeriesCSV)
      { // it is not likely coming here...
        PerfMetricSeriesCSV val = (PerfMetricSeriesCSV) vals[j];
        System.out.println("CSV value:" + val.getValue());
      }
    }
  }
    
  static void printPerfMetricCSV(PerfEntityMetricCSV pems)
  {
    System.out.println("SampleInfoCSV:" 
        + pems.getSampleInfoCSV());
    PerfMetricSeriesCSV[] csvs = pems.getValue();
    for(int i=0; i<csvs.length; i++)
    {
      System.out.println("PerfCounterId:" 
          + csvs[i].getId().getCounterId());
      System.out.println("CSV sample values:" 
          + csvs[i].getValue());
    }
  }
}