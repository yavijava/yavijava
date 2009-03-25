/*================================================================================
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

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.DatatypeConverter;

import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.QName;

import com.sun.xml.internal.bind.DatatypeConverterImpl;
import com.vmware.vim25.ManagedObjectReference;

/** 
 * The XML serialization/de-serialization engine.
 * @author Steve Jin (sjin@vmware.com)
*/

public final class XmlGen
{
  private static String PACKAGE_NAME = "com.vmware.vim25";
  private static Namespace XSI = new Namespace("xsi", "http://www.w3.org/2001/XMLSchema-instance");
  private static QName XSI_TYPE = new QName("type", XSI);
  private static String[] BASIC_TYPES = new String[] {"String", "int", "short", "long", "byte", "boolean", "Calendar"};

  static
  {
      DatatypeConverter.setDatatypeConverter(DatatypeConverterImpl.theInstance);
  }
  
  public static SoapFaultException parseSoapFault(Element root) throws Exception
  {
    SoapFaultException sfe = new SoapFaultException();

    sfe.setFaultCode(root.elementText("faultcode"));
    sfe.setFaultString(root.elementText("faultstring"));
    sfe.setFaultActor(root.elementText("faultactor"));
    
    Element detailE = root.element("detail");
    if(detailE != null)
    {
      List<?> subElems = detailE.elements();
      if(subElems.size()!=0)
      {
        Element faultE = (Element) subElems.get(0);
        String faultTypeName = faultE.attributeValue(XSI_TYPE);
        if(faultTypeName!=null)
        {
          sfe.detail = (Throwable) fromXmlElem(faultTypeName, faultE);
        }
      }
    }

    return sfe;
  }
  
  public static Object fromXML(String type, Element root) throws Exception
  {
    List<Element> subNodes = root.elements();
    
    if(type.equals("ManagedObjectReference"))
    {
    	Element e = subNodes.get(0);
    	return createMOR(e.attributeValue("type"), e.getText());	
    }
    else if(isBasicType(type))
    {
      String[] vals = new String[subNodes.size()];
      for(int i=0; i<vals.length; i++)
      {
        vals[i] = subNodes.get(i).getText();
      }
      return parseValue(type, vals);
    }
    else if(type.endsWith("[]"))
    { // array type
      String singleTypeName = type.substring(0, type.length()-2);
      if(subNodes.size()>0)
      {
    	  Element e = subNodes.get(0);
    	  String xsiType = e.attributeValue(XSI_TYPE);
    	  if(xsiType!= null)
    	  {
    		  singleTypeName = xsiType;
    	  }
      }
      
      Object ao = Array.newInstance(Class.forName(PACKAGE_NAME + "." + singleTypeName), subNodes.size());
      for(int i=0; i<subNodes.size(); i++)
      {
        Object o = fromXmlElem(singleTypeName, subNodes.get(i));
        Array.set(ao, i, o);
      }
      return ao;
    }
    else
    {
      return fromXmlElem(type, subNodes.get(0));
    }
  }
  
  private static boolean isBasicType(String type)
  {
    for(int i=0; i<BASIC_TYPES.length; i++)
    {
      if(type.startsWith(BASIC_TYPES[i]))
        return true;
    }
    return false;
  }
  
  private final static Set<String> PRIMITIVE_DATA_TYPES = new HashSet<String>();
  static
  {
	  PRIMITIVE_DATA_TYPES.add("int");
	  PRIMITIVE_DATA_TYPES.add("boolean");
	  PRIMITIVE_DATA_TYPES.add("short");
	  PRIMITIVE_DATA_TYPES.add("byte");
	  PRIMITIVE_DATA_TYPES.add("long");
  }
  
