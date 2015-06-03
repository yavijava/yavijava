package com.vmware.spbm.mo;

import java.lang.reflect.Constructor;

import org.apache.log4j.Logger;

import com.vmware.vim25.ManagedObjectReference;

public class PbmMorUtil {

    /**
     * Package name used for class generation
     */
    final public static String moPackageName = "com.vmware.spbm.mo";

    private static Logger log = Logger.getLogger(PbmMorUtil.class);

    /**
     * Takes an array of ManagedObjects and returns the MOR for each MO
     *
     * @param mos
     * @return
     */
    public static ManagedObjectReference[] createMORs(PbmManagedObject[] mos) {
        if (mos == null) {
            throw new IllegalArgumentException();
        }
        ManagedObjectReference[] mors = new ManagedObjectReference[mos.length];
        for (int i = 0; i < mos.length; i++) {
            mors[i] = mos[i].getMOR();
        }
        return mors;
    }

    /**
     * Given the ServerConnection and a MOR return the MO
     *
     * @param sc
     * @param mor
     * @return
     */
    public static PbmManagedObject createExactManagedObject(PbmServerConnection sc, ManagedObjectReference mor) {
        if (mor == null) {
            return null;
        }

        String moType = mor.type;

        try {
            Class<?> moClass = Class.forName(moPackageName + "." + moType);
            Constructor constructor = moClass.getConstructor(new Class[] {
                PbmServerConnection.class, ManagedObjectReference.class
            });
            return (PbmManagedObject) constructor.newInstance(new Object[] {
                sc, mor
            });
        } catch (Exception e) {
            log.error("Failed to create PBM MO for " + mor.toString(), e);
            return null;
        }
    }
}
