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

import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Calendar;

import javax.xml.bind.DatatypeConverter;

import org.doublecloud.ws.util.ReflectUtil;
import org.doublecloud.ws.util.TypeUtil;
import org.doublecloud.ws.util.XmlUtil;

import com.vmware.vim25.ManagedObjectReference;

public abstract class XmlGen
{
  public abstract Object fromXML(String returnType, InputStream in) throws Exception;
  
  public static String toXML(String methodName, Argument[] paras, String vimNameSpace)
  {
    StringBuffer sb = new StringBuffer();
    sb.append(SoapConsts.SOAP_HEADER);

    sb.append("<" + methodName + vimNameSpace);
    
    for(int i=0; i<paras.length; i++)
    {
      String key = paras[i].getName();
      String type = paras[i].getType();
      Object obj = paras[i].getValue();
      sb.append(toXML(key, type, obj)); //, null));
    }

    sb.append("</" + methodName + ">");
    sb.append(SoapConsts.SOAP_END);
    return sb.toString();
  }
  
  private static String toXML(String tag, String type, Object obj)
  {
    if(obj==null)
    {
      return "";
    }
    StringBuffer sb = new StringBuffer();
    if(TypeUtil.isBasicType(type))
    {
      toXML(sb, tag, obj.getClass(), obj);
    }
    else
    {
      Class<?> clazz = TypeUtil.getVimClass(type);
      toXML(sb, tag, clazz, obj);
    }
    return sb.toString();
  }

  private static void toXML(StringBuffer sb, String tagName, Class<?> type, Object obj)
  {
    Class<?> clazz = obj.getClass();
    
    if(clazz.isArray())
    {
      if(obj.getClass() == TypeUtil.INT_ARRAY_CLASS)
      {
        int[] objs = (int[]) obj;
        for(int i=0; i<objs.length; i++)
        {
          sb.append("<" + tagName +">");
          sb.append(objs[i]);
          sb.append("</" + tagName + ">");
        }
      }
      else if(obj.getClass()== TypeUtil.BYTE_ARRAY_CLASS)
      {
        byte[] objs = (byte[]) obj;
        for(int i=0; i<objs.length; i++)
        {
          sb.append("<" + tagName +">");
          sb.append(objs[i]);
          sb.append("</" + tagName + ">");
        }
      }
      else if(obj.getClass() == TypeUtil.LONG_ARRAY_CLASS)
      {
        long[] objs = (long[]) obj;
        for(int i=0; i<objs.length; i++)
        {
          sb.append("<" + tagName +">");
          sb.append(objs[i]);
          sb.append("</" + tagName + ">");
        }
      }
      else
      {
        Object[] objs = (Object[]) obj;
        for(int i=0; i<objs.length; i++)
        {
          toXML(sb, tagName, type.getComponentType(), objs[i]);
        }
      }
    }
    
    // from now on, no array type
    else if(clazz == ManagedObjectReference.class)
    { //MOR]
      ManagedObjectReference mor = (ManagedObjectReference) obj;
      if(clazz==type)
      {
        sb.append("<" + tagName + " type=\"" + mor.type + "\">");
      }
      else
      {
        sb.append("<" + tagName + " xsi:type=\"ManagedObjectReference\" type=\"" + mor.type + "\">");
      }
      sb.append(mor.val);
      sb.append("</" + tagName + ">");
    }
    else if(clazz.getCanonicalName().startsWith("java.lang")) //basic data type
    {
      if(clazz!=type)
      {
        sb.append("<" + tagName + " xsi:type=\"" + TypeUtil.getXSIType(obj) + "\">");
      }
      else
      {
        sb.append("<" + tagName +">");
      }
      
      if(clazz == String.class)
      {
        String temp = (String) obj;
        obj = XmlUtil.escapeForXML(temp);
      }
      
      sb.append(obj);
      sb.append("</" + tagName + ">");
    }
    else if(clazz.isEnum()) //enum data type
    {
      sb.append("<" + tagName +">" + obj + "</" + tagName + ">");
    }
    else if (obj instanceof Calendar) 
    {
      sb.append("<" + tagName + " xsi:type=\"xsd:dateTime\">" + DatatypeConverter.printDateTime((Calendar)obj) + "</" + tagName + ">");
    }
    else
    { // VIM type
      if(clazz==type)
      {
        sb.append("<" + tagName + ">");
      }
      else
      {
        String nameSpaceType = clazz.getSimpleName();
        sb.append("<" + tagName + " xsi:type=\"" + nameSpaceType + "\">");
      }
      
      Field[] fields = ReflectUtil.getAllFields(clazz);
      
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
  
        Class<?> fType = f.getType();
        toXML(sb, fName, fType, value);
      }
      sb.append("</" + tagName + ">");
    }
  }
  
  public static ManagedObjectReference createMOR(String type, String value)
  {
    ManagedObjectReference mor = new ManagedObjectReference();
    mor.val = value;
    mor.type = type;
    return mor;
  }
}
