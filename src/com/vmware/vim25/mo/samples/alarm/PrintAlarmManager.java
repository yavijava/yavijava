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

package com.vmware.vim25.mo.samples.alarm;

import java.net.URL;

import com.vmware.vim25.AlarmDescription;
import com.vmware.vim25.AlarmExpression;
import com.vmware.vim25.ElementDescription;
import com.vmware.vim25.MetricAlarmExpression;
import com.vmware.vim25.ScheduledTaskDetail;
import com.vmware.vim25.StateAlarmExpression;
import com.vmware.vim25.TypeDescription;
import com.vmware.vim25.mo.AlarmManager;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class PrintAlarmManager
{
  public static void main(String[] args) throws Exception
  {
    if(args.length != 3)
    {
      System.out.println("Usage: java PrintAlarmManager " 
        + "<url> <username> <password>");
      return;
    }

    ServiceInstance si = new ServiceInstance(
      new URL(args[0]), args[1], args[2], true);
     
    AlarmManager alarmMgr = si.getAlarmManager();

    System.out.println("Alarm expressions:");
    AlarmExpression[] defaultExps = alarmMgr.getDefaultExpression();
    printAlarmExpressions(defaultExps);

    System.out.println("\n\nAlarm descriptions:");
    AlarmDescription ad = alarmMgr.getDescription();
    printAlarmDescription(ad);
    
    si.getServerConnection().logout();
  }
  
  static void printAlarmDescription(AlarmDescription ad)
  {
    System.out.println("Entity statuses:");
    printElementDescriptions(ad.getEntityStatus());
    
    System.out.println("\nHostSystem connection states:");
    printElementDescriptions(ad.getHostSystemConnectionState());
    
    System.out.println("\nMetric operators:");
    printElementDescriptions(ad.getMetricOperator());

    System.out.println("\nState operators:");
    printElementDescriptions(ad.getStateOperator());

    System.out.println("\nVirtual machine power states:");
    printElementDescriptions(ad.getVirtualMachinePowerState());
    
    System.out.println("\nAction class descriptions:");
    printTypeDescriptions(ad.getAction());
    
    System.out.println("\nDescriptions of expressioin type " +
    		"for triggers:");
    printTypeDescriptions(ad.getExpr());
  }
  
  static void printAlarmExpressions(AlarmExpression[] exps)
  {
    for(int i=0; exps!=null && i<exps.length; i++)
    {
      System.out.println("\nAlarm expression #" + i);
      if(exps[i] instanceof MetricAlarmExpression)
      {
        MetricAlarmExpression mae = 
          (MetricAlarmExpression) exps[i];
        System.out.println("metric:" 
            + mae.getMetric().getCounterId());
        System.out.println("red:" + mae.getRed());
        System.out.println("type:" + mae.getType());
        System.out.println("yellow:" + mae.getYellow());
      }
      else if(exps[i] instanceof StateAlarmExpression)
      {
        StateAlarmExpression sae = 
          (StateAlarmExpression) exps[i];
        System.out.println("operator:" + sae.getOperator());
        System.out.println("red:" + sae.getRed());
        System.out.println("statePath:" + sae.getStatePath());
        System.out.println("type:" + sae.getType());
        System.out.println("yellow:" + sae.getYellow());
      }
    }
  }
  
  static void printTypeDescriptions(TypeDescription[] tds)
  {
    for(int i=0; tds!=null && i<tds.length; i++)
    {
      printTypeDescription(tds[i]);
    }
  }
  
  static void printTypeDescription(TypeDescription td)
  {
    System.out.println("\nKey:" + td.getKey());
    System.out.println("Label:" + td.getLabel());
    System.out.println("Summary:" + td.getSummary());
    if(td instanceof ScheduledTaskDetail)
    {
      System.out.println("Frequency:" + ((ScheduledTaskDetail)td).getFrequency());
    }
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
