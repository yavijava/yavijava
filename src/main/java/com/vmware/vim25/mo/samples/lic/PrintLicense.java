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

package com.vmware.vim25.mo.samples.lic;

import java.net.URL;

import com.vmware.vim25.EvaluationLicenseSource;
import com.vmware.vim25.LicenseAvailabilityInfo;
import com.vmware.vim25.LicenseDiagnostics;
import com.vmware.vim25.LicenseFeatureInfo;
import com.vmware.vim25.LicenseReservationInfo;
import com.vmware.vim25.LicenseServerSource;
import com.vmware.vim25.LicenseSource;
import com.vmware.vim25.LicenseUsageInfo;
import com.vmware.vim25.LocalLicenseSource;
import com.vmware.vim25.mo.LicenseManager;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */
public class PrintLicense
{
  public static void main(String[] args) throws Exception
  {
    if(args.length != 3)
    {
      System.out.println("Usage: java PrintLicense <url> " 
        + "<username> <password>");
      return;
    }
    
    ServiceInstance si = new ServiceInstance(
        new URL(args[0]), args[1], args[2], true);
    
    LicenseManager lm = si.getLicenseManager();
    
    System.out.println("License edition:" 
      + lm.getLicensedEdition());
    
    System.out.println("Licnese source available:"
      + lm.getSourceAvailable());
    
    printLicenseSource(lm.getSource());
    
    System.out.println("License Diagnostic Info:");
    printDiagnostics(lm.getDiagnostics());

    // The featureInfo property is deprecated as of 2.5.
    // Use the querySupportedFeatures as follows.
    System.out.println("\nLicense Features:");
    printLicenseFeatures(lm.querySupportedFeatures(null));
    
    System.out.println("\nLicense Usage:");
    printLicenseUsage(lm.queryLicenseUsage(null));
    
    System.out.println("\nLicense source availability:");
    printLicenseAvailable(
      lm.queryLicenseSourceAvailability(null));
    
    si.getServerConnection().logout();
  }
  
  static void printLicenseAvailable(LicenseAvailabilityInfo[] ls)
  {
    for(int i=0; ls!=null && i<ls.length; i++)
    {
      System.out.println("Feature:" 
          + ls[i].getFeature().getFeatureName());
      System.out.println("Total licenses:" + ls[i].getTotal());
      System.out.println("Available licenses:" 
        + ls[i].getAvailable());
    }
  }
  
  static void printLicenseUsage(LicenseUsageInfo ui)
  {
    System.out.println("The list of feature reservations:");
    LicenseReservationInfo[] ris = ui.getReservationInfo();
    for(int i=0; ris!=null && i< ris.length; i++)
    {
      System.out.println("Feature key :" + ris[i].getKey());
      System.out.println("Required license:" 
        + ris[i].getRequired());
      System.out.println("State:" + ris[i].getState());
    }
    
    System.out.println("All the features that are referenced" 
      + " in reservation:");
    printLicenseFeatures(ui.getFeatureInfo());
    
    System.out.println("License source:");
    printLicenseSource(ui.getSource());
    
    System.out.println("License source available:" 
      + ui.isSourceAvailable());
  }
  
  static void printLicenseSource(LicenseSource src)
  {
    if(src instanceof EvaluationLicenseSource)
    {
      System.out.println("Evaluation license: will expire in "
        + ((EvaluationLicenseSource)src).getRemainingHours()
        + " hours.");
    }
    else if(src instanceof LicenseServerSource)
    {
      System.out.println("License from server:"
        + ((LicenseServerSource)src).getLicenseServer());
    }
    else if(src instanceof LocalLicenseSource)
    {
      System.out.println("Local license key:"
        + ((LocalLicenseSource)src).getLicenseKeys());
    }
  }
  
  static void printLicenseFeatures(LicenseFeatureInfo[] fis)
  {
    for(int i=0; fis!=null && i<fis.length; i++)
    {
      String prtStr =
        "\nFeatureName:" + fis[i].getFeatureName() +
        "\nCostUnit:" + fis[i].getCostUnit() +
        "\nDependentKey:";
      
      String[] dep = fis[i].getDependentKey();
      for(int j=0; dep!=null && j<dep.length; j++)
      {
        prtStr += dep[j] + " ";
      }
      
      prtStr +=  "\nEdition:" + fis[i].getEdition() + 
        "\nExpiresOn:" + fis[i].getExpiresOn() +
        "\nFeatureDescription:" 
          + fis[i].getFeatureDescription() +
        "\nKey:" + fis[i].getKey() +
        "\nSourceRestriction:" + fis[i].getSourceRestriction() +
        "\nState:" + fis[i].getState();
      System.out.println(prtStr);
    }
  }
  
  static void printDiagnostics(LicenseDiagnostics ld)
  {
    if(ld==null)
      return;
    String prtStr = 
      "LastStatusUpdate:" + ld.getLastStatusUpdate().getTime() +
      "\nLicenseFeatureUnknown:" 
        + ld.getLicenseFeatureUnknowns() +
      "\nLicneseRequestFailures:" 
        + ld.getLicenseRequestFailures() +
      "\nLicenseReqeusts:" + ld.getLicenseRequests() +
      "\nOpFailiureMessage:" + ld.getOpFailureMessage() +
      "\nOpState:" + ld.getOpState() +
      "\nSourceLastChanged:" + ld.getSourceLastChanged().getTime() +
      "\nsourceLatency:" + ld.getSourceLatency() +
      "\nsourceLost:" + ld.getSourceLost();
    System.out.println(prtStr);
  }
}