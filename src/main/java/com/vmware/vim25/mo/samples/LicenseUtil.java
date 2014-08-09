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

package com.vmware.vim25.mo.samples;

import java.net.URL;
import java.rmi.RemoteException;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;

 /**
 *<pre>
 *Demonstrates uses of the Licensing API using License Managed Object
 *Reference.
 * 
 *<b>To run this samples following parameters are used :</b>
 *
 *action     [required]   : action to be performed [browse|setserver|setedition|featureinfo]
 *serverurl  [optional]   : url of license server
 *edition    [optional]   : Licensed edition 
 *feature    [optional]   : Licensed feature  
 *
 * @author sjin
 *</pre>
 */

public class LicenseUtil 
{
  public static void main(String[] args) throws Exception 
   {
		CommandLineParser clp = new CommandLineParser(constructOptions(), args);
		String urlStr = clp.get_option("url");
		String username = clp.get_option("username");
		String password = clp.get_option("password");
		String action = clp.get_option("action");
		String serverurl = clp.get_option("serverurl");
		String edition = clp.get_option("edition");
		String feature = clp.get_option("feature");

		if(!customValidation(clp))
			return;
		
		ServiceInstance si = new ServiceInstance(new URL(urlStr), username, password, true);
		LicenseManager licMgr = si.getLicenseManager();
		if(licMgr==null)
		{
			System.out.println("There is NO LicMgr available...");
			return;
		}
		
		if(action.equalsIgnoreCase("browse")) 
		{
			System.out.println("Display the license usage. The license usage is a list of supported features"
                             + "and the number of licenses that have been reserved.");
			displayLicenseUsage(licMgr);
		}
		else if(action.equalsIgnoreCase("setserver")) 
		{
			System.out.println("Set the License server.");
			setLicenseServer(licMgr,serverurl);
		}      
		else if(action.equalsIgnoreCase("setedition")) 
		{
			System.out.println("Set the License Edition.");
			setEdition(licMgr, edition);
		}
		else if(action.equalsIgnoreCase("featureinfo")) 
		{         
			displayFeatureInfo(licMgr, feature);
		}      
		else 
		{
			System.out.println("Invalid Action ");
			System.out.println("Valid Actions [browse|setserver|setedition|featureinfo]");
		}
   }
   
   private static void displayLicenseUsage(LicenseManager licMgr) throws Exception 
   {
      LicenseUsageInfo licUsage = licMgr.queryLicenseUsage(null);
      LicenseAvailabilityInfo[] avail = licMgr.queryLicenseSourceAvailability(null);
      System.out.println("==========Usage==========");
      print(licUsage);
      System.out.println("==========Available==========");
      print(avail);
   }
   
   private static void setLicenseServer(LicenseManager licMgr, String serverurl) throws Exception 
   {
      LicenseServerSource source = new LicenseServerSource();
      source.setLicenseServer("serverurl");      
      try
      {
    	  licMgr.configureLicenseSource(null, source);
      }
      catch(RemoteException re) 
      {
    	  re.printStackTrace();
      }
   }  
 
   private static void setEdition(LicenseManager licMgr, String edition) throws Exception 
   {
      boolean valid = validate(edition);
      if(valid) 
      {
         try
         {      
            licMgr.setLicenseEdition(null, edition);
         }
         catch(RemoteException re) 
         {
        	 re.printStackTrace();
         }
      }
   }
   
   private static void displayFeatureInfo(LicenseManager licMgr, String featureName) throws Exception 
   {
      LicenseFeatureInfo [] feature = licMgr.getFeatureInfo();

      for(int i=0 ;i < feature.length; i++) 
      {
         if(feature[i].getKey().equalsIgnoreCase(featureName)) 
         {
            System.out.println("Name       " + feature[i].getFeatureName());
            System.out.println("Unique Key " + feature[i].getKey());
            System.out.println("State      " + feature[i].getState());
            System.out.println("Cost Unit  " + feature[i].getCostUnit());
            return;
         }
      }
      System.out.println("Feature Not Available");
   }     
   
