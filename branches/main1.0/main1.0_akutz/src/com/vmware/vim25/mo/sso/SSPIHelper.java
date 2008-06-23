/*================================================================================
Copyright (c) 2008 VMware, Inc. All Rights Reserved.

Redistribution and use in source and binary forms, with or with modification, 
are permitted provided that the following conditions are met:

* Redistributions of source code must retain the above copyright notice, 
this list of conditions and the following disclaimer.

* Redistributions in binary form must reproduce the above copyright notice, 
this list of conditions and the following disclaimer in the documentation 
and/or other materials provided with the distribution.

* Neither the name of VMware, Inc. nor the names of its contributors may be used
to endorse or promote products derived from this software with specific prior 
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

package com.vmware.vim25.mo.sso;

import com.jinvoke.*;
import java.util.Arrays;

/**
 * Enables Windows passthrough authentication when this library is used on a
 * Windows platform.
 * 
 * @author Schley Andrew Kutz &lt;sakutz@gmail.com&gt;
 *
 */
public class SSPIHelper
{
	public final int ISC_REQ_ALLOCATE_MEMORY = 0x00000100;
	public final int ISC_REQ_CALL_LEVEL = 0x00001000;
	public final int ISC_REQ_CONFIDENTIALITY = 0x00000010;
	public final int ISC_REQ_CONNECTION = 0x00000800;
	public final int ISC_REQ_DATAGRAM = 0x00000400;
	public final int ISC_REQ_DELEGATE = 0x00000001;
	public final int ISC_REQ_EXTENDED_ERROR = 0x00004000;
	public final int ISC_REQ_FRAGMENT_SUPPLIED = 0x00002000;
	public final int ISC_REQ_FRAGMENT_TO_FIT = 0x00200000;
	public final int ISC_REQ_IDENTIFY = 0x00020000;
	public final int ISC_REQ_INTEGRITY = 0x00010000;
	public final int ISC_REQ_MANUAL_CRED_VALIDATION = 0x00080000;
	public final int ISC_REQ_MUTUAL_AUTH = 0x00000002;
	public final int ISC_REQ_NULL_SESSION = 0x00040000;
	public final int ISC_REQ_PROMPT_FOR_CREDS = 0x00000040;
	public final int ISC_REQ_REPLAY_DETECT = 0x00000004;
	public final int ISC_REQ_RESERVED1 = 0x00100000;
	public final int ISC_REQ_SEQUENCE_DETECT = 0x00000008;
	public final int ISC_REQ_STREAM = 0x00008000;
	public final int ISC_REQ_USE_DCE_STYLE = 0x00000200;
	public final int ISC_REQ_USE_SESSION_KEY = 0x00000020;
	public final int ISC_REQ_USE_SUPPLIED_CREDS = 0x00000080;
	
	private final int MAX_TOKEN_SIZE = 12288;
	public final int SEC_E_OK = 0;
	public final int SEC_I_CONTINUE_NEEDED = 0x90312;

	public final int SECPKG_ATTR_SIZES = 0;
	private final int SECPKG_CRED_INBOUND = 1;
	private final int SECPKG_CRED_OUTBOUND = 2;
	private final int SECURITY_NATIVE_DREP = 0x10;

	public final int STANDARD_CONTEXT_ATTRIBUTES =
		ISC_REQ_CONFIDENTIALITY | ISC_REQ_REPLAY_DETECT | ISC_REQ_SEQUENCE_DETECT |
		ISC_REQ_CONNECTION;

	public final int TOKEN_QUERY = 0x00008;
	private String _sAccountName = System.getenv( "USERDOMAIN" ) + "\\" + 
		System.getenv( "USERNAME" );

	private boolean _bGotClientCredentials;
	private boolean _bGotServerContext;
	private boolean _bGotServerCredentials;
	public SECURITY_HANDLE[] _hClientContext = new SECURITY_HANDLE[] { new SECURITY_HANDLE( 0 ) };
	private SECURITY_HANDLE[] _hInboundCred = new SECURITY_HANDLE[] { new SECURITY_HANDLE( 0 ) };
	private SECURITY_HANDLE[] _hOutboundCred = new SECURITY_HANDLE[] { new SECURITY_HANDLE( 0 ) };
	public SECURITY_HANDLE[] _hServerContext =new SECURITY_HANDLE[] { new SECURITY_HANDLE( 0 ) };

	static 
	{
		JInvoke.initialize();
	}
	
	public SSPIHelper()
	{
	}

	public SSPIHelper( String sRemotePrincipal )
	{
		_sAccountName = sRemotePrincipal;
	}
	
