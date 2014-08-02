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

import com.vmware.vim25.UserSearchResult;
import com.vmware.vim25.mo.ServiceInstance;
import com.vmware.vim25.mo.UserDirectory;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class ListAllUsers
{
  public static void main(String[] args) throws Exception
  {
    if(args.length != 3)
    {
      System.out.println("Usage: java ListAllUsers <url> " 
        + "<username> <password>");
      return;
    }
    
    ServiceInstance si = new ServiceInstance(
        new URL(args[0]), args[1], args[2], true);

    UserDirectory ud = si.getUserDirectory();
    
    //print out the domain names
    String[] domains = ud.getDomainList();
    System.out.println("domains:" + domains);
    for(int i=0; domains!=null && i<domains.length; i++)
    {
      System.out.println("Domain:" + domains[i]);
    }
    
    UserSearchResult[] usrs = ud.retrieveUserGroups(
          null, // only local machine is searched 
          "", // blank means matching all  
          "users", null, // all the groups
          false, //not exact match for the search 
          true, // include users 
          false // include groups
          );
    
    // print out the results
    for(int i=0; usrs!=null && i < usrs.length; i++)
    {
      System.out.println("===============================");
      System.out.println("Full name: " + usrs[i].getFullName());
      System.out.println("IsGroup:" + usrs[i].isGroup());
      System.out.println("Principal: " + usrs[i].getPrincipal());
    }

    si.getServerConnection().logout();
  }
}