  private final static Map<String, Class> VimClasses = new HashMap<String, Class>(); 
  /** Handle single VIM Data Object */
  private static Object fromXmlElem(String type, Element node) throws Exception
  {
    Class<?> clazz = null;
  	if(VimClasses.containsKey(type))
  	{
  		clazz = VimClasses.get(type);
  	}
  	else
  	{
  		clazz = Class.forName(PACKAGE_NAME + "." + type);
  		VimClasses.put(type, clazz);
  	}
  	Object obj = clazz.newInstance();
    
    List<Element> subNodes = node.elements();
    
    int sizeOfSubNodes = subNodes.size();
    
    for (int i=0; i<sizeOfSubNodes; i++) 
    {
      Element e = subNodes.get(i);
      String tagName = e.getName();
      
      Field field = null;
      if(PRIMITIVE_DATA_TYPES.contains(tagName))
      {
        field = clazz.getField("_" + tagName);
      }
      else
      {
        field = clazz.getField(tagName);
      }
      
      Class<?> fType = field.getType();
      boolean isFieldArray = fType.isArray();
      Class arrayElemType = null;
      if(isFieldArray)
      {
    	  arrayElemType = fType.getComponentType();
      }
      String arrayTypeName = fType.getSimpleName();
      String xsiType = e.attributeValue(XSI_TYPE);
      if(xsiType!=null && (!xsiType.startsWith("xsd:")))
      {
          fType = Class.forName(PACKAGE_NAME + "." + xsiType);
      }
      
      String fTypeFullName = fType.getCanonicalName();
      String fTypeSimpleName = fType.getSimpleName();
      
//      if(fTypeSimpleName.startsWith("ManagedObjectReference"))
      if(fType == ManagedObjectReference.class)
      {
        if(isFieldArray)
        {
          int sizeOfFieldArray = getNumberOfSameTags(subNodes, sizeOfSubNodes, i, tagName);
          ManagedObjectReference[] mos = new ManagedObjectReference[sizeOfFieldArray];
          for(int j=0; j<sizeOfFieldArray; j++)
          {
            Element elem = (Element) subNodes.get(j+i);
            mos[j] = XmlGen.createMOR(elem.attributeValue("type"), elem.getText());
          }
          field.set(obj, mos);
          i = i + sizeOfFieldArray -1;
        }
        else
        {
          field.set(obj, createMOR(e.attributeValue("type"), e.getText()));
        }
      }
      else if(fType.isEnum())
      {
        String enumStr = e.getText();
        Class enumClass = Class.forName(fTypeFullName);
        Object fo = Enum.valueOf(enumClass, enumStr); 
        field.set(obj, fo);
      }
      else if(isFieldArray==true && arrayElemType.isEnum())
      {
        int sizeOfFieldArray = getNumberOfSameTags(subNodes, sizeOfSubNodes, i, tagName);
        Object ao = Array.newInstance(arrayElemType, sizeOfFieldArray);
        for(int j=0; j<sizeOfFieldArray; j++)
        {
          String enumStr = ((Element) subNodes.get(j+i)).getText();
          Array.set(ao, j, Enum.valueOf(arrayElemType, enumStr));
        }
        field.set(obj, ao);
        i = i + sizeOfFieldArray -1;
      }
      else if(((xsiType!=null) && (!xsiType.startsWith("xsd"))) || fTypeFullName.startsWith(PACKAGE_NAME))
      { 
        if(isFieldArray)
        {
          int sizeOfFieldArray = getNumberOfSameTags(subNodes, sizeOfSubNodes, i, tagName);
          arrayTypeName = arrayTypeName.substring(0, arrayTypeName.length()-2);
          Object ao = Array.newInstance(Class.forName(PACKAGE_NAME + "." + arrayTypeName), sizeOfFieldArray);
          
          for(int j=0; j<sizeOfFieldArray; j++)
          {
            Element elem = (Element) subNodes.get(j+i);
            String elemType = arrayTypeName; 
            if(elem.attributeValue(XSI_TYPE)!=null)
            {
              elemType = elem.attributeValue(XSI_TYPE);
            }
            Object o = fromXmlElem(elemType, elem);
            Array.set(ao, j, o);
          }
          field.set(obj, ao);
          i = i + sizeOfFieldArray -1;
        }
        else
        { // single VIM
          Object o = null;
          if(xsiType!=null)
          {
            o = fromXmlElem(xsiType, e);
          }
          else
          {
            o = fromXmlElem(fType.getSimpleName(), e);
          }
          field.set(obj, o);
        }
      }
      else
      { //basic data type
        if(isFieldArray)
        {
          int sizeOfFieldArray = getNumberOfSameTags(subNodes, sizeOfSubNodes, i, tagName);

          String[] values = new String[sizeOfFieldArray];
          for(int j=0; j < values.length; j++)
          {
            values[j] = ((Element)subNodes.get(j+i)).getText();
          }

          String fTrueType = null;
          if(xsiType!=null)
          {
            fTrueType = xsiType.substring("xsd:".length()) + "[]";
          }
          else
          {
            fTrueType = fTypeSimpleName;
            if(!fTrueType.endsWith("[]"))
            {
              fTrueType = fTrueType + "[]";
            }
          }
          setFieldValue(field, obj, fTrueType, values);
          i = i + sizeOfFieldArray -1;
        }
        else
        {
          if(xsiType!=null && xsiType.startsWith("xsd:"))
          {
            xsiType = xsiType.substring("xsd:".length());
            setFieldValue(field, obj, xsiType, new String[] { e.getText()});
          }
          else
          {
            setFieldValue(field, obj, xsiType, new String[] { e.getText()});
          }
        }
      }
    }
    return obj;
  }

