package com.vmware.vim25.mo.samples;

//# Copyright 2008 VMware, Inc.  All rights reserved.

//#######################################################################################
//# DISCLAIMER. THIS SCRIPT IS PROVIDED TO YOU "AS IS" WITHOUT WARRANTIES OR CONDITIONS 
//# OF ANY KIND, WHETHER ORAL OR WRITTEN, EXPRESS OR IMPLIED. THE AUTHOR SPECIFICALLY 
//# DISCLAIMS ANY IMPLIED WARRANTIES OR CONDITIONS OF MERCHANTABILITY, SATISFACTORY 
//# QUALITY, NON-INFRINGEMENT AND FITNESS FOR A PARTICULAR PURPOSE. 
//#######################################################################################

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import com.vmware.vim25.ArrayOfEvent;
import com.vmware.vim25.Event;
import com.vmware.vim25.EventFilterSpec;
import com.vmware.vim25.EventFilterSpecByEntity;
import com.vmware.vim25.EventFilterSpecRecursionOption;
import com.vmware.vim25.ObjectSpec;
import com.vmware.vim25.ObjectUpdate;
import com.vmware.vim25.ObjectUpdateKind;
import com.vmware.vim25.PropertyChange;
import com.vmware.vim25.PropertyChangeOp;
import com.vmware.vim25.PropertyFilterSpec;
import com.vmware.vim25.PropertyFilterUpdate;
import com.vmware.vim25.PropertySpec;
import com.vmware.vim25.RequestCanceled;
import com.vmware.vim25.SelectionSpec;
import com.vmware.vim25.UpdateSet;
import com.vmware.vim25.VmEvent;
import com.vmware.vim25.mo.EventHistoryCollector;
import com.vmware.vim25.mo.EventManager;
import com.vmware.vim25.mo.Folder;
import com.vmware.vim25.mo.PropertyCollector;
import com.vmware.vim25.mo.PropertyFilter;
import com.vmware.vim25.mo.ServiceInstance;

/**
 * This sample shows you how to monitor for updates on events from VC
 * 
 * @author Tom Elliott (twelliott - telliott@vmware.com)
 * 
 */
public class VMEventsMonitor implements Runnable
{

    private static ServiceInstance si = null;

    private Folder _rootFolder;

    // EventManager and EventHistoryCollector References
    private EventManager _eventManager;

    private EventHistoryCollector _eventHistoryCollector;

    private static PropertyFilter propFilter;

    private static PropertyCollector propColl;

    private static Boolean shouldRun;

    /**
     * Initialize the necessary Managed Object References needed here
     */
    private void initialize()
    {
        _eventManager = si.getEventManager();
        _rootFolder = si.getRootFolder();
    }

    private void createEventHistoryCollector() throws Exception
    {
        // Create an Entity Event Filter Spec to
        // specify the MoRef of the VM to be get events filtered for
        EventFilterSpecByEntity entitySpec = new EventFilterSpecByEntity();
        entitySpec.setEntity(_rootFolder.getMOR());
        entitySpec.setRecursion(EventFilterSpecRecursionOption.children);

        // set the entity spec in the EventFilter
        EventFilterSpec eventFilter = new EventFilterSpec();
        eventFilter.setEntity(entitySpec);

        // we are only interested in getting events for the VM.
        // Add as many events you want to track relating to vm.
        // Refer to API Data Object vmEvent and see the extends class list for
        // elaborate list of vmEvents
        eventFilter.setType(new String[] { "VmPoweredOffEvent",
                "VmPoweredOnEvent", "VmSuspendedEvent", "VmRenamedEvent" });

        // create the EventHistoryCollector to monitor events for a VM
        // and get the ManagedObjectReference of the EventHistoryCollector
        // returned
        _eventHistoryCollector = _eventManager
                .createCollectorForEvents(eventFilter);
    }

    private PropertyFilterSpec createEventFilterSpec()
    {
        // Set up a PropertySpec to use the latestPage attribute
        // of the EventHistoryCollector

        PropertySpec propSpec = new PropertySpec();
        propSpec.setAll(new Boolean(false));
        propSpec.setPathSet(new String[] { "latestPage" });
        propSpec.setType(_eventHistoryCollector.getMOR().getType());

        // PropertySpecs are wrapped in a PropertySpec array
        PropertySpec[] propSpecAry = new PropertySpec[] { propSpec };

        // Set up an ObjectSpec with the above PropertySpec for the
        // EventHistoryCollector we just created
        // as the Root or Starting Object to get Attributes for.
        ObjectSpec objSpec = new ObjectSpec();
        objSpec.setObj(_eventHistoryCollector.getMOR());
        objSpec.setSkip(new Boolean(false));

        // Get Event objects in "latestPage" from "EventHistoryCollector"
        // and no "traversl" further, so, no SelectionSpec is specified
        objSpec.setSelectSet(new SelectionSpec[] {});

        // ObjectSpecs are wrapped in an ObjectSpec array
        ObjectSpec[] objSpecAry = new ObjectSpec[] { objSpec };

        PropertyFilterSpec spec = new PropertyFilterSpec();
        spec.setPropSet(propSpecAry);
        spec.setObjectSet(objSpecAry);
        return spec;
    }

    void handleUpdate(UpdateSet update)
    {
        ObjectUpdate[] vmUpdates;
        PropertyFilterUpdate[] pfus = update.getFilterSet();
        for (int pfui = 0; pfui < pfus.length; pfui++)
        {
            System.out.println("Virtual Machine updates:");
            vmUpdates = pfus[pfui].getObjectSet();
            for (ObjectUpdate vmi : vmUpdates)
            {
                System.out.println("Handling object update");
                handleObjectUpdate(vmi);
            }
        }
    }

