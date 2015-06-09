/*================================================================================
Copyright (c) 2013 Steve Jin. All Rights Reserved.
Copyright (c) 2009 VMware, Inc. All Rights Reserved.

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

package com.vmware.vim25.ws;

import com.vmware.vim25.ManagedObjectReference;
import org.apache.log4j.Logger;
import org.doublecloud.ws.util.ReflectUtil;
import org.doublecloud.ws.util.TypeUtil;
import org.doublecloud.ws.util.XmlUtil;

import javax.xml.bind.DatatypeConverter;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Calendar;

public abstract class XmlGen {

    private static Logger log = Logger.getLogger(XmlGen.class);

    public static String toXML(String methodName, Argument[] paras, String vimNameSpace) {
        StringBuilder sb = new StringBuilder();
        sb.append(SoapConsts.SOAP_HEADER);

        sb.append("<").append(methodName).append(vimNameSpace);

        for (Argument para : paras) {
            String key = para.getName();
            String type = para.getType();
            Object obj = para.getValue();
            sb.append(toXML(key, XmlGenDom.getPackageName(vimNameSpace), type, obj)); //, null));
        }

        sb.append("</").append(methodName).append(">");
        sb.append(SoapConsts.SOAP_END);
        return sb.toString();
    }

    private static String toXML(String tag, String packge, String type, Object obj) {
        if (obj == null) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        if (TypeUtil.isBasicType(type)) {
            toXML(sb, tag, obj.getClass(), obj);
        }
        else {
            Class<?> clazz = TypeUtil.getVimClass(packge, type);
            toXML(sb, tag, clazz, obj);
        }
        return sb.toString();
    }

    private static void toXML(StringBuffer sb, String tagName, Class<?> type, Object obj) {
        Class<?> clazz = obj.getClass();

        if (clazz.isArray()) {
            if (obj.getClass() == TypeUtil.INT_ARRAY_CLASS) {
                int[] objs = (int[]) obj;
                for (int obj1 : objs) {
                    sb.append("<").append(tagName).append(">");
                    sb.append(obj1);
                    sb.append("</").append(tagName).append(">");
                }
            }
            else if (obj.getClass() == TypeUtil.BYTE_ARRAY_CLASS) {
                byte[] objs = (byte[]) obj;
                for (byte obj1 : objs) {
                    sb.append("<").append(tagName).append(">");
                    sb.append(obj1);
                    sb.append("</").append(tagName).append(">");
                }
            }
            else if (obj.getClass() == TypeUtil.LONG_ARRAY_CLASS) {
                long[] objs = (long[]) obj;
                for (long obj1 : objs) {
                    sb.append("<").append(tagName).append(">");
                    sb.append(obj1);
                    sb.append("</").append(tagName).append(">");
                }
            }
            else {
                Object[] objs = (Object[]) obj;
                for (Object obj1 : objs) {
                    toXML(sb, tagName, type.getComponentType(), obj1);
                }
            }
        }

        // from now on, no array type
        else if (clazz == ManagedObjectReference.class) { //MOR]
            ManagedObjectReference mor = (ManagedObjectReference) obj;
            if (clazz == type) {
                sb.append("<").append(tagName).append(" type=\"").append(mor.type).append("\">");
            }
            else {
                sb.append("<").append(tagName).append(" xsi:type=\"ManagedObjectReference\" type=\"").append(mor.type).append("\">");
            }
            sb.append(mor.val);
            sb.append("</").append(tagName).append(">");
        }
        else if (clazz.getCanonicalName().startsWith("java.lang")) //basic data type
        {
            if (clazz != type) {
                sb.append("<").append(tagName).append(" xsi:type=\"").append(TypeUtil.getXSIType(obj)).append("\">");
            }
            else {
                sb.append("<").append(tagName).append(">");
            }

            if (clazz == String.class) {
                String temp = (String) obj;
                obj = XmlUtil.escapeForXML(temp);
            }

            sb.append(obj);
            sb.append("</").append(tagName).append(">");
        }
        else if (clazz.isEnum()) //enum data type
        {
            sb.append("<").append(tagName).append(">").append(obj).append("</").append(tagName).append(">");
        }
        else if (obj instanceof Calendar) {
            sb.append("<").append(tagName).append(" xsi:type=\"xsd:dateTime\">").append(DatatypeConverter.printDateTime((Calendar) obj)).append("</").append(tagName).append(">");
        }
        else { // VIM type
            if (clazz == type) {
                sb.append("<").append(tagName).append(">");
            }
            else {
                String nameSpaceType = clazz.getSimpleName();
                sb.append("<").append(tagName).append(" xsi:type=\"").append(nameSpaceType).append("\">");
            }

            Field[] fields = ReflectUtil.getAllFields(clazz);

            for (Field f : fields) {
                String fName = f.getName();

                Object value = null;
                if (!Modifier.isTransient(f.getModifiers())) {
                    try {
                        value = f.get(obj);
                    }
                    catch (IllegalAccessException iae) {
                        log.error("IllegalAccessException caught.", iae);
                    }
                }
                if (value == null) {
                    continue;
                }

                Class<?> fType = f.getType();
                toXML(sb, fName, fType, value);
            }
            sb.append("</").append(tagName).append(">");
        }
    }

    public static ManagedObjectReference createMOR(String type, String value) {
        ManagedObjectReference mor = new ManagedObjectReference();
        mor.val = value;
        mor.type = type;
        return mor;
    }

    public abstract Object fromXML(String returnType, InputStream in) throws Exception;
}