  private final static int getNumberOfSameTags(List<Element> subNodes, int sizeOfSubNodes, int from, String tagName)
  {
		int numOfTags = 1;
		for(int j=from+1; j<sizeOfSubNodes; j++)
		{
		  if(subNodes.get(j).getName().equals(tagName))
		  {
		    numOfTags ++;
		  }
		  else
		  {
		    break;
		  }
		}
		return numOfTags;
  }

  private static ManagedObjectReference createMOR(String type, String value)
  {
    ManagedObjectReference mor = new ManagedObjectReference();
    mor.val = value;
    mor.type = type;
    return mor;
  }
  
  private static Object parseValue(String type, String[] values) 
  {
    if("String".equals(type) || "string".equals(type))
    {
      return values[0];
    }
    else if("String[]".equals(type))
    {
      return values;
    }
    else if("int".equals(type))
    {
      return new Integer(values[0]);
    }
    else if("int[]".equals(type))
    {
      int[] is = new int[values.length];
      for(int i=0; i<is.length; i++)
      {
        is[i] = Integer.parseInt(values[i]);
      }
      return is;
    }
    else if("short".equals(type))
    {
      return new Short(values[0]);
    }
    else if("short[]".equals(type))
    {
      short[] ss = new short[values.length];
      for(int i=0; i< ss.length; i++)
      {
        ss[i] = Short.parseShort(values[i]);
      }
      return ss;
    }
    else if("byte".equals(type))
    {
      return new Byte(values[0]);
    }
    else if("byte[]".equals(type))
    {
      byte[] bs = new byte[values.length];
      for(int i=0; i< bs.length; i++)
      {
        bs[i] = Byte.parseByte(values[i]);
      }
      return bs;
    }
    else if("long".equals(type))
    {
      return new Long(values[0]);
    }
    else if("long[]".equals(type))
    {
      long[] ls = new long[values.length];
      for(int i=0; i< ls.length; i++)
      {
        ls[i] = Long.parseLong(values[i]);
      }
      return ls;
    }
    else if("boolean".equals(type))
    {
      return new Boolean(values[0]);
    }
    else if("boolean[]".equals(type))
    {
      boolean[] bs = new boolean[values.length];
      for(int i=0; i< bs.length; i++)
      {
        bs[i] = Boolean.getBoolean(values[i]);
      }
      return bs;
    }
    else if("Calendar".equals(type))
    {
      Calendar cal = DatatypeConverter.parseTime(values[0]);
      return cal;
    }
    else
    {
      System.err.println("Unexpected Type: " + type);
    }
    return null;
  }
  
