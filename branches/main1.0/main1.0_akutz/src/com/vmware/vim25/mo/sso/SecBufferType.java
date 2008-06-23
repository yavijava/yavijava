package com.vmware.vim25.mo.sso;

public enum SecBufferType
{ 
	SECBUFFER_VERSION (0),
	SECBUFFER_EMPTY   (0),
	SECBUFFER_DATA    (1),
	SECBUFFER_TOKEN   (2);
	
	int code;
	private SecBufferType(int code) 
	{
        this.code = code;
    }
	
    public int getCode() {
        return code;
    }
}
