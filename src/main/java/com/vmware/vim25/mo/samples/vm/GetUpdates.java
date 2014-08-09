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

package com.vmware.vim25.mo.samples.vm;

import com.vmware.vim25.HostListSummaryQuickStats;
import com.vmware.vim25.HostRuntimeInfo;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.ObjectUpdate;
import com.vmware.vim25.PropertyChange;
import com.vmware.vim25.PropertyChangeOp;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertyFilterUpdate;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VirtualMachineQuickStats;
import com.vmware.vim25.VirtualMachineRuntimeInfo;
import com.vmware.vim25.mo.*;
import com.vmware.vim25.mo.util.*;
import com.vmware.vim25.ws.*;

import java.util.*;
import java.io.*;
import java.net.URL;


 /**
 *<pre>
 *This sample demonstrates how to use the PropertyCollector to monitor
 *one or more properties of one or more managed objects. In particular
 *this sample monitors all or one Virtual Machine and all or one Host
 *for changes to some basic properties.
 *
 *<b>To run this samples following parameters are used :</b>
 *
 *vmname    [required]   : name of the virtual machine  
 *
 *<b>Command : /<b>
 *run.bat com.vmware.samples.general.GetUpdates --url [webserviceurl] 
 *--username [username] --password [password] --vmname  [vmName]
 *
 *<pre>
 *
 * @author Steve Jin
 * This is a sample converted from a similar sample from VMware web site.
 * It definitely needs clean-up ...
 */

public class GetUpdates 
{
	
	public static void main(String [] args) throws Exception
	{
	    CommandLineParser clp = new CommandLineParser(constructOptions(), args);
	   	String urlStr = clp.get_option("url");
  	    String username = clp.get_option("username");
	    String password = clp.get_option("password");
	    String vmname = clp.get_option("vmname");
	   
		ServiceInstance si = new ServiceInstance(new URL(urlStr), username, password, true);
		Folder rootFolder = si.getRootFolder();
		VirtualMachine vm = (VirtualMachine) new InventoryNavigator(rootFolder).searchManagedEntity("VirtualMachine", vmname);
		
		if(vm == null) 
		{
			System.out.println("Virtual Machine " + vmname  + " Not Found");
			return;
		}
		// "summary.quickStats" is taken out -- API ref says, 
		// "A set of statistics that are typically updated with near real-time regularity. 
		// This data object type does not support notification, for scalability reasons. 
		// Therefore, changes in QuickStats do not generate property collector updates. 
		// To monitor statistics values, use the statistics and alarms modules instead. 
		String[][] typeInfo = { new String[]{"VirtualMachine", "name","runtime"}};
		
		PropertySpec[] pSpecs = PropertyCollectorUtil.buildPropertySpecArray(typeInfo);
		ObjectSpec[] oSpecs = createObjectSpecs(vm);
		PropertyFilterSpec pSpec = new PropertyFilterSpec();
		pSpec.setPropSet(pSpecs);
		pSpec.setObjectSet(oSpecs);

		PropertyCollector pc = si.getPropertyCollector();
		PropertyFilter pf = pc.createFilter(pSpec, false);

		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String version = "";
		while(true)
		{
			UpdateSet update = pc.checkForUpdates(version);
			if(update != null && update.getFilterSet() != null) 
			{
				handleUpdate(update);
				version = update.getVersion();
				System.out.println("version is:" + version);
			} 
			else
			{
				System.out.println("No update is present!");
			}
			
			System.out.println("\nPress <Enter> to check for updates");
			System.out.println("Enter 'exit' <Enter> to exit the program");
			if(console.readLine().trim().equalsIgnoreCase("exit"))
				break;
		}
		pf.destroyPropertyFilter();
		si.getServerConnection().logout();
   }
	
	static ObjectSpec[] createObjectSpecs(ManagedObject mo)
	{
		ObjectSpec[] oSpecs = new ObjectSpec[] { new ObjectSpec() };            
		oSpecs[0].setObj(mo.getMOR());
		oSpecs[0].setSkip(Boolean.FALSE);
		//oSpecs[0].setSelectSet(PropertyCollectorUtil.buildFullTraversal()); // in doubt here...
		return oSpecs;
	}
   