  private static void setFieldValue(Field f, Object obj, String type, String[] values) throws IllegalArgumentException, IllegalAccessException 
  {
    String fType = type==null? f.getType().getSimpleName() : type;
    
    if("String".equals(fType) || "string".equals(fType))
    {
      f.set(obj, values[0]);
    }
    else if("String[]".equals(fType) || "string[]".equals(fType))
    {
      f.set(obj, values);
    }
    else if("int".equals(fType))
    {
      f.set(obj, Integer.parseInt(values[0]));
    }
    else if("Integer".equals(fType))
    {
      f.set(obj, new Integer(values[0]));
    }
    else if("int[]".equals(fType))
    {
      int[] is = new int[values.length];
      for(int i=0; i<is.length; i++)
      {
        is[i] = Integer.parseInt(values[i]);
      }
      f.set(obj, is);
    }
    else if("short".equals(fType))
    {
      f.set(obj, Short.parseShort(values[0]));
    }
    else if("Short".equals(fType))
    {
      f.set(obj, new Short(values[0]));
    }
    else if("short[]".equals(fType))
    {
      short[] ss = new short[values.length];
      for(int i=0; i< ss.length; i++)
      {
        ss[i] = Short.parseShort(values[i]);
      }
      f.set(obj, ss);
    }
    else if("byte".equals(fType))
    {
      f.set(obj, Byte.parseByte(values[0]));
    }
    else if("Byte".equals(fType))
    {
      f.set(obj, new Byte(values[0]));
    }
    else if("byte[]".equals(fType))
    {
      byte[] bs = new byte[values.length];
      for(int i=0; i< bs.length; i++)
      {
        bs[i] = Byte.parseByte(values[i]);
      }
      f.set(obj, bs);
    }
    else if("long".equals(fType))
    {
      f.set(obj, Long.parseLong(values[0]));
    }
    else if("Long".equals(fType))
    {
      f.set(obj, new Long(values[0]));
    }
    else if("long[]".equals(fType))
    {
      long[] ls = new long[values.length];
      for(int i=0; i< ls.length; i++)
      {
        ls[i] = Long.parseLong(values[i]);
      }
      f.set(obj, ls);
    }
    else if("boolean".equals(fType))
    {
      f.set(obj, Boolean.parseBoolean(values[0]));
    }
    else if("Boolean".equals(fType))
    {
      f.set(obj, new Boolean(values[0]));
    }
    else if("boolean[]".equals(fType))
    {
      boolean[] bs = new boolean[values.length];
      for(int i=0; i< bs.length; i++)
      {
        bs[i] = Boolean.parseBoolean(values[i]);
      }
      f.set(obj, bs);
    }
    else if("Calendar".equals(fType))
    {
      Calendar cal = DatatypeConverter.parseTime(values[0]);
      f.set(obj, cal);
    }
    else
    {
      System.err.println("Unexpected Type@setField: " + f.getType().getCanonicalName() + type + fType);
      throw new RuntimeException("Unexpected Type@setField: " + f.getType().getCanonicalName() + f.getName());
    }
  }
  
  public static String toXML(String tag, Object obj, String nameSpaceType)
  {
	if(obj==null)
	{
		return "";
	}
    Class<?> c = obj.getClass();
    
    if(c.isArray())
    {
      StringBuffer sb = new StringBuffer();
      Object[] objs = (Object[]) obj;
      for(int i=0; i<objs.length; i++)
      {
        sb.append(toXML(tag, objs[i], nameSpaceType));
      }
      return sb.toString();
    }
    if(c == ManagedObjectReference.class)
    {
      ManagedObjectReference mor = (ManagedObjectReference) obj;
      StringBuffer sb = new StringBuffer("<" + tag + " type=\"" + mor.type + "\">");
      sb.append(mor.val);
      sb.append("</" + tag + ">");
      return sb.toString();
    }
    else if(c.getCanonicalName().startsWith("java.lang"))
    { //basic data type
      return "<" + tag +">" + obj + "</" + tag + ">";
    }
    else if(c.isEnum())
    { // enumeration data type
      return "<" + tag +">" + obj + "</" + tag + ">";
    }
    else if (obj instanceof Calendar) 
    { 
    	return "<" + tag + " xsi:type=\"xsd:dateTime\">" + DatatypeConverter.printDateTime((Calendar)obj) + "</" + tag + ">";
    } 
    else
    {
      StringBuffer sb = new StringBuffer();
      if(nameSpaceType==null)
      {
    	sb.append("<" + tag + ">");
      }
      else
      {
    	sb.append("<" + tag + " xsi:type=\"" + nameSpaceType + "\">");
      }
      
      Field[] fields = getAllFields(c);
      
      for(int i=0; i<fields.length; i++)
      {
        Field f = fields[i];
        String fName = f.getName();
        
        Object value  = null;
        try
        {
          value = f.get(obj);
        } catch (IllegalAccessException iae)
        {
          iae.printStackTrace();
        }
        if(value==null)
        {
          continue;
        }

        Class<?> clazz = f.getType();
        if(clazz.isArray())
        {
          Object[] values = (Object[]) value;
          for(int j=0; values!=null && j<values.length; j++)
          {
            fieldToXML(sb, fName, clazz.getComponentType().getCanonicalName(), values[j]);
          }
        }
        else
        {
          fieldToXML(sb, fName, clazz.getCanonicalName(), value);
        }
      }
      sb.append("</" + tag + ">");
      return sb.toString();
    }
  }
  
