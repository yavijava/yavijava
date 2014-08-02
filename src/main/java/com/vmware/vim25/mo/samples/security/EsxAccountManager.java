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

import com.vmware.vim25.HostAccountSpec;
import com.vmware.vim25.HostPosixAccountSpec;
import com.vmware.vim25.UserSearchResult;
import com.vmware.vim25.mo.HostLocalAccountManager;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.UserDirectory;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class EsxAccountManager 
{
  public static void main(String[] args) throws Exception
  {
    if(args.length != 3)
    {
      System.out.println("Usage: java EsxAccountManager <url> " 
          + "<username> <password>");
      return;
    }

    ServiceInstance si = new ServiceInstance(
            new URL(args[0]), args[1], args[2], true);
    HostLocalAccountManager hlam = si.getAccountManager();
    if(hlam==null)
    {
      System.out.println("This sample works ONLY with ESX. " 
          + "Please try it again.");
    }

    //create a new POSIX account
    HostPosixAccountSpec has = new HostPosixAccountSpec();
    has.setId("vimaster");
    has.setDescription("The POSIX account for VI Master");
    has.setPassword("password");
    has.setShellAccess(true);
    hlam.createUser(has);

    //create a new group called masters
    HostAccountSpec grpSpec = new HostAccountSpec();
    grpSpec.setId("masters");
    // DON'T CALL the following two lines! NOT supported. 
    // grpSpec.setDescription("The Group for VI Masters");
    // grpSpec.setPassword("grppass");
    hlam.createGroup(grpSpec);

    //assign the new user to the new group
    hlam.assignUserToGroup("vimaster", "masters");
    
    //let's check their existence
    UserDirectory ud = si.getUserDirectory();
    UserSearchResult[] usrs = ud.retrieveUserGroups(
          null, // only local machine is searched 
          "master", // search string  
          null, null, 
          false, //not exact match for the search 
          true, // include users 
          true // include groups
          );
    // print out the results
    for(int i=0; usrs!=null && i < usrs.length; i++)
    {
      System.out.println("\n===============================");
      System.out.println("Full name: " + usrs[i].getFullName());
      System.out.println("IsGroup:" + usrs[i].isGroup());
      System.out.println("Principal: " + usrs[i].getPrincipal());
    }
    
    //delete the new user and group
    //Note: you have to delete the user before delete the group
    hlam.removeUser("vimaster");
    hlam.removeGroup("masters");
    
    si.getServerConnection().logout();
  }
}
