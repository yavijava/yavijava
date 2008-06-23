package com.vmware.vim25.mo.sso;

import com.jinvoke.NativeStruct;

@NativeStruct
public class SECURITY_HANDLE
{
	public int LowPart;
	public int HighPart;

	public SECURITY_HANDLE()
	{
	}
	
	public SECURITY_HANDLE( int dummy )
	{
		LowPart = HighPart = 0;
	}
}
