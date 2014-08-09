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

package com.vmware.vim25.mo.samples.ext;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Properties;

import com.vmware.vim25.Description;
import com.vmware.vim25.Extension;
import com.vmware.vim25.ExtensionClientInfo;
import com.vmware.vim25.ExtensionServerInfo;
import com.vmware.vim25.mo.ExtensionManager;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * http://vijava.sf.net
 * @author Steve Jin
 */

public class ExtMgrUtil
{
  public static void main(String[] args) throws Exception 
  {
    // get the properties file for parameters
    String filename = null;
    if(args.length==0)
    {
      System.out.println("Usage: java ExtMgrUtil " +
      	"[properties_file_path]");
      System.out.println("Since no properties file is " +
      	"specified, we will search for it in current path.");
      filename = "extension.properties";
    }
    else
    {
      filename = args[0];
    }

    // Read in parameters from the properties file
    Properties props = readProperties(filename);
    if(props==null) 
    {
      System.exit(-1);
    }

    // Assign the values to the corresponding variables
    URL url = new URL(props.getProperty("url"));
    String userName = props.getProperty("userName");
    String password = props.getProperty("password");
    String operation = props.getProperty("operation");
    String keyStr = props.getProperty("keyStr");

    ServiceInstance si = new ServiceInstance( 
        url, userName, password, true);
    ExtensionManager extMgr = si.getExtensionManager();

    if("register".equalsIgnoreCase(operation))
    {
      if(extMgr.findExtension(keyStr)!=null)
      {
        System.out.println("Plugin key: " + keyStr + 
            " is used. Please try with a new key.");
      }
      else 
      {
        Extension ext = createExtensionObject(props);
        extMgr.registerExtension(ext);
        System.out.println("Plugin: " + keyStr + 
            " has been successfully registered.");
      }
    }
    else if ("update".equalsIgnoreCase(operation))
    {
      if(extMgr.findExtension(keyStr)!=null)
      {
        Extension ext = createExtensionObject(props);
        extMgr.updateExtension(ext);
        System.out.println("Plugin: " + keyStr + 
            " has been successfully updated.");
      }
      else
      {
        System.out.println("The plugin doesn't exist. " +
            "Please register it before updating it.");
      }
    }
    else if("listall".equalsIgnoreCase(operation))
    {
      printAllExtensions(extMgr.getExtensionList());
    }
    else if("unregister".equalsIgnoreCase(operation))
    {
      if(extMgr.findExtension(keyStr)!=null)
      {
        extMgr.unregisterExtension(keyStr);
        System.out.println("Plugin: " + keyStr + 
            " has been successfully un-registered.");
      }
      else
      {
        System.out.println("Plugin: " + keyStr + 
          " does NOT exist. No need to unregister it.");
      }

    }
    else if("find".equalsIgnoreCase(operation))
    {
      if(extMgr.findExtension(keyStr)!=null)
      {
        System.out.println("Plugin: " + keyStr + 
            " is registered.");
      }
      else
      {
        System.out.println("Plugin: " + keyStr + 
            " can NOT be found.");
      }
    }
    else
    {
      System.out.println("Operation is not valide. " +
      		"Please try again.");
    }

    si.getServerConnection().logout();
  }

  static Properties readProperties(String filename)
  {
    Properties props = new Properties();
    FileInputStream fis = null; 
    try 
    {
      fis = new FileInputStream(filename);
      props.load(new FileInputStream(filename));
    } catch (FileNotFoundException fnfe)
    {
      System.out.println("Properties file " + filename +
          " does NOT exist. Please double check." );
      return null;
    }
    catch (IOException ioe) 
    {
      ioe.printStackTrace();
      System.out.println("Please check the parameters " +
      		"in the properties file " + filename);
      return null;
    } 
    finally
    {
      if(fis!=null)
      {
        try 
        {
          fis.close();
        } catch (IOException cioe)
        {}
      }
    }
    return props;
  }

  static Extension createExtensionObject(Properties props)
  {
    String companyStr = props.getProperty("companyStr");
    String descStr = props.getProperty("descStr"); 
    String keyStr = props.getProperty("keyStr");
    String extUrl = props.getProperty("extUrl");
    String adminEmail = props.getProperty("adminEmail");
    String version = props.getProperty("version");

    Description description = new Description();
    description.setLabel(keyStr);
    description.setSummary(descStr);

    ExtensionServerInfo esi = new ExtensionServerInfo();
    esi.setDescription(description);
    esi.setUrl(extUrl);
    esi.setCompany(companyStr);
    // the following type must NOT be changed
    esi.setType("com.vmware.vim.viClientScripts");
    esi.setAdminEmail( new String[] { adminEmail } );

    ExtensionClientInfo eci = new ExtensionClientInfo();
    eci.setCompany(companyStr);
    eci.setUrl(extUrl);
    eci.setType("com.vmware.vim.viClientScripts");
    eci.setVersion(version);
    eci.setDescription(description);

    Extension ext = new Extension();
    ext.setServer(new ExtensionServerInfo[]{esi});
    ext.setClient(new ExtensionClientInfo[] {eci});
    ext.setDescription(description);
    ext.setKey(keyStr);
    ext.setVersion(version);
    ext.setLastHeartbeatTime(Calendar.getInstance());

    return ext;
  }
  
  static void printAllExtensions(Extension[] exts) 
  {
    System.out.println("There are totally " + 
        exts.length + " plugin(s) registered.");

    for(int i=0; exts!=null && i<exts.length; i++)
    {
      System.out.println("\n --- Plugin # " + (i+1) + " --- ");
      System.out.println("Key: " + exts[i].getKey());
      System.out.println("Version: " + exts[i].getVersion());
      System.out.println("Registration Time: " + 
          exts[i].getLastHeartbeatTime().getTime());
      System.out.println("Configuration URL: " + 
          exts[i].getServer()[0].getUrl());
    }
  }
}