    void handleObjectUpdate(ObjectUpdate oUpdate)
    {
        PropertyChange[] pc = oUpdate.getChangeSet();
        System.out.println("Update kind = " + oUpdate.getKind());
        if (oUpdate.getKind() == ObjectUpdateKind.enter)
        {
            System.out.println(" New Data:");
            handleChanges(pc);
        } else if (oUpdate.getKind() == ObjectUpdateKind.leave)
        {
            System.out.println(" Removed Data:");
            handleChanges(pc);
        } else if (oUpdate.getKind() == ObjectUpdateKind.modify)
        {
            System.out.println(" Changed Data:");
            handleChanges(pc);
        }

    }

    void handleChanges(PropertyChange[] changes)
    {
        for (int pci = 0; pci < changes.length; ++pci)
        {
            String name = changes[pci].getName();
            Object value = changes[pci].getVal();
            PropertyChangeOp op = changes[pci].getOp();
            if (value != null && !op.getValue().equalsIgnoreCase("remove"))
            {
                System.out.println("===============");
                System.out.println("\nEvent Details follows:");
                if (value instanceof ArrayOfEvent)
                {
                    ArrayOfEvent aoe = (ArrayOfEvent) value;
                    Event[] evts = aoe.getEvent();
                    for (int evtID = 0; evtID < evts.length; ++evtID)
                    {
                        Event anEvent = evts[evtID];
                        System.out.println("\n----------" + "\n Event ID: "
                                + anEvent.getKey() + "\n Event: "
                                + anEvent.getClass().getName()
                                + "\n FullFormattedMessage: "
                                + anEvent.getFullFormattedMessage()
                                + "\n VM Reference: "
                                + anEvent.getVm().getVm().get_value()
                                + "\n----------\n");
                    }
                } else if (value instanceof VmEvent)
                {
                    VmEvent anEvent = (VmEvent) value;
                    System.out.println("\n----------" + "\n Event ID: "
                            + anEvent.getKey() + "\n Event: "
                            + anEvent.getClass().getName()
                            + "\n FullFormattedMessage: "
                            + anEvent.getFullFormattedMessage()
                            + "\n VM Reference: "
                            + anEvent.getVm().getVm().get_value()
                            + "\n----------\n");
                }
                System.out.println("===============");
            }
        }
    }

    public static void main(String[] args)
    {
        try
        {

            if (args.length != 3)
            {
                usage();
                return;
            }

            String urlStr = args[0];
            String username = args[1];
            String password = args[2];

            System.out.println("Connecting to " + urlStr + " as " + username);

            si = new ServiceInstance(new URL(urlStr), username, password, true);

            System.out.println("info---" + si.getAboutInfo().getFullName());

            VMEventsMonitor eventMonitor = new VMEventsMonitor();

            eventMonitor.initialize();
            eventMonitor.createEventHistoryCollector();

            PropertyFilterSpec eventFilterSpec = eventMonitor
                    .createEventFilterSpec();
            propColl = si.getPropertyCollector();

            propFilter = propColl.createFilter(eventFilterSpec, true);

            Thread watchUpdates = new Thread(eventMonitor);
            shouldRun = true;
            watchUpdates.start();
            BufferedReader console = new BufferedReader(new InputStreamReader(
                    System.in));
            do
            {
                System.out.println("");
                System.out.println("Enter 'exit' <Enter> to exit the program");
                String line = console.readLine();
                if (line.trim().equalsIgnoreCase("exit"))
                    break;
            } while (true);
            shouldRun = false;
            propColl.cancelWaitForUpdates();
            System.out
                    .println("Exiting the program, performing required cleaning");
            propFilter.destroyPropertyFilter();
            si.getServerConnection().logout();

        } catch (Exception e)
        {
            System.out.println("Caught Exception : " + " Name : "
                    + e.getClass().getName() + " Message : " + e.getMessage()
                    + " Trace : ");
        }
    }

    private static void usage()
    {
        System.err.println("Usage: QueryEvent server username password");
    }

    public void run()
    {
        String version = "";
        try
        {
            do
            {
                try
                {
                    System.out
                            .println("Waiting for new Updates. \nEnter 'exit' <Enter> to exit the program");
                    UpdateSet update = propColl.waitForUpdates(version);
                    if (update != null && update.getFilterSet() != null)
                    {

                        version = update.getVersion();
                        System.out.println(" Current Version: " + version);
                        
                        this.handleUpdate(update);

                    } else
                    {
                        System.out.println("No update is present!");
                    }
                } catch (Exception e)
                {
                    if (e instanceof org.apache.axis.AxisFault)
                    {
                        org.apache.axis.AxisFault fault = (org.apache.axis.AxisFault) e;
                        org.w3c.dom.Element[] errors = fault.getFaultDetails();
                        String faultString = fault.getFaultString();
                        if (faultString
                                .indexOf("java.net.SocketTimeoutException") != -1)
                        {
                        } else
                        {
                            throw e;
                        }
                    }
                }
            } while (shouldRun);
        } catch (Exception e)
        {
            if (e instanceof RequestCanceled)
            {
                System.out.println("OK");
            } else
            {
                System.out.println("Caught Exception : " + " Name : "
                        + e.getClass().getName() + " Message : "
                        + e.getMessage() + " Trace : ");
            }
        }
    }
}