  private static void fieldToXML(StringBuffer sb, String fName, String typeName, Object obj)
  {
    if(obj.getClass() == ManagedObjectReference.class)
    {
      ManagedObjectReference mor = (ManagedObjectReference) obj;
      sb.append("<" + fName + " type=\"" + mor.type + "\">");
      sb.append(mor.val);
      sb.append("</" + fName + ">");
      return;
    }
    
    boolean isVimType  = typeName.startsWith(PACKAGE_NAME);
    String realFieldType = obj.getClass().getCanonicalName();

    if (! isVimType) 
    {
      if(realFieldType.equals(typeName))
      {
    	  sb.append("<" + fName + ">");
      }
      else
      {
    	  sb.append("<" + fName + " xsi:type=\"" + getXSIType(obj) + "\">");
      }
      if(typeName.endsWith("Calendar"))
      {
    	  sb.append(DatatypeConverter.printDateTime((Calendar)obj));
      }
      else
      {
    	  sb.append(obj);
      }
      sb.append("</" + fName + ">");
    }
    else 
    {
      if(realFieldType.equals(typeName))
      {
    	sb.append(toXML(fName, obj, null));
      }
      else
      {
    	int lastDot = realFieldType.lastIndexOf(".");
    	String nameSpaceType = realFieldType.substring(lastDot+1);
    	sb.append(toXML(fName, obj, nameSpaceType));
      }
    }
  }
  
  private static String getXSIType(Object obj)
  {
	  Class type = obj.getClass();
	  if(java.lang.Integer.class == type)
	  {
		  return "xsd:int";
	  }
	  else if(java.lang.Long.class == type)
	  {
		  return "xsd:long";
	  }
	  else if(java.lang.Boolean.class == type)
	  {
		  return "xsd:boolean";
	  }
	  else if(java.lang.Short.class == type)
	  {
		  return "xsd:short";
	  }
	  else if(java.lang.Float.class == type)
	  {
		  return "xsd:float";
	  }
	  else if(java.lang.String.class == type)
	  {
		  return "xsd:string";
	  }
	  else if(java.lang.Byte.class == type)
	  {
		  return "xsd:byte";
	  }
	  else if(obj instanceof java.util.Calendar)
	  {
		  return "xsd:dateTime";
	  }
	  else
	  {
		  throw new RuntimeException("Unknow data type during serialization:" + type);
	  }
  }

  private static Field[] getAllFields(Class<?> c)
  {
    Field[] fields = null;
    ArrayList<Field> al = new ArrayList<Field>();
    getAllFields(c, al);
    fields = new Field[al.size()];
    for(int i=0; i<al.size(); i++)
    {
      fields[i] = (Field) al.get(i);
    }
    return fields;
  }
  
  private static void getAllFields(Class<?> clazz, ArrayList<Field> al)
  {
    Class<?> supClazz = clazz.getSuperclass();
    if(supClazz!=null)
    {
      getAllFields(supClazz, al);
    }
    Field[] fs = clazz.getDeclaredFields(); 
    for(int i=0; i<fs.length; i++)
    {
      al.add(fs[i]);
    }
  }
  
}