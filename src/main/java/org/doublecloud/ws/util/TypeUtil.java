/*================================================================================
Copyright (c) 2013 Steve Jin. All Rights Reserved.

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

package org.doublecloud.ws.util;

import org.apache.log4j.Logger;

import com.vmware.vim25.ws.XmlGenDom;

import java.lang.reflect.Array;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class TypeUtil {

    final public static Class<?> INT_ARRAY_CLASS = int[].class;
    final public static Class<?> BYTE_ARRAY_CLASS = byte[].class;
    final public static Class<?> LONG_ARRAY_CLASS = long[].class;

    private static Logger log = Logger.getLogger(TypeUtil.class);

    private final static Set<String> PRIMITIVE_TYPES = new HashSet<String>();

    static {
        PRIMITIVE_TYPES.add("int");
        PRIMITIVE_TYPES.add("boolean");
        PRIMITIVE_TYPES.add("short");
        PRIMITIVE_TYPES.add("float");
        PRIMITIVE_TYPES.add("byte");
        PRIMITIVE_TYPES.add("long");
        PRIMITIVE_TYPES.add("double");
    }

    public static boolean isPrimitiveType(String type) {
        return PRIMITIVE_TYPES.contains(type);
    }

    private static String[] BASIC_TYPES = new String[] {
        "String", "int", "short",
        "long", "float", "Float",
        "byte", "boolean", "Boolean",
        "Calendar", "double"
    };

    public static boolean isBasicType(String type) {
        for (String BASIC_TYPE : BASIC_TYPES) {
            if (type.startsWith(BASIC_TYPE)) {
                return true;
            }
        }
        return false;
    }

    final private static Package LANG_PKG = String.class.getPackage();
    final private static Package UTIL_PKG = Calendar.class.getPackage();

    public static boolean isBasicType(Class<?> clazz) {
        Package pkg = clazz.getPackage(); // for primitive type like int, the pkg is null
        return pkg == null || pkg == LANG_PKG || pkg == UTIL_PKG;
    }

    public final static String PACKAGE_NAME = "com.vmware.vim25";
    public final static String PBM_PACKAGE_NAME = "com.vmware.spbm";
    private final static Map<String, Class<?>> VIM_CLASSES = new ConcurrentHashMap<String, Class<?>>();

    public static Class<?> getVimClass(String packge, String type) {
        if (VIM_CLASSES.containsKey(type)) {
            return VIM_CLASSES.get(type);
        }
        else {
            try {
                Class<?> clazz;
                if (!type.endsWith("[]")) {
                    if (type.startsWith("vim25:")) {
                        type = type.substring(("vim25:").length());
                        packge = PACKAGE_NAME;
                    }
                    if (type.startsWith("pbm:")) {
                        type = type.substring(("pbm:").length());
                        packge = PBM_PACKAGE_NAME;
                    }
                    type = (packge == null || packge.isEmpty()) ? PACKAGE_NAME: packge + "." + type;
                    clazz = Class.forName(type);
                }
                else {
                    String arrayType = type.substring(0, type.length() - 2);
                    clazz = Array.newInstance(getVimClass(packge, arrayType), 0).getClass();
                }

                VIM_CLASSES.put(type, clazz);

                return clazz;
            }
            catch (ClassNotFoundException cnfe) {
                log.error("ClassNotFoundException caught for type: " + type, cnfe);
                return null;
            }
        }
    }


    private static Class<?>[] clazzes = new Class[]{
        java.lang.Integer.class, java.lang.Long.class,
        java.lang.Boolean.class, java.lang.Short.class,
        java.lang.Float.class, java.lang.String.class,
        java.lang.Byte.class, java.lang.Double.class
    };
    private static String[] xsdStrs = new String[]{
        "xsd:int", "xsd:long",
        "xsd:boolean", "xsd:short",
        "xsd:float", "xsd:string",
        "xsd:byte", "xsd:double"
    };

    //only for the basic data types as shown above
    public static String getXSIType(Object obj) {
        Class<?> type = obj.getClass();

        for (int i = 0; i < clazzes.length; i++) {
            if (type == clazzes[i]) {
                return xsdStrs[i];
            }
        }

        if (obj instanceof java.util.Calendar) {
            return "xsd:dateTime";
        }

        throw new RuntimeException("Unknown data type during serialization:" + type);
    }
}