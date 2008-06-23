package com.vmware.vim25.mo.sso;

import java.util.Arrays;
import com.jinvoke.NativeStruct;
import com.jinvoke.Util;

@NativeStruct
public class SecBuffer
{
	public int cbBuffer;
	public int BufferType;
	public int pvBuffer;

	// Added this no arg default constructor, so J/Invoke marshaller can create 
	// an instance of this struct.
	public SecBuffer()
	{
		
	}
	
	public SecBuffer( int bufferSize )
	{
		cbBuffer = bufferSize;
		BufferType = SecBufferType.SECBUFFER_TOKEN.getCode();
		pvBuffer = Util.byteArrayToPtr( new byte[ bufferSize ] );
	}

	public SecBuffer( byte[] secBufferBytes )
	{
		cbBuffer = secBufferBytes.length;
		BufferType = SecBufferType.SECBUFFER_TOKEN.getCode();
		pvBuffer = Util.byteArrayToPtr(secBufferBytes);// Arrays.copyOf( secBufferBytes, cbBuffer ) );
	}

	public SecBuffer( byte[] secBufferBytes, SecBufferType bufferType )
	{
		cbBuffer = secBufferBytes.length;
		BufferType = bufferType.getCode();
		pvBuffer = Util.byteArrayToPtr(secBufferBytes);// Arrays.copyOf( secBufferBytes, cbBuffer ) );
	}

	public void finalize()
	{
		if ( pvBuffer != 0 )
		{
			//Util.free( pvBuffer );
			//pvBuffer = 0;
		}
	}
}