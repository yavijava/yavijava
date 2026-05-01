package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import org.junit.Test;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InventoryNavigatorTest {

    // Configures a sequence of pages; retrievePropertiesEx returns first, continueRetrievePropertiesEx returns the rest.
    // retrieveProperties (the old deprecated path) returns only the first page's objects, so multi-page tests fail
    // with the correct assertion error rather than NPE when run against unfixed code.
    static class StubPropertyCollector extends PropertyCollector {
        private final List<RetrieveResult> pages;
        private int callCount = 0;

        StubPropertyCollector(RetrieveResult... pages) {
            super(null, null);
            this.pages = Arrays.asList(pages);
        }

        @Override
        public ObjectContent[] retrieveProperties(PropertyFilterSpec[] specSet)
                throws InvalidProperty, RuntimeFault, RemoteException {
            return pages.isEmpty() ? null : pages.get(0).getObjects();
        }

        @Override
        public RetrieveResult retrievePropertiesEx(PropertyFilterSpec[] specSet, RetrieveOptions options)
                throws InvalidProperty, RuntimeFault, RemoteException {
            return pages.isEmpty() ? null : pages.get(callCount++);
        }

        @Override
        public RetrieveResult continueRetrievePropertiesEx(String token)
                throws InvalidProperty, RuntimeFault, RemoteException {
            return pages.get(callCount++);
        }
    }

    static class StubServiceInstance extends ServiceInstance {
        private final PropertyCollector pc;

        StubServiceInstance(PropertyCollector pc) {
            super(new ServerConnection(null, null, null));
            this.pc = pc;
        }

        @Override
        public PropertyCollector getPropertyCollector() {
            return pc;
        }

        @Override
        public AboutInfo getAboutInfo() {
            AboutInfo ai = new AboutInfo();
            ai.apiVersion = "7.0.0";
            return ai;
        }
    }

    private InventoryNavigator makeNavigator(StubPropertyCollector stubPc) {
        StubServiceInstance si = new StubServiceInstance(stubPc);
        ServerConnection sc = new ServerConnection(null, null, si);
        ManagedObjectReference rootMor = new ManagedObjectReference();
        rootMor.setType("Folder");
        rootMor.setVal("group-d1");
        ManagedEntity root = new ManagedEntity(sc, rootMor) {};
        return new InventoryNavigator(root);
    }

    private ObjectContent folderContent(String val) {
        ManagedObjectReference mor = new ManagedObjectReference();
        mor.setType("Folder");
        mor.setVal(val);
        ObjectContent oc = new ObjectContent();
        oc.setObj(mor);
        return oc;
    }

    private RetrieveResult page(String token, ObjectContent... objects) {
        RetrieveResult r = new RetrieveResult();
        r.token = token;
        r.objects = objects.length > 0 ? objects : null;
        return r;
    }

    @Test
    public void searchManagedEntities_singlePage_returnsAllObjects() throws Exception {
        StubPropertyCollector stubPc = new StubPropertyCollector(
            page(null, folderContent("folder-1"), folderContent("folder-2"), folderContent("folder-3"))
        );

        ManagedEntity[] result = makeNavigator(stubPc).searchManagedEntities("Folder");

        assertEquals(3, result.length);
    }

    @Test
    public void searchManagedEntities_multiPage_accumulatesAcrossPages() throws Exception {
        StubPropertyCollector stubPc = new StubPropertyCollector(
            page("page2-token", folderContent("folder-1"), folderContent("folder-2")),
            page(null,           folderContent("folder-3"), folderContent("folder-4"))
        );

        ManagedEntity[] result = makeNavigator(stubPc).searchManagedEntities("Folder");

        assertEquals(4, result.length);
    }

    @Test
    public void searchManagedEntities_emptyPage_returnsEmptyArray() throws Exception {
        StubPropertyCollector stubPc = new StubPropertyCollector(
            page(null) // no objects
        );

        ManagedEntity[] result = makeNavigator(stubPc).searchManagedEntities("Folder");

        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void searchManagedEntities_nullTypeinfo_returnsEmptyArray() throws Exception {
        StubPropertyCollector stubPc = new StubPropertyCollector();
        InventoryNavigator nav = makeNavigator(stubPc);

        ManagedEntity[] result = nav.searchManagedEntities(null, true);

        assertNotNull(result);
        assertEquals(0, result.length);
    }

    private ObjectContent folderContentWithProps(String val, String name, ManagedEntityStatus overallStatus) {
        ObjectContent oc = folderContent(val);
        DynamicProperty pName = new DynamicProperty();
        pName.setName("name");
        pName.setVal(name);
        DynamicProperty pStatus = new DynamicProperty();
        pStatus.setName("overallStatus");
        pStatus.setVal(overallStatus);
        oc.setPropSet(new DynamicProperty[]{pName, pStatus});
        return oc;
    }

    @Test
    public void searchManagedEntitiesWithProperties_populatesPropertyCacheOnEachEntity() throws Exception {
        StubPropertyCollector stubPc = new StubPropertyCollector(
            page(null,
                folderContentWithProps("folder-1", "datacenter-folder", ManagedEntityStatus.green),
                folderContentWithProps("folder-2", "vm-folder", ManagedEntityStatus.yellow))
        );
        InventoryNavigator nav = makeNavigator(stubPc);

        ManagedEntity[] result = nav.searchManagedEntitiesWithProperties(
            new String[][]{{"Folder", "name", "overallStatus"}}, true);

        assertEquals(2, result.length);

        // Cached values are accessible via the typed getters with no extra round-trip.
        // Calling getName() here would NPE if it tried to talk to the server (stub is
        // PropertyCollector-only and getName() goes through getCurrentProperty/retrieveObjectProperties).
        assertEquals("datacenter-folder", result[0].getName());
        assertEquals(ManagedEntityStatus.green, result[0].getOverallStatus());
        assertEquals("vm-folder", result[1].getName());
        assertEquals(ManagedEntityStatus.yellow, result[1].getOverallStatus());
    }

    @Test
    public void searchManagedEntitiesWithProperties_nullTypeinfo_returnsEmptyArray() throws Exception {
        InventoryNavigator nav = makeNavigator(new StubPropertyCollector());

        ManagedEntity[] result = nav.searchManagedEntitiesWithProperties(null, true);

        assertNotNull(result);
        assertEquals(0, result.length);
    }
}
