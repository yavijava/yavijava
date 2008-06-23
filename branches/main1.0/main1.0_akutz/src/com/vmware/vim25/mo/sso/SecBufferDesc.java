package com.vmware.vim25.mo.sso;

import com.jinvoke.Util;
import com.jinvoke.NativeStruct;

@NativeStruct
public class SecBufferDesc
{
	public int ulVersion;
	public int cBuffers;
	public SecBuffer[] pBuffers;
	
	public SecBufferDesc() {}
	
	public SecBufferDesc( int bufferSize )
	{
		ulVersion = SecBufferType.SECBUFFER_VERSION.getCode();
		cBuffers = 1;
		pBuffers= new SecBuffer[] { new SecBuffer( bufferSize ) };
	}

	public SecBufferDesc( byte[] secBufferBytes )
	{
		ulVersion = SecBufferType.SECBUFFER_VERSION.getCode();
		cBuffers = 1;
		pBuffers= new SecBuffer[] { new SecBuffer( secBufferBytes ) };
	}

	public SecBufferDesc( MultipleSecBufferHelper[] secBufferBytesArray ) 
		throws Exception
	{
		if ( secBufferBytesArray == null || secBufferBytesArray.length == 0 )
		{
			throw new Exception("secBufferBytesArray cannot be null or 0 length" );
		}

		ulVersion = SecBufferType.SECBUFFER_VERSION.getCode();
		cBuffers = secBufferBytesArray.length;

		pBuffers = new SecBuffer[ secBufferBytesArray.length ];
		
		for ( int Index = 0; Index < secBufferBytesArray.length; Index++ )
		{
			pBuffers[ Index ] = new SecBuffer( 
				secBufferBytesArray[ Index ].Buffer,
				secBufferBytesArray[ Index ].BufferType );
		}
	}

	public void finalize()
	{
		for ( int Index = 0; Index < pBuffers.length; Index++ )
		{
			pBuffers[ Index ].finalize();
		}
		
		pBuffers = null;
	}

	public byte[] GetSecBufferByteArray() throws Exception
	{
		byte[] buffer = new byte[ 0 ];

		if ( pBuffers == null )
		{
			throw new Exception( "Already finalized" );
		}


		if (cBuffers == 1)
			return  Util.ptrToByteArray(pBuffers[0].pvBuffer, pBuffers[0].cbBuffer );
		
		for ( int x = 0; x < pBuffers.length; ++x )
		{
			byte[] buff = Util.ptrToByteArray( 
				pBuffers[ x ].pvBuffer,
				pBuffers[ x ].cbBuffer );
			byte[] tbuff = new byte[ buffer.length + buff.length ];
			System.arraycopy(buffer, 0, tbuff, 0,             buffer.length);
			System.arraycopy(buff,   0, tbuff, buffer.length, buff.length ); // changed tbuff to buff
			buffer = tbuff;
		}

		return ( buffer );
	}
}
