/*================================================================================
Copyright (c) 2008 VMware, Inc. All Rights Reserved.

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

package com.vmware.vim.cf;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Calendar;

/**
 * @author Steve JIN (sjin@vmware.com)
 */

class DeepCopier 
{
    private final static Package JAVA_LANG_PKG = String.class.getPackage();

    /**
     * This is used to clone an data object in VI SDK. The algorithm used here
     * is NOT generic enough to be used in other cases.
     * @param src the source object to be deep copied.
     * @return the cloned copy.
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    
	public static Object deepCopy(Object src) throws InstantiationException, IllegalAccessException
	{
		Class<?> clazz = src.getClass();

		// Just check if the object is mutable.
		// We assume the object that is final is likely immutable. 
		// It's true for String, Integer and other data types.
		if(Modifier.isFinal(clazz.getModifiers()))
		{
          return src; 
		}

		Object dst = clazz.newInstance();
		if(src instanceof Calendar)
		{
			((Calendar)dst).setTimeInMillis(((Calendar)src).getTimeInMillis());
			return dst;
		}
		
		Field[] fields = clazz.getFields();
		for(int i=0; i<fields.length; i++)
		{
			Object fObj = fields[i].get(src);
			if(fObj == null)
			{
				continue;
			}
			Class<?> fRealType = fObj.getClass();
			if((!fRealType.isPrimitive()) 
			  || (!fRealType.isEnum())
			  || fRealType.getPackage() != JAVA_LANG_PKG)
			{
				if(fRealType.isArray())
				{
					Object[] items = (Object[]) fObj;
					fObj = Array.newInstance(fRealType.getComponentType(), items.length);
					for(int j=0; j<items.length; j++)
					{
						Array.set(fObj, j, deepCopy(items[j]));
					}
				}
				else
				{
					fObj = deepCopy(fObj);
				}
			}
			fields[i].set(dst, fObj);
		}
		
		return dst;
	}
}