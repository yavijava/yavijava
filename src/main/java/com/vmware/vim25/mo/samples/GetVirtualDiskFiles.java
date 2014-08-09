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
import com.vmware.vim25.*;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;

/**
	*<pre>
	*This sample searches the Virtual disk files in all the data stores available in
	*specified host using Controller Type Property. 
	*Note: This property is not available in VC 3.0.1 and ESX 3.0.1
	*
	*<b>Parameters:</b>
	*	--hostname [hostname]
	 *  --url [webserviceurl] 
	 *  --username [username] 
	 * 	--password [password]
	*</pre>
	* @author sjin
*/

public class GetVirtualDiskFiles 
{
	public static void main(String[] args) throws Exception
	{
	    CommandLineParser clp = new CommandLineParser(constructOptions(), args);
	   	String urlStr = clp.get_option("url");
  	    String username = clp.get_option("username");
	    String password = clp.get_option("password");
		String hostname = clp.get_option("hostname");

		ServiceInstance si = new ServiceInstance(new URL(urlStr), username, password, true);
		HostSystem host = (HostSystem) new InventoryNavigator(si.getRootFolder()).searchManagedEntity("HostSystem",hostname);
		
		Datastore[] datastores = host.getDatastores();
	
		System.out.println("Searching The Datastores using Controller Type Property");
		for(int i = 0; i < datastores.length; i++) 
		{
			HostDatastoreBrowser dsBrowser = datastores[i].getBrowser();
			DatastoreSummary ds =  datastores[i].getSummary();
			String dsName = ds.getName();  
			System.out.println("\nSearching The Datastore " + dsName);

			VmDiskFileQueryFilter vdiskFilter = new VmDiskFileQueryFilter();
			vdiskFilter.setControllerType(new String [] {"VirtualIDEController"});

			VmDiskFileQuery fQuery = new VmDiskFileQuery();
			fQuery.setFilter(vdiskFilter);

			HostDatastoreBrowserSearchSpec searchSpec = new HostDatastoreBrowserSearchSpec();
			searchSpec.setQuery(new FileQuery []{fQuery});
			//searchSpec.setMatchPattern(matchPattern);
			
			Task task = dsBrowser.searchDatastoreSubFolders_Task("["+dsName+"]", searchSpec);
			task.waitForMe();
			TaskInfo tInfo = task.getTaskInfo();         
			ArrayOfHostDatastoreBrowserSearchResults searchResult = 
					(ArrayOfHostDatastoreBrowserSearchResults)tInfo.getResult();
            
			int len = searchResult.getHostDatastoreBrowserSearchResults().length;                        
			for(int j=0 ; j<len; j++) 
			{
				HostDatastoreBrowserSearchResults sres =  searchResult.HostDatastoreBrowserSearchResults[j];
				FileInfo [] fileArray = sres.getFile();
				if(fileArray == null) continue;
				for(int k=0 ; k<fileArray.length; k++) 
				{
					System.out.println("Virtual Disks Files " + fileArray[k].getPath());
				}
			}
		}
   }
    
	public static OptionSpec[] constructOptions() 
	{
        OptionSpec [] useroptions = new OptionSpec[1];
        useroptions[0] = new OptionSpec("hostname","String",1
                                        ,"Name of the host", null);
        return useroptions;
    }
     
    
}
