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

package com.vmware.vim25.mo.samples.cluster;

import java.net.URL;
import java.util.Date;

import com.vmware.vim25.ClusterRecommendation;
import com.vmware.vim25.mo.ClusterComputeResource;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.ManagedObject;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class DrsApp 
{
  public static void main(String[] args) throws Exception
  {
    if(args.length!=3)
    {
      System.out.println("Usage: java DrsApp " +
      		"<url> <username> <password>");
      System.exit(0);
    }

    ServiceInstance si = new ServiceInstance(
        new URL(args[0]), args[1], args[2], true);
    Folder root = si.getRootFolder();
    ManagedEntity[] mes = new InventoryNavigator(
        root).searchManagedEntities("ClusterComputeResource");
    if(mes==null || mes.length == 0)
    {
      System.out.println("There is no DRS cluster. Exiting.");
      si.getServerConnection().logout();
      return;
    }

    ClusterComputeResource ccr = 
        ((ClusterComputeResource)mes[0]);
    EmailMessenger em = new EmailMessenger(
        "mailhost1.vmware.com", "username", "password");

    for(;;)
    {
      StringBuffer sb = new StringBuffer();
      ClusterRecommendation[] recs = ccr.getRecommendation(); 
      if(recs!=null)
      {
        for(int i=0; i< recs.length; i++)
        {
          sb.append("\n\nRecommendation #" + (i+1));
          sb.append(recommendationToString(recs[i]));
          sb.append("\nPlease click the following URL " +
          		"and enter " + recs[i].getKey() 
          		+ " as key to apply this recommendation:");
          sb.append(createMobUrl(args[0], ccr) 
              + "&method=applyRecommendation");
          sb.append("\nThe time window for applying " +
          		"recommendations is 5 mins. Please act ASAP!");
        }

        // the receiver's email address
        String recvEmail = "admin@***.com";
        System.out.println("Sending DRS recommendation email to:"
            + recvEmail);
        em.sendEmailTo(recvEmail, "DRS Messenger -- " 
            + recs.length + " recommendation(s)", sb.toString());
      }
      Thread.sleep(1*60*1000); //wait for 1 minute
    }
  }

  static String recommendationToString(
      ClusterRecommendation rec)
  {
    StringBuffer sb = new StringBuffer();
    sb.append("\nRating:" + rec.getRating());
    sb.append("\nReasonText:" + rec.getReasonText());
    sb.append("\nKey:" + rec.getKey());
    sb.append("\nTarget:" + rec.getTarget());
    sb.append("\nTime:" + new Date(
        rec.getTime().getTimeInMillis()));
    return sb.toString();
  }

  static String createMobUrl(String serviceUrl, ManagedObject mo)
  {
    int sdkLoc = serviceUrl.indexOf("/sdk");
    String baseUrl = serviceUrl.substring(0, sdkLoc);
    return baseUrl + "/mob/?moid=" + mo.getMOR().get_value();
  }
}