   static void handleUpdate(UpdateSet update) 
   {
      ArrayList vmUpdates = new ArrayList();
      ArrayList hostUpdates = new ArrayList();
      PropertyFilterUpdate[] pfus = update.getFilterSet(); 
      for(int i=0; i<pfus.length; i++) 
      {
         ObjectUpdate[] ous = pfus[i].getObjectSet();
         for(int j=0; j<ous.length; ++j) 
         {
            if(ous[j].getObj().getType().equals("VirtualMachine")) 
            {
               vmUpdates.add(ous[j]);
            } 
            else if(ous[j].getObj().getType().equals("HostSystem")) 
            {
               hostUpdates.add(ous[j]);
            }
         }
      }      
      if(vmUpdates.size() > 0) 
      {
         System.out.println("Virtual Machine updates:");
         for(Iterator vmi = vmUpdates.iterator(); vmi.hasNext();) 
         {
            handleObjectUpdate((ObjectUpdate)vmi.next());
         }
      }      
      if(hostUpdates.size() > 0) 
      {
         System.out.println("Host updates:");
         for(Iterator vmi = hostUpdates.iterator(); vmi.hasNext();) 
         {
            handleObjectUpdate((ObjectUpdate)vmi.next());
         }
      }
   }
   
   static void handleObjectUpdate(ObjectUpdate oUpdate) 
   {
      PropertyChange[] pc = oUpdate.getChangeSet();
      System.out.println(oUpdate.getKind() + "Data:");
	  handleChanges(pc);
   }   
   
   static void handleChanges(PropertyChange[] changes) 
   {
      for(int i=0; i < changes.length; i++) 
      {
         String name = changes[i].getName();
         Object value = changes[i].getVal();
         PropertyChangeOp op = changes[i].getOp();
         if(op != PropertyChangeOp.remove)
         {
        	 System.out.println("  Property Name: " + name);
        	 if("summary.quickStats".equals(name)) 
        	 {               
               if(value instanceof VirtualMachineQuickStats) 
               {
                  VirtualMachineQuickStats vmqs = (VirtualMachineQuickStats)value;
                  String cpu = vmqs.getOverallCpuUsage()==null ? "unavailable" : vmqs.getOverallCpuUsage().toString();
                  String memory = vmqs.getHostMemoryUsage()==null ? "unavailable" : vmqs.getHostMemoryUsage().toString();
                  System.out.println("   Guest Status: " + vmqs.getGuestHeartbeatStatus().toString());
                  System.out.println("   CPU Load %: " + cpu);
                  System.out.println("   Memory Load %: " + memory);
               } 
               else if (value instanceof HostListSummaryQuickStats) 
               {
                  HostListSummaryQuickStats hsqs = (HostListSummaryQuickStats)value;
                  String cpu = hsqs.getOverallCpuUsage()==null ? "unavailable" : hsqs.getOverallCpuUsage().toString();
                  String memory = hsqs.getOverallMemoryUsage()==null ? "unavailable" : hsqs.getOverallMemoryUsage().toString();
                  System.out.println("   CPU Load %: " + cpu);
                  System.out.println("   Memory Load %: " + memory);
               }
            } 
            else if("runtime".equals(name)) 
            {
               if(value instanceof VirtualMachineRuntimeInfo) 
               {
                  VirtualMachineRuntimeInfo vmri = (VirtualMachineRuntimeInfo)value;
                  System.out.println("   Power State: " + vmri.getPowerState().toString());
                  System.out.println("   Connection State: " + vmri.getConnectionState().toString());
                  Calendar bTime = vmri.getBootTime();
                  if(bTime != null) 
                  {
                     System.out.println("   Boot Time: " + bTime.getTime());
                  }
                  Long mOverhead = vmri.getMemoryOverhead();
                  if(mOverhead != null) 
                  {
                     System.out.println("   Memory Overhead: "+mOverhead);
                  }
               } 
               else if(value instanceof HostRuntimeInfo) 
               {
                  HostRuntimeInfo hri = (HostRuntimeInfo)value;
                  System.out.println("   Connection State: " + hri.getConnectionState().toString());
                  Calendar bTime = hri.getBootTime();
                  if(bTime != null) 
                  {
                     System.out.println("   Boot Time: " + bTime.getTime());
                  }
               }
            } 
            else if("name".equals(name)) 
            {
               System.out.println("   "+value);
            } 
            else 
            {
               System.out.println("   "+value.toString());
            }
         } 
         else 
         {
            System.out.println("Property Name: " +name+ " value removed.");
         }
      }
   }
   
   private static OptionSpec[] constructOptions() 
   {
      return new OptionSpec[]
      {
    	  new OptionSpec("vmname","String",1, "Name of the virtual machine", null)
      };
   }

}   
