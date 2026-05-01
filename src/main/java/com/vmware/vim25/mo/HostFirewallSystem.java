// auto generated using yavijava_generator
package com.vmware.vim25.mo;

import com.vmware.vim25.*;
import com.vmware.vim25.mo.util.MorUtil;
import java.rmi.RemoteException;

/* ===== BEGIN custom imports (preserved by regenerator) ===== */
/* ===== END custom imports ===== */

public class HostFirewallSystem extends ExtensibleManagedObject {

    public HostFirewallSystem(ServerConnection serverConnection, ManagedObjectReference mor) {
        super(serverConnection, mor);
    }

    public HostFirewallInfo getFirewallInfo() {
        return (HostFirewallInfo) getCurrentProperty("firewallInfo");
    }

    public void disableRuleset(String id) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().disableRuleset(getMOR(), id);
    }

    public void enableRuleset(String id) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().enableRuleset(getMOR(), id);
    }

    public void refresh() throws RuntimeFault, RemoteException {
        getVimService().refresh(getMOR());
    }

    public void updateDefaultPolicy(HostFirewallDefaultPolicy defaultPolicy) throws RuntimeFault, RemoteException {
        getVimService().updateDefaultPolicy(getMOR(), defaultPolicy);
    }

    public void updateRuleset(String id, HostFirewallRulesetRulesetSpec spec) throws HostConfigFault, NotFound, RuntimeFault, RemoteException {
        getVimService().updateRuleset(getMOR(), id, spec);
    }

    /* ===== BEGIN custom (preserved by regenerator) ===== */
    public void refreshFirewall() throws RuntimeFault, RemoteException {
        getVimService().refreshFirewall(getMOR());
    }
    /* ===== END custom ===== */
}