	@NativeImport(library="secur32")
	private native int AcquireCredentialsHandle(
		String pszPrincipal, //SEC_CHAR*
		String pszPackage, //SEC_CHAR* //"Kerberos","NTLM","Negotiative"
		int fCredentialUse,
		int PAuthenticationID, //_LUID AuthenticationID,//pvLogonID, //PLUID
		int pAuthData, //PVOID
		int pGetKeyFn, //SEC_GET_KEY_FN
		int pvGetKeyArgument, //PVOID
		SECURITY_HANDLE[] phCredential, //SecHandle //PCtxtHandle ref
		SECURITY_INTEGER[] ptsExpiry ); //PTimeStamp //TimeStamp ref
	
	@NativeImport(library="secur32")
	private native int InitializeSecurityContext(
		SECURITY_HANDLE[] phCredential, //PCredHandle
		SECURITY_HANDLE[] phContext, //PCtxtHandle
		String pszTargetName,
		int fContextReq,
		int Reserved1,
		int TargetDataRep,
		SecBufferDesc pInput, //int pInput, //PSecBufferDesc SecBufferDesc
		int Reserved2,
		SECURITY_HANDLE[] phNewContext, //PCtxtHandle
		SecBufferDesc[] pOutput, //PSecBufferDesc SecBufferDesc
		int[] pfContextAttr, //managed ulong == 64 bits!!!
		SECURITY_INTEGER[] ptsExpiry ); //PTimeStamp
/*
	@NativeImport(library="secur32")
	private native int InitializeSecurityContext(
		SECURITY_HANDLE[] phCredential, //PCredHandle
		SECURITY_HANDLE[] phContext, //PCtxtHandle
		String pszTargetName,
		int fContextReq,
		int Reserved1,
		int TargetDataRep,
		SecBufferDesc SecBufferDesc, //PSecBufferDesc SecBufferDesc
		int Reserved2,
		SECURITY_HANDLE[] phNewContext, //PCtxtHandle
		SecBufferDesc[] pOutput, //PSecBufferDesc SecBufferDesc
		int[] pfContextAttr, //managed ulong == 64 bits!!!
		SECURITY_INTEGER[] ptsExpiry ); //PTimeStamp
*/
	@NativeImport(library="secur32")
	private native int AcceptSecurityContext(
		SECURITY_HANDLE[] phCredential,
		int phContext,
		SecBufferDesc[] pInput,
		int fContextReq,
		int TargetDataRep,
		SECURITY_HANDLE[] phNewContext,
		SecBufferDesc[] pOutput,
		int pfContextAttr[], //managed ulong == 64 bits!!!
		SECURITY_INTEGER[] ptsTimeStamp );

	@NativeImport( library="secur32")
	private native int AcceptSecurityContext(
		SECURITY_HANDLE[] phCredential,
		SECURITY_HANDLE[] phContext,
		SecBufferDesc[] pInput,
		int fContextReq,
		int TargetDataRep,
		SECURITY_HANDLE[] phNewContext,
		SecBufferDesc[] pOutput,
		int[] pfContextAttr, //managed ulong == 64 bits!!!
		SECURITY_INTEGER[] ptsTimeStamp );

	@NativeImport( library="secur32")
	public native int ImpersonateSecurityContext(
		SECURITY_HANDLE[] phContext );

	@NativeImport( library="secur32")
	public native int QueryContextAttributes(
		SECURITY_HANDLE[] phContext,
		int ulAttribute,
		SecPkgContext_Sizes[] pContextAttributes );

	@NativeImport( library="secur32")
	public native int EncryptMessage(
		SECURITY_HANDLE[] phContext,
		int fQOP, //managed ulong == 64 bits!!!
		SecBufferDesc[] pMessage,
		int MessageSeqNo ); //managed ulong == 64 bits!!!

	@NativeImport( library="secur32")
	public native int DecryptMessage(
		SECURITY_HANDLE[] phContext,
		SecBufferDesc[] pMessage,
		int MessageSeqNo,
		int[] pfQOP );

	@NativeImport( library="secur32")
	public native int MakeSignature(
		SECURITY_HANDLE[] phContext, // Context to use
		int fQOP, // Quality of Protection
		SecBufferDesc[] pMessage, // Message to sign
		int MessageSeqNo ); // Message Sequence Num.

	@NativeImport( library="secur32")
	public native int VerifySignature(
		SECURITY_HANDLE[] phContext, // Context to use
		SecBufferDesc[] pMessage, // Message to sign
		int MessageSeqNo, // Message Sequence Num.
		int[] pfQOP ); // Quality of Protection
		
