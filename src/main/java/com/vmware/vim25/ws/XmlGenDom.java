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
import com.vmware.vim25.mo.util.MorUtil;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.doublecloud.ws.util.ReflectUtil;
import org.doublecloud.ws.util.TypeUtil;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.rmi.RemoteException;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The XML serialization/de-serialization engine.
 *
 * @author Steve Jin (http://www.doublecloud.org)
 */

class XmlGenDom extends XmlGen {
    private static Logger log = Logger.getLogger(XmlGenDom.class);

    protected static int getNumberOfSameTags(List<Element> subNodes, int sizeOfSubNodes, int from, String tagName) {
        int numOfTags = 1;
        for (int j = from + 1; j < sizeOfSubNodes; j++) {
            if (subNodes.get(j).getName().equals(tagName)) {
                numOfTags++;
            }
            else {
                break;
            }
        }
        return numOfTags;
    }

    public Object fromXML(String returnType, InputStream is) throws RemoteException {
        log.debug("Parsing XML payload from server. " + returnType);
        Element root = null;
        try {
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);
            log.trace("XML Document: " + doc.asXML());
            root = doc.getRootElement();
        }
        catch (DocumentException e){
            Throwable throwThis = e.getNestedException() != null ? e.getNestedException() : e;
            throw new RemoteException("An error occurred parsing XML with return type: " + returnType, throwThis);
        } catch (Exception e1) {
            throw new RemoteException("VI SDK invoke exception:" + e1);
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                }
                catch (IOException ignore) {
                }
            }
        }

        Element body = (Element) root.elements().get(0);
        Element resp = (Element) body.elements().get(0);

        if (resp.getName().contains("Fault")) {
            SoapFaultException sfe;
            try {
                sfe = parseSoapFault(resp);
            }
            catch (Exception e) {
                throw new RemoteException("Exception in SoapClient.invoke:", e);
            }
            if (sfe != null && sfe.detail != null) {
                throw (RemoteException) sfe.detail;
            }
            else {
                throw sfe;
            }
        }
        else {
            if (returnType != null) {
                try {
                    return fromXML(returnType, resp);
                }
                catch (Exception e) {
                    throw new RemoteException("Exception in SoapClient.invoke:", e);
                }
            }
            else {
                return null;
            }
        }
    }

    protected SoapFaultException parseSoapFault(Element root) throws Exception {
        try {
            SoapFaultException sfe = new SoapFaultException();

            sfe.setFaultCode(root.elementText("faultcode"));
            sfe.setFaultString(root.elementText("faultstring"));
            sfe.setFaultActor(root.elementText("faultactor"));

            Element detailE = root.element("detail");
            if (detailE != null) {
                List<?> subElems = detailE.elements();
                if (subElems.size() != 0) {
                    Element faultE = (Element) subElems.get(0);
                    String faultTypeName = faultE.attributeValue(SoapConsts.XSI_TYPE);
                    if (faultTypeName != null) {
                        sfe.detail = (Throwable) fromXml(TypeUtil.getVimClass(faultTypeName), faultE);
                    }
                }
            }
            sfe.detail = (Throwable) setDetailMessageInException(sfe.detail, root.elementText("faultstring"));
            return sfe;
        }
        catch (RuntimeException e) {
            throw new RuntimeException("Could not map the soap fault from:\n" + getContent(root), e);
        }
    }

    protected static Object setDetailMessageInException(Object obj, String detailMessage) {
        Class current = obj.getClass();
        while(current != null) {
            try{
                Field field = current.getDeclaredField("detailMessage");
                if ((!Modifier.isPublic(field.getModifiers()) || !Modifier.isPublic(field.getDeclaringClass().getModifiers()) ||
                        Modifier.isFinal(field.getModifiers())) && !field.isAccessible()) {
                    field.setAccessible(true);
                }
                field.set(obj, detailMessage);
                return obj;
            } catch (NoSuchFieldException e) {
                current = current.getSuperclass();
            } catch (IllegalAccessException e) {
                log.info("The fault string: \"" + detailMessage + "\", was unable to be set in exception due to: ", e);
                return obj;
            } catch (AccessControlException e) {
                log.info("The fault string: \"" + detailMessage + "\", was unable to be set in exception due to: ", e);
                return obj;
            }
        }
        return obj;
    }

    private static String getContent(Element element) {
        StringBuilder builder = new StringBuilder();
        for (Iterator<Element> i = element.elementIterator(); i.hasNext(); ) {
            Element e = i.next();
            builder.append(e.asXML());
        }
        return builder.toString();
    }

    @SuppressWarnings("unchecked")
    private Object fromXML(String type, Element root) throws Exception {
        List<Element> subNodes = root.elements();

        if (subNodes.size() == 0) {
            return null;
        }

        if (type.startsWith("ManagedObjectReference")) {
            if (!type.endsWith("[]")) {
                Element e = subNodes.get(0);
                return MorUtil.createMOR(e.attributeValue("type"), e.getText());
            }
            else {
                ManagedObjectReference[] mos = new ManagedObjectReference[subNodes.size()];
                for (int i = 0; i < subNodes.size(); i++) {
                    Element elem = subNodes.get(i);
                    mos[i] = MorUtil.createMOR(elem.attributeValue("type"), elem.getText());
                }
                return mos;
            }
        }
        else if (TypeUtil.isBasicType(type)) {
            List<String> vals = new ArrayList<String>();
            for (Element subNode : subNodes) {
                vals.add(subNode.getText());
            }
            return ReflectUtil.parseToObject(type, vals);
        }
        else if (type.endsWith("[]")) { // array type
            String arrayItemTypeName = type.substring(0, type.length() - 2);
            Class<?> clazz = TypeUtil.getVimClass(arrayItemTypeName);
            Object ao = Array.newInstance(clazz, subNodes.size());

            for (int i = 0; i < subNodes.size(); i++) {
                Element e = subNodes.get(i);
                String xsiType = e.attributeValue(SoapConsts.XSI_TYPE);
                Object o = fromXml(TypeUtil.getVimClass(xsiType == null ? arrayItemTypeName : xsiType), subNodes.get(i));
                Array.set(ao, i, o);
            }
            return ao;
        } else {
            Class<?> vimClass = TypeUtil.getVimClass(type);
            if(vimClass != null) {
                return fromXml(vimClass, subNodes.get(0));
            } else {
                log.error("Vim class not found for type: " + type + ", XML Document: " + subNodes.get(0).asXML());
                return null;
            }
        }
    }

    /**
     * Handle single VIM Data Object except MOR
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    private Object fromXml(Class<?> clazz, Element node) throws Exception {
        Object obj = clazz.newInstance();

        List<Element> subNodes = node.elements();
        int sizeOfSubNodes = subNodes.size();

        for (int i = 0; i < sizeOfSubNodes; i++) {
            Element e = subNodes.get(i);
            String tagName = e.getName();

            Field field = null;
            if (TypeUtil.isPrimitiveType(tagName)) {
                field = clazz.getField("_" + tagName);
            }
            else {
                field = clazz.getField(tagName);
            }

            Class<?> fType = field.getType();
            boolean isFieldArray = fType.isArray();
            //if field is an array, adjust it to the component type
            if (isFieldArray) {
                fType = fType.getComponentType();
            }

            Class fRealType = fType;
            String xsiType = e.attributeValue(SoapConsts.XSI_TYPE);
            if (xsiType != null && (!xsiType.startsWith("xsd:"))) {
                fRealType = TypeUtil.getVimClass(xsiType);
            }

            if (fRealType == ManagedObjectReference.class) { // MOR
                if (isFieldArray) {
                    int sizeOfFieldArray = getNumberOfSameTags(subNodes, sizeOfSubNodes, i, tagName);
                    ManagedObjectReference[] mos = new ManagedObjectReference[sizeOfFieldArray];
                    for (int j = 0; j < sizeOfFieldArray; j++) {
                        Element elem = subNodes.get(j + i);
                        mos[j] = MorUtil.createMOR(elem.attributeValue("type"), elem.getText());
                    }
                    field.set(obj, mos);
                    i = i + sizeOfFieldArray - 1;
                }
                else {
                    field.set(obj, MorUtil.createMOR(e.attributeValue("type"), e.getText()));
                }
            }
            else if (fRealType.isEnum()) { // Enum type
                if (!isFieldArray) {
                    Object fo = Enum.valueOf(fRealType, e.getText());
                    field.set(obj, fo);
                }
                else {
                    int sizeOfFieldArray = getNumberOfSameTags(subNodes, sizeOfSubNodes, i, tagName);
                    Object ao = Array.newInstance(fRealType, sizeOfFieldArray);
                    for (int j = 0; j < sizeOfFieldArray; j++) {
                        String enumStr = ((Element) subNodes.get(j + i)).getText();
                        Array.set(ao, j, Enum.valueOf(fRealType, enumStr));
                    }
                    field.set(obj, ao);
                    i = i + sizeOfFieldArray - 1;
                }
            }
            else if (TypeUtil.isBasicType(fRealType)) { // basic data types
                if (isFieldArray) {
                    int sizeOfFieldArray = getNumberOfSameTags(subNodes, sizeOfSubNodes, i, tagName);

                    List<String> values = new ArrayList<String>();
                    for (int j = 0; j < sizeOfFieldArray; j++) {
                        values.add(subNodes.get(j + i).getText());
                    }

                    String fTrueType;
                    if (xsiType != null) {
                        fTrueType = xsiType.substring("xsd:".length()) + "[]";
                    }
                    else {
                        fTrueType = fRealType.getSimpleName();
                        if (!fTrueType.endsWith("[]")) {
                            fTrueType = fTrueType + "[]";
                        }
                    }
                    ReflectUtil.setObjectArrayField(obj, field, fTrueType, values);
                    i = i + sizeOfFieldArray - 1;
                }
                else {
                    if (xsiType != null) {
                        xsiType = xsiType.substring("xsd:".length());
                        ReflectUtil.setObjectField(obj, field, xsiType, e.getText());
                    }
                    else {
                        ReflectUtil.setObjectField(obj, field, fRealType.getSimpleName(), e.getText());
                    }
                }
            }
            else { //VIM type
                if (isFieldArray) {
                    int sizeOfFieldArray = getNumberOfSameTags(subNodes, sizeOfSubNodes, i, tagName);
                    // arrayTypeName = arrayTypeName.substring(0, arrayTypeName.length()-2);
                    Object ao = Array.newInstance(fType, sizeOfFieldArray);
                    String fGenericType = fType.getSimpleName();
                    for (int j = 0; j < sizeOfFieldArray; j++) {
                        Element elem = subNodes.get(j + i);
                        String elemXsiType = elem.attributeValue(SoapConsts.XSI_TYPE);
                        String elemType = elemXsiType != null ? elemXsiType : fGenericType;
                        Object o = fromXml(TypeUtil.getVimClass(elemType), elem);
                        Array.set(ao, j, o);
                    }
                    field.set(obj, ao);
                    i = i + sizeOfFieldArray - 1;
                }
                else { // single VIM
                    Object o = fromXml(fRealType, e);
                    field.set(obj, o);
                }
            }
        }
        return obj;
    }
}