   private static boolean validate(String feature)
   {
      String [] features = {"backup","das","drs","esxExpress","esxFull"
                           ,"esxHost","esxVmtn","gsxHost","iscsi","nas",
                            "san","vc","vmotion","vsmp"};
      boolean flag = false;
      for(int i=0; i<features.length; i++) 
      {
         if(features[i].equals(feature))
         {
            flag = true;
            break;
         }
      }
      if(!flag) 
      {
         System.out.println("Invalid Edition / Feature : " +
                            "Specify the edition/feature from below list");
         System.out.println("backup     "+"Enable ESX Server consolidated" + 
                            "backup feature. This is a per CPU package license.");
         System.out.println("das        "+"Enable VirtualCenter HA. This is a per" + 
                            "ESX server CPU package license.");
         System.out.println("drs        "+"Enable VirtualCenter Distributed Resource" + 
                            "Scheduler. This is a per ESX server CPU package license.");
         System.out.println("esxExpress "+
                            "The edition license for the ESX server, Starter edition." + 
                            "This is a per CPU package license.");
         System.out.println("esxFull    "+
                            "The edition license for the ESX Server, Standard edition." + 
                            "This is a per CPU package license.");
         System.out.println("esxHost    "+
                            "Enable VirtualCenter ESX Server host management" + 
                            "functionality." + 
                            "This is a per ESX server CPU package license. ");
         System.out.println("esxVmtn    "+
                            "The edition license for the ESX server, VMTN edition." + 
                            "This is a per CPU package license. ");
         System.out.println("gsxHost    "+
                            "Enable VirtualCenter GSX Server host management" + 
                            "functionality. This is a per GSX server CPU " + 
                            "package license. ");
         System.out.println("iscsi      "+"Enable use of iSCSI. This is a per " +
                            "CPU package license.");
         System.out.println("nas        "+
                            "Enable use of NAS. This is a per CPU package license.");
         System.out.println("san        "+
                            "Enable use of SAN. This is a per CPU package license.");
         System.out.println("vc"+
                            "The edition license for a VirtualCenter server, full" + 
                            "edition. This license is independent of the number of" + 
                            "CPU packages for the VirtualCenter host.");
         System.out.println("vmotion "+"Enable VMotion. This is a per ESX server" + 
                            "CPU package license.");
         System.out.println("vsmp       "+
                            "Enable up to 4-way VSMP feature." + 
                            "This is a per CPU package license.");
      }
      return flag;
   }
   
   private static void print(LicenseUsageInfo usage) 
   {
      if(usage != null && usage.getFeatureInfo() != null) 
      {
         for(int i=0; i<usage.getFeatureInfo().length; ++i) 
         {
            print(usage.featureInfo[i]);
         }
         if(usage.getReservationInfo() != null) 
         {
            for(int i=0; i<usage.getReservationInfo().length; ++i) 
            {
               print(usage.featureInfo[i]);
            }
         }
      } 
      else 
      {
         System.out.println(" : No usage returned.");
      }
   }
   
   private static void print(LicenseFeatureInfo feature) 
   {
      LicenseFeatureInfoState state = feature.getState();
      String fState;
      if(state == null) 
      {
         fState = "Edition";
      } 
      else if(LicenseFeatureInfoState.enabled == state) 
      {
         fState = "Included";
      } 
      else if(LicenseFeatureInfoState.disabled == state) 
      {
         fState = "Disabled";
      } 
      else 
      {
         fState = "Optional";
      }
      System.out.println(" : F: " + feature.getKey() + ", Cost: " + feature.getCostUnit() + ", State: " + fState);
   }

   private static void print(LicenseReservationInfo reservation) 
   {
      System.out.println(" : R: " + reservation.getKey() +
            ", Required: " + reservation.getRequired() +
            ", State: " + reservation.getState());
   }
   
   private static void print(LicenseAvailabilityInfo[] avail) 
   {
      System.out.println(" : License Available Info:");
      if(avail != null) 
      {
         for(int i=0; i<avail.length; ++i) 
         {
            LicenseAvailabilityInfo info = avail[i];
            print(info.getFeature());
            System.out.println(" : Total: " + info.getTotal()+ ", Avaliable: " + info.getAvailable());
         }
      } 
      else 
      {
         System.out.println(" : No usage returned.");
      }
   }
   
   private static boolean customValidation(CommandLineParser clp) throws Exception
   {
      boolean flag = true;
      String action = clp.get_option("action");
      if(action.equalsIgnoreCase("setserver")) 
      {
         if(!clp.option_is_set("serverurl")) {
            System.out.println("For action setserver --serverurl" + 
                               "is mandatory argument");
            flag = false;
         }
      }
      else if(action.equalsIgnoreCase("setedition")) 
      {
         if(!clp.option_is_set("edition")) {
            System.out.println("For action setedition --edition is "+
                               "mandatory argument");
            flag = false;
         }
      }
      else if(action.equalsIgnoreCase("featureinfo")) {
         if(!clp.option_is_set("feature")) {
           System.out.println("For action featureinfo --feature is " + 
                              "mandatory argument");
           flag = false;
         }
      }
      return flag;
   }
   private static OptionSpec[] constructOptions() 
   {
      return new OptionSpec[]
      {
    	new OptionSpec("action","String",1,"[browse|setserver|setedition|featureinfo]", null),
    	new OptionSpec("serverurl","String",0, "License Server URL", null),
    	new OptionSpec("edition","String",0, "License Edition", null),
        new OptionSpec("feature","String",0, "Name of the feature", null)
      };
   }   
}
 
