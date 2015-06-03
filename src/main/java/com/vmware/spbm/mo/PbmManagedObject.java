package com.vmware.spbm.mo;

import org.apache.log4j.Logger;

import com.vmware.vim25.ManagedObjectReference;
import com.vmware.spbm.PbmPortType;

/**
 *
 * @author Atoka Sema
 */

abstract public class PbmManagedObject {
    private static String MO_PACKAGE_NAME = null;

    /**
     * Create Logger
     */
    private static Logger log = Logger.getLogger(PbmManagedObject.class);

    static {
        MO_PACKAGE_NAME = PbmManagedObject.class.getPackage().getName();
    }

    /**
     * holds the ServerConnection instance
     */
    private PbmServerConnection pbmServerConnection = null;
    /**
     * holds the ExtensionManager managed object reference
     */
    private ManagedObjectReference mor = null;

    protected PbmManagedObject() {
    }

    /**
     * Constructor that reuse exiting web service connection Use this constructor when you can re-use existing web
     * service connection.
     *
     * @param serverConnection
     * @param mor
     */
    public PbmManagedObject(PbmServerConnection pbmServerConnection, ManagedObjectReference mor) {
        this.pbmServerConnection = pbmServerConnection;
        this.mor = mor;
    }

    /**
     * Set the ManagedObjectReference object pointing to the managed object
     */
    protected void setMOR(ManagedObjectReference mor) {
        this.mor = mor;
    }

    /**
     * get the ManagedObjectReference object pointing to the managed object
     *
     * @return
     */
    public ManagedObjectReference getMOR() {
        return this.mor;
    }

    /**
     * Get the web service
     *
     * @return
     */
    protected PbmPortType getPbmService() {
        return pbmServerConnection.getPbmService();
    }

    public PbmServerConnection getPbmServerConnection() {
        return pbmServerConnection;
    }

    /**
     * Set up the ServerConnection, only when it hasn't been set yet.
     *
     * @param sc
     */
    protected void setPbmServerConnection(PbmServerConnection psc) {
        if (this.pbmServerConnection == null) {
            this.pbmServerConnection = psc;
        }
    }

    @Override
    public String toString() {
        return mor.type + ":" + mor.val + " @ " + getPbmServerConnection().getUrl();
    }

}