	public byte[] InitializeClient(
		byte[] serverToken,
		boolean[] bContinueProcessing) throws Exception
	{
		byte[] ct;
		bContinueProcessing[0] = true;

		SECURITY_INTEGER[] ClientLifeTime = new SECURITY_INTEGER[] { new SECURITY_INTEGER( 0 ) };

		if ( !_bGotClientCredentials )
		{
			if ( AcquireCredentialsHandle(
			     	_sAccountName, "NTLM", SECPKG_CRED_OUTBOUND,
			     	0, 0, 0, 0,
			     	_hOutboundCred, ClientLifeTime ) != SEC_E_OK )
			{
				throw new Exception( "Couldn't acquire client credentials" );
			}

			System.out.println(ClientLifeTime[0].LowPart + " " +ClientLifeTime[0].HighPart);
			_bGotClientCredentials = true;
		}

		int ss = -1;

		SecBufferDesc[] ClientToken = new SecBufferDesc[] { new SecBufferDesc( MAX_TOKEN_SIZE ) };

		try
		{
			int[] ContextAttributes = new int[] { 0 };

			if ( serverToken == null )
			{
				ss = InitializeSecurityContext(
					_hOutboundCred,
					null,
					_sAccountName, // null string pszTargetName,
					STANDARD_CONTEXT_ATTRIBUTES,
					0, //int Reserved1,
					SECURITY_NATIVE_DREP, //int TargetDataRep
					null, //0, //Always zero first time around...
					0, //int Reserved2,
					_hClientContext, //pHandle CtxtHandle = SecHandle
					ClientToken, //SecBufferDesc pOutput, //PSecBufferDesc
					ContextAttributes, //int pfContextAttr,
					ClientLifeTime ); //IntPtr ptsExpiry ); //PTimeStamp
			}
			else
			{
				SecBufferDesc ServerToken = new SecBufferDesc( serverToken );

				try
				{
					ss = InitializeSecurityContext(
						_hOutboundCred,
						_hClientContext,
						_sAccountName, // null string pszTargetName,
						STANDARD_CONTEXT_ATTRIBUTES,
						0, //int Reserved1,
						SECURITY_NATIVE_DREP, //int TargetDataRep
						ServerToken, //Always zero first time around...
						0, //int Reserved2,
						_hClientContext, //pHandle CtxtHandle = SecHandle
						ClientToken, //SecBufferDesc pOutput, //PSecBufferDesc
						ContextAttributes, //int pfContextAttr,
						ClientLifeTime ); //IntPtr ptsExpiry ); //PTimeStamp
					
				}
				finally
				{
					ServerToken.finalize();
				}
			}

			if ( ss != SEC_E_OK && ss != SEC_I_CONTINUE_NEEDED )
			{
				throw new Exception( "InitializeSecurityContext() failed!!!" );
			}

			ct = ClientToken[ 0 ].GetSecBufferByteArray();
		}
		finally
		{
			ClientToken[ 0 ].finalize();
		}

		bContinueProcessing[0] = ss != SEC_E_OK;
		return ct;
	}

