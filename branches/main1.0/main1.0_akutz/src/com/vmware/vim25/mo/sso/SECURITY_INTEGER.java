package com.vmware.vim25.mo.sso;

import com.jinvoke.NativeStruct;

@NativeStruct
public class SECURITY_INTEGER
{
	public int LowPart;
	public int HighPart;
	
	public SECURITY_INTEGER() {
		
	}

	public SECURITY_INTEGER( int dummy )
	{
		LowPart = 0;
		HighPart = 0;
	}
};