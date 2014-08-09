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

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.doublecloud.ws.util.ReflectUtil;
import org.doublecloud.ws.util.TypeUtil;

import com.vmware.vim25.ManagedObjectReference;

/** 
 * The XML serialization/de-serialization engine.
 * @author Steve Jin (http://www.doublecloud.org)
*/ 

final class XmlGenDom extends XmlGen
{
  public Object fromXML(String returnType, InputStream is) throws RemoteException
  {
    Element root = null;
    try 
    {
      SAXReader reader = new SAXReader();
      Document doc = reader.read(is);
      root = doc.getRootElement();
    } 
    catch (Exception e1) 
    {
      throw new RemoteException("VI SDK invoke exception:" + e1);
    }
    finally
    {
      if(is!=null) 
        try { is.close(); } catch(IOException ioe) {}
    }
    
    Element body = (Element) root.elements().get(0);
    Element resp = (Element) body.elements().get(0);
    
    if(resp.getName().indexOf("Fault")!=-1)
    {
      SoapFaultException sfe = null;
      try 
      {
        sfe = parseSoapFault(resp);
      } 
      catch (Exception e) 
      {
        throw new RemoteException("Exception in WSClient.invoke:", e);
      }
      if(sfe!=null && sfe.detail!=null)
      {
        throw (RemoteException) sfe.detail;
      }
      else
      {
        throw sfe;
      }
    }
    else
    {
      if(returnType!=null)
      {
        try 
        {
          return fromXML(returnType, resp);
        } 
        catch (Exception e) 
        {
          throw new RemoteException("Exception in WSClient.invoke:", e);
        }
      }
      else
      {
        return null;
      }
    }
  }
  
