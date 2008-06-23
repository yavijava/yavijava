package com.vmware.vim25.mo.sso;

public class MultipleSecBufferHelper
{
	public byte[] Buffer;
	public SecBufferType BufferType;

	public MultipleSecBufferHelper( byte[] buffer, SecBufferType bufferType ) throws Exception
	{
		if ( buffer == null || buffer.length == 0 )
		{
			throw new Exception( "buffer cannot be null or 0 length" );
		}

		Buffer = buffer;
		BufferType = bufferType;
	}
} ;
