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

package com.vmware.vim25.mo.samples.security;

import java.net.URL;
import com.vmware.vim25.AuthorizationDescription;
import com.vmware.vim25.AuthorizationPrivilege;
import com.vmware.vim25.AuthorizationRole;
import com.vmware.vim25.ElementDescription;
import com.vmware.vim25.mo.AuthorizationManager;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class ListAuthorization
{
  public static void main(String[] args) throws Exception
  {
    if(args.length != 3)
    {
      System.out.println("Usage: java ListAuthorization <url> " 
        + "<username> <password>");
      return;
    }
    
    ServiceInstance si = new ServiceInstance(
        new URL(args[0]), args[1], args[2], true);

    AuthorizationManager am = si.getAuthorizationManager();
    AuthorizationDescription ad = am.getDescription();
    
    System.out.println("Descriptions of all privileges:");
    printDescriptions(ad.getPrivilege());

    System.out.println("Descriptions of all privilege groups:");
    printDescriptions( ad.getPrivilegeGroup());

    System.out.println("List of all privileges with details:");
    printPrivileges(am.getPrivilegeList());
    
    System.out.println("List of all the roles with details:");
    printRoles(am.getRoleList());
    
    si.getServerConnection().logout();
  }
  
  static void printDescriptions(ElementDescription[] eds)
  {
    for(int i=0; eds!=null && i< eds.length; i++)
    {
      System.out.println("\nKey:" + eds[i].getKey());
      System.out.println("Label:" + eds[i].getLabel());
      System.out.println("Summary:" + eds[i].getSummary());
    }
  }
  
  static void printPrivileges(AuthorizationPrivilege[] aps)
  {
    for(int i=0; aps!=null && i< aps.length; i++)
    {
      System.out.println("\nName:" + aps[i].getName());
      System.out.println("onParent:" + aps[i].isOnParent());
      System.out.println("Group:" + aps[i].getPrivGroupName());
      System.out.println("ID:" + aps[i].getPrivId());
    }
  }

  static void printRoles(AuthorizationRole[] ars)
  {
    for(int i=0; ars!=null && i<ars.length; i++)
    {
      System.out.println("\nName:" + ars[i].getName());
      System.out.println("Role ID:" + ars[i].getRoleId());
      System.out.println("Sys Role:" + ars[i].isSystem());
      System.out.print("Privileges: ");
      String[] privs = ars[i].getPrivilege();
      for(int j=0; privs!=null && j < privs.length; j++)
      {
        if(j==0)
        {
          System.out.print(privs[j]);
        }
        else
        {
          System.out.print(", " + privs[j]);
        }
      }
    }
  }
}