  private SoapFaultException parseSoapFault(Element root) throws Exception
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
        String faultTypeName = faultE.attributeValue(SoapConsts.XSI_TYPE);
        if(faultTypeName!=null)
        {
          sfe.detail = (Throwable) fromXml(TypeUtil.getVimClass(faultTypeName), faultE);
        }
      }
    }
    return sfe;
  }
  
  @SuppressWarnings("unchecked")
  private Object fromXML(String type, Element root) throws Exception
  {
    List<Element> subNodes = root.elements();
    
    if(subNodes.size()==0)
    {
      return null;
    }
    
    if(type.startsWith("ManagedObjectReference"))
    {
    	if(! type.endsWith("[]"))
    	{
    		Element e = subNodes.get(0);
    		return createMOR(e.attributeValue("type"), e.getText());
    	}
    	else
    	{
        ManagedObjectReference[] mos = new ManagedObjectReference[subNodes.size()];
        for(int i=0; i<subNodes.size(); i++)
        {
          Element elem = (Element) subNodes.get(i);
          mos[i] = createMOR(elem.attributeValue("type"), elem.getText());
        }
        return mos;
    	}
    }
    else if(TypeUtil.isBasicType(type))
    {
      List<String> vals = new ArrayList<String>();
      for(int i=0; i<subNodes.size(); i++)
      {
        vals.add(subNodes.get(i).getText());
      }
      return ReflectUtil.parseToObject(type, vals);
    }
    else if(type.endsWith("[]"))
    { // array type
      String arrayItemTypeName = type.substring(0, type.length()-2);
      Class<?> clazz = TypeUtil.getVimClass(arrayItemTypeName);
      Object ao = Array.newInstance(clazz, subNodes.size());

      for(int i=0; i<subNodes.size(); i++)
      {
     	  Element e = subNodes.get(i);
     	  String xsiType = e.attributeValue(SoapConsts.XSI_TYPE);
        Object o = fromXml(TypeUtil.getVimClass(xsiType==null? arrayItemTypeName : xsiType), subNodes.get(i));
        Array.set(ao, i, o);
      }
      return ao;
    }
    else
    {
      return fromXml(TypeUtil.getVimClass(type), subNodes.get(0));
    }
  }
  
  /** Handle single VIM Data Object except MOR */
  @SuppressWarnings({ "unchecked", "rawtypes" })
  private Object fromXml(Class<?> clazz, Element node) throws Exception
  {
    Object obj = clazz.newInstance();
    
    List<Element> subNodes = node.elements();
    int sizeOfSubNodes = subNodes.size();
    
    for (int i=0; i<sizeOfSubNodes; i++) 
    {
      Element e = subNodes.get(i);
      String tagName = e.getName();
      
      Field field = null;
      if(TypeUtil.isPrimitiveType(tagName))
      {
        field = clazz.getField("_" + tagName);
      }
      else
      {
        field = clazz.getField(tagName);
      }
      
      Class<?> fType = field.getType();
      boolean isFieldArray = fType.isArray();
      //if field is an array, adjust it to the component type
      if(isFieldArray)
      {
    	  fType = fType.getComponentType();
      }

      Class fRealType = fType;
      String xsiType = e.attributeValue(SoapConsts.XSI_TYPE);
      if(xsiType!=null && (!xsiType.startsWith("xsd:")))
      {
        fRealType = TypeUtil.getVimClass(xsiType);
      }
      
      if(fRealType == ManagedObjectReference.class)
      { // MOR
        if(isFieldArray)
        {
          int sizeOfFieldArray = getNumberOfSameTags(subNodes, sizeOfSubNodes, i, tagName);
          ManagedObjectReference[] mos = new ManagedObjectReference[sizeOfFieldArray];
          for(int j=0; j<sizeOfFieldArray; j++)
          {
            Element elem = (Element) subNodes.get(j+i);
            mos[j] = createMOR(elem.attributeValue("type"), elem.getText());
          }
          field.set(obj, mos);
          i = i + sizeOfFieldArray -1;
        }
        else
        {
          field.set(obj, createMOR(e.attributeValue("type"), e.getText()));
        }
      }
      else if(fRealType.isEnum())
      { // Enum type
      	if(!isFieldArray)
      	{
	        Object fo = Enum.valueOf(fRealType, e.getText()); 
	        field.set(obj, fo);
      	}
      	else
      	{
	        int sizeOfFieldArray = getNumberOfSameTags(subNodes, sizeOfSubNodes, i, tagName);
	        Object ao = Array.newInstance(fRealType, sizeOfFieldArray);
	        for(int j=0; j<sizeOfFieldArray; j++)
	        {
	          String enumStr = ((Element) subNodes.get(j+i)).getText();
	          Array.set(ao, j, Enum.valueOf(fRealType, enumStr));
	        }
	        field.set(obj, ao);
	        i = i + sizeOfFieldArray -1;
      	}
      }
      else if (TypeUtil.isBasicType(fRealType))
      { // basic data types
        if(isFieldArray)
        {
          int sizeOfFieldArray = getNumberOfSameTags(subNodes, sizeOfSubNodes, i, tagName);

          List<String> values = new ArrayList<String>();
          for(int j=0; j < sizeOfFieldArray; j++)
          {
            values.add(((Element)subNodes.get(j+i)).getText());
          }

          String fTrueType = null;
          if(xsiType!=null)
          {
            fTrueType = xsiType.substring("xsd:".length()) + "[]";
          }
          else
          {
            fTrueType = fRealType.getSimpleName();
            if(!fTrueType.endsWith("[]"))
            {
              fTrueType = fTrueType + "[]";
            }
          }
          ReflectUtil.setObjectArrayField(obj, field, fTrueType, values);
          i = i + sizeOfFieldArray -1;
        }
        else
        {
          if(xsiType!=null)
          {
            xsiType = xsiType.substring("xsd:".length());
            ReflectUtil.setObjectField(obj, field, xsiType, e.getText());
          }
          else
          {
            ReflectUtil.setObjectField(obj, field, fRealType.getSimpleName(), e.getText());
          }
        }
      }
      else
      { //VIM type
        if(isFieldArray)
        {
          int sizeOfFieldArray = getNumberOfSameTags(subNodes, sizeOfSubNodes, i, tagName);
         // arrayTypeName = arrayTypeName.substring(0, arrayTypeName.length()-2);
          Object ao = Array.newInstance(fType, sizeOfFieldArray);
          String fGenericType = fType.getSimpleName();
          for(int j=0; j<sizeOfFieldArray; j++)
          {
            Element elem = (Element) subNodes.get(j+i);
            String elemXsiType = elem.attributeValue(SoapConsts.XSI_TYPE);
            String elemType = elemXsiType!=null? elemXsiType : fGenericType;
            Object o = fromXml(TypeUtil.getVimClass(elemType), elem);
            Array.set(ao, j, o);
          }
          field.set(obj, ao);
          i = i + sizeOfFieldArray -1;
        }
        else
        { // single VIM
          Object o = fromXml(fRealType, e);
          field.set(obj, o);
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
}