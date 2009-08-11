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

import com.vmware.vim25.ElementDescription;
import com.vmware.vim25.PerfCounterInfo;
import com.vmware.vim25.PerfInterval;
import com.vmware.vim25.PerformanceDescription;
import com.vmware.vim25.mo.PerformanceManager;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class PrintPerfMgr 
{
  public static void main(String[] args) throws Exception
  {
    if(args.length != 3)
    {
      System.out.println("Usage: java PrintPerfMgr " 
        + "<url> <username> <password>");
      return;
    }

    ServiceInstance si = new ServiceInstance(
      new URL(args[0]), args[1], args[2], true);

    PerformanceManager perfMgr = si.getPerformanceManager();

    System.out.println("***Print All Descriptions:");
    PerformanceDescription pd = perfMgr.getDescription();
    printPerfDescription(pd);

    System.out.println("\n***Print All Historical Intervals:");
    PerfInterval[] pis = perfMgr.getHistoricalInterval();
    printPerfIntervals(pis);
    
    System.out.println("\n***Print All Perf Counters:");
    PerfCounterInfo[] pcis = perfMgr.getPerfCounter();
    printPerfCounters(pcis);
    
    si.getServerConnection().logout();
  }
  
  static void printPerfIntervals(PerfInterval[] pis)
  {
    for(int i=0; pis!=null && i<pis.length; i++)
    {
      System.out.println("\nPerfInterval # " + i);
      StringBuffer sb = new StringBuffer();
      sb.append("Name:" + pis[i].getName());
      sb.append("\nKey:" + pis[i].getKey());
      sb.append("\nLevel:"+ pis[i].getLevel());
      sb.append("\nSamplingPeriod:" + pis[i].getSamplingPeriod());
      sb.append("\nLength:" + pis[i].getLength());
      sb.append("\nEnabled:" + pis[i].isEnabled());
      System.out.println(sb);
    }
  }
  
  static void printPerfCounters(PerfCounterInfo[] pcis)
  {
    for(int i=0; pcis!=null && i<pcis.length; i++)
    {
      System.out.println("\nKey:" + pcis[i].getKey());
      String perfCounter = pcis[i].getGroupInfo().getKey() + "."
          + pcis[i].getNameInfo().getKey() + "." 
          + pcis[i].getRollupType();
      System.out.println("PerfCounter:" + perfCounter);
      System.out.println("Level:" + pcis[i].getLevel());
      System.out.println("StatsType:" + pcis[i].getStatsType());
      System.out.println("UnitInfo:" 
          + pcis[i].getUnitInfo().getKey());
    }
  }
  
  static void printPerfDescription(PerformanceDescription pd)
  {
    ElementDescription[] eds = pd.getCounterType();
    printElementDescriptions(eds);
   
    ElementDescription[] statsTypes = pd.getStatsType();
    printElementDescriptions(statsTypes);
  }
  
  static void printElementDescriptions(ElementDescription[] eds)
  {
    for(int i=0; eds!=null && i<eds.length; i++)
    {
      printElementDescription(eds[i]);
    }
  }
  
  static void printElementDescription(ElementDescription ed)
  {
    System.out.println("\nKey:" + ed.getKey());
    System.out.println("Label:" + ed.getLabel());
    System.out.println("Summary:" + ed.getSummary());
  }
}