	public byte[] InitializeServer(
		byte[] clientToken, 
		boolean [] bContinueProcessing ) throws Exception
	{
		byte[] st;
		bContinueProcessing[0] = true;
		SECURITY_INTEGER[] NewLifeTime = new SECURITY_INTEGER[] { new SECURITY_INTEGER( 0 ) };

		if ( !_bGotServerCredentials )
		{
			if ( AcquireCredentialsHandle(
			     	_sAccountName, "NTLM", SECPKG_CRED_INBOUND,
			     	0, 0, 0, 0,
			     	_hInboundCred, NewLifeTime ) != SEC_E_OK )
			{
				throw new Exception( "Couldn't acquire server credentials handle!!!" );
			}

			_bGotServerCredentials = true;
		}

		SecBufferDesc[] ServerToken = new SecBufferDesc[] { new SecBufferDesc( MAX_TOKEN_SIZE ) };
		SecBufferDesc[] ClientToken = new SecBufferDesc[] { new SecBufferDesc( clientToken ) };

		try
		{
			int ss = -1;
			int[] uNewContextAttr = new int[] { 0 };

			if ( !_bGotServerContext )
			{
				ss = AcceptSecurityContext(
					_hInboundCred, // [in] handle to the credentials
					0,
					// [in/out] handle of partially formed context.  Always NULL the first time through
					ClientToken, // [in] pointer to the input buffers
					STANDARD_CONTEXT_ATTRIBUTES, // [in] required context attributes
					SECURITY_NATIVE_DREP, // [in] data representation on the target
					_hServerContext, // [in/out] receives the new context handle    
					ServerToken, // [in/out] pointer to the output buffers
					uNewContextAttr, // [out] receives the context attributes        
					NewLifeTime ); // [out] receives the life span of the security context
			}
			else
			{
				ss = AcceptSecurityContext(
					_hInboundCred, // [in] handle to the credentials
					_hServerContext,
					// [in/out] handle of partially formed context.  Always NULL the first time through
					ClientToken, // [in] pointer to the input buffers
					STANDARD_CONTEXT_ATTRIBUTES, // [in] required context attributes
					SECURITY_NATIVE_DREP, // [in] data representation on the target
					_hServerContext, // [in/out] receives the new context handle    
					ServerToken, // [in/out] pointer to the output buffers
					uNewContextAttr, // [out] receives the context attributes        
					NewLifeTime ); // [out] receives the life span of the security context
			}

			if ( ss != SEC_E_OK && ss != SEC_I_CONTINUE_NEEDED )
			{
				throw new Exception( "AcceptSecurityContext() failed!!!" );
			}

			if ( !_bGotServerContext )
			{
				_bGotServerContext = true;
			}

			st = ServerToken[ 0 ].GetSecBufferByteArray();

			bContinueProcessing[0] = ss != SEC_E_OK;
		
		}
		finally
		{
			ClientToken[ 0 ].finalize();
			ServerToken[ 0 ].finalize();
		}
		
		return st;
	}

	
	public byte[] EncryptMessage(
		byte[] message, boolean bUseClientContext)
		throws Exception
	{
		byte[] encryptedBuffer = null;

		SECURITY_HANDLE[] EncryptionContext = _hServerContext;

		if ( bUseClientContext )
		{
			EncryptionContext = _hClientContext;
		}

		SecPkgContext_Sizes[] ContextSizes = new SecPkgContext_Sizes[] { new SecPkgContext_Sizes() };

		if (
			QueryContextAttributes(
				EncryptionContext, SECPKG_ATTR_SIZES, ContextSizes ) != SEC_E_OK )
		{
			throw new Exception( "QueryContextAttribute() failed!!!" );
		}
		MultipleSecBufferHelper[] ThisSecHelper = new MultipleSecBufferHelper[2];
		ThisSecHelper[ 0 ] = new MultipleSecBufferHelper(
			message, SecBufferType.SECBUFFER_DATA );
		ThisSecHelper[ 1 ] =
			new MultipleSecBufferHelper(
				new byte[ContextSizes[ 0 ].cbSecurityTrailer], SecBufferType.SECBUFFER_TOKEN );

		SecBufferDesc[] DescBuffer = new SecBufferDesc[] { new SecBufferDesc( ThisSecHelper ) };

		try
		{
			if ( EncryptMessage( EncryptionContext, 0, DescBuffer, 0 ) !=
			     SEC_E_OK )
			{
				throw new Exception( "EncryptMessage() failed!!!" );
			}

			encryptedBuffer = DescBuffer[ 0 ].GetSecBufferByteArray();
			return encryptedBuffer;
		}
		finally
		{
			DescBuffer[0].finalize();
		}
	}

