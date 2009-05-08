package com.vmware.vim25.mo.samples;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.vmware.vim25.Description;
import com.vmware.vim25.Extension;
import com.vmware.vim25.ExtensionClientInfo;
import com.vmware.vim25.ExtensionServerInfo;
import com.vmware.vim25.VirtualMachineSummary;
import com.vmware.vim25.cf.CacheInstance;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.InventoryNavigator;
import com.vmware.vim25.mo.ManagedEntity;
import com.vmware.vim25.mo.ServiceInstance;

public class CacheFrameworkSample
{
  public static void main(String[] args) throws Exception
  {
    ServiceInstance si = new ServiceInstance(new URL("http://10.20.143.205/sdk"), "root", "password", true); 
    Folder rootFolder = si.getRootFolder();
    ManagedEntity[] vms = new InventoryNavigator(rootFolder).searchManagedEntities("VirtualMachine");
    ManagedEntity[] hosts = new InventoryNavigator(rootFolder).searchManagedEntities("HostSystem");
  
    CacheInstance vicf = new CacheInstance(si);
    vicf.watch(vms, new String[] {"name", "runtime.powerState", "summary"});
    vicf.watch(hosts, new String[] {"name", "summary"});
    vicf.start();

    Thread.sleep(1000);
    Thread[] vrs = new VimReader[2];

    for(int i=0; i<vrs.length; i++)
    {
      vrs[i] = new VimReader("Thread " + i, vicf, vms, hosts);
      vrs[i].start();
    }
    
    for(int i=0; i<vrs.length; i++)
    {
      vrs[i].join();
    }
    si.getServerConnection().logout();
  }
}

class VimReader extends Thread
{
  private CacheInstance vicf;
  private ManagedEntity[] vms;
  private ManagedEntity[] hosts;
  
  public VimReader(String name, CacheInstance vicf, ManagedEntity[] vms, ManagedEntity[] hosts)
  {
    super(name);
    this.vicf = vicf;
    this.vms = vms;
    this.hosts = hosts;
  }
  
  public void run()
  {
    for(;;)
    {
      for(int i=0; i<1; i++)
      {
        String name = (String) vicf.get(vms[i], "name");
        SimpleDateFormat sdf = new SimpleDateFormat();
        Object power = vicf.get(vms[i], "runtime.powerState");
        VirtualMachineSummary summary = (VirtualMachineSummary )vicf.get(vms[i], "summary");
        System.out.println(this.getName() + " reading vm: " + name + " = " + power + " @ " + sdf.format(new Date(System.currentTimeMillis())));//+ summary.getRuntime().getMaxMemoryUsage());
      }
      
      for(int i=0; i<1; i++)
      {
        String name = (String) vicf.get(hosts[i], "name");
        Object summary = vicf.get(hosts[i], "summary");
        System.out.println(this.getName() + " reading host: " + name + " = " + summary);
      }
      
      System.out.flush();
      try
      {
        Thread.sleep(30000);
      } catch(Exception e)
      {}
    }
  }
}