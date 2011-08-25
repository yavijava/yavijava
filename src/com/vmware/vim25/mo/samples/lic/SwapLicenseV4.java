package com.vmware.vim25.mo.samples.lic;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.vmware.vim25.LicenseAssignmentManagerLicenseAssignment;
import com.vmware.vim25.LicenseManagerLicenseInfo;
import com.vmware.vim25.mo.LicenseAssignmentManager;
import com.vmware.vim25.mo.LicenseManager;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * This sample shows how to replace an old license key with a new one.
 * @author Steve Jin (http://www.doublecloud.org) 
 */

public class SwapLicenseV4
{
  public static void main(String[] args) throws Exception
  {
    ServiceInstance si = new ServiceInstance(new URL("https://8.8.8.8/sdk"), 
        "administrator", "vmware", true);
    LicenseManager lm = si.getLicenseManager();
    LicenseAssignmentManager lam = lm.getLicenseAssignmentManager();
    
    LicenseAssignmentManagerLicenseAssignment[] las = lam.queryAssignedLicenses(null);

    String newLic = "XXXXX-XXXXX-XXXXX-XXXXX-XXXXX";
    String oldLic = "YYYYY-YYYYY-YYYYY-YYYYY-YYYYY";
    
    List<LicEntity> entities = new ArrayList<LicEntity>();
   
    for(LicenseAssignmentManagerLicenseAssignment la : las)
    {
      LicenseManagerLicenseInfo licInfo = la.getAssignedLicense();
      if(oldLic.equals(licInfo.getLicenseKey()))
      {
        entities.add(new LicEntity(la.getEntityId(), la.getEntityDisplayName()));
        System.out.println("entityId:" + la.getEntityId());
        
      }
    }
    
    lm.addLicense(newLic, null);
    
    for(LicEntity e : entities)
    {
      lam.updateAssignedLicense(e.entityId, newLic, e.displayName);
    }
    lm.removeLicense(oldLic);
  }
}

class LicEntity
{
  String entityId;
  String displayName;

  public LicEntity(String entityId, String displayName)
  {
    this.entityId = entityId;
    this.displayName = displayName;
  }
}