	public byte[] DecryptMessage(int messageLength, byte[] encryptedBuffer, boolean bUseClientContext) throws Exception
	{
		byte[] decryptedBuffer = null;

		SECURITY_HANDLE[] DecryptionContext = _hServerContext;

		if ( bUseClientContext )
		{
			DecryptionContext = _hClientContext;
		}

		byte[] EncryptedMessage = new byte[messageLength];
		EncryptedMessage = Arrays.copyOf( encryptedBuffer, messageLength );

		int SecurityTrailerLength = encryptedBuffer.length - messageLength;

		byte[] SecurityTrailer = new byte[SecurityTrailerLength];
		System.arraycopy(encryptedBuffer, messageLength, SecurityTrailer, 0, SecurityTrailerLength);
		//SecurityTrailer = java.util.Arrays.copyOfRange( encryptedBuffer, 0, messageLength );
		
		MultipleSecBufferHelper[] ThisSecHelper = new MultipleSecBufferHelper[2];
		ThisSecHelper[ 0 ] = new MultipleSecBufferHelper(EncryptedMessage, SecBufferType.SECBUFFER_DATA );
		ThisSecHelper[ 1 ] = new MultipleSecBufferHelper(SecurityTrailer, SecBufferType.SECBUFFER_TOKEN );
		SecBufferDesc[] DescBuffer = new SecBufferDesc[] { new SecBufferDesc( ThisSecHelper ) };
		try
		{
			int[] EncryptionQuality = new int[] { 0 };

			int result = DecryptMessage(DecryptionContext, DescBuffer, 0, EncryptionQuality);
			
			if (result != SEC_E_OK )
			{
				throw new Exception( "DecryptMessage() failed!!!" );
			}

			decryptedBuffer = new byte[messageLength];
			decryptedBuffer = Arrays.copyOf( DescBuffer[ 0 ].GetSecBufferByteArray(), messageLength );
			//decryptedBuffer = Arrays.copyOf( db.GetSecBufferByteArray(), messageLength );
			
			return decryptedBuffer;
		}
		finally
		{
			DescBuffer[ 0 ].finalize();
		}
	}
	/*
	public void SignMessage(
		byte[] message, boolean bUseClientContext, byte[] signedBuffer,
		SECURITY_HANDLE hServerContext ) throws Exception
	{
		signedBuffer = null;

		SECURITY_HANDLE[] EncryptionContext = _hServerContext;

		if ( bUseClientContext )
		{
			EncryptionContext = _hClientContext;
		}

		SecPkgContext_Sizes[] ContextSizes = new SecPkgContext_Sizes[] { new SecPkgContext_Sizes() };

		if (
			QueryContextAttributes(
				EncryptionContext, SECPKG_ATTR_SIZES, ContextSizes ) != SEC_E_OK )
		{
			throw new Exception( "QueryContextAttribute() failed!!!" );
		}

		MultipleSecBufferHelper[] ThisSecHelper = new MultipleSecBufferHelper[2];
		ThisSecHelper[ 0 ] = new MultipleSecBufferHelper(
			message, SecBufferType.SECBUFFER_DATA );
		ThisSecHelper[ 1 ] =
			new MultipleSecBufferHelper(
				new byte[ContextSizes[ 0 ].cbMaxSignature], SecBufferType.SECBUFFER_TOKEN );

		SecBufferDesc[] DescBuffer = new SecBufferDesc[] { new SecBufferDesc( ThisSecHelper ) };

		try
		{
			if ( MakeSignature( EncryptionContext, 0, DescBuffer, 0 ) !=
			     SEC_E_OK )
			{
				throw new Exception( "MakeSignature() failed!!!" );
			}

			//SSPIHelperTest.SignAndVerify(_hClientContext,hServerContext,DescBuffer);
			int[] EncryptionQuality = new int[] { 0 };
			VerifySignature(
				_hServerContext, DescBuffer, 0, EncryptionQuality );

			signedBuffer = DescBuffer[ 0 ].GetSecBufferByteArray();
		}
		finally
		{
			DescBuffer[ 0 ].finalize();
		}
	}

	public void VerifyMessage(
		int messageLength, byte[] signedBuffer, boolean bUseClientContext,
		byte[] verifiedBuffer ) throws Exception
	{
		verifiedBuffer = null;

		SECURITY_HANDLE[] DecryptionContext = _hServerContext;

		if ( bUseClientContext )
		{
			DecryptionContext = _hClientContext;
		}

		byte[] SignedMessage = new byte[messageLength];
		SignedMessage = Arrays.copyOf( signedBuffer, messageLength );

		int SignatureLength = signedBuffer.length - messageLength;

		byte[] Signature = new byte[SignatureLength];
		Signature = Arrays.copyOf( signedBuffer, messageLength );

		MultipleSecBufferHelper[] ThisSecHelper = new MultipleSecBufferHelper[2];
		ThisSecHelper[ 0 ] = new MultipleSecBufferHelper(
			SignedMessage, SecBufferType.SECBUFFER_DATA );
		ThisSecHelper[ 1 ] = new MultipleSecBufferHelper(
			Signature, SecBufferType.SECBUFFER_TOKEN );
		SecBufferDesc[] DescBuffer = new SecBufferDesc[] { new SecBufferDesc( ThisSecHelper ) };
		try
		{
			int[] EncryptionQuality = new int[] { 0 };

			int Return = VerifySignature(
				DecryptionContext, DescBuffer, 0, EncryptionQuality );

			if ( Return != SEC_E_OK )
			{
				throw new Exception( "VerifySignature() failed!!!" );
			}

			verifiedBuffer = new byte[messageLength];
			verifiedBuffer = Arrays.copyOf( DescBuffer[ 0 ].GetSecBufferByteArray(), messageLength );
		}
		finally
		{
			DescBuffer[ 0 ].finalize();
		}
	}
	*/
}
