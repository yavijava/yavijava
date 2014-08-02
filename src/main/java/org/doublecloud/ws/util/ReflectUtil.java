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

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

public class ReflectUtil
{
  public static Field[] getAllFields(Class<?> c)
  {
    List<Field> listOfFields = new ArrayList<Field>();
    getAllFields(c, listOfFields);

    Field[] arrayOffields = new Field[listOfFields.size()];
    listOfFields.toArray(arrayOffields);
    return arrayOffields;
  }
  
  private static void getAllFields(Class<?> clazz, List<Field> listOfFields)
  {
    Class<?> superClass = clazz.getSuperclass();
    
    if(superClass!=null)
    {
      getAllFields(superClass, listOfFields);
    }
    
    Field[] fields = clazz.getDeclaredFields(); 
    for(int i=0; i < fields.length; i++)
    {
      listOfFields.add(fields[i]);
    }
  }
  
  public final static void setArrayField(Object obj, List<Object> vimObjList, Field vimArrayField, Class<?> vimArrayType) throws IllegalAccessException
  {
    Object ao = Array.newInstance(vimArrayType, vimObjList.size());
    for(int i=0; i< vimObjList.size(); i++)
    {
      Array.set(ao, i, vimObjList.get(i));
    }
    vimArrayField.set(obj, ao);
    
    vimObjList.clear();
  }
  
  public final static void setObjectField(Object object, Field field, String type, String value) throws IllegalArgumentException, IllegalAccessException 
  {
    if("String".equals(type) || "string".equals(type))
    {
      field.set(object, value);
    }
    else if("int".equals(type))
    {
      field.set(object, Integer.parseInt(value));
    }
    else if("Integer".equals(type))
    {
      field.set(object, new Integer(value));
    }
    else if("short".equals(type))
    {
      field.set(object, Short.parseShort(value));
    }
    else if("Short".equals(type))
    {
      field.set(object, new Short(value));
    }
    else if("byte".equals(type))
    {
      field.set(object, Byte.parseByte(value));
    }
    else if("Byte".equals(type))
    {
      field.set(object, new Byte(value));
    }
    else if("long".equals(type))
    {
      field.set(object, Long.parseLong(value));
    }
    else if("Long".equals(type))
    {
      field.set(object, new Long(value));
    }
    else if("float".equals(type))
    {
      field.set(object, Float.parseFloat(value));
    }
    else if("Float".equals(type))
    {
      field.set(object, new Float(value));
    }
    else if("boolean".equals(type))
    {
      field.set(object, Boolean.parseBoolean(value));
    }
    else if("Boolean".equals(type))
    {
      field.set(object, new Boolean(value));
    }
    else if("Calendar".equals(type) || "dateTime".equals(type))
    {
      Calendar cal = DatatypeConverter.parseTime(value);
      field.set(object, cal);
    }
    else if("double".equals(type))
    {
      field.set(object, Double.parseDouble(value));
    }
    else if("Double".equals(type))
    {
      field.set(object, new Double(value));
    }
    else
    {
      throw new RuntimeException("Unexpected Type at setObjectField: " + field.getType().getCanonicalName() + field.getName());
    }
  }

  public static void setObjectArrayField(Object object, Field field, String type, List<String> values) throws IllegalArgumentException, IllegalAccessException 
  {
    if("String[]".equals(type) || "string[]".equals(type))
    {
      String[] vals = new String[values.size()];
      field.set(object, values.toArray(vals));
    }
    else if("int[]".equals(type))
    {
      field.set(object, toIntArray(values));
    }
    else if("short[]".equals(type))
    {
      field.set(object, toShortArray(values));
    }
    else if("byte[]".equals(type))
    {
      field.set(object, toByteArray(values));
    }
    else if("long[]".equals(type))
    {
      field.set(object, toLongArray(values));
    }
    else if("float[]".equals(type))
    {
      field.set(object, toFloatArray(values));
    }
    else if("boolean[]".equals(type))
    {
      field.set(object, toBooleanArray(values));
    }
    else
    {
      throw new RuntimeException("Unexpected Type at setObjectArrayField: " + field.getType().getCanonicalName() + field.getName());
    }
  }
  
  private static byte[] toByteArray(List<String> values)
  {
    byte[] bs = new byte[values.size()];
    for(int i=0; i< bs.length; i++)
    {
      bs[i] = Byte.parseByte(values.get(i));
    }
    return bs;
  }

  private static long[] toLongArray(List<String> values)
  {
    long[] ls = new long[values.size()];
    for(int i=0; i< ls.length; i++)
    {
      ls[i] = Long.parseLong(values.get(i));
    }
    return ls;
  }

  private static short[] toShortArray(List<String> values)
  { 
    short[] ss = new short[values.size()];
    for(int i=0; i< ss.length; i++)
    {
      ss[i] = Short.parseShort(values.get(i));
    }
    return ss;
  }

  private static float[] toFloatArray(List<String> values)
  { 
    float[] fs = new float[values.size()];
    for(int i=0; i< fs.length; i++)
    {
      fs[i] = Float.parseFloat(values.get(i));
    }
    return fs;
  }
  
  private static double[] toDoubleArray(List<String> values)
  {
    double[] ds = new double[values.size()];
    for(int i=0; i<ds.length; i++)
    {
      ds[i] = Double.parseDouble(values.get(i));
    }
    return ds;
  }

  private static int[] toIntArray(List<String> values)
  { 
    int[] is = new int[values.size()];
    for(int i=0; i<is.length; i++)
    {
      is[i] = Integer.parseInt(values.get(i));
    }
    return is;
  }

  private static boolean[] toBooleanArray(List<String> values)
  { 
    boolean[] bs = new boolean[values.size()];
    for(int i=0; i< bs.length; i++)
    {
      bs[i] = Boolean.parseBoolean(values.get(i));
    }
    return bs;
  }
  
  public static Object parseToObject(String type, List<String> values) 
  {
    if("String".equals(type) || "string".equals(type))
    {
      return values.get(0);
    }
    else if("String[]".equals(type))
    {
      return values;
    }
    else if("int".equals(type))
    {
      return new Integer(values.get(0));
    }
    else if("int[]".equals(type))
    {
      return toIntArray(values);
    }
    else if("short".equals(type))
    {
      return new Short(values.get(0));
    }
    else if("short[]".equals(type))
    {
      return toShortArray(values);
    }
    else if("byte".equals(type))
    {
      return new Byte(values.get(0));
    }
    else if("byte[]".equals(type))
    {
      return toByteArray(values);
    }
    else if("long".equals(type))
    {
      return new Long(values.get(0));
    }
    else if("long[]".equals(type))
    {
      return toLongArray(values);
    }
    else if("float".equals(type))
    {
      return new Float(values.get(0));
    }
    else if("float[]".equals(type))
    {
      return toFloatArray(values);
    }
    else if("boolean".equals(type))
    {
      return new Boolean(values.get(0));
    }
    else if("boolean[]".equals(type))
    {
      return toBooleanArray(values);
    }
    else if("Calendar".equals(type)  || "dateTime".equals(type))
    {
      Calendar cal = DatatypeConverter.parseTime(values.get(0));
      return cal;
    }
    else if("double".equals(type))
    {
      return new Double(values.get(0));
    }
    else if("double[]".equals(type))
    {
      return toDoubleArray(values);
    }
    else
    {
      throw new RuntimeException("Unexpected Type at parseToObject: " + type + values.get(0));
    }
  }
}